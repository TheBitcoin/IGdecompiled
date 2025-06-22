package X3;

import W3.C2604a;
import Z3.C2621j;
import com.inmobi.cmp.data.storage.SharedStorage;
import java.util.Arrays;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.internal.F;
import kotlin.jvm.internal.m;

public final class v implements u {

    /* renamed from: a  reason: collision with root package name */
    public final C2604a f24337a;

    /* renamed from: b  reason: collision with root package name */
    public final SharedStorage f24338b;

    /* renamed from: c  reason: collision with root package name */
    public final W3.b f24339c;

    /* renamed from: d  reason: collision with root package name */
    public final C2621j f24340d;

    /* renamed from: e  reason: collision with root package name */
    public final String f24341e;

    public static final class a extends d {

        /* renamed from: a  reason: collision with root package name */
        public Object f24342a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f24343b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ v f24344c;

        /* renamed from: d  reason: collision with root package name */
        public int f24345d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(v vVar, V2.d dVar) {
            super(dVar);
            this.f24344c = vVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f24343b = obj;
            this.f24345d |= Integer.MIN_VALUE;
            return this.f24344c.b(this);
        }
    }

    public static final class b extends d {

        /* renamed from: a  reason: collision with root package name */
        public /* synthetic */ Object f24346a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ v f24347b;

        /* renamed from: c  reason: collision with root package name */
        public int f24348c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(v vVar, V2.d dVar) {
            super(dVar);
            this.f24347b = vVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f24346a = obj;
            this.f24348c |= Integer.MIN_VALUE;
            return this.f24347b.a(this);
        }
    }

