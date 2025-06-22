package com.google.android.gms.measurement.internal;

import M.C0335p;
import android.os.RemoteException;
import android.text.TextUtils;
import f0.C0917f;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.android.gms.measurement.internal.a5  reason: case insensitive filesystem */
final class C0733a5 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ AtomicReference f2847a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f2848b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ String f2849c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ String f2850d;

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ M5 f2851e;

    /* renamed from: f  reason: collision with root package name */
    private final /* synthetic */ boolean f2852f;

    /* renamed from: g  reason: collision with root package name */
    private final /* synthetic */ F4 f2853g;

    C0733a5(F4 f4, AtomicReference atomicReference, String str, String str2, String str3, M5 m5, boolean z4) {
        this.f2847a = atomicReference;
        this.f2848b = str;
        this.f2849c = str2;
        this.f2850d = str3;
        this.f2851e = m5;
        this.f2852f = z4;
        this.f2853g = f4;
    }

    public final void run() {
        synchronized (this.f2847a) {
            try {
                C0917f y4 = this.f2853g.f2397d;
                if (y4 == null) {
                    this.f2853g.a().G().d("(legacy) Failed to get user properties; not connected to service", C0821n2.s(this.f2848b), this.f2849c, this.f2850d);
                    this.f2847a.set(Collections.EMPTY_LIST);
                    this.f2847a.notify();
                    return;
                }
                if (TextUtils.isEmpty(this.f2848b)) {
                    C0335p.l(this.f2851e);
                    this.f2847a.set(y4.Z(this.f2849c, this.f2850d, this.f2852f, this.f2851e));
                } else {
                    this.f2847a.set(y4.r(this.f2848b, this.f2849c, this.f2850d, this.f2852f));
                }
                this.f2853g.m0();
                this.f2847a.notify();
            } catch (RemoteException e5) {
                try {
                    this.f2853g.a().G().d("(legacy) Failed to get user properties; remote exception", C0821n2.s(this.f2848b), this.f2849c, e5);
                    this.f2847a.set(Collections.EMPTY_LIST);
                    this.f2847a.notify();
                } catch (Throwable th) {
                    this.f2847a.notify();
                    throw th;
                }
            }
        }
    }
}
