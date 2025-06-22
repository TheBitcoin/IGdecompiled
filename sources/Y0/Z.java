package y0;

import A0.C1269e;
import A0.m;
import B0.F;
import E0.e;
import F0.C1295b;
import G0.j;
import H0.C1303d;
import android.app.ApplicationExitInfo;
import android.content.Context;
import androidx.work.impl.utils.b;
import j$.util.DesugarCollections;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.concurrent.Executor;
import k0.C0937l;
import k0.C0940o;
import v0.g;
import z0.C2446g;

public class Z {

    /* renamed from: a  reason: collision with root package name */
    private final C2435z f22611a;

    /* renamed from: b  reason: collision with root package name */
    private final e f22612b;

    /* renamed from: c  reason: collision with root package name */
    private final C1295b f22613c;

    /* renamed from: d  reason: collision with root package name */
    private final C1269e f22614d;

    /* renamed from: e  reason: collision with root package name */
    private final m f22615e;

    /* renamed from: f  reason: collision with root package name */
    private final I f22616f;

    /* renamed from: g  reason: collision with root package name */
    private final C2446g f22617g;

    Z(C2435z zVar, e eVar, C1295b bVar, C1269e eVar2, m mVar, I i4, C2446g gVar) {
        this.f22611a = zVar;
        this.f22612b = eVar;
        this.f22613c = bVar;
        this.f22614d = eVar2;
        this.f22615e = mVar;
        this.f22616f = i4;
        this.f22617g = gVar;
    }

    public static /* synthetic */ void a(Z z4, F.e.d dVar, String str, boolean z5) {
        z4.getClass();
        g.f().b("disk worker: log non-fatal event to persistence");
        z4.f22612b.w(dVar, str, z5);
    }

    private F.e.d d(F.e.d dVar, C1269e eVar, m mVar) {
        F.e.d.b h4 = dVar.h();
        String c5 = eVar.c();
        if (c5 != null) {
            h4.d(F.e.d.C0074d.a().b(c5).a());
        } else {
            g.f().i("No log data to include with this event.");
        }
        List n4 = n(mVar.e());
        List n5 = n(mVar.f());
        if (!n4.isEmpty() || !n5.isEmpty()) {
            h4.b(dVar.b().i().e(n4).g(n5).a());
        }
        return h4.a();
    }

    private F.e.d e(F.e.d dVar) {
        return f(d(dVar, this.f22614d, this.f22615e), this.f22615e);
    }

    private F.e.d f(F.e.d dVar, m mVar) {
        List g4 = mVar.g();
        if (g4.isEmpty()) {
            return dVar;
        }
        F.e.d.b h4 = dVar.h();
        h4.e(F.e.d.f.a().b(g4).a());
        return h4.a();
    }

    private static F.a g(ApplicationExitInfo applicationExitInfo) {
        String str = null;
        try {
            InputStream a5 = applicationExitInfo.getTraceInputStream();
            if (a5 != null) {
                str = h(a5);
            }
        } catch (IOException e5) {
            g f4 = g.f();
            f4.k("Could not get input trace in application exit info: " + applicationExitInfo.toString() + " Error: " + e5);
        }
        return F.a.a().c(applicationExitInfo.getImportance()).e(applicationExitInfo.getProcessName()).g(applicationExitInfo.getReason()).i(applicationExitInfo.getTimestamp()).d(applicationExitInfo.getPid()).f(applicationExitInfo.getPss()).h(applicationExitInfo.getRss()).j(str).a();
    }

