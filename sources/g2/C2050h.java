package g2;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.leanback.preference.LeanbackPreferenceDialogFragment;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.uptodown.UptodownApp;
import g2.O;
import g2.Z;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import u2.x;

/* renamed from: g2.h  reason: case insensitive filesystem */
public final class C2050h implements Parcelable {
    public static Parcelable.Creator<C2050h> CREATOR = new a();

    /* renamed from: F0  reason: collision with root package name */
    public static final b f20600F0 = new b((C2103g) null);

    /* renamed from: A  reason: collision with root package name */
    private long f20601A = -1;

    /* renamed from: A0  reason: collision with root package name */
    private boolean f20602A0;

    /* renamed from: B  reason: collision with root package name */
    private long f20603B = -1;

    /* renamed from: B0  reason: collision with root package name */
    private int f20604B0;

    /* renamed from: C  reason: collision with root package name */
    private int f20605C;

    /* renamed from: C0  reason: collision with root package name */
    private int f20606C0;

    /* renamed from: D  reason: collision with root package name */
    private String f20607D;

    /* renamed from: D0  reason: collision with root package name */
    private ArrayList f20608D0;

    /* renamed from: E  reason: collision with root package name */
    private String f20609E;

    /* renamed from: E0  reason: collision with root package name */
    private transient ArrayList f20610E0;

    /* renamed from: F  reason: collision with root package name */
    private String f20611F;

    /* renamed from: G  reason: collision with root package name */
    private String f20612G;

    /* renamed from: H  reason: collision with root package name */
    private String f20613H;

    /* renamed from: I  reason: collision with root package name */
    private String f20614I;

    /* renamed from: J  reason: collision with root package name */
    private ArrayList f20615J;

    /* renamed from: K  reason: collision with root package name */
    private ArrayList f20616K;

    /* renamed from: L  reason: collision with root package name */
    private ArrayList f20617L;

    /* renamed from: M  reason: collision with root package name */
    private String f20618M;

    /* renamed from: N  reason: collision with root package name */
    private String f20619N;

    /* renamed from: O  reason: collision with root package name */
    private ArrayList f20620O;

    /* renamed from: P  reason: collision with root package name */
    private ArrayList f20621P;

    /* renamed from: Q  reason: collision with root package name */
    private K f20622Q;

    /* renamed from: R  reason: collision with root package name */
    private String f20623R;

    /* renamed from: S  reason: collision with root package name */
    private String f20624S;

    /* renamed from: T  reason: collision with root package name */
    private String f20625T;

    /* renamed from: U  reason: collision with root package name */
    private int f20626U;

    /* renamed from: V  reason: collision with root package name */
    private String f20627V;

    /* renamed from: W  reason: collision with root package name */
    private String f20628W;

    /* renamed from: X  reason: collision with root package name */
    private String f20629X;

    /* renamed from: Y  reason: collision with root package name */
    private String f20630Y;

    /* renamed from: Z  reason: collision with root package name */
    private String f20631Z;

    /* renamed from: a  reason: collision with root package name */
    private long f20632a;

    /* renamed from: b  reason: collision with root package name */
    private String f20633b;

    /* renamed from: c  reason: collision with root package name */
    private String f20634c;

    /* renamed from: d  reason: collision with root package name */
    private long f20635d = -1;

    /* renamed from: e  reason: collision with root package name */
    private String f20636e;

    /* renamed from: f  reason: collision with root package name */
    private String f20637f;

    /* renamed from: g  reason: collision with root package name */
    private String f20638g;

    /* renamed from: h  reason: collision with root package name */
    private String f20639h;

    /* renamed from: i  reason: collision with root package name */
    private int f20640i;

    /* renamed from: j  reason: collision with root package name */
    private int f20641j;

    /* renamed from: k  reason: collision with root package name */
    private String f20642k;

    /* renamed from: l  reason: collision with root package name */
    private String f20643l;

    /* renamed from: m  reason: collision with root package name */
    private String f20644m;

    /* renamed from: m0  reason: collision with root package name */
    private String f20645m0;

    /* renamed from: n  reason: collision with root package name */
    private String f20646n;

    /* renamed from: n0  reason: collision with root package name */
    private long f20647n0;

    /* renamed from: o  reason: collision with root package name */
    private String f20648o;

    /* renamed from: o0  reason: collision with root package name */
    private String f20649o0;

    /* renamed from: p  reason: collision with root package name */
    private int f20650p;

    /* renamed from: p0  reason: collision with root package name */
    private String f20651p0;

    /* renamed from: q  reason: collision with root package name */
    private int f20652q;

    /* renamed from: q0  reason: collision with root package name */
    private String f20653q0;

    /* renamed from: r  reason: collision with root package name */
    private int f20654r;

    /* renamed from: r0  reason: collision with root package name */
    private int f20655r0;

    /* renamed from: s  reason: collision with root package name */
    private int f20656s;

