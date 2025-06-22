package androidx.constraintlayout.utils.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.motion.widget.Debug;
import androidx.constraintlayout.motion.widget.FloatLayout;
import androidx.constraintlayout.widget.R;
import androidx.core.view.GravityCompat;
import j$.util.Objects;

public class MotionLabel extends View implements FloatLayout {
    private static final int MONOSPACE = 3;
    private static final int SANS = 1;
    private static final int SERIF = 2;
    static final String TAG = "MotionLabel";
    private boolean mAutoSize = false;
    private int mAutoSizeTextType = 0;
    float mBackgroundPanX = Float.NaN;
    float mBackgroundPanY = Float.NaN;
    private float mBaseTextSize = Float.NaN;
    private float mDeltaLeft;
    private float mFloatHeight;
    private float mFloatWidth;
    private String mFontFamily;
    private int mGravity = 8388659;
    private Layout mLayout;
    boolean mNotBuilt = true;
    Matrix mOutlinePositionMatrix;
    private int mPaddingBottom = 1;
    private int mPaddingLeft = 1;
    private int mPaddingRight = 1;
    private int mPaddingTop = 1;
    TextPaint mPaint = new TextPaint();
    Paint mPaintCache = new Paint();
    float mPaintTextSize;
    Path mPath = new Path();
    RectF mRect;
    float mRotate = Float.NaN;
    /* access modifiers changed from: private */
    public float mRound = Float.NaN;
    /* access modifiers changed from: private */
    public float mRoundPercent = 0.0f;
    private int mStyleIndex;
    Paint mTempPaint;
    Rect mTempRect;
    private String mText = "Hello World";
    private Drawable mTextBackground;
    private Bitmap mTextBackgroundBitmap;
    private Rect mTextBounds = new Rect();
    private int mTextFillColor = 65535;
    private int mTextOutlineColor = 65535;
    private float mTextOutlineThickness = 0.0f;
    private float mTextPanX = 0.0f;
    private float mTextPanY = 0.0f;
    private BitmapShader mTextShader;
    private Matrix mTextShaderMatrix;
    private float mTextSize = 48.0f;
    private int mTextureEffect = 0;
    private float mTextureHeight = Float.NaN;
    private float mTextureWidth = Float.NaN;
    private int mTypefaceIndex;
    private boolean mUseOutline = false;
    ViewOutlineProvider mViewOutlineProvider;
    float mZoom = Float.NaN;

    public MotionLabel(Context context) {
        super(context);
        init(context, (AttributeSet) null);
    }

    private void adjustTexture(float f4, float f5, float f6, float f7) {
        if (this.mTextShaderMatrix != null) {
            this.mFloatWidth = f6 - f4;
            this.mFloatHeight = f7 - f5;
            updateShaderMatrix();
        }
    }

    private float getHorizontalOffset() {
        float f4;
        float f5;
        if (Float.isNaN(this.mBaseTextSize)) {
            f4 = 1.0f;
        } else {
            f4 = this.mTextSize / this.mBaseTextSize;
        }
        TextPaint textPaint = this.mPaint;
        String str = this.mText;
        float measureText = f4 * textPaint.measureText(str, 0, str.length());
        if (Float.isNaN(this.mFloatWidth)) {
            f5 = (float) getMeasuredWidth();
        } else {
            f5 = this.mFloatWidth;
        }
        return ((((f5 - ((float) getPaddingLeft())) - ((float) getPaddingRight())) - measureText) * (this.mTextPanX + 1.0f)) / 2.0f;
    }

    private float getVerticalOffset() {
        float f4;
        float f5;
        if (Float.isNaN(this.mBaseTextSize)) {
            f4 = 1.0f;
        } else {
            f4 = this.mTextSize / this.mBaseTextSize;
        }
        Paint.FontMetrics fontMetrics = this.mPaint.getFontMetrics();
        if (Float.isNaN(this.mFloatHeight)) {
            f5 = (float) getMeasuredHeight();
        } else {
            f5 = this.mFloatHeight;
        }
        float paddingTop = (f5 - ((float) getPaddingTop())) - ((float) getPaddingBottom());
        float f6 = fontMetrics.descent;
        float f7 = fontMetrics.ascent;
        return (((paddingTop - ((f6 - f7) * f4)) * (1.0f - this.mTextPanY)) / 2.0f) - (f4 * f7);
    }

