package com.google.firebase.concurrent;

import android.os.Process;
import android.os.StrictMode;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

class b implements ThreadFactory {

    /* renamed from: e  reason: collision with root package name */
    private static final ThreadFactory f11126e = Executors.defaultThreadFactory();

    /* renamed from: a  reason: collision with root package name */
    private final AtomicLong f11127a = new AtomicLong();

    /* renamed from: b  reason: collision with root package name */
    private final String f11128b;

    /* renamed from: c  reason: collision with root package name */
    private final int f11129c;

    /* renamed from: d  reason: collision with root package name */
    private final StrictMode.ThreadPolicy f11130d;

    b(String str, int i4, StrictMode.ThreadPolicy threadPolicy) {
        this.f11128b = str;
        this.f11129c = i4;
        this.f11130d = threadPolicy;
    }

    public static /* synthetic */ void a(b bVar, Runnable runnable) {
        Process.setThreadPriority(bVar.f11129c);
        StrictMode.ThreadPolicy threadPolicy = bVar.f11130d;
        if (threadPolicy != null) {
            StrictMode.setThreadPolicy(threadPolicy);
        }
        runnable.run();
    }

    public Thread newThread(Runnable runnable) {
        Thread newThread = f11126e.newThread(new a(this, runnable));
        newThread.setName(String.format(Locale.ROOT, "%s Thread #%d", new Object[]{this.f11128b, Long.valueOf(this.f11127a.getAndIncrement())}));
        return newThread;
    }
}
