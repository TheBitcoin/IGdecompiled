package t1;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import q1.h;

/* renamed from: t1.f  reason: case insensitive filesystem */
public class C2289f {

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f21800b = Pattern.compile("^[a-zA-Z0-9 ]+$");

    /* renamed from: a  reason: collision with root package name */
    private final List f21801a = new ArrayList();

    private void b(View view) {
        if (view == null) {
            throw new IllegalArgumentException("FriendlyObstruction is null");
        }
    }

    private void d(String str) {
        if (str == null) {
            return;
        }
        if (str.length() > 50) {
            throw new IllegalArgumentException("FriendlyObstruction has detailed reason over 50 characters in length");
        } else if (!f21800b.matcher(str).matches()) {
            throw new IllegalArgumentException("FriendlyObstruction has detailed reason that contains characters not in [a-z][A-Z][0-9] or space");
        }
    }

    private C2288e e(View view) {
        for (C2288e eVar : this.f21801a) {
            if (eVar.c().get() == view) {
                return eVar;
            }
        }
        return null;
    }

    public List a() {
        return this.f21801a;
    }

    public void c(View view, h hVar, String str) {
        b(view);
        d(str);
        if (e(view) == null) {
            this.f21801a.add(new C2288e(view, hVar, str));
        }
    }

    public void f() {
        this.f21801a.clear();
    }

    public void g(View view) {
        b(view);
        C2288e e5 = e(view);
        if (e5 != null) {
            this.f21801a.remove(e5);
        }
    }
}
