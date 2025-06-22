package A0;

import E0.g;
import androidx.lifecycle.i;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicMarkableReference;
import java.util.concurrent.atomic.AtomicReference;
import z0.C2446g;

public class m {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final C1270f f5738a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final C2446g f5739b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public String f5740c;

    /* renamed from: d  reason: collision with root package name */
    private final a f5741d = new a(false);

    /* renamed from: e  reason: collision with root package name */
    private final a f5742e = new a(true);

    /* renamed from: f  reason: collision with root package name */
    private final j f5743f = new j(128);

    /* renamed from: g  reason: collision with root package name */
    private final AtomicMarkableReference f5744g = new AtomicMarkableReference((Object) null, false);

    private class a {

        /* renamed from: a  reason: collision with root package name */
        final AtomicMarkableReference f5745a;

        /* renamed from: b  reason: collision with root package name */
        private final AtomicReference f5746b = new AtomicReference((Object) null);

        /* renamed from: c  reason: collision with root package name */
        private final boolean f5747c;

        public a(boolean z4) {
            int i4;
            this.f5747c = z4;
            if (z4) {
                i4 = 8192;
            } else {
                i4 = 1024;
            }
            this.f5745a = new AtomicMarkableReference(new C1268d(64, i4), false);
        }

        public static /* synthetic */ void a(a aVar) {
            aVar.f5746b.set((Object) null);
            aVar.d();
        }

        private void c() {
            l lVar = new l(this);
            if (i.a(this.f5746b, (Object) null, lVar)) {
                m.this.f5739b.f22852b.d(lVar);
            }
        }

        private void d() {
            Map map;
            synchronized (this) {
                try {
                    if (this.f5745a.isMarked()) {
                        map = ((C1268d) this.f5745a.getReference()).a();
                        AtomicMarkableReference atomicMarkableReference = this.f5745a;
                        atomicMarkableReference.set((C1268d) atomicMarkableReference.getReference(), false);
                    } else {
                        map = null;
                    }
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
            if (map != null) {
                m.this.f5738a.q(m.this.f5740c, map, this.f5747c);
            }
        }

        public Map b() {
            return ((C1268d) this.f5745a.getReference()).a();
        }

        public boolean e(String str, String str2) {
            synchronized (this) {
                try {
                    if (!((C1268d) this.f5745a.getReference()).d(str, str2)) {
                        return false;
                    }
                    AtomicMarkableReference atomicMarkableReference = this.f5745a;
                    atomicMarkableReference.set((C1268d) atomicMarkableReference.getReference(), true);
                    c();
                    return true;
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
        }
    }

    public m(String str, g gVar, C2446g gVar2) {
        this.f5740c = str;
        this.f5738a = new C1270f(gVar);
        this.f5739b = gVar2;
    }

    public static /* synthetic */ void a(m mVar, String str, Map map, List list) {
        if (mVar.h() != null) {
            mVar.f5738a.s(str, mVar.h());
        }
        if (!map.isEmpty()) {
            mVar.f5738a.p(str, map);
        }
        if (!list.isEmpty()) {
            mVar.f5738a.r(str, list);
        }
    }

    public static m i(String str, g gVar, C2446g gVar2) {
        C1270f fVar = new C1270f(gVar);
        m mVar = new m(str, gVar, gVar2);
        ((C1268d) mVar.f5741d.f5745a.getReference()).e(fVar.i(str, false));
        ((C1268d) mVar.f5742e.f5745a.getReference()).e(fVar.i(str, true));
        mVar.f5744g.set(fVar.k(str), false);
        mVar.f5743f.c(fVar.j(str));
        return mVar;
    }

    public static String j(String str, g gVar) {
        return new C1270f(gVar).k(str);
    }

    public Map e() {
        return this.f5741d.b();
    }

    public Map f() {
        return this.f5742e.b();
    }

    public List g() {
        return this.f5743f.a();
    }

    public String h() {
        return (String) this.f5744g.getReference();
    }

    public boolean k(String str, String str2) {
        return this.f5742e.e(str, str2);
    }

    public void l(String str) {
        synchronized (this.f5740c) {
            this.f5740c = str;
            this.f5739b.f22852b.d(new k(this, str, this.f5741d.b(), this.f5743f.b()));
        }
    }
}
