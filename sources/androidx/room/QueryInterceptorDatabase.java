package androidx.room;

import S2.C1594h;
import S2.C1601o;
import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteTransactionListener;
import android.os.CancellationSignal;
import android.util.Pair;
import androidx.annotation.RequiresApi;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.mbridge.msdk.MBridgeConstans;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.m;

public final class QueryInterceptorDatabase implements SupportSQLiteDatabase, AutoCloseable {
    private final SupportSQLiteDatabase delegate;
    private final RoomDatabase.QueryCallback queryCallback;
    private final Executor queryCallbackExecutor;

    public QueryInterceptorDatabase(SupportSQLiteDatabase supportSQLiteDatabase, Executor executor, RoomDatabase.QueryCallback queryCallback2) {
        m.e(supportSQLiteDatabase, "delegate");
        m.e(executor, "queryCallbackExecutor");
        m.e(queryCallback2, "queryCallback");
        this.delegate = supportSQLiteDatabase;
        this.queryCallbackExecutor = executor;
        this.queryCallback = queryCallback2;
    }

    /* access modifiers changed from: private */
    public static final void beginTransaction$lambda$0(QueryInterceptorDatabase queryInterceptorDatabase) {
        m.e(queryInterceptorDatabase, "this$0");
        queryInterceptorDatabase.queryCallback.onQuery("BEGIN EXCLUSIVE TRANSACTION", C1601o.h());
    }

    /* access modifiers changed from: private */
    public static final void beginTransactionNonExclusive$lambda$1(QueryInterceptorDatabase queryInterceptorDatabase) {
        m.e(queryInterceptorDatabase, "this$0");
        queryInterceptorDatabase.queryCallback.onQuery("BEGIN DEFERRED TRANSACTION", C1601o.h());
    }

    /* access modifiers changed from: private */
    public static final void beginTransactionWithListener$lambda$2(QueryInterceptorDatabase queryInterceptorDatabase) {
        m.e(queryInterceptorDatabase, "this$0");
        queryInterceptorDatabase.queryCallback.onQuery("BEGIN EXCLUSIVE TRANSACTION", C1601o.h());
    }

    /* access modifiers changed from: private */
    public static final void beginTransactionWithListenerNonExclusive$lambda$3(QueryInterceptorDatabase queryInterceptorDatabase) {
        m.e(queryInterceptorDatabase, "this$0");
        queryInterceptorDatabase.queryCallback.onQuery("BEGIN DEFERRED TRANSACTION", C1601o.h());
    }

    /* access modifiers changed from: private */
    public static final void endTransaction$lambda$4(QueryInterceptorDatabase queryInterceptorDatabase) {
        m.e(queryInterceptorDatabase, "this$0");
        queryInterceptorDatabase.queryCallback.onQuery("END TRANSACTION", C1601o.h());
    }

    /* access modifiers changed from: private */
    public static final void execSQL$lambda$10(QueryInterceptorDatabase queryInterceptorDatabase, String str) {
        m.e(queryInterceptorDatabase, "this$0");
        m.e(str, "$sql");
        queryInterceptorDatabase.queryCallback.onQuery(str, C1601o.h());
    }

    /* access modifiers changed from: private */
    public static final void execSQL$lambda$11(QueryInterceptorDatabase queryInterceptorDatabase, String str, List list) {
        m.e(queryInterceptorDatabase, "this$0");
        m.e(str, "$sql");
        m.e(list, "$inputArguments");
        queryInterceptorDatabase.queryCallback.onQuery(str, list);
    }

    /* access modifiers changed from: private */
    public static final void query$lambda$6(QueryInterceptorDatabase queryInterceptorDatabase, String str) {
        m.e(queryInterceptorDatabase, "this$0");
        m.e(str, "$query");
        queryInterceptorDatabase.queryCallback.onQuery(str, C1601o.h());
    }

    /* access modifiers changed from: private */
    public static final void query$lambda$7(QueryInterceptorDatabase queryInterceptorDatabase, String str, Object[] objArr) {
        m.e(queryInterceptorDatabase, "this$0");
        m.e(str, "$query");
        m.e(objArr, "$bindArgs");
        queryInterceptorDatabase.queryCallback.onQuery(str, C1594h.I(objArr));
    }

