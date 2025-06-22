package androidx.dynamicanimation.animation;

import android.util.FloatProperty;
import androidx.annotation.RequiresApi;

public abstract class FloatPropertyCompat<T> {
    final String mPropertyName;

    public FloatPropertyCompat(String str) {
        this.mPropertyName = str;
    }

    @RequiresApi(24)
    public static <T> FloatPropertyCompat<T> createFloatPropertyCompat(final FloatProperty<T> floatProperty) {
        return new FloatPropertyCompat<T>(floatProperty.getName()) {
            public float getValue(T t4) {
                return ((Float) floatProperty.get(t4)).floatValue();
            }

            public void setValue(T t4, float f4) {
                floatProperty.setValue(t4, f4);
            }
        };
    }

    public abstract float getValue(T t4);

    public abstract void setValue(T t4, float f4);
}
