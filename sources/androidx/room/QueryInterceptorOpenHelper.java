package androidx.room;

import androidx.annotation.RequiresApi;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.m;

public final class QueryInterceptorOpenHelper implements SupportSQLiteOpenHelper, DelegatingOpenHelper, AutoCloseable {
    private final SupportSQLiteOpenHelper delegate;
    private final RoomDatabase.QueryCallback queryCallback;
    private final Executor queryCallbackExecutor;

    public QueryInterceptorOpenHelper(SupportSQLiteOpenHelper supportSQLiteOpenHelper, Executor executor, RoomDatabase.QueryCallback queryCallback2) {
        m.e(supportSQLiteOpenHelper, "delegate");
        m.e(executor, "queryCallbackExecutor");
        m.e(queryCallback2, "queryCallback");
        this.delegate = supportSQLiteOpenHelper;
        this.queryCallbackExecutor = executor;
        this.queryCallback = queryCallback2;
    }

    public void close() {
        this.delegate.close();
    }

    public String getDatabaseName() {
        return this.delegate.getDatabaseName();
    }

    public SupportSQLiteOpenHelper getDelegate() {
        return this.delegate;
    }

    public SupportSQLiteDatabase getReadableDatabase() {
        return new QueryInterceptorDatabase(getDelegate().getReadableDatabase(), this.queryCallbackExecutor, this.queryCallback);
    }

    public SupportSQLiteDatabase getWritableDatabase() {
        return new QueryInterceptorDatabase(getDelegate().getWritableDatabase(), this.queryCallbackExecutor, this.queryCallback);
    }

    @RequiresApi(api = 16)
    public void setWriteAheadLoggingEnabled(boolean z4) {
        this.delegate.setWriteAheadLoggingEnabled(z4);
    }
}
