package s3;

import V2.d;
import V2.g;
import kotlin.coroutines.jvm.internal.e;

final class x implements d, e {

    /* renamed from: a  reason: collision with root package name */
    private final d f4412a;

    /* renamed from: b  reason: collision with root package name */
    private final g f4413b;

    public x(d dVar, g gVar) {
        this.f4412a = dVar;
        this.f4413b = gVar;
    }

    public e getCallerFrame() {
        d dVar = this.f4412a;
        if (dVar instanceof e) {
            return (e) dVar;
        }
        return null;
    }

    public g getContext() {
        return this.f4413b;
    }

    public void resumeWith(Object obj) {
        this.f4412a.resumeWith(obj);
    }
}
