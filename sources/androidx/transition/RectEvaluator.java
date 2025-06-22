package androidx.transition;

import android.animation.TypeEvaluator;
import android.graphics.Rect;

class RectEvaluator implements TypeEvaluator<Rect> {
    private Rect mRect;

    RectEvaluator() {
    }

    RectEvaluator(Rect rect) {
        this.mRect = rect;
    }

    public Rect evaluate(float f4, Rect rect, Rect rect2) {
        int i4 = rect.left;
        int i5 = i4 + ((int) (((float) (rect2.left - i4)) * f4));
        int i6 = rect.top;
        int i7 = i6 + ((int) (((float) (rect2.top - i6)) * f4));
        int i8 = rect.right;
        int i9 = i8 + ((int) (((float) (rect2.right - i8)) * f4));
        int i10 = rect.bottom;
        int i11 = i10 + ((int) (((float) (rect2.bottom - i10)) * f4));
        Rect rect3 = this.mRect;
        if (rect3 == null) {
            return new Rect(i5, i7, i9, i11);
        }
        rect3.set(i5, i7, i9, i11);
        return this.mRect;
    }
}
