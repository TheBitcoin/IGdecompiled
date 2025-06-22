package com.squareup.picasso;

import H1.d;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

class z {

    /* renamed from: a  reason: collision with root package name */
    final HandlerThread f17405a;

    /* renamed from: b  reason: collision with root package name */
    final H1.a f17406b;

    /* renamed from: c  reason: collision with root package name */
    final Handler f17407c;

    /* renamed from: d  reason: collision with root package name */
    long f17408d;

    /* renamed from: e  reason: collision with root package name */
    long f17409e;

    /* renamed from: f  reason: collision with root package name */
    long f17410f;

    /* renamed from: g  reason: collision with root package name */
    long f17411g;

    /* renamed from: h  reason: collision with root package name */
    long f17412h;

    /* renamed from: i  reason: collision with root package name */
    long f17413i;

    /* renamed from: j  reason: collision with root package name */
    long f17414j;

    /* renamed from: k  reason: collision with root package name */
    long f17415k;

    /* renamed from: l  reason: collision with root package name */
    int f17416l;

    /* renamed from: m  reason: collision with root package name */
    int f17417m;

    /* renamed from: n  reason: collision with root package name */
    int f17418n;

    private static class a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private final z f17419a;

        /* renamed from: com.squareup.picasso.z$a$a  reason: collision with other inner class name */
        class C0212a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Message f17420a;

            C0212a(Message message) {
                this.f17420a = message;
            }

            public void run() {
                throw new AssertionError("Unhandled stats message." + this.f17420a.what);
            }
        }

        a(Looper looper, z zVar) {
            super(looper);
            this.f17419a = zVar;
        }

        public void handleMessage(Message message) {
            int i4 = message.what;
            if (i4 == 0) {
                this.f17419a.j();
            } else if (i4 == 1) {
                this.f17419a.k();
            } else if (i4 == 2) {
                this.f17419a.h((long) message.arg1);
            } else if (i4 == 3) {
                this.f17419a.i((long) message.arg1);
            } else if (i4 != 4) {
                s.f17301o.post(new C0212a(message));
            } else {
                this.f17419a.l((Long) message.obj);
            }
        }
    }

    z(H1.a aVar) {
        this.f17406b = aVar;
        HandlerThread handlerThread = new HandlerThread("Picasso-Stats", 10);
        this.f17405a = handlerThread;
        handlerThread.start();
        C.i(handlerThread.getLooper());
        this.f17407c = new a(handlerThread.getLooper(), this);
    }

    private static long g(int i4, long j4) {
        return j4 / ((long) i4);
    }

    private void m(Bitmap bitmap, int i4) {
        int j4 = C.j(bitmap);
        Handler handler = this.f17407c;
        handler.sendMessage(handler.obtainMessage(i4, j4, 0));
    }

    /* access modifiers changed from: package-private */
    public d a() {
        int a5 = this.f17406b.a();
        int size = this.f17406b.size();
        long j4 = this.f17408d;
        long j5 = this.f17409e;
        long j6 = this.f17410f;
        long j7 = this.f17411g;
        long j8 = this.f17412h;
        long j9 = this.f17413i;
        int i4 = a5;
        long j10 = this.f17414j;
        long j11 = this.f17415k;
        int i5 = this.f17416l;
        int i6 = this.f17417m;
        int i7 = i5;
        int i8 = i7;
        int i9 = i6;
        return new d(i4, size, j4, j5, j6, j7, j8, j9, j10, j11, i8, i9, this.f17418n, System.currentTimeMillis());
    }

    /* access modifiers changed from: package-private */
    public void b(Bitmap bitmap) {
        m(bitmap, 2);
    }

    /* access modifiers changed from: package-private */
    public void c(Bitmap bitmap) {
        m(bitmap, 3);
    }

    /* access modifiers changed from: package-private */
    public void d() {
        this.f17407c.sendEmptyMessage(0);
    }

    /* access modifiers changed from: package-private */
    public void e() {
        this.f17407c.sendEmptyMessage(1);
    }

    /* access modifiers changed from: package-private */
    public void f(long j4) {
        Handler handler = this.f17407c;
        handler.sendMessage(handler.obtainMessage(4, Long.valueOf(j4)));
    }

    /* access modifiers changed from: package-private */
    public void h(long j4) {
        int i4 = this.f17417m + 1;
        this.f17417m = i4;
        long j5 = this.f17411g + j4;
        this.f17411g = j5;
        this.f17414j = g(i4, j5);
    }

    /* access modifiers changed from: package-private */
    public void i(long j4) {
        this.f17418n++;
        long j5 = this.f17412h + j4;
        this.f17412h = j5;
        this.f17415k = g(this.f17417m, j5);
    }

    /* access modifiers changed from: package-private */
    public void j() {
        this.f17408d++;
    }

    /* access modifiers changed from: package-private */
    public void k() {
        this.f17409e++;
    }

    /* access modifiers changed from: package-private */
    public void l(Long l4) {
        this.f17416l++;
        long longValue = this.f17410f + l4.longValue();
        this.f17410f = longValue;
        this.f17413i = g(this.f17416l, longValue);
    }
}
