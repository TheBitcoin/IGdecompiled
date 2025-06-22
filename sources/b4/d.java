package b4;

import A3.a;
import C3.e;
import C3.f;
import M2.c;
import T3.C2579g;
import V3.C2591b;
import V3.C2592c;
import V3.C2594e;
import V3.C2598i;
import V3.C2603n;
import W3.C2604a;
import W3.b;
import X3.C2605a;
import X3.C2607c;
import X3.C2610f;
import X3.g;
import X3.j;
import X3.k;
import X3.m;
import X3.o;
import X3.q;
import X3.s;
import X3.u;
import X3.v;
import X3.w;
import X3.x;
import Z3.C2614c;
import Z3.C2623l;
import android.app.Application;
import android.net.ConnectivityManager;
import androidx.core.os.ConfigurationCompat;
import com.inmobi.cmp.ChoiceCmp;
import com.inmobi.cmp.data.model.ChoiceStyle;
import com.inmobi.cmp.data.storage.SharedStorage;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import j1.C2091a;
import java.util.List;
import java.util.Locale;

public final class d {

    /* renamed from: A  reason: collision with root package name */
    public static k f24463A;

    /* renamed from: B  reason: collision with root package name */
    public static s f24464B;

    /* renamed from: a  reason: collision with root package name */
    public static final d f24465a = new d();

    /* renamed from: b  reason: collision with root package name */
    public static Application f24466b;

    /* renamed from: c  reason: collision with root package name */
    public static C2604a f24467c;

    /* renamed from: d  reason: collision with root package name */
    public static ChoiceStyle f24468d = new ChoiceStyle();

    /* renamed from: e  reason: collision with root package name */
    public static C2591b f24469e;

    /* renamed from: f  reason: collision with root package name */
    public static C2592c f24470f;

    /* renamed from: g  reason: collision with root package name */
    public static E2.s f24471g;

    /* renamed from: h  reason: collision with root package name */
    public static f f24472h;

    /* renamed from: i  reason: collision with root package name */
    public static SharedStorage f24473i;

    /* renamed from: j  reason: collision with root package name */
    public static b f24474j;

    /* renamed from: k  reason: collision with root package name */
    public static C2579g f24475k;

    /* renamed from: l  reason: collision with root package name */
    public static c f24476l;

    /* renamed from: m  reason: collision with root package name */
    public static a f24477m;

    /* renamed from: n  reason: collision with root package name */
    public static String f24478n = "";

    /* renamed from: o  reason: collision with root package name */
    public static C2091a f24479o;

    /* renamed from: p  reason: collision with root package name */
    public static C2614c f24480p;

    /* renamed from: q  reason: collision with root package name */
    public static q f24481q;

    /* renamed from: r  reason: collision with root package name */
    public static C2607c f24482r;

    /* renamed from: s  reason: collision with root package name */
    public static C2610f f24483s;

    /* renamed from: t  reason: collision with root package name */
    public static j f24484t;

    /* renamed from: u  reason: collision with root package name */
    public static u f24485u;

    /* renamed from: v  reason: collision with root package name */
    public static w f24486v;

    /* renamed from: w  reason: collision with root package name */
    public static m f24487w;

    /* renamed from: x  reason: collision with root package name */
    public static o f24488x;

    /* renamed from: y  reason: collision with root package name */
    public static g f24489y;

    /* renamed from: z  reason: collision with root package name */
    public static C2605a f24490z;

    public final Locale a() {
        if (f24466b != null) {
            Locale locale = ConfigurationCompat.getLocales(b().getResources().getConfiguration()).get(0);
            if (locale == null) {
                locale = Locale.US;
            }
            kotlin.jvm.internal.m.d(locale, "{\n            Configurat…0] ?: Locale.US\n        }");
            return locale;
        }
        Locale locale2 = Locale.US;
        kotlin.jvm.internal.m.d(locale2, "{\n            Locale.US\n        }");
        return locale2;
    }

    public final Application b() {
        Application application = f24466b;
        if (application != null) {
            return application;
        }
        kotlin.jvm.internal.m.u(MimeTypes.BASE_TYPE_APPLICATION);
        return null;
    }

    public final C2610f c() {
        if (f24483s == null) {
            f24483s = new C2610f(m(), n(), ChoiceCmp.INSTANCE.getCallback());
        }
        C2610f fVar = f24483s;
        if (fVar != null) {
            return fVar;
        }
        kotlin.jvm.internal.m.u("consentRepository_");
        return null;
    }

