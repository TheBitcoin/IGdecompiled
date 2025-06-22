package p3;

import R2.s;
import V2.g;
import android.os.Handler;
import android.os.Looper;
import d3.l;
import j3.e;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;
import o3.C0989m;
import o3.C1009w0;
import o3.T;
import o3.Y;

public final class c extends d implements T {
    private volatile c _immediate;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Handler f3929a;

    /* renamed from: b  reason: collision with root package name */
    private final String f3930b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f3931c;

    /* renamed from: d  reason: collision with root package name */
    private final c f3932d;

    public static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C0989m f3933a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ c f3934b;

        public a(C0989m mVar, c cVar) {
            this.f3933a = mVar;
            this.f3934b = cVar;
        }

        public final void run() {
            this.f3933a.e(this.f3934b, s.f8222a);
        }
    }

    static final class b extends n implements l {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f3935a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Runnable f3936b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(c cVar, Runnable runnable) {
            super(1);
            this.f3935a = cVar;
            this.f3936b = runnable;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return s.f8222a;
        }

        public final void invoke(Throwable th) {
            this.f3935a.f3929a.removeCallbacks(this.f3936b);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private c(Handler handler, String str, boolean z4) {
        super((C2103g) null);
        c cVar = null;
        this.f3929a = handler;
        this.f3930b = str;
        this.f3931c = z4;
        this._immediate = z4 ? this : cVar;
        c cVar2 = this._immediate;
        if (cVar2 == null) {
            cVar2 = new c(handler, str, true);
            this._immediate = cVar2;
        }
        this.f3932d = cVar2;
    }

    private final void H(g gVar, Runnable runnable) {
        C1009w0.c(gVar, new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed"));
        Y.b().dispatch(gVar, runnable);
    }

    /* renamed from: I */
    public c D() {
        return this.f3932d;
    }

    public void dispatch(g gVar, Runnable runnable) {
        if (!this.f3929a.post(runnable)) {
            H(gVar, runnable);
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof c) || ((c) obj).f3929a != this.f3929a) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return System.identityHashCode(this.f3929a);
    }

    public boolean isDispatchNeeded(g gVar) {
        if (!this.f3931c || !m.a(Looper.myLooper(), this.f3929a.getLooper())) {
            return true;
        }
        return false;
    }

    public void n(long j4, C0989m mVar) {
        a aVar = new a(mVar, this);
        if (this.f3929a.postDelayed(aVar, e.d(j4, 4611686018427387903L))) {
            mVar.q(new b(this, aVar));
        } else {
            H(mVar.getContext(), aVar);
        }
    }

    public String toString() {
        String F4 = F();
        if (F4 != null) {
            return F4;
        }
        String str = this.f3930b;
        if (str == null) {
            str = this.f3929a.toString();
        }
        if (!this.f3931c) {
            return str;
        }
        return str + ".immediate";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c(Handler handler, String str, int i4, C2103g gVar) {
        this(handler, (i4 & 2) != 0 ? null : str);
    }

    public c(Handler handler, String str) {
        this(handler, str, false);
    }
}
