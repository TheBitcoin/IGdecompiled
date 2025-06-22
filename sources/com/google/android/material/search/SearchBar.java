package com.google.android.material.search;

import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.MenuRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityManagerCompat;
import androidx.core.widget.TextViewCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ToolbarUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.mbridge.msdk.foundation.entity.CampaignEx;

public class SearchBar extends Toolbar {
    private static final int DEFAULT_SCROLL_FLAGS = 53;
    private static final int DEF_STYLE_RES = R.style.Widget_Material3_SearchBar;
    private static final String NAMESPACE_APP = "http://schemas.android.com/apk/res-auto";
    /* access modifiers changed from: private */
    @Nullable
    public final AccessibilityManager accessibilityManager;
    private MaterialShapeDrawable backgroundShape;
    @Nullable
    private View centerView;
    private final boolean defaultMarginsEnabled;
    private final Drawable defaultNavigationIcon;
    private boolean defaultScrollFlagsEnabled;
    private final boolean forceDefaultNavigationOnClickListener;
    private final boolean layoutInflated;
    private int menuResId;
    @Nullable
    private Integer navigationIconTint;
    @Nullable
    private Drawable originalNavigationIconBackground;
    private final SearchBarAnimationHelper searchBarAnimationHelper;
    private final TextView textView;
    private final boolean tintNavigationIcon;
    /* access modifiers changed from: private */
    public final AccessibilityManagerCompat.TouchExplorationStateChangeListener touchExplorationStateChangeListener;

    public static abstract class OnLoadAnimationCallback {
        public void onAnimationEnd() {
        }

