package y0;

import E0.g;
import java.io.File;
import java.io.IOException;

/* renamed from: y0.y  reason: case insensitive filesystem */
class C2434y {

    /* renamed from: a  reason: collision with root package name */
    private final String f22731a;

    /* renamed from: b  reason: collision with root package name */
    private final g f22732b;

    public C2434y(String str, g gVar) {
        this.f22731a = str;
        this.f22732b = gVar;
    }

    private File b() {
        return this.f22732b.g(this.f22731a);
    }

    public boolean a() {
        try {
            return b().createNewFile();
        } catch (IOException e5) {
            v0.g f4 = v0.g.f();
            f4.e("Error creating marker: " + this.f22731a, e5);
            return false;
        }
    }

    public boolean c() {
        return b().exists();
    }

    public boolean d() {
        return b().delete();
    }
}
