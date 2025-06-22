package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.navigation.NavigationBarItemView;
import com.google.android.material.navigation.NavigationBarMenuView;
import java.util.ArrayList;
import java.util.List;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class BottomNavigationMenuView extends NavigationBarMenuView {
    private final int activeItemMaxWidth;
    private final int activeItemMinWidth;
    private final int inactiveItemMaxWidth;
    private final int inactiveItemMinWidth;
    private boolean itemHorizontalTranslationEnabled;
    private final List<Integer> tempChildWidths = new ArrayList();

    public BottomNavigationMenuView(@NonNull Context context) {
        super(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        setLayoutParams(layoutParams);
        Resources resources = getResources();
        this.inactiveItemMaxWidth = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_item_max_width);
        this.inactiveItemMinWidth = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_item_min_width);
        this.activeItemMaxWidth = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_active_item_max_width);
        this.activeItemMinWidth = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_active_item_min_width);
    }

    /* access modifiers changed from: protected */
    @NonNull
    public NavigationBarItemView createNavigationBarItemView(@NonNull Context context) {
        return new BottomNavigationItemView(context);
    }

    public boolean isItemHorizontalTranslationEnabled() {
        return this.itemHorizontalTranslationEnabled;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        int childCount = getChildCount();
        int i8 = i6 - i4;
        int i9 = i7 - i5;
        int i10 = 0;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8) {
                if (ViewCompat.getLayoutDirection(this) == 1) {
                    int i12 = i8 - i10;
                    childAt.layout(i12 - childAt.getMeasuredWidth(), 0, i12, i9);
                } else {
                    childAt.layout(i10, 0, childAt.getMeasuredWidth() + i10, i9);
                }
                i10 += childAt.getMeasuredWidth();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i4, int i5) {
        int i6;
        int i7;
        int i8;
        MenuBuilder menu = getMenu();
        int size = View.MeasureSpec.getSize(i4);
        int size2 = menu.getVisibleItems().size();
        int childCount = getChildCount();
        this.tempChildWidths.clear();
        int size3 = View.MeasureSpec.getSize(i5);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size3, 1073741824);
        int i9 = 1;
        if (!isShifting(getLabelVisibilityMode(), size2) || !isItemHorizontalTranslationEnabled()) {
            if (size2 != 0) {
                i9 = size2;
            }
            int min = Math.min(size / i9, this.activeItemMaxWidth);
            int i10 = size - (size2 * min);
            for (int i11 = 0; i11 < childCount; i11++) {
                if (getChildAt(i11).getVisibility() == 8) {
                    i6 = 0;
                } else if (i10 > 0) {
                    i6 = min + 1;
                    i10--;
                } else {
                    i6 = min;
                }
                this.tempChildWidths.add(Integer.valueOf(i6));
            }
        } else {
            View childAt = getChildAt(getSelectedItemPosition());
            int i12 = this.activeItemMinWidth;
            if (childAt.getVisibility() != 8) {
                childAt.measure(View.MeasureSpec.makeMeasureSpec(this.activeItemMaxWidth, Integer.MIN_VALUE), makeMeasureSpec);
                i12 = Math.max(i12, childAt.getMeasuredWidth());
            }
            if (childAt.getVisibility() != 8) {
                i7 = 1;
            } else {
                i7 = 0;
            }
            int i13 = size2 - i7;
            int min2 = Math.min(size - (this.inactiveItemMinWidth * i13), Math.min(i12, this.activeItemMaxWidth));
            int i14 = size - min2;
            if (i13 != 0) {
                i9 = i13;
            }
            int min3 = Math.min(i14 / i9, this.inactiveItemMaxWidth);
            int i15 = i14 - (i13 * min3);
            for (int i16 = 0; i16 < childCount; i16++) {
                if (getChildAt(i16).getVisibility() != 8) {
                    if (i16 == getSelectedItemPosition()) {
                        i8 = min2;
                    } else {
                        i8 = min3;
                    }
                    if (i15 > 0) {
                        i8++;
                        i15--;
                    }
                } else {
                    i8 = 0;
                }
                this.tempChildWidths.add(Integer.valueOf(i8));
            }
        }
        int i17 = 0;
        for (int i18 = 0; i18 < childCount; i18++) {
            View childAt2 = getChildAt(i18);
            if (childAt2.getVisibility() != 8) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec(this.tempChildWidths.get(i18).intValue(), 1073741824), makeMeasureSpec);
                childAt2.getLayoutParams().width = childAt2.getMeasuredWidth();
                i17 += childAt2.getMeasuredWidth();
            }
        }
        setMeasuredDimension(i17, size3);
    }

    public void setItemHorizontalTranslationEnabled(boolean z4) {
        this.itemHorizontalTranslationEnabled = z4;
    }
}
