package androidx.leanback.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.ColorInt;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.leanback.R;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class PagingIndicator extends View {
    private static final TimeInterpolator DECELERATE_INTERPOLATOR = new DecelerateInterpolator();
    private static final Property<Dot, Float> DOT_ALPHA;
    private static final Property<Dot, Float> DOT_DIAMETER;
    private static final Property<Dot, Float> DOT_TRANSLATION_X;
    private static final long DURATION_ALPHA = 167;
    private static final long DURATION_DIAMETER = 417;
    private static final long DURATION_TRANSLATION_X = 417;
    private final AnimatorSet mAnimator;
    Bitmap mArrow;
    final int mArrowDiameter;
    private final int mArrowGap;
    Paint mArrowPaint;
    final int mArrowRadius;
    final Rect mArrowRect;
    final float mArrowToBgRatio;
    final Paint mBgPaint;
    private int mCurrentPage;
    int mDotCenterY;
    final int mDotDiameter;
    @ColorInt
    int mDotFgSelectColor;
    private final int mDotGap;
    final int mDotRadius;
    private int[] mDotSelectedNextX;
    private int[] mDotSelectedPrevX;
    private int[] mDotSelectedX;
    private Dot[] mDots;
    final Paint mFgPaint;
    private final AnimatorSet mHideAnimator;
    boolean mIsLtr;
    private int mPageCount;
    private int mPreviousPage;
    private final int mShadowRadius;
    private final AnimatorSet mShowAnimator;

    public class Dot {
        static final float LEFT = -1.0f;
        static final float LTR = 1.0f;
        static final float RIGHT = 1.0f;
        static final float RTL = -1.0f;
        float mAlpha;
        float mArrowImageRadius;
        float mCenterX;
        float mDiameter;
        float mDirection = 1.0f;
        @ColorInt
        int mFgColor;
        float mLayoutDirection;
        float mRadius;
        float mTranslationX;

        public Dot() {
            float f4 = 1.0f;
            this.mLayoutDirection = !PagingIndicator.this.mIsLtr ? -1.0f : f4;
        }

        public void adjustAlpha() {
            this.mFgColor = Color.argb(Math.round(this.mAlpha * 255.0f), Color.red(PagingIndicator.this.mDotFgSelectColor), Color.green(PagingIndicator.this.mDotFgSelectColor), Color.blue(PagingIndicator.this.mDotFgSelectColor));
        }

        /* access modifiers changed from: package-private */
        public void deselect() {
            this.mTranslationX = 0.0f;
            this.mCenterX = 0.0f;
            PagingIndicator pagingIndicator = PagingIndicator.this;
            this.mDiameter = (float) pagingIndicator.mDotDiameter;
            float f4 = (float) pagingIndicator.mDotRadius;
            this.mRadius = f4;
            this.mArrowImageRadius = f4 * pagingIndicator.mArrowToBgRatio;
            this.mAlpha = 0.0f;
            adjustAlpha();
        }

        /* access modifiers changed from: package-private */
        public void draw(Canvas canvas) {
            float f4 = this.mCenterX + this.mTranslationX;
            PagingIndicator pagingIndicator = PagingIndicator.this;
            canvas.drawCircle(f4, (float) pagingIndicator.mDotCenterY, this.mRadius, pagingIndicator.mBgPaint);
            if (this.mAlpha > 0.0f) {
                PagingIndicator.this.mFgPaint.setColor(this.mFgColor);
                PagingIndicator pagingIndicator2 = PagingIndicator.this;
                canvas.drawCircle(f4, (float) pagingIndicator2.mDotCenterY, this.mRadius, pagingIndicator2.mFgPaint);
                PagingIndicator pagingIndicator3 = PagingIndicator.this;
                Bitmap bitmap = pagingIndicator3.mArrow;
                Rect rect = pagingIndicator3.mArrowRect;
                float f5 = this.mArrowImageRadius;
                int i4 = PagingIndicator.this.mDotCenterY;
                canvas.drawBitmap(bitmap, rect, new Rect((int) (f4 - f5), (int) (((float) i4) - f5), (int) (f4 + f5), (int) (((float) i4) + f5)), PagingIndicator.this.mArrowPaint);
            }
        }

        public float getAlpha() {
            return this.mAlpha;
        }

        public float getDiameter() {
            return this.mDiameter;
        }

        public float getTranslationX() {
            return this.mTranslationX;
        }

        /* access modifiers changed from: package-private */
        public void onRtlPropertiesChanged() {
            float f4;
            if (PagingIndicator.this.mIsLtr) {
                f4 = 1.0f;
            } else {
                f4 = -1.0f;
            }
            this.mLayoutDirection = f4;
        }

        /* access modifiers changed from: package-private */
        public void select() {
            this.mTranslationX = 0.0f;
            this.mCenterX = 0.0f;
            PagingIndicator pagingIndicator = PagingIndicator.this;
            this.mDiameter = (float) pagingIndicator.mArrowDiameter;
            float f4 = (float) pagingIndicator.mArrowRadius;
            this.mRadius = f4;
            this.mArrowImageRadius = f4 * pagingIndicator.mArrowToBgRatio;
            this.mAlpha = 1.0f;
            adjustAlpha();
        }

        public void setAlpha(float f4) {
            this.mAlpha = f4;
            adjustAlpha();
            PagingIndicator.this.invalidate();
        }

        public void setDiameter(float f4) {
            this.mDiameter = f4;
            float f5 = f4 / 2.0f;
            this.mRadius = f5;
            PagingIndicator pagingIndicator = PagingIndicator.this;
            this.mArrowImageRadius = f5 * pagingIndicator.mArrowToBgRatio;
            pagingIndicator.invalidate();
        }

        public void setTranslationX(float f4) {
            this.mTranslationX = f4 * this.mDirection * this.mLayoutDirection;
            PagingIndicator.this.invalidate();
        }
    }

    static {
        Class<Float> cls = Float.class;
        DOT_ALPHA = new Property<Dot, Float>(cls, "alpha") {
            public Float get(Dot dot) {
                return Float.valueOf(dot.getAlpha());
            }

            public void set(Dot dot, Float f4) {
                dot.setAlpha(f4.floatValue());
            }
        };
        DOT_DIAMETER = new Property<Dot, Float>(cls, "diameter") {
            public Float get(Dot dot) {
                return Float.valueOf(dot.getDiameter());
            }

            public void set(Dot dot, Float f4) {
                dot.setDiameter(f4.floatValue());
            }
        };
        DOT_TRANSLATION_X = new Property<Dot, Float>(cls, "translation_x") {
            public Float get(Dot dot) {
                return Float.valueOf(dot.getTranslationX());
            }

            public void set(Dot dot, Float f4) {
                dot.setTranslationX(f4.floatValue());
            }
        };
    }

    public PagingIndicator(Context context) {
        this(context, (AttributeSet) null, 0);
    }

    private void adjustDotPosition() {
        int i4;
        float f4;
        int i5 = 0;
        while (true) {
            i4 = this.mCurrentPage;
            f4 = -1.0f;
            if (i5 >= i4) {
                break;
            }
            this.mDots[i5].deselect();
            Dot dot = this.mDots[i5];
            if (i5 != this.mPreviousPage) {
                f4 = 1.0f;
            }
            dot.mDirection = f4;
            dot.mCenterX = (float) this.mDotSelectedPrevX[i5];
            i5++;
        }
        this.mDots[i4].select();
        Dot[] dotArr = this.mDots;
        int i6 = this.mCurrentPage;
        Dot dot2 = dotArr[i6];
        if (this.mPreviousPage >= i6) {
            f4 = 1.0f;
        }
        dot2.mDirection = f4;
        dot2.mCenterX = (float) this.mDotSelectedX[i6];
        while (true) {
            i6++;
            if (i6 < this.mPageCount) {
                this.mDots[i6].deselect();
                Dot dot3 = this.mDots[i6];
                dot3.mDirection = 1.0f;
                dot3.mCenterX = (float) this.mDotSelectedNextX[i6];
            } else {
                return;
            }
        }
    }

    private void calculateDotPositions() {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int width = getWidth() - getPaddingRight();
        int requiredWidth = getRequiredWidth();
        int i4 = (paddingLeft + width) / 2;
        int i5 = this.mPageCount;
        int[] iArr = new int[i5];
        this.mDotSelectedX = iArr;
        int[] iArr2 = new int[i5];
        this.mDotSelectedPrevX = iArr2;
        int[] iArr3 = new int[i5];
        this.mDotSelectedNextX = iArr3;
        int i6 = 1;
        if (this.mIsLtr) {
            int i7 = i4 - (requiredWidth / 2);
            int i8 = this.mDotRadius;
            int i9 = this.mDotGap;
            int i10 = this.mArrowGap;
            iArr[0] = ((i7 + i8) - i9) + i10;
            iArr2[0] = i7 + i8;
            iArr3[0] = ((i7 + i8) - (i9 * 2)) + (i10 * 2);
            while (i6 < this.mPageCount) {
                int[] iArr4 = this.mDotSelectedX;
                int[] iArr5 = this.mDotSelectedPrevX;
                int i11 = i6 - 1;
                int i12 = iArr5[i11];
                int i13 = this.mArrowGap;
                iArr4[i6] = i12 + i13;
                iArr5[i6] = iArr5[i11] + this.mDotGap;
                this.mDotSelectedNextX[i6] = iArr4[i11] + i13;
                i6++;
            }
        } else {
            int i14 = i4 + (requiredWidth / 2);
            int i15 = this.mDotRadius;
            int i16 = this.mDotGap;
            int i17 = this.mArrowGap;
            iArr[0] = ((i14 - i15) + i16) - i17;
            iArr2[0] = i14 - i15;
            iArr3[0] = ((i14 - i15) + (i16 * 2)) - (i17 * 2);
            while (i6 < this.mPageCount) {
                int[] iArr6 = this.mDotSelectedX;
                int[] iArr7 = this.mDotSelectedPrevX;
                int i18 = i6 - 1;
                int i19 = iArr7[i18];
                int i20 = this.mArrowGap;
                iArr6[i6] = i19 - i20;
                iArr7[i6] = iArr7[i18] - this.mDotGap;
                this.mDotSelectedNextX[i6] = iArr6[i18] - i20;
                i6++;
            }
        }
        this.mDotCenterY = paddingTop + this.mArrowRadius;
        adjustDotPosition();
    }

    private Animator createDotAlphaAnimator(float f4, float f5) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat((Object) null, DOT_ALPHA, new float[]{f4, f5});
        ofFloat.setDuration(DURATION_ALPHA);
        ofFloat.setInterpolator(DECELERATE_INTERPOLATOR);
        return ofFloat;
    }

    private Animator createDotDiameterAnimator(float f4, float f5) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat((Object) null, DOT_DIAMETER, new float[]{f4, f5});
        ofFloat.setDuration(417);
        ofFloat.setInterpolator(DECELERATE_INTERPOLATOR);
        return ofFloat;
    }

    private Animator createDotTranslationXAnimator() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat((Object) null, DOT_TRANSLATION_X, new float[]{(float) ((-this.mArrowGap) + this.mDotGap), 0.0f});
        ofFloat.setDuration(417);
        ofFloat.setInterpolator(DECELERATE_INTERPOLATOR);
        return ofFloat;
    }

    private int getColorFromTypedArray(TypedArray typedArray, int i4, int i5) {
        return typedArray.getColor(i4, getResources().getColor(i5));
    }

    private int getDesiredHeight() {
        return getPaddingTop() + this.mArrowDiameter + getPaddingBottom() + this.mShadowRadius;
    }

    private int getDesiredWidth() {
        return getPaddingLeft() + getRequiredWidth() + getPaddingRight();
    }

    private int getDimensionFromTypedArray(TypedArray typedArray, int i4, int i5) {
        return typedArray.getDimensionPixelOffset(i4, getResources().getDimensionPixelOffset(i5));
    }

    private int getRequiredWidth() {
        return (this.mDotRadius * 2) + (this.mArrowGap * 2) + ((this.mPageCount - 3) * this.mDotGap);
    }

    private Bitmap loadArrow() {
        Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), R.drawable.lb_ic_nav_arrow);
        if (this.mIsLtr) {
            return decodeResource;
        }
        Matrix matrix = new Matrix();
        matrix.preScale(-1.0f, 1.0f);
        return Bitmap.createBitmap(decodeResource, 0, 0, decodeResource.getWidth(), decodeResource.getHeight(), matrix, false);
    }

    private void setSelectedPage(int i4) {
        if (i4 != this.mCurrentPage) {
            this.mCurrentPage = i4;
            adjustDotPosition();
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public int[] getDotSelectedLeftX() {
        return this.mDotSelectedPrevX;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public int[] getDotSelectedRightX() {
        return this.mDotSelectedNextX;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public int[] getDotSelectedX() {
        return this.mDotSelectedX;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public int getPageCount() {
        return this.mPageCount;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        for (int i4 = 0; i4 < this.mPageCount; i4++) {
            this.mDots[i4].draw(canvas);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i4, int i5) {
        int desiredHeight = getDesiredHeight();
        int mode = View.MeasureSpec.getMode(i5);
        if (mode == Integer.MIN_VALUE) {
            desiredHeight = Math.min(desiredHeight, View.MeasureSpec.getSize(i5));
        } else if (mode == 1073741824) {
            desiredHeight = View.MeasureSpec.getSize(i5);
        }
        int desiredWidth = getDesiredWidth();
        int mode2 = View.MeasureSpec.getMode(i4);
        if (mode2 == Integer.MIN_VALUE) {
            desiredWidth = Math.min(desiredWidth, View.MeasureSpec.getSize(i4));
        } else if (mode2 == 1073741824) {
            desiredWidth = View.MeasureSpec.getSize(i4);
        }
        setMeasuredDimension(desiredWidth, desiredHeight);
    }

    public void onPageSelected(int i4, boolean z4) {
        if (this.mCurrentPage != i4) {
            if (this.mAnimator.isStarted()) {
                this.mAnimator.end();
            }
            int i5 = this.mCurrentPage;
            this.mPreviousPage = i5;
            if (z4) {
                this.mHideAnimator.setTarget(this.mDots[i5]);
                this.mShowAnimator.setTarget(this.mDots[i4]);
                this.mAnimator.start();
            }
            setSelectedPage(i4);
        }
    }

    public void onRtlPropertiesChanged(int i4) {
        boolean z4;
        super.onRtlPropertiesChanged(i4);
        if (i4 == 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (this.mIsLtr != z4) {
            this.mIsLtr = z4;
            this.mArrow = loadArrow();
            Dot[] dotArr = this.mDots;
            if (dotArr != null) {
                for (Dot onRtlPropertiesChanged : dotArr) {
                    onRtlPropertiesChanged.onRtlPropertiesChanged();
                }
            }
            calculateDotPositions();
            invalidate();
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i4, int i5, int i6, int i7) {
        setMeasuredDimension(i4, i5);
        calculateDotPositions();
    }

    public void setArrowBackgroundColor(@ColorInt int i4) {
        this.mDotFgSelectColor = i4;
    }

    public void setArrowColor(@ColorInt int i4) {
        if (this.mArrowPaint == null) {
            this.mArrowPaint = new Paint();
        }
        this.mArrowPaint.setColorFilter(new PorterDuffColorFilter(i4, PorterDuff.Mode.SRC_IN));
    }

    public void setDotBackgroundColor(@ColorInt int i4) {
        this.mBgPaint.setColor(i4);
    }

    public void setPageCount(int i4) {
        if (i4 > 0) {
            this.mPageCount = i4;
            this.mDots = new Dot[i4];
            for (int i5 = 0; i5 < this.mPageCount; i5++) {
                this.mDots[i5] = new Dot();
            }
            calculateDotPositions();
            setSelectedPage(0);
            return;
        }
        throw new IllegalArgumentException("The page count should be a positive integer");
    }

    public PagingIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PagingIndicator(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        AnimatorSet animatorSet = new AnimatorSet();
        this.mAnimator = animatorSet;
        Resources resources = getResources();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PagingIndicator, i4, 0);
        int dimensionFromTypedArray = getDimensionFromTypedArray(obtainStyledAttributes, R.styleable.PagingIndicator_lbDotRadius, R.dimen.lb_page_indicator_dot_radius);
        this.mDotRadius = dimensionFromTypedArray;
        this.mDotDiameter = dimensionFromTypedArray * 2;
        int dimensionFromTypedArray2 = getDimensionFromTypedArray(obtainStyledAttributes, R.styleable.PagingIndicator_arrowRadius, R.dimen.lb_page_indicator_arrow_radius);
        this.mArrowRadius = dimensionFromTypedArray2;
        int i5 = dimensionFromTypedArray2 * 2;
        this.mArrowDiameter = i5;
        this.mDotGap = getDimensionFromTypedArray(obtainStyledAttributes, R.styleable.PagingIndicator_dotToDotGap, R.dimen.lb_page_indicator_dot_gap);
        this.mArrowGap = getDimensionFromTypedArray(obtainStyledAttributes, R.styleable.PagingIndicator_dotToArrowGap, R.dimen.lb_page_indicator_arrow_gap);
        int colorFromTypedArray = getColorFromTypedArray(obtainStyledAttributes, R.styleable.PagingIndicator_dotBgColor, R.color.lb_page_indicator_dot);
        Paint paint = new Paint(1);
        this.mBgPaint = paint;
        paint.setColor(colorFromTypedArray);
        this.mDotFgSelectColor = getColorFromTypedArray(obtainStyledAttributes, R.styleable.PagingIndicator_arrowBgColor, R.color.lb_page_indicator_arrow_background);
        if (this.mArrowPaint == null) {
            int i6 = R.styleable.PagingIndicator_arrowColor;
            if (obtainStyledAttributes.hasValue(i6)) {
                setArrowColor(obtainStyledAttributes.getColor(i6, 0));
            }
        }
        obtainStyledAttributes.recycle();
        this.mIsLtr = resources.getConfiguration().getLayoutDirection() == 0;
        int color = resources.getColor(R.color.lb_page_indicator_arrow_shadow);
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.lb_page_indicator_arrow_shadow_radius);
        this.mShadowRadius = dimensionPixelSize;
        Paint paint2 = new Paint(1);
        this.mFgPaint = paint2;
        float dimensionPixelSize2 = (float) resources.getDimensionPixelSize(R.dimen.lb_page_indicator_arrow_shadow_offset);
        paint2.setShadowLayer((float) dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize2, color);
        this.mArrow = loadArrow();
        this.mArrowRect = new Rect(0, 0, this.mArrow.getWidth(), this.mArrow.getHeight());
        this.mArrowToBgRatio = ((float) this.mArrow.getWidth()) / ((float) i5);
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.mShowAnimator = animatorSet2;
        animatorSet2.playTogether(new Animator[]{createDotAlphaAnimator(0.0f, 1.0f), createDotDiameterAnimator((float) (dimensionFromTypedArray * 2), (float) (dimensionFromTypedArray2 * 2)), createDotTranslationXAnimator()});
        AnimatorSet animatorSet3 = new AnimatorSet();
        this.mHideAnimator = animatorSet3;
        animatorSet3.playTogether(new Animator[]{createDotAlphaAnimator(1.0f, 0.0f), createDotDiameterAnimator((float) (dimensionFromTypedArray2 * 2), (float) (dimensionFromTypedArray * 2)), createDotTranslationXAnimator()});
        animatorSet.playTogether(new Animator[]{animatorSet2, animatorSet3});
        setLayerType(1, (Paint) null);
    }
}
