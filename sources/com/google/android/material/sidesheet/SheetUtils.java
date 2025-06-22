package com.google.android.material.sidesheet;

import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
final class SheetUtils {
    private SheetUtils() {
    }

    static boolean isSwipeMostlyHorizontal(float f4, float f5) {
        if (Math.abs(f4) > Math.abs(f5)) {
            return true;
        }
        return false;
    }
}
