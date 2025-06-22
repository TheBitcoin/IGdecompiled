package b2;

import R2.n;
import V2.d;
import W1.s;
import W2.b;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import d3.p;
import f2.C2016g;
import g2.C2048f;
import java.util.ArrayList;
import kotlin.coroutines.jvm.internal.l;
import o3.C1001s0;
import o3.J;
import o3.L;
import o3.Y;
import u2.m;
import u2.t;

/* renamed from: b2.a  reason: case insensitive filesystem */
public final class C1629a {

    /* renamed from: b2.a$a  reason: collision with other inner class name */
    static final class C0138a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f9098a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f9099b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C2016g f9100c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0138a(Context context, C2016g gVar, d dVar) {
            super(2, dVar);
            this.f9099b = context;
            this.f9100c = gVar;
        }

        public final d create(Object obj, d dVar) {
            return new C0138a(this.f9099b, this.f9100c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            ApplicationInfo applicationInfo;
            b.c();
            if (this.f9098a == 0) {
                n.b(obj);
                ArrayList B4 = new m().B(this.f9099b);
                t a5 = t.f21927u.a(this.f9099b);
                a5.a();
                Context context = this.f9099b;
                C2016g gVar = this.f9100c;
                int size = B4.size();
                int i4 = 0;
                while (i4 < size) {
                    Object obj2 = B4.get(i4);
                    i4++;
                    C2048f fVar = (C2048f) obj2;
                    String o4 = fVar.o();
                    if (!(o4 == null || o4.length() == 0)) {
                        try {
                            PackageManager packageManager = context.getPackageManager();
                            kotlin.jvm.internal.m.d(packageManager, "getPackageManager(...)");
                            String o5 = fVar.o();
                            kotlin.jvm.internal.m.b(o5);
                            applicationInfo = s.a(packageManager, o5, 128);
                        } catch (PackageManager.NameNotFoundException unused) {
                            applicationInfo = null;
                        }
                        if (applicationInfo != null) {
                            long d5 = new m().d(applicationInfo);
                            if (fVar.t() != d5) {
                                fVar.b0(d5);
                                a5.r1(fVar);
                                String o6 = fVar.o();
                                kotlin.jvm.internal.m.b(o6);
                                gVar.a(o6, d5);
                            }
                        }
                    }
                }
                a5.i();
                return R2.s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, d dVar) {
            return ((C0138a) create(j4, dVar)).invokeSuspend(R2.s.f8222a);
        }
    }

    public C1629a(C2016g gVar, J j4, Context context) {
        kotlin.jvm.internal.m.e(gVar, "listener");
        kotlin.jvm.internal.m.e(j4, "scope");
        kotlin.jvm.internal.m.e(context, "context");
        C1001s0 unused = C0981i.d(j4, Y.b(), (L) null, new C0138a(context, gVar, (d) null), 2, (Object) null);
    }
}
