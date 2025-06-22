package com.google.android.material.canvas;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class CanvasCompat {

    public interface CanvasOperation {
        void run(@NonNull Canvas canvas);
    }

    private CanvasCompat() {
    }

    public static int saveLayerAlpha(@NonNull Canvas canvas, @Nullable RectF rectF, int i4) {
        if (Build.VERSION.SDK_INT > 21) {
            return canvas.saveLayerAlpha(rectF, i4);
        }
        return canvas.saveLayerAlpha(rectF, i4, 31);
    }

    public static int saveLayerAlpha(@NonNull Canvas canvas, float f4, float f5, float f6, float f7, int i4) {
        if (Build.VERSION.SDK_INT > 21) {
            return canvas.saveLayerAlpha(f4, f5, f6, f7, i4);
        }
        return canvas.saveLayerAlpha(f4, f5, f6, f7, i4, 31);
    }
}
