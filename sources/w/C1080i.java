package w;

import O2.a;
import android.content.Context;
import s.C1045b;
import s.d;
import x.f;
import x.x;
import y.C1094d;

/* renamed from: w.i  reason: case insensitive filesystem */
public final class C1080i implements C1045b {

    /* renamed from: a  reason: collision with root package name */
    private final a f4606a;

    /* renamed from: b  reason: collision with root package name */
    private final a f4607b;

    /* renamed from: c  reason: collision with root package name */
    private final a f4608c;

    /* renamed from: d  reason: collision with root package name */
    private final a f4609d;

    public C1080i(a aVar, a aVar2, a aVar3, a aVar4) {
        this.f4606a = aVar;
        this.f4607b = aVar2;
        this.f4608c = aVar3;
        this.f4609d = aVar4;
    }

    public static C1080i a(a aVar, a aVar2, a aVar3, a aVar4) {
        return new C1080i(aVar, aVar2, aVar3, aVar4);
    }

    public static x c(Context context, C1094d dVar, f fVar, A.a aVar) {
        return (x) d.d(C1079h.a(context, dVar, fVar, aVar));
    }

    /* renamed from: b */
    public x get() {
        return c((Context) this.f4606a.get(), (C1094d) this.f4607b.get(), (f) this.f4608c.get(), (A.a) this.f4609d.get());
    }
}
