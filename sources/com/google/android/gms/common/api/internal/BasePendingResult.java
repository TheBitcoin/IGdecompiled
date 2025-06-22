package com.google.android.gms.common.api.internal;

import K.f;
import K.g;
import K.j;
import M.C0335p;
import Z.i;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.Status;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

@KeepName
public abstract class BasePendingResult<R extends j> extends g {

    /* renamed from: m  reason: collision with root package name */
    static final ThreadLocal f1264m = new D();

    /* renamed from: a  reason: collision with root package name */
    private final Object f1265a = new Object();

    /* renamed from: b  reason: collision with root package name */
    protected final a f1266b;

    /* renamed from: c  reason: collision with root package name */
    protected final WeakReference f1267c;

    /* renamed from: d  reason: collision with root package name */
    private final CountDownLatch f1268d = new CountDownLatch(1);

    /* renamed from: e  reason: collision with root package name */
    private final ArrayList f1269e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    private final AtomicReference f1270f = new AtomicReference();

    /* renamed from: g  reason: collision with root package name */
    private j f1271g;

    /* renamed from: h  reason: collision with root package name */
    private Status f1272h;

    /* renamed from: i  reason: collision with root package name */
    private volatile boolean f1273i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f1274j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f1275k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f1276l = false;

    public static class a extends i {
        public a(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            int i4 = message.what;
            if (i4 == 1) {
                Pair pair = (Pair) message.obj;
                android.support.v4.media.a.a(pair.first);
                j jVar = (j) pair.second;
                try {
                    throw null;
                } catch (RuntimeException e5) {
                    BasePendingResult.j(jVar);
                    throw e5;
                }
            } else if (i4 != 2) {
                Log.wtf("BasePendingResult", "Don't know how to handle message: " + i4, new Exception());
            } else {
                ((BasePendingResult) message.obj).d(Status.f1252i);
            }
        }
    }

    protected BasePendingResult(f fVar) {
        Looper looper;
        if (fVar != null) {
            looper = fVar.c();
        } else {
            looper = Looper.getMainLooper();
        }
        this.f1266b = new a(looper);
        this.f1267c = new WeakReference(fVar);
    }

    private final j g() {
        j jVar;
        synchronized (this.f1265a) {
            C0335p.p(!this.f1273i, "Result has already been consumed.");
            C0335p.p(e(), "Result is not ready.");
            jVar = this.f1271g;
            this.f1271g = null;
            this.f1273i = true;
        }
        android.support.v4.media.a.a(this.f1270f.getAndSet((Object) null));
        return (j) C0335p.l(jVar);
    }

    private final void h(j jVar) {
        this.f1271g = jVar;
        this.f1272h = jVar.getStatus();
        this.f1268d.countDown();
        ArrayList arrayList = this.f1269e;
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            ((g.a) arrayList.get(i4)).a(this.f1272h);
        }
        this.f1269e.clear();
    }

    public final void a(g.a aVar) {
        boolean z4;
        if (aVar != null) {
            z4 = true;
        } else {
            z4 = false;
        }
        C0335p.b(z4, "Callback cannot be null.");
        synchronized (this.f1265a) {
            try {
                if (e()) {
                    aVar.a(this.f1272h);
                } else {
                    this.f1269e.add(aVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final j b(long j4, TimeUnit timeUnit) {
        if (j4 > 0) {
            C0335p.k("await must not be called on the UI thread when time is greater than zero.");
        }
        C0335p.p(!this.f1273i, "Result has already been consumed.");
        C0335p.p(true, "Cannot await if then() has been called.");
        try {
            if (!this.f1268d.await(j4, timeUnit)) {
                d(Status.f1252i);
            }
        } catch (InterruptedException unused) {
            d(Status.f1250g);
        }
        C0335p.p(e(), "Result is not ready.");
        return g();
    }

    /* access modifiers changed from: protected */
    public abstract j c(Status status);

    public final void d(Status status) {
        synchronized (this.f1265a) {
            try {
                if (!e()) {
                    f(c(status));
                    this.f1275k = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean e() {
        if (this.f1268d.getCount() == 0) {
            return true;
        }
        return false;
    }

    public final void f(j jVar) {
        synchronized (this.f1265a) {
            try {
                if (this.f1275k || this.f1274j) {
                    j(jVar);
                    return;
                }
                e();
                C0335p.p(!e(), "Results have already been set");
                C0335p.p(!this.f1273i, "Result has already been consumed");
                h(jVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void i() {
        boolean z4 = true;
        if (!this.f1276l && !((Boolean) f1264m.get()).booleanValue()) {
            z4 = false;
        }
        this.f1276l = z4;
    }

    public static void j(j jVar) {
    }
}
