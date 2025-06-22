package com.google.android.gms.measurement.internal;

import M.C0335p;
import java.lang.Thread;

final class R2 implements Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    private final String f2700a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ P2 f2701b;

    public R2(P2 p22, String str) {
        this.f2701b = p22;
        C0335p.l(str);
        this.f2700a = str;
    }

    public final synchronized void uncaughtException(Thread thread, Throwable th) {
        this.f2701b.a().G().b(this.f2700a, th);
    }
}
