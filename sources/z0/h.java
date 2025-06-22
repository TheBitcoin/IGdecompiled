package Z0;

import android.content.Context;
import s0.C2268c;
import s0.r;

public abstract class h {

    public interface a {
        String a(Object obj);
    }

    public static C2268c b(String str, String str2) {
        return C2268c.l(f.a(str, str2), f.class);
    }

    public static C2268c c(String str, a aVar) {
        return C2268c.m(f.class).b(r.k(Context.class)).f(new g(str, aVar)).d();
    }
}
