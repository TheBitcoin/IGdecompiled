package androidx.leanback.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
import androidx.annotation.VisibleForTesting;
import androidx.leanback.R;
import java.util.ArrayList;

public class BaseCardView extends FrameLayout {
    public static final int CARD_REGION_VISIBLE_ACTIVATED = 1;
    public static final int CARD_REGION_VISIBLE_ALWAYS = 0;
    public static final int CARD_REGION_VISIBLE_SELECTED = 2;
    public static final int CARD_TYPE_INFO_OVER = 1;
    public static final int CARD_TYPE_INFO_UNDER = 2;
    public static final int CARD_TYPE_INFO_UNDER_WITH_EXTRA = 3;
    private static final int CARD_TYPE_INVALID = 4;
    public static final int CARD_TYPE_MAIN_ONLY = 0;
    private static final boolean DEBUG = false;
    private static final int[] LB_PRESSED_STATE_SET = {16842919};
    private static final String TAG = "BaseCardView";
    private final int mActivatedAnimDuration;
    private Animation mAnim;
    private final Runnable mAnimationTrigger;
    private int mCardType;
    private boolean mDelaySelectedAnim;
    ArrayList<View> mExtraViewList;
    private int mExtraVisibility;
    float mInfoAlpha;
    float mInfoOffset;
    ArrayList<View> mInfoViewList;
    float mInfoVisFraction;
    private int mInfoVisibility;
    private ArrayList<View> mMainViewList;
    private int mMeasuredHeight;
    private int mMeasuredWidth;
    private final int mSelectedAnimDuration;
    private int mSelectedAnimationDelay;

    class AnimationBase extends Animation {
        AnimationBase() {
        }

        /* access modifiers changed from: package-private */
        @VisibleForTesting
        public final void mockEnd() {
            applyTransformation(1.0f, (Transformation) null);
            BaseCardView.this.cancelAnimations();
        }

        /* access modifiers changed from: package-private */
        @VisibleForTesting
        public final void mockStart() {
            getTransformation(0, (Transformation) null);
        }
    }

    final class InfoAlphaAnimation extends AnimationBase {
        private float mDelta;
        private float mStartValue;

        public InfoAlphaAnimation(float f4, float f5) {
            super();
            this.mStartValue = f4;
            this.mDelta = f5 - f4;
        }

        /* access modifiers changed from: protected */
        public void applyTransformation(float f4, Transformation transformation) {
            BaseCardView.this.mInfoAlpha = this.mStartValue + (f4 * this.mDelta);
            for (int i4 = 0; i4 < BaseCardView.this.mInfoViewList.size(); i4++) {
                BaseCardView.this.mInfoViewList.get(i4).setAlpha(BaseCardView.this.mInfoAlpha);
            }
        }
    }

    final class InfoHeightAnimation extends AnimationBase {
        private float mDelta;
        private float mStartValue;

        public InfoHeightAnimation(float f4, float f5) {
            super();
            this.mStartValue = f4;
            this.mDelta = f5 - f4;
        }

        /* access modifiers changed from: protected */
        public void applyTransformation(float f4, Transformation transformation) {
            BaseCardView baseCardView = BaseCardView.this;
            baseCardView.mInfoVisFraction = this.mStartValue + (f4 * this.mDelta);
            baseCardView.requestLayout();
        }
    }

    final class InfoOffsetAnimation extends AnimationBase {
        private float mDelta;
        private float mStartValue;

        public InfoOffsetAnimation(float f4, float f5) {
            super();
            this.mStartValue = f4;
            this.mDelta = f5 - f4;
        }

        /* access modifiers changed from: protected */
        public void applyTransformation(float f4, Transformation transformation) {
            BaseCardView baseCardView = BaseCardView.this;
            baseCardView.mInfoOffset = this.mStartValue + (f4 * this.mDelta);
            baseCardView.requestLayout();
        }
    }

    public BaseCardView(Context context) {
        this(context, (AttributeSet) null);
    }