    /* renamed from: s0  reason: collision with root package name */
    private String f20657s0;

    /* renamed from: t  reason: collision with root package name */
    private int f20658t;

    /* renamed from: t0  reason: collision with root package name */
    private int f20659t0;

    /* renamed from: u  reason: collision with root package name */
    private int f20660u;

    /* renamed from: u0  reason: collision with root package name */
    private String f20661u0;

    /* renamed from: v  reason: collision with root package name */
    private int f20662v;

    /* renamed from: v0  reason: collision with root package name */
    private c f20663v0 = c.NONE;

    /* renamed from: w  reason: collision with root package name */
    private String f20664w;

    /* renamed from: w0  reason: collision with root package name */
    private HashMap f20665w0 = new HashMap();

    /* renamed from: x  reason: collision with root package name */
    private C2053k f20666x;

    /* renamed from: x0  reason: collision with root package name */
    private int f20667x0;

    /* renamed from: y  reason: collision with root package name */
    private int f20668y;

    /* renamed from: y0  reason: collision with root package name */
    private int f20669y0;

    /* renamed from: z  reason: collision with root package name */
    private String f20670z;

    /* renamed from: z0  reason: collision with root package name */
    private int f20671z0;

    /* renamed from: g2.h$a */
    public static final class a implements Parcelable.Creator {
        a() {
        }

        /* renamed from: a */
        public C2050h createFromParcel(Parcel parcel) {
            m.e(parcel, "source");
            return new C2050h(parcel);
        }

        /* renamed from: b */
        public C2050h[] newArray(int i4) {
            return new C2050h[i4];
        }
    }

    /* renamed from: g2.h$b */
    public static final class b {
        public /* synthetic */ b(C2103g gVar) {
            this();
        }

        public static /* synthetic */ C2050h b(b bVar, JSONObject jSONObject, Context context, int i4, Object obj) {
            if ((i4 & 2) != 0) {
                context = null;
            }
            return bVar.a(jSONObject, context);
        }

        public final C2050h a(JSONObject jSONObject, Context context) {
            m.e(jSONObject, "jsonObjectData");
            C2050h hVar = new C2050h();
            hVar.a(jSONObject, context);
            return hVar;
        }

        public final boolean c(String str) {
            return m.a(str, "Discontinued");
        }

        public final boolean d(String str) {
            if (str == null || g(str) || c(str) || e(str) || h(str) || f(str)) {
                return false;
            }
            return true;
        }

        public final boolean e(String str) {
            return m.a(str, "ExternalDownload");
        }

        public final boolean f(String str) {
            return m.a(str, "AppNotAvailableInThisCountry");
        }

        public final boolean g(String str) {
            return m.a(str, "PreRegister");
        }

        public final boolean h(String str) {
            return m.a(str, "ReadingMode");
        }

        private b() {
        }
    }

    /* renamed from: g2.h$c */
    public enum c {
        UPDATE,
        PROMOTED,
        LATEST,
        EDITOR_CHOICE,
        TRENDING,
        NONE;

        static {
            c[] a5;
            f20679h = X2.b.a(a5);
        }
    }

    public C2050h() {
    }

    private final boolean C0() {
        if (this.f20655r0 > 1) {
            return true;
        }
        return false;
    }

