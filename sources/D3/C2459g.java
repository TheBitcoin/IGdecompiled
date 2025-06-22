package D3;

import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* renamed from: D3.g  reason: case insensitive filesystem */
public final class C2459g {

    /* renamed from: A  reason: collision with root package name */
    public static final C2459g f22943A = d("TLS_KRB5_WITH_3DES_EDE_CBC_MD5", 35);

    /* renamed from: A0  reason: collision with root package name */
    public static final C2459g f22944A0 = d("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", 49161);

    /* renamed from: B  reason: collision with root package name */
    public static final C2459g f22945B = d("TLS_KRB5_WITH_RC4_128_MD5", 36);

    /* renamed from: B0  reason: collision with root package name */
    public static final C2459g f22946B0 = d("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", 49162);

    /* renamed from: C  reason: collision with root package name */
    public static final C2459g f22947C = d("TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA", 38);

    /* renamed from: C0  reason: collision with root package name */
    public static final C2459g f22948C0 = d("TLS_ECDH_RSA_WITH_NULL_SHA", 49163);

    /* renamed from: D  reason: collision with root package name */
    public static final C2459g f22949D = d("TLS_KRB5_EXPORT_WITH_RC4_40_SHA", 40);

    /* renamed from: D0  reason: collision with root package name */
    public static final C2459g f22950D0 = d("TLS_ECDH_RSA_WITH_RC4_128_SHA", 49164);

    /* renamed from: E  reason: collision with root package name */
    public static final C2459g f22951E = d("TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5", 41);

    /* renamed from: E0  reason: collision with root package name */
    public static final C2459g f22952E0 = d("TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA", 49165);

    /* renamed from: F  reason: collision with root package name */
    public static final C2459g f22953F = d("TLS_KRB5_EXPORT_WITH_RC4_40_MD5", 43);

    /* renamed from: F0  reason: collision with root package name */
    public static final C2459g f22954F0 = d("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA", 49166);

    /* renamed from: G  reason: collision with root package name */
    public static final C2459g f22955G = d("TLS_RSA_WITH_AES_128_CBC_SHA", 47);

    /* renamed from: G0  reason: collision with root package name */
    public static final C2459g f22956G0 = d("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA", 49167);

    /* renamed from: H  reason: collision with root package name */
    public static final C2459g f22957H = d("TLS_DHE_DSS_WITH_AES_128_CBC_SHA", 50);

    /* renamed from: H0  reason: collision with root package name */
    public static final C2459g f22958H0 = d("TLS_ECDHE_RSA_WITH_NULL_SHA", 49168);

    /* renamed from: I  reason: collision with root package name */
    public static final C2459g f22959I = d("TLS_DHE_RSA_WITH_AES_128_CBC_SHA", 51);

    /* renamed from: I0  reason: collision with root package name */
    public static final C2459g f22960I0 = d("TLS_ECDHE_RSA_WITH_RC4_128_SHA", 49169);

    /* renamed from: J  reason: collision with root package name */
    public static final C2459g f22961J = d("TLS_DH_anon_WITH_AES_128_CBC_SHA", 52);

    /* renamed from: J0  reason: collision with root package name */
    public static final C2459g f22962J0 = d("TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA", 49170);

    /* renamed from: K  reason: collision with root package name */
    public static final C2459g f22963K = d("TLS_RSA_WITH_AES_256_CBC_SHA", 53);

    /* renamed from: K0  reason: collision with root package name */
    public static final C2459g f22964K0 = d("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", 49171);

    /* renamed from: L  reason: collision with root package name */
    public static final C2459g f22965L = d("TLS_DHE_DSS_WITH_AES_256_CBC_SHA", 56);

    /* renamed from: L0  reason: collision with root package name */
    public static final C2459g f22966L0 = d("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", 49172);

    /* renamed from: M  reason: collision with root package name */
    public static final C2459g f22967M = d("TLS_DHE_RSA_WITH_AES_256_CBC_SHA", 57);

    /* renamed from: M0  reason: collision with root package name */
    public static final C2459g f22968M0 = d("TLS_ECDH_anon_WITH_NULL_SHA", 49173);

    /* renamed from: N  reason: collision with root package name */
    public static final C2459g f22969N = d("TLS_DH_anon_WITH_AES_256_CBC_SHA", 58);

    /* renamed from: N0  reason: collision with root package name */
    public static final C2459g f22970N0 = d("TLS_ECDH_anon_WITH_RC4_128_SHA", 49174);

    /* renamed from: O  reason: collision with root package name */
    public static final C2459g f22971O = d("TLS_RSA_WITH_NULL_SHA256", 59);

