package androidx.constraintlayout.core.state.helpers;

import androidx.constraintlayout.core.state.HelperReference;
import androidx.constraintlayout.core.state.State;
import androidx.constraintlayout.core.widgets.Flow;
import androidx.constraintlayout.core.widgets.HelperWidget;
import java.util.HashMap;

public class FlowReference extends HelperReference {
    protected float mFirstHorizontalBias = 0.5f;
    protected int mFirstHorizontalStyle = -1;
    protected float mFirstVerticalBias = 0.5f;
    protected int mFirstVerticalStyle = -1;
    protected Flow mFlow;
    protected int mHorizontalAlign = 2;
    protected int mHorizontalGap = 0;
    protected int mHorizontalStyle = -1;
    protected float mLastHorizontalBias = 0.5f;
    protected int mLastHorizontalStyle = -1;
    protected float mLastVerticalBias = 0.5f;
    protected int mLastVerticalStyle = -1;
    protected HashMap<String, Float> mMapPostMargin;
    protected HashMap<String, Float> mMapPreMargin;
    protected HashMap<String, Float> mMapWeights;
    protected int mMaxElementsWrap = -1;
    protected int mOrientation = 0;
    protected int mPaddingBottom = 0;
    protected int mPaddingLeft = 0;
    protected int mPaddingRight = 0;
    protected int mPaddingTop = 0;
    protected int mVerticalAlign = 2;
    protected int mVerticalGap = 0;
    protected int mVerticalStyle = -1;
    protected int mWrapMode = 0;

    public FlowReference(State state, State.Helper helper) {
        super(state, helper);
        if (helper == State.Helper.VERTICAL_FLOW) {
            this.mOrientation = 1;
        }
    }

    public void addFlowElement(String str, float f4, float f5, float f6) {
        super.add(str);
        if (!Float.isNaN(f4)) {
            if (this.mMapWeights == null) {
                this.mMapWeights = new HashMap<>();
            }
            this.mMapWeights.put(str, Float.valueOf(f4));
        }
        if (!Float.isNaN(f5)) {
            if (this.mMapPreMargin == null) {
                this.mMapPreMargin = new HashMap<>();
            }
            this.mMapPreMargin.put(str, Float.valueOf(f5));
        }
        if (!Float.isNaN(f6)) {
            if (this.mMapPostMargin == null) {
                this.mMapPostMargin = new HashMap<>();
            }
            this.mMapPostMargin.put(str, Float.valueOf(f6));
        }
    }

    public void apply() {
        getHelperWidget();
        setConstraintWidget(this.mFlow);
        this.mFlow.setOrientation(this.mOrientation);
        this.mFlow.setWrapMode(this.mWrapMode);
        int i4 = this.mMaxElementsWrap;
        if (i4 != -1) {
            this.mFlow.setMaxElementsWrap(i4);
        }
        int i5 = this.mPaddingLeft;
        if (i5 != 0) {
            this.mFlow.setPaddingLeft(i5);
        }
        int i6 = this.mPaddingTop;
        if (i6 != 0) {
            this.mFlow.setPaddingTop(i6);
        }
        int i7 = this.mPaddingRight;
        if (i7 != 0) {
            this.mFlow.setPaddingRight(i7);
        }
        int i8 = this.mPaddingBottom;
        if (i8 != 0) {
            this.mFlow.setPaddingBottom(i8);
        }
        int i9 = this.mHorizontalGap;
        if (i9 != 0) {
            this.mFlow.setHorizontalGap(i9);
        }
        int i10 = this.mVerticalGap;
        if (i10 != 0) {
            this.mFlow.setVerticalGap(i10);
        }
        float f4 = this.mHorizontalBias;
        if (f4 != 0.5f) {
            this.mFlow.setHorizontalBias(f4);
        }
        float f5 = this.mFirstHorizontalBias;
        if (f5 != 0.5f) {
            this.mFlow.setFirstHorizontalBias(f5);
        }
        float f6 = this.mLastHorizontalBias;
        if (f6 != 0.5f) {
            this.mFlow.setLastHorizontalBias(f6);
        }
        float f7 = this.mVerticalBias;
        if (f7 != 0.5f) {
            this.mFlow.setVerticalBias(f7);
        }
        float f8 = this.mFirstVerticalBias;
        if (f8 != 0.5f) {
            this.mFlow.setFirstVerticalBias(f8);
        }
        float f9 = this.mLastVerticalBias;
        if (f9 != 0.5f) {
            this.mFlow.setLastVerticalBias(f9);
        }
        int i11 = this.mHorizontalAlign;
        if (i11 != 2) {
            this.mFlow.setHorizontalAlign(i11);
        }
        int i12 = this.mVerticalAlign;
        if (i12 != 2) {
            this.mFlow.setVerticalAlign(i12);
        }
        int i13 = this.mVerticalStyle;
        if (i13 != -1) {
            this.mFlow.setVerticalStyle(i13);
        }
        int i14 = this.mFirstVerticalStyle;
        if (i14 != -1) {
            this.mFlow.setFirstVerticalStyle(i14);
        }
        int i15 = this.mLastVerticalStyle;
        if (i15 != -1) {
            this.mFlow.setLastVerticalStyle(i15);
        }
        int i16 = this.mHorizontalStyle;
        if (i16 != -1) {
            this.mFlow.setHorizontalStyle(i16);
        }
        int i17 = this.mFirstHorizontalStyle;
        if (i17 != -1) {
            this.mFlow.setFirstHorizontalStyle(i17);
        }
        int i18 = this.mLastHorizontalStyle;
        if (i18 != -1) {
            this.mFlow.setLastHorizontalStyle(i18);
        }
        applyBase();
    }