    private final void K0(JSONObject jSONObject, Context context) {
        JSONObject optJSONObject;
        if (!jSONObject.isNull("appID")) {
            this.f20632a = jSONObject.optLong("appID");
        }
        if (!jSONObject.isNull(RewardPlus.NAME)) {
            this.f20633b = jSONObject.optString(RewardPlus.NAME);
        }
        if (!jSONObject.isNull("license")) {
            this.f20639h = jSONObject.optString("license");
        }
        if (!jSONObject.isNull("lastVersionCode")) {
            this.f20635d = jSONObject.optLong("lastVersionCode");
        }
        if (!jSONObject.isNull("shortDescription")) {
            this.f20637f = jSONObject.optString("shortDescription");
        }
        if (!jSONObject.isNull("iconURL")) {
            this.f20643l = jSONObject.optString("iconURL");
        } else if (!jSONObject.isNull(RewardPlus.ICON)) {
            this.f20643l = jSONObject.optString(RewardPlus.ICON);
        }
        if (!jSONObject.isNull("feature")) {
            this.f20644m = jSONObject.optString("feature");
        } else if (!jSONObject.isNull("imageURL")) {
            this.f20644m = jSONObject.optString("imageURL");
        }
        if (!jSONObject.isNull("author")) {
            this.f20646n = jSONObject.optString("author");
        }
        if (!jSONObject.isNull("size")) {
            this.f20638g = jSONObject.optString("size");
        }
        if (!jSONObject.isNull("downloads")) {
            this.f20640i = jSONObject.optInt("downloads");
        }
        if (!jSONObject.isNull("weeklyDownloads")) {
            this.f20641j = jSONObject.optInt("weeklyDownloads");
        }
        if (!jSONObject.isNull("lastUpdate")) {
            this.f20642k = jSONObject.optString("lastUpdate");
        }
        if (!jSONObject.isNull("urlShare")) {
            this.f20636e = jSONObject.optString("urlShare");
        }
        if (!jSONObject.isNull("description")) {
            String optString = jSONObject.optString("description");
            m.d(optString, "optString(...)");
            this.f20648o = m3.m.w(optString, "\n", "<br />", false, 4, (Object) null);
        }
        if (!jSONObject.isNull(CampaignEx.JSON_KEY_STAR)) {
            this.f20650p = jSONObject.optInt(CampaignEx.JSON_KEY_STAR);
        }
        if (!jSONObject.isNull("ratingCount")) {
            this.f20652q = jSONObject.optInt("ratingCount");
        }
        if (!jSONObject.isNull("ratingCount1")) {
            this.f20654r = jSONObject.optInt("ratingCount1");
        }
        if (!jSONObject.isNull("ratingCount2")) {
            this.f20656s = jSONObject.optInt("ratingCount2");
        }
        if (!jSONObject.isNull("ratingCount3")) {
            this.f20658t = jSONObject.optInt("ratingCount3");
        }
        if (!jSONObject.isNull("ratingCount4")) {
            this.f20660u = jSONObject.optInt("ratingCount4");
        }
        if (!jSONObject.isNull("ratingCount5")) {
            this.f20662v = jSONObject.optInt("ratingCount5");
        }
        if (!jSONObject.isNull("packagename")) {
            this.f20664w = jSONObject.optString("packagename");
        } else if (!jSONObject.isNull("packageName")) {
            this.f20664w = jSONObject.optString("packageName");
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("categoryData");
        if (optJSONObject2 != null) {
            C2053k kVar = new C2053k(0, (String) null, (String) null, 7, (C2103g) null);
            this.f20666x = kVar;
            m.b(kVar);
            kVar.k(optJSONObject2);
        }
        if (!jSONObject.isNull("permissionCount")) {
            this.f20668y = jSONObject.optInt("permissionCount");
        }
        if (!jSONObject.isNull("md5Signature")) {
            this.f20607D = jSONObject.optString("md5Signature");
        }
        if (!jSONObject.isNull("activeADEX")) {
            this.f20605C = jSONObject.optInt("activeADEX");
        }
        if (!jSONObject.isNull("pegi")) {
            this.f20611F = jSONObject.optString("pegi");
        }
        if (!jSONObject.isNull("technicalData")) {
            this.f20613H = jSONObject.optString("technicalData");
        }
        if (!jSONObject.isNull("versionRequired")) {
            this.f20614I = jSONObject.optString("versionRequired");
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("compatibleFile");
        if (optJSONObject3 != null) {
            JSONArray optJSONArray = optJSONObject3.optJSONArray("densities");
            if (optJSONArray != null) {
                this.f20615J = new ArrayList();
                int length = optJSONArray.length();
                for (int i4 = 0; i4 < length; i4++) {
                    ArrayList arrayList = this.f20615J;
                    if (arrayList != null) {
                        arrayList.add(optJSONArray.optString(i4));
                    }
                }
            }
            JSONArray optJSONArray2 = optJSONObject3.optJSONArray("abis");
            if (optJSONArray2 != null) {
                this.f20616K = new ArrayList();
                int length2 = optJSONArray2.length();
                for (int i5 = 0; i5 < length2; i5++) {
                    ArrayList arrayList2 = this.f20616K;
                    if (arrayList2 != null) {
                        arrayList2.add(optJSONArray2.optString(i5));
                    }
                }
            }
            if (!optJSONObject3.isNull("fileID")) {
                this.f20601A = optJSONObject3.optLong("fileID");
            }
            if (!optJSONObject3.isNull("minSDK")) {
                this.f20670z = optJSONObject3.optString("minSDK");
            }
            if (!optJSONObject3.isNull("version")) {
                this.f20634c = optJSONObject3.optString("version");
            }
            if (!optJSONObject3.isNull("sha256")) {
                this.f20612G = optJSONObject3.optString("sha256");
            }
            if (!optJSONObject3.isNull("url_apk")) {
                this.f20609E = optJSONObject3.optString("url_apk");
            }
            JSONArray optJSONArray3 = optJSONObject3.optJSONArray("requiredFeatures");
            if (optJSONArray3 != null) {
                this.f20617L = new ArrayList();
                int length3 = optJSONArray3.length();
                for (int i6 = 0; i6 < length3; i6++) {
                    ArrayList arrayList3 = this.f20617L;
                    if (arrayList3 != null) {
                        arrayList3.add(optJSONArray3.optString(i6));
                    }
                }
                ArrayList arrayList4 = this.f20617L;
                m.b(arrayList4);
                if (!arrayList4.isEmpty() && context != null) {
                    r rVar = new r();
                    ArrayList arrayList5 = this.f20617L;
                    m.b(arrayList5);
                    ArrayList e5 = rVar.e(arrayList5, context);
                    if (!e5.isEmpty()) {
                        Iterator it = e5.iterator();
                        m.d(it, "iterator(...)");
                        while (it.hasNext()) {
                            Object next = it.next();
                            m.d(next, "next(...)");
                            Bundle bundle = new Bundle();
                            bundle.putInt("update", 0);
                            bundle.putString("feature", (String) next);
                            new x(context).d("required_features_not_supported", bundle);
                        }
                    }
                }
            }
        }
        if (!jSONObject.isNull("website")) {
            this.f20618M = jSONObject.optString("website");
        }
        if (!jSONObject.isNull("downloadStatus")) {
            String optString2 = jSONObject.optString("downloadStatus");
            this.f20619N = optString2;
            if (m3.m.q(optString2, "PreRegister", false, 2, (Object) null) && (optJSONObject = jSONObject.optJSONObject("preRegister")) != null) {
                if (!optJSONObject.isNull("date")) {
                    this.f20623R = optJSONObject.optString("date");
                }
                if (!optJSONObject.isNull("countPreRegistered")) {
                    this.f20624S = optJSONObject.optString("countPreRegistered");
                }
            }
        }
        if (!jSONObject.isNull("newFeatures")) {
            this.f20625T = jSONObject.optString("newFeatures");
        }
        if (!jSONObject.isNull("onBoard")) {
            this.f20626U = jSONObject.optInt("onBoard");
        }
        if (!jSONObject.isNull("responsibilities")) {
            this.f20627V = jSONObject.optString("responsibilities");
        }
        if (!jSONObject.isNull(TypedValues.CycleType.S_WAVE_PHASE)) {
            this.f20628W = jSONObject.optString(TypedValues.CycleType.S_WAVE_PHASE);
        }
        if (!jSONObject.isNull("deviceType")) {
            this.f20629X = jSONObject.optString("deviceType");
        }
        JSONObject optJSONObject4 = jSONObject.optJSONObject("translations");
        if (optJSONObject4 != null) {
            this.f20665w0 = new HashMap();
            if (!optJSONObject4.isNull("try")) {
                HashMap hashMap = this.f20665w0;
                m.b(hashMap);
                hashMap.put("try", optJSONObject4.optString("try"));
            }
            if (!optJSONObject4.isNull("supportedDevice")) {
                HashMap hashMap2 = this.f20665w0;
                m.b(hashMap2);
                hashMap2.put("supportedDevice", optJSONObject4.optString("supportedDevice"));
            }
        }
        if (!jSONObject.isNull("readingModeText")) {
            this.f20630Y = jSONObject.optString("readingModeText");
        }
        if (!jSONObject.isNull("externalDownloadURL")) {
            this.f20631Z = jSONObject.optString("externalDownloadURL");
        }
        if (!jSONObject.isNull("externalDownloadText")) {
            this.f20645m0 = jSONObject.optString("externalDownloadText");
        }
        if (!jSONObject.isNull("organizationID")) {
            this.f20647n0 = jSONObject.optLong("organizationID");
        }
        if (!jSONObject.isNull("editorNameNew")) {
            this.f20649o0 = jSONObject.optString("editorNameNew");
        }
        if (!jSONObject.isNull("editorAvatar")) {
            this.f20651p0 = jSONObject.optString("editorAvatar");
        }
        if (!jSONObject.isNull("showReviewedBy")) {
            this.f20659t0 = jSONObject.optInt("showReviewedBy");
        }
        if (!jSONObject.isNull("editorJobTitle")) {
            this.f20653q0 = jSONObject.optString("editorJobTitle");
        }
        if (!jSONObject.isNull("totalVersions")) {
            this.f20655r0 = jSONObject.optInt("totalVersions");
        }
        if (!jSONObject.isNull("disclaimerText")) {
            this.f20657s0 = jSONObject.optString("disclaimerText");
        }
        if (!jSONObject.isNull("tagID")) {
            int optInt = jSONObject.optInt("tagID");
            if (optInt == 0) {
                this.f20663v0 = c.NONE;
            } else if (optInt == 1) {
                this.f20663v0 = c.TRENDING;
            } else if (optInt == 2) {
                this.f20663v0 = c.LATEST;
            } else if (optInt == 3) {
                this.f20663v0 = c.UPDATE;
            } else if (optInt == 4) {
                this.f20663v0 = c.PROMOTED;
            } else if (optInt == 5) {
                this.f20663v0 = c.EDITOR_CHOICE;
            }
            if (!jSONObject.isNull("tag")) {
                this.f20661u0 = jSONObject.optString("tag");
            }
        }
        if (!jSONObject.isNull("promoted")) {
            this.f20667x0 = jSONObject.optInt("promoted");
        }
        if (!jSONObject.isNull("containsAds")) {
            this.f20669y0 = jSONObject.optInt("containsAds");
        }
        if (!jSONObject.isNull("hasAlternatives")) {
            if (jSONObject.optBoolean("hasAlternatives")) {
                this.f20671z0 = 1;
            } else {
                this.f20671z0 = 0;
            }
        }
        if (!jSONObject.isNull("wishlist")) {
            this.f20604B0 = jSONObject.optInt("wishlist");
        }
        JSONArray optJSONArray4 = jSONObject.optJSONArray("userSays");
        if (optJSONArray4 != null) {
            this.f20608D0 = new ArrayList();
            int length4 = optJSONArray4.length();
            for (int i7 = 0; i7 < length4; i7++) {
                ArrayList arrayList6 = this.f20608D0;
                m.b(arrayList6);
                arrayList6.add(optJSONArray4.getString(i7));
            }
        }
        if (!jSONObject.isNull("recommended")) {
            this.f20606C0 = jSONObject.optInt("recommended");
        }
    }

    public static /* synthetic */ void b(C2050h hVar, JSONObject jSONObject, Context context, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            context = null;
        }
        hVar.a(jSONObject, context);
    }

    public final int A() {
        return this.f20671z0;
    }

    public final int A0() {
        return this.f20604B0;
    }

    public final String B() {
        if (this.f20644m == null) {
            return null;
        }
        return this.f20644m + UptodownApp.f17422D.p() + ":webp";
    }

    public final boolean B0() {
        if (this.f20601A >= 0) {
            return true;
        }
        return false;
    }

    public final String C() {
        return this.f20643l;
    }

    public final String D(int i4) {
        if (this.f20643l == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(':');
        sb.append(i4);
        String sb2 = sb.toString();
        return this.f20643l + sb2 + ":webp";
    }

    public final boolean D0() {
        return f20600F0.c(this.f20619N);
    }

    public final String E() {
        if (this.f20643l == null) {
            return null;
        }
        return this.f20643l + UptodownApp.f17422D.q() + ":webp";
    }

    public final boolean E0() {
        return f20600F0.d(this.f20619N);
    }

    public final String F() {
        if (this.f20643l == null) {
            return null;
        }
        return this.f20643l + UptodownApp.f17422D.r() + ":webp";
    }

    public final boolean F0() {
        return f20600F0.e(this.f20619N);
    }

    public final String G() {
        return this.f20642k;
    }

    public final boolean G0() {
        return f20600F0.f(this.f20619N);
    }

    public final long H() {
        return this.f20635d;
    }

    public final boolean H0() {
        return f20600F0.g(this.f20619N);
    }

    public final String I() {
        return this.f20639h;
    }

    public final boolean I0() {
        if (this.f20667x0 == 1) {
            return true;
        }
        return false;
    }

    public final String J() {
        return this.f20607D;
    }

    public final boolean J0() {
        return f20600F0.h(this.f20619N);
    }

    public final String K() {
        return this.f20670z;
    }

    public final String L() {
        return this.f20633b;
    }

    public final void L0(long j4) {
        this.f20632a = j4;
    }

    public final String M() {
        return this.f20625T;
    }

    public final void M0(String str) {
        this.f20644m = str;
    }

    public final boolean N() {
        return this.f20602A0;
    }

    public final void N0(long j4) {
        this.f20601A = j4;
    }

    public final ArrayList O() {
        return this.f20610E0;
    }

    public final void O0(boolean z4) {
        this.f20602A0 = z4;
    }

    public final long P() {
        return this.f20647n0;
    }

    public final void P0(ArrayList arrayList) {
        this.f20610E0 = arrayList;
    }

    public final String Q() {
        return this.f20664w;
    }

    public final void Q0(int i4) {
        this.f20606C0 = i4;
    }

    public final String R() {
        return this.f20611F;
    }

    public final void R0(K k4) {
        this.f20622Q = k4;
    }

    public final int S() {
        return this.f20668y;
    }

    public final void S0(ArrayList arrayList) {
        this.f20620O = arrayList;
    }

    public final String T() {
        return this.f20628W;
    }

    public final void T0(String str) {
        this.f20612G = str;
    }

    public final String U() {
        return this.f20624S;
    }

    public final void U0(long j4) {
        this.f20603B = j4;
    }

    public final int V() {
        return this.f20650p;
    }

    public final void V0(ArrayList arrayList) {
        this.f20621P = arrayList;
    }

    public final int W() {
        return this.f20652q;
    }

    public final void W0(int i4) {
        this.f20604B0 = i4;
    }

    public final int X() {
        return this.f20654r;
    }

    public final int Y() {
        return this.f20656s;
    }

    public final int Z() {
        return this.f20658t;
    }

    public final void a(JSONObject jSONObject, Context context) {
        m.e(jSONObject, "jsonObjectData");
        if (jSONObject.has(MBridgeConstans.DYNAMIC_VIEW_WX_APP)) {
            JSONObject optJSONObject = jSONObject.optJSONObject(MBridgeConstans.DYNAMIC_VIEW_WX_APP);
            if (optJSONObject != null) {
                K0(optJSONObject, context);
            }
        } else {
            K0(jSONObject, context);
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("videos");
        if (optJSONArray != null) {
            this.f20621P = new ArrayList();
            int length = optJSONArray.length();
            for (int i4 = 0; i4 < length; i4++) {
                if (optJSONArray.get(i4) instanceof JSONObject) {
                    Z.b bVar = Z.f20518c;
                    Object obj = optJSONArray.get(i4);
                    m.c(obj, "null cannot be cast to non-null type org.json.JSONObject");
                    Z a5 = bVar.a((JSONObject) obj);
                    ArrayList arrayList = this.f20621P;
                    m.b(arrayList);
                    arrayList.add(a5);
                }
            }
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray("screenshots");
        if (optJSONArray2 != null) {
            this.f20620O = new ArrayList();
            int length2 = optJSONArray2.length();
            for (int i5 = 0; i5 < length2; i5++) {
                if (optJSONArray2.get(i5) instanceof JSONObject) {
                    O.b bVar2 = O.f20438e;
                    Object obj2 = optJSONArray2.get(i5);
                    m.c(obj2, "null cannot be cast to non-null type org.json.JSONObject");
                    O b5 = bVar2.b((JSONObject) obj2);
                    ArrayList arrayList2 = this.f20620O;
                    if (arrayList2 != null) {
                        arrayList2.add(b5);
                    }
                }
            }
        }
    }

    public final int a0() {
        return this.f20660u;
    }

    public final int b0() {
        return this.f20662v;
    }

    public final boolean c() {
        if (J0() || F0() || !C0() || G0()) {
            return false;
        }
        return true;
    }

    public final String c0() {
        return this.f20630Y;
    }

    public final int d() {
        return this.f20605C;
    }

    public final int d0() {
        return this.f20606C0;
    }

    public int describeContents() {
        return hashCode();
    }

    public final long e() {
        return this.f20632a;
    }

    public final K e0() {
        return this.f20622Q;
    }

    public final long f(L l4) {
        int i4;
        m.e(l4, "responseJson");
        try {
            if (l4.b() || l4.e() == null) {
                return 0;
            }
            JSONObject e5 = l4.e();
            m.b(e5);
            if (!e5.isNull("success")) {
                i4 = e5.optInt("success");
            } else {
                i4 = 0;
            }
            JSONObject optJSONObject = e5.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
            if (i4 != 1 || optJSONObject == null || optJSONObject.isNull("appID")) {
                return 0;
            }
            return optJSONObject.optLong("appID");
        } catch (JSONException e6) {
            e6.printStackTrace();
            return -1;
        }
    }

    public final ArrayList f0() {
        return this.f20617L;
    }

    public final String g() {
        return this.f20646n;
    }

    public final String g0() {
        return this.f20627V;
    }

    public final C2053k h() {
        return this.f20666x;
    }

    public final ArrayList h0() {
        return this.f20620O;
    }

    public final int i() {
        return this.f20669y0;
    }

    public final String i0() {
        return this.f20612G;
    }

    public final String j() {
        return this.f20648o;
    }

    public final String j0() {
        return this.f20637f;
    }

    public final int k() {
        return this.f20626U;
    }

    public final int k0() {
        return this.f20659t0;
    }

    public final String l() {
        return this.f20629X;
    }

    public final String l0() {
        return this.f20638g;
    }

    public final String m() {
        return this.f20657s0;
    }

    public final ArrayList m0() {
        return this.f20616K;
    }

    public final String n() {
        return this.f20619N;
    }

    public final ArrayList n0() {
        return this.f20615J;
    }

    public final String o() {
        return this.f20609E;
    }

    public final String o0() {
        return this.f20661u0;
    }

    public final int p() {
        return this.f20640i;
    }

    public final c p0() {
        return this.f20663v0;
    }

    public final String q() {
        return this.f20651p0;
    }

    public final String q0() {
        return this.f20613H;
    }

    public final String r() {
        return this.f20653q0;
    }

    public final int r0() {
        return this.f20655r0;
    }

    public final String s() {
        return this.f20649o0;
    }

    public final String s0(String str) {
        m.e(str, LeanbackPreferenceDialogFragment.ARG_KEY);
        HashMap hashMap = this.f20665w0;
        if (hashMap != null) {
            return (String) hashMap.get(str);
        }
        return null;
    }

    public final String t() {
        return this.f20645m0;
    }

    public final String t0() {
        return this.f20636e;
    }

    public String toString() {
        return "AppInfo(appID=" + this.f20632a + ", name=" + this.f20633b + ", versionName=" + this.f20634c + ", lastVersionCode=" + this.f20635d + ", urlShare=" + this.f20636e + ", shortDescription=" + this.f20637f + ", size=" + this.f20638g + ", license=" + this.f20639h + ", downloads=" + this.f20640i + ", weeklyDownloads=" + this.f20641j + ", lastUpdate=" + this.f20642k + ", icon=" + this.f20643l + ", feature=" + this.f20644m + ", author=" + this.f20646n + ", description=" + this.f20648o + ", rating=" + this.f20650p + ", ratingCount=" + this.f20652q + ", ratingCount1=" + this.f20654r + ", ratingCount2=" + this.f20656s + ", ratingCount3=" + this.f20658t + ", ratingCount4=" + this.f20660u + ", ratingCount5=" + this.f20662v + ", packagename=" + this.f20664w + ", screenShots=" + this.f20620O + ", category=" + this.f20666x + ", permissionCount=" + this.f20668y + ", minsdk=" + this.f20670z + ", md5signature=" + this.f20607D + ", downloadUrl=" + this.f20609E + ", fileID=" + this.f20601A + ", oldVersions=" + this.f20610E0 + ", activeADEX=" + this.f20605C + ", sha256=" + this.f20612G + ", technicalData=" + this.f20613H + ", versionRequired=" + this.f20614I + ", webAuthor=" + this.f20618M + ", downloadStatus=" + this.f20619N + ", devOnBoard=" + this.f20626U + ", responsibilities=" + this.f20627V + ", phase=" + this.f20628W + ", readingModeText=" + this.f20630Y + ", externalDownloadUrl=" + this.f20631Z + ", newFeatures=" + this.f20625T + ", preRegisterDate=" + this.f20623R + ", preRegistersCount=" + this.f20624S + ", editorAvatar=" + this.f20651p0 + ", editorJobTitle=" + this.f20653q0 + ", showReviewedBy=" + this.f20659t0 + ", containAds=" + this.f20669y0 + ", hasAlternatives=" + this.f20671z0 + ", wishlist=" + this.f20604B0 + ", deviceType=" + this.f20629X + ", translations=" + this.f20665w0 + ", supportedDensities=" + this.f20615J + ", supportedAbis=" + this.f20616K + ", requiredFeatures=" + this.f20617L + ", pegi=" + this.f20611F + ", externalDownloadText=" + this.f20645m0 + ", organizationID=" + this.f20647n0 + ", editorName=" + this.f20649o0 + ", totalVersions=" + this.f20655r0 + ", disclaimerText=" + this.f20657s0 + ')';
    }

    public final String u() {
        return this.f20631Z;
    }

    public final ArrayList u0() {
        return this.f20608D0;
    }

    public final String v() {
        return this.f20644m;
    }

    public final long v0() {
        return this.f20603B;
    }

    public final String w() {
        if (this.f20644m == null) {
            return null;
        }
        UptodownApp.a aVar = UptodownApp.f17422D;
        if (aVar.x() <= 0) {
            return y();
        }
        return this.f20644m + ':' + aVar.x() + ":webp";
    }

    public final String w0() {
        return this.f20634c;
    }

    public void writeToParcel(Parcel parcel, int i4) {
        m.e(parcel, "parcel");
        parcel.writeLong(this.f20632a);
        parcel.writeString(this.f20633b);
        parcel.writeString(this.f20634c);
        parcel.writeLong(this.f20635d);
        parcel.writeString(this.f20636e);
        parcel.writeString(this.f20637f);
        parcel.writeString(this.f20638g);
        parcel.writeString(this.f20639h);
        parcel.writeInt(this.f20640i);
        parcel.writeInt(this.f20641j);
        parcel.writeString(this.f20642k);
        parcel.writeString(this.f20643l);
        parcel.writeString(this.f20644m);
        parcel.writeString(this.f20646n);
        parcel.writeString(this.f20648o);
        parcel.writeInt(this.f20650p);
        parcel.writeInt(this.f20652q);
        parcel.writeInt(this.f20654r);
        parcel.writeInt(this.f20656s);
        parcel.writeInt(this.f20658t);
        parcel.writeInt(this.f20660u);
        parcel.writeInt(this.f20662v);
        parcel.writeString(this.f20664w);
        parcel.writeParcelable(this.f20666x, i4);
        parcel.writeInt(this.f20668y);
        parcel.writeString(this.f20670z);
        parcel.writeString(this.f20607D);
        parcel.writeString(this.f20609E);
        parcel.writeLong(this.f20601A);
        parcel.writeInt(this.f20605C);
        parcel.writeString(this.f20612G);
        parcel.writeString(this.f20613H);
        parcel.writeString(this.f20614I);
        parcel.writeStringList(this.f20615J);
        parcel.writeStringList(this.f20616K);
        parcel.writeStringList(this.f20617L);
        parcel.writeString(this.f20618M);
        parcel.writeString(this.f20619N);
        parcel.writeString(this.f20611F);
        parcel.writeInt(this.f20626U);
        parcel.writeString(this.f20629X);
        parcel.writeMap(this.f20665w0);
        parcel.writeString(this.f20630Y);
        parcel.writeString(this.f20631Z);
        parcel.writeString(this.f20645m0);
        parcel.writeLong(this.f20647n0);
        parcel.writeString(this.f20649o0);
        parcel.writeInt(this.f20655r0);
        parcel.writeString(this.f20627V);
        parcel.writeString(this.f20625T);
        parcel.writeString(this.f20623R);
        parcel.writeString(this.f20624S);
        parcel.writeString(this.f20651p0);
        parcel.writeString(this.f20653q0);
        parcel.writeString(this.f20657s0);
        parcel.writeInt(this.f20659t0);
        parcel.writeInt(this.f20669y0);
        parcel.writeInt(this.f20671z0);
        parcel.writeInt(this.f20604B0);
        parcel.writeStringList(this.f20608D0);
        parcel.writeInt(this.f20606C0);
    }

    public final String x() {
        if (this.f20644m == null) {
            return null;
        }
        return this.f20644m + UptodownApp.f17422D.n() + ":webp";
    }

    public final String x0() {
        return this.f20614I;
    }

    public final String y() {
        if (this.f20644m == null) {
            return null;
        }
        return this.f20644m + UptodownApp.f17422D.o() + ":webp";
    }

    public final ArrayList y0() {
        return this.f20621P;
    }

    public final long z() {
        return this.f20601A;
    }

    public final String z0() {
        return this.f20618M;
    }

    public C2050h(Parcel parcel) {
        m.e(parcel, "source");
        this.f20632a = parcel.readLong();
        this.f20633b = parcel.readString();
        this.f20634c = parcel.readString();
        this.f20635d = parcel.readLong();
        this.f20636e = parcel.readString();
        this.f20637f = parcel.readString();
        this.f20638g = parcel.readString();
        this.f20639h = parcel.readString();
        this.f20640i = parcel.readInt();
        this.f20641j = parcel.readInt();
        this.f20642k = parcel.readString();
        this.f20643l = parcel.readString();
        this.f20644m = parcel.readString();
        this.f20646n = parcel.readString();
        this.f20648o = parcel.readString();
        this.f20650p = parcel.readInt();
        this.f20652q = parcel.readInt();
        this.f20654r = parcel.readInt();
        this.f20656s = parcel.readInt();
        this.f20658t = parcel.readInt();
        this.f20660u = parcel.readInt();
        this.f20662v = parcel.readInt();
        this.f20664w = parcel.readString();
        Class<C2053k> cls = C2053k.class;
        if (Build.VERSION.SDK_INT >= 33) {
            this.f20666x = (C2053k) parcel.readParcelable(cls.getClassLoader(), cls);
        } else {
            this.f20666x = (C2053k) parcel.readParcelable(cls.getClassLoader());
        }
        this.f20668y = parcel.readInt();
        this.f20670z = parcel.readString();
        this.f20607D = parcel.readString();
        this.f20609E = parcel.readString();
        this.f20601A = parcel.readLong();
        this.f20605C = parcel.readInt();
        this.f20612G = parcel.readString();
        this.f20613H = parcel.readString();
        this.f20614I = parcel.readString();
        this.f20615J = parcel.createStringArrayList();
        this.f20616K = parcel.createStringArrayList();
        this.f20617L = parcel.createStringArrayList();
        this.f20618M = parcel.readString();
        this.f20619N = parcel.readString();
        this.f20611F = parcel.readString();
        this.f20626U = parcel.readInt();
        this.f20629X = parcel.readString();
        HashMap readHashMap = parcel.readHashMap(ClassLoader.getSystemClassLoader());
        m.c(readHashMap, "null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.String>");
        this.f20665w0 = readHashMap;
        this.f20630Y = parcel.readString();
        this.f20631Z = parcel.readString();
        this.f20645m0 = parcel.readString();
        this.f20647n0 = parcel.readLong();
        this.f20649o0 = parcel.readString();
        this.f20655r0 = parcel.readInt();
        this.f20627V = parcel.readString();
        this.f20625T = parcel.readString();
        this.f20623R = parcel.readString();
        this.f20624S = parcel.readString();
        this.f20651p0 = parcel.readString();
        this.f20653q0 = parcel.readString();
        this.f20657s0 = parcel.readString();
        this.f20659t0 = parcel.readInt();
        this.f20669y0 = parcel.readInt();
        this.f20671z0 = parcel.readInt();
        this.f20604B0 = parcel.readInt();
        this.f20608D0 = parcel.createStringArrayList();
        this.f20606C0 = parcel.readInt();
    }
}
