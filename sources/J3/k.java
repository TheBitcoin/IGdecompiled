package J3;

import N3.C2517h;
import androidx.core.view.PointerIconCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import java.io.ByteArrayOutputStream;

class k {

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f23593b = {8184, 8388568, 268435426, 268435427, 268435428, 268435429, 268435430, 268435431, 268435432, 16777194, 1073741820, 268435433, 268435434, 1073741821, 268435435, 268435436, 268435437, 268435438, 268435439, 268435440, 268435441, 268435442, 1073741822, 268435443, 268435444, 268435445, 268435446, 268435447, 268435448, 268435449, 268435450, 268435451, 20, PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, PointerIconCompat.TYPE_TOP_LEFT_DIAGONAL_DOUBLE_ARROW, 4090, 8185, 21, 248, 2042, PointerIconCompat.TYPE_ZOOM_IN, PointerIconCompat.TYPE_ZOOM_OUT, 249, 2043, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 22, 23, 24, 0, 1, 2, 25, 26, 27, 28, 29, 30, 31, 92, 251, 32764, 32, 4091, PointerIconCompat.TYPE_GRAB, 8186, 33, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 252, 115, 253, 8187, 524272, 8188, 16380, 34, 32765, 3, 35, 4, 36, 5, 37, 38, 39, 6, 116, 117, 40, 41, 42, 7, 43, 118, 44, 8, 9, 45, 119, 120, 121, 122, 123, 32766, 2044, 16381, 8189, 268435452, 1048550, 4194258, 1048551, 1048552, 4194259, 4194260, 4194261, 8388569, 4194262, 8388570, 8388571, 8388572, 8388573, 8388574, 16777195, 8388575, 16777196, 16777197, 4194263, 8388576, 16777198, 8388577, 8388578, 8388579, 8388580, 2097116, 4194264, 8388581, 4194265, 8388582, 8388583, 16777199, 4194266, 2097117, 1048553, 4194267, 4194268, 8388584, 8388585, 2097118, 8388586, 4194269, 4194270, 16777200, 2097119, 4194271, 8388587, 8388588, 2097120, 2097121, 4194272, 2097122, 8388589, 4194273, 8388590, 8388591, 1048554, 4194274, 4194275, 4194276, 8388592, 4194277, 4194278, 8388593, 67108832, 67108833, 1048555, 524273, 4194279, 8388594, 4194280, 33554412, 67108834, 67108835, 67108836, 134217694, 134217695, 67108837, 16777201, 33554413, 524274, 2097123, 67108838, 134217696, 134217697, 67108839, 134217698, 16777202, 2097124, 2097125, 67108840, 67108841, 268435453, 134217699, 134217700, 134217701, 1048556, 16777203, 1048557, 2097126, 4194281, 2097127, 2097128, 8388595, 4194282, 4194283, 33554414, 33554415, 16777204, 16777205, 67108842, 8388596, 67108843, 134217702, 67108844, 67108845, 134217703, 134217704, 134217705, 134217706, 134217707, 268435454, 134217708, 134217709, 134217710, 134217711, 134217712, 67108846};

    /* renamed from: c  reason: collision with root package name */
    private static final byte[] f23594c = {13, 23, 28, 28, 28, 28, 28, 28, 28, 24, 30, 28, 28, 30, 28, 28, 28, 28, 28, 28, 28, 28, 30, 28, 28, 28, 28, 28, 28, 28, 28, 28, 6, 10, 10, 12, 13, 6, 8, 11, 10, 10, 8, 11, 8, 6, 6, 6, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 7, 8, 15, 6, 12, 10, 13, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 7, 8, 13, 19, 13, 14, 6, 15, 5, 6, 5, 6, 5, 6, 6, 6, 5, 7, 7, 6, 6, 6, 5, 6, 7, 6, 5, 5, 6, 7, 7, 7, 7, 7, 15, 11, 14, 13, 28, 20, 22, 20, 20, 22, 22, 22, 23, 22, 23, 23, 23, 23, 23, 24, 23, 24, 24, 22, 23, 24, 23, 23, 23, 23, 21, 22, 23, 22, 23, 23, 24, 22, 21, 20, 22, 22, 23, 23, 21, 23, 22, 22, 24, 21, 22, 23, 23, 21, 21, 22, 21, 23, 22, 23, 23, 20, 22, 22, 22, 23, 22, 22, 23, 26, 26, 20, 19, 22, 23, 22, 25, 26, 26, 26, 27, 27, 26, 24, 25, 19, 21, 26, 27, 27, 26, 27, 24, 21, 21, 26, 26, 28, 27, 27, 27, 20, 24, 20, 21, 22, 21, 21, 23, 22, 22, 25, 25, 24, 24, 26, 23, 26, 27, 26, 26, 27, 27, 27, 27, 27, 28, 27, 27, 27, 27, 27, 26};

