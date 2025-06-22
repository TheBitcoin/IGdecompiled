package com.google.android.material.bottomsheet;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.RoundedCorner;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import androidx.activity.BackEventCompat;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.VisibleForTesting;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.Insets;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.ViewDragHelper;
import com.google.android.material.R;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.motion.MaterialBackHandler;
import com.google.android.material.motion.MaterialBottomContainerBackHelper;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> implements MaterialBackHandler {
    private static final int CORNER_ANIMATION_DURATION = 500;
    @VisibleForTesting
    static final int DEFAULT_SIGNIFICANT_VEL_THRESHOLD = 500;
    private static final int DEF_STYLE_RES = R.style.Widget_Design_BottomSheet_Modal;
    private static final float HIDE_FRICTION = 0.1f;
    private static final float HIDE_THRESHOLD = 0.5f;
    private static final int INVALID_POSITION = -1;
    private static final int NO_MAX_SIZE = -1;
    public static final int PEEK_HEIGHT_AUTO = -1;
    public static final int SAVE_ALL = -1;
    public static final int SAVE_FIT_TO_CONTENTS = 2;
    public static final int SAVE_HIDEABLE = 4;
    public static final int SAVE_NONE = 0;
    public static final int SAVE_PEEK_HEIGHT = 1;
    public static final int SAVE_SKIP_COLLAPSED = 8;
    public static final int STATE_COLLAPSED = 4;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_EXPANDED = 3;
    public static final int STATE_HALF_EXPANDED = 6;
    public static final int STATE_HIDDEN = 5;
    public static final int STATE_SETTLING = 2;
    private static final String TAG = "BottomSheetBehavior";
    @VisibleForTesting
    static final int VIEW_INDEX_ACCESSIBILITY_DELEGATE_VIEW = 1;
    private static final int VIEW_INDEX_BOTTOM_SHEET = 0;
    @Nullable
    WeakReference<View> accessibilityDelegateViewRef;
    int activePointerId;
    @Nullable
    private ColorStateList backgroundTint;
    @Nullable
    MaterialBottomContainerBackHelper bottomContainerBackHelper;
    @NonNull
    private final ArrayList<BottomSheetCallback> callbacks = new ArrayList<>();
    private int childHeight;
    int collapsedOffset;
    private final ViewDragHelper.Callback dragCallback = new ViewDragHelper.Callback() {
        private long viewCapturedMillis;

        private boolean releasedLow(@NonNull View view) {
            int top = view.getTop();
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            if (top > (bottomSheetBehavior.parentHeight + bottomSheetBehavior.getExpandedOffset()) / 2) {
                return true;
            }
            return false;
        }

        public int clampViewPositionHorizontal(@NonNull View view, int i4, int i5) {
            return view.getLeft();
        }

        public int clampViewPositionVertical(@NonNull View view, int i4, int i5) {
            return MathUtils.clamp(i4, BottomSheetBehavior.this.getExpandedOffset(), getViewVerticalDragRange(view));
        }

        public int getViewVerticalDragRange(@NonNull View view) {
            if (BottomSheetBehavior.this.canBeHiddenByDragging()) {
                return BottomSheetBehavior.this.parentHeight;
            }
            return BottomSheetBehavior.this.collapsedOffset;
        }

        public void onViewDragStateChanged(int i4) {
            if (i4 == 1 && BottomSheetBehavior.this.draggable) {
                BottomSheetBehavior.this.setStateInternal(1);
            }
        }

        public void onViewPositionChanged(@NonNull View view, int i4, int i5, int i6, int i7) {
            BottomSheetBehavior.this.dispatchOnSlide(i5);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x003c, code lost:
            if (r9 > r7.this$0.halfExpandedOffset) goto L_0x012b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0091, code lost:
            if (java.lang.Math.abs(r8.getTop() - r7.this$0.getExpandedOffset()) < java.lang.Math.abs(r8.getTop() - r7.this$0.halfExpandedOffset)) goto L_0x0010;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x00d0, code lost:
            if (r7.this$0.shouldSkipHalfExpandedStateWhenDragging() == false) goto L_0x012b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x00f2, code lost:
            if (java.lang.Math.abs(r9 - r7.this$0.fitToContentsOffset) < java.lang.Math.abs(r9 - r7.this$0.collapsedOffset)) goto L_0x0010;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x010e, code lost:
            if (r7.this$0.shouldSkipHalfExpandedStateWhenDragging() != false) goto L_0x00ae;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x0128, code lost:
            if (r7.this$0.shouldSkipHalfExpandedStateWhenDragging() == false) goto L_0x012b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0035, code lost:
            if (r10.shouldExpandOnUpwardDrag(r3, (((float) r9) * 100.0f) / ((float) r10.parentHeight)) != false) goto L_0x0010;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onViewReleased(@androidx.annotation.NonNull android.view.View r8, float r9, float r10) {
            /*
                r7 = this;
                r0 = 6
                r1 = 3
                r2 = 4
                r3 = 0
                int r4 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
                if (r4 >= 0) goto L_0x0040
                com.google.android.material.bottomsheet.BottomSheetBehavior r9 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r9 = r9.fitToContents
                if (r9 == 0) goto L_0x0013
            L_0x0010:
                r0 = 3
                goto L_0x012b
            L_0x0013:
                int r9 = r8.getTop()
                long r3 = java.lang.System.currentTimeMillis()
                long r5 = r7.viewCapturedMillis
                long r3 = r3 - r5
                com.google.android.material.bottomsheet.BottomSheetBehavior r10 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r10 = r10.shouldSkipHalfExpandedStateWhenDragging()
                if (r10 == 0) goto L_0x0038
                float r9 = (float) r9
                r10 = 1120403456(0x42c80000, float:100.0)
                float r9 = r9 * r10
                com.google.android.material.bottomsheet.BottomSheetBehavior r10 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r0 = r10.parentHeight
                float r0 = (float) r0
                float r9 = r9 / r0
                boolean r9 = r10.shouldExpandOnUpwardDrag(r3, r9)
                if (r9 == 0) goto L_0x00ae
                goto L_0x0010
            L_0x0038:
                com.google.android.material.bottomsheet.BottomSheetBehavior r10 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r10 = r10.halfExpandedOffset
                if (r9 <= r10) goto L_0x0010
                goto L_0x012b
            L_0x0040:
                com.google.android.material.bottomsheet.BottomSheetBehavior r4 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r5 = r4.hideable
                if (r5 == 0) goto L_0x0095
                boolean r4 = r4.shouldHide(r8, r10)
                if (r4 == 0) goto L_0x0095
                float r9 = java.lang.Math.abs(r9)
                float r2 = java.lang.Math.abs(r10)
                int r9 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
                if (r9 >= 0) goto L_0x0063
                com.google.android.material.bottomsheet.BottomSheetBehavior r9 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r9 = r9.significantVelocityThreshold
                float r9 = (float) r9
                int r9 = (r10 > r9 ? 1 : (r10 == r9 ? 0 : -1))
                if (r9 > 0) goto L_0x0069
            L_0x0063:
                boolean r9 = r7.releasedLow(r8)
                if (r9 == 0) goto L_0x006c
            L_0x0069:
                r0 = 5
                goto L_0x012b
            L_0x006c:
                com.google.android.material.bottomsheet.BottomSheetBehavior r9 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r9 = r9.fitToContents
                if (r9 == 0) goto L_0x0075
                goto L_0x0010
            L_0x0075:
                int r9 = r8.getTop()
                com.google.android.material.bottomsheet.BottomSheetBehavior r10 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r10 = r10.getExpandedOffset()
                int r9 = r9 - r10
                int r9 = java.lang.Math.abs(r9)
                int r10 = r8.getTop()
                com.google.android.material.bottomsheet.BottomSheetBehavior r2 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r2 = r2.halfExpandedOffset
                int r10 = r10 - r2
                int r10 = java.lang.Math.abs(r10)
                if (r9 >= r10) goto L_0x012b
                goto L_0x0010
            L_0x0095:
                int r3 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
                if (r3 == 0) goto L_0x00d3
                float r9 = java.lang.Math.abs(r9)
                float r10 = java.lang.Math.abs(r10)
                int r9 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1))
                if (r9 <= 0) goto L_0x00a6
                goto L_0x00d3
            L_0x00a6:
                com.google.android.material.bottomsheet.BottomSheetBehavior r9 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r9 = r9.fitToContents
                if (r9 == 0) goto L_0x00b1
            L_0x00ae:
                r0 = 4
                goto L_0x012b
            L_0x00b1:
                int r9 = r8.getTop()
                com.google.android.material.bottomsheet.BottomSheetBehavior r10 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r10 = r10.halfExpandedOffset
                int r10 = r9 - r10
                int r10 = java.lang.Math.abs(r10)
                com.google.android.material.bottomsheet.BottomSheetBehavior r1 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r1 = r1.collapsedOffset
                int r9 = r9 - r1
                int r9 = java.lang.Math.abs(r9)
                if (r10 >= r9) goto L_0x00ae
                com.google.android.material.bottomsheet.BottomSheetBehavior r9 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r9 = r9.shouldSkipHalfExpandedStateWhenDragging()
                if (r9 == 0) goto L_0x012b
                goto L_0x00ae
            L_0x00d3:
                int r9 = r8.getTop()
                com.google.android.material.bottomsheet.BottomSheetBehavior r10 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r10 = r10.fitToContents
                if (r10 == 0) goto L_0x00f6
                com.google.android.material.bottomsheet.BottomSheetBehavior r10 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r10 = r10.fitToContentsOffset
                int r10 = r9 - r10
                int r10 = java.lang.Math.abs(r10)
                com.google.android.material.bottomsheet.BottomSheetBehavior r0 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r0 = r0.collapsedOffset
                int r9 = r9 - r0
                int r9 = java.lang.Math.abs(r9)
                if (r10 >= r9) goto L_0x00ae
                goto L_0x0010
            L_0x00f6:
                com.google.android.material.bottomsheet.BottomSheetBehavior r10 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r3 = r10.halfExpandedOffset
                if (r9 >= r3) goto L_0x0111
                int r10 = r10.collapsedOffset
                int r10 = r9 - r10
                int r10 = java.lang.Math.abs(r10)
                if (r9 >= r10) goto L_0x0108
                goto L_0x0010
            L_0x0108:
                com.google.android.material.bottomsheet.BottomSheetBehavior r9 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r9 = r9.shouldSkipHalfExpandedStateWhenDragging()
                if (r9 == 0) goto L_0x012b
                goto L_0x00ae
            L_0x0111:
                int r10 = r9 - r3
                int r10 = java.lang.Math.abs(r10)
                com.google.android.material.bottomsheet.BottomSheetBehavior r1 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r1 = r1.collapsedOffset
                int r9 = r9 - r1
                int r9 = java.lang.Math.abs(r9)
                if (r10 >= r9) goto L_0x00ae
                com.google.android.material.bottomsheet.BottomSheetBehavior r9 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r9 = r9.shouldSkipHalfExpandedStateWhenDragging()
                if (r9 == 0) goto L_0x012b
                goto L_0x00ae
            L_0x012b:
                com.google.android.material.bottomsheet.BottomSheetBehavior r9 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r10 = r9.shouldSkipSmoothAnimation()
                r9.startSettling(r8, r0, r10)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.AnonymousClass5.onViewReleased(android.view.View, float, float):void");
        }

        public boolean tryCaptureView(@NonNull View view, int i4) {
            View view2;
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            int i5 = bottomSheetBehavior.state;
            if (i5 == 1 || bottomSheetBehavior.touchingScrollingChild) {
                return false;
            }
            if (i5 == 3 && bottomSheetBehavior.activePointerId == i4) {
                WeakReference<View> weakReference = bottomSheetBehavior.nestedScrollingChildRef;
                if (weakReference != null) {
                    view2 = weakReference.get();
                } else {
                    view2 = null;
                }
                if (view2 != null && view2.canScrollVertically(-1)) {
                    return false;
                }
            }
            this.viewCapturedMillis = System.currentTimeMillis();
            WeakReference<V> weakReference2 = BottomSheetBehavior.this.viewRef;
            if (weakReference2 == null || weakReference2.get() != view) {
                return false;
            }
            return true;
        }
    };
    /* access modifiers changed from: private */
    public boolean draggable = true;
    float elevation = -1.0f;
    @VisibleForTesting
    final SparseIntArray expandHalfwayActionIds = new SparseIntArray();
    private boolean expandedCornersRemoved;
    int expandedOffset;
    /* access modifiers changed from: private */
    public boolean fitToContents = true;
    int fitToContentsOffset;
    /* access modifiers changed from: private */
    public int gestureInsetBottom;
    private boolean gestureInsetBottomIgnored;
    int halfExpandedOffset;
    float halfExpandedRatio = 0.5f;
    private float hideFriction = 0.1f;
    boolean hideable;
    private boolean ignoreEvents;
    @Nullable
    private Map<View, Integer> importantForAccessibilityMap;
    private int initialY = -1;
    /* access modifiers changed from: private */
    public int insetBottom;
    /* access modifiers changed from: private */
    public int insetTop;
    @Nullable
    private ValueAnimator interpolatorAnimator;
    private int lastNestedScrollDy;
    int lastStableState = 4;
    /* access modifiers changed from: private */
    public boolean marginLeftSystemWindowInsets;
    /* access modifiers changed from: private */
    public boolean marginRightSystemWindowInsets;
    /* access modifiers changed from: private */
    public boolean marginTopSystemWindowInsets;
    /* access modifiers changed from: private */
    public MaterialShapeDrawable materialShapeDrawable;
    private int maxHeight = -1;
    private int maxWidth = -1;
    private float maximumVelocity;
    private boolean nestedScrolled;
    @Nullable
    WeakReference<View> nestedScrollingChildRef;
    /* access modifiers changed from: private */
    public boolean paddingBottomSystemWindowInsets;
    /* access modifiers changed from: private */
    public boolean paddingLeftSystemWindowInsets;
    /* access modifiers changed from: private */
    public boolean paddingRightSystemWindowInsets;
    private boolean paddingTopSystemWindowInsets;
    int parentHeight;
    int parentWidth;
    /* access modifiers changed from: private */
    public int peekHeight;
    private boolean peekHeightAuto;
    private int peekHeightGestureInsetBuffer;
    private int peekHeightMin;
    private int saveFlags = 0;
    private ShapeAppearanceModel shapeAppearanceModelDefault;
    private boolean shouldRemoveExpandedCorners;
    /* access modifiers changed from: private */
    public int significantVelocityThreshold;
    /* access modifiers changed from: private */
    public boolean skipCollapsed;
    int state = 4;
    private final BottomSheetBehavior<V>.StateSettlingTracker stateSettlingTracker = new StateSettlingTracker();
    boolean touchingScrollingChild;
    private boolean updateImportantForAccessibilityOnSiblings = false;
    @Nullable
    private VelocityTracker velocityTracker;
    @Nullable
    ViewDragHelper viewDragHelper;
    @Nullable
    WeakReference<V> viewRef;

    public static abstract class BottomSheetCallback {
        /* access modifiers changed from: package-private */
        public void onLayout(@NonNull View view) {
        }

        public abstract void onSlide(@NonNull View view, float f4);

        public abstract void onStateChanged(@NonNull View view, int i4);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface SaveFlags {
    }

    protected static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            @NonNull
            public SavedState[] newArray(int i4) {
                return new SavedState[i4];
            }

            @NonNull
            public SavedState createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Nullable
            public SavedState createFromParcel(@NonNull Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }
        };
        boolean fitToContents;
        boolean hideable;
        int peekHeight;
        boolean skipCollapsed;
        final int state;

        public SavedState(@NonNull Parcel parcel) {
            this(parcel, (ClassLoader) null);
        }

        public void writeToParcel(@NonNull Parcel parcel, int i4) {
            super.writeToParcel(parcel, i4);
            parcel.writeInt(this.state);
            parcel.writeInt(this.peekHeight);
            parcel.writeInt(this.fitToContents ? 1 : 0);
            parcel.writeInt(this.hideable ? 1 : 0);
            parcel.writeInt(this.skipCollapsed ? 1 : 0);
        }

        public SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.state = parcel.readInt();
            this.peekHeight = parcel.readInt();
            boolean z4 = false;
            this.fitToContents = parcel.readInt() == 1;
            this.hideable = parcel.readInt() == 1;
            this.skipCollapsed = parcel.readInt() == 1 ? true : z4;
        }

        public SavedState(Parcelable parcelable, @NonNull BottomSheetBehavior<?> bottomSheetBehavior) {
            super(parcelable);
            this.state = bottomSheetBehavior.state;
            this.peekHeight = bottomSheetBehavior.peekHeight;
            this.fitToContents = bottomSheetBehavior.fitToContents;
            this.hideable = bottomSheetBehavior.hideable;
            this.skipCollapsed = bottomSheetBehavior.skipCollapsed;
        }

        @Deprecated
        public SavedState(Parcelable parcelable, int i4) {
            super(parcelable);
            this.state = i4;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface StableState {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
    }

    private class StateSettlingTracker {
        private final Runnable continueSettlingRunnable;
        /* access modifiers changed from: private */
        public boolean isContinueSettlingRunnablePosted;
        /* access modifiers changed from: private */
        public int targetState;

        private StateSettlingTracker() {
            this.continueSettlingRunnable = new Runnable() {
                public void run() {
                    boolean unused = StateSettlingTracker.this.isContinueSettlingRunnablePosted = false;
                    ViewDragHelper viewDragHelper = BottomSheetBehavior.this.viewDragHelper;
                    if (viewDragHelper == null || !viewDragHelper.continueSettling(true)) {
                        StateSettlingTracker stateSettlingTracker = StateSettlingTracker.this;
                        BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                        if (bottomSheetBehavior.state == 2) {
                            bottomSheetBehavior.setStateInternal(stateSettlingTracker.targetState);
                            return;
                        }
                        return;
                    }
                    StateSettlingTracker stateSettlingTracker2 = StateSettlingTracker.this;
                    stateSettlingTracker2.continueSettlingToState(stateSettlingTracker2.targetState);
                }
            };
        }

        /* access modifiers changed from: package-private */
        public void continueSettlingToState(int i4) {
            WeakReference<V> weakReference = BottomSheetBehavior.this.viewRef;
            if (weakReference != null && weakReference.get() != null) {
                this.targetState = i4;
                if (!this.isContinueSettlingRunnablePosted) {
                    ViewCompat.postOnAnimation((View) BottomSheetBehavior.this.viewRef.get(), this.continueSettlingRunnable);
                    this.isContinueSettlingRunnablePosted = true;
                }
            }
        }
    }

    public BottomSheetBehavior() {
    }

    private int addAccessibilityActionForState(View view, @StringRes int i4, int i5) {
        return ViewCompat.addAccessibilityAction(view, view.getResources().getString(i4), createAccessibilityViewCommandForState(i5));
    }

    private void calculateCollapsedOffset() {
        int calculatePeekHeight = calculatePeekHeight();
        if (this.fitToContents) {
            this.collapsedOffset = Math.max(this.parentHeight - calculatePeekHeight, this.fitToContentsOffset);
        } else {
            this.collapsedOffset = this.parentHeight - calculatePeekHeight;
        }
    }

    @RequiresApi(31)
    private float calculateCornerInterpolation(float f4, @Nullable RoundedCorner roundedCorner) {
        if (roundedCorner != null) {
            float a5 = (float) roundedCorner.getRadius();
            if (a5 > 0.0f && f4 > 0.0f) {
                return a5 / f4;
            }
        }
        return 0.0f;
    }

    private void calculateHalfExpandedOffset() {
        this.halfExpandedOffset = (int) (((float) this.parentHeight) * (1.0f - this.halfExpandedRatio));
    }

    private float calculateInterpolationWithCornersRemoved() {
        WeakReference<V> weakReference;
        WindowInsets a5;
        if (this.materialShapeDrawable == null || (weakReference = this.viewRef) == null || weakReference.get() == null || Build.VERSION.SDK_INT < 31) {
            return 0.0f;
        }
        View view = (View) this.viewRef.get();
        if (!isAtTopOfScreen() || (a5 = view.getRootWindowInsets()) == null) {
            return 0.0f;
        }
        return Math.max(calculateCornerInterpolation(this.materialShapeDrawable.getTopLeftCornerResolvedSize(), a5.getRoundedCorner(0)), calculateCornerInterpolation(this.materialShapeDrawable.getTopRightCornerResolvedSize(), a5.getRoundedCorner(1)));
    }

    private int calculatePeekHeight() {
        int i4;
        if (this.peekHeightAuto) {
            return Math.min(Math.max(this.peekHeightMin, this.parentHeight - ((this.parentWidth * 9) / 16)), this.childHeight) + this.insetBottom;
        }
        if (this.gestureInsetBottomIgnored || this.paddingBottomSystemWindowInsets || (i4 = this.gestureInsetBottom) <= 0) {
            return this.peekHeight + this.insetBottom;
        }
        return Math.max(this.peekHeight, i4 + this.peekHeightGestureInsetBuffer);
    }

    private float calculateSlideOffsetWithTop(int i4) {
        float f4;
        float f5;
        int i5 = this.collapsedOffset;
        if (i4 > i5 || i5 == getExpandedOffset()) {
            int i6 = this.collapsedOffset;
            f4 = (float) (i6 - i4);
            f5 = (float) (this.parentHeight - i6);
        } else {
            int i7 = this.collapsedOffset;
            f4 = (float) (i7 - i4);
            f5 = (float) (i7 - getExpandedOffset());
        }
        return f4 / f5;
    }

    /* access modifiers changed from: private */
    public boolean canBeHiddenByDragging() {
        if (!isHideable() || !isHideableWhenDragging()) {
            return false;
        }
        return true;
    }

    private void clearAccessibilityAction(View view, int i4) {
        if (view != null) {
            ViewCompat.removeAccessibilityAction(view, 524288);
            ViewCompat.removeAccessibilityAction(view, 262144);
            ViewCompat.removeAccessibilityAction(view, 1048576);
            int i5 = this.expandHalfwayActionIds.get(i4, -1);
            if (i5 != -1) {
                ViewCompat.removeAccessibilityAction(view, i5);
                this.expandHalfwayActionIds.delete(i4);
            }
        }
    }

    private AccessibilityViewCommand createAccessibilityViewCommandForState(final int i4) {
        return new AccessibilityViewCommand() {
            public boolean perform(@NonNull View view, @Nullable AccessibilityViewCommand.CommandArguments commandArguments) {
                BottomSheetBehavior.this.setState(i4);
                return true;
            }
        };
    }

    private void createMaterialShapeDrawableIfNeeded(@NonNull Context context) {
        if (this.shapeAppearanceModelDefault != null) {
            MaterialShapeDrawable materialShapeDrawable2 = new MaterialShapeDrawable(this.shapeAppearanceModelDefault);
            this.materialShapeDrawable = materialShapeDrawable2;
            materialShapeDrawable2.initializeElevationOverlay(context);
            ColorStateList colorStateList = this.backgroundTint;
            if (colorStateList != null) {
                this.materialShapeDrawable.setFillColor(colorStateList);
                return;
            }
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(16842801, typedValue, true);
            this.materialShapeDrawable.setTint(typedValue.data);
        }
    }

    private void createShapeValueAnimator() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{calculateInterpolationWithCornersRemoved(), 1.0f});
        this.interpolatorAnimator = ofFloat;
        ofFloat.setDuration(500);
        this.interpolatorAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (BottomSheetBehavior.this.materialShapeDrawable != null) {
                    BottomSheetBehavior.this.materialShapeDrawable.setInterpolation(floatValue);
                }
            }
        });
    }

    @NonNull
    public static <V extends View> BottomSheetBehavior<V> from(@NonNull V v4) {
        ViewGroup.LayoutParams layoutParams = v4.getLayoutParams();
        if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) layoutParams).getBehavior();
            if (behavior instanceof BottomSheetBehavior) {
                return (BottomSheetBehavior) behavior;
            }
            throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
        }
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }

    private int getChildMeasureSpec(int i4, int i5, int i6, int i7) {
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i4, i5, i7);
        if (i6 == -1) {
            return childMeasureSpec;
        }
        int mode = View.MeasureSpec.getMode(childMeasureSpec);
        int size = View.MeasureSpec.getSize(childMeasureSpec);
        if (mode == 1073741824) {
            return View.MeasureSpec.makeMeasureSpec(Math.min(size, i6), 1073741824);
        }
        if (size != 0) {
            i6 = Math.min(size, i6);
        }
        return View.MeasureSpec.makeMeasureSpec(i6, Integer.MIN_VALUE);
    }

    private int getTopOffsetForState(int i4) {
        if (i4 == 3) {
            return getExpandedOffset();
        }
        if (i4 == 4) {
            return this.collapsedOffset;
        }
        if (i4 == 5) {
            return this.parentHeight;
        }
        if (i4 == 6) {
            return this.halfExpandedOffset;
        }
        throw new IllegalArgumentException("Invalid state to get top offset: " + i4);
    }

    private float getYVelocity() {
        VelocityTracker velocityTracker2 = this.velocityTracker;
        if (velocityTracker2 == null) {
            return 0.0f;
        }
        velocityTracker2.computeCurrentVelocity(1000, this.maximumVelocity);
        return this.velocityTracker.getYVelocity(this.activePointerId);
    }

    private boolean isAtTopOfScreen() {
        WeakReference<V> weakReference = this.viewRef;
        if (!(weakReference == null || weakReference.get() == null)) {
            int[] iArr = new int[2];
            ((View) this.viewRef.get()).getLocationOnScreen(iArr);
            if (iArr[1] == 0) {
                return true;
            }
        }
        return false;
    }

    private boolean isExpandedAndShouldRemoveCorners() {
        if (this.state != 3) {
            return false;
        }
        if (this.shouldRemoveExpandedCorners || isAtTopOfScreen()) {
            return true;
        }
        return false;
    }

    private boolean isLayouting(V v4) {
        ViewParent parent = v4.getParent();
        if (parent == null || !parent.isLayoutRequested() || !ViewCompat.isAttachedToWindow(v4)) {
            return false;
        }
        return true;
    }

    private void replaceAccessibilityActionForState(View view, AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat, int i4) {
        ViewCompat.replaceAccessibilityAction(view, accessibilityActionCompat, (CharSequence) null, createAccessibilityViewCommandForState(i4));
    }

    private void reset() {
        this.activePointerId = -1;
        this.initialY = -1;
        VelocityTracker velocityTracker2 = this.velocityTracker;
        if (velocityTracker2 != null) {
            velocityTracker2.recycle();
            this.velocityTracker = null;
        }
    }

    private void restoreOptionalState(@NonNull SavedState savedState) {
        int i4 = this.saveFlags;
        if (i4 != 0) {
            if (i4 == -1 || (i4 & 1) == 1) {
                this.peekHeight = savedState.peekHeight;
            }
            if (i4 == -1 || (i4 & 2) == 2) {
                this.fitToContents = savedState.fitToContents;
            }
            if (i4 == -1 || (i4 & 4) == 4) {
                this.hideable = savedState.hideable;
            }
            if (i4 == -1 || (i4 & 8) == 8) {
                this.skipCollapsed = savedState.skipCollapsed;
            }
        }
    }

    private void runAfterLayout(V v4, Runnable runnable) {
        if (isLayouting(v4)) {
            v4.post(runnable);
        } else {
            runnable.run();
        }
    }

    private void setWindowInsetsListener(@NonNull View view) {
        final boolean z4;
        if (Build.VERSION.SDK_INT < 29 || isGestureInsetBottomIgnored() || this.peekHeightAuto) {
            z4 = false;
        } else {
            z4 = true;
        }
        if (this.paddingBottomSystemWindowInsets || this.paddingLeftSystemWindowInsets || this.paddingRightSystemWindowInsets || this.marginLeftSystemWindowInsets || this.marginRightSystemWindowInsets || this.marginTopSystemWindowInsets || z4) {
            ViewUtils.doOnApplyWindowInsets(view, new ViewUtils.OnApplyWindowInsetsListener() {
                public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat, ViewUtils.RelativePadding relativePadding) {
                    boolean z4;
                    int i4;
                    int i5;
                    int i6;
                    int i7;
                    int i8;
                    Insets insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars());
                    Insets insets2 = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.mandatorySystemGestures());
                    int unused = BottomSheetBehavior.this.insetTop = insets.top;
                    boolean isLayoutRtl = ViewUtils.isLayoutRtl(view);
                    int paddingBottom = view.getPaddingBottom();
                    int paddingLeft = view.getPaddingLeft();
                    int paddingRight = view.getPaddingRight();
                    if (BottomSheetBehavior.this.paddingBottomSystemWindowInsets) {
                        int unused2 = BottomSheetBehavior.this.insetBottom = windowInsetsCompat.getSystemWindowInsetBottom();
                        paddingBottom = relativePadding.bottom + BottomSheetBehavior.this.insetBottom;
                    }
                    if (BottomSheetBehavior.this.paddingLeftSystemWindowInsets) {
                        if (isLayoutRtl) {
                            i8 = relativePadding.end;
                        } else {
                            i8 = relativePadding.start;
                        }
                        paddingLeft = i8 + insets.left;
                    }
                    if (BottomSheetBehavior.this.paddingRightSystemWindowInsets) {
                        if (isLayoutRtl) {
                            i7 = relativePadding.start;
                        } else {
                            i7 = relativePadding.end;
                        }
                        paddingRight = i7 + insets.right;
                    }
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                    boolean z5 = true;
                    if (!BottomSheetBehavior.this.marginLeftSystemWindowInsets || marginLayoutParams.leftMargin == (i6 = insets.left)) {
                        z4 = false;
                    } else {
                        marginLayoutParams.leftMargin = i6;
                        z4 = true;
                    }
                    if (BottomSheetBehavior.this.marginRightSystemWindowInsets && marginLayoutParams.rightMargin != (i5 = insets.right)) {
                        marginLayoutParams.rightMargin = i5;
                        z4 = true;
                    }
                    if (!BottomSheetBehavior.this.marginTopSystemWindowInsets || marginLayoutParams.topMargin == (i4 = insets.top)) {
                        z5 = z4;
                    } else {
                        marginLayoutParams.topMargin = i4;
                    }
                    if (z5) {
                        view.setLayoutParams(marginLayoutParams);
                    }
                    view.setPadding(paddingLeft, view.getPaddingTop(), paddingRight, paddingBottom);
                    if (z4) {
                        int unused3 = BottomSheetBehavior.this.gestureInsetBottom = insets2.bottom;
                    }
                    if (!BottomSheetBehavior.this.paddingBottomSystemWindowInsets && !z4) {
                        return windowInsetsCompat;
                    }
                    BottomSheetBehavior.this.updatePeekHeight(false);
                    return windowInsetsCompat;
                }
            });
        }
    }

    private boolean shouldHandleDraggingWithHelper() {
        if (this.viewDragHelper == null) {
            return false;
        }
        if (this.draggable || this.state == 1) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public void startSettling(View view, int i4, boolean z4) {
        int topOffsetForState = getTopOffsetForState(i4);
        ViewDragHelper viewDragHelper2 = this.viewDragHelper;
        if (viewDragHelper2 == null || (!z4 ? !viewDragHelper2.smoothSlideViewTo(view, view.getLeft(), topOffsetForState) : !viewDragHelper2.settleCapturedViewAt(view.getLeft(), topOffsetForState))) {
            setStateInternal(i4);
            return;
        }
        setStateInternal(2);
        updateDrawableForTargetState(i4, true);
        this.stateSettlingTracker.continueSettlingToState(i4);
    }

    private void updateAccessibilityActions() {
        WeakReference<V> weakReference = this.viewRef;
        if (weakReference != null) {
            updateAccessibilityActions((View) weakReference.get(), 0);
        }
        WeakReference<View> weakReference2 = this.accessibilityDelegateViewRef;
        if (weakReference2 != null) {
            updateAccessibilityActions(weakReference2.get(), 1);
        }
    }

    private void updateDrawableForTargetState(int i4, boolean z4) {
        boolean isExpandedAndShouldRemoveCorners;
        ValueAnimator valueAnimator;
        if (i4 != 2 && this.expandedCornersRemoved != (isExpandedAndShouldRemoveCorners = isExpandedAndShouldRemoveCorners()) && this.materialShapeDrawable != null) {
            this.expandedCornersRemoved = isExpandedAndShouldRemoveCorners;
            float f4 = 1.0f;
            if (!z4 || (valueAnimator = this.interpolatorAnimator) == null) {
                ValueAnimator valueAnimator2 = this.interpolatorAnimator;
                if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                    this.interpolatorAnimator.cancel();
                }
                MaterialShapeDrawable materialShapeDrawable2 = this.materialShapeDrawable;
                if (this.expandedCornersRemoved) {
                    f4 = calculateInterpolationWithCornersRemoved();
                }
                materialShapeDrawable2.setInterpolation(f4);
            } else if (valueAnimator.isRunning()) {
                this.interpolatorAnimator.reverse();
            } else {
                float interpolation = this.materialShapeDrawable.getInterpolation();
                if (isExpandedAndShouldRemoveCorners) {
                    f4 = calculateInterpolationWithCornersRemoved();
                }
                this.interpolatorAnimator.setFloatValues(new float[]{interpolation, f4});
                this.interpolatorAnimator.start();
            }
        }
    }

    private void updateImportantForAccessibility(boolean z4) {
        Map<View, Integer> map;
        WeakReference<V> weakReference = this.viewRef;
        if (weakReference != null) {
            ViewParent parent = ((View) weakReference.get()).getParent();
            if (parent instanceof CoordinatorLayout) {
                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
                int childCount = coordinatorLayout.getChildCount();
                if (z4) {
                    if (this.importantForAccessibilityMap == null) {
                        this.importantForAccessibilityMap = new HashMap(childCount);
                    } else {
                        return;
                    }
                }
                for (int i4 = 0; i4 < childCount; i4++) {
                    V childAt = coordinatorLayout.getChildAt(i4);
                    if (childAt != this.viewRef.get()) {
                        if (z4) {
                            this.importantForAccessibilityMap.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                            if (this.updateImportantForAccessibilityOnSiblings) {
                                ViewCompat.setImportantForAccessibility(childAt, 4);
                            }
                        } else if (this.updateImportantForAccessibilityOnSiblings && (map = this.importantForAccessibilityMap) != null && map.containsKey(childAt)) {
                            ViewCompat.setImportantForAccessibility(childAt, this.importantForAccessibilityMap.get(childAt).intValue());
                        }
                    }
                }
                if (!z4) {
                    this.importantForAccessibilityMap = null;
                } else if (this.updateImportantForAccessibilityOnSiblings) {
                    ((View) this.viewRef.get()).sendAccessibilityEvent(8);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void updatePeekHeight(boolean z4) {
        View view;
        if (this.viewRef != null) {
            calculateCollapsedOffset();
            if (this.state == 4 && (view = (View) this.viewRef.get()) != null) {
                if (z4) {
                    setState(4);
                } else {
                    view.requestLayout();
                }
            }
        }
    }

    public void addBottomSheetCallback(@NonNull BottomSheetCallback bottomSheetCallback) {
        if (!this.callbacks.contains(bottomSheetCallback)) {
            this.callbacks.add(bottomSheetCallback);
        }
    }

    public float calculateSlideOffset() {
        WeakReference<V> weakReference = this.viewRef;
        if (weakReference == null || weakReference.get() == null) {
            return -1.0f;
        }
        return calculateSlideOffsetWithTop(((View) this.viewRef.get()).getTop());
    }

    public void cancelBackProgress() {
        MaterialBottomContainerBackHelper materialBottomContainerBackHelper = this.bottomContainerBackHelper;
        if (materialBottomContainerBackHelper != null) {
            materialBottomContainerBackHelper.cancelBackProgress();
        }
    }

    @VisibleForTesting
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void disableShapeAnimations() {
        this.interpolatorAnimator = null;
    }

    /* access modifiers changed from: package-private */
    public void dispatchOnSlide(int i4) {
        View view = (View) this.viewRef.get();
        if (view != null && !this.callbacks.isEmpty()) {
            float calculateSlideOffsetWithTop = calculateSlideOffsetWithTop(i4);
            for (int i5 = 0; i5 < this.callbacks.size(); i5++) {
                this.callbacks.get(i5).onSlide(view, calculateSlideOffsetWithTop);
            }
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    @Nullable
    public View findScrollingChild(View view) {
        if (view.getVisibility() != 0) {
            return null;
        }
        if (ViewCompat.isNestedScrollingEnabled(view)) {
            return view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                View findScrollingChild = findScrollingChild(viewGroup.getChildAt(i4));
                if (findScrollingChild != null) {
                    return findScrollingChild;
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    @Nullable
    public MaterialBottomContainerBackHelper getBackHelper() {
        return this.bottomContainerBackHelper;
    }

    public int getExpandedOffset() {
        int i4;
        if (this.fitToContents) {
            return this.fitToContentsOffset;
        }
        int i5 = this.expandedOffset;
        if (this.paddingTopSystemWindowInsets) {
            i4 = 0;
        } else {
            i4 = this.insetTop;
        }
        return Math.max(i5, i4);
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getHalfExpandedRatio() {
        return this.halfExpandedRatio;
    }

    public float getHideFriction() {
        return this.hideFriction;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getLastStableState() {
        return this.lastStableState;
    }

    /* access modifiers changed from: package-private */
    public MaterialShapeDrawable getMaterialShapeDrawable() {
        return this.materialShapeDrawable;
    }

    @Px
    public int getMaxHeight() {
        return this.maxHeight;
    }

    @Px
    public int getMaxWidth() {
        return this.maxWidth;
    }

    public int getPeekHeight() {
        if (this.peekHeightAuto) {
            return -1;
        }
        return this.peekHeight;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public int getPeekHeightMin() {
        return this.peekHeightMin;
    }

    public int getSaveFlags() {
        return this.saveFlags;
    }

    public int getSignificantVelocityThreshold() {
        return this.significantVelocityThreshold;
    }

    public boolean getSkipCollapsed() {
        return this.skipCollapsed;
    }

    public int getState() {
        return this.state;
    }

    public void handleBackInvoked() {
        MaterialBottomContainerBackHelper materialBottomContainerBackHelper = this.bottomContainerBackHelper;
        if (materialBottomContainerBackHelper != null) {
            BackEventCompat onHandleBackInvoked = materialBottomContainerBackHelper.onHandleBackInvoked();
            int i4 = 4;
            if (onHandleBackInvoked == null || Build.VERSION.SDK_INT < 34) {
                if (this.hideable) {
                    i4 = 5;
                }
                setState(i4);
            } else if (this.hideable) {
                this.bottomContainerBackHelper.finishBackProgressNotPersistent(onHandleBackInvoked, new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animator) {
                        BottomSheetBehavior.this.setStateInternal(5);
                        WeakReference<V> weakReference = BottomSheetBehavior.this.viewRef;
                        if (weakReference != null && weakReference.get() != null) {
                            ((View) BottomSheetBehavior.this.viewRef.get()).requestLayout();
                        }
                    }
                });
            } else {
                this.bottomContainerBackHelper.finishBackProgressPersistent(onHandleBackInvoked, (Animator.AnimatorListener) null);
                setState(4);
            }
        }
    }

    public boolean isDraggable() {
        return this.draggable;
    }

    public boolean isFitToContents() {
        return this.fitToContents;
    }

    public boolean isGestureInsetBottomIgnored() {
        return this.gestureInsetBottomIgnored;
    }

    public boolean isHideable() {
        return this.hideable;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isHideableWhenDragging() {
        return true;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isNestedScrollingCheckEnabled() {
        return true;
    }

    public boolean isShouldRemoveExpandedCorners() {
        return this.shouldRemoveExpandedCorners;
    }

    public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
        super.onAttachedToLayoutParams(layoutParams);
        this.viewRef = null;
        this.viewDragHelper = null;
        this.bottomContainerBackHelper = null;
    }

    public void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        this.viewRef = null;
        this.viewDragHelper = null;
        this.bottomContainerBackHelper = null;
    }

    public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v4, @NonNull MotionEvent motionEvent) {
        int i4;
        ViewDragHelper viewDragHelper2;
        boolean z4;
        View view;
        if (!v4.isShown() || !this.draggable) {
            this.ignoreEvents = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            reset();
        }
        if (this.velocityTracker == null) {
            this.velocityTracker = VelocityTracker.obtain();
        }
        this.velocityTracker.addMovement(motionEvent);
        View view2 = null;
        if (actionMasked == 0) {
            int x4 = (int) motionEvent.getX();
            this.initialY = (int) motionEvent.getY();
            if (this.state != 2) {
                WeakReference<View> weakReference = this.nestedScrollingChildRef;
                if (weakReference != null) {
                    view = weakReference.get();
                } else {
                    view = null;
                }
                if (view != null && coordinatorLayout.isPointInChildBounds(view, x4, this.initialY)) {
                    this.activePointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
                    this.touchingScrollingChild = true;
                }
            }
            if (this.activePointerId != -1 || coordinatorLayout.isPointInChildBounds(v4, x4, this.initialY)) {
                z4 = false;
            } else {
                z4 = true;
            }
            this.ignoreEvents = z4;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.touchingScrollingChild = false;
            this.activePointerId = -1;
            if (this.ignoreEvents) {
                this.ignoreEvents = false;
                return false;
            }
        }
        if (!this.ignoreEvents && (viewDragHelper2 = this.viewDragHelper) != null && viewDragHelper2.shouldInterceptTouchEvent(motionEvent)) {
            return true;
        }
        WeakReference<View> weakReference2 = this.nestedScrollingChildRef;
        if (weakReference2 != null) {
            view2 = weakReference2.get();
        }
        if (actionMasked != 2 || view2 == null || this.ignoreEvents || this.state == 1 || coordinatorLayout.isPointInChildBounds(view2, (int) motionEvent.getX(), (int) motionEvent.getY()) || this.viewDragHelper == null || (i4 = this.initialY) == -1 || Math.abs(((float) i4) - motionEvent.getY()) <= ((float) this.viewDragHelper.getTouchSlop())) {
            return false;
        }
        return true;
    }

    public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v4, int i4) {
        if (ViewCompat.getFitsSystemWindows(coordinatorLayout) && !ViewCompat.getFitsSystemWindows(v4)) {
            v4.setFitsSystemWindows(true);
        }
        if (this.viewRef == null) {
            this.peekHeightMin = coordinatorLayout.getResources().getDimensionPixelSize(R.dimen.design_bottom_sheet_peek_height_min);
            setWindowInsetsListener(v4);
            ViewCompat.setWindowInsetsAnimationCallback(v4, new InsetsAnimationCallback(v4));
            this.viewRef = new WeakReference<>(v4);
            this.bottomContainerBackHelper = new MaterialBottomContainerBackHelper(v4);
            MaterialShapeDrawable materialShapeDrawable2 = this.materialShapeDrawable;
            if (materialShapeDrawable2 != null) {
                ViewCompat.setBackground(v4, materialShapeDrawable2);
                MaterialShapeDrawable materialShapeDrawable3 = this.materialShapeDrawable;
                float f4 = this.elevation;
                if (f4 == -1.0f) {
                    f4 = ViewCompat.getElevation(v4);
                }
                materialShapeDrawable3.setElevation(f4);
            } else {
                ColorStateList colorStateList = this.backgroundTint;
                if (colorStateList != null) {
                    ViewCompat.setBackgroundTintList(v4, colorStateList);
                }
            }
            updateAccessibilityActions();
            if (ViewCompat.getImportantForAccessibility(v4) == 0) {
                ViewCompat.setImportantForAccessibility(v4, 1);
            }
        }
        if (this.viewDragHelper == null) {
            this.viewDragHelper = ViewDragHelper.create(coordinatorLayout, this.dragCallback);
        }
        int top = v4.getTop();
        coordinatorLayout.onLayoutChild(v4, i4);
        this.parentWidth = coordinatorLayout.getWidth();
        this.parentHeight = coordinatorLayout.getHeight();
        int height = v4.getHeight();
        this.childHeight = height;
        int i5 = this.parentHeight;
        int i6 = i5 - height;
        int i7 = this.insetTop;
        if (i6 < i7) {
            if (this.paddingTopSystemWindowInsets) {
                int i8 = this.maxHeight;
                if (i8 != -1) {
                    i5 = Math.min(i5, i8);
                }
                this.childHeight = i5;
            } else {
                int i9 = i5 - i7;
                int i10 = this.maxHeight;
                if (i10 != -1) {
                    i9 = Math.min(i9, i10);
                }
                this.childHeight = i9;
            }
        }
        this.fitToContentsOffset = Math.max(0, this.parentHeight - this.childHeight);
        calculateHalfExpandedOffset();
        calculateCollapsedOffset();
        int i11 = this.state;
        if (i11 == 3) {
            ViewCompat.offsetTopAndBottom(v4, getExpandedOffset());
        } else if (i11 == 6) {
            ViewCompat.offsetTopAndBottom(v4, this.halfExpandedOffset);
        } else if (this.hideable && i11 == 5) {
            ViewCompat.offsetTopAndBottom(v4, this.parentHeight);
        } else if (i11 == 4) {
            ViewCompat.offsetTopAndBottom(v4, this.collapsedOffset);
        } else if (i11 == 1 || i11 == 2) {
            ViewCompat.offsetTopAndBottom(v4, top - v4.getTop());
        }
        updateDrawableForTargetState(this.state, false);
        this.nestedScrollingChildRef = new WeakReference<>(findScrollingChild(v4));
        for (int i12 = 0; i12 < this.callbacks.size(); i12++) {
            this.callbacks.get(i12).onLayout(v4);
        }
        return true;
    }

    public boolean onMeasureChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v4, int i4, int i5, int i6, int i7) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) v4.getLayoutParams();
        v4.measure(getChildMeasureSpec(i4, coordinatorLayout.getPaddingLeft() + coordinatorLayout.getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i5, this.maxWidth, marginLayoutParams.width), getChildMeasureSpec(i6, coordinatorLayout.getPaddingTop() + coordinatorLayout.getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i7, this.maxHeight, marginLayoutParams.height));
        return true;
    }

    public boolean onNestedPreFling(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v4, @NonNull View view, float f4, float f5) {
        WeakReference<View> weakReference;
        if (!isNestedScrollingCheckEnabled() || (weakReference = this.nestedScrollingChildRef) == null || view != weakReference.get() || (this.state == 3 && !super.onNestedPreFling(coordinatorLayout, v4, view, f4, f5))) {
            return false;
        }
        return true;
    }

    public void onNestedPreScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v4, @NonNull View view, int i4, int i5, @NonNull int[] iArr, int i6) {
        View view2;
        if (i6 != 1) {
            WeakReference<View> weakReference = this.nestedScrollingChildRef;
            if (weakReference != null) {
                view2 = weakReference.get();
            } else {
                view2 = null;
            }
            if (!isNestedScrollingCheckEnabled() || view == view2) {
                int top = v4.getTop();
                int i7 = top - i5;
                if (i5 > 0) {
                    if (i7 < getExpandedOffset()) {
                        int expandedOffset2 = top - getExpandedOffset();
                        iArr[1] = expandedOffset2;
                        ViewCompat.offsetTopAndBottom(v4, -expandedOffset2);
                        setStateInternal(3);
                    } else if (this.draggable) {
                        iArr[1] = i5;
                        ViewCompat.offsetTopAndBottom(v4, -i5);
                        setStateInternal(1);
                    } else {
                        return;
                    }
                } else if (i5 < 0 && !view.canScrollVertically(-1)) {
                    if (i7 > this.collapsedOffset && !canBeHiddenByDragging()) {
                        int i8 = top - this.collapsedOffset;
                        iArr[1] = i8;
                        ViewCompat.offsetTopAndBottom(v4, -i8);
                        setStateInternal(4);
                    } else if (this.draggable) {
                        iArr[1] = i5;
                        ViewCompat.offsetTopAndBottom(v4, -i5);
                        setStateInternal(1);
                    } else {
                        return;
                    }
                }
                dispatchOnSlide(v4.getTop());
                this.lastNestedScrollDy = i5;
                this.nestedScrolled = true;
            }
        }
    }

    public void onNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v4, @NonNull View view, int i4, int i5, int i6, int i7, int i8, @NonNull int[] iArr) {
    }

    public void onRestoreInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v4, @NonNull Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(coordinatorLayout, v4, savedState.getSuperState());
        restoreOptionalState(savedState);
        int i4 = savedState.state;
        if (i4 == 1 || i4 == 2) {
            this.state = 4;
            this.lastStableState = 4;
            return;
        }
        this.state = i4;
        this.lastStableState = i4;
    }

    @NonNull
    public Parcelable onSaveInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v4) {
        return new SavedState(super.onSaveInstanceState(coordinatorLayout, v4), (BottomSheetBehavior<?>) this);
    }

    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v4, @NonNull View view, @NonNull View view2, int i4, int i5) {
        this.lastNestedScrollDy = 0;
        this.nestedScrolled = false;
        if ((i4 & 2) != 0) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0035, code lost:
        if (r4.getTop() <= r2.halfExpandedOffset) goto L_0x00aa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0065, code lost:
        if (java.lang.Math.abs(r3 - r2.fitToContentsOffset) < java.lang.Math.abs(r3 - r2.collapsedOffset)) goto L_0x00aa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x007b, code lost:
        if (shouldSkipHalfExpandedStateWhenDragging() != false) goto L_0x0092;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x008b, code lost:
        if (java.lang.Math.abs(r3 - r1) < java.lang.Math.abs(r3 - r2.collapsedOffset)) goto L_0x00a9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00a7, code lost:
        if (java.lang.Math.abs(r3 - r2.halfExpandedOffset) < java.lang.Math.abs(r3 - r2.collapsedOffset)) goto L_0x00a9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onStopNestedScroll(@androidx.annotation.NonNull androidx.coordinatorlayout.widget.CoordinatorLayout r3, @androidx.annotation.NonNull V r4, @androidx.annotation.NonNull android.view.View r5, int r6) {
        /*
            r2 = this;
            int r3 = r4.getTop()
            int r6 = r2.getExpandedOffset()
            r0 = 3
            if (r3 != r6) goto L_0x000f
            r2.setStateInternal(r0)
            return
        L_0x000f:
            boolean r3 = r2.isNestedScrollingCheckEnabled()
            if (r3 == 0) goto L_0x0024
            java.lang.ref.WeakReference<android.view.View> r3 = r2.nestedScrollingChildRef
            if (r3 == 0) goto L_0x0023
            java.lang.Object r3 = r3.get()
            if (r5 != r3) goto L_0x0023
            boolean r3 = r2.nestedScrolled
            if (r3 != 0) goto L_0x0024
        L_0x0023:
            return
        L_0x0024:
            int r3 = r2.lastNestedScrollDy
            r5 = 6
            if (r3 <= 0) goto L_0x0039
            boolean r3 = r2.fitToContents
            if (r3 == 0) goto L_0x002f
            goto L_0x00aa
        L_0x002f:
            int r3 = r4.getTop()
            int r6 = r2.halfExpandedOffset
            if (r3 <= r6) goto L_0x00aa
            goto L_0x00a9
        L_0x0039:
            boolean r3 = r2.hideable
            if (r3 == 0) goto L_0x0049
            float r3 = r2.getYVelocity()
            boolean r3 = r2.shouldHide(r4, r3)
            if (r3 == 0) goto L_0x0049
            r0 = 5
            goto L_0x00aa
        L_0x0049:
            int r3 = r2.lastNestedScrollDy
            r6 = 4
            if (r3 != 0) goto L_0x008e
            int r3 = r4.getTop()
            boolean r1 = r2.fitToContents
            if (r1 == 0) goto L_0x0068
            int r5 = r2.fitToContentsOffset
            int r5 = r3 - r5
            int r5 = java.lang.Math.abs(r5)
            int r1 = r2.collapsedOffset
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r5 >= r3) goto L_0x0092
            goto L_0x00aa
        L_0x0068:
            int r1 = r2.halfExpandedOffset
            if (r3 >= r1) goto L_0x007e
            int r1 = r2.collapsedOffset
            int r1 = r3 - r1
            int r1 = java.lang.Math.abs(r1)
            if (r3 >= r1) goto L_0x0077
            goto L_0x00aa
        L_0x0077:
            boolean r3 = r2.shouldSkipHalfExpandedStateWhenDragging()
            if (r3 == 0) goto L_0x00a9
            goto L_0x0092
        L_0x007e:
            int r0 = r3 - r1
            int r0 = java.lang.Math.abs(r0)
            int r1 = r2.collapsedOffset
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r0 >= r3) goto L_0x0092
            goto L_0x00a9
        L_0x008e:
            boolean r3 = r2.fitToContents
            if (r3 == 0) goto L_0x0094
        L_0x0092:
            r0 = 4
            goto L_0x00aa
        L_0x0094:
            int r3 = r4.getTop()
            int r0 = r2.halfExpandedOffset
            int r0 = r3 - r0
            int r0 = java.lang.Math.abs(r0)
            int r1 = r2.collapsedOffset
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r0 >= r3) goto L_0x0092
        L_0x00a9:
            r0 = 6
        L_0x00aa:
            r3 = 0
            r2.startSettling(r4, r0, r3)
            r2.nestedScrolled = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.onStopNestedScroll(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.View, int):void");
    }

    public boolean onTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v4, @NonNull MotionEvent motionEvent) {
        if (!v4.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.state == 1 && actionMasked == 0) {
            return true;
        }
        if (shouldHandleDraggingWithHelper()) {
            this.viewDragHelper.processTouchEvent(motionEvent);
        }
        if (actionMasked == 0) {
            reset();
        }
        if (this.velocityTracker == null) {
            this.velocityTracker = VelocityTracker.obtain();
        }
        this.velocityTracker.addMovement(motionEvent);
        if (shouldHandleDraggingWithHelper() && actionMasked == 2 && !this.ignoreEvents && Math.abs(((float) this.initialY) - motionEvent.getY()) > ((float) this.viewDragHelper.getTouchSlop())) {
            this.viewDragHelper.captureChildView(v4, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.ignoreEvents;
    }

    public void removeBottomSheetCallback(@NonNull BottomSheetCallback bottomSheetCallback) {
        this.callbacks.remove(bottomSheetCallback);
    }

    /* access modifiers changed from: package-private */
    public void setAccessibilityDelegateView(@Nullable View view) {
        WeakReference<View> weakReference;
        if (view != null || (weakReference = this.accessibilityDelegateViewRef) == null) {
            this.accessibilityDelegateViewRef = new WeakReference<>(view);
            updateAccessibilityActions(view, 1);
            return;
        }
        clearAccessibilityAction(weakReference.get(), 1);
        this.accessibilityDelegateViewRef = null;
    }

    @Deprecated
    public void setBottomSheetCallback(BottomSheetCallback bottomSheetCallback) {
        Log.w(TAG, "BottomSheetBehavior now supports multiple callbacks. `setBottomSheetCallback()` removes all existing callbacks, including ones set internally by library authors, which may result in unintended behavior. This may change in the future. Please use `addBottomSheetCallback()` and `removeBottomSheetCallback()` instead to set your own callbacks.");
        this.callbacks.clear();
        if (bottomSheetCallback != null) {
            this.callbacks.add(bottomSheetCallback);
        }
    }

    public void setDraggable(boolean z4) {
        this.draggable = z4;
    }

    public void setExpandedOffset(int i4) {
        if (i4 >= 0) {
            this.expandedOffset = i4;
            updateDrawableForTargetState(this.state, true);
            return;
        }
        throw new IllegalArgumentException("offset must be greater than or equal to 0");
    }

    public void setFitToContents(boolean z4) {
        int i4;
        if (this.fitToContents != z4) {
            this.fitToContents = z4;
            if (this.viewRef != null) {
                calculateCollapsedOffset();
            }
            if (!this.fitToContents || this.state != 6) {
                i4 = this.state;
            } else {
                i4 = 3;
            }
            setStateInternal(i4);
            updateDrawableForTargetState(this.state, true);
            updateAccessibilityActions();
        }
    }

    public void setGestureInsetBottomIgnored(boolean z4) {
        this.gestureInsetBottomIgnored = z4;
    }

    public void setHalfExpandedRatio(@FloatRange(from = 0.0d, fromInclusive = false, to = 1.0d, toInclusive = false) float f4) {
        if (f4 <= 0.0f || f4 >= 1.0f) {
            throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
        }
        this.halfExpandedRatio = f4;
        if (this.viewRef != null) {
            calculateHalfExpandedOffset();
        }
    }

    public void setHideFriction(float f4) {
        this.hideFriction = f4;
    }

    public void setHideable(boolean z4) {
        if (this.hideable != z4) {
            this.hideable = z4;
            if (!z4 && this.state == 5) {
                setState(4);
            }
            updateAccessibilityActions();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setHideableInternal(boolean z4) {
        this.hideable = z4;
    }

    public void setMaxHeight(@Px int i4) {
        this.maxHeight = i4;
    }

    public void setMaxWidth(@Px int i4) {
        this.maxWidth = i4;
    }

    public void setPeekHeight(int i4) {
        setPeekHeight(i4, false);
    }

    public void setSaveFlags(int i4) {
        this.saveFlags = i4;
    }

    public void setShouldRemoveExpandedCorners(boolean z4) {
        if (this.shouldRemoveExpandedCorners != z4) {
            this.shouldRemoveExpandedCorners = z4;
            updateDrawableForTargetState(getState(), true);
        }
    }

    public void setSignificantVelocityThreshold(int i4) {
        this.significantVelocityThreshold = i4;
    }

    public void setSkipCollapsed(boolean z4) {
        this.skipCollapsed = z4;
    }

    public void setState(int i4) {
        String str;
        final int i5;
        if (i4 == 1 || i4 == 2) {
            StringBuilder sb = new StringBuilder();
            sb.append("STATE_");
            if (i4 == 1) {
                str = "DRAGGING";
            } else {
                str = "SETTLING";
            }
            sb.append(str);
            sb.append(" should not be set externally.");
            throw new IllegalArgumentException(sb.toString());
        } else if (this.hideable || i4 != 5) {
            if (i4 != 6 || !this.fitToContents || getTopOffsetForState(i4) > this.fitToContentsOffset) {
                i5 = i4;
            } else {
                i5 = 3;
            }
            WeakReference<V> weakReference = this.viewRef;
            if (weakReference == null || weakReference.get() == null) {
                setStateInternal(i4);
                return;
            }
            final View view = (View) this.viewRef.get();
            runAfterLayout(view, new Runnable() {
                public void run() {
                    BottomSheetBehavior.this.startSettling(view, i5, false);
                }
            });
        } else {
            Log.w(TAG, "Cannot set state: " + i4);
        }
    }

    /* access modifiers changed from: package-private */
    public void setStateInternal(int i4) {
        View view;
        if (this.state != i4) {
            this.state = i4;
            if (i4 == 4 || i4 == 3 || i4 == 6 || (this.hideable && i4 == 5)) {
                this.lastStableState = i4;
            }
            WeakReference<V> weakReference = this.viewRef;
            if (weakReference != null && (view = (View) weakReference.get()) != null) {
                if (i4 == 3) {
                    updateImportantForAccessibility(true);
                } else if (i4 == 6 || i4 == 5 || i4 == 4) {
                    updateImportantForAccessibility(false);
                }
                updateDrawableForTargetState(i4, true);
                for (int i5 = 0; i5 < this.callbacks.size(); i5++) {
                    this.callbacks.get(i5).onStateChanged(view, i4);
                }
                updateAccessibilityActions();
            }
        }
    }

    public void setUpdateImportantForAccessibilityOnSiblings(boolean z4) {
        this.updateImportantForAccessibilityOnSiblings = z4;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean shouldExpandOnUpwardDrag(long j4, @FloatRange(from = 0.0d, to = 100.0d) float f4) {
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean shouldHide(@NonNull View view, float f4) {
        if (this.skipCollapsed) {
            return true;
        }
        if (!isHideableWhenDragging() || view.getTop() < this.collapsedOffset) {
            return false;
        }
        if (Math.abs((((float) view.getTop()) + (f4 * this.hideFriction)) - ((float) this.collapsedOffset)) / ((float) calculatePeekHeight()) > 0.5f) {
            return true;
        }
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean shouldSkipHalfExpandedStateWhenDragging() {
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean shouldSkipSmoothAnimation() {
        return true;
    }

    public void startBackProgress(@NonNull BackEventCompat backEventCompat) {
        MaterialBottomContainerBackHelper materialBottomContainerBackHelper = this.bottomContainerBackHelper;
        if (materialBottomContainerBackHelper != null) {
            materialBottomContainerBackHelper.startBackProgress(backEventCompat);
        }
    }

    public void updateBackProgress(@NonNull BackEventCompat backEventCompat) {
        MaterialBottomContainerBackHelper materialBottomContainerBackHelper = this.bottomContainerBackHelper;
        if (materialBottomContainerBackHelper != null) {
            materialBottomContainerBackHelper.updateBackProgress(backEventCompat);
        }
    }

    public final void setPeekHeight(int i4, boolean z4) {
        if (i4 == -1) {
            if (!this.peekHeightAuto) {
                this.peekHeightAuto = true;
            } else {
                return;
            }
        } else if (this.peekHeightAuto || this.peekHeight != i4) {
            this.peekHeightAuto = false;
            this.peekHeight = Math.max(0, i4);
        } else {
            return;
        }
        updatePeekHeight(z4);
    }

    private void updateAccessibilityActions(View view, int i4) {
        if (view != null) {
            clearAccessibilityAction(view, i4);
            int i5 = 6;
            if (!this.fitToContents && this.state != 6) {
                this.expandHalfwayActionIds.put(i4, addAccessibilityActionForState(view, R.string.bottomsheet_action_expand_halfway, 6));
            }
            if (this.hideable && isHideableWhenDragging() && this.state != 5) {
                replaceAccessibilityActionForState(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_DISMISS, 5);
            }
            int i6 = this.state;
            if (i6 == 3) {
                if (this.fitToContents) {
                    i5 = 4;
                }
                replaceAccessibilityActionForState(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_COLLAPSE, i5);
            } else if (i6 == 4) {
                if (this.fitToContents) {
                    i5 = 3;
                }
                replaceAccessibilityActionForState(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_EXPAND, i5);
            } else if (i6 == 6) {
                replaceAccessibilityActionForState(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_COLLAPSE, 4);
                replaceAccessibilityActionForState(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_EXPAND, 3);
            }
        }
    }

    public BottomSheetBehavior(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        int i4;
        this.peekHeightGestureInsetBuffer = context.getResources().getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BottomSheetBehavior_Layout);
        int i5 = R.styleable.BottomSheetBehavior_Layout_backgroundTint;
        if (obtainStyledAttributes.hasValue(i5)) {
            this.backgroundTint = MaterialResources.getColorStateList(context, obtainStyledAttributes, i5);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.BottomSheetBehavior_Layout_shapeAppearance)) {
            this.shapeAppearanceModelDefault = ShapeAppearanceModel.builder(context, attributeSet, R.attr.bottomSheetStyle, DEF_STYLE_RES).build();
        }
        createMaterialShapeDrawableIfNeeded(context);
        createShapeValueAnimator();
        this.elevation = obtainStyledAttributes.getDimension(R.styleable.BottomSheetBehavior_Layout_android_elevation, -1.0f);
        int i6 = R.styleable.BottomSheetBehavior_Layout_android_maxWidth;
        if (obtainStyledAttributes.hasValue(i6)) {
            setMaxWidth(obtainStyledAttributes.getDimensionPixelSize(i6, -1));
        }
        int i7 = R.styleable.BottomSheetBehavior_Layout_android_maxHeight;
        if (obtainStyledAttributes.hasValue(i7)) {
            setMaxHeight(obtainStyledAttributes.getDimensionPixelSize(i7, -1));
        }
        int i8 = R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight;
        TypedValue peekValue = obtainStyledAttributes.peekValue(i8);
        if (peekValue == null || (i4 = peekValue.data) != -1) {
            setPeekHeight(obtainStyledAttributes.getDimensionPixelSize(i8, -1));
        } else {
            setPeekHeight(i4);
        }
        setHideable(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_hideable, false));
        setGestureInsetBottomIgnored(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_gestureInsetBottomIgnored, false));
        setFitToContents(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_fitToContents, true));
        setSkipCollapsed(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_skipCollapsed, false));
        setDraggable(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_draggable, true));
        setSaveFlags(obtainStyledAttributes.getInt(R.styleable.BottomSheetBehavior_Layout_behavior_saveFlags, 0));
        setHalfExpandedRatio(obtainStyledAttributes.getFloat(R.styleable.BottomSheetBehavior_Layout_behavior_halfExpandedRatio, 0.5f));
        int i9 = R.styleable.BottomSheetBehavior_Layout_behavior_expandedOffset;
        TypedValue peekValue2 = obtainStyledAttributes.peekValue(i9);
        if (peekValue2 == null || peekValue2.type != 16) {
            setExpandedOffset(obtainStyledAttributes.getDimensionPixelOffset(i9, 0));
        } else {
            setExpandedOffset(peekValue2.data);
        }
        setSignificantVelocityThreshold(obtainStyledAttributes.getInt(R.styleable.BottomSheetBehavior_Layout_behavior_significantVelocityThreshold, 500));
        this.paddingBottomSystemWindowInsets = obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_paddingBottomSystemWindowInsets, false);
        this.paddingLeftSystemWindowInsets = obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_paddingLeftSystemWindowInsets, false);
        this.paddingRightSystemWindowInsets = obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_paddingRightSystemWindowInsets, false);
        this.paddingTopSystemWindowInsets = obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_paddingTopSystemWindowInsets, true);
        this.marginLeftSystemWindowInsets = obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_marginLeftSystemWindowInsets, false);
        this.marginRightSystemWindowInsets = obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_marginRightSystemWindowInsets, false);
        this.marginTopSystemWindowInsets = obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_marginTopSystemWindowInsets, false);
        this.shouldRemoveExpandedCorners = obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_shouldRemoveExpandedCorners, true);
        obtainStyledAttributes.recycle();
        this.maximumVelocity = (float) ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }
}
