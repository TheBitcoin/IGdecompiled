package androidx.leanback.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import java.util.ArrayList;

class ControlBar extends LinearLayout {
    private int mChildMarginFromCenter;
    boolean mDefaultFocusToMiddle = true;
    int mLastFocusIndex = -1;
    private OnChildFocusedListener mOnChildFocusedListener;

    public interface OnChildFocusedListener {
        void onChildFocusedListener(View view, View view2);
    }

    public ControlBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void addFocusables(ArrayList<View> arrayList, int i4, int i5) {
        if (i4 == 33 || i4 == 130) {
            int i6 = this.mLastFocusIndex;
            if (i6 >= 0 && i6 < getChildCount()) {
                arrayList.add(getChildAt(this.mLastFocusIndex));
            } else if (getChildCount() > 0) {
                arrayList.add(getChildAt(getDefaultFocusIndex()));
            }
        } else {
            super.addFocusables(arrayList, i4, i5);
        }
    }

    /* access modifiers changed from: package-private */
    public int getDefaultFocusIndex() {
        if (this.mDefaultFocusToMiddle) {
            return getChildCount() / 2;
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i4, int i5) {
        super.onMeasure(i4, i5);
        if (this.mChildMarginFromCenter > 0) {
            int i6 = 0;
            int i7 = 0;
            while (i6 < getChildCount() - 1) {
                View childAt = getChildAt(i6);
                i6++;
                View childAt2 = getChildAt(i6);
                int measuredWidth = this.mChildMarginFromCenter - ((childAt.getMeasuredWidth() + childAt2.getMeasuredWidth()) / 2);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt2.getLayoutParams();
                layoutParams.setMarginStart(measuredWidth);
                childAt2.setLayoutParams(layoutParams);
                i7 += measuredWidth - layoutParams.getMarginStart();
            }
            setMeasuredDimension(getMeasuredWidth() + i7, getMeasuredHeight());
        }
    }

    /* access modifiers changed from: protected */
    public boolean onRequestFocusInDescendants(int i4, Rect rect) {
        int i5;
        if (getChildCount() > 0) {
            int i6 = this.mLastFocusIndex;
            if (i6 < 0 || i6 >= getChildCount()) {
                i5 = getDefaultFocusIndex();
            } else {
                i5 = this.mLastFocusIndex;
            }
            if (getChildAt(i5).requestFocus(i4, rect)) {
                return true;
            }
        }
        return super.onRequestFocusInDescendants(i4, rect);
    }

    public void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        this.mLastFocusIndex = indexOfChild(view);
        OnChildFocusedListener onChildFocusedListener = this.mOnChildFocusedListener;
        if (onChildFocusedListener != null) {
            onChildFocusedListener.onChildFocusedListener(view, view2);
        }
    }

    public void setChildMarginFromCenter(int i4) {
        this.mChildMarginFromCenter = i4;
    }

    /* access modifiers changed from: package-private */
    public void setDefaultFocusToMiddle(boolean z4) {
        this.mDefaultFocusToMiddle = z4;
    }

    public void setOnChildFocusedListener(OnChildFocusedListener onChildFocusedListener) {
        this.mOnChildFocusedListener = onChildFocusedListener;
    }

    public ControlBar(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
    }
}
