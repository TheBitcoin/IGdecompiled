package com.mbridge.msdk.dycreator.baseview.cusview;

import android.content.Context;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

public class MBRotationView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    Runnable f12381a = new Runnable() {
        public void run() {
            MBRotationView.a(MBRotationView.this);
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private Camera f12382b;

    /* renamed from: c  reason: collision with root package name */
    private Matrix f12383c;

    /* renamed from: d  reason: collision with root package name */
    private int f12384d;

    /* renamed from: e  reason: collision with root package name */
    private int f12385e;

    /* renamed from: f  reason: collision with root package name */
    private int f12386f = 40;

    /* renamed from: g  reason: collision with root package name */
    private int f12387g = 20;

    /* renamed from: h  reason: collision with root package name */
    private int f12388h = 0;

    /* renamed from: i  reason: collision with root package name */
    private int f12389i = 0;

    /* renamed from: j  reason: collision with root package name */
    private int f12390j;

    /* renamed from: k  reason: collision with root package name */
    private int f12391k = 0;

    /* renamed from: l  reason: collision with root package name */
    private float f12392l = 0.5f;

    /* renamed from: m  reason: collision with root package name */
    private float f12393m = 0.9f;

    /* renamed from: n  reason: collision with root package name */
    private boolean f12394n = true;

    /* renamed from: o  reason: collision with root package name */
    private boolean f12395o = false;

    /* renamed from: p  reason: collision with root package name */
    private boolean f12396p = false;

    public MBRotationView(Context context) {
        super(context);
        a();
    }

    private void a() {
        this.f12382b = new Camera();
        this.f12383c = new Matrix();
        setWillNotDraw(false);
    }

    private void b(int i4, int i5, int i6) {
        if (i6 == 0) {
            float f4 = (float) ((-i4) / 2);
            this.f12382b.translate(f4, 0.0f, 0.0f);
            float f5 = (float) (-i5);
            this.f12382b.rotateY(f5);
            this.f12382b.translate(f4, 0.0f, 0.0f);
            this.f12382b.translate(f4, 0.0f, 0.0f);
            this.f12382b.rotateY(f5);
            this.f12382b.translate(f4, 0.0f, 0.0f);
        } else if (i6 == 1) {
            float f6 = (float) (i4 / 2);
            this.f12382b.translate(f6, 0.0f, 0.0f);
            this.f12382b.rotateY((float) i5);
            this.f12382b.translate(f6, 0.0f, 0.0f);
        } else if (i6 == 2) {
            float f7 = (float) ((-i4) / 2);
            this.f12382b.translate(f7, 0.0f, 0.0f);
            this.f12382b.rotateY((float) (-i5));
            this.f12382b.translate(f7, 0.0f, 0.0f);
        } else if (i6 == 3) {
            this.f12382b.rotateY(0.0f);
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        if (getChildCount() != 0) {
            if (this.f12395o) {
                int height = getHeight() / 2;
                int i4 = ((this.f12388h * this.f12384d) / 2) / this.f12386f;
                a(canvas, i4, height, 0);
                a(canvas, i4, height, 1);
                if (Math.abs(this.f12388h) > this.f12386f / 2) {
                    a(canvas, i4, height, 3);
                    a(canvas, i4, height, 2);
                    return;
                }
                a(canvas, i4, height, 2);
                a(canvas, i4, height, 3);
                return;
            }
            int width = getWidth() / 2;
            int i5 = ((this.f12388h * this.f12385e) / 2) / this.f12386f;
            b(canvas, i5, width, 0);
            b(canvas, i5, width, 1);
            if (Math.abs(this.f12388h) > this.f12386f / 2) {
                b(canvas, i5, width, 3);
                b(canvas, i5, width, 2);
                return;
            }
            b(canvas, i5, width, 2);
            b(canvas, i5, width, 3);
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        int i8 = i6 - i4;
        float f4 = (float) i8;
        float f5 = this.f12392l;
        int i9 = (int) (((1.0f - f5) * f4) / 2.0f);
        int i10 = i7 - i5;
        float f6 = (float) i10;
        float f7 = this.f12393m;
        int i11 = (int) (((1.0f - f7) * f6) / 2.0f);
        this.f12384d = (int) (f6 * f7);
        this.f12385e = (int) (f4 * f5);
        int childCount = getChildCount();
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            childAt.layout(i9, i11, i8 - i9, i10 - i11);
            childAt.setClickable(true);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            int i13 = layoutParams.width;
            int i14 = this.f12385e;
            if (i13 != i14) {
                layoutParams.width = i14;
                layoutParams.height = this.f12384d;
                childAt.setLayoutParams(layoutParams);
            }
        }
    }

    public void setAutoscroll(boolean z4) {
        if (z4) {
            postDelayed(this.f12381a, (long) (1000 / this.f12387g));
        }
        this.f12394n = z4;
    }

    public void setHeightRatio(float f4) {
        this.f12393m = f4;
    }

    public void setRotateV(boolean z4) {
        this.f12395o = z4;
        invalidate();
    }

    public void setWidthRatio(float f4) {
        this.f12392l = f4;
    }

    private void a(int i4, int i5, int i6) {
        float f4 = ((float) (-i4)) / 2.0f;
        if (i6 == 0) {
            this.f12382b.translate(0.0f, f4, 0.0f);
            float f5 = (float) (-i5);
            this.f12382b.rotateX(f5);
            this.f12382b.translate(0.0f, f4, 0.0f);
            this.f12382b.translate(0.0f, f4, 0.0f);
            this.f12382b.rotateX(f5);
            this.f12382b.translate(0.0f, f4, 0.0f);
        } else if (i6 == 1) {
            this.f12382b.translate(0.0f, f4, 0.0f);
            this.f12382b.rotateX((float) i5);
            this.f12382b.translate(0.0f, f4, 0.0f);
        } else if (i6 == 2) {
            this.f12382b.translate(0.0f, f4, 0.0f);
            this.f12382b.rotateX((float) (-i5));
            this.f12382b.translate(0.0f, f4, 0.0f);
        } else if (i6 == 3) {
            this.f12382b.rotateX(0.0f);
        }
    }

    public MBRotationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    private void b(Canvas canvas, int i4, int i5, int i6) {
        canvas.save();
        this.f12382b.save();
        this.f12383c.reset();
        float f4 = (float) i4;
        this.f12382b.translate(f4, 0.0f, 0.0f);
        this.f12382b.rotateY((float) this.f12388h);
        this.f12382b.translate(f4, 0.0f, 0.0f);
        if (i4 == 0) {
            if (this.f12396p) {
                b(this.f12385e, this.f12386f, i6);
            } else {
                b(-this.f12385e, -this.f12386f, i6);
            }
        } else if (i4 > 0) {
            b(this.f12385e, this.f12386f, i6);
        } else if (i4 < 0) {
            b(-this.f12385e, -this.f12386f, i6);
        }
        this.f12382b.getMatrix(this.f12383c);
        this.f12382b.restore();
        this.f12383c.preTranslate((float) (-i5), (float) ((-getHeight()) / 2));
        this.f12383c.postTranslate((float) i5, (float) (getHeight() / 2));
        canvas.concat(this.f12383c);
        View childAt = getChildAt(a(i6));
        if (childAt != null) {
            drawChild(canvas, childAt, 0);
        }
        canvas.restore();
    }

    private void a(Canvas canvas, int i4, int i5, int i6) {
        canvas.save();
        this.f12382b.save();
        this.f12383c.reset();
        float f4 = (float) i4;
        this.f12382b.translate(0.0f, f4, 0.0f);
        this.f12382b.rotateX((float) this.f12388h);
        this.f12382b.translate(0.0f, f4, 0.0f);
        if (i4 == 0) {
            if (this.f12396p) {
                a(this.f12384d, this.f12386f, i6);
            } else {
                a(-this.f12384d, -this.f12386f, i6);
            }
        } else if (i4 > 0) {
            a(this.f12384d, this.f12386f, i6);
        } else if (i4 < 0) {
            a(-this.f12384d, -this.f12386f, i6);
        }
        this.f12382b.getMatrix(this.f12383c);
        this.f12382b.restore();
        this.f12383c.preTranslate((float) ((-getWidth()) / 2), (float) (-i5));
        this.f12383c.postTranslate((float) (getWidth() / 2), (float) i5);
        canvas.concat(this.f12383c);
        View childAt = getChildAt(a(i6));
        if (childAt != null) {
            drawChild(canvas, childAt, 0);
        }
        canvas.restore();
    }

    public MBRotationView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        a();
    }

    private int a(int i4) {
        int i5;
        int i6;
        int i7;
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 != 2) {
                    i5 = i4 != 3 ? 0 : this.f12389i;
                } else if (this.f12396p) {
                    i6 = this.f12389i;
                } else {
                    i7 = this.f12389i;
                    i5 = i7 + 1;
                }
            } else if (this.f12396p) {
                i7 = this.f12389i;
                i5 = i7 + 1;
            } else {
                i6 = this.f12389i;
            }
            i5 = i6 - 1;
        } else if (this.f12396p) {
            i5 = this.f12389i - 2;
        } else {
            i5 = this.f12389i + 2;
        }
        int childCount = i5 % getChildCount();
        if (childCount >= 0) {
            return childCount;
        }
        return childCount + getChildCount();
    }

    static /* synthetic */ void a(MBRotationView mBRotationView) {
        int i4;
        if (mBRotationView.getChildCount() != 0) {
            int i5 = mBRotationView.f12388h - 1;
            mBRotationView.f12388h = i5;
            int i6 = mBRotationView.f12389i;
            mBRotationView.f12390j = i6;
            int i7 = mBRotationView.f12386f;
            int i8 = i5 % i7;
            mBRotationView.f12388h = i8;
            mBRotationView.f12389i = i6 - (i5 / i7);
            if (Math.abs(i8) > mBRotationView.f12386f / 2) {
                i4 = mBRotationView.a(2);
            } else {
                i4 = mBRotationView.a(3);
            }
            if (mBRotationView.f12391k != i4) {
                mBRotationView.f12391k = i4;
            }
            mBRotationView.invalidate();
            if (mBRotationView.f12394n) {
                mBRotationView.postDelayed(mBRotationView.f12381a, (long) (1000 / mBRotationView.f12387g));
            }
        }
    }
}
