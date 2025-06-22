package X3;

import C3.f;
import S2.C1601o;
import V3.C2590a;
import V3.C2594e;
import V3.C2597h;
import V3.C2598i;
import V3.C2599j;
import V3.C2600k;
import V3.C2601l;
import V3.C2602m;
import V3.C2603n;
import V3.q;
import V3.r;
import W3.C2604a;
import Z3.C2621j;
import androidx.leanback.preference.LeanbackPreferenceDialogFragment;
import com.inmobi.cmp.data.storage.SharedStorage;
import com.inmobi.cmp.model.ChoiceError;
import d3.l;
import java.util.List;
import java.util.Locale;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.internal.m;

public final class x implements w {

    /* renamed from: a  reason: collision with root package name */
    public final Locale f24349a;

    /* renamed from: b  reason: collision with root package name */
    public final C2604a f24350b;

    /* renamed from: c  reason: collision with root package name */
    public final SharedStorage f24351c;

    /* renamed from: d  reason: collision with root package name */
    public final W3.b f24352d;

    /* renamed from: e  reason: collision with root package name */
    public C2621j f24353e;

    /* renamed from: f  reason: collision with root package name */
    public final String f24354f = "tcfv2/translations/";

    /* renamed from: g  reason: collision with root package name */
    public r f24355g;

    /* renamed from: h  reason: collision with root package name */
    public C2594e f24356h = new C2594e((String) null, (String) null, (String) null, (String) null, (String) null, (List) null, (List) null, (List) null, (List) null, (List) null, (List) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, -1, 262143);

    /* renamed from: i  reason: collision with root package name */
    public C2598i f24357i = new C2598i((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (List) null, (List) null, 32767);

    /* renamed from: j  reason: collision with root package name */
    public C2603n f24358j = new C2603n((String) null, (String) null, (String) null, (List) null, (String) null, (String) null, (String) null, (String) null, (String) null, (List) null, 1023);

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f24359a;

        static {
            int[] iArr = new int[ChoiceError.values().length];
            iArr[ChoiceError.NETWORK_FILE_NOT_FOUND_ERROR.ordinal()] = 1;
            f24359a = iArr;
        }
    }

    public static final class b extends d {

        /* renamed from: a  reason: collision with root package name */
        public Object f24360a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f24361b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ x f24362c;

        /* renamed from: d  reason: collision with root package name */
        public int f24363d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(x xVar, V2.d dVar) {
            super(dVar);
            this.f24362c = xVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f24361b = obj;
            this.f24363d |= Integer.MIN_VALUE;
            return this.f24362c.c(this);
        }
    }

    public static final class c extends d {

        /* renamed from: a  reason: collision with root package name */
        public Object f24364a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f24365b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ x f24366c;

        /* renamed from: d  reason: collision with root package name */
        public int f24367d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(x xVar, V2.d dVar) {
            super(dVar);
            this.f24366c = xVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f24365b = obj;
            this.f24367d |= Integer.MIN_VALUE;
            return this.f24366c.a(this);
        }
    }

