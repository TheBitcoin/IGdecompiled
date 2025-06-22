package r3;

import R2.m;
import R2.s;
import W2.b;
import androidx.concurrent.futures.a;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.jvm.internal.h;
import o3.C0991n;
import s3.c;
import s3.d;

final class L extends d {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f4180a = AtomicReferenceFieldUpdater.newUpdater(L.class, Object.class, "_state");
    private volatile Object _state;

    /* renamed from: d */
    public boolean a(J j4) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f4180a;
        if (atomicReferenceFieldUpdater.get(this) != null) {
            return false;
        }
        atomicReferenceFieldUpdater.set(this, K.f4178a);
        return true;
    }

    public final Object e(V2.d dVar) {
        C0991n nVar = new C0991n(b.b(dVar), 1);
        nVar.z();
        if (!a.a(f4180a, this, K.f4178a, nVar)) {
            m.a aVar = m.f8216a;
            nVar.resumeWith(m.a(s.f8222a));
        }
        Object v4 = nVar.v();
        if (v4 == b.c()) {
            h.c(dVar);
        }
        if (v4 == b.c()) {
            return v4;
        }
        return s.f8222a;
    }

    /* renamed from: f */
    public V2.d[] b(J j4) {
        f4180a.set(this, (Object) null);
        return c.f4340a;
    }

    public final void g() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f4180a;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj != null && obj != K.f4179b) {
                if (obj == K.f4178a) {
                    if (a.a(f4180a, this, obj, K.f4179b)) {
                        return;
                    }
                } else if (a.a(f4180a, this, obj, K.f4178a)) {
                    m.a aVar = m.f8216a;
                    ((C0991n) obj).resumeWith(m.a(s.f8222a));
                    return;
                }
            } else {
                return;
            }
        }
    }

    public final boolean h() {
        Object andSet = f4180a.getAndSet(this, K.f4178a);
        kotlin.jvm.internal.m.b(andSet);
        if (andSet == K.f4179b) {
            return true;
        }
        return false;
    }
}
