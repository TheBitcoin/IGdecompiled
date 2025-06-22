package t3;

import V2.g;
import kotlin.jvm.internal.m;

public final class L implements g.c {

    /* renamed from: a  reason: collision with root package name */
    private final ThreadLocal f4479a;

    public L(ThreadLocal threadLocal) {
        this.f4479a = threadLocal;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof L) && m.a(this.f4479a, ((L) obj).f4479a)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f4479a.hashCode();
    }

    public String toString() {
        return "ThreadLocalKey(threadLocal=" + this.f4479a + ')';
    }
}
