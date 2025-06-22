package t3;

import R2.s;
import V2.g;
import d3.l;
import kotlin.jvm.internal.n;
import o3.I;

public abstract class x {

    static final class a extends n implements l {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ l f4528a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Object f4529b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ g f4530c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(l lVar, Object obj, g gVar) {
            super(1);
            this.f4528a = lVar;
            this.f4529b = obj;
            this.f4530c = gVar;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return s.f8222a;
        }

        public final void invoke(Throwable th) {
            x.b(this.f4528a, this.f4529b, this.f4530c);
        }
    }

    public static final l a(l lVar, Object obj, g gVar) {
        return new a(lVar, obj, gVar);
    }

    public static final void b(l lVar, Object obj, g gVar) {
        Q c5 = c(lVar, obj, (Q) null);
        if (c5 != null) {
            I.a(gVar, c5);
        }
    }

    public static final Q c(l lVar, Object obj, Q q4) {
        try {
            lVar.invoke(obj);
            return q4;
        } catch (Throwable th) {
            if (q4 == null || q4.getCause() == th) {
                return new Q("Exception in undelivered element handler for " + obj, th);
            }
            R2.a.a(q4, th);
            return q4;
        }
    }

    public static /* synthetic */ Q d(l lVar, Object obj, Q q4, int i4, Object obj2) {
        if ((i4 & 2) != 0) {
            q4 = null;
        }
        return c(lVar, obj, q4);
    }
}
