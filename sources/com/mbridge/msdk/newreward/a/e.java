package com.mbridge.msdk.newreward.a;

import android.os.HandlerThread;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.newout.RewardVideoListener;
import com.mbridge.msdk.newreward.function.common.MBridgeCommon;
import com.mbridge.msdk.newreward.function.e.a;
import com.mbridge.msdk.newreward.function.e.c;
import com.mbridge.msdk.newreward.function.e.d;
import com.mbridge.msdk.newreward.function.e.f;
import com.mbridge.msdk.out.MBridgeIds;
import java.io.File;
import org.json.JSONArray;
import q1.C2205a;
import q1.C2206b;
import r1.C2216b;

public final class e {

    /* renamed from: A  reason: collision with root package name */
    private String f14377A;

    /* renamed from: B  reason: collision with root package name */
    private String f14378B;

    /* renamed from: C  reason: collision with root package name */
    private String f14379C = "";

    /* renamed from: D  reason: collision with root package name */
    private int f14380D;

    /* renamed from: E  reason: collision with root package name */
    private long f14381E;

    /* renamed from: F  reason: collision with root package name */
    private boolean f14382F = false;

    /* renamed from: G  reason: collision with root package name */
    private boolean f14383G = false;

    /* renamed from: H  reason: collision with root package name */
    private boolean f14384H = false;

    /* renamed from: I  reason: collision with root package name */
    private a f14385I = new a();

    /* renamed from: J  reason: collision with root package name */
    private com.mbridge.msdk.newreward.function.e.e f14386J = new com.mbridge.msdk.newreward.function.e.e();

    /* renamed from: K  reason: collision with root package name */
    private f f14387K = new f();

    /* renamed from: L  reason: collision with root package name */
    private c f14388L = new c();

    /* renamed from: M  reason: collision with root package name */
    private d f14389M = new d();

    /* renamed from: N  reason: collision with root package name */
    private int f14390N = 25000;

    /* renamed from: O  reason: collision with root package name */
    private MBridgeIds f14391O;

    /* renamed from: P  reason: collision with root package name */
    private f f14392P;

    /* renamed from: Q  reason: collision with root package name */
    private com.mbridge.msdk.newreward.function.g.c f14393Q;

    /* renamed from: R  reason: collision with root package name */
    private boolean f14394R = false;

    /* renamed from: S  reason: collision with root package name */
    private boolean f14395S = false;

    /* renamed from: T  reason: collision with root package name */
    private boolean f14396T = false;

    /* renamed from: U  reason: collision with root package name */
    private boolean f14397U = false;

    /* renamed from: V  reason: collision with root package name */
    private boolean f14398V = false;

    /* renamed from: W  reason: collision with root package name */
    private boolean f14399W = false;

    /* renamed from: X  reason: collision with root package name */
    private boolean f14400X = false;

    /* renamed from: Y  reason: collision with root package name */
    private boolean f14401Y = false;

    /* renamed from: Z  reason: collision with root package name */
    private C2206b f14402Z;

    /* renamed from: a  reason: collision with root package name */
    public b f14403a;
    private C2205a aa;
    private C2216b ab;
    private boolean ac;
    private int ad = 0;
    private JSONArray ae = new JSONArray();
    private HandlerThread af;
    private RewardVideoListener ag;

    /* renamed from: b  reason: collision with root package name */
    int f14404b;

    /* renamed from: c  reason: collision with root package name */
    private String f14405c;

    /* renamed from: d  reason: collision with root package name */
    private CampaignEx f14406d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f14407e;

    /* renamed from: f  reason: collision with root package name */
    private int f14408f;

    /* renamed from: g  reason: collision with root package name */
    private int f14409g;

    /* renamed from: h  reason: collision with root package name */
    private int f14410h;

    /* renamed from: i  reason: collision with root package name */
    private int f14411i;

    /* renamed from: j  reason: collision with root package name */
    private int f14412j = com.mbridge.msdk.foundation.same.a.f13108F;

    /* renamed from: k  reason: collision with root package name */
    private int f14413k = 2;

    /* renamed from: l  reason: collision with root package name */
    private int f14414l = MBridgeCommon.DEFAULT_LOAD_TIMEOUT;

    /* renamed from: m  reason: collision with root package name */
    private boolean f14415m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f14416n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f14417o = false;

    /* renamed from: p  reason: collision with root package name */
    private long f14418p;

    /* renamed from: q  reason: collision with root package name */
    private long f14419q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f14420r = false;

    /* renamed from: s  reason: collision with root package name */
    private int f14421s = 0;

    /* renamed from: t  reason: collision with root package name */
    private int f14422t = 0;

