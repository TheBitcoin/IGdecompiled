package androidx.room;

import androidx.sqlite.db.SupportSQLiteDatabase;
import d3.l;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.m;

/* synthetic */ class AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$yieldIfContendedSafely$1 extends k implements l {
    public static final AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$yieldIfContendedSafely$1 INSTANCE = new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$yieldIfContendedSafely$1();

    AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$yieldIfContendedSafely$1() {
        super(1, SupportSQLiteDatabase.class, "yieldIfContendedSafely", "yieldIfContendedSafely()Z", 0);
    }

    public final Boolean invoke(SupportSQLiteDatabase supportSQLiteDatabase) {
        m.e(supportSQLiteDatabase, "p0");
        return Boolean.valueOf(supportSQLiteDatabase.yieldIfContendedSafely());
    }
}
