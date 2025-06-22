package com.google.android.gms.measurement.internal;

import M.C0335p;
import android.app.job.JobParameters;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.google.android.gms.internal.measurement.C0526c1;
import f0.B;

/* renamed from: com.google.android.gms.measurement.internal.l5  reason: case insensitive filesystem */
public final class C0810l5 {

    /* renamed from: a  reason: collision with root package name */
    private final Context f3109a;

    public C0810l5(Context context) {
        C0335p.l(context);
        this.f3109a = context;
    }

    private final void f(Runnable runnable) {
        H5 j4 = H5.j(this.f3109a);
        j4.f().D(new C0817m5(this, j4, runnable));
    }

    private final C0821n2 j() {
        return S2.b(this.f3109a, (C0526c1) null, (Long) null).a();
    }

    public final int a(Intent intent, int i4, int i5) {
        C0821n2 a5 = S2.b(this.f3109a, (C0526c1) null, (Long) null).a();
        if (intent == null) {
            a5.L().a("AppMeasurementService started with null intent");
            return 2;
        }
        String action = intent.getAction();
        a5.K().c("Local AppMeasurementService called. startId, action", Integer.valueOf(i5), action);
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            f(new C0831o5(this, i5, a5, intent));
        }
        return 2;
    }

    public final IBinder b(Intent intent) {
        if (intent == null) {
            j().G().a("onBind called with null intent");
            return null;
        }
        String action = intent.getAction();
        if ("com.google.android.gms.measurement.START".equals(action)) {
            return new X2(H5.j(this.f3109a));
        }
        j().L().b("onBind received unknown action", action);
        return null;
    }

    public final void c() {
        S2.b(this.f3109a, (C0526c1) null, (Long) null).a().K().a("Local AppMeasurementService is starting up");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void d(int i4, C0821n2 n2Var, Intent intent) {
        if (((B) this.f3109a).a(i4)) {
            n2Var.K().b("Local AppMeasurementService processed last upload request. StartId", Integer.valueOf(i4));
            j().K().a("Completed wakeful intent.");
            ((B) this.f3109a).b(intent);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void e(C0821n2 n2Var, JobParameters jobParameters) {
        n2Var.K().a("AppMeasurementJobService processed last upload request.");
        ((B) this.f3109a).c(jobParameters, false);
    }

    public final boolean g(JobParameters jobParameters) {
        C0821n2 a5 = S2.b(this.f3109a, (C0526c1) null, (Long) null).a();
        String string = jobParameters.getExtras().getString("action");
        a5.K().b("Local AppMeasurementJobService called. action", string);
        if (!"com.google.android.gms.measurement.UPLOAD".equals(string)) {
            return true;
        }
        f(new C0803k5(this, a5, jobParameters));
        return true;
    }

    public final void h() {
        S2.b(this.f3109a, (C0526c1) null, (Long) null).a().K().a("Local AppMeasurementService is shutting down");
    }

    public final void i(Intent intent) {
        if (intent == null) {
            j().G().a("onRebind called with null intent");
            return;
        }
        j().K().b("onRebind called. action", intent.getAction());
    }

    public final boolean k(Intent intent) {
        if (intent == null) {
            j().G().a("onUnbind called with null intent");
            return true;
        }
        j().K().b("onUnbind called for intent. action", intent.getAction());
        return true;
    }
}
