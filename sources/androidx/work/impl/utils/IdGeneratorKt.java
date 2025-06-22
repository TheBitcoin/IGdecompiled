package androidx.work.impl.utils;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.model.Preference;
import kotlin.jvm.internal.m;

public final class IdGeneratorKt {
    public static final int INITIAL_ID = 0;
    public static final String NEXT_ALARM_MANAGER_ID_KEY = "next_alarm_manager_id";
    public static final String NEXT_JOB_SCHEDULER_ID_KEY = "next_job_scheduler_id";
    public static final String PREFERENCE_FILE_KEY = "androidx.work.util.id";

    public static final void migrateLegacyIdGenerator(Context context, SupportSQLiteDatabase supportSQLiteDatabase) {
        m.e(context, "context");
        m.e(supportSQLiteDatabase, "sqLiteDatabase");
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFERENCE_FILE_KEY, 0);
        if (sharedPreferences.contains(NEXT_JOB_SCHEDULER_ID_KEY) || sharedPreferences.contains(NEXT_JOB_SCHEDULER_ID_KEY)) {
            int i4 = sharedPreferences.getInt(NEXT_JOB_SCHEDULER_ID_KEY, 0);
            int i5 = sharedPreferences.getInt(NEXT_ALARM_MANAGER_ID_KEY, 0);
            supportSQLiteDatabase.beginTransaction();
            try {
                supportSQLiteDatabase.execSQL(PreferenceUtils.INSERT_PREFERENCE, new Object[]{NEXT_JOB_SCHEDULER_ID_KEY, Integer.valueOf(i4)});
                supportSQLiteDatabase.execSQL(PreferenceUtils.INSERT_PREFERENCE, new Object[]{NEXT_ALARM_MANAGER_ID_KEY, Integer.valueOf(i5)});
                sharedPreferences.edit().clear().apply();
                supportSQLiteDatabase.setTransactionSuccessful();
            } finally {
                supportSQLiteDatabase.endTransaction();
            }
        }
    }

    /* access modifiers changed from: private */
    public static final int nextId(WorkDatabase workDatabase, String str) {
        int i4;
        Long longValue = workDatabase.preferenceDao().getLongValue(str);
        int i5 = 0;
        if (longValue != null) {
            i4 = (int) longValue.longValue();
        } else {
            i4 = 0;
        }
        if (i4 != Integer.MAX_VALUE) {
            i5 = i4 + 1;
        }
        updatePreference(workDatabase, str, i5);
        return i4;
    }

    /* access modifiers changed from: private */
    public static final void updatePreference(WorkDatabase workDatabase, String str, int i4) {
        workDatabase.preferenceDao().insertPreference(new Preference(str, Long.valueOf((long) i4)));
    }
}
