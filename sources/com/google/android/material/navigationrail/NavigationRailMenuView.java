package com.google.android.material.navigationrail;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import com.google.android.material.navigation.NavigationBarItemView;
import com.google.android.material.navigation.NavigationBarMenuView;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class NavigationRailMenuView extends NavigationBarMenuView {
    @Px
    private int itemMinimumHeight = -1;
    private final FrameLayout.LayoutParams layoutParams;

    public NavigationRailMenuView(@NonNull Context context) {
        super(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        this.layoutParams = layoutParams2;
        layoutParams2.gravity = 49;
        setLayoutParams(layoutParams2);
        setItemActiveIndicatorResizeable(true);
    }

    private int makeSharedHeightSpec(int i4, int i5, int i6) {
        int max = i5 / Math.max(1, i6);
        int i7 = this.itemMinimumHeight;
        if (i7 == -1) {
            i7 = View.MeasureSpec.getSize(i4);
        }
        return View.MeasureSpec.makeMeasureSpec(Math.min(i7, max), 0);
    }

    private int measureChildHeight(View view, int i4, int i5) {
        if (view.getVisibility() == 8) {
            return 0;
        }
        view.measure(i4, i5);
        return view.getMeasuredHeight();
    }

    private int measureSharedChildHeights(int i4, int i5, int i6, View view) {
        int i7;
        if (view == null) {
            i7 = makeSharedHeightSpec(i4, i5, i6);
        } else {
            i7 = View.MeasureSpec.makeMeasureSpec(view.getMeasuredHeight(), 0);
        }
        int childCount = getChildCount();
        int i8 = 0;
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (childAt != view) {
                i8 += measureChildHeight(childAt, i4, i7);
            }
        }
        return i8;
    }

    private int measureShiftingChildHeights(int i4, int i5, int i6) {
        int i7;
        View childAt = getChildAt(getSelectedItemPosition());
        if (childAt != null) {
            i7 = measureChildHeight(childAt, i4, makeSharedHeightSpec(i4, i5, i6));
            i5 -= i7;
            i6--;
        } else {
            i7 = 0;
        }
        return i7 + measureSharedChildHeights(i4, i5, i6, childAt);
    }

    /* access modifiers changed from: protected */
    @NonNull
    public NavigationBarItemView createNavigationBarItemView(@NonNull Context context) {
        return new NavigationRailItemView(context);
    }

    @Px
    public int getItemMinimumHeight() {
        return this.itemMinimumHeight;
    }

    /* access modifiers changed from: package-private */
    public int getMenuGravity() {
        return this.layoutParams.gravity;
    }

    /* access modifiers changed from: package-private */
    public boolean isTopGravity() {
        if ((this.layoutParams.gravity & 112) == 48) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        int childCount = getChildCount();
        int i8 = i6 - i4;
        int i9 = 0;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() != 8) {
                int measuredHeight = childAt.getMeasuredHeight() + i9;
                childAt.layout(0, i9, i8, measuredHeight);
                i9 = measuredHeight;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i4, int i5) {
        int i6;
        int size = View.MeasureSpec.getSize(i5);
        int size2 = getMenu().getVisibleItems().size();
        if (size2 <= 1 || !isShifting(getLabelVisibilityMode(), size2)) {
            i6 = measureSharedChildHeights(i4, size, size2, (View) null);
        } else {
            i6 = measureShiftingChildHeights(i4, size, size2);
        }
        setMeasuredDimension(View.MeasureSpec.getSize(i4), View.resolveSizeAndState(i6, i5, 0));
    }

    public void setItemMinimumHeight(@Px int i4) {
        if (this.itemMinimumHeight != i4) {
            this.itemMinimumHeight = i4;
            requestLayout();
        }
    }

    /* access modifiers changed from: package-private */
    public void setMenuGravity(int i4) {
        FrameLayout.LayoutParams layoutParams2 = this.layoutParams;
        if (layoutParams2.gravity != i4) {
            layoutParams2.gravity = i4;
            setLayoutParams(layoutParams2);
        }
    }
}
