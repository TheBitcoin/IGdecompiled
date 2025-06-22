package w2;

import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import com.uptodown.util.views.CropImageView;
import kotlin.jvm.internal.m;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    private final CropImageView f22024a;

    public e(CropImageView cropImageView) {
        m.e(cropImageView, "cropImageView");
        this.f22024a = cropImageView;
    }

    private final Matrix b() {
        Matrix imageMatrix = this.f22024a.getImageMatrix();
        m.d(imageMatrix, "getImageMatrix(...)");
        return imageMatrix;
    }

    private final float c(int i4, int i5, float f4, boolean z4) {
        if (z4) {
            return 0.0f;
        }
        if (i4 == 3 || i4 == 4 || i4 == 5) {
            return ((float) i5) - f4;
        }
        if (i4 == 6 || i4 == 7) {
            return (((float) i5) - f4) / 2.0f;
        }
        return 0.0f;
    }

    private final float d(int i4, int i5, float f4, boolean z4) {
        if (!z4) {
            return 0.0f;
        }
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 4) {
                    if (!(i4 == 5 || i4 == 7)) {
                        return 0.0f;
                    }
                }
            }
            return ((float) i5) - f4;
        }
        return (((float) i5) - f4) / 2.0f;
    }

    public final void a() {
        boolean z4;
        int width = (this.f22024a.getWidth() - this.f22024a.getPaddingLeft()) - this.f22024a.getPaddingRight();
        int height = (this.f22024a.getHeight() - this.f22024a.getPaddingTop()) - this.f22024a.getPaddingBottom();
        int cropType = this.f22024a.getCropType();
        Drawable drawable = this.f22024a.getDrawable();
        if (cropType != -1 && height > 0 && width > 0 && drawable != null) {
            Matrix b5 = b();
            int intrinsicWidth = drawable.getIntrinsicWidth();
            float intrinsicHeight = (float) drawable.getIntrinsicHeight();
            float f4 = ((float) height) / intrinsicHeight;
            float f5 = (float) intrinsicWidth;
            float f6 = ((float) width) / f5;
            int i4 = (f6 > f4 ? 1 : (f6 == f4 ? 0 : -1));
            if (i4 > 0) {
                f4 = f6;
            }
            b5.setScale(f4, f4);
            if (i4 > 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            b5.postTranslate(c(cropType, width, f5 * f4, z4), d(cropType, height, intrinsicHeight * f4, z4));
            this.f22024a.setImageMatrix(b5);
        }
    }
}
