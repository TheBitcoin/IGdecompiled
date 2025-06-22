package androidx.leanback.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Shader;
import android.util.AttributeSet;
import androidx.core.view.ViewCompat;
import androidx.leanback.R;

public class HorizontalGridView extends BaseGridView {
    private boolean mFadingHighEdge;
    private boolean mFadingLowEdge;
    private LinearGradient mHighFadeShader;
    private int mHighFadeShaderLength;
    private int mHighFadeShaderOffset;
    private LinearGradient mLowFadeShader;
    private int mLowFadeShaderLength;
    private int mLowFadeShaderOffset;
    private Bitmap mTempBitmapHigh;
    private Bitmap mTempBitmapLow;
    private Paint mTempPaint;
    private Rect mTempRect;

    public HorizontalGridView(Context context) {
        this(context, (AttributeSet) null);
    }

    private Bitmap getTempBitmapHigh() {
        Bitmap bitmap = this.mTempBitmapHigh;
        if (!(bitmap != null && bitmap.getWidth() == this.mHighFadeShaderLength && this.mTempBitmapHigh.getHeight() == getHeight())) {
            this.mTempBitmapHigh = Bitmap.createBitmap(this.mHighFadeShaderLength, getHeight(), Bitmap.Config.ARGB_8888);
        }
        return this.mTempBitmapHigh;
    }

    private Bitmap getTempBitmapLow() {
        Bitmap bitmap = this.mTempBitmapLow;
        if (!(bitmap != null && bitmap.getWidth() == this.mLowFadeShaderLength && this.mTempBitmapLow.getHeight() == getHeight())) {
            this.mTempBitmapLow = Bitmap.createBitmap(this.mLowFadeShaderLength, getHeight(), Bitmap.Config.ARGB_8888);
        }
        return this.mTempBitmapLow;
    }

