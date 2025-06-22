package q3;

import R2.a;
import R2.s;
import V2.d;
import d3.l;
import kotlin.jvm.internal.D;
import o3.W0;
import q3.h;
import t3.F;
import t3.Q;
import t3.x;

public class p extends b {

    /* renamed from: m  reason: collision with root package name */
    private final int f4101m;

    /* renamed from: n  reason: collision with root package name */
    private final a f4102n;

    public p(int i4, a aVar, l lVar) {
        super(i4, lVar);
        this.f4101m = i4;
        this.f4102n = aVar;
        if (aVar == a.SUSPEND) {
            throw new IllegalArgumentException(("This implementation does not support suspension for senders, use " + D.b(b.class).b() + " instead").toString());
        } else if (i4 < 1) {
            throw new IllegalArgumentException(("Buffered channel capacity must be at least 1, but " + i4 + " was specified").toString());
        }
    }

    static /* synthetic */ Object O0(p pVar, Object obj, d dVar) {
        Q d5;
        Object R02 = pVar.R0(obj, true);
        if (!(R02 instanceof h.a)) {
            return s.f8222a;
        }
        h.e(R02);
        l lVar = pVar.f4049b;
        if (lVar == null || (d5 = x.d(lVar, obj, (Q) null, 2, (Object) null)) == null) {
            throw pVar.R();
        }
        a.a(d5, pVar.R());
        throw d5;
    }

    private final Object P0(Object obj, boolean z4) {
        l lVar;
        Q d5;
        Object B4 = super.B(obj);
        if (h.i(B4) || h.h(B4)) {
            return B4;
        }
        if (!z4 || (lVar = this.f4049b) == null || (d5 = x.d(lVar, obj, (Q) null, 2, (Object) null)) == null) {
            return h.f4091b.c(s.f8222a);
        }
        throw d5;
    }

    private final Object Q0(Object obj) {
        j jVar;
        int i4;
        p pVar;
        W0 w02;
        F f4 = c.f4070d;
        j jVar2 = (j) b.f4043h.get(this);
        while (true) {
            long andIncrement = b.f4039d.getAndIncrement(this);
            long j4 = 1152921504606846975L & andIncrement;
            boolean l4 = b0(andIncrement);
            int i5 = c.f4068b;
            long j5 = j4 / ((long) i5);
            int i6 = (int) (j4 % ((long) i5));
            if (jVar2.f4463c != j5) {
                jVar = M(j5, jVar2);
                if (jVar != null) {
                    pVar = this;
                    i4 = i6;
                } else if (l4) {
                    return h.f4091b.a(R());
                }
            } else {
                jVar = jVar2;
                i4 = i6;
                pVar = this;
            }
            long j6 = j4;
            Object obj2 = obj;
            int x4 = pVar.J0(jVar, i4, obj2, j6, f4, l4);
            j jVar3 = jVar;
            p pVar2 = pVar;
            jVar2 = jVar3;
            if (x4 == 0) {
                jVar2.b();
                return h.f4091b.c(s.f8222a);
            } else if (x4 == 1) {
                return h.f4091b.c(s.f8222a);
            } else {
                if (x4 != 2) {
                    if (x4 == 3) {
                        throw new IllegalStateException("unexpected");
                    } else if (x4 != 4) {
                        if (x4 == 5) {
                            jVar2.b();
                        }
                        obj = obj2;
                    } else {
                        if (j6 < Q()) {
                            jVar2.b();
                        }
                        return h.f4091b.a(R());
                    }
                } else if (l4) {
                    jVar2.p();
                    return h.f4091b.a(R());
                } else {
                    if (f4 instanceof W0) {
                        w02 = (W0) f4;
                    } else {
                        w02 = null;
                    }
                    if (w02 != null) {
                        r0(w02, jVar2, i4);
                    }
                    I((jVar2.f4463c * ((long) i5)) + ((long) i4));
                    return h.f4091b.c(s.f8222a);
                }
            }
        }
    }

    private final Object R0(Object obj, boolean z4) {
        if (this.f4102n == a.DROP_LATEST) {
            return P0(obj, z4);
        }
        return Q0(obj);
    }

    public Object B(Object obj) {
        return R0(obj, false);
    }

    /* access modifiers changed from: protected */
    public boolean c0() {
        if (this.f4102n == a.DROP_OLDEST) {
            return true;
        }
        return false;
    }

    public Object t(Object obj, d dVar) {
        return O0(this, obj, dVar);
    }
}
