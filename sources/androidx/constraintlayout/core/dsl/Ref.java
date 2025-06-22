package androidx.constraintlayout.core.dsl;

import java.util.ArrayList;
import java.util.Arrays;

public class Ref {
    private String mId;
    private float mPostMargin;
    private float mPreMargin;
    private float mWeight;

    Ref(String str) {
        this.mWeight = Float.NaN;
        this.mPreMargin = Float.NaN;
        this.mPostMargin = Float.NaN;
        this.mId = str;
    }

    public static void addStringToReferences(String str, ArrayList<Ref> arrayList) {
        Object obj;
        if (str != null && str.length() != 0) {
            Object[] objArr = new Object[4];
            StringBuilder sb = new StringBuilder();
            int i4 = 0;
            int i5 = 0;
            for (int i6 = 0; i6 < str.length(); i6++) {
                char charAt = str.charAt(i6);
                if (!(charAt == ' ' || charAt == '\'')) {
                    if (charAt == ',') {
                        if (i4 < 3) {
                            objArr[i4] = sb.toString();
                            sb.setLength(0);
                            i4++;
                        }
                        if (i5 == 1 && (obj = objArr[0]) != null) {
                            arrayList.add(new Ref(obj.toString()));
                            objArr[0] = null;
                        }
                    } else if (charAt == '[') {
                        i5++;
                    } else if (charAt != ']') {
                        sb.append(charAt);
                    } else if (i5 > 0) {
                        i5--;
                        objArr[i4] = sb.toString();
                        sb.setLength(0);
                        Object obj2 = objArr[0];
                        if (obj2 != null) {
                            arrayList.add(new Ref(obj2.toString(), parseFloat(objArr[1]), parseFloat(objArr[2]), parseFloat(objArr[3])));
                            Arrays.fill(objArr, (Object) null);
                        }
                    }
                    i4 = 0;
                }
            }
        }
    }

    public static float parseFloat(Object obj) {
        try {
            return Float.parseFloat(obj.toString());
        } catch (Exception unused) {
            return Float.NaN;
        }
    }

    public static Ref parseStringToRef(String str) {
        String[] split = str.replaceAll("[\\[\\]\\']", "").split(",");
        if (split.length == 0) {
            return null;
        }
        Object[] objArr = new Object[4];
        int i4 = 0;
        while (i4 < split.length && i4 < 4) {
            objArr[i4] = split[i4];
            i4++;
        }
        return new Ref(objArr[0].toString().replace("'", ""), parseFloat(objArr[1]), parseFloat(objArr[2]), parseFloat(objArr[3]));
    }

    public String getId() {
        return this.mId;
    }

    public float getPostMargin() {
        return this.mPostMargin;
    }

    public float getPreMargin() {
        return this.mPreMargin;
    }

    public float getWeight() {
        return this.mWeight;
    }

    public void setId(String str) {
        this.mId = str;
    }

    public void setPostMargin(float f4) {
        this.mPostMargin = f4;
    }

    public void setPreMargin(float f4) {
        this.mPreMargin = f4;
    }

    public void setWeight(float f4) {
        this.mWeight = f4;
    }

    public String toString() {
        boolean z4;
        float f4;
        String str = this.mId;
        if (str == null || str.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        if (!Float.isNaN(this.mWeight) || !Float.isNaN(this.mPreMargin) || !Float.isNaN(this.mPostMargin)) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z4) {
            sb.append("[");
        }
        sb.append("'");
        sb.append(this.mId);
        sb.append("'");
        float f5 = 0.0f;
        if (!Float.isNaN(this.mPostMargin)) {
            sb.append(",");
            if (!Float.isNaN(this.mWeight)) {
                f4 = this.mWeight;
            } else {
                f4 = 0.0f;
            }
            sb.append(f4);
            sb.append(",");
            if (!Float.isNaN(this.mPreMargin)) {
                f5 = this.mPreMargin;
            }
            sb.append(f5);
            sb.append(",");
            sb.append(this.mPostMargin);
        } else if (!Float.isNaN(this.mPreMargin)) {
            sb.append(",");
            if (!Float.isNaN(this.mWeight)) {
                f5 = this.mWeight;
            }
            sb.append(f5);
            sb.append(",");
            sb.append(this.mPreMargin);
        } else if (!Float.isNaN(this.mWeight)) {
            sb.append(",");
            sb.append(this.mWeight);
        }
        if (z4) {
            sb.append("]");
        }
        sb.append(",");
        return sb.toString();
    }

    Ref(String str, float f4) {
        this.mPreMargin = Float.NaN;
        this.mPostMargin = Float.NaN;
        this.mId = str;
        this.mWeight = f4;
    }

    Ref(String str, float f4, float f5) {
        this.mPostMargin = Float.NaN;
        this.mId = str;
        this.mWeight = f4;
        this.mPreMargin = f5;
    }

    Ref(String str, float f4, float f5, float f6) {
        this.mId = str;
        this.mWeight = f4;
        this.mPreMargin = f5;
        this.mPostMargin = f6;
    }
}
