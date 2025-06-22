package androidx.work.impl;

import android.content.Context;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.work.impl.utils.PreferenceUtils;
import kotlin.jvm.internal.m;

public final class RescheduleMigration extends Migration {
    private final Context mContext;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RescheduleMigration(Context context, int i4, int i5) {
        super(i4, i5);
        m.e(context, "mContext");
        this.mContext = context;
    }

    public final Context getMContext() {
        return this.mContext;
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        m.e(supportSQLiteDatabase, "db");
        if (this.endVersion >= 10) {
            supportSQLiteDatabase.execSQL(PreferenceUtils.INSERT_PREFERENCE, new Object[]{PreferenceUtils.KEY_RESCHEDULE_NEEDED, 1});
            return;
        }
        this.mContext.getSharedPreferences(PreferenceUtils.PREFERENCES_FILE_NAME, 0).edit().putBoolean(PreferenceUtils.KEY_RESCHEDULE_NEEDED, true).apply();
    }
}
