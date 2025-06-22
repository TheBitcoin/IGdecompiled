package androidx.core.graphics.drawable;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.Px;

public final class DrawableKt {
    public static final Bitmap toBitmap(Drawable drawable, @Px int i4, @Px int i5, Bitmap.Config config) {
        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if (bitmapDrawable.getBitmap() == null) {
                throw new IllegalArgumentException("bitmap is null");
            } else if (config == null || bitmapDrawable.getBitmap().getConfig() == config) {
                if (i4 == bitmapDrawable.getBitmap().getWidth() && i5 == bitmapDrawable.getBitmap().getHeight()) {
                    return bitmapDrawable.getBitmap();
                }
                return Bitmap.createScaledBitmap(bitmapDrawable.getBitmap(), i4, i5, true);
            }
        }
        Rect bounds = drawable.getBounds();
        int i6 = bounds.left;
        int i7 = bounds.top;
        int i8 = bounds.right;
        int i9 = bounds.bottom;
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i4, i5, config);
        drawable.setBounds(0, 0, i4, i5);
        drawable.draw(new Canvas(createBitmap));
        drawable.setBounds(i6, i7, i8, i9);
        return createBitmap;
    }

    public static /* synthetic */ Bitmap toBitmap$default(Drawable drawable, int i4, int i5, Bitmap.Config config, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i4 = drawable.getIntrinsicWidth();
        }
        if ((i6 & 2) != 0) {
            i5 = drawable.getIntrinsicHeight();
        }
        if ((i6 & 4) != 0) {
            config = null;
        }
        return toBitmap(drawable, i4, i5, config);
    }

    public static final Bitmap toBitmapOrNull(Drawable drawable, @Px int i4, @Px int i5, Bitmap.Config config) {
        if (!(drawable instanceof BitmapDrawable) || ((BitmapDrawable) drawable).getBitmap() != null) {
            return toBitmap(drawable, i4, i5, config);
        }
        return null;
    }

    public static /* synthetic */ Bitmap toBitmapOrNull$default(Drawable drawable, int i4, int i5, Bitmap.Config config, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i4 = drawable.getIntrinsicWidth();
        }
        if ((i6 & 2) != 0) {
            i5 = drawable.getIntrinsicHeight();
        }
        if ((i6 & 4) != 0) {
            config = null;
        }
        return toBitmapOrNull(drawable, i4, i5, config);
    }

    public static final void updateBounds(Drawable drawable, @Px int i4, @Px int i5, @Px int i6, @Px int i7) {
        drawable.setBounds(i4, i5, i6, i7);
    }

    public static /* synthetic */ void updateBounds$default(Drawable drawable, int i4, int i5, int i6, int i7, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i4 = drawable.getBounds().left;
        }
        if ((i8 & 2) != 0) {
            i5 = drawable.getBounds().top;
        }
        if ((i8 & 4) != 0) {
            i6 = drawable.getBounds().right;
        }
        if ((i8 & 8) != 0) {
            i7 = drawable.getBounds().bottom;
        }
        updateBounds(drawable, i4, i5, i6, i7);
    }
}
