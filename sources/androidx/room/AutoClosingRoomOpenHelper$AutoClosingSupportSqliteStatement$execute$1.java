package androidx.room;

import androidx.sqlite.db.SupportSQLiteStatement;
import d3.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;

final class AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$execute$1 extends n implements l {
    public static final AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$execute$1 INSTANCE = new AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$execute$1();

    AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$execute$1() {
        super(1);
    }

    public final Object invoke(SupportSQLiteStatement supportSQLiteStatement) {
        m.e(supportSQLiteStatement, "statement");
        supportSQLiteStatement.execute();
        return null;
    }
}
