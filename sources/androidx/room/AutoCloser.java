package androidx.room;

import R2.s;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.GuardedBy;
import androidx.annotation.VisibleForTesting;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import d3.l;
import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;

public final class AutoCloser {
    public static final Companion Companion = new Companion((C2103g) null);
    public static final String autoCloseBug = "https://issuetracker.google.com/issues/new?component=413107&template=1096568";
    private long autoCloseTimeoutInMs;
    private final Runnable autoCloser;
    @GuardedBy("lock")
    private SupportSQLiteDatabase delegateDatabase;
    public SupportSQLiteOpenHelper delegateOpenHelper;
    private final Runnable executeAutoCloser;
    private final Executor executor;
    private final Handler handler = new Handler(Looper.getMainLooper());
    @GuardedBy("lock")
    private long lastDecrementRefCountTimeStamp;
    private final Object lock = new Object();
    private boolean manuallyClosed;
    private Runnable onAutoCloseCallback;
    @GuardedBy("lock")
    private int refCount;

    public static final class Companion {
        public /* synthetic */ Companion(C2103g gVar) {
            this();
        }

        private Companion() {
        }
    }

    public AutoCloser(long j4, TimeUnit timeUnit, Executor executor2) {
        m.e(timeUnit, "autoCloseTimeUnit");
        m.e(executor2, "autoCloseExecutor");
        this.autoCloseTimeoutInMs = timeUnit.toMillis(j4);
        this.executor = executor2;
        this.lastDecrementRefCountTimeStamp = SystemClock.uptimeMillis();
        this.executeAutoCloser = new a(this);
        this.autoCloser = new b(this);
    }

    /* access modifiers changed from: private */
    public static final void autoCloser$lambda$3(AutoCloser autoCloser2) {
        s sVar;
        m.e(autoCloser2, "this$0");
        synchronized (autoCloser2.lock) {
            try {
                if (SystemClock.uptimeMillis() - autoCloser2.lastDecrementRefCountTimeStamp >= autoCloser2.autoCloseTimeoutInMs) {
                    if (autoCloser2.refCount == 0) {
                        Runnable runnable = autoCloser2.onAutoCloseCallback;
                        if (runnable != null) {
                            runnable.run();
                            sVar = s.f8222a;
                        } else {
                            sVar = null;
                        }
                        if (sVar != null) {
                            SupportSQLiteDatabase supportSQLiteDatabase = autoCloser2.delegateDatabase;
                            if (supportSQLiteDatabase != null && supportSQLiteDatabase.isOpen()) {
                                supportSQLiteDatabase.close();
                            }
                            autoCloser2.delegateDatabase = null;
                            s sVar2 = s.f8222a;
                            return;
                        }
                        throw new IllegalStateException("onAutoCloseCallback is null but it should have been set before use. Please file a bug against Room at: https://issuetracker.google.com/issues/new?component=413107&template=1096568");
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void executeAutoCloser$lambda$0(AutoCloser autoCloser2) {
        m.e(autoCloser2, "this$0");
        autoCloser2.executor.execute(autoCloser2.autoCloser);
    }

    public final void closeDatabaseIfOpen() throws IOException {
        synchronized (this.lock) {
            try {
                this.manuallyClosed = true;
                SupportSQLiteDatabase supportSQLiteDatabase = this.delegateDatabase;
                if (supportSQLiteDatabase != null) {
                    supportSQLiteDatabase.close();
                }
                this.delegateDatabase = null;
                s sVar = s.f8222a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void decrementCountAndScheduleClose() {
        synchronized (this.lock) {
            try {
                int i4 = this.refCount;
                if (i4 > 0) {
                    int i5 = i4 - 1;
                    this.refCount = i5;
                    if (i5 == 0) {
                        if (this.delegateDatabase != null) {
                            this.handler.postDelayed(this.executeAutoCloser, this.autoCloseTimeoutInMs);
                        } else {
                            return;
                        }
                    }
                    s sVar = s.f8222a;
                    return;
                }
                throw new IllegalStateException("ref count is 0 or lower but we're supposed to decrement");
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final <V> V executeRefCountingFunction(l lVar) {
        m.e(lVar, "block");
        try {
            return lVar.invoke(incrementCountAndEnsureDbIsOpen());
        } finally {
            decrementCountAndScheduleClose();
        }
    }

    public final SupportSQLiteDatabase getDelegateDatabase$room_runtime_release() {
        return this.delegateDatabase;
    }

    public final SupportSQLiteOpenHelper getDelegateOpenHelper() {
        SupportSQLiteOpenHelper supportSQLiteOpenHelper = this.delegateOpenHelper;
        if (supportSQLiteOpenHelper != null) {
            return supportSQLiteOpenHelper;
        }
        m.u("delegateOpenHelper");
        return null;
    }

    public final long getLastDecrementRefCountTimeStamp$room_runtime_release() {
        return this.lastDecrementRefCountTimeStamp;
    }

    public final Runnable getOnAutoCloseCallback$room_runtime_release() {
        return this.onAutoCloseCallback;
    }

    public final int getRefCount$room_runtime_release() {
        return this.refCount;
    }

    @VisibleForTesting
    public final int getRefCountForTest$room_runtime_release() {
        int i4;
        synchronized (this.lock) {
            i4 = this.refCount;
        }
        return i4;
    }

    public final SupportSQLiteDatabase incrementCountAndEnsureDbIsOpen() {
        synchronized (this.lock) {
            this.handler.removeCallbacks(this.executeAutoCloser);
            this.refCount++;
            if (!this.manuallyClosed) {
                SupportSQLiteDatabase supportSQLiteDatabase = this.delegateDatabase;
                if (supportSQLiteDatabase != null && supportSQLiteDatabase.isOpen()) {
                    return supportSQLiteDatabase;
                }
                SupportSQLiteDatabase writableDatabase = getDelegateOpenHelper().getWritableDatabase();
                this.delegateDatabase = writableDatabase;
                return writableDatabase;
            }
            throw new IllegalStateException("Attempting to open already closed database.");
        }
    }

    public final void init(SupportSQLiteOpenHelper supportSQLiteOpenHelper) {
        m.e(supportSQLiteOpenHelper, "delegateOpenHelper");
        setDelegateOpenHelper(supportSQLiteOpenHelper);
    }

    public final boolean isActive() {
        return !this.manuallyClosed;
    }

    public final void setAutoCloseCallback(Runnable runnable) {
        m.e(runnable, "onAutoClose");
        this.onAutoCloseCallback = runnable;
    }

    public final void setDelegateDatabase$room_runtime_release(SupportSQLiteDatabase supportSQLiteDatabase) {
        this.delegateDatabase = supportSQLiteDatabase;
    }

    public final void setDelegateOpenHelper(SupportSQLiteOpenHelper supportSQLiteOpenHelper) {
        m.e(supportSQLiteOpenHelper, "<set-?>");
        this.delegateOpenHelper = supportSQLiteOpenHelper;
    }

    public final void setLastDecrementRefCountTimeStamp$room_runtime_release(long j4) {
        this.lastDecrementRefCountTimeStamp = j4;
    }

    public final void setOnAutoCloseCallback$room_runtime_release(Runnable runnable) {
        this.onAutoCloseCallback = runnable;
    }

    public final void setRefCount$room_runtime_release(int i4) {
        this.refCount = i4;
    }
}
