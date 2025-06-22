package com.google.android.material.navigationrail;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.resources.MaterialResources;

public class NavigationRailView extends NavigationBarView {
    private static final int DEFAULT_HEADER_GRAVITY = 49;
    static final int DEFAULT_MENU_GRAVITY = 49;
    static final int MAX_ITEM_COUNT = 7;
    static final int NO_ITEM_MINIMUM_HEIGHT = -1;
    @Nullable
    private View headerView;
    /* access modifiers changed from: private */
    @Nullable
    public Boolean paddingBottomSystemWindowInsets;
    /* access modifiers changed from: private */
    @Nullable
    public Boolean paddingStartSystemWindowInsets;
    /* access modifiers changed from: private */
    @Nullable
    public Boolean paddingTopSystemWindowInsets;
    private final int topMargin;

    public NavigationRailView(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private void applyWindowInsets() {
        ViewUtils.doOnApplyWindowInsets(this, new ViewUtils.OnApplyWindowInsetsListener() {
            @NonNull
            public WindowInsetsCompat onApplyWindowInsets(View view, @NonNull WindowInsetsCompat windowInsetsCompat, @NonNull ViewUtils.RelativePadding relativePadding) {
                int i4;
                Insets insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars());
                NavigationRailView navigationRailView = NavigationRailView.this;
                if (navigationRailView.shouldApplyWindowInsetPadding(navigationRailView.paddingTopSystemWindowInsets)) {
                    relativePadding.top += insets.top;
                }
                NavigationRailView navigationRailView2 = NavigationRailView.this;
                if (navigationRailView2.shouldApplyWindowInsetPadding(navigationRailView2.paddingBottomSystemWindowInsets)) {
                    relativePadding.bottom += insets.bottom;
                }
                NavigationRailView navigationRailView3 = NavigationRailView.this;
                if (navigationRailView3.shouldApplyWindowInsetPadding(navigationRailView3.paddingStartSystemWindowInsets)) {
                    int i5 = relativePadding.start;
                    if (ViewUtils.isLayoutRtl(view)) {
                        i4 = insets.right;
                    } else {
                        i4 = insets.left;
                    }
                    relativePadding.start = i5 + i4;
                }
                relativePadding.applyToView(view);
                return windowInsetsCompat;
            }
        });
    }

    private NavigationRailMenuView getNavigationRailMenuView() {
        return (NavigationRailMenuView) getMenuView();
    }

    private boolean isHeaderViewVisible() {
        View view = this.headerView;
        if (view == null || view.getVisibility() == 8) {
            return false;
        }
        return true;
    }

