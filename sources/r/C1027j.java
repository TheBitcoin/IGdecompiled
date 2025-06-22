package r;

import O2.a;
import android.content.Context;
import s.C1045b;

/* renamed from: r.j  reason: case insensitive filesystem */
public final class C1027j implements C1045b {

    /* renamed from: a  reason: collision with root package name */
    private final a f4128a;

    /* renamed from: b  reason: collision with root package name */
    private final a f4129b;

    /* renamed from: c  reason: collision with root package name */
    private final a f4130c;

    public C1027j(a aVar, a aVar2, a aVar3) {
        this.f4128a = aVar;
        this.f4129b = aVar2;
        this.f4130c = aVar3;
    }

    public static C1027j a(a aVar, a aVar2, a aVar3) {
        return new C1027j(aVar, aVar2, aVar3);
    }

    public static C1026i c(Context context, A.a aVar, A.a aVar2) {
        return new C1026i(context, aVar, aVar2);
    }

    /* renamed from: b */
    public C1026i get() {
        return c((Context) this.f4128a.get(), (A.a) this.f4129b.get(), (A.a) this.f4130c.get());
    }
}