    /* renamed from: O0  reason: collision with root package name */
    public static final C2459g f22972O0 = d("TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA", 49175);

    /* renamed from: P  reason: collision with root package name */
    public static final C2459g f22973P = d("TLS_RSA_WITH_AES_128_CBC_SHA256", 60);

    /* renamed from: P0  reason: collision with root package name */
    public static final C2459g f22974P0 = d("TLS_ECDH_anon_WITH_AES_128_CBC_SHA", 49176);

    /* renamed from: Q  reason: collision with root package name */
    public static final C2459g f22975Q = d("TLS_RSA_WITH_AES_256_CBC_SHA256", 61);

    /* renamed from: Q0  reason: collision with root package name */
    public static final C2459g f22976Q0 = d("TLS_ECDH_anon_WITH_AES_256_CBC_SHA", 49177);

    /* renamed from: R  reason: collision with root package name */
    public static final C2459g f22977R = d("TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", 64);

    /* renamed from: R0  reason: collision with root package name */
    public static final C2459g f22978R0 = d("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256", 49187);

    /* renamed from: S  reason: collision with root package name */
    public static final C2459g f22979S = d("TLS_RSA_WITH_CAMELLIA_128_CBC_SHA", 65);

    /* renamed from: S0  reason: collision with root package name */
    public static final C2459g f22980S0 = d("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384", 49188);

    /* renamed from: T  reason: collision with root package name */
    public static final C2459g f22981T = d("TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA", 68);

    /* renamed from: T0  reason: collision with root package name */
    public static final C2459g f22982T0 = d("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256", 49189);

    /* renamed from: U  reason: collision with root package name */
    public static final C2459g f22983U = d("TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA", 69);

    /* renamed from: U0  reason: collision with root package name */
    public static final C2459g f22984U0 = d("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384", 49190);

    /* renamed from: V  reason: collision with root package name */
    public static final C2459g f22985V = d("TLS_DHE_RSA_WITH_AES_128_CBC_SHA256", 103);

    /* renamed from: V0  reason: collision with root package name */
    public static final C2459g f22986V0 = d("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", 49191);

    /* renamed from: W  reason: collision with root package name */
    public static final C2459g f22987W = d("TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", 106);

    /* renamed from: W0  reason: collision with root package name */
    public static final C2459g f22988W0 = d("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", 49192);

    /* renamed from: X  reason: collision with root package name */
    public static final C2459g f22989X = d("TLS_DHE_RSA_WITH_AES_256_CBC_SHA256", 107);

    /* renamed from: X0  reason: collision with root package name */
    public static final C2459g f22990X0 = d("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256", 49193);

    /* renamed from: Y  reason: collision with root package name */
    public static final C2459g f22991Y = d("TLS_DH_anon_WITH_AES_128_CBC_SHA256", 108);

    /* renamed from: Y0  reason: collision with root package name */
    public static final C2459g f22992Y0 = d("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384", 49194);

    /* renamed from: Z  reason: collision with root package name */
    public static final C2459g f22993Z = d("TLS_DH_anon_WITH_AES_256_CBC_SHA256", 109);

    /* renamed from: Z0  reason: collision with root package name */
    public static final C2459g f22994Z0 = d("TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", 49195);

    /* renamed from: a0  reason: collision with root package name */
    public static final C2459g f22995a0 = d("TLS_RSA_WITH_CAMELLIA_256_CBC_SHA", 132);

    /* renamed from: a1  reason: collision with root package name */
    public static final C2459g f22996a1 = d("TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", 49196);

    /* renamed from: b  reason: collision with root package name */
    static final Comparator f22997b;

    /* renamed from: b0  reason: collision with root package name */
    public static final C2459g f22998b0 = d("TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA", TsExtractor.TS_STREAM_TYPE_E_AC3);

    /* renamed from: b1  reason: collision with root package name */
    public static final C2459g f22999b1 = d("TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256", 49197);

    /* renamed from: c  reason: collision with root package name */
    private static final Map f23000c;

    /* renamed from: c0  reason: collision with root package name */
    public static final C2459g f23001c0 = d("TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA", 136);

    /* renamed from: c1  reason: collision with root package name */
    public static final C2459g f23002c1 = d("TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384", 49198);

    /* renamed from: d  reason: collision with root package name */
    public static final C2459g f23003d = d("SSL_RSA_WITH_NULL_MD5", 1);

    /* renamed from: d0  reason: collision with root package name */
    public static final C2459g f23004d0 = d("TLS_PSK_WITH_RC4_128_SHA", TsExtractor.TS_STREAM_TYPE_DTS);

