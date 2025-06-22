package androidx.core.view.animation;

import android.graphics.Path;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

public final class PathInterpolatorCompat {

    @RequiresApi(21)
    static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static Interpolator createPathInterpolator(Path path) {
            return new PathInterpolator(path);
        }

        @DoNotInline
        static Interpolator createPathInterpolator(float f4, float f5) {
            return new PathInterpolator(f4, f5);
        }

        @DoNotInline
        static Interpolator createPathInterpolator(float f4, float f5, float f6, float f7) {
            return new PathInterpolator(f4, f5, f6, f7);
        }
    }

    private PathInterpolatorCompat() {
    }

    @NonNull
    public static Interpolator create(@NonNull Path path) {
        return Api21Impl.createPathInterpolator(path);
    }

    @NonNull
    public static Interpolator create(float f4, float f5) {
        return Api21Impl.createPathInterpolator(f4, f5);
    }

    @NonNull
    public static Interpolator create(float f4, float f5, float f6, float f7) {
        return Api21Impl.createPathInterpolator(f4, f5, f6, f7);
    }
}
