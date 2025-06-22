package androidx.core.content.res;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import androidx.annotation.AnyRes;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.RequiresApi;
import androidx.annotation.StyleableRes;
import d3.l;
import kotlin.jvm.internal.m;

public final class TypedArrayKt {
    private static final void checkAttribute(TypedArray typedArray, @StyleableRes int i4) {
        if (!typedArray.hasValue(i4)) {
            throw new IllegalArgumentException("Attribute not defined in set.");
        }
    }

    public static final boolean getBooleanOrThrow(TypedArray typedArray, @StyleableRes int i4) {
        checkAttribute(typedArray, i4);
        return typedArray.getBoolean(i4, false);
    }

    @ColorInt
    public static final int getColorOrThrow(TypedArray typedArray, @StyleableRes int i4) {
        checkAttribute(typedArray, i4);
        return typedArray.getColor(i4, 0);
    }

    public static final ColorStateList getColorStateListOrThrow(TypedArray typedArray, @StyleableRes int i4) {
        checkAttribute(typedArray, i4);
        ColorStateList colorStateList = typedArray.getColorStateList(i4);
        if (colorStateList != null) {
            return colorStateList;
        }
        throw new IllegalStateException("Attribute value was not a color or color state list.");
    }

    public static final float getDimensionOrThrow(TypedArray typedArray, @StyleableRes int i4) {
        checkAttribute(typedArray, i4);
        return typedArray.getDimension(i4, 0.0f);
    }

    @Dimension
    public static final int getDimensionPixelOffsetOrThrow(TypedArray typedArray, @StyleableRes int i4) {
        checkAttribute(typedArray, i4);
        return typedArray.getDimensionPixelOffset(i4, 0);
    }

    @Dimension
    public static final int getDimensionPixelSizeOrThrow(TypedArray typedArray, @StyleableRes int i4) {
        checkAttribute(typedArray, i4);
        return typedArray.getDimensionPixelSize(i4, 0);
    }

    public static final Drawable getDrawableOrThrow(TypedArray typedArray, @StyleableRes int i4) {
        checkAttribute(typedArray, i4);
        Drawable drawable = typedArray.getDrawable(i4);
        m.b(drawable);
        return drawable;
    }

    public static final float getFloatOrThrow(TypedArray typedArray, @StyleableRes int i4) {
        checkAttribute(typedArray, i4);
        return typedArray.getFloat(i4, 0.0f);
    }

    @RequiresApi(26)
    public static final Typeface getFontOrThrow(TypedArray typedArray, @StyleableRes int i4) {
        checkAttribute(typedArray, i4);
        return TypedArrayApi26ImplKt.getFont(typedArray, i4);
    }

    public static final int getIntOrThrow(TypedArray typedArray, @StyleableRes int i4) {
        checkAttribute(typedArray, i4);
        return typedArray.getInt(i4, 0);
    }

    public static final int getIntegerOrThrow(TypedArray typedArray, @StyleableRes int i4) {
        checkAttribute(typedArray, i4);
        return typedArray.getInteger(i4, 0);
    }

    @AnyRes
    public static final int getResourceIdOrThrow(TypedArray typedArray, @StyleableRes int i4) {
        checkAttribute(typedArray, i4);
        return typedArray.getResourceId(i4, 0);
    }

    public static final String getStringOrThrow(TypedArray typedArray, @StyleableRes int i4) {
        checkAttribute(typedArray, i4);
        String string = typedArray.getString(i4);
        if (string != null) {
            return string;
        }
        throw new IllegalStateException("Attribute value could not be coerced to String.");
    }

    public static final CharSequence[] getTextArrayOrThrow(TypedArray typedArray, @StyleableRes int i4) {
        checkAttribute(typedArray, i4);
        return typedArray.getTextArray(i4);
    }

    public static final CharSequence getTextOrThrow(TypedArray typedArray, @StyleableRes int i4) {
        checkAttribute(typedArray, i4);
        CharSequence text = typedArray.getText(i4);
        if (text != null) {
            return text;
        }
        throw new IllegalStateException("Attribute value could not be coerced to CharSequence.");
    }

    public static final <R> R use(TypedArray typedArray, l lVar) {
        R invoke = lVar.invoke(typedArray);
        typedArray.recycle();
        return invoke;
    }
}
