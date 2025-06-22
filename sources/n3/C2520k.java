package N3;

import N3.Q;
import O3.C2537c;
import O3.C2542h;
import com.mbridge.msdk.MBridgeConstans;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;

/* renamed from: N3.k  reason: case insensitive filesystem */
public abstract class C2520k {

    /* renamed from: a  reason: collision with root package name */
    public static final a f23727a = new a((C2103g) null);

    /* renamed from: b  reason: collision with root package name */
    public static final C2520k f23728b;

    /* renamed from: c  reason: collision with root package name */
    public static final Q f23729c;

    /* renamed from: d  reason: collision with root package name */
    public static final C2520k f23730d;

    /* renamed from: N3.k$a */
    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        private a() {
        }
    }

    static {
        C2520k kVar;
        try {
            Class.forName("java.nio.file.Files");
            kVar = new K();
        } catch (ClassNotFoundException unused) {
            kVar = new C2527s();
        }
        f23728b = kVar;
        Q.a aVar = Q.f23639b;
        String property = System.getProperty("java.io.tmpdir");
        m.d(property, "getProperty(\"java.io.tmpdir\")");
        f23729c = Q.a.e(aVar, property, false, 1, (Object) null);
        ClassLoader classLoader = C2542h.class.getClassLoader();
        m.d(classLoader, "ResourceFileSystem::class.java.classLoader");
        f23730d = new C2542h(classLoader, false);
    }

    public abstract void a(Q q4, Q q5);

    public final void b(Q q4, boolean z4) {
        m.e(q4, "dir");
        C2537c.a(this, q4, z4);
    }

    public final void c(Q q4) {
        m.e(q4, "dir");
        d(q4, false);
    }

    public abstract void d(Q q4, boolean z4);

    public final void e(Q q4) {
        m.e(q4, MBridgeConstans.DYNAMIC_VIEW_WX_PATH);
        f(q4, false);
    }

    public abstract void f(Q q4, boolean z4);

    public final boolean g(Q q4) {
        m.e(q4, MBridgeConstans.DYNAMIC_VIEW_WX_PATH);
        return C2537c.b(this, q4);
    }

    public abstract C2519j h(Q q4);

    public abstract C2518i i(Q q4);

    public final C2518i j(Q q4) {
        m.e(q4, "file");
        return k(q4, false, false);
    }

    public abstract C2518i k(Q q4, boolean z4, boolean z5);

    public abstract Z l(Q q4);
}
