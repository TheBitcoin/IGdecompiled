package androidx.core.app;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import java.io.Closeable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.CountDownLatch;

public final class PendingIntentCompat {

    @RequiresApi(23)
    private static class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        public static void send(@NonNull PendingIntent pendingIntent, @NonNull Context context, int i4, @NonNull Intent intent, @Nullable PendingIntent.OnFinished onFinished, @Nullable Handler handler, @Nullable String str, @Nullable Bundle bundle) throws PendingIntent.CanceledException {
            pendingIntent.send(context, i4, intent, onFinished, handler, str, bundle);
        }
    }

    @RequiresApi(26)
    private static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        public static PendingIntent getForegroundService(Context context, int i4, Intent intent, int i5) {
            return PendingIntent.getForegroundService(context, i4, intent, i5);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    private static class GatedCallback implements Closeable, AutoCloseable {
        @Nullable
        private PendingIntent.OnFinished mCallback;
        private final CountDownLatch mComplete = new CountDownLatch(1);
        private boolean mSuccess;

        GatedCallback(@Nullable PendingIntent.OnFinished onFinished) {
            this.mCallback = onFinished;
            this.mSuccess = false;
        }

        /* access modifiers changed from: private */
        public void onSendFinished(PendingIntent pendingIntent, Intent intent, int i4, String str, Bundle bundle) {
            boolean z4 = false;
            while (true) {
                try {
                    this.mComplete.await();
                    break;
                } catch (InterruptedException unused) {
                    z4 = true;
                    pendingIntent = pendingIntent;
                    intent = intent;
                    i4 = i4;
                    str = str;
                    bundle = bundle;
                } catch (Throwable th) {
                    Throwable th2 = th;
                    if (z4) {
                        Thread.currentThread().interrupt();
                    }
                    throw th2;
                }
            }
            if (z4) {
                Thread.currentThread().interrupt();
            }
            PendingIntent.OnFinished onFinished = this.mCallback;
            if (onFinished != null) {
                onFinished.onSendFinished(pendingIntent, intent, i4, str, bundle);
                this.mCallback = null;
            }
        }

        public void close() {
            if (!this.mSuccess) {
                this.mCallback = null;
            }
            this.mComplete.countDown();
        }

        public void complete() {
            this.mSuccess = true;
        }

        @Nullable
        public PendingIntent.OnFinished getCallback() {
            if (this.mCallback == null) {
                return null;
            }
            return new s(this);
        }
    }

    private PendingIntentCompat() {
    }

    private static int addMutabilityFlags(boolean z4, int i4) {
        int i5;
        if (z4) {
            if (Build.VERSION.SDK_INT >= 31) {
                i5 = 33554432;
            }
            return i4;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            i5 = AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
        }
        return i4;
        return i5 | i4;
    }

    @NonNull
    public static PendingIntent getActivities(@NonNull Context context, int i4, @SuppressLint({"ArrayReturn"}) @NonNull Intent[] intentArr, int i5, @Nullable Bundle bundle, boolean z4) {
        return PendingIntent.getActivities(context, i4, intentArr, addMutabilityFlags(z4, i5), bundle);
    }

    @Nullable
    public static PendingIntent getActivity(@NonNull Context context, int i4, @NonNull Intent intent, int i5, boolean z4) {
        return PendingIntent.getActivity(context, i4, intent, addMutabilityFlags(z4, i5));
    }

    @Nullable
    public static PendingIntent getBroadcast(@NonNull Context context, int i4, @NonNull Intent intent, int i5, boolean z4) {
        return PendingIntent.getBroadcast(context, i4, intent, addMutabilityFlags(z4, i5));
    }

    @RequiresApi(26)
    @NonNull
    public static PendingIntent getForegroundService(@NonNull Context context, int i4, @NonNull Intent intent, int i5, boolean z4) {
        return Api26Impl.getForegroundService(context, i4, intent, addMutabilityFlags(z4, i5));
    }

    @Nullable
    public static PendingIntent getService(@NonNull Context context, int i4, @NonNull Intent intent, int i5, boolean z4) {
        return PendingIntent.getService(context, i4, intent, addMutabilityFlags(z4, i5));
    }

    @SuppressLint({"LambdaLast"})
    public static void send(@NonNull PendingIntent pendingIntent, int i4, @Nullable PendingIntent.OnFinished onFinished, @Nullable Handler handler) throws PendingIntent.CanceledException {
        GatedCallback gatedCallback = new GatedCallback(onFinished);
        try {
            pendingIntent.send(i4, gatedCallback.getCallback(), handler);
            gatedCallback.complete();
            gatedCallback.close();
            return;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    @NonNull
    public static PendingIntent getActivities(@NonNull Context context, int i4, @SuppressLint({"ArrayReturn"}) @NonNull Intent[] intentArr, int i5, boolean z4) {
        return PendingIntent.getActivities(context, i4, intentArr, addMutabilityFlags(z4, i5));
    }

    @Nullable
    public static PendingIntent getActivity(@NonNull Context context, int i4, @NonNull Intent intent, int i5, @Nullable Bundle bundle, boolean z4) {
        return PendingIntent.getActivity(context, i4, intent, addMutabilityFlags(z4, i5), bundle);
    }

    @SuppressLint({"LambdaLast"})
    public static void send(@NonNull PendingIntent pendingIntent, @SuppressLint({"ContextFirst"}) @NonNull Context context, int i4, @NonNull Intent intent, @Nullable PendingIntent.OnFinished onFinished, @Nullable Handler handler) throws PendingIntent.CanceledException {
        send(pendingIntent, context, i4, intent, onFinished, handler, (String) null, (Bundle) null);
    }

    @SuppressLint({"LambdaLast"})
    public static void send(@NonNull PendingIntent pendingIntent, @SuppressLint({"ContextFirst"}) @NonNull Context context, int i4, @NonNull Intent intent, @Nullable PendingIntent.OnFinished onFinished, @Nullable Handler handler, @Nullable String str, @Nullable Bundle bundle) throws PendingIntent.CanceledException {
        Throwable th;
        GatedCallback gatedCallback = new GatedCallback(onFinished);
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                Api23Impl.send(pendingIntent, context, i4, intent, onFinished, handler, str, bundle);
            } else {
                pendingIntent.send(context, i4, intent, gatedCallback.getCallback(), handler, str);
            }
            gatedCallback.complete();
            gatedCallback.close();
            return;
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        throw th;
    }
}
