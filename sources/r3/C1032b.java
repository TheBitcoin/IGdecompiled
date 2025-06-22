package r3;

import V2.g;
import V2.h;
import d3.p;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.internal.C2103g;
import q3.s;
import s3.e;

/* renamed from: r3.b  reason: case insensitive filesystem */
final class C1032b extends C1033c {

    /* renamed from: e  reason: collision with root package name */
    private final p f4186e;

    /* renamed from: r3.b$a */
    static final class a extends d {

        /* renamed from: a  reason: collision with root package name */
        Object f4187a;

        /* renamed from: b  reason: collision with root package name */
        /* synthetic */ Object f4188b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C1032b f4189c;

        /* renamed from: d  reason: collision with root package name */
        int f4190d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(C1032b bVar, V2.d dVar) {
            super(dVar);
            this.f4189c = bVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f4188b = obj;
            this.f4190d |= Integer.MIN_VALUE;
            return this.f4189c.h((s) null, this);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C1032b(p pVar, g gVar, int i4, q3.a aVar, int i5, C2103g gVar2) {
        this(pVar, (i5 & 2) != 0 ? h.f8445a : gVar, (i5 & 4) != 0 ? -2 : i4, (i5 & 8) != 0 ? q3.a.SUSPEND : aVar);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object h(q3.s r5, V2.d r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof r3.C1032b.a
            if (r0 == 0) goto L_0x0013
            r0 = r6
            r3.b$a r0 = (r3.C1032b.a) r0
            int r1 = r0.f4190d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f4190d = r1
            goto L_0x0018
        L_0x0013:
            r3.b$a r0 = new r3.b$a
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.f4188b
            java.lang.Object r1 = W2.b.c()
            int r2 = r0.f4190d
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r5 = r0.f4187a
            q3.s r5 = (q3.s) r5
            R2.n.b(r6)
            goto L_0x0043
        L_0x002d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0035:
            R2.n.b(r6)
            r0.f4187a = r5
            r0.f4190d = r3
            java.lang.Object r6 = super.h(r5, r0)
            if (r6 != r1) goto L_0x0043
            return r1
        L_0x0043:
            boolean r5 = r5.C()
            if (r5 == 0) goto L_0x004c
            R2.s r5 = R2.s.f8222a
            return r5
        L_0x004c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "'awaitClose { yourCallbackOrListener.cancel() }' should be used in the end of callbackFlow block.\nOtherwise, a callback/listener may leak in case of external cancellation.\nSee callbackFlow API documentation for the details."
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: r3.C1032b.h(q3.s, V2.d):java.lang.Object");
    }

    /* access modifiers changed from: protected */
    public e i(g gVar, int i4, q3.a aVar) {
        return new C1032b(this.f4186e, gVar, i4, aVar);
    }

    public C1032b(p pVar, g gVar, int i4, q3.a aVar) {
        super(pVar, gVar, i4, aVar);
        this.f4186e = pVar;
    }
}