        public void onAnimationStart() {
        }
    }

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            public SavedState[] newArray(int i4) {
                return new SavedState[i4];
            }

            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }
        };
        String text;

        public SavedState(Parcel parcel) {
            this(parcel, (ClassLoader) null);
        }

        public void writeToParcel(Parcel parcel, int i4) {
            super.writeToParcel(parcel, i4);
            parcel.writeString(this.text);
        }

        public SavedState(Parcel parcel, @Nullable ClassLoader classLoader) {
            super(parcel, classLoader);
            this.text = parcel.readString();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public SearchBar(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private int defaultIfZero(int i4, int i5) {
        return i4 == 0 ? i5 : i4;
    }

    private ColorStateList getCompatBackgroundColorStateList(@ColorInt int i4, @ColorInt int i5) {
        int[][] iArr = {new int[]{16842919}, new int[]{16842908}, new int[0]};
        int layer = MaterialColors.layer(i4, i5);
        return new ColorStateList(iArr, new int[]{layer, layer, i4});
    }

    private void initBackground(ShapeAppearanceModel shapeAppearanceModel, @ColorInt int i4, float f4, float f5, @ColorInt int i5) {
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(shapeAppearanceModel);
        this.backgroundShape = materialShapeDrawable;
        materialShapeDrawable.initializeElevationOverlay(getContext());
        this.backgroundShape.setElevation(f4);
        if (f5 >= 0.0f) {
            this.backgroundShape.setStroke(f5, i5);
        }
        int color = MaterialColors.getColor(this, R.attr.colorControlHighlight);
        this.backgroundShape.setFillColor(ColorStateList.valueOf(i4));
        ColorStateList valueOf = ColorStateList.valueOf(color);
        MaterialShapeDrawable materialShapeDrawable2 = this.backgroundShape;
        ViewCompat.setBackground(this, new RippleDrawable(valueOf, materialShapeDrawable2, materialShapeDrawable2));
    }

    private void initNavigationIcon() {
        Drawable drawable;
        if (getNavigationIcon() == null) {
            drawable = this.defaultNavigationIcon;
        } else {
            drawable = getNavigationIcon();
        }
        setNavigationIcon(drawable);
        setNavigationIconDecorative(true);
    }

    private void initTextView(@StyleRes int i4, String str, String str2) {
        if (i4 != -1) {
            TextViewCompat.setTextAppearance(this.textView, i4);
        }
        setText((CharSequence) str);
        setHint((CharSequence) str2);
        if (getNavigationIcon() == null) {
            MarginLayoutParamsCompat.setMarginStart((ViewGroup.MarginLayoutParams) this.textView.getLayoutParams(), getResources().getDimensionPixelSize(R.dimen.m3_searchbar_text_margin_start_no_navigation_icon));
        }
    }

    private void layoutCenterView() {
        View view = this.centerView;
        if (view != null) {
            int measuredWidth = view.getMeasuredWidth();
            int measuredWidth2 = (getMeasuredWidth() / 2) - (measuredWidth / 2);
            int i4 = measuredWidth2 + measuredWidth;
            int measuredHeight = this.centerView.getMeasuredHeight();
            int measuredHeight2 = (getMeasuredHeight() / 2) - (measuredHeight / 2);
            layoutChild(this.centerView, measuredWidth2, measuredHeight2, i4, measuredHeight2 + measuredHeight);
        }
    }

    private void layoutChild(View view, int i4, int i5, int i6, int i7) {
        if (ViewCompat.getLayoutDirection(this) == 1) {
            view.layout(getMeasuredWidth() - i6, i5, getMeasuredWidth() - i4, i7);
        } else {
            view.layout(i4, i5, i6, i7);
        }
    }

    @Nullable
    private Drawable maybeTintNavigationIcon(@Nullable Drawable drawable) {
        int i4;
        int i5;
        if (!this.tintNavigationIcon || drawable == null) {
            return drawable;
        }
        Integer num = this.navigationIconTint;
        if (num != null) {
            i4 = num.intValue();
        } else {
            if (drawable == this.defaultNavigationIcon) {
                i5 = R.attr.colorOnSurfaceVariant;
            } else {
                i5 = R.attr.colorOnSurface;
            }
            i4 = MaterialColors.getColor(this, i5);
        }
        Drawable wrap = DrawableCompat.wrap(drawable.mutate());
        DrawableCompat.setTint(wrap, i4);
        return wrap;
    }

    private void measureCenterView(int i4, int i5) {
        View view = this.centerView;
        if (view != null) {
            view.measure(i4, i5);
        }
    }

    private void setDefaultMargins() {
        if (this.defaultMarginsEnabled && (getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            Resources resources = getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.m3_searchbar_margin_horizontal);
            int dimensionPixelSize2 = resources.getDimensionPixelSize(getDefaultMarginVerticalResource());
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
            marginLayoutParams.leftMargin = defaultIfZero(marginLayoutParams.leftMargin, dimensionPixelSize);
            marginLayoutParams.topMargin = defaultIfZero(marginLayoutParams.topMargin, dimensionPixelSize2);
            marginLayoutParams.rightMargin = defaultIfZero(marginLayoutParams.rightMargin, dimensionPixelSize);
            marginLayoutParams.bottomMargin = defaultIfZero(marginLayoutParams.bottomMargin, dimensionPixelSize2);
        }
    }

    private void setHandwritingBoundsInsets() {
        int i4;
        int i5;
        if (Build.VERSION.SDK_INT >= 34) {
            boolean z4 = true;
            int i6 = 0;
            if (getLayoutDirection() != 1) {
                z4 = false;
            }
            ImageButton navigationIconButton = ToolbarUtils.getNavigationIconButton(this);
            if (navigationIconButton == null || !navigationIconButton.isClickable()) {
                i4 = 0;
            } else if (z4) {
                i4 = getWidth() - navigationIconButton.getLeft();
            } else {
                i4 = navigationIconButton.getRight();
            }
            ActionMenuView actionMenuView = ToolbarUtils.getActionMenuView(this);
            if (actionMenuView != null) {
                if (z4) {
                    i6 = actionMenuView.getRight();
                } else {
                    i6 = getWidth() - actionMenuView.getLeft();
                }
            }
            if (z4) {
                i5 = i6;
            } else {
                i5 = i4;
            }
            float f4 = (float) (-i5);
            if (!z4) {
                i4 = i6;
            }
            setHandwritingBoundsOffsets(f4, 0.0f, (float) (-i4), 0.0f);
        }
    }

    private void setNavigationIconDecorative(boolean z4) {
        Drawable drawable;
        ImageButton navigationIconButton = ToolbarUtils.getNavigationIconButton(this);
        if (navigationIconButton != null) {
            navigationIconButton.setClickable(!z4);
            navigationIconButton.setFocusable(!z4);
            Drawable background = navigationIconButton.getBackground();
            if (background != null) {
                this.originalNavigationIconBackground = background;
            }
            if (z4) {
                drawable = null;
            } else {
                drawable = this.originalNavigationIconBackground;
            }
            navigationIconButton.setBackgroundDrawable(drawable);
            setHandwritingBoundsInsets();
        }
    }

    private void setOrClearDefaultScrollFlags() {
        if (getLayoutParams() instanceof AppBarLayout.LayoutParams) {
            AppBarLayout.LayoutParams layoutParams = (AppBarLayout.LayoutParams) getLayoutParams();
            if (this.defaultScrollFlagsEnabled) {
                if (layoutParams.getScrollFlags() == 0) {
                    layoutParams.setScrollFlags(53);
                }
            } else if (layoutParams.getScrollFlags() == 53) {
                layoutParams.setScrollFlags(0);
            }
        }
    }

    private void setupTouchExplorationStateChangeListener() {
        AccessibilityManager accessibilityManager2 = this.accessibilityManager;
        if (accessibilityManager2 != null) {
            if (accessibilityManager2.isEnabled() && this.accessibilityManager.isTouchExplorationEnabled()) {
                setFocusableInTouchMode(true);
            }
            addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
                public void onViewAttachedToWindow(View view) {
                    AccessibilityManagerCompat.addTouchExplorationStateChangeListener(SearchBar.this.accessibilityManager, SearchBar.this.touchExplorationStateChangeListener);
                }

                public void onViewDetachedFromWindow(View view) {
                    AccessibilityManagerCompat.removeTouchExplorationStateChangeListener(SearchBar.this.accessibilityManager, SearchBar.this.touchExplorationStateChangeListener);
                }
            });
        }
    }

    private void validateAttributes(@Nullable AttributeSet attributeSet) {
        if (attributeSet != null) {
            if (attributeSet.getAttributeValue(NAMESPACE_APP, CampaignEx.JSON_KEY_TITLE) != null) {
                throw new UnsupportedOperationException("SearchBar does not support title. Use hint or text instead.");
            } else if (attributeSet.getAttributeValue(NAMESPACE_APP, "subtitle") != null) {
                throw new UnsupportedOperationException("SearchBar does not support subtitle. Use hint or text instead.");
            }
        }
    }

    public void addCollapseAnimationListener(@NonNull AnimatorListenerAdapter animatorListenerAdapter) {
        this.searchBarAnimationHelper.addCollapseAnimationListener(animatorListenerAdapter);
    }

    public void addExpandAnimationListener(@NonNull AnimatorListenerAdapter animatorListenerAdapter) {
        this.searchBarAnimationHelper.addExpandAnimationListener(animatorListenerAdapter);
    }

    public void addOnLoadAnimationCallback(@NonNull OnLoadAnimationCallback onLoadAnimationCallback) {
        this.searchBarAnimationHelper.addOnLoadAnimationCallback(onLoadAnimationCallback);
    }

    public void addView(View view, int i4, ViewGroup.LayoutParams layoutParams) {
        if (this.layoutInflated && this.centerView == null && !(view instanceof ActionMenuView)) {
            this.centerView = view;
            view.setAlpha(0.0f);
        }
        super.addView(view, i4, layoutParams);
    }

    public void clearText() {
        this.textView.setText("");
    }

    public boolean collapse(@NonNull View view) {
        return collapse(view, (AppBarLayout) null);
    }

    public boolean expand(@NonNull View view) {
        return expand(view, (AppBarLayout) null);
    }

    @Nullable
    public View getCenterView() {
        return this.centerView;
    }

    /* access modifiers changed from: package-private */
    public float getCompatElevation() {
        MaterialShapeDrawable materialShapeDrawable = this.backgroundShape;
        if (materialShapeDrawable != null) {
            return materialShapeDrawable.getElevation();
        }
        return ViewCompat.getElevation(this);
    }

    public float getCornerSize() {
        return this.backgroundShape.getTopLeftCornerResolvedSize();
    }

    /* access modifiers changed from: protected */
    @DimenRes
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getDefaultMarginVerticalResource() {
        return R.dimen.m3_searchbar_margin_vertical;
    }

    /* access modifiers changed from: protected */
    @DrawableRes
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getDefaultNavigationIconResource() {
        return R.drawable.ic_search_black_24;
    }

    @Nullable
    public CharSequence getHint() {
        return this.textView.getHint();
    }

    /* access modifiers changed from: package-private */
    public int getMenuResId() {
        return this.menuResId;
    }

    @ColorInt
    public int getStrokeColor() {
        return this.backgroundShape.getStrokeColor().getDefaultColor();
    }

    @Dimension
    public float getStrokeWidth() {
        return this.backgroundShape.getStrokeWidth();
    }

    @NonNull
    public CharSequence getText() {
        return this.textView.getText();
    }

    @NonNull
    public TextView getTextView() {
        return this.textView;
    }

    public void inflateMenu(@MenuRes int i4) {
        Menu menu = getMenu();
        boolean z4 = menu instanceof MenuBuilder;
        if (z4) {
            ((MenuBuilder) menu).stopDispatchingItemsChanged();
        }
        super.inflateMenu(i4);
        this.menuResId = i4;
        if (z4) {
            ((MenuBuilder) menu).startDispatchingItemsChanged();
        }
    }

    public boolean isCollapsing() {
        return this.searchBarAnimationHelper.isCollapsing();
    }

    public boolean isDefaultScrollFlagsEnabled() {
        return this.defaultScrollFlagsEnabled;
    }

    public boolean isExpanding() {
        return this.searchBarAnimationHelper.isExpanding();
    }

    public boolean isOnLoadAnimationFadeInEnabled() {
        return this.searchBarAnimationHelper.isOnLoadAnimationFadeInEnabled();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(this, this.backgroundShape);
        setDefaultMargins();
        setOrClearDefaultScrollFlags();
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(EditText.class.getCanonicalName());
        int i4 = Build.VERSION.SDK_INT;
        accessibilityNodeInfo.setEditable(isEnabled());
        CharSequence text = getText();
        boolean isEmpty = TextUtils.isEmpty(text);
        if (i4 >= 26) {
            accessibilityNodeInfo.setHintText(getHint());
            accessibilityNodeInfo.setShowingHintText(isEmpty);
        }
        if (isEmpty) {
            text = getHint();
        }
        accessibilityNodeInfo.setText(text);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        super.onLayout(z4, i4, i5, i6, i7);
        layoutCenterView();
        setHandwritingBoundsInsets();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i4, int i5) {
        super.onMeasure(i4, i5);
        measureCenterView(i4, i5);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setText((CharSequence) savedState.text);
    }

    /* access modifiers changed from: protected */
    @NonNull
    public Parcelable onSaveInstanceState() {
        String str;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        CharSequence text = getText();
        if (text == null) {
            str = null;
        } else {
            str = text.toString();
        }
        savedState.text = str;
        return savedState;
    }

    public boolean removeCollapseAnimationListener(@NonNull AnimatorListenerAdapter animatorListenerAdapter) {
        return this.searchBarAnimationHelper.removeCollapseAnimationListener(animatorListenerAdapter);
    }

    public boolean removeExpandAnimationListener(@NonNull AnimatorListenerAdapter animatorListenerAdapter) {
        return this.searchBarAnimationHelper.removeExpandAnimationListener(animatorListenerAdapter);
    }

    public boolean removeOnLoadAnimationCallback(@NonNull OnLoadAnimationCallback onLoadAnimationCallback) {
        return this.searchBarAnimationHelper.removeOnLoadAnimationCallback(onLoadAnimationCallback);
    }

    public void setCenterView(@Nullable View view) {
        View view2 = this.centerView;
        if (view2 != null) {
            removeView(view2);
            this.centerView = null;
        }
        if (view != null) {
            addView(view);
        }
    }

    public void setDefaultScrollFlagsEnabled(boolean z4) {
        this.defaultScrollFlagsEnabled = z4;
        setOrClearDefaultScrollFlags();
    }

    @RequiresApi(21)
    public void setElevation(float f4) {
        super.setElevation(f4);
        MaterialShapeDrawable materialShapeDrawable = this.backgroundShape;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setElevation(f4);
        }
    }

    public void setHint(@Nullable CharSequence charSequence) {
        this.textView.setHint(charSequence);
    }

    public void setNavigationIcon(@Nullable Drawable drawable) {
        super.setNavigationIcon(maybeTintNavigationIcon(drawable));
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        boolean z4;
        if (!this.forceDefaultNavigationOnClickListener) {
            super.setNavigationOnClickListener(onClickListener);
            if (onClickListener == null) {
                z4 = true;
            } else {
                z4 = false;
            }
            setNavigationIconDecorative(z4);
        }
    }

    public void setOnLoadAnimationFadeInEnabled(boolean z4) {
        this.searchBarAnimationHelper.setOnLoadAnimationFadeInEnabled(z4);
    }

    public void setStrokeColor(@ColorInt int i4) {
        if (getStrokeColor() != i4) {
            this.backgroundShape.setStrokeColor(ColorStateList.valueOf(i4));
        }
    }

    public void setStrokeWidth(@Dimension float f4) {
        if (getStrokeWidth() != f4) {
            this.backgroundShape.setStrokeWidth(f4);
        }
    }

    public void setSubtitle(CharSequence charSequence) {
    }

    public void setText(@Nullable CharSequence charSequence) {
        this.textView.setText(charSequence);
    }

    public void setTitle(CharSequence charSequence) {
    }

    public void startOnLoadAnimation() {
        post(new C1784b(this));
    }

    public void stopOnLoadAnimation() {
        this.searchBarAnimationHelper.stopOnLoadAnimation(this);
    }

    public static class ScrollingViewBehavior extends AppBarLayout.ScrollingViewBehavior {
        private boolean initialized = false;

        public ScrollingViewBehavior() {
        }

        private void setAppBarLayoutTransparent(AppBarLayout appBarLayout) {
            appBarLayout.setBackgroundColor(0);
            if (Build.VERSION.SDK_INT == 21) {
                appBarLayout.setOutlineProvider((ViewOutlineProvider) null);
            } else {
                appBarLayout.setTargetElevation(0.0f);
            }
        }

        public boolean onDependentViewChanged(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull View view2) {
            boolean onDependentViewChanged = super.onDependentViewChanged(coordinatorLayout, view, view2);
            if (!this.initialized && (view2 instanceof AppBarLayout)) {
                this.initialized = true;
                setAppBarLayoutTransparent((AppBarLayout) view2);
            }
            return onDependentViewChanged;
        }

        /* access modifiers changed from: protected */
        public boolean shouldHeaderOverlapScrollingChild() {
            return true;
        }

        public ScrollingViewBehavior(@NonNull Context context, @Nullable AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    public SearchBar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialSearchBarStyle);
    }

    public boolean collapse(@NonNull View view, @Nullable AppBarLayout appBarLayout) {
        return collapse(view, appBarLayout, false);
    }

    public boolean expand(@NonNull View view, @Nullable AppBarLayout appBarLayout) {
        return expand(view, appBarLayout, false);
    }

    public void setHint(@StringRes int i4) {
        this.textView.setHint(i4);
    }

    public void setText(@StringRes int i4) {
        this.textView.setText(i4);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public SearchBar(@androidx.annotation.NonNull android.content.Context r14, @androidx.annotation.Nullable android.util.AttributeSet r15, int r16) {
        /*
            r13 = this;
            r3 = r16
            int r4 = DEF_STYLE_RES
            android.content.Context r14 = com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(r14, r15, r3, r4)
            r13.<init>(r14, r15, r3)
            r14 = -1
            r13.menuResId = r14
            com.google.android.material.search.c r0 = new com.google.android.material.search.c
            r0.<init>(r13)
            r13.touchExplorationStateChangeListener = r0
            android.content.Context r0 = r13.getContext()
            r13.validateAttributes(r15)
            int r2 = r13.getDefaultNavigationIconResource()
            android.graphics.drawable.Drawable r2 = androidx.appcompat.content.res.AppCompatResources.getDrawable(r0, r2)
            r13.defaultNavigationIcon = r2
            com.google.android.material.search.SearchBarAnimationHelper r2 = new com.google.android.material.search.SearchBarAnimationHelper
            r2.<init>()
            r13.searchBarAnimationHelper = r2
            int[] r2 = com.google.android.material.R.styleable.SearchBar
            r6 = 0
            int[] r5 = new int[r6]
            r1 = r15
            android.content.res.TypedArray r2 = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(r0, r1, r2, r3, r4, r5)
            com.google.android.material.shape.ShapeAppearanceModel$Builder r1 = com.google.android.material.shape.ShapeAppearanceModel.builder((android.content.Context) r0, (android.util.AttributeSet) r15, (int) r3, (int) r4)
            com.google.android.material.shape.ShapeAppearanceModel r8 = r1.build()
            int r1 = com.google.android.material.R.styleable.SearchBar_backgroundTint
            int r9 = r2.getColor(r1, r6)
            int r1 = com.google.android.material.R.styleable.SearchBar_elevation
            r3 = 0
            float r10 = r2.getDimension(r1, r3)
            int r1 = com.google.android.material.R.styleable.SearchBar_defaultMarginsEnabled
            r3 = 1
            boolean r1 = r2.getBoolean(r1, r3)
            r13.defaultMarginsEnabled = r1
            int r1 = com.google.android.material.R.styleable.SearchBar_defaultScrollFlagsEnabled
            boolean r1 = r2.getBoolean(r1, r3)
            r13.defaultScrollFlagsEnabled = r1
            int r1 = com.google.android.material.R.styleable.SearchBar_hideNavigationIcon
            boolean r1 = r2.getBoolean(r1, r6)
            int r4 = com.google.android.material.R.styleable.SearchBar_forceDefaultNavigationOnClickListener
            boolean r4 = r2.getBoolean(r4, r6)
            r13.forceDefaultNavigationOnClickListener = r4
            int r4 = com.google.android.material.R.styleable.SearchBar_tintNavigationIcon
            boolean r4 = r2.getBoolean(r4, r3)
            r13.tintNavigationIcon = r4
            int r4 = com.google.android.material.R.styleable.SearchBar_navigationIconTint
            boolean r5 = r2.hasValue(r4)
            if (r5 == 0) goto L_0x0085
            int r4 = r2.getColor(r4, r14)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r13.navigationIconTint = r4
        L_0x0085:
            int r4 = com.google.android.material.R.styleable.SearchBar_android_textAppearance
            int r14 = r2.getResourceId(r4, r14)
            int r4 = com.google.android.material.R.styleable.SearchBar_android_text
            java.lang.String r4 = r2.getString(r4)
            int r5 = com.google.android.material.R.styleable.SearchBar_android_hint
            java.lang.String r5 = r2.getString(r5)
            int r7 = com.google.android.material.R.styleable.SearchBar_strokeWidth
            r11 = -1082130432(0xffffffffbf800000, float:-1.0)
            float r11 = r2.getDimension(r7, r11)
            int r7 = com.google.android.material.R.styleable.SearchBar_strokeColor
            int r12 = r2.getColor(r7, r6)
            r2.recycle()
            if (r1 != 0) goto L_0x00ad
            r13.initNavigationIcon()
        L_0x00ad:
            r13.setClickable(r3)
            r13.setFocusable(r3)
            android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r0)
            int r1 = com.google.android.material.R.layout.mtrl_search_bar
            r0.inflate(r1, r13)
            r13.layoutInflated = r3
            int r0 = com.google.android.material.R.id.open_search_bar_text_view
            android.view.View r0 = r13.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r13.textView = r0
            androidx.core.view.ViewCompat.setElevation(r13, r10)
            r13.initTextView(r14, r4, r5)
            r7 = r13
            r7.initBackground(r8, r9, r10, r11, r12)
            android.content.Context r14 = r13.getContext()
            java.lang.String r0 = "accessibility"
            java.lang.Object r14 = r14.getSystemService(r0)
            android.view.accessibility.AccessibilityManager r14 = (android.view.accessibility.AccessibilityManager) r14
            r13.accessibilityManager = r14
            r13.setupTouchExplorationStateChangeListener()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.search.SearchBar.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public boolean collapse(@NonNull View view, @Nullable AppBarLayout appBarLayout, boolean z4) {
        if ((view.getVisibility() != 0 || isCollapsing()) && !isExpanding()) {
            return false;
        }
        this.searchBarAnimationHelper.startCollapseAnimation(this, view, appBarLayout, z4);
        return true;
    }

    public boolean expand(@NonNull View view, @Nullable AppBarLayout appBarLayout, boolean z4) {
        if ((view.getVisibility() == 0 || isExpanding()) && !isCollapsing()) {
            return false;
        }
        this.searchBarAnimationHelper.startExpandAnimation(this, view, appBarLayout, z4);
        return true;
    }
}
