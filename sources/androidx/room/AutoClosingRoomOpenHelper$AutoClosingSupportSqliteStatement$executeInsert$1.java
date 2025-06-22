package androidx.room;

import androidx.sqlite.db.SupportSQLiteStatement;
import d3.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;

final class AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$executeInsert$1 extends n implements l {
    public static final AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$executeInsert$1 INSTANCE = new AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$executeInsert$1();

    AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$executeInsert$1() {
        super(1);
    }

    public final Long invoke(SupportSQLiteStatement supportSQLiteStatement) {
        m.e(supportSQLiteStatement, "obj");
        return Long.valueOf(supportSQLiteStatement.executeInsert());
    }
}
