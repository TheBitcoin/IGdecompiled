package androidx.work.impl.model;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.lifecycle.LiveData;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.NetworkType;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo;
import androidx.work.impl.model.WorkSpec;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import r3.C1035e;

public final class WorkSpecDao_Impl implements WorkSpecDao {
    /* access modifiers changed from: private */
    public final RoomDatabase __db;
    private final EntityInsertionAdapter<WorkSpec> __insertionAdapterOfWorkSpec;
    private final SharedSQLiteStatement __preparedStmtOfDelete;
    private final SharedSQLiteStatement __preparedStmtOfIncrementGeneration;
    private final SharedSQLiteStatement __preparedStmtOfIncrementPeriodCount;
    private final SharedSQLiteStatement __preparedStmtOfIncrementWorkSpecRunAttemptCount;
    private final SharedSQLiteStatement __preparedStmtOfMarkWorkSpecScheduled;
    private final SharedSQLiteStatement __preparedStmtOfPruneFinishedWorkWithZeroDependentsIgnoringKeepForAtLeast;
    private final SharedSQLiteStatement __preparedStmtOfResetScheduledState;
    private final SharedSQLiteStatement __preparedStmtOfResetWorkSpecNextScheduleTimeOverride;
    private final SharedSQLiteStatement __preparedStmtOfResetWorkSpecRunAttemptCount;
    private final SharedSQLiteStatement __preparedStmtOfSetCancelledState;
    private final SharedSQLiteStatement __preparedStmtOfSetLastEnqueueTime;
    private final SharedSQLiteStatement __preparedStmtOfSetNextScheduleTimeOverride;
    private final SharedSQLiteStatement __preparedStmtOfSetOutput;
    private final SharedSQLiteStatement __preparedStmtOfSetState;
    private final SharedSQLiteStatement __preparedStmtOfSetStopReason;
    private final EntityDeletionOrUpdateAdapter<WorkSpec> __updateAdapterOfWorkSpec;

