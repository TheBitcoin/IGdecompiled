package androidx.room;

import androidx.sqlite.db.SupportSQLiteDatabase;
import d3.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;

final class AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$setMaximumSize$1 extends n implements l {
    final /* synthetic */ long $numBytes;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$setMaximumSize$1(long j4) {
        super(1);
        this.$numBytes = j4;
    }

    public final Long invoke(SupportSQLiteDatabase supportSQLiteDatabase) {
        m.e(supportSQLiteDatabase, "db");
        return Long.valueOf(supportSQLiteDatabase.setMaximumSize(this.$numBytes));
    }
}
