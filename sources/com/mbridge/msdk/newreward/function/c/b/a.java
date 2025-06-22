package com.mbridge.msdk.newreward.function.c.b;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import androidx.work.WorkRequest;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.newreward.a.c.a;
import com.mbridge.msdk.newreward.function.c.a.b;
import com.mbridge.msdk.newreward.function.common.MBridgeGlobalCommon;
import com.mbridge.msdk.newreward.function.common.VolleyErrorUtils;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.mbridge.msdk.tracker.network.ac;
import com.mbridge.msdk.tracker.network.ad;
import com.mbridge.msdk.tracker.network.e;
import com.mbridge.msdk.tracker.network.r;
import com.mbridge.msdk.tracker.network.t;
import com.mbridge.msdk.tracker.network.toolbox.f;
import com.mbridge.msdk.tracker.network.u;
import com.mbridge.msdk.tracker.network.w;
import com.mbridge.msdk.tracker.network.y;
import com.mbridge.msdk.tracker.network.z;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public class a extends u<JSONObject> implements w.a {

    /* renamed from: a  reason: collision with root package name */
    protected b f14529a;

    /* renamed from: b  reason: collision with root package name */
    protected Context f14530b = c.m().c();

    /* renamed from: c  reason: collision with root package name */
    protected int f14531c;

    /* renamed from: d  reason: collision with root package name */
    protected String f14532d;

    /* renamed from: e  reason: collision with root package name */
    protected String f14533e;

    /* renamed from: f  reason: collision with root package name */
    protected String f14534f;

    /* renamed from: g  reason: collision with root package name */
    private Map<String, String> f14535g;

    /* renamed from: h  reason: collision with root package name */
    private c f14536h;

    /* renamed from: i  reason: collision with root package name */
    private z f14537i;

    /* renamed from: j  reason: collision with root package name */
    private long f14538j;

    /* renamed from: k  reason: collision with root package name */
    private long f14539k;

    /* renamed from: l  reason: collision with root package name */
    private String f14540l;

    /* renamed from: m  reason: collision with root package name */
    private String f14541m;

    /* renamed from: n  reason: collision with root package name */
    private String f14542n;

    /* renamed from: o  reason: collision with root package name */
    private String f14543o;

    /* renamed from: p  reason: collision with root package name */
    private Map<String, String> f14544p;

    /* renamed from: q  reason: collision with root package name */
    private long f14545q;

    /* renamed from: com.mbridge.msdk.newreward.function.c.b.a$a  reason: collision with other inner class name */
    private static final class C0195a implements a.C0192a {

        /* renamed from: a  reason: collision with root package name */
        private final a f14546a;

        /* renamed from: b  reason: collision with root package name */
        private final b f14547b;

        public C0195a(a aVar, b bVar) {
            this.f14546a = aVar;
            this.f14547b = bVar;
        }

        public final void a(String str, long j4) {
            af.a("BaseCampaignRequest", "onTimeout taskID = " + str + ", timeout = " + j4);
            a.a(this.f14546a, this.f14547b, j4);
        }
    }

    public a(int i4, String str, String str2, String str3, long j4, String str4, String str5) {
        super(0, str4, 0, str5);
        this.f14531c = i4;
        this.f14532d = str;
        this.f14533e = str2;
        this.f14534f = str3;
        this.f14540l = UUID.randomUUID().toString();
        this.f14538j = SystemClock.elapsedRealtime();
        this.f14543o = str4;
        this.f14529a = new b(this.f14531c, this.f14532d, this.f14533e, this.f14534f);
        a((w.a) this);
        d(true);
        c(true);
        this.f14545q = j4 <= 0 ? WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS : j4;
        com.mbridge.msdk.newreward.a.c.a.a().a(this.f14540l, this.f14545q, new C0195a(this, this.f14529a));
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void a(Object obj) {
        c cVar;
        JSONObject jSONObject = (JSONObject) obj;
        if (MBridgeConstans.DEBUG) {
            af.a("BaseCampaignRequest", "deliverResponse: " + jSONObject);
        }
        com.mbridge.msdk.newreward.a.c.a.a().a(this.f14540l);
        int optInt = jSONObject.optInt(NotificationCompat.CATEGORY_STATUS);
        if (optInt == 1) {
            JSONObject optJSONObject = jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
            if (optJSONObject != null) {
                CampaignUnit parseCampaignUnit = com.mbridge.msdk.foundation.entity.b.parseCampaignUnit(optJSONObject, this.f14541m);
                this.f14529a.a(optJSONObject);
                this.f14529a.f(optJSONObject.optString("c"));
                this.f14529a.e(optJSONObject.optString(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B));
                this.f14529a.d(optJSONObject.optString("a"));
                this.f14529a.d(optJSONObject.optInt("template"));
                this.f14529a.a(System.currentTimeMillis());
                this.f14529a.c(this.f14541m);
                this.f14529a.g(optJSONObject.optString(com.mbridge.msdk.foundation.same.a.f13122T));
                this.f14529a.c(1);
                this.f14529a.e(0);
                this.f14529a.a(parseCampaignUnit.getRequestId());
                this.f14529a.a(parseCampaignUnit.getEcppv());
                this.f14529a.i(this.f14543o);
                this.f14529a.a(parseCampaignUnit.getSecondRequestIndex());
                this.f14529a.b(parseCampaignUnit.getSecondShowIndex());
                ArrayList arrayList = new ArrayList();
                MBridgeGlobalCommon.handlerCampaigns(this.f14542n, this.f14529a, parseCampaignUnit.getAds(), arrayList);
                b bVar = this.f14529a;
                if (!(bVar == null || (cVar = this.f14536h) == null)) {
                    try {
                        cVar.a(bVar, this);
                    } catch (Exception e5) {
                        if (MBridgeConstans.DEBUG) {
                            af.b("BaseCampaignRequest", "handlerOnSuccessEvent Exception: ", e5);
                        }
                    }
                }
            } else {
                a(this, this.f14529a, new b(7, "data is null"));
            }
        } else {
            b bVar2 = new b(9);
            bVar2.a(jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE, ""));
            bVar2.a(optInt);
            bVar2.c(jSONObject.toString());
            a(this, this.f14529a, bVar2);
        }
        this.f14539k = SystemClock.elapsedRealtime();
    }

    public final void b(String str) {
        c("local_id", str);
        c("ad_type", String.valueOf(this.f14531c));
        this.f14542n = str;
    }

    public final Map<String, String> c() {
        if (this.f14544p == null) {
            this.f14544p = new HashMap();
        }
        this.f14544p.put("Charset", C.UTF8_NAME);
        return this.f14544p;
    }

    public final boolean d() {
        return true;
    }

    public final z b() {
        if (this.f14537i == null) {
            this.f14537i = new e(10000, this.f14545q, 5);
        }
        return this.f14537i;
    }

    public final void b(String str, String str2) {
        if (this.f14544p == null) {
            this.f14544p = new HashMap();
        }
        this.f14544p.put(str, str2);
    }

    public final void a(c cVar) {
        this.f14536h = cVar;
    }

    public final void a(String str, String str2) {
        if (this.f14535g == null) {
            this.f14535g = new HashMap();
        }
        if (!TextUtils.isEmpty(str)) {
            Map<String, String> map = this.f14535g;
            if (str2 == null) {
                str2 = "";
            }
            map.put(str, str2);
        }
    }

    public final void a(String str) {
        this.f14541m = str;
    }

    public final void a(Map<String, String> map) {
        if (this.f14535g == null) {
            this.f14535g = new HashMap();
        }
        if (map != null && map.size() != 0) {
            this.f14535g.putAll(map);
        }
    }

    /* access modifiers changed from: protected */
    public final Map<String, String> a() {
        if (this.f14535g == null) {
            this.f14535g = new HashMap();
        }
        return this.f14535g;
    }

    /* access modifiers changed from: protected */
    public final w<JSONObject> a(r rVar) {
        if (rVar != null) {
            try {
                byte[] bArr = rVar.f15601b;
                if (bArr != null) {
                    if (bArr.length != 0) {
                        return w.a(new JSONObject(new String(bArr, StandardCharsets.UTF_8)), f.a(rVar));
                    }
                }
            } catch (JSONException e5) {
                if (MBridgeConstans.DEBUG) {
                    af.b("BaseCampaignRequest", "parseNetworkResponse JSONException: ", e5);
                }
                return w.a(new t(e5));
            } catch (Exception e6) {
                if (MBridgeConstans.DEBUG) {
                    af.b("BaseCampaignRequest", "parseNetworkResponse Exception: ", e6);
                }
                return w.a(new ac((Throwable) e6));
            }
        }
        return w.a(new y());
    }

    public final void a(ad adVar) {
        c cVar;
        com.mbridge.msdk.newreward.a.c.a.a().a(this.f14540l);
        if (MBridgeConstans.DEBUG) {
            af.b("BaseCampaignRequest", "onErrorResponse: " + adVar.getMessage());
        }
        b bVar = this.f14529a;
        if (bVar != null && (cVar = this.f14536h) != null) {
            try {
                cVar.b(bVar, this, VolleyErrorUtils.parseVolleyError(adVar));
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    af.b("BaseCampaignRequest", "onError Exception: ", e5);
                }
            }
        }
    }

    private static void a(a aVar, b bVar, b bVar2) {
        c cVar;
        if (aVar != null && bVar != null && (cVar = aVar.f14536h) != null) {
            try {
                cVar.a(bVar, aVar, bVar2);
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    af.b("BaseCampaignRequest", "handlerOnFailedEvent Exception: ", e5);
                }
            }
        }
    }

    static /* synthetic */ void a(a aVar, b bVar, long j4) {
        c cVar;
        if (aVar != null && bVar != null && (cVar = aVar.f14536h) != null) {
            try {
                b bVar2 = bVar;
                cVar.a(bVar2, aVar, j4, new b(10, "v3 is timeout"));
            } catch (Exception e5) {
                Exception exc = e5;
                if (MBridgeConstans.DEBUG) {
                    af.b("BaseCampaignRequest", "onTimeout Exception: ", exc);
                }
            }
        }
    }
}
