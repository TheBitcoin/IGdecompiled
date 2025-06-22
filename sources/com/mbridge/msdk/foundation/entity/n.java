package com.mbridge.msdk.foundation.entity;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.mbridge.msdk.foundation.same.a;
import com.mbridge.msdk.foundation.tools.ab;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public final class n {

    /* renamed from: a  reason: collision with root package name */
    public static int f13061a = 1;

    /* renamed from: b  reason: collision with root package name */
    public static int f13062b;

    /* renamed from: A  reason: collision with root package name */
    private String f13063A;

    /* renamed from: B  reason: collision with root package name */
    private String f13064B;

    /* renamed from: C  reason: collision with root package name */
    private String f13065C;

    /* renamed from: D  reason: collision with root package name */
    private String f13066D;

    /* renamed from: E  reason: collision with root package name */
    private int f13067E;

    /* renamed from: F  reason: collision with root package name */
    private String f13068F;

    /* renamed from: G  reason: collision with root package name */
    private String f13069G;

    /* renamed from: H  reason: collision with root package name */
    private int f13070H = 0;

    /* renamed from: I  reason: collision with root package name */
    private String f13071I;

    /* renamed from: J  reason: collision with root package name */
    private String f13072J;

    /* renamed from: K  reason: collision with root package name */
    private String f13073K;

    /* renamed from: L  reason: collision with root package name */
    private int f13074L;

    /* renamed from: M  reason: collision with root package name */
    private long f13075M;

    /* renamed from: N  reason: collision with root package name */
    private String f13076N;

    /* renamed from: O  reason: collision with root package name */
    private int f13077O;

    /* renamed from: c  reason: collision with root package name */
    private Map<String, String> f13078c = null;

    /* renamed from: d  reason: collision with root package name */
    private String f13079d;

    /* renamed from: e  reason: collision with root package name */
    private int f13080e;

    /* renamed from: f  reason: collision with root package name */
    private int f13081f = 0;

    /* renamed from: g  reason: collision with root package name */
    private int f13082g;

    /* renamed from: h  reason: collision with root package name */
    private String f13083h;

    /* renamed from: i  reason: collision with root package name */
    private String f13084i;

    /* renamed from: j  reason: collision with root package name */
    private String f13085j;

    /* renamed from: k  reason: collision with root package name */
    private String f13086k;

    /* renamed from: l  reason: collision with root package name */
    private String f13087l;

    /* renamed from: m  reason: collision with root package name */
    private String f13088m;

    /* renamed from: n  reason: collision with root package name */
    private String f13089n;

    /* renamed from: o  reason: collision with root package name */
    private String f13090o;

    /* renamed from: p  reason: collision with root package name */
    private String f13091p;

    /* renamed from: q  reason: collision with root package name */
    private String f13092q;

    /* renamed from: r  reason: collision with root package name */
    private int f13093r;

    /* renamed from: s  reason: collision with root package name */
    private String f13094s;

    /* renamed from: t  reason: collision with root package name */
    private String f13095t;

    /* renamed from: u  reason: collision with root package name */
    private String f13096u;

    /* renamed from: v  reason: collision with root package name */
    private int f13097v = 0;

    /* renamed from: w  reason: collision with root package name */
    private int f13098w;

    /* renamed from: x  reason: collision with root package name */
    private String f13099x;

    /* renamed from: y  reason: collision with root package name */
    private String f13100y;

    /* renamed from: z  reason: collision with root package name */
    private String f13101z;

    public n(String str, int i4, int i5, int i6, int i7, String str2, String str3, int i8, String str4, int i9, String str5) {
        this.f13094s = str;
        this.f13098w = i4;
        this.f13099x = str5;
        this.f13093r = i5;
        this.f13077O = i6;
        this.f13074L = i7;
        try {
            if (!TextUtils.isEmpty(str2)) {
                this.f13100y = URLEncoder.encode(str2, "utf-8");
            }
        } catch (UnsupportedEncodingException e5) {
            e5.printStackTrace();
        }
        this.f13101z = str3;
        this.f13067E = i8;
        this.f13086k = str4;
        this.f13075M = (long) i9;
    }

    public final int A() {
        return this.f13077O;
    }

    public final int B() {
        return this.f13097v;
    }

    public final int C() {
        return this.f13082g;
    }

    public final String D() {
        return this.f13071I;
    }

    public final String E() {
        return this.f13089n;
    }

    public final int F() {
        return this.f13070H;
    }

    public final String a() {
        return this.f13094s;
    }

    public final String b() {
        return this.f13065C;
    }

    public final String c() {
        return this.f13073K;
    }

    public final String d() {
        return this.f13079d;
    }

    public final String e() {
        return this.f13083h;
    }

    public final String f() {
        return this.f13063A;
    }

    public final String g() {
        return this.f13064B;
    }

    public final String h() {
        return TextUtils.isEmpty(this.f13101z) ? "" : this.f13101z;
    }

    public final String i() {
        return this.f13084i;
    }

    public final String j() {
        return this.f13085j;
    }

    public final int k() {
        return this.f13098w;
    }

    public final String l() {
        return this.f13099x;
    }

    public final int m() {
        return this.f13067E;
    }

    public final String n() {
        return this.f13086k;
    }

    public final long o() {
        return this.f13075M;
    }

    public final int p() {
        return this.f13074L;
    }

    public final String q() {
        return this.f13076N;
    }

    public final String r() {
        return this.f13100y;
    }

    public final String s() {
        return this.f13088m;
    }

    public final String t() {
        return this.f13087l;
    }

    @NonNull
    public final String toString() {
        return "RewardReportData [key=" + this.f13094s + ", networkType=" + this.f13098w + ", isCompleteView=" + this.f13093r + ", watchedMillis=" + this.f13077O + ", videoLength=" + this.f13074L + ", offerUrl=" + this.f13100y + ", reason=" + this.f13101z + ", result=" + this.f13067E + ", duration=" + this.f13086k + ", videoSize=" + this.f13075M + "]";
    }

    public final int u() {
        return this.f13080e;
    }

    public final String v() {
        return this.f13090o;
    }

    public final String w() {
        return this.f13072J;
    }

    public final String x() {
        return this.f13095t;
    }

    public final String y() {
        return this.f13092q;
    }

    public final int z() {
        return this.f13093r;
    }

    public final void a(String str) {
        this.f13094s = str;
    }

    public final void b(String str) {
        this.f13065C = str;
    }

    public final void c(String str) {
        this.f13073K = str;
    }

    public final void d(String str) {
        this.f13079d = str;
    }

    public final void e(String str) {
        this.f13083h = str;
    }

    public final void f(String str) {
        this.f13063A = str;
    }

    public final void g(String str) {
        this.f13064B = str;
    }

    public final void h(String str) {
        this.f13101z = str;
    }

    public final void i(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f13084i = URLEncoder.encode(str);
        }
    }

    public final void j(String str) {
        this.f13085j = str;
    }

    public final void k(String str) {
        this.f13099x = str;
    }

    public final void l(String str) {
        this.f13086k = str;
    }

    public final void m(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                this.f13076N = URLEncoder.encode(str, "utf-8");
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    public final void n(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                this.f13088m = URLEncoder.encode(str, "utf-8");
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    public final void o(String str) {
        this.f13087l = str;
    }

    public final void p(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                this.f13092q = URLEncoder.encode(str, "utf-8");
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    public final void q(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                this.f13071I = URLEncoder.encode(str, "utf-8");
            }
        } catch (UnsupportedEncodingException e5) {
            e5.printStackTrace();
        }
    }

    public final void r(String str) {
        this.f13089n = str;
    }

    public final void s(String str) {
        this.f13096u = str;
    }

    public final void t(String str) {
        this.f13066D = str;
    }

    public final void u(String str) {
        this.f13068F = str;
    }

    public final void v(String str) {
        this.f13069G = str;
    }

    public final void a(int i4) {
        this.f13098w = i4;
    }

    public final void b(int i4) {
        this.f13067E = i4;
    }

    public final void c(int i4) {
        this.f13080e = i4;
    }

    public final void d(int i4) {
        this.f13097v = i4;
    }

    public final void e(int i4) {
        this.f13070H = i4;
    }

    public final void a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (this.f13078c == null) {
                this.f13078c = new HashMap();
            }
            try {
                this.f13078c.put(str, str2);
            } catch (Exception unused) {
            }
        }
    }

    public final String b(String str, String str2) {
        Map<String, String> map;
        if (!TextUtils.isEmpty(str) && (map = this.f13078c) != null) {
            try {
                String str3 = map.get(str);
                return TextUtils.isEmpty(str3) ? str2 : str3;
            } catch (Exception unused) {
            }
        }
    }

    public n() {
    }

    public n(String str, int i4, String str2, String str3, String str4) {
        this.f13094s = str;
        this.f13099x = str4;
        this.f13098w = i4;
        if (!TextUtils.isEmpty(str2)) {
            try {
                this.f13100y = URLEncoder.encode(str2, "utf-8");
            } catch (UnsupportedEncodingException e5) {
                e5.printStackTrace();
            }
        }
        this.f13101z = str3;
    }

    public n(String str, int i4, int i5, String str2, int i6, String str3, int i7, String str4) {
        this.f13094s = str;
        this.f13098w = i4;
        this.f13099x = str4;
        this.f13074L = i5;
        if (!TextUtils.isEmpty(str2)) {
            try {
                this.f13100y = URLEncoder.encode(str2, "utf-8");
            } catch (UnsupportedEncodingException e5) {
                e5.printStackTrace();
            }
        }
        this.f13067E = i6;
        this.f13086k = str3;
        this.f13075M = (long) i7;
    }

    public n(Context context, CampaignEx campaignEx, int i4, String str, long j4, int i5) {
        if (i5 == 1 || i5 == 287 || i5 == 94) {
            this.f13094s = "m_download_end";
        } else if (i5 == 95) {
            this.f13094s = "2000025";
        }
        int m4 = ab.m(context);
        this.f13098w = m4;
        this.f13099x = ab.a(context, m4);
        this.f13074L = campaignEx.getVideoLength();
        this.f13063A = campaignEx.getRequestId();
        this.f13064B = campaignEx.getRequestIdNotice();
        if (!TextUtils.isEmpty(this.f13100y)) {
            try {
                this.f13100y = URLEncoder.encode(campaignEx.getNoticeUrl() == null ? campaignEx.getClickURL() : campaignEx.getNoticeUrl(), "utf-8");
            } catch (UnsupportedEncodingException e5) {
                e5.printStackTrace();
            }
        }
        this.f13067E = i4;
        this.f13086k = str;
        this.f13075M = j4 == 0 ? (long) campaignEx.getVideoSize() : j4;
    }

    public n(String str, String str2, String str3, String str4, String str5, String str6, int i4, String str7) {
        this.f13094s = str;
        this.f13090o = str2;
        this.f13072J = str3;
        this.f13095t = str4;
        this.f13073K = str5;
        this.f13083h = str6;
        this.f13098w = i4;
        this.f13099x = str7;
    }

    public n(String str) {
        this.f13091p = str;
    }

    public n(String str, int i4, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.f13094s = str;
        this.f13067E = i4;
        this.f13086k = str2;
        try {
            if (!TextUtils.isEmpty(str3)) {
                this.f13088m = URLEncoder.encode(str3, "utf-8");
            }
        } catch (UnsupportedEncodingException e5) {
            e5.printStackTrace();
        }
        this.f13083h = str4;
        this.f13073K = str5;
        this.f13101z = str6;
        this.f13087l = str7;
        if (Integer.valueOf(str2).intValue() > a.f13114L) {
            this.f13067E = 2;
        }
    }

    public n(String str, String str2, String str3, String str4, String str5, int i4) {
        this.f13094s = str;
        this.f13083h = str2;
        this.f13063A = str3;
        this.f13064B = str4;
        this.f13073K = str5;
        this.f13098w = i4;
    }

    public n(String str, String str2, String str3, String str4, String str5, int i4, int i5, String str6) {
        this.f13094s = str;
        this.f13083h = str2;
        this.f13063A = str3;
        this.f13064B = str4;
        this.f13073K = str5;
        this.f13098w = i4;
        this.f13101z = str6;
        this.f13082g = i5;
    }
}