    /* renamed from: u  reason: collision with root package name */
    private String f14423u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f14424v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f14425w = false;

    /* renamed from: x  reason: collision with root package name */
    private String f14426x;

    /* renamed from: y  reason: collision with root package name */
    private String f14427y;

    /* renamed from: z  reason: collision with root package name */
    private int f14428z;

    public e(boolean z4, int i4, String str, String str2, boolean z5) {
        this.f14407e = z4;
        this.f14428z = i4;
        this.f14426x = str;
        this.f14427y = str2;
        this.f14416n = z5;
    }

    public final int A() {
        return this.f14404b;
    }

    public final String B() {
        return this.f14377A;
    }

    public final String C() {
        return this.f14378B;
    }

    public final a D() {
        return this.f14385I;
    }

    public final d E() {
        return this.f14389M;
    }

    public final com.mbridge.msdk.newreward.function.e.e F() {
        return this.f14386J;
    }

    public final String G() {
        return this.f14405c;
    }

    public final String H() {
        return this.f14427y;
    }

    public final boolean I() {
        return this.f14407e;
    }

    public final String J() {
        return this.f14426x;
    }

    public final RewardVideoListener K() {
        return this.ag;
    }

    public final int L() {
        return this.f14409g;
    }

    public final int M() {
        if (this.f14407e) {
            return 2;
        }
        return 3;
    }

    public final int N() {
        return this.f14408f;
    }

    public final int O() {
        return this.f14413k;
    }

    public final int P() {
        int i4 = this.f14390N;
        if (i4 <= 0) {
            return 25000;
        }
        return i4;
    }

    public final int Q() {
        return this.f14414l;
    }

    public final boolean R() {
        return this.f14416n;
    }

    public final MBridgeIds S() {
        return this.f14391O;
    }

    public final long T() {
        long j4;
        a aVar = this.f14385I;
        if (aVar != null && aVar.b() != null && this.f14385I.b().p() > 0) {
            return this.f14385I.b().p();
        }
        long currentTimeMillis = System.currentTimeMillis();
        com.mbridge.msdk.videocommon.d.a a5 = this.f14387K.a();
        if (a5 == null) {
            j4 = 3600000;
        } else {
            j4 = a5.f();
        }
        return j4 + currentTimeMillis;
    }

    public final CampaignEx U() {
        return this.f14406d;
    }

    public final String V() {
        CampaignEx campaignEx = this.f14406d;
        if (campaignEx == null) {
            return "";
        }
        return campaignEx.getRequestIdNotice();
    }

    public final f W() {
        return this.f14392P;
    }

    public final boolean X() {
        return this.f14394R;
    }

    public final boolean Y() {
        return this.f14395S;
    }

    public final boolean Z() {
        return this.f14397U;
    }

    public final HandlerThread a() {
        return this.af;
    }

    public final boolean aa() {
        return this.f14398V;
    }

    public final boolean ab() {
        return this.f14399W;
    }

    public final boolean ac() {
        return this.f14400X;
    }

    public final C2206b ad() {
        return this.f14402Z;
    }

    public final C2205a ae() {
        return this.aa;
    }

    public final C2216b af() {
        return this.ab;
    }

    public final boolean ag() {
        return this.f14401Y;
    }

    public final boolean ah() {
        return this.f14396T;
    }

    public final String ai() {
        CampaignEx campaignEx = this.f14406d;
        if (campaignEx == null || campaignEx.getRewardTemplateMode() == null) {
            return "904";
        }
        String e5 = this.f14406d.getRewardTemplateMode().e();
        if (TextUtils.isEmpty(e5)) {
            return "904";
        }
        if (this.f14406d.getAdSpaceT() == 2) {
            return "HALF_TEMPLATE";
        }
        boolean b5 = com.mbridge.msdk.newreward.function.h.c.b(e5);
        String valueOf = String.valueOf(this.f14406d.getRewardTemplateMode().f());
        if (!b5 && this.ac) {
            return "WEB_TEMPLATE";
        }
        return valueOf;
    }

    public final String aj() {
        boolean z4;
        CampaignEx campaignEx = this.f14406d;
        if (campaignEx == null) {
            return "404";
        }
        boolean b5 = com.mbridge.msdk.newreward.function.h.c.b(campaignEx.getendcard_url());
        if (this.f14406d.isMraid() || !b5) {
            z4 = true;
        } else {
            z4 = false;
        }
        long ecTemplateId = this.f14406d.getEcTemplateId();
        if (ecTemplateId == 0) {
            ecTemplateId = 404;
        }
        if (!z4) {
            return String.valueOf(ecTemplateId);
        }
        if (this.ac) {
            return "WEB_EC";
        }
        return String.valueOf(ecTemplateId);
    }

