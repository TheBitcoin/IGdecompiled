package androidx.core.app;

import android.app.Notification;
import android.app.Service;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class ServiceCompat {
    private static final int FOREGROUND_SERVICE_TYPE_ALLOWED_SINCE_Q = 255;
    private static final int FOREGROUND_SERVICE_TYPE_ALLOWED_SINCE_U = 1073745919;
    public static final int START_STICKY = 1;
    public static final int STOP_FOREGROUND_DETACH = 2;
    public static final int STOP_FOREGROUND_REMOVE = 1;

    @RequiresApi(24)
    static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        static void stopForeground(Service service, int i4) {
            service.stopForeground(i4);
        }
    }

    @RequiresApi(29)
    static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        static void startForeground(Service service, int i4, Notification notification, int i5) {
            if (i5 == 0 || i5 == -1) {
                service.startForeground(i4, notification, i5);
            } else {
                service.startForeground(i4, notification, i5 & 255);
            }
        }
    }

    @RequiresApi(34)
    static class Api34Impl {
        private Api34Impl() {
        }

        @DoNotInline
        static void startForeground(Service service, int i4, Notification notification, int i5) {
            if (i5 == 0 || i5 == -1) {
                service.startForeground(i4, notification, i5);
            } else {
                service.startForeground(i4, notification, i5 & ServiceCompat.FOREGROUND_SERVICE_TYPE_ALLOWED_SINCE_U);
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface StopForegroundFlags {
    }

    private ServiceCompat() {
    }

    public static void startForeground(@NonNull Service service, int i4, @NonNull Notification notification, int i5) {
        int i6 = Build.VERSION.SDK_INT;
        if (i6 >= 34) {
            Api34Impl.startForeground(service, i4, notification, i5);
        } else if (i6 >= 29) {
            Api29Impl.startForeground(service, i4, notification, i5);
        } else {
            service.startForeground(i4, notification);
        }
    }

    public static void stopForeground(@NonNull Service service, int i4) {
        if (Build.VERSION.SDK_INT >= 24) {
            Api24Impl.stopForeground(service, i4);
            return;
        }
        boolean z4 = true;
        if ((i4 & 1) == 0) {
            z4 = false;
        }
        service.stopForeground(z4);
    }
}
