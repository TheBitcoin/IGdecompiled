package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;
import java.util.Map;
import java.util.Set;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class QuantizerCelebi {
    private QuantizerCelebi() {
    }

    public static Map<Integer, Integer> quantize(int[] iArr, int i4) {
        Set<Integer> keySet = new QuantizerWu().quantize(iArr, i4).colorToCount.keySet();
        int[] iArr2 = new int[keySet.size()];
        int i5 = 0;
        for (Integer intValue : keySet) {
            iArr2[i5] = intValue.intValue();
            i5++;
        }
        return QuantizerWsmeans.quantize(iArr, iArr2, i4);
    }
}