    public final boolean ak() {
        CampaignEx campaignEx = this.f14406d;
        if (campaignEx != null && campaignEx.getPlayable_ads_without_video() == 2) {
            return true;
        }
        return false;
    }

    public final String al() {
        boolean z4;
        CampaignEx campaignEx = this.f14406d;
        if (campaignEx == null) {
            return "ONLY_PLAYABLE";
        }
        boolean z5 = false;
        if (campaignEx.getPlayable_ads_without_video() == 2) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (this.f14406d.getAdSpaceT() == 2) {
            z5 = true;
        }
        if (z4 && z5) {
            return "HALF_END_CARD";
        }
        if (this.ac) {
            return "ONLY_PLAYABLE";
        }
        return "404";
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0063 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int am() {
        /*
            r5 = this;
            r0 = 0
            com.mbridge.msdk.newreward.function.e.a r1 = r5.f14385I     // Catch:{ Exception -> 0x0034 }
            if (r1 == 0) goto L_0x0037
            java.util.List r1 = r1.a()     // Catch:{ Exception -> 0x0034 }
            if (r1 == 0) goto L_0x0037
            com.mbridge.msdk.newreward.function.e.a r1 = r5.f14385I     // Catch:{ Exception -> 0x0034 }
            java.util.List r1 = r1.a()     // Catch:{ Exception -> 0x0034 }
            boolean r1 = r1.isEmpty()     // Catch:{ Exception -> 0x0034 }
            if (r1 != 0) goto L_0x0037
            com.mbridge.msdk.newreward.function.e.a r1 = r5.f14385I     // Catch:{ Exception -> 0x0034 }
            java.util.List r1 = r1.a()     // Catch:{ Exception -> 0x0034 }
            java.lang.Object r1 = r1.get(r0)     // Catch:{ Exception -> 0x0034 }
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = (com.mbridge.msdk.foundation.entity.CampaignEx) r1     // Catch:{ Exception -> 0x0034 }
            if (r1 == 0) goto L_0x0037
            com.mbridge.msdk.foundation.entity.CampaignEx$c r2 = r1.getRewardTemplateMode()     // Catch:{ Exception -> 0x0034 }
            if (r2 == 0) goto L_0x0037
            com.mbridge.msdk.foundation.entity.CampaignEx$c r1 = r1.getRewardTemplateMode()     // Catch:{ Exception -> 0x0034 }
            int r1 = r1.b()     // Catch:{ Exception -> 0x0034 }
            goto L_0x0038
        L_0x0034:
            r1 = move-exception
            r2 = 0
            goto L_0x0053
        L_0x0037:
            r1 = 0
        L_0x0038:
            if (r1 != 0) goto L_0x005b
            com.mbridge.msdk.newreward.function.e.f r2 = r5.f14387K     // Catch:{ Exception -> 0x004f }
            if (r2 == 0) goto L_0x005b
            com.mbridge.msdk.videocommon.d.c r2 = r2.b()     // Catch:{ Exception -> 0x004f }
            if (r2 == 0) goto L_0x005b
            com.mbridge.msdk.newreward.function.e.f r2 = r5.f14387K     // Catch:{ Exception -> 0x004f }
            com.mbridge.msdk.videocommon.d.c r2 = r2.b()     // Catch:{ Exception -> 0x004f }
            int r1 = r2.c()     // Catch:{ Exception -> 0x004f }
            goto L_0x005b
        L_0x004f:
            r2 = move-exception
            r4 = r2
            r2 = r1
            r1 = r4
        L_0x0053:
            boolean r3 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r3 == 0) goto L_0x005a
            r1.printStackTrace()
        L_0x005a:
            r1 = r2
        L_0x005b:
            r2 = 1
            if (r1 == r2) goto L_0x0063
            r2 = 2
            if (r1 == r2) goto L_0x0064
            r0 = -1
            goto L_0x0064
        L_0x0063:
            r0 = 1
        L_0x0064:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.newreward.a.e.am():int");
    }

    public final String b() {
        JSONArray jSONArray = this.ae;
        if (jSONArray == null) {
            return "";
        }
        return jSONArray.toString();
    }

    public final com.mbridge.msdk.newreward.function.g.c c() {
        return this.f14393Q;
    }

    public final boolean d() {
        return this.f14384H;
    }

    public final boolean e() {
        return this.f14383G;
    }

    public final boolean f() {
        return this.f14382F;
    }

    public final long g() {
        return this.f14381E;
    }

    public final int h() {
        return this.f14428z;
    }

    public final String i() {
        return this.f14379C;
    }

    public final boolean j() {
        return this.f14424v;
    }

    public final String k() {
        return this.f14423u;
    }

    public final void l() {
        this.f14421s++;
    }

    public final void m() {
        this.f14422t++;
    }

    public final boolean n() {
        return this.f14420r;
    }

    public final long o() {
        return this.f14419q;
    }

    public final long p() {
        return this.f14418p;
    }

    public final boolean q() {
        return this.f14417o;
    }

    public final boolean r() {
        return this.f14415m;
    }

    public final boolean s() {
        return this.f14425w;
    }

    public final int t() {
        return this.f14409g;
    }

    public final int u() {
        return this.f14410h;
    }

    public final int v() {
        return this.f14411i;
    }

    public final int w() {
        return this.f14412j;
    }

    public final f x() {
        return this.f14387K;
    }

    public final int y() {
        return this.f14380D;
    }

    public final c z() {
        return this.f14388L;
    }

    public final void a(HandlerThread handlerThread) {
        this.af = handlerThread;
    }

    public final void c(boolean z4) {
        this.f14382F = z4;
    }

    public final void d(boolean z4) {
        this.f14424v = z4;
    }

    public final void e(boolean z4) {
        this.f14420r = z4;
    }

    public final void f(boolean z4) {
        this.f14417o = z4;
    }

    public final void g(boolean z4) {
        this.f14415m = z4;
    }

    public final void h(boolean z4) {
        this.f14425w = z4;
    }

    public final void i(boolean z4) {
        this.f14394R = z4;
    }

    public final void j(boolean z4) {
        this.f14395S = z4;
    }

    public final void k(boolean z4) {
        this.f14397U = z4;
    }

    public final void l(boolean z4) {
        this.f14398V = z4;
    }

    public final void m(boolean z4) {
        this.f14399W = z4;
    }

    public final void n(boolean z4) {
        this.f14400X = z4;
    }

    public final void o(boolean z4) {
        this.f14401Y = z4;
    }

    public final void p(boolean z4) {
        this.ac = z4;
    }

    public final void q(boolean z4) {
        this.f14396T = z4;
    }

    public final void a(String str) {
        if (this.ae == null) {
            this.ae = new JSONArray();
        }
        this.ae.put(str);
    }

    public final void c(String str) {
        this.f14423u = str;
    }

    public final void d(int i4) {
        this.f14404b = i4;
    }

    public final void e(String str) {
        this.f14378B = str;
    }

    public final void f(String str) {
        this.f14405c = str;
    }

    public final void g(int i4) {
        this.f14414l = i4;
    }

    public final void b(boolean z4) {
        this.f14383G = z4;
    }

    public final void c(long j4) {
        this.f14418p = j4;
    }

    public final void d(String str) {
        this.f14377A = str;
    }

    public final void e(int i4) {
        this.f14413k = i4;
    }

    public final void f(int i4) {
        this.f14390N = i4;
    }

    public final File g(String str) {
        for (com.mbridge.msdk.newreward.function.c.a.a next : this.f14385I.b().u()) {
            if (next.g().equals(str)) {
                return next.d().g();
            }
        }
        return null;
    }

    public final void b(String str) {
        this.f14379C = str;
    }

    public final void c(int i4) {
        this.f14380D = i4;
    }

    public final void a(com.mbridge.msdk.newreward.function.g.c cVar) {
        this.f14393Q = cVar;
    }

    public final void b(long j4) {
        this.f14419q = j4;
    }

    public final void a(boolean z4) {
        this.f14384H = z4;
    }

    public final void b(int i4) {
        this.f14412j = i4;
    }

    public final void a(long j4) {
        this.f14381E = j4;
    }

    public final void a(int i4) {
        this.f14408f = i4;
    }

    public final void a(f fVar) {
        this.f14387K = fVar;
    }

    public final void a(a aVar) {
        this.f14385I = aVar;
    }

    public final void a(RewardVideoListener rewardVideoListener) {
        this.ag = rewardVideoListener;
    }

    public final void a(MBridgeIds mBridgeIds) {
        this.f14391O = mBridgeIds;
    }

    public final void a(f fVar) {
        this.f14392P = fVar;
    }

    public final void a(CampaignEx campaignEx) {
        this.f14406d = campaignEx;
    }

    public final void a(C2206b bVar) {
        this.f14402Z = bVar;
    }

    public final void a(C2205a aVar) {
        this.aa = aVar;
    }

    public final void a(C2216b bVar) {
        this.ab = bVar;
    }

    public final void a(int i4, int i5, int i6) {
        this.f14409g = i4;
        this.f14410h = i5;
        this.f14411i = i6;
    }
}
