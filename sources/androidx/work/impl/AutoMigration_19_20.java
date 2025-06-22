package androidx.work.impl;

import androidx.room.migration.AutoMigrationSpec;
import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.jvm.internal.m;

public final class AutoMigration_19_20 implements AutoMigrationSpec {
    public void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        m.e(supportSQLiteDatabase, "db");
        supportSQLiteDatabase.execSQL("UPDATE WorkSpec SET `last_enqueue_time` = -1 WHERE `last_enqueue_time` = 0");
    }
}
