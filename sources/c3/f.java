package C3;

import A2.a;
import V3.C2594e;
import V3.C2598i;
import V3.C2603n;
import kotlin.jvm.internal.m;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public g f169a;

    /* renamed from: b  reason: collision with root package name */
    public a f170b;

    /* renamed from: c  reason: collision with root package name */
    public e f171c;

    /* renamed from: d  reason: collision with root package name */
    public C2594e f172d;

    /* renamed from: e  reason: collision with root package name */
    public C2598i f173e;

    /* renamed from: f  reason: collision with root package name */
    public C2603n f174f;

    public f(g gVar, a aVar, e eVar, C2594e eVar2, C2598i iVar, C2603n nVar) {
        m.e(gVar, "premiumProperties");
        m.e(aVar, "coreConfig");
        m.e(eVar, "nonIabVendorsInfo");
        m.e(eVar2, "coreUiLabels");
        m.e(iVar, "mobileUiLabels");
        m.e(nVar, "premiumUiLabels");
        this.f169a = gVar;
        this.f170b = aVar;
        this.f171c = eVar;
        this.f172d = eVar2;
        this.f173e = iVar;
        this.f174f = nVar;
    }

    public final a a() {
        return this.f170b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        if (m.a(this.f169a, fVar.f169a) && m.a(this.f170b, fVar.f170b) && m.a(this.f171c, fVar.f171c) && m.a(this.f172d, fVar.f172d) && m.a(this.f173e, fVar.f173e) && m.a(this.f174f, fVar.f174f)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.f170b.hashCode();
        int hashCode2 = this.f171c.hashCode();
        int hashCode3 = this.f172d.hashCode();
        int hashCode4 = this.f173e.hashCode();
        return this.f174f.hashCode() + ((hashCode4 + ((hashCode3 + ((hashCode2 + ((hashCode + (this.f169a.hashCode() * 31)) * 31)) * 31)) * 31)) * 31);
    }

    public String toString() {
        StringBuilder a5 = a.a("PortalConfig(premiumProperties=");
        a5.append(this.f169a);
        a5.append(", coreConfig=");
        a5.append(this.f170b);
        a5.append(", nonIabVendorsInfo=");
        a5.append(this.f171c);
        a5.append(", coreUiLabels=");
        a5.append(this.f172d);
        a5.append(", mobileUiLabels=");
        a5.append(this.f173e);
        a5.append(", premiumUiLabels=");
        a5.append(this.f174f);
        a5.append(')');
        return a5.toString();
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ f(C3.g r59, C3.a r60, C3.e r61, V3.C2594e r62, V3.C2598i r63, V3.C2603n r64, int r65) {
        /*
            r58 = this;
            r0 = r65 & 1
            r1 = 7
            r2 = 0
            if (r0 == 0) goto L_0x000c
            C3.g r0 = new C3.g
            r0.<init>(r2, r2, r2, r1)
            goto L_0x000e
        L_0x000c:
            r0 = r59
        L_0x000e:
            r3 = r65 & 2
            if (r3 == 0) goto L_0x006b
            C3.a r4 = new C3.a
            r50 = -1
            r51 = 8191(0x1fff, float:1.1478E-41)
            r5 = 0
            r6 = 0
            r7 = 0
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
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51)
            goto L_0x006d
        L_0x006b:
            r4 = r60
        L_0x006d:
            r3 = r65 & 4
            if (r3 == 0) goto L_0x0077
            C3.e r3 = new C3.e
            r3.<init>(r2, r2, r2, r1)
            goto L_0x0079
        L_0x0077:
            r3 = r61
        L_0x0079:
            r1 = r65 & 8
            if (r1 == 0) goto L_0x00e2
            V3.e r5 = new V3.e
            r56 = -1
            r57 = 262143(0x3ffff, float:3.6734E-40)
            r6 = 0
            r7 = 0
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
            r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57)
            goto L_0x00e4
        L_0x00e2:
            r5 = r62
        L_0x00e4:
            r1 = r65 & 16
            if (r1 == 0) goto L_0x0105
            V3.i r6 = new V3.i
            r21 = 0
            r22 = 32767(0x7fff, float:4.5916E-41)
            r7 = 0
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
            r6.<init>(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            r2 = r6
        L_0x0105:
            r1 = r65 & 32
            if (r1 == 0) goto L_0x012a
            V3.n r6 = new V3.n
            r16 = 0
            r17 = 1023(0x3ff, float:1.434E-42)
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r6.<init>(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            r65 = r6
        L_0x011d:
            r59 = r58
            r60 = r0
            r64 = r2
            r62 = r3
            r61 = r4
            r63 = r5
            goto L_0x012d
        L_0x012a:
            r65 = r64
            goto L_0x011d
        L_0x012d:
            r59.<init>(r60, r61, r62, r63, r64, r65)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: C3.f.<init>(C3.g, C3.a, C3.e, V3.e, V3.i, V3.n, int):void");
    }
}
