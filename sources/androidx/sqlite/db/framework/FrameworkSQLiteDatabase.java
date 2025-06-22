package androidx.sqlite.db.framework;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.database.sqlite.SQLiteStatement;
import android.database.sqlite.SQLiteTransactionListener;
import android.os.Build;
import android.os.CancellationSignal;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteCompat;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.mbridge.msdk.MBridgeConstans;
import d3.r;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;

public final class FrameworkSQLiteDatabase implements SupportSQLiteDatabase, AutoCloseable {
    private static final String[] CONFLICT_VALUES = {"", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};
    public static final Companion Companion = new Companion((C2103g) null);
    private static final String[] EMPTY_STRING_ARRAY = new String[0];
    private final List<Pair<String, String>> attachedDbs;
    private final SQLiteDatabase delegate;

    @RequiresApi(30)
    public static final class Api30Impl {
        public static final Api30Impl INSTANCE = new Api30Impl();

        private Api30Impl() {
        }

        @DoNotInline
        public final void execPerConnectionSQL(SQLiteDatabase sQLiteDatabase, String str, Object[] objArr) {
            m.e(sQLiteDatabase, "sQLiteDatabase");
            m.e(str, "sql");
            sQLiteDatabase.execPerConnectionSQL(str, objArr);
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(C2103g gVar) {
            this();
        }

        private Companion() {
        }
    }

    public FrameworkSQLiteDatabase(SQLiteDatabase sQLiteDatabase) {
        m.e(sQLiteDatabase, "delegate");
        this.delegate = sQLiteDatabase;
        this.attachedDbs = sQLiteDatabase.getAttachedDbs();
    }

    /* access modifiers changed from: private */
    public static final Cursor query$lambda$0(r rVar, SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
        m.e(rVar, "$tmp0");
        return (Cursor) rVar.invoke(sQLiteDatabase, sQLiteCursorDriver, str, sQLiteQuery);
    }

    /* access modifiers changed from: private */
    public static final Cursor query$lambda$1(SupportSQLiteQuery supportSQLiteQuery, SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
        m.e(supportSQLiteQuery, "$query");
        m.b(sQLiteQuery);
        supportSQLiteQuery.bindTo(new FrameworkSQLiteProgram(sQLiteQuery));
        return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
    }

    public void beginTransaction() {
        this.delegate.beginTransaction();
    }

    public void beginTransactionNonExclusive() {
        this.delegate.beginTransactionNonExclusive();
    }

    public void beginTransactionWithListener(SQLiteTransactionListener sQLiteTransactionListener) {
        m.e(sQLiteTransactionListener, "transactionListener");
        this.delegate.beginTransactionWithListener(sQLiteTransactionListener);
    }

    public void beginTransactionWithListenerNonExclusive(SQLiteTransactionListener sQLiteTransactionListener) {
        m.e(sQLiteTransactionListener, "transactionListener");
        this.delegate.beginTransactionWithListenerNonExclusive(sQLiteTransactionListener);
    }

    public void close() throws IOException {
        this.delegate.close();
    }

    public SupportSQLiteStatement compileStatement(String str) {
        m.e(str, "sql");
        SQLiteStatement compileStatement = this.delegate.compileStatement(str);
        m.d(compileStatement, "delegate.compileStatement(sql)");
        return new FrameworkSQLiteStatement(compileStatement);
    }

    public int delete(String str, String str2, Object[] objArr) {
        m.e(str, "table");
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM ");
        sb.append(str);
        if (!(str2 == null || str2.length() == 0)) {
            sb.append(" WHERE ");
            sb.append(str2);
        }
        String sb2 = sb.toString();
        m.d(sb2, "StringBuilder().apply(builderAction).toString()");
        SupportSQLiteStatement compileStatement = compileStatement(sb2);
        SimpleSQLiteQuery.Companion.bind(compileStatement, objArr);
        return compileStatement.executeUpdateDelete();
    }

    @RequiresApi(api = 16)
    public void disableWriteAheadLogging() {
        SupportSQLiteCompat.Api16Impl.disableWriteAheadLogging(this.delegate);
    }

    public boolean enableWriteAheadLogging() {
        return this.delegate.enableWriteAheadLogging();
    }

    public void endTransaction() {
        this.delegate.endTransaction();
    }

    public void execPerConnectionSQL(String str, Object[] objArr) {
        m.e(str, "sql");
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 30) {
            Api30Impl.INSTANCE.execPerConnectionSQL(this.delegate, str, objArr);
            return;
        }
        throw new UnsupportedOperationException("execPerConnectionSQL is not supported on a SDK version lower than 30, current version is: " + i4);
    }

    public void execSQL(String str) throws SQLException {
        m.e(str, "sql");
        this.delegate.execSQL(str);
    }

