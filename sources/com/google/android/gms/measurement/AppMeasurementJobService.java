package com.google.android.gms.measurement;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import com.google.android.gms.measurement.internal.C0810l5;
import f0.B;

@TargetApi(24)
public final class AppMeasurementJobService extends JobService implements B {

    /* renamed from: a  reason: collision with root package name */
    private C0810l5 f2277a;

    private final C0810l5 d() {
        if (this.f2277a == null) {
            this.f2277a = new C0810l5(this);
        }
        return this.f2277a;
    }

    public final boolean a(int i4) {
        throw new UnsupportedOperationException();
    }

    public final void b(Intent intent) {
    }

    public final void c(JobParameters jobParameters, boolean z4) {
        jobFinished(jobParameters, false);
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

    public final boolean onStartJob(JobParameters jobParameters) {
        return d().g(jobParameters);
    }

    public final boolean onStopJob(JobParameters jobParameters) {
        return false;
    }

    public final boolean onUnbind(Intent intent) {
        return d().k(intent);
    }
}
