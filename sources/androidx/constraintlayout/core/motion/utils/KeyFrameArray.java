package androidx.constraintlayout.core.motion.utils;

import androidx.constraintlayout.core.motion.CustomAttribute;
import androidx.constraintlayout.core.motion.CustomVariable;
import java.io.PrintStream;
import java.util.Arrays;

public class KeyFrameArray {

    public static class CustomArray {
        private static final int EMPTY = 999;
        int mCount;
        int[] mKeys = new int[101];
        CustomAttribute[] mValues = new CustomAttribute[101];

        public CustomArray() {
            clear();
        }

        public void append(int i4, CustomAttribute customAttribute) {
            if (this.mValues[i4] != null) {
                remove(i4);
            }
            this.mValues[i4] = customAttribute;
            int[] iArr = this.mKeys;
            int i5 = this.mCount;
            this.mCount = i5 + 1;
            iArr[i5] = i4;
            Arrays.sort(iArr);
        }

        public void clear() {
            Arrays.fill(this.mKeys, 999);
            Arrays.fill(this.mValues, (Object) null);
            this.mCount = 0;
        }

        public void dump() {
            String str;
            PrintStream printStream = System.out;
            printStream.println("V: " + Arrays.toString(Arrays.copyOf(this.mKeys, this.mCount)));
            System.out.print("K: [");
            for (int i4 = 0; i4 < this.mCount; i4++) {
                PrintStream printStream2 = System.out;
                StringBuilder sb = new StringBuilder();
                if (i4 == 0) {
                    str = "";
                } else {
                    str = ", ";
                }
                sb.append(str);
                sb.append(valueAt(i4));
                printStream2.print(sb.toString());
            }
            System.out.println("]");
        }

        public int keyAt(int i4) {
            return this.mKeys[i4];
        }

        public void remove(int i4) {
            this.mValues[i4] = null;
            int i5 = 0;
            int i6 = 0;
            while (true) {
                int i7 = this.mCount;
                if (i5 < i7) {
                    int[] iArr = this.mKeys;
                    if (i4 == iArr[i5]) {
                        iArr[i5] = 999;
                        i6++;
                    }
                    if (i5 != i6) {
                        iArr[i5] = iArr[i6];
                    }
                    i6++;
                    i5++;
                } else {
                    this.mCount = i7 - 1;
                    return;
                }
            }
        }

        public int size() {
            return this.mCount;
        }

        public CustomAttribute valueAt(int i4) {
            return this.mValues[this.mKeys[i4]];
        }
    }

    public static class CustomVar {
        private static final int EMPTY = 999;
        int mCount;
        int[] mKeys = new int[101];
        CustomVariable[] mValues = new CustomVariable[101];

        public CustomVar() {
            clear();
        }

        public void append(int i4, CustomVariable customVariable) {
            if (this.mValues[i4] != null) {
                remove(i4);
            }
            this.mValues[i4] = customVariable;
            int[] iArr = this.mKeys;
            int i5 = this.mCount;
            this.mCount = i5 + 1;
            iArr[i5] = i4;
            Arrays.sort(iArr);
        }

        public void clear() {
            Arrays.fill(this.mKeys, 999);
            Arrays.fill(this.mValues, (Object) null);
            this.mCount = 0;
        }

        public void dump() {
            String str;
            PrintStream printStream = System.out;
            printStream.println("V: " + Arrays.toString(Arrays.copyOf(this.mKeys, this.mCount)));
            System.out.print("K: [");
            for (int i4 = 0; i4 < this.mCount; i4++) {
                PrintStream printStream2 = System.out;
                StringBuilder sb = new StringBuilder();
                if (i4 == 0) {
                    str = "";
                } else {
                    str = ", ";
                }
                sb.append(str);
                sb.append(valueAt(i4));
                printStream2.print(sb.toString());
            }
            System.out.println("]");
        }

        public int keyAt(int i4) {
            return this.mKeys[i4];
        }

        public void remove(int i4) {
            this.mValues[i4] = null;
            int i5 = 0;
            int i6 = 0;
            while (true) {
                int i7 = this.mCount;
                if (i5 < i7) {
                    int[] iArr = this.mKeys;
                    if (i4 == iArr[i5]) {
                        iArr[i5] = 999;
                        i6++;
                    }
                    if (i5 != i6) {
                        iArr[i5] = iArr[i6];
                    }
                    i6++;
                    i5++;
                } else {
                    this.mCount = i7 - 1;
                    return;
                }
            }
        }

        public int size() {
            return this.mCount;
        }

        public CustomVariable valueAt(int i4) {
            return this.mValues[this.mKeys[i4]];
        }
    }

    static class FloatArray {
        private static final int EMPTY = 999;
        int mCount;
        int[] mKeys = new int[101];
        float[][] mValues = new float[101][];

        FloatArray() {
            clear();
        }

        public void append(int i4, float[] fArr) {
            if (this.mValues[i4] != null) {
                remove(i4);
            }
            this.mValues[i4] = fArr;
            int[] iArr = this.mKeys;
            int i5 = this.mCount;
            this.mCount = i5 + 1;
            iArr[i5] = i4;
            Arrays.sort(iArr);
        }

        public void clear() {
            Arrays.fill(this.mKeys, 999);
            Arrays.fill(this.mValues, (Object) null);
            this.mCount = 0;
        }

        public void dump() {
            String str;
            PrintStream printStream = System.out;
            printStream.println("V: " + Arrays.toString(Arrays.copyOf(this.mKeys, this.mCount)));
            System.out.print("K: [");
            for (int i4 = 0; i4 < this.mCount; i4++) {
                PrintStream printStream2 = System.out;
                StringBuilder sb = new StringBuilder();
                if (i4 == 0) {
                    str = "";
                } else {
                    str = ", ";
                }
                sb.append(str);
                sb.append(Arrays.toString(valueAt(i4)));
                printStream2.print(sb.toString());
            }
            System.out.println("]");
        }

        public int keyAt(int i4) {
            return this.mKeys[i4];
        }

        public void remove(int i4) {
            this.mValues[i4] = null;
            int i5 = 0;
            int i6 = 0;
            while (true) {
                int i7 = this.mCount;
                if (i5 < i7) {
                    int[] iArr = this.mKeys;
                    if (i4 == iArr[i5]) {
                        iArr[i5] = 999;
                        i6++;
                    }
                    if (i5 != i6) {
                        iArr[i5] = iArr[i6];
                    }
                    i6++;
                    i5++;
                } else {
                    this.mCount = i7 - 1;
                    return;
                }
            }
        }

        public int size() {
            return this.mCount;
        }

        public float[] valueAt(int i4) {
            return this.mValues[this.mKeys[i4]];
        }
    }
}
