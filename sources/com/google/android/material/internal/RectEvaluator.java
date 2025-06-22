package com.google.android.material.internal;

import android.animation.TypeEvaluator;
import android.graphics.Rect;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class RectEvaluator implements TypeEvaluator<Rect> {
    private final Rect rect;

    public RectEvaluator(@NonNull Rect rect2) {
        this.rect = rect2;
    }

    public Rect evaluate(float f4, @NonNull Rect rect2, @NonNull Rect rect3) {
        int i4 = rect2.left;
        int i5 = i4 + ((int) (((float) (rect3.left - i4)) * f4));
        int i6 = rect2.top;
        int i7 = i6 + ((int) (((float) (rect3.top - i6)) * f4));
        int i8 = rect2.right;
        int i9 = rect2.bottom;
        int i10 = i9 + ((int) (((float) (rect3.bottom - i9)) * f4));
        this.rect.set(i5, i7, i8 + ((int) (((float) (rect3.right - i8)) * f4)), i10);
        return this.rect;
    }
}