    public WorkSpecDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfWorkSpec = new EntityInsertionAdapter<WorkSpec>(roomDatabase) {
            public String createQuery() {
                return "INSERT OR IGNORE INTO `WorkSpec` (`id`,`state`,`worker_class_name`,`input_merger_class_name`,`input`,`output`,`initial_delay`,`interval_duration`,`flex_duration`,`run_attempt_count`,`backoff_policy`,`backoff_delay_duration`,`last_enqueue_time`,`minimum_retention_duration`,`schedule_requested_at`,`run_in_foreground`,`out_of_quota_policy`,`period_count`,`generation`,`next_schedule_time_override`,`next_schedule_time_override_generation`,`stop_reason`,`required_network_type`,`requires_charging`,`requires_device_idle`,`requires_battery_not_low`,`requires_storage_not_low`,`trigger_content_update_delay`,`trigger_max_content_delay`,`content_uri_triggers`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, WorkSpec workSpec) {
                String str = workSpec.id;
                if (str == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, str);
                }
                WorkTypeConverters workTypeConverters = WorkTypeConverters.INSTANCE;
                supportSQLiteStatement.bindLong(2, (long) WorkTypeConverters.stateToInt(workSpec.state));
                String str2 = workSpec.workerClassName;
                if (str2 == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, str2);
                }
                String str3 = workSpec.inputMergerClassName;
                if (str3 == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, str3);
                }
                byte[] byteArrayInternal = Data.toByteArrayInternal(workSpec.input);
                if (byteArrayInternal == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindBlob(5, byteArrayInternal);
                }
                byte[] byteArrayInternal2 = Data.toByteArrayInternal(workSpec.output);
                if (byteArrayInternal2 == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindBlob(6, byteArrayInternal2);
                }
                supportSQLiteStatement.bindLong(7, workSpec.initialDelay);
                supportSQLiteStatement.bindLong(8, workSpec.intervalDuration);
                supportSQLiteStatement.bindLong(9, workSpec.flexDuration);
                supportSQLiteStatement.bindLong(10, (long) workSpec.runAttemptCount);
                supportSQLiteStatement.bindLong(11, (long) WorkTypeConverters.backoffPolicyToInt(workSpec.backoffPolicy));
                supportSQLiteStatement.bindLong(12, workSpec.backoffDelayDuration);
                supportSQLiteStatement.bindLong(13, workSpec.lastEnqueueTime);
                supportSQLiteStatement.bindLong(14, workSpec.minimumRetentionDuration);
                supportSQLiteStatement.bindLong(15, workSpec.scheduleRequestedAt);
                supportSQLiteStatement.bindLong(16, workSpec.expedited ? 1 : 0);
                supportSQLiteStatement.bindLong(17, (long) WorkTypeConverters.outOfQuotaPolicyToInt(workSpec.outOfQuotaPolicy));
                supportSQLiteStatement.bindLong(18, (long) workSpec.getPeriodCount());
                supportSQLiteStatement.bindLong(19, (long) workSpec.getGeneration());
                supportSQLiteStatement.bindLong(20, workSpec.getNextScheduleTimeOverride());
                supportSQLiteStatement.bindLong(21, (long) workSpec.getNextScheduleTimeOverrideGeneration());
                supportSQLiteStatement.bindLong(22, (long) workSpec.getStopReason());
                Constraints constraints = workSpec.constraints;
                if (constraints != null) {
                    supportSQLiteStatement.bindLong(23, (long) WorkTypeConverters.networkTypeToInt(constraints.getRequiredNetworkType()));
                    supportSQLiteStatement.bindLong(24, constraints.requiresCharging() ? 1 : 0);
                    supportSQLiteStatement.bindLong(25, constraints.requiresDeviceIdle() ? 1 : 0);
                    supportSQLiteStatement.bindLong(26, constraints.requiresBatteryNotLow() ? 1 : 0);
                    supportSQLiteStatement.bindLong(27, constraints.requiresStorageNotLow() ? 1 : 0);
                    supportSQLiteStatement.bindLong(28, constraints.getContentTriggerUpdateDelayMillis());
                    supportSQLiteStatement.bindLong(29, constraints.getContentTriggerMaxDelayMillis());
                    byte[] ofTriggersToByteArray = WorkTypeConverters.setOfTriggersToByteArray(constraints.getContentUriTriggers());
                    if (ofTriggersToByteArray == null) {
                        supportSQLiteStatement.bindNull(30);
                    } else {
                        supportSQLiteStatement.bindBlob(30, ofTriggersToByteArray);
                    }
                } else {
                    supportSQLiteStatement.bindNull(23);
                    supportSQLiteStatement.bindNull(24);
                    supportSQLiteStatement.bindNull(25);
                    supportSQLiteStatement.bindNull(26);
                    supportSQLiteStatement.bindNull(27);
                    supportSQLiteStatement.bindNull(28);
                    supportSQLiteStatement.bindNull(29);
                    supportSQLiteStatement.bindNull(30);
                }
            }
        };
        this.__updateAdapterOfWorkSpec = new EntityDeletionOrUpdateAdapter<WorkSpec>(roomDatabase) {
            public String createQuery() {
                return "UPDATE OR ABORT `WorkSpec` SET `id` = ?,`state` = ?,`worker_class_name` = ?,`input_merger_class_name` = ?,`input` = ?,`output` = ?,`initial_delay` = ?,`interval_duration` = ?,`flex_duration` = ?,`run_attempt_count` = ?,`backoff_policy` = ?,`backoff_delay_duration` = ?,`last_enqueue_time` = ?,`minimum_retention_duration` = ?,`schedule_requested_at` = ?,`run_in_foreground` = ?,`out_of_quota_policy` = ?,`period_count` = ?,`generation` = ?,`next_schedule_time_override` = ?,`next_schedule_time_override_generation` = ?,`stop_reason` = ?,`required_network_type` = ?,`requires_charging` = ?,`requires_device_idle` = ?,`requires_battery_not_low` = ?,`requires_storage_not_low` = ?,`trigger_content_update_delay` = ?,`trigger_max_content_delay` = ?,`content_uri_triggers` = ? WHERE `id` = ?";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, WorkSpec workSpec) {
                String str = workSpec.id;
                if (str == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, str);
                }
                WorkTypeConverters workTypeConverters = WorkTypeConverters.INSTANCE;
                supportSQLiteStatement.bindLong(2, (long) WorkTypeConverters.stateToInt(workSpec.state));
                String str2 = workSpec.workerClassName;
                if (str2 == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, str2);
                }
                String str3 = workSpec.inputMergerClassName;
                if (str3 == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, str3);
                }
                byte[] byteArrayInternal = Data.toByteArrayInternal(workSpec.input);
                if (byteArrayInternal == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindBlob(5, byteArrayInternal);
                }
                byte[] byteArrayInternal2 = Data.toByteArrayInternal(workSpec.output);
                if (byteArrayInternal2 == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindBlob(6, byteArrayInternal2);
                }
                supportSQLiteStatement.bindLong(7, workSpec.initialDelay);
                supportSQLiteStatement.bindLong(8, workSpec.intervalDuration);
                supportSQLiteStatement.bindLong(9, workSpec.flexDuration);
                supportSQLiteStatement.bindLong(10, (long) workSpec.runAttemptCount);
                supportSQLiteStatement.bindLong(11, (long) WorkTypeConverters.backoffPolicyToInt(workSpec.backoffPolicy));
                supportSQLiteStatement.bindLong(12, workSpec.backoffDelayDuration);
                supportSQLiteStatement.bindLong(13, workSpec.lastEnqueueTime);
                supportSQLiteStatement.bindLong(14, workSpec.minimumRetentionDuration);
                supportSQLiteStatement.bindLong(15, workSpec.scheduleRequestedAt);
                supportSQLiteStatement.bindLong(16, workSpec.expedited ? 1 : 0);
                supportSQLiteStatement.bindLong(17, (long) WorkTypeConverters.outOfQuotaPolicyToInt(workSpec.outOfQuotaPolicy));
                supportSQLiteStatement.bindLong(18, (long) workSpec.getPeriodCount());
                supportSQLiteStatement.bindLong(19, (long) workSpec.getGeneration());
                supportSQLiteStatement.bindLong(20, workSpec.getNextScheduleTimeOverride());
                supportSQLiteStatement.bindLong(21, (long) workSpec.getNextScheduleTimeOverrideGeneration());
                supportSQLiteStatement.bindLong(22, (long) workSpec.getStopReason());
                Constraints constraints = workSpec.constraints;
                if (constraints != null) {
                    supportSQLiteStatement.bindLong(23, (long) WorkTypeConverters.networkTypeToInt(constraints.getRequiredNetworkType()));
                    supportSQLiteStatement.bindLong(24, constraints.requiresCharging() ? 1 : 0);
                    supportSQLiteStatement.bindLong(25, constraints.requiresDeviceIdle() ? 1 : 0);
                    supportSQLiteStatement.bindLong(26, constraints.requiresBatteryNotLow() ? 1 : 0);
                    supportSQLiteStatement.bindLong(27, constraints.requiresStorageNotLow() ? 1 : 0);
                    supportSQLiteStatement.bindLong(28, constraints.getContentTriggerUpdateDelayMillis());
                    supportSQLiteStatement.bindLong(29, constraints.getContentTriggerMaxDelayMillis());
                    byte[] ofTriggersToByteArray = WorkTypeConverters.setOfTriggersToByteArray(constraints.getContentUriTriggers());
                    if (ofTriggersToByteArray == null) {
                        supportSQLiteStatement.bindNull(30);
                    } else {
                        supportSQLiteStatement.bindBlob(30, ofTriggersToByteArray);
                    }
                } else {
                    supportSQLiteStatement.bindNull(23);
                    supportSQLiteStatement.bindNull(24);
                    supportSQLiteStatement.bindNull(25);
                    supportSQLiteStatement.bindNull(26);
                    supportSQLiteStatement.bindNull(27);
                    supportSQLiteStatement.bindNull(28);
                    supportSQLiteStatement.bindNull(29);
                    supportSQLiteStatement.bindNull(30);
                }
                String str4 = workSpec.id;
                if (str4 == null) {
                    supportSQLiteStatement.bindNull(31);
                } else {
                    supportSQLiteStatement.bindString(31, str4);
                }
            }
        };
        this.__preparedStmtOfDelete = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM workspec WHERE id=?";
            }
        };
        this.__preparedStmtOfSetState = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "UPDATE workspec SET state=? WHERE id=?";
            }
        };
        this.__preparedStmtOfSetCancelledState = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "UPDATE workspec SET stop_reason = CASE WHEN state=1 THEN 1 ELSE -256 END, state=5 WHERE id=?";
            }
        };
        this.__preparedStmtOfIncrementPeriodCount = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "UPDATE workspec SET period_count=period_count+1 WHERE id=?";
            }
        };
        this.__preparedStmtOfSetOutput = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "UPDATE workspec SET output=? WHERE id=?";
            }
        };
        this.__preparedStmtOfSetLastEnqueueTime = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "UPDATE workspec SET last_enqueue_time=? WHERE id=?";
            }
        };
        this.__preparedStmtOfIncrementWorkSpecRunAttemptCount = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "UPDATE workspec SET run_attempt_count=run_attempt_count+1 WHERE id=?";
            }
        };
        this.__preparedStmtOfResetWorkSpecRunAttemptCount = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "UPDATE workspec SET run_attempt_count=0 WHERE id=?";
            }
        };
        this.__preparedStmtOfSetNextScheduleTimeOverride = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "UPDATE workspec SET next_schedule_time_override=? WHERE id=?";
            }
        };
        this.__preparedStmtOfResetWorkSpecNextScheduleTimeOverride = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "UPDATE workspec SET next_schedule_time_override=9223372036854775807 WHERE (id=? AND next_schedule_time_override_generation=?)";
            }
        };
        this.__preparedStmtOfMarkWorkSpecScheduled = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "UPDATE workspec SET schedule_requested_at=? WHERE id=?";
            }
        };
        this.__preparedStmtOfResetScheduledState = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "UPDATE workspec SET schedule_requested_at=-1 WHERE state NOT IN (2, 3, 5)";
            }
        };
        this.__preparedStmtOfPruneFinishedWorkWithZeroDependentsIgnoringKeepForAtLeast = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM workspec WHERE state IN (2, 3, 5) AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))";
            }
        };
        this.__preparedStmtOfIncrementGeneration = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "UPDATE workspec SET generation=generation+1 WHERE id=?";
            }
        };
        this.__preparedStmtOfSetStopReason = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "UPDATE workspec SET stop_reason=? WHERE id=?";
            }
        };
    }

    /* access modifiers changed from: private */
    public void __fetchRelationshipWorkProgressAsandroidxWorkData(HashMap<String, ArrayList<Data>> hashMap) {
        byte[] bArr;
        int i4;
        Set<String> keySet = hashMap.keySet();
        if (!keySet.isEmpty()) {
            if (hashMap.size() > 999) {
                HashMap hashMap2 = new HashMap(RoomDatabase.MAX_BIND_PARAMETER_CNT);
                loop0:
                while (true) {
                    i4 = 0;
                    for (String next : keySet) {
                        hashMap2.put(next, hashMap.get(next));
                        i4++;
                        if (i4 == 999) {
                            __fetchRelationshipWorkProgressAsandroidxWorkData(hashMap2);
                            hashMap2 = new HashMap(RoomDatabase.MAX_BIND_PARAMETER_CNT);
                        }
                    }
                    break loop0;
                }
                if (i4 > 0) {
                    __fetchRelationshipWorkProgressAsandroidxWorkData(hashMap2);
                    return;
                }
                return;
            }
            StringBuilder newStringBuilder = StringUtil.newStringBuilder();
            newStringBuilder.append("SELECT `progress`,`work_spec_id` FROM `WorkProgress` WHERE `work_spec_id` IN (");
            int size = keySet.size();
            StringUtil.appendPlaceholders(newStringBuilder, size);
            newStringBuilder.append(")");
            RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(newStringBuilder.toString(), size);
            int i5 = 1;
            for (String next2 : keySet) {
                if (next2 == null) {
                    acquire.bindNull(i5);
                } else {
                    acquire.bindString(i5, next2);
                }
                i5++;
            }
            Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
            try {
                int columnIndex = CursorUtil.getColumnIndex(query, "work_spec_id");
                if (columnIndex != -1) {
                    while (query.moveToNext()) {
                        ArrayList arrayList = hashMap.get(query.getString(columnIndex));
                        if (arrayList != null) {
                            if (query.isNull(0)) {
                                bArr = null;
                            } else {
                                bArr = query.getBlob(0);
                            }
                            arrayList.add(Data.fromByteArray(bArr));
                        }
                    }
                    query.close();
                }
            } finally {
                query.close();
            }
        }
    }

    /* access modifiers changed from: private */
    public void __fetchRelationshipWorkTagAsjavaLangString(HashMap<String, ArrayList<String>> hashMap) {
        String str;
        int i4;
        Set<String> keySet = hashMap.keySet();
        if (!keySet.isEmpty()) {
            if (hashMap.size() > 999) {
                HashMap hashMap2 = new HashMap(RoomDatabase.MAX_BIND_PARAMETER_CNT);
                loop0:
                while (true) {
                    i4 = 0;
                    for (String next : keySet) {
                        hashMap2.put(next, hashMap.get(next));
                        i4++;
                        if (i4 == 999) {
                            __fetchRelationshipWorkTagAsjavaLangString(hashMap2);
                            hashMap2 = new HashMap(RoomDatabase.MAX_BIND_PARAMETER_CNT);
                        }
                    }
                    break loop0;
                }
                if (i4 > 0) {
                    __fetchRelationshipWorkTagAsjavaLangString(hashMap2);
                    return;
                }
                return;
            }
            StringBuilder newStringBuilder = StringUtil.newStringBuilder();
            newStringBuilder.append("SELECT `tag`,`work_spec_id` FROM `WorkTag` WHERE `work_spec_id` IN (");
            int size = keySet.size();
            StringUtil.appendPlaceholders(newStringBuilder, size);
            newStringBuilder.append(")");
            RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(newStringBuilder.toString(), size);
            int i5 = 1;
            for (String next2 : keySet) {
                if (next2 == null) {
                    acquire.bindNull(i5);
                } else {
                    acquire.bindString(i5, next2);
                }
                i5++;
            }
            Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
            try {
                int columnIndex = CursorUtil.getColumnIndex(query, "work_spec_id");
                if (columnIndex != -1) {
                    while (query.moveToNext()) {
                        ArrayList arrayList = hashMap.get(query.getString(columnIndex));
                        if (arrayList != null) {
                            if (query.isNull(0)) {
                                str = null;
                            } else {
                                str = query.getString(0);
                            }
                            arrayList.add(str);
                        }
                    }
                    query.close();
                }
            } finally {
                query.close();
            }
        }
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.EMPTY_LIST;
    }

    public int countNonFinishedContentUriTriggerWorkers() {
        int i4 = 0;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("Select COUNT(*) FROM workspec WHERE LENGTH(content_uri_triggers)<>0 AND state NOT IN (2, 3, 5)", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            if (query.moveToFirst()) {
                i4 = query.getInt(0);
            }
            return i4;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public void delete(String str) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfDelete.acquire();
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDelete.release(acquire);
        }
    }

    public List<WorkSpec> getAllEligibleWorkSpecsForScheduling(int i4) {
        RoomSQLiteQuery roomSQLiteQuery;
        String str;
        String str2;
        String str3;
        byte[] bArr;
        byte[] bArr2;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        byte[] bArr3;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM workspec WHERE state=0 ORDER BY last_enqueue_time LIMIT ?", 1);
        acquire.bindLong(1, (long) i4);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, MRAIDCommunicatorUtil.KEY_STATE);
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "worker_class_name");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "input_merger_class_name");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "input");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "output");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "initial_delay");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "interval_duration");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "flex_duration");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "run_attempt_count");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "backoff_policy");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "backoff_delay_duration");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "last_enqueue_time");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "minimum_retention_duration");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "schedule_requested_at");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "run_in_foreground");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "out_of_quota_policy");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "period_count");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "generation");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "next_schedule_time_override");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "next_schedule_time_override_generation");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "stop_reason");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "required_network_type");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "requires_charging");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "requires_device_idle");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "requires_battery_not_low");
                int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, "requires_storage_not_low");
                int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(query, "trigger_content_update_delay");
                int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(query, "trigger_max_content_delay");
                int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(query, "content_uri_triggers");
                int i5 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    if (query.isNull(columnIndexOrThrow)) {
                        str = null;
                    } else {
                        str = query.getString(columnIndexOrThrow);
                    }
                    WorkInfo.State intToState = WorkTypeConverters.intToState(query.getInt(columnIndexOrThrow2));
                    if (query.isNull(columnIndexOrThrow3)) {
                        str2 = null;
                    } else {
                        str2 = query.getString(columnIndexOrThrow3);
                    }
                    if (query.isNull(columnIndexOrThrow4)) {
                        str3 = null;
                    } else {
                        str3 = query.getString(columnIndexOrThrow4);
                    }
                    if (query.isNull(columnIndexOrThrow5)) {
                        bArr = null;
                    } else {
                        bArr = query.getBlob(columnIndexOrThrow5);
                    }
                    Data fromByteArray = Data.fromByteArray(bArr);
                    if (query.isNull(columnIndexOrThrow6)) {
                        bArr2 = null;
                    } else {
                        bArr2 = query.getBlob(columnIndexOrThrow6);
                    }
                    Data fromByteArray2 = Data.fromByteArray(bArr2);
                    long j4 = query.getLong(columnIndexOrThrow7);
                    long j5 = query.getLong(columnIndexOrThrow8);
                    long j6 = query.getLong(columnIndexOrThrow9);
                    int i6 = query.getInt(columnIndexOrThrow10);
                    BackoffPolicy intToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy(query.getInt(columnIndexOrThrow11));
                    long j7 = query.getLong(columnIndexOrThrow12);
                    long j8 = query.getLong(columnIndexOrThrow13);
                    int i7 = i5;
                    long j9 = query.getLong(i7);
                    int i8 = columnIndexOrThrow;
                    int i9 = columnIndexOrThrow15;
                    long j10 = query.getLong(i9);
                    columnIndexOrThrow15 = i9;
                    int i10 = columnIndexOrThrow16;
                    if (query.getInt(i10) != 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    columnIndexOrThrow16 = i10;
                    int i11 = columnIndexOrThrow17;
                    OutOfQuotaPolicy intToOutOfQuotaPolicy = WorkTypeConverters.intToOutOfQuotaPolicy(query.getInt(i11));
                    columnIndexOrThrow17 = i11;
                    int i12 = columnIndexOrThrow18;
                    int i13 = query.getInt(i12);
                    columnIndexOrThrow18 = i12;
                    int i14 = columnIndexOrThrow19;
                    int i15 = query.getInt(i14);
                    columnIndexOrThrow19 = i14;
                    int i16 = columnIndexOrThrow20;
                    long j11 = query.getLong(i16);
                    columnIndexOrThrow20 = i16;
                    int i17 = columnIndexOrThrow21;
                    int i18 = query.getInt(i17);
                    columnIndexOrThrow21 = i17;
                    int i19 = columnIndexOrThrow22;
                    int i20 = query.getInt(i19);
                    columnIndexOrThrow22 = i19;
                    int i21 = columnIndexOrThrow23;
                    NetworkType intToNetworkType = WorkTypeConverters.intToNetworkType(query.getInt(i21));
                    columnIndexOrThrow23 = i21;
                    int i22 = columnIndexOrThrow24;
                    if (query.getInt(i22) != 0) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    columnIndexOrThrow24 = i22;
                    int i23 = columnIndexOrThrow25;
                    if (query.getInt(i23) != 0) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    columnIndexOrThrow25 = i23;
                    int i24 = columnIndexOrThrow26;
                    if (query.getInt(i24) != 0) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    columnIndexOrThrow26 = i24;
                    int i25 = columnIndexOrThrow27;
                    if (query.getInt(i25) != 0) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    columnIndexOrThrow27 = i25;
                    int i26 = columnIndexOrThrow28;
                    long j12 = query.getLong(i26);
                    columnIndexOrThrow28 = i26;
                    int i27 = columnIndexOrThrow29;
                    long j13 = query.getLong(i27);
                    columnIndexOrThrow29 = i27;
                    int i28 = columnIndexOrThrow30;
                    if (query.isNull(i28)) {
                        bArr3 = null;
                    } else {
                        bArr3 = query.getBlob(i28);
                    }
                    columnIndexOrThrow30 = i28;
                    arrayList.add(new WorkSpec(str, intToState, str2, str3, fromByteArray, fromByteArray2, j4, j5, j6, new Constraints(intToNetworkType, z5, z6, z7, z8, j12, j13, WorkTypeConverters.byteArrayToSetOfTriggers(bArr3)), i6, intToBackoffPolicy, j7, j8, j9, j10, z4, intToOutOfQuotaPolicy, i13, i15, j11, i18, i20));
                    columnIndexOrThrow = i8;
                    i5 = i7;
                }
                query.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = acquire;
            query.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    public List<String> getAllUnfinishedWork() {
        String str;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5)", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                if (query.isNull(0)) {
                    str = null;
                } else {
                    str = query.getString(0);
                }
                arrayList.add(str);
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public List<String> getAllWorkSpecIds() {
        String str;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT id FROM workspec", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                if (query.isNull(0)) {
                    str = null;
                } else {
                    str = query.getString(0);
                }
                arrayList.add(str);
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public LiveData<List<String>> getAllWorkSpecIdsLiveData() {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT id FROM workspec", 0);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"workspec"}, true, new Callable<List<String>>() {
            /* access modifiers changed from: protected */
            public void finalize() {
                acquire.release();
            }

            public List<String> call() throws Exception {
                Cursor query;
                String str;
                WorkSpecDao_Impl.this.__db.beginTransaction();
                try {
                    query = DBUtil.query(WorkSpecDao_Impl.this.__db, acquire, false, (CancellationSignal) null);
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        if (query.isNull(0)) {
                            str = null;
                        } else {
                            str = query.getString(0);
                        }
                        arrayList.add(str);
                    }
                    WorkSpecDao_Impl.this.__db.setTransactionSuccessful();
                    query.close();
                    WorkSpecDao_Impl.this.__db.endTransaction();
                    return arrayList;
                } catch (Throwable th) {
                    WorkSpecDao_Impl.this.__db.endTransaction();
                    throw th;
                }
            }
        });
    }

    public List<WorkSpec> getEligibleWorkForScheduling(int i4) {
        RoomSQLiteQuery roomSQLiteQuery;
        String str;
        String str2;
        String str3;
        byte[] bArr;
        byte[] bArr2;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        byte[] bArr3;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM workspec WHERE state=0 AND schedule_requested_at=-1 ORDER BY last_enqueue_time LIMIT (SELECT MAX(?-COUNT(*), 0) FROM workspec WHERE schedule_requested_at<>-1 AND LENGTH(content_uri_triggers)=0 AND state NOT IN (2, 3, 5))", 1);
        acquire.bindLong(1, (long) i4);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, MRAIDCommunicatorUtil.KEY_STATE);
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "worker_class_name");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "input_merger_class_name");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "input");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "output");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "initial_delay");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "interval_duration");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "flex_duration");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "run_attempt_count");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "backoff_policy");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "backoff_delay_duration");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "last_enqueue_time");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "minimum_retention_duration");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "schedule_requested_at");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "run_in_foreground");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "out_of_quota_policy");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "period_count");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "generation");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "next_schedule_time_override");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "next_schedule_time_override_generation");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "stop_reason");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "required_network_type");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "requires_charging");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "requires_device_idle");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "requires_battery_not_low");
                int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, "requires_storage_not_low");
                int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(query, "trigger_content_update_delay");
                int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(query, "trigger_max_content_delay");
                int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(query, "content_uri_triggers");
                int i5 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    if (query.isNull(columnIndexOrThrow)) {
                        str = null;
                    } else {
                        str = query.getString(columnIndexOrThrow);
                    }
                    WorkInfo.State intToState = WorkTypeConverters.intToState(query.getInt(columnIndexOrThrow2));
                    if (query.isNull(columnIndexOrThrow3)) {
                        str2 = null;
                    } else {
                        str2 = query.getString(columnIndexOrThrow3);
                    }
                    if (query.isNull(columnIndexOrThrow4)) {
                        str3 = null;
                    } else {
                        str3 = query.getString(columnIndexOrThrow4);
                    }
                    if (query.isNull(columnIndexOrThrow5)) {
                        bArr = null;
                    } else {
                        bArr = query.getBlob(columnIndexOrThrow5);
                    }
                    Data fromByteArray = Data.fromByteArray(bArr);
                    if (query.isNull(columnIndexOrThrow6)) {
                        bArr2 = null;
                    } else {
                        bArr2 = query.getBlob(columnIndexOrThrow6);
                    }
                    Data fromByteArray2 = Data.fromByteArray(bArr2);
                    long j4 = query.getLong(columnIndexOrThrow7);
                    long j5 = query.getLong(columnIndexOrThrow8);
                    long j6 = query.getLong(columnIndexOrThrow9);
                    int i6 = query.getInt(columnIndexOrThrow10);
                    BackoffPolicy intToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy(query.getInt(columnIndexOrThrow11));
                    long j7 = query.getLong(columnIndexOrThrow12);
                    long j8 = query.getLong(columnIndexOrThrow13);
                    int i7 = i5;
                    long j9 = query.getLong(i7);
                    int i8 = columnIndexOrThrow;
                    int i9 = columnIndexOrThrow15;
                    long j10 = query.getLong(i9);
                    columnIndexOrThrow15 = i9;
                    int i10 = columnIndexOrThrow16;
                    if (query.getInt(i10) != 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    columnIndexOrThrow16 = i10;
                    int i11 = columnIndexOrThrow17;
                    OutOfQuotaPolicy intToOutOfQuotaPolicy = WorkTypeConverters.intToOutOfQuotaPolicy(query.getInt(i11));
                    columnIndexOrThrow17 = i11;
                    int i12 = columnIndexOrThrow18;
                    int i13 = query.getInt(i12);
                    columnIndexOrThrow18 = i12;
                    int i14 = columnIndexOrThrow19;
                    int i15 = query.getInt(i14);
                    columnIndexOrThrow19 = i14;
                    int i16 = columnIndexOrThrow20;
                    long j11 = query.getLong(i16);
                    columnIndexOrThrow20 = i16;
                    int i17 = columnIndexOrThrow21;
                    int i18 = query.getInt(i17);
                    columnIndexOrThrow21 = i17;
                    int i19 = columnIndexOrThrow22;
                    int i20 = query.getInt(i19);
                    columnIndexOrThrow22 = i19;
                    int i21 = columnIndexOrThrow23;
                    NetworkType intToNetworkType = WorkTypeConverters.intToNetworkType(query.getInt(i21));
                    columnIndexOrThrow23 = i21;
                    int i22 = columnIndexOrThrow24;
                    if (query.getInt(i22) != 0) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    columnIndexOrThrow24 = i22;
                    int i23 = columnIndexOrThrow25;
                    if (query.getInt(i23) != 0) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    columnIndexOrThrow25 = i23;
                    int i24 = columnIndexOrThrow26;
                    if (query.getInt(i24) != 0) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    columnIndexOrThrow26 = i24;
                    int i25 = columnIndexOrThrow27;
                    if (query.getInt(i25) != 0) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    columnIndexOrThrow27 = i25;
                    int i26 = columnIndexOrThrow28;
                    long j12 = query.getLong(i26);
                    columnIndexOrThrow28 = i26;
                    int i27 = columnIndexOrThrow29;
                    long j13 = query.getLong(i27);
                    columnIndexOrThrow29 = i27;
                    int i28 = columnIndexOrThrow30;
                    if (query.isNull(i28)) {
                        bArr3 = null;
                    } else {
                        bArr3 = query.getBlob(i28);
                    }
                    columnIndexOrThrow30 = i28;
                    arrayList.add(new WorkSpec(str, intToState, str2, str3, fromByteArray, fromByteArray2, j4, j5, j6, new Constraints(intToNetworkType, z5, z6, z7, z8, j12, j13, WorkTypeConverters.byteArrayToSetOfTriggers(bArr3)), i6, intToBackoffPolicy, j7, j8, j9, j10, z4, intToOutOfQuotaPolicy, i13, i15, j11, i18, i20));
                    columnIndexOrThrow = i8;
                    i5 = i7;
                }
                query.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = acquire;
            query.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    public List<WorkSpec> getEligibleWorkForSchedulingWithContentUris() {
        RoomSQLiteQuery roomSQLiteQuery;
        String str;
        String str2;
        String str3;
        byte[] bArr;
        byte[] bArr2;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        byte[] bArr3;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM workspec WHERE state=0 AND schedule_requested_at=-1 AND LENGTH(content_uri_triggers)<>0 ORDER BY last_enqueue_time", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, MRAIDCommunicatorUtil.KEY_STATE);
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "worker_class_name");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "input_merger_class_name");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "input");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "output");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "initial_delay");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "interval_duration");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "flex_duration");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "run_attempt_count");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "backoff_policy");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "backoff_delay_duration");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "last_enqueue_time");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "minimum_retention_duration");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "schedule_requested_at");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "run_in_foreground");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "out_of_quota_policy");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "period_count");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "generation");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "next_schedule_time_override");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "next_schedule_time_override_generation");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "stop_reason");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "required_network_type");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "requires_charging");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "requires_device_idle");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "requires_battery_not_low");
                int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, "requires_storage_not_low");
                int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(query, "trigger_content_update_delay");
                int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(query, "trigger_max_content_delay");
                int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(query, "content_uri_triggers");
                int i4 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    if (query.isNull(columnIndexOrThrow)) {
                        str = null;
                    } else {
                        str = query.getString(columnIndexOrThrow);
                    }
                    WorkInfo.State intToState = WorkTypeConverters.intToState(query.getInt(columnIndexOrThrow2));
                    if (query.isNull(columnIndexOrThrow3)) {
                        str2 = null;
                    } else {
                        str2 = query.getString(columnIndexOrThrow3);
                    }
                    if (query.isNull(columnIndexOrThrow4)) {
                        str3 = null;
                    } else {
                        str3 = query.getString(columnIndexOrThrow4);
                    }
                    if (query.isNull(columnIndexOrThrow5)) {
                        bArr = null;
                    } else {
                        bArr = query.getBlob(columnIndexOrThrow5);
                    }
                    Data fromByteArray = Data.fromByteArray(bArr);
                    if (query.isNull(columnIndexOrThrow6)) {
                        bArr2 = null;
                    } else {
                        bArr2 = query.getBlob(columnIndexOrThrow6);
                    }
                    Data fromByteArray2 = Data.fromByteArray(bArr2);
                    long j4 = query.getLong(columnIndexOrThrow7);
                    long j5 = query.getLong(columnIndexOrThrow8);
                    long j6 = query.getLong(columnIndexOrThrow9);
                    int i5 = query.getInt(columnIndexOrThrow10);
                    BackoffPolicy intToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy(query.getInt(columnIndexOrThrow11));
                    long j7 = query.getLong(columnIndexOrThrow12);
                    long j8 = query.getLong(columnIndexOrThrow13);
                    int i6 = i4;
                    long j9 = query.getLong(i6);
                    int i7 = columnIndexOrThrow;
                    int i8 = columnIndexOrThrow15;
                    long j10 = query.getLong(i8);
                    columnIndexOrThrow15 = i8;
                    int i9 = columnIndexOrThrow16;
                    if (query.getInt(i9) != 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    columnIndexOrThrow16 = i9;
                    int i10 = columnIndexOrThrow17;
                    OutOfQuotaPolicy intToOutOfQuotaPolicy = WorkTypeConverters.intToOutOfQuotaPolicy(query.getInt(i10));
                    columnIndexOrThrow17 = i10;
                    int i11 = columnIndexOrThrow18;
                    int i12 = query.getInt(i11);
                    columnIndexOrThrow18 = i11;
                    int i13 = columnIndexOrThrow19;
                    int i14 = query.getInt(i13);
                    columnIndexOrThrow19 = i13;
                    int i15 = columnIndexOrThrow20;
                    long j11 = query.getLong(i15);
                    columnIndexOrThrow20 = i15;
                    int i16 = columnIndexOrThrow21;
                    int i17 = query.getInt(i16);
                    columnIndexOrThrow21 = i16;
                    int i18 = columnIndexOrThrow22;
                    int i19 = query.getInt(i18);
                    columnIndexOrThrow22 = i18;
                    int i20 = columnIndexOrThrow23;
                    NetworkType intToNetworkType = WorkTypeConverters.intToNetworkType(query.getInt(i20));
                    columnIndexOrThrow23 = i20;
                    int i21 = columnIndexOrThrow24;
                    if (query.getInt(i21) != 0) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    columnIndexOrThrow24 = i21;
                    int i22 = columnIndexOrThrow25;
                    if (query.getInt(i22) != 0) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    columnIndexOrThrow25 = i22;
                    int i23 = columnIndexOrThrow26;
                    if (query.getInt(i23) != 0) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    columnIndexOrThrow26 = i23;
                    int i24 = columnIndexOrThrow27;
                    if (query.getInt(i24) != 0) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    columnIndexOrThrow27 = i24;
                    int i25 = columnIndexOrThrow28;
                    long j12 = query.getLong(i25);
                    columnIndexOrThrow28 = i25;
                    int i26 = columnIndexOrThrow29;
                    long j13 = query.getLong(i26);
                    columnIndexOrThrow29 = i26;
                    int i27 = columnIndexOrThrow30;
                    if (query.isNull(i27)) {
                        bArr3 = null;
                    } else {
                        bArr3 = query.getBlob(i27);
                    }
                    columnIndexOrThrow30 = i27;
                    arrayList.add(new WorkSpec(str, intToState, str2, str3, fromByteArray, fromByteArray2, j4, j5, j6, new Constraints(intToNetworkType, z5, z6, z7, z8, j12, j13, WorkTypeConverters.byteArrayToSetOfTriggers(bArr3)), i5, intToBackoffPolicy, j7, j8, j9, j10, z4, intToOutOfQuotaPolicy, i12, i14, j11, i17, i19));
                    columnIndexOrThrow = i7;
                    i4 = i6;
                }
                query.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = acquire;
            query.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    public List<Data> getInputsFromPrerequisites(String str) {
        byte[] bArr;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT output FROM workspec WHERE id IN\n             (SELECT prerequisite_id FROM dependency WHERE work_spec_id=?)", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                if (query.isNull(0)) {
                    bArr = null;
                } else {
                    bArr = query.getBlob(0);
                }
                arrayList.add(Data.fromByteArray(bArr));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public List<WorkSpec> getRecentlyCompletedWork(long j4) {
        RoomSQLiteQuery roomSQLiteQuery;
        String str;
        String str2;
        String str3;
        byte[] bArr;
        byte[] bArr2;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        byte[] bArr3;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM workspec WHERE last_enqueue_time >= ? AND state IN (2, 3, 5) ORDER BY last_enqueue_time DESC", 1);
        acquire.bindLong(1, j4);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, MRAIDCommunicatorUtil.KEY_STATE);
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "worker_class_name");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "input_merger_class_name");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "input");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "output");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "initial_delay");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "interval_duration");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "flex_duration");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "run_attempt_count");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "backoff_policy");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "backoff_delay_duration");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "last_enqueue_time");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "minimum_retention_duration");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "schedule_requested_at");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "run_in_foreground");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "out_of_quota_policy");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "period_count");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "generation");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "next_schedule_time_override");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "next_schedule_time_override_generation");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "stop_reason");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "required_network_type");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "requires_charging");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "requires_device_idle");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "requires_battery_not_low");
                int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, "requires_storage_not_low");
                int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(query, "trigger_content_update_delay");
                int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(query, "trigger_max_content_delay");
                int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(query, "content_uri_triggers");
                int i4 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    if (query.isNull(columnIndexOrThrow)) {
                        str = null;
                    } else {
                        str = query.getString(columnIndexOrThrow);
                    }
                    WorkInfo.State intToState = WorkTypeConverters.intToState(query.getInt(columnIndexOrThrow2));
                    if (query.isNull(columnIndexOrThrow3)) {
                        str2 = null;
                    } else {
                        str2 = query.getString(columnIndexOrThrow3);
                    }
                    if (query.isNull(columnIndexOrThrow4)) {
                        str3 = null;
                    } else {
                        str3 = query.getString(columnIndexOrThrow4);
                    }
                    if (query.isNull(columnIndexOrThrow5)) {
                        bArr = null;
                    } else {
                        bArr = query.getBlob(columnIndexOrThrow5);
                    }
                    Data fromByteArray = Data.fromByteArray(bArr);
                    if (query.isNull(columnIndexOrThrow6)) {
                        bArr2 = null;
                    } else {
                        bArr2 = query.getBlob(columnIndexOrThrow6);
                    }
                    Data fromByteArray2 = Data.fromByteArray(bArr2);
                    long j5 = query.getLong(columnIndexOrThrow7);
                    long j6 = query.getLong(columnIndexOrThrow8);
                    long j7 = query.getLong(columnIndexOrThrow9);
                    int i5 = query.getInt(columnIndexOrThrow10);
                    BackoffPolicy intToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy(query.getInt(columnIndexOrThrow11));
                    long j8 = query.getLong(columnIndexOrThrow12);
                    long j9 = query.getLong(columnIndexOrThrow13);
                    int i6 = i4;
                    long j10 = query.getLong(i6);
                    int i7 = columnIndexOrThrow;
                    int i8 = columnIndexOrThrow15;
                    long j11 = query.getLong(i8);
                    columnIndexOrThrow15 = i8;
                    int i9 = columnIndexOrThrow16;
                    if (query.getInt(i9) != 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    columnIndexOrThrow16 = i9;
                    int i10 = columnIndexOrThrow17;
                    OutOfQuotaPolicy intToOutOfQuotaPolicy = WorkTypeConverters.intToOutOfQuotaPolicy(query.getInt(i10));
                    columnIndexOrThrow17 = i10;
                    int i11 = columnIndexOrThrow18;
                    int i12 = query.getInt(i11);
                    columnIndexOrThrow18 = i11;
                    int i13 = columnIndexOrThrow19;
                    int i14 = query.getInt(i13);
                    columnIndexOrThrow19 = i13;
                    int i15 = columnIndexOrThrow20;
                    long j12 = query.getLong(i15);
                    columnIndexOrThrow20 = i15;
                    int i16 = columnIndexOrThrow21;
                    int i17 = query.getInt(i16);
                    columnIndexOrThrow21 = i16;
                    int i18 = columnIndexOrThrow22;
                    int i19 = query.getInt(i18);
                    columnIndexOrThrow22 = i18;
                    int i20 = columnIndexOrThrow23;
                    NetworkType intToNetworkType = WorkTypeConverters.intToNetworkType(query.getInt(i20));
                    columnIndexOrThrow23 = i20;
                    int i21 = columnIndexOrThrow24;
                    if (query.getInt(i21) != 0) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    columnIndexOrThrow24 = i21;
                    int i22 = columnIndexOrThrow25;
                    if (query.getInt(i22) != 0) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    columnIndexOrThrow25 = i22;
                    int i23 = columnIndexOrThrow26;
                    if (query.getInt(i23) != 0) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    columnIndexOrThrow26 = i23;
                    int i24 = columnIndexOrThrow27;
                    if (query.getInt(i24) != 0) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    columnIndexOrThrow27 = i24;
                    int i25 = columnIndexOrThrow28;
                    long j13 = query.getLong(i25);
                    columnIndexOrThrow28 = i25;
                    int i26 = columnIndexOrThrow29;
                    long j14 = query.getLong(i26);
                    columnIndexOrThrow29 = i26;
                    int i27 = columnIndexOrThrow30;
                    if (query.isNull(i27)) {
                        bArr3 = null;
                    } else {
                        bArr3 = query.getBlob(i27);
                    }
                    columnIndexOrThrow30 = i27;
                    arrayList.add(new WorkSpec(str, intToState, str2, str3, fromByteArray, fromByteArray2, j5, j6, j7, new Constraints(intToNetworkType, z5, z6, z7, z8, j13, j14, WorkTypeConverters.byteArrayToSetOfTriggers(bArr3)), i5, intToBackoffPolicy, j8, j9, j10, j11, z4, intToOutOfQuotaPolicy, i12, i14, j12, i17, i19));
                    columnIndexOrThrow = i7;
                    i4 = i6;
                }
                query.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = acquire;
            query.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    public List<WorkSpec> getRunningWork() {
        RoomSQLiteQuery roomSQLiteQuery;
        String str;
        String str2;
        String str3;
        byte[] bArr;
        byte[] bArr2;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        byte[] bArr3;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM workspec WHERE state=1", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, MRAIDCommunicatorUtil.KEY_STATE);
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "worker_class_name");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "input_merger_class_name");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "input");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "output");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "initial_delay");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "interval_duration");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "flex_duration");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "run_attempt_count");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "backoff_policy");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "backoff_delay_duration");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "last_enqueue_time");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "minimum_retention_duration");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "schedule_requested_at");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "run_in_foreground");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "out_of_quota_policy");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "period_count");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "generation");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "next_schedule_time_override");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "next_schedule_time_override_generation");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "stop_reason");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "required_network_type");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "requires_charging");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "requires_device_idle");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "requires_battery_not_low");
                int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, "requires_storage_not_low");
                int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(query, "trigger_content_update_delay");
                int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(query, "trigger_max_content_delay");
                int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(query, "content_uri_triggers");
                int i4 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    if (query.isNull(columnIndexOrThrow)) {
                        str = null;
                    } else {
                        str = query.getString(columnIndexOrThrow);
                    }
                    WorkInfo.State intToState = WorkTypeConverters.intToState(query.getInt(columnIndexOrThrow2));
                    if (query.isNull(columnIndexOrThrow3)) {
                        str2 = null;
                    } else {
                        str2 = query.getString(columnIndexOrThrow3);
                    }
                    if (query.isNull(columnIndexOrThrow4)) {
                        str3 = null;
                    } else {
                        str3 = query.getString(columnIndexOrThrow4);
                    }
                    if (query.isNull(columnIndexOrThrow5)) {
                        bArr = null;
                    } else {
                        bArr = query.getBlob(columnIndexOrThrow5);
                    }
                    Data fromByteArray = Data.fromByteArray(bArr);
                    if (query.isNull(columnIndexOrThrow6)) {
                        bArr2 = null;
                    } else {
                        bArr2 = query.getBlob(columnIndexOrThrow6);
                    }
                    Data fromByteArray2 = Data.fromByteArray(bArr2);
                    long j4 = query.getLong(columnIndexOrThrow7);
                    long j5 = query.getLong(columnIndexOrThrow8);
                    long j6 = query.getLong(columnIndexOrThrow9);
                    int i5 = query.getInt(columnIndexOrThrow10);
                    BackoffPolicy intToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy(query.getInt(columnIndexOrThrow11));
                    long j7 = query.getLong(columnIndexOrThrow12);
                    long j8 = query.getLong(columnIndexOrThrow13);
                    int i6 = i4;
                    long j9 = query.getLong(i6);
                    int i7 = columnIndexOrThrow;
                    int i8 = columnIndexOrThrow15;
                    long j10 = query.getLong(i8);
                    columnIndexOrThrow15 = i8;
                    int i9 = columnIndexOrThrow16;
                    if (query.getInt(i9) != 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    columnIndexOrThrow16 = i9;
                    int i10 = columnIndexOrThrow17;
                    OutOfQuotaPolicy intToOutOfQuotaPolicy = WorkTypeConverters.intToOutOfQuotaPolicy(query.getInt(i10));
                    columnIndexOrThrow17 = i10;
                    int i11 = columnIndexOrThrow18;
                    int i12 = query.getInt(i11);
                    columnIndexOrThrow18 = i11;
                    int i13 = columnIndexOrThrow19;
                    int i14 = query.getInt(i13);
                    columnIndexOrThrow19 = i13;
                    int i15 = columnIndexOrThrow20;
                    long j11 = query.getLong(i15);
                    columnIndexOrThrow20 = i15;
                    int i16 = columnIndexOrThrow21;
                    int i17 = query.getInt(i16);
                    columnIndexOrThrow21 = i16;
                    int i18 = columnIndexOrThrow22;
                    int i19 = query.getInt(i18);
                    columnIndexOrThrow22 = i18;
                    int i20 = columnIndexOrThrow23;
                    NetworkType intToNetworkType = WorkTypeConverters.intToNetworkType(query.getInt(i20));
                    columnIndexOrThrow23 = i20;
                    int i21 = columnIndexOrThrow24;
                    if (query.getInt(i21) != 0) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    columnIndexOrThrow24 = i21;
                    int i22 = columnIndexOrThrow25;
                    if (query.getInt(i22) != 0) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    columnIndexOrThrow25 = i22;
                    int i23 = columnIndexOrThrow26;
                    if (query.getInt(i23) != 0) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    columnIndexOrThrow26 = i23;
                    int i24 = columnIndexOrThrow27;
                    if (query.getInt(i24) != 0) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    columnIndexOrThrow27 = i24;
                    int i25 = columnIndexOrThrow28;
                    long j12 = query.getLong(i25);
                    columnIndexOrThrow28 = i25;
                    int i26 = columnIndexOrThrow29;
                    long j13 = query.getLong(i26);
                    columnIndexOrThrow29 = i26;
                    int i27 = columnIndexOrThrow30;
                    if (query.isNull(i27)) {
                        bArr3 = null;
                    } else {
                        bArr3 = query.getBlob(i27);
                    }
                    columnIndexOrThrow30 = i27;
                    arrayList.add(new WorkSpec(str, intToState, str2, str3, fromByteArray, fromByteArray2, j4, j5, j6, new Constraints(intToNetworkType, z5, z6, z7, z8, j12, j13, WorkTypeConverters.byteArrayToSetOfTriggers(bArr3)), i5, intToBackoffPolicy, j7, j8, j9, j10, z4, intToOutOfQuotaPolicy, i12, i14, j11, i17, i19));
                    columnIndexOrThrow = i7;
                    i4 = i6;
                }
                query.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = acquire;
            query.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    public LiveData<Long> getScheduleRequestedAtLiveData(String str) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT schedule_requested_at FROM workspec WHERE id=?", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"workspec"}, false, new Callable<Long>() {
            /* access modifiers changed from: protected */
            public void finalize() {
                acquire.release();
            }

            public Long call() throws Exception {
                Cursor query = DBUtil.query(WorkSpecDao_Impl.this.__db, acquire, false, (CancellationSignal) null);
                try {
                    Long valueOf = Long.valueOf(query.moveToFirst() ? query.getLong(0) : 0);
                    query.close();
                    return valueOf;
                } catch (Throwable th) {
                    query.close();
                    throw th;
                }
            }
        });
    }

    public List<WorkSpec> getScheduledWork() {
        RoomSQLiteQuery roomSQLiteQuery;
        String str;
        String str2;
        String str3;
        byte[] bArr;
        byte[] bArr2;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        byte[] bArr3;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM workspec WHERE state=0 AND schedule_requested_at<>-1", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, MRAIDCommunicatorUtil.KEY_STATE);
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "worker_class_name");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "input_merger_class_name");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "input");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "output");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "initial_delay");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "interval_duration");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "flex_duration");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "run_attempt_count");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "backoff_policy");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "backoff_delay_duration");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "last_enqueue_time");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "minimum_retention_duration");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "schedule_requested_at");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "run_in_foreground");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "out_of_quota_policy");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "period_count");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "generation");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "next_schedule_time_override");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "next_schedule_time_override_generation");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "stop_reason");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "required_network_type");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "requires_charging");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "requires_device_idle");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "requires_battery_not_low");
                int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, "requires_storage_not_low");
                int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(query, "trigger_content_update_delay");
                int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(query, "trigger_max_content_delay");
                int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(query, "content_uri_triggers");
                int i4 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    if (query.isNull(columnIndexOrThrow)) {
                        str = null;
                    } else {
                        str = query.getString(columnIndexOrThrow);
                    }
                    WorkInfo.State intToState = WorkTypeConverters.intToState(query.getInt(columnIndexOrThrow2));
                    if (query.isNull(columnIndexOrThrow3)) {
                        str2 = null;
                    } else {
                        str2 = query.getString(columnIndexOrThrow3);
                    }
                    if (query.isNull(columnIndexOrThrow4)) {
                        str3 = null;
                    } else {
                        str3 = query.getString(columnIndexOrThrow4);
                    }
                    if (query.isNull(columnIndexOrThrow5)) {
                        bArr = null;
                    } else {
                        bArr = query.getBlob(columnIndexOrThrow5);
                    }
                    Data fromByteArray = Data.fromByteArray(bArr);
                    if (query.isNull(columnIndexOrThrow6)) {
                        bArr2 = null;
                    } else {
                        bArr2 = query.getBlob(columnIndexOrThrow6);
                    }
                    Data fromByteArray2 = Data.fromByteArray(bArr2);
                    long j4 = query.getLong(columnIndexOrThrow7);
                    long j5 = query.getLong(columnIndexOrThrow8);
                    long j6 = query.getLong(columnIndexOrThrow9);
                    int i5 = query.getInt(columnIndexOrThrow10);
                    BackoffPolicy intToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy(query.getInt(columnIndexOrThrow11));
                    long j7 = query.getLong(columnIndexOrThrow12);
                    long j8 = query.getLong(columnIndexOrThrow13);
                    int i6 = i4;
                    long j9 = query.getLong(i6);
                    int i7 = columnIndexOrThrow;
                    int i8 = columnIndexOrThrow15;
                    long j10 = query.getLong(i8);
                    columnIndexOrThrow15 = i8;
                    int i9 = columnIndexOrThrow16;
                    if (query.getInt(i9) != 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    columnIndexOrThrow16 = i9;
                    int i10 = columnIndexOrThrow17;
                    OutOfQuotaPolicy intToOutOfQuotaPolicy = WorkTypeConverters.intToOutOfQuotaPolicy(query.getInt(i10));
                    columnIndexOrThrow17 = i10;
                    int i11 = columnIndexOrThrow18;
                    int i12 = query.getInt(i11);
                    columnIndexOrThrow18 = i11;
                    int i13 = columnIndexOrThrow19;
                    int i14 = query.getInt(i13);
                    columnIndexOrThrow19 = i13;
                    int i15 = columnIndexOrThrow20;
                    long j11 = query.getLong(i15);
                    columnIndexOrThrow20 = i15;
                    int i16 = columnIndexOrThrow21;
                    int i17 = query.getInt(i16);
                    columnIndexOrThrow21 = i16;
                    int i18 = columnIndexOrThrow22;
                    int i19 = query.getInt(i18);
                    columnIndexOrThrow22 = i18;
                    int i20 = columnIndexOrThrow23;
                    NetworkType intToNetworkType = WorkTypeConverters.intToNetworkType(query.getInt(i20));
                    columnIndexOrThrow23 = i20;
                    int i21 = columnIndexOrThrow24;
                    if (query.getInt(i21) != 0) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    columnIndexOrThrow24 = i21;
                    int i22 = columnIndexOrThrow25;
                    if (query.getInt(i22) != 0) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    columnIndexOrThrow25 = i22;
                    int i23 = columnIndexOrThrow26;
                    if (query.getInt(i23) != 0) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    columnIndexOrThrow26 = i23;
                    int i24 = columnIndexOrThrow27;
                    if (query.getInt(i24) != 0) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    columnIndexOrThrow27 = i24;
                    int i25 = columnIndexOrThrow28;
                    long j12 = query.getLong(i25);
                    columnIndexOrThrow28 = i25;
                    int i26 = columnIndexOrThrow29;
                    long j13 = query.getLong(i26);
                    columnIndexOrThrow29 = i26;
                    int i27 = columnIndexOrThrow30;
                    if (query.isNull(i27)) {
                        bArr3 = null;
                    } else {
                        bArr3 = query.getBlob(i27);
                    }
                    columnIndexOrThrow30 = i27;
                    arrayList.add(new WorkSpec(str, intToState, str2, str3, fromByteArray, fromByteArray2, j4, j5, j6, new Constraints(intToNetworkType, z5, z6, z7, z8, j12, j13, WorkTypeConverters.byteArrayToSetOfTriggers(bArr3)), i5, intToBackoffPolicy, j7, j8, j9, j10, z4, intToOutOfQuotaPolicy, i12, i14, j11, i17, i19));
                    columnIndexOrThrow = i7;
                    i4 = i6;
                }
                query.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = acquire;
            query.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    public WorkInfo.State getState(String str) {
        Integer num;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT state FROM workspec WHERE id=?", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        WorkInfo.State state = null;
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            if (query.moveToFirst()) {
                if (query.isNull(0)) {
                    num = null;
                } else {
                    num = Integer.valueOf(query.getInt(0));
                }
                if (num != null) {
                    WorkTypeConverters workTypeConverters = WorkTypeConverters.INSTANCE;
                    state = WorkTypeConverters.intToState(num.intValue());
                }
            }
            return state;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public List<String> getUnfinishedWorkWithName(String str) {
        String str2;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                if (query.isNull(0)) {
                    str2 = null;
                } else {
                    str2 = query.getString(0);
                }
                arrayList.add(str2);
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public List<String> getUnfinishedWorkWithTag(String str) {
        String str2;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM worktag WHERE tag=?)", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                if (query.isNull(0)) {
                    str2 = null;
                } else {
                    str2 = query.getString(0);
                }
                arrayList.add(str2);
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public WorkSpec getWorkSpec(String str) {
        RoomSQLiteQuery roomSQLiteQuery;
        WorkSpec workSpec;
        String str2;
        String str3;
        String str4;
        byte[] bArr;
        byte[] bArr2;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        byte[] bArr3;
        String str5 = str;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM workspec WHERE id=?", 1);
        if (str5 == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str5);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, MRAIDCommunicatorUtil.KEY_STATE);
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "worker_class_name");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "input_merger_class_name");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "input");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "output");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "initial_delay");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "interval_duration");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "flex_duration");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "run_attempt_count");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "backoff_policy");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "backoff_delay_duration");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "last_enqueue_time");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "minimum_retention_duration");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "schedule_requested_at");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "run_in_foreground");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "out_of_quota_policy");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "period_count");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "generation");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "next_schedule_time_override");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "next_schedule_time_override_generation");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "stop_reason");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "required_network_type");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "requires_charging");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "requires_device_idle");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "requires_battery_not_low");
                int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, "requires_storage_not_low");
                int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(query, "trigger_content_update_delay");
                int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(query, "trigger_max_content_delay");
                int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(query, "content_uri_triggers");
                if (query.moveToFirst()) {
                    if (query.isNull(columnIndexOrThrow)) {
                        str2 = null;
                    } else {
                        str2 = query.getString(columnIndexOrThrow);
                    }
                    WorkInfo.State intToState = WorkTypeConverters.intToState(query.getInt(columnIndexOrThrow2));
                    if (query.isNull(columnIndexOrThrow3)) {
                        str3 = null;
                    } else {
                        str3 = query.getString(columnIndexOrThrow3);
                    }
                    if (query.isNull(columnIndexOrThrow4)) {
                        str4 = null;
                    } else {
                        str4 = query.getString(columnIndexOrThrow4);
                    }
                    if (query.isNull(columnIndexOrThrow5)) {
                        bArr = null;
                    } else {
                        bArr = query.getBlob(columnIndexOrThrow5);
                    }
                    Data fromByteArray = Data.fromByteArray(bArr);
                    if (query.isNull(columnIndexOrThrow6)) {
                        bArr2 = null;
                    } else {
                        bArr2 = query.getBlob(columnIndexOrThrow6);
                    }
                    Data fromByteArray2 = Data.fromByteArray(bArr2);
                    long j4 = query.getLong(columnIndexOrThrow7);
                    long j5 = query.getLong(columnIndexOrThrow8);
                    long j6 = query.getLong(columnIndexOrThrow9);
                    int i4 = query.getInt(columnIndexOrThrow10);
                    BackoffPolicy intToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy(query.getInt(columnIndexOrThrow11));
                    long j7 = query.getLong(columnIndexOrThrow12);
                    long j8 = query.getLong(columnIndexOrThrow13);
                    long j9 = query.getLong(columnIndexOrThrow14);
                    long j10 = query.getLong(columnIndexOrThrow15);
                    if (query.getInt(columnIndexOrThrow16) != 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    OutOfQuotaPolicy intToOutOfQuotaPolicy = WorkTypeConverters.intToOutOfQuotaPolicy(query.getInt(columnIndexOrThrow17));
                    int i5 = query.getInt(columnIndexOrThrow18);
                    int i6 = query.getInt(columnIndexOrThrow19);
                    long j11 = query.getLong(columnIndexOrThrow20);
                    int i7 = query.getInt(columnIndexOrThrow21);
                    int i8 = query.getInt(columnIndexOrThrow22);
                    NetworkType intToNetworkType = WorkTypeConverters.intToNetworkType(query.getInt(columnIndexOrThrow23));
                    if (query.getInt(columnIndexOrThrow24) != 0) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (query.getInt(columnIndexOrThrow25) != 0) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    if (query.getInt(columnIndexOrThrow26) != 0) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    if (query.getInt(columnIndexOrThrow27) != 0) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    long j12 = query.getLong(columnIndexOrThrow28);
                    long j13 = query.getLong(columnIndexOrThrow29);
                    if (query.isNull(columnIndexOrThrow30)) {
                        bArr3 = null;
                    } else {
                        bArr3 = query.getBlob(columnIndexOrThrow30);
                    }
                    workSpec = new WorkSpec(str2, intToState, str3, str4, fromByteArray, fromByteArray2, j4, j5, j6, new Constraints(intToNetworkType, z5, z6, z7, z8, j12, j13, WorkTypeConverters.byteArrayToSetOfTriggers(bArr3)), i4, intToBackoffPolicy, j7, j8, j9, j10, z4, intToOutOfQuotaPolicy, i5, i6, j11, i7, i8);
                } else {
                    workSpec = null;
                }
                query.close();
                roomSQLiteQuery.release();
                return workSpec;
            } catch (Throwable th) {
                th = th;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = acquire;
            query.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    public List<WorkSpec.IdAndState> getWorkSpecIdAndStatesForName(String str) {
        String str2;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT id, state FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                if (query.isNull(0)) {
                    str2 = null;
                } else {
                    str2 = query.getString(0);
                }
                arrayList.add(new WorkSpec.IdAndState(str2, WorkTypeConverters.intToState(query.getInt(1))));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public C1035e getWorkStatusPojoFlowDataForIds(List<String> list) {
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("SELECT id, state, output, run_attempt_count, generation, required_network_type, requires_charging,requires_device_idle, requires_battery_not_low, requires_storage_not_low, trigger_content_update_delay, trigger_max_content_delay, content_uri_triggers, initial_delay, interval_duration, flex_duration, backoff_policy, backoff_delay_duration, last_enqueue_time, period_count, next_schedule_time_override, stop_reason FROM workspec WHERE id IN (");
        int size = list.size();
        StringUtil.appendPlaceholders(newStringBuilder, size);
        newStringBuilder.append(")");
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(newStringBuilder.toString(), size);
        int i4 = 1;
        for (String next : list) {
            if (next == null) {
                acquire.bindNull(i4);
            } else {
                acquire.bindString(i4, next);
            }
            i4++;
        }
        return CoroutinesRoom.createFlow(this.__db, true, new String[]{"WorkTag", "WorkProgress", "workspec"}, new Callable<List<WorkSpec.WorkInfoPojo>>() {
            /* access modifiers changed from: protected */
            public void finalize() {
                acquire.release();
            }

            public List<WorkSpec.WorkInfoPojo> call() throws Exception {
                Cursor query;
                String str;
                byte[] bArr;
                byte[] bArr2;
                WorkSpecDao_Impl.this.__db.beginTransaction();
                try {
                    query = DBUtil.query(WorkSpecDao_Impl.this.__db, acquire, true, (CancellationSignal) null);
                    HashMap hashMap = new HashMap();
                    HashMap hashMap2 = new HashMap();
                    while (query.moveToNext()) {
                        String string = query.getString(0);
                        if (((ArrayList) hashMap.get(string)) == null) {
                            hashMap.put(string, new ArrayList());
                        }
                        String string2 = query.getString(0);
                        if (((ArrayList) hashMap2.get(string2)) == null) {
                            hashMap2.put(string2, new ArrayList());
                        }
                    }
                    query.moveToPosition(-1);
                    WorkSpecDao_Impl.this.__fetchRelationshipWorkTagAsjavaLangString(hashMap);
                    WorkSpecDao_Impl.this.__fetchRelationshipWorkProgressAsandroidxWorkData(hashMap2);
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        if (query.isNull(0)) {
                            str = null;
                        } else {
                            str = query.getString(0);
                        }
                        WorkInfo.State intToState = WorkTypeConverters.intToState(query.getInt(1));
                        if (query.isNull(2)) {
                            bArr = null;
                        } else {
                            bArr = query.getBlob(2);
                        }
                        Data fromByteArray = Data.fromByteArray(bArr);
                        int i4 = query.getInt(3);
                        int i5 = query.getInt(4);
                        long j4 = query.getLong(13);
                        long j5 = query.getLong(14);
                        long j6 = query.getLong(15);
                        BackoffPolicy intToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy(query.getInt(16));
                        long j7 = query.getLong(17);
                        long j8 = query.getLong(18);
                        int i6 = query.getInt(19);
                        long j9 = query.getLong(20);
                        int i7 = query.getInt(21);
                        NetworkType intToNetworkType = WorkTypeConverters.intToNetworkType(query.getInt(5));
                        boolean z4 = query.getInt(6) != 0;
                        boolean z5 = query.getInt(7) != 0;
                        boolean z6 = query.getInt(8) != 0;
                        boolean z7 = query.getInt(9) != 0;
                        long j10 = query.getLong(10);
                        long j11 = query.getLong(11);
                        if (query.isNull(12)) {
                            bArr2 = null;
                        } else {
                            bArr2 = query.getBlob(12);
                        }
                        Constraints constraints = new Constraints(intToNetworkType, z4, z5, z6, z7, j10, j11, WorkTypeConverters.byteArrayToSetOfTriggers(bArr2));
                        ArrayList arrayList2 = (ArrayList) hashMap.get(query.getString(0));
                        if (arrayList2 == null) {
                            arrayList2 = new ArrayList();
                        }
                        ArrayList arrayList3 = (ArrayList) hashMap2.get(query.getString(0));
                        if (arrayList3 == null) {
                            arrayList3 = new ArrayList();
                        }
                        arrayList.add(new WorkSpec.WorkInfoPojo(str, intToState, fromByteArray, j4, j5, j6, constraints, i4, intToBackoffPolicy, j7, j8, i6, i5, j9, i7, arrayList2, arrayList3));
                    }
                    WorkSpecDao_Impl.this.__db.setTransactionSuccessful();
                    query.close();
                    WorkSpecDao_Impl.this.__db.endTransaction();
                    return arrayList;
                } catch (Throwable th) {
                    WorkSpecDao_Impl.this.__db.endTransaction();
                    throw th;
                }
            }
        });
    }

    public C1035e getWorkStatusPojoFlowForName(String str) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT id, state, output, run_attempt_count, generation, required_network_type, requires_charging,requires_device_idle, requires_battery_not_low, requires_storage_not_low, trigger_content_update_delay, trigger_max_content_delay, content_uri_triggers, initial_delay, interval_duration, flex_duration, backoff_policy, backoff_delay_duration, last_enqueue_time, period_count, next_schedule_time_override, stop_reason FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        return CoroutinesRoom.createFlow(this.__db, true, new String[]{"WorkTag", "WorkProgress", "workspec", "workname"}, new Callable<List<WorkSpec.WorkInfoPojo>>() {
            /* access modifiers changed from: protected */
            public void finalize() {
                acquire.release();
            }

            public List<WorkSpec.WorkInfoPojo> call() throws Exception {
                Cursor query;
                String str;
                byte[] bArr;
                byte[] bArr2;
                WorkSpecDao_Impl.this.__db.beginTransaction();
                try {
                    query = DBUtil.query(WorkSpecDao_Impl.this.__db, acquire, true, (CancellationSignal) null);
                    HashMap hashMap = new HashMap();
                    HashMap hashMap2 = new HashMap();
                    while (query.moveToNext()) {
                        String string = query.getString(0);
                        if (((ArrayList) hashMap.get(string)) == null) {
                            hashMap.put(string, new ArrayList());
                        }
                        String string2 = query.getString(0);
                        if (((ArrayList) hashMap2.get(string2)) == null) {
                            hashMap2.put(string2, new ArrayList());
                        }
                    }
                    query.moveToPosition(-1);
                    WorkSpecDao_Impl.this.__fetchRelationshipWorkTagAsjavaLangString(hashMap);
                    WorkSpecDao_Impl.this.__fetchRelationshipWorkProgressAsandroidxWorkData(hashMap2);
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        if (query.isNull(0)) {
                            str = null;
                        } else {
                            str = query.getString(0);
                        }
                        WorkInfo.State intToState = WorkTypeConverters.intToState(query.getInt(1));
                        if (query.isNull(2)) {
                            bArr = null;
                        } else {
                            bArr = query.getBlob(2);
                        }
                        Data fromByteArray = Data.fromByteArray(bArr);
                        int i4 = query.getInt(3);
                        int i5 = query.getInt(4);
                        long j4 = query.getLong(13);
                        long j5 = query.getLong(14);
                        long j6 = query.getLong(15);
                        BackoffPolicy intToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy(query.getInt(16));
                        long j7 = query.getLong(17);
                        long j8 = query.getLong(18);
                        int i6 = query.getInt(19);
                        long j9 = query.getLong(20);
                        int i7 = query.getInt(21);
                        NetworkType intToNetworkType = WorkTypeConverters.intToNetworkType(query.getInt(5));
                        boolean z4 = query.getInt(6) != 0;
                        boolean z5 = query.getInt(7) != 0;
                        boolean z6 = query.getInt(8) != 0;
                        boolean z7 = query.getInt(9) != 0;
                        long j10 = query.getLong(10);
                        long j11 = query.getLong(11);
                        if (query.isNull(12)) {
                            bArr2 = null;
                        } else {
                            bArr2 = query.getBlob(12);
                        }
                        Constraints constraints = new Constraints(intToNetworkType, z4, z5, z6, z7, j10, j11, WorkTypeConverters.byteArrayToSetOfTriggers(bArr2));
                        ArrayList arrayList2 = (ArrayList) hashMap.get(query.getString(0));
                        if (arrayList2 == null) {
                            arrayList2 = new ArrayList();
                        }
                        ArrayList arrayList3 = (ArrayList) hashMap2.get(query.getString(0));
                        if (arrayList3 == null) {
                            arrayList3 = new ArrayList();
                        }
                        arrayList.add(new WorkSpec.WorkInfoPojo(str, intToState, fromByteArray, j4, j5, j6, constraints, i4, intToBackoffPolicy, j7, j8, i6, i5, j9, i7, arrayList2, arrayList3));
                    }
                    WorkSpecDao_Impl.this.__db.setTransactionSuccessful();
                    query.close();
                    WorkSpecDao_Impl.this.__db.endTransaction();
                    return arrayList;
                } catch (Throwable th) {
                    WorkSpecDao_Impl.this.__db.endTransaction();
                    throw th;
                }
            }
        });
    }

    public C1035e getWorkStatusPojoFlowForTag(String str) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT id, state, output, run_attempt_count, generation, required_network_type, requires_charging,requires_device_idle, requires_battery_not_low, requires_storage_not_low, trigger_content_update_delay, trigger_max_content_delay, content_uri_triggers, initial_delay, interval_duration, flex_duration, backoff_policy, backoff_delay_duration, last_enqueue_time, period_count, next_schedule_time_override, stop_reason FROM workspec WHERE id IN\n            (SELECT work_spec_id FROM worktag WHERE tag=?)", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        return CoroutinesRoom.createFlow(this.__db, true, new String[]{"WorkTag", "WorkProgress", "workspec", "worktag"}, new Callable<List<WorkSpec.WorkInfoPojo>>() {
            /* access modifiers changed from: protected */
            public void finalize() {
                acquire.release();
            }

            public List<WorkSpec.WorkInfoPojo> call() throws Exception {
                Cursor query;
                String str;
                byte[] bArr;
                byte[] bArr2;
                WorkSpecDao_Impl.this.__db.beginTransaction();
                try {
                    query = DBUtil.query(WorkSpecDao_Impl.this.__db, acquire, true, (CancellationSignal) null);
                    HashMap hashMap = new HashMap();
                    HashMap hashMap2 = new HashMap();
                    while (query.moveToNext()) {
                        String string = query.getString(0);
                        if (((ArrayList) hashMap.get(string)) == null) {
                            hashMap.put(string, new ArrayList());
                        }
                        String string2 = query.getString(0);
                        if (((ArrayList) hashMap2.get(string2)) == null) {
                            hashMap2.put(string2, new ArrayList());
                        }
                    }
                    query.moveToPosition(-1);
                    WorkSpecDao_Impl.this.__fetchRelationshipWorkTagAsjavaLangString(hashMap);
                    WorkSpecDao_Impl.this.__fetchRelationshipWorkProgressAsandroidxWorkData(hashMap2);
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        if (query.isNull(0)) {
                            str = null;
                        } else {
                            str = query.getString(0);
                        }
                        WorkInfo.State intToState = WorkTypeConverters.intToState(query.getInt(1));
                        if (query.isNull(2)) {
                            bArr = null;
                        } else {
                            bArr = query.getBlob(2);
                        }
                        Data fromByteArray = Data.fromByteArray(bArr);
                        int i4 = query.getInt(3);
                        int i5 = query.getInt(4);
                        long j4 = query.getLong(13);
                        long j5 = query.getLong(14);
                        long j6 = query.getLong(15);
                        BackoffPolicy intToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy(query.getInt(16));
                        long j7 = query.getLong(17);
                        long j8 = query.getLong(18);
                        int i6 = query.getInt(19);
                        long j9 = query.getLong(20);
                        int i7 = query.getInt(21);
                        NetworkType intToNetworkType = WorkTypeConverters.intToNetworkType(query.getInt(5));
                        boolean z4 = query.getInt(6) != 0;
                        boolean z5 = query.getInt(7) != 0;
                        boolean z6 = query.getInt(8) != 0;
                        boolean z7 = query.getInt(9) != 0;
                        long j10 = query.getLong(10);
                        long j11 = query.getLong(11);
                        if (query.isNull(12)) {
                            bArr2 = null;
                        } else {
                            bArr2 = query.getBlob(12);
                        }
                        Constraints constraints = new Constraints(intToNetworkType, z4, z5, z6, z7, j10, j11, WorkTypeConverters.byteArrayToSetOfTriggers(bArr2));
                        ArrayList arrayList2 = (ArrayList) hashMap.get(query.getString(0));
                        if (arrayList2 == null) {
                            arrayList2 = new ArrayList();
                        }
                        ArrayList arrayList3 = (ArrayList) hashMap2.get(query.getString(0));
                        if (arrayList3 == null) {
                            arrayList3 = new ArrayList();
                        }
                        arrayList.add(new WorkSpec.WorkInfoPojo(str, intToState, fromByteArray, j4, j5, j6, constraints, i4, intToBackoffPolicy, j7, j8, i6, i5, j9, i7, arrayList2, arrayList3));
                    }
                    WorkSpecDao_Impl.this.__db.setTransactionSuccessful();
                    query.close();
                    WorkSpecDao_Impl.this.__db.endTransaction();
                    return arrayList;
                } catch (Throwable th) {
                    WorkSpecDao_Impl.this.__db.endTransaction();
                    throw th;
                }
            }
        });
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: androidx.work.impl.model.WorkSpec$WorkInfoPojo} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: byte[]} */
    /* JADX WARNING: type inference failed for: r4v0 */
    /* JADX WARNING: type inference failed for: r4v3 */
    /* JADX WARNING: type inference failed for: r4v5 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.work.impl.model.WorkSpec.WorkInfoPojo getWorkStatusPojoForId(java.lang.String r43) {
        /*
            r42 = this;
            r1 = r42
            r0 = r43
            java.lang.String r2 = "SELECT id, state, output, run_attempt_count, generation, required_network_type, requires_charging,requires_device_idle, requires_battery_not_low, requires_storage_not_low, trigger_content_update_delay, trigger_max_content_delay, content_uri_triggers, initial_delay, interval_duration, flex_duration, backoff_policy, backoff_delay_duration, last_enqueue_time, period_count, next_schedule_time_override, stop_reason FROM workspec WHERE id=?"
            r3 = 1
            androidx.room.RoomSQLiteQuery r2 = androidx.room.RoomSQLiteQuery.acquire(r2, r3)
            if (r0 != 0) goto L_0x0011
            r2.bindNull(r3)
            goto L_0x0014
        L_0x0011:
            r2.bindString(r3, r0)
        L_0x0014:
            androidx.room.RoomDatabase r0 = r1.__db
            r0.assertNotSuspendingTransaction()
            androidx.room.RoomDatabase r0 = r1.__db
            r0.beginTransaction()
            androidx.room.RoomDatabase r0 = r1.__db     // Catch:{ all -> 0x0179 }
            r4 = 0
            android.database.Cursor r5 = androidx.room.util.DBUtil.query(r0, r2, r3, r4)     // Catch:{ all -> 0x0179 }
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ all -> 0x004b }
            r0.<init>()     // Catch:{ all -> 0x004b }
            java.util.HashMap r6 = new java.util.HashMap     // Catch:{ all -> 0x004b }
            r6.<init>()     // Catch:{ all -> 0x004b }
        L_0x002f:
            boolean r7 = r5.moveToNext()     // Catch:{ all -> 0x004b }
            r8 = 0
            if (r7 == 0) goto L_0x0063
            java.lang.String r7 = r5.getString(r8)     // Catch:{ all -> 0x004b }
            java.lang.Object r9 = r0.get(r7)     // Catch:{ all -> 0x004b }
            java.util.ArrayList r9 = (java.util.ArrayList) r9     // Catch:{ all -> 0x004b }
            if (r9 != 0) goto L_0x004e
            java.util.ArrayList r9 = new java.util.ArrayList     // Catch:{ all -> 0x004b }
            r9.<init>()     // Catch:{ all -> 0x004b }
            r0.put(r7, r9)     // Catch:{ all -> 0x004b }
            goto L_0x004e
        L_0x004b:
            r0 = move-exception
            goto L_0x017b
        L_0x004e:
            java.lang.String r7 = r5.getString(r8)     // Catch:{ all -> 0x004b }
            java.lang.Object r8 = r6.get(r7)     // Catch:{ all -> 0x004b }
            java.util.ArrayList r8 = (java.util.ArrayList) r8     // Catch:{ all -> 0x004b }
            if (r8 != 0) goto L_0x002f
            java.util.ArrayList r8 = new java.util.ArrayList     // Catch:{ all -> 0x004b }
            r8.<init>()     // Catch:{ all -> 0x004b }
            r6.put(r7, r8)     // Catch:{ all -> 0x004b }
            goto L_0x002f
        L_0x0063:
            r7 = -1
            r5.moveToPosition(r7)     // Catch:{ all -> 0x004b }
            r1.__fetchRelationshipWorkTagAsjavaLangString(r0)     // Catch:{ all -> 0x004b }
            r1.__fetchRelationshipWorkProgressAsandroidxWorkData(r6)     // Catch:{ all -> 0x004b }
            boolean r7 = r5.moveToFirst()     // Catch:{ all -> 0x004b }
            if (r7 == 0) goto L_0x0168
            boolean r7 = r5.isNull(r8)     // Catch:{ all -> 0x004b }
            if (r7 == 0) goto L_0x007b
            r10 = r4
            goto L_0x0080
        L_0x007b:
            java.lang.String r7 = r5.getString(r8)     // Catch:{ all -> 0x004b }
            r10 = r7
        L_0x0080:
            int r7 = r5.getInt(r3)     // Catch:{ all -> 0x004b }
            androidx.work.WorkInfo$State r11 = androidx.work.impl.model.WorkTypeConverters.intToState(r7)     // Catch:{ all -> 0x004b }
            r7 = 2
            boolean r9 = r5.isNull(r7)     // Catch:{ all -> 0x004b }
            if (r9 == 0) goto L_0x0091
            r7 = r4
            goto L_0x0095
        L_0x0091:
            byte[] r7 = r5.getBlob(r7)     // Catch:{ all -> 0x004b }
        L_0x0095:
            androidx.work.Data r12 = androidx.work.Data.fromByteArray(r7)     // Catch:{ all -> 0x004b }
            r7 = 3
            int r20 = r5.getInt(r7)     // Catch:{ all -> 0x004b }
            r7 = 4
            int r27 = r5.getInt(r7)     // Catch:{ all -> 0x004b }
            r7 = 13
            long r13 = r5.getLong(r7)     // Catch:{ all -> 0x004b }
            r7 = 14
            long r15 = r5.getLong(r7)     // Catch:{ all -> 0x004b }
            r7 = 15
            long r17 = r5.getLong(r7)     // Catch:{ all -> 0x004b }
            r7 = 16
            int r7 = r5.getInt(r7)     // Catch:{ all -> 0x004b }
            androidx.work.BackoffPolicy r21 = androidx.work.impl.model.WorkTypeConverters.intToBackoffPolicy(r7)     // Catch:{ all -> 0x004b }
            r7 = 17
            long r22 = r5.getLong(r7)     // Catch:{ all -> 0x004b }
            r7 = 18
            long r24 = r5.getLong(r7)     // Catch:{ all -> 0x004b }
            r7 = 19
            int r26 = r5.getInt(r7)     // Catch:{ all -> 0x004b }
            r7 = 20
            long r28 = r5.getLong(r7)     // Catch:{ all -> 0x004b }
            r7 = 21
            int r30 = r5.getInt(r7)     // Catch:{ all -> 0x004b }
            r7 = 5
            int r7 = r5.getInt(r7)     // Catch:{ all -> 0x004b }
            androidx.work.NetworkType r32 = androidx.work.impl.model.WorkTypeConverters.intToNetworkType(r7)     // Catch:{ all -> 0x004b }
            r7 = 6
            int r7 = r5.getInt(r7)     // Catch:{ all -> 0x004b }
            if (r7 == 0) goto L_0x00f0
            r33 = 1
            goto L_0x00f2
        L_0x00f0:
            r33 = 0
        L_0x00f2:
            r7 = 7
            int r7 = r5.getInt(r7)     // Catch:{ all -> 0x004b }
            if (r7 == 0) goto L_0x00fc
            r34 = 1
            goto L_0x00fe
        L_0x00fc:
            r34 = 0
        L_0x00fe:
            r7 = 8
            int r7 = r5.getInt(r7)     // Catch:{ all -> 0x004b }
            if (r7 == 0) goto L_0x0109
            r35 = 1
            goto L_0x010b
        L_0x0109:
            r35 = 0
        L_0x010b:
            r7 = 9
            int r7 = r5.getInt(r7)     // Catch:{ all -> 0x004b }
            if (r7 == 0) goto L_0x0116
            r36 = 1
            goto L_0x0118
        L_0x0116:
            r36 = 0
        L_0x0118:
            r3 = 10
            long r37 = r5.getLong(r3)     // Catch:{ all -> 0x004b }
            r3 = 11
            long r39 = r5.getLong(r3)     // Catch:{ all -> 0x004b }
            r3 = 12
            boolean r7 = r5.isNull(r3)     // Catch:{ all -> 0x004b }
            if (r7 == 0) goto L_0x012d
            goto L_0x0131
        L_0x012d:
            byte[] r4 = r5.getBlob(r3)     // Catch:{ all -> 0x004b }
        L_0x0131:
            java.util.Set r41 = androidx.work.impl.model.WorkTypeConverters.byteArrayToSetOfTriggers(r4)     // Catch:{ all -> 0x004b }
            androidx.work.Constraints r31 = new androidx.work.Constraints     // Catch:{ all -> 0x004b }
            r31.<init>(r32, r33, r34, r35, r36, r37, r39, r41)     // Catch:{ all -> 0x004b }
            java.lang.String r3 = r5.getString(r8)     // Catch:{ all -> 0x004b }
            java.lang.Object r0 = r0.get(r3)     // Catch:{ all -> 0x004b }
            java.util.ArrayList r0 = (java.util.ArrayList) r0     // Catch:{ all -> 0x004b }
            if (r0 != 0) goto L_0x014b
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x004b }
            r0.<init>()     // Catch:{ all -> 0x004b }
        L_0x014b:
            java.lang.String r3 = r5.getString(r8)     // Catch:{ all -> 0x004b }
            java.lang.Object r3 = r6.get(r3)     // Catch:{ all -> 0x004b }
            java.util.ArrayList r3 = (java.util.ArrayList) r3     // Catch:{ all -> 0x004b }
            if (r3 != 0) goto L_0x015c
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ all -> 0x004b }
            r3.<init>()     // Catch:{ all -> 0x004b }
        L_0x015c:
            r32 = r3
            androidx.work.impl.model.WorkSpec$WorkInfoPojo r9 = new androidx.work.impl.model.WorkSpec$WorkInfoPojo     // Catch:{ all -> 0x004b }
            r19 = r31
            r31 = r0
            r9.<init>(r10, r11, r12, r13, r15, r17, r19, r20, r21, r22, r24, r26, r27, r28, r30, r31, r32)     // Catch:{ all -> 0x004b }
            r4 = r9
        L_0x0168:
            androidx.room.RoomDatabase r0 = r1.__db     // Catch:{ all -> 0x004b }
            r0.setTransactionSuccessful()     // Catch:{ all -> 0x004b }
            r5.close()     // Catch:{ all -> 0x0179 }
            r2.release()     // Catch:{ all -> 0x0179 }
            androidx.room.RoomDatabase r0 = r1.__db
            r0.endTransaction()
            return r4
        L_0x0179:
            r0 = move-exception
            goto L_0x0182
        L_0x017b:
            r5.close()     // Catch:{ all -> 0x0179 }
            r2.release()     // Catch:{ all -> 0x0179 }
            throw r0     // Catch:{ all -> 0x0179 }
        L_0x0182:
            androidx.room.RoomDatabase r2 = r1.__db
            r2.endTransaction()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.model.WorkSpecDao_Impl.getWorkStatusPojoForId(java.lang.String):androidx.work.impl.model.WorkSpec$WorkInfoPojo");
    }

    public List<WorkSpec.WorkInfoPojo> getWorkStatusPojoForIds(List<String> list) {
        Cursor query;
        String str;
        byte[] bArr;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        byte[] bArr2;
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("SELECT id, state, output, run_attempt_count, generation, required_network_type, requires_charging,requires_device_idle, requires_battery_not_low, requires_storage_not_low, trigger_content_update_delay, trigger_max_content_delay, content_uri_triggers, initial_delay, interval_duration, flex_duration, backoff_policy, backoff_delay_duration, last_enqueue_time, period_count, next_schedule_time_override, stop_reason FROM workspec WHERE id IN (");
        int size = list.size();
        StringUtil.appendPlaceholders(newStringBuilder, size);
        newStringBuilder.append(")");
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(newStringBuilder.toString(), size);
        int i4 = 1;
        for (String next : list) {
            if (next == null) {
                acquire.bindNull(i4);
            } else {
                acquire.bindString(i4, next);
            }
            i4++;
        }
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            query = DBUtil.query(this.__db, acquire, true, (CancellationSignal) null);
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            while (query.moveToNext()) {
                String string = query.getString(0);
                if (((ArrayList) hashMap.get(string)) == null) {
                    hashMap.put(string, new ArrayList());
                }
                String string2 = query.getString(0);
                if (((ArrayList) hashMap2.get(string2)) == null) {
                    hashMap2.put(string2, new ArrayList());
                }
            }
            query.moveToPosition(-1);
            __fetchRelationshipWorkTagAsjavaLangString(hashMap);
            __fetchRelationshipWorkProgressAsandroidxWorkData(hashMap2);
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                if (query.isNull(0)) {
                    str = null;
                } else {
                    str = query.getString(0);
                }
                WorkInfo.State intToState = WorkTypeConverters.intToState(query.getInt(1));
                if (query.isNull(2)) {
                    bArr = null;
                } else {
                    bArr = query.getBlob(2);
                }
                Data fromByteArray = Data.fromByteArray(bArr);
                int i5 = query.getInt(3);
                int i6 = query.getInt(4);
                long j4 = query.getLong(13);
                long j5 = query.getLong(14);
                long j6 = query.getLong(15);
                BackoffPolicy intToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy(query.getInt(16));
                long j7 = query.getLong(17);
                long j8 = query.getLong(18);
                int i7 = query.getInt(19);
                long j9 = query.getLong(20);
                int i8 = query.getInt(21);
                NetworkType intToNetworkType = WorkTypeConverters.intToNetworkType(query.getInt(5));
                if (query.getInt(6) != 0) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (query.getInt(7) != 0) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (query.getInt(8) != 0) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (query.getInt(9) != 0) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                long j10 = query.getLong(10);
                long j11 = query.getLong(11);
                if (query.isNull(12)) {
                    bArr2 = null;
                } else {
                    bArr2 = query.getBlob(12);
                }
                Constraints constraints = new Constraints(intToNetworkType, z4, z5, z6, z7, j10, j11, WorkTypeConverters.byteArrayToSetOfTriggers(bArr2));
                ArrayList arrayList2 = (ArrayList) hashMap.get(query.getString(0));
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                }
                ArrayList arrayList3 = (ArrayList) hashMap2.get(query.getString(0));
                if (arrayList3 == null) {
                    arrayList3 = new ArrayList();
                }
                arrayList.add(new WorkSpec.WorkInfoPojo(str, intToState, fromByteArray, j4, j5, j6, constraints, i5, intToBackoffPolicy, j7, j8, i7, i6, j9, i8, arrayList2, arrayList3));
            }
            this.__db.setTransactionSuccessful();
            query.close();
            acquire.release();
            this.__db.endTransaction();
            return arrayList;
        } catch (Throwable th) {
            this.__db.endTransaction();
            throw th;
        }
    }

    public List<WorkSpec.WorkInfoPojo> getWorkStatusPojoForName(String str) {
        Cursor query;
        String str2;
        byte[] bArr;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        byte[] bArr2;
        String str3 = str;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT id, state, output, run_attempt_count, generation, required_network_type, requires_charging,requires_device_idle, requires_battery_not_low, requires_storage_not_low, trigger_content_update_delay, trigger_max_content_delay, content_uri_triggers, initial_delay, interval_duration, flex_duration, backoff_policy, backoff_delay_duration, last_enqueue_time, period_count, next_schedule_time_override, stop_reason FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (str3 == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str3);
        }
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            query = DBUtil.query(this.__db, acquire, true, (CancellationSignal) null);
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            while (query.moveToNext()) {
                String string = query.getString(0);
                if (((ArrayList) hashMap.get(string)) == null) {
                    hashMap.put(string, new ArrayList());
                }
                String string2 = query.getString(0);
                if (((ArrayList) hashMap2.get(string2)) == null) {
                    hashMap2.put(string2, new ArrayList());
                }
            }
            query.moveToPosition(-1);
            __fetchRelationshipWorkTagAsjavaLangString(hashMap);
            __fetchRelationshipWorkProgressAsandroidxWorkData(hashMap2);
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                if (query.isNull(0)) {
                    str2 = null;
                } else {
                    str2 = query.getString(0);
                }
                WorkInfo.State intToState = WorkTypeConverters.intToState(query.getInt(1));
                if (query.isNull(2)) {
                    bArr = null;
                } else {
                    bArr = query.getBlob(2);
                }
                Data fromByteArray = Data.fromByteArray(bArr);
                int i4 = query.getInt(3);
                int i5 = query.getInt(4);
                long j4 = query.getLong(13);
                long j5 = query.getLong(14);
                long j6 = query.getLong(15);
                BackoffPolicy intToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy(query.getInt(16));
                long j7 = query.getLong(17);
                long j8 = query.getLong(18);
                int i6 = query.getInt(19);
                long j9 = query.getLong(20);
                int i7 = query.getInt(21);
                NetworkType intToNetworkType = WorkTypeConverters.intToNetworkType(query.getInt(5));
                if (query.getInt(6) != 0) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (query.getInt(7) != 0) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (query.getInt(8) != 0) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (query.getInt(9) != 0) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                long j10 = query.getLong(10);
                long j11 = query.getLong(11);
                if (query.isNull(12)) {
                    bArr2 = null;
                } else {
                    bArr2 = query.getBlob(12);
                }
                Constraints constraints = new Constraints(intToNetworkType, z4, z5, z6, z7, j10, j11, WorkTypeConverters.byteArrayToSetOfTriggers(bArr2));
                ArrayList arrayList2 = (ArrayList) hashMap.get(query.getString(0));
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                }
                ArrayList arrayList3 = (ArrayList) hashMap2.get(query.getString(0));
                if (arrayList3 == null) {
                    arrayList3 = new ArrayList();
                }
                arrayList.add(new WorkSpec.WorkInfoPojo(str2, intToState, fromByteArray, j4, j5, j6, constraints, i4, intToBackoffPolicy, j7, j8, i6, i5, j9, i7, arrayList2, arrayList3));
            }
            this.__db.setTransactionSuccessful();
            query.close();
            acquire.release();
            this.__db.endTransaction();
            return arrayList;
        } catch (Throwable th) {
            this.__db.endTransaction();
            throw th;
        }
    }

    public List<WorkSpec.WorkInfoPojo> getWorkStatusPojoForTag(String str) {
        Cursor query;
        String str2;
        byte[] bArr;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        byte[] bArr2;
        String str3 = str;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT id, state, output, run_attempt_count, generation, required_network_type, requires_charging,requires_device_idle, requires_battery_not_low, requires_storage_not_low, trigger_content_update_delay, trigger_max_content_delay, content_uri_triggers, initial_delay, interval_duration, flex_duration, backoff_policy, backoff_delay_duration, last_enqueue_time, period_count, next_schedule_time_override, stop_reason FROM workspec WHERE id IN\n            (SELECT work_spec_id FROM worktag WHERE tag=?)", 1);
        if (str3 == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str3);
        }
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            query = DBUtil.query(this.__db, acquire, true, (CancellationSignal) null);
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            while (query.moveToNext()) {
                String string = query.getString(0);
                if (((ArrayList) hashMap.get(string)) == null) {
                    hashMap.put(string, new ArrayList());
                }
                String string2 = query.getString(0);
                if (((ArrayList) hashMap2.get(string2)) == null) {
                    hashMap2.put(string2, new ArrayList());
                }
            }
            query.moveToPosition(-1);
            __fetchRelationshipWorkTagAsjavaLangString(hashMap);
            __fetchRelationshipWorkProgressAsandroidxWorkData(hashMap2);
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                if (query.isNull(0)) {
                    str2 = null;
                } else {
                    str2 = query.getString(0);
                }
                WorkInfo.State intToState = WorkTypeConverters.intToState(query.getInt(1));
                if (query.isNull(2)) {
                    bArr = null;
                } else {
                    bArr = query.getBlob(2);
                }
                Data fromByteArray = Data.fromByteArray(bArr);
                int i4 = query.getInt(3);
                int i5 = query.getInt(4);
                long j4 = query.getLong(13);
                long j5 = query.getLong(14);
                long j6 = query.getLong(15);
                BackoffPolicy intToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy(query.getInt(16));
                long j7 = query.getLong(17);
                long j8 = query.getLong(18);
                int i6 = query.getInt(19);
                long j9 = query.getLong(20);
                int i7 = query.getInt(21);
                NetworkType intToNetworkType = WorkTypeConverters.intToNetworkType(query.getInt(5));
                if (query.getInt(6) != 0) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (query.getInt(7) != 0) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (query.getInt(8) != 0) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (query.getInt(9) != 0) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                long j10 = query.getLong(10);
                long j11 = query.getLong(11);
                if (query.isNull(12)) {
                    bArr2 = null;
                } else {
                    bArr2 = query.getBlob(12);
                }
                Constraints constraints = new Constraints(intToNetworkType, z4, z5, z6, z7, j10, j11, WorkTypeConverters.byteArrayToSetOfTriggers(bArr2));
                ArrayList arrayList2 = (ArrayList) hashMap.get(query.getString(0));
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                }
                ArrayList arrayList3 = (ArrayList) hashMap2.get(query.getString(0));
                if (arrayList3 == null) {
                    arrayList3 = new ArrayList();
                }
                arrayList.add(new WorkSpec.WorkInfoPojo(str2, intToState, fromByteArray, j4, j5, j6, constraints, i4, intToBackoffPolicy, j7, j8, i6, i5, j9, i7, arrayList2, arrayList3));
            }
            this.__db.setTransactionSuccessful();
            query.close();
            acquire.release();
            this.__db.endTransaction();
            return arrayList;
        } catch (Throwable th) {
            this.__db.endTransaction();
            throw th;
        }
    }

    public LiveData<List<WorkSpec.WorkInfoPojo>> getWorkStatusPojoLiveDataForIds(List<String> list) {
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("SELECT id, state, output, run_attempt_count, generation, required_network_type, requires_charging,requires_device_idle, requires_battery_not_low, requires_storage_not_low, trigger_content_update_delay, trigger_max_content_delay, content_uri_triggers, initial_delay, interval_duration, flex_duration, backoff_policy, backoff_delay_duration, last_enqueue_time, period_count, next_schedule_time_override, stop_reason FROM workspec WHERE id IN (");
        int size = list.size();
        StringUtil.appendPlaceholders(newStringBuilder, size);
        newStringBuilder.append(")");
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(newStringBuilder.toString(), size);
        int i4 = 1;
        for (String next : list) {
            if (next == null) {
                acquire.bindNull(i4);
            } else {
                acquire.bindString(i4, next);
            }
            i4++;
        }
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"WorkTag", "WorkProgress", "workspec"}, true, new Callable<List<WorkSpec.WorkInfoPojo>>() {
            /* access modifiers changed from: protected */
            public void finalize() {
                acquire.release();
            }

            public List<WorkSpec.WorkInfoPojo> call() throws Exception {
                Cursor query;
                String str;
                byte[] bArr;
                byte[] bArr2;
                WorkSpecDao_Impl.this.__db.beginTransaction();
                try {
                    query = DBUtil.query(WorkSpecDao_Impl.this.__db, acquire, true, (CancellationSignal) null);
                    HashMap hashMap = new HashMap();
                    HashMap hashMap2 = new HashMap();
                    while (query.moveToNext()) {
                        String string = query.getString(0);
                        if (((ArrayList) hashMap.get(string)) == null) {
                            hashMap.put(string, new ArrayList());
                        }
                        String string2 = query.getString(0);
                        if (((ArrayList) hashMap2.get(string2)) == null) {
                            hashMap2.put(string2, new ArrayList());
                        }
                    }
                    query.moveToPosition(-1);
                    WorkSpecDao_Impl.this.__fetchRelationshipWorkTagAsjavaLangString(hashMap);
                    WorkSpecDao_Impl.this.__fetchRelationshipWorkProgressAsandroidxWorkData(hashMap2);
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        if (query.isNull(0)) {
                            str = null;
                        } else {
                            str = query.getString(0);
                        }
                        WorkInfo.State intToState = WorkTypeConverters.intToState(query.getInt(1));
                        if (query.isNull(2)) {
                            bArr = null;
                        } else {
                            bArr = query.getBlob(2);
                        }
                        Data fromByteArray = Data.fromByteArray(bArr);
                        int i4 = query.getInt(3);
                        int i5 = query.getInt(4);
                        long j4 = query.getLong(13);
                        long j5 = query.getLong(14);
                        long j6 = query.getLong(15);
                        BackoffPolicy intToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy(query.getInt(16));
                        long j7 = query.getLong(17);
                        long j8 = query.getLong(18);
                        int i6 = query.getInt(19);
                        long j9 = query.getLong(20);
                        int i7 = query.getInt(21);
                        NetworkType intToNetworkType = WorkTypeConverters.intToNetworkType(query.getInt(5));
                        boolean z4 = query.getInt(6) != 0;
                        boolean z5 = query.getInt(7) != 0;
                        boolean z6 = query.getInt(8) != 0;
                        boolean z7 = query.getInt(9) != 0;
                        long j10 = query.getLong(10);
                        long j11 = query.getLong(11);
                        if (query.isNull(12)) {
                            bArr2 = null;
                        } else {
                            bArr2 = query.getBlob(12);
                        }
                        Constraints constraints = new Constraints(intToNetworkType, z4, z5, z6, z7, j10, j11, WorkTypeConverters.byteArrayToSetOfTriggers(bArr2));
                        ArrayList arrayList2 = (ArrayList) hashMap.get(query.getString(0));
                        if (arrayList2 == null) {
                            arrayList2 = new ArrayList();
                        }
                        ArrayList arrayList3 = (ArrayList) hashMap2.get(query.getString(0));
                        if (arrayList3 == null) {
                            arrayList3 = new ArrayList();
                        }
                        arrayList.add(new WorkSpec.WorkInfoPojo(str, intToState, fromByteArray, j4, j5, j6, constraints, i4, intToBackoffPolicy, j7, j8, i6, i5, j9, i7, arrayList2, arrayList3));
                    }
                    WorkSpecDao_Impl.this.__db.setTransactionSuccessful();
                    query.close();
                    WorkSpecDao_Impl.this.__db.endTransaction();
                    return arrayList;
                } catch (Throwable th) {
                    WorkSpecDao_Impl.this.__db.endTransaction();
                    throw th;
                }
            }
        });
    }

    public LiveData<List<WorkSpec.WorkInfoPojo>> getWorkStatusPojoLiveDataForName(String str) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT id, state, output, run_attempt_count, generation, required_network_type, requires_charging,requires_device_idle, requires_battery_not_low, requires_storage_not_low, trigger_content_update_delay, trigger_max_content_delay, content_uri_triggers, initial_delay, interval_duration, flex_duration, backoff_policy, backoff_delay_duration, last_enqueue_time, period_count, next_schedule_time_override, stop_reason FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"WorkTag", "WorkProgress", "workspec", "workname"}, true, new Callable<List<WorkSpec.WorkInfoPojo>>() {
            /* access modifiers changed from: protected */
            public void finalize() {
                acquire.release();
            }

            public List<WorkSpec.WorkInfoPojo> call() throws Exception {
                Cursor query;
                String str;
                byte[] bArr;
                byte[] bArr2;
                WorkSpecDao_Impl.this.__db.beginTransaction();
                try {
                    query = DBUtil.query(WorkSpecDao_Impl.this.__db, acquire, true, (CancellationSignal) null);
                    HashMap hashMap = new HashMap();
                    HashMap hashMap2 = new HashMap();
                    while (query.moveToNext()) {
                        String string = query.getString(0);
                        if (((ArrayList) hashMap.get(string)) == null) {
                            hashMap.put(string, new ArrayList());
                        }
                        String string2 = query.getString(0);
                        if (((ArrayList) hashMap2.get(string2)) == null) {
                            hashMap2.put(string2, new ArrayList());
                        }
                    }
                    query.moveToPosition(-1);
                    WorkSpecDao_Impl.this.__fetchRelationshipWorkTagAsjavaLangString(hashMap);
                    WorkSpecDao_Impl.this.__fetchRelationshipWorkProgressAsandroidxWorkData(hashMap2);
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        if (query.isNull(0)) {
                            str = null;
                        } else {
                            str = query.getString(0);
                        }
                        WorkInfo.State intToState = WorkTypeConverters.intToState(query.getInt(1));
                        if (query.isNull(2)) {
                            bArr = null;
                        } else {
                            bArr = query.getBlob(2);
                        }
                        Data fromByteArray = Data.fromByteArray(bArr);
                        int i4 = query.getInt(3);
                        int i5 = query.getInt(4);
                        long j4 = query.getLong(13);
                        long j5 = query.getLong(14);
                        long j6 = query.getLong(15);
                        BackoffPolicy intToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy(query.getInt(16));
                        long j7 = query.getLong(17);
                        long j8 = query.getLong(18);
                        int i6 = query.getInt(19);
                        long j9 = query.getLong(20);
                        int i7 = query.getInt(21);
                        NetworkType intToNetworkType = WorkTypeConverters.intToNetworkType(query.getInt(5));
                        boolean z4 = query.getInt(6) != 0;
                        boolean z5 = query.getInt(7) != 0;
                        boolean z6 = query.getInt(8) != 0;
                        boolean z7 = query.getInt(9) != 0;
                        long j10 = query.getLong(10);
                        long j11 = query.getLong(11);
                        if (query.isNull(12)) {
                            bArr2 = null;
                        } else {
                            bArr2 = query.getBlob(12);
                        }
                        Constraints constraints = new Constraints(intToNetworkType, z4, z5, z6, z7, j10, j11, WorkTypeConverters.byteArrayToSetOfTriggers(bArr2));
                        ArrayList arrayList2 = (ArrayList) hashMap.get(query.getString(0));
                        if (arrayList2 == null) {
                            arrayList2 = new ArrayList();
                        }
                        ArrayList arrayList3 = (ArrayList) hashMap2.get(query.getString(0));
                        if (arrayList3 == null) {
                            arrayList3 = new ArrayList();
                        }
                        arrayList.add(new WorkSpec.WorkInfoPojo(str, intToState, fromByteArray, j4, j5, j6, constraints, i4, intToBackoffPolicy, j7, j8, i6, i5, j9, i7, arrayList2, arrayList3));
                    }
                    WorkSpecDao_Impl.this.__db.setTransactionSuccessful();
                    query.close();
                    WorkSpecDao_Impl.this.__db.endTransaction();
                    return arrayList;
                } catch (Throwable th) {
                    WorkSpecDao_Impl.this.__db.endTransaction();
                    throw th;
                }
            }
        });
    }

    public LiveData<List<WorkSpec.WorkInfoPojo>> getWorkStatusPojoLiveDataForTag(String str) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT id, state, output, run_attempt_count, generation, required_network_type, requires_charging,requires_device_idle, requires_battery_not_low, requires_storage_not_low, trigger_content_update_delay, trigger_max_content_delay, content_uri_triggers, initial_delay, interval_duration, flex_duration, backoff_policy, backoff_delay_duration, last_enqueue_time, period_count, next_schedule_time_override, stop_reason FROM workspec WHERE id IN\n            (SELECT work_spec_id FROM worktag WHERE tag=?)", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"WorkTag", "WorkProgress", "workspec", "worktag"}, true, new Callable<List<WorkSpec.WorkInfoPojo>>() {
            /* access modifiers changed from: protected */
            public void finalize() {
                acquire.release();
            }

            public List<WorkSpec.WorkInfoPojo> call() throws Exception {
                Cursor query;
                String str;
                byte[] bArr;
                byte[] bArr2;
                WorkSpecDao_Impl.this.__db.beginTransaction();
                try {
                    query = DBUtil.query(WorkSpecDao_Impl.this.__db, acquire, true, (CancellationSignal) null);
                    HashMap hashMap = new HashMap();
                    HashMap hashMap2 = new HashMap();
                    while (query.moveToNext()) {
                        String string = query.getString(0);
                        if (((ArrayList) hashMap.get(string)) == null) {
                            hashMap.put(string, new ArrayList());
                        }
                        String string2 = query.getString(0);
                        if (((ArrayList) hashMap2.get(string2)) == null) {
                            hashMap2.put(string2, new ArrayList());
                        }
                    }
                    query.moveToPosition(-1);
                    WorkSpecDao_Impl.this.__fetchRelationshipWorkTagAsjavaLangString(hashMap);
                    WorkSpecDao_Impl.this.__fetchRelationshipWorkProgressAsandroidxWorkData(hashMap2);
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        if (query.isNull(0)) {
                            str = null;
                        } else {
                            str = query.getString(0);
                        }
                        WorkInfo.State intToState = WorkTypeConverters.intToState(query.getInt(1));
                        if (query.isNull(2)) {
                            bArr = null;
                        } else {
                            bArr = query.getBlob(2);
                        }
                        Data fromByteArray = Data.fromByteArray(bArr);
                        int i4 = query.getInt(3);
                        int i5 = query.getInt(4);
                        long j4 = query.getLong(13);
                        long j5 = query.getLong(14);
                        long j6 = query.getLong(15);
                        BackoffPolicy intToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy(query.getInt(16));
                        long j7 = query.getLong(17);
                        long j8 = query.getLong(18);
                        int i6 = query.getInt(19);
                        long j9 = query.getLong(20);
                        int i7 = query.getInt(21);
                        NetworkType intToNetworkType = WorkTypeConverters.intToNetworkType(query.getInt(5));
                        boolean z4 = query.getInt(6) != 0;
                        boolean z5 = query.getInt(7) != 0;
                        boolean z6 = query.getInt(8) != 0;
                        boolean z7 = query.getInt(9) != 0;
                        long j10 = query.getLong(10);
                        long j11 = query.getLong(11);
                        if (query.isNull(12)) {
                            bArr2 = null;
                        } else {
                            bArr2 = query.getBlob(12);
                        }
                        Constraints constraints = new Constraints(intToNetworkType, z4, z5, z6, z7, j10, j11, WorkTypeConverters.byteArrayToSetOfTriggers(bArr2));
                        ArrayList arrayList2 = (ArrayList) hashMap.get(query.getString(0));
                        if (arrayList2 == null) {
                            arrayList2 = new ArrayList();
                        }
                        ArrayList arrayList3 = (ArrayList) hashMap2.get(query.getString(0));
                        if (arrayList3 == null) {
                            arrayList3 = new ArrayList();
                        }
                        arrayList.add(new WorkSpec.WorkInfoPojo(str, intToState, fromByteArray, j4, j5, j6, constraints, i4, intToBackoffPolicy, j7, j8, i6, i5, j9, i7, arrayList2, arrayList3));
                    }
                    WorkSpecDao_Impl.this.__db.setTransactionSuccessful();
                    query.close();
                    WorkSpecDao_Impl.this.__db.endTransaction();
                    return arrayList;
                } catch (Throwable th) {
                    WorkSpecDao_Impl.this.__db.endTransaction();
                    throw th;
                }
            }
        });
    }

    public boolean hasUnfinishedWork() {
        boolean z4 = false;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT COUNT(*) > 0 FROM workspec WHERE state NOT IN (2, 3, 5) LIMIT 1", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            if (query.moveToFirst() && query.getInt(0) != 0) {
                z4 = true;
            }
            return z4;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public void incrementGeneration(String str) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfIncrementGeneration.acquire();
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfIncrementGeneration.release(acquire);
        }
    }

    public void incrementPeriodCount(String str) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfIncrementPeriodCount.acquire();
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfIncrementPeriodCount.release(acquire);
        }
    }

    public int incrementWorkSpecRunAttemptCount(String str) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfIncrementWorkSpecRunAttemptCount.acquire();
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.__db.beginTransaction();
        try {
            int executeUpdateDelete = acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            return executeUpdateDelete;
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfIncrementWorkSpecRunAttemptCount.release(acquire);
        }
    }

    public void insertWorkSpec(WorkSpec workSpec) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfWorkSpec.insert(workSpec);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    public int markWorkSpecScheduled(String str, long j4) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfMarkWorkSpecScheduled.acquire();
        acquire.bindLong(1, j4);
        if (str == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, str);
        }
        this.__db.beginTransaction();
        try {
            int executeUpdateDelete = acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            return executeUpdateDelete;
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfMarkWorkSpecScheduled.release(acquire);
        }
    }

    public void pruneFinishedWorkWithZeroDependentsIgnoringKeepForAtLeast() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfPruneFinishedWorkWithZeroDependentsIgnoringKeepForAtLeast.acquire();
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfPruneFinishedWorkWithZeroDependentsIgnoringKeepForAtLeast.release(acquire);
        }
    }

    public int resetScheduledState() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfResetScheduledState.acquire();
        this.__db.beginTransaction();
        try {
            int executeUpdateDelete = acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            return executeUpdateDelete;
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfResetScheduledState.release(acquire);
        }
    }

    public void resetWorkSpecNextScheduleTimeOverride(String str, int i4) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfResetWorkSpecNextScheduleTimeOverride.acquire();
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        acquire.bindLong(2, (long) i4);
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfResetWorkSpecNextScheduleTimeOverride.release(acquire);
        }
    }

    public int resetWorkSpecRunAttemptCount(String str) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfResetWorkSpecRunAttemptCount.acquire();
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.__db.beginTransaction();
        try {
            int executeUpdateDelete = acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            return executeUpdateDelete;
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfResetWorkSpecRunAttemptCount.release(acquire);
        }
    }

    public int setCancelledState(String str) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfSetCancelledState.acquire();
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.__db.beginTransaction();
        try {
            int executeUpdateDelete = acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            return executeUpdateDelete;
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfSetCancelledState.release(acquire);
        }
    }

    public void setLastEnqueueTime(String str, long j4) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfSetLastEnqueueTime.acquire();
        acquire.bindLong(1, j4);
        if (str == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, str);
        }
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfSetLastEnqueueTime.release(acquire);
        }
    }

    public void setNextScheduleTimeOverride(String str, long j4) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfSetNextScheduleTimeOverride.acquire();
        acquire.bindLong(1, j4);
        if (str == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, str);
        }
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfSetNextScheduleTimeOverride.release(acquire);
        }
    }

    public void setOutput(String str, Data data) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfSetOutput.acquire();
        byte[] byteArrayInternal = Data.toByteArrayInternal(data);
        if (byteArrayInternal == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindBlob(1, byteArrayInternal);
        }
        if (str == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, str);
        }
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfSetOutput.release(acquire);
        }
    }

    public int setState(WorkInfo.State state, String str) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfSetState.acquire();
        acquire.bindLong(1, (long) WorkTypeConverters.stateToInt(state));
        if (str == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, str);
        }
        this.__db.beginTransaction();
        try {
            int executeUpdateDelete = acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            return executeUpdateDelete;
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfSetState.release(acquire);
        }
    }

    public void setStopReason(String str, int i4) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfSetStopReason.acquire();
        acquire.bindLong(1, (long) i4);
        if (str == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, str);
        }
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfSetStopReason.release(acquire);
        }
    }

    public void updateWorkSpec(WorkSpec workSpec) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfWorkSpec.handle(workSpec);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }
}
