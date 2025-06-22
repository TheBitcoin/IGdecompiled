package com.mbridge.msdk.videocommon.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.widget.MBImageView;

public class RoundImageView extends MBImageView {

    /* renamed from: a  reason: collision with root package name */
    private int f17139a;

    /* renamed from: b  reason: collision with root package name */
    private int f17140b;

    /* renamed from: c  reason: collision with root package name */
    private Paint f17141c;

    /* renamed from: d  reason: collision with root package name */
    private int f17142d;

    /* renamed from: e  reason: collision with root package name */
    private Matrix f17143e = new Matrix();

    /* renamed from: f  reason: collision with root package name */
    private BitmapShader f17144f;

    /* renamed from: g  reason: collision with root package name */
    private int f17145g;

    /* renamed from: h  reason: collision with root package name */
    private RectF f17146h;

    public RoundImageView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        Paint paint = new Paint();
        this.f17141c = paint;
        paint.setAntiAlias(true);
        this.f17140b = (int) TypedValue.applyDimension(1, 5.0f, getResources().getDisplayMetrics());
        this.f17139a = 1;
    }

    private Bitmap a(Drawable drawable) {
        try {
            if (drawable instanceof BitmapDrawable) {
                return ((BitmapDrawable) drawable).getBitmap();
            }
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_4444);
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            drawable.draw(canvas);
            return createBitmap;
        } catch (Throwable th) {
            af.b("View", th.getMessage());
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        try {
            if (getDrawable() != null) {
                Drawable drawable = getDrawable();
                if (drawable != null) {
                    Bitmap a5 = a(drawable);
                    if (a5 != null && !a5.isRecycled()) {
                        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                        this.f17144f = new BitmapShader(a5, tileMode, tileMode);
                        int i4 = this.f17139a;
                        float f4 = 1.0f;
                        if (i4 == 0) {
                            f4 = (((float) this.f17145g) * 1.0f) / ((float) Math.min(a5.getWidth(), a5.getHeight()));
                        } else if (i4 == 1) {
                            f4 = Math.max((((float) getWidth()) * 1.0f) / ((float) a5.getWidth()), (((float) getHeight()) * 1.0f) / ((float) a5.getHeight()));
                        }
                        this.f17143e.setScale(f4, f4);
                        this.f17144f.setLocalMatrix(this.f17143e);
                        this.f17141c.setShader(this.f17144f);
                    }
                }
                if (this.f17139a == 1) {
                    RectF rectF = this.f17146h;
                    int i5 = this.f17140b;
                    canvas.drawRoundRect(rectF, (float) i5, (float) i5, this.f17141c);
                    return;
                }
                int i6 = this.f17142d;
                canvas.drawCircle((float) i6, (float) i6, (float) i6, this.f17141c);
            }
        } catch (Throwable th) {
            af.b("RoundImageView", th.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i4, int i5) {
        super.onMeasure(i4, i5);
        if (this.f17139a == 0) {
            int min = Math.min(getMeasuredWidth(), getMeasuredHeight());
            this.f17145g = min;
            this.f17142d = min / 2;
            setMeasuredDimension(min, min);
        }
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            super.onRestoreInstanceState(bundle.getParcelable("state_instance"));
            this.f17139a = bundle.getInt("state_type");
            this.f17140b = bundle.getInt("state_border_radius");
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("state_instance", super.onSaveInstanceState());
        bundle.putInt("state_type", this.f17139a);
        bundle.putInt("state_border_radius", this.f17140b);
        return bundle;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i4, int i5, int i6, int i7) {
        super.onSizeChanged(i4, i5, i6, i7);
        if (this.f17139a == 1) {
            this.f17146h = new RectF(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
        }
    }

    public void setBorderRadius(int i4) {
        int a5 = ak.a(getContext(), (float) i4);
        if (this.f17140b != a5) {
            this.f17140b = a5;
            invalidate();
        }
    }

    public void setType(int i4) {
        if (this.f17139a != i4) {
            this.f17139a = i4;
            if (!(i4 == 1 || i4 == 0)) {
                this.f17139a = 0;
            }
            requestLayout();
        }
    }

    public RoundImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Paint paint = new Paint();
        this.f17141c = paint;
        paint.setAntiAlias(true);
        this.f17140b = (int) TypedValue.applyDimension(1, 5.0f, getResources().getDisplayMetrics());
        this.f17139a = 1;
    }

    public RoundImageView(Context context) {
        super(context);
        Paint paint = new Paint();
        this.f17141c = paint;
        paint.setAntiAlias(true);
        this.f17140b = (int) TypedValue.applyDimension(1, 5.0f, getResources().getDisplayMetrics());
        this.f17139a = 1;
    }
}
