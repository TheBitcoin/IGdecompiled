package com.google.android.gms.measurement.internal;

import android.app.job.JobParameters;

/* renamed from: com.google.android.gms.measurement.internal.k5  reason: case insensitive filesystem */
public final /* synthetic */ class C0803k5 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ C0810l5 f3086a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ C0821n2 f3087b;

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ JobParameters f3088c;

    public /* synthetic */ C0803k5(C0810l5 l5Var, C0821n2 n2Var, JobParameters jobParameters) {
        this.f3086a = l5Var;
        this.f3087b = n2Var;
        this.f3088c = jobParameters;
    }

    public final void run() {
        this.f3086a.e(this.f3087b, this.f3088c);
    }
}
