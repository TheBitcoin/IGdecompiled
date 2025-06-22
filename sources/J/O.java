package J;

abstract class O {
    static int a(int i4) {
        int[] iArr = {1, 2, 3, 4, 5, 6};
        int i5 = 0;
        while (i5 < 6) {
            int i6 = iArr[i5];
            int i7 = i6 - 1;
            if (i6 == 0) {
                throw null;
            } else if (i7 == i4) {
                return i6;
            } else {
                i5++;
            }
        }
        return 1;
    }
}
