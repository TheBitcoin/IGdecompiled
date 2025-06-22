package androidx.constraintlayout.core.parser;

public class CLNumber extends CLElement {
    float mValue;

    public CLNumber(char[] cArr) {
        super(cArr);
        this.mValue = Float.NaN;
    }

    public static CLElement allocate(char[] cArr) {
        return new CLNumber(cArr);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CLNumber) {
            float f4 = getFloat();
            float f5 = ((CLNumber) obj).getFloat();
            if ((!Float.isNaN(f4) || !Float.isNaN(f5)) && f4 != f5) {
                return false;
            }
            return true;
        }
        return false;
    }

    public float getFloat() {
        if (Float.isNaN(this.mValue) && hasContent()) {
            this.mValue = Float.parseFloat(content());
        }
        return this.mValue;
    }

    public int getInt() {
        if (Float.isNaN(this.mValue) && hasContent()) {
            this.mValue = (float) Integer.parseInt(content());
        }
        return (int) this.mValue;
    }

    public int hashCode() {
        int i4;
        int hashCode = super.hashCode() * 31;
        float f4 = this.mValue;
        if (f4 != 0.0f) {
            i4 = Float.floatToIntBits(f4);
        } else {
            i4 = 0;
        }
        return hashCode + i4;
    }

    public boolean isInt() {
        float f4 = getFloat();
        if (((float) ((int) f4)) == f4) {
            return true;
        }
        return false;
    }

    public void putValue(float f4) {
        this.mValue = f4;
    }

    /* access modifiers changed from: protected */
    public String toFormattedJSON(int i4, int i5) {
        StringBuilder sb = new StringBuilder();
        addIndent(sb, i4);
        float f4 = getFloat();
        int i6 = (int) f4;
        if (((float) i6) == f4) {
            sb.append(i6);
        } else {
            sb.append(f4);
        }
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public String toJSON() {
        float f4 = getFloat();
        int i4 = (int) f4;
        if (((float) i4) == f4) {
            return "" + i4;
        }
        return "" + f4;
    }

    public CLNumber(float f4) {
        super((char[]) null);
        this.mValue = f4;
    }
}
