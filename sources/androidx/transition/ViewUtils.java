package androidx.transition;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import android.util.Property;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

class ViewUtils {
    static final Property<View, Rect> CLIP_BOUNDS = new Property<View, Rect>(Rect.class, "clipBounds") {
        public Rect get(View view) {
            return view.getClipBounds();
        }

        public void set(View view, Rect rect) {
            view.setClipBounds(rect);
        }
    };
    private static final ViewUtilsApi19 IMPL;
    private static final String TAG = "ViewUtils";
    static final Property<View, Float> TRANSITION_ALPHA = new Property<View, Float>(Float.class, "translationAlpha") {
        public Float get(View view) {
            return Float.valueOf(ViewUtils.getTransitionAlpha(view));
        }

        public void set(View view, Float f4) {
            ViewUtils.setTransitionAlpha(view, f4.floatValue());
        }
    };

    static {
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 29) {
            IMPL = new ViewUtilsApi29();
        } else if (i4 >= 23) {
            IMPL = new ViewUtilsApi23();
        } else if (i4 >= 22) {
            IMPL = new ViewUtilsApi22();
        } else {
            IMPL = new ViewUtilsApi21();
        }
    }

    private ViewUtils() {
    }

    static void clearNonTransitionAlpha(@NonNull View view) {
        IMPL.clearNonTransitionAlpha(view);
    }

    static float getTransitionAlpha(@NonNull View view) {
        return IMPL.getTransitionAlpha(view);
    }

    static void saveNonTransitionAlpha(@NonNull View view) {
        IMPL.saveNonTransitionAlpha(view);
    }

    static void setAnimationMatrix(@NonNull View view, @Nullable Matrix matrix) {
        IMPL.setAnimationMatrix(view, matrix);
    }

    static void setLeftTopRightBottom(@NonNull View view, int i4, int i5, int i6, int i7) {
        IMPL.setLeftTopRightBottom(view, i4, i5, i6, i7);
    }

    static void setTransitionAlpha(@NonNull View view, float f4) {
        IMPL.setTransitionAlpha(view, f4);
    }

    static void setTransitionVisibility(@NonNull View view, int i4) {
        IMPL.setTransitionVisibility(view, i4);
    }

    static void transformMatrixToGlobal(@NonNull View view, @NonNull Matrix matrix) {
        IMPL.transformMatrixToGlobal(view, matrix);
    }

    static void transformMatrixToLocal(@NonNull View view, @NonNull Matrix matrix) {
        IMPL.transformMatrixToLocal(view, matrix);
    }
}