    private void animateInfoAlpha(boolean z4) {
        float f4;
        cancelAnimations();
        if (z4) {
            for (int i4 = 0; i4 < this.mInfoViewList.size(); i4++) {
                this.mInfoViewList.get(i4).setVisibility(0);
            }
        }
        float f5 = 0.0f;
        if (z4) {
            f4 = 1.0f;
        } else {
            f4 = 0.0f;
        }
        if (f4 != this.mInfoAlpha) {
            float f6 = this.mInfoAlpha;
            if (z4) {
                f5 = 1.0f;
            }
            InfoAlphaAnimation infoAlphaAnimation = new InfoAlphaAnimation(f6, f5);
            this.mAnim = infoAlphaAnimation;
            infoAlphaAnimation.setDuration((long) this.mActivatedAnimDuration);
            this.mAnim.setInterpolator(new DecelerateInterpolator());
            this.mAnim.setAnimationListener(new Animation.AnimationListener() {
                public void onAnimationEnd(Animation animation) {
                    if (((double) BaseCardView.this.mInfoAlpha) == 0.0d) {
                        for (int i4 = 0; i4 < BaseCardView.this.mInfoViewList.size(); i4++) {
                            BaseCardView.this.mInfoViewList.get(i4).setVisibility(8);
                        }
                    }
                }

                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                }
            });
            startAnimation(this.mAnim);
        }
    }

    private void animateInfoHeight(boolean z4) {
        float f4;
        cancelAnimations();
        if (z4) {
            for (int i4 = 0; i4 < this.mInfoViewList.size(); i4++) {
                this.mInfoViewList.get(i4).setVisibility(0);
            }
        }
        if (z4) {
            f4 = 1.0f;
        } else {
            f4 = 0.0f;
        }
        if (this.mInfoVisFraction != f4) {
            InfoHeightAnimation infoHeightAnimation = new InfoHeightAnimation(this.mInfoVisFraction, f4);
            this.mAnim = infoHeightAnimation;
            infoHeightAnimation.setDuration((long) this.mSelectedAnimDuration);
            this.mAnim.setInterpolator(new AccelerateDecelerateInterpolator());
            this.mAnim.setAnimationListener(new Animation.AnimationListener() {
                public void onAnimationEnd(Animation animation) {
                    if (BaseCardView.this.mInfoVisFraction == 0.0f) {
                        for (int i4 = 0; i4 < BaseCardView.this.mInfoViewList.size(); i4++) {
                            BaseCardView.this.mInfoViewList.get(i4).setVisibility(8);
                        }
                    }
                }

                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                }
            });
            startAnimation(this.mAnim);
        }
    }

    private void applyActiveState(boolean z4) {
        int i4;
        if (hasInfoRegion() && (i4 = this.mInfoVisibility) == 1) {
            setInfoViewVisibility(isRegionVisible(i4));
        }
    }

    private void applySelectedState(boolean z4) {
        removeCallbacks(this.mAnimationTrigger);
        if (this.mCardType == 3) {
            if (!z4) {
                animateInfoOffset(false);
            } else if (!this.mDelaySelectedAnim) {
                post(this.mAnimationTrigger);
                this.mDelaySelectedAnim = true;
            } else {
                postDelayed(this.mAnimationTrigger, (long) this.mSelectedAnimationDelay);
            }
        } else if (this.mInfoVisibility == 2) {
            setInfoViewVisibility(z4);
        }
    }

    private void findChildrenViews() {
        boolean z4;
        boolean z5;
        this.mMainViewList.clear();
        this.mInfoViewList.clear();
        this.mExtraViewList.clear();
        int childCount = getChildCount();
        if (!hasInfoRegion() || !isCurrentRegionVisible(this.mInfoVisibility)) {
            z4 = false;
        } else {
            z4 = true;
        }
        if (!hasExtraRegion() || this.mInfoOffset <= 0.0f) {
            z5 = false;
        } else {
            z5 = true;
        }
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (childAt != null) {
                int i5 = ((LayoutParams) childAt.getLayoutParams()).viewType;
                int i6 = 8;
                if (i5 == 1) {
                    childAt.setAlpha(this.mInfoAlpha);
                    this.mInfoViewList.add(childAt);
                    if (z4) {
                        i6 = 0;
                    }
                    childAt.setVisibility(i6);
                } else if (i5 == 2) {
                    this.mExtraViewList.add(childAt);
                    if (z5) {
                        i6 = 0;
                    }
                    childAt.setVisibility(i6);
                } else {
                    this.mMainViewList.add(childAt);
                    childAt.setVisibility(0);
                }
            }
        }
    }

    private boolean hasExtraRegion() {
        if (this.mCardType == 3) {
            return true;
        }
        return false;
    }

    private boolean hasInfoRegion() {
        if (this.mCardType != 0) {
            return true;
        }
        return false;
    }

    private boolean isCurrentRegionVisible(int i4) {
        if (i4 == 0) {
            return true;
        }
        if (i4 == 1) {
            return isActivated();
        }
        if (i4 != 2) {
            return false;
        }
        if (this.mCardType != 2) {
            return isSelected();
        }
        if (this.mInfoVisFraction > 0.0f) {
            return true;
        }
        return false;
    }

    private boolean isRegionVisible(int i4) {
        if (i4 == 0) {
            return true;
        }
        if (i4 == 1) {
            return isActivated();
        }
        if (i4 != 2) {
            return false;
        }
        return isSelected();
    }

    private void setInfoViewVisibility(boolean z4) {
        int i4;
        int i5 = this.mCardType;
        if (i5 == 3) {
            if (z4) {
                for (int i6 = 0; i6 < this.mInfoViewList.size(); i6++) {
                    this.mInfoViewList.get(i6).setVisibility(0);
                }
                return;
            }
            for (int i7 = 0; i7 < this.mInfoViewList.size(); i7++) {
                this.mInfoViewList.get(i7).setVisibility(8);
            }
            for (int i8 = 0; i8 < this.mExtraViewList.size(); i8++) {
                this.mExtraViewList.get(i8).setVisibility(8);
            }
            this.mInfoOffset = 0.0f;
        } else if (i5 == 2) {
            if (this.mInfoVisibility == 2) {
                animateInfoHeight(z4);
                return;
            }
            for (int i9 = 0; i9 < this.mInfoViewList.size(); i9++) {
                View view = this.mInfoViewList.get(i9);
                if (z4) {
                    i4 = 0;
                } else {
                    i4 = 8;
                }
                view.setVisibility(i4);
            }
        } else if (i5 == 1) {
            animateInfoAlpha(z4);
        }
    }

    /* access modifiers changed from: package-private */
    public void animateInfoOffset(boolean z4) {
        float f4;
        cancelAnimations();
        int i4 = 0;
        if (z4) {
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.mMeasuredWidth, 1073741824);
            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
            int i5 = 0;
            for (int i6 = 0; i6 < this.mExtraViewList.size(); i6++) {
                View view = this.mExtraViewList.get(i6);
                view.setVisibility(0);
                view.measure(makeMeasureSpec, makeMeasureSpec2);
                i5 = Math.max(i5, view.getMeasuredHeight());
            }
            i4 = i5;
        }
        float f5 = this.mInfoOffset;
        if (z4) {
            f4 = (float) i4;
        } else {
            f4 = 0.0f;
        }
        InfoOffsetAnimation infoOffsetAnimation = new InfoOffsetAnimation(f5, f4);
        this.mAnim = infoOffsetAnimation;
        infoOffsetAnimation.setDuration((long) this.mSelectedAnimDuration);
        this.mAnim.setInterpolator(new AccelerateDecelerateInterpolator());
        this.mAnim.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationEnd(Animation animation) {
                if (BaseCardView.this.mInfoOffset == 0.0f) {
                    for (int i4 = 0; i4 < BaseCardView.this.mExtraViewList.size(); i4++) {
                        BaseCardView.this.mExtraViewList.get(i4).setVisibility(8);
                    }
                }
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }
        });
        startAnimation(this.mAnim);
    }

    /* access modifiers changed from: package-private */
    public void cancelAnimations() {
        Animation animation = this.mAnim;
        if (animation != null) {
            animation.cancel();
            this.mAnim = null;
            clearAnimation();
        }
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public int getCardType() {
        return this.mCardType;
    }

    @Deprecated
    public int getExtraVisibility() {
        return this.mExtraVisibility;
    }

    /* access modifiers changed from: package-private */
    public final float getFinalInfoAlpha() {
        if (this.mCardType == 1 && this.mInfoVisibility == 2 && !isSelected()) {
            return 0.0f;
        }
        return 1.0f;
    }

    /* access modifiers changed from: package-private */
    public final float getFinalInfoVisFraction() {
        if (this.mCardType == 2 && this.mInfoVisibility == 2 && !isSelected()) {
            return 0.0f;
        }
        return 1.0f;
    }

    public int getInfoVisibility() {
        return this.mInfoVisibility;
    }

    public boolean isSelectedAnimationDelayed() {
        return this.mDelaySelectedAnim;
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int i4) {
        boolean z4 = false;
        boolean z5 = false;
        for (int i5 : super.onCreateDrawableState(i4)) {
            if (i5 == 16842919) {
                z4 = true;
            }
            if (i5 == 16842910) {
                z5 = true;
            }
        }
        if (z4 && z5) {
            return View.PRESSED_ENABLED_STATE_SET;
        }
        if (z4) {
            return LB_PRESSED_STATE_SET;
        }
        if (z5) {
            return View.ENABLED_STATE_SET;
        }
        return View.EMPTY_STATE_SET;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.mAnimationTrigger);
        cancelAnimations();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        float paddingTop = (float) getPaddingTop();
        for (int i8 = 0; i8 < this.mMainViewList.size(); i8++) {
            View view = this.mMainViewList.get(i8);
            if (view.getVisibility() != 8) {
                view.layout(getPaddingLeft(), (int) paddingTop, this.mMeasuredWidth + getPaddingLeft(), (int) (((float) view.getMeasuredHeight()) + paddingTop));
                paddingTop += (float) view.getMeasuredHeight();
            }
        }
        if (hasInfoRegion()) {
            float f4 = 0.0f;
            for (int i9 = 0; i9 < this.mInfoViewList.size(); i9++) {
                f4 += (float) this.mInfoViewList.get(i9).getMeasuredHeight();
            }
            int i10 = this.mCardType;
            if (i10 == 1) {
                paddingTop -= f4;
                if (paddingTop < 0.0f) {
                    paddingTop = 0.0f;
                }
            } else if (i10 != 2) {
                paddingTop -= this.mInfoOffset;
            } else if (this.mInfoVisibility == 2) {
                f4 *= this.mInfoVisFraction;
            }
            for (int i11 = 0; i11 < this.mInfoViewList.size(); i11++) {
                View view2 = this.mInfoViewList.get(i11);
                if (view2.getVisibility() != 8) {
                    int measuredHeight = view2.getMeasuredHeight();
                    if (((float) measuredHeight) > f4) {
                        measuredHeight = (int) f4;
                    }
                    float f5 = (float) measuredHeight;
                    paddingTop += f5;
                    view2.layout(getPaddingLeft(), (int) paddingTop, this.mMeasuredWidth + getPaddingLeft(), (int) paddingTop);
                    f4 -= f5;
                    if (f4 <= 0.0f) {
                        break;
                    }
                }
            }
            if (hasExtraRegion()) {
                for (int i12 = 0; i12 < this.mExtraViewList.size(); i12++) {
                    View view3 = this.mExtraViewList.get(i12);
                    if (view3.getVisibility() != 8) {
                        view3.layout(getPaddingLeft(), (int) paddingTop, this.mMeasuredWidth + getPaddingLeft(), (int) (((float) view3.getMeasuredHeight()) + paddingTop));
                        paddingTop += (float) view3.getMeasuredHeight();
                    }
                }
            }
        }
        onSizeChanged(0, 0, i6 - i4, i7 - i5);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00e1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r14, int r15) {
        /*
            r13 = this;
            r0 = 0
            r13.mMeasuredWidth = r0
            r13.mMeasuredHeight = r0
            r13.findChildrenViews()
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r0)
            r2 = 0
            r3 = 0
            r4 = 0
        L_0x000f:
            java.util.ArrayList<android.view.View> r5 = r13.mMainViewList
            int r5 = r5.size()
            r6 = 8
            if (r2 >= r5) goto L_0x0046
            java.util.ArrayList<android.view.View> r5 = r13.mMainViewList
            java.lang.Object r5 = r5.get(r2)
            android.view.View r5 = (android.view.View) r5
            int r7 = r5.getVisibility()
            if (r7 == r6) goto L_0x0043
            r13.measureChild(r5, r1, r1)
            int r6 = r13.mMeasuredWidth
            int r7 = r5.getMeasuredWidth()
            int r6 = java.lang.Math.max(r6, r7)
            r13.mMeasuredWidth = r6
            int r6 = r5.getMeasuredHeight()
            int r3 = r3 + r6
            int r5 = r5.getMeasuredState()
            int r4 = android.view.View.combineMeasuredStates(r4, r5)
        L_0x0043:
            int r2 = r2 + 1
            goto L_0x000f
        L_0x0046:
            int r2 = r13.mMeasuredWidth
            r5 = 2
            int r2 = r2 / r5
            float r2 = (float) r2
            r13.setPivotX(r2)
            int r2 = r3 / 2
            float r2 = (float) r2
            r13.setPivotY(r2)
            int r2 = r13.mMeasuredWidth
            r7 = 1073741824(0x40000000, float:2.0)
            int r2 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r7)
            boolean r7 = r13.hasInfoRegion()
            r8 = 1
            if (r7 == 0) goto L_0x00c5
            r7 = 0
            r9 = 0
        L_0x0065:
            java.util.ArrayList<android.view.View> r10 = r13.mInfoViewList
            int r10 = r10.size()
            if (r7 >= r10) goto L_0x0092
            java.util.ArrayList<android.view.View> r10 = r13.mInfoViewList
            java.lang.Object r10 = r10.get(r7)
            android.view.View r10 = (android.view.View) r10
            int r11 = r10.getVisibility()
            if (r11 == r6) goto L_0x008f
            r13.measureChild(r10, r2, r1)
            int r11 = r13.mCardType
            if (r11 == r8) goto L_0x0087
            int r11 = r10.getMeasuredHeight()
            int r9 = r9 + r11
        L_0x0087:
            int r10 = r10.getMeasuredState()
            int r4 = android.view.View.combineMeasuredStates(r4, r10)
        L_0x008f:
            int r7 = r7 + 1
            goto L_0x0065
        L_0x0092:
            boolean r7 = r13.hasExtraRegion()
            if (r7 == 0) goto L_0x00c3
            r7 = 0
            r10 = 0
        L_0x009a:
            java.util.ArrayList<android.view.View> r11 = r13.mExtraViewList
            int r11 = r11.size()
            if (r7 >= r11) goto L_0x00c7
            java.util.ArrayList<android.view.View> r11 = r13.mExtraViewList
            java.lang.Object r11 = r11.get(r7)
            android.view.View r11 = (android.view.View) r11
            int r12 = r11.getVisibility()
            if (r12 == r6) goto L_0x00c0
            r13.measureChild(r11, r2, r1)
            int r12 = r11.getMeasuredHeight()
            int r10 = r10 + r12
            int r11 = r11.getMeasuredState()
            int r4 = android.view.View.combineMeasuredStates(r4, r11)
        L_0x00c0:
            int r7 = r7 + 1
            goto L_0x009a
        L_0x00c3:
            r10 = 0
            goto L_0x00c7
        L_0x00c5:
            r9 = 0
            goto L_0x00c3
        L_0x00c7:
            boolean r1 = r13.hasInfoRegion()
            if (r1 == 0) goto L_0x00d2
            int r1 = r13.mInfoVisibility
            if (r1 != r5) goto L_0x00d2
            r0 = 1
        L_0x00d2:
            float r1 = (float) r3
            float r2 = (float) r9
            if (r0 == 0) goto L_0x00da
            float r3 = r13.mInfoVisFraction
            float r2 = r2 * r3
        L_0x00da:
            float r1 = r1 + r2
            float r2 = (float) r10
            float r1 = r1 + r2
            if (r0 == 0) goto L_0x00e1
            r0 = 0
            goto L_0x00e3
        L_0x00e1:
            float r0 = r13.mInfoOffset
        L_0x00e3:
            float r1 = r1 - r0
            int r0 = (int) r1
            r13.mMeasuredHeight = r0
            int r0 = r13.mMeasuredWidth
            int r1 = r13.getPaddingLeft()
            int r0 = r0 + r1
            int r1 = r13.getPaddingRight()
            int r0 = r0 + r1
            int r14 = android.view.View.resolveSizeAndState(r0, r14, r4)
            int r0 = r13.mMeasuredHeight
            int r1 = r13.getPaddingTop()
            int r0 = r0 + r1
            int r1 = r13.getPaddingBottom()
            int r0 = r0 + r1
            int r1 = r4 << 16
            int r15 = android.view.View.resolveSizeAndState(r0, r15, r1)
            r13.setMeasuredDimension(r14, r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.leanback.widget.BaseCardView.onMeasure(int, int):void");
    }

    public void setActivated(boolean z4) {
        if (z4 != isActivated()) {
            super.setActivated(z4);
            applyActiveState(isActivated());
        }
    }

    public void setCardType(int i4) {
        if (this.mCardType != i4) {
            if (i4 < 0 || i4 >= 4) {
                Log.e(TAG, "Invalid card type specified: " + i4 + ". Defaulting to type CARD_TYPE_MAIN_ONLY.");
                this.mCardType = 0;
            } else {
                this.mCardType = i4;
            }
            requestLayout();
        }
    }

    @Deprecated
    public void setExtraVisibility(int i4) {
        if (this.mExtraVisibility != i4) {
            this.mExtraVisibility = i4;
        }
    }

    public void setInfoVisibility(int i4) {
        if (this.mInfoVisibility != i4) {
            cancelAnimations();
            this.mInfoVisibility = i4;
            this.mInfoVisFraction = getFinalInfoVisFraction();
            requestLayout();
            float finalInfoAlpha = getFinalInfoAlpha();
            if (finalInfoAlpha != this.mInfoAlpha) {
                this.mInfoAlpha = finalInfoAlpha;
                for (int i5 = 0; i5 < this.mInfoViewList.size(); i5++) {
                    this.mInfoViewList.get(i5).setAlpha(this.mInfoAlpha);
                }
            }
        }
    }

    public void setSelected(boolean z4) {
        if (z4 != isSelected()) {
            super.setSelected(z4);
            applySelectedState(isSelected());
        }
    }

    public void setSelectedAnimationDelayed(boolean z4) {
        this.mDelaySelectedAnim = z4;
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public String toString() {
        return super.toString();
    }

    public BaseCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.baseCardViewStyle);
    }

    public BaseCardView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.mAnimationTrigger = new Runnable() {
            public void run() {
                BaseCardView.this.animateInfoOffset(true);
            }
        };
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.lbBaseCardView, i4, 0);
        try {
            this.mCardType = obtainStyledAttributes.getInteger(R.styleable.lbBaseCardView_cardType, 0);
            Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.lbBaseCardView_cardForeground);
            if (drawable != null) {
                setForeground(drawable);
            }
            Drawable drawable2 = obtainStyledAttributes.getDrawable(R.styleable.lbBaseCardView_cardBackground);
            if (drawable2 != null) {
                setBackground(drawable2);
            }
            this.mInfoVisibility = obtainStyledAttributes.getInteger(R.styleable.lbBaseCardView_infoVisibility, 1);
            int integer = obtainStyledAttributes.getInteger(R.styleable.lbBaseCardView_extraVisibility, 2);
            this.mExtraVisibility = integer;
            int i5 = this.mInfoVisibility;
            if (integer < i5) {
                this.mExtraVisibility = i5;
            }
            this.mSelectedAnimationDelay = obtainStyledAttributes.getInteger(R.styleable.lbBaseCardView_selectedAnimationDelay, getResources().getInteger(R.integer.lb_card_selected_animation_delay));
            this.mSelectedAnimDuration = obtainStyledAttributes.getInteger(R.styleable.lbBaseCardView_selectedAnimationDuration, getResources().getInteger(R.integer.lb_card_selected_animation_duration));
            this.mActivatedAnimDuration = obtainStyledAttributes.getInteger(R.styleable.lbBaseCardView_activatedAnimationDuration, getResources().getInteger(R.integer.lb_card_activated_animation_duration));
            obtainStyledAttributes.recycle();
            this.mDelaySelectedAnim = true;
            this.mMainViewList = new ArrayList<>();
            this.mInfoViewList = new ArrayList<>();
            this.mExtraViewList = new ArrayList<>();
            this.mInfoOffset = 0.0f;
            this.mInfoVisFraction = getFinalInfoVisFraction();
            this.mInfoAlpha = getFinalInfoAlpha();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public static class LayoutParams extends FrameLayout.LayoutParams {
        public static final int VIEW_TYPE_EXTRA = 2;
        public static final int VIEW_TYPE_INFO = 1;
        public static final int VIEW_TYPE_MAIN = 0;
        @ViewDebug.ExportedProperty(category = "layout", mapping = {@ViewDebug.IntToString(from = 0, to = "MAIN"), @ViewDebug.IntToString(from = 1, to = "INFO"), @ViewDebug.IntToString(from = 2, to = "EXTRA")})
        public int viewType = 0;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.lbBaseCardView_Layout);
            this.viewType = obtainStyledAttributes.getInt(R.styleable.lbBaseCardView_Layout_layout_viewType, 0);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(int i4, int i5) {
            super(i4, i5);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.viewType = layoutParams.viewType;
        }
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }
}
