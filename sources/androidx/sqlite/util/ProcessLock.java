package androidx.sqlite.util;

import android.annotation.SuppressLint;
import android.util.Log;
import androidx.annotation.RestrictTo;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class ProcessLock {
    public static final Companion Companion = new Companion((C2103g) null);
    private static final String TAG = "SupportSQLiteLock";
    /* access modifiers changed from: private */
    public static final Map<String, Lock> threadLocksMap = new HashMap();
    private FileChannel lockChannel;
    private final File lockFile;
    private final boolean processLock;
    @SuppressLint({"SyntheticAccessor"})
    private final Lock threadLock;

    public static final class Companion {
        public /* synthetic */ Companion(C2103g gVar) {
            this();
        }

        /* access modifiers changed from: private */
        public final Lock getThreadLock(String str) {
            Lock lock;
            synchronized (ProcessLock.threadLocksMap) {
                try {
                    Map access$getThreadLocksMap$cp = ProcessLock.threadLocksMap;
                    Object obj = access$getThreadLocksMap$cp.get(str);
                    if (obj == null) {
                        obj = new ReentrantLock();
                        access$getThreadLocksMap$cp.put(str, obj);
                    }
                    lock = (Lock) obj;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return lock;
        }

        private Companion() {
        }
    }

    public ProcessLock(String str, File file, boolean z4) {
        m.e(str, RewardPlus.NAME);
        m.e(file, "lockDir");
        this.processLock = z4;
        File file2 = new File(file, str + ".lck");
        this.lockFile = file2;
        Companion companion = Companion;
        String absolutePath = file2.getAbsolutePath();
        m.d(absolutePath, "lockFile.absolutePath");
        this.threadLock = companion.getThreadLock(absolutePath);
    }

    public static /* synthetic */ void lock$default(ProcessLock processLock2, boolean z4, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            z4 = processLock2.processLock;
        }
        processLock2.lock(z4);
    }

    public final void lock(boolean z4) {
        this.threadLock.lock();
        if (z4) {
            try {
                File parentFile = this.lockFile.getParentFile();
                if (parentFile != null) {
                    parentFile.mkdirs();
                }
                FileChannel channel = new FileOutputStream(this.lockFile).getChannel();
                channel.lock();
                this.lockChannel = channel;
            } catch (IOException e5) {
                this.lockChannel = null;
                Log.w(TAG, "Unable to grab file lock.", e5);
            }
        }
    }

    public final void unlock() {
        try {
            FileChannel fileChannel = this.lockChannel;
            if (fileChannel != null) {
                fileChannel.close();
            }
        } catch (IOException unused) {
        }
        this.threadLock.unlock();
    }
}
