package X3;

import W3.C2604a;
import Z3.C2621j;
import android.content.Context;
import com.inmobi.cmp.data.storage.SharedStorage;
import java.util.Locale;
import kotlin.jvm.internal.m;

public final class r implements q {

    /* renamed from: a  reason: collision with root package name */
    public final Context f24297a;

    /* renamed from: b  reason: collision with root package name */
    public final C2604a f24298b;

    /* renamed from: c  reason: collision with root package name */
    public final Locale f24299c;

    /* renamed from: d  reason: collision with root package name */
    public final SharedStorage f24300d;

    /* renamed from: e  reason: collision with root package name */
    public final W3.b f24301e;

    /* renamed from: f  reason: collision with root package name */
    public final C2621j f24302f;

    /* renamed from: g  reason: collision with root package name */
    public final String f24303g = "GVL-v%s/vendor-list.json";

    /* renamed from: h  reason: collision with root package name */
    public final String f24304h = "GVL-v%s/purposes-%s.json";

    public static final class a extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a  reason: collision with root package name */
        public Object f24305a;

        /* renamed from: b  reason: collision with root package name */
        public Object f24306b;

        /* renamed from: c  reason: collision with root package name */
        public int f24307c;

        /* renamed from: d  reason: collision with root package name */
        public /* synthetic */ Object f24308d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ r f24309e;