    public final C2614c d() {
        if (f24480p == null) {
            f24480p = new C2614c();
        }
        C2614c cVar = f24480p;
        if (cVar != null) {
            return cVar;
        }
        kotlin.jvm.internal.m.u("coreUiLabelsResolver");
        return null;
    }

    public final c e() {
        c cVar = f24476l;
        if (cVar != null) {
            return cVar;
        }
        return new c((String) null, (M2.a) null, (List) null, 7);
    }

    public final j f() {
        if (f24484t == null) {
            f24484t = new j(m(), ChoiceCmp.INSTANCE.getCallback());
        }
        j jVar = f24484t;
        if (jVar != null) {
            return jVar;
        }
        kotlin.jvm.internal.m.u("gbcConsentRepository_");
        return null;
    }

    public final C2091a g() {
        if (f24479o == null) {
            f24479o = new C2091a();
        }
        C2091a aVar = f24479o;
        if (aVar != null) {
            return aVar;
        }
        kotlin.jvm.internal.m.u("gppModel");
        return null;
    }

    public final a h() {
        a aVar = f24477m;
        if (aVar != null) {
            return aVar;
        }
        return new a((String) null, (String) null, (List) null, (List) null, 15);
    }

    public final C2604a i() {
        if (f24467c == null) {
            Object systemService = b().getSystemService("connectivity");
            if (systemService != null) {
                f24467c = new C2604a((ConnectivityManager) systemService);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type android.net.ConnectivityManager");
            }
        }
        C2604a aVar = f24467c;
        if (aVar != null) {
            return aVar;
        }
        kotlin.jvm.internal.m.u("networkUtil_");
        return null;
    }

    public final f j() {
        f fVar = f24472h;
        if (fVar != null) {
            return fVar;
        }
        return new f((C3.g) null, (C3.a) null, (e) null, (C2594e) null, (C2598i) null, (C2603n) null, 63);
    }

    public final u k() {
        if (f24485u == null) {
            C2604a i4 = i();
            SharedStorage m4 = m();
            b l4 = l();
            ChoiceCmp choiceCmp = ChoiceCmp.INSTANCE;
            f24485u = new v(i4, m4, l4, new C2623l(choiceCmp.getCallback(), d()), choiceCmp.getAppPackageId(), choiceCmp.getPCode());
        }
        u uVar = f24485u;
        if (uVar != null) {
            return uVar;
        }
        kotlin.jvm.internal.m.u("portalConfigRepository_");
        return null;
    }

    public final b l() {
        if (f24474j == null) {
            f24474j = new W3.c();
        }
        b bVar = f24474j;
        if (bVar != null) {
            return bVar;
        }
        kotlin.jvm.internal.m.u("requestApi_");
        return null;
    }

    public final SharedStorage m() {
        if (f24473i == null) {
            f24473i = new SharedStorage(b());
        }
        SharedStorage sharedStorage = f24473i;
        if (sharedStorage != null) {
            return sharedStorage;
        }
        kotlin.jvm.internal.m.u("storage_");
        return null;
    }

    public final E2.s n() {
        if (f24471g == null) {
            f24471g = new E2.s((z3.e) null);
        }
        E2.s sVar = f24471g;
        if (sVar != null) {
            return sVar;
        }
        kotlin.jvm.internal.m.u("tcModel");
        return null;
    }

    public final C2579g o() {
        C3.a aVar;
        if (f24475k == null) {
            E2.s n4 = n();
            ChoiceCmp choiceCmp = ChoiceCmp.INSTANCE;
            f portalConfig$app_release = choiceCmp.getPortalConfig$app_release();
            if (portalConfig$app_release == null) {
                aVar = null;
            } else {
                aVar = portalConfig$app_release.f170b;
            }
            f24475k = new C2579g(n4, aVar, i(), l(), choiceCmp.getCallback(), choiceCmp.getAppPackageId());
        }
        C2579g gVar = f24475k;
        if (gVar != null) {
            return gVar;
        }
        kotlin.jvm.internal.m.u("tracking");
        return null;
    }

    public final w p() {
        if (f24486v == null) {
            f24486v = new x(a(), i(), m(), l(), new Z3.m(d()));
        }
        w wVar = f24486v;
        if (wVar != null) {
            return wVar;
        }
        kotlin.jvm.internal.m.u("translationsTextRepository_");
        return null;
    }
}
