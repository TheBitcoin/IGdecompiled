package r3;

import R2.n;
import R2.s;
import S2.C1601o;
import V2.d;
import androidx.privacysandbox.ads.adservices.adselection.u;
import d3.p;
import d3.q;
import java.util.List;
import kotlin.coroutines.jvm.internal.l;

final class H implements D {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final long f4160b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final long f4161c;

    static final class a extends l implements q {

        /* renamed from: a  reason: collision with root package name */
        int f4162a;

        /* renamed from: b  reason: collision with root package name */
        private /* synthetic */ Object f4163b;

        /* renamed from: c  reason: collision with root package name */
        /* synthetic */ int f4164c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ H f4165d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(H h4, d dVar) {
            super(3, dVar);
            this.f4165d = h4;
        }

        public final Object i(C1036f fVar, int i4, d dVar) {
            a aVar = new a(this.f4165d, dVar);
            aVar.f4163b = fVar;
            aVar.f4164c = i4;
            return aVar.invokeSuspend(s.f8222a);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return i((C1036f) obj, ((Number) obj2).intValue(), (d) obj3);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v10, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: r3.f} */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0050, code lost:
            if (r1.emit(r10, r9) == r0) goto L_0x009b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0061, code lost:
            if (o3.U.b(r6, r9) == r0) goto L_0x009b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x007a, code lost:
            if (r1.emit(r10, r9) == r0) goto L_0x009b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x008b, code lost:
            if (o3.U.b(r4, r9) == r0) goto L_0x009b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0099, code lost:
            if (r1.emit(r10, r9) != r0) goto L_0x009c;
         */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
            /*
                r9 = this;
                java.lang.Object r0 = W2.b.c()
                int r1 = r9.f4162a
                r2 = 5
                r3 = 4
                r4 = 3
                r5 = 2
                r6 = 1
                if (r1 == 0) goto L_0x003c
                if (r1 == r6) goto L_0x0038
                if (r1 == r5) goto L_0x0030
                if (r1 == r4) goto L_0x0028
                if (r1 == r3) goto L_0x0020
                if (r1 != r2) goto L_0x0018
                goto L_0x0038
            L_0x0018:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r0)
                throw r10
            L_0x0020:
                java.lang.Object r1 = r9.f4163b
                r3.f r1 = (r3.C1036f) r1
                R2.n.b(r10)
                goto L_0x008e
            L_0x0028:
                java.lang.Object r1 = r9.f4163b
                r3.f r1 = (r3.C1036f) r1
                R2.n.b(r10)
                goto L_0x007d
            L_0x0030:
                java.lang.Object r1 = r9.f4163b
                r3.f r1 = (r3.C1036f) r1
                R2.n.b(r10)
                goto L_0x0064
            L_0x0038:
                R2.n.b(r10)
                goto L_0x009c
            L_0x003c:
                R2.n.b(r10)
                java.lang.Object r10 = r9.f4163b
                r1 = r10
                r3.f r1 = (r3.C1036f) r1
                int r10 = r9.f4164c
                if (r10 <= 0) goto L_0x0053
                r3.B r10 = r3.B.START
                r9.f4162a = r6
                java.lang.Object r10 = r1.emit(r10, r9)
                if (r10 != r0) goto L_0x009c
                goto L_0x009b
            L_0x0053:
                r3.H r10 = r9.f4165d
                long r6 = r10.f4160b
                r9.f4163b = r1
                r9.f4162a = r5
                java.lang.Object r10 = o3.U.b(r6, r9)
                if (r10 != r0) goto L_0x0064
                goto L_0x009b
            L_0x0064:
                r3.H r10 = r9.f4165d
                long r5 = r10.f4161c
                r7 = 0
                int r10 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
                if (r10 <= 0) goto L_0x008e
                r3.B r10 = r3.B.STOP
                r9.f4163b = r1
                r9.f4162a = r4
                java.lang.Object r10 = r1.emit(r10, r9)
                if (r10 != r0) goto L_0x007d
                goto L_0x009b
            L_0x007d:
                r3.H r10 = r9.f4165d
                long r4 = r10.f4161c
                r9.f4163b = r1
                r9.f4162a = r3
                java.lang.Object r10 = o3.U.b(r4, r9)
                if (r10 != r0) goto L_0x008e
                goto L_0x009b
            L_0x008e:
                r3.B r10 = r3.B.STOP_AND_RESET_REPLAY_CACHE
                r3 = 0
                r9.f4163b = r3
                r9.f4162a = r2
                java.lang.Object r10 = r1.emit(r10, r9)
                if (r10 != r0) goto L_0x009c
            L_0x009b:
                return r0
            L_0x009c:
                R2.s r10 = R2.s.f8222a
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: r3.H.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f4166a;

        /* renamed from: b  reason: collision with root package name */
        /* synthetic */ Object f4167b;

        b(d dVar) {
            super(2, dVar);
        }

        public final d create(Object obj, d dVar) {
            b bVar = new b(dVar);
            bVar.f4167b = obj;
            return bVar;
        }

        /* renamed from: i */
        public final Object invoke(B b5, d dVar) {
            return ((b) create(b5, dVar)).invokeSuspend(s.f8222a);
        }

        public final Object invokeSuspend(Object obj) {
            boolean z4;
            W2.b.c();
            if (this.f4166a == 0) {
                n.b(obj);
                if (((B) this.f4167b) != B.START) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                return kotlin.coroutines.jvm.internal.b.a(z4);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public H(long j4, long j5) {
        this.f4160b = j4;
        this.f4161c = j5;
        if (j4 < 0) {
            throw new IllegalArgumentException(("stopTimeout(" + j4 + " ms) cannot be negative").toString());
        } else if (j5 < 0) {
            throw new IllegalArgumentException(("replayExpiration(" + j5 + " ms) cannot be negative").toString());
        }
    }

    public C1035e a(I i4) {
        return C1037g.k(C1037g.l(C1037g.z(i4, new a(this, (d) null)), new b((d) null)));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof H)) {
            return false;
        }
        H h4 = (H) obj;
        if (this.f4160b == h4.f4160b && this.f4161c == h4.f4161c) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (u.a(this.f4160b) * 31) + u.a(this.f4161c);
    }

    public String toString() {
        List d5 = C1601o.d(2);
        if (this.f4160b > 0) {
            d5.add("stopTimeout=" + this.f4160b + "ms");
        }
        if (this.f4161c < Long.MAX_VALUE) {
            d5.add("replayExpiration=" + this.f4161c + "ms");
        }
        List a5 = C1601o.a(d5);
        return "SharingStarted.WhileSubscribed(" + C1601o.O(a5, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (d3.l) null, 63, (Object) null) + ')';
    }
}
