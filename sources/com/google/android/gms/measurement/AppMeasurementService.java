package com.google.android.gms.measurement;

import android.app.Service;
import android.app.job.JobParameters;
import android.content.Intent;
import android.os.IBinder;
import androidx.legacy.content.WakefulBroadcastReceiver;
import com.google.android.gms.measurement.internal.C0810l5;
import f0.B;

public final class AppMeasurementService extends Service implements B {

    /* renamed from: a  reason: collision with root package name */
    private C0810l5 f2279a;

    private final C0810l5 d() {
        if (this.f2279a == null) {
            this.f2279a = new C0810l5(this);
        }
        return this.f2279a;
    }

    public final boolean a(int i4) {
        return stopSelfResult(i4);
    }

    public final void b(Intent intent) {
        WakefulBroadcastReceiver.completeWakefulIntent(intent);
    }

    public final void c(JobParameters jobParameters, boolean z4) {
        throw new UnsupportedOperationException();
    }

    public final IBinder onBind(Intent intent) {
        return d().b(intent);
    }

    public final void onCreate() {
        super.onCreate();
        d().c();
    }

    public final void onDestroy() {
        d().h();
        super.onDestroy();
    }

    public final void onRebind(Intent intent) {
        d().i(intent);
    }

    public final int onStartCommand(Intent intent, int i4, int i5) {
        return d().a(intent, i4, i5);
    }

    public final boolean onUnbind(Intent intent) {
        return d().k(intent);
    }
}