    public v(C2604a aVar, SharedStorage sharedStorage, W3.b bVar, C2621j jVar, String str, String str2) {
        m.e(aVar, "networkUtil");
        m.e(sharedStorage, "sharedStorage");
        m.e(bVar, "requestApi");
        m.e(jVar, "resolver");
        m.e(str, "packageName");
        m.e(str2, "pCode");
        this.f24337a = aVar;
        this.f24338b = sharedStorage;
        this.f24339c = bVar;
        this.f24340d = jVar;
        F f4 = F.f20971a;
        String format = String.format(m.m("https://cmp.inmobi.com/", "choice/%s/%s/app-config.json"), Arrays.copyOf(new Object[]{str2, str}, 2));
        m.d(format, "format(format, *args)");
        this.f24341e = format;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object a(V2.d r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof X3.v.b
            if (r0 == 0) goto L_0x0013
            r0 = r8
            X3.v$b r0 = (X3.v.b) r0
            int r1 = r0.f24348c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f24348c = r1
            goto L_0x0018
        L_0x0013:
            X3.v$b r0 = new X3.v$b
            r0.<init>(r7, r8)
        L_0x0018:
            java.lang.Object r8 = r0.f24346a
            java.lang.Object r1 = W2.b.c()
            int r2 = r0.f24348c
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            R2.n.b(r8)     // Catch:{ a -> 0x006b }
            goto L_0x005b
        L_0x0029:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x0031:
            R2.n.b(r8)
            W3.a r8 = r7.f24337a     // Catch:{ a -> 0x006b }
            boolean r8 = r8.a()     // Catch:{ a -> 0x006b }
            if (r8 == 0) goto L_0x005e
            Z3.j r8 = r7.f24340d     // Catch:{ a -> 0x006b }
            com.inmobi.cmp.data.storage.SharedStorage r2 = r7.f24338b     // Catch:{ a -> 0x006b }
            a4.a r4 = a4.a.PORTAL_CONFIG     // Catch:{ a -> 0x006b }
            java.lang.String r2 = r2.j(r4)     // Catch:{ a -> 0x006b }
            java.lang.Object r8 = r8.a(r2)     // Catch:{ a -> 0x006b }
            C3.f r8 = (C3.f) r8     // Catch:{ a -> 0x006b }
            W3.b r2 = r7.f24339c     // Catch:{ a -> 0x006b }
            C3.a r8 = r8.f170b     // Catch:{ a -> 0x006b }
            java.lang.String r8 = r8.f145r     // Catch:{ a -> 0x006b }
            r0.f24348c = r3     // Catch:{ a -> 0x006b }
            java.lang.Object r8 = r2.b(r8, r0)     // Catch:{ a -> 0x006b }
            if (r8 != r1) goto L_0x005b
            return r1
        L_0x005b:
            android.graphics.Bitmap r8 = (android.graphics.Bitmap) r8     // Catch:{ a -> 0x006b }
            return r8
        L_0x005e:
            C2.b r0 = C2.b.f6277a     // Catch:{ a -> 0x006b }
            com.inmobi.cmp.model.ChoiceError r1 = com.inmobi.cmp.model.ChoiceError.NO_CONNECTION     // Catch:{ a -> 0x006b }
            r5 = 0
            r6 = 30
            r2 = 0
            r3 = 0
            r4 = 0
            C2.b.a(r0, r1, r2, r3, r4, r5, r6)     // Catch:{ a -> 0x006b }
        L_0x006b:
            r8 = 0
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: X3.v.a(V2.d):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object b(V2.d r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof X3.v.a
            if (r0 == 0) goto L_0x0013
            r0 = r9
            X3.v$a r0 = (X3.v.a) r0
            int r1 = r0.f24345d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f24345d = r1
            goto L_0x0018
        L_0x0013:
            X3.v$a r0 = new X3.v$a
            r0.<init>(r8, r9)
        L_0x0018:
            java.lang.Object r9 = r0.f24343b
            java.lang.Object r1 = W2.b.c()
            int r2 = r0.f24345d
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r0 = r0.f24342a
            X3.v r0 = (X3.v) r0
            R2.n.b(r9)     // Catch:{ a -> 0x006b }
            goto L_0x0050
        L_0x002d:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x0035:
            R2.n.b(r9)
            W3.a r9 = r8.f24337a     // Catch:{ a -> 0x006a }
            boolean r9 = r9.a()     // Catch:{ a -> 0x006a }
            if (r9 == 0) goto L_0x0053
            W3.b r9 = r8.f24339c     // Catch:{ a -> 0x006a }
            java.lang.String r2 = r8.f24341e     // Catch:{ a -> 0x006a }
            r0.f24342a = r8     // Catch:{ a -> 0x006a }
            r0.f24345d = r3     // Catch:{ a -> 0x006a }
            java.lang.Object r9 = r9.a(r2, r0)     // Catch:{ a -> 0x006a }
            if (r9 != r1) goto L_0x004f
            return r1
        L_0x004f:
            r0 = r8
        L_0x0050:
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ a -> 0x006b }
            goto L_0x0073
        L_0x0053:
            C2.b r1 = C2.b.f6277a     // Catch:{ a -> 0x006a }
            com.inmobi.cmp.model.ChoiceError r2 = com.inmobi.cmp.model.ChoiceError.NO_CONNECTION     // Catch:{ a -> 0x006a }
            r6 = 0
            r7 = 30
            r3 = 0
            r4 = 0
            r5 = 0
            C2.b.a(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ a -> 0x006a }
            com.inmobi.cmp.data.storage.SharedStorage r9 = r8.f24338b     // Catch:{ a -> 0x006a }
            a4.a r0 = a4.a.PORTAL_CONFIG     // Catch:{ a -> 0x006a }
            java.lang.String r9 = r9.j(r0)     // Catch:{ a -> 0x006a }
            r0 = r8
            goto L_0x0073
        L_0x006a:
            r0 = r8
        L_0x006b:
            com.inmobi.cmp.data.storage.SharedStorage r9 = r0.f24338b
            a4.a r1 = a4.a.PORTAL_CONFIG
            java.lang.String r9 = r9.j(r1)
        L_0x0073:
            com.inmobi.cmp.data.storage.SharedStorage r1 = r0.f24338b
            a4.a r2 = a4.a.PORTAL_CONFIG
            r1.e(r2, r9)
            Z3.j r0 = r0.f24340d
            java.lang.Object r9 = r0.a(r9)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: X3.v.b(V2.d):java.lang.Object");
    }
}
