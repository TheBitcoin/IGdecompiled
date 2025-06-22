package androidx.sqlite.db;

import android.annotation.SuppressLint;
import com.mbridge.msdk.MBridgeConstans;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;

public final class SimpleSQLiteQuery implements SupportSQLiteQuery {
    public static final Companion Companion = new Companion((C2103g) null);
    private final Object[] bindArgs;
    private final String query;

    public static final class Companion {
        public /* synthetic */ Companion(C2103g gVar) {
            this();
        }

        @SuppressLint({"SyntheticAccessor"})
        public final void bind(SupportSQLiteProgram supportSQLiteProgram, Object[] objArr) {
            m.e(supportSQLiteProgram, "statement");
            if (objArr != null) {
                int length = objArr.length;
                int i4 = 0;
                while (i4 < length) {
                    Object obj = objArr[i4];
                    i4++;
                    bind(supportSQLiteProgram, i4, obj);
                }
            }
        }

        private Companion() {
        }

        private final void bind(SupportSQLiteProgram supportSQLiteProgram, int i4, Object obj) {
            if (obj == null) {
                supportSQLiteProgram.bindNull(i4);
            } else if (obj instanceof byte[]) {
                supportSQLiteProgram.bindBlob(i4, (byte[]) obj);
            } else if (obj instanceof Float) {
                supportSQLiteProgram.bindDouble(i4, (double) ((Number) obj).floatValue());
            } else if (obj instanceof Double) {
                supportSQLiteProgram.bindDouble(i4, ((Number) obj).doubleValue());
            } else if (obj instanceof Long) {
                supportSQLiteProgram.bindLong(i4, ((Number) obj).longValue());
            } else if (obj instanceof Integer) {
                supportSQLiteProgram.bindLong(i4, (long) ((Number) obj).intValue());
            } else if (obj instanceof Short) {
                supportSQLiteProgram.bindLong(i4, (long) ((Number) obj).shortValue());
            } else if (obj instanceof Byte) {
                supportSQLiteProgram.bindLong(i4, (long) ((Number) obj).byteValue());
            } else if (obj instanceof String) {
                supportSQLiteProgram.bindString(i4, (String) obj);
            } else if (obj instanceof Boolean) {
                supportSQLiteProgram.bindLong(i4, ((Boolean) obj).booleanValue() ? 1 : 0);
            } else {
                throw new IllegalArgumentException("Cannot bind " + obj + " at index " + i4 + " Supported types: Null, ByteArray, Float, Double, Long, Int, Short, Byte, String");
            }
        }
    }

    public SimpleSQLiteQuery(String str, Object[] objArr) {
        m.e(str, MBridgeConstans.DYNAMIC_VIEW_WX_QUERY);
        this.query = str;
        this.bindArgs = objArr;
    }

    @SuppressLint({"SyntheticAccessor"})
    public static final void bind(SupportSQLiteProgram supportSQLiteProgram, Object[] objArr) {
        Companion.bind(supportSQLiteProgram, objArr);
    }

    public void bindTo(SupportSQLiteProgram supportSQLiteProgram) {
        m.e(supportSQLiteProgram, "statement");
        Companion.bind(supportSQLiteProgram, this.bindArgs);
    }

    public int getArgCount() {
        Object[] objArr = this.bindArgs;
        if (objArr != null) {
            return objArr.length;
        }
        return 0;
    }

    public String getSql() {
        return this.query;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SimpleSQLiteQuery(String str) {
        this(str, (Object[]) null);
        m.e(str, MBridgeConstans.DYNAMIC_VIEW_WX_QUERY);
    }
}
