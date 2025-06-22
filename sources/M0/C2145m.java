package m0;

/* renamed from: m0.m  reason: case insensitive filesystem */
abstract class C2145m {
    static int a(int i4, double d5) {
        int max = Math.max(i4, 2);
        int highestOneBit = Integer.highestOneBit(max);
        if (max <= ((int) (d5 * ((double) highestOneBit)))) {
            return highestOneBit;
        }
        int i5 = highestOneBit << 1;
        if (i5 > 0) {
            return i5;
        }
        return 1073741824;
    }

    static int b(int i4) {
        return (int) (((long) Integer.rotateLeft((int) (((long) i4) * -862048943), 15)) * 461845907);
    }

    static int c(Object obj) {
        int i4;
        if (obj == null) {
            i4 = 0;
        } else {
            i4 = obj.hashCode();
        }
        return b(i4);
    }
}
