package F0;

import B0.F;
import C0.j;
import android.content.Context;
import com.google.android.datatransport.cct.a;
import k0.C0937l;
import o.C0962c;
import o.h;
import q.u;
import y0.C2408A;
import y0.N;

/* renamed from: F0.b  reason: case insensitive filesystem */
public class C1295b {

    /* renamed from: c  reason: collision with root package name */
    private static final j f6421c = new j();

    /* renamed from: d  reason: collision with root package name */
    private static final String f6422d = d("hts/cahyiseot-agolai.o/1frlglgc/aclg", "tp:/rsltcrprsp.ogepscmv/ieo/eaybtho");

    /* renamed from: e  reason: collision with root package name */
    private static final String f6423e = d("AzSBpY4F0rHiHFdinTvM", "IayrSTFL9eJ69YeSUO2");

    /* renamed from: f  reason: collision with root package name */
    private static final h f6424f = new C1294a();

    /* renamed from: a  reason: collision with root package name */
    private final C1298e f6425a;

    /* renamed from: b  reason: collision with root package name */
    private final h f6426b;

    C1295b(C1298e eVar, h hVar) {
        this.f6425a = eVar;
        this.f6426b = hVar;
    }

    public static C1295b b(Context context, G0.j jVar, N n4) {
        u.f(context);
        o.j g4 = u.c().g(new a(f6422d, f6423e));
        C0962c b5 = C0962c.b("json");
        h hVar = f6424f;
        return new C1295b(new C1298e(g4.a("FIREBASE_CRASHLYTICS_REPORT", F.class, b5, hVar), jVar.b(), n4), hVar);
    }

    private static String d(String str, String str2) {
        int length = str.length() - str2.length();
        if (length < 0 || length > 1) {
            throw new IllegalArgumentException("Invalid input received");
        }
        StringBuilder sb = new StringBuilder(str.length() + str2.length());
        for (int i4 = 0; i4 < str.length(); i4++) {
            sb.append(str.charAt(i4));
            if (str2.length() > i4) {
                sb.append(str2.charAt(i4));
            }
        }
        return sb.toString();
    }

    public C0937l c(C2408A a5, boolean z4) {
        return this.f6425a.i(a5, z4).a();
    }
}
