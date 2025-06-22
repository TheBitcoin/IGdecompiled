package com.uptodown.activities;

import R2.n;
import R2.s;
import android.content.Context;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import d3.p;
import g2.C2048f;
import g2.S;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.z;
import o3.C1001s0;
import o3.J;
import o3.L;
import o3.Y;
import r3.I;
import r3.K;
import r3.t;
import u2.E;

public final class P extends ViewModel {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final t f18084a;

    /* renamed from: b  reason: collision with root package name */
    private final I f18085b;

    /* renamed from: c  reason: collision with root package name */
    private final t f18086c;

    /* renamed from: d  reason: collision with root package name */
    private final t f18087d;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final boolean f18088a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f18089b;

        public a(boolean z4, boolean z5) {
            this.f18088a = z4;
            this.f18089b = z5;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f18088a == aVar.f18088a && this.f18089b == aVar.f18089b;
        }

        public int hashCode() {
            return (androidx.privacysandbox.ads.adservices.adid.a.a(this.f18088a) * 31) + androidx.privacysandbox.ads.adservices.adid.a.a(this.f18089b);
        }

        public String toString() {
            return "DownloadAllButtonData(hasUpdates=" + this.f18088a + ", allCompleted=" + this.f18089b + ')';
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final ArrayList f18090a;

        /* renamed from: b  reason: collision with root package name */
        private final ArrayList f18091b;

        /* renamed from: c  reason: collision with root package name */
        private final ArrayList f18092c;

        /* renamed from: d  reason: collision with root package name */
        private final ArrayList f18093d;

        /* renamed from: e  reason: collision with root package name */
        private final a f18094e;

        public b(ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4, a aVar) {
            m.e(arrayList, "updates");
            m.e(arrayList2, "disabled");
            m.e(arrayList3, "ignored");
            m.e(arrayList4, "recentlyUpdated");
            m.e(aVar, "downloadAllButtonData");
            this.f18090a = arrayList;
            this.f18091b = arrayList2;
            this.f18092c = arrayList3;
            this.f18093d = arrayList4;
            this.f18094e = aVar;
        }

        public final ArrayList a() {
            return this.f18091b;
        }

        public final ArrayList b() {
            return this.f18092c;
        }

        public final ArrayList c() {
            return this.f18093d;
        }

        public final ArrayList d() {
            return this.f18090a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return m.a(this.f18090a, bVar.f18090a) && m.a(this.f18091b, bVar.f18091b) && m.a(this.f18092c, bVar.f18092c) && m.a(this.f18093d, bVar.f18093d) && m.a(this.f18094e, bVar.f18094e);
        }

        public int hashCode() {
            return (((((((this.f18090a.hashCode() * 31) + this.f18091b.hashCode()) * 31) + this.f18092c.hashCode()) * 31) + this.f18093d.hashCode()) * 31) + this.f18094e.hashCode();
        }

        public String toString() {
            return "UpdatesData(updates=" + this.f18090a + ", disabled=" + this.f18091b + ", ignored=" + this.f18092c + ", recentlyUpdated=" + this.f18093d + ", downloadAllButtonData=" + this.f18094e + ')';
        }
    }

    static final class c extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a  reason: collision with root package name */
        Object f18095a;

        /* renamed from: b  reason: collision with root package name */
        /* synthetic */ Object f18096b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ P f18097c;

        /* renamed from: d  reason: collision with root package name */
        int f18098d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(P p4, V2.d dVar) {
            super(dVar);
            this.f18097c = p4;
        }