    /* access modifiers changed from: private */
    public static final void query$lambda$8(QueryInterceptorDatabase queryInterceptorDatabase, SupportSQLiteQuery supportSQLiteQuery, QueryInterceptorProgram queryInterceptorProgram) {
        m.e(queryInterceptorDatabase, "this$0");
        m.e(supportSQLiteQuery, "$query");
        m.e(queryInterceptorProgram, "$queryInterceptorProgram");
        queryInterceptorDatabase.queryCallback.onQuery(supportSQLiteQuery.getSql(), queryInterceptorProgram.getBindArgsCache$room_runtime_release());
    }

    /* access modifiers changed from: private */
    public static final void query$lambda$9(QueryInterceptorDatabase queryInterceptorDatabase, SupportSQLiteQuery supportSQLiteQuery, QueryInterceptorProgram queryInterceptorProgram) {
        m.e(queryInterceptorDatabase, "this$0");
        m.e(supportSQLiteQuery, "$query");
        m.e(queryInterceptorProgram, "$queryInterceptorProgram");
        queryInterceptorDatabase.queryCallback.onQuery(supportSQLiteQuery.getSql(), queryInterceptorProgram.getBindArgsCache$room_runtime_release());
    }

    /* access modifiers changed from: private */
    public static final void setTransactionSuccessful$lambda$5(QueryInterceptorDatabase queryInterceptorDatabase) {
        m.e(queryInterceptorDatabase, "this$0");
        queryInterceptorDatabase.queryCallback.onQuery("TRANSACTION SUCCESSFUL", C1601o.h());
    }

    public void beginTransaction() {
        this.queryCallbackExecutor.execute(new l(this));
        this.delegate.beginTransaction();
    }

    public void beginTransactionNonExclusive() {
        this.queryCallbackExecutor.execute(new n(this));
        this.delegate.beginTransactionNonExclusive();
    }

    public void beginTransactionWithListener(SQLiteTransactionListener sQLiteTransactionListener) {
        m.e(sQLiteTransactionListener, "transactionListener");
        this.queryCallbackExecutor.execute(new q(this));
        this.delegate.beginTransactionWithListener(sQLiteTransactionListener);
    }

    public void beginTransactionWithListenerNonExclusive(SQLiteTransactionListener sQLiteTransactionListener) {
        m.e(sQLiteTransactionListener, "transactionListener");
        this.queryCallbackExecutor.execute(new h(this));
        this.delegate.beginTransactionWithListenerNonExclusive(sQLiteTransactionListener);
    }

    public void close() {
        this.delegate.close();
    }

    public SupportSQLiteStatement compileStatement(String str) {
        m.e(str, "sql");
        return new QueryInterceptorStatement(this.delegate.compileStatement(str), str, this.queryCallbackExecutor, this.queryCallback);
    }

    public int delete(String str, String str2, Object[] objArr) {
        m.e(str, "table");
        return this.delegate.delete(str, str2, objArr);
    }

    @RequiresApi(api = 16)
    public void disableWriteAheadLogging() {
        this.delegate.disableWriteAheadLogging();
    }

    public boolean enableWriteAheadLogging() {
        return this.delegate.enableWriteAheadLogging();
    }

    public void endTransaction() {
        this.queryCallbackExecutor.execute(new g(this));
        this.delegate.endTransaction();
    }

    public void execPerConnectionSQL(String str, @SuppressLint({"ArrayReturn"}) Object[] objArr) {
        m.e(str, "sql");
        this.delegate.execPerConnectionSQL(str, objArr);
    }

    public void execSQL(String str) {
        m.e(str, "sql");
        this.queryCallbackExecutor.execute(new k(this, str));
        this.delegate.execSQL(str);
    }

    public List<Pair<String, String>> getAttachedDbs() {
        return this.delegate.getAttachedDbs();
    }

    public long getMaximumSize() {
        return this.delegate.getMaximumSize();
    }

    public long getPageSize() {
        return this.delegate.getPageSize();
    }

    public String getPath() {
        return this.delegate.getPath();
    }

    public int getVersion() {
        return this.delegate.getVersion();
    }

    public boolean inTransaction() {
        return this.delegate.inTransaction();
    }

