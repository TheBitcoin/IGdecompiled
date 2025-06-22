package com.mbridge.msdk.c;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.mbridge.msdk.foundation.controller.a;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class c {

    /* renamed from: A  reason: collision with root package name */
    private String f11902A;

    /* renamed from: B  reason: collision with root package name */
    private int f11903B = 1;

    /* renamed from: C  reason: collision with root package name */
    private String f11904C = "";

    /* renamed from: D  reason: collision with root package name */
    private int f11905D;

    /* renamed from: E  reason: collision with root package name */
    private int f11906E;

    /* renamed from: F  reason: collision with root package name */
    private int f11907F = 100;

    /* renamed from: G  reason: collision with root package name */
    private int f11908G = 60;

    /* renamed from: H  reason: collision with root package name */
    private int f11909H = DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_AFTER_REBUFFER_MS;

    /* renamed from: I  reason: collision with root package name */
    private int f11910I;

    /* renamed from: J  reason: collision with root package name */
    private int f11911J = 1;

    /* renamed from: K  reason: collision with root package name */
    private String f11912K;

    /* renamed from: L  reason: collision with root package name */
    private String f11913L = "";

    /* renamed from: M  reason: collision with root package name */
    private String f11914M = "";

    /* renamed from: N  reason: collision with root package name */
    private int f11915N;

    /* renamed from: a  reason: collision with root package name */
    private String f11916a = "";

    /* renamed from: b  reason: collision with root package name */
    private List<Integer> f11917b;

    /* renamed from: c  reason: collision with root package name */
    private List<Integer> f11918c;

    /* renamed from: d  reason: collision with root package name */
    private int f11919d;

    /* renamed from: e  reason: collision with root package name */
    private int f11920e;

    /* renamed from: f  reason: collision with root package name */
    private int f11921f;

    /* renamed from: g  reason: collision with root package name */
    private int f11922g;

    /* renamed from: h  reason: collision with root package name */
    private int f11923h;

    /* renamed from: i  reason: collision with root package name */
    private int f11924i;

    /* renamed from: j  reason: collision with root package name */
    private int f11925j = 0;

    /* renamed from: k  reason: collision with root package name */
    private long f11926k;

    /* renamed from: l  reason: collision with root package name */
    private long f11927l;

    /* renamed from: m  reason: collision with root package name */
    private int f11928m;

    /* renamed from: n  reason: collision with root package name */
    private int f11929n;

    /* renamed from: o  reason: collision with root package name */
    private int f11930o;

    /* renamed from: p  reason: collision with root package name */
    private long f11931p;

    /* renamed from: q  reason: collision with root package name */
    private long f11932q;

    /* renamed from: r  reason: collision with root package name */
    private int f11933r;

    /* renamed from: s  reason: collision with root package name */
    private String f11934s;

    /* renamed from: t  reason: collision with root package name */
    private int f11935t;

    /* renamed from: u  reason: collision with root package name */
    private int f11936u;

    /* renamed from: v  reason: collision with root package name */
    private int f11937v = 30;

    /* renamed from: w  reason: collision with root package name */
    private int f11938w = 1;

    /* renamed from: x  reason: collision with root package name */
    private int f11939x = 10;

    /* renamed from: y  reason: collision with root package name */
    private int f11940y = 60;

    /* renamed from: z  reason: collision with root package name */
    private String f11941z;

    public static k a(JSONObject jSONObject) {
        k kVar;
        k kVar2 = null;
        if (jSONObject != null) {
            try {
                kVar = new k();
            } catch (Exception e5) {
                e = e5;
                e.printStackTrace();
                return kVar2;
            }
            try {
                kVar.f11912K = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
                String optString = jSONObject.optString("ab_id");
                kVar.f11916a = optString;
                a.f12767b.put(kVar.f11912K, optString);
                kVar.f11913L = jSONObject.optString("rid");
                JSONArray optJSONArray = jSONObject.optJSONArray("adSourceList");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                        arrayList.add(Integer.valueOf(optJSONArray.optInt(i4)));
                    }
                    kVar.f11917b = arrayList;
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("ad_source_timeout");
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i5 = 0; i5 < optJSONArray2.length(); i5++) {
                        arrayList2.add(Integer.valueOf(optJSONArray2.optInt(i5)));
                    }
                    kVar.f11918c = arrayList2;
                }
                kVar.f11910I = jSONObject.optInt("tpqn");
                kVar.f11921f = jSONObject.optInt("aqn");
                kVar.f11920e = jSONObject.optInt("acn");
                kVar.f11915N = jSONObject.optInt("wt");
                int i6 = 1;
                kVar.f11938w = jSONObject.optInt("iscasf", 1);
                kVar.f11909H = jSONObject.optInt("spmxrt", DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_AFTER_REBUFFER_MS);
                kVar.f11931p = jSONObject.optLong("current_time");
                kVar.f11903B = jSONObject.optInt(TypedValues.CycleType.S_WAVE_OFFSET);
                kVar.f11932q = jSONObject.optLong("dlct", 3600);
                kVar.f11922g = jSONObject.optInt("autoplay", 0);
                kVar.f11933r = jSONObject.optInt("dlnet", 2);
                kVar.f11902A = jSONObject.optString("no_offer");
                kVar.f11924i = jSONObject.optInt("cb_type");
                kVar.f11927l = jSONObject.optLong("clct", 86400);
                kVar.f11926k = jSONObject.optLong("clcq", 300);
                kVar.f11907F = jSONObject.optInt(CampaignEx.JSON_KEY_READY_RATE, 100);
                kVar.f11925j = jSONObject.optInt("cd_rate", 0);
                kVar.f11929n = jSONObject.optInt("content", 1);
                kVar.f11936u = jSONObject.optInt("impt", 0);
                kVar.f11935t = jSONObject.optInt("icon_type", 1);
                kVar.f11941z = jSONObject.optString("no_ads_url", "");
                kVar.f11906E = jSONObject.optInt("playclosebtn_tm", -1);
                kVar.f11905D = jSONObject.optInt("play_ctdown", 0);
                kVar.f11928m = jSONObject.optInt("close_alert", 0);
                kVar.f11937v = jSONObject.optInt("intershowlimit", 30);
                kVar.f11908G = jSONObject.optInt("refreshFq", 60);
                kVar.f11923h = jSONObject.optInt("closeBtn", 0);
                int optInt = jSONObject.optInt("tmorl", 1);
                if (optInt <= 2) {
                    if (optInt > 0) {
                        i6 = optInt;
                    }
                }
                kVar.f11911J = i6;
                kVar.f11904C = jSONObject.optString("placementid", "");
                kVar.f11939x = jSONObject.optInt("ltafemty", 10);
                kVar.f11940y = jSONObject.optInt("ltorwc", 60);
                kVar.f11914M = jSONObject.optString("vtag", "");
                return kVar;
            } catch (Exception e6) {
                e = e6;
                kVar2 = kVar;
                e.printStackTrace();
                return kVar2;
            }
        }
        return kVar2;
    }

    public final List<Integer> b() {
        return this.f11917b;
    }

    public final List<Integer> c() {
        return this.f11918c;
    }

    public final int d() {
        return this.f11920e;
    }

    public final int e() {
        return this.f11921f;
    }

    public final int f() {
        return this.f11923h;
    }

    public final int g() {
        return this.f11925j;
    }

    public final int h() {
        return this.f11929n;
    }

    public final long i() {
        return this.f11931p;
    }

    public final long j() {
        return this.f11932q;
    }

    public final int k() {
        return this.f11933r;
    }

    public final int l() {
        return this.f11936u;
    }

    public final int m() {
        return this.f11938w;
    }

    public final int n() {
        return this.f11939x;
    }

    public final int o() {
        return this.f11940y;
    }

    public final int p() {
        return this.f11907F;
    }

    public final int q() {
        return this.f11908G;
    }

    public final int r() {
        return this.f11909H;
    }

    public final String s() {
        return this.f11913L;
    }

    public final String t() {
        return this.f11914M;
    }

    public String toString() {
        List<Integer> list = this.f11917b;
        String str = "";
        if (list != null && list.size() > 0) {
            for (Integer num : this.f11917b) {
                str = str + num + ",";
            }
        }
        return "offset = " + this.f11903B + " unitId = " + this.f11912K + " fbPlacementId = " + this.f11934s + str;
    }

    public final int u() {
        return this.f11915N;
    }

    public final int v() {
        return this.f11922g;
    }

    public final int w() {
        return this.f11903B;
    }

    public final JSONObject x() {
        JSONObject jSONObject = new JSONObject();
        try {
            List<Integer> list = this.f11917b;
            if (list != null && list.size() > 0) {
                int size = list.size();
                JSONArray jSONArray = new JSONArray();
                for (int i4 = 0; i4 < size; i4++) {
                    jSONArray.put(list.get(i4));
                }
                jSONObject.put("adSourceList", jSONArray);
            }
            List<Integer> list2 = this.f11918c;
            if (list2 != null && list2.size() > 0) {
                int size2 = list2.size();
                JSONArray jSONArray2 = new JSONArray();
                for (int i5 = 0; i5 < size2; i5++) {
                    jSONArray2.put(list2.get(i5));
                }
                jSONObject.put("ad_source_timeout", jSONArray2);
            }
            jSONObject.put("tpqn", this.f11910I);
            jSONObject.put("aqn", this.f11921f);
            jSONObject.put("acn", this.f11920e);
            jSONObject.put("wt", this.f11915N);
            jSONObject.put("current_time", this.f11931p);
            jSONObject.put(TypedValues.CycleType.S_WAVE_OFFSET, this.f11903B);
            jSONObject.put("dlct", this.f11932q);
            jSONObject.put("autoplay", this.f11922g);
            jSONObject.put("dlnet", this.f11933r);
            jSONObject.put("no_offer", this.f11902A);
            jSONObject.put("cb_type", this.f11924i);
            jSONObject.put("clct", this.f11927l);
            jSONObject.put("clcq", this.f11926k);
            jSONObject.put(CampaignEx.JSON_KEY_READY_RATE, this.f11907F);
            jSONObject.put("content", this.f11929n);
            jSONObject.put("impt", this.f11936u);
            jSONObject.put("icon_type", this.f11935t);
            jSONObject.put("no_ads_url", this.f11941z);
            jSONObject.put("playclosebtn_tm", this.f11906E);
            jSONObject.put("play_ctdown", this.f11905D);
            jSONObject.put("close_alert", this.f11928m);
            jSONObject.put("closeBtn", this.f11923h);
            jSONObject.put("refreshFq", this.f11908G);
            jSONObject.put("countdown", this.f11930o);
            jSONObject.put("allowSkip", this.f11919d);
            jSONObject.put("tmorl", this.f11911J);
            jSONObject.put(CampaignEx.JSON_KEY_CAMPAIGN_UNITID, this.f11912K);
            jSONObject.put("placementid", this.f11904C);
            jSONObject.put("ltafemty", this.f11939x);
            jSONObject.put("ltorwc", this.f11940y);
            jSONObject.put("vtag", this.f11914M);
            return jSONObject;
        } catch (Exception e5) {
            e5.printStackTrace();
            return jSONObject;
        }
    }

    public final void b(List<Integer> list) {
        this.f11918c = list;
    }

    public final void c(int i4) {
        this.f11920e = i4;
    }

    public final void d(int i4) {
        this.f11921f = i4;
    }

    public final void e(int i4) {
        this.f11925j = i4;
    }

    public final void f(int i4) {
        this.f11929n = i4;
    }

    public final void g(int i4) {
        this.f11930o = i4;
    }

    public final void h(int i4) {
        this.f11933r = i4;
    }

    public final void i(int i4) {
        this.f11936u = i4;
    }

    public final void j(int i4) {
        this.f11939x = i4;
    }

    public final void k(int i4) {
        this.f11940y = i4;
    }

    public final void l(int i4) {
        this.f11907F = i4;
    }

    public final void m(int i4) {
        this.f11908G = i4;
    }

    public final void n(int i4) {
        this.f11910I = i4;
    }

    public final void o(int i4) {
        this.f11915N = i4;
    }

    public final void p(int i4) {
        this.f11903B = i4;
    }

    public final void b(int i4) {
        this.f11919d = i4;
    }

    public final void b(String str) {
        this.f11912K = str;
    }

    public final void a(int i4) {
        this.f11922g = i4;
    }

    public final String a() {
        return this.f11916a;
    }

    public final void a(List<Integer> list) {
        this.f11917b = list;
    }

    public final void a(long j4) {
        this.f11932q = j4;
    }

    public final void a(String str) {
        this.f11904C = str;
    }
}