        public final Object invokeSuspend(Object obj) {
            this.f18096b = obj;
            this.f18098d |= Integer.MIN_VALUE;
            return this.f18097c.d((Context) null, (ArrayList) null, false, this);
        }
    }

    static final class d extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f18099a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f18100b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ArrayList f18101c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Context f18102d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ z f18103e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(boolean z4, ArrayList arrayList, Context context, z zVar, V2.d dVar) {
            super(2, dVar);
            this.f18100b = z4;
            this.f18101c = arrayList;
            this.f18102d = context;
            this.f18103e = zVar;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new d(this.f18100b, this.f18101c, this.f18102d, this.f18103e, dVar);
        }

        /* JADX WARNING: Removed duplicated region for block: B:18:0x003d A[EDGE_INSN: B:18:0x003d->B:12:0x003d ?: BREAK  , SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:7:0x001f  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r3) {
            /*
                r2 = this;
                W2.b.c()
                int r0 = r2.f18099a
                if (r0 != 0) goto L_0x0040
                R2.n.b(r3)
                boolean r3 = r2.f18100b
                if (r3 == 0) goto L_0x003d
                java.util.ArrayList r3 = r2.f18101c
                java.util.Iterator r3 = r3.iterator()
                java.lang.String r0 = "iterator(...)"
                kotlin.jvm.internal.m.d(r3, r0)
            L_0x0019:
                boolean r0 = r3.hasNext()
                if (r0 == 0) goto L_0x003d
                java.lang.Object r0 = r3.next()
                java.lang.String r1 = "next(...)"
                kotlin.jvm.internal.m.d(r0, r1)
                g2.S r0 = (g2.S) r0
                android.content.Context r1 = r2.f18102d
                g2.s r0 = r0.b(r1)
                if (r0 == 0) goto L_0x0038
                boolean r0 = r0.f()
                if (r0 != 0) goto L_0x0019
            L_0x0038:
                kotlin.jvm.internal.z r3 = r2.f18103e
                r0 = 0
                r3.f20985a = r0
            L_0x003d:
                R2.s r3 = R2.s.f8222a
                return r3
            L_0x0040:
                java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r3.<init>(r0)
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.P.d.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((d) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class e extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        Object f18104a;

        /* renamed from: b  reason: collision with root package name */
        Object f18105b;

        /* renamed from: c  reason: collision with root package name */
        Object f18106c;

        /* renamed from: d  reason: collision with root package name */
        Object f18107d;

        /* renamed from: e  reason: collision with root package name */
        Object f18108e;

        /* renamed from: f  reason: collision with root package name */
        boolean f18109f;

        /* renamed from: g  reason: collision with root package name */
        int f18110g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ boolean f18111h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ P f18112i;

        /* renamed from: j  reason: collision with root package name */
        final /* synthetic */ Context f18113j;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(boolean z4, P p4, Context context, V2.d dVar) {
            super(2, dVar);
            this.f18111h = z4;
            this.f18112i = p4;
            this.f18113j = context;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new e(this.f18111h, this.f18112i, this.f18113j, dVar);
        }

        /* JADX WARNING: Removed duplicated region for block: B:55:0x01d3  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r19) {
            /*
                r18 = this;
                r0 = r18
                java.lang.Object r1 = W2.b.c()
                int r2 = r0.f18110g
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L_0x0053
                if (r2 == r4) goto L_0x0035
                if (r2 != r3) goto L_0x002d
                boolean r1 = r0.f18109f
                java.lang.Object r2 = r0.f18107d
                java.util.ArrayList r2 = (java.util.ArrayList) r2
                java.lang.Object r3 = r0.f18106c
                java.util.ArrayList r3 = (java.util.ArrayList) r3
                java.lang.Object r4 = r0.f18105b
                java.util.ArrayList r4 = (java.util.ArrayList) r4
                java.lang.Object r5 = r0.f18104a
                java.util.ArrayList r5 = (java.util.ArrayList) r5
                R2.n.b(r19)
                r7 = r19
                r9 = r2
                r11 = r4
            L_0x0029:
                r12 = r3
                r10 = r5
                goto L_0x01d8
            L_0x002d:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r1.<init>(r2)
                throw r1
            L_0x0035:
                java.lang.Object r2 = r0.f18108e
                java.util.ArrayList r2 = (java.util.ArrayList) r2
                java.lang.Object r4 = r0.f18107d
                java.util.ArrayList r4 = (java.util.ArrayList) r4
                java.lang.Object r5 = r0.f18106c
                java.util.ArrayList r5 = (java.util.ArrayList) r5
                java.lang.Object r6 = r0.f18105b
                java.util.ArrayList r6 = (java.util.ArrayList) r6
                java.lang.Object r7 = r0.f18104a
                java.util.ArrayList r7 = (java.util.ArrayList) r7
                R2.n.b(r19)
                r10 = r2
                r3 = r5
                r2 = r19
            L_0x0050:
                r5 = r7
                goto L_0x01b2
            L_0x0053:
                R2.n.b(r19)
                boolean r2 = r0.f18111h
                if (r2 == 0) goto L_0x0065
                com.uptodown.activities.P r2 = r0.f18112i
                r3.t r2 = r2.f18084a
                u2.E$a r5 = u2.E.a.f21883a
                r2.setValue(r5)
            L_0x0065:
                u2.m r2 = new u2.m
                r2.<init>()
                android.content.Context r5 = r0.f18113j
                java.util.ArrayList r2 = r2.B(r5)
                u2.t$a r5 = u2.t.f21927u
                android.content.Context r6 = r0.f18113j
                u2.t r5 = r5.a(r6)
                r5.a()
                java.util.ArrayList r6 = new java.util.ArrayList
                r6.<init>()
                java.util.ArrayList r7 = new java.util.ArrayList
                r7.<init>()
                java.util.ArrayList r8 = new java.util.ArrayList
                r8.<init>()
                java.util.ArrayList r9 = new java.util.ArrayList
                r9.<init>()
                java.util.Iterator r2 = r2.iterator()
                java.lang.String r10 = "iterator(...)"
                kotlin.jvm.internal.m.d(r2, r10)
            L_0x0098:
                boolean r10 = r2.hasNext()
                if (r10 == 0) goto L_0x0132
                java.lang.Object r10 = r2.next()
                java.lang.String r11 = "next(...)"
                kotlin.jvm.internal.m.d(r10, r11)
                g2.f r10 = (g2.C2048f) r10
                long r11 = r10.b()
                r13 = 0
                int r15 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
                if (r15 <= 0) goto L_0x0098
                android.content.Context r11 = r0.f18113j
                boolean r11 = r10.C(r11)
                if (r11 == 0) goto L_0x0098
                int r11 = r10.e()
                if (r11 != r4) goto L_0x00ce
                g2.f$c r11 = g2.C2048f.c.OUTDATED
                r10.c0(r11)
                boolean r10 = r8.add(r10)
                kotlin.coroutines.jvm.internal.b.a(r10)
                goto L_0x0098
            L_0x00ce:
                java.lang.String r11 = r10.o()
                kotlin.jvm.internal.m.b(r11)
                g2.S r11 = r5.D0(r11)
                if (r11 != 0) goto L_0x00ea
                boolean r12 = r10.D()
                if (r12 == 0) goto L_0x0122
                g2.f$c r12 = g2.C2048f.c.UPDATED
                r10.c0(r12)
                r9.add(r10)
                goto L_0x0122
            L_0x00ea:
                int r12 = r11.e()
                if (r12 != r4) goto L_0x00f8
                boolean r10 = r8.add(r10)
                kotlin.coroutines.jvm.internal.b.a(r10)
                goto L_0x0122
            L_0x00f8:
                g2.f$c r12 = g2.C2048f.c.OUTDATED
                r10.c0(r12)
                W1.h r12 = new W1.h
                r12.<init>()
                android.content.Context r13 = r0.f18113j
                java.lang.String r14 = r10.o()
                kotlin.jvm.internal.m.b(r14)
                boolean r12 = r12.p(r13, r14)
                if (r12 == 0) goto L_0x0119
                boolean r10 = r7.add(r10)
                kotlin.coroutines.jvm.internal.b.a(r10)
                goto L_0x0122
            L_0x0119:
                int r12 = r11.e()
                if (r12 != 0) goto L_0x0122
                r6.add(r10)
            L_0x0122:
                if (r11 == 0) goto L_0x0098
                int r10 = r11.g()
                if (r10 != 0) goto L_0x0098
                r11.r(r4)
                r5.v1(r11)
                goto L_0x0098
            L_0x0132:
                u2.m$a r2 = u2.m.f21904a
                android.content.Context r10 = r0.f18113j
                r2.l(r6, r10)
                r2.q(r9)
                android.content.Context r10 = r0.f18113j
                r2.l(r8, r10)
                android.content.Context r10 = r0.f18113j
                r2.l(r7, r10)
                java.util.ArrayList r2 = r5.F0()
                r5.i()
                java.util.ArrayList r5 = new java.util.ArrayList
                r5.<init>()
                java.util.ArrayList r10 = new java.util.ArrayList
                r10.<init>()
                int r11 = r2.size()
                r13 = 0
            L_0x015c:
                if (r13 >= r11) goto L_0x0197
                java.lang.Object r14 = r2.get(r13)
                int r13 = r13 + 1
                g2.S r14 = (g2.S) r14
                int r15 = r6.size()
                r12 = 0
            L_0x016b:
                if (r12 >= r15) goto L_0x015c
                java.lang.Object r16 = r6.get(r12)
                int r12 = r12 + 1
                r3 = r16
                g2.f r3 = (g2.C2048f) r3
                java.lang.String r4 = r14.h()
                r17 = r11
                java.lang.String r11 = r3.o()
                boolean r4 = kotlin.jvm.internal.m.a(r4, r11)
                if (r4 == 0) goto L_0x0192
                r10.add(r14)
                M1.J$a r4 = new M1.J$a
                r4.<init>(r3, r14)
                r5.add(r4)
            L_0x0192:
                r11 = r17
                r3 = 2
                r4 = 1
                goto L_0x016b
            L_0x0197:
                com.uptodown.activities.P r3 = r0.f18112i
                r0.f18104a = r7
                r0.f18105b = r8
                r0.f18106c = r9
                r0.f18107d = r5
                r0.f18108e = r10
                r4 = 1
                r0.f18110g = r4
                java.lang.Object r2 = r3.i(r2, r6, r0)
                if (r2 != r1) goto L_0x01ad
                goto L_0x01d2
            L_0x01ad:
                r4 = r5
                r6 = r8
                r3 = r9
                goto L_0x0050
            L_0x01b2:
                java.lang.Boolean r2 = (java.lang.Boolean) r2
                boolean r2 = r2.booleanValue()
                com.uptodown.activities.P r7 = r0.f18112i
                android.content.Context r8 = r0.f18113j
                r0.f18104a = r5
                r0.f18105b = r6
                r0.f18106c = r3
                r0.f18107d = r4
                r9 = 0
                r0.f18108e = r9
                r0.f18109f = r2
                r9 = 2
                r0.f18110g = r9
                java.lang.Object r7 = r7.d(r8, r10, r2, r0)
                if (r7 != r1) goto L_0x01d3
            L_0x01d2:
                return r1
            L_0x01d3:
                r1 = r2
                r9 = r4
                r11 = r6
                goto L_0x0029
            L_0x01d8:
                java.lang.Boolean r7 = (java.lang.Boolean) r7
                boolean r2 = r7.booleanValue()
                com.uptodown.activities.P r3 = r0.f18112i
                r3.t r3 = r3.f18084a
                u2.E$c r4 = new u2.E$c
                com.uptodown.activities.P$b r8 = new com.uptodown.activities.P$b
                com.uptodown.activities.P$a r13 = new com.uptodown.activities.P$a
                r13.<init>(r1, r2)
                r8.<init>(r9, r10, r11, r12, r13)
                r4.<init>(r8)
                r3.setValue(r4)
                R2.s r1 = R2.s.f8222a
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.P.e.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((e) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class f extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a  reason: collision with root package name */
        Object f18114a;

        /* renamed from: b  reason: collision with root package name */
        /* synthetic */ Object f18115b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ P f18116c;

        /* renamed from: d  reason: collision with root package name */
        int f18117d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(P p4, V2.d dVar) {
            super(dVar);
            this.f18116c = p4;
        }

        public final Object invokeSuspend(Object obj) {
            this.f18115b = obj;
            this.f18117d |= Integer.MIN_VALUE;
            return this.f18116c.i((ArrayList) null, (ArrayList) null, this);
        }
    }

    static final class g extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f18118a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ArrayList f18119b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ArrayList f18120c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ArrayList f18121d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, V2.d dVar) {
            super(2, dVar);
            this.f18119b = arrayList;
            this.f18120c = arrayList2;
            this.f18121d = arrayList3;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new g(this.f18119b, this.f18120c, this.f18121d, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f18118a == 0) {
                n.b(obj);
                ArrayList arrayList = new ArrayList(this.f18119b);
                int size = arrayList.size();
                for (int i4 = 0; i4 < size; i4++) {
                    Iterator it = this.f18120c.iterator();
                    m.d(it, "iterator(...)");
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Object next = it.next();
                        m.d(next, "next(...)");
                        S s4 = (S) next;
                        String o4 = ((C2048f) arrayList.get(i4)).o();
                        if (o4 != null && m3.m.p(o4, s4.h(), true) && ((C2048f) arrayList.get(i4)).e() == 0) {
                            this.f18121d.add(s4);
                            break;
                        }
                    }
                }
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((g) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public P() {
        t a5 = K.a(E.a.f21883a);
        this.f18084a = a5;
        this.f18085b = a5;
        Boolean bool = Boolean.FALSE;
        this.f18086c = K.a(bool);
        this.f18087d = K.a(bool);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object d(android.content.Context r11, java.util.ArrayList r12, boolean r13, V2.d r14) {
        /*
            r10 = this;
            boolean r0 = r14 instanceof com.uptodown.activities.P.c
            if (r0 == 0) goto L_0x0013
            r0 = r14
            com.uptodown.activities.P$c r0 = (com.uptodown.activities.P.c) r0
            int r1 = r0.f18098d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f18098d = r1
            goto L_0x0018
        L_0x0013:
            com.uptodown.activities.P$c r0 = new com.uptodown.activities.P$c
            r0.<init>(r10, r14)
        L_0x0018:
            java.lang.Object r14 = r0.f18096b
            java.lang.Object r1 = W2.b.c()
            int r2 = r0.f18098d
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r11 = r0.f18095a
            kotlin.jvm.internal.z r11 = (kotlin.jvm.internal.z) r11
            R2.n.b(r14)
            goto L_0x0058
        L_0x002d:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x0035:
            R2.n.b(r14)
            kotlin.jvm.internal.z r8 = new kotlin.jvm.internal.z
            r8.<init>()
            r8.f20985a = r3
            o3.G r14 = o3.Y.b()
            com.uptodown.activities.P$d r4 = new com.uptodown.activities.P$d
            r9 = 0
            r7 = r11
            r6 = r12
            r5 = r13
            r4.<init>(r5, r6, r7, r8, r9)
            r0.f18095a = r8
            r0.f18098d = r3
            java.lang.Object r11 = o3.C0977g.g(r14, r4, r0)
            if (r11 != r1) goto L_0x0057
            return r1
        L_0x0057:
            r11 = r8
        L_0x0058:
            boolean r11 = r11.f20985a
            java.lang.Boolean r11 = kotlin.coroutines.jvm.internal.b.a(r11)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.P.d(android.content.Context, java.util.ArrayList, boolean, V2.d):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object i(java.util.ArrayList r7, java.util.ArrayList r8, V2.d r9) {
        /*
            r6 = this;
            boolean r0 = r9 instanceof com.uptodown.activities.P.f
            if (r0 == 0) goto L_0x0013
            r0 = r9
            com.uptodown.activities.P$f r0 = (com.uptodown.activities.P.f) r0
            int r1 = r0.f18117d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f18117d = r1
            goto L_0x0018
        L_0x0013:
            com.uptodown.activities.P$f r0 = new com.uptodown.activities.P$f
            r0.<init>(r6, r9)
        L_0x0018:
            java.lang.Object r9 = r0.f18115b
            java.lang.Object r1 = W2.b.c()
            int r2 = r0.f18117d
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r7 = r0.f18114a
            java.util.ArrayList r7 = (java.util.ArrayList) r7
            R2.n.b(r9)
            goto L_0x0053
        L_0x002d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0035:
            R2.n.b(r9)
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            o3.G r2 = o3.Y.b()
            com.uptodown.activities.P$g r4 = new com.uptodown.activities.P$g
            r5 = 0
            r4.<init>(r8, r7, r9, r5)
            r0.f18114a = r9
            r0.f18117d = r3
            java.lang.Object r7 = o3.C0977g.g(r2, r4, r0)
            if (r7 != r1) goto L_0x0052
            return r1
        L_0x0052:
            r7 = r9
        L_0x0053:
            int r7 = r7.size()
            if (r7 <= 0) goto L_0x005a
            goto L_0x005b
        L_0x005a:
            r3 = 0
        L_0x005b:
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.b.a(r3)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.P.i(java.util.ArrayList, java.util.ArrayList, V2.d):java.lang.Object");
    }

    public final void e(Context context, boolean z4) {
        m.e(context, "context");
        C1001s0 unused = C0981i.d(ViewModelKt.getViewModelScope(this), Y.b(), (L) null, new e(z4, this, context, (V2.d) null), 2, (Object) null);
    }

    public final t f() {
        return this.f18087d;
    }

    public final I g() {
        return this.f18085b;
    }

    public final t h() {
        return this.f18086c;
    }
}
