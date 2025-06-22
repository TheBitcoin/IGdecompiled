package r3;

import R2.n;
import R2.s;
import W2.b;
import d3.p;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.z;

final class G implements D {

    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f4152a;

        /* renamed from: b  reason: collision with root package name */
        private /* synthetic */ Object f4153b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ I f4154c;

        /* renamed from: r3.G$a$a  reason: collision with other inner class name */
        static final class C0038a implements C1036f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ z f4155a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C1036f f4156b;

            /* renamed from: r3.G$a$a$a  reason: collision with other inner class name */
            static final class C0039a extends d {

                /* renamed from: a  reason: collision with root package name */
                /* synthetic */ Object f4157a;

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ C0038a f4158b;

                /* renamed from: c  reason: collision with root package name */
                int f4159c;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                C0039a(C0038a aVar, V2.d dVar) {
                    super(dVar);
                    this.f4158b = aVar;
                }

                public final Object invokeSuspend(Object obj) {
                    this.f4157a = obj;
                    this.f4159c |= Integer.MIN_VALUE;
                    return this.f4158b.b(0, this);
                }
            }

            C0038a(z zVar, C1036f fVar) {
                this.f4155a = zVar;
                this.f4156b = fVar;
            }

            /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object b(int r5, V2.d r6) {
                /*
                    r4 = this;
                    boolean r0 = r6 instanceof r3.G.a.C0038a.C0039a
                    if (r0 == 0) goto L_0x0013
                    r0 = r6
                    r3.G$a$a$a r0 = (r3.G.a.C0038a.C0039a) r0
                    int r1 = r0.f4159c
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L_0x0013
                    int r1 = r1 - r2
                    r0.f4159c = r1
                    goto L_0x0018
                L_0x0013:
                    r3.G$a$a$a r0 = new r3.G$a$a$a
                    r0.<init>(r4, r6)
                L_0x0018:
                    java.lang.Object r6 = r0.f4157a
                    java.lang.Object r1 = W2.b.c()
                    int r2 = r0.f4159c
                    r3 = 1
                    if (r2 == 0) goto L_0x0031
                    if (r2 != r3) goto L_0x0029
                    R2.n.b(r6)
                    goto L_0x004b
                L_0x0029:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L_0x0031:
                    R2.n.b(r6)
                    if (r5 <= 0) goto L_0x004e
                    kotlin.jvm.internal.z r5 = r4.f4155a
                    boolean r6 = r5.f20985a
                    if (r6 != 0) goto L_0x004e
                    r5.f20985a = r3
                    r3.f r5 = r4.f4156b
                    r3.B r6 = r3.B.START
                    r0.f4159c = r3
                    java.lang.Object r5 = r5.emit(r6, r0)
                    if (r5 != r1) goto L_0x004b
                    return r1
                L_0x004b:
                    R2.s r5 = R2.s.f8222a
                    return r5
                L_0x004e:
                    R2.s r5 = R2.s.f8222a
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: r3.G.a.C0038a.b(int, V2.d):java.lang.Object");
            }

            public /* bridge */ /* synthetic */ Object emit(Object obj, V2.d dVar) {
                return b(((Number) obj).intValue(), dVar);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(I i4, V2.d dVar) {
            super(2, dVar);
            this.f4154c = i4;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            a aVar = new a(this.f4154c, dVar);
            aVar.f4153b = obj;
            return aVar;
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = b.c();
            int i4 = this.f4152a;
            if (i4 == 0) {
                n.b(obj);
                z zVar = new z();
                I i5 = this.f4154c;
                C0038a aVar = new C0038a(zVar, (C1036f) this.f4153b);
                this.f4152a = 1;
                if (i5.collect(aVar, this) == c5) {
                    return c5;
                }
            } else if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                n.b(obj);
            }
            throw new R2.d();
        }

        public final Object invoke(C1036f fVar, V2.d dVar) {
            return ((a) create(fVar, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public C1035e a(I i4) {
        return C1037g.r(new a(i4, (V2.d) null));
    }

    public String toString() {
        return "SharingStarted.Lazily";
    }
}
