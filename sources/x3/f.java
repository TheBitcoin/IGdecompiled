package x3;

import V2.g;
import java.util.concurrent.atomic.AtomicReferenceArray;
import t3.C;

final class f extends C {

    /* renamed from: e  reason: collision with root package name */
    private final AtomicReferenceArray f4712e = new AtomicReferenceArray(e.f4711f);

    public f(long j4, f fVar, int i4) {
        super(j4, fVar, i4);
    }

    public int n() {
        return e.f4711f;
    }

    public void o(int i4, Throwable th, g gVar) {
        r().set(i4, e.f4710e);
        p();
    }

    public final AtomicReferenceArray r() {
        return this.f4712e;
    }

    public String toString() {
        return "SemaphoreSegment[id=" + this.f4463c + ", hashCode=" + hashCode() + ']';
    }
}
