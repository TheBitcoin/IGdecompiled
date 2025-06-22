package androidx.room;

import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.m;

public final class QueryInterceptorStatement implements SupportSQLiteStatement, AutoCloseable {
    private final List<Object> bindArgsCache = new ArrayList();
    private final SupportSQLiteStatement delegate;
    private final RoomDatabase.QueryCallback queryCallback;
    private final Executor queryCallbackExecutor;
    private final String sqlStatement;

    public QueryInterceptorStatement(SupportSQLiteStatement supportSQLiteStatement, String str, Executor executor, RoomDatabase.QueryCallback queryCallback2) {
        m.e(supportSQLiteStatement, "delegate");
        m.e(str, "sqlStatement");
        m.e(executor, "queryCallbackExecutor");
        m.e(queryCallback2, "queryCallback");
        this.delegate = supportSQLiteStatement;
        this.sqlStatement = str;
        this.queryCallbackExecutor = executor;
        this.queryCallback = queryCallback2;
    }

    /* access modifiers changed from: private */
    public static final void execute$lambda$0(QueryInterceptorStatement queryInterceptorStatement) {
        m.e(queryInterceptorStatement, "this$0");
        queryInterceptorStatement.queryCallback.onQuery(queryInterceptorStatement.sqlStatement, queryInterceptorStatement.bindArgsCache);
    }

    /* access modifiers changed from: private */
    public static final void executeInsert$lambda$2(QueryInterceptorStatement queryInterceptorStatement) {
        m.e(queryInterceptorStatement, "this$0");
        queryInterceptorStatement.queryCallback.onQuery(queryInterceptorStatement.sqlStatement, queryInterceptorStatement.bindArgsCache);
    }

    /* access modifiers changed from: private */
    public static final void executeUpdateDelete$lambda$1(QueryInterceptorStatement queryInterceptorStatement) {
        m.e(queryInterceptorStatement, "this$0");
        queryInterceptorStatement.queryCallback.onQuery(queryInterceptorStatement.sqlStatement, queryInterceptorStatement.bindArgsCache);
    }

    private final void saveArgsToCache(int i4, Object obj) {
        int i5 = i4 - 1;
        if (i5 >= this.bindArgsCache.size()) {
            int size = (i5 - this.bindArgsCache.size()) + 1;
            for (int i6 = 0; i6 < size; i6++) {
                this.bindArgsCache.add((Object) null);
            }
        }
        this.bindArgsCache.set(i5, obj);
    }

    /* access modifiers changed from: private */
    public static final void simpleQueryForLong$lambda$3(QueryInterceptorStatement queryInterceptorStatement) {
        m.e(queryInterceptorStatement, "this$0");
        queryInterceptorStatement.queryCallback.onQuery(queryInterceptorStatement.sqlStatement, queryInterceptorStatement.bindArgsCache);
    }

    /* access modifiers changed from: private */
    public static final void simpleQueryForString$lambda$4(QueryInterceptorStatement queryInterceptorStatement) {
        m.e(queryInterceptorStatement, "this$0");
        queryInterceptorStatement.queryCallback.onQuery(queryInterceptorStatement.sqlStatement, queryInterceptorStatement.bindArgsCache);
    }

    public void bindBlob(int i4, byte[] bArr) {
        m.e(bArr, "value");
        saveArgsToCache(i4, bArr);
        this.delegate.bindBlob(i4, bArr);
    }

    public void bindDouble(int i4, double d5) {
        saveArgsToCache(i4, Double.valueOf(d5));
        this.delegate.bindDouble(i4, d5);
    }

    public void bindLong(int i4, long j4) {
        saveArgsToCache(i4, Long.valueOf(j4));
        this.delegate.bindLong(i4, j4);
    }

    public void bindNull(int i4) {
        Object[] array = this.bindArgsCache.toArray(new Object[0]);
        m.c(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        saveArgsToCache(i4, Arrays.copyOf(array, array.length));
        this.delegate.bindNull(i4);
    }

    public void bindString(int i4, String str) {
        m.e(str, "value");
        saveArgsToCache(i4, str);
        this.delegate.bindString(i4, str);
    }

    public void clearBindings() {
        this.bindArgsCache.clear();
        this.delegate.clearBindings();
    }

    public void close() {
        this.delegate.close();
    }

    public void execute() {
        this.queryCallbackExecutor.execute(new v(this));
        this.delegate.execute();
    }

    public long executeInsert() {
        this.queryCallbackExecutor.execute(new t(this));
        return this.delegate.executeInsert();
    }

    public int executeUpdateDelete() {
        this.queryCallbackExecutor.execute(new w(this));
        return this.delegate.executeUpdateDelete();
    }

    public long simpleQueryForLong() {
        this.queryCallbackExecutor.execute(new s(this));
        return this.delegate.simpleQueryForLong();
    }

    public String simpleQueryForString() {
        this.queryCallbackExecutor.execute(new u(this));
        return this.delegate.simpleQueryForString();
    }
}
