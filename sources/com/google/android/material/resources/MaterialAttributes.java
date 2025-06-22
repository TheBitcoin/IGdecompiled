package com.google.android.material.resources;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.AttrRes;
import androidx.annotation.DimenRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import com.google.android.material.R;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class MaterialAttributes {
    @Nullable
    public static TypedValue resolve(@NonNull Context context, @AttrRes int i4) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i4, typedValue, true)) {
            return typedValue;
        }
        return null;
    }

    public static boolean resolveBoolean(@NonNull Context context, @AttrRes int i4, boolean z4) {
        TypedValue resolve = resolve(context, i4);
        if (resolve == null || resolve.type != 18) {
            return z4;
        }
        if (resolve.data != 0) {
            return true;
        }
        return false;
    }

    public static boolean resolveBooleanOrThrow(@NonNull Context context, @AttrRes int i4, @NonNull String str) {
        if (resolveOrThrow(context, i4, str) != 0) {
            return true;
        }
        return false;
    }

    @Px
    public static int resolveDimension(@NonNull Context context, @AttrRes int i4, @DimenRes int i5) {
        float dimension;
        TypedValue resolve = resolve(context, i4);
        if (resolve == null || resolve.type != 5) {
            dimension = context.getResources().getDimension(i5);
        } else {
            dimension = resolve.getDimension(context.getResources().getDisplayMetrics());
        }
        return (int) dimension;
    }

    public static int resolveInteger(@NonNull Context context, @AttrRes int i4, int i5) {
        TypedValue resolve = resolve(context, i4);
        if (resolve == null || resolve.type != 16) {
            return i5;
        }
        return resolve.data;
    }

    @Px
    public static int resolveMinimumAccessibleTouchTarget(@NonNull Context context) {
        return resolveDimension(context, R.attr.minTouchTargetSize, R.dimen.mtrl_min_touch_target_size);
    }

    public static int resolveOrThrow(@NonNull Context context, @AttrRes int i4, @NonNull String str) {
        return resolveTypedValueOrThrow(context, i4, str).data;
    }

    @NonNull
    public static TypedValue resolveTypedValueOrThrow(@NonNull View view, @AttrRes int i4) {
        return resolveTypedValueOrThrow(view.getContext(), i4, view.getClass().getCanonicalName());
    }

    public static int resolveOrThrow(@NonNull View view, @AttrRes int i4) {
        return resolveTypedValueOrThrow(view, i4).data;
    }

    @NonNull
    public static TypedValue resolveTypedValueOrThrow(@NonNull Context context, @AttrRes int i4, @NonNull String str) {
        TypedValue resolve = resolve(context, i4);
        if (resolve != null) {
            return resolve;
        }
        throw new IllegalArgumentException(String.format("%1$s requires a value for the %2$s attribute to be set in your app theme. You can either set the attribute in your theme or update your theme to inherit from Theme.MaterialComponents (or a descendant).", new Object[]{str, context.getResources().getResourceName(i4)}));
    }
}
