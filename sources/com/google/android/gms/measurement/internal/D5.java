package com.google.android.gms.measurement.internal;

import R.d;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.PersistableBundle;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.internal.measurement.A0;
import com.google.android.gms.internal.measurement.B0;

public final class D5 extends E5 {

    /* renamed from: d  reason: collision with root package name */
    private final AlarmManager f2363d = ((AlarmManager) A().getSystemService(NotificationCompat.CATEGORY_ALARM));

    /* renamed from: e  reason: collision with root package name */
    private C0859t f2364e;

    /* renamed from: f  reason: collision with root package name */
    private Integer f2365f;

    protected D5(H5 h5) {
        super(h5);
    }

    private final void D() {
        JobScheduler jobScheduler = (JobScheduler) A().getSystemService("jobscheduler");
        if (jobScheduler != null) {
            jobScheduler.cancel(x());
        }
    }

    private final int x() {
        if (this.f2365f == null) {
            String packageName = A().getPackageName();
            this.f2365f = Integer.valueOf(("measurement" + packageName).hashCode());
        }
        return this.f2365f.intValue();
    }

    private final PendingIntent y() {
        Context A4 = A();
        return B0.a(A4, 0, new Intent().setClassName(A4, "com.google.android.gms.measurement.AppMeasurementReceiver").setAction("com.google.android.gms.measurement.UPLOAD"), B0.f1405a);
    }

    private final C0859t z() {
        if (this.f2364e == null) {
            this.f2364e = new C5(this, this.f2403b.t0());
        }
        return this.f2364e;
    }

    public final /* bridge */ /* synthetic */ Context A() {
        return super.A();
    }

    public final /* bridge */ /* synthetic */ d B() {
        return super.B();
    }

    public final /* bridge */ /* synthetic */ C0741c C() {
        return super.C();
    }

    public final /* bridge */ /* synthetic */ C0821n2 a() {
        return super.a();
    }

    public final /* bridge */ /* synthetic */ C0769g b() {
        return super.b();
    }

    public final /* bridge */ /* synthetic */ C0887x c() {
        return super.c();
    }

    public final /* bridge */ /* synthetic */ C0779h2 d() {
        return super.d();
    }

    public final /* bridge */ /* synthetic */ C0904z2 e() {
        return super.e();
    }

    public final /* bridge */ /* synthetic */ P2 f() {
        return super.f();
    }

    public final /* bridge */ /* synthetic */ d6 g() {
        return super.g();
    }

    public final /* bridge */ /* synthetic */ void i() {
        super.i();
    }

    public final /* bridge */ /* synthetic */ void j() {
        super.j();
    }

    public final /* bridge */ /* synthetic */ void k() {
        super.k();
    }

    public final /* bridge */ /* synthetic */ Z5 l() {
        return super.l();
    }

    public final /* bridge */ /* synthetic */ h6 m() {
        return super.m();
    }

    public final /* bridge */ /* synthetic */ C0797k n() {
        return super.n();
    }

    public final /* bridge */ /* synthetic */ I2 o() {
        return super.o();
    }

    public final /* bridge */ /* synthetic */ C0796j5 p() {
        return super.p();
    }

    public final /* bridge */ /* synthetic */ G5 q() {
        return super.q();
    }

    /* access modifiers changed from: protected */
    public final boolean u() {
        AlarmManager alarmManager = this.f2363d;
        if (alarmManager != null) {
            alarmManager.cancel(y());
        }
        if (Build.VERSION.SDK_INT < 24) {
            return false;
        }
        D();
        return false;
    }

    public final void v(long j4) {
        r();
        Context A4 = A();
        if (!d6.d0(A4)) {
            a().F().a("Receiver not registered/enabled");
        }
        if (!d6.e0(A4, false)) {
            a().F().a("Service not registered/enabled");
        }
        w();
        a().K().b("Scheduling upload, millis", Long.valueOf(j4));
        long elapsedRealtime = B().elapsedRealtime() + j4;
        if (j4 < Math.max(0, ((Long) G.f2519z.a((Object) null)).longValue()) && !z().e()) {
            z().b(j4);
        }
        if (Build.VERSION.SDK_INT >= 24) {
            Context A5 = A();
            ComponentName componentName = new ComponentName(A5, "com.google.android.gms.measurement.AppMeasurementJobService");
            int x4 = x();
            PersistableBundle persistableBundle = new PersistableBundle();
            persistableBundle.putString("action", "com.google.android.gms.measurement.UPLOAD");
            A0.c(A5, new JobInfo.Builder(x4, componentName).setMinimumLatency(j4).setOverrideDeadline(j4 << 1).setExtras(persistableBundle).build(), "com.google.android.gms", "UploadAlarm");
            return;
        }
        AlarmManager alarmManager = this.f2363d;
        if (alarmManager != null) {
            alarmManager.setInexactRepeating(2, elapsedRealtime, Math.max(((Long) G.f2509u.a((Object) null)).longValue(), j4), y());
        }
    }

    public final void w() {
        r();
        a().K().a("Unscheduling upload");
        AlarmManager alarmManager = this.f2363d;
        if (alarmManager != null) {
            alarmManager.cancel(y());
        }
        z().a();
        if (Build.VERSION.SDK_INT >= 24) {
            D();
        }
    }
}
