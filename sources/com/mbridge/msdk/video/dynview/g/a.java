package com.mbridge.msdk.video.dynview.g;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;

public final class a extends ShapeDrawable {

    /* renamed from: a  reason: collision with root package name */
    private int f16034a;

    /* renamed from: b  reason: collision with root package name */
    private float f16035b;

    /* renamed from: c  reason: collision with root package name */
    private float f16036c;

    /* renamed from: d  reason: collision with root package name */
    private int f16037d;

    /* renamed from: e  reason: collision with root package name */
    private int f16038e;

    /* renamed from: f  reason: collision with root package name */
    private Bitmap f16039f;

    /* renamed from: g  reason: collision with root package name */
    private Bitmap f16040g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f16041h;

    /* renamed from: i  reason: collision with root package name */
    private Paint f16042i;

    /* renamed from: j  reason: collision with root package name */
    private Matrix f16043j;

    /* renamed from: com.mbridge.msdk.video.dynview.g.a$a  reason: collision with other inner class name */
    public static class C0204a implements b {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public RectShape f16044a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public Bitmap f16045b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public Bitmap f16046c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public boolean f16047d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public int f16048e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public int f16049f;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public int f16050g;
        /* access modifiers changed from: private */

        /* renamed from: h  reason: collision with root package name */
        public float f16051h;
        /* access modifiers changed from: private */

        /* renamed from: i  reason: collision with root package name */
        public float f16052i;

        private C0204a() {
            this.f16049f = 100;
            this.f16050g = 10;
            this.f16044a = new RectShape();
        }

        public final b a(Bitmap bitmap) {
            this.f16045b = bitmap;
            return this;
        }

        public final b b(Bitmap bitmap) {
            this.f16046c = bitmap;
            return this;
        }

        public final b a(boolean z4) {
            this.f16047d = z4;
            return this;
        }

        public final b b(float f4) {
            this.f16052i = f4;
            return this;
        }

        public final b a(int i4) {
            this.f16048e = i4;
            return this;
        }

        public final b a(float f4) {
            this.f16051h = f4;
            return this;
        }

        public final a a() {
            return new a(this);
        }
    }

    public interface b {
        b a(Bitmap bitmap);

        b a(boolean z4);

        b b(float f4);

        b b(Bitmap bitmap);
    }

    private void a(Canvas canvas, Path path, Bitmap bitmap) {
        if (canvas != null && path != null && bitmap != null && !bitmap.isRecycled()) {
            if (!(bitmap.getWidth() == 0 || bitmap.getHeight() == 0)) {
                float max = Math.max(this.f16035b / ((float) bitmap.getWidth()), this.f16036c / ((float) bitmap.getHeight()));
                if (this.f16043j == null) {
                    this.f16043j = new Matrix();
                }
                this.f16043j.reset();
                this.f16043j.preScale(max, max);
            }
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
            bitmapShader.setLocalMatrix(this.f16043j);
            this.f16042i.setShader(bitmapShader);
            canvas.drawPath(path, this.f16042i);
        }
    }

    public final void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f16034a == 1) {
            float f4 = this.f16036c / 2.0f;
            Path path = new Path();
            path.moveTo(0.0f, 0.0f);
            path.lineTo(0.0f, (((float) this.f16037d) + f4) - ((float) this.f16038e));
            path.lineTo(this.f16035b, (f4 - ((float) this.f16037d)) - ((float) this.f16038e));
            path.lineTo(this.f16035b, 0.0f);
            if (this.f16041h) {
                try {
                    a(canvas, path);
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            } else {
                Bitmap bitmap = this.f16039f;
                if (bitmap != null && !bitmap.isRecycled()) {
                    try {
                        a(canvas, path, this.f16039f);
                    } catch (Exception e6) {
                        e6.printStackTrace();
                    }
                }
            }
            Path path2 = new Path();
            path2.moveTo(0.0f, ((float) this.f16037d) + f4 + ((float) this.f16038e));
            path2.lineTo(0.0f, this.f16036c);
            path2.lineTo(this.f16035b, this.f16036c);
            path2.lineTo(this.f16035b, (f4 - ((float) this.f16037d)) + ((float) this.f16038e));
            if (this.f16041h) {
                try {
                    a(canvas, path2);
                } catch (Exception e7) {
                    e7.printStackTrace();
                }
            } else {
                Bitmap bitmap2 = this.f16040g;
                if (bitmap2 != null && !bitmap2.isRecycled()) {
                    try {
                        a(canvas, path2, this.f16040g);
                    } catch (Exception e8) {
                        e8.printStackTrace();
                    }
                }
            }
        } else {
            float f5 = this.f16035b / 2.0f;
            Path path3 = new Path();
            path3.moveTo(0.0f, 0.0f);
            path3.lineTo(0.0f, this.f16036c);
            path3.lineTo((f5 - ((float) this.f16037d)) - ((float) this.f16038e), this.f16036c);
            path3.lineTo((((float) this.f16037d) + f5) - ((float) this.f16038e), 0.0f);
            if (this.f16041h) {
                try {
                    a(canvas, path3);
                } catch (Exception e9) {
                    e9.printStackTrace();
                }
            } else {
                Bitmap bitmap3 = this.f16039f;
                if (bitmap3 != null && !bitmap3.isRecycled()) {
                    try {
                        a(canvas, path3, this.f16039f);
                    } catch (Exception e10) {
                        e10.printStackTrace();
                    }
                }
            }
            Path path4 = new Path();
            path4.moveTo(((float) this.f16037d) + f5 + ((float) this.f16038e), 0.0f);
            path4.lineTo(this.f16035b, 0.0f);
            path4.lineTo(this.f16035b, this.f16036c);
            path4.lineTo((f5 - ((float) this.f16037d)) + ((float) this.f16038e), this.f16036c);
            if (this.f16041h) {
                try {
                    a(canvas, path4);
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
            } else {
                Bitmap bitmap4 = this.f16040g;
                if (bitmap4 != null && !bitmap4.isRecycled()) {
                    try {
                        a(canvas, path4, this.f16040g);
                    } catch (Exception e12) {
                        e12.printStackTrace();
                    }
                }
            }
        }
    }

    public final int getOpacity() {
        return -3;
    }

    private a(C0204a aVar) {
        super(aVar.f16044a);
        this.f16041h = false;
        this.f16039f = aVar.f16045b;
        this.f16040g = aVar.f16046c;
        this.f16041h = aVar.f16047d;
        this.f16034a = aVar.f16048e;
        this.f16037d = aVar.f16049f;
        this.f16038e = aVar.f16050g;
        this.f16035b = aVar.f16051h;
        this.f16036c = aVar.f16052i;
        Paint paint = new Paint();
        this.f16042i = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f16042i.setAntiAlias(true);
        this.f16043j = new Matrix();
    }

    private void a(Canvas canvas, Path path) {
        this.f16042i.setColor(Color.parseColor("#40EAEAEA"));
        canvas.drawPath(path, this.f16042i);
    }

    public static C0204a a() {
        return new C0204a();
    }
}
