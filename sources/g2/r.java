package g2;

import W1.C1610f;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.FeatureInfo;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import kotlin.jvm.internal.C2098b;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import m3.j;
import org.json.JSONArray;
import org.json.JSONObject;

public final class r {

    /* renamed from: w  reason: collision with root package name */
    public static final a f20713w = new a((C2103g) null);

    /* renamed from: a  reason: collision with root package name */
    private String f20714a;

    /* renamed from: b  reason: collision with root package name */
    private String f20715b;

    /* renamed from: c  reason: collision with root package name */
    private String f20716c;

    /* renamed from: d  reason: collision with root package name */
    private String f20717d;

    /* renamed from: e  reason: collision with root package name */
    private String f20718e;

    /* renamed from: f  reason: collision with root package name */
    private String f20719f;

    /* renamed from: g  reason: collision with root package name */
    private String f20720g;

    /* renamed from: h  reason: collision with root package name */
    private int f20721h;

    /* renamed from: i  reason: collision with root package name */
    private int f20722i;

    /* renamed from: j  reason: collision with root package name */
    private int f20723j;

    /* renamed from: k  reason: collision with root package name */
    private float f20724k;

    /* renamed from: l  reason: collision with root package name */
    private String f20725l;

    /* renamed from: m  reason: collision with root package name */
    private long f20726m;

    /* renamed from: n  reason: collision with root package name */
    private String[] f20727n;

    /* renamed from: o  reason: collision with root package name */
    private String[] f20728o;

    /* renamed from: p  reason: collision with root package name */
    private String[] f20729p;

    /* renamed from: q  reason: collision with root package name */
    private String f20730q;

    /* renamed from: r  reason: collision with root package name */
    private int f20731r;

    /* renamed from: s  reason: collision with root package name */
    private String f20732s;

    /* renamed from: t  reason: collision with root package name */
    private int f20733t;

    /* renamed from: u  reason: collision with root package name */
    private String f20734u;

