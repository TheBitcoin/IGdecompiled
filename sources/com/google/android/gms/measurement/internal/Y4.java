package com.google.android.gms.measurement.internal;

import M.C0335p;
import android.os.RemoteException;
import android.text.TextUtils;
import f0.C0917f;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

final class Y4 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ AtomicReference f2817a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f2818b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ String f2819c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ String f2820d;

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ M5 f2821e;

    /* renamed from: f  reason: collision with root package name */
    private final /* synthetic */ F4 f2822f;

    Y4(F4 f4, AtomicReference atomicReference, String str, String str2, String str3, M5 m5) {
        this.f2817a = atomicReference;
        this.f2818b = str;
        this.f2819c = str2;
        this.f2820d = str3;
        this.f2821e = m5;
        this.f2822f = f4;
    }

    public final void run() {
        synchronized (this.f2817a) {
            try {
                C0917f y4 = this.f2822f.f2397d;
                if (y4 == null) {
                    this.f2822f.a().G().d("(legacy) Failed to get conditional properties; not connected to service", C0821n2.s(this.f2818b), this.f2819c, this.f2820d);
                    this.f2817a.set(Collections.EMPTY_LIST);
                    this.f2817a.notify();
                    return;
                }
                if (TextUtils.isEmpty(this.f2818b)) {
                    C0335p.l(this.f2821e);
                    this.f2817a.set(y4.l(this.f2819c, this.f2820d, this.f2821e));
                } else {
                    this.f2817a.set(y4.K(this.f2818b, this.f2819c, this.f2820d));
                }
                this.f2822f.m0();
                this.f2817a.notify();
            } catch (RemoteException e5) {
                try {
                    this.f2822f.a().G().d("(legacy) Failed to get conditional properties; remote exception", C0821n2.s(this.f2818b), this.f2819c, e5);
                    this.f2817a.set(Collections.EMPTY_LIST);
                    this.f2817a.notify();
                } catch (Throwable th) {
                    this.f2817a.notify();
                    throw th;
                }
            }
        }
    }
}
