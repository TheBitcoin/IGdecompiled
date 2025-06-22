package com.google.android.material.tabs;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.BoolRes;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.Pools;
import androidx.core.view.GravityCompat;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.R;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.badge.BadgeUtils;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.shape.MaterialShapeUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

@ViewPager.DecorView
public class TabLayout extends HorizontalScrollView {
    private static final int ANIMATION_DURATION = 300;
    @Dimension(unit = 0)
    static final int DEFAULT_GAP_TEXT_ICON = 8;
    @Dimension(unit = 0)
    private static final int DEFAULT_HEIGHT = 48;
    @Dimension(unit = 0)
    private static final int DEFAULT_HEIGHT_WITH_TEXT_ICON = 72;
    private static final int DEF_STYLE_RES = R.style.Widget_Design_TabLayout;
    @Dimension(unit = 0)
    static final int FIXED_WRAP_GUTTER_MIN = 16;
    public static final int GRAVITY_CENTER = 1;
    public static final int GRAVITY_FILL = 0;
    public static final int GRAVITY_START = 2;
    public static final int INDICATOR_ANIMATION_MODE_ELASTIC = 1;
    public static final int INDICATOR_ANIMATION_MODE_FADE = 2;
    public static final int INDICATOR_ANIMATION_MODE_LINEAR = 0;
    public static final int INDICATOR_GRAVITY_BOTTOM = 0;
    public static final int INDICATOR_GRAVITY_CENTER = 1;
    public static final int INDICATOR_GRAVITY_STRETCH = 3;
    public static final int INDICATOR_GRAVITY_TOP = 2;
    private static final int INVALID_WIDTH = -1;
    private static final String LOG_TAG = "TabLayout";
    public static final int MODE_AUTO = 2;
    public static final int MODE_FIXED = 1;
    public static final int MODE_SCROLLABLE = 0;
    private static final int SELECTED_INDICATOR_HEIGHT_DEFAULT = -1;
    public static final int TAB_LABEL_VISIBILITY_LABELED = 1;
    public static final int TAB_LABEL_VISIBILITY_UNLABELED = 0;
    @Dimension(unit = 0)
    private static final int TAB_MIN_WIDTH_MARGIN = 56;
    private static final Pools.Pool<Tab> tabPool = new Pools.SynchronizedPool(16);
    private AdapterChangeListener adapterChangeListener;
    private int contentInsetStart;
    @Nullable
    private BaseOnTabSelectedListener currentVpSelectedListener;
    /* access modifiers changed from: private */
    public final int defaultTabTextAppearance;
    int indicatorPosition;
    boolean inlineLabel;
    int mode;
    private TabLayoutOnPageChangeListener pageChangeListener;
    @Nullable
    private PagerAdapter pagerAdapter;
    private DataSetObserver pagerAdapterObserver;
    private final int requestedTabMaxWidth;
    private final int requestedTabMinWidth;
    private ValueAnimator scrollAnimator;
    private final int scrollableTabMinWidth;
    @Nullable
    private BaseOnTabSelectedListener selectedListener;
    private final ArrayList<BaseOnTabSelectedListener> selectedListeners;
    @Nullable
    private Tab selectedTab;
    /* access modifiers changed from: private */
    public int selectedTabTextAppearance;
    float selectedTabTextSize;
    private boolean setupViewPagerImplicitly;
    @NonNull
    final SlidingTabIndicator slidingTabIndicator;
    final int tabBackgroundResId;
    int tabGravity;
    ColorStateList tabIconTint;
    PorterDuff.Mode tabIconTintMode;
    int tabIndicatorAnimationDuration;
    int tabIndicatorAnimationMode;
    boolean tabIndicatorFullWidth;
    int tabIndicatorGravity;
    int tabIndicatorHeight;
    /* access modifiers changed from: private */
    public TabIndicatorInterpolator tabIndicatorInterpolator;
    /* access modifiers changed from: private */
    public final TimeInterpolator tabIndicatorTimeInterpolator;
    int tabMaxWidth;
    int tabPaddingBottom;
    int tabPaddingEnd;
    int tabPaddingStart;
    int tabPaddingTop;
    ColorStateList tabRippleColorStateList;
    @NonNull
    Drawable tabSelectedIndicator;
    private int tabSelectedIndicatorColor;
    /* access modifiers changed from: private */
    public final int tabTextAppearance;
    ColorStateList tabTextColors;
    float tabTextMultiLineSize;
    float tabTextSize;
    private final Pools.Pool<TabView> tabViewPool;
    private final ArrayList<Tab> tabs;
    boolean unboundedRipple;
    @Nullable
    ViewPager viewPager;
    /* access modifiers changed from: private */
    public int viewPagerScrollState;

    private class AdapterChangeListener implements ViewPager.OnAdapterChangeListener {
        private boolean autoRefresh;

        AdapterChangeListener() {
        }

        public void onAdapterChanged(@NonNull ViewPager viewPager, @Nullable PagerAdapter pagerAdapter, @Nullable PagerAdapter pagerAdapter2) {
            TabLayout tabLayout = TabLayout.this;
            if (tabLayout.viewPager == viewPager) {
                tabLayout.setPagerAdapter(pagerAdapter2, this.autoRefresh);
            }
        }

        /* access modifiers changed from: package-private */
        public void setAutoRefresh(boolean z4) {
            this.autoRefresh = z4;
        }
    }

    @Deprecated
    public interface BaseOnTabSelectedListener<T extends Tab> {
        void onTabReselected(T t4);

        void onTabSelected(T t4);

        void onTabUnselected(T t4);
    }

    public @interface LabelVisibility {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Mode {
    }

    public interface OnTabSelectedListener extends BaseOnTabSelectedListener<Tab> {
    }

    private class PagerAdapterObserver extends DataSetObserver {
        PagerAdapterObserver() {
        }

        public void onChanged() {
            TabLayout.this.populateFromPagerAdapter();
        }

        public void onInvalidated() {
            TabLayout.this.populateFromPagerAdapter();
        }
    }

    class SlidingTabIndicator extends LinearLayout {
        ValueAnimator indicatorAnimator;
        private int layoutDirection = -1;

        SlidingTabIndicator(Context context) {
            super(context);
            setWillNotDraw(false);
        }

        private void jumpIndicatorToIndicatorPosition() {
            TabLayout tabLayout = TabLayout.this;
            if (tabLayout.indicatorPosition == -1) {
                tabLayout.indicatorPosition = tabLayout.getSelectedTabPosition();
            }
            jumpIndicatorToPosition(TabLayout.this.indicatorPosition);
        }

        private void jumpIndicatorToPosition(int i4) {
            if (TabLayout.this.viewPagerScrollState == 0 || (TabLayout.this.getTabSelectedIndicator().getBounds().left == -1 && TabLayout.this.getTabSelectedIndicator().getBounds().right == -1)) {
                View childAt = getChildAt(i4);
                TabIndicatorInterpolator access$1700 = TabLayout.this.tabIndicatorInterpolator;
                TabLayout tabLayout = TabLayout.this;
                access$1700.setIndicatorBoundsForTab(tabLayout, childAt, tabLayout.tabSelectedIndicator);
                TabLayout.this.indicatorPosition = i4;
            }
        }

        /* access modifiers changed from: private */
        public void jumpIndicatorToSelectedPosition() {
            jumpIndicatorToPosition(TabLayout.this.getSelectedTabPosition());
        }

        /* access modifiers changed from: private */
        public void tweenIndicatorPosition(View view, View view2, float f4) {
            if (view == null || view.getWidth() <= 0) {
                Drawable drawable = TabLayout.this.tabSelectedIndicator;
                drawable.setBounds(-1, drawable.getBounds().top, -1, TabLayout.this.tabSelectedIndicator.getBounds().bottom);
            } else {
                TabIndicatorInterpolator access$1700 = TabLayout.this.tabIndicatorInterpolator;
                TabLayout tabLayout = TabLayout.this;
                access$1700.updateIndicatorForOffset(tabLayout, view, view2, f4, tabLayout.tabSelectedIndicator);
            }
            ViewCompat.postInvalidateOnAnimation(this);
        }

        private void updateOrRecreateIndicatorAnimation(boolean z4, int i4, int i5) {
            TabLayout tabLayout = TabLayout.this;
            if (tabLayout.indicatorPosition != i4) {
                final View childAt = getChildAt(tabLayout.getSelectedTabPosition());
                final View childAt2 = getChildAt(i4);
                if (childAt2 == null) {
                    jumpIndicatorToSelectedPosition();
                    return;
                }
                TabLayout.this.indicatorPosition = i4;
                AnonymousClass1 r5 = new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                        SlidingTabIndicator.this.tweenIndicatorPosition(childAt, childAt2, valueAnimator.getAnimatedFraction());
                    }
                };
                if (z4) {
                    ValueAnimator valueAnimator = new ValueAnimator();
                    this.indicatorAnimator = valueAnimator;
                    valueAnimator.setInterpolator(TabLayout.this.tabIndicatorTimeInterpolator);
                    valueAnimator.setDuration((long) i5);
                    valueAnimator.setFloatValues(new float[]{0.0f, 1.0f});
                    valueAnimator.addUpdateListener(r5);
                    valueAnimator.start();
                    return;
                }
                this.indicatorAnimator.removeAllUpdateListeners();
                this.indicatorAnimator.addUpdateListener(r5);
            }
        }

        /* access modifiers changed from: package-private */
        public void animateIndicatorToPosition(int i4, int i5) {
            ValueAnimator valueAnimator = this.indicatorAnimator;
            if (!(valueAnimator == null || !valueAnimator.isRunning() || TabLayout.this.indicatorPosition == i4)) {
                this.indicatorAnimator.cancel();
            }
            updateOrRecreateIndicatorAnimation(true, i4, i5);
        }

