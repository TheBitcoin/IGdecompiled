package t3;

import V2.g;
import o3.J;

/* renamed from: t3.f  reason: case insensitive filesystem */
public final class C1056f implements J {

    /* renamed from: a  reason: collision with root package name */
    private final g f4492a;

    public C1056f(g gVar) {
        this.f4492a = gVar;
    }

    public g getCoroutineContext() {
        return this.f4492a;
    }

    public String toString() {
        return "CoroutineScope(coroutineContext=" + getCoroutineContext() + ')';
    }
}
