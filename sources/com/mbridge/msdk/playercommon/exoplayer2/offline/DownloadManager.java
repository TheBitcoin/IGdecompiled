package com.mbridge.msdk.playercommon.exoplayer2.offline;

import android.os.ConditionVariable;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;
import com.mbridge.msdk.playercommon.exoplayer2.offline.DownloadAction;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSource;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.cache.Cache;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

public final class DownloadManager {
    private static final boolean DEBUG = false;
    public static final int DEFAULT_MAX_SIMULTANEOUS_DOWNLOADS = 1;
    public static final int DEFAULT_MIN_RETRY_COUNT = 5;
    private static final String TAG = "DownloadManager";
    /* access modifiers changed from: private */
    public final ActionFile actionFile;
    private final ArrayList<Task> activeDownloadTasks;
    /* access modifiers changed from: private */
    public final DownloadAction.Deserializer[] deserializers;
    /* access modifiers changed from: private */
    public final DownloaderConstructorHelper downloaderConstructorHelper;
    private boolean downloadsStopped;
    private final Handler fileIOHandler;
    private final HandlerThread fileIOThread;
    /* access modifiers changed from: private */
    public final Handler handler;
    /* access modifiers changed from: private */
    public boolean initialized;
    /* access modifiers changed from: private */
    public final CopyOnWriteArraySet<Listener> listeners;
    private final int maxActiveDownloadTasks;
    private final int minRetryCount;
    private int nextTaskId;
    /* access modifiers changed from: private */
    public boolean released;
    /* access modifiers changed from: private */
    public final ArrayList<Task> tasks;

    public interface Listener {
        void onIdle(DownloadManager downloadManager);

        void onInitialized(DownloadManager downloadManager);

        void onTaskStateChanged(DownloadManager downloadManager, TaskState taskState);
    }

    private static final class Task implements Runnable {
        public static final int STATE_QUEUED_CANCELING = 5;
        public static final int STATE_STARTED_CANCELING = 6;
        public static final int STATE_STARTED_STOPPING = 7;
        /* access modifiers changed from: private */
        public final DownloadAction action;
        /* access modifiers changed from: private */
        public volatile int currentState;
        private final DownloadManager downloadManager;
        private volatile Downloader downloader;
        private Throwable error;
        /* access modifiers changed from: private */
        public final int id;
        private final int minRetryCount;
        private Thread thread;

        @Retention(RetentionPolicy.SOURCE)
        public @interface InternalState {
        }

