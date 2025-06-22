package androidx.room;

import androidx.sqlite.db.SupportSQLiteDatabase;
import d3.l;
import java.util.Locale;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;

final class AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$setLocale$1 extends n implements l {
    final /* synthetic */ Locale $locale;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$setLocale$1(Locale locale) {
        super(1);
        this.$locale = locale;
    }

    public final Object invoke(SupportSQLiteDatabase supportSQLiteDatabase) {
        m.e(supportSQLiteDatabase, "db");
        supportSQLiteDatabase.setLocale(this.$locale);
        return null;
    }
}
