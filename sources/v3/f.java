package v3;

import V2.g;
import o3.C0982i0;

public abstract class f extends C0982i0 {

    /* renamed from: b  reason: collision with root package name */
    private final int f4564b;

    /* renamed from: c  reason: collision with root package name */
    private final int f4565c;

    /* renamed from: d  reason: collision with root package name */
    private final long f4566d;

    /* renamed from: e  reason: collision with root package name */
    private final String f4567e;

    /* renamed from: f  reason: collision with root package name */
    private a f4568f = D();

    public f(int i4, int i5, long j4, String str) {
        this.f4564b = i4;
        this.f4565c = i5;
        this.f4566d = j4;
        this.f4567e = str;
    }

    private final a D() {
        return new a(this.f4564b, this.f4565c, this.f4566d, this.f4567e);
    }

    public final void F(Runnable runnable, i iVar, boolean z4) {
        this.f4568f.l(runnable, iVar, z4);
    }

    public void dispatch(g gVar, Runnable runnable) {
        a.n(this.f4568f, runnable, (i) null, false, 6, (Object) null);
    }

    public void dispatchYield(g gVar, Runnable runnable) {
        a.n(this.f4568f, runnable, (i) null, true, 2, (Object) null);
    }
}
