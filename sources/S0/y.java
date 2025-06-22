package s0;

import R0.b;
import j$.util.DesugarCollections;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

class y implements b {

    /* renamed from: a  reason: collision with root package name */
    private volatile Set f21757a = Collections.newSetFromMap(new ConcurrentHashMap());

    /* renamed from: b  reason: collision with root package name */
    private volatile Set f21758b = null;

    y(Collection collection) {
        this.f21757a.addAll(collection);
    }

    static y b(Collection collection) {
        return new y((Set) collection);
    }

    private synchronized void d() {
        try {
            for (b bVar : this.f21757a) {
                this.f21758b.add(bVar.get());
            }
            this.f21757a = null;
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void a(b bVar) {
        try {
            if (this.f21758b == null) {
                this.f21757a.add(bVar);
            } else {
                this.f21758b.add(bVar.get());
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    /* renamed from: c */
    public Set get() {
        if (this.f21758b == null) {
            synchronized (this) {
                try {
                    if (this.f21758b == null) {
                        this.f21758b = Collections.newSetFromMap(new ConcurrentHashMap());
                        d();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return DesugarCollections.unmodifiableSet(this.f21758b);
    }
}
