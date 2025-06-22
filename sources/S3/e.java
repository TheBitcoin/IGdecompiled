package s3;

import R2.n;
import R2.s;
import S2.C1601o;
import V2.d;
import V2.g;
import V2.h;
import d3.p;
import java.util.ArrayList;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.m;
import o3.J;
import o3.K;
import o3.L;
import o3.N;
import q3.q;
import q3.u;
import r3.C1035e;
import r3.C1036f;
import r3.C1037g;

public abstract class e implements p {

    /* renamed from: a  reason: collision with root package name */
    public final g f4341a;

    /* renamed from: b  reason: collision with root package name */
    public final int f4342b;

    /* renamed from: c  reason: collision with root package name */
    public final q3.a f4343c;

    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f4344a;

        /* renamed from: b  reason: collision with root package name */
        private /* synthetic */ Object f4345b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C1036f f4346c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ e f4347d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(C1036f fVar, e eVar, d dVar) {
            super(2, dVar);
            this.f4346c = fVar;
            this.f4347d = eVar;
        }

        public final d create(Object obj, d dVar) {
            a aVar = new a(this.f4346c, this.f4347d, dVar);
            aVar.f4345b = obj;
            return aVar;
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f4344a;
            if (i4 == 0) {
                n.b(obj);
                C1036f fVar = this.f4346c;
                u m4 = this.f4347d.m((J) this.f4345b);
                this.f4344a = 1;
                if (C1037g.m(fVar, m4, this) == c5) {
                    return c5;
                }
            } else if (i4 == 1) {
                n.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return s.f8222a;
        }

        public final Object invoke(J j4, d dVar) {
            return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f4348a;

        /* renamed from: b  reason: collision with root package name */
        /* synthetic */ Object f4349b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ e f4350c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(e eVar, d dVar) {
            super(2, dVar);
            this.f4350c = eVar;
        }

        public final d create(Object obj, d dVar) {
            b bVar = new b(this.f4350c, dVar);
            bVar.f4349b = obj;
            return bVar;
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f4348a;
            if (i4 == 0) {
                n.b(obj);
                e eVar = this.f4350c;
                this.f4348a = 1;
                if (eVar.h((q3.s) this.f4349b, this) == c5) {
                    return c5;
                }
            } else if (i4 == 1) {
                n.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return s.f8222a;
        }

        public final Object invoke(q3.s sVar, d dVar) {
            return ((b) create(sVar, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public e(g gVar, int i4, q3.a aVar) {
        this.f4341a = gVar;
        this.f4342b = i4;
        this.f4343c = aVar;
    }

    static /* synthetic */ Object e(e eVar, C1036f fVar, d dVar) {
        Object d5 = K.d(new a(fVar, eVar, (d) null), dVar);
        if (d5 == W2.b.c()) {
            return d5;
        }
        return s.f8222a;
    }

    public C1035e b(g gVar, int i4, q3.a aVar) {
        g plus = gVar.plus(this.f4341a);
        if (aVar == q3.a.SUSPEND) {
            int i5 = this.f4342b;
            if (i5 != -3) {
                if (i4 != -3) {
                    if (i5 != -2) {
                        if (i4 != -2) {
                            i4 += i5;
                            if (i4 < 0) {
                                i4 = Integer.MAX_VALUE;
                            }
                        }
                    }
                }
                i4 = i5;
            }
            aVar = this.f4343c;
        }
        if (m.a(plus, this.f4341a) && i4 == this.f4342b && aVar == this.f4343c) {
            return this;
        }
        return i(plus, i4, aVar);
    }

    /* access modifiers changed from: protected */
    public String c() {
        return null;
    }

    public Object collect(C1036f fVar, d dVar) {
        return e(this, fVar, dVar);
    }

    /* access modifiers changed from: protected */
    public abstract Object h(q3.s sVar, d dVar);

    /* access modifiers changed from: protected */
    public abstract e i(g gVar, int i4, q3.a aVar);

    public C1035e j() {
        return null;
    }

    public final p k() {
        return new b(this, (d) null);
    }

    public final int l() {
        int i4 = this.f4342b;
        if (i4 == -3) {
            return -2;
        }
        return i4;
    }

    public u m(J j4) {
        return q.c(j4, this.f4341a, l(), this.f4343c, L.ATOMIC, (d3.l) null, k(), 16, (Object) null);
    }

    public String toString() {
        ArrayList arrayList = new ArrayList(4);
        String c5 = c();
        if (c5 != null) {
            arrayList.add(c5);
        }
        if (this.f4341a != h.f8445a) {
            arrayList.add("context=" + this.f4341a);
        }
        if (this.f4342b != -3) {
            arrayList.add("capacity=" + this.f4342b);
        }
        if (this.f4343c != q3.a.SUSPEND) {
            arrayList.add("onBufferOverflow=" + this.f4343c);
        }
        return N.a(this) + '[' + C1601o.O(arrayList, ", ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (d3.l) null, 62, (Object) null) + ']';
    }
}