    public float getFirstHorizontalBias() {
        return this.mFirstHorizontalBias;
    }

    public int getFirstHorizontalStyle() {
        return this.mFirstHorizontalStyle;
    }

    public float getFirstVerticalBias() {
        return this.mFirstVerticalBias;
    }

    public int getFirstVerticalStyle() {
        return this.mFirstVerticalStyle;
    }

    public HelperWidget getHelperWidget() {
        if (this.mFlow == null) {
            this.mFlow = new Flow();
        }
        return this.mFlow;
    }

    public int getHorizontalAlign() {
        return this.mHorizontalAlign;
    }

    public float getHorizontalBias() {
        return this.mHorizontalBias;
    }

    public int getHorizontalGap() {
        return this.mHorizontalGap;
    }

    public int getHorizontalStyle() {
        return this.mHorizontalStyle;
    }

    public float getLastHorizontalBias() {
        return this.mLastHorizontalBias;
    }

    public int getLastHorizontalStyle() {
        return this.mLastHorizontalStyle;
    }

    public float getLastVerticalBias() {
        return this.mLastVerticalBias;
    }

    public int getLastVerticalStyle() {
        return this.mLastVerticalStyle;
    }

    public int getMaxElementsWrap() {
        return this.mMaxElementsWrap;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public int getPaddingBottom() {
        return this.mPaddingBottom;
    }

    public int getPaddingLeft() {
        return this.mPaddingLeft;
    }

    public int getPaddingRight() {
        return this.mPaddingRight;
    }

    public int getPaddingTop() {
        return this.mPaddingTop;
    }

    /* access modifiers changed from: protected */
    public float getPostMargin(String str) {
        HashMap<String, Float> hashMap = this.mMapPreMargin;
        if (hashMap == null || !hashMap.containsKey(str)) {
            return 0.0f;
        }
        return this.mMapPreMargin.get(str).floatValue();
    }

    /* access modifiers changed from: protected */
    public float getPreMargin(String str) {
        HashMap<String, Float> hashMap = this.mMapPostMargin;
        if (hashMap == null || !hashMap.containsKey(str)) {
            return 0.0f;
        }
        return this.mMapPostMargin.get(str).floatValue();
    }

    public int getVerticalAlign() {
        return this.mVerticalAlign;
    }

    public float getVerticalBias() {
        return this.mVerticalBias;
    }

    public int getVerticalGap() {
        return this.mVerticalGap;
    }

    public int getVerticalStyle() {
        return this.mVerticalStyle;
    }

    /* access modifiers changed from: protected */
    public float getWeight(String str) {
        HashMap<String, Float> hashMap = this.mMapWeights;
        if (hashMap != null && hashMap.containsKey(str)) {
            return this.mMapWeights.get(str).floatValue();
        }
        return -1.0f;
    }

    public int getWrapMode() {
        return this.mWrapMode;
    }

    public void setFirstHorizontalBias(float f4) {
        this.mFirstHorizontalBias = f4;
    }

    public void setFirstHorizontalStyle(int i4) {
        this.mFirstHorizontalStyle = i4;
    }

    public void setFirstVerticalBias(float f4) {
        this.mFirstVerticalBias = f4;
    }

    public void setFirstVerticalStyle(int i4) {
        this.mFirstVerticalStyle = i4;
    }

    public void setHelperWidget(HelperWidget helperWidget) {
        if (helperWidget instanceof Flow) {
            this.mFlow = (Flow) helperWidget;
        } else {
            this.mFlow = null;
        }
    }

    public void setHorizontalAlign(int i4) {
        this.mHorizontalAlign = i4;
    }

    public void setHorizontalGap(int i4) {
        this.mHorizontalGap = i4;
    }

    public void setHorizontalStyle(int i4) {
        this.mHorizontalStyle = i4;
    }

    public void setLastHorizontalBias(float f4) {
        this.mLastHorizontalBias = f4;
    }

    public void setLastHorizontalStyle(int i4) {
        this.mLastHorizontalStyle = i4;
    }

    public void setLastVerticalBias(float f4) {
        this.mLastVerticalBias = f4;
    }

    public void setLastVerticalStyle(int i4) {
        this.mLastVerticalStyle = i4;
    }

    public void setMaxElementsWrap(int i4) {
        this.mMaxElementsWrap = i4;
    }

    public void setOrientation(int i4) {
        this.mOrientation = i4;
    }

    public void setPaddingBottom(int i4) {
        this.mPaddingBottom = i4;
    }

    public void setPaddingLeft(int i4) {
        this.mPaddingLeft = i4;
    }

    public void setPaddingRight(int i4) {
        this.mPaddingRight = i4;
    }

    public void setPaddingTop(int i4) {
        this.mPaddingTop = i4;
    }

    public void setVerticalAlign(int i4) {
        this.mVerticalAlign = i4;
    }

    public void setVerticalGap(int i4) {
        this.mVerticalGap = i4;
    }

    public void setVerticalStyle(int i4) {
        this.mVerticalStyle = i4;
    }

    public void setWrapMode(int i4) {
        this.mWrapMode = i4;
    }
}
