package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;
import java.util.LinkedHashMap;
import java.util.Map;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class QuantizerMap implements Quantizer {
    Map<Integer, Integer> colorToCount;

    public Map<Integer, Integer> getColorToCount() {
        return this.colorToCount;
    }

    public QuantizerResult quantize(int[] iArr, int i4) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (int i5 : iArr) {
            Integer num = (Integer) linkedHashMap.get(Integer.valueOf(i5));
            int i6 = 1;
            if (num != null) {
                i6 = 1 + num.intValue();
            }
            linkedHashMap.put(Integer.valueOf(i5), Integer.valueOf(i6));
        }
        this.colorToCount = linkedHashMap;
        return new QuantizerResult(linkedHashMap);
    }
}
