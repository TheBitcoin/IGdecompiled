package androidx.constraintlayout.core.motion.utils;

import java.util.Arrays;

public class TypedBundle {
    private static final int INITIAL_BOOLEAN = 4;
    private static final int INITIAL_FLOAT = 10;
    private static final int INITIAL_INT = 10;
    private static final int INITIAL_STRING = 5;
    int mCountBoolean = 0;
    int mCountFloat = 0;
    int mCountInt = 0;
    int mCountString = 0;
    int[] mTypeBoolean = new int[4];
    int[] mTypeFloat = new int[10];
    int[] mTypeInt = new int[10];
    int[] mTypeString = new int[5];
    boolean[] mValueBoolean = new boolean[4];
    float[] mValueFloat = new float[10];
    int[] mValueInt = new int[10];
    String[] mValueString = new String[5];

    public void add(int i4, int i5) {
        int i6 = this.mCountInt;
        int[] iArr = this.mTypeInt;
        if (i6 >= iArr.length) {
            this.mTypeInt = Arrays.copyOf(iArr, iArr.length * 2);
            int[] iArr2 = this.mValueInt;
            this.mValueInt = Arrays.copyOf(iArr2, iArr2.length * 2);
        }
        int[] iArr3 = this.mTypeInt;
        int i7 = this.mCountInt;
        iArr3[i7] = i4;
        int[] iArr4 = this.mValueInt;
        this.mCountInt = i7 + 1;
        iArr4[i7] = i5;
    }

    public void addIfNotNull(int i4, String str) {
        if (str != null) {
            add(i4, str);
        }
    }

    public void applyDelta(TypedValues typedValues) {
        for (int i4 = 0; i4 < this.mCountInt; i4++) {
            typedValues.setValue(this.mTypeInt[i4], this.mValueInt[i4]);
        }
        for (int i5 = 0; i5 < this.mCountFloat; i5++) {
            typedValues.setValue(this.mTypeFloat[i5], this.mValueFloat[i5]);
        }
        for (int i6 = 0; i6 < this.mCountString; i6++) {
            typedValues.setValue(this.mTypeString[i6], this.mValueString[i6]);
        }
        for (int i7 = 0; i7 < this.mCountBoolean; i7++) {
            typedValues.setValue(this.mTypeBoolean[i7], this.mValueBoolean[i7]);
        }
    }

    public void clear() {
        this.mCountBoolean = 0;
        this.mCountString = 0;
        this.mCountFloat = 0;
        this.mCountInt = 0;
    }

    public int getInteger(int i4) {
        for (int i5 = 0; i5 < this.mCountInt; i5++) {
            if (this.mTypeInt[i5] == i4) {
                return this.mValueInt[i5];
            }
        }
        return -1;
    }

    public String toString() {
        return "TypedBundle{mCountInt=" + this.mCountInt + ", mCountFloat=" + this.mCountFloat + ", mCountString=" + this.mCountString + ", mCountBoolean=" + this.mCountBoolean + '}';
    }

    public void add(int i4, float f4) {
        int i5 = this.mCountFloat;
        int[] iArr = this.mTypeFloat;
        if (i5 >= iArr.length) {
            this.mTypeFloat = Arrays.copyOf(iArr, iArr.length * 2);
            float[] fArr = this.mValueFloat;
            this.mValueFloat = Arrays.copyOf(fArr, fArr.length * 2);
        }
        int[] iArr2 = this.mTypeFloat;
        int i6 = this.mCountFloat;
        iArr2[i6] = i4;
        float[] fArr2 = this.mValueFloat;
        this.mCountFloat = i6 + 1;
        fArr2[i6] = f4;
    }

    public void applyDelta(TypedBundle typedBundle) {
        for (int i4 = 0; i4 < this.mCountInt; i4++) {
            typedBundle.add(this.mTypeInt[i4], this.mValueInt[i4]);
        }
        for (int i5 = 0; i5 < this.mCountFloat; i5++) {
            typedBundle.add(this.mTypeFloat[i5], this.mValueFloat[i5]);
        }
        for (int i6 = 0; i6 < this.mCountString; i6++) {
            typedBundle.add(this.mTypeString[i6], this.mValueString[i6]);
        }
        for (int i7 = 0; i7 < this.mCountBoolean; i7++) {
            typedBundle.add(this.mTypeBoolean[i7], this.mValueBoolean[i7]);
        }
    }

    public void add(int i4, String str) {
        int i5 = this.mCountString;
        int[] iArr = this.mTypeString;
        if (i5 >= iArr.length) {
            this.mTypeString = Arrays.copyOf(iArr, iArr.length * 2);
            String[] strArr = this.mValueString;
            this.mValueString = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
        }
        int[] iArr2 = this.mTypeString;
        int i6 = this.mCountString;
        iArr2[i6] = i4;
        String[] strArr2 = this.mValueString;
        this.mCountString = i6 + 1;
        strArr2[i6] = str;
    }

    public void add(int i4, boolean z4) {
        int i5 = this.mCountBoolean;
        int[] iArr = this.mTypeBoolean;
        if (i5 >= iArr.length) {
            this.mTypeBoolean = Arrays.copyOf(iArr, iArr.length * 2);
            boolean[] zArr = this.mValueBoolean;
            this.mValueBoolean = Arrays.copyOf(zArr, zArr.length * 2);
        }
        int[] iArr2 = this.mTypeBoolean;
        int i6 = this.mCountBoolean;
        iArr2[i6] = i4;
        boolean[] zArr2 = this.mValueBoolean;
        this.mCountBoolean = i6 + 1;
        zArr2[i6] = z4;
    }
}
