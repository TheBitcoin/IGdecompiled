package com.google.android.gms.measurement.internal;

import M.C0335p;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Pair;
import androidx.collection.ArrayMap;
import com.google.android.gms.internal.measurement.C0599k2;
import com.google.android.gms.internal.measurement.C0617m2;
import com.google.android.gms.internal.measurement.C0635o2;
import com.google.android.gms.internal.measurement.C0643p2;
import com.google.android.gms.internal.measurement.C0658r2;
import com.google.android.gms.internal.measurement.C0668s4;
import com.google.android.gms.internal.measurement.C0674t2;
import com.google.android.gms.internal.measurement.I1;
import com.google.android.gms.internal.measurement.J1;
import com.google.android.gms.internal.measurement.K1;
import com.google.android.gms.internal.measurement.M1;
import com.google.android.gms.internal.measurement.r7;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import f0.C;
import f0.q;
import f0.r;
import f0.s;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.measurement.internal.k  reason: case insensitive filesystem */
final class C0797k extends E5 {
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static final String[] f3066f = {"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_bundled_day", "ALTER TABLE events ADD COLUMN last_bundled_day INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;", "current_session_count", "ALTER TABLE events ADD COLUMN current_session_count INTEGER;"};
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public static final String[] f3067g = {TtmlNode.ATTR_TTS_ORIGIN, "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public static final String[] f3068h = {"app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", "android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;", "admob_app_id", "ALTER TABLE apps ADD COLUMN admob_app_id TEXT;", "linked_admob_app_id", "ALTER TABLE apps ADD COLUMN linked_admob_app_id TEXT;", "dynamite_version", "ALTER TABLE apps ADD COLUMN dynamite_version INTEGER;", "safelisted_events", "ALTER TABLE apps ADD COLUMN safelisted_events TEXT;", "ga_app_id", "ALTER TABLE apps ADD COLUMN ga_app_id TEXT;", "config_last_modified_time", "ALTER TABLE apps ADD COLUMN config_last_modified_time TEXT;", "e_tag", "ALTER TABLE apps ADD COLUMN e_tag TEXT;", "session_stitching_token", "ALTER TABLE apps ADD COLUMN session_stitching_token TEXT;", "sgtm_upload_enabled", "ALTER TABLE apps ADD COLUMN sgtm_upload_enabled INTEGER;", "target_os_version", "ALTER TABLE apps ADD COLUMN target_os_version INTEGER;", "session_stitching_token_hash", "ALTER TABLE apps ADD COLUMN session_stitching_token_hash INTEGER;", "ad_services_version", "ALTER TABLE apps ADD COLUMN ad_services_version INTEGER;", "unmatched_first_open_without_ad_id", "ALTER TABLE apps ADD COLUMN unmatched_first_open_without_ad_id INTEGER;", "npa_metadata_value", "ALTER TABLE apps ADD COLUMN npa_metadata_value INTEGER;", "attribution_eligibility_status", "ALTER TABLE apps ADD COLUMN attribution_eligibility_status INTEGER;", "sgtm_preview_key", "ALTER TABLE apps ADD COLUMN sgtm_preview_key TEXT;", "dma_consent_state", "ALTER TABLE apps ADD COLUMN dma_consent_state INTEGER;", "daily_realtime_dcu_count", "ALTER TABLE apps ADD COLUMN daily_realtime_dcu_count INTEGER;", "bundle_delivery_index", "ALTER TABLE apps ADD COLUMN bundle_delivery_index INTEGER;", "serialized_npa_metadata", "ALTER TABLE apps ADD COLUMN serialized_npa_metadata TEXT;", "unmatched_pfo", "ALTER TABLE apps ADD COLUMN unmatched_pfo INTEGER;", "unmatched_uwa", "ALTER TABLE apps ADD COLUMN unmatched_uwa INTEGER;", "ad_campaign_info", "ALTER TABLE apps ADD COLUMN ad_campaign_info BLOB;", "daily_registered_triggers_count", "ALTER TABLE apps ADD COLUMN daily_registered_triggers_count INTEGER;"};
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public static final String[] f3069i = {"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public static final String[] f3070j = {"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;"};
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public static final String[] f3071k = {"session_scoped", "ALTER TABLE event_filters ADD COLUMN session_scoped BOOLEAN;"};
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public static final String[] f3072l = {"session_scoped", "ALTER TABLE property_filters ADD COLUMN session_scoped BOOLEAN;"};
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public static final String[] f3073m = {"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public static final String[] f3074n = {"consent_source", "ALTER TABLE consent_settings ADD COLUMN consent_source INTEGER;", "dma_consent_settings", "ALTER TABLE consent_settings ADD COLUMN dma_consent_settings TEXT;", "storage_consent_at_bundling", "ALTER TABLE consent_settings ADD COLUMN storage_consent_at_bundling TEXT;"};
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public static final String[] f3075o = {"idempotent", "CREATE INDEX IF NOT EXISTS trigger_uris_index ON trigger_uris (app_id);"};

    /* renamed from: d  reason: collision with root package name */
    private final r f3076d = new r(this, A(), "google_app_measurement.db");
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final C0900y5 f3077e = new C0900y5(B());

    C0797k(H5 h5) {
        super(h5);
    }

    private final long C0(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            cursor = y().rawQuery(str, strArr);
            if (cursor.moveToFirst()) {
                long j4 = cursor.getLong(0);
                cursor.close();
                return j4;
            }
            throw new SQLiteException("Database returned empty set");
        } catch (SQLiteException e5) {
            a().G().c("Database error", str, e5);
            throw e5;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    private final long G(String str, String[] strArr, long j4) {
        Cursor cursor = null;
        try {
            Cursor rawQuery = y().rawQuery(str, strArr);
            if (rawQuery.moveToFirst()) {
                long j5 = rawQuery.getLong(0);
                rawQuery.close();
                return j5;
            }
            rawQuery.close();
            return j4;
        } catch (SQLiteException e5) {
            a().G().c("Database error", str, e5);
            throw e5;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    private final boolean G0(String str, List list) {
        C0335p.f(str);
        r();
        k();
        SQLiteDatabase y4 = y();
        try {
            long C02 = C0("select count(1) from audience_filter_values where app_id=?", new String[]{str});
            int max = Math.max(0, Math.min(2000, b().t(str, G.f2420I)));
            if (C02 <= ((long) max)) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            for (int i4 = 0; i4 < list.size(); i4++) {
                Integer num = (Integer) list.get(i4);
                if (num == null) {
                    return false;
                }
                arrayList.add(Integer.toString(num.intValue()));
            }
            if (y4.delete("audience_filter_values", "audience_id in (select audience_id from audience_filter_values where app_id=? and audience_id not in " + ("(" + TextUtils.join(",", arrayList) + ")") + " order by rowid desc limit -1 offset ?)", new String[]{str, Integer.toString(max)}) > 0) {
                return true;
            }
            return false;
        } catch (SQLiteException e5) {
            a().G().c("Database error querying filters. appId", C0821n2.s(str), e5);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:51:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x012a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.measurement.internal.A J0(java.lang.String r29, java.lang.String r30, java.lang.String r31) {
        /*
            r28 = this;
            M.C0335p.f(r30)
            M.C0335p.f(r31)
            r28.k()
            r28.r()
            java.util.ArrayList r0 = new java.util.ArrayList
            java.lang.String r8 = "last_exempt_from_sampling"
            java.lang.String r9 = "current_session_count"
            java.lang.String r1 = "lifetime_count"
            java.lang.String r2 = "current_bundle_count"
            java.lang.String r3 = "last_fire_timestamp"
            java.lang.String r4 = "last_bundled_timestamp"
            java.lang.String r5 = "last_bundled_day"
            java.lang.String r6 = "last_sampled_complex_event_id"
            java.lang.String r7 = "last_sampling_rate"
            java.lang.String[] r1 = new java.lang.String[]{r1, r2, r3, r4, r5, r6, r7, r8, r9}
            java.util.List r1 = java.util.Arrays.asList(r1)
            r0.<init>(r1)
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r28.y()     // Catch:{ SQLiteException -> 0x0105, all -> 0x0103 }
            r10 = 0
            java.lang.String[] r3 = new java.lang.String[r10]     // Catch:{ SQLiteException -> 0x0105, all -> 0x0103 }
            java.lang.Object[] r0 = r0.toArray(r3)     // Catch:{ SQLiteException -> 0x0105, all -> 0x0103 }
            r4 = r0
            java.lang.String[] r4 = (java.lang.String[]) r4     // Catch:{ SQLiteException -> 0x0105, all -> 0x0103 }
            java.lang.String r5 = "app_id=? and name=?"
            java.lang.String[] r6 = new java.lang.String[]{r30, r31}     // Catch:{ SQLiteException -> 0x0105, all -> 0x0103 }
            r8 = 0
            r9 = 0
            r7 = 0
            r3 = r29
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ SQLiteException -> 0x0105, all -> 0x0103 }
            boolean r0 = r2.moveToFirst()     // Catch:{ SQLiteException -> 0x00cb }
            if (r0 != 0) goto L_0x0053
            r2.close()
            return r1
        L_0x0053:
            long r14 = r2.getLong(r10)     // Catch:{ SQLiteException -> 0x00cb }
            r0 = 1
            long r16 = r2.getLong(r0)     // Catch:{ SQLiteException -> 0x00cb }
            r3 = 2
            long r20 = r2.getLong(r3)     // Catch:{ SQLiteException -> 0x00cb }
            r3 = 3
            boolean r4 = r2.isNull(r3)     // Catch:{ SQLiteException -> 0x00cb }
            r5 = 0
            if (r4 == 0) goto L_0x006d
            r22 = r5
            goto L_0x0073
        L_0x006d:
            long r3 = r2.getLong(r3)     // Catch:{ SQLiteException -> 0x00cb }
            r22 = r3
        L_0x0073:
            r3 = 4
            boolean r4 = r2.isNull(r3)     // Catch:{ SQLiteException -> 0x00cb }
            if (r4 == 0) goto L_0x007d
            r24 = r1
            goto L_0x0087
        L_0x007d:
            long r3 = r2.getLong(r3)     // Catch:{ SQLiteException -> 0x00cb }
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch:{ SQLiteException -> 0x00cb }
            r24 = r3
        L_0x0087:
            r3 = 5
            boolean r4 = r2.isNull(r3)     // Catch:{ SQLiteException -> 0x00cb }
            if (r4 == 0) goto L_0x0091
            r25 = r1
            goto L_0x009b
        L_0x0091:
            long r3 = r2.getLong(r3)     // Catch:{ SQLiteException -> 0x00cb }
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch:{ SQLiteException -> 0x00cb }
            r25 = r3
        L_0x009b:
            r3 = 6
            boolean r4 = r2.isNull(r3)     // Catch:{ SQLiteException -> 0x00cb }
            if (r4 == 0) goto L_0x00a5
            r26 = r1
            goto L_0x00af
        L_0x00a5:
            long r3 = r2.getLong(r3)     // Catch:{ SQLiteException -> 0x00cb }
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch:{ SQLiteException -> 0x00cb }
            r26 = r3
        L_0x00af:
            r3 = 7
            boolean r4 = r2.isNull(r3)     // Catch:{ SQLiteException -> 0x00cb }
            if (r4 != 0) goto L_0x00cd
            long r3 = r2.getLong(r3)     // Catch:{ SQLiteException -> 0x00cb }
            r7 = 1
            int r9 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r9 != 0) goto L_0x00c1
            r10 = 1
        L_0x00c1:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r10)     // Catch:{ SQLiteException -> 0x00cb }
            r27 = r0
            goto L_0x00cf
        L_0x00c8:
            r0 = move-exception
            r1 = r2
            goto L_0x0128
        L_0x00cb:
            r0 = move-exception
            goto L_0x0107
        L_0x00cd:
            r27 = r1
        L_0x00cf:
            r0 = 8
            boolean r3 = r2.isNull(r0)     // Catch:{ SQLiteException -> 0x00cb }
            if (r3 == 0) goto L_0x00da
        L_0x00d7:
            r18 = r5
            goto L_0x00df
        L_0x00da:
            long r5 = r2.getLong(r0)     // Catch:{ SQLiteException -> 0x00cb }
            goto L_0x00d7
        L_0x00df:
            com.google.android.gms.measurement.internal.A r11 = new com.google.android.gms.measurement.internal.A     // Catch:{ SQLiteException -> 0x00cb }
            r12 = r30
            r13 = r31
            r11.<init>(r12, r13, r14, r16, r18, r20, r22, r24, r25, r26, r27)     // Catch:{ SQLiteException -> 0x00cb }
            boolean r0 = r2.moveToNext()     // Catch:{ SQLiteException -> 0x00cb }
            if (r0 == 0) goto L_0x00ff
            com.google.android.gms.measurement.internal.n2 r0 = r28.a()     // Catch:{ SQLiteException -> 0x00cb }
            com.google.android.gms.measurement.internal.p2 r0 = r0.G()     // Catch:{ SQLiteException -> 0x00cb }
            java.lang.String r3 = "Got multiple records for event aggregates, expected one. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.C0821n2.s(r30)     // Catch:{ SQLiteException -> 0x00cb }
            r0.b(r3, r4)     // Catch:{ SQLiteException -> 0x00cb }
        L_0x00ff:
            r2.close()
            return r11
        L_0x0103:
            r0 = move-exception
            goto L_0x0128
        L_0x0105:
            r0 = move-exception
            r2 = r1
        L_0x0107:
            com.google.android.gms.measurement.internal.n2 r3 = r28.a()     // Catch:{ all -> 0x00c8 }
            com.google.android.gms.measurement.internal.p2 r3 = r3.G()     // Catch:{ all -> 0x00c8 }
            java.lang.String r4 = "Error querying events. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.C0821n2.s(r30)     // Catch:{ all -> 0x00c8 }
            com.google.android.gms.measurement.internal.h2 r6 = r28.d()     // Catch:{ all -> 0x00c8 }
            r13 = r31
            java.lang.String r6 = r6.c(r13)     // Catch:{ all -> 0x00c8 }
            r3.d(r4, r5, r6, r0)     // Catch:{ all -> 0x00c8 }
            if (r2 == 0) goto L_0x0127
            r2.close()
        L_0x0127:
            return r1
        L_0x0128:
            if (r1 == 0) goto L_0x012d
            r1.close()
        L_0x012d:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.C0797k.J0(java.lang.String, java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.A");
    }

    private final Object M(Cursor cursor, int i4) {
        int type = cursor.getType(i4);
        if (type == 0) {
            a().G().a("Loaded invalid null value from database");
            return null;
        } else if (type == 1) {
            return Long.valueOf(cursor.getLong(i4));
        } else {
            if (type == 2) {
                return Double.valueOf(cursor.getDouble(i4));
            }
            if (type == 3) {
                return cursor.getString(i4);
            }
            if (type != 4) {
                a().G().b("Loaded invalid unknown value type, ignoring it", Integer.valueOf(type));
                return null;
            }
            a().G().a("Loaded invalid blob type value, ignoring it");
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0046  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.Object N(java.lang.String r3, java.lang.String[] r4, com.google.android.gms.measurement.internal.C0852s r5) {
        /*
            r2 = this;
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r2.y()     // Catch:{ SQLiteException -> 0x002f, all -> 0x002d }
            android.database.Cursor r3 = r1.rawQuery(r3, r4)     // Catch:{ SQLiteException -> 0x002f, all -> 0x002d }
            boolean r4 = r3.moveToFirst()     // Catch:{ SQLiteException -> 0x0023 }
            if (r4 != 0) goto L_0x0025
            com.google.android.gms.measurement.internal.n2 r4 = r2.a()     // Catch:{ SQLiteException -> 0x0023 }
            com.google.android.gms.measurement.internal.p2 r4 = r4.K()     // Catch:{ SQLiteException -> 0x0023 }
            java.lang.String r5 = "No data found"
            r4.a(r5)     // Catch:{ SQLiteException -> 0x0023 }
            r3.close()
            return r0
        L_0x0020:
            r4 = move-exception
            r0 = r3
            goto L_0x0044
        L_0x0023:
            r4 = move-exception
            goto L_0x0031
        L_0x0025:
            java.lang.Object r4 = r5.a(r3)     // Catch:{ SQLiteException -> 0x0023 }
            r3.close()
            return r4
        L_0x002d:
            r4 = move-exception
            goto L_0x0044
        L_0x002f:
            r4 = move-exception
            r3 = r0
        L_0x0031:
            com.google.android.gms.measurement.internal.n2 r5 = r2.a()     // Catch:{ all -> 0x0020 }
            com.google.android.gms.measurement.internal.p2 r5 = r5.G()     // Catch:{ all -> 0x0020 }
            java.lang.String r1 = "Error querying database."
            r5.b(r1, r4)     // Catch:{ all -> 0x0020 }
            if (r3 == 0) goto L_0x0043
            r3.close()
        L_0x0043:
            return r0
        L_0x0044:
            if (r0 == 0) goto L_0x0049
            r0.close()
        L_0x0049:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.C0797k.N(java.lang.String, java.lang.String[], com.google.android.gms.measurement.internal.s):java.lang.Object");
    }

    private final String P(String str, String[] strArr, String str2) {
        Cursor cursor = null;
        try {
            Cursor rawQuery = y().rawQuery(str, strArr);
            if (rawQuery.moveToFirst()) {
                String string = rawQuery.getString(0);
                rawQuery.close();
                return string;
            }
            rawQuery.close();
            return str2;
        } catch (SQLiteException e5) {
            a().G().c("Database error", str, e5);
            throw e5;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    private static void T(ContentValues contentValues, String str, Object obj) {
        C0335p.f(str);
        C0335p.l(obj);
        if (obj instanceof String) {
            contentValues.put(str, (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put(str, (Long) obj);
        } else if (obj instanceof Double) {
            contentValues.put(str, (Double) obj);
        } else {
            throw new IllegalArgumentException("Invalid value type");
        }
    }

    private final void V0(String str, String str2) {
        C0335p.f(str2);
        k();
        r();
        try {
            y().delete(str, "app_id=?", new String[]{str2});
        } catch (SQLiteException e5) {
            a().G().c("Error deleting snapshot. appId", C0821n2.s(str2), e5);
        }
    }

    private final void Z(String str, A a5) {
        long j4;
        C0335p.l(a5);
        k();
        r();
        ContentValues contentValues = new ContentValues();
        contentValues.put(MBridgeConstans.APP_ID, a5.f2283a);
        contentValues.put(RewardPlus.NAME, a5.f2284b);
        contentValues.put("lifetime_count", Long.valueOf(a5.f2285c));
        contentValues.put("current_bundle_count", Long.valueOf(a5.f2286d));
        contentValues.put("last_fire_timestamp", Long.valueOf(a5.f2288f));
        contentValues.put("last_bundled_timestamp", Long.valueOf(a5.f2289g));
        contentValues.put("last_bundled_day", a5.f2290h);
        contentValues.put("last_sampled_complex_event_id", a5.f2291i);
        contentValues.put("last_sampling_rate", a5.f2292j);
        contentValues.put("current_session_count", Long.valueOf(a5.f2287e));
        Boolean bool = a5.f2293k;
        if (bool == null || !bool.booleanValue()) {
            j4 = null;
        } else {
            j4 = 1L;
        }
        contentValues.put("last_exempt_from_sampling", j4);
        try {
            if (y().insertWithOnConflict(str, (String) null, contentValues, 5) == -1) {
                a().G().b("Failed to insert/update event aggregates (got -1). appId", C0821n2.s(a5.f2283a));
            }
        } catch (SQLiteException e5) {
            a().G().c("Error storing event aggregates. appId", C0821n2.s(a5.f2283a), e5);
        }
    }

    private final void b0(String str, String str2, ContentValues contentValues) {
        try {
            SQLiteDatabase y4 = y();
            String asString = contentValues.getAsString(str2);
            if (asString == null) {
                a().H().b("Value of the primary key is not set.", C0821n2.s(str2));
                return;
            }
            if (((long) y4.update(str, contentValues, str2 + " = ?", new String[]{asString})) == 0 && y4.insertWithOnConflict(str, (String) null, contentValues, 5) == -1) {
                a().G().c("Failed to insert/update table (got -1). key", C0821n2.s(str), C0821n2.s(str2));
            }
        } catch (SQLiteException e5) {
            a().G().d("Error storing into table. key", C0821n2.s(str), C0821n2.s(str2), e5);
        }
    }

    private final boolean e0(long j4, B b5, long j5, boolean z4) {
        k();
        r();
        C0335p.l(b5);
        C0335p.f(b5.f2316a);
        byte[] i4 = l().E(b5).i();
        ContentValues contentValues = new ContentValues();
        contentValues.put(MBridgeConstans.APP_ID, b5.f2316a);
        contentValues.put(RewardPlus.NAME, b5.f2317b);
        contentValues.put(CampaignEx.JSON_KEY_TIMESTAMP, Long.valueOf(b5.f2319d));
        contentValues.put("metadata_fingerprint", Long.valueOf(j5));
        contentValues.put(DataSchemeDataSource.SCHEME_DATA, i4);
        contentValues.put("realtime", Integer.valueOf(z4 ? 1 : 0));
        try {
            long update = (long) y().update("raw_events", contentValues, "rowid = ?", new String[]{String.valueOf(j4)});
            if (update == 1) {
                return true;
            }
            a().G().c("Failed to update raw event. appId, updatedRows", C0821n2.s(b5.f2316a), Long.valueOf(update));
            return false;
        } catch (SQLiteException e5) {
            a().G().c("Error updating raw event. appId", C0821n2.s(b5.f2316a), e5);
            return false;
        }
    }

    private final boolean j0(String str, int i4, J1 j12) {
        Integer num;
        Boolean bool;
        r();
        k();
        C0335p.f(str);
        C0335p.l(j12);
        Integer num2 = null;
        if (j12.N().isEmpty()) {
            C0835p2 L4 = a().L();
            Object s4 = C0821n2.s(str);
            Integer valueOf = Integer.valueOf(i4);
            if (j12.T()) {
                num2 = Integer.valueOf(j12.J());
            }
            L4.d("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", s4, valueOf, String.valueOf(num2));
            return false;
        }
        byte[] i5 = j12.i();
        ContentValues contentValues = new ContentValues();
        contentValues.put(MBridgeConstans.APP_ID, str);
        contentValues.put("audience_id", Integer.valueOf(i4));
        if (j12.T()) {
            num = Integer.valueOf(j12.J());
        } else {
            num = null;
        }
        contentValues.put("filter_id", num);
        contentValues.put("event_name", j12.N());
        if (j12.U()) {
            bool = Boolean.valueOf(j12.R());
        } else {
            bool = null;
        }
        contentValues.put("session_scoped", bool);
        contentValues.put(DataSchemeDataSource.SCHEME_DATA, i5);
        try {
            if (y().insertWithOnConflict("event_filters", (String) null, contentValues, 5) != -1) {
                return true;
            }
            a().G().b("Failed to insert event filter (got -1). appId", C0821n2.s(str));
            return true;
        } catch (SQLiteException e5) {
            a().G().c("Error storing event filter. appId", C0821n2.s(str), e5);
            return false;
        }
    }

    private final boolean k0(String str, int i4, M1 m12) {
        Integer num;
        Boolean bool;
        r();
        k();
        C0335p.f(str);
        C0335p.l(m12);
        Integer num2 = null;
        if (m12.K().isEmpty()) {
            C0835p2 L4 = a().L();
            Object s4 = C0821n2.s(str);
            Integer valueOf = Integer.valueOf(i4);
            if (m12.O()) {
                num2 = Integer.valueOf(m12.j());
            }
            L4.d("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", s4, valueOf, String.valueOf(num2));
            return false;
        }
        byte[] i5 = m12.i();
        ContentValues contentValues = new ContentValues();
        contentValues.put(MBridgeConstans.APP_ID, str);
        contentValues.put("audience_id", Integer.valueOf(i4));
        if (m12.O()) {
            num = Integer.valueOf(m12.j());
        } else {
            num = null;
        }
        contentValues.put("filter_id", num);
        contentValues.put("property_name", m12.K());
        if (m12.P()) {
            bool = Boolean.valueOf(m12.N());
        } else {
            bool = null;
        }
        contentValues.put("session_scoped", bool);
        contentValues.put(DataSchemeDataSource.SCHEME_DATA, i5);
        try {
            if (y().insertWithOnConflict("property_filters", (String) null, contentValues, 5) != -1) {
                return true;
            }
            a().G().b("Failed to insert property filter (got -1). appId", C0821n2.s(str));
            return false;
        } catch (SQLiteException e5) {
            a().G().c("Error storing property filter. appId", C0821n2.s(str), e5);
            return false;
        }
    }

    private final String z0() {
        long currentTimeMillis = B().currentTimeMillis();
        C c5 = C.GOOGLE_SIGNAL;
        return "(" + ("(upload_type = " + c5.A() + " AND (ABS(creation_timestamp - " + currentTimeMillis + ") > CAST(" + ((Long) G.f2416G.a((Object) null)).longValue() + " AS INTEGER)))") + " OR " + ("(upload_type != " + c5.A() + " AND (ABS(creation_timestamp - " + currentTimeMillis + ") > CAST(" + C0769g.P() + " AS INTEGER)))") + ")";
    }

    public final long A0(String str) {
        C0335p.f(str);
        k();
        r();
        return G("select first_open_count from app2 where app_id=?", new String[]{str}, -1);
    }

    /* access modifiers changed from: protected */
    public final long B0(String str, String str2) {
        C0335p.f(str);
        C0335p.f(str2);
        k();
        r();
        SQLiteDatabase y4 = y();
        y4.beginTransaction();
        long j4 = 0;
        try {
            long G4 = G("select " + str2 + " from app2 where app_id=?", new String[]{str}, -1);
            if (G4 == -1) {
                ContentValues contentValues = new ContentValues();
                contentValues.put(MBridgeConstans.APP_ID, str);
                contentValues.put("first_open_count", 0);
                contentValues.put("previous_install_count", 0);
                if (y4.insertWithOnConflict("app2", (String) null, contentValues, 5) == -1) {
                    a().G().c("Failed to insert column (got -1). appId", C0821n2.s(str), str2);
                    y4.endTransaction();
                    return -1;
                }
                G4 = 0;
            }
            try {
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put(MBridgeConstans.APP_ID, str);
                contentValues2.put(str2, Long.valueOf(1 + G4));
                if (((long) y4.update("app2", contentValues2, "app_id = ?", new String[]{str})) == 0) {
                    a().G().c("Failed to update column (got 0). appId", C0821n2.s(str), str2);
                    y4.endTransaction();
                    return -1;
                }
                y4.setTransactionSuccessful();
                y4.endTransaction();
                return G4;
            } catch (SQLiteException e5) {
                e = e5;
                j4 = G4;
                try {
                    a().G().d("Error inserting column. appId", C0821n2.s(str), str2, e);
                    y4.endTransaction();
                    return j4;
                } catch (Throwable th) {
                    Throwable th2 = th;
                    y4.endTransaction();
                    throw th2;
                }
            }
        } catch (SQLiteException e6) {
            e = e6;
            a().G().d("Error inserting column. appId", C0821n2.s(str), str2, e);
            y4.endTransaction();
            return j4;
        }
    }

    public final int D(String str, String str2) {
        C0335p.f(str);
        C0335p.f(str2);
        k();
        r();
        try {
            return y().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e5) {
            a().G().d("Error deleting conditional property", C0821n2.s(str), d().g(str2), e5);
            return 0;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00f4, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00f5, code lost:
        r12 = r17;
        r7 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x010e, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0114, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0034, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0035, code lost:
        r12 = r17;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x010e  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0114  */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0034 A[Catch:{ SQLiteException -> 0x0039, all -> 0x0034 }, ExcHandler: all (th java.lang.Throwable), PHI: r2 
      PHI: (r2v4 android.database.Cursor) = (r2v0 android.database.Cursor), (r2v5 android.database.Cursor), (r2v0 android.database.Cursor) binds: [B:1:0x0011, B:19:0x0096, B:5:0x002b] A[DONT_GENERATE, DONT_INLINE], Splitter:B:1:0x0011] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List D0(java.lang.String r18, java.lang.String r19, java.lang.String r20) {
        /*
            r17 = this;
            r0 = r20
            M.C0335p.f(r18)
            r17.k()
            r17.r()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r2 = 0
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x00f4, all -> 0x0034 }
            r4 = 3
            r3.<init>(r4)     // Catch:{ SQLiteException -> 0x00f4, all -> 0x0034 }
            r6 = r18
            r3.add(r6)     // Catch:{ SQLiteException -> 0x00f4, all -> 0x0034 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x00f4, all -> 0x0034 }
            java.lang.String r7 = "app_id=?"
            r5.<init>(r7)     // Catch:{ SQLiteException -> 0x00f4, all -> 0x0034 }
            boolean r7 = android.text.TextUtils.isEmpty(r19)     // Catch:{ SQLiteException -> 0x00f4, all -> 0x0034 }
            if (r7 != 0) goto L_0x003e
            r7 = r19
            r3.add(r7)     // Catch:{ SQLiteException -> 0x0039, all -> 0x0034 }
            java.lang.String r8 = " and origin=?"
            r5.append(r8)     // Catch:{ SQLiteException -> 0x0039, all -> 0x0034 }
            goto L_0x0040
        L_0x0034:
            r0 = move-exception
            r12 = r17
            goto L_0x0112
        L_0x0039:
            r0 = move-exception
            r12 = r17
            goto L_0x00f9
        L_0x003e:
            r7 = r19
        L_0x0040:
            boolean r8 = android.text.TextUtils.isEmpty(r0)     // Catch:{ SQLiteException -> 0x0039, all -> 0x0034 }
            if (r8 != 0) goto L_0x005f
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x0039, all -> 0x0034 }
            r8.<init>()     // Catch:{ SQLiteException -> 0x0039, all -> 0x0034 }
            r8.append(r0)     // Catch:{ SQLiteException -> 0x0039, all -> 0x0034 }
            java.lang.String r9 = "*"
            r8.append(r9)     // Catch:{ SQLiteException -> 0x0039, all -> 0x0034 }
            java.lang.String r8 = r8.toString()     // Catch:{ SQLiteException -> 0x0039, all -> 0x0034 }
            r3.add(r8)     // Catch:{ SQLiteException -> 0x0039, all -> 0x0034 }
            java.lang.String r8 = " and name glob ?"
            r5.append(r8)     // Catch:{ SQLiteException -> 0x0039, all -> 0x0034 }
        L_0x005f:
            int r8 = r3.size()     // Catch:{ SQLiteException -> 0x0039, all -> 0x0034 }
            java.lang.String[] r8 = new java.lang.String[r8]     // Catch:{ SQLiteException -> 0x0039, all -> 0x0034 }
            java.lang.Object[] r3 = r3.toArray(r8)     // Catch:{ SQLiteException -> 0x0039, all -> 0x0034 }
            r12 = r3
            java.lang.String[] r12 = (java.lang.String[]) r12     // Catch:{ SQLiteException -> 0x0039, all -> 0x0034 }
            android.database.sqlite.SQLiteDatabase r8 = r17.y()     // Catch:{ SQLiteException -> 0x0039, all -> 0x0034 }
            java.lang.String r9 = "user_attributes"
            java.lang.String r3 = "name"
            java.lang.String r10 = "set_timestamp"
            java.lang.String r11 = "value"
            java.lang.String r13 = "origin"
            java.lang.String[] r10 = new java.lang.String[]{r3, r10, r11, r13}     // Catch:{ SQLiteException -> 0x0039, all -> 0x0034 }
            java.lang.String r11 = r5.toString()     // Catch:{ SQLiteException -> 0x0039, all -> 0x0034 }
            java.lang.String r15 = "rowid"
            java.lang.String r16 = "1001"
            r13 = 0
            r14 = 0
            android.database.Cursor r2 = r8.query(r9, r10, r11, r12, r13, r14, r15, r16)     // Catch:{ SQLiteException -> 0x0039, all -> 0x0034 }
            boolean r3 = r2.moveToFirst()     // Catch:{ SQLiteException -> 0x0039, all -> 0x0034 }
            if (r3 != 0) goto L_0x0096
            r2.close()
            return r1
        L_0x0096:
            int r3 = r1.size()     // Catch:{ SQLiteException -> 0x0039, all -> 0x0034 }
            r5 = 1000(0x3e8, float:1.401E-42)
            if (r3 < r5) goto L_0x00b2
            com.google.android.gms.measurement.internal.n2 r0 = r17.a()     // Catch:{ SQLiteException -> 0x0039, all -> 0x0034 }
            com.google.android.gms.measurement.internal.p2 r0 = r0.G()     // Catch:{ SQLiteException -> 0x0039, all -> 0x0034 }
            java.lang.String r3 = "Read more than the max allowed user properties, ignoring excess"
            java.lang.Integer r4 = java.lang.Integer.valueOf(r5)     // Catch:{ SQLiteException -> 0x0039, all -> 0x0034 }
            r0.b(r3, r4)     // Catch:{ SQLiteException -> 0x0039, all -> 0x0034 }
            r12 = r17
            goto L_0x00ed
        L_0x00b2:
            r3 = 0
            java.lang.String r8 = r2.getString(r3)     // Catch:{ SQLiteException -> 0x0039, all -> 0x0034 }
            r3 = 1
            long r9 = r2.getLong(r3)     // Catch:{ SQLiteException -> 0x0039, all -> 0x0034 }
            r3 = 2
            r12 = r17
            java.lang.Object r11 = r12.M(r2, r3)     // Catch:{ SQLiteException -> 0x00dd }
            java.lang.String r7 = r2.getString(r4)     // Catch:{ SQLiteException -> 0x00dd }
            if (r11 != 0) goto L_0x00df
            com.google.android.gms.measurement.internal.n2 r3 = r12.a()     // Catch:{ SQLiteException -> 0x00dd }
            com.google.android.gms.measurement.internal.p2 r3 = r3.G()     // Catch:{ SQLiteException -> 0x00dd }
            java.lang.String r5 = "(2)Read invalid user property value, ignoring it"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.C0821n2.s(r6)     // Catch:{ SQLiteException -> 0x00dd }
            r3.d(r5, r8, r7, r0)     // Catch:{ SQLiteException -> 0x00dd }
            goto L_0x00e7
        L_0x00db:
            r0 = move-exception
            goto L_0x0112
        L_0x00dd:
            r0 = move-exception
            goto L_0x00f9
        L_0x00df:
            com.google.android.gms.measurement.internal.a6 r5 = new com.google.android.gms.measurement.internal.a6     // Catch:{ SQLiteException -> 0x00dd }
            r5.<init>(r6, r7, r8, r9, r11)     // Catch:{ SQLiteException -> 0x00dd }
            r1.add(r5)     // Catch:{ SQLiteException -> 0x00dd }
        L_0x00e7:
            boolean r3 = r2.moveToNext()     // Catch:{ SQLiteException -> 0x00dd }
            if (r3 != 0) goto L_0x00f1
        L_0x00ed:
            r2.close()
            return r1
        L_0x00f1:
            r6 = r18
            goto L_0x0096
        L_0x00f4:
            r0 = move-exception
            r12 = r17
            r7 = r19
        L_0x00f9:
            com.google.android.gms.measurement.internal.n2 r1 = r12.a()     // Catch:{ all -> 0x00db }
            com.google.android.gms.measurement.internal.p2 r1 = r1.G()     // Catch:{ all -> 0x00db }
            java.lang.String r3 = "(2)Error querying user properties"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.C0821n2.s(r18)     // Catch:{ all -> 0x00db }
            r1.d(r3, r4, r7, r0)     // Catch:{ all -> 0x00db }
            java.util.List r0 = java.util.Collections.EMPTY_LIST     // Catch:{ all -> 0x00db }
            if (r2 == 0) goto L_0x0111
            r2.close()
        L_0x0111:
            return r0
        L_0x0112:
            if (r2 == 0) goto L_0x0117
            r2.close()
        L_0x0117:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.C0797k.D0(java.lang.String, java.lang.String, java.lang.String):java.util.List");
    }

    public final long E(C0643p2 p2Var) {
        k();
        r();
        C0335p.l(p2Var);
        C0335p.f(p2Var.x2());
        byte[] i4 = p2Var.i();
        long x4 = l().x(i4);
        ContentValues contentValues = new ContentValues();
        contentValues.put(MBridgeConstans.APP_ID, p2Var.x2());
        contentValues.put("metadata_fingerprint", Long.valueOf(x4));
        contentValues.put(TtmlNode.TAG_METADATA, i4);
        try {
            y().insertWithOnConflict("raw_events_metadata", (String) null, contentValues, 4);
            return x4;
        } catch (SQLiteException e5) {
            a().G().c("Error storing raw event metadata. appId", C0821n2.s(p2Var.x2()), e5);
            throw e5;
        }
    }

    public final void E0(String str, A3 a32) {
        C0335p.l(str);
        C0335p.l(a32);
        k();
        r();
        ContentValues contentValues = new ContentValues();
        contentValues.put(MBridgeConstans.APP_ID, str);
        contentValues.put("consent_state", a32.x());
        contentValues.put("consent_source", Integer.valueOf(a32.b()));
        b0("consent_settings", MBridgeConstans.APP_ID, contentValues);
    }

    public final long F(String str) {
        C0335p.f(str);
        k();
        r();
        try {
            return (long) y().delete("raw_events", "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str, String.valueOf(Math.max(0, Math.min(1000000, b().t(str, G.f2501q))))});
        } catch (SQLiteException e5) {
            a().G().c("Error deleting over the limit events. appId", C0821n2.s(str), e5);
            return 0;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean F0(String str, Bundle bundle) {
        k();
        r();
        String str2 = str;
        byte[] i4 = l().E(new B(this.f3273a, "", str2, "dep", 0, 0, bundle)).i();
        a().K().c("Saving default event parameters, appId, data size", d().c(str2), Integer.valueOf(i4.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put(MBridgeConstans.APP_ID, str2);
        contentValues.put("parameters", i4);
        try {
            if (y().insertWithOnConflict("default_event_params", (String) null, contentValues, 5) != -1) {
                return true;
            }
            a().G().b("Failed to insert default event parameters (got -1). appId", C0821n2.s(str2));
            return false;
        } catch (SQLiteException e5) {
            a().G().c("Error storing default event parameters. appId", C0821n2.s(str2), e5);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x008c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.util.Pair H(java.lang.String r6, java.lang.Long r7) {
        /*
            r5 = this;
            r5.k()
            r5.r()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r5.y()     // Catch:{ SQLiteException -> 0x0075, all -> 0x0073 }
            java.lang.String r2 = "select main_event, children_to_process from main_event_params where app_id=? and event_id=?"
            java.lang.String r3 = java.lang.String.valueOf(r7)     // Catch:{ SQLiteException -> 0x0075, all -> 0x0073 }
            java.lang.String[] r3 = new java.lang.String[]{r6, r3}     // Catch:{ SQLiteException -> 0x0075, all -> 0x0073 }
            android.database.Cursor r1 = r1.rawQuery(r2, r3)     // Catch:{ SQLiteException -> 0x0075, all -> 0x0073 }
            boolean r2 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x0033 }
            if (r2 != 0) goto L_0x0035
            com.google.android.gms.measurement.internal.n2 r6 = r5.a()     // Catch:{ SQLiteException -> 0x0033 }
            com.google.android.gms.measurement.internal.p2 r6 = r6.K()     // Catch:{ SQLiteException -> 0x0033 }
            java.lang.String r7 = "Main event not found"
            r6.a(r7)     // Catch:{ SQLiteException -> 0x0033 }
            r1.close()
            return r0
        L_0x0030:
            r6 = move-exception
            r0 = r1
            goto L_0x008a
        L_0x0033:
            r6 = move-exception
            goto L_0x0077
        L_0x0035:
            r2 = 0
            byte[] r2 = r1.getBlob(r2)     // Catch:{ SQLiteException -> 0x0033 }
            r3 = 1
            long r3 = r1.getLong(r3)     // Catch:{ SQLiteException -> 0x0033 }
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch:{ SQLiteException -> 0x0033 }
            com.google.android.gms.internal.measurement.k2$a r4 = com.google.android.gms.internal.measurement.C0599k2.S()     // Catch:{ IOException -> 0x005d }
            com.google.android.gms.internal.measurement.Y4 r2 = com.google.android.gms.measurement.internal.Z5.G(r4, r2)     // Catch:{ IOException -> 0x005d }
            com.google.android.gms.internal.measurement.k2$a r2 = (com.google.android.gms.internal.measurement.C0599k2.a) r2     // Catch:{ IOException -> 0x005d }
            com.google.android.gms.internal.measurement.Z4 r2 = r2.m()     // Catch:{ IOException -> 0x005d }
            com.google.android.gms.internal.measurement.s4 r2 = (com.google.android.gms.internal.measurement.C0668s4) r2     // Catch:{ IOException -> 0x005d }
            com.google.android.gms.internal.measurement.k2 r2 = (com.google.android.gms.internal.measurement.C0599k2) r2     // Catch:{ IOException -> 0x005d }
            android.util.Pair r6 = android.util.Pair.create(r2, r3)     // Catch:{ SQLiteException -> 0x0033 }
            r1.close()
            return r6
        L_0x005d:
            r2 = move-exception
            com.google.android.gms.measurement.internal.n2 r3 = r5.a()     // Catch:{ SQLiteException -> 0x0033 }
            com.google.android.gms.measurement.internal.p2 r3 = r3.G()     // Catch:{ SQLiteException -> 0x0033 }
            java.lang.String r4 = "Failed to merge main event. appId, eventId"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.C0821n2.s(r6)     // Catch:{ SQLiteException -> 0x0033 }
            r3.d(r4, r6, r7, r2)     // Catch:{ SQLiteException -> 0x0033 }
            r1.close()
            return r0
        L_0x0073:
            r6 = move-exception
            goto L_0x008a
        L_0x0075:
            r6 = move-exception
            r1 = r0
        L_0x0077:
            com.google.android.gms.measurement.internal.n2 r7 = r5.a()     // Catch:{ all -> 0x0030 }
            com.google.android.gms.measurement.internal.p2 r7 = r7.G()     // Catch:{ all -> 0x0030 }
            java.lang.String r2 = "Error selecting main event"
            r7.b(r2, r6)     // Catch:{ all -> 0x0030 }
            if (r1 == 0) goto L_0x0089
            r1.close()
        L_0x0089:
            return r0
        L_0x008a:
            if (r0 == 0) goto L_0x008f
            r0.close()
        L_0x008f:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.C0797k.H(java.lang.String, java.lang.Long):android.util.Pair");
    }

    public final long H0(String str) {
        C0335p.f(str);
        return G("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0);
    }

    public final C0825o I(long j4, String str, long j5, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10) {
        C0335p.f(str);
        k();
        r();
        String[] strArr = {str};
        C0825o oVar = new C0825o();
        Cursor cursor = null;
        try {
            SQLiteDatabase y4 = y();
            cursor = y4.query("apps", new String[]{"day", "daily_events_count", "daily_public_events_count", "daily_conversions_count", "daily_error_events_count", "daily_realtime_events_count", "daily_realtime_dcu_count", "daily_registered_triggers_count"}, "app_id=?", new String[]{str}, (String) null, (String) null, (String) null);
            if (!cursor.moveToFirst()) {
                a().L().b("Not updating daily counts, app is not known. appId", C0821n2.s(str));
                cursor.close();
                return oVar;
            }
            if (cursor.getLong(0) == j4) {
                oVar.f3154b = cursor.getLong(1);
                oVar.f3153a = cursor.getLong(2);
                oVar.f3155c = cursor.getLong(3);
                oVar.f3156d = cursor.getLong(4);
                oVar.f3157e = cursor.getLong(5);
                oVar.f3158f = cursor.getLong(6);
                oVar.f3159g = cursor.getLong(7);
            }
            if (z4) {
                oVar.f3154b += j5;
            }
            if (z5) {
                oVar.f3153a += j5;
            }
            if (z6) {
                oVar.f3155c += j5;
            }
            if (z7) {
                oVar.f3156d += j5;
            }
            if (z8) {
                oVar.f3157e += j5;
            }
            if (z9) {
                oVar.f3158f += j5;
            }
            if (z10) {
                oVar.f3159g += j5;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("day", Long.valueOf(j4));
            contentValues.put("daily_public_events_count", Long.valueOf(oVar.f3153a));
            contentValues.put("daily_events_count", Long.valueOf(oVar.f3154b));
            contentValues.put("daily_conversions_count", Long.valueOf(oVar.f3155c));
            contentValues.put("daily_error_events_count", Long.valueOf(oVar.f3156d));
            contentValues.put("daily_realtime_events_count", Long.valueOf(oVar.f3157e));
            contentValues.put("daily_realtime_dcu_count", Long.valueOf(oVar.f3158f));
            contentValues.put("daily_registered_triggers_count", Long.valueOf(oVar.f3159g));
            y4.update("apps", contentValues, "app_id=?", strArr);
            cursor.close();
            return oVar;
        } catch (SQLiteException e5) {
            a().G().c("Error updating daily counts. appId", C0821n2.s(str), e5);
            if (cursor != null) {
                cursor.close();
            }
            return oVar;
        } catch (Throwable th) {
            Throwable th2 = th;
            if (cursor != null) {
                cursor.close();
            }
            throw th2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x0113  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0119  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.C0755e I0(java.lang.String r24, java.lang.String r25) {
        /*
            r23 = this;
            M.C0335p.f(r24)
            M.C0335p.f(r25)
            r23.k()
            r23.r()
            r6 = 0
            android.database.sqlite.SQLiteDatabase r7 = r23.y()     // Catch:{ SQLiteException -> 0x00f4, all -> 0x00f2 }
            java.lang.String r8 = "conditional_properties"
            java.lang.String r9 = "origin"
            java.lang.String r10 = "value"
            java.lang.String r11 = "active"
            java.lang.String r12 = "trigger_event_name"
            java.lang.String r13 = "trigger_timeout"
            java.lang.String r14 = "timed_out_event"
            java.lang.String r15 = "creation_timestamp"
            java.lang.String r16 = "triggered_event"
            java.lang.String r17 = "triggered_timestamp"
            java.lang.String r18 = "time_to_live"
            java.lang.String r19 = "expired_event"
            java.lang.String[] r9 = new java.lang.String[]{r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19}     // Catch:{ SQLiteException -> 0x00f4, all -> 0x00f2 }
            java.lang.String r10 = "app_id=? and name=?"
            java.lang.String[] r11 = new java.lang.String[]{r24, r25}     // Catch:{ SQLiteException -> 0x00f4, all -> 0x00f2 }
            r13 = 0
            r14 = 0
            r12 = 0
            android.database.Cursor r7 = r7.query(r8, r9, r10, r11, r12, r13, r14)     // Catch:{ SQLiteException -> 0x00f4, all -> 0x00f2 }
            boolean r0 = r7.moveToFirst()     // Catch:{ SQLiteException -> 0x0053 }
            if (r0 != 0) goto L_0x0044
            r7.close()
            return r6
        L_0x0044:
            r0 = 0
            java.lang.String r1 = r7.getString(r0)     // Catch:{ SQLiteException -> 0x0053 }
            if (r1 != 0) goto L_0x004d
            java.lang.String r1 = ""
        L_0x004d:
            r5 = r1
            goto L_0x0058
        L_0x004f:
            r0 = move-exception
            r6 = r7
            goto L_0x0117
        L_0x0053:
            r0 = move-exception
            r1 = r25
            goto L_0x00f8
        L_0x0058:
            r1 = 1
            r8 = r23
            java.lang.Object r4 = r8.M(r7, r1)     // Catch:{ SQLiteException -> 0x0053 }
            r2 = 2
            int r2 = r7.getInt(r2)     // Catch:{ SQLiteException -> 0x0053 }
            if (r2 == 0) goto L_0x0068
            r14 = 1
            goto L_0x0069
        L_0x0068:
            r14 = 0
        L_0x0069:
            r0 = 3
            java.lang.String r15 = r7.getString(r0)     // Catch:{ SQLiteException -> 0x0053 }
            r0 = 4
            long r17 = r7.getLong(r0)     // Catch:{ SQLiteException -> 0x0053 }
            com.google.android.gms.measurement.internal.Z5 r0 = r8.l()     // Catch:{ SQLiteException -> 0x0053 }
            r1 = 5
            byte[] r1 = r7.getBlob(r1)     // Catch:{ SQLiteException -> 0x0053 }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.E> r2 = com.google.android.gms.measurement.internal.E.CREATOR     // Catch:{ SQLiteException -> 0x0053 }
            android.os.Parcelable r0 = r0.D(r1, r2)     // Catch:{ SQLiteException -> 0x0053 }
            r16 = r0
            com.google.android.gms.measurement.internal.E r16 = (com.google.android.gms.measurement.internal.E) r16     // Catch:{ SQLiteException -> 0x0053 }
            r0 = 6
            long r12 = r7.getLong(r0)     // Catch:{ SQLiteException -> 0x0053 }
            com.google.android.gms.measurement.internal.Z5 r0 = r8.l()     // Catch:{ SQLiteException -> 0x0053 }
            r1 = 7
            byte[] r1 = r7.getBlob(r1)     // Catch:{ SQLiteException -> 0x0053 }
            android.os.Parcelable r0 = r0.D(r1, r2)     // Catch:{ SQLiteException -> 0x0053 }
            r19 = r0
            com.google.android.gms.measurement.internal.E r19 = (com.google.android.gms.measurement.internal.E) r19     // Catch:{ SQLiteException -> 0x0053 }
            r0 = 8
            long r0 = r7.getLong(r0)     // Catch:{ SQLiteException -> 0x0053 }
            r3 = 9
            long r20 = r7.getLong(r3)     // Catch:{ SQLiteException -> 0x0053 }
            com.google.android.gms.measurement.internal.Z5 r3 = r8.l()     // Catch:{ SQLiteException -> 0x0053 }
            r9 = 10
            byte[] r9 = r7.getBlob(r9)     // Catch:{ SQLiteException -> 0x0053 }
            android.os.Parcelable r2 = r3.D(r9, r2)     // Catch:{ SQLiteException -> 0x0053 }
            r22 = r2
            com.google.android.gms.measurement.internal.E r22 = (com.google.android.gms.measurement.internal.E) r22     // Catch:{ SQLiteException -> 0x0053 }
            com.google.android.gms.measurement.internal.Y5 r11 = new com.google.android.gms.measurement.internal.Y5     // Catch:{ SQLiteException -> 0x0053 }
            r2 = r0
            r0 = r11
            r1 = r25
            r0.<init>(r1, r2, r4, r5)     // Catch:{ SQLiteException -> 0x00ec }
            com.google.android.gms.measurement.internal.e r8 = new com.google.android.gms.measurement.internal.e     // Catch:{ SQLiteException -> 0x00ec }
            r9 = r24
            r11 = r0
            r10 = r5
            r8.<init>(r9, r10, r11, r12, r14, r15, r16, r17, r19, r20, r22)     // Catch:{ SQLiteException -> 0x00ec }
            boolean r0 = r7.moveToNext()     // Catch:{ SQLiteException -> 0x00ec }
            if (r0 == 0) goto L_0x00ee
            com.google.android.gms.measurement.internal.n2 r0 = r23.a()     // Catch:{ SQLiteException -> 0x00ec }
            com.google.android.gms.measurement.internal.p2 r0 = r0.G()     // Catch:{ SQLiteException -> 0x00ec }
            java.lang.String r2 = "Got multiple records for conditional property, expected one"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.C0821n2.s(r24)     // Catch:{ SQLiteException -> 0x00ec }
            com.google.android.gms.measurement.internal.h2 r4 = r23.d()     // Catch:{ SQLiteException -> 0x00ec }
            java.lang.String r4 = r4.g(r1)     // Catch:{ SQLiteException -> 0x00ec }
            r0.c(r2, r3, r4)     // Catch:{ SQLiteException -> 0x00ec }
            goto L_0x00ee
        L_0x00ec:
            r0 = move-exception
            goto L_0x00f8
        L_0x00ee:
            r7.close()
            return r8
        L_0x00f2:
            r0 = move-exception
            goto L_0x0117
        L_0x00f4:
            r0 = move-exception
            r1 = r25
            r7 = r6
        L_0x00f8:
            com.google.android.gms.measurement.internal.n2 r2 = r23.a()     // Catch:{ all -> 0x004f }
            com.google.android.gms.measurement.internal.p2 r2 = r2.G()     // Catch:{ all -> 0x004f }
            java.lang.String r3 = "Error querying conditional property"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.C0821n2.s(r24)     // Catch:{ all -> 0x004f }
            com.google.android.gms.measurement.internal.h2 r5 = r23.d()     // Catch:{ all -> 0x004f }
            java.lang.String r1 = r5.g(r1)     // Catch:{ all -> 0x004f }
            r2.d(r3, r4, r1, r0)     // Catch:{ all -> 0x004f }
            if (r7 == 0) goto L_0x0116
            r7.close()
        L_0x0116:
            return r6
        L_0x0117:
            if (r6 == 0) goto L_0x011c
            r6.close()
        L_0x011c:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.C0797k.I0(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.e");
    }

    public final C0825o J(long j4, String str, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10) {
        return I(j4, str, 1, false, false, z6, false, z8, z9, z10);
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0086  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.os.Bundle K0(java.lang.String r6) {
        /*
            r5 = this;
            r5.k()
            r5.r()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r5.y()     // Catch:{ SQLiteException -> 0x006f, all -> 0x006d }
            java.lang.String r2 = "select parameters from default_event_params where app_id=?"
            java.lang.String[] r3 = new java.lang.String[]{r6}     // Catch:{ SQLiteException -> 0x006f, all -> 0x006d }
            android.database.Cursor r1 = r1.rawQuery(r2, r3)     // Catch:{ SQLiteException -> 0x006f, all -> 0x006d }
            boolean r2 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x002f }
            if (r2 != 0) goto L_0x0031
            com.google.android.gms.measurement.internal.n2 r6 = r5.a()     // Catch:{ SQLiteException -> 0x002f }
            com.google.android.gms.measurement.internal.p2 r6 = r6.K()     // Catch:{ SQLiteException -> 0x002f }
            java.lang.String r2 = "Default event parameters not found"
            r6.a(r2)     // Catch:{ SQLiteException -> 0x002f }
            r1.close()
            return r0
        L_0x002c:
            r6 = move-exception
            r0 = r1
            goto L_0x0084
        L_0x002f:
            r6 = move-exception
            goto L_0x0071
        L_0x0031:
            r2 = 0
            byte[] r2 = r1.getBlob(r2)     // Catch:{ SQLiteException -> 0x002f }
            com.google.android.gms.internal.measurement.k2$a r3 = com.google.android.gms.internal.measurement.C0599k2.S()     // Catch:{ IOException -> 0x0057 }
            com.google.android.gms.internal.measurement.Y4 r2 = com.google.android.gms.measurement.internal.Z5.G(r3, r2)     // Catch:{ IOException -> 0x0057 }
            com.google.android.gms.internal.measurement.k2$a r2 = (com.google.android.gms.internal.measurement.C0599k2.a) r2     // Catch:{ IOException -> 0x0057 }
            com.google.android.gms.internal.measurement.Z4 r2 = r2.m()     // Catch:{ IOException -> 0x0057 }
            com.google.android.gms.internal.measurement.s4 r2 = (com.google.android.gms.internal.measurement.C0668s4) r2     // Catch:{ IOException -> 0x0057 }
            com.google.android.gms.internal.measurement.k2 r2 = (com.google.android.gms.internal.measurement.C0599k2) r2     // Catch:{ IOException -> 0x0057 }
            r5.l()     // Catch:{ SQLiteException -> 0x002f }
            java.util.List r6 = r2.V()     // Catch:{ SQLiteException -> 0x002f }
            android.os.Bundle r6 = com.google.android.gms.measurement.internal.Z5.y(r6)     // Catch:{ SQLiteException -> 0x002f }
            r1.close()
            return r6
        L_0x0057:
            r2 = move-exception
            com.google.android.gms.measurement.internal.n2 r3 = r5.a()     // Catch:{ SQLiteException -> 0x002f }
            com.google.android.gms.measurement.internal.p2 r3 = r3.G()     // Catch:{ SQLiteException -> 0x002f }
            java.lang.String r4 = "Failed to retrieve default event parameters. appId"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.C0821n2.s(r6)     // Catch:{ SQLiteException -> 0x002f }
            r3.c(r4, r6, r2)     // Catch:{ SQLiteException -> 0x002f }
            r1.close()
            return r0
        L_0x006d:
            r6 = move-exception
            goto L_0x0084
        L_0x006f:
            r6 = move-exception
            r1 = r0
        L_0x0071:
            com.google.android.gms.measurement.internal.n2 r2 = r5.a()     // Catch:{ all -> 0x002c }
            com.google.android.gms.measurement.internal.p2 r2 = r2.G()     // Catch:{ all -> 0x002c }
            java.lang.String r3 = "Error selecting default event parameters"
            r2.b(r3, r6)     // Catch:{ all -> 0x002c }
            if (r1 == 0) goto L_0x0083
            r1.close()
        L_0x0083:
            return r0
        L_0x0084:
            if (r0 == 0) goto L_0x0089
            r0.close()
        L_0x0089:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.C0797k.K0(java.lang.String):android.os.Bundle");
    }

    public final A L0(String str, String str2) {
        return J0("events", str, str2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:112:0x0351 A[Catch:{ SQLiteException -> 0x00b8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x037d  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0383  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0134 A[Catch:{ SQLiteException -> 0x00b8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x017f A[Catch:{ SQLiteException -> 0x00b8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0183 A[Catch:{ SQLiteException -> 0x00b8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x01b7 A[Catch:{ SQLiteException -> 0x00b8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x01d5 A[Catch:{ SQLiteException -> 0x00b8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x01d8 A[Catch:{ SQLiteException -> 0x00b8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x01e7 A[Catch:{ SQLiteException -> 0x00b8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x023d A[Catch:{ SQLiteException -> 0x00b8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x02b3 A[Catch:{ SQLiteException -> 0x00b8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x02b5 A[Catch:{ SQLiteException -> 0x00b8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x02c1 A[Catch:{ SQLiteException -> 0x00b8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x02c3 A[Catch:{ SQLiteException -> 0x00b8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x02eb A[Catch:{ SQLiteException -> 0x00b8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x02ee A[Catch:{ SQLiteException -> 0x00b8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0307 A[Catch:{ SQLiteException -> 0x00b8 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.C0744c2 M0(java.lang.String r51) {
        /*
            r50 = this;
            r1 = r50
            r2 = r51
            M.C0335p.f(r2)
            r1.k()
            r1.r()
            r3 = 0
            android.database.sqlite.SQLiteDatabase r4 = r1.y()     // Catch:{ SQLiteException -> 0x0368, all -> 0x0366 }
            java.lang.String r5 = "apps"
            java.lang.String r6 = "app_instance_id"
            java.lang.String r7 = "gmp_app_id"
            java.lang.String r8 = "resettable_device_id_hash"
            java.lang.String r9 = "last_bundle_index"
            java.lang.String r10 = "last_bundle_start_timestamp"
            java.lang.String r11 = "last_bundle_end_timestamp"
            java.lang.String r12 = "app_version"
            java.lang.String r13 = "app_store"
            java.lang.String r14 = "gmp_version"
            java.lang.String r15 = "dev_cert_hash"
            java.lang.String r16 = "measurement_enabled"
            java.lang.String r17 = "day"
            java.lang.String r18 = "daily_public_events_count"
            java.lang.String r19 = "daily_events_count"
            java.lang.String r20 = "daily_conversions_count"
            java.lang.String r21 = "config_fetched_time"
            java.lang.String r22 = "failed_config_fetch_time"
            java.lang.String r23 = "app_version_int"
            java.lang.String r24 = "firebase_instance_id"
            java.lang.String r25 = "daily_error_events_count"
            java.lang.String r26 = "daily_realtime_events_count"
            java.lang.String r27 = "health_monitor_sample"
            java.lang.String r28 = "android_id"
            java.lang.String r29 = "adid_reporting_enabled"
            java.lang.String r30 = "admob_app_id"
            java.lang.String r31 = "dynamite_version"
            java.lang.String r32 = "safelisted_events"
            java.lang.String r33 = "ga_app_id"
            java.lang.String r34 = "session_stitching_token"
            java.lang.String r35 = "sgtm_upload_enabled"
            java.lang.String r36 = "target_os_version"
            java.lang.String r37 = "session_stitching_token_hash"
            java.lang.String r38 = "ad_services_version"
            java.lang.String r39 = "unmatched_first_open_without_ad_id"
            java.lang.String r40 = "npa_metadata_value"
            java.lang.String r41 = "attribution_eligibility_status"
            java.lang.String r42 = "sgtm_preview_key"
            java.lang.String r43 = "dma_consent_state"
            java.lang.String r44 = "daily_realtime_dcu_count"
            java.lang.String r45 = "bundle_delivery_index"
            java.lang.String r46 = "serialized_npa_metadata"
            java.lang.String r47 = "unmatched_pfo"
            java.lang.String r48 = "unmatched_uwa"
            java.lang.String r49 = "ad_campaign_info"
            java.lang.String[] r6 = new java.lang.String[]{r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49}     // Catch:{ SQLiteException -> 0x0368, all -> 0x0366 }
            java.lang.String r7 = "app_id=?"
            java.lang.String[] r8 = new java.lang.String[]{r2}     // Catch:{ SQLiteException -> 0x0368, all -> 0x0366 }
            r10 = 0
            r11 = 0
            r9 = 0
            android.database.Cursor r4 = r4.query(r5, r6, r7, r8, r9, r10, r11)     // Catch:{ SQLiteException -> 0x0368, all -> 0x0366 }
            boolean r0 = r4.moveToFirst()     // Catch:{ SQLiteException -> 0x00b8 }
            if (r0 != 0) goto L_0x0087
            r4.close()
            return r3
        L_0x0087:
            com.google.android.gms.measurement.internal.c2 r0 = new com.google.android.gms.measurement.internal.c2     // Catch:{ SQLiteException -> 0x00b8 }
            com.google.android.gms.measurement.internal.H5 r5 = r1.f2403b     // Catch:{ SQLiteException -> 0x00b8 }
            com.google.android.gms.measurement.internal.S2 r5 = r5.t0()     // Catch:{ SQLiteException -> 0x00b8 }
            r0.<init>(r5, r2)     // Catch:{ SQLiteException -> 0x00b8 }
            boolean r5 = com.google.android.gms.internal.measurement.C0576h6.a()     // Catch:{ SQLiteException -> 0x00b8 }
            r6 = 0
            if (r5 == 0) goto L_0x00bb
            com.google.android.gms.measurement.internal.g r5 = r1.b()     // Catch:{ SQLiteException -> 0x00b8 }
            com.google.android.gms.measurement.internal.b2 r7 = com.google.android.gms.measurement.internal.G.f2455Z0     // Catch:{ SQLiteException -> 0x00b8 }
            boolean r5 = r5.q(r7)     // Catch:{ SQLiteException -> 0x00b8 }
            if (r5 == 0) goto L_0x00bb
            com.google.android.gms.measurement.internal.H5 r5 = r1.f2403b     // Catch:{ SQLiteException -> 0x00b8 }
            com.google.android.gms.measurement.internal.A3 r5 = r5.U(r2)     // Catch:{ SQLiteException -> 0x00b8 }
            com.google.android.gms.measurement.internal.A3$a r7 = com.google.android.gms.measurement.internal.A3.a.ANALYTICS_STORAGE     // Catch:{ SQLiteException -> 0x00b8 }
            boolean r5 = r5.m(r7)     // Catch:{ SQLiteException -> 0x00b8 }
            if (r5 == 0) goto L_0x00c2
            goto L_0x00bb
        L_0x00b4:
            r0 = move-exception
            r3 = r4
            goto L_0x0381
        L_0x00b8:
            r0 = move-exception
            goto L_0x036a
        L_0x00bb:
            java.lang.String r5 = r4.getString(r6)     // Catch:{ SQLiteException -> 0x00b8 }
            r0.J(r5)     // Catch:{ SQLiteException -> 0x00b8 }
        L_0x00c2:
            r5 = 1
            java.lang.String r7 = r4.getString(r5)     // Catch:{ SQLiteException -> 0x00b8 }
            r0.Z(r7)     // Catch:{ SQLiteException -> 0x00b8 }
            boolean r7 = com.google.android.gms.internal.measurement.C0576h6.a()     // Catch:{ SQLiteException -> 0x00b8 }
            if (r7 == 0) goto L_0x00ea
            com.google.android.gms.measurement.internal.g r7 = r1.b()     // Catch:{ SQLiteException -> 0x00b8 }
            com.google.android.gms.measurement.internal.b2 r8 = com.google.android.gms.measurement.internal.G.f2455Z0     // Catch:{ SQLiteException -> 0x00b8 }
            boolean r7 = r7.q(r8)     // Catch:{ SQLiteException -> 0x00b8 }
            if (r7 == 0) goto L_0x00ea
            com.google.android.gms.measurement.internal.H5 r7 = r1.f2403b     // Catch:{ SQLiteException -> 0x00b8 }
            com.google.android.gms.measurement.internal.A3 r7 = r7.U(r2)     // Catch:{ SQLiteException -> 0x00b8 }
            com.google.android.gms.measurement.internal.A3$a r8 = com.google.android.gms.measurement.internal.A3.a.AD_STORAGE     // Catch:{ SQLiteException -> 0x00b8 }
            boolean r7 = r7.m(r8)     // Catch:{ SQLiteException -> 0x00b8 }
            if (r7 == 0) goto L_0x00f2
        L_0x00ea:
            r7 = 2
            java.lang.String r7 = r4.getString(r7)     // Catch:{ SQLiteException -> 0x00b8 }
            r0.f0(r7)     // Catch:{ SQLiteException -> 0x00b8 }
        L_0x00f2:
            r7 = 3
            long r7 = r4.getLong(r7)     // Catch:{ SQLiteException -> 0x00b8 }
            r0.A0(r7)     // Catch:{ SQLiteException -> 0x00b8 }
            r7 = 4
            long r7 = r4.getLong(r7)     // Catch:{ SQLiteException -> 0x00b8 }
            r0.C0(r7)     // Catch:{ SQLiteException -> 0x00b8 }
            r7 = 5
            long r7 = r4.getLong(r7)     // Catch:{ SQLiteException -> 0x00b8 }
            r0.y0(r7)     // Catch:{ SQLiteException -> 0x00b8 }
            r7 = 6
            java.lang.String r7 = r4.getString(r7)     // Catch:{ SQLiteException -> 0x00b8 }
            r0.S(r7)     // Catch:{ SQLiteException -> 0x00b8 }
            r7 = 7
            java.lang.String r7 = r4.getString(r7)     // Catch:{ SQLiteException -> 0x00b8 }
            r0.O(r7)     // Catch:{ SQLiteException -> 0x00b8 }
            r7 = 8
            long r7 = r4.getLong(r7)     // Catch:{ SQLiteException -> 0x00b8 }
            r0.u0(r7)     // Catch:{ SQLiteException -> 0x00b8 }
            r7 = 9
            long r7 = r4.getLong(r7)     // Catch:{ SQLiteException -> 0x00b8 }
            r0.n0(r7)     // Catch:{ SQLiteException -> 0x00b8 }
            r7 = 10
            boolean r8 = r4.isNull(r7)     // Catch:{ SQLiteException -> 0x00b8 }
            if (r8 != 0) goto L_0x013d
            int r7 = r4.getInt(r7)     // Catch:{ SQLiteException -> 0x00b8 }
            if (r7 == 0) goto L_0x013b
            goto L_0x013d
        L_0x013b:
            r7 = 0
            goto L_0x013e
        L_0x013d:
            r7 = 1
        L_0x013e:
            r0.K(r7)     // Catch:{ SQLiteException -> 0x00b8 }
            r7 = 11
            long r7 = r4.getLong(r7)     // Catch:{ SQLiteException -> 0x00b8 }
            r0.k0(r7)     // Catch:{ SQLiteException -> 0x00b8 }
            r7 = 12
            long r7 = r4.getLong(r7)     // Catch:{ SQLiteException -> 0x00b8 }
            r0.e0(r7)     // Catch:{ SQLiteException -> 0x00b8 }
            r7 = 13
            long r7 = r4.getLong(r7)     // Catch:{ SQLiteException -> 0x00b8 }
            r0.b0(r7)     // Catch:{ SQLiteException -> 0x00b8 }
            r7 = 14
            long r7 = r4.getLong(r7)     // Catch:{ SQLiteException -> 0x00b8 }
            r0.V(r7)     // Catch:{ SQLiteException -> 0x00b8 }
            r7 = 15
            long r7 = r4.getLong(r7)     // Catch:{ SQLiteException -> 0x00b8 }
            r0.R(r7)     // Catch:{ SQLiteException -> 0x00b8 }
            r7 = 16
            long r7 = r4.getLong(r7)     // Catch:{ SQLiteException -> 0x00b8 }
            r0.s0(r7)     // Catch:{ SQLiteException -> 0x00b8 }
            r7 = 17
            boolean r8 = r4.isNull(r7)     // Catch:{ SQLiteException -> 0x00b8 }
            if (r8 == 0) goto L_0x0183
            r7 = -2147483648(0xffffffff80000000, double:NaN)
            goto L_0x0188
        L_0x0183:
            int r7 = r4.getInt(r7)     // Catch:{ SQLiteException -> 0x00b8 }
            long r7 = (long) r7     // Catch:{ SQLiteException -> 0x00b8 }
        L_0x0188:
            r0.H(r7)     // Catch:{ SQLiteException -> 0x00b8 }
            r7 = 18
            java.lang.String r7 = r4.getString(r7)     // Catch:{ SQLiteException -> 0x00b8 }
            r0.W(r7)     // Catch:{ SQLiteException -> 0x00b8 }
            r7 = 19
            long r7 = r4.getLong(r7)     // Catch:{ SQLiteException -> 0x00b8 }
            r0.Y(r7)     // Catch:{ SQLiteException -> 0x00b8 }
            r7 = 20
            long r7 = r4.getLong(r7)     // Catch:{ SQLiteException -> 0x00b8 }
            r0.h0(r7)     // Catch:{ SQLiteException -> 0x00b8 }
            r7 = 21
            java.lang.String r7 = r4.getString(r7)     // Catch:{ SQLiteException -> 0x00b8 }
            r0.c0(r7)     // Catch:{ SQLiteException -> 0x00b8 }
            r7 = 23
            boolean r8 = r4.isNull(r7)     // Catch:{ SQLiteException -> 0x00b8 }
            if (r8 != 0) goto L_0x01c0
            int r7 = r4.getInt(r7)     // Catch:{ SQLiteException -> 0x00b8 }
            if (r7 == 0) goto L_0x01be
            goto L_0x01c0
        L_0x01be:
            r7 = 0
            goto L_0x01c1
        L_0x01c0:
            r7 = 1
        L_0x01c1:
            r0.h(r7)     // Catch:{ SQLiteException -> 0x00b8 }
            r7 = 24
            java.lang.String r7 = r4.getString(r7)     // Catch:{ SQLiteException -> 0x00b8 }
            r0.f(r7)     // Catch:{ SQLiteException -> 0x00b8 }
            r7 = 25
            boolean r8 = r4.isNull(r7)     // Catch:{ SQLiteException -> 0x00b8 }
            if (r8 == 0) goto L_0x01d8
            r7 = 0
            goto L_0x01dc
        L_0x01d8:
            long r7 = r4.getLong(r7)     // Catch:{ SQLiteException -> 0x00b8 }
        L_0x01dc:
            r0.q0(r7)     // Catch:{ SQLiteException -> 0x00b8 }
            r7 = 26
            boolean r8 = r4.isNull(r7)     // Catch:{ SQLiteException -> 0x00b8 }
            if (r8 != 0) goto L_0x01f9
            java.lang.String r7 = r4.getString(r7)     // Catch:{ SQLiteException -> 0x00b8 }
            java.lang.String r8 = ","
            r9 = -1
            java.lang.String[] r7 = r7.split(r8, r9)     // Catch:{ SQLiteException -> 0x00b8 }
            java.util.List r7 = java.util.Arrays.asList(r7)     // Catch:{ SQLiteException -> 0x00b8 }
            r0.g(r7)     // Catch:{ SQLiteException -> 0x00b8 }
        L_0x01f9:
            boolean r7 = com.google.android.gms.internal.measurement.C0576h6.a()     // Catch:{ SQLiteException -> 0x00b8 }
            if (r7 == 0) goto L_0x0219
            com.google.android.gms.measurement.internal.g r7 = r1.b()     // Catch:{ SQLiteException -> 0x00b8 }
            com.google.android.gms.measurement.internal.b2 r8 = com.google.android.gms.measurement.internal.G.f2455Z0     // Catch:{ SQLiteException -> 0x00b8 }
            boolean r7 = r7.q(r8)     // Catch:{ SQLiteException -> 0x00b8 }
            if (r7 == 0) goto L_0x0219
            com.google.android.gms.measurement.internal.H5 r7 = r1.f2403b     // Catch:{ SQLiteException -> 0x00b8 }
            com.google.android.gms.measurement.internal.A3 r7 = r7.U(r2)     // Catch:{ SQLiteException -> 0x00b8 }
            com.google.android.gms.measurement.internal.A3$a r8 = com.google.android.gms.measurement.internal.A3.a.ANALYTICS_STORAGE     // Catch:{ SQLiteException -> 0x00b8 }
            boolean r7 = r7.m(r8)     // Catch:{ SQLiteException -> 0x00b8 }
            if (r7 == 0) goto L_0x0222
        L_0x0219:
            r7 = 28
            java.lang.String r7 = r4.getString(r7)     // Catch:{ SQLiteException -> 0x00b8 }
            r0.l0(r7)     // Catch:{ SQLiteException -> 0x00b8 }
        L_0x0222:
            boolean r7 = com.google.android.gms.internal.measurement.r7.a()     // Catch:{ SQLiteException -> 0x00b8 }
            if (r7 == 0) goto L_0x026f
            com.google.android.gms.measurement.internal.g r7 = r1.b()     // Catch:{ SQLiteException -> 0x00b8 }
            com.google.android.gms.measurement.internal.b2 r8 = com.google.android.gms.measurement.internal.G.f2518y0     // Catch:{ SQLiteException -> 0x00b8 }
            boolean r7 = r7.q(r8)     // Catch:{ SQLiteException -> 0x00b8 }
            if (r7 == 0) goto L_0x026f
            r1.g()     // Catch:{ SQLiteException -> 0x00b8 }
            boolean r7 = com.google.android.gms.measurement.internal.d6.H0(r2)     // Catch:{ SQLiteException -> 0x00b8 }
            if (r7 == 0) goto L_0x026f
            r7 = 29
            boolean r8 = r4.isNull(r7)     // Catch:{ SQLiteException -> 0x00b8 }
            if (r8 != 0) goto L_0x024d
            int r7 = r4.getInt(r7)     // Catch:{ SQLiteException -> 0x00b8 }
            if (r7 == 0) goto L_0x024d
            r7 = 1
            goto L_0x024e
        L_0x024d:
            r7 = 0
        L_0x024e:
            r0.P(r7)     // Catch:{ SQLiteException -> 0x00b8 }
            r7 = 39
            long r7 = r4.getLong(r7)     // Catch:{ SQLiteException -> 0x00b8 }
            r0.w0(r7)     // Catch:{ SQLiteException -> 0x00b8 }
            com.google.android.gms.measurement.internal.g r7 = r1.b()     // Catch:{ SQLiteException -> 0x00b8 }
            com.google.android.gms.measurement.internal.b2 r8 = com.google.android.gms.measurement.internal.G.f2520z0     // Catch:{ SQLiteException -> 0x00b8 }
            boolean r7 = r7.q(r8)     // Catch:{ SQLiteException -> 0x00b8 }
            if (r7 == 0) goto L_0x026f
            r7 = 36
            java.lang.String r7 = r4.getString(r7)     // Catch:{ SQLiteException -> 0x00b8 }
            r0.o0(r7)     // Catch:{ SQLiteException -> 0x00b8 }
        L_0x026f:
            r7 = 30
            long r7 = r4.getLong(r7)     // Catch:{ SQLiteException -> 0x00b8 }
            r0.G0(r7)     // Catch:{ SQLiteException -> 0x00b8 }
            r7 = 31
            long r7 = r4.getLong(r7)     // Catch:{ SQLiteException -> 0x00b8 }
            r0.E0(r7)     // Catch:{ SQLiteException -> 0x00b8 }
            boolean r7 = com.google.android.gms.internal.measurement.C0604k7.a()     // Catch:{ SQLiteException -> 0x00b8 }
            if (r7 == 0) goto L_0x02a5
            com.google.android.gms.measurement.internal.g r7 = r1.b()     // Catch:{ SQLiteException -> 0x00b8 }
            com.google.android.gms.measurement.internal.b2 r8 = com.google.android.gms.measurement.internal.G.f2421I0     // Catch:{ SQLiteException -> 0x00b8 }
            boolean r7 = r7.F(r2, r8)     // Catch:{ SQLiteException -> 0x00b8 }
            if (r7 == 0) goto L_0x02a5
            r7 = 32
            int r7 = r4.getInt(r7)     // Catch:{ SQLiteException -> 0x00b8 }
            r0.b(r7)     // Catch:{ SQLiteException -> 0x00b8 }
            r7 = 35
            long r7 = r4.getLong(r7)     // Catch:{ SQLiteException -> 0x00b8 }
            r0.N(r7)     // Catch:{ SQLiteException -> 0x00b8 }
        L_0x02a5:
            r7 = 33
            boolean r8 = r4.isNull(r7)     // Catch:{ SQLiteException -> 0x00b8 }
            if (r8 != 0) goto L_0x02b5
            int r7 = r4.getInt(r7)     // Catch:{ SQLiteException -> 0x00b8 }
            if (r7 == 0) goto L_0x02b5
            r7 = 1
            goto L_0x02b6
        L_0x02b5:
            r7 = 0
        L_0x02b6:
            r0.T(r7)     // Catch:{ SQLiteException -> 0x00b8 }
            r7 = 34
            boolean r8 = r4.isNull(r7)     // Catch:{ SQLiteException -> 0x00b8 }
            if (r8 == 0) goto L_0x02c3
            r5 = r3
            goto L_0x02ce
        L_0x02c3:
            int r7 = r4.getInt(r7)     // Catch:{ SQLiteException -> 0x00b8 }
            if (r7 == 0) goto L_0x02ca
            r6 = 1
        L_0x02ca:
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r6)     // Catch:{ SQLiteException -> 0x00b8 }
        L_0x02ce:
            r0.d(r5)     // Catch:{ SQLiteException -> 0x00b8 }
            r5 = 37
            int r5 = r4.getInt(r5)     // Catch:{ SQLiteException -> 0x00b8 }
            r0.M(r5)     // Catch:{ SQLiteException -> 0x00b8 }
            r5 = 38
            int r5 = r4.getInt(r5)     // Catch:{ SQLiteException -> 0x00b8 }
            r0.G(r5)     // Catch:{ SQLiteException -> 0x00b8 }
            r5 = 40
            boolean r6 = r4.isNull(r5)     // Catch:{ SQLiteException -> 0x00b8 }
            if (r6 == 0) goto L_0x02ee
            java.lang.String r5 = ""
            goto L_0x02f8
        L_0x02ee:
            java.lang.String r5 = r4.getString(r5)     // Catch:{ SQLiteException -> 0x00b8 }
            java.lang.Object r5 = M.C0335p.l(r5)     // Catch:{ SQLiteException -> 0x00b8 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ SQLiteException -> 0x00b8 }
        L_0x02f8:
            r0.i0(r5)     // Catch:{ SQLiteException -> 0x00b8 }
            com.google.android.gms.measurement.internal.g r5 = r1.b()     // Catch:{ SQLiteException -> 0x00b8 }
            com.google.android.gms.measurement.internal.b2 r6 = com.google.android.gms.measurement.internal.G.f2451X0     // Catch:{ SQLiteException -> 0x00b8 }
            boolean r5 = r5.q(r6)     // Catch:{ SQLiteException -> 0x00b8 }
            if (r5 == 0) goto L_0x032d
            r5 = 41
            boolean r6 = r4.isNull(r5)     // Catch:{ SQLiteException -> 0x00b8 }
            if (r6 != 0) goto L_0x031a
            long r5 = r4.getLong(r5)     // Catch:{ SQLiteException -> 0x00b8 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ SQLiteException -> 0x00b8 }
            r0.e(r5)     // Catch:{ SQLiteException -> 0x00b8 }
        L_0x031a:
            r5 = 42
            boolean r6 = r4.isNull(r5)     // Catch:{ SQLiteException -> 0x00b8 }
            if (r6 != 0) goto L_0x032d
            long r5 = r4.getLong(r5)     // Catch:{ SQLiteException -> 0x00b8 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ SQLiteException -> 0x00b8 }
            r0.I(r5)     // Catch:{ SQLiteException -> 0x00b8 }
        L_0x032d:
            boolean r5 = com.google.android.gms.internal.measurement.R6.a()     // Catch:{ SQLiteException -> 0x00b8 }
            if (r5 == 0) goto L_0x0348
            com.google.android.gms.measurement.internal.g r5 = r1.b()     // Catch:{ SQLiteException -> 0x00b8 }
            com.google.android.gms.measurement.internal.b2 r6 = com.google.android.gms.measurement.internal.G.f2447V0     // Catch:{ SQLiteException -> 0x00b8 }
            boolean r5 = r5.F(r2, r6)     // Catch:{ SQLiteException -> 0x00b8 }
            if (r5 == 0) goto L_0x0348
            r5 = 43
            byte[] r5 = r4.getBlob(r5)     // Catch:{ SQLiteException -> 0x00b8 }
            r0.i(r5)     // Catch:{ SQLiteException -> 0x00b8 }
        L_0x0348:
            r0.x()     // Catch:{ SQLiteException -> 0x00b8 }
            boolean r5 = r4.moveToNext()     // Catch:{ SQLiteException -> 0x00b8 }
            if (r5 == 0) goto L_0x0362
            com.google.android.gms.measurement.internal.n2 r5 = r1.a()     // Catch:{ SQLiteException -> 0x00b8 }
            com.google.android.gms.measurement.internal.p2 r5 = r5.G()     // Catch:{ SQLiteException -> 0x00b8 }
            java.lang.String r6 = "Got multiple records for app, expected one. appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.C0821n2.s(r2)     // Catch:{ SQLiteException -> 0x00b8 }
            r5.b(r6, r7)     // Catch:{ SQLiteException -> 0x00b8 }
        L_0x0362:
            r4.close()
            return r0
        L_0x0366:
            r0 = move-exception
            goto L_0x0381
        L_0x0368:
            r0 = move-exception
            r4 = r3
        L_0x036a:
            com.google.android.gms.measurement.internal.n2 r5 = r1.a()     // Catch:{ all -> 0x00b4 }
            com.google.android.gms.measurement.internal.p2 r5 = r5.G()     // Catch:{ all -> 0x00b4 }
            java.lang.String r6 = "Error querying app. appId"
            java.lang.Object r2 = com.google.android.gms.measurement.internal.C0821n2.s(r2)     // Catch:{ all -> 0x00b4 }
            r5.c(r6, r2, r0)     // Catch:{ all -> 0x00b4 }
            if (r4 == 0) goto L_0x0380
            r4.close()
        L_0x0380:
            return r3
        L_0x0381:
            if (r3 == 0) goto L_0x0386
            r3.close()
        L_0x0386:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.C0797k.M0(java.lang.String):com.google.android.gms.measurement.internal.c2");
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00a0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.a6 N0(java.lang.String r11, java.lang.String r12) {
        /*
            r10 = this;
            M.C0335p.f(r11)
            M.C0335p.f(r12)
            r10.k()
            r10.r()
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r10.y()     // Catch:{ SQLiteException -> 0x007a, all -> 0x0077 }
            java.lang.String r3 = "user_attributes"
            java.lang.String r0 = "set_timestamp"
            java.lang.String r4 = "value"
            java.lang.String r5 = "origin"
            java.lang.String[] r4 = new java.lang.String[]{r0, r4, r5}     // Catch:{ SQLiteException -> 0x007a, all -> 0x0077 }
            java.lang.String r5 = "app_id=? and name=?"
            java.lang.String[] r6 = new java.lang.String[]{r11, r12}     // Catch:{ SQLiteException -> 0x007a, all -> 0x0077 }
            r8 = 0
            r9 = 0
            r7 = 0
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ SQLiteException -> 0x007a, all -> 0x0077 }
            boolean r0 = r2.moveToFirst()     // Catch:{ SQLiteException -> 0x0073 }
            if (r0 != 0) goto L_0x0034
            r2.close()
            return r1
        L_0x0034:
            r0 = 0
            long r7 = r2.getLong(r0)     // Catch:{ SQLiteException -> 0x0073 }
            r0 = 1
            java.lang.Object r9 = r10.M(r2, r0)     // Catch:{ SQLiteException -> 0x0073 }
            if (r9 != 0) goto L_0x0044
            r2.close()
            return r1
        L_0x0044:
            r0 = 2
            java.lang.String r5 = r2.getString(r0)     // Catch:{ SQLiteException -> 0x0073 }
            com.google.android.gms.measurement.internal.a6 r3 = new com.google.android.gms.measurement.internal.a6     // Catch:{ SQLiteException -> 0x0073 }
            r4 = r11
            r6 = r12
            r3.<init>(r4, r5, r6, r7, r9)     // Catch:{ SQLiteException -> 0x006c }
            boolean r11 = r2.moveToNext()     // Catch:{ SQLiteException -> 0x006c }
            if (r11 == 0) goto L_0x006f
            com.google.android.gms.measurement.internal.n2 r11 = r10.a()     // Catch:{ SQLiteException -> 0x006c }
            com.google.android.gms.measurement.internal.p2 r11 = r11.G()     // Catch:{ SQLiteException -> 0x006c }
            java.lang.String r12 = "Got multiple records for user property, expected one. appId"
            java.lang.Object r0 = com.google.android.gms.measurement.internal.C0821n2.s(r4)     // Catch:{ SQLiteException -> 0x006c }
            r11.b(r12, r0)     // Catch:{ SQLiteException -> 0x006c }
            goto L_0x006f
        L_0x0068:
            r0 = move-exception
            r11 = r0
            r1 = r2
            goto L_0x009e
        L_0x006c:
            r0 = move-exception
        L_0x006d:
            r11 = r0
            goto L_0x007f
        L_0x006f:
            r2.close()
            return r3
        L_0x0073:
            r0 = move-exception
            r4 = r11
            r6 = r12
            goto L_0x006d
        L_0x0077:
            r0 = move-exception
            r11 = r0
            goto L_0x009e
        L_0x007a:
            r0 = move-exception
            r4 = r11
            r6 = r12
            r11 = r0
            r2 = r1
        L_0x007f:
            com.google.android.gms.measurement.internal.n2 r12 = r10.a()     // Catch:{ all -> 0x0068 }
            com.google.android.gms.measurement.internal.p2 r12 = r12.G()     // Catch:{ all -> 0x0068 }
            java.lang.String r0 = "Error querying user property. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.C0821n2.s(r4)     // Catch:{ all -> 0x0068 }
            com.google.android.gms.measurement.internal.h2 r4 = r10.d()     // Catch:{ all -> 0x0068 }
            java.lang.String r4 = r4.g(r6)     // Catch:{ all -> 0x0068 }
            r12.d(r0, r3, r4, r11)     // Catch:{ all -> 0x0068 }
            if (r2 == 0) goto L_0x009d
            r2.close()
        L_0x009d:
            return r1
        L_0x009e:
            if (r1 == 0) goto L_0x00a3
            r1.close()
        L_0x00a3:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.C0797k.N0(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.a6");
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0057  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String O(long r4) {
        /*
            r3 = this;
            r3.k()
            r3.r()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r3.y()     // Catch:{ SQLiteException -> 0x0040, all -> 0x003e }
            java.lang.String r2 = "select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;"
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ SQLiteException -> 0x0040, all -> 0x003e }
            java.lang.String[] r4 = new java.lang.String[]{r4}     // Catch:{ SQLiteException -> 0x0040, all -> 0x003e }
            android.database.Cursor r4 = r1.rawQuery(r2, r4)     // Catch:{ SQLiteException -> 0x0040, all -> 0x003e }
            boolean r5 = r4.moveToFirst()     // Catch:{ SQLiteException -> 0x0033 }
            if (r5 != 0) goto L_0x0035
            com.google.android.gms.measurement.internal.n2 r5 = r3.a()     // Catch:{ SQLiteException -> 0x0033 }
            com.google.android.gms.measurement.internal.p2 r5 = r5.K()     // Catch:{ SQLiteException -> 0x0033 }
            java.lang.String r1 = "No expired configs for apps with pending events"
            r5.a(r1)     // Catch:{ SQLiteException -> 0x0033 }
            r4.close()
            return r0
        L_0x0030:
            r5 = move-exception
            r0 = r4
            goto L_0x0055
        L_0x0033:
            r5 = move-exception
            goto L_0x0042
        L_0x0035:
            r5 = 0
            java.lang.String r5 = r4.getString(r5)     // Catch:{ SQLiteException -> 0x0033 }
            r4.close()
            return r5
        L_0x003e:
            r5 = move-exception
            goto L_0x0055
        L_0x0040:
            r5 = move-exception
            r4 = r0
        L_0x0042:
            com.google.android.gms.measurement.internal.n2 r1 = r3.a()     // Catch:{ all -> 0x0030 }
            com.google.android.gms.measurement.internal.p2 r1 = r1.G()     // Catch:{ all -> 0x0030 }
            java.lang.String r2 = "Error selecting expired configs"
            r1.b(r2, r5)     // Catch:{ all -> 0x0030 }
            if (r4 == 0) goto L_0x0054
            r4.close()
        L_0x0054:
            return r0
        L_0x0055:
            if (r0 == 0) goto L_0x005a
            r0.close()
        L_0x005a:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.C0797k.O(long):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x008b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.C0804l O0(java.lang.String r11) {
        /*
            r10 = this;
            M.C0335p.f(r11)
            r10.k()
            r10.r()
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r10.y()     // Catch:{ SQLiteException -> 0x0070, all -> 0x006d }
            java.lang.String r3 = "apps"
            java.lang.String r0 = "remote_config"
            java.lang.String r4 = "config_last_modified_time"
            java.lang.String r5 = "e_tag"
            java.lang.String[] r4 = new java.lang.String[]{r0, r4, r5}     // Catch:{ SQLiteException -> 0x0070, all -> 0x006d }
            java.lang.String r5 = "app_id=?"
            java.lang.String[] r6 = new java.lang.String[]{r11}     // Catch:{ SQLiteException -> 0x0070, all -> 0x006d }
            r8 = 0
            r9 = 0
            r7 = 0
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ SQLiteException -> 0x0070, all -> 0x006d }
            boolean r0 = r2.moveToFirst()     // Catch:{ SQLiteException -> 0x005c }
            if (r0 != 0) goto L_0x0031
            r2.close()
            return r1
        L_0x0031:
            r0 = 0
            byte[] r0 = r2.getBlob(r0)     // Catch:{ SQLiteException -> 0x005c }
            r3 = 1
            java.lang.String r3 = r2.getString(r3)     // Catch:{ SQLiteException -> 0x005c }
            r4 = 2
            java.lang.String r4 = r2.getString(r4)     // Catch:{ SQLiteException -> 0x005c }
            boolean r5 = r2.moveToNext()     // Catch:{ SQLiteException -> 0x005c }
            if (r5 == 0) goto L_0x005e
            com.google.android.gms.measurement.internal.n2 r5 = r10.a()     // Catch:{ SQLiteException -> 0x005c }
            com.google.android.gms.measurement.internal.p2 r5 = r5.G()     // Catch:{ SQLiteException -> 0x005c }
            java.lang.String r6 = "Got multiple records for app config, expected one. appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.C0821n2.s(r11)     // Catch:{ SQLiteException -> 0x005c }
            r5.b(r6, r7)     // Catch:{ SQLiteException -> 0x005c }
            goto L_0x005e
        L_0x0058:
            r0 = move-exception
            r11 = r0
            r1 = r2
            goto L_0x0089
        L_0x005c:
            r0 = move-exception
            goto L_0x0072
        L_0x005e:
            if (r0 != 0) goto L_0x0064
            r2.close()
            return r1
        L_0x0064:
            com.google.android.gms.measurement.internal.l r5 = new com.google.android.gms.measurement.internal.l     // Catch:{ SQLiteException -> 0x005c }
            r5.<init>(r0, r3, r4)     // Catch:{ SQLiteException -> 0x005c }
            r2.close()
            return r5
        L_0x006d:
            r0 = move-exception
            r11 = r0
            goto L_0x0089
        L_0x0070:
            r0 = move-exception
            r2 = r1
        L_0x0072:
            com.google.android.gms.measurement.internal.n2 r3 = r10.a()     // Catch:{ all -> 0x0058 }
            com.google.android.gms.measurement.internal.p2 r3 = r3.G()     // Catch:{ all -> 0x0058 }
            java.lang.String r4 = "Error querying remote config. appId"
            java.lang.Object r11 = com.google.android.gms.measurement.internal.C0821n2.s(r11)     // Catch:{ all -> 0x0058 }
            r3.c(r4, r11, r0)     // Catch:{ all -> 0x0058 }
            if (r2 == 0) goto L_0x0088
            r2.close()
        L_0x0088:
            return r1
        L_0x0089:
            if (r1 == 0) goto L_0x008e
            r1.close()
        L_0x008e:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.C0797k.O0(java.lang.String):com.google.android.gms.measurement.internal.l");
    }

    /* access modifiers changed from: package-private */
    public final Map P0(String str, String str2) {
        r();
        k();
        C0335p.f(str);
        C0335p.f(str2);
        ArrayMap arrayMap = new ArrayMap();
        Cursor cursor = null;
        try {
            cursor = y().query("event_filters", new String[]{"audience_id", DataSchemeDataSource.SCHEME_DATA}, "app_id=? AND event_name=?", new String[]{str, str2}, (String) null, (String) null, (String) null);
            if (!cursor.moveToFirst()) {
                Map map = Collections.EMPTY_MAP;
                cursor.close();
                return map;
            }
            do {
                try {
                    J1 j12 = (J1) ((C0668s4) ((J1.a) Z5.G(J1.K(), cursor.getBlob(1))).m());
                    int i4 = cursor.getInt(0);
                    List list = (List) arrayMap.get(Integer.valueOf(i4));
                    if (list == null) {
                        list = new ArrayList();
                        arrayMap.put(Integer.valueOf(i4), list);
                    }
                    list.add(j12);
                } catch (IOException e5) {
                    a().G().c("Failed to merge filter. appId", C0821n2.s(str), e5);
                }
            } while (cursor.moveToNext());
            cursor.close();
            return arrayMap;
        } catch (SQLiteException e6) {
            a().G().c("Database error querying filters. appId", C0821n2.s(str), e6);
            Map map2 = Collections.EMPTY_MAP;
            if (cursor != null) {
                cursor.close();
            }
            return map2;
        } catch (Throwable th) {
            Throwable th2 = th;
            if (cursor != null) {
                cursor.close();
            }
            throw th2;
        }
    }

    public final List Q(String str, int i4, int i5) {
        boolean z4;
        boolean z5;
        long j4;
        long j5;
        int i6 = i5;
        k();
        r();
        int i7 = 1;
        if (i4 > 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        C0335p.a(z4);
        if (i6 > 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        C0335p.a(z5);
        C0335p.f(str);
        Cursor cursor = null;
        try {
            cursor = y().query("queue", new String[]{"rowid", DataSchemeDataSource.SCHEME_DATA, "retry_count"}, "app_id=?", new String[]{str}, (String) null, (String) null, "rowid", String.valueOf(i4));
            if (!cursor.moveToFirst()) {
                List list = Collections.EMPTY_LIST;
                cursor.close();
                return list;
            }
            ArrayList arrayList = new ArrayList();
            int i8 = 0;
            while (true) {
                long j6 = cursor.getLong(0);
                try {
                    byte[] j02 = l().j0(cursor.getBlob(i7));
                    if (!arrayList.isEmpty() && j02.length + i8 > i6) {
                        break;
                    }
                    try {
                        C0643p2.a aVar = (C0643p2.a) Z5.G(C0643p2.u2(), j02);
                        if (!arrayList.isEmpty()) {
                            C0643p2 p2Var = (C0643p2) ((Pair) arrayList.get(0)).first;
                            C0643p2 p2Var2 = (C0643p2) ((C0668s4) aVar.m());
                            if (!p2Var.Y().equals(p2Var2.Y()) || !p2Var.X().equals(p2Var2.X()) || p2Var.o0() != p2Var2.o0() || !p2Var.Z().equals(p2Var2.Z())) {
                                break;
                            }
                            Iterator it = p2Var.m0().iterator();
                            while (true) {
                                j4 = -1;
                                if (!it.hasNext()) {
                                    j5 = -1;
                                    break;
                                }
                                C0674t2 t2Var = (C0674t2) it.next();
                                if ("_npa".equals(t2Var.U())) {
                                    j5 = t2Var.P();
                                    break;
                                }
                            }
                            Iterator it2 = p2Var2.m0().iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    break;
                                }
                                C0674t2 t2Var2 = (C0674t2) it2.next();
                                if ("_npa".equals(t2Var2.U())) {
                                    j4 = t2Var2.P();
                                    break;
                                }
                            }
                            if (j5 != j4) {
                                break;
                            }
                        }
                        if (!cursor.isNull(2)) {
                            aVar.x0(cursor.getInt(2));
                        }
                        i8 += j02.length;
                        arrayList.add(Pair.create((C0643p2) ((C0668s4) aVar.m()), Long.valueOf(j6)));
                    } catch (IOException e5) {
                        a().G().c("Failed to merge queued bundle. appId", C0821n2.s(str), e5);
                    }
                    if (!cursor.moveToNext() || i8 > i6) {
                        break;
                    }
                    i7 = 1;
                } catch (IOException e6) {
                    a().G().c("Failed to unzip queued bundle. appId", C0821n2.s(str), e6);
                }
            }
            cursor.close();
            return arrayList;
        } catch (SQLiteException e7) {
            a().G().c("Error querying bundles. appId", C0821n2.s(str), e7);
            List list2 = Collections.EMPTY_LIST;
            if (cursor != null) {
                cursor.close();
            }
            return list2;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public final C0873v Q0(String str) {
        C0335p.l(str);
        k();
        r();
        return C0873v.d(P("select dma_consent_settings from consent_settings where app_id=? limit 1;", new String[]{str}, ""));
    }

    public final List R(String str, String str2, String str3) {
        C0335p.f(str);
        k();
        r();
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(str);
        StringBuilder sb = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            sb.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(str3 + "*");
            sb.append(" and name glob ?");
        }
        return S(sb.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    /* access modifiers changed from: package-private */
    public final Map R0(String str, String str2) {
        r();
        k();
        C0335p.f(str);
        C0335p.f(str2);
        ArrayMap arrayMap = new ArrayMap();
        Cursor cursor = null;
        try {
            cursor = y().query("property_filters", new String[]{"audience_id", DataSchemeDataSource.SCHEME_DATA}, "app_id=? AND property_name=?", new String[]{str, str2}, (String) null, (String) null, (String) null);
            if (!cursor.moveToFirst()) {
                Map map = Collections.EMPTY_MAP;
                cursor.close();
                return map;
            }
            do {
                try {
                    M1 m12 = (M1) ((C0668s4) ((M1.a) Z5.G(M1.I(), cursor.getBlob(1))).m());
                    int i4 = cursor.getInt(0);
                    List list = (List) arrayMap.get(Integer.valueOf(i4));
                    if (list == null) {
                        list = new ArrayList();
                        arrayMap.put(Integer.valueOf(i4), list);
                    }
                    list.add(m12);
                } catch (IOException e5) {
                    a().G().c("Failed to merge filter", C0821n2.s(str), e5);
                }
            } while (cursor.moveToNext());
            cursor.close();
            return arrayMap;
        } catch (SQLiteException e6) {
            a().G().c("Database error querying filters. appId", C0821n2.s(str), e6);
            Map map2 = Collections.EMPTY_MAP;
            if (cursor != null) {
                cursor.close();
            }
            return map2;
        } catch (Throwable th) {
            Throwable th2 = th;
            if (cursor != null) {
                cursor.close();
            }
            throw th2;
        }
    }

    public final List S(String str, String[] strArr) {
        k();
        r();
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = y().query("conditional_properties", new String[]{MBridgeConstans.APP_ID, TtmlNode.ATTR_TTS_ORIGIN, RewardPlus.NAME, "value", "active", "trigger_event_name", "trigger_timeout", "timed_out_event", "creation_timestamp", "triggered_event", "triggered_timestamp", "time_to_live", "expired_event"}, str, strArr, (String) null, (String) null, "rowid", "1001");
            if (!cursor.moveToFirst()) {
                cursor.close();
                return arrayList;
            }
            while (true) {
                if (arrayList.size() < 1000) {
                    boolean z4 = false;
                    String string = cursor.getString(0);
                    String string2 = cursor.getString(1);
                    String string3 = cursor.getString(2);
                    Object M4 = M(cursor, 3);
                    if (cursor.getInt(4) != 0) {
                        z4 = true;
                    }
                    String string4 = cursor.getString(5);
                    long j4 = cursor.getLong(6);
                    Z5 l4 = l();
                    byte[] blob = cursor.getBlob(7);
                    Parcelable.Creator<E> creator = E.CREATOR;
                    long j5 = cursor.getLong(8);
                    long j6 = cursor.getLong(10);
                    long j7 = cursor.getLong(11);
                    String str2 = string2;
                    Y5 y5 = new Y5(string3, j6, M4, str2);
                    String str3 = str2;
                    long j8 = j5;
                    arrayList.add(new C0755e(string, str3, y5, j8, z4, string4, (E) l4.D(blob, creator), j4, (E) l().D(cursor.getBlob(9), creator), j7, (E) l().D(cursor.getBlob(12), creator)));
                    if (!cursor.moveToNext()) {
                        break;
                    }
                } else {
                    a().G().b("Read more than the max allowed conditional properties, ignoring extra", 1000);
                    break;
                }
            }
            cursor.close();
            return arrayList;
        } catch (SQLiteException e5) {
            a().G().b("Error querying conditional user property value", e5);
            List list = Collections.EMPTY_LIST;
            if (cursor != null) {
                cursor.close();
            }
            return list;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public final A3 S0(String str) {
        C0335p.l(str);
        k();
        r();
        return A3.q(P("select storage_consent_at_bundling from consent_settings where app_id=? limit 1;", new String[]{str}, ""));
    }

    public final void T0(String str, String str2) {
        C0335p.f(str);
        C0335p.f(str2);
        k();
        r();
        try {
            y().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e5) {
            a().G().d("Error deleting user property. appId", C0821n2.s(str), d().g(str2), e5);
        }
    }

    public final void U(A a5) {
        Z("events", a5);
    }

    public final A3 U0(String str) {
        C0335p.l(str);
        k();
        r();
        A3 a32 = (A3) N("select consent_state, consent_source from consent_settings where app_id=? limit 1;", new String[]{str}, new C0811m());
        if (a32 == null) {
            return A3.f2299c;
        }
        return a32;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0043, code lost:
        if (r7.f2403b.U(r0).m(com.google.android.gms.measurement.internal.A3.a.ANALYTICS_STORAGE) != false) goto L_0x0045;
     */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0242  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0295  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x02d9  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0326 A[Catch:{ SQLiteException -> 0x0338 }] */
    /* JADX WARNING: Removed duplicated region for block: B:72:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void V(com.google.android.gms.measurement.internal.C0744c2 r8, boolean r9, boolean r10) {
        /*
            r7 = this;
            java.lang.String r10 = "apps"
            M.C0335p.l(r8)
            r7.k()
            r7.r()
            java.lang.String r0 = r8.l()
            M.C0335p.l(r0)
            android.content.ContentValues r1 = new android.content.ContentValues
            r1.<init>()
            java.lang.String r2 = "app_id"
            r1.put(r2, r0)
            boolean r2 = com.google.android.gms.internal.measurement.C0576h6.a()
            java.lang.String r3 = "app_instance_id"
            r4 = 0
            if (r2 == 0) goto L_0x0045
            com.google.android.gms.measurement.internal.g r2 = r7.b()
            com.google.android.gms.measurement.internal.b2 r5 = com.google.android.gms.measurement.internal.G.f2455Z0
            boolean r2 = r2.q(r5)
            if (r2 == 0) goto L_0x0045
            if (r9 == 0) goto L_0x0037
            r1.put(r3, r4)
            goto L_0x004c
        L_0x0037:
            com.google.android.gms.measurement.internal.H5 r9 = r7.f2403b
            com.google.android.gms.measurement.internal.A3 r9 = r9.U(r0)
            com.google.android.gms.measurement.internal.A3$a r2 = com.google.android.gms.measurement.internal.A3.a.ANALYTICS_STORAGE
            boolean r9 = r9.m(r2)
            if (r9 == 0) goto L_0x004c
        L_0x0045:
            java.lang.String r9 = r8.m()
            r1.put(r3, r9)
        L_0x004c:
            java.lang.String r9 = "gmp_app_id"
            java.lang.String r2 = r8.q()
            r1.put(r9, r2)
            boolean r9 = com.google.android.gms.internal.measurement.C0576h6.a()
            if (r9 == 0) goto L_0x0075
            com.google.android.gms.measurement.internal.g r9 = r7.b()
            com.google.android.gms.measurement.internal.b2 r2 = com.google.android.gms.measurement.internal.G.f2455Z0
            boolean r9 = r9.q(r2)
            if (r9 == 0) goto L_0x0075
            com.google.android.gms.measurement.internal.H5 r9 = r7.f2403b
            com.google.android.gms.measurement.internal.A3 r9 = r9.U(r0)
            com.google.android.gms.measurement.internal.A3$a r2 = com.google.android.gms.measurement.internal.A3.a.AD_STORAGE
            boolean r9 = r9.m(r2)
            if (r9 == 0) goto L_0x007e
        L_0x0075:
            java.lang.String r9 = "resettable_device_id_hash"
            java.lang.String r2 = r8.s()
            r1.put(r9, r2)
        L_0x007e:
            long r2 = r8.F0()
            java.lang.Long r9 = java.lang.Long.valueOf(r2)
            java.lang.String r2 = "last_bundle_index"
            r1.put(r2, r9)
            long r2 = r8.H0()
            java.lang.Long r9 = java.lang.Long.valueOf(r2)
            java.lang.String r2 = "last_bundle_start_timestamp"
            r1.put(r2, r9)
            long r2 = r8.D0()
            java.lang.Long r9 = java.lang.Long.valueOf(r2)
            java.lang.String r2 = "last_bundle_end_timestamp"
            r1.put(r2, r9)
            java.lang.String r9 = "app_version"
            java.lang.String r2 = r8.o()
            r1.put(r9, r2)
            java.lang.String r9 = "app_store"
            java.lang.String r2 = r8.n()
            r1.put(r9, r2)
            long r2 = r8.z0()
            java.lang.Long r9 = java.lang.Long.valueOf(r2)
            java.lang.String r2 = "gmp_version"
            r1.put(r2, r9)
            long r2 = r8.t0()
            java.lang.Long r9 = java.lang.Long.valueOf(r2)
            java.lang.String r2 = "dev_cert_hash"
            r1.put(r2, r9)
            boolean r9 = r8.A()
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r9)
            java.lang.String r2 = "measurement_enabled"
            r1.put(r2, r9)
            long r2 = r8.r0()
            java.lang.Long r9 = java.lang.Long.valueOf(r2)
            java.lang.String r2 = "day"
            r1.put(r2, r9)
            long r2 = r8.m0()
            java.lang.Long r9 = java.lang.Long.valueOf(r2)
            java.lang.String r2 = "daily_public_events_count"
            r1.put(r2, r9)
            long r2 = r8.j0()
            java.lang.Long r9 = java.lang.Long.valueOf(r2)
            java.lang.String r2 = "daily_events_count"
            r1.put(r2, r9)
            long r2 = r8.d0()
            java.lang.Long r9 = java.lang.Long.valueOf(r2)
            java.lang.String r2 = "daily_conversions_count"
            r1.put(r2, r9)
            long r2 = r8.a0()
            java.lang.Long r9 = java.lang.Long.valueOf(r2)
            java.lang.String r2 = "config_fetched_time"
            r1.put(r2, r9)
            long r2 = r8.x0()
            java.lang.Long r9 = java.lang.Long.valueOf(r2)
            java.lang.String r2 = "failed_config_fetch_time"
            r1.put(r2, r9)
            long r2 = r8.U()
            java.lang.Long r9 = java.lang.Long.valueOf(r2)
            java.lang.String r2 = "app_version_int"
            r1.put(r2, r9)
            java.lang.String r9 = "firebase_instance_id"
            java.lang.String r2 = r8.p()
            r1.put(r9, r2)
            long r2 = r8.g0()
            java.lang.Long r9 = java.lang.Long.valueOf(r2)
            java.lang.String r2 = "daily_error_events_count"
            r1.put(r2, r9)
            long r2 = r8.p0()
            java.lang.Long r9 = java.lang.Long.valueOf(r2)
            java.lang.String r2 = "daily_realtime_events_count"
            r1.put(r2, r9)
            java.lang.String r9 = "health_monitor_sample"
            java.lang.String r2 = r8.r()
            r1.put(r9, r2)
            long r2 = r8.Q()
            java.lang.Long r9 = java.lang.Long.valueOf(r2)
            java.lang.String r2 = "android_id"
            r1.put(r2, r9)
            boolean r9 = r8.z()
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r9)
            java.lang.String r2 = "adid_reporting_enabled"
            r1.put(r2, r9)
            java.lang.String r9 = "admob_app_id"
            java.lang.String r2 = r8.j()
            r1.put(r9, r2)
            long r2 = r8.v0()
            java.lang.Long r9 = java.lang.Long.valueOf(r2)
            java.lang.String r2 = "dynamite_version"
            r1.put(r2, r9)
            boolean r9 = com.google.android.gms.internal.measurement.C0576h6.a()
            if (r9 == 0) goto L_0x01b5
            com.google.android.gms.measurement.internal.g r9 = r7.b()
            com.google.android.gms.measurement.internal.b2 r2 = com.google.android.gms.measurement.internal.G.f2455Z0
            boolean r9 = r9.q(r2)
            if (r9 == 0) goto L_0x01b5
            com.google.android.gms.measurement.internal.H5 r9 = r7.f2403b
            com.google.android.gms.measurement.internal.A3 r9 = r9.U(r0)
            com.google.android.gms.measurement.internal.A3$a r2 = com.google.android.gms.measurement.internal.A3.a.ANALYTICS_STORAGE
            boolean r9 = r9.m(r2)
            if (r9 == 0) goto L_0x01be
        L_0x01b5:
            java.lang.String r9 = "session_stitching_token"
            java.lang.String r2 = r8.u()
            r1.put(r9, r2)
        L_0x01be:
            boolean r9 = r8.C()
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r9)
            java.lang.String r2 = "sgtm_upload_enabled"
            r1.put(r2, r9)
            long r2 = r8.J0()
            java.lang.Long r9 = java.lang.Long.valueOf(r2)
            java.lang.String r2 = "target_os_version"
            r1.put(r2, r9)
            long r2 = r8.I0()
            java.lang.Long r9 = java.lang.Long.valueOf(r2)
            java.lang.String r2 = "session_stitching_token_hash"
            r1.put(r2, r9)
            boolean r9 = com.google.android.gms.internal.measurement.C0604k7.a()
            if (r9 == 0) goto L_0x0211
            com.google.android.gms.measurement.internal.g r9 = r7.b()
            com.google.android.gms.measurement.internal.b2 r2 = com.google.android.gms.measurement.internal.G.f2421I0
            boolean r9 = r9.F(r0, r2)
            if (r9 == 0) goto L_0x0211
            int r9 = r8.a()
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            java.lang.String r2 = "ad_services_version"
            r1.put(r2, r9)
            long r2 = r8.X()
            java.lang.Long r9 = java.lang.Long.valueOf(r2)
            java.lang.String r2 = "attribution_eligibility_status"
            r1.put(r2, r9)
        L_0x0211:
            boolean r9 = r8.D()
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r9)
            java.lang.String r2 = "unmatched_first_open_without_ad_id"
            r1.put(r2, r9)
            java.lang.String r9 = "npa_metadata_value"
            java.lang.Boolean r2 = r8.K0()
            r1.put(r9, r2)
            boolean r9 = com.google.android.gms.internal.measurement.r7.a()
            if (r9 == 0) goto L_0x024f
            com.google.android.gms.measurement.internal.g r9 = r7.b()
            com.google.android.gms.measurement.internal.b2 r2 = com.google.android.gms.measurement.internal.G.f2518y0
            boolean r9 = r9.F(r0, r2)
            if (r9 == 0) goto L_0x024f
            r7.g()
            boolean r9 = com.google.android.gms.measurement.internal.d6.H0(r0)
            if (r9 == 0) goto L_0x024f
            long r2 = r8.B0()
            java.lang.Long r9 = java.lang.Long.valueOf(r2)
            java.lang.String r2 = "bundle_delivery_index"
            r1.put(r2, r9)
        L_0x024f:
            boolean r9 = com.google.android.gms.internal.measurement.r7.a()
            if (r9 == 0) goto L_0x026a
            com.google.android.gms.measurement.internal.g r9 = r7.b()
            com.google.android.gms.measurement.internal.b2 r2 = com.google.android.gms.measurement.internal.G.f2520z0
            boolean r9 = r9.F(r0, r2)
            if (r9 == 0) goto L_0x026a
            java.lang.String r9 = "sgtm_preview_key"
            java.lang.String r2 = r8.v()
            r1.put(r9, r2)
        L_0x026a:
            int r9 = r8.L()
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            java.lang.String r2 = "dma_consent_state"
            r1.put(r2, r9)
            int r9 = r8.F()
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            java.lang.String r2 = "daily_realtime_dcu_count"
            r1.put(r2, r9)
            java.lang.String r9 = "serialized_npa_metadata"
            java.lang.String r2 = r8.t()
            r1.put(r9, r2)
            java.util.List r9 = r8.w()
            java.lang.String r2 = "safelisted_events"
            if (r9 == 0) goto L_0x02b2
            boolean r3 = r9.isEmpty()
            if (r3 == 0) goto L_0x02a9
            com.google.android.gms.measurement.internal.n2 r9 = r7.a()
            com.google.android.gms.measurement.internal.p2 r9 = r9.L()
            java.lang.String r3 = "Safelisted events should not be an empty list. appId"
            r9.b(r3, r0)
            goto L_0x02b2
        L_0x02a9:
            java.lang.String r3 = ","
            java.lang.String r9 = android.text.TextUtils.join(r3, r9)
            r1.put(r2, r9)
        L_0x02b2:
            boolean r9 = com.google.android.gms.internal.measurement.C0678t6.a()
            if (r9 == 0) goto L_0x02cd
            com.google.android.gms.measurement.internal.g r9 = r7.b()
            com.google.android.gms.measurement.internal.b2 r3 = com.google.android.gms.measurement.internal.G.f2512v0
            boolean r9 = r9.q(r3)
            if (r9 == 0) goto L_0x02cd
            boolean r9 = r1.containsKey(r2)
            if (r9 != 0) goto L_0x02cd
            r1.put(r2, r4)
        L_0x02cd:
            com.google.android.gms.measurement.internal.g r9 = r7.b()
            com.google.android.gms.measurement.internal.b2 r2 = com.google.android.gms.measurement.internal.G.f2451X0
            boolean r9 = r9.q(r2)
            if (r9 == 0) goto L_0x02eb
            java.lang.String r9 = "unmatched_pfo"
            java.lang.Long r2 = r8.L0()
            r1.put(r9, r2)
            java.lang.String r9 = "unmatched_uwa"
            java.lang.Long r2 = r8.M0()
            r1.put(r9, r2)
        L_0x02eb:
            boolean r9 = com.google.android.gms.internal.measurement.R6.a()
            if (r9 == 0) goto L_0x0306
            com.google.android.gms.measurement.internal.g r9 = r7.b()
            com.google.android.gms.measurement.internal.b2 r2 = com.google.android.gms.measurement.internal.G.f2447V0
            boolean r9 = r9.F(r0, r2)
            if (r9 == 0) goto L_0x0306
            java.lang.String r9 = "ad_campaign_info"
            byte[] r8 = r8.E()
            r1.put(r9, r8)
        L_0x0306:
            android.database.sqlite.SQLiteDatabase r8 = r7.y()     // Catch:{ SQLiteException -> 0x0338 }
            java.lang.String r9 = "app_id = ?"
            java.lang.String[] r2 = new java.lang.String[]{r0}     // Catch:{ SQLiteException -> 0x0338 }
            int r9 = r8.update(r10, r1, r9, r2)     // Catch:{ SQLiteException -> 0x0338 }
            long r2 = (long) r9     // Catch:{ SQLiteException -> 0x0338 }
            r5 = 0
            int r9 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r9 != 0) goto L_0x033a
            r9 = 5
            long r8 = r8.insertWithOnConflict(r10, r4, r1, r9)     // Catch:{ SQLiteException -> 0x0338 }
            r1 = -1
            int r10 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r10 != 0) goto L_0x033a
            com.google.android.gms.measurement.internal.n2 r8 = r7.a()     // Catch:{ SQLiteException -> 0x0338 }
            com.google.android.gms.measurement.internal.p2 r8 = r8.G()     // Catch:{ SQLiteException -> 0x0338 }
            java.lang.String r9 = "Failed to insert/update app (got -1). appId"
            java.lang.Object r10 = com.google.android.gms.measurement.internal.C0821n2.s(r0)     // Catch:{ SQLiteException -> 0x0338 }
            r8.b(r9, r10)     // Catch:{ SQLiteException -> 0x0338 }
            return
        L_0x0338:
            r8 = move-exception
            goto L_0x033b
        L_0x033a:
            return
        L_0x033b:
            com.google.android.gms.measurement.internal.n2 r9 = r7.a()
            com.google.android.gms.measurement.internal.p2 r9 = r9.G()
            java.lang.String r10 = "Error storing app. appId"
            java.lang.Object r0 = com.google.android.gms.measurement.internal.C0821n2.s(r0)
            r9.c(r10, r0, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.C0797k.V(com.google.android.gms.measurement.internal.c2, boolean, boolean):void");
    }

    /* access modifiers changed from: package-private */
    public final void W(Long l4) {
        k();
        r();
        C0335p.l(l4);
        if ((!r7.a() || b().q(G.f2409C0)) && o0()) {
            if (C0("SELECT COUNT(1) FROM upload_queue WHERE rowid = " + l4 + " AND retry_count =  2147483647 LIMIT 1", (String[]) null) > 0) {
                a().L().a("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                SQLiteDatabase y4 = y();
                y4.execSQL("UPDATE upload_queue SET retry_count = retry_count + 1 WHERE rowid = " + l4 + " AND retry_count < 2147483647");
            } catch (SQLiteException e5) {
                a().G().b("Error incrementing retry count. error", e5);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x00f5 A[Catch:{ IOException -> 0x00a6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x017b  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0181  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.V5 W0(java.lang.String r15) {
        /*
            r14 = this;
            M.C0335p.f(r15)
            r14.k()
            r14.r()
            boolean r0 = com.google.android.gms.internal.measurement.r7.a()
            r1 = 0
            if (r0 == 0) goto L_0x001d
            com.google.android.gms.measurement.internal.g r0 = r14.b()
            com.google.android.gms.measurement.internal.b2 r2 = com.google.android.gms.measurement.internal.G.f2409C0
            boolean r0 = r0.q(r2)
            if (r0 != 0) goto L_0x001d
            return r1
        L_0x001d:
            android.database.sqlite.SQLiteDatabase r2 = r14.y()     // Catch:{ SQLiteException -> 0x016a, all -> 0x0167 }
            java.lang.String r3 = "upload_queue"
            java.lang.String r4 = "rowId"
            java.lang.String r5 = "app_id"
            java.lang.String r6 = "measurement_batch"
            java.lang.String r7 = "upload_uri"
            java.lang.String r8 = "upload_headers"
            java.lang.String r9 = "upload_type"
            java.lang.String r10 = "retry_count"
            java.lang.String[] r4 = new java.lang.String[]{r4, r5, r6, r7, r8, r9, r10}     // Catch:{ SQLiteException -> 0x016a, all -> 0x0167 }
            java.lang.String r0 = r14.z0()     // Catch:{ SQLiteException -> 0x016a, all -> 0x0167 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x016a, all -> 0x0167 }
            java.lang.String r6 = "app_id=? AND NOT "
            r5.<init>(r6)     // Catch:{ SQLiteException -> 0x016a, all -> 0x0167 }
            r5.append(r0)     // Catch:{ SQLiteException -> 0x016a, all -> 0x0167 }
            java.lang.String r5 = r5.toString()     // Catch:{ SQLiteException -> 0x016a, all -> 0x0167 }
            java.lang.String[] r6 = new java.lang.String[]{r15}     // Catch:{ SQLiteException -> 0x016a, all -> 0x0167 }
            java.lang.String r9 = "creation_timestamp ASC"
            java.lang.String r10 = "1"
            r7 = 0
            r8 = 0
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ SQLiteException -> 0x016a, all -> 0x0167 }
            boolean r0 = r2.moveToFirst()     // Catch:{ SQLiteException -> 0x0080 }
            if (r0 != 0) goto L_0x005f
            r2.close()
            return r1
        L_0x005f:
            r0 = 3
            java.lang.String r0 = r2.getString(r0)     // Catch:{ SQLiteException -> 0x0080 }
            boolean r3 = android.text.TextUtils.isEmpty(r0)     // Catch:{ SQLiteException -> 0x0080 }
            if (r3 == 0) goto L_0x0083
            com.google.android.gms.measurement.internal.n2 r0 = r14.a()     // Catch:{ SQLiteException -> 0x0080 }
            com.google.android.gms.measurement.internal.p2 r0 = r0.F()     // Catch:{ SQLiteException -> 0x0080 }
            java.lang.String r3 = "Upload uri is null or empty. Destination is unknown. Dropping batch. "
            r0.a(r3)     // Catch:{ SQLiteException -> 0x0080 }
            r2.close()
            return r1
        L_0x007b:
            r0 = move-exception
            r15 = r0
            r1 = r2
            goto L_0x017f
        L_0x0080:
            r0 = move-exception
            goto L_0x016c
        L_0x0083:
            com.google.android.gms.internal.measurement.o2$a r3 = com.google.android.gms.internal.measurement.C0635o2.L()     // Catch:{ IOException -> 0x00a6 }
            r4 = 2
            byte[] r5 = r2.getBlob(r4)     // Catch:{ IOException -> 0x00a6 }
            com.google.android.gms.internal.measurement.Y4 r3 = com.google.android.gms.measurement.internal.Z5.G(r3, r5)     // Catch:{ IOException -> 0x00a6 }
            com.google.android.gms.internal.measurement.o2$a r3 = (com.google.android.gms.internal.measurement.C0635o2.a) r3     // Catch:{ IOException -> 0x00a6 }
            f0.C[] r5 = f0.C.values()     // Catch:{ IOException -> 0x00a6 }
            r6 = 5
            int r6 = r2.getInt(r6)     // Catch:{ IOException -> 0x00a6 }
            r5 = r5[r6]     // Catch:{ IOException -> 0x00a6 }
            f0.C r6 = f0.C.SGTM     // Catch:{ IOException -> 0x00a6 }
            if (r5 == r6) goto L_0x00a9
            f0.C r6 = f0.C.GOOGLE_ANALYTICS     // Catch:{ IOException -> 0x00a6 }
            if (r5 != r6) goto L_0x00e8
            goto L_0x00a9
        L_0x00a6:
            r0 = move-exception
            goto L_0x0156
        L_0x00a9:
            r6 = 6
            int r7 = r2.getInt(r6)     // Catch:{ IOException -> 0x00a6 }
            if (r7 <= 0) goto L_0x00e8
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ IOException -> 0x00a6 }
            r7.<init>()     // Catch:{ IOException -> 0x00a6 }
            java.util.List r8 = r3.B()     // Catch:{ IOException -> 0x00a6 }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ IOException -> 0x00a6 }
        L_0x00bd:
            boolean r9 = r8.hasNext()     // Catch:{ IOException -> 0x00a6 }
            if (r9 == 0) goto L_0x00e2
            java.lang.Object r9 = r8.next()     // Catch:{ IOException -> 0x00a6 }
            com.google.android.gms.internal.measurement.p2 r9 = (com.google.android.gms.internal.measurement.C0643p2) r9     // Catch:{ IOException -> 0x00a6 }
            com.google.android.gms.internal.measurement.s4$b r9 = r9.y()     // Catch:{ IOException -> 0x00a6 }
            com.google.android.gms.internal.measurement.p2$a r9 = (com.google.android.gms.internal.measurement.C0643p2.a) r9     // Catch:{ IOException -> 0x00a6 }
            int r10 = r2.getInt(r6)     // Catch:{ IOException -> 0x00a6 }
            r9.x0(r10)     // Catch:{ IOException -> 0x00a6 }
            com.google.android.gms.internal.measurement.Z4 r9 = r9.m()     // Catch:{ IOException -> 0x00a6 }
            com.google.android.gms.internal.measurement.s4 r9 = (com.google.android.gms.internal.measurement.C0668s4) r9     // Catch:{ IOException -> 0x00a6 }
            com.google.android.gms.internal.measurement.p2 r9 = (com.google.android.gms.internal.measurement.C0643p2) r9     // Catch:{ IOException -> 0x00a6 }
            r7.add(r9)     // Catch:{ IOException -> 0x00a6 }
            goto L_0x00bd
        L_0x00e2:
            r3.y()     // Catch:{ IOException -> 0x00a6 }
            r3.s(r7)     // Catch:{ IOException -> 0x00a6 }
        L_0x00e8:
            java.util.HashMap r6 = new java.util.HashMap     // Catch:{ IOException -> 0x00a6 }
            r6.<init>()     // Catch:{ IOException -> 0x00a6 }
            r7 = 4
            java.lang.String r7 = r2.getString(r7)     // Catch:{ IOException -> 0x00a6 }
            r8 = 0
            if (r7 == 0) goto L_0x0129
            java.lang.String r9 = "\r\n"
            java.lang.String[] r7 = r7.split(r9)     // Catch:{ IOException -> 0x00a6 }
            int r9 = r7.length     // Catch:{ IOException -> 0x00a6 }
            r10 = 0
        L_0x00fd:
            if (r10 >= r9) goto L_0x0129
            r11 = r7[r10]     // Catch:{ IOException -> 0x00a6 }
            boolean r12 = r11.isEmpty()     // Catch:{ IOException -> 0x00a6 }
            if (r12 != 0) goto L_0x0129
            java.lang.String r12 = "="
            java.lang.String[] r12 = r11.split(r12, r4)     // Catch:{ IOException -> 0x00a6 }
            int r13 = r12.length     // Catch:{ IOException -> 0x00a6 }
            if (r13 == r4) goto L_0x011e
            com.google.android.gms.measurement.internal.n2 r4 = r14.a()     // Catch:{ IOException -> 0x00a6 }
            com.google.android.gms.measurement.internal.p2 r4 = r4.G()     // Catch:{ IOException -> 0x00a6 }
            java.lang.String r7 = "Invalid upload header: "
            r4.b(r7, r11)     // Catch:{ IOException -> 0x00a6 }
            goto L_0x0129
        L_0x011e:
            r11 = r12[r8]     // Catch:{ IOException -> 0x00a6 }
            r13 = 1
            r12 = r12[r13]     // Catch:{ IOException -> 0x00a6 }
            r6.put(r11, r12)     // Catch:{ IOException -> 0x00a6 }
            int r10 = r10 + 1
            goto L_0x00fd
        L_0x0129:
            com.google.android.gms.measurement.internal.X5 r4 = new com.google.android.gms.measurement.internal.X5     // Catch:{ IOException -> 0x00a6 }
            r4.<init>()     // Catch:{ IOException -> 0x00a6 }
            long r7 = r2.getLong(r8)     // Catch:{ IOException -> 0x00a6 }
            com.google.android.gms.measurement.internal.X5 r4 = r4.b(r7)     // Catch:{ IOException -> 0x00a6 }
            com.google.android.gms.internal.measurement.Z4 r3 = r3.m()     // Catch:{ IOException -> 0x00a6 }
            com.google.android.gms.internal.measurement.s4 r3 = (com.google.android.gms.internal.measurement.C0668s4) r3     // Catch:{ IOException -> 0x00a6 }
            com.google.android.gms.internal.measurement.o2 r3 = (com.google.android.gms.internal.measurement.C0635o2) r3     // Catch:{ IOException -> 0x00a6 }
            com.google.android.gms.measurement.internal.X5 r3 = r4.c(r3)     // Catch:{ IOException -> 0x00a6 }
            com.google.android.gms.measurement.internal.X5 r0 = r3.e(r0)     // Catch:{ IOException -> 0x00a6 }
            com.google.android.gms.measurement.internal.X5 r0 = r0.f(r6)     // Catch:{ IOException -> 0x00a6 }
            com.google.android.gms.measurement.internal.X5 r0 = r0.d(r5)     // Catch:{ IOException -> 0x00a6 }
            com.google.android.gms.measurement.internal.V5 r15 = r0.a()     // Catch:{ IOException -> 0x00a6 }
            r2.close()
            return r15
        L_0x0156:
            com.google.android.gms.measurement.internal.n2 r3 = r14.a()     // Catch:{ SQLiteException -> 0x0080 }
            com.google.android.gms.measurement.internal.p2 r3 = r3.G()     // Catch:{ SQLiteException -> 0x0080 }
            java.lang.String r4 = "Failed to queued MeasurementBatch from upload_queue. appId"
            r3.c(r4, r15, r0)     // Catch:{ SQLiteException -> 0x0080 }
            r2.close()
            return r1
        L_0x0167:
            r0 = move-exception
            r15 = r0
            goto L_0x017f
        L_0x016a:
            r0 = move-exception
            r2 = r1
        L_0x016c:
            com.google.android.gms.measurement.internal.n2 r3 = r14.a()     // Catch:{ all -> 0x007b }
            com.google.android.gms.measurement.internal.p2 r3 = r3.G()     // Catch:{ all -> 0x007b }
            java.lang.String r4 = "Error to querying MeasurementBatch from upload_queue. appId"
            r3.c(r4, r15, r0)     // Catch:{ all -> 0x007b }
            if (r2 == 0) goto L_0x017e
            r2.close()
        L_0x017e:
            return r1
        L_0x017f:
            if (r1 == 0) goto L_0x0184
            r1.close()
        L_0x0184:
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.C0797k.W0(java.lang.String):com.google.android.gms.measurement.internal.V5");
    }

    public final void X(String str, Bundle bundle) {
        C0797k kVar = this;
        C0335p.l(bundle);
        kVar.k();
        kVar.r();
        String str2 = str;
        C0832p pVar = new C0832p(kVar, str2);
        List<C0818n> a5 = pVar.a();
        while (!a5.isEmpty()) {
            for (C0818n nVar : a5) {
                Z5 l4 = kVar.l();
                C0599k2 k2Var = nVar.f3133d;
                Bundle bundle2 = new Bundle();
                for (C0617m2 m2Var : k2Var.V()) {
                    if (m2Var.Z()) {
                        bundle2.putDouble(m2Var.W(), m2Var.G());
                    } else if (m2Var.a0()) {
                        bundle2.putFloat(m2Var.W(), m2Var.N());
                    } else if (m2Var.b0()) {
                        bundle2.putLong(m2Var.W(), m2Var.S());
                    } else if (m2Var.d0()) {
                        bundle2.putString(m2Var.W(), m2Var.X());
                    } else if (!m2Var.Y().isEmpty()) {
                        bundle2.putParcelableArray(m2Var.W(), Z5.i0(m2Var.Y()));
                    } else {
                        l4.a().G().b("Unexpected parameter type for parameter", m2Var);
                    }
                }
                String string = bundle2.getString("_o");
                bundle2.remove("_o");
                String U4 = k2Var.U();
                if (string == null) {
                    string = "";
                }
                C0848r2 r2Var = new C0848r2(U4, string, bundle2, k2Var.R());
                kVar.g().N(r2Var.f3204d, bundle);
                kVar.e0(nVar.f3130a, new B(kVar.f3273a, r2Var.f3202b, str2, nVar.f3133d.U(), nVar.f3133d.R(), nVar.f3133d.Q(), r2Var.f3204d), nVar.f3131b, nVar.f3132c);
                kVar = this;
                str2 = str;
            }
            a5 = pVar.a();
            kVar = this;
            str2 = str;
        }
    }

    public final List X0(String str) {
        C0335p.f(str);
        k();
        r();
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = y().query("trigger_uris", new String[]{"trigger_uri", "timestamp_millis", "source"}, "app_id=?", new String[]{str}, (String) null, (String) null, "rowid", (String) null);
            if (!cursor.moveToFirst()) {
                cursor.close();
                return arrayList;
            }
            do {
                String string = cursor.getString(0);
                if (string == null) {
                    string = "";
                }
                arrayList.add(new B5(string, cursor.getLong(1), cursor.getInt(2)));
            } while (cursor.moveToNext());
            cursor.close();
            return arrayList;
        } catch (SQLiteException e5) {
            a().G().c("Error querying trigger uris. appId", C0821n2.s(str), e5);
            List list = Collections.EMPTY_LIST;
            if (cursor != null) {
                cursor.close();
            }
            return list;
        } catch (Throwable th) {
            Throwable th2 = th;
            if (cursor != null) {
                cursor.close();
            }
            throw th2;
        }
    }

    public final void Y(String str, C0873v vVar) {
        A3 a32;
        C0335p.l(str);
        C0335p.l(vVar);
        k();
        r();
        if (b().q(G.f2441S0) && U0(str) == (a32 = A3.f2299c)) {
            E0(str, a32);
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(MBridgeConstans.APP_ID, str);
        contentValues.put("dma_consent_settings", vVar.j());
        b0("consent_settings", MBridgeConstans.APP_ID, contentValues);
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x009b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List Y0(java.lang.String r12) {
        /*
            r11 = this;
            M.C0335p.f(r12)
            r11.k()
            r11.r()
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r11.y()     // Catch:{ SQLiteException -> 0x004e }
            java.lang.String r3 = "user_attributes"
            java.lang.String r4 = "name"
            java.lang.String r5 = "origin"
            java.lang.String r6 = "set_timestamp"
            java.lang.String r7 = "value"
            java.lang.String[] r4 = new java.lang.String[]{r4, r5, r6, r7}     // Catch:{ SQLiteException -> 0x004e }
            java.lang.String r5 = "app_id=?"
            java.lang.String[] r6 = new java.lang.String[]{r12}     // Catch:{ SQLiteException -> 0x004e }
            java.lang.String r9 = "rowid"
            java.lang.String r10 = "1000"
            r7 = 0
            r8 = 0
            android.database.Cursor r1 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ SQLiteException -> 0x004e }
            boolean r2 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x004e }
            if (r2 != 0) goto L_0x003b
            r1.close()
            return r0
        L_0x003b:
            r2 = 0
            java.lang.String r6 = r1.getString(r2)     // Catch:{ SQLiteException -> 0x004e }
            r2 = 1
            java.lang.String r2 = r1.getString(r2)     // Catch:{ SQLiteException -> 0x004e }
            if (r2 != 0) goto L_0x0049
            java.lang.String r2 = ""
        L_0x0049:
            r5 = r2
            goto L_0x0051
        L_0x004b:
            r0 = move-exception
            r12 = r0
            goto L_0x009f
        L_0x004e:
            r0 = move-exception
            r4 = r12
            goto L_0x0086
        L_0x0051:
            r2 = 2
            long r7 = r1.getLong(r2)     // Catch:{ SQLiteException -> 0x004e }
            r2 = 3
            java.lang.Object r9 = r11.M(r1, r2)     // Catch:{ SQLiteException -> 0x004e }
            if (r9 != 0) goto L_0x0070
            com.google.android.gms.measurement.internal.n2 r2 = r11.a()     // Catch:{ SQLiteException -> 0x004e }
            com.google.android.gms.measurement.internal.p2 r2 = r2.G()     // Catch:{ SQLiteException -> 0x004e }
            java.lang.String r3 = "Read invalid user property value, ignoring it. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.C0821n2.s(r12)     // Catch:{ SQLiteException -> 0x004e }
            r2.b(r3, r4)     // Catch:{ SQLiteException -> 0x004e }
            r4 = r12
            goto L_0x0079
        L_0x0070:
            com.google.android.gms.measurement.internal.a6 r3 = new com.google.android.gms.measurement.internal.a6     // Catch:{ SQLiteException -> 0x004e }
            r4 = r12
            r3.<init>(r4, r5, r6, r7, r9)     // Catch:{ SQLiteException -> 0x0085 }
            r0.add(r3)     // Catch:{ SQLiteException -> 0x0085 }
        L_0x0079:
            boolean r12 = r1.moveToNext()     // Catch:{ SQLiteException -> 0x0085 }
            if (r12 != 0) goto L_0x0083
            r1.close()
            return r0
        L_0x0083:
            r12 = r4
            goto L_0x003b
        L_0x0085:
            r0 = move-exception
        L_0x0086:
            com.google.android.gms.measurement.internal.n2 r12 = r11.a()     // Catch:{ all -> 0x004b }
            com.google.android.gms.measurement.internal.p2 r12 = r12.G()     // Catch:{ all -> 0x004b }
            java.lang.String r2 = "Error querying user properties. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.C0821n2.s(r4)     // Catch:{ all -> 0x004b }
            r12.c(r2, r3, r0)     // Catch:{ all -> 0x004b }
            java.util.List r12 = java.util.Collections.EMPTY_LIST     // Catch:{ all -> 0x004b }
            if (r1 == 0) goto L_0x009e
            r1.close()
        L_0x009e:
            return r12
        L_0x009f:
            if (r1 == 0) goto L_0x00a4
            r1.close()
        L_0x00a4:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.C0797k.Y0(java.lang.String):java.util.List");
    }

    /* access modifiers changed from: package-private */
    public final Map Z0(String str) {
        r();
        k();
        C0335p.f(str);
        Cursor cursor = null;
        try {
            cursor = y().query("audience_filter_values", new String[]{"audience_id", "current_results"}, "app_id=?", new String[]{str}, (String) null, (String) null, (String) null);
            if (!cursor.moveToFirst()) {
                Map map = Collections.EMPTY_MAP;
                cursor.close();
                return map;
            }
            ArrayMap arrayMap = new ArrayMap();
            do {
                int i4 = cursor.getInt(0);
                try {
                    arrayMap.put(Integer.valueOf(i4), (C0658r2) ((C0668s4) ((C0658r2.a) Z5.G(C0658r2.R(), cursor.getBlob(1))).m()));
                } catch (IOException e5) {
                    a().G().d("Failed to merge filter results. appId, audienceId, error", C0821n2.s(str), Integer.valueOf(i4), e5);
                }
            } while (cursor.moveToNext());
            cursor.close();
            return arrayMap;
        } catch (SQLiteException e6) {
            a().G().c("Database error querying filter results. appId", C0821n2.s(str), e6);
            Map map2 = Collections.EMPTY_MAP;
            if (cursor != null) {
                cursor.close();
            }
            return map2;
        } catch (Throwable th) {
            Throwable th2 = th;
            if (cursor != null) {
                cursor.close();
            }
            throw th2;
        }
    }

    public final void a0(String str, A3 a32) {
        C0335p.l(str);
        C0335p.l(a32);
        k();
        r();
        E0(str, U0(str));
        ContentValues contentValues = new ContentValues();
        contentValues.put(MBridgeConstans.APP_ID, str);
        contentValues.put("storage_consent_at_bundling", a32.x());
        b0("consent_settings", MBridgeConstans.APP_ID, contentValues);
    }

    /* access modifiers changed from: package-private */
    public final Map a1(String str) {
        C0335p.f(str);
        ArrayMap arrayMap = new ArrayMap();
        Cursor cursor = null;
        try {
            cursor = y().query("event_filters", new String[]{"audience_id", DataSchemeDataSource.SCHEME_DATA}, "app_id=?", new String[]{str}, (String) null, (String) null, (String) null);
            if (!cursor.moveToFirst()) {
                Map map = Collections.EMPTY_MAP;
                cursor.close();
                return map;
            }
            do {
                try {
                    J1 j12 = (J1) ((C0668s4) ((J1.a) Z5.G(J1.K(), cursor.getBlob(1))).m());
                    if (j12.S()) {
                        int i4 = cursor.getInt(0);
                        List list = (List) arrayMap.get(Integer.valueOf(i4));
                        if (list == null) {
                            list = new ArrayList();
                            arrayMap.put(Integer.valueOf(i4), list);
                        }
                        list.add(j12);
                    }
                } catch (IOException e5) {
                    a().G().c("Failed to merge filter. appId", C0821n2.s(str), e5);
                }
            } while (cursor.moveToNext());
            cursor.close();
            return arrayMap;
        } catch (SQLiteException e6) {
            a().G().c("Database error querying filters. appId", C0821n2.s(str), e6);
            Map map2 = Collections.EMPTY_MAP;
            if (cursor != null) {
                cursor.close();
            }
            return map2;
        } catch (Throwable th) {
            Throwable th2 = th;
            if (cursor != null) {
                cursor.close();
            }
            throw th2;
        }
    }

    /* access modifiers changed from: package-private */
    public final Map b1(String str) {
        r();
        k();
        C0335p.f(str);
        ArrayMap arrayMap = new ArrayMap();
        Cursor cursor = null;
        try {
            cursor = y().rawQuery("select audience_id, filter_id from event_filters where app_id = ? and session_scoped = 1 UNION select audience_id, filter_id from property_filters where app_id = ? and session_scoped = 1;", new String[]{str, str});
            if (!cursor.moveToFirst()) {
                Map map = Collections.EMPTY_MAP;
                cursor.close();
                return map;
            }
            do {
                int i4 = cursor.getInt(0);
                List list = (List) arrayMap.get(Integer.valueOf(i4));
                if (list == null) {
                    list = new ArrayList();
                    arrayMap.put(Integer.valueOf(i4), list);
                }
                list.add(Integer.valueOf(cursor.getInt(1)));
            } while (cursor.moveToNext());
            cursor.close();
            return arrayMap;
        } catch (SQLiteException e5) {
            a().G().c("Database error querying scoped filters. appId", C0821n2.s(str), e5);
            Map map2 = Collections.EMPTY_MAP;
            if (cursor != null) {
                cursor.close();
            }
            return map2;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public final void c0(String str, List list) {
        Integer num;
        boolean z4;
        boolean z5;
        String str2 = str;
        List<I1> list2 = list;
        C0335p.l(list2);
        for (int i4 = 0; i4 < list2.size(); i4++) {
            I1.a aVar = (I1.a) ((I1) list2.get(i4)).y();
            if (aVar.q() != 0) {
                for (int i5 = 0; i5 < aVar.q(); i5++) {
                    J1.a aVar2 = (J1.a) aVar.t(i5).y();
                    J1.a aVar3 = (J1.a) ((C0668s4.b) aVar2.clone());
                    String b5 = q.b(aVar2.x());
                    if (b5 != null) {
                        aVar3.s(b5);
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    for (int i6 = 0; i6 < aVar2.q(); i6++) {
                        K1 t4 = aVar2.t(i6);
                        String a5 = s.a(t4.L());
                        if (a5 != null) {
                            aVar3.r(i6, (K1) ((C0668s4) ((K1.a) t4.y()).q(a5).m()));
                            z5 = true;
                        }
                    }
                    if (z5) {
                        I1.a r4 = aVar.r(i5, aVar3);
                        list2.set(i4, (I1) ((C0668s4) r4.m()));
                        aVar = r4;
                    }
                }
            }
            if (aVar.x() != 0) {
                for (int i7 = 0; i7 < aVar.x(); i7++) {
                    M1 y4 = aVar.y(i7);
                    String a6 = r.a(y4.K());
                    if (a6 != null) {
                        aVar = aVar.s(i7, ((M1.a) y4.y()).q(a6));
                        list2.set(i4, (I1) ((C0668s4) aVar.m()));
                    }
                }
            }
        }
        r();
        k();
        C0335p.f(str2);
        C0335p.l(list2);
        SQLiteDatabase y5 = y();
        y5.beginTransaction();
        try {
            r();
            k();
            C0335p.f(str2);
            SQLiteDatabase y6 = y();
            y6.delete("property_filters", "app_id=?", new String[]{str2});
            y6.delete("event_filters", "app_id=?", new String[]{str2});
            for (I1 i12 : list2) {
                r();
                k();
                C0335p.f(str2);
                C0335p.l(i12);
                if (!i12.P()) {
                    a().L().b("Audience with no ID. appId", C0821n2.s(str2));
                } else {
                    int j4 = i12.j();
                    Iterator it = i12.N().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (!((J1) it.next()).T()) {
                                a().L().c("Event filter with no ID. Audience definition ignored. appId, audienceId", C0821n2.s(str2), Integer.valueOf(j4));
                                break;
                            }
                        } else {
                            Iterator it2 = i12.O().iterator();
                            while (true) {
                                if (it2.hasNext()) {
                                    if (!((M1) it2.next()).O()) {
                                        a().L().c("Property filter with no ID. Audience definition ignored. appId, audienceId", C0821n2.s(str2), Integer.valueOf(j4));
                                        break;
                                    }
                                } else {
                                    Iterator it3 = i12.N().iterator();
                                    while (true) {
                                        if (it3.hasNext()) {
                                            if (!j0(str2, j4, (J1) it3.next())) {
                                                z4 = false;
                                                break;
                                            }
                                        } else {
                                            z4 = true;
                                            break;
                                        }
                                    }
                                    if (z4) {
                                        Iterator it4 = i12.O().iterator();
                                        while (true) {
                                            if (it4.hasNext()) {
                                                if (!k0(str2, j4, (M1) it4.next())) {
                                                    z4 = false;
                                                    break;
                                                }
                                            } else {
                                                break;
                                            }
                                        }
                                    }
                                    if (!z4) {
                                        r();
                                        k();
                                        C0335p.f(str2);
                                        SQLiteDatabase y7 = y();
                                        y7.delete("property_filters", "app_id=? and audience_id=?", new String[]{str2, String.valueOf(j4)});
                                        y7.delete("event_filters", "app_id=? and audience_id=?", new String[]{str2, String.valueOf(j4)});
                                    }
                                }
                            }
                        }
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            for (I1 i13 : list2) {
                if (i13.P()) {
                    num = Integer.valueOf(i13.j());
                } else {
                    num = null;
                }
                arrayList.add(num);
            }
            G0(str2, arrayList);
            y5.setTransactionSuccessful();
            y5.endTransaction();
        } catch (Throwable th) {
            y5.endTransaction();
            throw th;
        }
    }

    public final void c1() {
        r();
        y().beginTransaction();
    }

    /* access modifiers changed from: package-private */
    public final void d0(List list) {
        k();
        r();
        C0335p.l(list);
        C0335p.n(list.size());
        if (o0()) {
            String str = "(" + TextUtils.join(",", list) + ")";
            if (C0("SELECT COUNT(1) FROM queue WHERE rowid IN " + str + " AND retry_count =  2147483647 LIMIT 1", (String[]) null) > 0) {
                a().L().a("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                y().execSQL("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN " + str + " AND (retry_count IS NULL OR retry_count < 2147483647)");
            } catch (SQLiteException e5) {
                a().G().b("Error incrementing retry count. error", e5);
            }
        }
    }

    public final void d1(String str) {
        k();
        r();
        try {
            y().execSQL("delete from default_event_params where app_id=?", new String[]{str});
        } catch (SQLiteException e5) {
            a().G().b("Error clearing default event params", e5);
        }
    }

    public final void e1(String str) {
        A L02;
        V0("events_snapshot", str);
        Cursor cursor = null;
        try {
            cursor = y().query("events", (String[]) Collections.singletonList(RewardPlus.NAME).toArray(new String[0]), "app_id=?", new String[]{str}, (String) null, (String) null, (String) null);
            if (!cursor.moveToFirst()) {
                cursor.close();
                return;
            }
            do {
                String string = cursor.getString(0);
                if (!(string == null || (L02 = L0(str, string)) == null)) {
                    Z("events_snapshot", L02);
                }
            } while (cursor.moveToNext());
            cursor.close();
        } catch (SQLiteException e5) {
            a().G().c("Error creating snapshot. appId", C0821n2.s(str), e5);
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            Throwable th2 = th;
            if (cursor != null) {
                cursor.close();
            }
            throw th2;
        }
    }

    public final boolean f0(C0643p2 p2Var, boolean z4) {
        k();
        r();
        C0335p.l(p2Var);
        C0335p.f(p2Var.x2());
        C0335p.o(p2Var.L0());
        j1();
        long currentTimeMillis = B().currentTimeMillis();
        if (p2Var.c2() < currentTimeMillis - C0769g.P() || p2Var.c2() > C0769g.P() + currentTimeMillis) {
            a().L().d("Storing bundle outside of the max uploading time span. appId, now, timestamp", C0821n2.s(p2Var.x2()), Long.valueOf(currentTimeMillis), Long.valueOf(p2Var.c2()));
        }
        try {
            byte[] h02 = l().h0(p2Var.i());
            a().K().b("Saving bundle, size", Integer.valueOf(h02.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put(MBridgeConstans.APP_ID, p2Var.x2());
            contentValues.put("bundle_end_timestamp", Long.valueOf(p2Var.c2()));
            contentValues.put(DataSchemeDataSource.SCHEME_DATA, h02);
            contentValues.put("has_realtime", Integer.valueOf(z4 ? 1 : 0));
            if (p2Var.S0()) {
                contentValues.put("retry_count", Integer.valueOf(p2Var.B1()));
            }
            try {
                if (y().insert("queue", (String) null, contentValues) != -1) {
                    return true;
                }
                a().G().b("Failed to insert bundle (got -1). appId", C0821n2.s(p2Var.x2()));
                return false;
            } catch (SQLiteException e5) {
                a().G().c("Error storing bundle. appId", C0821n2.s(p2Var.x2()), e5);
                return false;
            }
        } catch (IOException e6) {
            a().G().c("Data loss. Failed to serialize bundle. appId", C0821n2.s(p2Var.x2()), e6);
            return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x009f, code lost:
        if ("_v".equals(r0) != false) goto L_0x00a1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00ff A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void f1(java.lang.String r20) {
        /*
            r19 = this;
            r1 = r19
            r2 = r20
            java.lang.String r3 = "events_snapshot"
            java.util.ArrayList r0 = new java.util.ArrayList
            java.lang.String r4 = "name"
            java.lang.String r5 = "lifetime_count"
            java.lang.String[] r4 = new java.lang.String[]{r4, r5}
            java.util.List r4 = java.util.Arrays.asList(r4)
            r0.<init>(r4)
            java.lang.String r4 = "_f"
            com.google.android.gms.measurement.internal.A r5 = r1.L0(r2, r4)
            java.lang.String r6 = "_v"
            com.google.android.gms.measurement.internal.A r7 = r1.L0(r2, r6)
            java.lang.String r8 = "events"
            r1.V0(r8, r2)
            r9 = 0
            r10 = 0
            android.database.sqlite.SQLiteDatabase r11 = r1.y()     // Catch:{ SQLiteException -> 0x00cc, all -> 0x00c9 }
            java.lang.String r12 = "events_snapshot"
            java.lang.String[] r13 = new java.lang.String[r9]     // Catch:{ SQLiteException -> 0x00cc, all -> 0x00c9 }
            java.lang.Object[] r0 = r0.toArray(r13)     // Catch:{ SQLiteException -> 0x00cc, all -> 0x00c9 }
            r13 = r0
            java.lang.String[] r13 = (java.lang.String[]) r13     // Catch:{ SQLiteException -> 0x00cc, all -> 0x00c9 }
            java.lang.String r14 = "app_id=?"
            java.lang.String[] r15 = new java.lang.String[]{r2}     // Catch:{ SQLiteException -> 0x00cc, all -> 0x00c9 }
            r17 = 0
            r18 = 0
            r16 = 0
            android.database.Cursor r10 = r11.query(r12, r13, r14, r15, r16, r17, r18)     // Catch:{ SQLiteException -> 0x00cc, all -> 0x00c9 }
            boolean r0 = r10.moveToFirst()     // Catch:{ SQLiteException -> 0x00cc, all -> 0x00c9 }
            if (r0 != 0) goto L_0x0061
            r10.close()
            if (r5 == 0) goto L_0x0058
            r1.Z(r8, r5)
            goto L_0x005d
        L_0x0058:
            if (r7 == 0) goto L_0x005d
            r1.Z(r8, r7)
        L_0x005d:
            r1.V0(r3, r2)
            return
        L_0x0061:
            r11 = 0
            r12 = 0
        L_0x0063:
            java.lang.String r0 = r10.getString(r9)     // Catch:{ SQLiteException -> 0x0091, all -> 0x008d }
            com.google.android.gms.measurement.internal.g r13 = r1.b()     // Catch:{ SQLiteException -> 0x0091, all -> 0x008d }
            com.google.android.gms.measurement.internal.b2 r14 = com.google.android.gms.measurement.internal.G.f2461b1     // Catch:{ SQLiteException -> 0x0091, all -> 0x008d }
            boolean r13 = r13.q(r14)     // Catch:{ SQLiteException -> 0x0091, all -> 0x008d }
            r14 = 1
            if (r13 == 0) goto L_0x0094
            long r15 = r10.getLong(r14)     // Catch:{ SQLiteException -> 0x0091, all -> 0x008d }
            r17 = 1
            int r13 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r13 < 0) goto L_0x00a2
            boolean r13 = r4.equals(r0)     // Catch:{ SQLiteException -> 0x0091, all -> 0x008d }
            if (r13 == 0) goto L_0x0086
        L_0x0084:
            r11 = 1
            goto L_0x00a2
        L_0x0086:
            boolean r13 = r6.equals(r0)     // Catch:{ SQLiteException -> 0x0091, all -> 0x008d }
            if (r13 == 0) goto L_0x00a2
            goto L_0x00a1
        L_0x008d:
            r0 = move-exception
            r9 = r11
            goto L_0x00f8
        L_0x0091:
            r0 = move-exception
            r9 = r11
            goto L_0x00ce
        L_0x0094:
            boolean r13 = r4.equals(r0)     // Catch:{ SQLiteException -> 0x0091, all -> 0x008d }
            if (r13 == 0) goto L_0x009b
            goto L_0x0084
        L_0x009b:
            boolean r13 = r6.equals(r0)     // Catch:{ SQLiteException -> 0x0091, all -> 0x008d }
            if (r13 == 0) goto L_0x00a2
        L_0x00a1:
            r12 = 1
        L_0x00a2:
            if (r0 == 0) goto L_0x00ad
            com.google.android.gms.measurement.internal.A r0 = r1.J0(r3, r2, r0)     // Catch:{ SQLiteException -> 0x0091, all -> 0x008d }
            if (r0 == 0) goto L_0x00ad
            r1.Z(r8, r0)     // Catch:{ SQLiteException -> 0x0091, all -> 0x008d }
        L_0x00ad:
            boolean r0 = r10.moveToNext()     // Catch:{ SQLiteException -> 0x0091, all -> 0x008d }
            if (r0 != 0) goto L_0x0063
            r10.close()
            if (r11 != 0) goto L_0x00be
            if (r5 == 0) goto L_0x00be
            r1.Z(r8, r5)
            goto L_0x00c5
        L_0x00be:
            if (r12 != 0) goto L_0x00c5
            if (r7 == 0) goto L_0x00c5
            r1.Z(r8, r7)
        L_0x00c5:
            r1.V0(r3, r2)
            return
        L_0x00c9:
            r0 = move-exception
            r12 = 0
            goto L_0x00f8
        L_0x00cc:
            r0 = move-exception
            r12 = 0
        L_0x00ce:
            com.google.android.gms.measurement.internal.n2 r4 = r1.a()     // Catch:{ all -> 0x00f7 }
            com.google.android.gms.measurement.internal.p2 r4 = r4.G()     // Catch:{ all -> 0x00f7 }
            java.lang.String r6 = "Error querying snapshot. appId"
            java.lang.Object r11 = com.google.android.gms.measurement.internal.C0821n2.s(r2)     // Catch:{ all -> 0x00f7 }
            r4.c(r6, r11, r0)     // Catch:{ all -> 0x00f7 }
            if (r10 == 0) goto L_0x00e4
            r10.close()
        L_0x00e4:
            if (r9 != 0) goto L_0x00ec
            if (r5 == 0) goto L_0x00ec
            r1.Z(r8, r5)
            goto L_0x00f3
        L_0x00ec:
            if (r12 != 0) goto L_0x00f3
            if (r7 == 0) goto L_0x00f3
            r1.Z(r8, r7)
        L_0x00f3:
            r1.V0(r3, r2)
            return
        L_0x00f7:
            r0 = move-exception
        L_0x00f8:
            if (r10 == 0) goto L_0x00fd
            r10.close()
        L_0x00fd:
            if (r9 != 0) goto L_0x0106
            if (r5 != 0) goto L_0x0102
            goto L_0x0106
        L_0x0102:
            r1.Z(r8, r5)
            goto L_0x010d
        L_0x0106:
            if (r12 != 0) goto L_0x010d
            if (r7 == 0) goto L_0x010d
            r1.Z(r8, r7)
        L_0x010d:
            r1.V0(r3, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.C0797k.f1(java.lang.String):void");
    }

    public final boolean g0(C0755e eVar) {
        C0335p.l(eVar);
        k();
        r();
        String str = eVar.f2953a;
        C0335p.l(str);
        if (N0(str, eVar.f2955c.f2824b) == null && C0("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{str}) >= 1000) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(MBridgeConstans.APP_ID, str);
        contentValues.put(TtmlNode.ATTR_TTS_ORIGIN, eVar.f2954b);
        contentValues.put(RewardPlus.NAME, eVar.f2955c.f2824b);
        T(contentValues, "value", C0335p.l(eVar.f2955c.c()));
        contentValues.put("active", Boolean.valueOf(eVar.f2957e));
        contentValues.put("trigger_event_name", eVar.f2958f);
        contentValues.put("trigger_timeout", Long.valueOf(eVar.f2960h));
        g();
        contentValues.put("timed_out_event", d6.q0(eVar.f2959g));
        contentValues.put("creation_timestamp", Long.valueOf(eVar.f2956d));
        g();
        contentValues.put("triggered_event", d6.q0(eVar.f2961i));
        contentValues.put("triggered_timestamp", Long.valueOf(eVar.f2955c.f2825c));
        contentValues.put("time_to_live", Long.valueOf(eVar.f2962j));
        g();
        contentValues.put("expired_event", d6.q0(eVar.f2963k));
        try {
            if (y().insertWithOnConflict("conditional_properties", (String) null, contentValues, 5) != -1) {
                return true;
            }
            a().G().b("Failed to insert/update conditional user property (got -1)", C0821n2.s(str));
            return true;
        } catch (SQLiteException e5) {
            a().G().c("Error storing conditional user property", C0821n2.s(str), e5);
            return true;
        }
    }

    public final boolean g1(String str) {
        if (r7.a() && !b().q(G.f2409C0)) {
            return false;
        }
        String z02 = z0();
        if (C0("SELECT COUNT(1) > 0 FROM upload_queue WHERE app_id=? AND NOT " + z02, new String[]{str}) != 0) {
            return true;
        }
        return false;
    }

    public final boolean h0(B b5, long j4, boolean z4) {
        k();
        r();
        C0335p.l(b5);
        C0335p.f(b5.f2316a);
        byte[] i4 = l().E(b5).i();
        ContentValues contentValues = new ContentValues();
        contentValues.put(MBridgeConstans.APP_ID, b5.f2316a);
        contentValues.put(RewardPlus.NAME, b5.f2317b);
        contentValues.put(CampaignEx.JSON_KEY_TIMESTAMP, Long.valueOf(b5.f2319d));
        contentValues.put("metadata_fingerprint", Long.valueOf(j4));
        contentValues.put(DataSchemeDataSource.SCHEME_DATA, i4);
        contentValues.put("realtime", Integer.valueOf(z4 ? 1 : 0));
        try {
            if (y().insert("raw_events", (String) null, contentValues) != -1) {
                return true;
            }
            a().G().b("Failed to insert raw event (got -1). appId", C0821n2.s(b5.f2316a));
            return false;
        } catch (SQLiteException e5) {
            a().G().c("Error storing raw event. appId", C0821n2.s(b5.f2316a), e5);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x005d A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0063 A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean h1(java.lang.String r10) {
        /*
            r9 = this;
            r0 = 1
            r1 = 0
            r2 = 0
            android.database.sqlite.SQLiteDatabase r3 = r9.y()     // Catch:{ SQLiteException -> 0x004c }
            java.lang.String r4 = "select timestamp from raw_events where app_id=? and name = '_f' limit 1;"
            java.lang.String[] r5 = new java.lang.String[]{r10}     // Catch:{ SQLiteException -> 0x004c }
            android.database.Cursor r2 = r3.rawQuery(r4, r5)     // Catch:{ SQLiteException -> 0x004c }
            boolean r3 = r2.moveToFirst()     // Catch:{ SQLiteException -> 0x004c }
            if (r3 != 0) goto L_0x001b
            r2.close()
            return r1
        L_0x001b:
            long r3 = r2.getLong(r1)     // Catch:{ SQLiteException -> 0x004c }
            R.d r5 = r9.B()     // Catch:{ SQLiteException -> 0x004c }
            long r5 = r5.currentTimeMillis()     // Catch:{ SQLiteException -> 0x004c }
            r7 = 15000(0x3a98, double:7.411E-320)
            long r3 = r3 + r7
            int r7 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r7 >= 0) goto L_0x0030
            r3 = 1
            goto L_0x0031
        L_0x0030:
            r3 = 0
        L_0x0031:
            java.lang.String r4 = "select count(*) from raw_events where app_id=? and name not like '!_%' escape '!' limit 1;"
            java.lang.String[] r10 = new java.lang.String[]{r10}     // Catch:{ SQLiteException -> 0x004a }
            r5 = 0
            long r7 = r9.G(r4, r10, r5)     // Catch:{ SQLiteException -> 0x004a }
            int r10 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r10 <= 0) goto L_0x0043
            r10 = 1
            goto L_0x0044
        L_0x0043:
            r10 = 0
        L_0x0044:
            r2.close()
            goto L_0x0061
        L_0x0048:
            r10 = move-exception
            goto L_0x0067
        L_0x004a:
            r10 = move-exception
            goto L_0x004e
        L_0x004c:
            r10 = move-exception
            r3 = 0
        L_0x004e:
            com.google.android.gms.measurement.internal.n2 r4 = r9.a()     // Catch:{ all -> 0x0048 }
            com.google.android.gms.measurement.internal.p2 r4 = r4.G()     // Catch:{ all -> 0x0048 }
            java.lang.String r5 = "Error checking backfill conditions"
            r4.b(r5, r10)     // Catch:{ all -> 0x0048 }
            if (r2 == 0) goto L_0x0060
            r2.close()
        L_0x0060:
            r10 = 0
        L_0x0061:
            if (r3 == 0) goto L_0x0066
            if (r10 != 0) goto L_0x0066
            return r0
        L_0x0066:
            return r1
        L_0x0067:
            if (r2 == 0) goto L_0x006c
            r2.close()
        L_0x006c:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.C0797k.h1(java.lang.String):boolean");
    }

    public final boolean i0(a6 a6Var) {
        C0335p.l(a6Var);
        k();
        r();
        if (N0(a6Var.f2854a, a6Var.f2856c) == null) {
            if (d6.K0(a6Var.f2856c)) {
                if (C0("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{a6Var.f2854a}) >= ((long) b().n(a6Var.f2854a, G.f2422J, 25, 100))) {
                    return false;
                }
            } else if (!"_npa".equals(a6Var.f2856c) && C0("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{a6Var.f2854a, a6Var.f2855b}) >= 25) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(MBridgeConstans.APP_ID, a6Var.f2854a);
        contentValues.put(TtmlNode.ATTR_TTS_ORIGIN, a6Var.f2855b);
        contentValues.put(RewardPlus.NAME, a6Var.f2856c);
        contentValues.put("set_timestamp", Long.valueOf(a6Var.f2857d));
        T(contentValues, "value", a6Var.f2858e);
        try {
            if (y().insertWithOnConflict("user_attributes", (String) null, contentValues, 5) != -1) {
                return true;
            }
            a().G().b("Failed to insert/update user property (got -1). appId", C0821n2.s(a6Var.f2854a));
            return true;
        } catch (SQLiteException e5) {
            a().G().c("Error storing user property. appId", C0821n2.s(a6Var.f2854a), e5);
            return true;
        }
    }

    public final void i1() {
        r();
        y().endTransaction();
    }

    /* access modifiers changed from: package-private */
    public final void j1() {
        int delete;
        k();
        r();
        if (o0()) {
            long a5 = p().f3052e.a();
            long elapsedRealtime = B().elapsedRealtime();
            if (Math.abs(elapsedRealtime - a5) > C0769g.Q()) {
                p().f3052e.b(elapsedRealtime);
                k();
                r();
                if (o0() && (delete = y().delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(B().currentTimeMillis()), String.valueOf(C0769g.P())})) > 0) {
                    a().K().b("Deleted stale rows. rowsDeleted", Integer.valueOf(delete));
                }
            }
        }
    }

    public final void k1() {
        r();
        y().setTransactionSuccessful();
    }

    public final boolean l0(String str, C0635o2 o2Var, String str2, Map map, C c5) {
        int delete;
        k();
        r();
        C0335p.l(o2Var);
        C0335p.f(str);
        if (r7.a() && !b().q(G.f2409C0)) {
            return false;
        }
        k();
        r();
        if (o0()) {
            long a5 = p().f3053f.a();
            long elapsedRealtime = B().elapsedRealtime();
            if (Math.abs(elapsedRealtime - a5) > C0769g.Q()) {
                p().f3053f.b(elapsedRealtime);
                k();
                r();
                if (o0() && (delete = y().delete("upload_queue", z0(), new String[0])) > 0) {
                    a().K().b("Deleted stale MeasurementBatch rows from upload_queue. rowsDeleted", Integer.valueOf(delete));
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : map.entrySet()) {
            arrayList.add(((String) entry.getKey()) + "=" + ((String) entry.getValue()));
        }
        byte[] i4 = o2Var.i();
        ContentValues contentValues = new ContentValues();
        contentValues.put(MBridgeConstans.APP_ID, str);
        contentValues.put("measurement_batch", i4);
        contentValues.put("upload_uri", str2);
        StringBuilder sb = new StringBuilder();
        int size = arrayList.size();
        if (size > 0) {
            sb.append((CharSequence) arrayList.get(0));
            int i5 = 1;
            while (i5 < size) {
                sb.append("\r\n");
                Object obj = arrayList.get(i5);
                i5++;
                sb.append((CharSequence) obj);
            }
        }
        contentValues.put("upload_headers", sb.toString());
        contentValues.put("upload_type", Integer.valueOf(c5.A()));
        contentValues.put("creation_timestamp", Long.valueOf(B().currentTimeMillis()));
        contentValues.put("retry_count", 0);
        try {
            if (y().insert("upload_queue", (String) null, contentValues) != -1) {
                return true;
            }
            a().G().b("Failed to insert MeasurementBatch (got -1) to upload_queue. appId", str);
            return false;
        } catch (SQLiteException e5) {
            a().G().c("Error storing MeasurementBatch to upload_queue. appId", str, e5);
            return false;
        }
    }

    public final boolean l1() {
        if (C0("select count(1) > 0 from raw_events", (String[]) null) != 0) {
            return true;
        }
        return false;
    }

    public final boolean m0(String str, B5 b5) {
        k();
        r();
        C0335p.l(b5);
        C0335p.f(str);
        long currentTimeMillis = B().currentTimeMillis();
        long j4 = b5.f2333b;
        C0737b2 b2Var = G.f2481i0;
        if (j4 < currentTimeMillis - ((Long) b2Var.a((Object) null)).longValue() || b5.f2333b > ((Long) b2Var.a((Object) null)).longValue() + currentTimeMillis) {
            a().L().d("Storing trigger URI outside of the max retention time span. appId, now, timestamp", C0821n2.s(str), Long.valueOf(currentTimeMillis), Long.valueOf(b5.f2333b));
        }
        a().K().a("Saving trigger URI");
        ContentValues contentValues = new ContentValues();
        contentValues.put(MBridgeConstans.APP_ID, str);
        contentValues.put("trigger_uri", b5.f2332a);
        contentValues.put("source", Integer.valueOf(b5.f2334c));
        contentValues.put("timestamp_millis", Long.valueOf(b5.f2333b));
        try {
            if (y().insert("trigger_uris", (String) null, contentValues) != -1) {
                return true;
            }
            a().G().b("Failed to insert trigger URI (got -1). appId", C0821n2.s(str));
            return false;
        } catch (SQLiteException e5) {
            a().G().c("Error storing trigger URI. appId", C0821n2.s(str), e5);
            return false;
        }
    }

    public final boolean m1() {
        if (C0("select count(1) > 0 from queue where has_realtime = 1", (String[]) null) != 0) {
            return true;
        }
        return false;
    }

    public final boolean n0(String str, Long l4, long j4, C0599k2 k2Var) {
        k();
        r();
        C0335p.l(k2Var);
        C0335p.f(str);
        C0335p.l(l4);
        byte[] i4 = k2Var.i();
        a().K().c("Saving complex main event, appId, data size", d().c(str), Integer.valueOf(i4.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put(MBridgeConstans.APP_ID, str);
        contentValues.put("event_id", l4);
        contentValues.put("children_to_process", Long.valueOf(j4));
        contentValues.put("main_event", i4);
        try {
            if (y().insertWithOnConflict("main_event_params", (String) null, contentValues, 5) != -1) {
                return true;
            }
            a().G().b("Failed to insert complex main event (got -1). appId", C0821n2.s(str));
            return false;
        } catch (SQLiteException e5) {
            a().G().c("Error storing complex main event. appId", C0821n2.s(str), e5);
            return false;
        }
    }

    public final boolean n1() {
        if (C0("select count(1) > 0 from raw_events where realtime = 1", (String[]) null) != 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public final boolean o0() {
        return A().getDatabasePath("google_app_measurement.db").exists();
    }

    /* access modifiers changed from: protected */
    public final boolean u() {
        return false;
    }

    public final long v() {
        Cursor cursor = null;
        try {
            cursor = y().rawQuery("select rowid from raw_events order by rowid desc limit 1;", (String[]) null);
            if (!cursor.moveToFirst()) {
                cursor.close();
                return -1;
            }
            long j4 = cursor.getLong(0);
            cursor.close();
            return j4;
        } catch (SQLiteException e5) {
            a().G().b("Error querying raw events", e5);
            if (cursor != null) {
                cursor.close();
            }
            return -1;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public final long w() {
        return G("select max(bundle_end_timestamp) from queue", (String[]) null, 0);
    }

    public final long x() {
        return G("select max(timestamp) from raw_events", (String[]) null, 0);
    }

    /* access modifiers changed from: package-private */
    public final SQLiteDatabase y() {
        k();
        try {
            return this.f3076d.getWritableDatabase();
        } catch (SQLiteException e5) {
            a().L().b("Error opening database", e5);
            throw e5;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x003e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String z() {
        /*
            r6 = this;
            android.database.sqlite.SQLiteDatabase r0 = r6.y()
            r1 = 0
            java.lang.String r2 = "select app_id from queue order by has_realtime desc, rowid asc limit 1;"
            android.database.Cursor r0 = r0.rawQuery(r2, r1)     // Catch:{ SQLiteException -> 0x0027, all -> 0x0022 }
            boolean r2 = r0.moveToFirst()     // Catch:{ SQLiteException -> 0x001c }
            if (r2 == 0) goto L_0x001e
            r2 = 0
            java.lang.String r1 = r0.getString(r2)     // Catch:{ SQLiteException -> 0x001c }
            r0.close()
            return r1
        L_0x001a:
            r1 = move-exception
            goto L_0x003c
        L_0x001c:
            r2 = move-exception
            goto L_0x0029
        L_0x001e:
            r0.close()
            return r1
        L_0x0022:
            r0 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
            goto L_0x003c
        L_0x0027:
            r2 = move-exception
            r0 = r1
        L_0x0029:
            com.google.android.gms.measurement.internal.n2 r3 = r6.a()     // Catch:{ all -> 0x001a }
            com.google.android.gms.measurement.internal.p2 r3 = r3.G()     // Catch:{ all -> 0x001a }
            java.lang.String r4 = "Database error getting next bundle app id"
            r3.b(r4, r2)     // Catch:{ all -> 0x001a }
            if (r0 == 0) goto L_0x003b
            r0.close()
        L_0x003b:
            return r1
        L_0x003c:
            if (r0 == 0) goto L_0x0041
            r0.close()
        L_0x0041:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.C0797k.z():java.lang.String");
    }
}
