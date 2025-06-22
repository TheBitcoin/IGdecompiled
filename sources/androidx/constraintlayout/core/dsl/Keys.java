package androidx.constraintlayout.core.dsl;

import java.util.Arrays;

public class Keys {
    /* access modifiers changed from: protected */
    public void append(StringBuilder sb, String str, int i4) {
        if (i4 != Integer.MIN_VALUE) {
            sb.append(str);
            sb.append(":'");
            sb.append(i4);
            sb.append("',\n");
        }
    }

    /* access modifiers changed from: protected */
    public String unpack(String[] strArr) {
        String str;
        StringBuilder sb = new StringBuilder("[");
        for (int i4 = 0; i4 < strArr.length; i4++) {
            if (i4 == 0) {
                str = "'";
            } else {
                str = ",'";
            }
            sb.append(str);
            sb.append(strArr[i4]);
            sb.append("'");
        }
        sb.append("]");
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public void append(StringBuilder sb, String str, String str2) {
        if (str2 != null) {
            sb.append(str);
            sb.append(":'");
            sb.append(str2);
            sb.append("',\n");
        }
    }

    /* access modifiers changed from: protected */
    public void append(StringBuilder sb, String str, float f4) {
        if (!Float.isNaN(f4)) {
            sb.append(str);
            sb.append(":");
            sb.append(f4);
            sb.append(",\n");
        }
    }

    /* access modifiers changed from: protected */
    public void append(StringBuilder sb, String str, String[] strArr) {
        if (strArr != null) {
            sb.append(str);
            sb.append(":");
            sb.append(unpack(strArr));
            sb.append(",\n");
        }
    }

    /* access modifiers changed from: protected */
    public void append(StringBuilder sb, String str, float[] fArr) {
        if (fArr != null) {
            sb.append(str);
            sb.append("percentWidth:");
            sb.append(Arrays.toString(fArr));
            sb.append(",\n");
        }
    }
}
