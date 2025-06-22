package O;

import K.a;
import K.e;
import M.C0338t;
import M.C0340v;
import M.C0341w;
import android.content.Context;
import com.google.android.gms.common.api.internal.C0505d;
import k0.C0937l;

public final class d extends e implements C0340v {

    /* renamed from: k  reason: collision with root package name */
    private static final a.g f599k;

    /* renamed from: l  reason: collision with root package name */
    private static final a.C0001a f600l;

    /* renamed from: m  reason: collision with root package name */
    private static final a f601m;

    /* renamed from: n  reason: collision with root package name */
    public static final /* synthetic */ int f602n = 0;

    static {
        a.g gVar = new a.g();
        f599k = gVar;
        c cVar = new c();
        f600l = cVar;
        f601m = new a("ClientTelemetry.API", cVar, gVar);
    }

    public d(Context context, C0341w wVar) {
        super(context, f601m, wVar, e.a.f374c);
    }

    public final C0937l a(C0338t tVar) {
        C0505d.a a5 = C0505d.a();
        a5.d(Z.d.f657a);
        a5.c(false);
        a5.b(new b(tVar));
        return d(a5.a());
    }
}
