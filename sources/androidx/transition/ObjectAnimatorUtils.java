package androidx.transition;

import android.animation.ObjectAnimator;
import android.animation.TypeConverter;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.Property;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

class ObjectAnimatorUtils {

    @RequiresApi(21)
    static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static <T, V> ObjectAnimator ofObject(T t4, Property<T, V> property, Path path) {
            return ObjectAnimator.ofObject(t4, property, (TypeConverter) null, path);
        }
    }

    private ObjectAnimatorUtils() {
    }

    static <T> ObjectAnimator ofPointF(T t4, Property<T, PointF> property, Path path) {
        return Api21Impl.ofObject(t4, property, path);
    }
}
