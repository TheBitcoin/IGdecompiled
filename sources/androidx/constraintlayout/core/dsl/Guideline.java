package androidx.constraintlayout.core.dsl;

import androidx.constraintlayout.core.dsl.Helper;

public abstract class Guideline extends Helper {
    private int mEnd = Integer.MIN_VALUE;
    private float mPercent = Float.NaN;
    private int mStart = Integer.MIN_VALUE;

    Guideline(String str) {
        super(str, new Helper.HelperType(""));
    }

    public int getEnd() {
        return this.mEnd;
    }

    public float getPercent() {
        return this.mPercent;
    }

    public int getStart() {
        return this.mStart;
    }

    public void setEnd(int i4) {
        this.mEnd = i4;
        this.configMap.put(TtmlNode.END, String.valueOf(i4));
    }

    public void setPercent(float f4) {
        this.mPercent = f4;
        this.configMap.put("percent", String.valueOf(f4));
    }

    public void setStart(int i4) {
        this.mStart = i4;
        this.configMap.put("start", String.valueOf(i4));
    }
}