        /* renamed from: f  reason: collision with root package name */
        public int f24310f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(r rVar, V2.d dVar) {
            super(dVar);
            this.f24309e = rVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f24308d = obj;
            this.f24310f |= Integer.MIN_VALUE;
            return this.f24309e.a(0, this);
        }
    }

    public static final class b extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a  reason: collision with root package name */
        public /* synthetic */ Object f24311a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ r f24312b;

        /* renamed from: c  reason: collision with root package name */
        public int f24313c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(r rVar, V2.d dVar) {
            super(dVar);
            this.f24312b = rVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f24311a = obj;
            this.f24313c |= Integer.MIN_VALUE;
            return this.f24312b.b(0, this);
        }
    }

    public static final class c extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a  reason: collision with root package name */
        public Object f24314a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f24315b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ r f24316c;

        /* renamed from: d  reason: collision with root package name */
        public int f24317d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(r rVar, V2.d dVar) {
            super(dVar);
            this.f24316c = rVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f24315b = obj;
            this.f24317d |= Integer.MIN_VALUE;
            return this.f24316c.c(0, this);
        }
    }

    public static final class d extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a  reason: collision with root package name */
        public Object f24318a;

        /* renamed from: b  reason: collision with root package name */
        public Object f24319b;

        /* renamed from: c  reason: collision with root package name */
        public int f24320c;

        /* renamed from: d  reason: collision with root package name */
        public /* synthetic */ Object f24321d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ r f24322e;

        /* renamed from: f  reason: collision with root package name */
        public int f24323f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(r rVar, V2.d dVar) {
            super(dVar);
            this.f24322e = rVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f24321d = obj;
            this.f24323f |= Integer.MIN_VALUE;
            return this.f24322e.d(0, this);
        }
    }

    public r(Context context, C2604a aVar, Locale locale, SharedStorage sharedStorage, W3.b bVar, C2621j jVar) {
        m.e(context, "context");
        m.e(aVar, "networkUtil");
        m.e(locale, "appLocale");
        m.e(sharedStorage, "sharedStorage");
        m.e(bVar, "requestApi");
        m.e(jVar, "resolver");
        this.f24297a = context;
        this.f24298b = aVar;
        this.f24299c = locale;
        this.f24300d = sharedStorage;
        this.f24301e = bVar;
        this.f24302f = jVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0095, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0096, code lost:
        b3.C1642b.a(r2, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0099, code lost:
        throw r8;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object a(int r7, V2.d r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof X3.r.a
            if (r0 == 0) goto L_0x0013
            r0 = r8
            X3.r$a r0 = (X3.r.a) r0
            int r1 = r0.f24310f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f24310f = r1
            goto L_0x0018
        L_0x0013:
            X3.r$a r0 = new X3.r$a
            r0.<init>(r6, r8)
        L_0x0018:
            java.lang.Object r8 = r0.f24308d
            java.lang.Object r1 = W2.b.c()
            int r2 = r0.f24310f
            r3 = 1
            r4 = 2
            if (r2 == 0) goto L_0x004b
            if (r2 == r3) goto L_0x003d
            if (r2 != r4) goto L_0x0035
            java.lang.Object r7 = r0.f24306b
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r0 = r0.f24305a
            X3.r r0 = (X3.r) r0
            R2.n.b(r8)
            goto L_0x00b2
        L_0x0035:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x003d:
            int r7 = r0.f24307c
            java.lang.Object r2 = r0.f24306b
            X3.r r2 = (X3.r) r2
            java.lang.Object r3 = r0.f24305a
            X3.r r3 = (X3.r) r3
            R2.n.b(r8)
            goto L_0x005f
        L_0x004b:
            R2.n.b(r8)
            r0.f24305a = r6
            r0.f24306b = r6
            r0.f24307c = r7
            r0.f24310f = r3
            java.lang.Object r8 = r6.c(r7, r0)
            if (r8 != r1) goto L_0x005d
            goto L_0x00ad
        L_0x005d:
            r2 = r6
            r3 = r2
        L_0x005f:
            java.lang.String r8 = (java.lang.String) r8
            r2.getClass()
            int r5 = r8.length()
            if (r5 != 0) goto L_0x009a
            if (r7 <= r4) goto L_0x006f
            int r8 = A1.d.vendor_list_3
            goto L_0x0071
        L_0x006f:
            int r8 = A1.d.vendor_list_2
        L_0x0071:
            android.content.Context r2 = r2.f24297a
            android.content.res.Resources r2 = r2.getResources()
            java.io.InputStream r8 = r2.openRawResource(r8)
            java.io.BufferedReader r2 = new java.io.BufferedReader
            java.io.InputStreamReader r5 = new java.io.InputStreamReader
            r5.<init>(r8)
            r2.<init>(r5)
            java.lang.String r8 = r2.readLine()     // Catch:{ all -> 0x0093 }
            r5 = 0
            b3.C1642b.a(r2, r5)
            java.lang.String r2 = "{\n            val resour…}\n            }\n        }"
            kotlin.jvm.internal.m.d(r8, r2)
            goto L_0x009a
        L_0x0093:
            r7 = move-exception
            throw r7     // Catch:{ all -> 0x0095 }
        L_0x0095:
            r8 = move-exception
            b3.C1642b.a(r2, r7)
            throw r8
        L_0x009a:
            com.inmobi.cmp.data.storage.SharedStorage r2 = r3.f24300d
            a4.a r5 = a4.a.VENDOR_LIST
            r2.e(r5, r8)
            r0.f24305a = r3
            r0.f24306b = r8
            r0.f24310f = r4
            java.lang.Object r7 = r3.d(r7, r0)
            if (r7 != r1) goto L_0x00ae
        L_0x00ad:
            return r1
        L_0x00ae:
            r0 = r8
            r8 = r7
            r7 = r0
            r0 = r3
        L_0x00b2:
            java.lang.String r8 = (java.lang.String) r8
            Z3.j r1 = r0.f24302f
            java.lang.Object r7 = r1.a(r7)
            z3.e r7 = (z3.e) r7
            com.inmobi.cmp.data.storage.SharedStorage r1 = r0.f24300d
            a4.a r2 = a4.a.TCF_POLICY_VERSION
            java.lang.Integer r3 = r7.f4802c
            if (r3 != 0) goto L_0x00c6
            r3 = 2
            goto L_0x00ca
        L_0x00c6:
            int r3 = r3.intValue()
        L_0x00ca:
            r1.c(r2, r3)
            com.inmobi.cmp.data.storage.SharedStorage r1 = r0.f24300d
            a4.a r2 = a4.a.GPP_POLICY_VERSION
            java.lang.Integer r3 = r7.f4802c
            if (r3 != 0) goto L_0x00d6
            goto L_0x00da
        L_0x00d6:
            int r4 = r3.intValue()
        L_0x00da:
            r1.c(r2, r4)
            int r1 = r8.length()
            if (r1 <= 0) goto L_0x011d
            Z3.j r1 = r0.f24302f
            java.lang.Object r8 = r1.a(r8)
            z3.e r8 = (z3.e) r8
            java.util.Map r1 = r8.f4803d
            java.lang.String r2 = "<set-?>"
            kotlin.jvm.internal.m.e(r1, r2)
            r7.f4803d = r1
            java.util.Map r1 = r8.f4804e
            kotlin.jvm.internal.m.e(r1, r2)
            r7.f4804e = r1
            java.util.Map r1 = r8.f4805f
            kotlin.jvm.internal.m.e(r1, r2)
            r7.f4805f = r1
            java.util.Map r1 = r8.f4806g
            kotlin.jvm.internal.m.e(r1, r2)
            r7.f4806g = r1
            java.util.Map r8 = r8.f4809j
            kotlin.jvm.internal.m.e(r8, r2)
            r7.f4809j = r8
            com.inmobi.cmp.data.storage.SharedStorage r8 = r0.f24300d
            a4.a r0 = a4.a.PORTAL_CHOICE_LANG
            java.lang.String r8 = r8.j(r0)
            kotlin.jvm.internal.m.e(r8, r2)
            r7.f4811l = r8
        L_0x011d:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: X3.r.a(int, V2.d):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object b(int r9, V2.d r10) {
        /*
            r8 = this;
            r0 = 2
            r1 = 1
            boolean r2 = r10 instanceof X3.r.b
            if (r2 == 0) goto L_0x0015
            r2 = r10
            X3.r$b r2 = (X3.r.b) r2
            int r3 = r2.f24313c
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0015
            int r3 = r3 - r4
            r2.f24313c = r3
            goto L_0x001a
        L_0x0015:
            X3.r$b r2 = new X3.r$b
            r2.<init>(r8, r10)
        L_0x001a:
            java.lang.Object r10 = r2.f24311a
            java.lang.Object r3 = W2.b.c()
            int r4 = r2.f24313c
            if (r4 == 0) goto L_0x0032
            if (r4 != r1) goto L_0x002a
            R2.n.b(r10)     // Catch:{ a -> 0x006d }
            goto L_0x006a
        L_0x002a:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0032:
            R2.n.b(r10)
            W3.b r10 = r8.f24301e     // Catch:{ a -> 0x006d }
            kotlin.jvm.internal.F r4 = kotlin.jvm.internal.F.f20971a     // Catch:{ a -> 0x006d }
            java.lang.String r4 = "https://cmp.inmobi.com/"
            java.lang.String r5 = r8.f24304h     // Catch:{ a -> 0x006d }
            java.lang.String r4 = kotlin.jvm.internal.m.m(r4, r5)     // Catch:{ a -> 0x006d }
            java.lang.Integer r9 = kotlin.coroutines.jvm.internal.b.b(r9)     // Catch:{ a -> 0x006d }
            com.inmobi.cmp.data.storage.SharedStorage r5 = r8.f24300d     // Catch:{ a -> 0x006d }
            a4.a r6 = a4.a.PORTAL_CHOICE_LANG     // Catch:{ a -> 0x006d }
            java.lang.String r5 = r5.j(r6)     // Catch:{ a -> 0x006d }
            java.lang.Object[] r6 = new java.lang.Object[r0]     // Catch:{ a -> 0x006d }
            r7 = 0
            r6[r7] = r9     // Catch:{ a -> 0x006d }
            r6[r1] = r5     // Catch:{ a -> 0x006d }
            java.lang.Object[] r9 = java.util.Arrays.copyOf(r6, r0)     // Catch:{ a -> 0x006d }
            java.lang.String r9 = java.lang.String.format(r4, r9)     // Catch:{ a -> 0x006d }
            java.lang.String r0 = "format(format, *args)"
            kotlin.jvm.internal.m.d(r9, r0)     // Catch:{ a -> 0x006d }
            r2.f24313c = r1     // Catch:{ a -> 0x006d }
            java.lang.Object r10 = r10.a(r9, r2)     // Catch:{ a -> 0x006d }
            if (r10 != r3) goto L_0x006a
            return r3
        L_0x006a:
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ a -> 0x006d }
            return r10
        L_0x006d:
            java.lang.String r9 = ""
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: X3.r.b(int, V2.d):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object c(int r8, V2.d r9) {
        /*
            r7 = this;
            r0 = 1
            boolean r1 = r9 instanceof X3.r.c
            if (r1 == 0) goto L_0x0014
            r1 = r9
            X3.r$c r1 = (X3.r.c) r1
            int r2 = r1.f24317d
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L_0x0014
            int r2 = r2 - r3
            r1.f24317d = r2
            goto L_0x0019
        L_0x0014:
            X3.r$c r1 = new X3.r$c
            r1.<init>(r7, r9)
        L_0x0019:
            java.lang.Object r9 = r1.f24315b
            java.lang.Object r2 = W2.b.c()
            int r3 = r1.f24317d
            if (r3 == 0) goto L_0x0035
            if (r3 != r0) goto L_0x002d
            java.lang.Object r8 = r1.f24314a
            X3.r r8 = (X3.r) r8
            R2.n.b(r9)     // Catch:{ a -> 0x0088 }
            goto L_0x006e
        L_0x002d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0035:
            R2.n.b(r9)
            W3.a r9 = r7.f24298b     // Catch:{ a -> 0x0087 }
            boolean r9 = r9.a()     // Catch:{ a -> 0x0087 }
            if (r9 == 0) goto L_0x0071
            W3.b r9 = r7.f24301e     // Catch:{ a -> 0x0087 }
            java.lang.String r3 = "https://cmp.inmobi.com/"
            kotlin.jvm.internal.F r4 = kotlin.jvm.internal.F.f20971a     // Catch:{ a -> 0x0087 }
            java.lang.String r4 = r7.f24303g     // Catch:{ a -> 0x0087 }
            java.lang.Integer r8 = kotlin.coroutines.jvm.internal.b.b(r8)     // Catch:{ a -> 0x0087 }
            java.lang.Object[] r5 = new java.lang.Object[r0]     // Catch:{ a -> 0x0087 }
            r6 = 0
            r5[r6] = r8     // Catch:{ a -> 0x0087 }
            java.lang.Object[] r8 = java.util.Arrays.copyOf(r5, r0)     // Catch:{ a -> 0x0087 }
            java.lang.String r8 = java.lang.String.format(r4, r8)     // Catch:{ a -> 0x0087 }
            java.lang.String r4 = "format(format, *args)"
            kotlin.jvm.internal.m.d(r8, r4)     // Catch:{ a -> 0x0087 }
            java.lang.String r8 = kotlin.jvm.internal.m.m(r3, r8)     // Catch:{ a -> 0x0087 }
            r1.f24314a = r7     // Catch:{ a -> 0x0087 }
            r1.f24317d = r0     // Catch:{ a -> 0x0087 }
            java.lang.Object r9 = r9.a(r8, r1)     // Catch:{ a -> 0x0087 }
            if (r9 != r2) goto L_0x006d
            return r2
        L_0x006d:
            r8 = r7
        L_0x006e:
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ a -> 0x0088 }
            return r9
        L_0x0071:
            C2.b r0 = C2.b.f6277a     // Catch:{ a -> 0x0087 }
            com.inmobi.cmp.model.ChoiceError r1 = com.inmobi.cmp.model.ChoiceError.NO_CONNECTION     // Catch:{ a -> 0x0087 }
            r5 = 0
            r6 = 30
            r2 = 0
            r3 = 0
            r4 = 0
            C2.b.a(r0, r1, r2, r3, r4, r5, r6)     // Catch:{ a -> 0x0087 }
            com.inmobi.cmp.data.storage.SharedStorage r8 = r7.f24300d     // Catch:{ a -> 0x0087 }
            a4.a r9 = a4.a.VENDOR_LIST     // Catch:{ a -> 0x0087 }
            java.lang.String r8 = r8.j(r9)     // Catch:{ a -> 0x0087 }
            return r8
        L_0x0087:
            r8 = r7
        L_0x0088:
            com.inmobi.cmp.data.storage.SharedStorage r8 = r8.f24300d
            a4.a r9 = a4.a.VENDOR_LIST
            java.lang.String r8 = r8.j(r9)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: X3.r.c(int, V2.d):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0100, code lost:
        if (r13 != r4) goto L_0x0103;
     */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object d(int r12, V2.d r13) {
        /*
            r11 = this;
            r0 = 0
            r1 = 2
            r2 = 1
            boolean r3 = r13 instanceof X3.r.d
            if (r3 == 0) goto L_0x0016
            r3 = r13
            X3.r$d r3 = (X3.r.d) r3
            int r4 = r3.f24323f
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r4 & r5
            if (r6 == 0) goto L_0x0016
            int r4 = r4 - r5
            r3.f24323f = r4
            goto L_0x001b
        L_0x0016:
            X3.r$d r3 = new X3.r$d
            r3.<init>(r11, r13)
        L_0x001b:
            java.lang.Object r13 = r3.f24321d
            java.lang.Object r4 = W2.b.c()
            int r5 = r3.f24323f
            java.lang.String r6 = "EN"
            if (r5 == 0) goto L_0x004a
            if (r5 == r2) goto L_0x0038
            if (r5 != r1) goto L_0x0030
            R2.n.b(r13)
            goto L_0x0103
        L_0x0030:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L_0x0038:
            int r12 = r3.f24320c
            java.lang.Object r0 = r3.f24319b
            java.lang.String r0 = (java.lang.String) r0
            java.lang.Object r2 = r3.f24318a
            X3.r r2 = (X3.r) r2
            R2.n.b(r13)     // Catch:{ a -> 0x0047 }
            goto L_0x00dc
        L_0x0047:
            goto L_0x00ee
        L_0x004a:
            R2.n.b(r13)
            com.inmobi.cmp.data.storage.SharedStorage r13 = r11.f24300d     // Catch:{ a -> 0x007a }
            a4.a r5 = a4.a.PORTAL_CHOICE_LANG     // Catch:{ a -> 0x007a }
            java.lang.String r13 = r13.j(r5)     // Catch:{ a -> 0x007a }
            java.lang.String r5 = "key"
            kotlin.jvm.internal.m.e(r13, r5)     // Catch:{ a -> 0x007a }
            r5 = 26
            int[] r5 = E2.b.a(r5)     // Catch:{ a -> 0x007a }
            int r7 = r5.length     // Catch:{ a -> 0x007a }
            r8 = 0
        L_0x0062:
            if (r8 >= r7) goto L_0x007d
            r9 = r5[r8]     // Catch:{ a -> 0x007a }
            int r8 = r8 + r2
            java.lang.String r9 = z3.a.b(r9)     // Catch:{ a -> 0x007a }
            boolean r9 = m3.m.p(r9, r13, r2)     // Catch:{ a -> 0x007a }
            if (r9 == 0) goto L_0x0062
            java.lang.String r9 = "autoDetectedLanguage"
            boolean r9 = m3.m.p(r13, r9, r2)     // Catch:{ a -> 0x007a }
            if (r9 != 0) goto L_0x0062
            goto L_0x0083
        L_0x007a:
            goto L_0x00ed
        L_0x007d:
            java.util.Locale r13 = r11.f24299c     // Catch:{ a -> 0x007a }
            java.lang.String r13 = r13.getLanguage()     // Catch:{ a -> 0x007a }
        L_0x0083:
            java.lang.String r5 = "sharedStorage.getStringP….language }\n            }"
            kotlin.jvm.internal.m.d(r13, r5)     // Catch:{ a -> 0x007a }
            java.util.Locale r5 = java.util.Locale.ROOT     // Catch:{ a -> 0x007a }
            java.lang.String r7 = "ROOT"
            kotlin.jvm.internal.m.d(r5, r7)     // Catch:{ a -> 0x007a }
            java.lang.String r13 = r13.toUpperCase(r5)     // Catch:{ a -> 0x007a }
            java.lang.String r5 = "this as java.lang.String).toUpperCase(locale)"
            kotlin.jvm.internal.m.d(r13, r5)     // Catch:{ a -> 0x007a }
            W3.a r5 = r11.f24298b     // Catch:{ a -> 0x007a }
            boolean r5 = r5.a()     // Catch:{ a -> 0x007a }
            if (r5 == 0) goto L_0x00e2
            boolean r5 = kotlin.jvm.internal.m.a(r13, r6)     // Catch:{ a -> 0x007a }
            if (r5 != 0) goto L_0x00e2
            W3.b r5 = r11.f24301e     // Catch:{ a -> 0x007a }
            kotlin.jvm.internal.F r7 = kotlin.jvm.internal.F.f20971a     // Catch:{ a -> 0x007a }
            java.lang.String r7 = "https://cmp.inmobi.com/"
            java.lang.String r8 = r11.f24304h     // Catch:{ a -> 0x007a }
            java.lang.String r7 = kotlin.jvm.internal.m.m(r7, r8)     // Catch:{ a -> 0x007a }
            java.lang.Integer r8 = kotlin.coroutines.jvm.internal.b.b(r12)     // Catch:{ a -> 0x007a }
            java.lang.Object[] r9 = new java.lang.Object[r1]     // Catch:{ a -> 0x007a }
            r9[r0] = r8     // Catch:{ a -> 0x007a }
            r9[r2] = r13     // Catch:{ a -> 0x007a }
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r9, r1)     // Catch:{ a -> 0x007a }
            java.lang.String r0 = java.lang.String.format(r7, r0)     // Catch:{ a -> 0x007a }
            java.lang.String r7 = "format(format, *args)"
            kotlin.jvm.internal.m.d(r0, r7)     // Catch:{ a -> 0x007a }
            r3.f24318a = r11     // Catch:{ a -> 0x007a }
            r3.f24319b = r13     // Catch:{ a -> 0x007a }
            r3.f24320c = r12     // Catch:{ a -> 0x007a }
            r3.f24323f = r2     // Catch:{ a -> 0x007a }
            java.lang.Object r0 = r5.a(r0, r3)     // Catch:{ a -> 0x007a }
            if (r0 != r4) goto L_0x00d8
            goto L_0x0102
        L_0x00d8:
            r2 = r0
            r0 = r13
            r13 = r2
            r2 = r11
        L_0x00dc:
            java.lang.String r13 = (java.lang.String) r13     // Catch:{ a -> 0x0047 }
            r10 = r0
            r0 = r13
            r13 = r10
            goto L_0x00e5
        L_0x00e2:
            java.lang.String r0 = ""
            r2 = r11
        L_0x00e5:
            com.inmobi.cmp.data.storage.SharedStorage r5 = r2.f24300d     // Catch:{ a -> 0x0047 }
            a4.a r7 = a4.a.PORTAL_CHOICE_LANG     // Catch:{ a -> 0x0047 }
            r5.e(r7, r13)     // Catch:{ a -> 0x0047 }
            return r0
        L_0x00ed:
            r2 = r11
        L_0x00ee:
            com.inmobi.cmp.data.storage.SharedStorage r13 = r2.f24300d
            a4.a r0 = a4.a.PORTAL_CHOICE_LANG
            r13.e(r0, r6)
            r13 = 0
            r3.f24318a = r13
            r3.f24319b = r13
            r3.f24323f = r1
            java.lang.Object r13 = r2.b(r12, r3)
            if (r13 != r4) goto L_0x0103
        L_0x0102:
            return r4
        L_0x0103:
            java.lang.String r13 = (java.lang.String) r13
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: X3.r.d(int, V2.d):java.lang.Object");
    }
}