    /* renamed from: d  reason: collision with root package name */
    private static final k f23595d = new k();

    /* renamed from: a  reason: collision with root package name */
    private final a f23596a = new a();

    private k() {
        b();
    }

    private void a(int i4, int i5, byte b5) {
        a aVar = new a(i4, b5);
        a aVar2 = this.f23596a;
        while (b5 > 8) {
            b5 = (byte) (b5 - 8);
            int i6 = (i5 >>> b5) & 255;
            a[] aVarArr = aVar2.f23597a;
            if (aVarArr != null) {
                if (aVarArr[i6] == null) {
                    aVarArr[i6] = new a();
                }
                aVar2 = aVar2.f23597a[i6];
            } else {
                throw new IllegalStateException("invalid dictionary: prefix not unique");
            }
        }
        int i7 = 8 - b5;
        int i8 = (i5 << i7) & 255;
        int i9 = 1 << i7;
        for (int i10 = i8; i10 < i8 + i9; i10++) {
            aVar2.f23597a[i10] = aVar;
        }
    }

    private void b() {
        int i4 = 0;
        while (true) {
            byte[] bArr = f23594c;
            if (i4 < bArr.length) {
                a(i4, f23593b[i4], bArr[i4]);
                i4++;
            } else {
                return;
            }
        }
    }

    public static k f() {
        return f23595d;
    }

    /* access modifiers changed from: package-private */
    public byte[] c(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        a aVar = this.f23596a;
        byte b5 = 0;
        int i4 = 0;
        for (byte b6 : bArr) {
            b5 = (b5 << 8) | (b6 & 255);
            i4 += 8;
            while (i4 >= 8) {
                aVar = aVar.f23597a[(b5 >>> (i4 - 8)) & 255];
                if (aVar.f23597a == null) {
                    byteArrayOutputStream.write(aVar.f23598b);
                    i4 -= aVar.f23599c;
                    aVar = this.f23596a;
                } else {
                    i4 -= 8;
                }
            }
        }
        while (i4 > 0) {
            a aVar2 = aVar.f23597a[(b5 << (8 - i4)) & 255];
            if (aVar2.f23597a != null || aVar2.f23599c > i4) {
                break;
            }
            byteArrayOutputStream.write(aVar2.f23598b);
            i4 -= aVar2.f23599c;
            aVar = this.f23596a;
        }
        return byteArrayOutputStream.toByteArray();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: long} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: byte} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void d(N3.C2517h r8, N3.C2515f r9) {
        /*
            r7 = this;
            r0 = 0
            r2 = 0
            r3 = 0
        L_0x0004:
            int r4 = r8.G()
            r5 = 255(0xff, float:3.57E-43)
            if (r2 >= r4) goto L_0x002d
            byte r4 = r8.h(r2)
            r4 = r4 & r5
            int[] r5 = f23593b
            r5 = r5[r4]
            byte[] r6 = f23594c
            byte r4 = r6[r4]
            long r0 = r0 << r4
            long r5 = (long) r5
            long r0 = r0 | r5
            int r3 = r3 + r4
        L_0x001d:
            r4 = 8
            if (r3 < r4) goto L_0x002a
            int r3 = r3 + -8
            long r4 = r0 >> r3
            int r5 = (int) r4
            r9.writeByte(r5)
            goto L_0x001d
        L_0x002a:
            int r2 = r2 + 1
            goto L_0x0004
        L_0x002d:
            if (r3 <= 0) goto L_0x003a
            int r8 = 8 - r3
            long r0 = r0 << r8
            int r8 = r5 >>> r3
            long r2 = (long) r8
            long r0 = r0 | r2
            int r8 = (int) r0
            r9.writeByte(r8)
        L_0x003a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: J3.k.d(N3.h, N3.f):void");
    }

    /* access modifiers changed from: package-private */
    public int e(C2517h hVar) {
        long j4 = 0;
        for (int i4 = 0; i4 < hVar.G(); i4++) {
            j4 += (long) f23594c[hVar.h(i4) & 255];
        }
        return (int) ((j4 + 7) >> 3);
    }

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        final a[] f23597a;

        /* renamed from: b  reason: collision with root package name */
        final int f23598b;

        /* renamed from: c  reason: collision with root package name */
        final int f23599c;

        a() {
            this.f23597a = new a[256];
            this.f23598b = 0;
            this.f23599c = 0;
        }

        a(int i4, int i5) {
            this.f23597a = null;
            this.f23598b = i4;
            int i6 = i5 & 7;
            this.f23599c = i6 == 0 ? 8 : i6;
        }
    }
}
