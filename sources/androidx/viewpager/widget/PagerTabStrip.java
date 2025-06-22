package androidx.viewpager.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;

public class PagerTabStrip extends PagerTitleStrip {
    private static final int FULL_UNDERLINE_HEIGHT = 1;
    private static final int INDICATOR_HEIGHT = 3;
    private static final int MIN_PADDING_BOTTOM = 6;
    private static final int MIN_STRIP_HEIGHT = 32;
    private static final int MIN_TEXT_SPACING = 64;
    private static final int TAB_PADDING = 16;
    private static final int TAB_SPACING = 32;
    private static final String TAG = "PagerTabStrip";
    private boolean mDrawFullUnderline;
    private boolean mDrawFullUnderlineSet;
    private int mFullUnderlineHeight;
    private boolean mIgnoreTap;
    private int mIndicatorColor;
    private int mIndicatorHeight;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private int mMinPaddingBottom;
    private int mMinStripHeight;
    private int mMinTextSpacing;
    private int mTabAlpha;
    private int mTabPadding;
    private final Paint mTabPaint;
    private final Rect mTempRect;
    private int mTouchSlop;

    public PagerTabStrip(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    public boolean getDrawFullUnderline() {
        return this.mDrawFullUnderline;
    }

    /* access modifiers changed from: package-private */
    public int getMinHeight() {
        return Math.max(super.getMinHeight(), this.mMinStripHeight);
    }

    @ColorInt
    public int getTabIndicatorColor() {
        return this.mIndicatorColor;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        int left = this.mCurrText.getLeft() - this.mTabPadding;
        int right = this.mCurrText.getRight() + this.mTabPadding;
        this.mTabPaint.setColor((this.mTabAlpha << 24) | (this.mIndicatorColor & ViewCompat.MEASURED_SIZE_MASK));
        float f4 = (float) height;
        Canvas canvas2 = canvas;
        canvas2.drawRect((float) left, (float) (height - this.mIndicatorHeight), (float) right, f4, this.mTabPaint);
        Canvas canvas3 = canvas2;
        if (this.mDrawFullUnderline) {
            this.mTabPaint.setColor((this.mIndicatorColor & ViewCompat.MEASURED_SIZE_MASK) | ViewCompat.MEASURED_STATE_MASK);
            canvas3.drawRect((float) getPaddingLeft(), (float) (height - this.mFullUnderlineHeight), (float) (getWidth() - getPaddingRight()), f4, this.mTabPaint);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0 && this.mIgnoreTap) {
            return false;
        }
        float x4 = motionEvent.getX();
        float y4 = motionEvent.getY();
        if (action == 0) {
            this.mInitialMotionX = x4;
            this.mInitialMotionY = y4;
            this.mIgnoreTap = false;
        } else if (action != 1) {
            if (action == 2 && (Math.abs(x4 - this.mInitialMotionX) > ((float) this.mTouchSlop) || Math.abs(y4 - this.mInitialMotionY) > ((float) this.mTouchSlop))) {
                this.mIgnoreTap = true;
            }
        } else if (x4 < ((float) (this.mCurrText.getLeft() - this.mTabPadding))) {
            ViewPager viewPager = this.mPager;
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
        } else if (x4 > ((float) (this.mCurrText.getRight() + this.mTabPadding))) {
            ViewPager viewPager2 = this.mPager;
            viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
        }
        return true;
    }

    public void setBackgroundColor(@ColorInt int i4) {
        boolean z4;
        super.setBackgroundColor(i4);
        if (!this.mDrawFullUnderlineSet) {
            if ((i4 & ViewCompat.MEASURED_STATE_MASK) == 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            this.mDrawFullUnderline = z4;
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        boolean z4;
        super.setBackgroundDrawable(drawable);
        if (!this.mDrawFullUnderlineSet) {
            if (drawable == null) {
                z4 = true;
            } else {
                z4 = false;
            }
            this.mDrawFullUnderline = z4;
        }
    }

    public void setBackgroundResource(@DrawableRes int i4) {
        boolean z4;
        super.setBackgroundResource(i4);
        if (!this.mDrawFullUnderlineSet) {
            if (i4 == 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            this.mDrawFullUnderline = z4;
        }
    }

    public void setDrawFullUnderline(boolean z4) {
        this.mDrawFullUnderline = z4;
        this.mDrawFullUnderlineSet = true;
        invalidate();
    }

    public void setPadding(int i4, int i5, int i6, int i7) {
        int i8 = this.mMinPaddingBottom;
        if (i7 < i8) {
            i7 = i8;
        }
        super.setPadding(i4, i5, i6, i7);
    }

    public void setTabIndicatorColor(@ColorInt int i4) {
        this.mIndicatorColor = i4;
        this.mTabPaint.setColor(i4);
        invalidate();
    }

    public void setTabIndicatorColorResource(@ColorRes int i4) {
        setTabIndicatorColor(ContextCompat.getColor(getContext(), i4));
    }

    public void setTextSpacing(int i4) {
        int i5 = this.mMinTextSpacing;
        if (i4 < i5) {
            i4 = i5;
        }
        super.setTextSpacing(i4);
    }

    /* access modifiers changed from: package-private */
    public void updateTextPositions(int i4, float f4, boolean z4) {
        Rect rect = this.mTempRect;
        int height = getHeight();
        int left = this.mCurrText.getLeft() - this.mTabPadding;
        int right = this.mCurrText.getRight() + this.mTabPadding;
        int i5 = height - this.mIndicatorHeight;
        rect.set(left, i5, right, height);
        super.updateTextPositions(i4, f4, z4);
        this.mTabAlpha = (int) (Math.abs(f4 - 0.5f) * 2.0f * 255.0f);
        rect.union(this.mCurrText.getLeft() - this.mTabPadding, i5, this.mCurrText.getRight() + this.mTabPadding, height);
        invalidate(rect);
    }

    public PagerTabStrip(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Paint paint = new Paint();
        this.mTabPaint = paint;
        this.mTempRect = new Rect();
        this.mTabAlpha = 255;
        this.mDrawFullUnderline = false;
        this.mDrawFullUnderlineSet = false;
        int i4 = this.mTextColor;
        this.mIndicatorColor = i4;
        paint.setColor(i4);
        float f4 = context.getResources().getDisplayMetrics().density;
        this.mIndicatorHeight = (int) ((3.0f * f4) + 0.5f);
        this.mMinPaddingBottom = (int) ((6.0f * f4) + 0.5f);
        this.mMinTextSpacing = (int) (64.0f * f4);
        this.mTabPadding = (int) ((16.0f * f4) + 0.5f);
        this.mFullUnderlineHeight = (int) ((1.0f * f4) + 0.5f);
        this.mMinStripHeight = (int) ((f4 * 32.0f) + 0.5f);
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        setTextSpacing(getTextSpacing());
        setWillNotDraw(false);
        this.mPrevText.setFocusable(true);
        this.mPrevText.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ViewPager viewPager = PagerTabStrip.this.mPager;
                viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
            }
        });
        this.mNextText.setFocusable(true);
        this.mNextText.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ViewPager viewPager = PagerTabStrip.this.mPager;
                viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
            }
        });
        if (getBackground() == null) {
            this.mDrawFullUnderline = true;
        }
    }
}
