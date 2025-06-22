package K;

import J.C0305d;
import K.f;
import L.C0319c;
import L.h;
import M.C0322c;
import M.C0323d;
import M.C0329j;
import M.C0335p;
import android.content.Context;
import android.os.Looper;
import java.util.Set;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final C0001a f360a;

    /* renamed from: b  reason: collision with root package name */
    private final g f361b;

    /* renamed from: c  reason: collision with root package name */
    private final String f362c;

    /* renamed from: K.a$a  reason: collision with other inner class name */
    public static abstract class C0001a extends e {
        public f a(Context context, Looper looper, C0323d dVar, Object obj, f.a aVar, f.b bVar) {
            return b(context, looper, dVar, obj, aVar, bVar);
        }

        public f b(Context context, Looper looper, C0323d dVar, Object obj, C0319c cVar, h hVar) {
            throw new UnsupportedOperationException("buildClient must be implemented");
        }
    }

    public interface b {
    }

    public static class c {
    }

    public interface d {
    }

    public static abstract class e {
    }

    public interface f extends b {
        void b();

        Set c();

        void d(String str);

        void e(C0329j jVar, Set set);

        boolean f();

        String g();

        void h(C0322c.e eVar);

        void i(C0322c.C0003c cVar);

        boolean j();

        boolean k();

        int l();

        C0305d[] m();

        String n();

        boolean o();
    }

    public static final class g extends c {
    }

    public a(String str, C0001a aVar, g gVar) {
        C0335p.m(aVar, "Cannot construct an Api with a null ClientBuilder");
        C0335p.m(gVar, "Cannot construct an Api with a null ClientKey");
        this.f362c = str;
        this.f360a = aVar;
        this.f361b = gVar;
    }

    public final C0001a a() {
        return this.f360a;
    }

    public final c b() {
        return this.f361b;
    }

    public final String c() {
        return this.f362c;
    }
}
