package com.google.android.material.color;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import com.google.android.material.R;
import com.google.android.material.color.utilities.Blend;
import com.google.android.material.color.utilities.Hct;
import com.google.android.material.resources.MaterialAttributes;

public class MaterialColors {
    public static final float ALPHA_DISABLED = 0.38f;
    public static final float ALPHA_DISABLED_LOW = 0.12f;
    public static final float ALPHA_FULL = 1.0f;
    public static final float ALPHA_LOW = 0.32f;
    public static final float ALPHA_MEDIUM = 0.54f;
    private static final int CHROMA_NEUTRAL = 6;
    private static final int TONE_ACCENT_CONTAINER_DARK = 30;
    private static final int TONE_ACCENT_CONTAINER_LIGHT = 90;
    private static final int TONE_ACCENT_DARK = 80;
    private static final int TONE_ACCENT_LIGHT = 40;
    private static final int TONE_ON_ACCENT_CONTAINER_DARK = 90;
    private static final int TONE_ON_ACCENT_CONTAINER_LIGHT = 10;
    private static final int TONE_ON_ACCENT_DARK = 20;
    private static final int TONE_ON_ACCENT_LIGHT = 100;
    private static final int TONE_SURFACE_CONTAINER_DARK = 12;
    private static final int TONE_SURFACE_CONTAINER_HIGH_DARK = 17;
    private static final int TONE_SURFACE_CONTAINER_HIGH_LIGHT = 92;
    private static final int TONE_SURFACE_CONTAINER_LIGHT = 94;

    private MaterialColors() {
    }

    @ColorInt
    public static int compositeARGBWithAlpha(@ColorInt int i4, @IntRange(from = 0, to = 255) int i5) {
        return ColorUtils.setAlphaComponent(i4, (Color.alpha(i4) * i5) / 255);
    }

    @ColorInt
    public static int getColor(@NonNull View view, @AttrRes int i4) {
        return resolveColor(view.getContext(), MaterialAttributes.resolveTypedValueOrThrow(view, i4));
    }

    @ColorInt
    @Nullable
    public static Integer getColorOrNull(@NonNull Context context, @AttrRes int i4) {
        TypedValue resolve = MaterialAttributes.resolve(context, i4);
        if (resolve != null) {
            return Integer.valueOf(resolveColor(context, resolve));
        }
        return null;
    }

    @ColorInt
    private static int getColorRole(@ColorInt int i4, @IntRange(from = 0, to = 100) int i5) {
        Hct fromInt = Hct.fromInt(i4);
        fromInt.setTone((double) i5);
        return fromInt.toInt();
    }

    @NonNull
    public static ColorRoles getColorRoles(@NonNull Context context, @ColorInt int i4) {
        return getColorRoles(i4, isLightTheme(context));
    }

    @NonNull
    public static ColorStateList getColorStateList(@NonNull Context context, @AttrRes int i4, @NonNull ColorStateList colorStateList) {
        ColorStateList colorStateList2;
        TypedValue resolve = MaterialAttributes.resolve(context, i4);
        if (resolve != null) {
            colorStateList2 = resolveColorStateList(context, resolve);
        } else {
            colorStateList2 = null;
        }
        if (colorStateList2 == null) {
            return colorStateList;
        }
        return colorStateList2;
    }

    @Nullable
    public static ColorStateList getColorStateListOrNull(@NonNull Context context, @AttrRes int i4) {
        TypedValue resolve = MaterialAttributes.resolve(context, i4);
        if (resolve == null) {
            return null;
        }
        int i5 = resolve.resourceId;
        if (i5 != 0) {
            return ContextCompat.getColorStateList(context, i5);
        }
        int i6 = resolve.data;
        if (i6 != 0) {
            return ColorStateList.valueOf(i6);
        }
        return null;
    }

    @ColorInt
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static int getSurfaceContainerFromSeed(@NonNull Context context, @ColorInt int i4) {
        int i5;
        if (isLightTheme(context)) {
            i5 = 94;
        } else {
            i5 = 12;
        }
        return getColorRole(i4, i5, 6);
    }

