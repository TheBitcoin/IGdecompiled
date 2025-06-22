package y;

import O2.a;
import android.content.Context;
import s.C1045b;
import s.d;

/* renamed from: y.h  reason: case insensitive filesystem */
public final class C1098h implements C1045b {

    /* renamed from: a  reason: collision with root package name */
    private final a f4769a;

    public C1098h(a aVar) {
        this.f4769a = aVar;
    }

    public static C1098h a(a aVar) {
        return new C1098h(aVar);
    }

    public static String c(Context context) {
        return (String) d.d(C1096f.b(context));
    }

    /* renamed from: b */
    public String get() {
        return c((Context) this.f4769a.get());
    }
}
