package X3;

import W3.C2604a;
import W3.b;
import Z3.C2621j;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.internal.m;

public final class n implements m {

    /* renamed from: a  reason: collision with root package name */
    public final C2604a f24280a;

    /* renamed from: b  reason: collision with root package name */
    public final b f24281b;

    /* renamed from: c  reason: collision with root package name */
    public final C2621j f24282c;

    /* renamed from: d  reason: collision with root package name */
    public final String f24283d = "geoip";

    public static final class a extends d {

        /* renamed from: a  reason: collision with root package name */
        public Object f24284a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f24285b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ n f24286c;

        /* renamed from: d  reason: collision with root package name */
        public int f24287d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(n nVar, V2.d dVar) {
            super(dVar);
            this.f24286c = nVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f24285b = obj;
            this.f24287d |= Integer.MIN_VALUE;
            return this.f24286c.a(this);
        }
    }

    public n(C2604a aVar, b bVar, C2621j jVar) {
        m.e(aVar, "networkUtil");
        m.e(bVar, "requestApi");
        m.e(jVar, "resolver");
        this.f24280a = aVar;
        this.f24281b = bVar;
        this.f24282c = jVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object a(V2.d r12) {
        /*
            r11 = this;
            boolean r0 = r12 instanceof X3.n.a
            if (r0 == 0) goto L_0x0013
            r0 = r12
            X3.n$a r0 = (X3.n.a) r0
            int r1 = r0.f24287d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f24287d = r1
            goto L_0x0018
        L_0x0013:
            X3.n$a r0 = new X3.n$a
            r0.<init>(r11, r12)
        L_0x0018:
            java.lang.Object r12 = r0.f24285b
            java.lang.Object r1 = W2.b.c()
            int r2 = r0.f24287d
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x0038
            if (r2 != r4) goto L_0x0030
            java.lang.Object r0 = r0.f24284a
            X3.n r0 = (X3.n) r0
            R2.n.b(r12)     // Catch:{ a -> 0x002e }
            goto L_0x0059
        L_0x002e:
            goto L_0x006c
        L_0x0030:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L_0x0038:
            R2.n.b(r12)
            W3.a r12 = r11.f24280a     // Catch:{ a -> 0x005c }
            boolean r12 = r12.a()     // Catch:{ a -> 0x005c }
            if (r12 == 0) goto L_0x005e
            W3.b r12 = r11.f24281b     // Catch:{ a -> 0x005c }
            java.lang.String r2 = "https://cmp.inmobi.com/"
            java.lang.String r5 = r11.f24283d     // Catch:{ a -> 0x005c }
            java.lang.String r2 = kotlin.jvm.internal.m.m(r2, r5)     // Catch:{ a -> 0x005c }
            r0.f24284a = r11     // Catch:{ a -> 0x005c }
            r0.f24287d = r4     // Catch:{ a -> 0x005c }
            java.lang.Object r12 = r12.a(r2, r0)     // Catch:{ a -> 0x005c }
            if (r12 != r1) goto L_0x0058
            return r1
        L_0x0058:
            r0 = r11
        L_0x0059:
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ a -> 0x002e }
            goto L_0x006d
        L_0x005c:
            goto L_0x006b
        L_0x005e:
            C2.b r4 = C2.b.f6277a     // Catch:{ a -> 0x005c }
            com.inmobi.cmp.model.ChoiceError r5 = com.inmobi.cmp.model.ChoiceError.NO_CONNECTION     // Catch:{ a -> 0x005c }
            r9 = 0
            r10 = 30
            r6 = 0
            r7 = 0
            r8 = 0
            C2.b.a(r4, r5, r6, r7, r8, r9, r10)     // Catch:{ a -> 0x005c }
        L_0x006b:
            r0 = r11
        L_0x006c:
            r12 = r3
        L_0x006d:
            if (r12 != 0) goto L_0x0070
            goto L_0x0079
        L_0x0070:
            Z3.j r0 = r0.f24282c
            java.lang.Object r12 = r0.a(r12)
            r3 = r12
            P2.b r3 = (P2.b) r3
        L_0x0079:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: X3.n.a(V2.d):java.lang.Object");
    }
}
