package com.mbridge.msdk.e.a;

import android.os.CountDownTimer;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private a f12702a;

    /* renamed from: b  reason: collision with root package name */
    private long f12703b;

    /* renamed from: c  reason: collision with root package name */
    private a f12704c;

    /* renamed from: d  reason: collision with root package name */
    private long f12705d = 0;

    private static class a extends CountDownTimer {

        /* renamed from: a  reason: collision with root package name */
        private a f12706a;

        public a(long j4, long j5) {
            super(j4, j5);
        }

        /* access modifiers changed from: package-private */
        public final void a(a aVar) {
            this.f12706a = aVar;
        }

        public final void onFinish() {
            a aVar = this.f12706a;
            if (aVar != null) {
                aVar.onFinish();
            }
        }

        public final void onTick(long j4) {
            a aVar = this.f12706a;
            if (aVar != null) {
                aVar.onTick(j4);
            }
        }
    }

    public final void a() {
        a aVar = this.f12704c;
        if (aVar != null) {
            aVar.cancel();
            this.f12704c = null;
        }
    }

    public final b b(long j4) {
        this.f12705d = j4;
        return this;
    }

    public final void b() {
        a aVar = this.f12704c;
        if (aVar == null) {
            if (aVar != null) {
                aVar.cancel();
                this.f12704c = null;
            }
            if (this.f12703b <= 0) {
                this.f12703b = this.f12705d + 1000;
            }
            a aVar2 = new a(this.f12705d, this.f12703b);
            this.f12704c = aVar2;
            aVar2.a(this.f12702a);
        }
        this.f12704c.start();
    }

    public final b a(long j4) {
        if (j4 < 0) {
            j4 = 1000;
        }
        this.f12703b = j4;
        return this;
    }

    public final b a(a aVar) {
        this.f12702a = aVar;
        return this;
    }
}
