package r;

import O2.a;
import android.content.Context;
import s.C1045b;

/* renamed from: r.l  reason: case insensitive filesystem */
public final class C1029l implements C1045b {

    /* renamed from: a  reason: collision with root package name */
    private final a f4136a;

    /* renamed from: b  reason: collision with root package name */
    private final a f4137b;

    public C1029l(a aVar, a aVar2) {
        this.f4136a = aVar;
        this.f4137b = aVar2;
    }

    public static C1029l a(a aVar, a aVar2) {
        return new C1029l(aVar, aVar2);
    }

    public static C1028k c(Context context, Object obj) {
        return new C1028k(context, (C1026i) obj);
    }

    /* renamed from: b */
    public C1028k get() {
        return c((Context) this.f4136a.get(), this.f4137b.get());
    }
}