        /* access modifiers changed from: private */
        public boolean canStart() {
            if (this.currentState == 0) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: private */
        public void cancel() {
            if (changeStateAndNotify(0, 5)) {
                this.downloadManager.handler.post(new Runnable() {
                    public void run() {
                        boolean unused = Task.this.changeStateAndNotify(5, 3);
                    }
                });
            } else if (changeStateAndNotify(1, 6)) {
                cancelDownload();
            }
        }

        private void cancelDownload() {
            if (this.downloader != null) {
                this.downloader.cancel();
            }
            this.thread.interrupt();
        }

        /* access modifiers changed from: private */
        public boolean changeStateAndNotify(int i4, int i5) {
            return changeStateAndNotify(i4, i5, (Throwable) null);
        }

        private int getExternalState() {
            int i4 = this.currentState;
            if (i4 == 5) {
                return 0;
            }
            if (i4 == 6 || i4 == 7) {
                return 1;
            }
            return this.currentState;
        }

        private int getRetryDelayMillis(int i4) {
            return Math.min((i4 - 1) * 1000, DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_AFTER_REBUFFER_MS);
        }

        private String getStateString() {
            int i4 = this.currentState;
            if (i4 == 5 || i4 == 6) {
                return "CANCELING";
            }
            if (i4 != 7) {
                return TaskState.getStateString(this.currentState);
            }
            return "STOPPING";
        }

        /* access modifiers changed from: private */
        public void start() {
            if (changeStateAndNotify(0, 1)) {
                Thread thread2 = new Thread(this);
                this.thread = thread2;
                thread2.start();
            }
        }

        /* access modifiers changed from: private */
        public void stop() {
            if (changeStateAndNotify(1, 7)) {
                DownloadManager.logd("Stopping", this);
                this.thread.interrupt();
            }
        }

        public final float getDownloadPercentage() {
            if (this.downloader != null) {
                return this.downloader.getDownloadPercentage();
            }
            return -1.0f;
        }

        public final TaskState getDownloadState() {
            return new TaskState(this.id, this.action, getExternalState(), getDownloadPercentage(), getDownloadedBytes(), this.error);
        }

        public final long getDownloadedBytes() {
            if (this.downloader != null) {
                return this.downloader.getDownloadedBytes();
            }
            return 0;
        }

        public final boolean isActive() {
            if (this.currentState == 5 || this.currentState == 1 || this.currentState == 7 || this.currentState == 6) {
                return true;
            }
            return false;
        }

        public final boolean isFinished() {
            if (this.currentState == 4 || this.currentState == 2 || this.currentState == 3) {
                return true;
            }
            return false;
        }

        public final void run() {
            long j4;
            int i4;
            DownloadManager.logd("Task is started", this);
            try {
                this.downloader = this.action.createDownloader(this.downloadManager.downloaderConstructorHelper);
                if (this.action.isRemoveAction) {
                    this.downloader.remove();
                } else {
                    j4 = -1;
                    i4 = 0;
                    while (!Thread.interrupted()) {
                        this.downloader.download();
                    }
                }
                th = null;
            } catch (IOException e5) {
                long downloadedBytes = this.downloader.getDownloadedBytes();
                if (downloadedBytes != j4) {
                    DownloadManager.logd("Reset error count. downloadedBytes = " + downloadedBytes, this);
                    j4 = downloadedBytes;
                    i4 = 0;
                }
                if (this.currentState != 1 || (i4 = i4 + 1) > this.minRetryCount) {
                    throw e5;
                }
                DownloadManager.logd("Download error. Retry " + i4, this);
                Thread.sleep((long) getRetryDelayMillis(i4));
            } catch (Throwable th) {
                th = th;
            }
            this.downloadManager.handler.post(new Runnable() {
                public void run() {
                    int i4;
                    Task task = Task.this;
                    Throwable th = th;
                    if (th != null) {
                        i4 = 4;
                    } else {
                        i4 = 2;
                    }
                    if (!task.changeStateAndNotify(1, i4, th) && !Task.this.changeStateAndNotify(6, 3) && !Task.this.changeStateAndNotify(7, 0)) {
                        throw new IllegalStateException();
                    }
                }
            });
        }

        public final String toString() {
            return super.toString();
        }

        private Task(int i4, DownloadManager downloadManager2, DownloadAction downloadAction, int i5) {
            this.id = i4;
            this.downloadManager = downloadManager2;
            this.action = downloadAction;
            this.currentState = 0;
            this.minRetryCount = i5;
        }

        /* access modifiers changed from: private */
        public boolean changeStateAndNotify(int i4, int i5, Throwable th) {
            if (this.currentState != i4) {
                return false;
            }
            this.currentState = i5;
            this.error = th;
            if (this.currentState != getExternalState()) {
                return true;
            }
            this.downloadManager.onTaskStateChange(this);
            return true;
        }

        private static String toString(byte[] bArr) {
            if (bArr.length > 100) {
                return "<data is too long>";
            }
            return '\'' + Util.fromUtf8Bytes(bArr) + '\'';
        }
    }

    public static final class TaskState {
        public static final int STATE_CANCELED = 3;
        public static final int STATE_COMPLETED = 2;
        public static final int STATE_FAILED = 4;
        public static final int STATE_QUEUED = 0;
        public static final int STATE_STARTED = 1;
        public final DownloadAction action;
        public final float downloadPercentage;
        public final long downloadedBytes;
        public final Throwable error;
        public final int state;
        public final int taskId;

        @Retention(RetentionPolicy.SOURCE)
        public @interface State {
        }

        public static String getStateString(int i4) {
            if (i4 == 0) {
                return "QUEUED";
            }
            if (i4 == 1) {
                return "STARTED";
            }
            if (i4 == 2) {
                return "COMPLETED";
            }
            if (i4 == 3) {
                return "CANCELED";
            }
            if (i4 == 4) {
                return "FAILED";
            }
            throw new IllegalStateException();
        }

        private TaskState(int i4, DownloadAction downloadAction, int i5, float f4, long j4, Throwable th) {
            this.taskId = i4;
            this.action = downloadAction;
            this.state = i5;
            this.downloadPercentage = f4;
            this.downloadedBytes = j4;
            this.error = th;
        }
    }

