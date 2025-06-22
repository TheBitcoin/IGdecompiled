package com.google.android.gms.measurement.internal;

import M.C0335p;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import com.google.android.gms.internal.measurement.C0599k2;
import com.google.android.gms.internal.measurement.C0668s4;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.google.android.gms.measurement.internal.p  reason: case insensitive filesystem */
public final class C0832p {

    /* renamed from: a  reason: collision with root package name */
    private final String f3171a;

    /* renamed from: b  reason: collision with root package name */
    private long f3172b = -1;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ C0797k f3173c;

    public C0832p(C0797k kVar, String str) {
        this.f3173c = kVar;
        C0335p.f(str);
        this.f3171a = str;
    }

    public final List a() {
        boolean z4;
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = this.f3173c.y().query("raw_events", new String[]{"rowid", RewardPlus.NAME, CampaignEx.JSON_KEY_TIMESTAMP, "metadata_fingerprint", DataSchemeDataSource.SCHEME_DATA, "realtime"}, "app_id = ? and rowid > ?", new String[]{this.f3171a, String.valueOf(this.f3172b)}, (String) null, (String) null, "rowid", "1000");
            if (!cursor.moveToFirst()) {
                List list = Collections.EMPTY_LIST;
                cursor.close();
                return list;
            }
            do {
                long j4 = cursor.getLong(0);
                long j5 = cursor.getLong(3);
                if (cursor.getLong(5) == 1) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                byte[] blob = cursor.getBlob(4);
                if (j4 > this.f3172b) {
                    this.f3172b = j4;
                }
                try {
                    C0599k2.a aVar = (C0599k2.a) Z5.G(C0599k2.S(), blob);
                    String string = cursor.getString(1);
                    if (string == null) {
                        string = "";
                    }
                    aVar.B(string).D(cursor.getLong(2));
                    arrayList.add(new C0818n(j4, j5, z4, (C0599k2) ((C0668s4) aVar.m())));
                } catch (IOException e5) {
                    this.f3173c.a().G().c("Data loss. Failed to merge raw event. appId", C0821n2.s(this.f3171a), e5);
                }
            } while (cursor.moveToNext());
            cursor.close();
            return arrayList;
        } catch (SQLiteException e6) {
            this.f3173c.a().G().c("Data loss. Error querying raw events batch. appId", C0821n2.s(this.f3171a), e6);
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }
}
