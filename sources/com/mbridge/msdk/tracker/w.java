package com.mbridge.msdk.tracker;

import android.util.Log;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;

public final class w {

    /* renamed from: a  reason: collision with root package name */
    public final int f15703a;

    /* renamed from: b  reason: collision with root package name */
    public final int f15704b;

    /* renamed from: c  reason: collision with root package name */
    public final int f15705c;

    /* renamed from: d  reason: collision with root package name */
    public final int f15706d;

    /* renamed from: e  reason: collision with root package name */
    public final int f15707e;

    /* renamed from: f  reason: collision with root package name */
    public final int f15708f;

    /* renamed from: g  reason: collision with root package name */
    public final o f15709g;

    /* renamed from: h  reason: collision with root package name */
    public final d f15710h;

    /* renamed from: i  reason: collision with root package name */
    public final v f15711i;

    /* renamed from: j  reason: collision with root package name */
    public final f f15712j;

    public static final class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public int f15713a = 50;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public int f15714b = DefaultLoadControl.DEFAULT_MIN_BUFFER_MS;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public int f15715c = 1;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public o f15716d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public int f15717e = 2;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public int f15718f = 50;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public int f15719g = 604800000;
        /* access modifiers changed from: private */

        /* renamed from: h  reason: collision with root package name */
        public d f15720h;
        /* access modifiers changed from: private */

        /* renamed from: i  reason: collision with root package name */
        public v f15721i;
        /* access modifiers changed from: private */

        /* renamed from: j  reason: collision with root package name */
        public f f15722j;

        public final a a(int i4) {
            if (i4 <= 0) {
                this.f15713a = 50;
                return this;
            }
            this.f15713a = i4;
            return this;
        }

        public final a b(int i4) {
            if (i4 < 0) {
                this.f15714b = DefaultLoadControl.DEFAULT_MIN_BUFFER_MS;
                return this;
            }
            this.f15714b = i4;
            return this;
        }

        public final a c(int i4) {
            if (i4 <= 0) {
                this.f15717e = 2;
                return this;
            }
            this.f15717e = i4;
            return this;
        }

        public final a d(int i4) {
            if (i4 < 0) {
                this.f15718f = 50;
                return this;
            }
            this.f15718f = i4;
            return this;
        }

        public final a e(int i4) {
            if (i4 < 0) {
                this.f15719g = 604800000;
                return this;
            }
            this.f15719g = i4;
            return this;
        }

        public final a a(int i4, o oVar) {
            this.f15715c = i4;
            this.f15716d = oVar;
            return this;
        }

        public final a a(d dVar) {
            this.f15720h = dVar;
            return this;
        }

        public final a a(v vVar) {
            this.f15721i = vVar;
            return this;
        }

        public final a a(f fVar) {
            this.f15722j = fVar;
            return this;
        }

        public final w a() {
            if (y.a((Object) this.f15720h) && a.f15435a) {
                Log.e("TrackManager", "decorate can not be null");
            }
            if (y.a((Object) this.f15721i) && a.f15435a) {
                Log.e("TrackManager", "responseHandler can not be null");
            }
            if ((y.a((Object) this.f15716d) || y.a((Object) this.f15716d.c())) && a.f15435a) {
                Log.e("TrackManager", "networkStackConfig or stack can not be null");
            }
            return new w(this);
        }
    }

    private w(a aVar) {
        this.f15703a = aVar.f15713a;
        this.f15704b = aVar.f15714b;
        this.f15705c = aVar.f15715c;
        this.f15706d = aVar.f15717e;
        this.f15707e = aVar.f15718f;
        this.f15708f = aVar.f15719g;
        this.f15709g = aVar.f15716d;
        this.f15710h = aVar.f15720h;
        this.f15711i = aVar.f15721i;
        this.f15712j = aVar.f15722j;
    }
}