    public DownloadManager(Cache cache, DataSource.Factory factory, File file, DownloadAction.Deserializer... deserializerArr) {
        this(new DownloaderConstructorHelper(cache, factory), file, deserializerArr);
    }

    /* access modifiers changed from: private */
    public Task addTaskForAction(DownloadAction downloadAction) {
        int i4 = this.nextTaskId;
        this.nextTaskId = i4 + 1;
        Task task = new Task(i4, this, downloadAction, this.minRetryCount);
        this.tasks.add(task);
        logd("Task is added", task);
        return task;
    }

    private void loadActions() {
        this.fileIOHandler.post(new Runnable() {
            public void run() {
                final DownloadAction[] downloadActionArr;
                try {
                    downloadActionArr = DownloadManager.this.actionFile.load(DownloadManager.this.deserializers);
                    DownloadManager.logd("Action file is loaded.");
                } catch (Throwable th) {
                    Log.e(DownloadManager.TAG, "Action file loading failed.", th);
                    downloadActionArr = new DownloadAction[0];
                }
                DownloadManager.this.handler.post(new Runnable() {
                    public void run() {
                        if (!DownloadManager.this.released) {
                            ArrayList arrayList = new ArrayList(DownloadManager.this.tasks);
                            DownloadManager.this.tasks.clear();
                            for (DownloadAction access$1300 : downloadActionArr) {
                                Task unused = DownloadManager.this.addTaskForAction(access$1300);
                            }
                            DownloadManager.logd("Tasks are created.");
                            boolean unused2 = DownloadManager.this.initialized = true;
                            Iterator it = DownloadManager.this.listeners.iterator();
                            while (it.hasNext()) {
                                ((Listener) it.next()).onInitialized(DownloadManager.this);
                            }
                            if (!arrayList.isEmpty()) {
                                DownloadManager.this.tasks.addAll(arrayList);
                                DownloadManager.this.saveActions();
                            }
                            DownloadManager.this.maybeStartTasks();
                            for (int i4 = 0; i4 < DownloadManager.this.tasks.size(); i4++) {
                                Task task = (Task) DownloadManager.this.tasks.get(i4);
                                if (task.currentState == 0) {
                                    DownloadManager.this.notifyListenersTaskStateChange(task);
                                }
                            }
                        }
                    }
                });
            }
        });
    }

    /* access modifiers changed from: private */
    public static void logd(String str) {
    }

