package b;

import R2.s;
import V2.d;
import d3.p;
import kotlin.coroutines.jvm.internal.l;
import o3.J;

public final class j extends l implements p {

    /* renamed from: a  reason: collision with root package name */
    public Object f1109a;

    /* renamed from: b  reason: collision with root package name */
    public int f1110b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ m f1111c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public j(m mVar, d dVar) {
        super(2, dVar);
        this.f1111c = mVar;
    }

    public final d create(Object obj, d dVar) {
        return new j(this.f1111c, dVar);
    }

    public Object invoke(Object obj, Object obj2) {
        J j4 = (J) obj;
        return new j(this.f1111c, (d) obj2).invokeSuspend(s.f8222a);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0152, code lost:
        if (r14 == false) goto L_0x0154;
     */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x01f4  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x01b8 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x01b5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r19) {
        /*
            r18 = this;
            r0 = r18
            java.lang.Object r1 = W2.b.c()
            int r2 = r0.f1110b
            java.lang.String r3 = "STATE_AND_NATIONAL"
            java.lang.String r4 = "state"
            r6 = 1
            if (r2 == 0) goto L_0x0023
            if (r2 != r6) goto L_0x001b
            java.lang.Object r1 = r0.f1109a
            A3.g r1 = (A3.g) r1
            R2.n.b(r19)
            r2 = r19
            goto L_0x0081
        L_0x001b:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0023:
            R2.n.b(r19)
            A3.d r2 = A3.d.f51a
            A3.g r13 = r2.c()
            b4.d r2 = b4.d.f24465a
            b.m r7 = r0.f1111c
            C3.f r7 = r7.f1116c
            C3.a r7 = r7.f170b
            java.lang.String r7 = r7.f118J
            boolean r7 = kotlin.jvm.internal.m.a(r7, r3)
            if (r7 == 0) goto L_0x0040
            E2.h r7 = E2.h.STATE_AND_NATIONAL
        L_0x003e:
            r12 = r7
            goto L_0x0043
        L_0x0040:
            E2.h r7 = E2.h.NATIONAL
            goto L_0x003e
        L_0x0043:
            java.lang.String r7 = "jurisdiction"
            kotlin.jvm.internal.m.e(r12, r7)
            kotlin.jvm.internal.m.e(r13, r4)
            X3.s r7 = b4.d.f24464B
            if (r7 != 0) goto L_0x006b
            X3.t r7 = new X3.t
            java.util.Locale r8 = r2.a()
            W3.a r9 = r2.i()
            W3.b r10 = r2.l()
            com.inmobi.cmp.data.storage.SharedStorage r11 = r2.m()
            Z3.k r14 = new Z3.k
            r14.<init>()
            r7.<init>(r8, r9, r10, r11, r12, r13, r14)
            b4.d.f24464B = r7
        L_0x006b:
            X3.s r2 = b4.d.f24464B
            if (r2 != 0) goto L_0x0075
            java.lang.String r2 = "mspaPrivacyRepository"
            kotlin.jvm.internal.m.u(r2)
            r2 = 0
        L_0x0075:
            r0.f1109a = r13
            r0.f1110b = r6
            java.lang.Object r2 = r2.a(r0)
            if (r2 != r1) goto L_0x0080
            return r1
        L_0x0080:
            r1 = r13
        L_0x0081:
            A3.a r2 = (A3.a) r2
            b.m r7 = r0.f1111c
            r7.getClass()
            java.util.List r8 = r2.f31c
            if (r8 != 0) goto L_0x008d
            goto L_0x00a2
        L_0x008d:
            java.util.Iterator r8 = r8.iterator()
        L_0x0091:
            boolean r9 = r8.hasNext()
            if (r9 == 0) goto L_0x00a2
            java.lang.Object r9 = r8.next()
            A3.e r9 = (A3.e) r9
            java.lang.Boolean r10 = r9.f62c
            r9.f63d = r10
            goto L_0x0091
        L_0x00a2:
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.List r9 = r2.f31c
            if (r9 != 0) goto L_0x00ad
            r11 = 0
            goto L_0x00e1
        L_0x00ad:
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            java.util.Iterator r9 = r9.iterator()
        L_0x00b6:
            boolean r12 = r9.hasNext()
            if (r12 == 0) goto L_0x00e1
            java.lang.Object r12 = r9.next()
            r13 = r12
            A3.e r13 = (A3.e) r13
            java.lang.Integer r13 = r13.f60a
            if (r13 != 0) goto L_0x00c9
            r13 = 0
            goto L_0x00db
        L_0x00c9:
            int r13 = r13.intValue()
            C3.f r14 = r7.f1116c
            C3.a r14 = r14.f170b
            java.util.List r14 = r14.f122N
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
            boolean r13 = r14.contains(r13)
        L_0x00db:
            if (r13 == 0) goto L_0x00b6
            r11.add(r12)
            goto L_0x00b6
        L_0x00e1:
            if (r11 != 0) goto L_0x00e5
            goto L_0x021f
        L_0x00e5:
            int r9 = r11.size()
            r12 = 0
        L_0x00ea:
            if (r12 >= r9) goto L_0x021f
            java.lang.Object r13 = r11.get(r12)
            int r12 = r12 + 1
            A3.e r13 = (A3.e) r13
            java.lang.Integer r14 = r13.f60a
            int[] r15 = A3.i.f83c
            int r15 = S2.C1594h.s(r15)
            if (r14 != 0) goto L_0x0101
        L_0x00fe:
            r0 = 1
            goto L_0x021b
        L_0x0101:
            int r14 = r14.intValue()
            if (r14 != r15) goto L_0x00fe
            C3.f r14 = r7.f1116c
            C3.a r14 = r14.f170b
            java.lang.String r14 = r14.f118J
            java.lang.String r15 = "NATIONAL"
            boolean r14 = kotlin.jvm.internal.m.a(r14, r15)
            if (r14 != 0) goto L_0x0154
            C3.f r14 = r7.f1116c
            C3.a r14 = r14.f170b
            java.lang.String r14 = r14.f118J
            boolean r14 = kotlin.jvm.internal.m.a(r14, r3)
            if (r14 == 0) goto L_0x0157
            kotlin.jvm.internal.m.e(r1, r4)
            kotlin.jvm.internal.m.e(r1, r4)
            int r14 = r1.ordinal()
            if (r14 == 0) goto L_0x0147
            if (r14 == r6) goto L_0x0144
            r15 = 2
            if (r14 == r15) goto L_0x0141
            r15 = 3
            if (r14 == r15) goto L_0x013e
            r15 = 4
            if (r14 == r15) goto L_0x013b
            java.lang.String r14 = ""
            goto L_0x0149
        L_0x013b:
            java.lang.String r14 = "va"
            goto L_0x0149
        L_0x013e:
            java.lang.String r14 = "ut"
            goto L_0x0149
        L_0x0141:
            java.lang.String r14 = "ct"
            goto L_0x0149
        L_0x0144:
            java.lang.String r14 = "co"
            goto L_0x0149
        L_0x0147:
            java.lang.String r14 = "ca"
        L_0x0149:
            int r14 = r14.length()
            if (r14 <= 0) goto L_0x0151
            r14 = 1
            goto L_0x0152
        L_0x0151:
            r14 = 0
        L_0x0152:
            if (r14 != 0) goto L_0x0157
        L_0x0154:
            r0 = 1
            goto L_0x01bf
        L_0x0157:
            java.util.List r14 = r13.f65f
            if (r14 != 0) goto L_0x015e
            r15 = 0
        L_0x015c:
            r0 = 1
            goto L_0x01bc
        L_0x015e:
            java.util.ArrayList r15 = new java.util.ArrayList
            r15.<init>()
            java.util.Iterator r14 = r14.iterator()
        L_0x0167:
            boolean r16 = r14.hasNext()
            if (r16 == 0) goto L_0x015c
            java.lang.Object r5 = r14.next()
            r10 = r5
            A3.f r10 = (A3.f) r10
            java.util.List r10 = r10.f72f
            if (r10 != 0) goto L_0x017a
            r0 = 1
            goto L_0x01b2
        L_0x017a:
            boolean r17 = r10.isEmpty()
            if (r17 == 0) goto L_0x0181
            goto L_0x01ac
        L_0x0181:
            java.util.Iterator r10 = r10.iterator()
        L_0x0185:
            boolean r17 = r10.hasNext()
            if (r17 == 0) goto L_0x01ac
            java.lang.Object r17 = r10.next()
            java.lang.Number r17 = (java.lang.Number) r17
            int r17 = r17.intValue()
            C3.f r6 = r7.f1116c
            C3.a r6 = r6.f170b
            java.util.List r6 = r6.f123O
            java.lang.Integer r0 = java.lang.Integer.valueOf(r17)
            boolean r0 = r6.contains(r0)
            if (r0 == 0) goto L_0x01a8
            r6 = 1
        L_0x01a6:
            r0 = 1
            goto L_0x01ae
        L_0x01a8:
            r0 = r18
            r6 = 1
            goto L_0x0185
        L_0x01ac:
            r6 = 0
            goto L_0x01a6
        L_0x01ae:
            if (r6 != r0) goto L_0x01b2
            r6 = 1
            goto L_0x01b3
        L_0x01b2:
            r6 = 0
        L_0x01b3:
            if (r6 == 0) goto L_0x01b8
            r15.add(r5)
        L_0x01b8:
            r0 = r18
            r6 = 1
            goto L_0x0167
        L_0x01bc:
            r13.f66g = r15
            goto L_0x01ef
        L_0x01bf:
            java.util.List r5 = r13.f65f
            if (r5 != 0) goto L_0x01c5
            r6 = 0
            goto L_0x01ed
        L_0x01c5:
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.Iterator r5 = r5.iterator()
        L_0x01ce:
            boolean r10 = r5.hasNext()
            if (r10 == 0) goto L_0x01ed
            java.lang.Object r10 = r5.next()
            r14 = r10
            A3.f r14 = (A3.f) r14
            C3.f r15 = r7.f1116c
            C3.a r15 = r15.f170b
            java.util.List r15 = r15.f123O
            java.lang.Integer r14 = r14.f67a
            boolean r14 = S2.C1601o.B(r15, r14)
            if (r14 == 0) goto L_0x01ce
            r6.add(r10)
            goto L_0x01ce
        L_0x01ed:
            r13.f66g = r6
        L_0x01ef:
            java.util.List r5 = r13.f66g
            if (r5 != 0) goto L_0x01f4
            goto L_0x0213
        L_0x01f4:
            java.util.Iterator r5 = r5.iterator()
        L_0x01f8:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x0213
            java.lang.Object r6 = r5.next()
            A3.f r6 = (A3.f) r6
            java.lang.Boolean r10 = r13.f63d
            java.lang.Boolean r14 = java.lang.Boolean.TRUE
            boolean r10 = kotlin.jvm.internal.m.a(r10, r14)
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r10)
            r6.f70d = r10
            goto L_0x01f8
        L_0x0213:
            r8.add(r13)
        L_0x0216:
            r0 = r18
            r6 = 1
            goto L_0x00ea
        L_0x021b:
            r8.add(r13)
            goto L_0x0216
        L_0x021f:
            r2.f32d = r8
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: b.j.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