    /* renamed from: d1  reason: collision with root package name */
    public static final C2459g f23005d1 = d("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", 49199);

    /* renamed from: e  reason: collision with root package name */
    public static final C2459g f23006e = d("SSL_RSA_WITH_NULL_SHA", 2);

    /* renamed from: e0  reason: collision with root package name */
    public static final C2459g f23007e0 = d("TLS_PSK_WITH_3DES_EDE_CBC_SHA", 139);

    /* renamed from: e1  reason: collision with root package name */
    public static final C2459g f23008e1 = d("TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", 49200);

    /* renamed from: f  reason: collision with root package name */
    public static final C2459g f23009f = d("SSL_RSA_EXPORT_WITH_RC4_40_MD5", 3);

    /* renamed from: f0  reason: collision with root package name */
    public static final C2459g f23010f0 = d("TLS_PSK_WITH_AES_128_CBC_SHA", 140);

    /* renamed from: f1  reason: collision with root package name */
    public static final C2459g f23011f1 = d("TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256", 49201);

    /* renamed from: g  reason: collision with root package name */
    public static final C2459g f23012g = d("SSL_RSA_WITH_RC4_128_MD5", 4);

    /* renamed from: g0  reason: collision with root package name */
    public static final C2459g f23013g0 = d("TLS_PSK_WITH_AES_256_CBC_SHA", 141);

    /* renamed from: g1  reason: collision with root package name */
    public static final C2459g f23014g1 = d("TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384", 49202);

    /* renamed from: h  reason: collision with root package name */
    public static final C2459g f23015h = d("SSL_RSA_WITH_RC4_128_SHA", 5);

    /* renamed from: h0  reason: collision with root package name */
    public static final C2459g f23016h0 = d("TLS_RSA_WITH_SEED_CBC_SHA", 150);

    /* renamed from: h1  reason: collision with root package name */
    public static final C2459g f23017h1 = d("TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA", 49205);

    /* renamed from: i  reason: collision with root package name */
    public static final C2459g f23018i = d("SSL_RSA_EXPORT_WITH_DES40_CBC_SHA", 8);

    /* renamed from: i0  reason: collision with root package name */
    public static final C2459g f23019i0 = d("TLS_RSA_WITH_AES_128_GCM_SHA256", 156);

    /* renamed from: i1  reason: collision with root package name */
    public static final C2459g f23020i1 = d("TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA", 49206);

    /* renamed from: j  reason: collision with root package name */
    public static final C2459g f23021j = d("SSL_RSA_WITH_DES_CBC_SHA", 9);

    /* renamed from: j0  reason: collision with root package name */
    public static final C2459g f23022j0 = d("TLS_RSA_WITH_AES_256_GCM_SHA384", 157);

