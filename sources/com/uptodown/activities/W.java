package com.uptodown.activities;

import R2.n;
import R2.s;
import V2.d;
import android.content.Context;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import d3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.m;
import o3.C1001s0;
import o3.J;
import o3.Y;
import org.json.JSONObject;
import r3.I;
import r3.K;
import r3.t;
import u2.E;
import u2.L;

public final class W extends ViewModel {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final t f18644a;

    /* renamed from: b  reason: collision with root package name */
    private final I f18645b;

    /* renamed from: c  reason: collision with root package name */
    private final t f18646c = K.a((Object) null);

    /* renamed from: d  reason: collision with root package name */
    private final t f18647d = K.a((Object) null);

    /* renamed from: e  reason: collision with root package name */
    private final t f18648e = K.a((Object) null);

    /* renamed from: f  reason: collision with root package name */
    private final t f18649f = K.a((Object) null);

    /* renamed from: g  reason: collision with root package name */
    private final t f18650g = K.a(0L);

    /* renamed from: h  reason: collision with root package name */
    private final t f18651h = K.a(Boolean.FALSE);

    /* renamed from: i  reason: collision with root package name */
    private final t f18652i = K.a(Boolean.TRUE);

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final g2.K f18653a;

        public a(g2.K k4) {
            this.f18653a = k4;
        }

        public final g2.K a() {
            return this.f18653a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && m.a(this.f18653a, ((a) obj).f18653a);
        }

        public int hashCode() {
            g2.K k4 = this.f18653a;
            if (k4 == null) {
                return 0;
            }
            return k4.hashCode();
        }

        public String toString() {
            return "VirusTotalReportData(reportVT=" + this.f18653a + ')';
        }
    }

    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f18654a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ W f18655b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f18656c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ boolean f18657d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ long f18658e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ long f18659f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(W w4, Context context, boolean z4, long j4, long j5, d dVar) {
            super(2, dVar);
            this.f18655b = w4;
            this.f18656c = context;
            this.f18657d = z4;
            this.f18658e = j4;
            this.f18659f = j5;
        }

        public final d create(Object obj, d dVar) {
            return new b(this.f18655b, this.f18656c, this.f18657d, this.f18658e, this.f18659f, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            long j4;
            g2.K k4;
            W2.b.c();
            if (this.f18654a == 0) {
                n.b(obj);
                this.f18655b.f18644a.setValue(E.a.f21883a);
                L l4 = new L(this.f18656c);
                if (!this.f18657d) {
                    j4 = this.f18658e;
                } else {
                    j4 = this.f18659f;
                }
                g2.L A02 = l4.A0(String.valueOf(j4));
                if (!A02.b() && A02.e() != null) {
                    JSONObject e5 = A02.e();
                    m.b(e5);
                    JSONObject optJSONObject = e5.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
                    if (e5.optInt("success") == 1 && optJSONObject != null) {
                        k4 = new g2.K();
                        k4.a(optJSONObject);
                        this.f18655b.f18644a.setValue(new E.c(new a(k4)));
                        return s.f8222a;
                    }
                }
                k4 = null;
                this.f18655b.f18644a.setValue(new E.c(new a(k4)));
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, d dVar) {
            return ((b) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public W() {
        t a5 = K.a(E.b.f21884a);
        this.f18644a = a5;
        this.f18645b = a5;
    }

    public final void b(Context context, long j4, long j5, boolean z4) {
        m.e(context, "context");
        boolean z5 = z4;
        C1001s0 unused = C0981i.d(ViewModelKt.getViewModelScope(this), Y.b(), (o3.L) null, new b(this, context, z5, j4, j5, (d) null), 2, (Object) null);
    }

    public final t c() {
        return this.f18646c;
    }

    public final t d() {
        return this.f18647d;
    }

    public final I e() {
        return this.f18645b;
    }

    public final t f() {
        return this.f18650g;
    }

    public final t g() {
        return this.f18649f;
    }

    public final t h() {
        return this.f18648e;
    }

    public final t i() {
        return this.f18651h;
    }

    public final t j() {
        return this.f18652i;
    }
}
