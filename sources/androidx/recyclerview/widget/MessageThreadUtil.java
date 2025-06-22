package androidx.recyclerview.widget;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.recyclerview.widget.ThreadUtil;
import androidx.recyclerview.widget.TileList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

class MessageThreadUtil<T> implements ThreadUtil<T> {

    static class MessageQueue {
        private final Object mLock = new Object();
        private SyncQueueItem mRoot;

        MessageQueue() {
        }

        /* access modifiers changed from: package-private */
        public SyncQueueItem next() {
            synchronized (this.mLock) {
                try {
                    SyncQueueItem syncQueueItem = this.mRoot;
                    if (syncQueueItem == null) {
                        return null;
                    }
                    this.mRoot = syncQueueItem.next;
                    return syncQueueItem;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:11:0x0017 A[Catch:{ all -> 0x0013 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void removeMessages(int r6) {
            /*
                r5 = this;
                java.lang.Object r0 = r5.mLock
                monitor-enter(r0)
            L_0x0003:
                androidx.recyclerview.widget.MessageThreadUtil$SyncQueueItem r1 = r5.mRoot     // Catch:{ all -> 0x0013 }
                if (r1 == 0) goto L_0x0015
                int r2 = r1.what     // Catch:{ all -> 0x0013 }
                if (r2 != r6) goto L_0x0015
                androidx.recyclerview.widget.MessageThreadUtil$SyncQueueItem r2 = r1.next     // Catch:{ all -> 0x0013 }
                r5.mRoot = r2     // Catch:{ all -> 0x0013 }
                r1.recycle()     // Catch:{ all -> 0x0013 }
                goto L_0x0003
            L_0x0013:
                r6 = move-exception
                goto L_0x002c
            L_0x0015:
                if (r1 == 0) goto L_0x002a
                androidx.recyclerview.widget.MessageThreadUtil$SyncQueueItem r2 = r1.next     // Catch:{ all -> 0x0013 }
            L_0x0019:
                if (r2 == 0) goto L_0x002a
                androidx.recyclerview.widget.MessageThreadUtil$SyncQueueItem r3 = r2.next     // Catch:{ all -> 0x0013 }
                int r4 = r2.what     // Catch:{ all -> 0x0013 }
                if (r4 != r6) goto L_0x0027
                r1.next = r3     // Catch:{ all -> 0x0013 }
                r2.recycle()     // Catch:{ all -> 0x0013 }
                goto L_0x0028
            L_0x0027:
                r1 = r2
            L_0x0028:
                r2 = r3
                goto L_0x0019
            L_0x002a:
                monitor-exit(r0)     // Catch:{ all -> 0x0013 }
                return
            L_0x002c:
                monitor-exit(r0)     // Catch:{ all -> 0x0013 }
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.MessageThreadUtil.MessageQueue.removeMessages(int):void");
        }

        /* access modifiers changed from: package-private */
        public void sendMessage(SyncQueueItem syncQueueItem) {
            synchronized (this.mLock) {
                try {
                    SyncQueueItem syncQueueItem2 = this.mRoot;
                    if (syncQueueItem2 == null) {
                        this.mRoot = syncQueueItem;
                        return;
                    }
                    while (true) {
                        SyncQueueItem syncQueueItem3 = syncQueueItem2.next;
                        if (syncQueueItem3 != null) {
                            syncQueueItem2 = syncQueueItem3;
                        } else {
                            syncQueueItem2.next = syncQueueItem;
                            return;
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void sendMessageAtFrontOfQueue(SyncQueueItem syncQueueItem) {
            synchronized (this.mLock) {
                syncQueueItem.next = this.mRoot;
                this.mRoot = syncQueueItem;
            }
        }
    }

    MessageThreadUtil() {
    }

    public ThreadUtil.BackgroundCallback<T> getBackgroundProxy(final ThreadUtil.BackgroundCallback<T> backgroundCallback) {
        return new ThreadUtil.BackgroundCallback<T>() {
            static final int LOAD_TILE = 3;
            static final int RECYCLE_TILE = 4;
            static final int REFRESH = 1;
            static final int UPDATE_RANGE = 2;
            private Runnable mBackgroundRunnable = new Runnable() {
                public void run() {
                    while (true) {
                        SyncQueueItem next = AnonymousClass2.this.mQueue.next();
                        if (next == null) {
                            AnonymousClass2.this.mBackgroundRunning.set(false);
                            return;
                        }
                        int i4 = next.what;
                        if (i4 == 1) {
                            AnonymousClass2.this.mQueue.removeMessages(1);
                            backgroundCallback.refresh(next.arg1);
                        } else if (i4 == 2) {
                            AnonymousClass2.this.mQueue.removeMessages(2);
                            AnonymousClass2.this.mQueue.removeMessages(3);
                            backgroundCallback.updateRange(next.arg1, next.arg2, next.arg3, next.arg4, next.arg5);
                        } else if (i4 == 3) {
                            backgroundCallback.loadTile(next.arg1, next.arg2);
                        } else if (i4 != 4) {
                            Log.e("ThreadUtil", "Unsupported message, what=" + next.what);
                        } else {
                            backgroundCallback.recycleTile((TileList.Tile) next.data);
                        }
                    }
                }
            };
            AtomicBoolean mBackgroundRunning = new AtomicBoolean(false);
            private final Executor mExecutor = AsyncTask.THREAD_POOL_EXECUTOR;
            final MessageQueue mQueue = new MessageQueue();

            private void maybeExecuteBackgroundRunnable() {
                if (this.mBackgroundRunning.compareAndSet(false, true)) {
                    this.mExecutor.execute(this.mBackgroundRunnable);
                }
            }

            private void sendMessage(SyncQueueItem syncQueueItem) {
                this.mQueue.sendMessage(syncQueueItem);
                maybeExecuteBackgroundRunnable();
            }

            private void sendMessageAtFrontOfQueue(SyncQueueItem syncQueueItem) {
                this.mQueue.sendMessageAtFrontOfQueue(syncQueueItem);
                maybeExecuteBackgroundRunnable();
            }

            public void loadTile(int i4, int i5) {
                sendMessage(SyncQueueItem.obtainMessage(3, i4, i5));
            }

            public void recycleTile(TileList.Tile<T> tile) {
                sendMessage(SyncQueueItem.obtainMessage(4, 0, (Object) tile));
            }

            public void refresh(int i4) {
                sendMessageAtFrontOfQueue(SyncQueueItem.obtainMessage(1, i4, (Object) null));
            }

            public void updateRange(int i4, int i5, int i6, int i7, int i8) {
                sendMessageAtFrontOfQueue(SyncQueueItem.obtainMessage(2, i4, i5, i6, i7, i8, (Object) null));
            }
        };
    }

    public ThreadUtil.MainThreadCallback<T> getMainThreadProxy(final ThreadUtil.MainThreadCallback<T> mainThreadCallback) {
        return new ThreadUtil.MainThreadCallback<T>() {
            static final int ADD_TILE = 2;
            static final int REMOVE_TILE = 3;
            static final int UPDATE_ITEM_COUNT = 1;
            private final Handler mMainThreadHandler = new Handler(Looper.getMainLooper());
            private Runnable mMainThreadRunnable = new Runnable() {
                public void run() {
                    SyncQueueItem next = AnonymousClass1.this.mQueue.next();
                    while (next != null) {
                        int i4 = next.what;
                        if (i4 == 1) {
                            mainThreadCallback.updateItemCount(next.arg1, next.arg2);
                        } else if (i4 == 2) {
                            mainThreadCallback.addTile(next.arg1, (TileList.Tile) next.data);
                        } else if (i4 != 3) {
                            Log.e("ThreadUtil", "Unsupported message, what=" + next.what);
                        } else {
                            mainThreadCallback.removeTile(next.arg1, next.arg2);
                        }
                        next = AnonymousClass1.this.mQueue.next();
                    }
                }
            };
            final MessageQueue mQueue = new MessageQueue();

            private void sendMessage(SyncQueueItem syncQueueItem) {
                this.mQueue.sendMessage(syncQueueItem);
                this.mMainThreadHandler.post(this.mMainThreadRunnable);
            }

            public void addTile(int i4, TileList.Tile<T> tile) {
                sendMessage(SyncQueueItem.obtainMessage(2, i4, (Object) tile));
            }

            public void removeTile(int i4, int i5) {
                sendMessage(SyncQueueItem.obtainMessage(3, i4, i5));
            }

            public void updateItemCount(int i4, int i5) {
                sendMessage(SyncQueueItem.obtainMessage(1, i4, i5));
            }
        };
    }

    static class SyncQueueItem {
        private static SyncQueueItem sPool;
        private static final Object sPoolLock = new Object();
        public int arg1;
        public int arg2;
        public int arg3;
        public int arg4;
        public int arg5;
        public Object data;
        SyncQueueItem next;
        public int what;

        SyncQueueItem() {
        }

        static SyncQueueItem obtainMessage(int i4, int i5, int i6, int i7, int i8, int i9, Object obj) {
            SyncQueueItem syncQueueItem;
            synchronized (sPoolLock) {
                try {
                    syncQueueItem = sPool;
                    if (syncQueueItem == null) {
                        syncQueueItem = new SyncQueueItem();
                    } else {
                        sPool = syncQueueItem.next;
                        syncQueueItem.next = null;
                    }
                    syncQueueItem.what = i4;
                    syncQueueItem.arg1 = i5;
                    syncQueueItem.arg2 = i6;
                    syncQueueItem.arg3 = i7;
                    syncQueueItem.arg4 = i8;
                    syncQueueItem.arg5 = i9;
                    syncQueueItem.data = obj;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return syncQueueItem;
        }

        /* access modifiers changed from: package-private */
        public void recycle() {
            this.next = null;
            this.arg5 = 0;
            this.arg4 = 0;
            this.arg3 = 0;
            this.arg2 = 0;
            this.arg1 = 0;
            this.what = 0;
            this.data = null;
            synchronized (sPoolLock) {
                try {
                    SyncQueueItem syncQueueItem = sPool;
                    if (syncQueueItem != null) {
                        this.next = syncQueueItem;
                    }
                    sPool = this;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        static SyncQueueItem obtainMessage(int i4, int i5, int i6) {
            return obtainMessage(i4, i5, i6, 0, 0, 0, (Object) null);
        }

        static SyncQueueItem obtainMessage(int i4, int i5, Object obj) {
            return obtainMessage(i4, i5, 0, 0, 0, 0, obj);
        }
    }
}
