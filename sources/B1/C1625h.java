package b1;

import R0.b;
import android.util.Log;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import m3.d;
import o.C0962c;
import o.C0963d;
import o.j;

/* renamed from: b1.h  reason: case insensitive filesystem */
public final class C1625h implements C1626i {

    /* renamed from: b  reason: collision with root package name */
    public static final a f9029b = new a((C2103g) null);

    /* renamed from: a  reason: collision with root package name */
    private final b f9030a;

    /* renamed from: b1.h$a */
    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        private a() {
        }
    }

    public C1625h(b bVar) {
        m.e(bVar, "transportFactoryProvider");
        this.f9030a = bVar;
    }

    /* access modifiers changed from: private */
    public final byte[] c(C1616A a5) {
        String b5 = C1617B.f8921a.c().b(a5);
        m.d(b5, "SessionEvents.SESSION_EVENT_ENCODER.encode(value)");
        Log.d("EventGDTLogger", "Session Event: " + b5);
        byte[] bytes = b5.getBytes(d.f21160b);
        m.d(bytes, "this as java.lang.String).getBytes(charset)");
        return bytes;
    }

    public void a(C1616A a5) {
        m.e(a5, "sessionEvent");
        ((j) this.f9030a.get()).a("FIREBASE_APPQUALITY_SESSION", C1616A.class, C0962c.b("json"), new C1624g(this)).a(C0963d.f(a5));
    }
}
