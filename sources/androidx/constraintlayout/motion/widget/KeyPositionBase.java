package androidx.constraintlayout.motion.widget;

import android.graphics.RectF;
import android.view.View;
import java.util.HashSet;

abstract class KeyPositionBase extends Key {
    protected static final float SELECTION_SLOPE = 20.0f;
    int mCurveFit = Key.UNSET;

    KeyPositionBase() {
    }

    /* access modifiers changed from: package-private */
    public abstract void calcPosition(int i4, int i5, float f4, float f5, float f6, float f7);

    /* access modifiers changed from: package-private */
    public void getAttributeNames(HashSet<String> hashSet) {
    }

    /* access modifiers changed from: package-private */
    public abstract float getPositionX();

    /* access modifiers changed from: package-private */
    public abstract float getPositionY();

    public abstract boolean intersects(int i4, int i5, RectF rectF, RectF rectF2, float f4, float f5);

    /* access modifiers changed from: package-private */
    public abstract void positionAttributes(View view, RectF rectF, RectF rectF2, float f4, float f5, String[] strArr, float[] fArr);
}