        /* access modifiers changed from: package-private */
        public boolean childrenNeedLayout() {
            int childCount = getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                if (getChildAt(i4).getWidth() <= 0) {
                    return true;
                }
            }
            return false;
        }

        public void draw(@NonNull Canvas canvas) {
            int i4;
            int height = TabLayout.this.tabSelectedIndicator.getBounds().height();
            if (height < 0) {
                height = TabLayout.this.tabSelectedIndicator.getIntrinsicHeight();
            }
            int i5 = TabLayout.this.tabIndicatorGravity;
            if (i5 == 0) {
                i4 = getHeight() - height;
                height = getHeight();
            } else if (i5 != 1) {
                i4 = 0;
                if (i5 != 2) {
                    if (i5 != 3) {
                        height = 0;
                    } else {
                        height = getHeight();
                    }
                }
            } else {
                i4 = (getHeight() - height) / 2;
                height = (getHeight() + height) / 2;
            }
            if (TabLayout.this.tabSelectedIndicator.getBounds().width() > 0) {
                Rect bounds = TabLayout.this.tabSelectedIndicator.getBounds();
                TabLayout.this.tabSelectedIndicator.setBounds(bounds.left, i4, bounds.right, height);
                TabLayout.this.tabSelectedIndicator.draw(canvas);
            }
            super.draw(canvas);
        }

        /* access modifiers changed from: protected */
        public void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
            super.onLayout(z4, i4, i5, i6, i7);
            ValueAnimator valueAnimator = this.indicatorAnimator;
            if (valueAnimator == null || !valueAnimator.isRunning()) {
                jumpIndicatorToIndicatorPosition();
            } else {
                updateOrRecreateIndicatorAnimation(false, TabLayout.this.getSelectedTabPosition(), -1);
            }
        }

        /* access modifiers changed from: protected */
        public void onMeasure(int i4, int i5) {
            super.onMeasure(i4, i5);
            if (View.MeasureSpec.getMode(i4) == 1073741824) {
                TabLayout tabLayout = TabLayout.this;
                boolean z4 = true;
                if (tabLayout.tabGravity == 1 || tabLayout.mode == 2) {
                    int childCount = getChildCount();
                    int i6 = 0;
                    for (int i7 = 0; i7 < childCount; i7++) {
                        View childAt = getChildAt(i7);
                        if (childAt.getVisibility() == 0) {
                            i6 = Math.max(i6, childAt.getMeasuredWidth());
                        }
                    }
                    if (i6 > 0) {
                        if (i6 * childCount <= getMeasuredWidth() - (((int) ViewUtils.dpToPx(getContext(), 16)) * 2)) {
                            boolean z5 = false;
                            for (int i8 = 0; i8 < childCount; i8++) {
                                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getChildAt(i8).getLayoutParams();
                                if (layoutParams.width != i6 || layoutParams.weight != 0.0f) {
                                    layoutParams.width = i6;
                                    layoutParams.weight = 0.0f;
                                    z5 = true;
                                }
                            }
                            z4 = z5;
                        } else {
                            TabLayout tabLayout2 = TabLayout.this;
                            tabLayout2.tabGravity = 0;
                            tabLayout2.updateTabViews(false);
                        }
                        if (z4) {
                            super.onMeasure(i4, i5);
                        }
                    }
                }
            }
        }

        public void onRtlPropertiesChanged(int i4) {
            super.onRtlPropertiesChanged(i4);
            if (Build.VERSION.SDK_INT < 23 && this.layoutDirection != i4) {
                requestLayout();
                this.layoutDirection = i4;
            }
        }

        /* access modifiers changed from: package-private */
        public void setIndicatorPositionFromTabPosition(int i4, float f4) {
            TabLayout.this.indicatorPosition = Math.round(((float) i4) + f4);
            ValueAnimator valueAnimator = this.indicatorAnimator;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.indicatorAnimator.cancel();
            }
            tweenIndicatorPosition(getChildAt(i4), getChildAt(i4 + 1), f4);
        }

        /* access modifiers changed from: package-private */
        public void setSelectedIndicatorHeight(int i4) {
            Rect bounds = TabLayout.this.tabSelectedIndicator.getBounds();
            TabLayout.this.tabSelectedIndicator.setBounds(bounds.left, 0, bounds.right, i4);
            requestLayout();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface TabGravity {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface TabIndicatorAnimationMode {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface TabIndicatorGravity {
    }

    public static class TabLayoutOnPageChangeListener implements ViewPager.OnPageChangeListener {
        private int previousScrollState;
        private int scrollState;
        @NonNull
        private final WeakReference<TabLayout> tabLayoutRef;

        public TabLayoutOnPageChangeListener(TabLayout tabLayout) {
            this.tabLayoutRef = new WeakReference<>(tabLayout);
        }

        public void onPageScrollStateChanged(int i4) {
            this.previousScrollState = this.scrollState;
            this.scrollState = i4;
            TabLayout tabLayout = this.tabLayoutRef.get();
            if (tabLayout != null) {
                tabLayout.updateViewPagerScrollState(this.scrollState);
            }
        }

        public void onPageScrolled(int i4, float f4, int i5) {
            TabLayout tabLayout = this.tabLayoutRef.get();
            if (tabLayout != null) {
                int i6 = this.scrollState;
                boolean z4 = true;
                if (i6 == 2 && this.previousScrollState != 1) {
                    z4 = false;
                }
                boolean z5 = true;
                if (i6 == 2 && this.previousScrollState == 0) {
                    z5 = false;
                }
                tabLayout.setScrollPosition(i4, f4, z4, z5, false);
            }
        }

        public void onPageSelected(int i4) {
            boolean z4;
            TabLayout tabLayout = this.tabLayoutRef.get();
            if (tabLayout != null && tabLayout.getSelectedTabPosition() != i4 && i4 < tabLayout.getTabCount()) {
                int i5 = this.scrollState;
                if (i5 == 0 || (i5 == 2 && this.previousScrollState == 0)) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                tabLayout.selectTab(tabLayout.getTabAt(i4), z4);
            }
        }

        /* access modifiers changed from: package-private */
        public void reset() {
            this.scrollState = 0;
            this.previousScrollState = 0;
        }
    }

    public final class TabView extends LinearLayout {
        @Nullable
        private View badgeAnchorView;
        /* access modifiers changed from: private */
        @Nullable
        public BadgeDrawable badgeDrawable;
        @Nullable
        private Drawable baseBackgroundDrawable;
        @Nullable
        private ImageView customIconView;
        @Nullable
        private TextView customTextView;
        @Nullable
        private View customView;
        private int defaultMaxLines = 2;
        private ImageView iconView;
        private Tab tab;
        private TextView textView;

        public TabView(@NonNull Context context) {
            super(context);
            updateBackgroundDrawable(context);
            ViewCompat.setPaddingRelative(this, TabLayout.this.tabPaddingStart, TabLayout.this.tabPaddingTop, TabLayout.this.tabPaddingEnd, TabLayout.this.tabPaddingBottom);
            setGravity(17);
            setOrientation(TabLayout.this.inlineLabel ^ true ? 1 : 0);
            setClickable(true);
            ViewCompat.setPointerIcon(this, PointerIconCompat.getSystemIcon(getContext(), PointerIconCompat.TYPE_HAND));
        }

        private void addOnLayoutChangeListener(@Nullable final View view) {
            if (view != null) {
                view.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
                    public void onLayoutChange(View view, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
                        if (view.getVisibility() == 0) {
                            TabView.this.tryUpdateBadgeDrawableBounds(view);
                        }
                    }
                });
            }
        }

        private float approximateLineWidth(@NonNull Layout layout, int i4, float f4) {
            return layout.getLineWidth(i4) * (f4 / layout.getPaint().getTextSize());
        }

        private void clipViewToPaddingForBadge(boolean z4) {
            setClipChildren(z4);
            setClipToPadding(z4);
            ViewGroup viewGroup = (ViewGroup) getParent();
            if (viewGroup != null) {
                viewGroup.setClipChildren(z4);
                viewGroup.setClipToPadding(z4);
            }
        }

        @NonNull
        private FrameLayout createPreApi18BadgeAnchorRoot() {
            FrameLayout frameLayout = new FrameLayout(getContext());
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            return frameLayout;
        }

        /* access modifiers changed from: private */
        public void drawBackground(@NonNull Canvas canvas) {
            Drawable drawable = this.baseBackgroundDrawable;
            if (drawable != null) {
                drawable.setBounds(getLeft(), getTop(), getRight(), getBottom());
                this.baseBackgroundDrawable.draw(canvas);
            }
        }

        /* access modifiers changed from: private */
        @Nullable
        public BadgeDrawable getBadge() {
            return this.badgeDrawable;
        }

        @Nullable
        private FrameLayout getCustomParentForBadge(@NonNull View view) {
            if ((view == this.iconView || view == this.textView) && BadgeUtils.USE_COMPAT_PARENT) {
                return (FrameLayout) view.getParent();
            }
            return null;
        }

        /* access modifiers changed from: private */
        @NonNull
        public BadgeDrawable getOrCreateBadge() {
            if (this.badgeDrawable == null) {
                this.badgeDrawable = BadgeDrawable.create(getContext());
            }
            tryUpdateBadgeAnchor();
            BadgeDrawable badgeDrawable2 = this.badgeDrawable;
            if (badgeDrawable2 != null) {
                return badgeDrawable2;
            }
            throw new IllegalStateException("Unable to create badge");
        }

        /* access modifiers changed from: private */
        public boolean hasBadgeDrawable() {
            if (this.badgeDrawable != null) {
                return true;
            }
            return false;
        }

        private void inflateAndAddDefaultIconView() {
            ViewGroup viewGroup;
            if (BadgeUtils.USE_COMPAT_PARENT) {
                viewGroup = createPreApi18BadgeAnchorRoot();
                addView(viewGroup, 0);
            } else {
                viewGroup = this;
            }
            ImageView imageView = (ImageView) LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_icon, viewGroup, false);
            this.iconView = imageView;
            viewGroup.addView(imageView, 0);
        }

        private void inflateAndAddDefaultTextView() {
            ViewGroup viewGroup;
            if (BadgeUtils.USE_COMPAT_PARENT) {
                viewGroup = createPreApi18BadgeAnchorRoot();
                addView(viewGroup);
            } else {
                viewGroup = this;
            }
            TextView textView2 = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_text, viewGroup, false);
            this.textView = textView2;
            viewGroup.addView(textView2);
        }

        /* access modifiers changed from: private */
        public void removeBadge() {
            if (this.badgeAnchorView != null) {
                tryRemoveBadgeFromAnchor();
            }
            this.badgeDrawable = null;
        }

        private void tryAttachBadgeToAnchor(@Nullable View view) {
            if (hasBadgeDrawable() && view != null) {
                clipViewToPaddingForBadge(false);
                BadgeUtils.attachBadgeDrawable(this.badgeDrawable, view, getCustomParentForBadge(view));
                this.badgeAnchorView = view;
            }
        }

        private void tryRemoveBadgeFromAnchor() {
            if (hasBadgeDrawable()) {
                clipViewToPaddingForBadge(true);
                View view = this.badgeAnchorView;
                if (view != null) {
                    BadgeUtils.detachBadgeDrawable(this.badgeDrawable, view);
                    this.badgeAnchorView = null;
                }
            }
        }

        private void tryUpdateBadgeAnchor() {
            Tab tab2;
            Tab tab3;
            if (hasBadgeDrawable()) {
                if (this.customView != null) {
                    tryRemoveBadgeFromAnchor();
                } else if (this.iconView != null && (tab3 = this.tab) != null && tab3.getIcon() != null) {
                    View view = this.badgeAnchorView;
                    ImageView imageView = this.iconView;
                    if (view != imageView) {
                        tryRemoveBadgeFromAnchor();
                        tryAttachBadgeToAnchor(this.iconView);
                        return;
                    }
                    tryUpdateBadgeDrawableBounds(imageView);
                } else if (this.textView == null || (tab2 = this.tab) == null || tab2.getTabLabelVisibility() != 1) {
                    tryRemoveBadgeFromAnchor();
                } else {
                    View view2 = this.badgeAnchorView;
                    TextView textView2 = this.textView;
                    if (view2 != textView2) {
                        tryRemoveBadgeFromAnchor();
                        tryAttachBadgeToAnchor(this.textView);
                        return;
                    }
                    tryUpdateBadgeDrawableBounds(textView2);
                }
            }
        }

        /* access modifiers changed from: private */
        public void tryUpdateBadgeDrawableBounds(@NonNull View view) {
            if (hasBadgeDrawable() && view == this.badgeAnchorView) {
                BadgeUtils.setBadgeDrawableBounds(this.badgeDrawable, view, getCustomParentForBadge(view));
            }
        }

        /* JADX WARNING: type inference failed for: r3v0, types: [android.graphics.drawable.RippleDrawable] */
        /* access modifiers changed from: private */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void updateBackgroundDrawable(android.content.Context r6) {
            /*
                r5 = this;
                com.google.android.material.tabs.TabLayout r0 = com.google.android.material.tabs.TabLayout.this
                int r0 = r0.tabBackgroundResId
                r1 = 0
                if (r0 == 0) goto L_0x001f
                android.graphics.drawable.Drawable r6 = androidx.appcompat.content.res.AppCompatResources.getDrawable(r6, r0)
                r5.baseBackgroundDrawable = r6
                if (r6 == 0) goto L_0x0021
                boolean r6 = r6.isStateful()
                if (r6 == 0) goto L_0x0021
                android.graphics.drawable.Drawable r6 = r5.baseBackgroundDrawable
                int[] r0 = r5.getDrawableState()
                r6.setState(r0)
                goto L_0x0021
            L_0x001f:
                r5.baseBackgroundDrawable = r1
            L_0x0021:
                android.graphics.drawable.GradientDrawable r6 = new android.graphics.drawable.GradientDrawable
                r6.<init>()
                r0 = 0
                r6.setColor(r0)
                com.google.android.material.tabs.TabLayout r0 = com.google.android.material.tabs.TabLayout.this
                android.content.res.ColorStateList r0 = r0.tabRippleColorStateList
                if (r0 == 0) goto L_0x0058
                android.graphics.drawable.GradientDrawable r0 = new android.graphics.drawable.GradientDrawable
                r0.<init>()
                r2 = 925353388(0x3727c5ac, float:1.0E-5)
                r0.setCornerRadius(r2)
                r2 = -1
                r0.setColor(r2)
                com.google.android.material.tabs.TabLayout r2 = com.google.android.material.tabs.TabLayout.this
                android.content.res.ColorStateList r2 = r2.tabRippleColorStateList
                android.content.res.ColorStateList r2 = com.google.android.material.ripple.RippleUtils.convertToRippleDrawableColor(r2)
                android.graphics.drawable.RippleDrawable r3 = new android.graphics.drawable.RippleDrawable
                com.google.android.material.tabs.TabLayout r4 = com.google.android.material.tabs.TabLayout.this
                boolean r4 = r4.unboundedRipple
                if (r4 == 0) goto L_0x0050
                r6 = r1
            L_0x0050:
                if (r4 == 0) goto L_0x0053
                goto L_0x0054
            L_0x0053:
                r1 = r0
            L_0x0054:
                r3.<init>(r2, r6, r1)
                r6 = r3
            L_0x0058:
                androidx.core.view.ViewCompat.setBackground(r5, r6)
                com.google.android.material.tabs.TabLayout r6 = com.google.android.material.tabs.TabLayout.this
                r6.invalidate()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.TabView.updateBackgroundDrawable(android.content.Context):void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:23:0x005d, code lost:
            if (com.google.android.material.tabs.TabLayout.Tab.access$1500(r7.tab) == 1) goto L_0x0061;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void updateTextAndIcon(@androidx.annotation.Nullable android.widget.TextView r8, @androidx.annotation.Nullable android.widget.ImageView r9, boolean r10) {
            /*
                r7 = this;
                com.google.android.material.tabs.TabLayout$Tab r0 = r7.tab
                r1 = 0
                if (r0 == 0) goto L_0x001a
                android.graphics.drawable.Drawable r0 = r0.getIcon()
                if (r0 == 0) goto L_0x001a
                com.google.android.material.tabs.TabLayout$Tab r0 = r7.tab
                android.graphics.drawable.Drawable r0 = r0.getIcon()
                android.graphics.drawable.Drawable r0 = androidx.core.graphics.drawable.DrawableCompat.wrap(r0)
                android.graphics.drawable.Drawable r0 = r0.mutate()
                goto L_0x001b
            L_0x001a:
                r0 = r1
            L_0x001b:
                if (r0 == 0) goto L_0x002d
                com.google.android.material.tabs.TabLayout r2 = com.google.android.material.tabs.TabLayout.this
                android.content.res.ColorStateList r2 = r2.tabIconTint
                androidx.core.graphics.drawable.DrawableCompat.setTintList(r0, r2)
                com.google.android.material.tabs.TabLayout r2 = com.google.android.material.tabs.TabLayout.this
                android.graphics.PorterDuff$Mode r2 = r2.tabIconTintMode
                if (r2 == 0) goto L_0x002d
                androidx.core.graphics.drawable.DrawableCompat.setTintMode(r0, r2)
            L_0x002d:
                com.google.android.material.tabs.TabLayout$Tab r2 = r7.tab
                if (r2 == 0) goto L_0x0036
                java.lang.CharSequence r2 = r2.getText()
                goto L_0x0037
            L_0x0036:
                r2 = r1
            L_0x0037:
                r3 = 8
                r4 = 0
                if (r9 == 0) goto L_0x004e
                if (r0 == 0) goto L_0x0048
                r9.setImageDrawable(r0)
                r9.setVisibility(r4)
                r7.setVisibility(r4)
                goto L_0x004e
            L_0x0048:
                r9.setVisibility(r3)
                r9.setImageDrawable(r1)
            L_0x004e:
                boolean r0 = android.text.TextUtils.isEmpty(r2)
                if (r8 == 0) goto L_0x0078
                if (r0 != 0) goto L_0x0060
                com.google.android.material.tabs.TabLayout$Tab r5 = r7.tab
                int r5 = r5.labelVisibilityMode
                r6 = 1
                if (r5 != r6) goto L_0x0060
                goto L_0x0061
            L_0x0060:
                r6 = 0
            L_0x0061:
                if (r0 != 0) goto L_0x0065
                r5 = r2
                goto L_0x0066
            L_0x0065:
                r5 = r1
            L_0x0066:
                r8.setText(r5)
                if (r6 == 0) goto L_0x006d
                r5 = 0
                goto L_0x006f
            L_0x006d:
                r5 = 8
            L_0x006f:
                r8.setVisibility(r5)
                if (r0 != 0) goto L_0x0079
                r7.setVisibility(r4)
                goto L_0x0079
            L_0x0078:
                r6 = 0
            L_0x0079:
                if (r10 == 0) goto L_0x00bd
                if (r9 == 0) goto L_0x00bd
                android.view.ViewGroup$LayoutParams r8 = r9.getLayoutParams()
                android.view.ViewGroup$MarginLayoutParams r8 = (android.view.ViewGroup.MarginLayoutParams) r8
                if (r6 == 0) goto L_0x0095
                int r10 = r9.getVisibility()
                if (r10 != 0) goto L_0x0095
                android.content.Context r10 = r7.getContext()
                float r10 = com.google.android.material.internal.ViewUtils.dpToPx(r10, r3)
                int r10 = (int) r10
                goto L_0x0096
            L_0x0095:
                r10 = 0
            L_0x0096:
                com.google.android.material.tabs.TabLayout r3 = com.google.android.material.tabs.TabLayout.this
                boolean r3 = r3.inlineLabel
                if (r3 == 0) goto L_0x00ae
                int r3 = androidx.core.view.MarginLayoutParamsCompat.getMarginEnd(r8)
                if (r10 == r3) goto L_0x00bd
                androidx.core.view.MarginLayoutParamsCompat.setMarginEnd(r8, r10)
                r8.bottomMargin = r4
                r9.setLayoutParams(r8)
                r9.requestLayout()
                goto L_0x00bd
            L_0x00ae:
                int r3 = r8.bottomMargin
                if (r10 == r3) goto L_0x00bd
                r8.bottomMargin = r10
                androidx.core.view.MarginLayoutParamsCompat.setMarginEnd(r8, r4)
                r9.setLayoutParams(r8)
                r9.requestLayout()
            L_0x00bd:
                com.google.android.material.tabs.TabLayout$Tab r8 = r7.tab
                if (r8 == 0) goto L_0x00c5
                java.lang.CharSequence r1 = r8.contentDesc
            L_0x00c5:
                int r8 = android.os.Build.VERSION.SDK_INT
                r9 = 23
                if (r8 <= r9) goto L_0x00d2
                if (r0 != 0) goto L_0x00ce
                goto L_0x00cf
            L_0x00ce:
                r2 = r1
            L_0x00cf:
                androidx.appcompat.widget.TooltipCompat.setTooltipText(r7, r2)
            L_0x00d2:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.TabView.updateTextAndIcon(android.widget.TextView, android.widget.ImageView, boolean):void");
        }

        /* access modifiers changed from: protected */
        public void drawableStateChanged() {
            boolean z4;
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            Drawable drawable = this.baseBackgroundDrawable;
            if (drawable == null || !drawable.isStateful()) {
                z4 = false;
            } else {
                z4 = this.baseBackgroundDrawable.setState(drawableState);
            }
            if (z4) {
                invalidate();
                TabLayout.this.invalidate();
            }
        }

        /* access modifiers changed from: package-private */
        public int getContentHeight() {
            View[] viewArr = {this.textView, this.iconView, this.customView};
            int i4 = 0;
            int i5 = 0;
            boolean z4 = false;
            for (int i6 = 0; i6 < 3; i6++) {
                View view = viewArr[i6];
                if (view != null && view.getVisibility() == 0) {
                    if (z4) {
                        i5 = Math.min(i5, view.getTop());
                    } else {
                        i5 = view.getTop();
                    }
                    if (z4) {
                        i4 = Math.max(i4, view.getBottom());
                    } else {
                        i4 = view.getBottom();
                    }
                    z4 = true;
                }
            }
            return i4 - i5;
        }

        /* access modifiers changed from: package-private */
        public int getContentWidth() {
            View[] viewArr = {this.textView, this.iconView, this.customView};
            int i4 = 0;
            int i5 = 0;
            boolean z4 = false;
            for (int i6 = 0; i6 < 3; i6++) {
                View view = viewArr[i6];
                if (view != null && view.getVisibility() == 0) {
                    if (z4) {
                        i5 = Math.min(i5, view.getLeft());
                    } else {
                        i5 = view.getLeft();
                    }
                    if (z4) {
                        i4 = Math.max(i4, view.getRight());
                    } else {
                        i4 = view.getRight();
                    }
                    z4 = true;
                }
            }
            return i4 - i5;
        }

        @Nullable
        public Tab getTab() {
            return this.tab;
        }

        public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            AccessibilityNodeInfoCompat wrap = AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo);
            BadgeDrawable badgeDrawable2 = this.badgeDrawable;
            if (badgeDrawable2 != null && badgeDrawable2.isVisible()) {
                wrap.setContentDescription(this.badgeDrawable.getContentDescription());
            }
            wrap.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(0, 1, this.tab.getPosition(), 1, false, isSelected()));
            if (isSelected()) {
                wrap.setClickable(false);
                wrap.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
            }
            wrap.setRoleDescription(getResources().getString(R.string.item_view_role_description));
        }

        public void onMeasure(int i4, int i5) {
            Layout layout;
            int size = View.MeasureSpec.getSize(i4);
            int mode = View.MeasureSpec.getMode(i4);
            int tabMaxWidth = TabLayout.this.getTabMaxWidth();
            if (tabMaxWidth > 0 && (mode == 0 || size > tabMaxWidth)) {
                i4 = View.MeasureSpec.makeMeasureSpec(TabLayout.this.tabMaxWidth, Integer.MIN_VALUE);
            }
            super.onMeasure(i4, i5);
            if (this.textView != null) {
                float f4 = TabLayout.this.tabTextSize;
                int i6 = this.defaultMaxLines;
                ImageView imageView = this.iconView;
                if (imageView == null || imageView.getVisibility() != 0) {
                    TextView textView2 = this.textView;
                    if (textView2 != null && textView2.getLineCount() > 1) {
                        f4 = TabLayout.this.tabTextMultiLineSize;
                    }
                } else {
                    i6 = 1;
                }
                float textSize = this.textView.getTextSize();
                int lineCount = this.textView.getLineCount();
                int maxLines = TextViewCompat.getMaxLines(this.textView);
                int i7 = (f4 > textSize ? 1 : (f4 == textSize ? 0 : -1));
                if (i7 == 0 && (maxLines < 0 || i6 == maxLines)) {
                    return;
                }
                if (TabLayout.this.mode != 1 || i7 <= 0 || lineCount != 1 || ((layout = this.textView.getLayout()) != null && approximateLineWidth(layout, 0, f4) <= ((float) ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight())))) {
                    this.textView.setTextSize(0, f4);
                    this.textView.setMaxLines(i6);
                    super.onMeasure(i4, i5);
                }
            }
        }

        public boolean performClick() {
            boolean performClick = super.performClick();
            if (this.tab == null) {
                return performClick;
            }
            if (!performClick) {
                playSoundEffect(0);
            }
            this.tab.select();
            return true;
        }

        /* access modifiers changed from: package-private */
        public void reset() {
            setTab((Tab) null);
            setSelected(false);
        }

        public void setSelected(boolean z4) {
            isSelected();
            super.setSelected(z4);
            TextView textView2 = this.textView;
            if (textView2 != null) {
                textView2.setSelected(z4);
            }
            ImageView imageView = this.iconView;
            if (imageView != null) {
                imageView.setSelected(z4);
            }
            View view = this.customView;
            if (view != null) {
                view.setSelected(z4);
            }
        }

        /* access modifiers changed from: package-private */
        public void setTab(@Nullable Tab tab2) {
            if (tab2 != this.tab) {
                this.tab = tab2;
                update();
            }
        }

        /* access modifiers changed from: package-private */
        public final void update() {
            boolean z4;
            updateTab();
            Tab tab2 = this.tab;
            if (tab2 == null || !tab2.isSelected()) {
                z4 = false;
            } else {
                z4 = true;
            }
            setSelected(z4);
        }

        /* access modifiers changed from: package-private */
        public final void updateOrientation() {
            setOrientation(TabLayout.this.inlineLabel ^ true ? 1 : 0);
            TextView textView2 = this.customTextView;
            if (textView2 == null && this.customIconView == null) {
                updateTextAndIcon(this.textView, this.iconView, true);
            } else {
                updateTextAndIcon(textView2, this.customIconView, false);
            }
        }

        /* access modifiers changed from: package-private */
        public final void updateTab() {
            View view;
            ViewParent parent;
            Tab tab2 = this.tab;
            if (tab2 != null) {
                view = tab2.getCustomView();
            } else {
                view = null;
            }
            if (view != null) {
                ViewParent parent2 = view.getParent();
                if (parent2 != this) {
                    if (parent2 != null) {
                        ((ViewGroup) parent2).removeView(view);
                    }
                    View view2 = this.customView;
                    if (!(view2 == null || (parent = view2.getParent()) == null)) {
                        ((ViewGroup) parent).removeView(this.customView);
                    }
                    addView(view);
                }
                this.customView = view;
                TextView textView2 = this.textView;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                }
                ImageView imageView = this.iconView;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.iconView.setImageDrawable((Drawable) null);
                }
                TextView textView3 = (TextView) view.findViewById(16908308);
                this.customTextView = textView3;
                if (textView3 != null) {
                    this.defaultMaxLines = TextViewCompat.getMaxLines(textView3);
                }
                this.customIconView = (ImageView) view.findViewById(16908294);
            } else {
                View view3 = this.customView;
                if (view3 != null) {
                    removeView(view3);
                    this.customView = null;
                }
                this.customTextView = null;
                this.customIconView = null;
            }
            if (this.customView == null) {
                if (this.iconView == null) {
                    inflateAndAddDefaultIconView();
                }
                if (this.textView == null) {
                    inflateAndAddDefaultTextView();
                    this.defaultMaxLines = TextViewCompat.getMaxLines(this.textView);
                }
                TextViewCompat.setTextAppearance(this.textView, TabLayout.this.defaultTabTextAppearance);
                if (!isSelected() || TabLayout.this.selectedTabTextAppearance == -1) {
                    TextViewCompat.setTextAppearance(this.textView, TabLayout.this.tabTextAppearance);
                } else {
                    TextViewCompat.setTextAppearance(this.textView, TabLayout.this.selectedTabTextAppearance);
                }
                ColorStateList colorStateList = TabLayout.this.tabTextColors;
                if (colorStateList != null) {
                    this.textView.setTextColor(colorStateList);
                }
                updateTextAndIcon(this.textView, this.iconView, true);
                tryUpdateBadgeAnchor();
                addOnLayoutChangeListener(this.iconView);
                addOnLayoutChangeListener(this.textView);
            } else {
                TextView textView4 = this.customTextView;
                if (!(textView4 == null && this.customIconView == null)) {
                    updateTextAndIcon(textView4, this.customIconView, false);
                }
            }
            if (tab2 != null && !TextUtils.isEmpty(tab2.contentDesc)) {
                setContentDescription(tab2.contentDesc);
            }
        }
    }

    public static class ViewPagerOnTabSelectedListener implements OnTabSelectedListener {
        private final ViewPager viewPager;

        public ViewPagerOnTabSelectedListener(ViewPager viewPager2) {
            this.viewPager = viewPager2;
        }

        public void onTabReselected(Tab tab) {
        }

        public void onTabSelected(@NonNull Tab tab) {
            this.viewPager.setCurrentItem(tab.getPosition());
        }

        public void onTabUnselected(Tab tab) {
        }
    }

    public TabLayout(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private void addTabFromItemView(@NonNull TabItem tabItem) {
        Tab newTab = newTab();
        CharSequence charSequence = tabItem.text;
        if (charSequence != null) {
            newTab.setText(charSequence);
        }
        Drawable drawable = tabItem.icon;
        if (drawable != null) {
            newTab.setIcon(drawable);
        }
        int i4 = tabItem.customLayout;
        if (i4 != 0) {
            newTab.setCustomView(i4);
        }
        if (!TextUtils.isEmpty(tabItem.getContentDescription())) {
            newTab.setContentDescription(tabItem.getContentDescription());
        }
        addTab(newTab);
    }

    private void addTabView(@NonNull Tab tab) {
        TabView tabView = tab.view;
        tabView.setSelected(false);
        tabView.setActivated(false);
        this.slidingTabIndicator.addView(tabView, tab.getPosition(), createLayoutParamsForTabs());
    }

    private void addViewInternal(View view) {
        if (view instanceof TabItem) {
            addTabFromItemView((TabItem) view);
            return;
        }
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    private void animateToTab(int i4) {
        if (i4 != -1) {
            if (getWindowToken() == null || !ViewCompat.isLaidOut(this) || this.slidingTabIndicator.childrenNeedLayout()) {
                setScrollPosition(i4, 0.0f, true);
                return;
            }
            int scrollX = getScrollX();
            int calculateScrollXForTab = calculateScrollXForTab(i4, 0.0f);
            if (scrollX != calculateScrollXForTab) {
                ensureScrollAnimator();
                this.scrollAnimator.setIntValues(new int[]{scrollX, calculateScrollXForTab});
                this.scrollAnimator.start();
            }
            this.slidingTabIndicator.animateIndicatorToPosition(i4, this.tabIndicatorAnimationDuration);
        }
    }

    private void applyGravityForModeScrollable(int i4) {
        if (i4 == 0) {
            Log.w(LOG_TAG, "MODE_SCROLLABLE + GRAVITY_FILL is not supported, GRAVITY_START will be used instead");
        } else if (i4 == 1) {
            this.slidingTabIndicator.setGravity(1);
            return;
        } else if (i4 != 2) {
            return;
        }
        this.slidingTabIndicator.setGravity(GravityCompat.START);
    }

    private void applyModeAndGravity() {
        int i4;
        int i5 = this.mode;
        if (i5 == 0 || i5 == 2) {
            i4 = Math.max(0, this.contentInsetStart - this.tabPaddingStart);
        } else {
            i4 = 0;
        }
        ViewCompat.setPaddingRelative(this.slidingTabIndicator, i4, 0, 0, 0);
        int i6 = this.mode;
        if (i6 == 0) {
            applyGravityForModeScrollable(this.tabGravity);
        } else if (i6 == 1 || i6 == 2) {
            if (this.tabGravity == 2) {
                Log.w(LOG_TAG, "GRAVITY_START is not supported with the current tab mode, GRAVITY_CENTER will be used instead");
            }
            this.slidingTabIndicator.setGravity(1);
        }
        updateTabViews(true);
    }

    private int calculateScrollXForTab(int i4, float f4) {
        View childAt;
        View view;
        int i5 = this.mode;
        int i6 = 0;
        if ((i5 != 0 && i5 != 2) || (childAt = this.slidingTabIndicator.getChildAt(i4)) == null) {
            return 0;
        }
        int i7 = i4 + 1;
        if (i7 < this.slidingTabIndicator.getChildCount()) {
            view = this.slidingTabIndicator.getChildAt(i7);
        } else {
            view = null;
        }
        int width = childAt.getWidth();
        if (view != null) {
            i6 = view.getWidth();
        }
        int left = (childAt.getLeft() + (width / 2)) - (getWidth() / 2);
        int i8 = (int) (((float) (width + i6)) * 0.5f * f4);
        if (ViewCompat.getLayoutDirection(this) == 0) {
            return left + i8;
        }
        return left - i8;
    }

    private void configureTab(@NonNull Tab tab, int i4) {
        tab.setPosition(i4);
        this.tabs.add(i4, tab);
        int size = this.tabs.size();
        int i5 = -1;
        for (int i6 = i4 + 1; i6 < size; i6++) {
            if (this.tabs.get(i6).getPosition() == this.indicatorPosition) {
                i5 = i6;
            }
            this.tabs.get(i6).setPosition(i6);
        }
        this.indicatorPosition = i5;
    }

    @NonNull
    private static ColorStateList createColorStateList(int i4, int i5) {
        return new ColorStateList(new int[][]{HorizontalScrollView.SELECTED_STATE_SET, HorizontalScrollView.EMPTY_STATE_SET}, new int[]{i5, i4});
    }

    @NonNull
    private LinearLayout.LayoutParams createLayoutParamsForTabs() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        updateTabViewLayoutParams(layoutParams);
        return layoutParams;
    }

    @NonNull
    private TabView createTabView(@NonNull Tab tab) {
        TabView tabView;
        Pools.Pool<TabView> pool = this.tabViewPool;
        if (pool != null) {
            tabView = pool.acquire();
        } else {
            tabView = null;
        }
        if (tabView == null) {
            tabView = new TabView(getContext());
        }
        tabView.setTab(tab);
        tabView.setFocusable(true);
        tabView.setMinimumWidth(getTabMinWidth());
        if (TextUtils.isEmpty(tab.contentDesc)) {
            tabView.setContentDescription(tab.text);
            return tabView;
        }
        tabView.setContentDescription(tab.contentDesc);
        return tabView;
    }

    private void dispatchTabReselected(@NonNull Tab tab) {
        for (int size = this.selectedListeners.size() - 1; size >= 0; size--) {
            this.selectedListeners.get(size).onTabReselected(tab);
        }
    }

    private void dispatchTabSelected(@NonNull Tab tab) {
        for (int size = this.selectedListeners.size() - 1; size >= 0; size--) {
            this.selectedListeners.get(size).onTabSelected(tab);
        }
    }

    private void dispatchTabUnselected(@NonNull Tab tab) {
        for (int size = this.selectedListeners.size() - 1; size >= 0; size--) {
            this.selectedListeners.get(size).onTabUnselected(tab);
        }
    }

    private void ensureScrollAnimator() {
        if (this.scrollAnimator == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.scrollAnimator = valueAnimator;
            valueAnimator.setInterpolator(this.tabIndicatorTimeInterpolator);
            this.scrollAnimator.setDuration((long) this.tabIndicatorAnimationDuration);
            this.scrollAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                    TabLayout.this.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
                }
            });
        }
    }

    @Dimension(unit = 0)
    private int getDefaultHeight() {
        int size = this.tabs.size();
        int i4 = 0;
        while (i4 < size) {
            Tab tab = this.tabs.get(i4);
            if (tab == null || tab.getIcon() == null || TextUtils.isEmpty(tab.getText())) {
                i4++;
            } else if (!this.inlineLabel) {
                return 72;
            } else {
                return 48;
            }
        }
        return 48;
    }

    private int getTabMinWidth() {
        int i4 = this.requestedTabMinWidth;
        if (i4 != -1) {
            return i4;
        }
        int i5 = this.mode;
        if (i5 == 0 || i5 == 2) {
            return this.scrollableTabMinWidth;
        }
        return 0;
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.slidingTabIndicator.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    private boolean isScrollingEnabled() {
        if (getTabMode() == 0 || getTabMode() == 2) {
            return true;
        }
        return false;
    }

    private void removeTabViewAt(int i4) {
        TabView tabView = (TabView) this.slidingTabIndicator.getChildAt(i4);
        this.slidingTabIndicator.removeViewAt(i4);
        if (tabView != null) {
            tabView.reset();
            this.tabViewPool.release(tabView);
        }
        requestLayout();
    }

    private void setSelectedTabView(int i4) {
        boolean z4;
        boolean z5;
        int childCount = this.slidingTabIndicator.getChildCount();
        if (i4 < childCount) {
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = this.slidingTabIndicator.getChildAt(i5);
                boolean z6 = true;
                if ((i5 != i4 || childAt.isSelected()) && (i5 == i4 || !childAt.isSelected())) {
                    if (i5 == i4) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    childAt.setSelected(z5);
                    if (i5 != i4) {
                        z6 = false;
                    }
                    childAt.setActivated(z6);
                } else {
                    if (i5 == i4) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    childAt.setSelected(z4);
                    if (i5 != i4) {
                        z6 = false;
                    }
                    childAt.setActivated(z6);
                    if (childAt instanceof TabView) {
                        ((TabView) childAt).updateTab();
                    }
                }
            }
        }
    }

    private void updateAllTabs() {
        int size = this.tabs.size();
        for (int i4 = 0; i4 < size; i4++) {
            this.tabs.get(i4).updateView();
        }
    }

    private void updateTabViewLayoutParams(@NonNull LinearLayout.LayoutParams layoutParams) {
        if (this.mode == 1 && this.tabGravity == 0) {
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
            return;
        }
        layoutParams.width = -2;
        layoutParams.weight = 0.0f;
    }

    public void addOnTabSelectedListener(@NonNull OnTabSelectedListener onTabSelectedListener) {
        addOnTabSelectedListener((BaseOnTabSelectedListener) onTabSelectedListener);
    }

    public void addTab(@NonNull Tab tab) {
        addTab(tab, this.tabs.isEmpty());
    }

    public void addView(View view) {
        addViewInternal(view);
    }

    public void clearOnTabSelectedListeners() {
        this.selectedListeners.clear();
    }

    /* access modifiers changed from: protected */
    public Tab createTabFromPool() {
        Tab acquire = tabPool.acquire();
        if (acquire == null) {
            return new Tab();
        }
        return acquire;
    }

    public int getSelectedTabPosition() {
        Tab tab = this.selectedTab;
        if (tab != null) {
            return tab.getPosition();
        }
        return -1;
    }

    @Nullable
    public Tab getTabAt(int i4) {
        if (i4 < 0 || i4 >= getTabCount()) {
            return null;
        }
        return this.tabs.get(i4);
    }

    public int getTabCount() {
        return this.tabs.size();
    }

    public int getTabGravity() {
        return this.tabGravity;
    }

    @Nullable
    public ColorStateList getTabIconTint() {
        return this.tabIconTint;
    }

    public int getTabIndicatorAnimationMode() {
        return this.tabIndicatorAnimationMode;
    }

    public int getTabIndicatorGravity() {
        return this.tabIndicatorGravity;
    }

    /* access modifiers changed from: package-private */
    public int getTabMaxWidth() {
        return this.tabMaxWidth;
    }

    public int getTabMode() {
        return this.mode;
    }

    @Nullable
    public ColorStateList getTabRippleColor() {
        return this.tabRippleColorStateList;
    }

    @NonNull
    public Drawable getTabSelectedIndicator() {
        return this.tabSelectedIndicator;
    }

    @Nullable
    public ColorStateList getTabTextColors() {
        return this.tabTextColors;
    }

    public boolean hasUnboundedRipple() {
        return this.unboundedRipple;
    }

    public boolean isInlineLabel() {
        return this.inlineLabel;
    }

    public boolean isTabIndicatorFullWidth() {
        return this.tabIndicatorFullWidth;
    }

    @NonNull
    public Tab newTab() {
        Tab createTabFromPool = createTabFromPool();
        createTabFromPool.parent = this;
        createTabFromPool.view = createTabView(createTabFromPool);
        if (createTabFromPool.id != -1) {
            createTabFromPool.view.setId(createTabFromPool.id);
        }
        return createTabFromPool;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(this);
        if (this.viewPager == null) {
            ViewParent parent = getParent();
            if (parent instanceof ViewPager) {
                setupWithViewPager((ViewPager) parent, true, true);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.setupViewPagerImplicitly) {
            setupWithViewPager((ViewPager) null);
            this.setupViewPagerImplicitly = false;
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(@NonNull Canvas canvas) {
        for (int i4 = 0; i4 < this.slidingTabIndicator.getChildCount(); i4++) {
            View childAt = this.slidingTabIndicator.getChildAt(i4);
            if (childAt instanceof TabView) {
                ((TabView) childAt).drawBackground(canvas);
            }
        }
        super.onDraw(canvas);
    }

    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, getTabCount(), false, 1));
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!isScrollingEnabled() || !super.onInterceptTouchEvent(motionEvent)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i4, int i5) {
        int round = Math.round(ViewUtils.dpToPx(getContext(), getDefaultHeight()));
        int mode2 = View.MeasureSpec.getMode(i5);
        if (mode2 != Integer.MIN_VALUE) {
            if (mode2 == 0) {
                i5 = View.MeasureSpec.makeMeasureSpec(round + getPaddingTop() + getPaddingBottom(), 1073741824);
            }
        } else if (getChildCount() == 1 && View.MeasureSpec.getSize(i5) >= round) {
            getChildAt(0).setMinimumHeight(round);
        }
        int size = View.MeasureSpec.getSize(i4);
        if (View.MeasureSpec.getMode(i4) != 0) {
            int i6 = this.requestedTabMaxWidth;
            if (i6 <= 0) {
                i6 = (int) (((float) size) - ViewUtils.dpToPx(getContext(), 56));
            }
            this.tabMaxWidth = i6;
        }
        super.onMeasure(i4, i5);
        if (getChildCount() == 1) {
            View childAt = getChildAt(0);
            int i7 = this.mode;
            if (i7 != 0) {
                if (i7 == 1) {
                    if (childAt.getMeasuredWidth() == getMeasuredWidth()) {
                        return;
                    }
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), ViewGroup.getChildMeasureSpec(i5, getPaddingTop() + getPaddingBottom(), childAt.getLayoutParams().height));
                } else if (i7 != 2) {
                    return;
                }
            }
            if (childAt.getMeasuredWidth() >= getMeasuredWidth()) {
                return;
            }
            childAt.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), ViewGroup.getChildMeasureSpec(i5, getPaddingTop() + getPaddingBottom(), childAt.getLayoutParams().height));
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() != 8 || isScrollingEnabled()) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void populateFromPagerAdapter() {
        int currentItem;
        removeAllTabs();
        PagerAdapter pagerAdapter2 = this.pagerAdapter;
        if (pagerAdapter2 != null) {
            int count = pagerAdapter2.getCount();
            for (int i4 = 0; i4 < count; i4++) {
                addTab(newTab().setText(this.pagerAdapter.getPageTitle(i4)), false);
            }
            ViewPager viewPager2 = this.viewPager;
            if (viewPager2 != null && count > 0 && (currentItem = viewPager2.getCurrentItem()) != getSelectedTabPosition() && currentItem < getTabCount()) {
                selectTab(getTabAt(currentItem));
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean releaseFromTabPool(Tab tab) {
        return tabPool.release(tab);
    }

    public void removeAllTabs() {
        for (int childCount = this.slidingTabIndicator.getChildCount() - 1; childCount >= 0; childCount--) {
            removeTabViewAt(childCount);
        }
        Iterator<Tab> it = this.tabs.iterator();
        while (it.hasNext()) {
            Tab next = it.next();
            it.remove();
            next.reset();
            releaseFromTabPool(next);
        }
        this.selectedTab = null;
    }

    public void removeOnTabSelectedListener(@NonNull OnTabSelectedListener onTabSelectedListener) {
        removeOnTabSelectedListener((BaseOnTabSelectedListener) onTabSelectedListener);
    }

    public void removeTab(@NonNull Tab tab) {
        if (tab.parent == this) {
            removeTabAt(tab.getPosition());
            return;
        }
        throw new IllegalArgumentException("Tab does not belong to this TabLayout.");
    }

    public void removeTabAt(int i4) {
        int i5;
        Tab tab;
        Tab tab2 = this.selectedTab;
        if (tab2 != null) {
            i5 = tab2.getPosition();
        } else {
            i5 = 0;
        }
        removeTabViewAt(i4);
        Tab remove = this.tabs.remove(i4);
        if (remove != null) {
            remove.reset();
            releaseFromTabPool(remove);
        }
        int size = this.tabs.size();
        int i6 = -1;
        for (int i7 = i4; i7 < size; i7++) {
            if (this.tabs.get(i7).getPosition() == this.indicatorPosition) {
                i6 = i7;
            }
            this.tabs.get(i7).setPosition(i7);
        }
        this.indicatorPosition = i6;
        if (i5 == i4) {
            if (this.tabs.isEmpty()) {
                tab = null;
            } else {
                tab = this.tabs.get(Math.max(0, i4 - 1));
            }
            selectTab(tab);
        }
    }

    public void selectTab(@Nullable Tab tab) {
        selectTab(tab, true);
    }

    @RequiresApi(21)
    public void setElevation(float f4) {
        super.setElevation(f4);
        MaterialShapeUtils.setElevation(this, f4);
    }

    public void setInlineLabel(boolean z4) {
        if (this.inlineLabel != z4) {
            this.inlineLabel = z4;
            for (int i4 = 0; i4 < this.slidingTabIndicator.getChildCount(); i4++) {
                View childAt = this.slidingTabIndicator.getChildAt(i4);
                if (childAt instanceof TabView) {
                    ((TabView) childAt).updateOrientation();
                }
            }
            applyModeAndGravity();
        }
    }

    public void setInlineLabelResource(@BoolRes int i4) {
        setInlineLabel(getResources().getBoolean(i4));
    }

    @Deprecated
    public void setOnTabSelectedListener(@Nullable OnTabSelectedListener onTabSelectedListener) {
        setOnTabSelectedListener((BaseOnTabSelectedListener) onTabSelectedListener);
    }

    /* access modifiers changed from: package-private */
    public void setPagerAdapter(@Nullable PagerAdapter pagerAdapter2, boolean z4) {
        DataSetObserver dataSetObserver;
        PagerAdapter pagerAdapter3 = this.pagerAdapter;
        if (!(pagerAdapter3 == null || (dataSetObserver = this.pagerAdapterObserver) == null)) {
            pagerAdapter3.unregisterDataSetObserver(dataSetObserver);
        }
        this.pagerAdapter = pagerAdapter2;
        if (z4 && pagerAdapter2 != null) {
            if (this.pagerAdapterObserver == null) {
                this.pagerAdapterObserver = new PagerAdapterObserver();
            }
            pagerAdapter2.registerDataSetObserver(this.pagerAdapterObserver);
        }
        populateFromPagerAdapter();
    }

    /* access modifiers changed from: package-private */
    public void setScrollAnimatorListener(Animator.AnimatorListener animatorListener) {
        ensureScrollAnimator();
        this.scrollAnimator.addListener(animatorListener);
    }

    public void setScrollPosition(int i4, float f4, boolean z4) {
        setScrollPosition(i4, f4, z4, true);
    }

    public void setSelectedTabIndicator(@Nullable Drawable drawable) {
        if (drawable == null) {
            drawable = new GradientDrawable();
        }
        Drawable mutate = DrawableCompat.wrap(drawable).mutate();
        this.tabSelectedIndicator = mutate;
        DrawableUtils.setTint(mutate, this.tabSelectedIndicatorColor);
        int i4 = this.tabIndicatorHeight;
        if (i4 == -1) {
            i4 = this.tabSelectedIndicator.getIntrinsicHeight();
        }
        this.slidingTabIndicator.setSelectedIndicatorHeight(i4);
    }

    public void setSelectedTabIndicatorColor(@ColorInt int i4) {
        this.tabSelectedIndicatorColor = i4;
        DrawableUtils.setTint(this.tabSelectedIndicator, i4);
        updateTabViews(false);
    }

    public void setSelectedTabIndicatorGravity(int i4) {
        if (this.tabIndicatorGravity != i4) {
            this.tabIndicatorGravity = i4;
            ViewCompat.postInvalidateOnAnimation(this.slidingTabIndicator);
        }
    }

    @Deprecated
    public void setSelectedTabIndicatorHeight(int i4) {
        this.tabIndicatorHeight = i4;
        this.slidingTabIndicator.setSelectedIndicatorHeight(i4);
    }

    public void setTabGravity(int i4) {
        if (this.tabGravity != i4) {
            this.tabGravity = i4;
            applyModeAndGravity();
        }
    }

    public void setTabIconTint(@Nullable ColorStateList colorStateList) {
        if (this.tabIconTint != colorStateList) {
            this.tabIconTint = colorStateList;
            updateAllTabs();
        }
    }

    public void setTabIconTintResource(@ColorRes int i4) {
        setTabIconTint(AppCompatResources.getColorStateList(getContext(), i4));
    }

    public void setTabIndicatorAnimationMode(int i4) {
        this.tabIndicatorAnimationMode = i4;
        if (i4 == 0) {
            this.tabIndicatorInterpolator = new TabIndicatorInterpolator();
        } else if (i4 == 1) {
            this.tabIndicatorInterpolator = new ElasticTabIndicatorInterpolator();
        } else if (i4 == 2) {
            this.tabIndicatorInterpolator = new FadeTabIndicatorInterpolator();
        } else {
            throw new IllegalArgumentException(i4 + " is not a valid TabIndicatorAnimationMode");
        }
    }

    public void setTabIndicatorFullWidth(boolean z4) {
        this.tabIndicatorFullWidth = z4;
        this.slidingTabIndicator.jumpIndicatorToSelectedPosition();
        ViewCompat.postInvalidateOnAnimation(this.slidingTabIndicator);
    }

    public void setTabMode(int i4) {
        if (i4 != this.mode) {
            this.mode = i4;
            applyModeAndGravity();
        }
    }

    public void setTabRippleColor(@Nullable ColorStateList colorStateList) {
        if (this.tabRippleColorStateList != colorStateList) {
            this.tabRippleColorStateList = colorStateList;
            for (int i4 = 0; i4 < this.slidingTabIndicator.getChildCount(); i4++) {
                View childAt = this.slidingTabIndicator.getChildAt(i4);
                if (childAt instanceof TabView) {
                    ((TabView) childAt).updateBackgroundDrawable(getContext());
                }
            }
        }
    }

    public void setTabRippleColorResource(@ColorRes int i4) {
        setTabRippleColor(AppCompatResources.getColorStateList(getContext(), i4));
    }

    public void setTabTextColors(@Nullable ColorStateList colorStateList) {
        if (this.tabTextColors != colorStateList) {
            this.tabTextColors = colorStateList;
            updateAllTabs();
        }
    }

    @Deprecated
    public void setTabsFromPagerAdapter(@Nullable PagerAdapter pagerAdapter2) {
        setPagerAdapter(pagerAdapter2, false);
    }

    public void setUnboundedRipple(boolean z4) {
        if (this.unboundedRipple != z4) {
            this.unboundedRipple = z4;
            for (int i4 = 0; i4 < this.slidingTabIndicator.getChildCount(); i4++) {
                View childAt = this.slidingTabIndicator.getChildAt(i4);
                if (childAt instanceof TabView) {
                    ((TabView) childAt).updateBackgroundDrawable(getContext());
                }
            }
        }
    }

    public void setUnboundedRippleResource(@BoolRes int i4) {
        setUnboundedRipple(getResources().getBoolean(i4));
    }

    public void setupWithViewPager(@Nullable ViewPager viewPager2) {
        setupWithViewPager(viewPager2, true);
    }

    public boolean shouldDelayChildPressedState() {
        if (getTabScrollRange() > 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void updateTabViews(boolean z4) {
        for (int i4 = 0; i4 < this.slidingTabIndicator.getChildCount(); i4++) {
            View childAt = this.slidingTabIndicator.getChildAt(i4);
            childAt.setMinimumWidth(getTabMinWidth());
            updateTabViewLayoutParams((LinearLayout.LayoutParams) childAt.getLayoutParams());
            if (z4) {
                childAt.requestLayout();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void updateViewPagerScrollState(int i4) {
        this.viewPagerScrollState = i4;
    }

    public static class Tab {
        public static final int INVALID_POSITION = -1;
        /* access modifiers changed from: private */
        @Nullable
        public CharSequence contentDesc;
        @Nullable
        private View customView;
        @Nullable
        private Drawable icon;
        /* access modifiers changed from: private */
        public int id = -1;
        /* access modifiers changed from: private */
        @LabelVisibility
        public int labelVisibilityMode = 1;
        @Nullable
        public TabLayout parent;
        private int position = -1;
        @Nullable
        private Object tag;
        /* access modifiers changed from: private */
        @Nullable
        public CharSequence text;
        @NonNull
        public TabView view;

        @Nullable
        public BadgeDrawable getBadge() {
            return this.view.getBadge();
        }

        @Nullable
        public CharSequence getContentDescription() {
            TabView tabView = this.view;
            if (tabView == null) {
                return null;
            }
            return tabView.getContentDescription();
        }

        @Nullable
        public View getCustomView() {
            return this.customView;
        }

        @Nullable
        public Drawable getIcon() {
            return this.icon;
        }

        public int getId() {
            return this.id;
        }

        @NonNull
        public BadgeDrawable getOrCreateBadge() {
            return this.view.getOrCreateBadge();
        }

        public int getPosition() {
            return this.position;
        }

        @LabelVisibility
        public int getTabLabelVisibility() {
            return this.labelVisibilityMode;
        }

        @Nullable
        public Object getTag() {
            return this.tag;
        }

        @Nullable
        public CharSequence getText() {
            return this.text;
        }

        public boolean isSelected() {
            TabLayout tabLayout = this.parent;
            if (tabLayout != null) {
                int selectedTabPosition = tabLayout.getSelectedTabPosition();
                if (selectedTabPosition == -1 || selectedTabPosition != this.position) {
                    return false;
                }
                return true;
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        public void removeBadge() {
            this.view.removeBadge();
        }

        /* access modifiers changed from: package-private */
        public void reset() {
            this.parent = null;
            this.view = null;
            this.tag = null;
            this.icon = null;
            this.id = -1;
            this.text = null;
            this.contentDesc = null;
            this.position = -1;
            this.customView = null;
        }

        public void select() {
            TabLayout tabLayout = this.parent;
            if (tabLayout != null) {
                tabLayout.selectTab(this);
                return;
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        @NonNull
        public Tab setContentDescription(@StringRes int i4) {
            TabLayout tabLayout = this.parent;
            if (tabLayout != null) {
                return setContentDescription(tabLayout.getResources().getText(i4));
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        @NonNull
        public Tab setCustomView(@Nullable View view2) {
            this.customView = view2;
            updateView();
            return this;
        }

        @NonNull
        public Tab setIcon(@Nullable Drawable drawable) {
            this.icon = drawable;
            TabLayout tabLayout = this.parent;
            if (tabLayout.tabGravity == 1 || tabLayout.mode == 2) {
                tabLayout.updateTabViews(true);
            }
            updateView();
            if (BadgeUtils.USE_COMPAT_PARENT && this.view.hasBadgeDrawable() && this.view.badgeDrawable.isVisible()) {
                this.view.invalidate();
            }
            return this;
        }

        @NonNull
        public Tab setId(int i4) {
            this.id = i4;
            TabView tabView = this.view;
            if (tabView != null) {
                tabView.setId(i4);
            }
            return this;
        }

        /* access modifiers changed from: package-private */
        public void setPosition(int i4) {
            this.position = i4;
        }

        @NonNull
        public Tab setTabLabelVisibility(@LabelVisibility int i4) {
            this.labelVisibilityMode = i4;
            TabLayout tabLayout = this.parent;
            if (tabLayout.tabGravity == 1 || tabLayout.mode == 2) {
                tabLayout.updateTabViews(true);
            }
            updateView();
            if (BadgeUtils.USE_COMPAT_PARENT && this.view.hasBadgeDrawable() && this.view.badgeDrawable.isVisible()) {
                this.view.invalidate();
            }
            return this;
        }

        @NonNull
        public Tab setTag(@Nullable Object obj) {
            this.tag = obj;
            return this;
        }

        @NonNull
        public Tab setText(@Nullable CharSequence charSequence) {
            if (TextUtils.isEmpty(this.contentDesc) && !TextUtils.isEmpty(charSequence)) {
                this.view.setContentDescription(charSequence);
            }
            this.text = charSequence;
            updateView();
            return this;
        }

        /* access modifiers changed from: package-private */
        public void updateView() {
            TabView tabView = this.view;
            if (tabView != null) {
                tabView.update();
            }
        }

        @NonNull
        public Tab setCustomView(@LayoutRes int i4) {
            return setCustomView(LayoutInflater.from(this.view.getContext()).inflate(i4, this.view, false));
        }

        @NonNull
        public Tab setContentDescription(@Nullable CharSequence charSequence) {
            this.contentDesc = charSequence;
            updateView();
            return this;
        }

        @NonNull
        public Tab setText(@StringRes int i4) {
            TabLayout tabLayout = this.parent;
            if (tabLayout != null) {
                return setText(tabLayout.getResources().getText(i4));
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        @NonNull
        public Tab setIcon(@DrawableRes int i4) {
            TabLayout tabLayout = this.parent;
            if (tabLayout != null) {
                return setIcon(AppCompatResources.getDrawable(tabLayout.getContext(), i4));
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }
    }

    public TabLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.tabStyle);
    }

    @Deprecated
    public void addOnTabSelectedListener(@Nullable BaseOnTabSelectedListener baseOnTabSelectedListener) {
        if (!this.selectedListeners.contains(baseOnTabSelectedListener)) {
            this.selectedListeners.add(baseOnTabSelectedListener);
        }
    }

    public void addTab(@NonNull Tab tab, int i4) {
        addTab(tab, i4, this.tabs.isEmpty());
    }

    public void addView(View view, int i4) {
        addViewInternal(view);
    }

    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    @Deprecated
    public void removeOnTabSelectedListener(@Nullable BaseOnTabSelectedListener baseOnTabSelectedListener) {
        this.selectedListeners.remove(baseOnTabSelectedListener);
    }

    public void selectTab(@Nullable Tab tab, boolean z4) {
        Tab tab2 = this.selectedTab;
        if (tab2 != tab) {
            int position = tab != null ? tab.getPosition() : -1;
            if (z4) {
                if ((tab2 == null || tab2.getPosition() == -1) && position != -1) {
                    setScrollPosition(position, 0.0f, true);
                } else {
                    animateToTab(position);
                }
                if (position != -1) {
                    setSelectedTabView(position);
                }
            }
            this.selectedTab = tab;
            if (!(tab2 == null || tab2.parent == null)) {
                dispatchTabUnselected(tab2);
            }
            if (tab != null) {
                dispatchTabSelected(tab);
            }
        } else if (tab2 != null) {
            dispatchTabReselected(tab);
            animateToTab(tab.getPosition());
        }
    }

    @Deprecated
    public void setOnTabSelectedListener(@Nullable BaseOnTabSelectedListener baseOnTabSelectedListener) {
        BaseOnTabSelectedListener baseOnTabSelectedListener2 = this.selectedListener;
        if (baseOnTabSelectedListener2 != null) {
            removeOnTabSelectedListener(baseOnTabSelectedListener2);
        }
        this.selectedListener = baseOnTabSelectedListener;
        if (baseOnTabSelectedListener != null) {
            addOnTabSelectedListener(baseOnTabSelectedListener);
        }
    }

    public void setScrollPosition(int i4, float f4, boolean z4, boolean z5) {
        setScrollPosition(i4, f4, z4, z5, true);
    }

    public void setupWithViewPager(@Nullable ViewPager viewPager2, boolean z4) {
        setupWithViewPager(viewPager2, z4, false);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public TabLayout(@androidx.annotation.NonNull android.content.Context r10, @androidx.annotation.Nullable android.util.AttributeSet r11, int r12) {
        /*
            r9 = this;
            int r4 = DEF_STYLE_RES
            android.content.Context r10 = com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(r10, r11, r12, r4)
            r9.<init>(r10, r11, r12)
            r10 = -1
            r9.indicatorPosition = r10
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r9.tabs = r0
            r9.selectedTabTextAppearance = r10
            r6 = 0
            r9.tabSelectedIndicatorColor = r6
            r0 = 2147483647(0x7fffffff, float:NaN)
            r9.tabMaxWidth = r0
            r9.tabIndicatorHeight = r10
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r9.selectedListeners = r0
            androidx.core.util.Pools$SimplePool r0 = new androidx.core.util.Pools$SimplePool
            r1 = 12
            r0.<init>(r1)
            r9.tabViewPool = r0
            android.content.Context r0 = r9.getContext()
            r9.setHorizontalScrollBarEnabled(r6)
            com.google.android.material.tabs.TabLayout$SlidingTabIndicator r7 = new com.google.android.material.tabs.TabLayout$SlidingTabIndicator
            r7.<init>(r0)
            r9.slidingTabIndicator = r7
            android.widget.FrameLayout$LayoutParams r1 = new android.widget.FrameLayout$LayoutParams
            r2 = -2
            r1.<init>(r2, r10)
            super.addView(r7, r6, r1)
            int[] r2 = com.google.android.material.R.styleable.TabLayout
            int r8 = com.google.android.material.R.styleable.TabLayout_tabTextAppearance
            int[] r5 = new int[]{r8}
            r1 = r11
            r3 = r12
            android.content.res.TypedArray r11 = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(r0, r1, r2, r3, r4, r5)
            android.graphics.drawable.Drawable r12 = r9.getBackground()
            android.content.res.ColorStateList r12 = com.google.android.material.drawable.DrawableUtils.getColorStateListOrNull(r12)
            if (r12 == 0) goto L_0x0073
            com.google.android.material.shape.MaterialShapeDrawable r1 = new com.google.android.material.shape.MaterialShapeDrawable
            r1.<init>()
            r1.setFillColor(r12)
            r1.initializeElevationOverlay(r0)
            float r12 = androidx.core.view.ViewCompat.getElevation(r9)
            r1.setElevation(r12)
            androidx.core.view.ViewCompat.setBackground(r9, r1)
        L_0x0073:
            int r12 = com.google.android.material.R.styleable.TabLayout_tabIndicator
            android.graphics.drawable.Drawable r12 = com.google.android.material.resources.MaterialResources.getDrawable(r0, r11, r12)
            r9.setSelectedTabIndicator((android.graphics.drawable.Drawable) r12)
            int r12 = com.google.android.material.R.styleable.TabLayout_tabIndicatorColor
            int r12 = r11.getColor(r12, r6)
            r9.setSelectedTabIndicatorColor(r12)
            int r12 = com.google.android.material.R.styleable.TabLayout_tabIndicatorHeight
            int r12 = r11.getDimensionPixelSize(r12, r10)
            r7.setSelectedIndicatorHeight(r12)
            int r12 = com.google.android.material.R.styleable.TabLayout_tabIndicatorGravity
            int r12 = r11.getInt(r12, r6)
            r9.setSelectedTabIndicatorGravity(r12)
            int r12 = com.google.android.material.R.styleable.TabLayout_tabIndicatorAnimationMode
            int r12 = r11.getInt(r12, r6)
            r9.setTabIndicatorAnimationMode(r12)
            int r12 = com.google.android.material.R.styleable.TabLayout_tabIndicatorFullWidth
            r1 = 1
            boolean r12 = r11.getBoolean(r12, r1)
            r9.setTabIndicatorFullWidth(r12)
            int r12 = com.google.android.material.R.styleable.TabLayout_tabPadding
            int r12 = r11.getDimensionPixelSize(r12, r6)
            r9.tabPaddingBottom = r12
            r9.tabPaddingEnd = r12
            r9.tabPaddingTop = r12
            r9.tabPaddingStart = r12
            int r2 = com.google.android.material.R.styleable.TabLayout_tabPaddingStart
            int r12 = r11.getDimensionPixelSize(r2, r12)
            r9.tabPaddingStart = r12
            int r12 = com.google.android.material.R.styleable.TabLayout_tabPaddingTop
            int r2 = r9.tabPaddingTop
            int r12 = r11.getDimensionPixelSize(r12, r2)
            r9.tabPaddingTop = r12
            int r12 = com.google.android.material.R.styleable.TabLayout_tabPaddingEnd
            int r2 = r9.tabPaddingEnd
            int r12 = r11.getDimensionPixelSize(r12, r2)
            r9.tabPaddingEnd = r12
            int r12 = com.google.android.material.R.styleable.TabLayout_tabPaddingBottom
            int r2 = r9.tabPaddingBottom
            int r12 = r11.getDimensionPixelSize(r12, r2)
            r9.tabPaddingBottom = r12
            boolean r12 = com.google.android.material.internal.ThemeEnforcement.isMaterial3Theme(r0)
            if (r12 == 0) goto L_0x00e9
            int r12 = com.google.android.material.R.attr.textAppearanceTitleSmall
            r9.defaultTabTextAppearance = r12
            goto L_0x00ed
        L_0x00e9:
            int r12 = com.google.android.material.R.attr.textAppearanceButton
            r9.defaultTabTextAppearance = r12
        L_0x00ed:
            int r12 = com.google.android.material.R.style.TextAppearance_Design_Tab
            int r12 = r11.getResourceId(r8, r12)
            r9.tabTextAppearance = r12
            int[] r2 = androidx.appcompat.R.styleable.TextAppearance
            android.content.res.TypedArray r3 = r0.obtainStyledAttributes(r12, r2)
            int r4 = androidx.appcompat.R.styleable.TextAppearance_android_textSize     // Catch:{ all -> 0x020f }
            int r5 = r3.getDimensionPixelSize(r4, r6)     // Catch:{ all -> 0x020f }
            float r5 = (float) r5     // Catch:{ all -> 0x020f }
            r9.tabTextSize = r5     // Catch:{ all -> 0x020f }
            int r5 = androidx.appcompat.R.styleable.TextAppearance_android_textColor     // Catch:{ all -> 0x020f }
            android.content.res.ColorStateList r7 = com.google.android.material.resources.MaterialResources.getColorStateList((android.content.Context) r0, (android.content.res.TypedArray) r3, (int) r5)     // Catch:{ all -> 0x020f }
            r9.tabTextColors = r7     // Catch:{ all -> 0x020f }
            r3.recycle()
            int r3 = com.google.android.material.R.styleable.TabLayout_tabSelectedTextAppearance
            boolean r7 = r11.hasValue(r3)
            if (r7 == 0) goto L_0x011d
            int r12 = r11.getResourceId(r3, r12)
            r9.selectedTabTextAppearance = r12
        L_0x011d:
            int r12 = r9.selectedTabTextAppearance
            if (r12 == r10) goto L_0x015c
            android.content.res.TypedArray r12 = r0.obtainStyledAttributes(r12, r2)
            float r2 = r9.tabTextSize     // Catch:{ all -> 0x0151 }
            int r2 = (int) r2     // Catch:{ all -> 0x0151 }
            int r2 = r12.getDimensionPixelSize(r4, r2)     // Catch:{ all -> 0x0151 }
            float r2 = (float) r2     // Catch:{ all -> 0x0151 }
            r9.selectedTabTextSize = r2     // Catch:{ all -> 0x0151 }
            android.content.res.ColorStateList r2 = com.google.android.material.resources.MaterialResources.getColorStateList((android.content.Context) r0, (android.content.res.TypedArray) r12, (int) r5)     // Catch:{ all -> 0x0151 }
            if (r2 == 0) goto L_0x0154
            android.content.res.ColorStateList r3 = r9.tabTextColors     // Catch:{ all -> 0x0151 }
            int r3 = r3.getDefaultColor()     // Catch:{ all -> 0x0151 }
            r4 = 16842913(0x10100a1, float:2.369401E-38)
            int[] r4 = new int[]{r4}     // Catch:{ all -> 0x0151 }
            int r5 = r2.getDefaultColor()     // Catch:{ all -> 0x0151 }
            int r2 = r2.getColorForState(r4, r5)     // Catch:{ all -> 0x0151 }
            android.content.res.ColorStateList r2 = createColorStateList(r3, r2)     // Catch:{ all -> 0x0151 }
            r9.tabTextColors = r2     // Catch:{ all -> 0x0151 }
            goto L_0x0154
        L_0x0151:
            r0 = move-exception
            r10 = r0
            goto L_0x0158
        L_0x0154:
            r12.recycle()
            goto L_0x015c
        L_0x0158:
            r12.recycle()
            throw r10
        L_0x015c:
            int r12 = com.google.android.material.R.styleable.TabLayout_tabTextColor
            boolean r2 = r11.hasValue(r12)
            if (r2 == 0) goto L_0x016a
            android.content.res.ColorStateList r12 = com.google.android.material.resources.MaterialResources.getColorStateList((android.content.Context) r0, (android.content.res.TypedArray) r11, (int) r12)
            r9.tabTextColors = r12
        L_0x016a:
            int r12 = com.google.android.material.R.styleable.TabLayout_tabSelectedTextColor
            boolean r2 = r11.hasValue(r12)
            if (r2 == 0) goto L_0x0182
            int r12 = r11.getColor(r12, r6)
            android.content.res.ColorStateList r2 = r9.tabTextColors
            int r2 = r2.getDefaultColor()
            android.content.res.ColorStateList r12 = createColorStateList(r2, r12)
            r9.tabTextColors = r12
        L_0x0182:
            int r12 = com.google.android.material.R.styleable.TabLayout_tabIconTint
            android.content.res.ColorStateList r12 = com.google.android.material.resources.MaterialResources.getColorStateList((android.content.Context) r0, (android.content.res.TypedArray) r11, (int) r12)
            r9.tabIconTint = r12
            int r12 = com.google.android.material.R.styleable.TabLayout_tabIconTintMode
            int r12 = r11.getInt(r12, r10)
            r2 = 0
            android.graphics.PorterDuff$Mode r12 = com.google.android.material.internal.ViewUtils.parseTintMode(r12, r2)
            r9.tabIconTintMode = r12
            int r12 = com.google.android.material.R.styleable.TabLayout_tabRippleColor
            android.content.res.ColorStateList r12 = com.google.android.material.resources.MaterialResources.getColorStateList((android.content.Context) r0, (android.content.res.TypedArray) r11, (int) r12)
            r9.tabRippleColorStateList = r12
            int r12 = com.google.android.material.R.styleable.TabLayout_tabIndicatorAnimationDuration
            r2 = 300(0x12c, float:4.2E-43)
            int r12 = r11.getInt(r12, r2)
            r9.tabIndicatorAnimationDuration = r12
            int r12 = com.google.android.material.R.attr.motionEasingEmphasizedInterpolator
            android.animation.TimeInterpolator r2 = com.google.android.material.animation.AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR
            android.animation.TimeInterpolator r12 = com.google.android.material.motion.MotionUtils.resolveThemeInterpolator(r0, r12, r2)
            r9.tabIndicatorTimeInterpolator = r12
            int r12 = com.google.android.material.R.styleable.TabLayout_tabMinWidth
            int r12 = r11.getDimensionPixelSize(r12, r10)
            r9.requestedTabMinWidth = r12
            int r12 = com.google.android.material.R.styleable.TabLayout_tabMaxWidth
            int r10 = r11.getDimensionPixelSize(r12, r10)
            r9.requestedTabMaxWidth = r10
            int r10 = com.google.android.material.R.styleable.TabLayout_tabBackground
            int r10 = r11.getResourceId(r10, r6)
            r9.tabBackgroundResId = r10
            int r10 = com.google.android.material.R.styleable.TabLayout_tabContentStart
            int r10 = r11.getDimensionPixelSize(r10, r6)
            r9.contentInsetStart = r10
            int r10 = com.google.android.material.R.styleable.TabLayout_tabMode
            int r10 = r11.getInt(r10, r1)
            r9.mode = r10
            int r10 = com.google.android.material.R.styleable.TabLayout_tabGravity
            int r10 = r11.getInt(r10, r6)
            r9.tabGravity = r10
            int r10 = com.google.android.material.R.styleable.TabLayout_tabInlineLabel
            boolean r10 = r11.getBoolean(r10, r6)
            r9.inlineLabel = r10
            int r10 = com.google.android.material.R.styleable.TabLayout_tabUnboundedRipple
            boolean r10 = r11.getBoolean(r10, r6)
            r9.unboundedRipple = r10
            r11.recycle()
            android.content.res.Resources r10 = r9.getResources()
            int r11 = com.google.android.material.R.dimen.design_tab_text_size_2line
            int r11 = r10.getDimensionPixelSize(r11)
            float r11 = (float) r11
            r9.tabTextMultiLineSize = r11
            int r11 = com.google.android.material.R.dimen.design_tab_scrollable_min_width
            int r10 = r10.getDimensionPixelSize(r11)
            r9.scrollableTabMinWidth = r10
            r9.applyModeAndGravity()
            return
        L_0x020f:
            r0 = move-exception
            r10 = r0
            r3.recycle()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    private void setupWithViewPager(@Nullable ViewPager viewPager2, boolean z4, boolean z5) {
        ViewPager viewPager3 = this.viewPager;
        if (viewPager3 != null) {
            TabLayoutOnPageChangeListener tabLayoutOnPageChangeListener = this.pageChangeListener;
            if (tabLayoutOnPageChangeListener != null) {
                viewPager3.removeOnPageChangeListener(tabLayoutOnPageChangeListener);
            }
            AdapterChangeListener adapterChangeListener2 = this.adapterChangeListener;
            if (adapterChangeListener2 != null) {
                this.viewPager.removeOnAdapterChangeListener(adapterChangeListener2);
            }
        }
        BaseOnTabSelectedListener baseOnTabSelectedListener = this.currentVpSelectedListener;
        if (baseOnTabSelectedListener != null) {
            removeOnTabSelectedListener(baseOnTabSelectedListener);
            this.currentVpSelectedListener = null;
        }
        if (viewPager2 != null) {
            this.viewPager = viewPager2;
            if (this.pageChangeListener == null) {
                this.pageChangeListener = new TabLayoutOnPageChangeListener(this);
            }
            this.pageChangeListener.reset();
            viewPager2.addOnPageChangeListener(this.pageChangeListener);
            ViewPagerOnTabSelectedListener viewPagerOnTabSelectedListener = new ViewPagerOnTabSelectedListener(viewPager2);
            this.currentVpSelectedListener = viewPagerOnTabSelectedListener;
            addOnTabSelectedListener((BaseOnTabSelectedListener) viewPagerOnTabSelectedListener);
            PagerAdapter adapter = viewPager2.getAdapter();
            if (adapter != null) {
                setPagerAdapter(adapter, z4);
            }
            if (this.adapterChangeListener == null) {
                this.adapterChangeListener = new AdapterChangeListener();
            }
            this.adapterChangeListener.setAutoRefresh(z4);
            viewPager2.addOnAdapterChangeListener(this.adapterChangeListener);
            setScrollPosition(viewPager2.getCurrentItem(), 0.0f, true);
        } else {
            this.viewPager = null;
            setPagerAdapter((PagerAdapter) null, false);
        }
        this.setupViewPagerImplicitly = z5;
    }

    public void addTab(@NonNull Tab tab, boolean z4) {
        addTab(tab, this.tabs.size(), z4);
    }

    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        addViewInternal(view);
    }

    /* access modifiers changed from: package-private */
    public void setScrollPosition(int i4, float f4, boolean z4, boolean z5, boolean z6) {
        int round = Math.round(((float) i4) + f4);
        if (round >= 0 && round < this.slidingTabIndicator.getChildCount()) {
            if (z5) {
                this.slidingTabIndicator.setIndicatorPositionFromTabPosition(i4, f4);
            }
            ValueAnimator valueAnimator = this.scrollAnimator;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.scrollAnimator.cancel();
            }
            int calculateScrollXForTab = calculateScrollXForTab(i4, f4);
            int scrollX = getScrollX();
            boolean z7 = (i4 < getSelectedTabPosition() && calculateScrollXForTab >= scrollX) || (i4 > getSelectedTabPosition() && calculateScrollXForTab <= scrollX) || i4 == getSelectedTabPosition();
            if (ViewCompat.getLayoutDirection(this) == 1) {
                z7 = (i4 < getSelectedTabPosition() && calculateScrollXForTab <= scrollX) || (i4 > getSelectedTabPosition() && calculateScrollXForTab >= scrollX) || i4 == getSelectedTabPosition();
            }
            if (z7 || this.viewPagerScrollState == 1 || z6) {
                if (i4 < 0) {
                    calculateScrollXForTab = 0;
                }
                scrollTo(calculateScrollXForTab, 0);
            }
            if (z4) {
                setSelectedTabView(round);
            }
        }
    }

    public void addTab(@NonNull Tab tab, int i4, boolean z4) {
        if (tab.parent == this) {
            configureTab(tab, i4);
            addTabView(tab);
            if (z4) {
                tab.select();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
    }

    public void addView(View view, int i4, ViewGroup.LayoutParams layoutParams) {
        addViewInternal(view);
    }

    public void setTabTextColors(int i4, int i5) {
        setTabTextColors(createColorStateList(i4, i5));
    }

    public void setSelectedTabIndicator(@DrawableRes int i4) {
        if (i4 != 0) {
            setSelectedTabIndicator(AppCompatResources.getDrawable(getContext(), i4));
        } else {
            setSelectedTabIndicator((Drawable) null);
        }
    }
}
