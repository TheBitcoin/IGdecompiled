package androidx.room;

import androidx.sqlite.db.SupportSQLiteDatabase;
import d3.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;

final class AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$execSQL$2 extends n implements l {
    final /* synthetic */ Object[] $bindArgs;
    final /* synthetic */ String $sql;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$execSQL$2(String str, Object[] objArr) {
        super(1);
        this.$sql = str;
        this.$bindArgs = objArr;
    }

    public final Object invoke(SupportSQLiteDatabase supportSQLiteDatabase) {
        m.e(supportSQLiteDatabase, "db");
        supportSQLiteDatabase.execSQL(this.$sql, this.$bindArgs);
        return null;
    }
}
