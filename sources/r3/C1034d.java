package r3;

import W2.b;
import d3.l;
import d3.p;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.internal.C;
import s3.s;

/* renamed from: r3.d  reason: case insensitive filesystem */
final class C1034d implements C1035e {

    /* renamed from: a  reason: collision with root package name */
    private final C1035e f4192a;

    /* renamed from: b  reason: collision with root package name */
    public final l f4193b;

    /* renamed from: c  reason: collision with root package name */
    public final p f4194c;

    /* renamed from: r3.d$a */
    static final class a implements C1036f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C1034d f4195a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C f4196b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C1036f f4197c;

        /* renamed from: r3.d$a$a  reason: collision with other inner class name */
        static final class C0041a extends d {

            /* renamed from: a  reason: collision with root package name */
            /* synthetic */ Object f4198a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ a f4199b;

            /* renamed from: c  reason: collision with root package name */
            int f4200c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0041a(a aVar, V2.d dVar) {
                super(dVar);
                this.f4199b = aVar;
            }

            public final Object invokeSuspend(Object obj) {
                this.f4198a = obj;
                this.f4200c |= Integer.MIN_VALUE;
                return this.f4199b.emit((Object) null, this);
            }
        }

        a(C1034d dVar, C c5, C1036f fVar) {
            this.f4195a = dVar;
            this.f4196b = c5;
            this.f4197c = fVar;
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object emit(java.lang.Object r6, V2.d r7) {
            /*
                r5 = this;
                boolean r0 = r7 instanceof r3.C1034d.a.C0041a
                if (r0 == 0) goto L_0x0013
                r0 = r7
                r3.d$a$a r0 = (r3.C1034d.a.C0041a) r0
                int r1 = r0.f4200c
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L_0x0013
                int r1 = r1 - r2
                r0.f4200c = r1
                goto L_0x0018
            L_0x0013:
                r3.d$a$a r0 = new r3.d$a$a
                r0.<init>(r5, r7)
            L_0x0018:
                java.lang.Object r7 = r0.f4198a
                java.lang.Object r1 = W2.b.c()
                int r2 = r0.f4200c
                r3 = 1
                if (r2 == 0) goto L_0x0031
                if (r2 != r3) goto L_0x0029
                R2.n.b(r7)
                goto L_0x0067
            L_0x0029:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L_0x0031:
                R2.n.b(r7)
                r3.d r7 = r5.f4195a
                d3.l r7 = r7.f4193b
                java.lang.Object r7 = r7.invoke(r6)
                kotlin.jvm.internal.C r2 = r5.f4196b
                java.lang.Object r2 = r2.f20968a
                t3.F r4 = s3.s.f4399a
                if (r2 == r4) goto L_0x0058
                r3.d r4 = r5.f4195a
                d3.p r4 = r4.f4194c
                java.lang.Object r2 = r4.invoke(r2, r7)
                java.lang.Boolean r2 = (java.lang.Boolean) r2
                boolean r2 = r2.booleanValue()
                if (r2 != 0) goto L_0x0055
                goto L_0x0058
            L_0x0055:
                R2.s r6 = R2.s.f8222a
                return r6
            L_0x0058:
                kotlin.jvm.internal.C r2 = r5.f4196b
                r2.f20968a = r7
                r3.f r7 = r5.f4197c
                r0.f4200c = r3
                java.lang.Object r6 = r7.emit(r6, r0)
                if (r6 != r1) goto L_0x0067
                return r1
            L_0x0067:
                R2.s r6 = R2.s.f8222a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: r3.C1034d.a.emit(java.lang.Object, V2.d):java.lang.Object");
        }
    }

    public C1034d(C1035e eVar, l lVar, p pVar) {
        this.f4192a = eVar;
        this.f4193b = lVar;
        this.f4194c = pVar;
    }

    public Object collect(C1036f fVar, V2.d dVar) {
        C c5 = new C();
        c5.f20968a = s.f4399a;
        Object collect = this.f4192a.collect(new a(this, c5, fVar), dVar);
        if (collect == b.c()) {
            return collect;
        }
        return R2.s.f8222a;
    }
}
