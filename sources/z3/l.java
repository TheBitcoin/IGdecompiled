package z3;

import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.util.Set;
import kotlin.jvm.internal.m;

public final class l extends f {

    /* renamed from: c  reason: collision with root package name */
    public final String f4818c;

    /* renamed from: d  reason: collision with root package name */
    public final Set f4819d;

    /* renamed from: e  reason: collision with root package name */
    public final Set f4820e;

    /* renamed from: f  reason: collision with root package name */
    public final Set f4821f;

    /* renamed from: g  reason: collision with root package name */
    public final Set f4822g;

    /* renamed from: h  reason: collision with root package name */
    public final Set f4823h;

    /* renamed from: i  reason: collision with root package name */
    public final Set f4824i;

    /* renamed from: j  reason: collision with root package name */
    public String f4825j;

    /* renamed from: k  reason: collision with root package name */
    public String f4826k;

    /* renamed from: l  reason: collision with root package name */
    public final int f4827l;

    /* renamed from: m  reason: collision with root package name */
    public final Boolean f4828m;

    /* renamed from: n  reason: collision with root package name */
    public final Set f4829n;

    /* renamed from: o  reason: collision with root package name */
    public final c f4830o;

    /* renamed from: p  reason: collision with root package name */
    public final String f4831p;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ l(int r23, java.lang.String r24, java.lang.String r25, java.util.Set r26, java.util.Set r27, java.util.Set r28, java.util.Set r29, java.util.Set r30, java.util.Set r31, java.lang.String r32, java.lang.String r33, z3.h r34, int r35, boolean r36, boolean r37, java.lang.Boolean r38, java.util.Set r39, z3.c r40, java.util.Set r41, java.lang.String r42, int r43) {
        /*
            r22 = this;
            r0 = r43
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0008
            r1 = 0
            goto L_0x000a
        L_0x0008:
            r1 = r23
        L_0x000a:
            r3 = r0 & 2
            java.lang.String r4 = ""
            if (r3 == 0) goto L_0x0012
            r3 = r4
            goto L_0x0014
        L_0x0012:
            r3 = r24
        L_0x0014:
            r5 = r0 & 4
            if (r5 == 0) goto L_0x001a
            r5 = 0
            goto L_0x001c
        L_0x001a:
            r5 = r25
        L_0x001c:
            r7 = r0 & 8
            if (r7 == 0) goto L_0x0026
            java.util.LinkedHashSet r7 = new java.util.LinkedHashSet
            r7.<init>()
            goto L_0x0028
        L_0x0026:
            r7 = r26
        L_0x0028:
            r8 = r0 & 16
            if (r8 == 0) goto L_0x0032
            java.util.LinkedHashSet r8 = new java.util.LinkedHashSet
            r8.<init>()
            goto L_0x0034
        L_0x0032:
            r8 = r27
        L_0x0034:
            r9 = r0 & 32
            if (r9 == 0) goto L_0x003e
            java.util.LinkedHashSet r9 = new java.util.LinkedHashSet
            r9.<init>()
            goto L_0x0040
        L_0x003e:
            r9 = r28
        L_0x0040:
            r10 = r0 & 64
            if (r10 == 0) goto L_0x004a
            java.util.LinkedHashSet r10 = new java.util.LinkedHashSet
            r10.<init>()
            goto L_0x004c
        L_0x004a:
            r10 = r29
        L_0x004c:
            r11 = r0 & 128(0x80, float:1.794E-43)
            if (r11 == 0) goto L_0x0056
            java.util.LinkedHashSet r11 = new java.util.LinkedHashSet
            r11.<init>()
            goto L_0x0058
        L_0x0056:
            r11 = r30
        L_0x0058:
            r12 = r0 & 256(0x100, float:3.59E-43)
            if (r12 == 0) goto L_0x0062
            java.util.LinkedHashSet r12 = new java.util.LinkedHashSet
            r12.<init>()
            goto L_0x0064
        L_0x0062:
            r12 = r31
        L_0x0064:
            r13 = r0 & 512(0x200, float:7.175E-43)
            if (r13 == 0) goto L_0x006a
            r13 = r4
            goto L_0x006c
        L_0x006a:
            r13 = r32
        L_0x006c:
            r14 = r0 & 1024(0x400, float:1.435E-42)
            if (r14 == 0) goto L_0x0072
            r14 = 0
            goto L_0x0074
        L_0x0072:
            r14 = r33
        L_0x0074:
            r15 = r0 & 2048(0x800, float:2.87E-42)
            if (r15 == 0) goto L_0x007a
            r15 = 0
            goto L_0x007c
        L_0x007a:
            r15 = r34
        L_0x007c:
            r2 = r0 & 4096(0x1000, float:5.74E-42)
            if (r2 == 0) goto L_0x0082
            r2 = -1
            goto L_0x0084
        L_0x0082:
            r2 = r35
        L_0x0084:
            r6 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r6 == 0) goto L_0x008a
            r6 = 0
            goto L_0x008c
        L_0x008a:
            r6 = r36
        L_0x008c:
            r17 = r1
            r1 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r1 == 0) goto L_0x0095
            r16 = 0
            goto L_0x0097
        L_0x0095:
            r16 = r37
        L_0x0097:
            r1 = 32768(0x8000, float:4.5918E-41)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x009f
            r1 = 0
            goto L_0x00a1
        L_0x009f:
            r1 = r38
        L_0x00a1:
            r18 = 65536(0x10000, float:9.18355E-41)
            r18 = r0 & r18
            if (r18 == 0) goto L_0x00ad
            java.util.LinkedHashSet r18 = new java.util.LinkedHashSet
            r18.<init>()
            goto L_0x00af
        L_0x00ad:
            r18 = r39
        L_0x00af:
            r19 = 131072(0x20000, float:1.83671E-40)
            r19 = r0 & r19
            if (r19 == 0) goto L_0x00b8
            r19 = 0
            goto L_0x00ba
        L_0x00b8:
            r19 = r40
        L_0x00ba:
            r20 = 262144(0x40000, float:3.67342E-40)
            r20 = r0 & r20
            if (r20 == 0) goto L_0x00c6
            java.util.LinkedHashSet r20 = new java.util.LinkedHashSet
            r20.<init>()
            goto L_0x00c8
        L_0x00c6:
            r20 = r41
        L_0x00c8:
            r21 = 524288(0x80000, float:7.34684E-40)
            r0 = r0 & r21
            if (r0 == 0) goto L_0x00f9
            r43 = r4
        L_0x00d0:
            r23 = r22
            r39 = r1
            r36 = r2
            r25 = r3
            r26 = r5
            r37 = r6
            r27 = r7
            r28 = r8
            r29 = r9
            r30 = r10
            r31 = r11
            r32 = r12
            r33 = r13
            r34 = r14
            r35 = r15
            r38 = r16
            r24 = r17
            r40 = r18
            r41 = r19
            r42 = r20
            goto L_0x00fc
        L_0x00f9:
            r43 = r42
            goto L_0x00d0
        L_0x00fc:
            r23.<init>(r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: z3.l.<init>(int, java.lang.String, java.lang.String, java.util.Set, java.util.Set, java.util.Set, java.util.Set, java.util.Set, java.util.Set, java.lang.String, java.lang.String, z3.h, int, boolean, boolean, java.lang.Boolean, java.util.Set, z3.c, java.util.Set, java.lang.String, int):void");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public l(int i4, String str, String str2, Set set, Set set2, Set set3, Set set4, Set set5, Set set6, String str3, String str4, h hVar, int i5, boolean z4, boolean z5, Boolean bool, Set set7, c cVar, Set set8, String str5) {
        super(i4, str);
        Set set9 = set4;
        Set set10 = set5;
        Set set11 = set6;
        String str6 = str3;
        Set set12 = set7;
        String str7 = str5;
        m.e(str, RewardPlus.NAME);
        m.e(set, "purposes");
        m.e(set2, "legIntPurposes");
        m.e(set3, "flexiblePurposes");
        m.e(set9, "specialPurposes");
        m.e(set10, "features");
        m.e(set11, "specialFeatures");
        m.e(str6, "policyUrl");
        m.e(set12, "dataDeclaration");
        m.e(set8, "urls");
        m.e(str7, "deviceStorageDisclosureUrl");
        this.f4818c = str2;
        this.f4819d = set;
        this.f4820e = set2;
        this.f4821f = set3;
        this.f4822g = set9;
        this.f4823h = set10;
        this.f4824i = set11;
        this.f4825j = str6;
        this.f4826k = str4;
        this.f4827l = i5;
        this.f4828m = bool;
        this.f4829n = set12;
        this.f4830o = cVar;
        this.f4831p = str7;
    }
}
