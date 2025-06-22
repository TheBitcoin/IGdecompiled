package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleableRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.res.ResourcesCompat;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class TintTypedArray {
    private final Context mContext;
    private TypedValue mTypedValue;
    private final TypedArray mWrapped;

    @RequiresApi(21)
    static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static int getChangingConfigurations(TypedArray typedArray) {
            return typedArray.getChangingConfigurations();
        }

        @DoNotInline
        static int getType(TypedArray typedArray, int i4) {
            return typedArray.getType(i4);
        }
    }

    private TintTypedArray(Context context, TypedArray typedArray) {
        this.mContext = context;
        this.mWrapped = typedArray;
    }

    public static TintTypedArray obtainStyledAttributes(Context context, AttributeSet attributeSet, int[] iArr) {
        return new TintTypedArray(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public boolean getBoolean(int i4, boolean z4) {
        return this.mWrapped.getBoolean(i4, z4);
    }

    @RequiresApi(21)
    public int getChangingConfigurations() {
        return Api21Impl.getChangingConfigurations(this.mWrapped);
    }

    public int getColor(int i4, int i5) {
        return this.mWrapped.getColor(i4, i5);
    }

    public ColorStateList getColorStateList(int i4) {
        int resourceId;
        ColorStateList colorStateList;
        if (!this.mWrapped.hasValue(i4) || (resourceId = this.mWrapped.getResourceId(i4, 0)) == 0 || (colorStateList = AppCompatResources.getColorStateList(this.mContext, resourceId)) == null) {
            return this.mWrapped.getColorStateList(i4);
        }
        return colorStateList;
    }

    public float getDimension(int i4, float f4) {
        return this.mWrapped.getDimension(i4, f4);
    }

    public int getDimensionPixelOffset(int i4, int i5) {
        return this.mWrapped.getDimensionPixelOffset(i4, i5);
    }

    public int getDimensionPixelSize(int i4, int i5) {
        return this.mWrapped.getDimensionPixelSize(i4, i5);
    }

    public Drawable getDrawable(int i4) {
        int resourceId;
        if (!this.mWrapped.hasValue(i4) || (resourceId = this.mWrapped.getResourceId(i4, 0)) == 0) {
            return this.mWrapped.getDrawable(i4);
        }
        return AppCompatResources.getDrawable(this.mContext, resourceId);
    }

    public Drawable getDrawableIfKnown(int i4) {
        int resourceId;
        if (!this.mWrapped.hasValue(i4) || (resourceId = this.mWrapped.getResourceId(i4, 0)) == 0) {
            return null;
        }
        return AppCompatDrawableManager.get().getDrawable(this.mContext, resourceId, true);
    }

    public float getFloat(int i4, float f4) {
        return this.mWrapped.getFloat(i4, f4);
    }

    @Nullable
    public Typeface getFont(@StyleableRes int i4, int i5, @Nullable ResourcesCompat.FontCallback fontCallback) {
        int resourceId = this.mWrapped.getResourceId(i4, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.mTypedValue == null) {
            this.mTypedValue = new TypedValue();
        }
        return ResourcesCompat.getFont(this.mContext, resourceId, this.mTypedValue, i5, fontCallback);
    }

    public float getFraction(int i4, int i5, int i6, float f4) {
        return this.mWrapped.getFraction(i4, i5, i6, f4);
    }

    public int getIndex(int i4) {
        return this.mWrapped.getIndex(i4);
    }

    public int getIndexCount() {
        return this.mWrapped.getIndexCount();
    }

    public int getInt(int i4, int i5) {
        return this.mWrapped.getInt(i4, i5);
    }

    public int getInteger(int i4, int i5) {
        return this.mWrapped.getInteger(i4, i5);
    }

    public int getLayoutDimension(int i4, String str) {
        return this.mWrapped.getLayoutDimension(i4, str);
    }

    public String getNonResourceString(int i4) {
        return this.mWrapped.getNonResourceString(i4);
    }

    public String getPositionDescription() {
        return this.mWrapped.getPositionDescription();
    }

    public int getResourceId(int i4, int i5) {
        return this.mWrapped.getResourceId(i4, i5);
    }

    public Resources getResources() {
        return this.mWrapped.getResources();
    }

    public String getString(int i4) {
        return this.mWrapped.getString(i4);
    }

    public CharSequence getText(int i4) {
        return this.mWrapped.getText(i4);
    }

    public CharSequence[] getTextArray(int i4) {
        return this.mWrapped.getTextArray(i4);
    }

    public int getType(int i4) {
        return Api21Impl.getType(this.mWrapped, i4);
    }

    public boolean getValue(int i4, TypedValue typedValue) {
        return this.mWrapped.getValue(i4, typedValue);
    }

    public TypedArray getWrappedTypeArray() {
        return this.mWrapped;
    }

    public boolean hasValue(int i4) {
        return this.mWrapped.hasValue(i4);
    }

    public int length() {
        return this.mWrapped.length();
    }

    public TypedValue peekValue(int i4) {
        return this.mWrapped.peekValue(i4);
    }

    public void recycle() {
        this.mWrapped.recycle();
    }

    public static TintTypedArray obtainStyledAttributes(Context context, AttributeSet attributeSet, int[] iArr, int i4, int i5) {
        return new TintTypedArray(context, context.obtainStyledAttributes(attributeSet, iArr, i4, i5));
    }

    public int getLayoutDimension(int i4, int i5) {
        return this.mWrapped.getLayoutDimension(i4, i5);
    }

    public static TintTypedArray obtainStyledAttributes(Context context, int i4, int[] iArr) {
        return new TintTypedArray(context, context.obtainStyledAttributes(i4, iArr));
    }
}
