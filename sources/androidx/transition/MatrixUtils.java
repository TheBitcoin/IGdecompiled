package androidx.transition;

import android.graphics.Matrix;
import android.graphics.RectF;

class MatrixUtils {
    static final Matrix IDENTITY_MATRIX = new Matrix() {
        /* access modifiers changed from: package-private */
        public void oops() {
            throw new IllegalStateException("Matrix can not be modified");
        }

        public boolean postConcat(Matrix matrix) {
            oops();
            return false;
        }

        public boolean postRotate(float f4, float f5, float f6) {
            oops();
            return false;
        }

        public boolean postScale(float f4, float f5, float f6, float f7) {
            oops();
            return false;
        }

        public boolean postSkew(float f4, float f5, float f6, float f7) {
            oops();
            return false;
        }

        public boolean postTranslate(float f4, float f5) {
            oops();
            return false;
        }

        public boolean preConcat(Matrix matrix) {
            oops();
            return false;
        }

        public boolean preRotate(float f4, float f5, float f6) {
            oops();
            return false;
        }

        public boolean preScale(float f4, float f5, float f6, float f7) {
            oops();
            return false;
        }

        public boolean preSkew(float f4, float f5, float f6, float f7) {
            oops();
            return false;
        }

        public boolean preTranslate(float f4, float f5) {
            oops();
            return false;
        }

        public void reset() {
            oops();
        }

        public void set(Matrix matrix) {
            oops();
        }

        public boolean setConcat(Matrix matrix, Matrix matrix2) {
            oops();
            return false;
        }

        public boolean setPolyToPoly(float[] fArr, int i4, float[] fArr2, int i5, int i6) {
            oops();
            return false;
        }

        public boolean setRectToRect(RectF rectF, RectF rectF2, Matrix.ScaleToFit scaleToFit) {
            oops();
            return false;
        }

        public void setRotate(float f4, float f5, float f6) {
            oops();
        }

        public void setScale(float f4, float f5, float f6, float f7) {
            oops();
        }

        public void setSinCos(float f4, float f5, float f6, float f7) {
            oops();
        }

        public void setSkew(float f4, float f5, float f6, float f7) {
            oops();
        }

        public void setTranslate(float f4, float f5) {
            oops();
        }

        public void setValues(float[] fArr) {
            oops();
        }

        public boolean postRotate(float f4) {
            oops();
            return false;
        }

        public boolean postScale(float f4, float f5) {
            oops();
            return false;
        }

        public boolean postSkew(float f4, float f5) {
            oops();
            return false;
        }

        public boolean preRotate(float f4) {
            oops();
            return false;
        }

        public boolean preScale(float f4, float f5) {
            oops();
            return false;
        }

        public boolean preSkew(float f4, float f5) {
            oops();
            return false;
        }

        public void setRotate(float f4) {
            oops();
        }

        public void setScale(float f4, float f5) {
            oops();
        }

        public void setSinCos(float f4, float f5) {
            oops();
        }

        public void setSkew(float f4, float f5) {
            oops();
        }
    };

    private MatrixUtils() {
    }
}
