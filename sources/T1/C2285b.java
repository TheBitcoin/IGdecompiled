package t1;

import android.view.View;
import q1.n;

/* renamed from: t1.b  reason: case insensitive filesystem */
public class C2285b extends C2287d {

    /* renamed from: d  reason: collision with root package name */
    private static C2285b f21789d = new C2285b();

    private C2285b() {
    }

    public static C2285b k() {
        return f21789d;
    }

    public void f(boolean z4) {
        for (n t4 : C2286c.e().c()) {
            t4.t().n(z4);
        }
    }

    public boolean h() {
        for (n n4 : C2286c.e().a()) {
            View n5 = n4.n();
            if (n5 != null && n5.hasWindowFocus()) {
                return true;
            }
        }
        return false;
    }
}