    @ColorInt
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static int getSurfaceContainerHighFromSeed(@NonNull Context context, @ColorInt int i4) {
        int i5;
        if (isLightTheme(context)) {
            i5 = 92;
        } else {
            i5 = 17;
        }
        return getColorRole(i4, i5, 6);
    }

    @ColorInt
    public static int harmonize(@ColorInt int i4, @ColorInt int i5) {
        return Blend.harmonize(i4, i5);
    }

    @ColorInt
    public static int harmonizeWithPrimary(@NonNull Context context, @ColorInt int i4) {
        return harmonize(i4, getColor(context, R.attr.colorPrimary, MaterialColors.class.getCanonicalName()));
    }

    public static boolean isColorLight(@ColorInt int i4) {
        if (i4 == 0 || ColorUtils.calculateLuminance(i4) <= 0.5d) {
            return false;
        }
        return true;
    }

    static boolean isLightTheme(@NonNull Context context) {
        return MaterialAttributes.resolveBoolean(context, R.attr.isLightTheme, true);
    }

    @ColorInt
    public static int layer(@NonNull View view, @AttrRes int i4, @AttrRes int i5) {
        return layer(view, i4, i5, 1.0f);
    }

    private static int resolveColor(@NonNull Context context, @NonNull TypedValue typedValue) {
        int i4 = typedValue.resourceId;
        if (i4 != 0) {
            return ContextCompat.getColor(context, i4);
        }
        return typedValue.data;
    }

    private static ColorStateList resolveColorStateList(@NonNull Context context, @NonNull TypedValue typedValue) {
        int i4 = typedValue.resourceId;
        if (i4 != 0) {
            return ContextCompat.getColorStateList(context, i4);
        }
        return ColorStateList.valueOf(typedValue.data);
    }

    @NonNull
    public static ColorRoles getColorRoles(@ColorInt int i4, boolean z4) {
        if (z4) {
            return new ColorRoles(getColorRole(i4, 40), getColorRole(i4, 100), getColorRole(i4, 90), getColorRole(i4, 10));
        }
        return new ColorRoles(getColorRole(i4, 80), getColorRole(i4, 20), getColorRole(i4, 30), getColorRole(i4, 90));
    }

    @ColorInt
    public static int layer(@NonNull View view, @AttrRes int i4, @AttrRes int i5, @FloatRange(from = 0.0d, to = 1.0d) float f4) {
        return layer(getColor(view, i4), getColor(view, i5), f4);
    }

    @ColorInt
    public static int getColor(Context context, @AttrRes int i4, String str) {
        return resolveColor(context, MaterialAttributes.resolveTypedValueOrThrow(context, i4, str));
    }

    @ColorInt
    private static int getColorRole(@ColorInt int i4, @IntRange(from = 0, to = 100) int i5, int i6) {
        Hct fromInt = Hct.fromInt(getColorRole(i4, i5));
        fromInt.setChroma((double) i6);
        return fromInt.toInt();
    }

    @ColorInt
    public static int layer(@ColorInt int i4, @ColorInt int i5, @FloatRange(from = 0.0d, to = 1.0d) float f4) {
        return layer(i4, ColorUtils.setAlphaComponent(i5, Math.round(((float) Color.alpha(i5)) * f4)));
    }

    @ColorInt
    public static int getColor(@NonNull View view, @AttrRes int i4, @ColorInt int i5) {
        return getColor(view.getContext(), i4, i5);
    }

    @ColorInt
    public static int getColor(@NonNull Context context, @AttrRes int i4, @ColorInt int i5) {
        Integer colorOrNull = getColorOrNull(context, i4);
        return colorOrNull != null ? colorOrNull.intValue() : i5;
    }

    @ColorInt
    public static int layer(@ColorInt int i4, @ColorInt int i5) {
        return ColorUtils.compositeColors(i5, i4);
    }
}
