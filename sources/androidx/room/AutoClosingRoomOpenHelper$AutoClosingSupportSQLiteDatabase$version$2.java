package androidx.room;

import androidx.sqlite.db.SupportSQLiteDatabase;
import d3.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;

final class AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$version$2 extends n implements l {
    final /* synthetic */ int $version;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$version$2(int i4) {
        super(1);
        this.$version = i4;
    }

    public final Object invoke(SupportSQLiteDatabase supportSQLiteDatabase) {
        m.e(supportSQLiteDatabase, "db");
        supportSQLiteDatabase.setVersion(this.$version);
        return null;
    }
}
