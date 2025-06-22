package T3;

import E2.s;
import S2.C1601o;
import W3.C2604a;
import com.inmobi.cmp.ChoiceCmpCallback;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.internal.m;

/* renamed from: T3.g  reason: case insensitive filesystem */
public final class C2579g {

    /* renamed from: a  reason: collision with root package name */
    public final s f23982a;

    /* renamed from: b  reason: collision with root package name */
    public C3.a f23983b;

    /* renamed from: c  reason: collision with root package name */
    public final C2604a f23984c;

    /* renamed from: d  reason: collision with root package name */
    public W3.b f23985d;

    /* renamed from: e  reason: collision with root package name */
    public final ChoiceCmpCallback f23986e;

    /* renamed from: f  reason: collision with root package name */
    public final String f23987f;

    /* renamed from: g  reason: collision with root package name */
    public final List f23988g = new ArrayList();

    /* renamed from: T3.g$a */
    public static final class a extends d {

        /* renamed from: a  reason: collision with root package name */
        public /* synthetic */ Object f23989a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ C2579g f23990b;

        /* renamed from: c  reason: collision with root package name */
        public int f23991c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(C2579g gVar, V2.d dVar) {
            super(dVar);
            this.f23990b = gVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f23989a = obj;
            this.f23991c |= Integer.MIN_VALUE;
            return this.f23990b.a((C2577e) null, (C2580h) null, (C2578f) null, this);
        }
    }

    /* renamed from: T3.g$b */
    public static final class b extends d {

        /* renamed from: a  reason: collision with root package name */
        public /* synthetic */ Object f23992a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ C2579g f23993b;

        /* renamed from: c  reason: collision with root package name */
        public int f23994c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(C2579g gVar, V2.d dVar) {
            super(dVar);
            this.f23993b = gVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f23992a = obj;
            this.f23994c |= Integer.MIN_VALUE;
            return this.f23993b.b((C2578f) null, (C2575c) null, this);
        }
    }

    static {
        m.d(C2579g.class.getSimpleName(), "Tracking::class.java.simpleName");
    }

    public C2579g(s sVar, C3.a aVar, C2604a aVar2, W3.b bVar, ChoiceCmpCallback choiceCmpCallback, String str) {
        m.e(sVar, "tcModel");
        m.e(aVar2, "networkUtil");
        m.e(bVar, "requestApi");
        m.e(str, "domain");
        this.f23982a = sVar;
        this.f23983b = aVar;
        this.f23984c = aVar2;
        this.f23985d = bVar;
        this.f23986e = choiceCmpCallback;
        this.f23987f = str;
    }

