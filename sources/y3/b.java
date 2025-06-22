package y3;

import R2.m;
import R2.n;
import R2.s;
import V2.d;
import d3.l;
import java.util.concurrent.CancellationException;
import k0.C0927b;
import k0.C0931f;
import k0.C0937l;
import kotlin.coroutines.jvm.internal.h;
import o3.C0989m;
import o3.C0991n;

public abstract class b {

    static final class a implements C0931f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C0989m f4795a;

        a(C0989m mVar) {
            this.f4795a = mVar;
        }

        public final void a(C0937l lVar) {
            Exception i4 = lVar.i();
            if (i4 != null) {
                C0989m mVar = this.f4795a;
                m.a aVar = m.f8216a;
                mVar.resumeWith(m.a(n.a(i4)));
            } else if (lVar.l()) {
                C0989m.a.a(this.f4795a, (Throwable) null, 1, (Object) null);
            } else {
                C0989m mVar2 = this.f4795a;
                m.a aVar2 = m.f8216a;
                mVar2.resumeWith(m.a(lVar.j()));
            }
        }
    }

    /* renamed from: y3.b$b  reason: collision with other inner class name */
    static final class C0057b extends kotlin.jvm.internal.n implements l {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C0927b f4796a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0057b(C0927b bVar) {
            super(1);
            this.f4796a = bVar;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return s.f8222a;
        }

        public final void invoke(Throwable th) {
            this.f4796a.a();
        }
    }

    public static final Object a(C0937l lVar, d dVar) {
        return b(lVar, (C0927b) null, dVar);
    }

    private static final Object b(C0937l lVar, C0927b bVar, d dVar) {
        if (lVar.m()) {
            Exception i4 = lVar.i();
            if (i4 != null) {
                throw i4;
            } else if (!lVar.l()) {
                return lVar.j();
            } else {
                throw new CancellationException("Task " + lVar + " was cancelled normally.");
            }
        } else {
            C0991n nVar = new C0991n(W2.b.b(dVar), 1);
            nVar.z();
            lVar.b(a.f4794a, new a(nVar));
            if (bVar != null) {
                nVar.q(new C0057b(bVar));
            }
            Object v4 = nVar.v();
            if (v4 == W2.b.c()) {
                h.c(dVar);
            }
            return v4;
        }
    }
}
