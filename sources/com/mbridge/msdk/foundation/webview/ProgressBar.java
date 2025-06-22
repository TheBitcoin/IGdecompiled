package com.mbridge.msdk.foundation.webview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import com.mbridge.msdk.foundation.webview.c;

public class ProgressBar extends View implements c {

    /* renamed from: a  reason: collision with root package name */
    Runnable f13715a = new Runnable() {
        public final void run() {
            ProgressBar.this.invalidate();
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private float f13716b;

    /* renamed from: c  reason: collision with root package name */
    private float f13717c;

    /* renamed from: d  reason: collision with root package name */
    private float f13718d;

    /* renamed from: e  reason: collision with root package name */
    private Drawable f13719e;

    /* renamed from: f  reason: collision with root package name */
    private float f13720f;

    /* renamed from: g  reason: collision with root package name */
    private long f13721g = 25;

    /* renamed from: h  reason: collision with root package name */
    private Handler f13722h = new Handler(Looper.getMainLooper());

    /* renamed from: i  reason: collision with root package name */
    private Drawable f13723i;

    /* renamed from: j  reason: collision with root package name */
    private int f13724j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f13725k = false;

    /* renamed from: l  reason: collision with root package name */
    private boolean f13726l;

    /* renamed from: m  reason: collision with root package name */
    private long f13727m;

    /* renamed from: n  reason: collision with root package name */
    private float f13728n = 0.95f;

    /* renamed from: o  reason: collision with root package name */
    private boolean f13729o = false;

    /* renamed from: p  reason: collision with root package name */
    private c.a f13730p;

    /* renamed from: q  reason: collision with root package name */
    private Drawable f13731q;

    /* renamed from: r  reason: collision with root package name */
    private Rect f13732r = new Rect();

    /* renamed from: s  reason: collision with root package name */
    private Drawable f13733s;

    /* renamed from: t  reason: collision with root package name */
    private float f13734t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f13735u;

    /* renamed from: v  reason: collision with root package name */
    private int f13736v;

    /* renamed from: w  reason: collision with root package name */
    private int f13737w;

    /* renamed from: x  reason: collision with root package name */
    private int f13738x;

    /* renamed from: y  reason: collision with root package name */
    private long f13739y;

    public ProgressBar(Context context) {
        super(context);
        setWillNotDraw(false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0042, code lost:
        if (r12.f13726l != false) goto L_0x005f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004b, code lost:
        if (r12.f13726l != false) goto L_0x0061;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0054, code lost:
        if (r12.f13726l != false) goto L_0x004e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x005d, code lost:
        if (r12.f13726l != false) goto L_0x005f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0127  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0173  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0191  */
    /* JADX WARNING: Removed duplicated region for block: B:78:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void draw(android.graphics.Canvas r13) {
        /*
            r12 = this;
            boolean r0 = r12.f13725k
            r1 = 1
            if (r0 != 0) goto L_0x0007
            r12.f13725k = r1
        L_0x0007:
            long r2 = java.lang.System.currentTimeMillis()
            boolean r0 = r12.f13729o
            if (r0 == 0) goto L_0x0012
            r4 = 0
            goto L_0x0016
        L_0x0012:
            long r4 = r12.f13727m
            long r4 = r2 - r4
        L_0x0016:
            float r0 = (float) r4
            r6 = 1148846080(0x447a0000, float:1000.0)
            float r0 = r0 / r6
            float r0 = java.lang.Math.abs(r0)
            r12.f13718d = r0
            r12.f13727m = r2
            long r2 = r12.f13739y
            long r2 = r2 + r4
            r12.f13739y = r2
            boolean r4 = r12.f13735u
            r5 = 1028443341(0x3d4ccccd, float:0.05)
            r6 = 1045220557(0x3e4ccccd, float:0.2)
            r7 = 1053609165(0x3ecccccd, float:0.4)
            r8 = 1065353216(0x3f800000, float:1.0)
            if (r4 != 0) goto L_0x005b
            r9 = 2000(0x7d0, double:9.88E-321)
            int r11 = (r2 > r9 ? 1 : (r2 == r9 ? 0 : -1))
            if (r11 >= 0) goto L_0x0057
            int r2 = r12.f13737w
            if (r2 != r1) goto L_0x0045
            boolean r1 = r12.f13726l
            if (r1 == 0) goto L_0x0061
            goto L_0x005f
        L_0x0045:
            int r2 = r12.f13736v
            if (r2 != r1) goto L_0x0052
            boolean r1 = r12.f13726l
            if (r1 == 0) goto L_0x004e
            goto L_0x0061
        L_0x004e:
            r7 = 1045220557(0x3e4ccccd, float:0.2)
            goto L_0x0061
        L_0x0052:
            boolean r1 = r12.f13726l
            if (r1 == 0) goto L_0x0057
            goto L_0x004e
        L_0x0057:
            r7 = 1028443341(0x3d4ccccd, float:0.05)
            goto L_0x0061
        L_0x005b:
            boolean r1 = r12.f13726l
            if (r1 == 0) goto L_0x0061
        L_0x005f:
            r7 = 1065353216(0x3f800000, float:1.0)
        L_0x0061:
            r12.f13717c = r7
            float r1 = r12.f13716b
            float r7 = r7 * r0
            float r1 = r1 + r7
            r12.f13716b = r1
            if (r4 != 0) goto L_0x0074
            float r0 = r12.f13728n
            int r1 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r1 <= 0) goto L_0x0074
            r12.f13716b = r0
        L_0x0074:
            android.graphics.Rect r0 = r12.f13732r
            float r1 = r12.f13716b
            float r2 = r12.f13734t
            float r1 = r1 * r2
            int r1 = (int) r1
            r0.right = r1
            android.os.Handler r0 = r12.f13722h
            r1 = 0
            r0.removeCallbacksAndMessages(r1)
            android.os.Handler r0 = r12.f13722h
            java.lang.Runnable r1 = r12.f13715a
            long r2 = r12.f13721g
            r0.postDelayed(r1, r2)
            super.draw(r13)
            float r0 = r12.f13718d
            boolean r1 = r12.f13735u
            r2 = 0
            r3 = 0
            if (r1 == 0) goto L_0x00d2
            float r1 = r12.f13720f
            float r4 = r12.f13734t
            r7 = 1056964608(0x3f000000, float:0.5)
            float r9 = r4 * r7
            float r9 = r1 / r9
            float r8 = r8 - r9
            r9 = 1132396544(0x437f0000, float:255.0)
            float r8 = r8 * r9
            int r8 = (int) r8
            if (r8 >= 0) goto L_0x00ac
            r8 = 0
        L_0x00ac:
            float r4 = r4 * r7
            int r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r1 <= 0) goto L_0x00b5
            r12.setVisible(r3)
        L_0x00b5:
            android.graphics.drawable.Drawable r1 = r12.f13733s
            if (r1 == 0) goto L_0x00bc
            r1.setAlpha(r8)
        L_0x00bc:
            android.graphics.drawable.Drawable r1 = r12.f13719e
            if (r1 == 0) goto L_0x00c3
            r1.setAlpha(r8)
        L_0x00c3:
            android.graphics.drawable.Drawable r1 = r12.f13731q
            if (r1 == 0) goto L_0x00ca
            r1.setAlpha(r8)
        L_0x00ca:
            r13.save()
            float r1 = r12.f13720f
            r13.translate(r1, r2)
        L_0x00d2:
            android.graphics.drawable.Drawable r1 = r12.f13733s
            if (r1 == 0) goto L_0x00fa
            android.graphics.drawable.Drawable r1 = r12.f13731q
            if (r1 == 0) goto L_0x00fa
            android.graphics.Rect r1 = r12.f13732r
            int r1 = r1.width()
            float r1 = (float) r1
            android.graphics.drawable.Drawable r4 = r12.f13731q
            int r4 = r4.getIntrinsicWidth()
            float r4 = (float) r4
            float r4 = r4 * r5
            float r1 = r1 - r4
            int r1 = (int) r1
            android.graphics.drawable.Drawable r4 = r12.f13733s
            int r5 = r4.getIntrinsicHeight()
            r4.setBounds(r3, r3, r1, r5)
            android.graphics.drawable.Drawable r1 = r12.f13733s
            r1.draw(r13)
        L_0x00fa:
            boolean r1 = r12.f13735u
            if (r1 == 0) goto L_0x0123
            android.graphics.drawable.Drawable r1 = r12.f13719e
            if (r1 == 0) goto L_0x0123
            android.graphics.drawable.Drawable r4 = r12.f13731q
            if (r4 == 0) goto L_0x0123
            int r1 = r1.getIntrinsicWidth()
            android.graphics.drawable.Drawable r4 = r12.f13719e
            int r5 = r4.getIntrinsicHeight()
            r4.setBounds(r3, r3, r1, r5)
            r13.save()
            int r1 = -r1
            float r1 = (float) r1
            r13.translate(r1, r2)
            android.graphics.drawable.Drawable r1 = r12.f13719e
            r1.draw(r13)
            r13.restore()
        L_0x0123:
            android.graphics.drawable.Drawable r1 = r12.f13731q
            if (r1 == 0) goto L_0x0141
            r13.save()
            android.graphics.Rect r1 = r12.f13732r
            int r1 = r1.width()
            int r3 = r12.getWidth()
            int r1 = r1 - r3
            float r1 = (float) r1
            r13.translate(r1, r2)
            android.graphics.drawable.Drawable r1 = r12.f13731q
            r1.draw(r13)
            r13.restore()
        L_0x0141:
            boolean r1 = r12.f13735u
            if (r1 != 0) goto L_0x018d
            float r1 = r12.f13716b
            float r3 = r12.f13728n
            float r1 = r1 - r3
            float r1 = java.lang.Math.abs(r1)
            r3 = 925353388(0x3727c5ac, float:1.0E-5)
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 >= 0) goto L_0x018d
            android.graphics.drawable.Drawable r1 = r12.f13723i
            if (r1 == 0) goto L_0x018d
            int r3 = r12.f13724j
            float r3 = (float) r3
            float r0 = r0 * r6
            float r4 = r12.f13734t
            float r0 = r0 * r4
            float r3 = r3 + r0
            int r0 = (int) r3
            r12.f13724j = r0
            int r1 = r1.getIntrinsicWidth()
            int r0 = r0 + r1
            android.graphics.Rect r1 = r12.f13732r
            int r1 = r1.width()
            if (r0 < r1) goto L_0x017c
            android.graphics.drawable.Drawable r0 = r12.f13723i
            int r0 = r0.getIntrinsicWidth()
            int r0 = -r0
            r12.f13724j = r0
        L_0x017c:
            r13.save()
            int r0 = r12.f13724j
            float r0 = (float) r0
            r13.translate(r0, r2)
            android.graphics.drawable.Drawable r0 = r12.f13723i
            r0.draw(r13)
            r13.restore()
        L_0x018d:
            boolean r0 = r12.f13735u
            if (r0 == 0) goto L_0x0194
            r13.restore()
        L_0x0194:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.webview.ProgressBar.draw(android.graphics.Canvas):void");
    }

    public Bitmap getDrawingCache(boolean z4) {
        return null;
    }

    public float getProgress() {
        return this.f13716b;
    }

    public void initResource(boolean z4) {
        if (z4 || (this.f13723i == null && this.f13731q == null && this.f13733s == null && this.f13719e == null)) {
            Drawable drawable = getResources().getDrawable(getResources().getIdentifier("mbridge_cm_highlight", "drawable", com.mbridge.msdk.foundation.controller.c.m().g()));
            this.f13723i = drawable;
            if (drawable != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), this.f13723i.getIntrinsicHeight());
            }
            Drawable drawable2 = getResources().getDrawable(getResources().getIdentifier("mbridge_cm_head", "drawable", com.mbridge.msdk.foundation.controller.c.m().g()));
            this.f13731q = drawable2;
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), this.f13731q.getIntrinsicHeight());
            }
            this.f13733s = getResources().getDrawable(getResources().getIdentifier("mbridge_cm_tail", "drawable", com.mbridge.msdk.foundation.controller.c.m().g()));
            this.f13719e = getResources().getDrawable(getResources().getIdentifier("mbridge_cm_end_animation", "drawable", com.mbridge.msdk.foundation.controller.c.m().g()));
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        super.onLayout(z4, i4, i5, i6, i7);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i4, int i5) {
        super.onMeasure(i4, i5);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i4, int i5, int i6, int i7) {
        super.onSizeChanged(i4, i5, i6, i7);
        this.f13734t = (float) getMeasuredWidth();
    }

    public void onThemeChange() {
        if (this.f13725k) {
            initResource(true);
        }
    }

    public void onWindowFocusChanged(boolean z4) {
        super.onWindowFocusChanged(z4);
        Drawable drawable = this.f13723i;
        if (drawable != null) {
            drawable.setBounds(0, 0, (int) (((double) drawable.getIntrinsicWidth()) * 1.5d), getHeight());
        }
        Drawable drawable2 = this.f13731q;
        if (drawable2 != null) {
            drawable2.setBounds(0, 0, getWidth(), getHeight());
        }
    }

    public void setPaused(boolean z4) {
        this.f13729o = z4;
        if (!z4) {
            this.f13727m = System.currentTimeMillis();
        }
    }

    public void setProgress(float f4, boolean z4) {
        if (z4 && f4 >= 1.0f) {
            startEndAnimation();
        }
    }

    public void setProgressBarListener(c.a aVar) {
        this.f13730p = aVar;
    }

    public void setProgressState(int i4) {
        if (i4 == 5) {
            this.f13736v = 1;
            this.f13737w = 0;
            this.f13738x = 0;
            this.f13739y = 0;
        } else if (i4 == 6) {
            this.f13737w = 1;
            if (this.f13738x == 1) {
                startEndAnimation();
            }
            this.f13739y = 0;
        } else if (i4 == 7) {
            startEndAnimation();
        } else if (i4 == 8) {
            this.f13738x = 1;
            if (this.f13737w == 1) {
                startEndAnimation();
            }
        }
    }

    public void setVisibility(int i4) {
        super.setVisibility(i4);
        if (i4 == 0) {
            c.a aVar = this.f13730p;
            if (aVar != null) {
                aVar.a(true);
                return;
            }
            return;
        }
        c.a aVar2 = this.f13730p;
        if (aVar2 != null) {
            aVar2.a(false);
        }
    }

    public void setVisible(boolean z4) {
        if (z4) {
            this.f13726l = true;
            this.f13727m = System.currentTimeMillis();
            this.f13718d = 0.0f;
            this.f13739y = 0;
            this.f13735u = false;
            this.f13720f = 0.0f;
            this.f13716b = 0.0f;
            this.f13734t = (float) getMeasuredWidth();
            this.f13729o = false;
            this.f13736v = 0;
            this.f13737w = 0;
            this.f13738x = 0;
            Drawable drawable = this.f13723i;
            if (drawable != null) {
                this.f13724j = -drawable.getIntrinsicWidth();
            } else {
                this.f13724j = 0;
            }
            Drawable drawable2 = this.f13733s;
            if (drawable2 != null) {
                drawable2.setAlpha(255);
            }
            Drawable drawable3 = this.f13719e;
            if (drawable3 != null) {
                drawable3.setAlpha(255);
            }
            Drawable drawable4 = this.f13731q;
            if (drawable4 != null) {
                drawable4.setAlpha(255);
            }
            setVisibility(0);
            invalidate();
            return;
        }
        setVisibility(4);
    }

    public void startEndAnimation() {
        if (!this.f13735u) {
            this.f13735u = true;
            this.f13720f = 0.0f;
        }
    }

    public ProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setWillNotDraw(false);
    }
}