    private void maybeNotifyListenersIdle() {
        if (isIdle()) {
            logd("Notify idle state");
            Iterator<Listener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onIdle(this);
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0036, code lost:
        r5 = com.mbridge.msdk.playercommon.exoplayer2.offline.DownloadManager.Task.access$300(r4);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void maybeStartTasks() {
        /*
            r11 = this;
            boolean r0 = r11.initialized
            if (r0 == 0) goto L_0x009f
            boolean r0 = r11.released
            if (r0 == 0) goto L_0x000a
            goto L_0x009f
        L_0x000a:
            boolean r0 = r11.downloadsStopped
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x001d
            java.util.ArrayList<com.mbridge.msdk.playercommon.exoplayer2.offline.DownloadManager$Task> r0 = r11.activeDownloadTasks
            int r0 = r0.size()
            int r3 = r11.maxActiveDownloadTasks
            if (r0 != r3) goto L_0x001b
            goto L_0x001d
        L_0x001b:
            r0 = 0
            goto L_0x001e
        L_0x001d:
            r0 = 1
        L_0x001e:
            r3 = 0
        L_0x001f:
            java.util.ArrayList<com.mbridge.msdk.playercommon.exoplayer2.offline.DownloadManager$Task> r4 = r11.tasks
            int r4 = r4.size()
            if (r3 >= r4) goto L_0x009f
            java.util.ArrayList<com.mbridge.msdk.playercommon.exoplayer2.offline.DownloadManager$Task> r4 = r11.tasks
            java.lang.Object r4 = r4.get(r3)
            com.mbridge.msdk.playercommon.exoplayer2.offline.DownloadManager$Task r4 = (com.mbridge.msdk.playercommon.exoplayer2.offline.DownloadManager.Task) r4
            boolean r5 = r4.canStart()
            if (r5 != 0) goto L_0x0036
            goto L_0x009c
        L_0x0036:
            com.mbridge.msdk.playercommon.exoplayer2.offline.DownloadAction r5 = r4.action
            boolean r6 = r5.isRemoveAction
            if (r6 != 0) goto L_0x0041
            if (r0 == 0) goto L_0x0041
            goto L_0x009c
        L_0x0041:
            r7 = 0
            r8 = 1
        L_0x0043:
            if (r7 >= r3) goto L_0x0083
            java.util.ArrayList<com.mbridge.msdk.playercommon.exoplayer2.offline.DownloadManager$Task> r9 = r11.tasks
            java.lang.Object r9 = r9.get(r7)
            com.mbridge.msdk.playercommon.exoplayer2.offline.DownloadManager$Task r9 = (com.mbridge.msdk.playercommon.exoplayer2.offline.DownloadManager.Task) r9
            com.mbridge.msdk.playercommon.exoplayer2.offline.DownloadAction r10 = r9.action
            boolean r10 = r10.isSameMedia(r5)
            if (r10 == 0) goto L_0x0080
            if (r6 == 0) goto L_0x0075
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r4)
            java.lang.String r10 = " clashes with "
            r8.append(r10)
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            logd(r8)
            r9.cancel()
            r8 = 0
            goto L_0x0080
        L_0x0075:
            com.mbridge.msdk.playercommon.exoplayer2.offline.DownloadAction r9 = r9.action
            boolean r9 = r9.isRemoveAction
            if (r9 == 0) goto L_0x0080
            r0 = 1
            r8 = 0
            goto L_0x0083
        L_0x0080:
            int r7 = r7 + 1
            goto L_0x0043
        L_0x0083:
            if (r8 == 0) goto L_0x009c
            r4.start()
            if (r6 != 0) goto L_0x009c
            java.util.ArrayList<com.mbridge.msdk.playercommon.exoplayer2.offline.DownloadManager$Task> r0 = r11.activeDownloadTasks
            r0.add(r4)
            java.util.ArrayList<com.mbridge.msdk.playercommon.exoplayer2.offline.DownloadManager$Task> r0 = r11.activeDownloadTasks
            int r0 = r0.size()
            int r4 = r11.maxActiveDownloadTasks
            if (r0 != r4) goto L_0x009b
            r0 = 1
            goto L_0x009c
        L_0x009b:
            r0 = 0
        L_0x009c:
            int r3 = r3 + 1
            goto L_0x001f
        L_0x009f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.offline.DownloadManager.maybeStartTasks():void");
    }

    /* access modifiers changed from: private */
    public void notifyListenersTaskStateChange(Task task) {
        logd("Task state is changed", task);
        TaskState downloadState = task.getDownloadState();
        Iterator<Listener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onTaskStateChanged(this, downloadState);
        }
    }

    /* access modifiers changed from: private */
    public void onTaskStateChange(Task task) {
        if (!this.released) {
            boolean isActive = task.isActive();
            if (!isActive) {
                this.activeDownloadTasks.remove(task);
            }
            notifyListenersTaskStateChange(task);
            if (task.isFinished()) {
                this.tasks.remove(task);
                saveActions();
            }
            if (!isActive) {
                maybeStartTasks();
                maybeNotifyListenersIdle();
            }
        }
    }

    /* access modifiers changed from: private */
    public void saveActions() {
        if (!this.released) {
            final DownloadAction[] downloadActionArr = new DownloadAction[this.tasks.size()];
            for (int i4 = 0; i4 < this.tasks.size(); i4++) {
                downloadActionArr[i4] = this.tasks.get(i4).action;
            }
            this.fileIOHandler.post(new Runnable() {
                public void run() {
                    try {
                        DownloadManager.this.actionFile.store(downloadActionArr);
                        DownloadManager.logd("Actions persisted.");
                    } catch (IOException e5) {
                        Log.e(DownloadManager.TAG, "Persisting actions failed.", e5);
                    }
                }
            });
        }
    }

    public final void addListener(Listener listener) {
        this.listeners.add(listener);
    }

    public final TaskState[] getAllTaskStates() {
        Assertions.checkState(!this.released);
        int size = this.tasks.size();
        TaskState[] taskStateArr = new TaskState[size];
        for (int i4 = 0; i4 < size; i4++) {
            taskStateArr[i4] = this.tasks.get(i4).getDownloadState();
        }
        return taskStateArr;
    }

    public final int getDownloadCount() {
        int i4 = 0;
        for (int i5 = 0; i5 < this.tasks.size(); i5++) {
            if (!this.tasks.get(i5).action.isRemoveAction) {
                i4++;
            }
        }
        return i4;
    }

    public final int getTaskCount() {
        Assertions.checkState(!this.released);
        return this.tasks.size();
    }

    @Nullable
    public final TaskState getTaskState(int i4) {
        Assertions.checkState(!this.released);
        for (int i5 = 0; i5 < this.tasks.size(); i5++) {
            Task task = this.tasks.get(i5);
            if (task.id == i4) {
                return task.getDownloadState();
            }
        }
        return null;
    }

    public final int handleAction(byte[] bArr) throws IOException {
        Assertions.checkState(!this.released);
        return handleAction(DownloadAction.deserializeFromStream(this.deserializers, new ByteArrayInputStream(bArr)));
    }

    public final boolean isIdle() {
        Assertions.checkState(!this.released);
        if (!this.initialized) {
            return false;
        }
        for (int i4 = 0; i4 < this.tasks.size(); i4++) {
            if (this.tasks.get(i4).isActive()) {
                return false;
            }
        }
        return true;
    }

    public final boolean isInitialized() {
        Assertions.checkState(!this.released);
        return this.initialized;
    }

    public final void release() {
        if (!this.released) {
            this.released = true;
            for (int i4 = 0; i4 < this.tasks.size(); i4++) {
                this.tasks.get(i4).stop();
            }
            final ConditionVariable conditionVariable = new ConditionVariable();
            this.fileIOHandler.post(new Runnable() {
                public void run() {
                    conditionVariable.open();
                }
            });
            conditionVariable.block();
            this.fileIOThread.quit();
            logd("Released");
        }
    }

    public final void removeListener(Listener listener) {
        this.listeners.remove(listener);
    }

    public final void startDownloads() {
        Assertions.checkState(!this.released);
        if (this.downloadsStopped) {
            this.downloadsStopped = false;
            maybeStartTasks();
            logd("Downloads are started");
        }
    }

    public final void stopDownloads() {
        Assertions.checkState(!this.released);
        if (!this.downloadsStopped) {
            this.downloadsStopped = true;
            for (int i4 = 0; i4 < this.activeDownloadTasks.size(); i4++) {
                this.activeDownloadTasks.get(i4).stop();
            }
            logd("Downloads are stopping");
        }
    }

    public DownloadManager(DownloaderConstructorHelper downloaderConstructorHelper2, File file, DownloadAction.Deserializer... deserializerArr) {
        this(downloaderConstructorHelper2, 1, 5, file, deserializerArr);
    }

    /* access modifiers changed from: private */
    public static void logd(String str, Task task) {
        logd(str + ": " + task);
    }

    public DownloadManager(DownloaderConstructorHelper downloaderConstructorHelper2, int i4, int i5, File file, DownloadAction.Deserializer... deserializerArr) {
        Assertions.checkArgument(deserializerArr.length > 0, "At least one Deserializer is required.");
        this.downloaderConstructorHelper = downloaderConstructorHelper2;
        this.maxActiveDownloadTasks = i4;
        this.minRetryCount = i5;
        this.actionFile = new ActionFile(file);
        this.deserializers = deserializerArr;
        this.downloadsStopped = true;
        this.tasks = new ArrayList<>();
        this.activeDownloadTasks = new ArrayList<>();
        Looper myLooper = Looper.myLooper();
        this.handler = new Handler(myLooper == null ? Looper.getMainLooper() : myLooper);
        HandlerThread handlerThread = new HandlerThread("DownloadManager file i/o");
        this.fileIOThread = handlerThread;
        handlerThread.start();
        this.fileIOHandler = new Handler(handlerThread.getLooper());
        this.listeners = new CopyOnWriteArraySet<>();
        loadActions();
        logd("Created");
    }

    public final int handleAction(DownloadAction downloadAction) {
        Assertions.checkState(!this.released);
        Task addTaskForAction = addTaskForAction(downloadAction);
        if (this.initialized) {
            saveActions();
            maybeStartTasks();
            if (addTaskForAction.currentState == 0) {
                notifyListenersTaskStateChange(addTaskForAction);
            }
        }
        return addTaskForAction.id;
    }
}