    public static Object c(C2579g gVar, Boolean bool, String str, String str2, String str3, String str4, C2578f fVar, V2.d dVar, int i4) {
        String d5;
        String d6;
        String str5 = (i4 & 2) != 0 ? null : str;
        String str6 = (i4 & 4) != 0 ? null : str2;
        String str7 = (i4 & 8) != 0 ? null : str3;
        String str8 = (i4 & 16) != 0 ? null : str4;
        gVar.getClass();
        if (m.a(bool, kotlin.coroutines.jvm.internal.b.a(true))) {
            d5 = "All";
        } else {
            d5 = gVar.d((String) null);
        }
        String str9 = d5;
        if (m.a(bool, kotlin.coroutines.jvm.internal.b.a(true))) {
            d6 = "none";
        } else {
            d6 = gVar.d("legitimate");
        }
        String str10 = d6;
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(gVar.f23988g);
        C2582j jVar = new C2582j(arrayList, str9, str10, str5, str6, (String) null, (String) null, str7, str8, 96);
        gVar.f23988g.clear();
        return gVar.a(C2577e.DONE, jVar, fVar, dVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(T3.C2577e r12, T3.C2580h r13, T3.C2578f r14, V2.d r15) {
        /*
            r11 = this;
            boolean r0 = r15 instanceof T3.C2579g.a
            if (r0 == 0) goto L_0x0013
            r0 = r15
            T3.g$a r0 = (T3.C2579g.a) r0
            int r1 = r0.f23991c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f23991c = r1
            goto L_0x0018
        L_0x0013:
            T3.g$a r0 = new T3.g$a
            r0.<init>(r11, r15)
        L_0x0018:
            java.lang.Object r15 = r0.f23989a
            java.lang.Object r1 = W2.b.c()
            int r2 = r0.f23991c
            java.lang.String r3 = ""
            r4 = 1
            if (r2 == 0) goto L_0x0034
            if (r2 != r4) goto L_0x002c
            R2.n.b(r15)     // Catch:{ a -> 0x00bf }
            goto L_0x00b2
        L_0x002c:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L_0x0034:
            R2.n.b(r15)
            java.util.Calendar r15 = java.util.Calendar.getInstance()
            long r5 = r15.getTimeInMillis()
            r13.b(r5)
            java.lang.String r15 = "<set-?>"
            kotlin.jvm.internal.m.e(r12, r15)
            r13.f23996b = r12
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r14 = r14.f23981a
            r12.append(r14)
            r14 = 45
            r12.append(r14)
            java.util.UUID r14 = T3.C2585m.f24019b
            java.lang.String r14 = r14.toString()
            java.lang.String r2 = "sessionID.toString()"
            kotlin.jvm.internal.m.d(r14, r2)
            r12.append(r14)
            java.lang.String r12 = r12.toString()
            r13.f23997c = r12
            java.lang.String r12 = r11.f23987f
            kotlin.jvm.internal.m.e(r12, r15)
            r13.f23998d = r12
            java.lang.String r12 = "https://api.cmp.inmobi.com/"
            android.net.Uri r12 = android.net.Uri.parse(r12)
            android.net.Uri$Builder r12 = r12.buildUpon()
            java.lang.String r5 = r13.a()
            r9 = 4
            r10 = 0
            java.lang.String r6 = "\\"
            java.lang.String r7 = ""
            r8 = 0
            java.lang.String r13 = m3.m.w(r5, r6, r7, r8, r9, r10)
            java.lang.String r14 = "log"
            android.net.Uri$Builder r12 = r12.appendQueryParameter(r14, r13)
            android.net.Uri r12 = r12.build()
            java.lang.String r12 = r12.toString()
            java.lang.String r13 = "parse(BuildConfig.INMOBI…      .build().toString()"
            kotlin.jvm.internal.m.d(r12, r13)
            W3.a r13 = r11.f23984c     // Catch:{ a -> 0x00bf }
            boolean r13 = r13.a()     // Catch:{ a -> 0x00bf }
            if (r13 == 0) goto L_0x00b5
            W3.b r13 = r11.f23985d     // Catch:{ a -> 0x00bf }
            r0.f23991c = r4     // Catch:{ a -> 0x00bf }
            java.lang.Object r15 = r13.a(r12, r0)     // Catch:{ a -> 0x00bf }
            if (r15 != r1) goto L_0x00b2
            return r1
        L_0x00b2:
            java.lang.String r15 = (java.lang.String) r15     // Catch:{ a -> 0x00bf }
            return r15
        L_0x00b5:
            com.inmobi.cmp.ChoiceCmpCallback r12 = r11.f23986e     // Catch:{ a -> 0x00bf }
            if (r12 != 0) goto L_0x00ba
            goto L_0x00bf
        L_0x00ba:
            com.inmobi.cmp.model.ChoiceError r13 = com.inmobi.cmp.model.ChoiceError.NO_CONNECTION     // Catch:{ a -> 0x00bf }
            r12.onCmpError(r13)     // Catch:{ a -> 0x00bf }
        L_0x00bf:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: T3.C2579g.a(T3.e, T3.h, T3.f, V2.d):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0068 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:20:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object b(T3.C2578f r12, T3.C2575c r13, V2.d r14) {
        /*
            r11 = this;
            boolean r0 = r14 instanceof T3.C2579g.b
            if (r0 == 0) goto L_0x0013
            r0 = r14
            T3.g$b r0 = (T3.C2579g.b) r0
            int r1 = r0.f23994c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f23994c = r1
            goto L_0x0018
        L_0x0013:
            T3.g$b r0 = new T3.g$b
            r0.<init>(r11, r14)
        L_0x0018:
            java.lang.Object r14 = r0.f23992a
            java.lang.Object r1 = W2.b.c()
            int r2 = r0.f23994c
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            R2.n.b(r14)
            goto L_0x0061
        L_0x0029:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L_0x0031:
            R2.n.b(r14)
            C3.a r14 = r11.f23983b
            if (r14 != 0) goto L_0x0039
            goto L_0x0065
        L_0x0039:
            T3.i r4 = new T3.i
            java.lang.String r5 = r14.f128a
            java.lang.String r6 = r14.f134g
            E2.s r2 = r11.f23982a
            int r7 = r2.f6403m
            int r2 = r2.f6404n
            java.lang.Integer r2 = kotlin.coroutines.jvm.internal.b.b(r2)
            java.lang.String r8 = "2."
            java.lang.String r8 = kotlin.jvm.internal.m.m(r8, r2)
            java.lang.String r9 = r13.f23967a
            java.lang.String r10 = r14.f132e
            r4.<init>(r5, r6, r7, r8, r9, r10)
            T3.e r13 = T3.C2577e.INIT
            r0.f23994c = r3
            java.lang.Object r14 = r11.a(r13, r4, r12, r0)
            if (r14 != r1) goto L_0x0061
            return r1
        L_0x0061:
            java.lang.String r14 = (java.lang.String) r14
            if (r14 != 0) goto L_0x0068
        L_0x0065:
            java.lang.String r12 = "Error sending init log: CMP configuration have not been initialized yet"
            return r12
        L_0x0068:
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: T3.C2579g.b(T3.f, T3.c, V2.d):java.lang.Object");
    }

    public final String d(String str) {
        List<Boolean> list;
        boolean a5 = m.a(str, "legitimate");
        if (a5) {
            list = C1601o.r(C1601o.k(this.f23982a.f6387D.getMap().values(), this.f23982a.f6386C.getMap().values(), this.f23982a.f6409s.getMap().values()));
        } else {
            list = C1601o.r(C1601o.k(this.f23982a.f6408r.getMap().values(), this.f23982a.f6416z.getMap().values(), this.f23982a.f6384A.getMap().values()));
        }
        boolean z4 = list instanceof Collection;
        if (!z4 || !list.isEmpty()) {
            for (Boolean booleanValue : list) {
                if (!booleanValue.booleanValue()) {
                    if (!z4 || !list.isEmpty()) {
                        for (Boolean booleanValue2 : list) {
                            if (booleanValue2.booleanValue()) {
                                return "Partial";
                            }
                        }
                    }
                    if (a5) {
                        return "all";
                    }
                    return "Reject";
                }
            }
        }
        if (a5) {
            return "none";
        }
        return "All";
    }

    public final void e(String str, String str2) {
        m.e(str, "identifier");
        m.e(str2, "value");
        List list = this.f23988g;
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        list.add(new C2587o(timeInMillis, str + ':' + str2));
    }
}