    public List<Pair<String, String>> getAttachedDbs() {
        return this.attachedDbs;
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

    public long insert(String str, int i4, ContentValues contentValues) throws SQLException {
        m.e(str, "table");
        m.e(contentValues, "values");
        return this.delegate.insertWithOnConflict(str, (String) null, contentValues, i4);
    }

    public boolean isDatabaseIntegrityOk() {
        return this.delegate.isDatabaseIntegrityOk();
    }

    public boolean isDbLockedByCurrentThread() {
        return this.delegate.isDbLockedByCurrentThread();
    }

    public final boolean isDelegate(SQLiteDatabase sQLiteDatabase) {
        m.e(sQLiteDatabase, "sqLiteDatabase");
        return m.a(this.delegate, sQLiteDatabase);
    }

    public boolean isExecPerConnectionSQLSupported() {
        if (Build.VERSION.SDK_INT >= 30) {
            return true;
        }
        return false;
    }

    public boolean isOpen() {
        return this.delegate.isOpen();
    }

    public boolean isReadOnly() {
        return this.delegate.isReadOnly();
    }

    @RequiresApi(api = 16)
    public boolean isWriteAheadLoggingEnabled() {
        return SupportSQLiteCompat.Api16Impl.isWriteAheadLoggingEnabled(this.delegate);
    }

    public boolean needUpgrade(int i4) {
        return this.delegate.needUpgrade(i4);
    }

    public Cursor query(String str) {
        m.e(str, MBridgeConstans.DYNAMIC_VIEW_WX_QUERY);
        return query((SupportSQLiteQuery) new SimpleSQLiteQuery(str));
    }

    @RequiresApi(api = 16)
    public void setForeignKeyConstraintsEnabled(boolean z4) {
        SupportSQLiteCompat.Api16Impl.setForeignKeyConstraintsEnabled(this.delegate, z4);
    }

    public void setLocale(Locale locale) {
        m.e(locale, "locale");
        this.delegate.setLocale(locale);
    }

    public void setMaxSqlCacheSize(int i4) {
        this.delegate.setMaxSqlCacheSize(i4);
    }

    /* renamed from: setMaximumSize  reason: collision with other method in class */
    public void m4setMaximumSize(long j4) {
        this.delegate.setMaximumSize(j4);
    }

    public void setPageSize(long j4) {
        this.delegate.setPageSize(j4);
    }

    public void setTransactionSuccessful() {
        this.delegate.setTransactionSuccessful();
    }

    public void setVersion(int i4) {
        this.delegate.setVersion(i4);
    }

    public int update(String str, int i4, ContentValues contentValues, String str2, Object[] objArr) {
        int i5;
        String str3;
        m.e(str, "table");
        m.e(contentValues, "values");
        if (contentValues.size() != 0) {
            int size = contentValues.size();
            if (objArr == null) {
                i5 = size;
            } else {
                i5 = objArr.length + size;
            }
            Object[] objArr2 = new Object[i5];
            StringBuilder sb = new StringBuilder();
            sb.append("UPDATE ");
            sb.append(CONFLICT_VALUES[i4]);
            sb.append(str);
            sb.append(" SET ");
            int i6 = 0;
            for (String next : contentValues.keySet()) {
                if (i6 > 0) {
                    str3 = ",";
                } else {
                    str3 = "";
                }
                sb.append(str3);
                sb.append(next);
                objArr2[i6] = contentValues.get(next);
                sb.append("=?");
                i6++;
            }
            if (objArr != null) {
                for (int i7 = size; i7 < i5; i7++) {
                    objArr2[i7] = objArr[i7 - size];
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                sb.append(" WHERE ");
                sb.append(str2);
            }
            String sb2 = sb.toString();
            m.d(sb2, "StringBuilder().apply(builderAction).toString()");
            SupportSQLiteStatement compileStatement = compileStatement(sb2);
            SimpleSQLiteQuery.Companion.bind(compileStatement, objArr2);
            return compileStatement.executeUpdateDelete();
        }
        throw new IllegalArgumentException("Empty values");
    }

    public boolean yieldIfContendedSafely() {
        return this.delegate.yieldIfContendedSafely();
    }

    public void execSQL(String str, Object[] objArr) throws SQLException {
        m.e(str, "sql");
        m.e(objArr, "bindArgs");
        this.delegate.execSQL(str, objArr);
    }

    public Cursor query(String str, Object[] objArr) {
        m.e(str, MBridgeConstans.DYNAMIC_VIEW_WX_QUERY);
        m.e(objArr, "bindArgs");
        return query((SupportSQLiteQuery) new SimpleSQLiteQuery(str, objArr));
    }

    public long setMaximumSize(long j4) {
        this.delegate.setMaximumSize(j4);
        return this.delegate.getMaximumSize();
    }

    public boolean yieldIfContendedSafely(long j4) {
        return this.delegate.yieldIfContendedSafely(j4);
    }

    public Cursor query(SupportSQLiteQuery supportSQLiteQuery) {
        m.e(supportSQLiteQuery, MBridgeConstans.DYNAMIC_VIEW_WX_QUERY);
        Cursor rawQueryWithFactory = this.delegate.rawQueryWithFactory(new b(new FrameworkSQLiteDatabase$query$cursorFactory$1(supportSQLiteQuery)), supportSQLiteQuery.getSql(), EMPTY_STRING_ARRAY, (String) null);
        m.d(rawQueryWithFactory, "delegate.rawQueryWithFac…EMPTY_STRING_ARRAY, null)");
        return rawQueryWithFactory;
    }

    @RequiresApi(16)
    public Cursor query(SupportSQLiteQuery supportSQLiteQuery, CancellationSignal cancellationSignal) {
        m.e(supportSQLiteQuery, MBridgeConstans.DYNAMIC_VIEW_WX_QUERY);
        SQLiteDatabase sQLiteDatabase = this.delegate;
        String sql = supportSQLiteQuery.getSql();
        String[] strArr = EMPTY_STRING_ARRAY;
        m.b(cancellationSignal);
        return SupportSQLiteCompat.Api16Impl.rawQueryWithFactory(sQLiteDatabase, sql, strArr, (String) null, cancellationSignal, new a(supportSQLiteQuery));
    }
}
