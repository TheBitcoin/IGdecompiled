package androidx.core.graphics;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.PointF;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import d3.l;

public final class BitmapKt {
    public static final Bitmap applyCanvas(Bitmap bitmap, l lVar) {
        lVar.invoke(new Canvas(bitmap));
        return bitmap;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000a, code lost:
        r3 = r3.y;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean contains(android.graphics.Bitmap r2, android.graphics.Point r3) {
        /*
            int r0 = r2.getWidth()
            int r1 = r3.x
            if (r1 < 0) goto L_0x0016
            if (r1 >= r0) goto L_0x0016
            int r3 = r3.y
            if (r3 < 0) goto L_0x0016
            int r2 = r2.getHeight()
            if (r3 >= r2) goto L_0x0016
            r2 = 1
            return r2
        L_0x0016:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.BitmapKt.contains(android.graphics.Bitmap, android.graphics.Point):boolean");
    }

    public static final Bitmap createBitmap(int i4, int i5, Bitmap.Config config) {
        return Bitmap.createBitmap(i4, i5, config);
    }

    public static /* synthetic */ Bitmap createBitmap$default(int i4, int i5, Bitmap.Config config, int i6, Object obj) {
        if ((i6 & 4) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        return Bitmap.createBitmap(i4, i5, config);
    }

    public static final int get(Bitmap bitmap, int i4, int i5) {
        return bitmap.getPixel(i4, i5);
    }

    public static final Bitmap scale(Bitmap bitmap, int i4, int i5, boolean z4) {
        return Bitmap.createScaledBitmap(bitmap, i4, i5, z4);
    }

    public static /* synthetic */ Bitmap scale$default(Bitmap bitmap, int i4, int i5, boolean z4, int i6, Object obj) {
        if ((i6 & 4) != 0) {
            z4 = true;
        }
        return Bitmap.createScaledBitmap(bitmap, i4, i5, z4);
    }

    public static final void set(Bitmap bitmap, int i4, int i5, @ColorInt int i6) {
        bitmap.setPixel(i4, i5, i6);
    }

    public static final boolean contains(Bitmap bitmap, PointF pointF) {
        float f4 = pointF.x;
        if (f4 < 0.0f || f4 >= ((float) bitmap.getWidth())) {
            return false;
        }
        float f5 = pointF.y;
        return f5 >= 0.0f && f5 < ((float) bitmap.getHeight());
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final Bitmap createBitmap(int i4, int i5, Bitmap.Config config, boolean z4, ColorSpace colorSpace) {
        return Bitmap.createBitmap(i4, i5, config, z4, colorSpace);
    }

    public static /* synthetic */ Bitmap createBitmap$default(int i4, int i5, Bitmap.Config config, boolean z4, ColorSpace colorSpace, int i6, Object obj) {
        if ((i6 & 4) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        if ((i6 & 8) != 0) {
            z4 = true;
        }
        if ((i6 & 16) != 0) {
            colorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
        }
        return Bitmap.createBitmap(i4, i5, config, z4, colorSpace);
    }
}
