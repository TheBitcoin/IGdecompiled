package androidx.room.migration;

import androidx.sqlite.db.SupportSQLiteDatabase;
import d3.l;
import kotlin.jvm.internal.m;

final class MigrationImpl extends Migration {
    private final l migrateCallback;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MigrationImpl(int i4, int i5, l lVar) {
        super(i4, i5);
        m.e(lVar, "migrateCallback");
        this.migrateCallback = lVar;
    }

    public final l getMigrateCallback() {
        return this.migrateCallback;
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        m.e(supportSQLiteDatabase, "database");
        this.migrateCallback.invoke(supportSQLiteDatabase);
    }
}