    private void init(Context context, AttributeSet attributeSet) {
        setUpTheme(context);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.MotionLabel);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i4 = 0; i4 < indexCount; i4++) {
                int index = obtainStyledAttributes.getIndex(i4);
                if (index == R.styleable.MotionLabel_android_text) {
                    setText(obtainStyledAttributes.getText(index));
                } else if (index == R.styleable.MotionLabel_android_fontFamily) {
                    this.mFontFamily = obtainStyledAttributes.getString(index);
                } else if (index == R.styleable.MotionLabel_scaleFromTextSize) {
                    this.mBaseTextSize = (float) obtainStyledAttributes.getDimensionPixelSize(index, (int) this.mBaseTextSize);
                } else if (index == R.styleable.MotionLabel_android_textSize) {
                    this.mTextSize = (float) obtainStyledAttributes.getDimensionPixelSize(index, (int) this.mTextSize);
                } else if (index == R.styleable.MotionLabel_android_textStyle) {
                    this.mStyleIndex = obtainStyledAttributes.getInt(index, this.mStyleIndex);
                } else if (index == R.styleable.MotionLabel_android_typeface) {
                    this.mTypefaceIndex = obtainStyledAttributes.getInt(index, this.mTypefaceIndex);
                } else if (index == R.styleable.MotionLabel_android_textColor) {
                    this.mTextFillColor = obtainStyledAttributes.getColor(index, this.mTextFillColor);
                } else if (index == R.styleable.MotionLabel_borderRound) {
                    float dimension = obtainStyledAttributes.getDimension(index, this.mRound);
                    this.mRound = dimension;
                    setRound(dimension);
                } else if (index == R.styleable.MotionLabel_borderRoundPercent) {
                    float f4 = obtainStyledAttributes.getFloat(index, this.mRoundPercent);
                    this.mRoundPercent = f4;
                    setRoundPercent(f4);
                } else if (index == R.styleable.MotionLabel_android_gravity) {
                    setGravity(obtainStyledAttributes.getInt(index, -1));
                } else if (index == R.styleable.MotionLabel_android_autoSizeTextType) {
                    this.mAutoSizeTextType = obtainStyledAttributes.getInt(index, 0);
                } else if (index == R.styleable.MotionLabel_textOutlineColor) {
                    this.mTextOutlineColor = obtainStyledAttributes.getInt(index, this.mTextOutlineColor);
                    this.mUseOutline = true;
                } else if (index == R.styleable.MotionLabel_textOutlineThickness) {
                    this.mTextOutlineThickness = obtainStyledAttributes.getDimension(index, this.mTextOutlineThickness);
                    this.mUseOutline = true;
                } else if (index == R.styleable.MotionLabel_textBackground) {
                    this.mTextBackground = obtainStyledAttributes.getDrawable(index);
                    this.mUseOutline = true;
                } else if (index == R.styleable.MotionLabel_textBackgroundPanX) {
                    this.mBackgroundPanX = obtainStyledAttributes.getFloat(index, this.mBackgroundPanX);
                } else if (index == R.styleable.MotionLabel_textBackgroundPanY) {
                    this.mBackgroundPanY = obtainStyledAttributes.getFloat(index, this.mBackgroundPanY);
                } else if (index == R.styleable.MotionLabel_textPanX) {
                    this.mTextPanX = obtainStyledAttributes.getFloat(index, this.mTextPanX);
                } else if (index == R.styleable.MotionLabel_textPanY) {
                    this.mTextPanY = obtainStyledAttributes.getFloat(index, this.mTextPanY);
                } else if (index == R.styleable.MotionLabel_textBackgroundRotate) {
                    this.mRotate = obtainStyledAttributes.getFloat(index, this.mRotate);
                } else if (index == R.styleable.MotionLabel_textBackgroundZoom) {
                    this.mZoom = obtainStyledAttributes.getFloat(index, this.mZoom);
                } else if (index == R.styleable.MotionLabel_textureHeight) {
                    this.mTextureHeight = obtainStyledAttributes.getDimension(index, this.mTextureHeight);
                } else if (index == R.styleable.MotionLabel_textureWidth) {
                    this.mTextureWidth = obtainStyledAttributes.getDimension(index, this.mTextureWidth);
                } else if (index == R.styleable.MotionLabel_textureEffect) {
                    this.mTextureEffect = obtainStyledAttributes.getInt(index, this.mTextureEffect);
                }
            }
            obtainStyledAttributes.recycle();
        }
        setupTexture();
        setupPath();
    }

    private void setTypefaceFromAttrs(String str, int i4, int i5) {
        Typeface typeface;
        Typeface typeface2;
        int i6;
        if (str != null) {
            typeface = Typeface.create(str, i5);
            if (typeface != null) {
                setTypeface(typeface);
                return;
            }
        } else {
            typeface = null;
        }
        boolean z4 = true;
        if (i4 == 1) {
            typeface = Typeface.SANS_SERIF;
        } else if (i4 == 2) {
            typeface = Typeface.SERIF;
        } else if (i4 == 3) {
            typeface = Typeface.MONOSPACE;
        }
        float f4 = 0.0f;
        if (i5 > 0) {
            if (typeface == null) {
                typeface2 = Typeface.defaultFromStyle(i5);
            } else {
                typeface2 = Typeface.create(typeface, i5);
            }
            setTypeface(typeface2);
            if (typeface2 != null) {
                i6 = typeface2.getStyle();
            } else {
                i6 = 0;
            }
            int i7 = (~i6) & i5;
            TextPaint textPaint = this.mPaint;
            if ((i7 & 1) == 0) {
                z4 = false;
            }
            textPaint.setFakeBoldText(z4);
            TextPaint textPaint2 = this.mPaint;
            if ((i7 & 2) != 0) {
                f4 = -0.25f;
            }
            textPaint2.setTextSkewX(f4);
            return;
        }
        this.mPaint.setFakeBoldText(false);
        this.mPaint.setTextSkewX(0.0f);
        setTypeface(typeface);
    }

    private void setUpTheme(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(androidx.appcompat.R.attr.colorPrimary, typedValue, true);
        TextPaint textPaint = this.mPaint;
        int i4 = typedValue.data;
        this.mTextFillColor = i4;
        textPaint.setColor(i4);
    }

    private void setupTexture() {
        if (this.mTextBackground != null) {
            this.mTextShaderMatrix = new Matrix();
            int intrinsicWidth = this.mTextBackground.getIntrinsicWidth();
            int intrinsicHeight = this.mTextBackground.getIntrinsicHeight();
            int i4 = 128;
            if (intrinsicWidth <= 0 && (intrinsicWidth = getWidth()) == 0) {
                if (Float.isNaN(this.mTextureWidth)) {
                    intrinsicWidth = 128;
                } else {
                    intrinsicWidth = (int) this.mTextureWidth;
                }
            }
            if (intrinsicHeight <= 0 && (intrinsicHeight = getHeight()) == 0) {
                if (!Float.isNaN(this.mTextureHeight)) {
                    i4 = (int) this.mTextureHeight;
                }
                intrinsicHeight = i4;
            }
            if (this.mTextureEffect != 0) {
                intrinsicWidth /= 2;
                intrinsicHeight /= 2;
            }
            this.mTextBackgroundBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(this.mTextBackgroundBitmap);
            this.mTextBackground.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            this.mTextBackground.setFilterBitmap(true);
            this.mTextBackground.draw(canvas);
            if (this.mTextureEffect != 0) {
                this.mTextBackgroundBitmap = blur(this.mTextBackgroundBitmap, 4);
            }
            Bitmap bitmap = this.mTextBackgroundBitmap;
            Shader.TileMode tileMode = Shader.TileMode.REPEAT;
            this.mTextShader = new BitmapShader(bitmap, tileMode, tileMode);
        }
    }

    private void updateShaderMatrix() {
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10 = 0.0f;
        if (Float.isNaN(this.mBackgroundPanX)) {
            f4 = 0.0f;
        } else {
            f4 = this.mBackgroundPanX;
        }
        if (Float.isNaN(this.mBackgroundPanY)) {
            f5 = 0.0f;
        } else {
            f5 = this.mBackgroundPanY;
        }
        if (Float.isNaN(this.mZoom)) {
            f6 = 1.0f;
        } else {
            f6 = this.mZoom;
        }
        if (!Float.isNaN(this.mRotate)) {
            f10 = this.mRotate;
        }
        this.mTextShaderMatrix.reset();
        float width = (float) this.mTextBackgroundBitmap.getWidth();
        float height = (float) this.mTextBackgroundBitmap.getHeight();
        if (Float.isNaN(this.mTextureWidth)) {
            f7 = this.mFloatWidth;
        } else {
            f7 = this.mTextureWidth;
        }
        if (Float.isNaN(this.mTextureHeight)) {
            f8 = this.mFloatHeight;
        } else {
            f8 = this.mTextureHeight;
        }
        if (width * f8 < height * f7) {
            f9 = f7 / width;
        } else {
            f9 = f8 / height;
        }
        float f11 = f6 * f9;
        this.mTextShaderMatrix.postScale(f11, f11);
        float f12 = width * f11;
        float f13 = f7 - f12;
        float f14 = f11 * height;
        float f15 = f8 - f14;
        if (!Float.isNaN(this.mTextureHeight)) {
            f15 = this.mTextureHeight / 2.0f;
        }
        if (!Float.isNaN(this.mTextureWidth)) {
            f13 = this.mTextureWidth / 2.0f;
        }
        this.mTextShaderMatrix.postTranslate((((f4 * f13) + f7) - f12) * 0.5f, (((f5 * f15) + f8) - f14) * 0.5f);
        this.mTextShaderMatrix.postRotate(f10, f7 / 2.0f, f8 / 2.0f);
        this.mTextShader.setLocalMatrix(this.mTextShaderMatrix);
    }

    /* access modifiers changed from: package-private */
    public Bitmap blur(Bitmap bitmap, int i4) {
        int width = bitmap.getWidth() / 2;
        int height = bitmap.getHeight() / 2;
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, width, height, true);
        for (int i5 = 0; i5 < i4 && width >= 32 && height >= 32; i5++) {
            width /= 2;
            height /= 2;
            createScaledBitmap = Bitmap.createScaledBitmap(createScaledBitmap, width, height, true);
        }
        return createScaledBitmap;
    }

    /* access modifiers changed from: package-private */
    public void buildShape(float f4) {
        if (this.mUseOutline || f4 != 1.0f) {
            this.mPath.reset();
            String str = this.mText;
            int length = str.length();
            this.mPaint.getTextBounds(str, 0, length, this.mTextBounds);
            this.mPaint.getTextPath(str, 0, length, 0.0f, 0.0f, this.mPath);
            if (f4 != 1.0f) {
                Log.v(TAG, Debug.getLoc() + " scale " + f4);
                Matrix matrix = new Matrix();
                matrix.postScale(f4, f4);
                this.mPath.transform(matrix);
            }
            Rect rect = this.mTextBounds;
            rect.right--;
            rect.left++;
            rect.bottom++;
            rect.top--;
            RectF rectF = new RectF();
            rectF.bottom = (float) getHeight();
            rectF.right = (float) getWidth();
            this.mNotBuilt = false;
        }
    }

    public float getRound() {
        return this.mRound;
    }

    public float getRoundPercent() {
        return this.mRoundPercent;
    }

    public float getScaleFromTextSize() {
        return this.mBaseTextSize;
    }

    public float getTextBackgroundPanX() {
        return this.mBackgroundPanX;
    }

    public float getTextBackgroundPanY() {
        return this.mBackgroundPanY;
    }

    public float getTextBackgroundRotate() {
        return this.mRotate;
    }

    public float getTextBackgroundZoom() {
        return this.mZoom;
    }

    public int getTextOutlineColor() {
        return this.mTextOutlineColor;
    }

    public float getTextPanX() {
        return this.mTextPanX;
    }

    public float getTextPanY() {
        return this.mTextPanY;
    }

    public float getTextureHeight() {
        return this.mTextureHeight;
    }

    public float getTextureWidth() {
        return this.mTextureWidth;
    }

    public Typeface getTypeface() {
        return this.mPaint.getTypeface();
    }

    public void layout(int i4, int i5, int i6, int i7) {
        float f4;
        super.layout(i4, i5, i6, i7);
        boolean isNaN = Float.isNaN(this.mBaseTextSize);
        if (isNaN) {
            f4 = 1.0f;
        } else {
            f4 = this.mTextSize / this.mBaseTextSize;
        }
        this.mFloatWidth = (float) (i6 - i4);
        this.mFloatHeight = (float) (i7 - i5);
        if (this.mAutoSize) {
            if (this.mTempRect == null) {
                this.mTempPaint = new Paint();
                this.mTempRect = new Rect();
                this.mTempPaint.set(this.mPaint);
                this.mPaintTextSize = this.mTempPaint.getTextSize();
            }
            Paint paint = this.mTempPaint;
            String str = this.mText;
            paint.getTextBounds(str, 0, str.length(), this.mTempRect);
            int width = this.mTempRect.width();
            int height = (int) (((float) this.mTempRect.height()) * 1.3f);
            float f5 = (this.mFloatWidth - ((float) this.mPaddingRight)) - ((float) this.mPaddingLeft);
            float f6 = (this.mFloatHeight - ((float) this.mPaddingBottom)) - ((float) this.mPaddingTop);
            if (isNaN) {
                float f7 = (float) width;
                float f8 = (float) height;
                if (f7 * f6 > f8 * f5) {
                    this.mPaint.setTextSize((this.mPaintTextSize * f5) / f7);
                } else {
                    this.mPaint.setTextSize((this.mPaintTextSize * f6) / f8);
                }
            } else {
                float f9 = (float) width;
                float f10 = (float) height;
                f4 = f9 * f6 > f10 * f5 ? f5 / f9 : f6 / f10;
            }
        }
        if (this.mUseOutline || !isNaN) {
            adjustTexture((float) i4, (float) i5, (float) i6, (float) i7);
            buildShape(f4);
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(@NonNull Canvas canvas) {
        float f4;
        if (Float.isNaN(this.mBaseTextSize)) {
            f4 = 1.0f;
        } else {
            f4 = this.mTextSize / this.mBaseTextSize;
        }
        super.onDraw(canvas);
        if (this.mUseOutline || f4 != 1.0f) {
            if (this.mNotBuilt) {
                buildShape(f4);
            }
            if (this.mOutlinePositionMatrix == null) {
                this.mOutlinePositionMatrix = new Matrix();
            }
            if (this.mUseOutline) {
                this.mPaintCache.set(this.mPaint);
                this.mOutlinePositionMatrix.reset();
                float horizontalOffset = ((float) this.mPaddingLeft) + getHorizontalOffset();
                float verticalOffset = ((float) this.mPaddingTop) + getVerticalOffset();
                this.mOutlinePositionMatrix.postTranslate(horizontalOffset, verticalOffset);
                this.mOutlinePositionMatrix.preScale(f4, f4);
                this.mPath.transform(this.mOutlinePositionMatrix);
                if (this.mTextShader != null) {
                    this.mPaint.setFilterBitmap(true);
                    this.mPaint.setShader(this.mTextShader);
                } else {
                    this.mPaint.setColor(this.mTextFillColor);
                }
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPaint.setStrokeWidth(this.mTextOutlineThickness);
                canvas.drawPath(this.mPath, this.mPaint);
                if (this.mTextShader != null) {
                    this.mPaint.setShader((Shader) null);
                }
                this.mPaint.setColor(this.mTextOutlineColor);
                this.mPaint.setStyle(Paint.Style.STROKE);
                this.mPaint.setStrokeWidth(this.mTextOutlineThickness);
                canvas.drawPath(this.mPath, this.mPaint);
                this.mOutlinePositionMatrix.reset();
                this.mOutlinePositionMatrix.postTranslate(-horizontalOffset, -verticalOffset);
                this.mPath.transform(this.mOutlinePositionMatrix);
                this.mPaint.set(this.mPaintCache);
                return;
            }
            float horizontalOffset2 = ((float) this.mPaddingLeft) + getHorizontalOffset();
            float verticalOffset2 = ((float) this.mPaddingTop) + getVerticalOffset();
            this.mOutlinePositionMatrix.reset();
            this.mOutlinePositionMatrix.preTranslate(horizontalOffset2, verticalOffset2);
            this.mPath.transform(this.mOutlinePositionMatrix);
            this.mPaint.setColor(this.mTextFillColor);
            this.mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
            this.mPaint.setStrokeWidth(this.mTextOutlineThickness);
            canvas.drawPath(this.mPath, this.mPaint);
            this.mOutlinePositionMatrix.reset();
            this.mOutlinePositionMatrix.preTranslate(-horizontalOffset2, -verticalOffset2);
            this.mPath.transform(this.mOutlinePositionMatrix);
            return;
        }
        float horizontalOffset3 = ((float) this.mPaddingLeft) + getHorizontalOffset();
        canvas.drawText(this.mText, this.mDeltaLeft + horizontalOffset3, ((float) this.mPaddingTop) + getVerticalOffset(), this.mPaint);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i4, int i5) {
        int mode = View.MeasureSpec.getMode(i4);
        int mode2 = View.MeasureSpec.getMode(i5);
        int size = View.MeasureSpec.getSize(i4);
        int size2 = View.MeasureSpec.getSize(i5);
        this.mAutoSize = false;
        this.mPaddingLeft = getPaddingLeft();
        this.mPaddingRight = getPaddingRight();
        this.mPaddingTop = getPaddingTop();
        this.mPaddingBottom = getPaddingBottom();
        if (mode != 1073741824 || mode2 != 1073741824) {
            TextPaint textPaint = this.mPaint;
            String str = this.mText;
            textPaint.getTextBounds(str, 0, str.length(), this.mTextBounds);
            if (mode != 1073741824) {
                size = (int) (((float) this.mTextBounds.width()) + 0.99999f);
            }
            size += this.mPaddingLeft + this.mPaddingRight;
            if (mode2 != 1073741824) {
                int fontMetricsInt = (int) (((float) this.mPaint.getFontMetricsInt((Paint.FontMetricsInt) null)) + 0.99999f);
                if (mode2 == Integer.MIN_VALUE) {
                    fontMetricsInt = Math.min(size2, fontMetricsInt);
                }
                size2 = this.mPaddingTop + this.mPaddingBottom + fontMetricsInt;
            }
        } else if (this.mAutoSizeTextType != 0) {
            this.mAutoSize = true;
        }
        setMeasuredDimension(size, size2);
    }

    @SuppressLint({"RtlHardcoded"})
    public void setGravity(int i4) {
        if ((i4 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK) == 0) {
            i4 |= GravityCompat.START;
        }
        if ((i4 & 112) == 0) {
            i4 |= 48;
        }
        if (i4 != this.mGravity) {
            invalidate();
        }
        this.mGravity = i4;
        int i5 = i4 & 112;
        if (i5 == 48) {
            this.mTextPanY = -1.0f;
        } else if (i5 != 80) {
            this.mTextPanY = 0.0f;
        } else {
            this.mTextPanY = 1.0f;
        }
        int i6 = i4 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (i6 != 3) {
            if (i6 != 5) {
                if (i6 != 8388611) {
                    if (i6 != 8388613) {
                        this.mTextPanX = 0.0f;
                        return;
                    }
                }
            }
            this.mTextPanX = 1.0f;
            return;
        }
        this.mTextPanX = -1.0f;
    }

    @RequiresApi(21)
    public void setRound(float f4) {
        boolean z4;
        if (Float.isNaN(f4)) {
            this.mRound = f4;
            float f5 = this.mRoundPercent;
            this.mRoundPercent = -1.0f;
            setRoundPercent(f5);
            return;
        }
        if (this.mRound != f4) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.mRound = f4;
        if (f4 != 0.0f) {
            if (this.mPath == null) {
                this.mPath = new Path();
            }
            if (this.mRect == null) {
                this.mRect = new RectF();
            }
            if (this.mViewOutlineProvider == null) {
                AnonymousClass2 r5 = new ViewOutlineProvider() {
                    public void getOutline(View view, Outline outline) {
                        outline.setRoundRect(0, 0, MotionLabel.this.getWidth(), MotionLabel.this.getHeight(), MotionLabel.this.mRound);
                    }
                };
                this.mViewOutlineProvider = r5;
                setOutlineProvider(r5);
            }
            setClipToOutline(true);
            this.mRect.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
            this.mPath.reset();
            Path path = this.mPath;
            RectF rectF = this.mRect;
            float f6 = this.mRound;
            path.addRoundRect(rectF, f6, f6, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z4) {
            invalidateOutline();
        }
    }

    @RequiresApi(21)
    public void setRoundPercent(float f4) {
        boolean z4;
        if (this.mRoundPercent != f4) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.mRoundPercent = f4;
        if (f4 != 0.0f) {
            if (this.mPath == null) {
                this.mPath = new Path();
            }
            if (this.mRect == null) {
                this.mRect = new RectF();
            }
            if (this.mViewOutlineProvider == null) {
                AnonymousClass1 r6 = new ViewOutlineProvider() {
                    public void getOutline(View view, Outline outline) {
                        int width = MotionLabel.this.getWidth();
                        int height = MotionLabel.this.getHeight();
                        outline.setRoundRect(0, 0, width, height, (((float) Math.min(width, height)) * MotionLabel.this.mRoundPercent) / 2.0f);
                    }
                };
                this.mViewOutlineProvider = r6;
                setOutlineProvider(r6);
            }
            setClipToOutline(true);
            int width = getWidth();
            int height = getHeight();
            float min = (((float) Math.min(width, height)) * this.mRoundPercent) / 2.0f;
            this.mRect.set(0.0f, 0.0f, (float) width, (float) height);
            this.mPath.reset();
            this.mPath.addRoundRect(this.mRect, min, min, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z4) {
            invalidateOutline();
        }
    }

    public void setScaleFromTextSize(float f4) {
        this.mBaseTextSize = f4;
    }

    public void setText(CharSequence charSequence) {
        this.mText = charSequence.toString();
        invalidate();
    }

    public void setTextBackgroundPanX(float f4) {
        this.mBackgroundPanX = f4;
        updateShaderMatrix();
        invalidate();
    }

    public void setTextBackgroundPanY(float f4) {
        this.mBackgroundPanY = f4;
        updateShaderMatrix();
        invalidate();
    }

    public void setTextBackgroundRotate(float f4) {
        this.mRotate = f4;
        updateShaderMatrix();
        invalidate();
    }

    public void setTextBackgroundZoom(float f4) {
        this.mZoom = f4;
        updateShaderMatrix();
        invalidate();
    }

    public void setTextFillColor(int i4) {
        this.mTextFillColor = i4;
        invalidate();
    }

    public void setTextOutlineColor(int i4) {
        this.mTextOutlineColor = i4;
        this.mUseOutline = true;
        invalidate();
    }

    public void setTextOutlineThickness(float f4) {
        this.mTextOutlineThickness = f4;
        this.mUseOutline = true;
        if (Float.isNaN(f4)) {
            this.mTextOutlineThickness = 1.0f;
            this.mUseOutline = false;
        }
        invalidate();
    }

    public void setTextPanX(float f4) {
        this.mTextPanX = f4;
        invalidate();
    }

    public void setTextPanY(float f4) {
        this.mTextPanY = f4;
        invalidate();
    }

    public void setTextSize(float f4) {
        float f5;
        this.mTextSize = f4;
        TextPaint textPaint = this.mPaint;
        if (!Float.isNaN(this.mBaseTextSize)) {
            f4 = this.mBaseTextSize;
        }
        textPaint.setTextSize(f4);
        if (Float.isNaN(this.mBaseTextSize)) {
            f5 = 1.0f;
        } else {
            f5 = this.mTextSize / this.mBaseTextSize;
        }
        buildShape(f5);
        requestLayout();
        invalidate();
    }

    public void setTextureHeight(float f4) {
        this.mTextureHeight = f4;
        updateShaderMatrix();
        invalidate();
    }

    public void setTextureWidth(float f4) {
        this.mTextureWidth = f4;
        updateShaderMatrix();
        invalidate();
    }

    public void setTypeface(Typeface typeface) {
        if (!Objects.equals(this.mPaint.getTypeface(), typeface)) {
            this.mPaint.setTypeface(typeface);
            if (this.mLayout != null) {
                this.mLayout = null;
                requestLayout();
                invalidate();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void setupPath() {
        this.mPaddingLeft = getPaddingLeft();
        this.mPaddingRight = getPaddingRight();
        this.mPaddingTop = getPaddingTop();
        this.mPaddingBottom = getPaddingBottom();
        setTypefaceFromAttrs(this.mFontFamily, this.mTypefaceIndex, this.mStyleIndex);
        this.mPaint.setColor(this.mTextFillColor);
        this.mPaint.setStrokeWidth(this.mTextOutlineThickness);
        this.mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.mPaint.setFlags(128);
        setTextSize(this.mTextSize);
        this.mPaint.setAntiAlias(true);
    }

    public void layout(float f4, float f5, float f6, float f7) {
        int i4 = (int) (f4 + 0.5f);
        this.mDeltaLeft = f4 - ((float) i4);
        int i5 = (int) (f6 + 0.5f);
        int i6 = i5 - i4;
        int i7 = (int) (f7 + 0.5f);
        int i8 = (int) (0.5f + f5);
        int i9 = i7 - i8;
        float f8 = f6 - f4;
        this.mFloatWidth = f8;
        float f9 = f7 - f5;
        this.mFloatHeight = f9;
        adjustTexture(f4, f5, f6, f7);
        if (getMeasuredHeight() == i9 && getMeasuredWidth() == i6) {
            super.layout(i4, i8, i5, i7);
        } else {
            measure(View.MeasureSpec.makeMeasureSpec(i6, 1073741824), View.MeasureSpec.makeMeasureSpec(i9, 1073741824));
            super.layout(i4, i8, i5, i7);
        }
        if (this.mAutoSize) {
            if (this.mTempRect == null) {
                this.mTempPaint = new Paint();
                this.mTempRect = new Rect();
                this.mTempPaint.set(this.mPaint);
                this.mPaintTextSize = this.mTempPaint.getTextSize();
            }
            this.mFloatWidth = f8;
            this.mFloatHeight = f9;
            Paint paint = this.mTempPaint;
            String str = this.mText;
            paint.getTextBounds(str, 0, str.length(), this.mTempRect);
            int width = this.mTempRect.width();
            float height = ((float) this.mTempRect.height()) * 1.3f;
            float f10 = (f8 - ((float) this.mPaddingRight)) - ((float) this.mPaddingLeft);
            float f11 = (f9 - ((float) this.mPaddingBottom)) - ((float) this.mPaddingTop);
            float f12 = (float) width;
            if (f12 * f11 > height * f10) {
                this.mPaint.setTextSize((this.mPaintTextSize * f10) / f12);
            } else {
                this.mPaint.setTextSize((this.mPaintTextSize * f11) / height);
            }
            if (this.mUseOutline || !Float.isNaN(this.mBaseTextSize)) {
                buildShape(Float.isNaN(this.mBaseTextSize) ? 1.0f : this.mTextSize / this.mBaseTextSize);
            }
        }
    }

    public MotionLabel(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public MotionLabel(Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        init(context, attributeSet);
    }
}