    /* renamed from: j1  reason: collision with root package name */
    public static final C2459g f23023j1 = d("TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52392);

    /* renamed from: k  reason: collision with root package name */
    public static final C2459g f23024k = d("SSL_RSA_WITH_3DES_EDE_CBC_SHA", 10);

    /* renamed from: k0  reason: collision with root package name */
    public static final C2459g f23025k0 = d("TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", 158);

    /* renamed from: k1  reason: collision with root package name */
    public static final C2459g f23026k1 = d("TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", 52393);

    /* renamed from: l  reason: collision with root package name */
    public static final C2459g f23027l = d("SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA", 17);

    /* renamed from: l0  reason: collision with root package name */
    public static final C2459g f23028l0 = d("TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", 159);

    /* renamed from: m  reason: collision with root package name */
    public static final C2459g f23029m = d("SSL_DHE_DSS_WITH_DES_CBC_SHA", 18);

    /* renamed from: m0  reason: collision with root package name */
    public static final C2459g f23030m0 = d("TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", 162);

    /* renamed from: n  reason: collision with root package name */
    public static final C2459g f23031n = d("SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA", 19);

    /* renamed from: n0  reason: collision with root package name */
    public static final C2459g f23032n0 = d("TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", 163);

    /* renamed from: o  reason: collision with root package name */
    public static final C2459g f23033o = d("SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA", 20);

    /* renamed from: o0  reason: collision with root package name */
    public static final C2459g f23034o0 = d("TLS_DH_anon_WITH_AES_128_GCM_SHA256", 166);

    /* renamed from: p  reason: collision with root package name */
    public static final C2459g f23035p = d("SSL_DHE_RSA_WITH_DES_CBC_SHA", 21);

    /* renamed from: p0  reason: collision with root package name */
    public static final C2459g f23036p0 = d("TLS_DH_anon_WITH_AES_256_GCM_SHA384", 167);

    /* renamed from: q  reason: collision with root package name */
    public static final C2459g f23037q = d("SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA", 22);

    /* renamed from: q0  reason: collision with root package name */
    public static final C2459g f23038q0 = d("TLS_EMPTY_RENEGOTIATION_INFO_SCSV", 255);

    /* renamed from: r  reason: collision with root package name */
    public static final C2459g f23039r = d("SSL_DH_anon_EXPORT_WITH_RC4_40_MD5", 23);

    /* renamed from: r0  reason: collision with root package name */
    public static final C2459g f23040r0 = d("TLS_FALLBACK_SCSV", 22016);

    /* renamed from: s  reason: collision with root package name */
    public static final C2459g f23041s = d("SSL_DH_anon_WITH_RC4_128_MD5", 24);

    /* renamed from: s0  reason: collision with root package name */
    public static final C2459g f23042s0 = d("TLS_ECDH_ECDSA_WITH_NULL_SHA", 49153);

    /* renamed from: t  reason: collision with root package name */
    public static final C2459g f23043t = d("SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA", 25);

    /* renamed from: t0  reason: collision with root package name */
    public static final C2459g f23044t0 = d("TLS_ECDH_ECDSA_WITH_RC4_128_SHA", 49154);

    /* renamed from: u  reason: collision with root package name */
    public static final C2459g f23045u = d("SSL_DH_anon_WITH_DES_CBC_SHA", 26);

    /* renamed from: u0  reason: collision with root package name */
    public static final C2459g f23046u0 = d("TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA", 49155);

    /* renamed from: v  reason: collision with root package name */
    public static final C2459g f23047v = d("SSL_DH_anon_WITH_3DES_EDE_CBC_SHA", 27);

    /* renamed from: v0  reason: collision with root package name */
    public static final C2459g f23048v0 = d("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA", 49156);

    /* renamed from: w  reason: collision with root package name */
    public static final C2459g f23049w = d("TLS_KRB5_WITH_DES_CBC_SHA", 30);

    /* renamed from: w0  reason: collision with root package name */
    public static final C2459g f23050w0 = d("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA", 49157);

    /* renamed from: x  reason: collision with root package name */
    public static final C2459g f23051x = d("TLS_KRB5_WITH_3DES_EDE_CBC_SHA", 31);

    /* renamed from: x0  reason: collision with root package name */
    public static final C2459g f23052x0 = d("TLS_ECDHE_ECDSA_WITH_NULL_SHA", 49158);

    /* renamed from: y  reason: collision with root package name */
    public static final C2459g f23053y = d("TLS_KRB5_WITH_RC4_128_SHA", 32);

    /* renamed from: y0  reason: collision with root package name */
    public static final C2459g f23054y0 = d("TLS_ECDHE_ECDSA_WITH_RC4_128_SHA", 49159);

    /* renamed from: z  reason: collision with root package name */
    public static final C2459g f23055z = d("TLS_KRB5_WITH_DES_CBC_MD5", 34);

    /* renamed from: z0  reason: collision with root package name */
    public static final C2459g f23056z0 = d("TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", 49160);

    /* renamed from: a  reason: collision with root package name */
    final String f23057a;

    /* renamed from: D3.g$a */
    class a implements Comparator {
        a() {
        }

        /* renamed from: a */
        public int compare(String str, String str2) {
            int min = Math.min(str.length(), str2.length());
            int i4 = 4;
            while (i4 < min) {
                char charAt = str.charAt(i4);
                char charAt2 = str2.charAt(i4);
                if (charAt == charAt2) {
                    i4++;
                } else if (charAt < charAt2) {
                    return -1;
                } else {
                    return 1;
                }
            }
            int length = str.length();
            int length2 = str2.length();
            if (length == length2) {
                return 0;
            }
            if (length < length2) {
                return -1;
            }
            return 1;
        }
    }

    static {
        a aVar = new a();
        f22997b = aVar;
        f23000c = new TreeMap(aVar);
    }

    private C2459g(String str) {
        str.getClass();
        this.f23057a = str;
    }

    public static synchronized C2459g a(String str) {
        C2459g gVar;
        synchronized (C2459g.class) {
            Map map = f23000c;
            gVar = (C2459g) map.get(str);
            if (gVar == null) {
                gVar = new C2459g(str);
                map.put(str, gVar);
            }
        }
        return gVar;
    }

    static List b(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String a5 : strArr) {
            arrayList.add(a(a5));
        }
        return DesugarCollections.unmodifiableList(arrayList);
    }

    private static C2459g d(String str, int i4) {
        return a(str);
    }

    public String c() {
        return this.f23057a;
    }

    public String toString() {
        return this.f23057a;
    }
}