    public long insert(String str, int i4, ContentValues contentValues) {
        m.e(str, "table");
        m.e(contentValues, "values");
        return this.delegate.insert(str, i4, contentValues);
    }

    public boolean isDatabaseIntegrityOk() {
        return this.delegate.isDatabaseIntegrityOk();
    }

    public boolean isDbLockedByCurrentThread() {
        return this.delegate.isDbLockedByCurrentThread();
    }

    public boolean isExecPerConnectionSQLSupported() {
        return this.delegate.isExecPerConnectionSQLSupported();
    }

    public boolean isOpen() {
        return this.delegate.isOpen();
    }

    public boolean isReadOnly() {
        return this.delegate.isReadOnly();
    }

    @RequiresApi(api = 16)
    public boolean isWriteAheadLoggingEnabled() {
        return this.delegate.isWriteAheadLoggingEnabled();
    }

    public boolean needUpgrade(int i4) {
        return this.delegate.needUpgrade(i4);
    }

    public Cursor query(String str) {
        m.e(str, MBridgeConstans.DYNAMIC_VIEW_WX_QUERY);
        this.queryCallbackExecutor.execute(new i(this, str));
        return this.delegate.query(str);
    }

    @RequiresApi(api = 16)
    public void setForeignKeyConstraintsEnabled(boolean z4) {
        this.delegate.setForeignKeyConstraintsEnabled(z4);
    }

    public void setLocale(Locale locale) {
        m.e(locale, "locale");
        this.delegate.setLocale(locale);
    }

    public void setMaxSqlCacheSize(int i4) {
        this.delegate.setMaxSqlCacheSize(i4);
    }

    public long setMaximumSize(long j4) {
        return this.delegate.setMaximumSize(j4);
    }

    public void setPageSize(long j4) {
        this.delegate.setPageSize(j4);
    }

    public void setTransactionSuccessful() {
        this.queryCallbackExecutor.execute(new m(this));
        this.delegate.setTransactionSuccessful();
    }

    public void setVersion(int i4) {
        this.delegate.setVersion(i4);
    }

    public int update(String str, int i4, ContentValues contentValues, String str2, Object[] objArr) {
        m.e(str, "table");
        m.e(contentValues, "values");
        return this.delegate.update(str, i4, contentValues, str2, objArr);
    }

    public boolean yieldIfContendedSafely() {
        return this.delegate.yieldIfContendedSafely();
    }

    public boolean yieldIfContendedSafely(long j4) {
        return this.delegate.yieldIfContendedSafely(j4);
    }

    public void execSQL(String str, Object[] objArr) {
        m.e(str, "sql");
        m.e(objArr, "bindArgs");
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(C1601o.e(objArr));
        this.queryCallbackExecutor.execute(new o(this, str, arrayList));
        this.delegate.execSQL(str, new List[]{arrayList});
    }

    public Cursor query(String str, Object[] objArr) {
        m.e(str, MBridgeConstans.DYNAMIC_VIEW_WX_QUERY);
        m.e(objArr, "bindArgs");
        this.queryCallbackExecutor.execute(new j(this, str, objArr));
        return this.delegate.query(str, objArr);
    }

    public Cursor query(SupportSQLiteQuery supportSQLiteQuery) {
        m.e(supportSQLiteQuery, MBridgeConstans.DYNAMIC_VIEW_WX_QUERY);
        QueryInterceptorProgram queryInterceptorProgram = new QueryInterceptorProgram();
        supportSQLiteQuery.bindTo(queryInterceptorProgram);
        this.queryCallbackExecutor.execute(new p(this, supportSQLiteQuery, queryInterceptorProgram));
        return this.delegate.query(supportSQLiteQuery);
    }

    public Cursor query(SupportSQLiteQuery supportSQLiteQuery, CancellationSignal cancellationSignal) {
        m.e(supportSQLiteQuery, MBridgeConstans.DYNAMIC_VIEW_WX_QUERY);
        QueryInterceptorProgram queryInterceptorProgram = new QueryInterceptorProgram();
        supportSQLiteQuery.bindTo(queryInterceptorProgram);
        this.queryCallbackExecutor.execute(new C0495r(this, supportSQLiteQuery, queryInterceptorProgram));
        return this.delegate.query(supportSQLiteQuery);
    }
}
