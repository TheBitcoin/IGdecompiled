package t1;

import android.content.Context;

/* renamed from: t1.g  reason: case insensitive filesystem */
public class C2290g {

    /* renamed from: b  reason: collision with root package name */
    private static C2290g f21802b = new C2290g();

    /* renamed from: a  reason: collision with root package name */
    private Context f21803a;

    private C2290g() {
    }

    public static C2290g c() {
        return f21802b;
    }

    public Context a() {
        return this.f21803a;
    }

    public void b(Context context) {
        Context context2;
        if (context != null) {
            context2 = context.getApplicationContext();
        } else {
            context2 = null;
        }
        this.f21803a = context2;
    }
}
