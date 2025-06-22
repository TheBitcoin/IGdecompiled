package com.google.android.gms.internal.measurement;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* renamed from: com.google.android.gms.internal.measurement.m1  reason: case insensitive filesystem */
final class C0616m1 implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    private ThreadFactory f1993a = Executors.defaultThreadFactory();

    C0616m1(C0544e1 e1Var) {
    }

    public final Thread newThread(Runnable runnable) {
        Thread newThread = this.f1993a.newThread(runnable);
        newThread.setName("ScionFrontendApi");
        return newThread;
    }
}