    public static String h(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return byteArrayOutputStream.toString(StandardCharsets.UTF_8.name());
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    public static Z i(Context context, I i4, E0.g gVar, C2412b bVar, C1269e eVar, m mVar, C1303d dVar, j jVar, N n4, C2424n nVar, C2446g gVar2) {
        return new Z(new C2435z(context, i4, bVar, dVar, jVar), new e(gVar, jVar, nVar), C1295b.b(context, jVar, n4), eVar, mVar, i4, gVar2);
    }

    private C2408A j(C2408A a5) {
        if (a5.b().h() != null && a5.b().g() != null) {
            return a5;
        }
        H d5 = this.f22616f.d(true);
        return C2408A.a(a5.b().t(d5.b()).s(d5.a()), a5.d(), a5.c());
    }

    private ApplicationExitInfo m(String str, List list) {
        long q4 = this.f22612b.q(str);
        for (Object a5 : list) {
            ApplicationExitInfo a6 = b.a(a5);
            if (a6.getTimestamp() < q4) {
                return null;
            }
            if (a6.getReason() == 6) {
                return a6;
            }
        }
        return null;
    }

    private static List n(Map map) {
        ArrayList arrayList = new ArrayList();
        arrayList.ensureCapacity(map.size());
        for (Map.Entry entry : map.entrySet()) {
            arrayList.add(F.c.a().b((String) entry.getKey()).c((String) entry.getValue()).a());
        }
        Collections.sort(arrayList, new Y());
        return DesugarCollections.unmodifiableList(arrayList);
    }

    /* access modifiers changed from: private */
    public boolean r(C0937l lVar) {
        if (lVar.n()) {
            C2408A a5 = (C2408A) lVar.j();
            g f4 = g.f();
            f4.b("Crashlytics report successfully enqueued to DataTransport: " + a5.d());
            File c5 = a5.c();
            if (c5.delete()) {
                g f5 = g.f();
                f5.b("Deleted report file: " + c5.getPath());
                return true;
            }
            g f6 = g.f();
            f6.k("Crashlytics could not delete report file: " + c5.getPath());
            return true;
        }
        g.f().l("Crashlytics report could not be enqueued to DataTransport", lVar.i());
        return false;
    }

    private void s(Throwable th, Thread thread, String str, String str2, long j4, boolean z4) {
        boolean equals = str2.equals("crash");
        F.e.d e5 = e(this.f22611a.d(th, thread, str2, j4, 4, 8, z4));
        if (!z4) {
            this.f22617g.f22852b.d(new X(this, e5, str, equals));
        } else {
            this.f22612b.w(e5, str, equals);
        }
    }

    public void k(String str, List list, F.a aVar) {
        g.f().b("SessionReportingCoordinator#finalizeSessionWithNativeEvent");
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            F.d.b b5 = ((L) it.next()).b();
            if (b5 != null) {
                arrayList.add(b5);
            }
        }
        this.f22612b.l(str, F.d.a().b(DesugarCollections.unmodifiableList(arrayList)).a(), aVar);
    }

    public void l(long j4, String str) {
        this.f22612b.k(str, j4);
    }

    public boolean o() {
        return this.f22612b.r();
    }

    public SortedSet p() {
        return this.f22612b.p();
    }

    public void q(String str, long j4) {
        this.f22612b.x(this.f22611a.e(str, j4));
    }

    public void t(Throwable th, Thread thread, String str, long j4) {
        g f4 = g.f();
        f4.i("Persisting fatal event for session " + str);
        s(th, thread, str, "crash", j4, true);
    }

    public void u(String str, List list, C1269e eVar, m mVar) {
        ApplicationExitInfo m4 = m(str, list);
        if (m4 == null) {
            g f4 = g.f();
            f4.i("No relevant ApplicationExitInfo occurred during session: " + str);
            return;
        }
        F.e.d c5 = this.f22611a.c(g(m4));
        g f5 = g.f();
        f5.b("Persisting anr for session " + str);
        this.f22612b.w(f(d(c5, eVar, mVar), mVar), str, true);
    }

    public void v() {
        this.f22612b.i();
    }

    public C0937l w(Executor executor) {
        return x(executor, (String) null);
    }

    public C0937l x(Executor executor, String str) {
        boolean z4;
        List<C2408A> u4 = this.f22612b.u();
        ArrayList arrayList = new ArrayList();
        for (C2408A a5 : u4) {
            if (str == null || str.equals(a5.d())) {
                C1295b bVar = this.f22613c;
                C2408A j4 = j(a5);
                if (str != null) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                arrayList.add(bVar.c(j4, z4).g(executor, new W(this)));
            }
        }
        return C0940o.f(arrayList);
    }
}
