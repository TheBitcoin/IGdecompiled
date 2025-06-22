package T3;

import R2.n;
import R2.s;
import V2.g;
import androidx.lifecycle.CoroutineLiveDataKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataScope;
import c.h;
import c.i;
import c.j;
import c.k;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import d3.p;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.UUID;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.z;
import o3.C0988l0;
import o3.C1001s0;
import o3.J;
import o3.L;
import o3.Y;

/* renamed from: T3.m  reason: case insensitive filesystem */
public final class C2585m {

    /* renamed from: a  reason: collision with root package name */
    public static final C2585m f24018a = new C2585m();

    /* renamed from: b  reason: collision with root package name */
    public static UUID f24019b = UUID.randomUUID();

    /* renamed from: c  reason: collision with root package name */
    public static C2579g f24020c = b4.d.f24465a.o();

    /* renamed from: T3.m$a */
    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f24021a;

        static {
            int[] iArr = new int[C2578f.values().length];
            iArr[1] = 1;
            iArr[5] = 2;
            iArr[0] = 3;
            iArr[2] = 4;
            iArr[3] = 5;
            iArr[4] = 6;
            f24021a = iArr;
            int[] iArr2 = new int[C2586n.values().length];
            iArr2[5] = 1;
            iArr2[6] = 2;
            iArr2[4] = 3;
            int[] iArr3 = new int[C2573a.values().length];
            iArr3[0] = 1;
            iArr3[2] = 2;
        }
    }

    /* renamed from: T3.m$b */
    public static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        public int f24022a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f24023b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f24024c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f24025d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Boolean f24026e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ C2578f f24027f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(String str, String str2, Boolean bool, C2578f fVar, V2.d dVar) {
            super(2, dVar);
            this.f24024c = str;
            this.f24025d = str2;
            this.f24026e = bool;
            this.f24027f = fVar;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            b bVar = new b(this.f24024c, this.f24025d, this.f24026e, this.f24027f, dVar);
            bVar.f24023b = obj;
            return bVar;
        }

        public Object invoke(Object obj, Object obj2) {
            return ((b) create((LiveDataScope) obj, (V2.d) obj2)).invokeSuspend(s.f8222a);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v5, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: androidx.lifecycle.LiveDataScope} */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0067, code lost:
            if (r15 == r0) goto L_0x0076;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0074, code lost:
            if (r1.emit((java.lang.String) r15, r14) == r0) goto L_0x0076;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0076, code lost:
            return r0;
         */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r15) {
            /*
                r14 = this;
                java.lang.Object r0 = W2.b.c()
                int r1 = r14.f24022a
                r2 = 2
                r3 = 1
                r4 = 0
                if (r1 == 0) goto L_0x0026
                if (r1 == r3) goto L_0x001d
                if (r1 != r2) goto L_0x0015
                R2.n.b(r15)
                r12 = r14
                goto L_0x0077
            L_0x0015:
                java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r15.<init>(r0)
                throw r15
            L_0x001d:
                java.lang.Object r1 = r14.f24023b
                androidx.lifecycle.LiveDataScope r1 = (androidx.lifecycle.LiveDataScope) r1
                R2.n.b(r15)
                r12 = r14
                goto L_0x006a
            L_0x0026:
                R2.n.b(r15)
                java.lang.Object r15 = r14.f24023b
                r1 = r15
                androidx.lifecycle.LiveDataScope r1 = (androidx.lifecycle.LiveDataScope) r1
                T3.g r5 = T3.C2585m.f24020c
                java.lang.String r15 = r14.f24024c
                if (r15 == 0) goto L_0x003f
                int r15 = r15.length()
                if (r15 != 0) goto L_0x003b
                goto L_0x003f
            L_0x003b:
                java.lang.String r15 = r14.f24024c
                r7 = r15
                goto L_0x0040
            L_0x003f:
                r7 = r4
            L_0x0040:
                b4.d r15 = b4.d.f24465a
                com.inmobi.cmp.data.storage.SharedStorage r15 = r15.m()
                a4.a r6 = a4.a.NON_IAB_CONSENT_ENCODED
                java.lang.String r9 = r15.j(r6)
                java.lang.String r15 = r14.f24025d
                int r6 = r15.length()
                if (r6 != 0) goto L_0x0056
                r8 = r4
                goto L_0x0057
            L_0x0056:
                r8 = r15
            L_0x0057:
                java.lang.Boolean r6 = r14.f24026e
                T3.f r11 = r14.f24027f
                r14.f24023b = r1
                r14.f24022a = r3
                r10 = 0
                r13 = 16
                r12 = r14
                java.lang.Object r15 = T3.C2579g.c(r5, r6, r7, r8, r9, r10, r11, r12, r13)
                if (r15 != r0) goto L_0x006a
                goto L_0x0076
            L_0x006a:
                java.lang.String r15 = (java.lang.String) r15
                r12.f24023b = r4
                r12.f24022a = r2
                java.lang.Object r15 = r1.emit(r15, r14)
                if (r15 != r0) goto L_0x0077
            L_0x0076:
                return r0
            L_0x0077:
                R2.s r15 = R2.s.f8222a
                return r15
            */
            throw new UnsupportedOperationException("Method not decompiled: T3.C2585m.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* renamed from: T3.m$c */
    public static final class c extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        public int f24028a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f24029b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f24030c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ C2573a f24031d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f24032e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(String str, C2573a aVar, int i4, V2.d dVar) {
            super(2, dVar);
            this.f24030c = str;
            this.f24031d = aVar;
            this.f24032e = i4;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            c cVar = new c(this.f24030c, this.f24031d, this.f24032e, dVar);
            cVar.f24029b = obj;
            return cVar;
        }

        public Object invoke(Object obj, Object obj2) {
            c cVar = new c(this.f24030c, this.f24031d, this.f24032e, (V2.d) obj2);
            cVar.f24029b = (LiveDataScope) obj;
            return cVar.invokeSuspend(s.f8222a);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0084, code lost:
            if (r5 == r1) goto L_0x0093;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0091, code lost:
            if (r2.emit((java.lang.String) r5, r0) == r1) goto L_0x0093;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0093, code lost:
            return r1;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r21) {
            /*
                r20 = this;
                r0 = r20
                java.lang.Object r1 = W2.b.c()
                int r2 = r0.f24028a
                r3 = 0
                r4 = 2
                r5 = 1
                if (r2 == 0) goto L_0x0028
                if (r2 == r5) goto L_0x001e
                if (r2 != r4) goto L_0x0016
                R2.n.b(r21)
                goto L_0x0094
            L_0x0016:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r1.<init>(r2)
                throw r1
            L_0x001e:
                java.lang.Object r2 = r0.f24029b
                androidx.lifecycle.LiveDataScope r2 = (androidx.lifecycle.LiveDataScope) r2
                R2.n.b(r21)
                r5 = r21
                goto L_0x0087
            L_0x0028:
                R2.n.b(r21)
                java.lang.Object r2 = r0.f24029b
                androidx.lifecycle.LiveDataScope r2 = (androidx.lifecycle.LiveDataScope) r2
                T3.g r6 = T3.C2585m.f24020c
                b4.d r7 = b4.d.f24465a
                com.inmobi.cmp.data.storage.SharedStorage r7 = r7.m()
                a4.a r8 = a4.a.GPP_STRING
                java.lang.String r14 = r7.j(r8)
                java.lang.String r7 = r0.f24030c
                java.lang.String r8 = "STATE_AND_NATIONAL"
                boolean r7 = kotlin.jvm.internal.m.a(r7, r8)
                if (r7 == 0) goto L_0x004b
                java.lang.String r7 = b4.d.f24478n
                r15 = r7
                goto L_0x004c
            L_0x004b:
                r15 = r3
            L_0x004c:
                java.lang.String r7 = r0.f24030c
                T3.a r8 = r0.f24031d
                int r9 = r0.f24032e
                r0.f24029b = r2
                r0.f24028a = r5
                r6.getClass()
                java.util.ArrayList r10 = new java.util.ArrayList
                r10.<init>()
                java.util.List r5 = r6.f23988g
                r10.addAll(r5)
                java.lang.String r11 = r8.f23955a
                java.lang.String r12 = T3.C2576d.a(r9)
                T3.j r9 = new T3.j
                r18 = 0
                r19 = 392(0x188, float:5.5E-43)
                r13 = 0
                r17 = 0
                r16 = r7
                r9.<init>(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
                java.util.List r5 = r6.f23988g
                r5.clear()
                T3.e r5 = T3.C2577e.DONE
                T3.f r7 = T3.C2578f.MSPA
                java.lang.Object r5 = r6.a(r5, r9, r7, r0)
                if (r5 != r1) goto L_0x0087
                goto L_0x0093
            L_0x0087:
                java.lang.String r5 = (java.lang.String) r5
                r0.f24029b = r3
                r0.f24028a = r4
                java.lang.Object r2 = r2.emit(r5, r0)
                if (r2 != r1) goto L_0x0094
            L_0x0093:
                return r1
            L_0x0094:
                R2.s r1 = R2.s.f8222a
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: T3.C2585m.c.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* renamed from: T3.m$d */
    public static final class d extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        public int f24033a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ C f24034b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ C f24035c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(C c5, C c6, V2.d dVar) {
            super(2, dVar);
            this.f24034b = c5;
            this.f24035c = c6;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new d(this.f24034b, this.f24035c, dVar);
        }

        public Object invoke(Object obj, Object obj2) {
            J j4 = (J) obj;
            return new d(this.f24034b, this.f24035c, (V2.d) obj2).invokeSuspend(s.f8222a);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f24033a;
            if (i4 == 0) {
                n.b(obj);
                this.f24033a = 1;
                if (C2585m.f24020c.b((C2578f) this.f24034b.f20968a, (C2575c) this.f24035c.f20968a, this) == c5) {
                    return c5;
                }
            } else if (i4 == 1) {
                n.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return s.f8222a;
        }
    }

    static {
        new LinkedHashMap();
        new LinkedHashMap();
    }

    public final LiveData a(C2586n nVar, C2573a aVar) {
        String str;
        int i4;
        m.e(nVar, "actionTag");
        m.e(aVar, "acceptanceState");
        int ordinal = nVar.ordinal();
        if (ordinal == 4) {
            str = String.valueOf(C2586n.SAVE_AND_EXIT);
        } else if (ordinal == 5) {
            str = String.valueOf(C2586n.ACCEPT_ALL);
        } else if (ordinal != 6) {
            str = String.valueOf(C2586n.PARTIAL_CONSENT);
        } else {
            str = String.valueOf(C2586n.REJECT_ALL);
        }
        int ordinal2 = aVar.ordinal();
        if (ordinal2 != 0) {
            i4 = 2;
            if (ordinal2 != 2) {
                i4 = 3;
            }
        } else {
            i4 = 1;
        }
        f24020c.e(str, CampaignEx.JSON_NATIVE_VIDEO_CLICK);
        return CoroutineLiveDataKt.liveData$default((g) null, 0, (p) new c(b4.d.f24465a.m().j(a4.a.SAVED_MSPA_JURISDICTION), aVar, i4, (V2.d) null), 3, (Object) null);
    }

    public final LiveData b(C2586n nVar, C2578f fVar) {
        Boolean bool;
        String str;
        Boolean bool2;
        m.e(nVar, "actionTag");
        m.e(fVar, "regulation");
        int ordinal = nVar.ordinal();
        String str2 = null;
        if (ordinal != 4) {
            if (ordinal == 5) {
                bool2 = Boolean.TRUE;
                str = String.valueOf(C2586n.ACCEPT_ALL);
            } else if (ordinal != 6) {
                bool2 = Boolean.FALSE;
                str = String.valueOf(C2586n.PARTIAL_CONSENT);
            } else {
                bool2 = Boolean.FALSE;
                str = String.valueOf(C2586n.REJECT_ALL);
            }
            bool = bool2;
        } else {
            str = String.valueOf(C2586n.SAVE_AND_EXIT);
            bool = null;
        }
        if (a.f24021a[fVar.ordinal()] == 1) {
            str2 = b4.d.f24465a.m().j(a4.a.TC_STRING);
        }
        String str3 = str2;
        String j4 = b4.d.f24465a.m().j(a4.a.GPP_STRING);
        f24020c.e(str, CampaignEx.JSON_NATIVE_VIDEO_CLICK);
        return CoroutineLiveDataKt.liveData$default((g) null, 0, (p) new b(str3, j4, bool, fVar, (V2.d) null), 3, (Object) null);
    }

    public final Object c(C2578f fVar, int i4, V2.d dVar) {
        Object obj;
        f24020c.e("goToPage", String.valueOf(i4));
        C2579g gVar = f24020c;
        if (gVar.f23988g.size() < 2) {
            obj = "";
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(gVar.f23988g);
            C2583k kVar = new C2583k(arrayList);
            gVar.f23988g.clear();
            obj = gVar.a(C2577e.NAVIGATION, kVar, fVar, dVar);
        }
        if (obj == W2.b.c()) {
            return obj;
        }
        return s.f8222a;
    }

    public final Object d(V2.d dVar) {
        String str;
        C2579g gVar = f24020c;
        C2578f fVar = C2578f.GBC;
        i iVar = i.f1157a;
        ArrayList arrayList = new ArrayList();
        i.f1159c.forEach(new h(arrayList));
        gVar.getClass();
        z zVar = new z();
        zVar.f20985a = true;
        i.f1159c.forEach(new j(zVar));
        if (zVar.f20985a) {
            str = "All";
        } else {
            z zVar2 = new z();
            zVar2.f20985a = true;
            i.f1159c.forEach(new k(zVar2));
            if (zVar2.f20985a) {
                str = "Reject";
            } else {
                str = "Partial";
            }
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.addAll(gVar.f23988g);
        C2584l lVar = new C2584l(arrayList2, str, arrayList);
        gVar.f23988g.clear();
        Object a5 = gVar.a(C2577e.DONE, lVar, fVar, dVar);
        if (a5 == W2.b.c()) {
            return a5;
        }
        return s.f8222a;
    }

    public final void e(C2578f fVar, boolean z4) {
        C2575c cVar;
        C2575c cVar2;
        m.e(fVar, "regulation");
        C c5 = new C();
        c5.f20968a = fVar;
        C c6 = new C();
        C2575c cVar3 = C2575c.TCF_CHANGE_OF_CONSENT;
        c6.f20968a = cVar3;
        int ordinal = fVar.ordinal();
        if (ordinal == 0) {
            c6.f20968a = C2575c.USP;
        } else if (ordinal == 1) {
            if (z4) {
                cVar3 = C2575c.TCF_MANDATORY;
            }
            c6.f20968a = cVar3;
        } else if (ordinal == 2) {
            c6.f20968a = C2575c.GBC;
        } else if (ordinal == 3) {
            if (z4) {
                cVar = C2575c.GBC_MANDATORY;
            } else {
                cVar = C2575c.GBC_CHANGE_OF_CONSENT;
            }
            c6.f20968a = cVar;
        } else if (ordinal == 4) {
            c6.f20968a = C2575c.GBC_US_OPT_OUT;
        } else if (ordinal == 5) {
            if (z4) {
                cVar2 = C2575c.MSPA_MANDATORY;
            } else if (b4.d.f24465a.m().h(a4.a.MSPA_SHOWN)) {
                cVar2 = C2575c.MSPA_CHANGE_OF_CONSENT;
            } else {
                cVar2 = C2575c.MSPA_OPT_OUT;
            }
            c6.f20968a = cVar2;
        }
        if (fVar == C2578f.GDPRWITHGBC || fVar == C2578f.USPWITHGBC) {
            c5.f20968a = C2578f.GBC;
        }
        C2579g gVar = f24020c;
        gVar.e("startOnPage", c5.f20968a + "_1");
        f24019b = UUID.randomUUID();
        C1001s0 unused = C0981i.d(C0988l0.f3711a, Y.b(), (L) null, new d(c5, c6, (V2.d) null), 2, (Object) null);
    }

    public final void f(String str, String str2) {
        m.e(str, "identifier");
        m.e(str2, "value");
        f24020c.e(str, str2);
    }
}
