package O3;

import N3.C2514e;
import N3.C2517h;
import kotlin.jvm.internal.m;

/* renamed from: O3.b  reason: case insensitive filesystem */
public abstract class C2536b {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f23747a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0036, code lost:
        return -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x018f, code lost:
        return -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x005c, code lost:
        return -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00a0, code lost:
        return -1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x01ae A[EDGE_INSN: B:161:0x01ae->B:158:0x01ae ?: BREAK  
    EDGE_INSN: B:163:0x01ae->B:158:0x01ae ?: BREAK  
    EDGE_INSN: B:180:0x01ae->B:158:0x01ae ?: BREAK  
    EDGE_INSN: B:185:0x01ae->B:158:0x01ae ?: BREAK  
    EDGE_INSN: B:195:0x01ae->B:158:0x01ae ?: BREAK  , RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final int c(byte[] r19, int r20) {
        /*
            r0 = r19
            r1 = r20
            r3 = 1
            int r4 = r0.length
            r5 = 0
            r6 = 0
            r7 = 0
        L_0x0009:
            if (r5 >= r4) goto L_0x01ae
            byte r8 = r0[r5]
            r9 = 65533(0xfffd, float:9.1831E-41)
            r10 = 160(0xa0, float:2.24E-43)
            r11 = 127(0x7f, float:1.78E-43)
            r12 = 32
            r13 = 13
            r14 = 10
            r15 = 65536(0x10000, float:9.18355E-41)
            r16 = -1
            if (r8 < 0) goto L_0x0064
            int r17 = r7 + 1
            if (r7 != r1) goto L_0x0026
            goto L_0x01ae
        L_0x0026:
            if (r8 == r14) goto L_0x0034
            if (r8 == r13) goto L_0x0034
            if (r8 < 0) goto L_0x002f
            if (r8 >= r12) goto L_0x002f
            goto L_0x0036
        L_0x002f:
            if (r11 > r8) goto L_0x0034
            if (r8 >= r10) goto L_0x0034
            goto L_0x0036
        L_0x0034:
            if (r8 != r9) goto L_0x0037
        L_0x0036:
            return r16
        L_0x0037:
            if (r8 >= r15) goto L_0x003b
            r7 = 1
            goto L_0x003c
        L_0x003b:
            r7 = 2
        L_0x003c:
            int r6 = r6 + r7
            int r5 = r5 + r3
        L_0x003e:
            r7 = r17
            if (r5 >= r4) goto L_0x0009
            byte r8 = r0[r5]
            if (r8 < 0) goto L_0x0009
            int r5 = r5 + r3
            int r17 = r7 + 1
            if (r7 != r1) goto L_0x004c
            return r6
        L_0x004c:
            if (r8 == r14) goto L_0x005a
            if (r8 == r13) goto L_0x005a
            if (r8 < 0) goto L_0x0055
            if (r8 >= r12) goto L_0x0055
            goto L_0x005c
        L_0x0055:
            if (r11 > r8) goto L_0x005a
            if (r8 >= r10) goto L_0x005a
            goto L_0x005c
        L_0x005a:
            if (r8 != r9) goto L_0x005d
        L_0x005c:
            return r16
        L_0x005d:
            if (r8 >= r15) goto L_0x0061
            r7 = 1
            goto L_0x0062
        L_0x0061:
            r7 = 2
        L_0x0062:
            int r6 = r6 + r7
            goto L_0x003e
        L_0x0064:
            r17 = 2
            int r2 = r8 >> 5
            r18 = 1
            r3 = -2
            r15 = 128(0x80, float:1.794E-43)
            if (r2 != r3) goto L_0x00b6
            int r3 = r5 + 1
            if (r4 > r3) goto L_0x0078
            if (r7 != r1) goto L_0x0077
            goto L_0x01ae
        L_0x0077:
            return r16
        L_0x0078:
            byte r2 = r0[r3]
            r3 = r2 & 192(0xc0, float:2.69E-43)
            if (r3 != r15) goto L_0x00b1
            r2 = r2 ^ 3968(0xf80, float:5.56E-42)
            int r3 = r8 << 6
            r2 = r2 ^ r3
            if (r2 >= r15) goto L_0x008a
            if (r7 != r1) goto L_0x0089
            goto L_0x01ae
        L_0x0089:
            return r16
        L_0x008a:
            int r3 = r7 + 1
            if (r7 != r1) goto L_0x0090
            goto L_0x01ae
        L_0x0090:
            if (r2 == r14) goto L_0x009e
            if (r2 == r13) goto L_0x009e
            if (r2 < 0) goto L_0x0099
            if (r2 >= r12) goto L_0x0099
            goto L_0x00a0
        L_0x0099:
            if (r11 > r2) goto L_0x009e
            if (r2 >= r10) goto L_0x009e
            goto L_0x00a0
        L_0x009e:
            if (r2 != r9) goto L_0x00a1
        L_0x00a0:
            return r16
        L_0x00a1:
            r7 = 65536(0x10000, float:9.18355E-41)
            if (r2 >= r7) goto L_0x00a7
            r2 = 1
            goto L_0x00a8
        L_0x00a7:
            r2 = 2
        L_0x00a8:
            int r6 = r6 + r2
            R2.s r2 = R2.s.f8222a
            int r5 = r5 + 2
        L_0x00ad:
            r7 = r3
            r3 = 1
            goto L_0x0009
        L_0x00b1:
            if (r7 != r1) goto L_0x00b5
            goto L_0x01ae
        L_0x00b5:
            return r16
        L_0x00b6:
            int r2 = r8 >> 4
            r9 = 57344(0xe000, float:8.0356E-41)
            r10 = 55296(0xd800, float:7.7486E-41)
            if (r2 != r3) goto L_0x0128
            int r2 = r5 + 2
            if (r4 > r2) goto L_0x00c9
            if (r7 != r1) goto L_0x00c8
            goto L_0x01ae
        L_0x00c8:
            return r16
        L_0x00c9:
            int r3 = r5 + 1
            byte r3 = r0[r3]
            r11 = r3 & 192(0xc0, float:2.69E-43)
            if (r11 != r15) goto L_0x0123
            byte r2 = r0[r2]
            r11 = r2 & 192(0xc0, float:2.69E-43)
            if (r11 != r15) goto L_0x011e
            r11 = -123008(0xfffffffffffe1f80, float:NaN)
            r2 = r2 ^ r11
            int r3 = r3 << 6
            r2 = r2 ^ r3
            int r3 = r8 << 12
            r2 = r2 ^ r3
            r3 = 2048(0x800, float:2.87E-42)
            if (r2 >= r3) goto L_0x00ea
            if (r7 != r1) goto L_0x00e9
            goto L_0x01ae
        L_0x00e9:
            return r16
        L_0x00ea:
            if (r10 > r2) goto L_0x00f3
            if (r2 >= r9) goto L_0x00f3
            if (r7 != r1) goto L_0x00f2
            goto L_0x01ae
        L_0x00f2:
            return r16
        L_0x00f3:
            int r3 = r7 + 1
            if (r7 != r1) goto L_0x00f9
            goto L_0x01ae
        L_0x00f9:
            if (r2 == r14) goto L_0x010b
            if (r2 == r13) goto L_0x010b
            if (r2 < 0) goto L_0x0102
            if (r2 >= r12) goto L_0x0102
            goto L_0x0110
        L_0x0102:
            r7 = 127(0x7f, float:1.78E-43)
            if (r7 > r2) goto L_0x010b
            r7 = 160(0xa0, float:2.24E-43)
            if (r2 >= r7) goto L_0x010b
            goto L_0x0110
        L_0x010b:
            r7 = 65533(0xfffd, float:9.1831E-41)
            if (r2 != r7) goto L_0x0111
        L_0x0110:
            return r16
        L_0x0111:
            r7 = 65536(0x10000, float:9.18355E-41)
            if (r2 >= r7) goto L_0x0117
            r2 = 1
            goto L_0x0118
        L_0x0117:
            r2 = 2
        L_0x0118:
            int r6 = r6 + r2
            R2.s r2 = R2.s.f8222a
            int r5 = r5 + 3
            goto L_0x00ad
        L_0x011e:
            if (r7 != r1) goto L_0x0122
            goto L_0x01ae
        L_0x0122:
            return r16
        L_0x0123:
            if (r7 != r1) goto L_0x0127
            goto L_0x01ae
        L_0x0127:
            return r16
        L_0x0128:
            int r2 = r8 >> 3
            if (r2 != r3) goto L_0x01aa
            int r2 = r5 + 3
            if (r4 > r2) goto L_0x0135
            if (r7 != r1) goto L_0x0134
            goto L_0x01ae
        L_0x0134:
            return r16
        L_0x0135:
            int r3 = r5 + 1
            byte r3 = r0[r3]
            r11 = r3 & 192(0xc0, float:2.69E-43)
            if (r11 != r15) goto L_0x01a6
            int r11 = r5 + 2
            byte r11 = r0[r11]
            r12 = r11 & 192(0xc0, float:2.69E-43)
            if (r12 != r15) goto L_0x01a2
            byte r2 = r0[r2]
            r12 = r2 & 192(0xc0, float:2.69E-43)
            if (r12 != r15) goto L_0x019e
            r12 = 3678080(0x381f80, float:5.154088E-39)
            r2 = r2 ^ r12
            int r11 = r11 << 6
            r2 = r2 ^ r11
            int r3 = r3 << 12
            r2 = r2 ^ r3
            int r3 = r8 << 18
            r2 = r2 ^ r3
            r3 = 1114111(0x10ffff, float:1.561202E-39)
            if (r2 <= r3) goto L_0x0161
            if (r7 != r1) goto L_0x0160
            goto L_0x01ae
        L_0x0160:
            return r16
        L_0x0161:
            if (r10 > r2) goto L_0x0169
            if (r2 >= r9) goto L_0x0169
            if (r7 != r1) goto L_0x0168
            goto L_0x01ae
        L_0x0168:
            return r16
        L_0x0169:
            r3 = 65536(0x10000, float:9.18355E-41)
            if (r2 >= r3) goto L_0x0171
            if (r7 != r1) goto L_0x0170
            goto L_0x01ae
        L_0x0170:
            return r16
        L_0x0171:
            int r3 = r7 + 1
            if (r7 != r1) goto L_0x0176
            goto L_0x01ae
        L_0x0176:
            if (r2 == r14) goto L_0x018a
            if (r2 == r13) goto L_0x018a
            if (r2 < 0) goto L_0x0181
            r7 = 32
            if (r2 >= r7) goto L_0x0181
            goto L_0x018f
        L_0x0181:
            r7 = 127(0x7f, float:1.78E-43)
            if (r7 > r2) goto L_0x018a
            r7 = 160(0xa0, float:2.24E-43)
            if (r2 >= r7) goto L_0x018a
            goto L_0x018f
        L_0x018a:
            r7 = 65533(0xfffd, float:9.1831E-41)
            if (r2 != r7) goto L_0x0190
        L_0x018f:
            return r16
        L_0x0190:
            r7 = 65536(0x10000, float:9.18355E-41)
            if (r2 >= r7) goto L_0x0196
            r2 = 1
            goto L_0x0197
        L_0x0196:
            r2 = 2
        L_0x0197:
            int r6 = r6 + r2
            R2.s r2 = R2.s.f8222a
            int r5 = r5 + 4
            goto L_0x00ad
        L_0x019e:
            if (r7 != r1) goto L_0x01a1
            goto L_0x01ae
        L_0x01a1:
            return r16
        L_0x01a2:
            if (r7 != r1) goto L_0x01a5
            goto L_0x01ae
        L_0x01a5:
            return r16
        L_0x01a6:
            if (r7 != r1) goto L_0x01a9
            goto L_0x01ae
        L_0x01a9:
            return r16
        L_0x01aa:
            if (r7 != r1) goto L_0x01ad
            goto L_0x01ae
        L_0x01ad:
            return r16
        L_0x01ae:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: O3.C2536b.c(byte[], int):int");
    }

    public static final void d(C2517h hVar, C2514e eVar, int i4, int i5) {
        m.e(hVar, "<this>");
        m.e(eVar, "buffer");
        eVar.write(hVar.i(), i4, i5);
    }

    /* access modifiers changed from: private */
    public static final int e(char c5) {
        if ('0' <= c5 && c5 < ':') {
            return c5 - '0';
        }
        if ('a' <= c5 && c5 < 'g') {
            return c5 - 'W';
        }
        if ('A' <= c5 && c5 < 'G') {
            return c5 - '7';
        }
        throw new IllegalArgumentException("Unexpected hex digit: " + c5);
    }

    public static final char[] f() {
        return f23747a;
    }
}
