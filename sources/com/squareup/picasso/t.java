package com.squareup.picasso;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.widget.ImageView;
import com.squareup.picasso.s;

final class t extends BitmapDrawable {

    /* renamed from: h  reason: collision with root package name */
    private static final Paint f17340h = new Paint();

    /* renamed from: a  reason: collision with root package name */
    private final boolean f17341a;

    /* renamed from: b  reason: collision with root package name */
    private final float f17342b;

    /* renamed from: c  reason: collision with root package name */
    private final s.e f17343c;

    /* renamed from: d  reason: collision with root package name */
    Drawable f17344d;

    /* renamed from: e  reason: collision with root package name */
    long f17345e;

    /* renamed from: f  reason: collision with root package name */
    boolean f17346f;

    /* renamed from: g  reason: collision with root package name */
    int f17347g = 255;

    t(Context context, Bitmap bitmap, Drawable drawable, s.e eVar, boolean z4, boolean z5) {
        super(context.getResources(), bitmap);
        this.f17341a = z5;
        this.f17342b = context.getResources().getDisplayMetrics().density;
        this.f17343c = eVar;
        if (eVar != s.e.MEMORY && !z4) {
            this.f17344d = drawable;
            this.f17346f = true;
            this.f17345e = SystemClock.uptimeMillis();
        }
    }

    private void a(Canvas canvas) {
        Paint paint = f17340h;
        paint.setColor(-1);
        canvas.drawPath(b(0, 0, (int) (this.f17342b * 16.0f)), paint);
        paint.setColor(this.f17343c.f17334a);
        canvas.drawPath(b(0, 0, (int) (this.f17342b * 15.0f)), paint);
    }

    private static Path b(int i4, int i5, int i6) {
        Path path = new Path();
        float f4 = (float) i4;
        float f5 = (float) i5;
        path.moveTo(f4, f5);
        path.lineTo((float) (i4 + i6), f5);
        path.lineTo(f4, (float) (i5 + i6));
        return path;
    }

    static void c(ImageView imageView, Context context, Bitmap bitmap, s.e eVar, boolean z4, boolean z5) {
        Drawable drawable = imageView.getDrawable();
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).stop();
        }
        imageView.setImageDrawable(new t(context, bitmap, drawable, eVar, z4, z5));
    }

    static void d(ImageView imageView, Drawable drawable) {
        imageView.setImageDrawable(drawable);
        if (imageView.getDrawable() instanceof Animatable) {
            ((Animatable) imageView.getDrawable()).start();
        }
    }

    public void draw(Canvas canvas) {
        if (!this.f17346f) {
            super.draw(canvas);
        } else {
            float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.f17345e)) / 200.0f;
            if (uptimeMillis >= 1.0f) {
                this.f17346f = false;
                this.f17344d = null;
                super.draw(canvas);
            } else {
                Drawable drawable = this.f17344d;
                if (drawable != null) {
                    drawable.draw(canvas);
                }
                super.setAlpha((int) (((float) this.f17347g) * uptimeMillis));
                super.draw(canvas);
                super.setAlpha(this.f17347g);
            }
        }
        if (this.f17341a) {
            a(canvas);
        }
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f17344d;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        super.onBoundsChange(rect);
    }

    public void setAlpha(int i4) {
        this.f17347g = i4;
        Drawable drawable = this.f17344d;
        if (drawable != null) {
            drawable.setAlpha(i4);
        }
        super.setAlpha(i4);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f17344d;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        }
        super.setColorFilter(colorFilter);
    }
}
