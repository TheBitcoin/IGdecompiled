package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class AlertDialogLayout extends LinearLayoutCompat {
    public AlertDialogLayout(@Nullable Context context) {
        super(context);
    }

    private void forceUniformWidth(int i4, int i5) {
        int i6;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        int i7 = 0;
        while (i7 < i4) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                LinearLayoutCompat.LayoutParams layoutParams = (LinearLayoutCompat.LayoutParams) childAt.getLayoutParams();
                if (layoutParams.width == -1) {
                    int i8 = layoutParams.height;
                    layoutParams.height = childAt.getMeasuredHeight();
                    i6 = i5;
                    measureChildWithMargins(childAt, makeMeasureSpec, 0, i6, 0);
                    layoutParams.height = i8;
                    i7++;
                    i5 = i6;
                }
            }
            i6 = i5;
            i7++;
            i5 = i6;
        }
    }

    private static int resolveMinimumHeight(View view) {
        int minimumHeight = ViewCompat.getMinimumHeight(view);
        if (minimumHeight > 0) {
            return minimumHeight;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.getChildCount() == 1) {
                return resolveMinimumHeight(viewGroup.getChildAt(0));
            }
        }
        return 0;
    }

    private void setChildFrame(View view, int i4, int i5, int i6, int i7) {
        view.layout(i4, i5, i6 + i4, i7 + i5);
    }

    private boolean tryOnMeasure(int i4, int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11 = i4;
        int i12 = i5;
        int childCount = getChildCount();
        View view = null;
        View view2 = null;
        View view3 = null;
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() != 8) {
                int id = childAt.getId();
                if (id == R.id.topPanel) {
                    view = childAt;
                } else if (id == R.id.buttonPanel) {
                    view2 = childAt;
                } else if ((id != R.id.contentPanel && id != R.id.customPanel) || view3 != null) {
                    return false;
                } else {
                    view3 = childAt;
                }
            }
        }
        int mode = View.MeasureSpec.getMode(i12);
        int size = View.MeasureSpec.getSize(i12);
        int mode2 = View.MeasureSpec.getMode(i11);
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (view != null) {
            view.measure(i11, 0);
            paddingTop += view.getMeasuredHeight();
            i6 = View.combineMeasuredStates(0, view.getMeasuredState());
        } else {
            i6 = 0;
        }
        if (view2 != null) {
            view2.measure(i11, 0);
            i8 = resolveMinimumHeight(view2);
            i7 = view2.getMeasuredHeight() - i8;
            paddingTop += i8;
            i6 = View.combineMeasuredStates(i6, view2.getMeasuredState());
        } else {
            i8 = 0;
            i7 = 0;
        }
        if (view3 != null) {
            if (mode == 0) {
                i10 = 0;
            } else {
                i10 = View.MeasureSpec.makeMeasureSpec(Math.max(0, size - paddingTop), mode);
            }
            view3.measure(i11, i10);
            i9 = view3.getMeasuredHeight();
            paddingTop += i9;
            i6 = View.combineMeasuredStates(i6, view3.getMeasuredState());
        } else {
            i9 = 0;
        }
        int i14 = size - paddingTop;
        if (view2 != null) {
            int i15 = paddingTop - i8;
            int min = Math.min(i14, i7);
            if (min > 0) {
                i14 -= min;
                i8 += min;
            }
            view2.measure(i11, View.MeasureSpec.makeMeasureSpec(i8, 1073741824));
            paddingTop = i15 + view2.getMeasuredHeight();
            i6 = View.combineMeasuredStates(i6, view2.getMeasuredState());
        }
        if (view3 != null && i14 > 0) {
            view3.measure(i11, View.MeasureSpec.makeMeasureSpec(i9 + i14, mode));
            paddingTop = (paddingTop - i9) + view3.getMeasuredHeight();
            i6 = View.combineMeasuredStates(i6, view3.getMeasuredState());
        }
        int i16 = 0;
        for (int i17 = 0; i17 < childCount; i17++) {
            View childAt2 = getChildAt(i17);
            if (childAt2.getVisibility() != 8) {
                i16 = Math.max(i16, childAt2.getMeasuredWidth());
            }
        }
        setMeasuredDimension(View.resolveSizeAndState(i16 + getPaddingLeft() + getPaddingRight(), i11, i6), View.resolveSizeAndState(paddingTop, i12, 0));
        if (mode2 == 1073741824) {
            return true;
        }
        forceUniformWidth(childCount, i12);
        return true;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int paddingLeft = getPaddingLeft();
        int i13 = i6 - i4;
        int paddingRight = i13 - getPaddingRight();
        int paddingRight2 = (i13 - paddingLeft) - getPaddingRight();
        int measuredHeight = getMeasuredHeight();
        int childCount = getChildCount();
        int gravity = getGravity();
        int i14 = gravity & 112;
        int i15 = gravity & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (i14 == 16) {
            i8 = getPaddingTop() + (((i7 - i5) - measuredHeight) / 2);
        } else if (i14 != 80) {
            i8 = getPaddingTop();
        } else {
            i8 = ((getPaddingTop() + i7) - i5) - measuredHeight;
        }
        Drawable dividerDrawable = getDividerDrawable();
        if (dividerDrawable == null) {
            i9 = 0;
        } else {
            i9 = dividerDrawable.getIntrinsicHeight();
        }
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt = getChildAt(i16);
            if (!(childAt == null || childAt.getVisibility() == 8)) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight2 = childAt.getMeasuredHeight();
                LinearLayoutCompat.LayoutParams layoutParams = (LinearLayoutCompat.LayoutParams) childAt.getLayoutParams();
                int i17 = layoutParams.gravity;
                if (i17 < 0) {
                    i17 = i15;
                }
                int absoluteGravity = GravityCompat.getAbsoluteGravity(i17, getLayoutDirection()) & 7;
                if (absoluteGravity == 1) {
                    i10 = ((paddingRight2 - measuredWidth) / 2) + paddingLeft + layoutParams.leftMargin;
                    i11 = layoutParams.rightMargin;
                    i12 = i10 - i11;
                } else if (absoluteGravity != 5) {
                    i12 = layoutParams.leftMargin + paddingLeft;
                } else {
                    i10 = paddingRight - measuredWidth;
                    i11 = layoutParams.rightMargin;
                    i12 = i10 - i11;
                }
                int i18 = i12;
                if (hasDividerBeforeChildAt(i16)) {
                    i8 += i9;
                }
                int i19 = i8 + layoutParams.topMargin;
                setChildFrame(childAt, i18, i19, measuredWidth, measuredHeight2);
                i8 = i19 + measuredHeight2 + layoutParams.bottomMargin;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i4, int i5) {
        if (!tryOnMeasure(i4, i5)) {
            super.onMeasure(i4, i5);
        }
    }

    public AlertDialogLayout(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
