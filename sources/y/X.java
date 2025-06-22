package y;

import O2.a;
import android.content.Context;
import s.C1045b;

public final class X implements C1045b {

    /* renamed from: a  reason: collision with root package name */
    private final a f4751a;

    /* renamed from: b  reason: collision with root package name */
    private final a f4752b;

    /* renamed from: c  reason: collision with root package name */
    private final a f4753c;

    public X(a aVar, a aVar2, a aVar3) {
        this.f4751a = aVar;
        this.f4752b = aVar2;
        this.f4753c = aVar3;
    }

    public static X a(a aVar, a aVar2, a aVar3) {
        return new X(aVar, aVar2, aVar3);
    }

    public static W c(Context context, String str, int i4) {
        return new W(context, str, i4);
    }

    /* renamed from: b */
    public W get() {
        return c((Context) this.f4751a.get(), (String) this.f4752b.get(), ((Integer) this.f4753c.get()).intValue());
    }
}
