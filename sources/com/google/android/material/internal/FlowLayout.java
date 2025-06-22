package com.google.android.material.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class FlowLayout extends ViewGroup {
    private int itemSpacing;
    private int lineSpacing;
    private int rowCount;
    private boolean singleLine;

    public FlowLayout(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private static int getMeasuredDimension(int i4, int i5, int i6) {
        if (i5 == Integer.MIN_VALUE) {
            return Math.min(i6, i4);
        }
        if (i5 != 1073741824) {
            return i6;
        }
        return i4;
    }

    private void loadFromAttributes(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.FlowLayout, 0, 0);
        this.lineSpacing = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FlowLayout_lineSpacing, 0);
        this.itemSpacing = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FlowLayout_itemSpacing, 0);
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: protected */
    public int getItemSpacing() {
        return this.itemSpacing;
    }

    /* access modifiers changed from: protected */
    public int getLineSpacing() {
        return this.lineSpacing;
    }

    /* access modifiers changed from: protected */
    public int getRowCount() {
        return this.rowCount;
    }

    public int getRowIndex(@NonNull View view) {
        Object tag = view.getTag(R.id.row_index_key);
        if (!(tag instanceof Integer)) {
            return -1;
        }
        return ((Integer) tag).intValue();
    }

    public boolean isSingleLine() {
        return this.singleLine;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        boolean z5;
        int i8;
        int i9;
        int i10;
        int i11;
        if (getChildCount() == 0) {
            this.rowCount = 0;
            return;
        }
        this.rowCount = 1;
        if (ViewCompat.getLayoutDirection(this) == 1) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (z5) {
            i8 = getPaddingRight();
        } else {
            i8 = getPaddingLeft();
        }
        if (z5) {
            i9 = getPaddingLeft();
        } else {
            i9 = getPaddingRight();
        }
        int paddingTop = getPaddingTop();
        int i12 = (i6 - i4) - i9;
        int i13 = i8;
        int i14 = paddingTop;
        for (int i15 = 0; i15 < getChildCount(); i15++) {
            View childAt = getChildAt(i15);
            if (childAt.getVisibility() == 8) {
                childAt.setTag(R.id.row_index_key, -1);
            } else {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    i10 = MarginLayoutParamsCompat.getMarginStart(marginLayoutParams);
                    i11 = MarginLayoutParamsCompat.getMarginEnd(marginLayoutParams);
                } else {
                    i11 = 0;
                    i10 = 0;
                }
                int measuredWidth = i13 + i10 + childAt.getMeasuredWidth();
                if (!this.singleLine && measuredWidth > i12) {
                    i14 = this.lineSpacing + paddingTop;
                    this.rowCount++;
                    i13 = i8;
                }
                childAt.setTag(R.id.row_index_key, Integer.valueOf(this.rowCount - 1));
                int i16 = i13 + i10;
                int measuredWidth2 = childAt.getMeasuredWidth() + i16;
                int measuredHeight = childAt.getMeasuredHeight() + i14;
                if (z5) {
                    childAt.layout(i12 - measuredWidth2, i14, (i12 - i13) - i10, measuredHeight);
                } else {
                    childAt.layout(i16, i14, measuredWidth2, measuredHeight);
                }
                i13 += i10 + i11 + childAt.getMeasuredWidth() + this.itemSpacing;
                paddingTop = measuredHeight;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i4, int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        int size = View.MeasureSpec.getSize(i4);
        int mode = View.MeasureSpec.getMode(i4);
        int size2 = View.MeasureSpec.getSize(i5);
        int mode2 = View.MeasureSpec.getMode(i5);
        if (mode == Integer.MIN_VALUE || mode == 1073741824) {
            i6 = size;
        } else {
            i6 = Integer.MAX_VALUE;
        }
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = i6 - getPaddingRight();
        int i10 = paddingTop;
        int i11 = 0;
        for (int i12 = 0; i12 < getChildCount(); i12++) {
            View childAt = getChildAt(i12);
            if (childAt.getVisibility() == 8) {
                int i13 = i4;
                int i14 = i5;
            } else {
                measureChild(childAt, i4, i5);
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    i8 = marginLayoutParams.leftMargin;
                    i7 = marginLayoutParams.rightMargin;
                } else {
                    i8 = 0;
                    i7 = 0;
                }
                int i15 = paddingLeft;
                if (paddingLeft + i8 + childAt.getMeasuredWidth() <= paddingRight || isSingleLine()) {
                    i9 = i15;
                } else {
                    i9 = getPaddingLeft();
                    i10 = this.lineSpacing + paddingTop;
                }
                int measuredWidth = i9 + i8 + childAt.getMeasuredWidth();
                int measuredHeight = i10 + childAt.getMeasuredHeight();
                if (measuredWidth > i11) {
                    i11 = measuredWidth;
                }
                paddingLeft = i9 + i8 + i7 + childAt.getMeasuredWidth() + this.itemSpacing;
                if (i12 == getChildCount() - 1) {
                    i11 += i7;
                }
                paddingTop = measuredHeight;
            }
        }
        setMeasuredDimension(getMeasuredDimension(size, mode, i11 + getPaddingRight()), getMeasuredDimension(size2, mode2, paddingTop + getPaddingBottom()));
    }

    /* access modifiers changed from: protected */
    public void setItemSpacing(int i4) {
        this.itemSpacing = i4;
    }

    /* access modifiers changed from: protected */
    public void setLineSpacing(int i4) {
        this.lineSpacing = i4;
    }

    public void setSingleLine(boolean z4) {
        this.singleLine = z4;
    }

    public FlowLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FlowLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.singleLine = false;
        loadFromAttributes(context, attributeSet);
    }

    @TargetApi(21)
    public FlowLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4, int i5) {
        super(context, attributeSet, i4, i5);
        this.singleLine = false;
        loadFromAttributes(context, attributeSet);
    }
}
