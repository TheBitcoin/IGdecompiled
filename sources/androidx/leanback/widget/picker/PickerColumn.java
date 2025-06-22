package androidx.leanback.widget.picker;

public class PickerColumn {
    private int mCurrentValue;
    private String mLabelFormat;
    private int mMaxValue;
    private int mMinValue;
    private CharSequence[] mStaticLabels;

    public int getCount() {
        return (this.mMaxValue - this.mMinValue) + 1;
    }

    public int getCurrentValue() {
        return this.mCurrentValue;
    }

    public CharSequence getLabelFor(int i4) {
        CharSequence[] charSequenceArr = this.mStaticLabels;
        if (charSequenceArr != null) {
            return charSequenceArr[i4];
        }
        return String.format(this.mLabelFormat, new Object[]{Integer.valueOf(i4)});
    }

    public String getLabelFormat() {
        return this.mLabelFormat;
    }

    public int getMaxValue() {
        return this.mMaxValue;
    }

    public int getMinValue() {
        return this.mMinValue;
    }

    public CharSequence[] getStaticLabels() {
        return this.mStaticLabels;
    }

    public void setCurrentValue(int i4) {
        this.mCurrentValue = i4;
    }

    public void setLabelFormat(String str) {
        this.mLabelFormat = str;
    }

    public void setMaxValue(int i4) {
        this.mMaxValue = i4;
    }

    public void setMinValue(int i4) {
        this.mMinValue = i4;
    }

    public void setStaticLabels(CharSequence[] charSequenceArr) {
        this.mStaticLabels = charSequenceArr;
    }
}
