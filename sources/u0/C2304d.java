package u0;

import R0.a;
import R0.b;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import q0.C2204a;
import v0.g;
import w0.C2333a;
import w0.d;
import w0.e;
import w0.f;
import x0.C2347a;
import x0.C2348b;
import x0.c;

/* renamed from: u0.d  reason: case insensitive filesystem */
public class C2304d {

    /* renamed from: a  reason: collision with root package name */
    private final a f21859a;

    /* renamed from: b  reason: collision with root package name */
    private volatile C2333a f21860b;

    /* renamed from: c  reason: collision with root package name */
    private volatile C2348b f21861c;

    /* renamed from: d  reason: collision with root package name */
    private final List f21862d;

    public C2304d(a aVar) {
        this(aVar, new c(), new f());
    }

    public static /* synthetic */ void a(C2304d dVar, b bVar) {
        dVar.getClass();
        g.f().b("AnalyticsConnector now available.");
        C2204a aVar = (C2204a) bVar.get();
        e eVar = new e(aVar);
        C2305e eVar2 = new C2305e();
        if (g(aVar, eVar2) != null) {
            g.f().b("Registered Firebase Analytics listener.");
            d dVar2 = new d();
            w0.c cVar = new w0.c(eVar, 500, TimeUnit.MILLISECONDS);
            synchronized (dVar) {
                try {
                    for (C2347a a5 : dVar.f21862d) {
                        dVar2.a(a5);
                    }
                    eVar2.d(dVar2);
                    eVar2.e(cVar);
                    dVar.f21861c = dVar2;
                    dVar.f21860b = cVar;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return;
        }
        g.f().k("Could not register Firebase Analytics listener; a listener is already registered.");
    }

    public static /* synthetic */ void c(C2304d dVar, C2347a aVar) {
        synchronized (dVar) {
            try {
                if (dVar.f21861c instanceof c) {
                    dVar.f21862d.add(aVar);
                }
                dVar.f21861c.a(aVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void f() {
        this.f21859a.a(new C2303c(this));
    }

    private static C2204a.C0267a g(C2204a aVar, C2305e eVar) {
        C2204a.C0267a b5 = aVar.b("clx", eVar);
        if (b5 != null) {
            return b5;
        }
        g.f().b("Could not register AnalyticsConnectorListener with Crashlytics origin.");
        C2204a.C0267a b6 = aVar.b("crash", eVar);
        if (b6 != null) {
            g.f().k("A new version of the Google Analytics for Firebase SDK is now available. For improved performance and compatibility with Crashlytics, please update to the latest version.");
        }
        return b6;
    }

    public C2333a d() {
        return new C2302b(this);
    }

    public C2348b e() {
        return new C2301a(this);
    }

    public C2304d(a aVar, C2348b bVar, C2333a aVar2) {
        this.f21859a = aVar;
        this.f21861c = bVar;
        this.f21862d = new ArrayList();
        this.f21860b = aVar2;
        f();
    }
}
