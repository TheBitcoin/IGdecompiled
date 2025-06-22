package androidx.core.graphics;

import android.graphics.Matrix;

public final class MatrixKt {
    public static final Matrix rotationMatrix(float f4, float f5, float f6) {
        Matrix matrix = new Matrix();
        matrix.setRotate(f4, f5, f6);
        return matrix;
    }

    public static /* synthetic */ Matrix rotationMatrix$default(float f4, float f5, float f6, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            f5 = 0.0f;
        }
        if ((i4 & 4) != 0) {
            f6 = 0.0f;
        }
        return rotationMatrix(f4, f5, f6);
    }

    public static final Matrix scaleMatrix(float f4, float f5) {
        Matrix matrix = new Matrix();
        matrix.setScale(f4, f5);
        return matrix;
    }

    public static /* synthetic */ Matrix scaleMatrix$default(float f4, float f5, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            f4 = 1.0f;
        }
        if ((i4 & 2) != 0) {
            f5 = 1.0f;
        }
        return scaleMatrix(f4, f5);
    }

    public static final Matrix times(Matrix matrix, Matrix matrix2) {
        Matrix matrix3 = new Matrix(matrix);
        matrix3.preConcat(matrix2);
        return matrix3;
    }

    public static final Matrix translationMatrix(float f4, float f5) {
        Matrix matrix = new Matrix();
        matrix.setTranslate(f4, f5);
        return matrix;
    }

    public static /* synthetic */ Matrix translationMatrix$default(float f4, float f5, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            f4 = 0.0f;
        }
        if ((i4 & 2) != 0) {
            f5 = 0.0f;
        }
        return translationMatrix(f4, f5);
    }

    public static final float[] values(Matrix matrix) {
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        return fArr;
    }
}
