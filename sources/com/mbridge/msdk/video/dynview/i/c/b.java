package com.mbridge.msdk.video.dynview.i.c;

import android.os.CountDownTimer;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private long f16079a = 0;

    /* renamed from: b  reason: collision with root package name */
    private long f16080b;

    /* renamed from: c  reason: collision with root package name */
    private a f16081c;

    /* renamed from: d  reason: collision with root package name */
    private a f16082d;

    private static class a extends CountDownTimer {

        /* renamed from: a  reason: collision with root package name */
        private a f16083a;

        public a(long j4, long j5) {
            super(j4, j5);
        }

        /* access modifiers changed from: package-private */
        public final void a(a aVar) {
            this.f16083a = aVar;
        }

        public final void onFinish() {
            a aVar = this.f16083a;
            if (aVar != null) {
                aVar.a();
            }
        }

        public final void onTick(long j4) {
            a aVar = this.f16083a;
            if (aVar != null) {
                aVar.a(j4);
            }
        }
    }

    private void c() {
        a aVar = this.f16082d;
        if (aVar != null) {
            aVar.cancel();
            this.f16082d = null;
        }
        if (this.f16080b <= 0) {
            this.f16080b = this.f16079a + 1000;
        }
        a aVar2 = new a(this.f16079a, this.f16080b);
        this.f16082d = aVar2;
        aVar2.a(this.f16081c);
    }

    public final b a(long j4) {
        if (j4 < 0) {
            j4 = 1000;
        }
        this.f16080b = j4;
        return this;
    }

    public final b b(long j4) {
        this.f16079a = j4;
        return this;
    }

    public final b a(a aVar) {
        this.f16081c = aVar;
        return this;
    }

    public final void b() {
        a aVar = this.f16082d;
        if (aVar != null) {
            aVar.cancel();
            this.f16082d = null;
        }
    }

    public final void a() {
        if (this.f16082d == null) {
            c();
        }
        this.f16082d.start();
    }

    public final void a(long j4, a aVar) {
        this.f16079a = j4;
        this.f16081c = aVar;
        c();
        a aVar2 = this.f16082d;
        if (aVar2 != null) {
            aVar2.start();
        }
    }
}