    private boolean needsFadingHighEdge() {
        if (!this.mFadingHighEdge) {
            return false;
        }
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            if (this.mLayoutManager.getOpticalRight(getChildAt(childCount)) > (getWidth() - getPaddingRight()) + this.mHighFadeShaderOffset) {
                return true;
            }
        }
        return false;
    }

    private boolean needsFadingLowEdge() {
        if (!this.mFadingLowEdge) {
            return false;
        }
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            if (this.mLayoutManager.getOpticalLeft(getChildAt(i4)) < getPaddingLeft() - this.mLowFadeShaderOffset) {
                return true;
            }
        }
        return false;
    }

    private void updateLayerType() {
        if (this.mFadingLowEdge || this.mFadingHighEdge) {
            setLayerType(2, (Paint) null);
            setWillNotDraw(false);
            return;
        }
        setLayerType(0, (Paint) null);
        setWillNotDraw(true);
    }

    public void draw(Canvas canvas) {
        int i4;
        int i5;
        int i6;
        int i7;
        Canvas canvas2 = canvas;
        boolean needsFadingLowEdge = needsFadingLowEdge();
        boolean needsFadingHighEdge = needsFadingHighEdge();
        if (!needsFadingLowEdge) {
            this.mTempBitmapLow = null;
        }
        if (!needsFadingHighEdge) {
            this.mTempBitmapHigh = null;
        }
        if (needsFadingLowEdge || needsFadingHighEdge) {
            if (this.mFadingLowEdge) {
                i4 = (getPaddingLeft() - this.mLowFadeShaderOffset) - this.mLowFadeShaderLength;
            } else {
                i4 = 0;
            }
            if (this.mFadingHighEdge) {
                i5 = (getWidth() - getPaddingRight()) + this.mHighFadeShaderOffset + this.mHighFadeShaderLength;
            } else {
                i5 = getWidth();
            }
            int save = canvas2.save();
            if (this.mFadingLowEdge) {
                i6 = this.mLowFadeShaderLength;
            } else {
                i6 = 0;
            }
            int i8 = i6 + i4;
            if (this.mFadingHighEdge) {
                i7 = this.mHighFadeShaderLength;
            } else {
                i7 = 0;
            }
            canvas2.clipRect(i8, 0, i5 - i7, getHeight());
            super.draw(canvas);
            canvas2.restoreToCount(save);
            Canvas canvas3 = new Canvas();
            Rect rect = this.mTempRect;
            rect.top = 0;
            rect.bottom = getHeight();
            if (needsFadingLowEdge && this.mLowFadeShaderLength > 0) {
                Bitmap tempBitmapLow = getTempBitmapLow();
                tempBitmapLow.eraseColor(0);
                canvas3.setBitmap(tempBitmapLow);
                int save2 = canvas3.save();
                canvas3.clipRect(0, 0, this.mLowFadeShaderLength, getHeight());
                float f4 = (float) (-i4);
                canvas3.translate(f4, 0.0f);
                super.draw(canvas3);
                canvas3.restoreToCount(save2);
                this.mTempPaint.setShader(this.mLowFadeShader);
                canvas3.drawRect(0.0f, 0.0f, (float) this.mLowFadeShaderLength, (float) getHeight(), this.mTempPaint);
                Rect rect2 = this.mTempRect;
                rect2.left = 0;
                rect2.right = this.mLowFadeShaderLength;
                canvas2.translate((float) i4, 0.0f);
                Rect rect3 = this.mTempRect;
                canvas2.drawBitmap(tempBitmapLow, rect3, rect3, (Paint) null);
                canvas2.translate(f4, 0.0f);
            }
            if (needsFadingHighEdge && this.mHighFadeShaderLength > 0) {
                Bitmap tempBitmapHigh = getTempBitmapHigh();
                tempBitmapHigh.eraseColor(0);
                canvas3.setBitmap(tempBitmapHigh);
                int save3 = canvas3.save();
                canvas3.clipRect(0, 0, this.mHighFadeShaderLength, getHeight());
                canvas3.translate((float) (-(i5 - this.mHighFadeShaderLength)), 0.0f);
                super.draw(canvas3);
                canvas3.restoreToCount(save3);
                this.mTempPaint.setShader(this.mHighFadeShader);
                canvas3.drawRect(0.0f, 0.0f, (float) this.mHighFadeShaderLength, (float) getHeight(), this.mTempPaint);
                Rect rect4 = this.mTempRect;
                rect4.left = 0;
                int i9 = this.mHighFadeShaderLength;
                rect4.right = i9;
                canvas2.translate((float) (i5 - i9), 0.0f);
                Rect rect5 = this.mTempRect;
                canvas2.drawBitmap(tempBitmapHigh, rect5, rect5, (Paint) null);
                canvas2.translate((float) (-(i5 - this.mHighFadeShaderLength)), 0.0f);
                return;
            }
            return;
        }
        super.draw(canvas);
    }

    public final boolean getFadingLeftEdge() {
        return this.mFadingLowEdge;
    }

    public final int getFadingLeftEdgeLength() {
        return this.mLowFadeShaderLength;
    }

    public final int getFadingLeftEdgeOffset() {
        return this.mLowFadeShaderOffset;
    }

    public final boolean getFadingRightEdge() {
        return this.mFadingHighEdge;
    }

    public final int getFadingRightEdgeLength() {
        return this.mHighFadeShaderLength;
    }

    public final int getFadingRightEdgeOffset() {
        return this.mHighFadeShaderOffset;
    }

    /* access modifiers changed from: protected */
    public void initAttributes(Context context, AttributeSet attributeSet) {
        initBaseGridViewAttributes(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.lbHorizontalGridView);
        setRowHeight(obtainStyledAttributes);
        setNumRows(obtainStyledAttributes.getInt(R.styleable.lbHorizontalGridView_numberOfRows, 1));
        obtainStyledAttributes.recycle();
        updateLayerType();
        Paint paint = new Paint();
        this.mTempPaint = paint;
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    }

    public final void setFadingLeftEdge(boolean z4) {
        if (this.mFadingLowEdge != z4) {
            this.mFadingLowEdge = z4;
            if (!z4) {
                this.mTempBitmapLow = null;
            }
            invalidate();
            updateLayerType();
        }
    }

    public final void setFadingLeftEdgeLength(int i4) {
        if (this.mLowFadeShaderLength != i4) {
            this.mLowFadeShaderLength = i4;
            if (i4 != 0) {
                this.mLowFadeShader = new LinearGradient(0.0f, 0.0f, (float) this.mLowFadeShaderLength, 0.0f, 0, ViewCompat.MEASURED_STATE_MASK, Shader.TileMode.CLAMP);
            } else {
                this.mLowFadeShader = null;
            }
            invalidate();
        }
    }

    public final void setFadingLeftEdgeOffset(int i4) {
        if (this.mLowFadeShaderOffset != i4) {
            this.mLowFadeShaderOffset = i4;
            invalidate();
        }
    }

    public final void setFadingRightEdge(boolean z4) {
        if (this.mFadingHighEdge != z4) {
            this.mFadingHighEdge = z4;
            if (!z4) {
                this.mTempBitmapHigh = null;
            }
            invalidate();
            updateLayerType();
        }
    }

    public final void setFadingRightEdgeLength(int i4) {
        if (this.mHighFadeShaderLength != i4) {
            this.mHighFadeShaderLength = i4;
            if (i4 != 0) {
                this.mHighFadeShader = new LinearGradient(0.0f, 0.0f, (float) this.mHighFadeShaderLength, 0.0f, ViewCompat.MEASURED_STATE_MASK, 0, Shader.TileMode.CLAMP);
            } else {
                this.mHighFadeShader = null;
            }
            invalidate();
        }
    }

    public final void setFadingRightEdgeOffset(int i4) {
        if (this.mHighFadeShaderOffset != i4) {
            this.mHighFadeShaderOffset = i4;
            invalidate();
        }
    }

    public void setNumRows(int i4) {
        this.mLayoutManager.setNumRows(i4);
        requestLayout();
    }

    /* access modifiers changed from: package-private */
    public void setRowHeight(TypedArray typedArray) {
        int i4 = R.styleable.lbHorizontalGridView_rowHeight;
        if (typedArray.peekValue(i4) != null) {
            setRowHeight(typedArray.getLayoutDimension(i4, 0));
        }
    }

    public HorizontalGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HorizontalGridView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.mTempPaint = new Paint();
        this.mTempRect = new Rect();
        this.mLayoutManager.setOrientation(0);
        initAttributes(context, attributeSet);
    }

    public void setRowHeight(int i4) {
        this.mLayoutManager.setRowHeight(i4);
        requestLayout();
    }
}