    public x(Locale locale, C2604a aVar, SharedStorage sharedStorage, W3.b bVar, C2621j jVar) {
        Locale locale2 = locale;
        C2604a aVar2 = aVar;
        SharedStorage sharedStorage2 = sharedStorage;
        W3.b bVar2 = bVar;
        C2621j jVar2 = jVar;
        m.e(locale2, "appLocale");
        m.e(aVar2, "networkUtil");
        m.e(sharedStorage2, "shareStorage");
        m.e(bVar2, "requestApi");
        m.e(jVar2, "resolver");
        this.f24349a = locale2;
        this.f24350b = aVar2;
        this.f24351c = sharedStorage2;
        this.f24352d = bVar2;
        this.f24353e = jVar2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object a(V2.d r13) {
        /*
            r12 = this;
            boolean r0 = r13 instanceof X3.x.c
            if (r0 == 0) goto L_0x0014
            r0 = r13
            X3.x$c r0 = (X3.x.c) r0
            int r1 = r0.f24367d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0014
            int r1 = r1 - r2
            r0.f24367d = r1
        L_0x0012:
            r13 = r0
            goto L_0x001a
        L_0x0014:
            X3.x$c r0 = new X3.x$c
            r0.<init>(r12, r13)
            goto L_0x0012
        L_0x001a:
            java.lang.Object r0 = r13.f24365b
            java.lang.Object r1 = W2.b.c()
            int r2 = r13.f24367d
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0044
            if (r2 == r4) goto L_0x003a
            if (r2 != r3) goto L_0x0032
            java.lang.Object r13 = r13.f24364a
            X3.x r13 = (X3.x) r13
            R2.n.b(r0)
            goto L_0x0096
        L_0x0032:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L_0x003a:
            java.lang.Object r2 = r13.f24364a
            X3.x r2 = (X3.x) r2
            R2.n.b(r0)     // Catch:{ a -> 0x0042 }
            goto L_0x0061
        L_0x0042:
            r0 = move-exception
            goto L_0x007e
        L_0x0044:
            R2.n.b(r0)
            W3.a r0 = r12.f24350b     // Catch:{ a -> 0x0064 }
            boolean r0 = r0.a()     // Catch:{ a -> 0x0064 }
            if (r0 == 0) goto L_0x0067
            W3.b r0 = r12.f24352d     // Catch:{ a -> 0x0064 }
            java.lang.String r2 = r12.j()     // Catch:{ a -> 0x0064 }
            r13.f24364a = r12     // Catch:{ a -> 0x0064 }
            r13.f24367d = r4     // Catch:{ a -> 0x0064 }
            java.lang.Object r0 = r0.a(r2, r13)     // Catch:{ a -> 0x0064 }
            if (r0 != r1) goto L_0x0060
            goto L_0x0094
        L_0x0060:
            r2 = r12
        L_0x0061:
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ a -> 0x0042 }
            goto L_0x00a2
        L_0x0064:
            r0 = move-exception
            r2 = r12
            goto L_0x007e
        L_0x0067:
            C2.b r5 = C2.b.f6277a     // Catch:{ a -> 0x0064 }
            com.inmobi.cmp.model.ChoiceError r6 = com.inmobi.cmp.model.ChoiceError.NO_CONNECTION     // Catch:{ a -> 0x0064 }
            r10 = 0
            r11 = 30
            r7 = 0
            r8 = 0
            r9 = 0
            C2.b.a(r5, r6, r7, r8, r9, r10, r11)     // Catch:{ a -> 0x0064 }
            com.inmobi.cmp.data.storage.SharedStorage r0 = r12.f24351c     // Catch:{ a -> 0x0064 }
            a4.a r2 = a4.a.TRANSLATIONS_TEXT     // Catch:{ a -> 0x0064 }
            java.lang.String r0 = r0.j(r2)     // Catch:{ a -> 0x0064 }
            r2 = r12
            goto L_0x00a2
        L_0x007e:
            com.inmobi.cmp.model.ChoiceError r0 = r0.f6276a
            int[] r5 = X3.x.a.f24359a
            int r0 = r0.ordinal()
            r0 = r5[r0]
            if (r0 != r4) goto L_0x009a
            r13.f24364a = r2
            r13.f24367d = r3
            java.lang.Object r0 = r2.c(r13)
            if (r0 != r1) goto L_0x0095
        L_0x0094:
            return r1
        L_0x0095:
            r13 = r2
        L_0x0096:
            java.lang.String r0 = (java.lang.String) r0
            r2 = r13
            goto L_0x00a2
        L_0x009a:
            com.inmobi.cmp.data.storage.SharedStorage r13 = r2.f24351c
            a4.a r0 = a4.a.TRANSLATIONS_TEXT
            java.lang.String r0 = r13.j(r0)
        L_0x00a2:
            com.inmobi.cmp.data.storage.SharedStorage r13 = r2.f24351c
            a4.a r1 = a4.a.TRANSLATIONS_TEXT
            r13.e(r1, r0)
            Z3.j r13 = r2.f24353e
            java.lang.Object r13 = r13.a(r0)
            V3.r r13 = (V3.r) r13
            r2.f24355g = r13
            if (r13 != 0) goto L_0x00bb
            java.lang.String r13 = "translationsText"
            kotlin.jvm.internal.m.u(r13)
            r13 = 0
        L_0x00bb:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: X3.x.a(V2.d):java.lang.Object");
    }

    public void b(f fVar) {
        m.e(fVar, "portalConfig");
        this.f24356h = fVar.f172d;
        this.f24357i = fVar.f173e;
        this.f24358j = fVar.f174f;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object c(V2.d r61) {
        /*
            r60 = this;
            r0 = r60
            r1 = r61
            boolean r2 = r1 instanceof X3.x.b
            if (r2 == 0) goto L_0x0017
            r2 = r1
            X3.x$b r2 = (X3.x.b) r2
            int r3 = r2.f24363d
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0017
            int r3 = r3 - r4
            r2.f24363d = r3
            goto L_0x001c
        L_0x0017:
            X3.x$b r2 = new X3.x$b
            r2.<init>(r0, r1)
        L_0x001c:
            java.lang.Object r1 = r2.f24361b
            java.lang.Object r3 = W2.b.c()
            int r4 = r2.f24363d
            r5 = 1
            if (r4 == 0) goto L_0x003a
            if (r4 != r5) goto L_0x0032
            java.lang.Object r2 = r2.f24360a
            X3.x r2 = (X3.x) r2
            R2.n.b(r1)     // Catch:{ a -> 0x00e4 }
            goto L_0x00e0
        L_0x0032:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x003a:
            R2.n.b(r1)
            com.inmobi.cmp.data.storage.SharedStorage r1 = r0.f24351c     // Catch:{ a -> 0x00e3 }
            a4.a r4 = a4.a.PORTAL_CHOICE_LANG     // Catch:{ a -> 0x00e3 }
            java.lang.String r6 = "EN"
            r1.e(r4, r6)     // Catch:{ a -> 0x00e3 }
            V3.e r7 = new V3.e     // Catch:{ a -> 0x00e3 }
            r58 = -1
            r59 = 262143(0x3ffff, float:3.6734E-40)
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r30 = 0
            r31 = 0
            r32 = 0
            r33 = 0
            r34 = 0
            r35 = 0
            r36 = 0
            r37 = 0
            r38 = 0
            r39 = 0
            r40 = 0
            r41 = 0
            r42 = 0
            r43 = 0
            r44 = 0
            r45 = 0
            r46 = 0
            r47 = 0
            r48 = 0
            r49 = 0
            r50 = 0
            r51 = 0
            r52 = 0
            r53 = 0
            r54 = 0
            r55 = 0
            r56 = 0
            r57 = 0
            r7.<init>(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59)     // Catch:{ a -> 0x00e3 }
            r0.f24356h = r7     // Catch:{ a -> 0x00e3 }
            V3.i r8 = new V3.i     // Catch:{ a -> 0x00e3 }
            r23 = 0
            r24 = 32767(0x7fff, float:4.5916E-41)
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r8.<init>(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)     // Catch:{ a -> 0x00e3 }
            r0.f24357i = r8     // Catch:{ a -> 0x00e3 }
            W3.b r1 = r0.f24352d     // Catch:{ a -> 0x00e3 }
            java.lang.String r4 = r0.j()     // Catch:{ a -> 0x00e3 }
            r2.f24360a = r0     // Catch:{ a -> 0x00e3 }
            r2.f24363d = r5     // Catch:{ a -> 0x00e3 }
            java.lang.Object r1 = r1.a(r4, r2)     // Catch:{ a -> 0x00e3 }
            if (r1 != r3) goto L_0x00df
            return r3
        L_0x00df:
            r2 = r0
        L_0x00e0:
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ a -> 0x00e4 }
            return r1
        L_0x00e3:
            r2 = r0
        L_0x00e4:
            com.inmobi.cmp.data.storage.SharedStorage r1 = r2.f24351c
            a4.a r2 = a4.a.TRANSLATIONS_TEXT
            java.lang.String r1 = r1.j(r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: X3.x.c(V2.d):java.lang.Object");
    }

    public C2602m d() {
        String str;
        k();
        if (this.f24356h.f24103X.length() == 0) {
            r rVar = this.f24355g;
            if (rVar == null) {
                m.u("translationsText");
                rVar = null;
            }
            str = rVar.f24230a.f24103X;
        } else {
            str = this.f24356h.f24103X;
        }
        return new C2602m(str, i());
    }

    public C2597h e() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        k();
        r rVar = null;
        if (this.f24356h.f24121r.length() == 0) {
            r rVar2 = this.f24355g;
            if (rVar2 == null) {
                m.u("translationsText");
                rVar2 = null;
            }
            str = rVar2.f24230a.f24121r;
        } else {
            str = this.f24356h.f24121r;
        }
        if (this.f24356h.f24086G.length() == 0) {
            r rVar3 = this.f24355g;
            if (rVar3 == null) {
                m.u("translationsText");
                rVar3 = null;
            }
            str2 = rVar3.f24230a.f24086G;
        } else {
            str2 = this.f24356h.f24086G;
        }
        if (this.f24356h.f24090K.length() == 0) {
            r rVar4 = this.f24355g;
            if (rVar4 == null) {
                m.u("translationsText");
                rVar4 = null;
            }
            str3 = rVar4.f24230a.f24090K;
        } else {
            str3 = this.f24356h.f24090K;
        }
        if (this.f24356h.f24091L.length() == 0) {
            r rVar5 = this.f24355g;
            if (rVar5 == null) {
                m.u("translationsText");
                rVar5 = null;
            }
            str4 = rVar5.f24230a.f24091L;
        } else {
            str4 = this.f24356h.f24091L;
        }
        if (this.f24356h.f24092M.length() == 0) {
            r rVar6 = this.f24355g;
            if (rVar6 == null) {
                m.u("translationsText");
                rVar6 = null;
            }
            str5 = rVar6.f24230a.f24092M;
        } else {
            str5 = this.f24356h.f24092M;
        }
        if (this.f24357i.f24155b.length() == 0) {
            r rVar7 = this.f24355g;
            if (rVar7 == null) {
                m.u("translationsText");
                rVar7 = null;
            }
            str6 = rVar7.f24232c.f24155b;
        } else {
            str6 = this.f24357i.f24155b;
        }
        if (this.f24356h.f24096Q.length() == 0) {
            r rVar8 = this.f24355g;
            if (rVar8 == null) {
                m.u("translationsText");
                rVar8 = null;
            }
            str7 = rVar8.f24230a.f24096Q;
        } else {
            str7 = this.f24356h.f24096Q;
        }
        if (this.f24356h.f24120q.length() == 0) {
            r rVar9 = this.f24355g;
            if (rVar9 == null) {
                m.u("translationsText");
                rVar9 = null;
            }
            str8 = rVar9.f24230a.f24120q;
        } else {
            str8 = this.f24356h.f24120q;
        }
        if (this.f24357i.f24157d.length() == 0) {
            r rVar10 = this.f24355g;
            if (rVar10 == null) {
                m.u("translationsText");
                rVar10 = null;
            }
            str9 = rVar10.f24232c.f24157d;
        } else {
            str9 = this.f24357i.f24157d;
        }
        if (this.f24357i.f24158e.length() == 0) {
            r rVar11 = this.f24355g;
            if (rVar11 == null) {
                m.u("translationsText");
            } else {
                rVar = rVar11;
            }
            str10 = rVar.f24232c.f24158e;
        } else {
            str10 = this.f24357i.f24158e;
        }
        return new C2597h(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, i());
    }

    public C2599j f() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        C2599j jVar;
        k();
        if (this.f24356h.f24104a.length() == 0) {
            r rVar = this.f24355g;
            if (rVar == null) {
                m.u("translationsText");
                rVar = null;
            }
            str = rVar.f24230a.f24104a;
        } else {
            str = this.f24356h.f24104a;
        }
        if (this.f24357i.f24168o.isEmpty()) {
            r rVar2 = this.f24355g;
            if (rVar2 == null) {
                m.u("translationsText");
                rVar2 = null;
            }
            str2 = C1601o.O(rVar2.f24232c.f24168o, " ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (l) null, 62, (Object) null);
        } else {
            str2 = C1601o.O(this.f24357i.f24168o, " ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (l) null, 62, (Object) null);
        }
        if (this.f24356h.f24121r.length() == 0) {
            r rVar3 = this.f24355g;
            if (rVar3 == null) {
                m.u("translationsText");
                rVar3 = null;
            }
            str3 = rVar3.f24230a.f24121r;
        } else {
            str3 = this.f24356h.f24121r;
        }
        if (this.f24356h.f24096Q.length() == 0) {
            r rVar4 = this.f24355g;
            if (rVar4 == null) {
                m.u("translationsText");
                rVar4 = null;
            }
            str4 = rVar4.f24230a.f24096Q;
        } else {
            str4 = this.f24356h.f24096Q;
        }
        if (this.f24357i.f24159f.length() == 0) {
            r rVar5 = this.f24355g;
            if (rVar5 == null) {
                m.u("translationsText");
                rVar5 = null;
            }
            str5 = rVar5.f24232c.f24159f;
        } else {
            str5 = this.f24357i.f24159f;
        }
        if (this.f24356h.f24118o.length() == 0) {
            r rVar6 = this.f24355g;
            if (rVar6 == null) {
                m.u("translationsText");
                rVar6 = null;
            }
            str6 = rVar6.f24230a.f24118o;
        } else {
            str6 = this.f24356h.f24118o;
        }
        if (this.f24356h.f24106c.length() == 0) {
            r rVar7 = this.f24355g;
            if (rVar7 == null) {
                m.u("translationsText");
                rVar7 = null;
            }
            str7 = rVar7.f24230a.f24106c;
        } else {
            str7 = this.f24356h.f24106c;
        }
        if (this.f24356h.f24119p.length() == 0) {
            r rVar8 = this.f24355g;
            if (rVar8 == null) {
                m.u("translationsText");
                rVar8 = null;
            }
            str8 = rVar8.f24230a.f24119p;
        } else {
            str8 = this.f24356h.f24119p;
        }
        if (this.f24356h.f24080A.length() == 0) {
            r rVar9 = this.f24355g;
            if (rVar9 == null) {
                m.u("translationsText");
                rVar9 = null;
            }
            str9 = rVar9.f24230a.f24080A;
        } else {
            str9 = this.f24356h.f24080A;
        }
        if (this.f24356h.f24120q.length() == 0) {
            r rVar10 = this.f24355g;
            if (rVar10 == null) {
                m.u("translationsText");
                rVar10 = null;
            }
            str10 = rVar10.f24230a.f24120q;
        } else {
            str10 = this.f24356h.f24120q;
        }
        if (this.f24357i.f24162i.length() == 0) {
            r rVar11 = this.f24355g;
            if (rVar11 == null) {
                m.u("translationsText");
                rVar11 = null;
            }
            str11 = rVar11.f24232c.f24162i;
        } else {
            str11 = this.f24357i.f24162i;
        }
        if (this.f24357i.f24163j.length() == 0) {
            r rVar12 = this.f24355g;
            if (rVar12 == null) {
                m.u("translationsText");
                rVar12 = null;
            }
            str12 = rVar12.f24232c.f24163j;
        } else {
            str12 = this.f24357i.f24163j;
        }
        if (this.f24357i.f24164k.length() == 0) {
            r rVar13 = this.f24355g;
            if (rVar13 == null) {
                m.u("translationsText");
                rVar13 = null;
            }
            str13 = rVar13.f24232c.f24164k;
        } else {
            str13 = this.f24357i.f24164k;
        }
        if (this.f24357i.f24165l.length() == 0) {
            r rVar14 = this.f24355g;
            if (rVar14 == null) {
                m.u("translationsText");
                rVar14 = null;
            }
            str14 = rVar14.f24232c.f24165l;
        } else {
            str14 = this.f24357i.f24165l;
        }
        String i4 = i();
        String str16 = str14;
        if (this.f24356h.f24081B.length() == 0) {
            r rVar15 = this.f24355g;
            if (rVar15 == null) {
                m.u("translationsText");
                rVar15 = null;
            }
            str15 = rVar15.f24230a.f24081B;
        } else {
            str15 = this.f24356h.f24081B;
        }
        String str17 = str15;
        jVar = new C2599j(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str16, i4, str17);
        return jVar;
    }

    public C2600k g() {
        String str;
        String upperCase;
        String upperCase2;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        k();
        r rVar = null;
        if (this.f24356h.f24096Q.length() == 0) {
            r rVar2 = this.f24355g;
            if (rVar2 == null) {
                m.u("translationsText");
                rVar2 = null;
            }
            str = rVar2.f24230a.f24096Q;
        } else {
            str = this.f24356h.f24096Q;
        }
        String str13 = str;
        if (this.f24356h.f24121r.length() == 0) {
            r rVar3 = this.f24355g;
            if (rVar3 == null) {
                m.u("translationsText");
                rVar3 = null;
            }
            upperCase = rVar3.f24230a.f24121r.toUpperCase(this.f24349a);
            m.d(upperCase, "this as java.lang.String).toUpperCase(locale)");
        } else {
            upperCase = this.f24356h.f24121r.toUpperCase(this.f24349a);
            m.d(upperCase, "this as java.lang.String).toUpperCase(locale)");
        }
        String str14 = upperCase;
        if (this.f24356h.f24122s.length() == 0) {
            r rVar4 = this.f24355g;
            if (rVar4 == null) {
                m.u("translationsText");
                rVar4 = null;
            }
            upperCase2 = rVar4.f24230a.f24122s.toUpperCase(this.f24349a);
            m.d(upperCase2, "this as java.lang.String).toUpperCase(locale)");
        } else {
            upperCase2 = this.f24356h.f24122s.toUpperCase(this.f24349a);
            m.d(upperCase2, "this as java.lang.String).toUpperCase(locale)");
        }
        String str15 = upperCase2;
        if (this.f24356h.f24124u.length() == 0) {
            r rVar5 = this.f24355g;
            if (rVar5 == null) {
                m.u("translationsText");
                rVar5 = null;
            }
            str2 = rVar5.f24230a.f24124u;
        } else {
            str2 = this.f24356h.f24124u;
        }
        String str16 = str2;
        if (this.f24356h.f24123t.length() == 0) {
            r rVar6 = this.f24355g;
            if (rVar6 == null) {
                m.u("translationsText");
                rVar6 = null;
            }
            str3 = rVar6.f24230a.f24123t;
        } else {
            str3 = this.f24356h.f24123t;
        }
        String str17 = str3;
        if (this.f24356h.f24125v.length() == 0) {
            r rVar7 = this.f24355g;
            if (rVar7 == null) {
                m.u("translationsText");
                rVar7 = null;
            }
            str4 = rVar7.f24230a.f24125v;
        } else {
            str4 = this.f24356h.f24125v;
        }
        String str18 = str4;
        if (this.f24356h.f24084E.length() == 0) {
            r rVar8 = this.f24355g;
            if (rVar8 == null) {
                m.u("translationsText");
                rVar8 = null;
            }
            str5 = rVar8.f24230a.f24084E;
        } else {
            str5 = this.f24356h.f24084E;
        }
        String str19 = str5;
        if (this.f24356h.f24097R.length() == 0) {
            r rVar9 = this.f24355g;
            if (rVar9 == null) {
                m.u("translationsText");
                rVar9 = null;
            }
            str6 = rVar9.f24230a.f24097R;
        } else {
            str6 = this.f24356h.f24097R;
        }
        String str20 = str6;
        if (this.f24356h.f24098S.length() == 0) {
            r rVar10 = this.f24355g;
            if (rVar10 == null) {
                m.u("translationsText");
                rVar10 = null;
            }
            str7 = rVar10.f24230a.f24098S;
        } else {
            str7 = this.f24356h.f24098S;
        }
        String str21 = str7;
        if (this.f24356h.f24099T.length() == 0) {
            r rVar11 = this.f24355g;
            if (rVar11 == null) {
                m.u("translationsText");
                rVar11 = null;
            }
            str8 = rVar11.f24230a.f24099T;
        } else {
            str8 = this.f24356h.f24099T;
        }
        String str22 = str8;
        if (this.f24356h.f24100U.length() == 0) {
            r rVar12 = this.f24355g;
            if (rVar12 == null) {
                m.u("translationsText");
                rVar12 = null;
            }
            str9 = rVar12.f24230a.f24100U;
        } else {
            str9 = this.f24356h.f24100U;
        }
        String str23 = str9;
        if (this.f24356h.f24101V.length() == 0) {
            r rVar13 = this.f24355g;
            if (rVar13 == null) {
                m.u("translationsText");
                rVar13 = null;
            }
            str10 = rVar13.f24230a.f24101V;
        } else {
            str10 = this.f24356h.f24101V;
        }
        String str24 = str10;
        if (this.f24356h.f24102W.length() == 0) {
            r rVar14 = this.f24355g;
            if (rVar14 == null) {
                m.u("translationsText");
                rVar14 = null;
            }
            str11 = rVar14.f24230a.f24102W;
        } else {
            str11 = this.f24356h.f24102W;
        }
        String str25 = str11;
        if (this.f24356h.f24103X.length() == 0) {
            r rVar15 = this.f24355g;
            if (rVar15 == null) {
                m.u("translationsText");
            } else {
                rVar = rVar15;
            }
            str12 = rVar.f24230a.f24103X;
        } else {
            str12 = this.f24356h.f24103X;
        }
        return new C2600k(str13, str14, str15, str16, str17, str18, str19, str20, str21, str22, str12, str23, str24, str25, i());
    }

    public q h() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        k();
        r rVar = null;
        if (this.f24356h.f24096Q.length() == 0) {
            r rVar2 = this.f24355g;
            if (rVar2 == null) {
                m.u("translationsText");
                rVar2 = null;
            }
            str = rVar2.f24230a.f24096Q;
        } else {
            str = this.f24356h.f24096Q;
        }
        if (this.f24356h.f24080A.length() == 0) {
            r rVar3 = this.f24355g;
            if (rVar3 == null) {
                m.u("translationsText");
                rVar3 = null;
            }
            str2 = rVar3.f24230a.f24080A;
        } else {
            str2 = this.f24356h.f24080A;
        }
        if (this.f24356h.f24106c.length() == 0) {
            r rVar4 = this.f24355g;
            if (rVar4 == null) {
                m.u("translationsText");
                rVar4 = null;
            }
            str3 = rVar4.f24230a.f24106c;
        } else {
            str3 = this.f24356h.f24106c;
        }
        if (this.f24357i.f24155b.length() == 0) {
            r rVar5 = this.f24355g;
            if (rVar5 == null) {
                m.u("translationsText");
                rVar5 = null;
            }
            str4 = rVar5.f24232c.f24155b;
        } else {
            str4 = this.f24357i.f24155b;
        }
        if (this.f24357i.f24165l.length() == 0) {
            r rVar6 = this.f24355g;
            if (rVar6 == null) {
                m.u("translationsText");
            } else {
                rVar = rVar6;
            }
            str5 = rVar.f24232c.f24165l;
        } else {
            str5 = this.f24357i.f24165l;
        }
        return new q(str, str2, str3, str4, str5, i());
    }

    public final String i() {
        if (this.f24356h.f24126w.length() != 0) {
            return this.f24356h.f24126w;
        }
        r rVar = this.f24355g;
        if (rVar == null) {
            m.u("translationsText");
            rVar = null;
        }
        return rVar.f24230a.f24126w;
    }

    public final String j() {
        String j4 = this.f24351c.j(a4.a.PORTAL_CHOICE_LANG);
        m.e(j4, LeanbackPreferenceDialogFragment.ARG_KEY);
        int[] a5 = E2.b.a(26);
        int length = a5.length;
        int i4 = 0;
        while (true) {
            if (i4 >= length) {
                j4 = this.f24349a.getLanguage();
                break;
            }
            int i5 = a5[i4];
            i4++;
            if (m3.m.p(z3.a.b(i5), j4, true) && !m3.m.p(j4, "autoDetectedLanguage", true)) {
                break;
            }
        }
        StringBuilder a6 = A2.a.a("https://cmp.inmobi.com/");
        a6.append(this.f24354f);
        m.d(j4, "language");
        String lowerCase = j4.toLowerCase(this.f24349a);
        m.d(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        a6.append(lowerCase);
        a6.append(".json");
        return a6.toString();
    }

    public final void k() {
        r rVar;
        if (this.f24355g == null) {
            String j4 = this.f24351c.j(a4.a.TRANSLATIONS_TEXT);
            if (j4.length() > 0) {
                rVar = (r) this.f24353e.a(j4);
            } else {
                rVar = new r((C2594e) null, (C2603n) null, (C2598i) null, 7);
            }
            this.f24355g = rVar;
        }
    }

    public C2590a b() {
        String str;
        List list;
        String str2;
        String str3;
        String str4;
        r rVar = null;
        if (this.f24358j.f24211c.length() == 0) {
            r rVar2 = this.f24355g;
            if (rVar2 == null) {
                m.u("translationsText");
                rVar2 = null;
            }
            str = rVar2.f24231b.f24211c;
        } else {
            str = this.f24358j.f24211c;
        }
        if (this.f24358j.f24212d.isEmpty()) {
            r rVar3 = this.f24355g;
            if (rVar3 == null) {
                m.u("translationsText");
                rVar3 = null;
            }
            list = rVar3.f24231b.f24212d;
        } else {
            list = this.f24358j.f24212d;
        }
        if (this.f24358j.f24215g.length() == 0) {
            r rVar4 = this.f24355g;
            if (rVar4 == null) {
                m.u("translationsText");
                rVar4 = null;
            }
            str2 = rVar4.f24231b.f24215g;
        } else {
            str2 = this.f24358j.f24215g;
        }
        if (this.f24358j.f24216h.length() == 0) {
            r rVar5 = this.f24355g;
            if (rVar5 == null) {
                m.u("translationsText");
                rVar5 = null;
            }
            str3 = rVar5.f24231b.f24216h;
        } else {
            str3 = this.f24358j.f24216h;
        }
        if (this.f24358j.f24214f.length() == 0) {
            r rVar6 = this.f24355g;
            if (rVar6 == null) {
                m.u("translationsText");
            } else {
                rVar = rVar6;
            }
            str4 = rVar.f24231b.f24214f;
        } else {
            str4 = this.f24358j.f24214f;
        }
        return new C2590a(str, list, str2, str3, str4, i());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00fe, code lost:
        if (r0 == null) goto L_0x0100;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0102, code lost:
        r10 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x011e, code lost:
        if (r0 == null) goto L_0x0100;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public V3.C2596g c() {
        /*
            r14 = this;
            r14.k()
            V3.e r0 = r14.f24356h
            java.lang.String r0 = r0.f24104a
            int r0 = r0.length()
            java.lang.String r1 = "translationsText"
            r2 = 0
            if (r0 != 0) goto L_0x001e
            V3.r r0 = r14.f24355g
            if (r0 != 0) goto L_0x0018
            kotlin.jvm.internal.m.u(r1)
            r0 = r2
        L_0x0018:
            V3.e r0 = r0.f24230a
            java.lang.String r0 = r0.f24104a
        L_0x001c:
            r4 = r0
            goto L_0x0023
        L_0x001e:
            V3.e r0 = r14.f24356h
            java.lang.String r0 = r0.f24104a
            goto L_0x001c
        L_0x0023:
            V3.i r0 = r14.f24357i
            java.util.List r0 = r0.f24168o
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x0049
            V3.r r0 = r14.f24355g
            if (r0 != 0) goto L_0x0035
            kotlin.jvm.internal.m.u(r1)
            r0 = r2
        L_0x0035:
            V3.i r0 = r0.f24232c
            java.util.List r5 = r0.f24168o
            r12 = 62
            r13 = 0
            java.lang.String r6 = " "
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            java.lang.String r0 = S2.C1601o.O(r5, r6, r7, r8, r9, r10, r11, r12, r13)
        L_0x0047:
            r5 = r0
            goto L_0x005c
        L_0x0049:
            V3.i r0 = r14.f24357i
            java.util.List r5 = r0.f24168o
            r12 = 62
            r13 = 0
            java.lang.String r6 = " "
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            java.lang.String r0 = S2.C1601o.O(r5, r6, r7, r8, r9, r10, r11, r12, r13)
            goto L_0x0047
        L_0x005c:
            V3.e r0 = r14.f24356h
            java.lang.String r0 = r0.f24108e
            int r0 = r0.length()
            if (r0 != 0) goto L_0x0074
            V3.r r0 = r14.f24355g
            if (r0 != 0) goto L_0x006e
            kotlin.jvm.internal.m.u(r1)
            r0 = r2
        L_0x006e:
            V3.e r0 = r0.f24230a
            java.lang.String r0 = r0.f24108e
        L_0x0072:
            r6 = r0
            goto L_0x0079
        L_0x0074:
            V3.e r0 = r14.f24356h
            java.lang.String r0 = r0.f24108e
            goto L_0x0072
        L_0x0079:
            V3.e r0 = r14.f24356h
            java.lang.String r0 = r0.f24105b
            int r0 = r0.length()
            if (r0 != 0) goto L_0x0091
            V3.r r0 = r14.f24355g
            if (r0 != 0) goto L_0x008b
            kotlin.jvm.internal.m.u(r1)
            r0 = r2
        L_0x008b:
            V3.e r0 = r0.f24230a
            java.lang.String r0 = r0.f24105b
        L_0x008f:
            r7 = r0
            goto L_0x0096
        L_0x0091:
            V3.e r0 = r14.f24356h
            java.lang.String r0 = r0.f24105b
            goto L_0x008f
        L_0x0096:
            V3.e r0 = r14.f24356h
            java.lang.String r0 = r0.f24107d
            int r0 = r0.length()
            if (r0 != 0) goto L_0x00ae
            V3.r r0 = r14.f24355g
            if (r0 != 0) goto L_0x00a8
            kotlin.jvm.internal.m.u(r1)
            r0 = r2
        L_0x00a8:
            V3.e r0 = r0.f24230a
            java.lang.String r0 = r0.f24107d
        L_0x00ac:
            r8 = r0
            goto L_0x00b3
        L_0x00ae:
            V3.e r0 = r14.f24356h
            java.lang.String r0 = r0.f24107d
            goto L_0x00ac
        L_0x00b3:
            V3.e r0 = r14.f24356h
            java.lang.String r0 = r0.f24120q
            int r0 = r0.length()
            if (r0 != 0) goto L_0x00cb
            V3.r r0 = r14.f24355g
            if (r0 != 0) goto L_0x00c5
            kotlin.jvm.internal.m.u(r1)
            r0 = r2
        L_0x00c5:
            V3.e r0 = r0.f24230a
            java.lang.String r0 = r0.f24120q
        L_0x00c9:
            r9 = r0
            goto L_0x00d0
        L_0x00cb:
            V3.e r0 = r14.f24356h
            java.lang.String r0 = r0.f24120q
            goto L_0x00c9
        L_0x00d0:
            V3.n r0 = r14.f24358j
            java.util.List r0 = r0.f24218j
            boolean r0 = r0.isEmpty()
            java.lang.String r3 = ""
            if (r0 == 0) goto L_0x0104
            V3.r r0 = r14.f24355g
            if (r0 != 0) goto L_0x00e4
            kotlin.jvm.internal.m.u(r1)
            r0 = r2
        L_0x00e4:
            V3.n r0 = r0.f24231b
            java.util.List r0 = r0.f24218j
            boolean r10 = r0.isEmpty()
            if (r10 != 0) goto L_0x00ef
            goto L_0x00f0
        L_0x00ef:
            r0 = r2
        L_0x00f0:
            if (r0 != 0) goto L_0x00f3
            goto L_0x0100
        L_0x00f3:
            java.lang.Object r0 = S2.C1601o.H(r0)
            V3.o r0 = (V3.o) r0
            if (r0 != 0) goto L_0x00fc
            goto L_0x0100
        L_0x00fc:
            java.lang.String r0 = r0.f24220b
            if (r0 != 0) goto L_0x0102
        L_0x0100:
            r10 = r3
            goto L_0x0121
        L_0x0102:
            r10 = r0
            goto L_0x0121
        L_0x0104:
            V3.n r0 = r14.f24358j
            java.util.List r0 = r0.f24218j
            boolean r10 = r0.isEmpty()
            if (r10 != 0) goto L_0x010f
            goto L_0x0110
        L_0x010f:
            r0 = r2
        L_0x0110:
            if (r0 != 0) goto L_0x0113
            goto L_0x0120
        L_0x0113:
            java.lang.Object r0 = S2.C1601o.H(r0)
            V3.o r0 = (V3.o) r0
            if (r0 != 0) goto L_0x011c
            goto L_0x0120
        L_0x011c:
            java.lang.String r0 = r0.f24220b
            if (r0 != 0) goto L_0x0102
        L_0x0120:
            goto L_0x0100
        L_0x0121:
            V3.e r0 = r14.f24356h
            java.lang.String r0 = r0.f24084E
            int r0 = r0.length()
            if (r0 != 0) goto L_0x013a
            V3.r r0 = r14.f24355g
            if (r0 != 0) goto L_0x0133
            kotlin.jvm.internal.m.u(r1)
            goto L_0x0134
        L_0x0133:
            r2 = r0
        L_0x0134:
            V3.e r0 = r2.f24230a
            java.lang.String r0 = r0.f24084E
        L_0x0138:
            r11 = r0
            goto L_0x013f
        L_0x013a:
            V3.e r0 = r14.f24356h
            java.lang.String r0 = r0.f24084E
            goto L_0x0138
        L_0x013f:
            V3.g r3 = new V3.g
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: X3.x.c():V3.g");
    }

    public C2601l a() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        k();
        r rVar = null;
        if (this.f24357i.f24159f.length() == 0) {
            r rVar2 = this.f24355g;
            if (rVar2 == null) {
                m.u("translationsText");
                rVar2 = null;
            }
            str = rVar2.f24232c.f24159f;
        } else {
            str = this.f24357i.f24159f;
        }
        if (this.f24356h.f24083D.length() == 0) {
            r rVar3 = this.f24355g;
            if (rVar3 == null) {
                m.u("translationsText");
                rVar3 = null;
            }
            str2 = rVar3.f24230a.f24083D;
        } else {
            str2 = this.f24356h.f24083D;
        }
        if (this.f24357i.f24155b.length() == 0) {
            r rVar4 = this.f24355g;
            if (rVar4 == null) {
                m.u("translationsText");
                rVar4 = null;
            }
            str3 = rVar4.f24232c.f24155b;
        } else {
            str3 = this.f24357i.f24155b;
        }
        if (this.f24356h.f24120q.length() == 0) {
            r rVar5 = this.f24355g;
            if (rVar5 == null) {
                m.u("translationsText");
                rVar5 = null;
            }
            str4 = rVar5.f24230a.f24120q;
        } else {
            str4 = this.f24356h.f24120q;
        }
        if (this.f24357i.f24157d.length() == 0) {
            r rVar6 = this.f24355g;
            if (rVar6 == null) {
                m.u("translationsText");
                rVar6 = null;
            }
            str5 = rVar6.f24232c.f24157d;
        } else {
            str5 = this.f24357i.f24157d;
        }
        if (this.f24357i.f24158e.length() == 0) {
            r rVar7 = this.f24355g;
            if (rVar7 == null) {
                m.u("translationsText");
            } else {
                rVar = rVar7;
            }
            str6 = rVar.f24232c.f24158e;
        } else {
            str6 = this.f24357i.f24158e;
        }
        return new C2601l(str, str2, str3, str4, str5, str6, i());
    }
}
