package com.mbridge.msdk.foundation.same.report.d;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.leanback.preference.LeanbackPreferenceDialogFragment;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.e;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.foundation.c.b;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.net.e.d;
import com.mbridge.msdk.foundation.tools.aq;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public final class c implements Serializable, Cloneable {

    /* renamed from: A  reason: collision with root package name */
    private int f13416A;

    /* renamed from: B  reason: collision with root package name */
    private CampaignEx f13417B;

    /* renamed from: C  reason: collision with root package name */
    private CopyOnWriteArrayList<CampaignEx> f13418C = new CopyOnWriteArrayList<>();

    /* renamed from: a  reason: collision with root package name */
    private boolean f13419a = false;

    /* renamed from: b  reason: collision with root package name */
    private Map<String, Map<String, String>> f13420b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private Map<String, Map<String, String>> f13421c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private Map<String, Long> f13422d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    private b f13423e;

    /* renamed from: f  reason: collision with root package name */
    private String f13424f = "";

    /* renamed from: g  reason: collision with root package name */
    private CopyOnWriteArrayList<CampaignEx> f13425g = new CopyOnWriteArrayList<>();

    /* renamed from: h  reason: collision with root package name */
    private String f13426h;

    /* renamed from: i  reason: collision with root package name */
    private int f13427i;

    /* renamed from: j  reason: collision with root package name */
    private String f13428j;

    /* renamed from: k  reason: collision with root package name */
    private String f13429k;

    /* renamed from: l  reason: collision with root package name */
    private String f13430l;

    /* renamed from: m  reason: collision with root package name */
    private String f13431m;

    /* renamed from: n  reason: collision with root package name */
    private String f13432n;

    /* renamed from: o  reason: collision with root package name */
    private String f13433o;

    /* renamed from: p  reason: collision with root package name */
    private String f13434p;

    /* renamed from: q  reason: collision with root package name */
    private String f13435q;

    /* renamed from: r  reason: collision with root package name */
    private int f13436r = -1;

    /* renamed from: s  reason: collision with root package name */
    private int f13437s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f13438t = false;

    /* renamed from: u  reason: collision with root package name */
    private boolean f13439u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f13440v = false;

    /* renamed from: w  reason: collision with root package name */
    private boolean f13441w;

    /* renamed from: x  reason: collision with root package name */
    private int f13442x;

    /* renamed from: y  reason: collision with root package name */
    private int f13443y;

    /* renamed from: z  reason: collision with root package name */
    private int f13444z;

    public c() {
    }

    public final boolean a() {
        return this.f13419a;
    }

    public final int b() {
        return this.f13436r;
    }

    public final String c() {
        return this.f13435q;
    }

    @NonNull
    public final Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public final String d() {
        return this.f13434p;
    }

    public final List<CampaignEx> e() {
        return this.f13425g;
    }

    public final String f() {
        return this.f13424f;
    }

    public final CampaignEx g() {
        return this.f13417B;
    }

    public final List<CampaignEx> h() {
        return this.f13418C;
    }

    public final String i() {
        Map map;
        if (!TextUtils.isEmpty(this.f13426h)) {
            return this.f13426h;
        }
        try {
            if (TextUtils.isEmpty(this.f13426h)) {
                String str = this.f13424f + this.f13435q;
                Map<String, Map<String, String>> map2 = this.f13420b;
                if (map2 != null && map2.containsKey(str) && (map = this.f13420b.get(str)) != null && map.containsKey(MBridgeConstans.PROPERTIES_UNIT_ID)) {
                    this.f13426h = (String) map.get(MBridgeConstans.PROPERTIES_UNIT_ID);
                }
            }
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                e5.printStackTrace();
            }
        }
        return this.f13426h;
    }

    public final int j() {
        return this.f13427i;
    }

    public final String k() {
        return this.f13429k;
    }

    public final String l() {
        return this.f13430l;
    }

    public final String m() {
        return this.f13432n;
    }

    public final int n() {
        return this.f13437s;
    }

    public final b o() {
        return this.f13423e;
    }

    public final Map<String, Map<String, String>> p() {
        return this.f13420b;
    }

    public final Map<String, Map<String, String>> q() {
        return this.f13421c;
    }

    public final boolean r() {
        return this.f13439u;
    }

    public final boolean s() {
        return this.f13440v;
    }

    public final String t() {
        return this.f13431m;
    }

    public final void a(boolean z4) {
        this.f13438t = z4;
    }

    public final void b(String str) {
        this.f13434p = str;
    }

    public final void c(String str) {
        this.f13424f = str;
    }

    public final void d(String str) {
        this.f13426h = str;
    }

    public final void e(String str) {
        this.f13428j = str;
    }

    public final void f(String str) {
        this.f13429k = str;
    }

    public final void g(String str) {
        this.f13430l = str;
    }

    public final void h(String str) {
        this.f13432n = str;
    }

    public final Map<String, String> j(String str) {
        int i4;
        String str2;
        b bVar;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        e eVar = new e();
        try {
            this.f13435q = str;
            eVar.a(CampaignEx.JSON_KEY_ST_TS, Long.valueOf(System.currentTimeMillis()));
            if (!TextUtils.isEmpty(i())) {
                eVar.a(MBridgeConstans.PROPERTIES_UNIT_ID, i());
            }
            int i5 = this.f13427i;
            if (i5 != 0) {
                eVar.a("adtp", Integer.valueOf(i5));
            }
            if (!TextUtils.isEmpty(this.f13433o)) {
                eVar.a(CampaignEx.JSON_KEY_HB, this.f13433o);
            }
            if (!TextUtils.isEmpty(this.f13428j)) {
                eVar.a("bid_tk", this.f13428j);
            }
            if (!TextUtils.isEmpty(str)) {
                eVar.a(LeanbackPreferenceDialogFragment.ARG_KEY, str);
            }
            if (Arrays.asList(b.f13404a).contains(str)) {
                eVar.a("from_cache", this.f13438t ? "1" : "2");
            }
            if ("2000047".contains(str)) {
                b bVar2 = this.f13423e;
                if (bVar2 != null) {
                    eVar.a("type", Integer.valueOf(bVar2.e()));
                    eVar.a("reason", bVar2.b());
                    if (!TextUtils.isEmpty(bVar2.h())) {
                        eVar.a("reason_d", bVar2.h());
                        eVar.a("type_d", Integer.valueOf(bVar2.g()));
                    }
                }
            }
            if ("2000048".contains(str) && (bVar = this.f13423e) != null && !TextUtils.isEmpty(bVar.h())) {
                eVar.a("type", Integer.valueOf(bVar.g()));
                eVar.a("reason", bVar.h());
            }
            if (this.f13427i == 296) {
                eVar.a("auto_load", this.f13434p);
                eVar.a("auto_refresh", Integer.valueOf(this.f13442x));
                eVar.a("auto_refresh_interval", Integer.valueOf(this.f13443y));
                eVar.a("content_type", Integer.valueOf(this.f13444z));
                eVar.a("temp_display_type", Integer.valueOf(this.f13416A));
            }
            if ("2000126".equals(this.f13435q)) {
                String str3 = this.f13428j;
                g a5 = h.a().a(com.mbridge.msdk.foundation.controller.c.m().k());
                if (TextUtils.isEmpty(str3)) {
                    i4 = a5.as();
                } else {
                    i4 = a5.I();
                }
                String a6 = d.f().a(str3, i4);
                if (TextUtils.isEmpty(a6)) {
                    str2 = "";
                } else {
                    str2 = aq.a(a6);
                }
                eVar.a("dns_ty", Integer.valueOf(e.a().a(str2)));
                eVar.a("dns_hs", str2);
            }
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                e5.printStackTrace();
            }
        }
        return eVar.a();
    }

    public final void k(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String str2 = this.f13424f + str;
                Map<String, Map<String, String>> map = this.f13420b;
                if (map != null && map.containsKey(str2)) {
                    this.f13420b.remove(str2);
                }
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    e5.printStackTrace();
                }
            }
        }
    }

    public final long l(String str) {
        Map<String, Long> map;
        try {
            if (!TextUtils.isEmpty(str) && (map = this.f13422d) != null && map.containsKey(str)) {
                Long l4 = this.f13422d.get(str);
                return System.currentTimeMillis() - (l4 != null ? l4.longValue() : 0);
            }
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                e5.printStackTrace();
            }
        }
        return 0;
    }

    public final void m(String str) {
        if (this.f13422d != null && !TextUtils.isEmpty(str)) {
            this.f13422d.put(str, Long.valueOf(System.currentTimeMillis()));
        }
    }

    public final void n(String str) {
        this.f13431m = str;
    }

    public final void a(int i4) {
        this.f13436r = i4;
    }

    public final void b(List<CampaignEx> list) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    if (!this.f13418C.isEmpty()) {
                        this.f13418C.clear();
                    }
                    this.f13418C.addAll(list);
                }
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    e5.printStackTrace();
                }
            }
        }
    }

    public final void c(int i4) {
        this.f13437s = i4;
    }

    public final void d(boolean z4) {
        this.f13441w = z4;
    }

    public final void e(int i4) {
        this.f13443y = i4;
    }

    public final void f(int i4) {
        this.f13444z = i4;
    }

    public final void g(int i4) {
        this.f13416A = i4;
    }

    public final void a(String str) {
        this.f13435q = str;
    }

    public final void c(boolean z4) {
        this.f13440v = z4;
    }

    public final void d(int i4) {
        this.f13442x = i4;
    }

    public final void a(List<CampaignEx> list) {
        if (list != null) {
            try {
                if (!list.isEmpty()) {
                    if (!this.f13425g.isEmpty()) {
                        this.f13425g.clear();
                    }
                    this.f13425g.addAll(list);
                }
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    e5.printStackTrace();
                }
            }
        }
    }

    public final void b(int i4) {
        this.f13427i = i4;
    }

    public final void b(boolean z4) {
        this.f13439u = z4;
    }

    public final void a(CampaignEx campaignEx) {
        this.f13417B = campaignEx;
        if (campaignEx != null) {
            try {
                CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = this.f13418C;
                int i4 = 0;
                if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
                    int i5 = 0;
                    while (true) {
                        if (i5 < this.f13418C.size()) {
                            if (this.f13418C.get(i5) != null && this.f13418C.get(i5).getId().equals(campaignEx.getId())) {
                                this.f13418C.set(i5, campaignEx);
                                break;
                            }
                            i5++;
                        } else {
                            break;
                        }
                    }
                }
                CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList2 = this.f13425g;
                if (copyOnWriteArrayList2 != null && !copyOnWriteArrayList2.isEmpty()) {
                    while (i4 < this.f13425g.size()) {
                        if (this.f13425g.get(i4) == null || !this.f13425g.get(i4).getId().equals(campaignEx.getId())) {
                            i4++;
                        } else {
                            this.f13425g.set(i4, campaignEx);
                            return;
                        }
                    }
                }
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    e5.printStackTrace();
                }
            }
        }
    }

    public c(boolean z4) {
        this.f13419a = z4;
    }

    public final void i(String str) {
        this.f13433o = str;
    }

    public final void a(String str, e eVar) {
        Map map;
        if (!TextUtils.isEmpty(str) && eVar != null) {
            try {
                String str2 = this.f13424f + str;
                Map<String, Map<String, String>> map2 = this.f13420b;
                if (map2 == null) {
                    return;
                }
                if (!map2.containsKey(str2) || (map = this.f13420b.get(str2)) == null) {
                    this.f13420b.put(str2, eVar.a());
                } else {
                    map.putAll(eVar.a());
                }
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    e5.printStackTrace();
                }
            }
        }
    }

    public final void a(String str, e eVar, int i4) {
        Map map;
        if (!TextUtils.isEmpty(str) && eVar != null) {
            try {
                String str2 = this.f13424f + "_" + i4 + "_" + str;
                Map<String, Map<String, String>> map2 = this.f13421c;
                if (map2 == null) {
                    return;
                }
                if (!map2.containsKey(str2) || (map = this.f13421c.get(str2)) == null) {
                    this.f13421c.put(str2, eVar.a());
                } else {
                    map.putAll(eVar.a());
                }
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    e5.printStackTrace();
                }
            }
        }
    }

    public final void a(b bVar) {
        this.f13423e = bVar;
    }
}
