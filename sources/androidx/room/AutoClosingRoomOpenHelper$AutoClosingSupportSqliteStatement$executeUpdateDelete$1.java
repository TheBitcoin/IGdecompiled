package androidx.room;

import androidx.sqlite.db.SupportSQLiteStatement;
import d3.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;

final class AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$executeUpdateDelete$1 extends n implements l {
    public static final AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$executeUpdateDelete$1 INSTANCE = new AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$executeUpdateDelete$1();

    AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$executeUpdateDelete$1() {
        super(1);
    }

    public final Integer invoke(SupportSQLiteStatement supportSQLiteStatement) {
        m.e(supportSQLiteStatement, "obj");
        return Integer.valueOf(supportSQLiteStatement.executeUpdateDelete());
    }
}
