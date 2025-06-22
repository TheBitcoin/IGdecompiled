package androidx.core.os;

import android.os.Build;
import android.os.ext.SdkExtensions;
import androidx.annotation.ChecksSdkIntAtLeast;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.exifinterface.media.ExifInterface;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Locale;
import kotlin.jvm.internal.m;

public final class BuildCompat {
    @ChecksSdkIntAtLeast(extension = 1000000)
    public static final int AD_SERVICES_EXTENSION_INT;
    public static final BuildCompat INSTANCE = new BuildCompat();
    @ChecksSdkIntAtLeast(extension = 30)
    public static final int R_EXTENSION_INT;
    @ChecksSdkIntAtLeast(extension = 31)
    public static final int S_EXTENSION_INT;
    @ChecksSdkIntAtLeast(extension = 33)
    public static final int T_EXTENSION_INT;

    @RequiresApi(30)
    private static final class Api30Impl {
        public static final Api30Impl INSTANCE = new Api30Impl();

        private Api30Impl() {
        }

        @DoNotInline
        public final int getExtensionVersion(int i4) {
            return SdkExtensions.getExtensionVersion(i4);
        }
    }

    @Retention(RetentionPolicy.CLASS)
    public @interface PrereleaseSdkCheck {
    }

    static {
        int i4;
        int i5;
        int i6;
        int i7 = Build.VERSION.SDK_INT;
        int i8 = 0;
        if (i7 >= 30) {
            i4 = Api30Impl.INSTANCE.getExtensionVersion(30);
        } else {
            i4 = 0;
        }
        R_EXTENSION_INT = i4;
        if (i7 >= 30) {
            i5 = Api30Impl.INSTANCE.getExtensionVersion(31);
        } else {
            i5 = 0;
        }
        S_EXTENSION_INT = i5;
        if (i7 >= 30) {
            i6 = Api30Impl.INSTANCE.getExtensionVersion(33);
        } else {
            i6 = 0;
        }
        T_EXTENSION_INT = i6;
        if (i7 >= 30) {
            i8 = Api30Impl.INSTANCE.getExtensionVersion(1000000);
        }
        AD_SERVICES_EXTENSION_INT = i8;
    }

    private BuildCompat() {
    }

    @ChecksSdkIntAtLeast(api = 24)
    public static final boolean isAtLeastN() {
        if (Build.VERSION.SDK_INT >= 24) {
            return true;
        }
        return false;
    }

    @ChecksSdkIntAtLeast(api = 25)
    public static final boolean isAtLeastNMR1() {
        if (Build.VERSION.SDK_INT >= 25) {
            return true;
        }
        return false;
    }

    @ChecksSdkIntAtLeast(api = 26)
    public static final boolean isAtLeastO() {
        if (Build.VERSION.SDK_INT >= 26) {
            return true;
        }
        return false;
    }

    @ChecksSdkIntAtLeast(api = 27)
    public static final boolean isAtLeastOMR1() {
        if (Build.VERSION.SDK_INT >= 27) {
            return true;
        }
        return false;
    }

    @ChecksSdkIntAtLeast(api = 28)
    public static final boolean isAtLeastP() {
        if (Build.VERSION.SDK_INT >= 28) {
            return true;
        }
        return false;
    }

    @VisibleForTesting
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final boolean isAtLeastPreReleaseCodename(String str, String str2) {
        m.e(str, "codename");
        m.e(str2, "buildCodename");
        if (m.a("REL", str2)) {
            return false;
        }
        Locale locale = Locale.ROOT;
        String upperCase = str2.toUpperCase(locale);
        m.d(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        String upperCase2 = str.toUpperCase(locale);
        m.d(upperCase2, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        if (upperCase.compareTo(upperCase2) >= 0) {
            return true;
        }
        return false;
    }

    @ChecksSdkIntAtLeast(api = 29)
    public static final boolean isAtLeastQ() {
        if (Build.VERSION.SDK_INT >= 29) {
            return true;
        }
        return false;
    }

    @ChecksSdkIntAtLeast(api = 30)
    public static final boolean isAtLeastR() {
        if (Build.VERSION.SDK_INT >= 30) {
            return true;
        }
        return false;
    }

    @ChecksSdkIntAtLeast(api = 31, codename = "S")
    public static final boolean isAtLeastS() {
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 31) {
            return true;
        }
        if (i4 < 30) {
            return false;
        }
        String str = Build.VERSION.CODENAME;
        m.d(str, "CODENAME");
        if (isAtLeastPreReleaseCodename(ExifInterface.LATITUDE_SOUTH, str)) {
            return true;
        }
        return false;
    }

    @ChecksSdkIntAtLeast(api = 32, codename = "Sv2")
    public static final boolean isAtLeastSv2() {
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 32) {
            return true;
        }
        if (i4 < 31) {
            return false;
        }
        String str = Build.VERSION.CODENAME;
        m.d(str, "CODENAME");
        if (isAtLeastPreReleaseCodename("Sv2", str)) {
            return true;
        }
        return false;
    }

    @ChecksSdkIntAtLeast(api = 33, codename = "Tiramisu")
    public static final boolean isAtLeastT() {
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 33) {
            return true;
        }
        if (i4 < 32) {
            return false;
        }
        String str = Build.VERSION.CODENAME;
        m.d(str, "CODENAME");
        if (isAtLeastPreReleaseCodename("Tiramisu", str)) {
            return true;
        }
        return false;
    }

    @ChecksSdkIntAtLeast(api = 34, codename = "UpsideDownCake")
    public static final boolean isAtLeastU() {
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 34) {
            return true;
        }
        if (i4 < 33) {
            return false;
        }
        String str = Build.VERSION.CODENAME;
        m.d(str, "CODENAME");
        if (isAtLeastPreReleaseCodename("UpsideDownCake", str)) {
            return true;
        }
        return false;
    }

    @ChecksSdkIntAtLeast(codename = "VanillaIceCream")
    @PrereleaseSdkCheck
    public static final boolean isAtLeastV() {
        if (Build.VERSION.SDK_INT < 34) {
            return false;
        }
        String str = Build.VERSION.CODENAME;
        m.d(str, "CODENAME");
        if (isAtLeastPreReleaseCodename("VanillaIceCream", str)) {
            return true;
        }
        return false;
    }
}
