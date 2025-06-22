package com.google.firebase.analytics;

import M.C0335p;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Keep;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;
import androidx.annotation.Size;
import androidx.work.WorkRequest;
import com.google.android.gms.internal.measurement.C0544e1;
import com.google.firebase.installations.c;
import f0.z;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import k0.C0940o;

public final class FirebaseAnalytics {

    /* renamed from: b  reason: collision with root package name */
    private static volatile FirebaseAnalytics f11102b;

    /* renamed from: a  reason: collision with root package name */
    private final C0544e1 f11103a;

    private FirebaseAnalytics(C0544e1 e1Var) {
        C0335p.l(e1Var);
        this.f11103a = e1Var;
    }

    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", "android.permission.WAKE_LOCK"})
    @NonNull
    @Keep
    public static FirebaseAnalytics getInstance(@NonNull Context context) {
        if (f11102b == null) {
            synchronized (FirebaseAnalytics.class) {
                try {
                    if (f11102b == null) {
                        f11102b = new FirebaseAnalytics(C0544e1.e(context));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f11102b;
    }

    @Keep
    @Nullable
    public static z getScionFrontendApiImplementation(Context context, @Nullable Bundle bundle) {
        C0544e1 f4 = C0544e1.f(context, (String) null, (String) null, (String) null, bundle);
        if (f4 == null) {
            return null;
        }
        return new a(f4);
    }

    public final void a(String str, Bundle bundle) {
        this.f11103a.s(str, bundle);
    }

    public final void b(boolean z4) {
        this.f11103a.q(Boolean.valueOf(z4));
    }

    @NonNull
    @Keep
    public final String getFirebaseInstanceId() {
        try {
            return (String) C0940o.b(c.p().getId(), WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS, TimeUnit.MILLISECONDS);
        } catch (ExecutionException e5) {
            throw new IllegalStateException(e5.getCause());
        } catch (TimeoutException unused) {
            throw new IllegalThreadStateException("Firebase Installations getId Task has timed out.");
        } catch (InterruptedException e6) {
            throw new IllegalStateException(e6);
        }
    }

    @MainThread
    @Deprecated
    @Keep
    public final void setCurrentScreen(@NonNull Activity activity, @Size(max = 36, min = 1) @Nullable String str, @Size(max = 36, min = 1) @Nullable String str2) {
        this.f11103a.j(activity, str, str2);
    }
}
