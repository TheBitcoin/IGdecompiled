package androidx.constraintlayout.core.motion.utils;

import java.util.Arrays;
import java.util.HashMap;

public class KeyCache {
    HashMap<Object, HashMap<String, float[]>> mMap = new HashMap<>();

    public float getFloatValue(Object obj, String str, int i4) {
        HashMap hashMap;
        float[] fArr;
        if (this.mMap.containsKey(obj) && (hashMap = this.mMap.get(obj)) != null && hashMap.containsKey(str) && (fArr = (float[]) hashMap.get(str)) != null && fArr.length > i4) {
            return fArr[i4];
        }
        return Float.NaN;
    }

    public void setFloatValue(Object obj, String str, int i4, float f4) {
        if (!this.mMap.containsKey(obj)) {
            HashMap hashMap = new HashMap();
            float[] fArr = new float[(i4 + 1)];
            fArr[i4] = f4;
            hashMap.put(str, fArr);
            this.mMap.put(obj, hashMap);
            return;
        }
        HashMap hashMap2 = this.mMap.get(obj);
        if (hashMap2 == null) {
            hashMap2 = new HashMap();
        }
        if (!hashMap2.containsKey(str)) {
            float[] fArr2 = new float[(i4 + 1)];
            fArr2[i4] = f4;
            hashMap2.put(str, fArr2);
            this.mMap.put(obj, hashMap2);
            return;
        }
        float[] fArr3 = (float[]) hashMap2.get(str);
        if (fArr3 == null) {
            fArr3 = new float[0];
        }
        if (fArr3.length <= i4) {
            fArr3 = Arrays.copyOf(fArr3, i4 + 1);
        }
        fArr3[i4] = f4;
        hashMap2.put(str, fArr3);
    }
}
