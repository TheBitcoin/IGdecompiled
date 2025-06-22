package com.mbridge.msdk.c;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.davemorrissey.labs.subscaleview.BuildConfig;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.net.e.d;
import com.mbridge.msdk.foundation.tools.f;
import com.mbridge.msdk.foundation.tools.s;
import com.mbridge.msdk.foundation.tools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public static int f11825a = 1500;

    /* renamed from: A  reason: collision with root package name */
    private String f11826A = "";

    /* renamed from: B  reason: collision with root package name */
    private String f11827B = "";

    /* renamed from: C  reason: collision with root package name */
    private String f11828C = "";

    /* renamed from: D  reason: collision with root package name */
    private int f11829D = 120;

    /* renamed from: E  reason: collision with root package name */
    private String f11830E = d.f().f13318h;

    /* renamed from: F  reason: collision with root package name */
    private String f11831F = d.f().f13322l;

    /* renamed from: G  reason: collision with root package name */
    private long f11832G;

    /* renamed from: H  reason: collision with root package name */
    private int f11833H = f11825a;

    /* renamed from: I  reason: collision with root package name */
    private ArrayList<Integer> f11834I;

    /* renamed from: J  reason: collision with root package name */
    private d f11835J;

    /* renamed from: K  reason: collision with root package name */
    private C0173b f11836K;

    /* renamed from: L  reason: collision with root package name */
    private int f11837L = 0;

    /* renamed from: M  reason: collision with root package name */
    private long f11838M = 86400;

    /* renamed from: N  reason: collision with root package name */
    private int f11839N = 0;

    /* renamed from: O  reason: collision with root package name */
    private int f11840O = 3;

    /* renamed from: P  reason: collision with root package name */
    private HashMap<String, String> f11841P;

    /* renamed from: Q  reason: collision with root package name */
    private String f11842Q;

    /* renamed from: R  reason: collision with root package name */
    private boolean f11843R = true;

    /* renamed from: S  reason: collision with root package name */
    private int f11844S = 0;

    /* renamed from: T  reason: collision with root package name */
    private boolean f11845T = false;

    /* renamed from: U  reason: collision with root package name */
    private boolean f11846U = false;

    /* renamed from: V  reason: collision with root package name */
    private int f11847V;

    /* renamed from: W  reason: collision with root package name */
    private int f11848W = 0;

    /* renamed from: X  reason: collision with root package name */
    private int f11849X = 0;

    /* renamed from: Y  reason: collision with root package name */
    private String f11850Y;

    /* renamed from: Z  reason: collision with root package name */
    private Map<String, String> f11851Z;
    private int aA = 3;
    private int aB = 0;
    private int aC = 10;
    private int aD = 600;
    private boolean aE;
    private int aF = 0;
    private JSONArray aG;
    private JSONObject aH;
    private String aI = "";
    private long aJ;
    private int aK = 8000;
    private int aL = 1;
    private long aM = 10;
    private int aN = 3;
    private long aO;
    private boolean aP;
    private int aQ = 1;
    private int aR = 1;
    private int aS = 1;
    private int aT = 1;
    private String aU = "";
    private String aV;
    private int aW = 1300;
    private int aX = 0;
    private int aY = 0;
    private long aZ = 3600;
    private String aa = BuildConfig.VERSION_NAME;
    private int ab = 30;
    private int ac = 9377;
    private int ad = 0;
    private int ae = 5;
    private int af = 1;
    private int ag = 8000;
    private String ah = "";
    private int ai;
    private int aj = 10;
    private int ak = 120;
    private String al;
    private String am;
    private String an = "";
    private String ao = "";
    private int ap;
    private int aq;
    private int ar;
    private int as;
    private String at = "";
    private String au = "";
    private long av;
    private long aw;
    private List<Integer> ax = new ArrayList();
    private int ay = 3;
    private int az = 0;

    /* renamed from: b  reason: collision with root package name */
    private boolean f11852b = false;
    private String ba = "";
    private int bb;
    private String bc;

    /* renamed from: c  reason: collision with root package name */
    private JSONArray f11853c = new JSONArray();

    /* renamed from: d  reason: collision with root package name */
    private JSONArray f11854d = new JSONArray();

    /* renamed from: e  reason: collision with root package name */
    private String f11855e = "";

    /* renamed from: f  reason: collision with root package name */
    private int f11856f = 0;

    /* renamed from: g  reason: collision with root package name */
    private int f11857g = 0;

    /* renamed from: h  reason: collision with root package name */
    private int f11858h = 2;

    /* renamed from: i  reason: collision with root package name */
    private int f11859i = 0;

    /* renamed from: j  reason: collision with root package name */
    private String f11860j = "";

    /* renamed from: k  reason: collision with root package name */
    private String f11861k = "";

    /* renamed from: l  reason: collision with root package name */
    private String f11862l = "";

    /* renamed from: m  reason: collision with root package name */
    private int f11863m;

    /* renamed from: n  reason: collision with root package name */
    private int f11864n = 0;

    /* renamed from: o  reason: collision with root package name */
    private List<com.mbridge.msdk.foundation.entity.a> f11865o;

    /* renamed from: p  reason: collision with root package name */
    private int f11866p = 0;

    /* renamed from: q  reason: collision with root package name */
    private long f11867q;

    /* renamed from: r  reason: collision with root package name */
    private a f11868r;

    /* renamed from: s  reason: collision with root package name */
    private String f11869s;

    /* renamed from: t  reason: collision with root package name */
    private Map<String, a> f11870t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f11871u;

    /* renamed from: v  reason: collision with root package name */
    private int f11872v;

    /* renamed from: w  reason: collision with root package name */
    private int f11873w = 1;

    /* renamed from: x  reason: collision with root package name */
    private boolean f11874x = false;

    /* renamed from: y  reason: collision with root package name */
    private String f11875y = "";

    /* renamed from: z  reason: collision with root package name */
    private String f11876z = "";

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private List<String> f11877a;

        /* renamed from: b  reason: collision with root package name */
        private List<String> f11878b;

        /* renamed from: c  reason: collision with root package name */
        private List<String> f11879c;

        /* renamed from: d  reason: collision with root package name */
        private List<String> f11880d;

        public final List<String> a() {
            return this.f11877a;
        }

        public final List<String> b() {
            return this.f11878b;
        }

        public final List<String> c() {
            return this.f11879c;
        }

        public final List<String> d() {
            return this.f11880d;
        }

        public final void a(JSONObject jSONObject) {
            try {
                JSONArray optJSONArray = jSONObject.optJSONArray("x");
                if (optJSONArray != null) {
                    this.f11879c = s.a(optJSONArray);
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("y");
                if (optJSONArray2 != null) {
                    this.f11880d = s.a(optJSONArray2);
                }
                JSONArray optJSONArray3 = jSONObject.optJSONArray("width");
                if (optJSONArray3 != null) {
                    this.f11878b = s.a(optJSONArray3);
                }
                JSONArray optJSONArray4 = jSONObject.optJSONArray("height");
                if (optJSONArray4 != null) {
                    this.f11877a = s.a(optJSONArray4);
                }
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    e5.printStackTrace();
                }
            }
        }
    }

    private static Map<String, a> e(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            HashMap hashMap = new HashMap();
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                a aVar = new a();
                JSONObject optJSONObject = jSONObject.optJSONObject(next);
                if (optJSONObject != null) {
                    aVar.a(optJSONObject);
                }
                hashMap.put(next, aVar);
            }
            return hashMap;
        } catch (JSONException e5) {
            if (MBridgeConstans.DEBUG) {
                e5.printStackTrace();
            }
            return null;
        } catch (Exception e6) {
            if (MBridgeConstans.DEBUG) {
                e6.printStackTrace();
            }
            return null;
        }
    }

    public final int A() {
        return this.f11829D;
    }

    public final String B() {
        return this.f11830E;
    }

    public final String C() {
        return this.f11831F;
    }

    public final long D() {
        return this.f11832G;
    }

    public final ArrayList<Integer> E() {
        return this.f11834I;
    }

    public final d F() {
        return this.f11835J;
    }

    public final C0173b G() {
        return this.f11836K;
    }

    public final long H() {
        return this.f11838M;
    }

    public final int I() {
        return this.f11840O;
    }

    public final HashMap<String, String> J() {
        return this.f11841P;
    }

    public final int K() {
        return this.f11844S;
    }

    public final int L() {
        return this.f11847V;
    }

    public final int M() {
        return this.f11848W;
    }

    public final JSONArray N() {
        return this.f11853c;
    }

    public final JSONArray O() {
        return this.f11854d;
    }

    public final String P() {
        return this.aa;
    }

    public final int Q() {
        return this.af;
    }

    public final int R() {
        return this.ag;
    }

    public final int S() {
        return this.ai;
    }

    public final int T() {
        return this.ak;
    }

    public final String U() {
        return this.al;
    }

    public final String V() {
        return this.am;
    }

    public final String W() {
        return this.an;
    }

    public final String X() {
        return this.ao;
    }

    public final int Y() {
        return this.ap;
    }

    public final int Z() {
        return this.aq;
    }

    public final int a() {
        return this.bb;
    }

    public final int aA() {
        return this.aW;
    }

    public final int aB() {
        return this.aX;
    }

    public final int aC() {
        return this.aY;
    }

    public final boolean aD() {
        return this.f11843R;
    }

    public final boolean aE() {
        return this.f11871u;
    }

    public final boolean aF() {
        return this.f11874x;
    }

    public final boolean aG() {
        return this.f11845T;
    }

    public final boolean aH() {
        return this.f11852b;
    }

    public final boolean aI() {
        return this.f11846U;
    }

    public final boolean aJ() {
        return this.aE;
    }

    public final boolean aK() {
        return this.aP;
    }

    public final void aL() {
        String language = Locale.getDefault().getLanguage();
        if (TextUtils.isEmpty(this.f11828C) || TextUtils.isEmpty(this.f11826A) || TextUtils.isEmpty(this.f11827B) || TextUtils.isEmpty(this.f11876z)) {
            if (TextUtils.isEmpty(language) || !language.equals("zh")) {
                this.f11828C = "Confirm to close? ";
                this.f11826A = "You will not be rewarded after closing the window";
                this.f11827B = "Close it";
                this.f11876z = "Continue";
            } else {
                this.f11828C = "确认关闭？";
                this.f11826A = "关闭后您将不会获得任何奖励噢~ ";
                this.f11827B = "确认关闭";
                this.f11876z = "继续观看";
            }
        }
        if (!TextUtils.isEmpty(this.f11828C) && !TextUtils.isEmpty(this.f11826A) && !TextUtils.isEmpty(this.f11827B) && !TextUtils.isEmpty(this.f11875y)) {
            return;
        }
        if (TextUtils.isEmpty(language) || !language.equals("zh")) {
            this.f11828C = "Confirm to close? ";
            this.f11826A = "You will not be rewarded after closing the window";
            this.f11827B = "Close it";
            this.f11875y = "Continue";
            return;
        }
        this.f11828C = "确认关闭？";
        this.f11826A = "关闭后您将不会获得任何奖励噢~ ";
        this.f11827B = "确认关闭";
        this.f11875y = "继续试玩";
    }

    public final int aa() {
        return this.ar;
    }

    public final int ab() {
        return this.as;
    }

    public final long ac() {
        return this.av;
    }

    public final long ad() {
        if (this.aw <= 0) {
            this.aw = 7200;
        }
        return this.aw;
    }

    public final int ae() {
        return this.ay;
    }

    public final int af() {
        return this.az;
    }

    public final int ag() {
        return this.aA;
    }

    public final int ah() {
        return this.aB;
    }

    public final int ai() {
        return this.aC;
    }

    public final int aj() {
        return this.aD;
    }

    public final int ak() {
        return this.aF;
    }

    public final JSONArray al() {
        return this.aG;
    }

    public final JSONObject am() {
        return this.aH;
    }

    public final String an() {
        return this.aI;
    }

    public final long ao() {
        return this.aJ;
    }

    public final int ap() {
        return this.aK;
    }

    public final int aq() {
        return this.aL;
    }

    public final long ar() {
        return this.aM * 1000;
    }

    public final int as() {
        return this.aN;
    }

    public final long at() {
        return this.aO;
    }

    public final int au() {
        return this.aQ;
    }

    public final int av() {
        return this.aR;
    }

    public final int aw() {
        return this.aS;
    }

    public final int ax() {
        return this.aT;
    }

    public final String ay() {
        return this.aU;
    }

    public final String az() {
        return this.aV;
    }

    public final String b() {
        return this.ba;
    }

    public final long c() {
        return this.aZ;
    }

    public final String d() {
        return this.f11855e;
    }

    public final int f() {
        return this.f11857g;
    }

    public final int g() {
        return this.f11858h;
    }

    public final int h() {
        return this.f11859i;
    }

    public final String i() {
        return this.f11860j;
    }

    public final String j() {
        return this.f11861k;
    }

    public final String k() {
        return this.f11862l;
    }

    public final int l() {
        return this.f11863m;
    }

    public final int m() {
        return this.f11864n;
    }

    public final List<com.mbridge.msdk.foundation.entity.a> n() {
        return this.f11865o;
    }

    public final int o() {
        return this.f11866p;
    }

    public final long p() {
        return this.f11867q;
    }

    public final a q() {
        return this.f11868r;
    }

    public final String r() {
        return this.f11869s;
    }

    public final Map<String, a> s() {
        return this.f11870t;
    }

    public final int t() {
        return this.f11872v;
    }

    public String toString() {
        return " cfc=" + this.f11872v + " getpf=" + this.f11838M + " rurl=" + this.aE;
    }

    public final int u() {
        return this.f11873w;
    }

    public final String v() {
        return this.f11875y;
    }

    public final String w() {
        return this.f11876z;
    }

    public final String x() {
        return this.f11826A;
    }

    public final String y() {
        return this.f11827B;
    }

    public final String z() {
        return this.f11828C;
    }

    public final void a(int i4) {
        this.bb = i4;
    }

    public final void b(int i4) {
        this.f11856f = i4;
    }

    public final void c(int i4) {
        this.f11857g = i4;
    }

    public final void d(int i4) {
        this.f11858h = i4;
    }

    public final void f(int i4) {
        this.f11863m = i4;
    }

    public final void g(int i4) {
        this.f11864n = i4;
    }

    public final void h(int i4) {
        this.f11866p = i4;
    }

    public final void i(int i4) {
        this.f11872v = i4;
    }

    public final void j(int i4) {
        this.f11873w = i4;
    }

    public final void k(int i4) {
        this.f11829D = i4;
    }

    public final void l(int i4) {
        this.f11840O = i4;
    }

    public final void m(int i4) {
        this.f11844S = i4;
    }

    public final void n(int i4) {
        this.f11847V = i4;
    }

    public final void o(int i4) {
        this.f11848W = i4;
    }

    public final void p(int i4) {
        if (i4 > 0) {
            this.aj = i4;
        }
    }

    public final void q(int i4) {
        this.ai = i4;
    }

    public final void r(int i4) {
        this.ak = i4;
    }

    public final void s(int i4) {
        this.aF = i4;
    }

    public final void t(int i4) {
        this.aL = i4;
    }

    public final void u(int i4) {
        this.aN = i4;
    }

    public final void v(int i4) {
        this.aQ = i4;
    }

    public final void w(int i4) {
        this.aR = i4;
    }

    public final void x(int i4) {
        this.aS = i4;
    }

    public final void y(int i4) {
        this.aT = i4;
    }

    public final boolean z(int i4) {
        return this.ax.contains(Integer.valueOf(i4));
    }

    public final void a(long j4) {
        this.aZ = j4;
    }

    public final void b(long j4) {
        this.f11867q = j4;
    }

    public final void c(String str) {
        this.an = str;
    }

    public final void d(String str) {
        this.ao = str;
    }

    public final void f(long j4) {
        this.aM = j4;
    }

    public static String a(Context context, String str) {
        try {
            g b5 = h.a().b(c.m().k());
            if (b5 == null) {
                return "";
            }
            if (b5.f11851Z == null) {
                return "";
            }
            String host = Uri.parse(str).getHost();
            for (Map.Entry<String, String> key : b5.f11851Z.entrySet()) {
                String str2 = (String) key.getKey();
                if (!TextUtils.isEmpty(host) && host.contains(str2)) {
                    String str3 = b5.f11851Z.get(str2);
                    if (TextUtils.isEmpty(str3)) {
                        return "";
                    }
                    return str3.replace("{gaid}", f.c());
                }
            }
            return "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public final void b(String str) {
        this.am = str;
    }

    public final void c(long j4) {
        this.av = j4;
    }

    public final void d(long j4) {
        this.aw = j4;
    }

    public final void f(boolean z4) {
        this.aP = z4;
    }

    public final void b(boolean z4) {
        this.f11874x = z4;
    }

    public final void c(boolean z4) {
        this.f11845T = z4;
    }

    public final void d(boolean z4) {
        this.f11852b = z4;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v7, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v13, resolved type: int} */
    /* JADX WARNING: type inference failed for: r16v16 */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:212|(3:216|217|218)|220|221|(3:225|226|227)) */
    /* JADX WARNING: Code restructure failed: missing block: B:180:?, code lost:
        r9.f11874x = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:200:?, code lost:
        r9.f11845T = true;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Missing exception handler attribute for start block: B:179:0x0565 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:190:0x059f */
    /* JADX WARNING: Missing exception handler attribute for start block: B:199:0x05af */
    /* JADX WARNING: Missing exception handler attribute for start block: B:220:0x0607 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0382 A[Catch:{ Exception -> 0x024f }] */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x03de A[Catch:{ Exception -> 0x0460 }] */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x03f2 A[Catch:{ Exception -> 0x0460 }] */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x0486 A[Catch:{ Exception -> 0x049b }] */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x0488 A[Catch:{ Exception -> 0x049b }] */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x0491 A[Catch:{ Exception -> 0x049b }] */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x0493 A[Catch:{ Exception -> 0x049b }] */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x04db A[Catch:{ Exception -> 0x053f }] */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x04e1 A[Catch:{ Exception -> 0x053f }] */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x04e7 A[Catch:{ Exception -> 0x053f }] */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x04ed A[Catch:{ Exception -> 0x053f }] */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x04f9 A[Catch:{ Exception -> 0x053f }] */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x055f A[Catch:{ Exception -> 0x0565 }] */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x0561 A[Catch:{ Exception -> 0x0565 }] */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x0575 A[Catch:{ Exception -> 0x024f }] */
    /* JADX WARNING: Removed duplicated region for block: B:196:0x05a9 A[Catch:{ Exception -> 0x05af }] */
    /* JADX WARNING: Removed duplicated region for block: B:197:0x05ab A[Catch:{ Exception -> 0x05af }] */
    /* JADX WARNING: Removed duplicated region for block: B:209:0x05d4 A[SYNTHETIC, Splitter:B:209:0x05d4] */
    /* JADX WARNING: Removed duplicated region for block: B:231:0x0637 A[SYNTHETIC, Splitter:B:231:0x0637] */
    /* JADX WARNING: Removed duplicated region for block: B:257:0x06c6 A[Catch:{ Exception -> 0x024f }] */
    /* JADX WARNING: Removed duplicated region for block: B:260:0x06dc A[Catch:{ Exception -> 0x024f }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0243 A[Catch:{ Exception -> 0x024f }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0269 A[Catch:{ Exception -> 0x024f }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x026e A[Catch:{ Exception -> 0x024f }] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x02ea A[Catch:{ Exception -> 0x024f }] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0300 A[Catch:{ Exception -> 0x024f }] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0315 A[SYNTHETIC, Splitter:B:78:0x0315] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.mbridge.msdk.c.g a(org.json.JSONObject r20) {
        /*
            r1 = r20
            java.lang.String r2 = "omsdkjs_h5_url"
            java.lang.String r3 = "omsdkjs_url"
            java.lang.String r0 = "plctb"
            java.lang.String r4 = "pcrn"
            java.lang.String r5 = "plct"
            java.lang.String r6 = "H+tU+FeXHM=="
            java.lang.String r7 = ""
            if (r1 == 0) goto L_0x06ee
            com.mbridge.msdk.c.g r9 = new com.mbridge.msdk.c.g     // Catch:{ Exception -> 0x06e8 }
            r9.<init>()     // Catch:{ Exception -> 0x06e8 }
            r9.aH = r1     // Catch:{ Exception -> 0x024f }
            java.lang.String r10 = "cc"
            java.lang.String r10 = r1.optString(r10)     // Catch:{ Exception -> 0x024f }
            r9.f11869s = r10     // Catch:{ Exception -> 0x024f }
            java.lang.String r10 = "mv_wildcard"
            java.lang.String r11 = "<mvpackage>mbridge</mvpackage>"
            java.lang.String r10 = r1.optString(r10, r11)     // Catch:{ Exception -> 0x024f }
            r9.am = r10     // Catch:{ Exception -> 0x024f }
            java.lang.String r10 = "cfc"
            int r10 = r1.optInt(r10)     // Catch:{ Exception -> 0x024f }
            r9.f11872v = r10     // Catch:{ Exception -> 0x024f }
            java.lang.String r10 = "getpf"
            long r10 = r1.optLong(r10)     // Catch:{ Exception -> 0x024f }
            r9.f11838M = r10     // Catch:{ Exception -> 0x024f }
            java.lang.String r10 = "current_time"
            long r10 = r1.optLong(r10)     // Catch:{ Exception -> 0x024f }
            r9.f11832G = r10     // Catch:{ Exception -> 0x024f }
            java.lang.String r10 = "cfb"
            boolean r10 = r1.optBoolean(r10)     // Catch:{ Exception -> 0x024f }
            r9.f11871u = r10     // Catch:{ Exception -> 0x024f }
            java.lang.String r10 = "awct"
            long r10 = r1.optLong(r10)     // Catch:{ Exception -> 0x024f }
            r9.f11867q = r10     // Catch:{ Exception -> 0x024f }
            long r10 = r1.optLong(r5)     // Catch:{ Exception -> 0x024f }
            r14 = 0
            int r16 = (r10 > r14 ? 1 : (r10 == r14 ? 0 : -1))
            if (r16 != 0) goto L_0x0060
            r10 = 3600(0xe10, double:1.7786E-320)
            goto L_0x0064
        L_0x0060:
            long r10 = r1.optLong(r5)     // Catch:{ Exception -> 0x024f }
        L_0x0064:
            r9.av = r10     // Catch:{ Exception -> 0x024f }
            java.lang.String r5 = "rurl"
            boolean r5 = r1.optBoolean(r5)     // Catch:{ Exception -> 0x024f }
            r9.aE = r5     // Catch:{ Exception -> 0x024f }
            java.lang.String r5 = "uct"
            long r10 = r1.optLong(r5)     // Catch:{ Exception -> 0x024f }
            r9.aO = r10     // Catch:{ Exception -> 0x024f }
            java.lang.String r5 = "ujds"
            boolean r5 = r1.optBoolean(r5)     // Catch:{ Exception -> 0x024f }
            r9.aP = r5     // Catch:{ Exception -> 0x024f }
            java.lang.String r5 = "n2"
            int r5 = r1.optInt(r5)     // Catch:{ Exception -> 0x024f }
            r9.ar = r5     // Catch:{ Exception -> 0x024f }
            java.lang.String r5 = "n3"
            int r5 = r1.optInt(r5)     // Catch:{ Exception -> 0x024f }
            r9.as = r5     // Catch:{ Exception -> 0x024f }
            java.lang.String r5 = "is_startup_crashsystem"
            r10 = 1
            int r5 = r1.optInt(r5, r10)     // Catch:{ Exception -> 0x024f }
            r9.f11847V = r5     // Catch:{ Exception -> 0x024f }
            int r5 = r1.optInt(r4)     // Catch:{ Exception -> 0x024f }
            r9.aq = r5     // Catch:{ Exception -> 0x024f }
            long r16 = r1.optLong(r0)     // Catch:{ Exception -> 0x024f }
            int r5 = (r16 > r14 ? 1 : (r16 == r14 ? 0 : -1))
            if (r5 != 0) goto L_0x00ac
            r16 = 7200(0x1c20, double:3.5573E-320)
        L_0x00a7:
            r18 = r14
            r14 = r16
            goto L_0x00b1
        L_0x00ac:
            long r16 = r1.optLong(r0)     // Catch:{ Exception -> 0x024f }
            goto L_0x00a7
        L_0x00b1:
            r9.aw = r14     // Catch:{ Exception -> 0x024f }
            r0 = 100
            int r0 = r1.optInt(r4, r0)     // Catch:{ Exception -> 0x024f }
            r9.aq = r0     // Catch:{ Exception -> 0x024f }
            java.lang.String r0 = "opent"
            int r0 = r1.optInt(r0, r10)     // Catch:{ Exception -> 0x024f }
            r9.ap = r0     // Catch:{ Exception -> 0x024f }
            java.lang.String r0 = "sfct"
            r4 = 1800(0x708, double:8.893E-321)
            long r4 = r1.optLong(r0, r4)     // Catch:{ Exception -> 0x024f }
            r9.aJ = r4     // Catch:{ Exception -> 0x024f }
            java.lang.String r0 = "upgd"
            int r0 = r1.optInt(r0, r10)     // Catch:{ Exception -> 0x024f }
            r9.aS = r0     // Catch:{ Exception -> 0x024f }
            java.lang.String r0 = "upsrl"
            int r0 = r1.optInt(r0, r10)     // Catch:{ Exception -> 0x024f }
            r9.aT = r0     // Catch:{ Exception -> 0x024f }
            java.lang.String r0 = "updevid"
            int r0 = r1.optInt(r0, r10)     // Catch:{ Exception -> 0x024f }
            r9.aR = r0     // Catch:{ Exception -> 0x024f }
            java.lang.String r0 = "sc"
            r4 = 0
            int r0 = r1.optInt(r0, r4)     // Catch:{ Exception -> 0x024f }
            r9.aF = r0     // Catch:{ Exception -> 0x024f }
            java.lang.String r0 = "up_tips"
            int r0 = r1.optInt(r0, r10)     // Catch:{ Exception -> 0x024f }
            r9.aQ = r0     // Catch:{ Exception -> 0x024f }
            java.lang.String r0 = "iseu"
            r5 = -1
            int r0 = r1.optInt(r0, r5)     // Catch:{ Exception -> 0x024f }
            r9.f11848W = r0     // Catch:{ Exception -> 0x024f }
            java.lang.String r0 = "jm_unit"
            java.lang.String r0 = r1.optString(r0)     // Catch:{ Exception -> 0x024f }
            r9.f11850Y = r0     // Catch:{ Exception -> 0x024f }
            java.lang.String r0 = "atf"
            org.json.JSONArray r0 = r1.optJSONArray(r0)     // Catch:{ Exception -> 0x014f }
            if (r0 == 0) goto L_0x0156
            int r11 = r0.length()     // Catch:{ Exception -> 0x014f }
            if (r11 <= 0) goto L_0x0156
            java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ Exception -> 0x014f }
            r11.<init>()     // Catch:{ Exception -> 0x014f }
            r14 = 0
        L_0x011b:
            int r15 = r0.length()     // Catch:{ Exception -> 0x014f }
            if (r14 >= r15) goto L_0x0153
            java.lang.String r15 = r0.optString(r14)     // Catch:{ Exception -> 0x014f }
            boolean r16 = com.mbridge.msdk.foundation.tools.ap.b(r15)     // Catch:{ Exception -> 0x014f }
            if (r16 == 0) goto L_0x0149
            r16 = -1
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ Exception -> 0x0147 }
            r5.<init>(r15)     // Catch:{ Exception -> 0x0147 }
            com.mbridge.msdk.foundation.entity.a r15 = new com.mbridge.msdk.foundation.entity.a     // Catch:{ Exception -> 0x0147 }
            java.lang.String r8 = "adtype"
            int r8 = r5.optInt(r8)     // Catch:{ Exception -> 0x0147 }
            java.lang.String r12 = "unitid"
            java.lang.String r5 = r5.optString(r12)     // Catch:{ Exception -> 0x0147 }
            r15.<init>(r8, r5)     // Catch:{ Exception -> 0x0147 }
            r11.add(r15)     // Catch:{ Exception -> 0x0147 }
            goto L_0x014b
        L_0x0147:
            r0 = move-exception
            goto L_0x015e
        L_0x0149:
            r16 = -1
        L_0x014b:
            int r14 = r14 + 1
            r5 = -1
            goto L_0x011b
        L_0x014f:
            r0 = move-exception
            r16 = -1
            goto L_0x015e
        L_0x0153:
            r16 = -1
            goto L_0x0159
        L_0x0156:
            r16 = -1
            r11 = 0
        L_0x0159:
            if (r11 == 0) goto L_0x0161
            r9.f11865o = r11     // Catch:{ Exception -> 0x0147 }
            goto L_0x0161
        L_0x015e:
            r0.printStackTrace()     // Catch:{ Exception -> 0x024f }
        L_0x0161:
            java.lang.String r0 = "adct"
            r5 = 259200(0x3f480, float:3.63217E-40)
            int r0 = r1.optInt(r0, r5)     // Catch:{ Exception -> 0x024f }
            r9.f11863m = r0     // Catch:{ Exception -> 0x024f }
            java.lang.String r0 = "confirm_title"
            java.lang.String r0 = r1.optString(r0, r7)     // Catch:{ Exception -> 0x024f }
            r9.f11828C = r0     // Catch:{ Exception -> 0x024f }
            java.lang.String r0 = "confirm_description"
            java.lang.String r0 = r1.optString(r0, r7)     // Catch:{ Exception -> 0x024f }
            r9.f11826A = r0     // Catch:{ Exception -> 0x024f }
            java.lang.String r0 = "confirm_t"
            java.lang.String r0 = r1.optString(r0, r7)     // Catch:{ Exception -> 0x024f }
            r9.f11827B = r0     // Catch:{ Exception -> 0x024f }
            java.lang.String r0 = "confirm_c_rv"
            java.lang.String r0 = r1.optString(r0, r7)     // Catch:{ Exception -> 0x024f }
            r9.f11876z = r0     // Catch:{ Exception -> 0x024f }
            java.lang.String r0 = "confirm_c_play"
            java.lang.String r0 = r1.optString(r0, r7)     // Catch:{ Exception -> 0x024f }
            r9.f11875y = r0     // Catch:{ Exception -> 0x024f }
            java.lang.String r0 = "adchoice_icon"
            java.lang.String r0 = r1.optString(r0, r7)     // Catch:{ Exception -> 0x024f }
            r9.f11860j = r0     // Catch:{ Exception -> 0x024f }
            java.lang.String r0 = "adchoice_link"
            java.lang.String r0 = r1.optString(r0, r7)     // Catch:{ Exception -> 0x024f }
            r9.f11861k = r0     // Catch:{ Exception -> 0x024f }
            java.lang.String r0 = "adchoice_size"
            java.lang.String r0 = r1.optString(r0, r7)     // Catch:{ Exception -> 0x024f }
            r9.f11862l = r0     // Catch:{ Exception -> 0x024f }
            java.lang.String r0 = "platform_logo"
            java.lang.String r0 = r1.optString(r0, r7)     // Catch:{ Exception -> 0x024f }
            r9.at = r0     // Catch:{ Exception -> 0x024f }
            java.lang.String r0 = "platform_name"
            java.lang.String r0 = r1.optString(r0, r7)     // Catch:{ Exception -> 0x024f }
            r9.au = r0     // Catch:{ Exception -> 0x024f }
            java.lang.String r0 = "cdnate_cfg"
            java.lang.String r0 = r1.optString(r0, r7)     // Catch:{ Exception -> 0x024f }
            java.util.Map r0 = e((java.lang.String) r0)     // Catch:{ Exception -> 0x024f }
            r9.f11870t = r0     // Catch:{ Exception -> 0x024f }
            java.lang.String r0 = "atrqt"
            int r0 = r1.optInt(r0, r4)     // Catch:{ Exception -> 0x024f }
            r9.f11866p = r0     // Catch:{ Exception -> 0x024f }
            java.lang.String r0 = "iupdid"
            int r0 = r1.optInt(r0, r4)     // Catch:{ Exception -> 0x024f }
            r9.f11849X = r0     // Catch:{ Exception -> 0x024f }
            java.lang.String r0 = "mcs"
            r5 = 120(0x78, float:1.68E-43)
            int r0 = r1.optInt(r0, r5)     // Catch:{ Exception -> 0x024f }
            r9.ak = r0     // Catch:{ Exception -> 0x024f }
            java.lang.String r0 = "ab_id"
            java.lang.String r0 = r1.optString(r0, r7)     // Catch:{ Exception -> 0x024f }
            r9.f11855e = r0     // Catch:{ Exception -> 0x024f }
            java.lang.String r0 = "rid"
            java.lang.String r0 = r1.optString(r0, r7)     // Catch:{ Exception -> 0x024f }
            r9.aI = r0     // Catch:{ Exception -> 0x024f }
            java.lang.String r0 = "log_rate"
            java.lang.String r8 = "-1"
            java.lang.String r0 = r1.optString(r0, r8)     // Catch:{ Exception -> 0x024f }
            r9.aa = r0     // Catch:{ Exception -> 0x024f }
            java.lang.String r0 = r1.optString(r3, r7)     // Catch:{ Exception -> 0x024f }
            r9.ao = r0     // Catch:{ Exception -> 0x024f }
            java.lang.String r0 = r1.optString(r2, r7)     // Catch:{ Exception -> 0x024f }
            r9.an = r0     // Catch:{ Exception -> 0x024f }
            java.lang.String r0 = "rty_tk_clk"
            int r0 = r1.optInt(r0, r4)     // Catch:{ Exception -> 0x024f }
            r9.az = r0     // Catch:{ Exception -> 0x024f }
            java.lang.String r0 = "rty_tk_imp"
            int r0 = r1.optInt(r0, r4)     // Catch:{ Exception -> 0x024f }
            r9.aB = r0     // Catch:{ Exception -> 0x024f }
            java.lang.String r0 = "rty_cnt"
            r8 = 3
            int r0 = r1.optInt(r0, r8)     // Catch:{ Exception -> 0x024f }
            r9.aA = r0     // Catch:{ Exception -> 0x024f }
            java.lang.String r0 = "rty_to"
            r11 = 600(0x258, float:8.41E-43)
            int r0 = r1.optInt(r0, r11)     // Catch:{ Exception -> 0x024f }
            r9.aD = r0     // Catch:{ Exception -> 0x024f }
            java.lang.String r0 = "rty_inr"
            r11 = 10
            int r0 = r1.optInt(r0, r11)     // Catch:{ Exception -> 0x024f }
            r9.aC = r0     // Catch:{ Exception -> 0x024f }
            java.lang.String r0 = "dns"
            java.lang.String r0 = r1.optString(r0)     // Catch:{ Exception -> 0x024f }
            r9.bc = r0     // Catch:{ Exception -> 0x024f }
            boolean r12 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x024f }
            if (r12 != 0) goto L_0x0253
            com.mbridge.msdk.c.e r12 = com.mbridge.msdk.c.e.a.f11953a     // Catch:{ Exception -> 0x024f }
            java.lang.String r0 = com.mbridge.msdk.foundation.tools.z.a(r0)     // Catch:{ Exception -> 0x024f }
            r12.b(r0)     // Catch:{ Exception -> 0x024f }
            goto L_0x0253
        L_0x024f:
            r0 = move-exception
            r8 = r9
            goto L_0x06ea
        L_0x0253:
            java.lang.String r0 = r1.optString(r3, r7)     // Catch:{ Exception -> 0x024f }
            r9.ao = r0     // Catch:{ Exception -> 0x024f }
            java.lang.String r0 = r1.optString(r2, r7)     // Catch:{ Exception -> 0x024f }
            r9.an = r0     // Catch:{ Exception -> 0x024f }
            java.lang.String r0 = "tcto"
            long r2 = r1.optLong(r0)     // Catch:{ Exception -> 0x024f }
            int r0 = (r2 > r18 ? 1 : (r2 == r18 ? 0 : -1))
            if (r0 != 0) goto L_0x026e
            r2 = 10
            r9.aM = r2     // Catch:{ Exception -> 0x024f }
            goto L_0x02a2
        L_0x026e:
            r9.aM = r2     // Catch:{ Exception -> 0x024f }
            java.lang.String r0 = "jt"
            org.json.JSONArray r0 = r1.optJSONArray(r0)     // Catch:{ Exception -> 0x024f }
            if (r0 == 0) goto L_0x02a2
            int r2 = r0.length()     // Catch:{ Exception -> 0x024f }
            if (r2 <= 0) goto L_0x02a2
            java.util.HashMap r2 = new java.util.HashMap     // Catch:{ Exception -> 0x024f }
            r2.<init>()     // Catch:{ Exception -> 0x024f }
            r3 = 0
        L_0x0284:
            int r12 = r0.length()     // Catch:{ Exception -> 0x024f }
            if (r3 >= r12) goto L_0x02a0
            org.json.JSONObject r12 = r0.optJSONObject(r3)     // Catch:{ Exception -> 0x024f }
            java.lang.String r13 = "domain"
            java.lang.String r13 = r12.optString(r13)     // Catch:{ Exception -> 0x024f }
            java.lang.String r14 = "format"
            java.lang.String r12 = r12.optString(r14)     // Catch:{ Exception -> 0x024f }
            r2.put(r13, r12)     // Catch:{ Exception -> 0x024f }
            int r3 = r3 + 1
            goto L_0x0284
        L_0x02a0:
            r9.f11851Z = r2     // Catch:{ Exception -> 0x024f }
        L_0x02a2:
            java.lang.String r0 = "mraid_js"
            java.lang.String r0 = r1.optString(r0)     // Catch:{ Exception -> 0x024f }
            r9.al = r0     // Catch:{ Exception -> 0x024f }
            java.lang.String r0 = "web_env_url"
            java.lang.String r0 = r1.optString(r0)     // Catch:{ Exception -> 0x024f }
            r9.aV = r0     // Catch:{ Exception -> 0x024f }
            java.lang.String r0 = "alrbs"
            int r0 = r1.optInt(r0, r4)     // Catch:{ Exception -> 0x024f }
            r2 = 2
            if (r0 > r2) goto L_0x02bd
            if (r0 >= 0) goto L_0x02be
        L_0x02bd:
            r0 = 0
        L_0x02be:
            r9.f11864n = r0     // Catch:{ Exception -> 0x024f }
            java.lang.String r0 = "GDPR_area"
            boolean r0 = r1.optBoolean(r0, r4)     // Catch:{ Exception -> 0x024f }
            r9.f11852b = r0     // Catch:{ Exception -> 0x024f }
            java.lang.String r0 = "ct"
            int r0 = r1.optInt(r0, r5)     // Catch:{ Exception -> 0x024f }
            r9.f11829D = r0     // Catch:{ Exception -> 0x024f }
            java.lang.String r0 = "ercd"
            org.json.JSONArray r0 = r1.optJSONArray(r0)     // Catch:{ Exception -> 0x024f }
            if (r0 == 0) goto L_0x0309
            int r2 = r0.length()     // Catch:{ Exception -> 0x024f }
            if (r2 <= 0) goto L_0x0309
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ Exception -> 0x024f }
            r2.<init>()     // Catch:{ Exception -> 0x024f }
            r3 = 0
        L_0x02e4:
            int r5 = r0.length()     // Catch:{ Exception -> 0x024f }
            if (r3 >= r5) goto L_0x02fa
            int r5 = r0.optInt(r3)     // Catch:{ Exception -> 0x024f }
            if (r5 == 0) goto L_0x02f7
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x024f }
            r2.add(r5)     // Catch:{ Exception -> 0x024f }
        L_0x02f7:
            int r3 = r3 + 1
            goto L_0x02e4
        L_0x02fa:
            int r0 = r2.size()     // Catch:{ Exception -> 0x024f }
            if (r0 <= 0) goto L_0x0309
            java.lang.Integer r0 = java.lang.Integer.valueOf(r16)     // Catch:{ Exception -> 0x024f }
            r2.add(r0)     // Catch:{ Exception -> 0x024f }
            r9.f11834I = r2     // Catch:{ Exception -> 0x024f }
        L_0x0309:
            java.lang.String r0 = "hst"
            java.lang.String r0 = r1.optString(r0)     // Catch:{ Exception -> 0x024f }
            boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x024f }
            if (r2 != 0) goto L_0x036d
            java.lang.String r0 = com.mbridge.msdk.foundation.tools.z.a(r0)     // Catch:{ Exception -> 0x0359 }
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x0359 }
            r2.<init>(r0)     // Catch:{ Exception -> 0x0359 }
            java.util.Iterator r0 = r2.keys()     // Catch:{ Exception -> 0x0359 }
            java.util.HashMap r3 = new java.util.HashMap     // Catch:{ Exception -> 0x0359 }
            r3.<init>()     // Catch:{ Exception -> 0x0359 }
        L_0x0327:
            boolean r5 = r0.hasNext()     // Catch:{ Exception -> 0x0359 }
            if (r5 == 0) goto L_0x035b
            java.lang.Object r5 = r0.next()     // Catch:{ Exception -> 0x0359 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x0359 }
            boolean r12 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x0359 }
            if (r12 != 0) goto L_0x0327
            java.lang.String r12 = r2.optString(r5)     // Catch:{ Exception -> 0x0359 }
            boolean r12 = android.text.TextUtils.isEmpty(r12)     // Catch:{ Exception -> 0x0359 }
            if (r12 != 0) goto L_0x0327
            java.lang.String r12 = r2.optString(r5)     // Catch:{ Exception -> 0x0359 }
            java.lang.String r12 = com.mbridge.msdk.foundation.tools.z.a(r12)     // Catch:{ Exception -> 0x0359 }
            boolean r12 = android.text.TextUtils.isEmpty(r12)     // Catch:{ Exception -> 0x0359 }
            if (r12 != 0) goto L_0x0327
            java.lang.String r12 = r2.optString(r5)     // Catch:{ Exception -> 0x0359 }
            r3.put(r5, r12)     // Catch:{ Exception -> 0x0359 }
            goto L_0x0327
        L_0x0359:
            r0 = move-exception
            goto L_0x0364
        L_0x035b:
            int r0 = r3.size()     // Catch:{ Exception -> 0x0359 }
            if (r0 <= 0) goto L_0x036d
            r9.f11841P = r3     // Catch:{ Exception -> 0x0359 }
            goto L_0x036d
        L_0x0364:
            java.lang.String r2 = "SETTING"
            java.lang.String r0 = r0.getMessage()     // Catch:{ Exception -> 0x024f }
            com.mbridge.msdk.foundation.tools.af.b(r2, r0)     // Catch:{ Exception -> 0x024f }
        L_0x036d:
            java.lang.String r0 = "refactor_switch"
            org.json.JSONArray r0 = r1.optJSONArray(r0)     // Catch:{ Exception -> 0x024f }
            if (r0 == 0) goto L_0x03b3
            int r2 = r0.length()     // Catch:{ Exception -> 0x024f }
            if (r2 <= 0) goto L_0x03b3
            r2 = 0
        L_0x037c:
            int r3 = r0.length()     // Catch:{ Exception -> 0x024f }
            if (r2 >= r3) goto L_0x03b3
            org.json.JSONObject r3 = r0.getJSONObject(r2)     // Catch:{ Exception -> 0x024f }
            java.util.Iterator r5 = r3.keys()     // Catch:{ Exception -> 0x024f }
        L_0x038a:
            boolean r12 = r5.hasNext()     // Catch:{ Exception -> 0x024f }
            if (r12 == 0) goto L_0x03b0
            java.lang.Object r12 = r5.next()     // Catch:{ Exception -> 0x024f }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ Exception -> 0x024f }
            boolean r13 = android.text.TextUtils.isEmpty(r12)     // Catch:{ Exception -> 0x024f }
            if (r13 != 0) goto L_0x038a
            boolean r13 = r3.getBoolean(r12)     // Catch:{ Exception -> 0x024f }
            if (r13 == 0) goto L_0x038a
            int r12 = java.lang.Integer.parseInt(r12)     // Catch:{ Exception -> 0x024f }
            java.util.List<java.lang.Integer> r13 = r9.ax     // Catch:{ Exception -> 0x024f }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ Exception -> 0x024f }
            r13.add(r12)     // Catch:{ Exception -> 0x024f }
            goto L_0x038a
        L_0x03b0:
            int r2 = r2 + 1
            goto L_0x037c
        L_0x03b3:
            java.lang.String r0 = "lqcnt"
            r2 = 30
            int r0 = r1.optInt(r0, r2)     // Catch:{ Exception -> 0x0460 }
            java.lang.String r2 = "lqto"
            r3 = 5
            int r2 = r1.optInt(r2, r3)     // Catch:{ Exception -> 0x0460 }
            java.lang.String r3 = "lqswt"
            int r3 = r1.optInt(r3, r4)     // Catch:{ Exception -> 0x0460 }
            java.lang.String r5 = "lqtype"
            int r5 = r1.optInt(r5, r10)     // Catch:{ Exception -> 0x0460 }
            r9.ae = r2     // Catch:{ Exception -> 0x0460 }
            r9.ab = r0     // Catch:{ Exception -> 0x0460 }
            r9.ad = r3     // Catch:{ Exception -> 0x0460 }
            r9.af = r5     // Catch:{ Exception -> 0x0460 }
            java.lang.String r0 = "lg_bl"
            org.json.JSONArray r0 = r1.optJSONArray(r0)     // Catch:{ Exception -> 0x0460 }
            if (r0 != 0) goto L_0x03e8
            org.json.JSONArray r0 = new org.json.JSONArray     // Catch:{ Exception -> 0x0460 }
            r0.<init>()     // Catch:{ Exception -> 0x0460 }
            java.lang.String r2 = "2000088"
            r0.put(r2)     // Catch:{ Exception -> 0x0460 }
        L_0x03e8:
            r9.f11853c = r0     // Catch:{ Exception -> 0x0460 }
            java.lang.String r0 = "lg_wl"
            org.json.JSONArray r0 = r1.optJSONArray(r0)     // Catch:{ Exception -> 0x0460 }
            if (r0 != 0) goto L_0x040b
            org.json.JSONArray r0 = new org.json.JSONArray     // Catch:{ Exception -> 0x0460 }
            r0.<init>()     // Catch:{ Exception -> 0x0460 }
            java.lang.String r2 = "2000041"
            r0.put(r2)     // Catch:{ Exception -> 0x0460 }
            java.lang.String r2 = "2000042"
            r0.put(r2)     // Catch:{ Exception -> 0x0460 }
            java.lang.String r2 = "2000032"
            r0.put(r2)     // Catch:{ Exception -> 0x0460 }
            java.lang.String r2 = "2000079"
            r0.put(r2)     // Catch:{ Exception -> 0x0460 }
        L_0x040b:
            r9.f11854d = r0     // Catch:{ Exception -> 0x0460 }
            java.lang.String r0 = "lg_wl_rt"
            int r0 = r1.optInt(r0)     // Catch:{ Exception -> 0x0460 }
            r9.aX = r0     // Catch:{ Exception -> 0x0460 }
            java.lang.String r0 = "srml"
            r2 = 8000(0x1f40, float:1.121E-41)
            int r0 = r1.optInt(r0, r2)     // Catch:{ Exception -> 0x0460 }
            r9.aK = r0     // Catch:{ Exception -> 0x0460 }
            java.lang.String r0 = "lrml"
            int r0 = r1.optInt(r0, r2)     // Catch:{ Exception -> 0x0460 }
            r9.ag = r0     // Catch:{ Exception -> 0x0460 }
            java.lang.String r0 = "wgl_d_ms"
            r2 = 1300(0x514, float:1.822E-42)
            int r0 = r1.optInt(r0, r2)     // Catch:{ Exception -> 0x0460 }
            r9.aW = r0     // Catch:{ Exception -> 0x0460 }
            java.lang.String r0 = "dp_ct"
            int r2 = f11825a     // Catch:{ Exception -> 0x0460 }
            int r0 = r1.optInt(r0, r2)     // Catch:{ Exception -> 0x0460 }
            r9.f11833H = r0     // Catch:{ Exception -> 0x0460 }
            com.mbridge.msdk.click.b.a.f12045c = r0     // Catch:{ Exception -> 0x0460 }
            java.lang.String r0 = "lqpt"
            java.lang.String r0 = r1.optString(r0)     // Catch:{ Exception -> 0x0460 }
            java.lang.String r0 = com.mbridge.msdk.foundation.tools.z.a(r0)     // Catch:{ Exception -> 0x0460 }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ Exception -> 0x0460 }
            if (r0 <= 0) goto L_0x0460
            r2 = 65535(0xffff, float:9.1834E-41)
            if (r0 >= r2) goto L_0x0460
            r9.ac = r0     // Catch:{ Exception -> 0x0460 }
            com.mbridge.msdk.foundation.same.net.e.d r2 = com.mbridge.msdk.foundation.same.net.e.d.f()     // Catch:{ Exception -> 0x0460 }
            r2.f13323m = r0     // Catch:{ Exception -> 0x0460 }
            com.mbridge.msdk.foundation.same.net.e.d r2 = com.mbridge.msdk.foundation.same.net.e.d.f()     // Catch:{ Exception -> 0x0460 }
            r2.f13326p = r0     // Catch:{ Exception -> 0x0460 }
        L_0x0460:
            java.lang.String r0 = "wvddt"
            int r0 = r1.optInt(r0, r4)     // Catch:{ Exception -> 0x024f }
            r9.aY = r0     // Catch:{ Exception -> 0x024f }
            java.lang.String r0 = "hst_st"
            java.lang.String r0 = r1.optString(r0, r7)     // Catch:{ Exception -> 0x024f }
            r9.f11830E = r0     // Catch:{ Exception -> 0x024f }
            java.lang.String r0 = "hst_st_t"
            java.lang.String r0 = r1.optString(r0, r7)     // Catch:{ Exception -> 0x024f }
            r9.f11831F = r0     // Catch:{ Exception -> 0x024f }
            java.lang.String r0 = "l"
            int r0 = r1.optInt(r0, r8)     // Catch:{ Exception -> 0x049b }
            java.lang.String r2 = "k"
            int r2 = r1.optInt(r2, r4)     // Catch:{ Exception -> 0x049b }
            if (r2 != r10) goto L_0x0488
            r2 = 1
            goto L_0x0489
        L_0x0488:
            r2 = 0
        L_0x0489:
            java.lang.String r3 = "m"
            int r3 = r1.optInt(r3, r10)     // Catch:{ Exception -> 0x049b }
            if (r3 != r10) goto L_0x0493
            r3 = 1
            goto L_0x0494
        L_0x0493:
            r3 = 0
        L_0x0494:
            r9.ay = r0     // Catch:{ Exception -> 0x049b }
            r9.f11846U = r2     // Catch:{ Exception -> 0x049b }
            r9.f11843R = r3     // Catch:{ Exception -> 0x049b }
            goto L_0x04a5
        L_0x049b:
            r0 = move-exception
            java.lang.String r2 = "Setting"
            java.lang.String r0 = r0.getMessage()     // Catch:{ Exception -> 0x024f }
            com.mbridge.msdk.foundation.tools.af.b(r2, r0)     // Catch:{ Exception -> 0x024f }
        L_0x04a5:
            java.lang.String r0 = "fbk_swt"
            int r0 = r1.optInt(r0, r4)     // Catch:{ Exception -> 0x024f }
            r9.f11837L = r0     // Catch:{ Exception -> 0x024f }
            java.lang.String r0 = "fbk"
            org.json.JSONObject r0 = r1.optJSONObject(r0)     // Catch:{ Exception -> 0x024f }
            com.mbridge.msdk.c.b$b r0 = com.mbridge.msdk.c.b.C0173b.a(r0)     // Catch:{ Exception -> 0x024f }
            r9.f11836K = r0     // Catch:{ Exception -> 0x024f }
            java.lang.String r0 = "ad_connection_timeout"
            int r2 = com.mbridge.msdk.foundation.same.a.f13141o     // Catch:{ Exception -> 0x053f }
            int r0 = r1.optInt(r0, r2)     // Catch:{ Exception -> 0x053f }
            java.lang.String r2 = "ad_read_timeout"
            int r3 = com.mbridge.msdk.foundation.same.a.f13143q     // Catch:{ Exception -> 0x053f }
            int r2 = r1.optInt(r2, r3)     // Catch:{ Exception -> 0x053f }
            java.lang.String r3 = "ad_write_timeout"
            int r5 = com.mbridge.msdk.foundation.same.a.f13145s     // Catch:{ Exception -> 0x053f }
            int r3 = r1.optInt(r3, r5)     // Catch:{ Exception -> 0x053f }
            java.lang.String r5 = "ad_retry_count"
            int r12 = com.mbridge.msdk.foundation.same.a.f13144r     // Catch:{ Exception -> 0x053f }
            int r5 = r1.optInt(r5, r12)     // Catch:{ Exception -> 0x053f }
            if (r0 > 0) goto L_0x04dd
            int r0 = com.mbridge.msdk.foundation.same.a.f13141o     // Catch:{ Exception -> 0x053f }
        L_0x04dd:
            r9.f11856f = r0     // Catch:{ Exception -> 0x053f }
            if (r2 > 0) goto L_0x04e3
            int r2 = com.mbridge.msdk.foundation.same.a.f13143q     // Catch:{ Exception -> 0x053f }
        L_0x04e3:
            r9.f11857g = r2     // Catch:{ Exception -> 0x053f }
            if (r3 > 0) goto L_0x04e9
            int r3 = com.mbridge.msdk.foundation.same.a.f13145s     // Catch:{ Exception -> 0x053f }
        L_0x04e9:
            r9.f11859i = r3     // Catch:{ Exception -> 0x053f }
            if (r5 >= 0) goto L_0x04ef
            int r5 = com.mbridge.msdk.foundation.same.a.f13144r     // Catch:{ Exception -> 0x053f }
        L_0x04ef:
            r9.f11858h = r5     // Catch:{ Exception -> 0x053f }
            java.lang.String r0 = "max_download_task_size"
            int r0 = r1.optInt(r0, r11)     // Catch:{ Exception -> 0x053f }
            if (r0 > 0) goto L_0x04fb
            r0 = 10
        L_0x04fb:
            r9.ai = r0     // Catch:{ Exception -> 0x053f }
            java.lang.String r0 = "max_bitmap_cache_size"
            int r0 = r1.optInt(r0, r11)     // Catch:{ Exception -> 0x053f }
            r9.p(r0)     // Catch:{ Exception -> 0x053f }
            java.lang.String r0 = "t_t"
            int r0 = r1.optInt(r0, r8)     // Catch:{ Exception -> 0x053f }
            r9.aN = r0     // Catch:{ Exception -> 0x053f }
            java.lang.String r0 = "h_t"
            int r0 = r1.optInt(r0, r8)     // Catch:{ Exception -> 0x053f }
            r9.f11840O = r0     // Catch:{ Exception -> 0x053f }
            java.lang.String r0 = "gtp"
            int r0 = r1.optInt(r0)     // Catch:{ Exception -> 0x053f }
            r9.f11839N = r0     // Catch:{ Exception -> 0x053f }
            com.mbridge.msdk.foundation.same.net.e.d r2 = com.mbridge.msdk.foundation.same.net.e.d.f()     // Catch:{ Exception -> 0x053f }
            r2.a((int) r0)     // Catch:{ Exception -> 0x053f }
            java.lang.String r0 = "i_i_t"
            r2 = 3600(0xe10, double:1.7786E-320)
            long r2 = r1.optLong(r0, r2)     // Catch:{ Exception -> 0x053f }
            r9.aZ = r2     // Catch:{ Exception -> 0x053f }
            java.lang.String r0 = "c_i"
            java.lang.String r0 = r1.optString(r0, r7)     // Catch:{ Exception -> 0x053f }
            r9.ba = r0     // Catch:{ Exception -> 0x053f }
            java.lang.String r0 = "n_c_u_p"
            int r0 = r1.optInt(r0, r4)     // Catch:{ Exception -> 0x053f }
            r9.bb = r0     // Catch:{ Exception -> 0x053f }
        L_0x053f:
            java.lang.String r0 = "http_track_url"
            java.lang.String r0 = r1.optString(r0, r7)     // Catch:{ Exception -> 0x0547 }
            r9.f11842Q = r0     // Catch:{ Exception -> 0x0547 }
        L_0x0547:
            java.lang.String r0 = "st_net"
            int r0 = r1.optInt(r0, r10)     // Catch:{ Exception -> 0x024f }
            r9.aL = r0     // Catch:{ Exception -> 0x024f }
            java.lang.String r0 = "vtag"
            java.lang.String r0 = r1.optString(r0, r7)     // Catch:{ Exception -> 0x024f }
            r9.aU = r0     // Catch:{ Exception -> 0x024f }
            java.lang.String r0 = "check_webview"
            int r0 = r1.optInt(r0, r4)     // Catch:{ Exception -> 0x0565 }
            if (r0 != 0) goto L_0x0561
            r0 = 0
            goto L_0x0562
        L_0x0561:
            r0 = 1
        L_0x0562:
            r9.f11874x = r0     // Catch:{ Exception -> 0x0565 }
            goto L_0x0567
        L_0x0565:
            r9.f11874x = r4     // Catch:{ Exception -> 0x024f }
        L_0x0567:
            java.lang.String r0 = "swxid"
            java.lang.String r0 = r1.optString(r0)     // Catch:{ Exception -> 0x024f }
            java.lang.String r2 = r9.ah     // Catch:{ Exception -> 0x024f }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x024f }
            if (r2 != 0) goto L_0x058e
            r9.ah = r0     // Catch:{ Exception -> 0x024f }
            com.mbridge.msdk.foundation.controller.c r0 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ Exception -> 0x024f }
            java.lang.String r0 = r0.h()     // Catch:{ Exception -> 0x024f }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x024f }
            if (r0 == 0) goto L_0x058e
            com.mbridge.msdk.foundation.controller.c r0 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ Exception -> 0x024f }
            java.lang.String r2 = r9.ah     // Catch:{ Exception -> 0x024f }
            r0.a((java.lang.String) r2)     // Catch:{ Exception -> 0x024f }
        L_0x058e:
            java.lang.String r0 = "sdk_filters"
            org.json.JSONArray r0 = r1.optJSONArray(r0)     // Catch:{ Exception -> 0x024f }
            r9.aG = r0     // Catch:{ Exception -> 0x024f }
            java.lang.String r0 = "ch_nv_im_cb"
            int r0 = r1.optInt(r0, r10)     // Catch:{ Exception -> 0x059f }
            r9.f11873w = r0     // Catch:{ Exception -> 0x059f }
            goto L_0x05a1
        L_0x059f:
            r9.f11873w = r10     // Catch:{ Exception -> 0x024f }
        L_0x05a1:
            java.lang.String r0 = "do_us_fi_re"
            int r0 = r1.optInt(r0, r10)     // Catch:{ Exception -> 0x05af }
            if (r0 == 0) goto L_0x05ab
            r0 = 1
            goto L_0x05ac
        L_0x05ab:
            r0 = 0
        L_0x05ac:
            r9.f11845T = r0     // Catch:{ Exception -> 0x05af }
            goto L_0x05b1
        L_0x05af:
            r9.f11845T = r10     // Catch:{ Exception -> 0x024f }
        L_0x05b1:
            com.mbridge.msdk.foundation.controller.d.a()     // Catch:{ Exception -> 0x0634 }
            com.mbridge.msdk.foundation.tools.FastKV$Builder r0 = new com.mbridge.msdk.foundation.tools.FastKV$Builder     // Catch:{ Exception -> 0x05c8 }
            com.mbridge.msdk.foundation.same.b.c r2 = com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_CONFIG     // Catch:{ Exception -> 0x05c8 }
            java.lang.String r2 = com.mbridge.msdk.foundation.same.b.e.a((com.mbridge.msdk.foundation.same.b.c) r2)     // Catch:{ Exception -> 0x05c8 }
            java.lang.String r3 = com.mbridge.msdk.foundation.tools.z.a(r6)     // Catch:{ Exception -> 0x05c8 }
            r0.<init>(r2, r3)     // Catch:{ Exception -> 0x05c8 }
            com.mbridge.msdk.foundation.tools.FastKV r8 = r0.build()     // Catch:{ Exception -> 0x05c8 }
            goto L_0x05ca
        L_0x05c8:
            r8 = 0
        L_0x05ca:
            java.lang.String r0 = "H+tU+Fz8"
            java.lang.String r2 = "H+tU+bfPhM=="
            java.lang.String r3 = "c"
            java.lang.String r5 = "b"
            if (r8 == 0) goto L_0x0637
            com.mbridge.msdk.foundation.controller.c r4 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ Exception -> 0x0605 }
            android.content.Context r4 = r4.c()     // Catch:{ Exception -> 0x0605 }
            if (r4 == 0) goto L_0x06ba
            java.lang.String r4 = r1.optString(r5)     // Catch:{ Exception -> 0x0605 }
            boolean r6 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x0605 }
            if (r6 != 0) goto L_0x0607
            java.lang.String r6 = com.mbridge.msdk.foundation.same.a.f13124V     // Catch:{ Exception -> 0x0605 }
            boolean r6 = android.text.TextUtils.equals(r6, r4)     // Catch:{ Exception -> 0x0605 }
            if (r6 != 0) goto L_0x0607
            com.mbridge.msdk.foundation.same.a.f13124V = r4     // Catch:{ Exception -> 0x0605 }
            com.mbridge.msdk.foundation.a.a.a r4 = com.mbridge.msdk.foundation.a.a.a.a()     // Catch:{ Exception -> 0x0605 }
            java.lang.String r6 = com.mbridge.msdk.foundation.same.a.f13124V     // Catch:{ Exception -> 0x0605 }
            r4.a((java.lang.String) r5, (java.lang.String) r6)     // Catch:{ Exception -> 0x0605 }
            java.lang.String r2 = com.mbridge.msdk.foundation.tools.z.a(r2)     // Catch:{ Exception -> 0x0607 }
            java.lang.String r4 = com.mbridge.msdk.foundation.same.a.f13124V     // Catch:{ Exception -> 0x0607 }
            r8.putString(r2, r4)     // Catch:{ Exception -> 0x0607 }
            goto L_0x0607
        L_0x0605:
            r0 = move-exception
            goto L_0x062f
        L_0x0607:
            java.lang.String r2 = r1.optString(r3)     // Catch:{ Exception -> 0x0605 }
            boolean r4 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x0605 }
            if (r4 != 0) goto L_0x06ba
            java.lang.String r4 = com.mbridge.msdk.foundation.same.a.f13133g     // Catch:{ Exception -> 0x0605 }
            boolean r4 = android.text.TextUtils.equals(r4, r2)     // Catch:{ Exception -> 0x0605 }
            if (r4 != 0) goto L_0x06ba
            com.mbridge.msdk.foundation.same.a.f13133g = r2     // Catch:{ Exception -> 0x0605 }
            com.mbridge.msdk.foundation.a.a.a r2 = com.mbridge.msdk.foundation.a.a.a.a()     // Catch:{ Exception -> 0x0605 }
            java.lang.String r4 = com.mbridge.msdk.foundation.same.a.f13133g     // Catch:{ Exception -> 0x0605 }
            r2.a((java.lang.String) r3, (java.lang.String) r4)     // Catch:{ Exception -> 0x0605 }
            java.lang.String r0 = com.mbridge.msdk.foundation.tools.z.a(r0)     // Catch:{ Exception -> 0x06ba }
            java.lang.String r2 = com.mbridge.msdk.foundation.same.a.f13133g     // Catch:{ Exception -> 0x06ba }
            r8.putString(r0, r2)     // Catch:{ Exception -> 0x06ba }
            goto L_0x06ba
        L_0x062f:
            r0.printStackTrace()     // Catch:{ Exception -> 0x0634 }
            goto L_0x06ba
        L_0x0634:
            r0 = move-exception
            goto L_0x06b7
        L_0x0637:
            com.mbridge.msdk.foundation.controller.c r7 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ Exception -> 0x0679 }
            android.content.Context r7 = r7.c()     // Catch:{ Exception -> 0x0679 }
            if (r7 == 0) goto L_0x06ba
            java.lang.String r8 = r1.optString(r5)     // Catch:{ Exception -> 0x0679 }
            boolean r10 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Exception -> 0x0679 }
            if (r10 != 0) goto L_0x067b
            java.lang.String r10 = com.mbridge.msdk.foundation.same.a.f13124V     // Catch:{ Exception -> 0x0679 }
            boolean r10 = android.text.TextUtils.equals(r10, r8)     // Catch:{ Exception -> 0x0679 }
            if (r10 != 0) goto L_0x067b
            com.mbridge.msdk.foundation.same.a.f13124V = r8     // Catch:{ Exception -> 0x0679 }
            com.mbridge.msdk.foundation.a.a.a r8 = com.mbridge.msdk.foundation.a.a.a.a()     // Catch:{ Exception -> 0x0679 }
            java.lang.String r10 = com.mbridge.msdk.foundation.same.a.f13124V     // Catch:{ Exception -> 0x0679 }
            r8.a((java.lang.String) r5, (java.lang.String) r10)     // Catch:{ Exception -> 0x0679 }
            java.lang.String r5 = com.mbridge.msdk.foundation.tools.z.a(r6)     // Catch:{ Exception -> 0x0679 }
            android.content.SharedPreferences r5 = r7.getSharedPreferences(r5, r4)     // Catch:{ Exception -> 0x0679 }
            if (r5 == 0) goto L_0x067b
            android.content.SharedPreferences$Editor r5 = r5.edit()     // Catch:{ Exception -> 0x0679 }
            java.lang.String r2 = com.mbridge.msdk.foundation.tools.z.a(r2)     // Catch:{ Exception -> 0x0679 }
            java.lang.String r8 = com.mbridge.msdk.foundation.same.a.f13124V     // Catch:{ Exception -> 0x0679 }
            r5.putString(r2, r8)     // Catch:{ Exception -> 0x0679 }
            r5.apply()     // Catch:{ Exception -> 0x0679 }
            goto L_0x067b
        L_0x0679:
            r0 = move-exception
            goto L_0x06b3
        L_0x067b:
            java.lang.String r2 = r1.optString(r3)     // Catch:{ Exception -> 0x0679 }
            boolean r5 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x0679 }
            if (r5 != 0) goto L_0x06ba
            java.lang.String r5 = com.mbridge.msdk.foundation.same.a.f13133g     // Catch:{ Exception -> 0x0679 }
            boolean r5 = android.text.TextUtils.equals(r5, r2)     // Catch:{ Exception -> 0x0679 }
            if (r5 != 0) goto L_0x06ba
            com.mbridge.msdk.foundation.same.a.f13133g = r2     // Catch:{ Exception -> 0x0679 }
            com.mbridge.msdk.foundation.a.a.a r2 = com.mbridge.msdk.foundation.a.a.a.a()     // Catch:{ Exception -> 0x0679 }
            java.lang.String r5 = com.mbridge.msdk.foundation.same.a.f13133g     // Catch:{ Exception -> 0x0679 }
            r2.a((java.lang.String) r3, (java.lang.String) r5)     // Catch:{ Exception -> 0x0679 }
            java.lang.String r2 = com.mbridge.msdk.foundation.tools.z.a(r6)     // Catch:{ Exception -> 0x0679 }
            android.content.SharedPreferences r2 = r7.getSharedPreferences(r2, r4)     // Catch:{ Exception -> 0x0679 }
            if (r2 == 0) goto L_0x06ba
            android.content.SharedPreferences$Editor r2 = r2.edit()     // Catch:{ Exception -> 0x0679 }
            java.lang.String r0 = com.mbridge.msdk.foundation.tools.z.a(r0)     // Catch:{ Exception -> 0x0679 }
            java.lang.String r3 = com.mbridge.msdk.foundation.same.a.f13133g     // Catch:{ Exception -> 0x0679 }
            r2.putString(r0, r3)     // Catch:{ Exception -> 0x0679 }
            r2.apply()     // Catch:{ Exception -> 0x0679 }
            goto L_0x06ba
        L_0x06b3:
            r0.printStackTrace()     // Catch:{ Exception -> 0x0634 }
            goto L_0x06ba
        L_0x06b7:
            r0.printStackTrace()     // Catch:{ Exception -> 0x024f }
        L_0x06ba:
            java.lang.String r0 = "bcp"
            java.lang.String r0 = r1.optString(r0)     // Catch:{ Exception -> 0x024f }
            boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x024f }
            if (r2 != 0) goto L_0x06d0
            java.lang.String r0 = com.mbridge.msdk.foundation.tools.z.a(r0)     // Catch:{ Exception -> 0x024f }
            com.mbridge.msdk.c.a r0 = com.mbridge.msdk.c.a.a(r0)     // Catch:{ Exception -> 0x024f }
            r9.f11868r = r0     // Catch:{ Exception -> 0x024f }
        L_0x06d0:
            java.lang.String r0 = "monitor"
            java.lang.String r0 = r1.optString(r0)     // Catch:{ Exception -> 0x024f }
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x024f }
            if (r1 != 0) goto L_0x06e6
            java.lang.String r0 = com.mbridge.msdk.foundation.tools.z.a(r0)     // Catch:{ Exception -> 0x024f }
            com.mbridge.msdk.c.d r0 = com.mbridge.msdk.c.d.a(r0)     // Catch:{ Exception -> 0x024f }
            r9.f11835J = r0     // Catch:{ Exception -> 0x024f }
        L_0x06e6:
            r8 = r9
            goto L_0x06ef
        L_0x06e8:
            r0 = move-exception
            r8 = 0
        L_0x06ea:
            r0.printStackTrace()
            goto L_0x06ef
        L_0x06ee:
            r8 = 0
        L_0x06ef:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.c.b.a(org.json.JSONObject):com.mbridge.msdk.c.g");
    }

    public final int e() {
        return this.f11856f;
    }

    /* renamed from: com.mbridge.msdk.c.b$b  reason: collision with other inner class name */
    public static class C0173b {

        /* renamed from: a  reason: collision with root package name */
        private String f11888a;

        /* renamed from: b  reason: collision with root package name */
        private JSONArray f11889b;

        /* renamed from: c  reason: collision with root package name */
        private String f11890c;

        /* renamed from: d  reason: collision with root package name */
        private String f11891d;

        /* renamed from: e  reason: collision with root package name */
        private String f11892e;

        /* renamed from: f  reason: collision with root package name */
        private String f11893f;

        public static C0173b a(JSONObject jSONObject) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            C0173b bVar = new C0173b();
            Context c5 = c.m().c();
            bVar.f11893f = jSONObject.optString(CampaignEx.JSON_KEY_TITLE, c5.getString(x.a(c5, "mbridge_cm_feedback_dialog_title", TypedValues.Custom.S_STRING)));
            bVar.f11888a = jSONObject.optString("cancel", c5.getString(x.a(c5, "mbridge_cm_feedback_dialog_close_close", TypedValues.Custom.S_STRING)));
            bVar.f11891d = jSONObject.optString("submit", c5.getString(x.a(c5, "mbridge_cm_feedback_dialog_close_submit", TypedValues.Custom.S_STRING)));
            bVar.f11892e = jSONObject.optString("submit_notice", c5.getString(x.a(c5, "mbridge_cm_feedback_dialog_submit_notice", TypedValues.Custom.S_STRING)));
            bVar.f11890c = jSONObject.optString("privacy", c5.getString(x.a(c5, "mbridge_cm_feedback_dialog_privacy_des", TypedValues.Custom.S_STRING)));
            JSONArray optJSONArray = jSONObject.optJSONArray("content");
            bVar.f11889b = optJSONArray;
            if (optJSONArray == null) {
                JSONArray jSONArray = new JSONArray();
                bVar.f11889b = jSONArray;
                jSONArray.put(c5.getString(x.a(c5, "mbridge_cm_feedback_dialog_content_not_play", TypedValues.Custom.S_STRING)));
                bVar.f11889b.put(c5.getString(x.a(c5, "mbridge_cm_feedback_dialog_content_sound_problems", TypedValues.Custom.S_STRING)));
                bVar.f11889b.put(c5.getString(x.a(c5, "mbridge_cm_feedback_dialog_content_misleading", TypedValues.Custom.S_STRING)));
                bVar.f11889b.put(c5.getString(x.a(c5, "mbridge_cm_feedback_dialog_content_fraud", TypedValues.Custom.S_STRING)));
                bVar.f11889b.put(c5.getString(x.a(c5, "mbridge_cm_feedback_dialog_content_por_violence", TypedValues.Custom.S_STRING)));
                bVar.f11889b.put(c5.getString(x.a(c5, "mbridge_cm_feedback_dialog_content_other", TypedValues.Custom.S_STRING)));
            }
            return bVar;
        }

        public final JSONArray b() {
            return this.f11889b;
        }

        public final String c() {
            return this.f11890c;
        }

        public final String d() {
            return this.f11891d;
        }

        public final String e() {
            return this.f11892e;
        }

        public final String f() {
            return this.f11893f;
        }

        public final String a() {
            return this.f11888a;
        }
    }

    public final void e(int i4) {
        this.f11859i = i4;
    }

    public final void e(long j4) {
        this.aJ = j4;
    }

    public final void e(boolean z4) {
        this.aE = z4;
    }

    public final void a(String str) {
        this.f11842Q = str;
    }

    public final void a(boolean z4) {
        this.f11871u = z4;
    }
}
