package x3;

import R2.s;
import V2.d;
import V2.g;
import d3.l;
import d3.q;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.jvm.internal.h;
import kotlin.jvm.internal.n;
import o3.C0989m;
import o3.C0991n;
import o3.C0995p;
import o3.G;
import o3.N;
import o3.W0;
import t3.C;
import t3.F;

public class b extends d implements a {
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f4682i = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "owner");

    /* renamed from: h  reason: collision with root package name */
    private final q f4683h;
    private volatile Object owner;

    private final class a implements C0989m, W0 {

        /* renamed from: a  reason: collision with root package name */
        public final C0991n f4684a;

        /* renamed from: b  reason: collision with root package name */
        public final Object f4685b;

        /* renamed from: x3.b$a$a  reason: collision with other inner class name */
        static final class C0053a extends n implements l {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ b f4687a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ a f4688b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0053a(b bVar, a aVar) {
                super(1);
                this.f4687a = bVar;
                this.f4688b = aVar;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return s.f8222a;
            }

            public final void invoke(Throwable th) {
                this.f4687a.d(this.f4688b.f4685b);
            }
        }

        /* renamed from: x3.b$a$b  reason: collision with other inner class name */
        static final class C0054b extends n implements l {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ b f4689a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ a f4690b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0054b(b bVar, a aVar) {
                super(1);
                this.f4689a = bVar;
                this.f4690b = aVar;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return s.f8222a;
            }

            public final void invoke(Throwable th) {
                b.f4682i.set(this.f4689a, this.f4690b.f4685b);
                this.f4689a.d(this.f4690b.f4685b);
            }
        }

        public a(C0991n nVar, Object obj) {
            this.f4684a = nVar;
            this.f4685b = obj;
        }

        public void D(Object obj) {
            this.f4684a.D(obj);
        }

        /* renamed from: a */
        public void c(s sVar, l lVar) {
            b.f4682i.set(b.this, this.f4685b);
            this.f4684a.c(sVar, new C0053a(b.this, this));
        }

        public void d(C c5, int i4) {
            this.f4684a.d(c5, i4);
        }

        /* renamed from: f */
        public void e(G g4, s sVar) {
            this.f4684a.e(g4, sVar);
        }

        /* renamed from: g */
        public Object b(s sVar, Object obj, l lVar) {
            Object b5 = this.f4684a.b(sVar, obj, new C0054b(b.this, this));
            if (b5 != null) {
                b.f4682i.set(b.this, this.f4685b);
            }
            return b5;
        }

        public g getContext() {
            return this.f4684a.getContext();
        }

        public void q(l lVar) {
            this.f4684a.q(lVar);
        }

        public void resumeWith(Object obj) {
            this.f4684a.resumeWith(obj);
        }

        public boolean y(Throwable th) {
            return this.f4684a.y(th);
        }
    }

    /* renamed from: x3.b$b  reason: collision with other inner class name */
    static final class C0055b extends n implements q {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f4691a;

        /* renamed from: x3.b$b$a */
        static final class a extends n implements l {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ b f4692a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ Object f4693b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(b bVar, Object obj) {
                super(1);
                this.f4692a = bVar;
                this.f4693b = obj;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return s.f8222a;
            }

            public final void invoke(Throwable th) {
                this.f4692a.d(this.f4693b);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0055b(b bVar) {
            super(3);
            this.f4691a = bVar;
        }

        public final l a(w3.a aVar, Object obj, Object obj2) {
            return new a(this.f4691a, obj);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            android.support.v4.media.a.a(obj);
            return a((w3.a) null, obj2, obj3);
        }
    }

    public b(boolean z4) {
        super(1, z4 ? 1 : 0);
        F f4;
        if (z4) {
            f4 = null;
        } else {
            f4 = c.f4694a;
        }
        this.owner = f4;
        this.f4683h = new C0055b(this);
    }

    private final int o(Object obj) {
        while (b()) {
            Object obj2 = f4682i.get(this);
            if (obj2 != c.f4694a) {
                if (obj2 == obj) {
                    return 1;
                }
                return 2;
            }
        }
        return 0;
    }

    static /* synthetic */ Object p(b bVar, Object obj, d dVar) {
        if (bVar.a(obj)) {
            return s.f8222a;
        }
        Object q4 = bVar.q(obj, dVar);
        if (q4 == W2.b.c()) {
            return q4;
        }
        return s.f8222a;
    }

    private final Object q(Object obj, d dVar) {
        C0991n b5 = C0995p.b(W2.b.b(dVar));
        try {
            e(new a(b5, obj));
            Object v4 = b5.v();
            if (v4 == W2.b.c()) {
                h.c(dVar);
            }
            if (v4 == W2.b.c()) {
                return v4;
            }
            return s.f8222a;
        } catch (Throwable th) {
            b5.J();
            throw th;
        }
    }

    private final int r(Object obj) {
        while (!k()) {
            if (obj == null) {
                return 1;
            }
            int o4 = o(obj);
            if (o4 == 1) {
                return 2;
            }
            if (o4 == 2) {
                return 1;
            }
        }
        f4682i.set(this, obj);
        return 0;
    }

    public boolean a(Object obj) {
        int r4 = r(obj);
        if (r4 == 0) {
            return true;
        }
        if (r4 == 1) {
            return false;
        }
        if (r4 != 2) {
            throw new IllegalStateException("unexpected");
        }
        throw new IllegalStateException(("This mutex is already locked by the specified owner: " + obj).toString());
    }

    public boolean b() {
        if (i() == 0) {
            return true;
        }
        return false;
    }

    public Object c(Object obj, d dVar) {
        return p(this, obj, dVar);
    }

    public void d(Object obj) {
        while (b()) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f4682i;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 != c.f4694a) {
                if (obj2 != obj && obj != null) {
                    throw new IllegalStateException(("This mutex is locked by " + obj2 + ", but " + obj + " is expected").toString());
                } else if (androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, obj2, c.f4694a)) {
                    j();
                    return;
                }
            }
        }
        throw new IllegalStateException("This mutex is not locked");
    }

    public String toString() {
        return "Mutex@" + N.b(this) + "[isLocked=" + b() + ",owner=" + f4682i.get(this) + ']';
    }
}