    /* renamed from: v  reason: collision with root package name */
    private int f20735v;

    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        private a() {
        }
    }

    public final String a() {
        String str = this.f20714a + this.f20721h;
        if (this.f20715b != null) {
            str = str + this.f20715b;
        }
        if (this.f20717d != null) {
            str = str + this.f20717d;
        }
        return C1610f.f8672a.c(str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0048, code lost:
        if (r0.equals("0") != false) goto L_0x004a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean b(java.lang.String r5) {
        /*
            r4 = this;
            java.lang.String r0 = "json"
            kotlin.jvm.internal.m.e(r5, r0)
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>(r5)
            java.lang.String r5 = "success"
            boolean r1 = r0.isNull(r5)
            r2 = 0
            if (r1 != 0) goto L_0x0071
            int r5 = r0.optInt(r5)
            r1 = 1
            if (r5 != r1) goto L_0x0071
            java.lang.String r5 = "data"
            org.json.JSONObject r5 = r0.optJSONObject(r5)
            if (r5 == 0) goto L_0x0071
            java.lang.String r0 = "sdk"
            boolean r3 = r5.isNull(r0)
            if (r3 != 0) goto L_0x0033
            int r3 = r4.f20721h
            int r0 = r5.optInt(r0)
            if (r3 != r0) goto L_0x0033
            r2 = 1
        L_0x0033:
            if (r2 == 0) goto L_0x0071
            java.lang.String r0 = "userID"
            boolean r1 = r5.isNull(r0)
            r2 = 0
            if (r1 != 0) goto L_0x004a
            java.lang.String r0 = r5.optString(r0)
            java.lang.String r1 = "0"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x004b
        L_0x004a:
            r0 = r2
        L_0x004b:
            u2.q r1 = new u2.q
            r1.<init>()
            java.lang.String r3 = r4.f20715b
            boolean r0 = r1.s(r0, r3)
            if (r0 == 0) goto L_0x0070
            java.lang.String r0 = "language"
            boolean r1 = r5.isNull(r0)
            if (r1 != 0) goto L_0x0064
            java.lang.String r2 = r5.optString(r0)
        L_0x0064:
            u2.q r5 = new u2.q
            r5.<init>()
            java.lang.String r0 = r4.f20717d
            boolean r5 = r5.s(r2, r0)
            return r5
        L_0x0070:
            return r0
        L_0x0071:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: g2.r.b(java.lang.String):boolean");
    }

    public final String c() {
        return this.f20716c;
    }

    public final String d() {
        return this.f20714a;
    }

    public final ArrayList e(ArrayList arrayList, Context context) {
        m.e(arrayList, "appRequiredFeatures");
        m.e(context, "context");
        ArrayList arrayList2 = new ArrayList();
        if (arrayList.size() > 0) {
            FeatureInfo[] systemAvailableFeatures = context.getPackageManager().getSystemAvailableFeatures();
            m.d(systemAvailableFeatures, "getSystemAvailableFeatures(...)");
            String[] systemSharedLibraryNames = context.getPackageManager().getSystemSharedLibraryNames();
            Iterator it = arrayList.iterator();
            m.d(it, "iterator(...)");
            while (it.hasNext()) {
                Object next = it.next();
                m.d(next, "next(...)");
                String str = (String) next;
                boolean z4 = false;
                boolean z5 = false;
                for (FeatureInfo featureInfo : systemAvailableFeatures) {
                    z5 = context.getPackageManager().hasSystemFeature(str);
                    if (!z5 && m3.m.p(str, "android.hardware.ram.low", true)) {
                        z5 = context.getPackageManager().hasSystemFeature("android.hardware.ram.normal");
                    }
                    if (z5) {
                        break;
                    }
                }
                if (!z5 && systemSharedLibraryNames != null) {
                    Iterator a5 = C2098b.a(systemSharedLibraryNames);
                    while (true) {
                        if (a5.hasNext()) {
                            if (m3.m.p(str, (String) a5.next(), true)) {
                                z4 = true;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
                if (!z5 && !z4) {
                    arrayList2.add(str);
                }
            }
        }
        return arrayList2;
    }

    public final boolean f(ArrayList arrayList, Context context) {
        m.e(arrayList, "appRequiredFeatures");
        m.e(context, "context");
        return e(arrayList, context).isEmpty();
    }

    public final boolean g(C2060s sVar) {
        m.e(sVar, "download");
        if (sVar.A() == null || this.f20727n == null) {
            return true;
        }
        String A4 = sVar.A();
        m.b(A4);
        String[] strArr = (String[]) new j(",").h(A4, 0).toArray(new String[0]);
        String[] strArr2 = this.f20727n;
        m.b(strArr2);
        for (String str : strArr2) {
            for (String str2 : strArr) {
                if (m3.m.p(str2, "universal", true) || m3.m.p(str, str2, true)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x002f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean h(g2.C2060s r5) {
        /*
            r4 = this;
            java.lang.String r0 = "download"
            kotlin.jvm.internal.m.e(r5, r0)
            java.util.ArrayList r0 = r5.B()
            r1 = 1
            if (r0 == 0) goto L_0x0057
            java.util.ArrayList r0 = r5.B()
            kotlin.jvm.internal.m.b(r0)
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x0057
            java.util.ArrayList r5 = r5.B()
            kotlin.jvm.internal.m.b(r5)
            java.util.Iterator r5 = r5.iterator()
            java.lang.String r0 = "iterator(...)"
            kotlin.jvm.internal.m.d(r5, r0)
        L_0x0029:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L_0x0055
            java.lang.Object r0 = r5.next()
            java.lang.String r2 = "next(...)"
            kotlin.jvm.internal.m.d(r0, r2)
            java.lang.String r0 = (java.lang.String) r0
            int r2 = java.lang.Integer.parseInt(r0)
            int r3 = r4.f20733t
            if (r2 == r3) goto L_0x0054
            int r2 = java.lang.Integer.parseInt(r0)
            r3 = 65534(0xfffe, float:9.1833E-41)
            if (r2 == r3) goto L_0x0054
            int r0 = java.lang.Integer.parseInt(r0)
            r2 = 65535(0xffff, float:9.1834E-41)
            if (r0 != r2) goto L_0x0029
        L_0x0054:
            return r1
        L_0x0055:
            r5 = 0
            return r5
        L_0x0057:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: g2.r.h(g2.s):boolean");
    }

    public final boolean i(C2060s sVar) {
        m.e(sVar, "download");
        if (sVar.u() <= this.f20721h) {
            return true;
        }
        return false;
    }

    public final void j(Context context) {
        String str;
        m.e(context, "context");
        this.f20714a = Settings.Secure.getString(context.getContentResolver(), "android_id");
        U e5 = U.f20468m.e(context);
        if (e5 != null) {
            str = e5.g();
        } else {
            str = null;
        }
        if (str != null) {
            this.f20715b = e5.g();
        } else {
            this.f20715b = null;
        }
        this.f20721h = Build.VERSION.SDK_INT;
        if (new P1.a(context).l()) {
            this.f20731r = 1;
        }
    }

    public final void k(Context context) {
        m.e(context, "context");
        j(context);
        this.f20722i = context.getResources().getDisplayMetrics().widthPixels;
        this.f20723j = context.getResources().getDisplayMetrics().heightPixels;
        this.f20724k = context.getResources().getDisplayMetrics().density;
        this.f20733t = context.getResources().getDisplayMetrics().densityDpi;
        this.f20734u = context.getString(R.string.dpi_device);
        this.f20716c = Locale.getDefault().getCountry();
        this.f20717d = Locale.getDefault().getLanguage();
        this.f20718e = Build.BRAND;
        this.f20720g = Build.MANUFACTURER;
        this.f20719f = Build.MODEL;
        Object systemService = context.getSystemService("phone");
        m.c(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
        TelephonyManager telephonyManager = (TelephonyManager) systemService;
        this.f20725l = telephonyManager.getNetworkOperatorName();
        String str = this.f20716c;
        if (str == null || str.length() == 0) {
            this.f20716c = telephonyManager.getNetworkCountryIso();
        }
        try {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            Object systemService2 = context.getSystemService("activity");
            m.c(systemService2, "null cannot be cast to non-null type android.app.ActivityManager");
            ((ActivityManager) systemService2).getMemoryInfo(memoryInfo);
            this.f20726m = memoryInfo.totalMem;
        } catch (Exception e5) {
            e5.getMessage();
        } catch (Error e6) {
            e6.getMessage();
        }
        this.f20727n = Build.SUPPORTED_ABIS;
        this.f20728o = Build.SUPPORTED_32_BIT_ABIS;
        this.f20729p = Build.SUPPORTED_64_BIT_ABIS;
        this.f20730q = context.getString(R.string.version, new Object[]{context.getString(R.string.app_name), "6.71", "671"});
        this.f20732s = Build.HARDWARE;
        if (UptodownApp.f17422D.S(context)) {
            this.f20735v = 1;
        } else {
            this.f20735v = 0;
        }
    }

    public final JSONObject l() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("identifier", this.f20714a);
        jSONObject.put("userID", this.f20715b);
        jSONObject.put("country", this.f20716c);
        jSONObject.put("language", this.f20717d);
        jSONObject.put("brand", this.f20718e);
        jSONObject.put("model", this.f20719f);
        jSONObject.put("manufacturer", this.f20720g);
        int i4 = this.f20721h;
        if (i4 > 0) {
            jSONObject.put("sdk", i4);
        }
        int i5 = this.f20722i;
        if (i5 > 0) {
            jSONObject.put("displayWidth", i5);
        }
        int i6 = this.f20723j;
        if (i6 > 0) {
            jSONObject.put("displayHeight", i6);
        }
        float f4 = this.f20724k;
        if (f4 > 0.0f) {
            jSONObject.put("displayDensity", (double) f4);
        }
        String str = this.f20734u;
        if (str != null) {
            m.b(str);
            if (str.length() > 0) {
                jSONObject.put("density", this.f20734u);
            }
        }
        long j4 = this.f20726m;
        if (j4 > 0) {
            jSONObject.put("ram", j4);
        }
        jSONObject.put("operador", this.f20725l);
        String[] strArr = this.f20727n;
        if (!(strArr == null || strArr.length == 0)) {
            JSONArray jSONArray = new JSONArray();
            Iterator a5 = C2098b.a(strArr);
            while (a5.hasNext()) {
                jSONArray.put((String) a5.next());
            }
            jSONObject.put("supportedABIs", jSONArray);
        }
        String[] strArr2 = this.f20728o;
        if (!(strArr2 == null || strArr2.length == 0)) {
            JSONArray jSONArray2 = new JSONArray();
            Iterator a6 = C2098b.a(strArr2);
            while (a6.hasNext()) {
                jSONArray2.put((String) a6.next());
            }
            jSONObject.put("supported32BitsABIs", jSONArray2);
        }
        String[] strArr3 = this.f20729p;
        if (!(strArr3 == null || strArr3.length == 0)) {
            JSONArray jSONArray3 = new JSONArray();
            Iterator a7 = C2098b.a(strArr3);
            while (a7.hasNext()) {
                jSONArray3.put((String) a7.next());
            }
            jSONObject.put("supported64BitsABIs", jSONArray3);
        }
        jSONObject.put("appVersion", this.f20730q);
        jSONObject.put("rooted", this.f20731r);
        jSONObject.put("isTV", this.f20735v);
        return jSONObject;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DeviceInfo(identifier=");
        sb.append(this.f20714a);
        sb.append(", userId=");
        sb.append(this.f20715b);
        sb.append(", country=");
        sb.append(this.f20716c);
        sb.append(", language=");
        sb.append(this.f20717d);
        sb.append(", brand=");
        sb.append(this.f20718e);
        sb.append(", model=");
        sb.append(this.f20719f);
        sb.append(", manufacturer=");
        sb.append(this.f20720g);
        sb.append(", sdk=");
        sb.append(this.f20721h);
        sb.append(", displayWidth=");
        sb.append(this.f20722i);
        sb.append(", displayHeight=");
        sb.append(this.f20723j);
        sb.append(", displayDensity=");
        sb.append(this.f20724k);
        sb.append(", densityDpi=");
        sb.append(this.f20733t);
        sb.append(", density=");
        sb.append(this.f20734u);
        sb.append(", operador=");
        sb.append(this.f20725l);
        sb.append(", ram=");
        sb.append(this.f20726m);
        sb.append(", supportedAbis=");
        String arrays = Arrays.toString(this.f20727n);
        m.d(arrays, "toString(...)");
        sb.append(arrays);
        sb.append(", supported32BitsAbis=");
        String arrays2 = Arrays.toString(this.f20728o);
        m.d(arrays2, "toString(...)");
        sb.append(arrays2);
        sb.append(", supported64BitsAbis=");
        String arrays3 = Arrays.toString(this.f20729p);
        m.d(arrays3, "toString(...)");
        sb.append(arrays3);
        sb.append(", appVersion=");
        sb.append(this.f20730q);
        sb.append(", rooted=");
        sb.append(this.f20731r);
        sb.append(", hardware=");
        sb.append(this.f20732s);
        sb.append(", isTv=");
        sb.append(this.f20735v);
        sb.append(')');
        return sb.toString();
    }
}
