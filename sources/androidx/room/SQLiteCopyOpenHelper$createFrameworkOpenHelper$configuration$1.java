package androidx.room;

import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import kotlin.jvm.internal.m;

public final class SQLiteCopyOpenHelper$createFrameworkOpenHelper$configuration$1 extends SupportSQLiteOpenHelper.Callback {
    final /* synthetic */ int $version;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SQLiteCopyOpenHelper$createFrameworkOpenHelper$configuration$1(int i4, int i5) {
        super(i5);
        this.$version = i4;
    }

    public void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
        m.e(supportSQLiteDatabase, "db");
    }

    public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
        m.e(supportSQLiteDatabase, "db");
        int i4 = this.$version;
        if (i4 < 1) {
            supportSQLiteDatabase.setVersion(i4);
        }
    }

    public void onUpgrade(SupportSQLiteDatabase supportSQLiteDatabase, int i4, int i5) {
        m.e(supportSQLiteDatabase, "db");
    }
}
