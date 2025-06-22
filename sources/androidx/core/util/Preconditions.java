package androidx.core.util;

import android.text.TextUtils;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.Locale;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class Preconditions {
    private Preconditions() {
    }

    public static void checkArgument(boolean z4) {
        if (!z4) {
            throw new IllegalArgumentException();
        }
    }

    public static float checkArgumentFinite(float f4, @NonNull String str) {
        if (Float.isNaN(f4)) {
            throw new IllegalArgumentException(str + " must not be NaN");
        } else if (!Float.isInfinite(f4)) {
            return f4;
        } else {
            throw new IllegalArgumentException(str + " must not be infinite");
        }
    }

    public static int checkArgumentInRange(int i4, int i5, int i6, @NonNull String str) {
        if (i4 < i5) {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too low)", new Object[]{str, Integer.valueOf(i5), Integer.valueOf(i6)}));
        } else if (i4 <= i6) {
            return i4;
        } else {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too high)", new Object[]{str, Integer.valueOf(i5), Integer.valueOf(i6)}));
        }
    }

    @IntRange(from = 0)
    public static int checkArgumentNonnegative(int i4, @Nullable String str) {
        if (i4 >= 0) {
            return i4;
        }
        throw new IllegalArgumentException(str);
    }

    public static int checkFlagsArgument(int i4, int i5) {
        if ((i4 & i5) == i4) {
            return i4;
        }
        throw new IllegalArgumentException("Requested flags 0x" + Integer.toHexString(i4) + ", but only 0x" + Integer.toHexString(i5) + " are allowed");
    }

    @NonNull
    public static <T> T checkNotNull(@Nullable T t4) {
        t4.getClass();
        return t4;
    }

    public static void checkState(boolean z4, @Nullable String str) {
        if (!z4) {
            throw new IllegalStateException(str);
        }
    }

    @NonNull
    public static <T extends CharSequence> T checkStringNotEmpty(@Nullable T t4) {
        if (!TextUtils.isEmpty(t4)) {
            return t4;
        }
        throw new IllegalArgumentException();
    }

    public static void checkArgument(boolean z4, @NonNull Object obj) {
        if (!z4) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    @IntRange(from = 0)
    public static int checkArgumentNonnegative(int i4) {
        if (i4 >= 0) {
            return i4;
        }
        throw new IllegalArgumentException();
    }

    @NonNull
    public static <T> T checkNotNull(@Nullable T t4, @NonNull Object obj) {
        if (t4 != null) {
            return t4;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static void checkState(boolean z4) {
        checkState(z4, (String) null);
    }

    public static void checkArgument(boolean z4, @NonNull String str, @NonNull Object... objArr) {
        if (!z4) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    @NonNull
    public static <T extends CharSequence> T checkStringNotEmpty(@Nullable T t4, @NonNull Object obj) {
        if (!TextUtils.isEmpty(t4)) {
            return t4;
        }
        throw new IllegalArgumentException(String.valueOf(obj));
    }

    @NonNull
    public static <T extends CharSequence> T checkStringNotEmpty(@Nullable T t4, @NonNull String str, @NonNull Object... objArr) {
        if (!TextUtils.isEmpty(t4)) {
            return t4;
        }
        throw new IllegalArgumentException(String.format(str, objArr));
    }

    public static long checkArgumentInRange(long j4, long j5, long j6, @NonNull String str) {
        if (j4 < j5) {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too low)", new Object[]{str, Long.valueOf(j5), Long.valueOf(j6)}));
        } else if (j4 <= j6) {
            return j4;
        } else {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too high)", new Object[]{str, Long.valueOf(j5), Long.valueOf(j6)}));
        }
    }

    public static float checkArgumentInRange(float f4, float f5, float f6, @NonNull String str) {
        if (f4 < f5) {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%f, %f] (too low)", new Object[]{str, Float.valueOf(f5), Float.valueOf(f6)}));
        } else if (f4 <= f6) {
            return f4;
        } else {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%f, %f] (too high)", new Object[]{str, Float.valueOf(f5), Float.valueOf(f6)}));
        }
    }

    public static double checkArgumentInRange(double d5, double d6, double d7, @NonNull String str) {
        if (d5 < d6) {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%f, %f] (too low)", new Object[]{str, Double.valueOf(d6), Double.valueOf(d7)}));
        } else if (d5 <= d7) {
            return d5;
        } else {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%f, %f] (too high)", new Object[]{str, Double.valueOf(d6), Double.valueOf(d7)}));
        }
    }
}
