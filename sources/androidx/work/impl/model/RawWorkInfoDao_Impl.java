package androidx.work.impl.model;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.lifecycle.LiveData;
import androidx.room.CoroutinesRoom;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.work.Data;
import androidx.work.impl.model.WorkSpec;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import r3.C1035e;

public final class RawWorkInfoDao_Impl implements RawWorkInfoDao {
    /* access modifiers changed from: private */
    public final RoomDatabase __db;

    public RawWorkInfoDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
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

    /* JADX WARNING: Removed duplicated region for block: B:104:0x0228 A[Catch:{ all -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x022f A[Catch:{ all -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x023c A[Catch:{ all -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0243 A[Catch:{ all -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0251 A[Catch:{ all -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0258 A[Catch:{ all -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x025b A[Catch:{ all -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x027f A[Catch:{ all -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x0292 A[Catch:{ all -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0122 A[Catch:{ all -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0125 A[Catch:{ all -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0131 A[Catch:{ all -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0134 A[Catch:{ all -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x014b A[Catch:{ all -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x014e A[Catch:{ all -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0154 A[Catch:{ all -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0157 A[Catch:{ all -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x015d A[Catch:{ all -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0160 A[Catch:{ all -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0168 A[Catch:{ all -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x016b A[Catch:{ all -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0171 A[Catch:{ all -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0174 A[Catch:{ all -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x017e A[Catch:{ all -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0181 A[Catch:{ all -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0187 A[Catch:{ all -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x018c A[Catch:{ all -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0193 A[Catch:{ all -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x019a A[Catch:{ all -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x01a3 A[Catch:{ all -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x01aa A[Catch:{ all -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x01b3 A[Catch:{ all -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x01ba A[Catch:{ all -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x01c1 A[Catch:{ all -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x01c8 A[Catch:{ all -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x01cf A[Catch:{ all -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x01d6 A[Catch:{ all -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x01e3 A[Catch:{ all -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x01ea A[Catch:{ all -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x01fa A[Catch:{ all -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0201 A[Catch:{ all -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0211 A[Catch:{ all -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0218 A[Catch:{ all -> 0x00d2 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<androidx.work.impl.model.WorkSpec.WorkInfoPojo> getWorkInfoPojos(androidx.sqlite.db.SupportSQLiteQuery r62) {
        /*
            r61 = this;
            r1 = r61
            androidx.room.RoomDatabase r0 = r1.__db
            r0.assertNotSuspendingTransaction()
            androidx.room.RoomDatabase r0 = r1.__db
            r2 = 1
            r3 = 0
            r4 = r62
            android.database.Cursor r4 = androidx.room.util.DBUtil.query(r0, r4, r2, r3)
            java.lang.String r0 = "id"
            int r0 = androidx.room.util.CursorUtil.getColumnIndex(r4, r0)     // Catch:{ all -> 0x00d2 }
            java.lang.String r5 = "state"
            int r5 = androidx.room.util.CursorUtil.getColumnIndex(r4, r5)     // Catch:{ all -> 0x00d2 }
            java.lang.String r6 = "output"
            int r6 = androidx.room.util.CursorUtil.getColumnIndex(r4, r6)     // Catch:{ all -> 0x00d2 }
            java.lang.String r7 = "initial_delay"
            int r7 = androidx.room.util.CursorUtil.getColumnIndex(r4, r7)     // Catch:{ all -> 0x00d2 }
            java.lang.String r8 = "interval_duration"
            int r8 = androidx.room.util.CursorUtil.getColumnIndex(r4, r8)     // Catch:{ all -> 0x00d2 }
            java.lang.String r9 = "flex_duration"
            int r9 = androidx.room.util.CursorUtil.getColumnIndex(r4, r9)     // Catch:{ all -> 0x00d2 }
            java.lang.String r10 = "run_attempt_count"
            int r10 = androidx.room.util.CursorUtil.getColumnIndex(r4, r10)     // Catch:{ all -> 0x00d2 }
            java.lang.String r11 = "backoff_policy"
            int r11 = androidx.room.util.CursorUtil.getColumnIndex(r4, r11)     // Catch:{ all -> 0x00d2 }
            java.lang.String r12 = "backoff_delay_duration"
            int r12 = androidx.room.util.CursorUtil.getColumnIndex(r4, r12)     // Catch:{ all -> 0x00d2 }
            java.lang.String r13 = "last_enqueue_time"
            int r13 = androidx.room.util.CursorUtil.getColumnIndex(r4, r13)     // Catch:{ all -> 0x00d2 }
            java.lang.String r14 = "period_count"
            int r14 = androidx.room.util.CursorUtil.getColumnIndex(r4, r14)     // Catch:{ all -> 0x00d2 }
            java.lang.String r15 = "generation"
            int r15 = androidx.room.util.CursorUtil.getColumnIndex(r4, r15)     // Catch:{ all -> 0x00d2 }
            java.lang.String r2 = "next_schedule_time_override"
            int r2 = androidx.room.util.CursorUtil.getColumnIndex(r4, r2)     // Catch:{ all -> 0x00d2 }
            java.lang.String r3 = "stop_reason"
            int r3 = androidx.room.util.CursorUtil.getColumnIndex(r4, r3)     // Catch:{ all -> 0x00d2 }
            r62 = r3
            java.lang.String r3 = "required_network_type"
            int r3 = androidx.room.util.CursorUtil.getColumnIndex(r4, r3)     // Catch:{ all -> 0x00d2 }
            r16 = r3
            java.lang.String r3 = "requires_charging"
            int r3 = androidx.room.util.CursorUtil.getColumnIndex(r4, r3)     // Catch:{ all -> 0x00d2 }
            r17 = r3
            java.lang.String r3 = "requires_device_idle"
            int r3 = androidx.room.util.CursorUtil.getColumnIndex(r4, r3)     // Catch:{ all -> 0x00d2 }
            r18 = r3
            java.lang.String r3 = "requires_battery_not_low"
            int r3 = androidx.room.util.CursorUtil.getColumnIndex(r4, r3)     // Catch:{ all -> 0x00d2 }
            r19 = r3
            java.lang.String r3 = "requires_storage_not_low"
            int r3 = androidx.room.util.CursorUtil.getColumnIndex(r4, r3)     // Catch:{ all -> 0x00d2 }
            r20 = r3
            java.lang.String r3 = "trigger_content_update_delay"
            int r3 = androidx.room.util.CursorUtil.getColumnIndex(r4, r3)     // Catch:{ all -> 0x00d2 }
            r21 = r3
            java.lang.String r3 = "trigger_max_content_delay"
            int r3 = androidx.room.util.CursorUtil.getColumnIndex(r4, r3)     // Catch:{ all -> 0x00d2 }
            r22 = r3
            java.lang.String r3 = "content_uri_triggers"
            int r3 = androidx.room.util.CursorUtil.getColumnIndex(r4, r3)     // Catch:{ all -> 0x00d2 }
            r23 = r3
            java.util.HashMap r3 = new java.util.HashMap     // Catch:{ all -> 0x00d2 }
            r3.<init>()     // Catch:{ all -> 0x00d2 }
            r24 = r2
            java.util.HashMap r2 = new java.util.HashMap     // Catch:{ all -> 0x00d2 }
            r2.<init>()     // Catch:{ all -> 0x00d2 }
        L_0x00b3:
            boolean r25 = r4.moveToNext()     // Catch:{ all -> 0x00d2 }
            if (r25 == 0) goto L_0x00f0
            r25 = r15
            java.lang.String r15 = r4.getString(r0)     // Catch:{ all -> 0x00d2 }
            java.lang.Object r26 = r3.get(r15)     // Catch:{ all -> 0x00d2 }
            java.util.ArrayList r26 = (java.util.ArrayList) r26     // Catch:{ all -> 0x00d2 }
            if (r26 != 0) goto L_0x00d5
            r26 = r14
            java.util.ArrayList r14 = new java.util.ArrayList     // Catch:{ all -> 0x00d2 }
            r14.<init>()     // Catch:{ all -> 0x00d2 }
            r3.put(r15, r14)     // Catch:{ all -> 0x00d2 }
            goto L_0x00d7
        L_0x00d2:
            r0 = move-exception
            goto L_0x02b3
        L_0x00d5:
            r26 = r14
        L_0x00d7:
            java.lang.String r14 = r4.getString(r0)     // Catch:{ all -> 0x00d2 }
            java.lang.Object r15 = r2.get(r14)     // Catch:{ all -> 0x00d2 }
            java.util.ArrayList r15 = (java.util.ArrayList) r15     // Catch:{ all -> 0x00d2 }
            if (r15 != 0) goto L_0x00eb
            java.util.ArrayList r15 = new java.util.ArrayList     // Catch:{ all -> 0x00d2 }
            r15.<init>()     // Catch:{ all -> 0x00d2 }
            r2.put(r14, r15)     // Catch:{ all -> 0x00d2 }
        L_0x00eb:
            r15 = r25
            r14 = r26
            goto L_0x00b3
        L_0x00f0:
            r26 = r14
            r25 = r15
            r14 = -1
            r4.moveToPosition(r14)     // Catch:{ all -> 0x00d2 }
            r1.__fetchRelationshipWorkTagAsjavaLangString(r3)     // Catch:{ all -> 0x00d2 }
            r1.__fetchRelationshipWorkProgressAsandroidxWorkData(r2)     // Catch:{ all -> 0x00d2 }
            java.util.ArrayList r15 = new java.util.ArrayList     // Catch:{ all -> 0x00d2 }
            int r14 = r4.getCount()     // Catch:{ all -> 0x00d2 }
            r15.<init>(r14)     // Catch:{ all -> 0x00d2 }
        L_0x0107:
            boolean r14 = r4.moveToNext()     // Catch:{ all -> 0x00d2 }
            if (r14 == 0) goto L_0x02af
            r14 = -1
            if (r0 != r14) goto L_0x0113
        L_0x0110:
            r29 = 0
            goto L_0x0120
        L_0x0113:
            boolean r27 = r4.isNull(r0)     // Catch:{ all -> 0x00d2 }
            if (r27 == 0) goto L_0x011a
            goto L_0x0110
        L_0x011a:
            java.lang.String r27 = r4.getString(r0)     // Catch:{ all -> 0x00d2 }
            r29 = r27
        L_0x0120:
            if (r5 != r14) goto L_0x0125
            r30 = 0
            goto L_0x012f
        L_0x0125:
            int r27 = r4.getInt(r5)     // Catch:{ all -> 0x00d2 }
            androidx.work.WorkInfo$State r27 = androidx.work.impl.model.WorkTypeConverters.intToState(r27)     // Catch:{ all -> 0x00d2 }
            r30 = r27
        L_0x012f:
            if (r6 != r14) goto L_0x0134
            r31 = 0
            goto L_0x0146
        L_0x0134:
            boolean r14 = r4.isNull(r6)     // Catch:{ all -> 0x00d2 }
            if (r14 == 0) goto L_0x013c
            r14 = 0
            goto L_0x0140
        L_0x013c:
            byte[] r14 = r4.getBlob(r6)     // Catch:{ all -> 0x00d2 }
        L_0x0140:
            androidx.work.Data r14 = androidx.work.Data.fromByteArray(r14)     // Catch:{ all -> 0x00d2 }
            r31 = r14
        L_0x0146:
            r32 = 0
            r14 = -1
            if (r7 != r14) goto L_0x014e
            r27 = r32
            goto L_0x0152
        L_0x014e:
            long r27 = r4.getLong(r7)     // Catch:{ all -> 0x00d2 }
        L_0x0152:
            if (r8 != r14) goto L_0x0157
            r34 = r32
            goto L_0x015b
        L_0x0157:
            long r34 = r4.getLong(r8)     // Catch:{ all -> 0x00d2 }
        L_0x015b:
            if (r9 != r14) goto L_0x0160
            r36 = r32
            goto L_0x0164
        L_0x0160:
            long r36 = r4.getLong(r9)     // Catch:{ all -> 0x00d2 }
        L_0x0164:
            r38 = 0
            if (r10 != r14) goto L_0x016b
            r39 = 0
            goto L_0x016f
        L_0x016b:
            int r39 = r4.getInt(r10)     // Catch:{ all -> 0x00d2 }
        L_0x016f:
            if (r11 != r14) goto L_0x0174
            r40 = 0
            goto L_0x017c
        L_0x0174:
            int r40 = r4.getInt(r11)     // Catch:{ all -> 0x00d2 }
            androidx.work.BackoffPolicy r40 = androidx.work.impl.model.WorkTypeConverters.intToBackoffPolicy(r40)     // Catch:{ all -> 0x00d2 }
        L_0x017c:
            if (r12 != r14) goto L_0x0181
            r41 = r32
            goto L_0x0185
        L_0x0181:
            long r41 = r4.getLong(r12)     // Catch:{ all -> 0x00d2 }
        L_0x0185:
            if (r13 != r14) goto L_0x018c
            r43 = r32
        L_0x0189:
            r1 = r26
            goto L_0x0191
        L_0x018c:
            long r43 = r4.getLong(r13)     // Catch:{ all -> 0x00d2 }
            goto L_0x0189
        L_0x0191:
            if (r1 != r14) goto L_0x019a
            r45 = 0
        L_0x0195:
            r26 = r1
            r1 = r25
            goto L_0x01a1
        L_0x019a:
            int r26 = r4.getInt(r1)     // Catch:{ all -> 0x00d2 }
            r45 = r26
            goto L_0x0195
        L_0x01a1:
            if (r1 != r14) goto L_0x01aa
            r46 = 0
        L_0x01a5:
            r25 = r1
            r1 = r24
            goto L_0x01b1
        L_0x01aa:
            int r25 = r4.getInt(r1)     // Catch:{ all -> 0x00d2 }
            r46 = r25
            goto L_0x01a5
        L_0x01b1:
            if (r1 != r14) goto L_0x01ba
            r47 = r32
        L_0x01b5:
            r24 = r1
            r1 = r62
            goto L_0x01bf
        L_0x01ba:
            long r47 = r4.getLong(r1)     // Catch:{ all -> 0x00d2 }
            goto L_0x01b5
        L_0x01bf:
            if (r1 != r14) goto L_0x01c8
            r49 = 0
        L_0x01c3:
            r62 = r1
            r1 = r16
            goto L_0x01cd
        L_0x01c8:
            int r49 = r4.getInt(r1)     // Catch:{ all -> 0x00d2 }
            goto L_0x01c3
        L_0x01cd:
            if (r1 != r14) goto L_0x01d6
            r51 = 0
        L_0x01d1:
            r16 = r1
            r1 = r17
            goto L_0x01e1
        L_0x01d6:
            int r16 = r4.getInt(r1)     // Catch:{ all -> 0x00d2 }
            androidx.work.NetworkType r16 = androidx.work.impl.model.WorkTypeConverters.intToNetworkType(r16)     // Catch:{ all -> 0x00d2 }
            r51 = r16
            goto L_0x01d1
        L_0x01e1:
            if (r1 != r14) goto L_0x01ea
            r52 = 0
        L_0x01e5:
            r17 = r1
            r1 = r18
            goto L_0x01f8
        L_0x01ea:
            int r17 = r4.getInt(r1)     // Catch:{ all -> 0x00d2 }
            if (r17 == 0) goto L_0x01f3
            r17 = 1
            goto L_0x01f5
        L_0x01f3:
            r17 = 0
        L_0x01f5:
            r52 = r17
            goto L_0x01e5
        L_0x01f8:
            if (r1 != r14) goto L_0x0201
            r53 = 0
        L_0x01fc:
            r18 = r1
            r1 = r19
            goto L_0x020f
        L_0x0201:
            int r18 = r4.getInt(r1)     // Catch:{ all -> 0x00d2 }
            if (r18 == 0) goto L_0x020a
            r18 = 1
            goto L_0x020c
        L_0x020a:
            r18 = 0
        L_0x020c:
            r53 = r18
            goto L_0x01fc
        L_0x020f:
            if (r1 != r14) goto L_0x0218
            r54 = 0
        L_0x0213:
            r19 = r1
            r1 = r20
            goto L_0x0226
        L_0x0218:
            int r19 = r4.getInt(r1)     // Catch:{ all -> 0x00d2 }
            if (r19 == 0) goto L_0x0221
            r19 = 1
            goto L_0x0223
        L_0x0221:
            r19 = 0
        L_0x0223:
            r54 = r19
            goto L_0x0213
        L_0x0226:
            if (r1 != r14) goto L_0x022f
            r55 = 0
        L_0x022a:
            r20 = r1
            r1 = r21
            goto L_0x023a
        L_0x022f:
            int r20 = r4.getInt(r1)     // Catch:{ all -> 0x00d2 }
            if (r20 == 0) goto L_0x0237
            r38 = 1
        L_0x0237:
            r55 = r38
            goto L_0x022a
        L_0x023a:
            if (r1 != r14) goto L_0x0243
            r56 = r32
        L_0x023e:
            r21 = r1
            r1 = r22
            goto L_0x0248
        L_0x0243:
            long r56 = r4.getLong(r1)     // Catch:{ all -> 0x00d2 }
            goto L_0x023e
        L_0x0248:
            if (r1 != r14) goto L_0x0251
        L_0x024a:
            r22 = r1
            r1 = r23
            r58 = r32
            goto L_0x0256
        L_0x0251:
            long r32 = r4.getLong(r1)     // Catch:{ all -> 0x00d2 }
            goto L_0x024a
        L_0x0256:
            if (r1 != r14) goto L_0x025b
            r60 = 0
            goto L_0x026e
        L_0x025b:
            boolean r23 = r4.isNull(r1)     // Catch:{ all -> 0x00d2 }
            if (r23 == 0) goto L_0x0264
            r23 = 0
            goto L_0x0268
        L_0x0264:
            byte[] r23 = r4.getBlob(r1)     // Catch:{ all -> 0x00d2 }
        L_0x0268:
            java.util.Set r23 = androidx.work.impl.model.WorkTypeConverters.byteArrayToSetOfTriggers(r23)     // Catch:{ all -> 0x00d2 }
            r60 = r23
        L_0x026e:
            androidx.work.Constraints r50 = new androidx.work.Constraints     // Catch:{ all -> 0x00d2 }
            r50.<init>(r51, r52, r53, r54, r55, r56, r58, r60)     // Catch:{ all -> 0x00d2 }
            java.lang.String r14 = r4.getString(r0)     // Catch:{ all -> 0x00d2 }
            java.lang.Object r14 = r3.get(r14)     // Catch:{ all -> 0x00d2 }
            java.util.ArrayList r14 = (java.util.ArrayList) r14     // Catch:{ all -> 0x00d2 }
            if (r14 != 0) goto L_0x0284
            java.util.ArrayList r14 = new java.util.ArrayList     // Catch:{ all -> 0x00d2 }
            r14.<init>()     // Catch:{ all -> 0x00d2 }
        L_0x0284:
            r52 = r1
            java.lang.String r1 = r4.getString(r0)     // Catch:{ all -> 0x00d2 }
            java.lang.Object r1 = r2.get(r1)     // Catch:{ all -> 0x00d2 }
            java.util.ArrayList r1 = (java.util.ArrayList) r1     // Catch:{ all -> 0x00d2 }
            if (r1 != 0) goto L_0x0297
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x00d2 }
            r1.<init>()     // Catch:{ all -> 0x00d2 }
        L_0x0297:
            r51 = r1
            r32 = r27
            androidx.work.impl.model.WorkSpec$WorkInfoPojo r28 = new androidx.work.impl.model.WorkSpec$WorkInfoPojo     // Catch:{ all -> 0x00d2 }
            r38 = r50
            r50 = r14
            r28.<init>(r29, r30, r31, r32, r34, r36, r38, r39, r40, r41, r43, r45, r46, r47, r49, r50, r51)     // Catch:{ all -> 0x00d2 }
            r1 = r28
            r15.add(r1)     // Catch:{ all -> 0x00d2 }
            r1 = r61
            r23 = r52
            goto L_0x0107
        L_0x02af:
            r4.close()
            return r15
        L_0x02b3:
            r4.close()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.model.RawWorkInfoDao_Impl.getWorkInfoPojos(androidx.sqlite.db.SupportSQLiteQuery):java.util.List");
    }

    public C1035e getWorkInfoPojosFlow(final SupportSQLiteQuery supportSQLiteQuery) {
        return CoroutinesRoom.createFlow(this.__db, false, new String[]{"WorkTag", "WorkProgress", "WorkSpec"}, new Callable<List<WorkSpec.WorkInfoPojo>>() {
            /* JADX WARNING: Removed duplicated region for block: B:104:0x022d A[Catch:{ all -> 0x00d1 }] */
            /* JADX WARNING: Removed duplicated region for block: B:106:0x0234 A[Catch:{ all -> 0x00d1 }] */
            /* JADX WARNING: Removed duplicated region for block: B:111:0x0241 A[Catch:{ all -> 0x00d1 }] */
            /* JADX WARNING: Removed duplicated region for block: B:113:0x0248 A[Catch:{ all -> 0x00d1 }] */
            /* JADX WARNING: Removed duplicated region for block: B:116:0x0256 A[Catch:{ all -> 0x00d1 }] */
            /* JADX WARNING: Removed duplicated region for block: B:118:0x025d A[Catch:{ all -> 0x00d1 }] */
            /* JADX WARNING: Removed duplicated region for block: B:119:0x0260 A[Catch:{ all -> 0x00d1 }] */
            /* JADX WARNING: Removed duplicated region for block: B:126:0x0284 A[Catch:{ all -> 0x00d1 }] */
            /* JADX WARNING: Removed duplicated region for block: B:129:0x0297 A[Catch:{ all -> 0x00d1 }] */
            /* JADX WARNING: Removed duplicated region for block: B:26:0x0125 A[Catch:{ all -> 0x00d1 }] */
            /* JADX WARNING: Removed duplicated region for block: B:27:0x0128 A[Catch:{ all -> 0x00d1 }] */
            /* JADX WARNING: Removed duplicated region for block: B:29:0x0134 A[Catch:{ all -> 0x00d1 }] */
            /* JADX WARNING: Removed duplicated region for block: B:30:0x0137 A[Catch:{ all -> 0x00d1 }] */
            /* JADX WARNING: Removed duplicated region for block: B:37:0x014e A[Catch:{ all -> 0x00d1 }] */
            /* JADX WARNING: Removed duplicated region for block: B:38:0x0151 A[Catch:{ all -> 0x00d1 }] */
            /* JADX WARNING: Removed duplicated region for block: B:40:0x0157 A[Catch:{ all -> 0x00d1 }] */
            /* JADX WARNING: Removed duplicated region for block: B:41:0x015a A[Catch:{ all -> 0x00d1 }] */
            /* JADX WARNING: Removed duplicated region for block: B:43:0x0160 A[Catch:{ all -> 0x00d1 }] */
            /* JADX WARNING: Removed duplicated region for block: B:44:0x0163 A[Catch:{ all -> 0x00d1 }] */
            /* JADX WARNING: Removed duplicated region for block: B:47:0x016b A[Catch:{ all -> 0x00d1 }] */
            /* JADX WARNING: Removed duplicated region for block: B:48:0x016e A[Catch:{ all -> 0x00d1 }] */
            /* JADX WARNING: Removed duplicated region for block: B:50:0x0174 A[Catch:{ all -> 0x00d1 }] */
            /* JADX WARNING: Removed duplicated region for block: B:51:0x0177 A[Catch:{ all -> 0x00d1 }] */
            /* JADX WARNING: Removed duplicated region for block: B:53:0x0181 A[Catch:{ all -> 0x00d1 }] */
            /* JADX WARNING: Removed duplicated region for block: B:54:0x0184 A[Catch:{ all -> 0x00d1 }] */
            /* JADX WARNING: Removed duplicated region for block: B:56:0x018a A[Catch:{ all -> 0x00d1 }] */
            /* JADX WARNING: Removed duplicated region for block: B:58:0x018f A[Catch:{ all -> 0x00d1 }] */
            /* JADX WARNING: Removed duplicated region for block: B:60:0x0196 A[Catch:{ all -> 0x00d1 }] */
            /* JADX WARNING: Removed duplicated region for block: B:62:0x019d A[Catch:{ all -> 0x00d1 }] */
            /* JADX WARNING: Removed duplicated region for block: B:64:0x01a6 A[Catch:{ all -> 0x00d1 }] */
            /* JADX WARNING: Removed duplicated region for block: B:66:0x01ad A[Catch:{ all -> 0x00d1 }] */
            /* JADX WARNING: Removed duplicated region for block: B:68:0x01b6 A[Catch:{ all -> 0x00d1 }] */
            /* JADX WARNING: Removed duplicated region for block: B:70:0x01bd A[Catch:{ all -> 0x00d1 }] */
            /* JADX WARNING: Removed duplicated region for block: B:72:0x01c4 A[Catch:{ all -> 0x00d1 }] */
            /* JADX WARNING: Removed duplicated region for block: B:74:0x01cb A[Catch:{ all -> 0x00d1 }] */
            /* JADX WARNING: Removed duplicated region for block: B:76:0x01d4 A[Catch:{ all -> 0x00d1 }] */
            /* JADX WARNING: Removed duplicated region for block: B:78:0x01db A[Catch:{ all -> 0x00d1 }] */
            /* JADX WARNING: Removed duplicated region for block: B:80:0x01e8 A[Catch:{ all -> 0x00d1 }] */
            /* JADX WARNING: Removed duplicated region for block: B:82:0x01ef A[Catch:{ all -> 0x00d1 }] */
            /* JADX WARNING: Removed duplicated region for block: B:88:0x01ff A[Catch:{ all -> 0x00d1 }] */
            /* JADX WARNING: Removed duplicated region for block: B:90:0x0206 A[Catch:{ all -> 0x00d1 }] */
            /* JADX WARNING: Removed duplicated region for block: B:96:0x0216 A[Catch:{ all -> 0x00d1 }] */
            /* JADX WARNING: Removed duplicated region for block: B:98:0x021d A[Catch:{ all -> 0x00d1 }] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.util.List<androidx.work.impl.model.WorkSpec.WorkInfoPojo> call() throws java.lang.Exception {
                /*
                    r62 = this;
                    r1 = r62
                    androidx.work.impl.model.RawWorkInfoDao_Impl r0 = androidx.work.impl.model.RawWorkInfoDao_Impl.this
                    androidx.room.RoomDatabase r0 = r0.__db
                    androidx.sqlite.db.SupportSQLiteQuery r2 = r5
                    r3 = 1
                    r4 = 0
                    android.database.Cursor r2 = androidx.room.util.DBUtil.query(r0, r2, r3, r4)
                    java.lang.String r0 = "id"
                    int r0 = androidx.room.util.CursorUtil.getColumnIndex(r2, r0)     // Catch:{ all -> 0x00d1 }
                    java.lang.String r5 = "state"
                    int r5 = androidx.room.util.CursorUtil.getColumnIndex(r2, r5)     // Catch:{ all -> 0x00d1 }
                    java.lang.String r6 = "output"
                    int r6 = androidx.room.util.CursorUtil.getColumnIndex(r2, r6)     // Catch:{ all -> 0x00d1 }
                    java.lang.String r7 = "initial_delay"
                    int r7 = androidx.room.util.CursorUtil.getColumnIndex(r2, r7)     // Catch:{ all -> 0x00d1 }
                    java.lang.String r8 = "interval_duration"
                    int r8 = androidx.room.util.CursorUtil.getColumnIndex(r2, r8)     // Catch:{ all -> 0x00d1 }
                    java.lang.String r9 = "flex_duration"
                    int r9 = androidx.room.util.CursorUtil.getColumnIndex(r2, r9)     // Catch:{ all -> 0x00d1 }
                    java.lang.String r10 = "run_attempt_count"
                    int r10 = androidx.room.util.CursorUtil.getColumnIndex(r2, r10)     // Catch:{ all -> 0x00d1 }
                    java.lang.String r11 = "backoff_policy"
                    int r11 = androidx.room.util.CursorUtil.getColumnIndex(r2, r11)     // Catch:{ all -> 0x00d1 }
                    java.lang.String r12 = "backoff_delay_duration"
                    int r12 = androidx.room.util.CursorUtil.getColumnIndex(r2, r12)     // Catch:{ all -> 0x00d1 }
                    java.lang.String r13 = "last_enqueue_time"
                    int r13 = androidx.room.util.CursorUtil.getColumnIndex(r2, r13)     // Catch:{ all -> 0x00d1 }
                    java.lang.String r14 = "period_count"
                    int r14 = androidx.room.util.CursorUtil.getColumnIndex(r2, r14)     // Catch:{ all -> 0x00d1 }
                    java.lang.String r15 = "generation"
                    int r15 = androidx.room.util.CursorUtil.getColumnIndex(r2, r15)     // Catch:{ all -> 0x00d1 }
                    java.lang.String r3 = "next_schedule_time_override"
                    int r3 = androidx.room.util.CursorUtil.getColumnIndex(r2, r3)     // Catch:{ all -> 0x00d1 }
                    java.lang.String r4 = "stop_reason"
                    int r4 = androidx.room.util.CursorUtil.getColumnIndex(r2, r4)     // Catch:{ all -> 0x00d1 }
                    r16 = r4
                    java.lang.String r4 = "required_network_type"
                    int r4 = androidx.room.util.CursorUtil.getColumnIndex(r2, r4)     // Catch:{ all -> 0x00d1 }
                    r17 = r4
                    java.lang.String r4 = "requires_charging"
                    int r4 = androidx.room.util.CursorUtil.getColumnIndex(r2, r4)     // Catch:{ all -> 0x00d1 }
                    r18 = r4
                    java.lang.String r4 = "requires_device_idle"
                    int r4 = androidx.room.util.CursorUtil.getColumnIndex(r2, r4)     // Catch:{ all -> 0x00d1 }
                    r19 = r4
                    java.lang.String r4 = "requires_battery_not_low"
                    int r4 = androidx.room.util.CursorUtil.getColumnIndex(r2, r4)     // Catch:{ all -> 0x00d1 }
                    r20 = r4
                    java.lang.String r4 = "requires_storage_not_low"
                    int r4 = androidx.room.util.CursorUtil.getColumnIndex(r2, r4)     // Catch:{ all -> 0x00d1 }
                    r21 = r4
                    java.lang.String r4 = "trigger_content_update_delay"
                    int r4 = androidx.room.util.CursorUtil.getColumnIndex(r2, r4)     // Catch:{ all -> 0x00d1 }
                    r22 = r4
                    java.lang.String r4 = "trigger_max_content_delay"
                    int r4 = androidx.room.util.CursorUtil.getColumnIndex(r2, r4)     // Catch:{ all -> 0x00d1 }
                    r23 = r4
                    java.lang.String r4 = "content_uri_triggers"
                    int r4 = androidx.room.util.CursorUtil.getColumnIndex(r2, r4)     // Catch:{ all -> 0x00d1 }
                    r24 = r4
                    java.util.HashMap r4 = new java.util.HashMap     // Catch:{ all -> 0x00d1 }
                    r4.<init>()     // Catch:{ all -> 0x00d1 }
                    r25 = r3
                    java.util.HashMap r3 = new java.util.HashMap     // Catch:{ all -> 0x00d1 }
                    r3.<init>()     // Catch:{ all -> 0x00d1 }
                L_0x00b2:
                    boolean r26 = r2.moveToNext()     // Catch:{ all -> 0x00d1 }
                    if (r26 == 0) goto L_0x00ef
                    r26 = r15
                    java.lang.String r15 = r2.getString(r0)     // Catch:{ all -> 0x00d1 }
                    java.lang.Object r27 = r4.get(r15)     // Catch:{ all -> 0x00d1 }
                    java.util.ArrayList r27 = (java.util.ArrayList) r27     // Catch:{ all -> 0x00d1 }
                    if (r27 != 0) goto L_0x00d4
                    r27 = r14
                    java.util.ArrayList r14 = new java.util.ArrayList     // Catch:{ all -> 0x00d1 }
                    r14.<init>()     // Catch:{ all -> 0x00d1 }
                    r4.put(r15, r14)     // Catch:{ all -> 0x00d1 }
                    goto L_0x00d6
                L_0x00d1:
                    r0 = move-exception
                    goto L_0x02b8
                L_0x00d4:
                    r27 = r14
                L_0x00d6:
                    java.lang.String r14 = r2.getString(r0)     // Catch:{ all -> 0x00d1 }
                    java.lang.Object r15 = r3.get(r14)     // Catch:{ all -> 0x00d1 }
                    java.util.ArrayList r15 = (java.util.ArrayList) r15     // Catch:{ all -> 0x00d1 }
                    if (r15 != 0) goto L_0x00ea
                    java.util.ArrayList r15 = new java.util.ArrayList     // Catch:{ all -> 0x00d1 }
                    r15.<init>()     // Catch:{ all -> 0x00d1 }
                    r3.put(r14, r15)     // Catch:{ all -> 0x00d1 }
                L_0x00ea:
                    r15 = r26
                    r14 = r27
                    goto L_0x00b2
                L_0x00ef:
                    r27 = r14
                    r26 = r15
                    r14 = -1
                    r2.moveToPosition(r14)     // Catch:{ all -> 0x00d1 }
                    androidx.work.impl.model.RawWorkInfoDao_Impl r15 = androidx.work.impl.model.RawWorkInfoDao_Impl.this     // Catch:{ all -> 0x00d1 }
                    r15.__fetchRelationshipWorkTagAsjavaLangString(r4)     // Catch:{ all -> 0x00d1 }
                    androidx.work.impl.model.RawWorkInfoDao_Impl r15 = androidx.work.impl.model.RawWorkInfoDao_Impl.this     // Catch:{ all -> 0x00d1 }
                    r15.__fetchRelationshipWorkProgressAsandroidxWorkData(r3)     // Catch:{ all -> 0x00d1 }
                    java.util.ArrayList r15 = new java.util.ArrayList     // Catch:{ all -> 0x00d1 }
                    int r14 = r2.getCount()     // Catch:{ all -> 0x00d1 }
                    r15.<init>(r14)     // Catch:{ all -> 0x00d1 }
                L_0x010a:
                    boolean r14 = r2.moveToNext()     // Catch:{ all -> 0x00d1 }
                    if (r14 == 0) goto L_0x02b4
                    r14 = -1
                    if (r0 != r14) goto L_0x0116
                L_0x0113:
                    r30 = 0
                    goto L_0x0123
                L_0x0116:
                    boolean r28 = r2.isNull(r0)     // Catch:{ all -> 0x00d1 }
                    if (r28 == 0) goto L_0x011d
                    goto L_0x0113
                L_0x011d:
                    java.lang.String r28 = r2.getString(r0)     // Catch:{ all -> 0x00d1 }
                    r30 = r28
                L_0x0123:
                    if (r5 != r14) goto L_0x0128
                    r31 = 0
                    goto L_0x0132
                L_0x0128:
                    int r28 = r2.getInt(r5)     // Catch:{ all -> 0x00d1 }
                    androidx.work.WorkInfo$State r28 = androidx.work.impl.model.WorkTypeConverters.intToState(r28)     // Catch:{ all -> 0x00d1 }
                    r31 = r28
                L_0x0132:
                    if (r6 != r14) goto L_0x0137
                    r32 = 0
                    goto L_0x0149
                L_0x0137:
                    boolean r14 = r2.isNull(r6)     // Catch:{ all -> 0x00d1 }
                    if (r14 == 0) goto L_0x013f
                    r14 = 0
                    goto L_0x0143
                L_0x013f:
                    byte[] r14 = r2.getBlob(r6)     // Catch:{ all -> 0x00d1 }
                L_0x0143:
                    androidx.work.Data r14 = androidx.work.Data.fromByteArray(r14)     // Catch:{ all -> 0x00d1 }
                    r32 = r14
                L_0x0149:
                    r33 = 0
                    r14 = -1
                    if (r7 != r14) goto L_0x0151
                    r28 = r33
                    goto L_0x0155
                L_0x0151:
                    long r28 = r2.getLong(r7)     // Catch:{ all -> 0x00d1 }
                L_0x0155:
                    if (r8 != r14) goto L_0x015a
                    r35 = r33
                    goto L_0x015e
                L_0x015a:
                    long r35 = r2.getLong(r8)     // Catch:{ all -> 0x00d1 }
                L_0x015e:
                    if (r9 != r14) goto L_0x0163
                    r37 = r33
                    goto L_0x0167
                L_0x0163:
                    long r37 = r2.getLong(r9)     // Catch:{ all -> 0x00d1 }
                L_0x0167:
                    r39 = 0
                    if (r10 != r14) goto L_0x016e
                    r40 = 0
                    goto L_0x0172
                L_0x016e:
                    int r40 = r2.getInt(r10)     // Catch:{ all -> 0x00d1 }
                L_0x0172:
                    if (r11 != r14) goto L_0x0177
                    r41 = 0
                    goto L_0x017f
                L_0x0177:
                    int r41 = r2.getInt(r11)     // Catch:{ all -> 0x00d1 }
                    androidx.work.BackoffPolicy r41 = androidx.work.impl.model.WorkTypeConverters.intToBackoffPolicy(r41)     // Catch:{ all -> 0x00d1 }
                L_0x017f:
                    if (r12 != r14) goto L_0x0184
                    r42 = r33
                    goto L_0x0188
                L_0x0184:
                    long r42 = r2.getLong(r12)     // Catch:{ all -> 0x00d1 }
                L_0x0188:
                    if (r13 != r14) goto L_0x018f
                    r44 = r33
                L_0x018c:
                    r1 = r27
                    goto L_0x0194
                L_0x018f:
                    long r44 = r2.getLong(r13)     // Catch:{ all -> 0x00d1 }
                    goto L_0x018c
                L_0x0194:
                    if (r1 != r14) goto L_0x019d
                    r46 = 0
                L_0x0198:
                    r27 = r1
                    r1 = r26
                    goto L_0x01a4
                L_0x019d:
                    int r27 = r2.getInt(r1)     // Catch:{ all -> 0x00d1 }
                    r46 = r27
                    goto L_0x0198
                L_0x01a4:
                    if (r1 != r14) goto L_0x01ad
                    r47 = 0
                L_0x01a8:
                    r26 = r1
                    r1 = r25
                    goto L_0x01b4
                L_0x01ad:
                    int r26 = r2.getInt(r1)     // Catch:{ all -> 0x00d1 }
                    r47 = r26
                    goto L_0x01a8
                L_0x01b4:
                    if (r1 != r14) goto L_0x01bd
                    r48 = r33
                L_0x01b8:
                    r25 = r1
                    r1 = r16
                    goto L_0x01c2
                L_0x01bd:
                    long r48 = r2.getLong(r1)     // Catch:{ all -> 0x00d1 }
                    goto L_0x01b8
                L_0x01c2:
                    if (r1 != r14) goto L_0x01cb
                    r50 = 0
                L_0x01c6:
                    r16 = r1
                    r1 = r17
                    goto L_0x01d2
                L_0x01cb:
                    int r16 = r2.getInt(r1)     // Catch:{ all -> 0x00d1 }
                    r50 = r16
                    goto L_0x01c6
                L_0x01d2:
                    if (r1 != r14) goto L_0x01db
                    r52 = 0
                L_0x01d6:
                    r17 = r1
                    r1 = r18
                    goto L_0x01e6
                L_0x01db:
                    int r17 = r2.getInt(r1)     // Catch:{ all -> 0x00d1 }
                    androidx.work.NetworkType r17 = androidx.work.impl.model.WorkTypeConverters.intToNetworkType(r17)     // Catch:{ all -> 0x00d1 }
                    r52 = r17
                    goto L_0x01d6
                L_0x01e6:
                    if (r1 != r14) goto L_0x01ef
                    r53 = 0
                L_0x01ea:
                    r18 = r1
                    r1 = r19
                    goto L_0x01fd
                L_0x01ef:
                    int r18 = r2.getInt(r1)     // Catch:{ all -> 0x00d1 }
                    if (r18 == 0) goto L_0x01f8
                    r18 = 1
                    goto L_0x01fa
                L_0x01f8:
                    r18 = 0
                L_0x01fa:
                    r53 = r18
                    goto L_0x01ea
                L_0x01fd:
                    if (r1 != r14) goto L_0x0206
                    r54 = 0
                L_0x0201:
                    r19 = r1
                    r1 = r20
                    goto L_0x0214
                L_0x0206:
                    int r19 = r2.getInt(r1)     // Catch:{ all -> 0x00d1 }
                    if (r19 == 0) goto L_0x020f
                    r19 = 1
                    goto L_0x0211
                L_0x020f:
                    r19 = 0
                L_0x0211:
                    r54 = r19
                    goto L_0x0201
                L_0x0214:
                    if (r1 != r14) goto L_0x021d
                    r55 = 0
                L_0x0218:
                    r20 = r1
                    r1 = r21
                    goto L_0x022b
                L_0x021d:
                    int r20 = r2.getInt(r1)     // Catch:{ all -> 0x00d1 }
                    if (r20 == 0) goto L_0x0226
                    r20 = 1
                    goto L_0x0228
                L_0x0226:
                    r20 = 0
                L_0x0228:
                    r55 = r20
                    goto L_0x0218
                L_0x022b:
                    if (r1 != r14) goto L_0x0234
                    r56 = 0
                L_0x022f:
                    r21 = r1
                    r1 = r22
                    goto L_0x023f
                L_0x0234:
                    int r21 = r2.getInt(r1)     // Catch:{ all -> 0x00d1 }
                    if (r21 == 0) goto L_0x023c
                    r39 = 1
                L_0x023c:
                    r56 = r39
                    goto L_0x022f
                L_0x023f:
                    if (r1 != r14) goto L_0x0248
                    r57 = r33
                L_0x0243:
                    r22 = r1
                    r1 = r23
                    goto L_0x024d
                L_0x0248:
                    long r57 = r2.getLong(r1)     // Catch:{ all -> 0x00d1 }
                    goto L_0x0243
                L_0x024d:
                    if (r1 != r14) goto L_0x0256
                L_0x024f:
                    r23 = r1
                    r1 = r24
                    r59 = r33
                    goto L_0x025b
                L_0x0256:
                    long r33 = r2.getLong(r1)     // Catch:{ all -> 0x00d1 }
                    goto L_0x024f
                L_0x025b:
                    if (r1 != r14) goto L_0x0260
                    r61 = 0
                    goto L_0x0273
                L_0x0260:
                    boolean r24 = r2.isNull(r1)     // Catch:{ all -> 0x00d1 }
                    if (r24 == 0) goto L_0x0269
                    r24 = 0
                    goto L_0x026d
                L_0x0269:
                    byte[] r24 = r2.getBlob(r1)     // Catch:{ all -> 0x00d1 }
                L_0x026d:
                    java.util.Set r24 = androidx.work.impl.model.WorkTypeConverters.byteArrayToSetOfTriggers(r24)     // Catch:{ all -> 0x00d1 }
                    r61 = r24
                L_0x0273:
                    androidx.work.Constraints r51 = new androidx.work.Constraints     // Catch:{ all -> 0x00d1 }
                    r51.<init>(r52, r53, r54, r55, r56, r57, r59, r61)     // Catch:{ all -> 0x00d1 }
                    java.lang.String r14 = r2.getString(r0)     // Catch:{ all -> 0x00d1 }
                    java.lang.Object r14 = r4.get(r14)     // Catch:{ all -> 0x00d1 }
                    java.util.ArrayList r14 = (java.util.ArrayList) r14     // Catch:{ all -> 0x00d1 }
                    if (r14 != 0) goto L_0x0289
                    java.util.ArrayList r14 = new java.util.ArrayList     // Catch:{ all -> 0x00d1 }
                    r14.<init>()     // Catch:{ all -> 0x00d1 }
                L_0x0289:
                    r53 = r1
                    java.lang.String r1 = r2.getString(r0)     // Catch:{ all -> 0x00d1 }
                    java.lang.Object r1 = r3.get(r1)     // Catch:{ all -> 0x00d1 }
                    java.util.ArrayList r1 = (java.util.ArrayList) r1     // Catch:{ all -> 0x00d1 }
                    if (r1 != 0) goto L_0x029c
                    java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x00d1 }
                    r1.<init>()     // Catch:{ all -> 0x00d1 }
                L_0x029c:
                    r52 = r1
                    r33 = r28
                    androidx.work.impl.model.WorkSpec$WorkInfoPojo r29 = new androidx.work.impl.model.WorkSpec$WorkInfoPojo     // Catch:{ all -> 0x00d1 }
                    r39 = r51
                    r51 = r14
                    r29.<init>(r30, r31, r32, r33, r35, r37, r39, r40, r41, r42, r44, r46, r47, r48, r50, r51, r52)     // Catch:{ all -> 0x00d1 }
                    r1 = r29
                    r15.add(r1)     // Catch:{ all -> 0x00d1 }
                    r1 = r62
                    r24 = r53
                    goto L_0x010a
                L_0x02b4:
                    r2.close()
                    return r15
                L_0x02b8:
                    r2.close()
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.model.RawWorkInfoDao_Impl.AnonymousClass2.call():java.util.List");
            }
        });
    }

    public LiveData<List<WorkSpec.WorkInfoPojo>> getWorkInfoPojosLiveData(final SupportSQLiteQuery supportSQLiteQuery) {
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"WorkTag", "WorkProgress", "WorkSpec"}, false, new Callable<List<WorkSpec.WorkInfoPojo>>() {
            /* JADX WARNING: Removed duplicated region for block: B:104:0x022d A[Catch:{ all -> 0x00d1 }] */
            /* JADX WARNING: Removed duplicated region for block: B:106:0x0234 A[Catch:{ all -> 0x00d1 }] */
            /* JADX WARNING: Removed duplicated region for block: B:111:0x0241 A[Catch:{ all -> 0x00d1 }] */
            /* JADX WARNING: Removed duplicated region for block: B:113:0x0248 A[Catch:{ all -> 0x00d1 }] */
            /* JADX WARNING: Removed duplicated region for block: B:116:0x0256 A[Catch:{ all -> 0x00d1 }] */
            /* JADX WARNING: Removed duplicated region for block: B:118:0x025d A[Catch:{ all -> 0x00d1 }] */
            /* JADX WARNING: Removed duplicated region for block: B:119:0x0260 A[Catch:{ all -> 0x00d1 }] */
            /* JADX WARNING: Removed duplicated region for block: B:126:0x0284 A[Catch:{ all -> 0x00d1 }] */
            /* JADX WARNING: Removed duplicated region for block: B:129:0x0297 A[Catch:{ all -> 0x00d1 }] */
            /* JADX WARNING: Removed duplicated region for block: B:26:0x0125 A[Catch:{ all -> 0x00d1 }] */
            /* JADX WARNING: Removed duplicated region for block: B:27:0x0128 A[Catch:{ all -> 0x00d1 }] */
            /* JADX WARNING: Removed duplicated region for block: B:29:0x0134 A[Catch:{ all -> 0x00d1 }] */
            /* JADX WARNING: Removed duplicated region for block: B:30:0x0137 A[Catch:{ all -> 0x00d1 }] */
            /* JADX WARNING: Removed duplicated region for block: B:37:0x014e A[Catch:{ all -> 0x00d1 }] */
            /* JADX WARNING: Removed duplicated region for block: B:38:0x0151 A[Catch:{ all -> 0x00d1 }] */
            /* JADX WARNING: Removed duplicated region for block: B:40:0x0157 A[Catch:{ all -> 0x00d1 }] */
            /* JADX WARNING: Removed duplicated region for block: B:41:0x015a A[Catch:{ all -> 0x00d1 }] */
            /* JADX WARNING: Removed duplicated region for block: B:43:0x0160 A[Catch:{ all -> 0x00d1 }] */
            /* JADX WARNING: Removed duplicated region for block: B:44:0x0163 A[Catch:{ all -> 0x00d1 }] */
            /* JADX WARNING: Removed duplicated region for block: B:47:0x016b A[Catch:{ all -> 0x00d1 }] */
            /* JADX WARNING: Removed duplicated region for block: B:48:0x016e A[Catch:{ all -> 0x00d1 }] */
            /* JADX WARNING: Removed duplicated region for block: B:50:0x0174 A[Catch:{ all -> 0x00d1 }] */
            /* JADX WARNING: Removed duplicated region for block: B:51:0x0177 A[Catch:{ all -> 0x00d1 }] */
            /* JADX WARNING: Removed duplicated region for block: B:53:0x0181 A[Catch:{ all -> 0x00d1 }] */
            /* JADX WARNING: Removed duplicated region for block: B:54:0x0184 A[Catch:{ all -> 0x00d1 }] */
            /* JADX WARNING: Removed duplicated region for block: B:56:0x018a A[Catch:{ all -> 0x00d1 }] */
            /* JADX WARNING: Removed duplicated region for block: B:58:0x018f A[Catch:{ all -> 0x00d1 }] */
            /* JADX WARNING: Removed duplicated region for block: B:60:0x0196 A[Catch:{ all -> 0x00d1 }] */
            /* JADX WARNING: Removed duplicated region for block: B:62:0x019d A[Catch:{ all -> 0x00d1 }] */
            /* JADX WARNING: Removed duplicated region for block: B:64:0x01a6 A[Catch:{ all -> 0x00d1 }] */
            /* JADX WARNING: Removed duplicated region for block: B:66:0x01ad A[Catch:{ all -> 0x00d1 }] */
            /* JADX WARNING: Removed duplicated region for block: B:68:0x01b6 A[Catch:{ all -> 0x00d1 }] */
            /* JADX WARNING: Removed duplicated region for block: B:70:0x01bd A[Catch:{ all -> 0x00d1 }] */
            /* JADX WARNING: Removed duplicated region for block: B:72:0x01c4 A[Catch:{ all -> 0x00d1 }] */
            /* JADX WARNING: Removed duplicated region for block: B:74:0x01cb A[Catch:{ all -> 0x00d1 }] */
            /* JADX WARNING: Removed duplicated region for block: B:76:0x01d4 A[Catch:{ all -> 0x00d1 }] */
            /* JADX WARNING: Removed duplicated region for block: B:78:0x01db A[Catch:{ all -> 0x00d1 }] */
            /* JADX WARNING: Removed duplicated region for block: B:80:0x01e8 A[Catch:{ all -> 0x00d1 }] */
            /* JADX WARNING: Removed duplicated region for block: B:82:0x01ef A[Catch:{ all -> 0x00d1 }] */
            /* JADX WARNING: Removed duplicated region for block: B:88:0x01ff A[Catch:{ all -> 0x00d1 }] */
            /* JADX WARNING: Removed duplicated region for block: B:90:0x0206 A[Catch:{ all -> 0x00d1 }] */
            /* JADX WARNING: Removed duplicated region for block: B:96:0x0216 A[Catch:{ all -> 0x00d1 }] */
            /* JADX WARNING: Removed duplicated region for block: B:98:0x021d A[Catch:{ all -> 0x00d1 }] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.util.List<androidx.work.impl.model.WorkSpec.WorkInfoPojo> call() throws java.lang.Exception {
                /*
                    r62 = this;
                    r1 = r62
                    androidx.work.impl.model.RawWorkInfoDao_Impl r0 = androidx.work.impl.model.RawWorkInfoDao_Impl.this
                    androidx.room.RoomDatabase r0 = r0.__db
                    androidx.sqlite.db.SupportSQLiteQuery r2 = r5
                    r3 = 1
                    r4 = 0
                    android.database.Cursor r2 = androidx.room.util.DBUtil.query(r0, r2, r3, r4)
                    java.lang.String r0 = "id"
                    int r0 = androidx.room.util.CursorUtil.getColumnIndex(r2, r0)     // Catch:{ all -> 0x00d1 }
                    java.lang.String r5 = "state"
                    int r5 = androidx.room.util.CursorUtil.getColumnIndex(r2, r5)     // Catch:{ all -> 0x00d1 }
                    java.lang.String r6 = "output"
                    int r6 = androidx.room.util.CursorUtil.getColumnIndex(r2, r6)     // Catch:{ all -> 0x00d1 }
                    java.lang.String r7 = "initial_delay"
                    int r7 = androidx.room.util.CursorUtil.getColumnIndex(r2, r7)     // Catch:{ all -> 0x00d1 }
                    java.lang.String r8 = "interval_duration"
                    int r8 = androidx.room.util.CursorUtil.getColumnIndex(r2, r8)     // Catch:{ all -> 0x00d1 }
                    java.lang.String r9 = "flex_duration"
                    int r9 = androidx.room.util.CursorUtil.getColumnIndex(r2, r9)     // Catch:{ all -> 0x00d1 }
                    java.lang.String r10 = "run_attempt_count"
                    int r10 = androidx.room.util.CursorUtil.getColumnIndex(r2, r10)     // Catch:{ all -> 0x00d1 }
                    java.lang.String r11 = "backoff_policy"
                    int r11 = androidx.room.util.CursorUtil.getColumnIndex(r2, r11)     // Catch:{ all -> 0x00d1 }
                    java.lang.String r12 = "backoff_delay_duration"
                    int r12 = androidx.room.util.CursorUtil.getColumnIndex(r2, r12)     // Catch:{ all -> 0x00d1 }
                    java.lang.String r13 = "last_enqueue_time"
                    int r13 = androidx.room.util.CursorUtil.getColumnIndex(r2, r13)     // Catch:{ all -> 0x00d1 }
                    java.lang.String r14 = "period_count"
                    int r14 = androidx.room.util.CursorUtil.getColumnIndex(r2, r14)     // Catch:{ all -> 0x00d1 }
                    java.lang.String r15 = "generation"
                    int r15 = androidx.room.util.CursorUtil.getColumnIndex(r2, r15)     // Catch:{ all -> 0x00d1 }
                    java.lang.String r3 = "next_schedule_time_override"
                    int r3 = androidx.room.util.CursorUtil.getColumnIndex(r2, r3)     // Catch:{ all -> 0x00d1 }
                    java.lang.String r4 = "stop_reason"
                    int r4 = androidx.room.util.CursorUtil.getColumnIndex(r2, r4)     // Catch:{ all -> 0x00d1 }
                    r16 = r4
                    java.lang.String r4 = "required_network_type"
                    int r4 = androidx.room.util.CursorUtil.getColumnIndex(r2, r4)     // Catch:{ all -> 0x00d1 }
                    r17 = r4
                    java.lang.String r4 = "requires_charging"
                    int r4 = androidx.room.util.CursorUtil.getColumnIndex(r2, r4)     // Catch:{ all -> 0x00d1 }
                    r18 = r4
                    java.lang.String r4 = "requires_device_idle"
                    int r4 = androidx.room.util.CursorUtil.getColumnIndex(r2, r4)     // Catch:{ all -> 0x00d1 }
                    r19 = r4
                    java.lang.String r4 = "requires_battery_not_low"
                    int r4 = androidx.room.util.CursorUtil.getColumnIndex(r2, r4)     // Catch:{ all -> 0x00d1 }
                    r20 = r4
                    java.lang.String r4 = "requires_storage_not_low"
                    int r4 = androidx.room.util.CursorUtil.getColumnIndex(r2, r4)     // Catch:{ all -> 0x00d1 }
                    r21 = r4
                    java.lang.String r4 = "trigger_content_update_delay"
                    int r4 = androidx.room.util.CursorUtil.getColumnIndex(r2, r4)     // Catch:{ all -> 0x00d1 }
                    r22 = r4
                    java.lang.String r4 = "trigger_max_content_delay"
                    int r4 = androidx.room.util.CursorUtil.getColumnIndex(r2, r4)     // Catch:{ all -> 0x00d1 }
                    r23 = r4
                    java.lang.String r4 = "content_uri_triggers"
                    int r4 = androidx.room.util.CursorUtil.getColumnIndex(r2, r4)     // Catch:{ all -> 0x00d1 }
                    r24 = r4
                    java.util.HashMap r4 = new java.util.HashMap     // Catch:{ all -> 0x00d1 }
                    r4.<init>()     // Catch:{ all -> 0x00d1 }
                    r25 = r3
                    java.util.HashMap r3 = new java.util.HashMap     // Catch:{ all -> 0x00d1 }
                    r3.<init>()     // Catch:{ all -> 0x00d1 }
                L_0x00b2:
                    boolean r26 = r2.moveToNext()     // Catch:{ all -> 0x00d1 }
                    if (r26 == 0) goto L_0x00ef
                    r26 = r15
                    java.lang.String r15 = r2.getString(r0)     // Catch:{ all -> 0x00d1 }
                    java.lang.Object r27 = r4.get(r15)     // Catch:{ all -> 0x00d1 }
                    java.util.ArrayList r27 = (java.util.ArrayList) r27     // Catch:{ all -> 0x00d1 }
                    if (r27 != 0) goto L_0x00d4
                    r27 = r14
                    java.util.ArrayList r14 = new java.util.ArrayList     // Catch:{ all -> 0x00d1 }
                    r14.<init>()     // Catch:{ all -> 0x00d1 }
                    r4.put(r15, r14)     // Catch:{ all -> 0x00d1 }
                    goto L_0x00d6
                L_0x00d1:
                    r0 = move-exception
                    goto L_0x02b8
                L_0x00d4:
                    r27 = r14
                L_0x00d6:
                    java.lang.String r14 = r2.getString(r0)     // Catch:{ all -> 0x00d1 }
                    java.lang.Object r15 = r3.get(r14)     // Catch:{ all -> 0x00d1 }
                    java.util.ArrayList r15 = (java.util.ArrayList) r15     // Catch:{ all -> 0x00d1 }
                    if (r15 != 0) goto L_0x00ea
                    java.util.ArrayList r15 = new java.util.ArrayList     // Catch:{ all -> 0x00d1 }
                    r15.<init>()     // Catch:{ all -> 0x00d1 }
                    r3.put(r14, r15)     // Catch:{ all -> 0x00d1 }
                L_0x00ea:
                    r15 = r26
                    r14 = r27
                    goto L_0x00b2
                L_0x00ef:
                    r27 = r14
                    r26 = r15
                    r14 = -1
                    r2.moveToPosition(r14)     // Catch:{ all -> 0x00d1 }
                    androidx.work.impl.model.RawWorkInfoDao_Impl r15 = androidx.work.impl.model.RawWorkInfoDao_Impl.this     // Catch:{ all -> 0x00d1 }
                    r15.__fetchRelationshipWorkTagAsjavaLangString(r4)     // Catch:{ all -> 0x00d1 }
                    androidx.work.impl.model.RawWorkInfoDao_Impl r15 = androidx.work.impl.model.RawWorkInfoDao_Impl.this     // Catch:{ all -> 0x00d1 }
                    r15.__fetchRelationshipWorkProgressAsandroidxWorkData(r3)     // Catch:{ all -> 0x00d1 }
                    java.util.ArrayList r15 = new java.util.ArrayList     // Catch:{ all -> 0x00d1 }
                    int r14 = r2.getCount()     // Catch:{ all -> 0x00d1 }
                    r15.<init>(r14)     // Catch:{ all -> 0x00d1 }
                L_0x010a:
                    boolean r14 = r2.moveToNext()     // Catch:{ all -> 0x00d1 }
                    if (r14 == 0) goto L_0x02b4
                    r14 = -1
                    if (r0 != r14) goto L_0x0116
                L_0x0113:
                    r30 = 0
                    goto L_0x0123
                L_0x0116:
                    boolean r28 = r2.isNull(r0)     // Catch:{ all -> 0x00d1 }
                    if (r28 == 0) goto L_0x011d
                    goto L_0x0113
                L_0x011d:
                    java.lang.String r28 = r2.getString(r0)     // Catch:{ all -> 0x00d1 }
                    r30 = r28
                L_0x0123:
                    if (r5 != r14) goto L_0x0128
                    r31 = 0
                    goto L_0x0132
                L_0x0128:
                    int r28 = r2.getInt(r5)     // Catch:{ all -> 0x00d1 }
                    androidx.work.WorkInfo$State r28 = androidx.work.impl.model.WorkTypeConverters.intToState(r28)     // Catch:{ all -> 0x00d1 }
                    r31 = r28
                L_0x0132:
                    if (r6 != r14) goto L_0x0137
                    r32 = 0
                    goto L_0x0149
                L_0x0137:
                    boolean r14 = r2.isNull(r6)     // Catch:{ all -> 0x00d1 }
                    if (r14 == 0) goto L_0x013f
                    r14 = 0
                    goto L_0x0143
                L_0x013f:
                    byte[] r14 = r2.getBlob(r6)     // Catch:{ all -> 0x00d1 }
                L_0x0143:
                    androidx.work.Data r14 = androidx.work.Data.fromByteArray(r14)     // Catch:{ all -> 0x00d1 }
                    r32 = r14
                L_0x0149:
                    r33 = 0
                    r14 = -1
                    if (r7 != r14) goto L_0x0151
                    r28 = r33
                    goto L_0x0155
                L_0x0151:
                    long r28 = r2.getLong(r7)     // Catch:{ all -> 0x00d1 }
                L_0x0155:
                    if (r8 != r14) goto L_0x015a
                    r35 = r33
                    goto L_0x015e
                L_0x015a:
                    long r35 = r2.getLong(r8)     // Catch:{ all -> 0x00d1 }
                L_0x015e:
                    if (r9 != r14) goto L_0x0163
                    r37 = r33
                    goto L_0x0167
                L_0x0163:
                    long r37 = r2.getLong(r9)     // Catch:{ all -> 0x00d1 }
                L_0x0167:
                    r39 = 0
                    if (r10 != r14) goto L_0x016e
                    r40 = 0
                    goto L_0x0172
                L_0x016e:
                    int r40 = r2.getInt(r10)     // Catch:{ all -> 0x00d1 }
                L_0x0172:
                    if (r11 != r14) goto L_0x0177
                    r41 = 0
                    goto L_0x017f
                L_0x0177:
                    int r41 = r2.getInt(r11)     // Catch:{ all -> 0x00d1 }
                    androidx.work.BackoffPolicy r41 = androidx.work.impl.model.WorkTypeConverters.intToBackoffPolicy(r41)     // Catch:{ all -> 0x00d1 }
                L_0x017f:
                    if (r12 != r14) goto L_0x0184
                    r42 = r33
                    goto L_0x0188
                L_0x0184:
                    long r42 = r2.getLong(r12)     // Catch:{ all -> 0x00d1 }
                L_0x0188:
                    if (r13 != r14) goto L_0x018f
                    r44 = r33
                L_0x018c:
                    r1 = r27
                    goto L_0x0194
                L_0x018f:
                    long r44 = r2.getLong(r13)     // Catch:{ all -> 0x00d1 }
                    goto L_0x018c
                L_0x0194:
                    if (r1 != r14) goto L_0x019d
                    r46 = 0
                L_0x0198:
                    r27 = r1
                    r1 = r26
                    goto L_0x01a4
                L_0x019d:
                    int r27 = r2.getInt(r1)     // Catch:{ all -> 0x00d1 }
                    r46 = r27
                    goto L_0x0198
                L_0x01a4:
                    if (r1 != r14) goto L_0x01ad
                    r47 = 0
                L_0x01a8:
                    r26 = r1
                    r1 = r25
                    goto L_0x01b4
                L_0x01ad:
                    int r26 = r2.getInt(r1)     // Catch:{ all -> 0x00d1 }
                    r47 = r26
                    goto L_0x01a8
                L_0x01b4:
                    if (r1 != r14) goto L_0x01bd
                    r48 = r33
                L_0x01b8:
                    r25 = r1
                    r1 = r16
                    goto L_0x01c2
                L_0x01bd:
                    long r48 = r2.getLong(r1)     // Catch:{ all -> 0x00d1 }
                    goto L_0x01b8
                L_0x01c2:
                    if (r1 != r14) goto L_0x01cb
                    r50 = 0
                L_0x01c6:
                    r16 = r1
                    r1 = r17
                    goto L_0x01d2
                L_0x01cb:
                    int r16 = r2.getInt(r1)     // Catch:{ all -> 0x00d1 }
                    r50 = r16
                    goto L_0x01c6
                L_0x01d2:
                    if (r1 != r14) goto L_0x01db
                    r52 = 0
                L_0x01d6:
                    r17 = r1
                    r1 = r18
                    goto L_0x01e6
                L_0x01db:
                    int r17 = r2.getInt(r1)     // Catch:{ all -> 0x00d1 }
                    androidx.work.NetworkType r17 = androidx.work.impl.model.WorkTypeConverters.intToNetworkType(r17)     // Catch:{ all -> 0x00d1 }
                    r52 = r17
                    goto L_0x01d6
                L_0x01e6:
                    if (r1 != r14) goto L_0x01ef
                    r53 = 0
                L_0x01ea:
                    r18 = r1
                    r1 = r19
                    goto L_0x01fd
                L_0x01ef:
                    int r18 = r2.getInt(r1)     // Catch:{ all -> 0x00d1 }
                    if (r18 == 0) goto L_0x01f8
                    r18 = 1
                    goto L_0x01fa
                L_0x01f8:
                    r18 = 0
                L_0x01fa:
                    r53 = r18
                    goto L_0x01ea
                L_0x01fd:
                    if (r1 != r14) goto L_0x0206
                    r54 = 0
                L_0x0201:
                    r19 = r1
                    r1 = r20
                    goto L_0x0214
                L_0x0206:
                    int r19 = r2.getInt(r1)     // Catch:{ all -> 0x00d1 }
                    if (r19 == 0) goto L_0x020f
                    r19 = 1
                    goto L_0x0211
                L_0x020f:
                    r19 = 0
                L_0x0211:
                    r54 = r19
                    goto L_0x0201
                L_0x0214:
                    if (r1 != r14) goto L_0x021d
                    r55 = 0
                L_0x0218:
                    r20 = r1
                    r1 = r21
                    goto L_0x022b
                L_0x021d:
                    int r20 = r2.getInt(r1)     // Catch:{ all -> 0x00d1 }
                    if (r20 == 0) goto L_0x0226
                    r20 = 1
                    goto L_0x0228
                L_0x0226:
                    r20 = 0
                L_0x0228:
                    r55 = r20
                    goto L_0x0218
                L_0x022b:
                    if (r1 != r14) goto L_0x0234
                    r56 = 0
                L_0x022f:
                    r21 = r1
                    r1 = r22
                    goto L_0x023f
                L_0x0234:
                    int r21 = r2.getInt(r1)     // Catch:{ all -> 0x00d1 }
                    if (r21 == 0) goto L_0x023c
                    r39 = 1
                L_0x023c:
                    r56 = r39
                    goto L_0x022f
                L_0x023f:
                    if (r1 != r14) goto L_0x0248
                    r57 = r33
                L_0x0243:
                    r22 = r1
                    r1 = r23
                    goto L_0x024d
                L_0x0248:
                    long r57 = r2.getLong(r1)     // Catch:{ all -> 0x00d1 }
                    goto L_0x0243
                L_0x024d:
                    if (r1 != r14) goto L_0x0256
                L_0x024f:
                    r23 = r1
                    r1 = r24
                    r59 = r33
                    goto L_0x025b
                L_0x0256:
                    long r33 = r2.getLong(r1)     // Catch:{ all -> 0x00d1 }
                    goto L_0x024f
                L_0x025b:
                    if (r1 != r14) goto L_0x0260
                    r61 = 0
                    goto L_0x0273
                L_0x0260:
                    boolean r24 = r2.isNull(r1)     // Catch:{ all -> 0x00d1 }
                    if (r24 == 0) goto L_0x0269
                    r24 = 0
                    goto L_0x026d
                L_0x0269:
                    byte[] r24 = r2.getBlob(r1)     // Catch:{ all -> 0x00d1 }
                L_0x026d:
                    java.util.Set r24 = androidx.work.impl.model.WorkTypeConverters.byteArrayToSetOfTriggers(r24)     // Catch:{ all -> 0x00d1 }
                    r61 = r24
                L_0x0273:
                    androidx.work.Constraints r51 = new androidx.work.Constraints     // Catch:{ all -> 0x00d1 }
                    r51.<init>(r52, r53, r54, r55, r56, r57, r59, r61)     // Catch:{ all -> 0x00d1 }
                    java.lang.String r14 = r2.getString(r0)     // Catch:{ all -> 0x00d1 }
                    java.lang.Object r14 = r4.get(r14)     // Catch:{ all -> 0x00d1 }
                    java.util.ArrayList r14 = (java.util.ArrayList) r14     // Catch:{ all -> 0x00d1 }
                    if (r14 != 0) goto L_0x0289
                    java.util.ArrayList r14 = new java.util.ArrayList     // Catch:{ all -> 0x00d1 }
                    r14.<init>()     // Catch:{ all -> 0x00d1 }
                L_0x0289:
                    r53 = r1
                    java.lang.String r1 = r2.getString(r0)     // Catch:{ all -> 0x00d1 }
                    java.lang.Object r1 = r3.get(r1)     // Catch:{ all -> 0x00d1 }
                    java.util.ArrayList r1 = (java.util.ArrayList) r1     // Catch:{ all -> 0x00d1 }
                    if (r1 != 0) goto L_0x029c
                    java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x00d1 }
                    r1.<init>()     // Catch:{ all -> 0x00d1 }
                L_0x029c:
                    r52 = r1
                    r33 = r28
                    androidx.work.impl.model.WorkSpec$WorkInfoPojo r29 = new androidx.work.impl.model.WorkSpec$WorkInfoPojo     // Catch:{ all -> 0x00d1 }
                    r39 = r51
                    r51 = r14
                    r29.<init>(r30, r31, r32, r33, r35, r37, r39, r40, r41, r42, r44, r46, r47, r48, r50, r51, r52)     // Catch:{ all -> 0x00d1 }
                    r1 = r29
                    r15.add(r1)     // Catch:{ all -> 0x00d1 }
                    r1 = r62
                    r24 = r53
                    goto L_0x010a
                L_0x02b4:
                    r2.close()
                    return r15
                L_0x02b8:
                    r2.close()
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.model.RawWorkInfoDao_Impl.AnonymousClass1.call():java.util.List");
            }
        });
    }
}