    private int makeMinWidthSpec(int i4) {
        int suggestedMinimumWidth = getSuggestedMinimumWidth();
        if (View.MeasureSpec.getMode(i4) == 1073741824 || suggestedMinimumWidth <= 0) {
            return i4;
        }
        return View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i4), suggestedMinimumWidth + getPaddingLeft() + getPaddingRight()), 1073741824);
    }

    /* access modifiers changed from: private */
    public boolean shouldApplyWindowInsetPadding(Boolean bool) {
        if (bool != null) {
            return bool.booleanValue();
        }
        return ViewCompat.getFitsSystemWindows(this);
    }

    public void addHeaderView(@LayoutRes int i4) {
        addHeaderView(LayoutInflater.from(getContext()).inflate(i4, this, false));
    }

    @Nullable
    public View getHeaderView() {
        return this.headerView;
    }

    public int getItemMinimumHeight() {
        return ((NavigationRailMenuView) getMenuView()).getItemMinimumHeight();
    }

    public int getMaxItemCount() {
        return 7;
    }

    public int getMenuGravity() {
        return getNavigationRailMenuView().getMenuGravity();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        super.onLayout(z4, i4, i5, i6, i7);
        NavigationRailMenuView navigationRailMenuView = getNavigationRailMenuView();
        int i8 = 0;
        if (isHeaderViewVisible()) {
            int bottom = this.headerView.getBottom() + this.topMargin;
            int top = navigationRailMenuView.getTop();
            if (top < bottom) {
                i8 = bottom - top;
            }
        } else if (navigationRailMenuView.isTopGravity()) {
            i8 = this.topMargin;
        }
        if (i8 > 0) {
            navigationRailMenuView.layout(navigationRailMenuView.getLeft(), navigationRailMenuView.getTop() + i8, navigationRailMenuView.getRight(), navigationRailMenuView.getBottom() + i8);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i4, int i5) {
        int makeMinWidthSpec = makeMinWidthSpec(i4);
        super.onMeasure(makeMinWidthSpec, i5);
        if (isHeaderViewVisible()) {
            measureChild(getNavigationRailMenuView(), makeMinWidthSpec, View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - this.headerView.getMeasuredHeight()) - this.topMargin, Integer.MIN_VALUE));
        }
    }

    public void removeHeaderView() {
        View view = this.headerView;
        if (view != null) {
            removeView(view);
            this.headerView = null;
        }
    }

    public void setItemMinimumHeight(@Px int i4) {
        ((NavigationRailMenuView) getMenuView()).setItemMinimumHeight(i4);
    }

    public void setMenuGravity(int i4) {
        getNavigationRailMenuView().setMenuGravity(i4);
    }

    public NavigationRailView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.navigationRailStyle);
    }

    public void addHeaderView(@NonNull View view) {
        removeHeaderView();
        this.headerView = view;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 49;
        layoutParams.topMargin = this.topMargin;
        addView(view, 0, layoutParams);
    }

    /* access modifiers changed from: protected */
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public NavigationRailMenuView createNavigationBarMenuView(@NonNull Context context) {
        return new NavigationRailMenuView(context);
    }

    public NavigationRailView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        this(context, attributeSet, i4, R.style.Widget_MaterialComponents_NavigationRailView);
    }

    public NavigationRailView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4, int i5) {
        super(context, attributeSet, i4, i5);
        this.paddingTopSystemWindowInsets = null;
        this.paddingBottomSystemWindowInsets = null;
        this.paddingStartSystemWindowInsets = null;
        this.topMargin = getResources().getDimensionPixelSize(R.dimen.mtrl_navigation_rail_margin);
        Context context2 = getContext();
        TintTypedArray obtainTintedStyledAttributes = ThemeEnforcement.obtainTintedStyledAttributes(context2, attributeSet, R.styleable.NavigationRailView, i4, i5, new int[0]);
        int resourceId = obtainTintedStyledAttributes.getResourceId(R.styleable.NavigationRailView_headerLayout, 0);
        if (resourceId != 0) {
            addHeaderView(resourceId);
        }
        setMenuGravity(obtainTintedStyledAttributes.getInt(R.styleable.NavigationRailView_menuGravity, 49));
        int i6 = R.styleable.NavigationRailView_itemMinHeight;
        if (obtainTintedStyledAttributes.hasValue(i6)) {
            setItemMinimumHeight(obtainTintedStyledAttributes.getDimensionPixelSize(i6, -1));
        }
        int i7 = R.styleable.NavigationRailView_paddingTopSystemWindowInsets;
        if (obtainTintedStyledAttributes.hasValue(i7)) {
            this.paddingTopSystemWindowInsets = Boolean.valueOf(obtainTintedStyledAttributes.getBoolean(i7, false));
        }
        int i8 = R.styleable.NavigationRailView_paddingBottomSystemWindowInsets;
        if (obtainTintedStyledAttributes.hasValue(i8)) {
            this.paddingBottomSystemWindowInsets = Boolean.valueOf(obtainTintedStyledAttributes.getBoolean(i8, false));
        }
        int i9 = R.styleable.NavigationRailView_paddingStartSystemWindowInsets;
        if (obtainTintedStyledAttributes.hasValue(i9)) {
            this.paddingStartSystemWindowInsets = Boolean.valueOf(obtainTintedStyledAttributes.getBoolean(i9, false));
        }
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.m3_navigation_rail_item_padding_top_with_large_font);
        int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(R.dimen.m3_navigation_rail_item_padding_bottom_with_large_font);
        float lerp = AnimationUtils.lerp(0.0f, 1.0f, 0.3f, 1.0f, MaterialResources.getFontScale(context2) - 1.0f);
        setItemPaddingTop(Math.round((float) AnimationUtils.lerp(getItemPaddingTop(), dimensionPixelOffset, lerp)));
        setItemPaddingBottom(Math.round((float) AnimationUtils.lerp(getItemPaddingBottom(), dimensionPixelOffset2, lerp)));
        obtainTintedStyledAttributes.recycle();
        applyWindowInsets();
    }
}
