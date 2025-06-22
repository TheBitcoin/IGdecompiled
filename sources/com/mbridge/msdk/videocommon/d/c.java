package com.mbridge.msdk.videocommon.d;

import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.mbridge.msdk.foundation.controller.a;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.foundation.tools.z;
import com.mbridge.msdk.newreward.function.common.MBridgeCommon;
import com.mbridge.msdk.videocommon.b.b;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c {

    /* renamed from: H  reason: collision with root package name */
    private static g f16987H;

    /* renamed from: a  reason: collision with root package name */
    public static String f16988a;

    /* renamed from: A  reason: collision with root package name */
    private int f16989A = 70;

    /* renamed from: B  reason: collision with root package name */
    private int f16990B = 0;

    /* renamed from: C  reason: collision with root package name */
    private int f16991C = -1;

    /* renamed from: D  reason: collision with root package name */
    private int f16992D = -1;

    /* renamed from: E  reason: collision with root package name */
    private int f16993E = -1;

    /* renamed from: F  reason: collision with root package name */
    private int f16994F;

    /* renamed from: G  reason: collision with root package name */
    private int f16995G = 20;

    /* renamed from: I  reason: collision with root package name */
    private int f16996I;

    /* renamed from: J  reason: collision with root package name */
    private int f16997J = 0;

    /* renamed from: K  reason: collision with root package name */
    private int f16998K = 1;

    /* renamed from: L  reason: collision with root package name */
    private String f16999L = "";

    /* renamed from: M  reason: collision with root package name */
    private int f17000M = 1;

    /* renamed from: N  reason: collision with root package name */
    private String f17001N = "";

    /* renamed from: O  reason: collision with root package name */
    private int f17002O = 1;

    /* renamed from: P  reason: collision with root package name */
    private String f17003P = "Virtual Item";

    /* renamed from: Q  reason: collision with root package name */
    private String f17004Q = "";

    /* renamed from: R  reason: collision with root package name */
    private String f17005R = "";

    /* renamed from: S  reason: collision with root package name */
    private int f17006S = 0;

    /* renamed from: T  reason: collision with root package name */
    private int f17007T = 1;

    /* renamed from: U  reason: collision with root package name */
    private int f17008U = 60;

    /* renamed from: V  reason: collision with root package name */
    private String f17009V = "";

    /* renamed from: W  reason: collision with root package name */
    private JSONArray f17010W;

    /* renamed from: X  reason: collision with root package name */
    private JSONObject f17011X;

    /* renamed from: b  reason: collision with root package name */
    private String f17012b;

    /* renamed from: c  reason: collision with root package name */
    private String f17013c;

    /* renamed from: d  reason: collision with root package name */
    private List<b> f17014d;

    /* renamed from: e  reason: collision with root package name */
    private long f17015e;

    /* renamed from: f  reason: collision with root package name */
    private int f17016f = -1;

    /* renamed from: g  reason: collision with root package name */
    private int f17017g = 0;

    /* renamed from: h  reason: collision with root package name */
    private int f17018h = 0;

    /* renamed from: i  reason: collision with root package name */
    private int f17019i = 1;

    /* renamed from: j  reason: collision with root package name */
    private int f17020j = 1;

    /* renamed from: k  reason: collision with root package name */
    private int f17021k = 1;

    /* renamed from: l  reason: collision with root package name */
    private int f17022l = 1;

    /* renamed from: m  reason: collision with root package name */
    private int f17023m = 5;

    /* renamed from: n  reason: collision with root package name */
    private int f17024n = 1;

    /* renamed from: o  reason: collision with root package name */
    private int f17025o = 3;

    /* renamed from: p  reason: collision with root package name */
    private int f17026p = 80;

    /* renamed from: q  reason: collision with root package name */
    private int f17027q = 100;

    /* renamed from: r  reason: collision with root package name */
    private int f17028r = 0;

    /* renamed from: s  reason: collision with root package name */
    private double f17029s = 1.0d;

    /* renamed from: t  reason: collision with root package name */
    private int f17030t = -1;

    /* renamed from: u  reason: collision with root package name */
    private ArrayList<Integer> f17031u;

    /* renamed from: v  reason: collision with root package name */
    private int f17032v = 3;

    /* renamed from: w  reason: collision with root package name */
    private int f17033w = 1;

    /* renamed from: x  reason: collision with root package name */
    private int f17034x = 100;

    /* renamed from: y  reason: collision with root package name */
    private int f17035y = 60;

    /* renamed from: z  reason: collision with root package name */
    private int f17036z = 0;

    private void y(int i4) {
        if (i4 <= 0) {
            this.f17000M = 1;
        } else {
            this.f17000M = i4;
        }
    }

    public final int A() {
        return this.f17032v;
    }

    public final Queue<Integer> B() {
        LinkedList linkedList;
        Exception e5;
        try {
            List<b> list = this.f17014d;
            if (list == null || list.size() <= 0) {
                return null;
            }
            linkedList = new LinkedList();
            int i4 = 0;
            while (i4 < this.f17014d.size()) {
                try {
                    linkedList.add(Integer.valueOf(this.f17014d.get(i4).b()));
                    i4++;
                } catch (Exception e6) {
                    e5 = e6;
                    e5.printStackTrace();
                    return linkedList;
                }
            }
            return linkedList;
        } catch (Exception e7) {
            Exception exc = e7;
            linkedList = null;
            e5 = exc;
            e5.printStackTrace();
            return linkedList;
        }
    }

    public final int C() {
        return this.f17007T;
    }

    public final int D() {
        return this.f17008U;
    }

    public final JSONObject E() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(CampaignEx.JSON_KEY_CAMPAIGN_UNITID, this.f17012b);
            jSONObject.put("callbackType", this.f17019i);
            List<b> list = this.f17014d;
            if (list != null && list.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                for (b next : this.f17014d) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("id", next.a());
                    jSONObject2.put("timeout", next.b());
                    jSONArray.put(jSONObject2);
                }
                jSONObject.put("adSourceList", jSONArray);
            }
            jSONObject.put("aqn", this.f17020j);
            jSONObject.put("acn", this.f17021k);
            jSONObject.put("vcn", this.f17022l);
            jSONObject.put(TypedValues.CycleType.S_WAVE_OFFSET, this.f17023m);
            jSONObject.put("dlnet", this.f17024n);
            jSONObject.put("tv_start", this.f17025o);
            jSONObject.put("tv_end", this.f17026p);
            jSONObject.put(CampaignEx.JSON_KEY_READY_RATE, this.f17027q);
            jSONObject.put("endscreen_type", this.f16996I);
            jSONObject.put("daily_play_cap", this.f16990B);
            jSONObject.put("video_skip_time", this.f16991C);
            jSONObject.put("video_skip_result", this.f16992D);
            jSONObject.put("video_interactive_type", this.f16993E);
            jSONObject.put("orientation", this.f17036z);
            jSONObject.put("close_button_delay", this.f16994F);
            jSONObject.put("playclosebtn_tm", this.f17016f);
            jSONObject.put("play_ctdown", this.f17017g);
            jSONObject.put("close_alert", this.f17018h);
            jSONObject.put("rfpv", this.f17030t);
            jSONObject.put("vdcmp", this.f17029s);
            JSONArray jSONArray2 = new JSONArray();
            ArrayList<Integer> arrayList = this.f17031u;
            if (arrayList != null) {
                if (arrayList.size() > 0) {
                    ArrayList<Integer> arrayList2 = this.f17031u;
                    int size = arrayList2.size();
                    int i4 = 0;
                    while (i4 < size) {
                        Integer num = arrayList2.get(i4);
                        i4++;
                        jSONArray2.put(num);
                    }
                }
                jSONObject.put("atl_type", jSONArray2);
            }
            jSONObject.put("atl_dyt", this.f17032v);
            jSONObject.put("tmorl", this.f17033w);
            jSONObject.put("placementid", this.f17013c);
            jSONObject.put("ltafemty", this.f17034x);
            jSONObject.put("ltorwc", this.f17035y);
            jSONObject.put(RewardPlus.AMOUNT_MAX, this.f16997J);
            jSONObject.put(RewardPlus.CALLBACK_RULE, this.f16998K);
            jSONObject.put(RewardPlus.VIRTUAL_CURRENCY, this.f16999L);
            jSONObject.put(RewardPlus.AMOUNT, this.f17000M);
            jSONObject.put(RewardPlus.ICON, this.f17001N);
            jSONObject.put(RewardPlus.CURRENCY_ID, this.f17002O);
            jSONObject.put(RewardPlus.NAME, this.f17003P);
            jSONObject.put("isDefault", this.f17006S);
            jSONObject.put("video_error_rule", this.f17007T);
            jSONObject.put("loadtmo", this.f17008U);
            jSONObject.put("vtag", this.f17009V);
            return jSONObject;
        } catch (Exception e5) {
            e5.printStackTrace();
            return jSONObject;
        }
    }

    public final int F() {
        return this.f16989A;
    }

    public final JSONArray G() {
        return this.f17010W;
    }

    public final int a() {
        return this.f17034x;
    }

    public final int b() {
        return this.f17035y;
    }

    public final int c() {
        return this.f17036z;
    }

    public final int d() {
        return this.f16990B;
    }

    public final int e() {
        return this.f16991C;
    }

    public final int f() {
        return this.f16992D;
    }

    public final int g() {
        return this.f16993E;
    }

    public final int h() {
        return this.f17016f;
    }

    public final int i() {
        return this.f17018h;
    }

    public final String j() {
        return this.f17009V;
    }

    public final String k() {
        return this.f17004Q;
    }

    public final String l() {
        return this.f17005R;
    }

    public final int m() {
        return this.f17000M;
    }

    public final String n() {
        return this.f17003P;
    }

    public final int o() {
        return this.f16995G;
    }

    public final int p() {
        return this.f16994F;
    }

    public final int q() {
        return this.f16996I;
    }

    public final int r() {
        return this.f17027q;
    }

    public final int s() {
        return this.f17028r;
    }

    public final int t() {
        return this.f17020j;
    }

    public final int u() {
        return this.f17021k;
    }

    public final int v() {
        return this.f17023m;
    }

    public final int w() {
        return this.f17024n;
    }

    public final long x() {
        return this.f17015e;
    }

    public final String z() {
        return this.f17013c;
    }

    public final void a(ArrayList<Integer> arrayList) {
        this.f17031u = arrayList;
    }

    public final void b(int i4) {
        this.f16990B = i4;
    }

    public final void c(int i4) {
        this.f16991C = i4;
    }

    public final void d(int i4) {
        this.f16992D = i4;
    }

    public final void e(int i4) {
        this.f16993E = i4;
    }

    public final void f(int i4) {
        this.f16994F = i4;
    }

    public final void g(int i4) {
        this.f16996I = i4;
    }

    public final void h(int i4) {
        this.f17025o = i4;
    }

    public final void i(int i4) {
        this.f17026p = i4;
    }

    public final void j(int i4) {
        this.f17027q = i4;
    }

    public final void k(int i4) {
        this.f17028r = i4;
    }

    public final void l(int i4) {
        this.f17020j = i4;
    }

    public final void m(int i4) {
        this.f17021k = i4;
    }

    public final void n(int i4) {
        this.f17022l = i4;
    }

    public final void o(int i4) {
        this.f17023m = i4;
    }

    public final void p(int i4) {
        this.f17024n = i4;
    }

    public final void q(int i4) {
        this.f17019i = i4;
    }

    public final void r(int i4) {
        this.f17033w = i4;
    }

    public final boolean s(int i4) {
        ArrayList<Integer> arrayList = this.f17031u;
        if (arrayList == null || arrayList.size() <= 0) {
            return false;
        }
        return this.f17031u.contains(Integer.valueOf(i4));
    }

    public final void t(int i4) {
        this.f17032v = i4;
    }

    public final void u(int i4) {
        this.f17006S = i4;
    }

    public final void v(int i4) {
        this.f17007T = i4;
    }

    public final void w(int i4) {
        this.f17008U = i4;
    }

    public final void x(int i4) {
        this.f16989A = i4;
    }

    public static c c(String str) {
        JSONObject optJSONObject;
        if (f16987H == null) {
            f16987H = g.a(com.mbridge.msdk.foundation.controller.c.m().c());
        }
        c cVar = null;
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("vtag", "");
                String optString2 = jSONObject.optString("rid", "");
                JSONArray optJSONArray = jSONObject.optJSONArray("unitSetting");
                if (!(optJSONArray == null || (optJSONObject = optJSONArray.optJSONObject(0)) == null)) {
                    String optString3 = optJSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
                    if (!TextUtils.isEmpty(optString3)) {
                        c cVar2 = new c();
                        try {
                            cVar2.f17009V = optString;
                            cVar2.f17005R = optString2;
                            List<b> a5 = b.a(optJSONObject.optJSONArray("adSourceList"));
                            cVar2.f17012b = optString3;
                            cVar2.f17014d = a5;
                            cVar2.f17019i = optJSONObject.optInt("callbackType");
                            int optInt = optJSONObject.optInt("aqn", 1);
                            if (optInt <= 0) {
                                optInt = 1;
                            }
                            cVar2.f17020j = optInt;
                            int optInt2 = optJSONObject.optInt("acn", 1);
                            if (optInt2 < 0) {
                                optInt2 = 1;
                            }
                            cVar2.f17021k = optInt2;
                            cVar2.f17022l = optJSONObject.optInt("vcn", 5);
                            cVar2.f17023m = optJSONObject.optInt(TypedValues.CycleType.S_WAVE_OFFSET, 5);
                            cVar2.f17024n = optJSONObject.optInt("dlnet", 1);
                            cVar2.f16996I = optJSONObject.optInt("endscreen_type", 2);
                            int i4 = 3;
                            cVar2.f17025o = optJSONObject.optInt("tv_start", 3);
                            cVar2.f17026p = optJSONObject.optInt("tv_end", 80);
                            cVar2.f17027q = optJSONObject.optInt(CampaignEx.JSON_KEY_READY_RATE, 100);
                            cVar2.f17028r = optJSONObject.optInt("cd_rate", 0);
                            cVar2.f17015e = jSONObject.optLong("current_time");
                            cVar2.f17036z = optJSONObject.optInt("orientation", 0);
                            cVar2.f16990B = optJSONObject.optInt("daily_play_cap", 0);
                            cVar2.f16991C = optJSONObject.optInt("video_skip_time", -1);
                            cVar2.f16992D = optJSONObject.optInt("video_skip_result", 2);
                            cVar2.f16993E = optJSONObject.optInt("video_interactive_type", -1);
                            cVar2.f16994F = optJSONObject.optInt("close_button_delay", 1);
                            cVar2.f17016f = optJSONObject.optInt("playclosebtn_tm", -1);
                            cVar2.f17017g = optJSONObject.optInt("play_ctdown", 0);
                            cVar2.f17018h = optJSONObject.optInt("close_alert", 0);
                            cVar2.f16995G = optJSONObject.optInt("rdrct", 20);
                            cVar2.f16989A = optJSONObject.optInt("load_global_timeout", 70);
                            cVar2.f17030t = optJSONObject.optInt("rfpv", -1);
                            cVar2.f17029s = optJSONObject.optDouble("vdcmp", 1.0d);
                            f16988a = optJSONObject.optString("atzu");
                            JSONArray optJSONArray2 = optJSONObject.optJSONArray("atl_type");
                            ArrayList<Integer> arrayList = new ArrayList<>();
                            if (optJSONArray2 != null) {
                                int i5 = 0;
                                while (i5 < optJSONArray2.length()) {
                                    try {
                                        arrayList.add(Integer.valueOf(optJSONArray2.getInt(i5)));
                                        i5++;
                                    } catch (Exception e5) {
                                        e5.printStackTrace();
                                    }
                                }
                            } else {
                                arrayList.add(4);
                                arrayList.add(6);
                            }
                            cVar2.f17031u = arrayList;
                            int optInt3 = optJSONObject.optInt("atl_dyt", 0);
                            if (optInt3 > 0) {
                                i4 = optInt3;
                            }
                            cVar2.f17032v = i4;
                            int optInt4 = optJSONObject.optInt("tmorl", 1);
                            if (optInt4 > 2 || optInt4 <= 0) {
                                optInt4 = 1;
                            }
                            cVar2.f17033w = optInt4;
                            cVar2.f17013c = optJSONObject.optString("placementid");
                            cVar2.f17034x = optJSONObject.optInt("ltafemty", 10);
                            cVar2.f17035y = optJSONObject.optInt("ltorwc", 60);
                            cVar2.d(optJSONObject.optString("ab_id"));
                            cVar2.f16997J = optJSONObject.optInt(RewardPlus.AMOUNT_MAX, 0);
                            cVar2.f16998K = optJSONObject.optInt(RewardPlus.CALLBACK_RULE, 1);
                            cVar2.f16999L = optJSONObject.optString(RewardPlus.VIRTUAL_CURRENCY, "");
                            cVar2.y(optJSONObject.optInt(RewardPlus.AMOUNT, 1));
                            cVar2.f17001N = optJSONObject.optString(RewardPlus.ICON, "");
                            cVar2.f17002O = optJSONObject.optInt(RewardPlus.CURRENCY_ID, 1);
                            cVar2.e(optJSONObject.optString(RewardPlus.NAME, "Virtual Item"));
                            cVar2.f17007T = optJSONObject.optInt("video_error_rule", 1);
                            cVar2.f17008U = optJSONObject.optInt("loadtmo", 60);
                            cVar2.f17010W = optJSONObject.optJSONArray("local_cache_info");
                            try {
                                String optString4 = optJSONObject.optString(MBridgeCommon.SettingConfig.KEY_SETTING_CONFIG_RETRY_STRATEGY);
                                if (!TextUtils.isEmpty(optString4)) {
                                    String a6 = z.a(optString4);
                                    if (!TextUtils.isEmpty(a6)) {
                                        cVar2.f17011X = new JSONObject(a6);
                                    }
                                }
                            } catch (Exception unused) {
                            }
                            return cVar2;
                        } catch (Exception e6) {
                            e = e6;
                            cVar = cVar2;
                            e.printStackTrace();
                            return cVar;
                        }
                    }
                }
            } catch (Exception e7) {
                e = e7;
                e.printStackTrace();
                return cVar;
            }
        }
        return cVar;
    }

    private void d(String str) {
        this.f17004Q = str;
        a.f12767b.put(this.f17012b, str);
    }

    private void e(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f17003P = this.f16999L;
        } else {
            this.f17003P = str;
        }
    }

    public final void a(int i4) {
        this.f17036z = i4;
    }

    public final void b(String str) {
        this.f17013c = str;
    }

    public final int y() {
        return this.f17033w;
    }

    public final void a(String str) {
        this.f17012b = str;
    }

    public final void a(List<b> list) {
        this.f17014d = list;
    }

    public static c a(JSONObject jSONObject) {
        c cVar;
        c cVar2 = null;
        if (jSONObject != null) {
            try {
                cVar = new c();
            } catch (Exception e5) {
                e = e5;
                e.printStackTrace();
                return cVar2;
            }
            try {
                cVar.f17014d = b.a(jSONObject.optJSONArray("adSourceList"));
                cVar.f17019i = jSONObject.optInt("callbackType");
                int optInt = jSONObject.optInt("aqn", 1);
                if (optInt <= 0) {
                    optInt = 1;
                }
                cVar.f17020j = optInt;
                int optInt2 = jSONObject.optInt("acn", 1);
                if (optInt2 < 0) {
                    optInt2 = 1;
                }
                cVar.f17021k = optInt2;
                cVar.f17022l = jSONObject.optInt("vcn", 5);
                cVar.f17023m = jSONObject.optInt(TypedValues.CycleType.S_WAVE_OFFSET, 5);
                cVar.f17024n = jSONObject.optInt("dlnet", 1);
                cVar.f16996I = jSONObject.optInt("endscreen_type", 2);
                cVar.f17025o = jSONObject.optInt("tv_start", 3);
                cVar.f17026p = jSONObject.optInt("tv_end", 80);
                cVar.f17027q = jSONObject.optInt(CampaignEx.JSON_KEY_READY_RATE, 100);
                cVar.f17015e = jSONObject.optLong("current_time");
                cVar.f17036z = jSONObject.optInt("orientation", 0);
                cVar.f16990B = jSONObject.optInt("daily_play_cap", 0);
                cVar.f16991C = jSONObject.optInt("video_skip_time", -1);
                cVar.f16992D = jSONObject.optInt("video_skip_result", 2);
                cVar.f16993E = jSONObject.optInt("video_interactive_type", -1);
                cVar.f16994F = jSONObject.optInt("close_button_delay", 1);
                cVar.f17016f = jSONObject.optInt("playclosebtn_tm", -1);
                cVar.f17017g = jSONObject.optInt("play_ctdown", 0);
                cVar.f17018h = jSONObject.optInt("close_alert", 0);
                cVar.f16995G = jSONObject.optInt("rdrct", 20);
                cVar.f17030t = jSONObject.optInt("rfpv", -1);
                cVar.f17029s = jSONObject.optDouble("vdcmp", 1.0d);
                cVar.f16989A = jSONObject.optInt("load_global_timeout", 70);
                JSONArray optJSONArray = jSONObject.optJSONArray("atl_type");
                ArrayList<Integer> arrayList = new ArrayList<>();
                if (optJSONArray != null) {
                    int i4 = 0;
                    while (i4 < optJSONArray.length()) {
                        try {
                            arrayList.add(Integer.valueOf(optJSONArray.getInt(i4)));
                            i4++;
                        } catch (Exception e6) {
                            e6.printStackTrace();
                        }
                    }
                } else {
                    arrayList.add(4);
                    arrayList.add(6);
                }
                cVar.f17031u = arrayList;
                cVar.f17032v = jSONObject.optInt("atl_dyt", 3);
                int optInt3 = jSONObject.optInt("tmorl", 1);
                if (optInt3 > 2 || optInt3 <= 0) {
                    optInt3 = 1;
                }
                cVar.f17033w = optInt3;
                cVar.f17013c = jSONObject.optString("placementid");
                cVar.f17034x = jSONObject.optInt("ltafemty", 10);
                cVar.f17035y = jSONObject.optInt("ltorwc", 60);
                cVar.d(jSONObject.optString("ab_id"));
                cVar.f17005R = jSONObject.optString("rid", "");
                cVar.f16997J = jSONObject.optInt(RewardPlus.AMOUNT_MAX, 0);
                cVar.f16998K = jSONObject.optInt(RewardPlus.CALLBACK_RULE, 1);
                cVar.f16999L = jSONObject.optString(RewardPlus.VIRTUAL_CURRENCY, "");
                cVar.y(jSONObject.optInt(RewardPlus.AMOUNT, 1));
                cVar.f17001N = jSONObject.optString(RewardPlus.ICON, "");
                cVar.f17002O = jSONObject.optInt(RewardPlus.CURRENCY_ID, 1);
                cVar.e(jSONObject.optString(RewardPlus.NAME, "Virtual Item"));
                cVar.f17007T = jSONObject.optInt("video_error_rule", 1);
                cVar.f17008U = jSONObject.optInt("loadtmo", 60);
                cVar.f17009V = jSONObject.optString("vtag", "");
                cVar.f17010W = jSONObject.optJSONArray("local_cache_info");
                try {
                    String optString = jSONObject.optString(MBridgeCommon.SettingConfig.KEY_SETTING_CONFIG_RETRY_STRATEGY);
                    if (!TextUtils.isEmpty(optString)) {
                        String a5 = z.a(optString);
                        if (!TextUtils.isEmpty(a5)) {
                            cVar.f17011X = new JSONObject(a5);
                        }
                    }
                } catch (Exception unused) {
                }
                return cVar;
            } catch (Exception e7) {
                e = e7;
                cVar2 = cVar;
                e.printStackTrace();
                return cVar2;
            }
        }
        return cVar2;
    }
}
