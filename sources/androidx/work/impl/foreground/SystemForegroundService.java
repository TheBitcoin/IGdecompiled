package androidx.work.impl.foreground;

import android.app.ForegroundServiceStartNotAllowedException;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.DoNotInline;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;
import androidx.annotation.RestrictTo;
import androidx.lifecycle.LifecycleService;
import androidx.work.Logger;
import androidx.work.impl.foreground.SystemForegroundDispatcher;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class SystemForegroundService extends LifecycleService implements SystemForegroundDispatcher.Callback {
    /* access modifiers changed from: private */
    public static final String TAG = Logger.tagWithPrefix("SystemFgService");
    @Nullable
    private static SystemForegroundService sForegroundService = null;
    SystemForegroundDispatcher mDispatcher;
    private Handler mHandler;
    private boolean mIsShutdown;
    NotificationManager mNotificationManager;

    @RequiresApi(29)
    static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        static void startForeground(Service service, int i4, Notification notification, int i5) {
            service.startForeground(i4, notification, i5);
        }
    }

    @RequiresApi(31)
    static class Api31Impl {
        private Api31Impl() {
        }

        @DoNotInline
        static void startForeground(Service service, int i4, Notification notification, int i5) {
            try {
                service.startForeground(i4, notification, i5);
            } catch (ForegroundServiceStartNotAllowedException e5) {
                Logger.get().warning(SystemForegroundService.TAG, "Unable to start foreground service", e5);
            } catch (SecurityException e6) {
                Logger.get().warning(SystemForegroundService.TAG, "Unable to start foreground service", e6);
            }
        }
    }

    @Nullable
    public static SystemForegroundService getInstance() {
        return sForegroundService;
    }

    @MainThread
    private void initializeDispatcher() {
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mNotificationManager = (NotificationManager) getApplicationContext().getSystemService("notification");
        SystemForegroundDispatcher systemForegroundDispatcher = new SystemForegroundDispatcher(getApplicationContext());
        this.mDispatcher = systemForegroundDispatcher;
        systemForegroundDispatcher.setCallback(this);
    }

    public void cancelNotification(final int i4) {
        this.mHandler.post(new Runnable() {
            public void run() {
                SystemForegroundService.this.mNotificationManager.cancel(i4);
            }
        });
    }

    @RequiresPermission("android.permission.POST_NOTIFICATIONS")
    public void notify(final int i4, @NonNull final Notification notification) {
        this.mHandler.post(new Runnable() {
            public void run() {
                SystemForegroundService.this.mNotificationManager.notify(i4, notification);
            }
        });
    }

    public void onCreate() {
        super.onCreate();
        sForegroundService = this;
        initializeDispatcher();
    }

    public void onDestroy() {
        super.onDestroy();
        this.mDispatcher.onDestroy();
    }

    public int onStartCommand(@Nullable Intent intent, int i4, int i5) {
        super.onStartCommand(intent, i4, i5);
        if (this.mIsShutdown) {
            Logger.get().info(TAG, "Re-initializing SystemForegroundService after a request to shut-down.");
            this.mDispatcher.onDestroy();
            initializeDispatcher();
            this.mIsShutdown = false;
        }
        if (intent == null) {
            return 3;
        }
        this.mDispatcher.onStartCommand(intent);
        return 3;
    }

    public void startForeground(final int i4, final int i5, @NonNull final Notification notification) {
        this.mHandler.post(new Runnable() {
            public void run() {
                int i4 = Build.VERSION.SDK_INT;
                if (i4 >= 31) {
                    Api31Impl.startForeground(SystemForegroundService.this, i4, notification, i5);
                } else if (i4 >= 29) {
                    Api29Impl.startForeground(SystemForegroundService.this, i4, notification, i5);
                } else {
                    SystemForegroundService.this.startForeground(i4, notification);
                }
            }
        });
    }

    @MainThread
    public void stop() {
        this.mIsShutdown = true;
        Logger.get().debug(TAG, "All commands completed.");
        if (Build.VERSION.SDK_INT >= 26) {
            stopForeground(true);
        }
        sForegroundService = null;
        stopSelf();
    }
}
