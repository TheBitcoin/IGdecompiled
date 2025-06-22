package N0;

import K0.C1493b;
import K0.C1495d;
import K0.C1496e;
import L0.b;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class h {

    /* renamed from: a  reason: collision with root package name */
    private final Map f7765a;

    /* renamed from: b  reason: collision with root package name */
    private final Map f7766b;

    /* renamed from: c  reason: collision with root package name */
    private final C1495d f7767c;

    public static final class a implements b {

        /* renamed from: d  reason: collision with root package name */
        private static final C1495d f7768d = new g();

        /* renamed from: a  reason: collision with root package name */
        private final Map f7769a = new HashMap();

        /* renamed from: b  reason: collision with root package name */
        private final Map f7770b = new HashMap();

        /* renamed from: c  reason: collision with root package name */
        private C1495d f7771c = f7768d;

        public static /* synthetic */ void b(Object obj, C1496e eVar) {
            throw new C1493b("Couldn't find encoder for type " + obj.getClass().getCanonicalName());
        }

        public h c() {
            return new h(new HashMap(this.f7769a), new HashMap(this.f7770b), this.f7771c);
        }

        public a d(L0.a aVar) {
            aVar.a(this);
            return this;
        }

        /* renamed from: e */
        public a a(Class cls, C1495d dVar) {
            this.f7769a.put(cls, dVar);
            this.f7770b.remove(cls);
            return this;
        }
    }

    h(Map map, Map map2, C1495d dVar) {
        this.f7765a = map;
        this.f7766b = map2;
        this.f7767c = dVar;
    }

    public static a a() {
        return new a();
    }

    public void b(Object obj, OutputStream outputStream) {
        new f(outputStream, this.f7765a, this.f7766b, this.f7767c).t(obj);
    }

    public byte[] c(Object obj) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            b(obj, byteArrayOutputStream);
        } catch (IOException unused) {
        }
        return byteArrayOutputStream.toByteArray();
    }
}
