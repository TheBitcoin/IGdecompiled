package androidx.room;

import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.jvm.internal.v;

/* synthetic */ class AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$maximumSize$1 extends v {
    public static final AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$maximumSize$1 INSTANCE = new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$maximumSize$1();

    AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$maximumSize$1() {
        super(SupportSQLiteDatabase.class, "maximumSize", "getMaximumSize()J", 0);
    }

    public Object get(Object obj) {
        return Long.valueOf(((SupportSQLiteDatabase) obj).getMaximumSize());
    }
}
