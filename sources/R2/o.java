package R2;

import d3.a;
import java.io.Serializable;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;

final class o implements g, Serializable {

    /* renamed from: a  reason: collision with root package name */
    private a f8218a;

    /* renamed from: b  reason: collision with root package name */
    private volatile Object f8219b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f8220c;

    public o(a aVar, Object obj) {
        m.e(aVar, "initializer");
        this.f8218a = aVar;
        this.f8219b = q.f8221a;
        this.f8220c = obj == null ? this : obj;
    }

    public Object getValue() {
        Object obj;
        Object obj2 = this.f8219b;
        q qVar = q.f8221a;
        if (obj2 != qVar) {
            return obj2;
        }
        synchronized (this.f8220c) {
            obj = this.f8219b;
            if (obj == qVar) {
                a aVar = this.f8218a;
                m.b(aVar);
                obj = aVar.invoke();
                this.f8219b = obj;
                this.f8218a = null;
            }
        }
        return obj;
    }

    public boolean isInitialized() {
        if (this.f8219b != q.f8221a) {
            return true;
        }
        return false;
    }

    public String toString() {
        if (isInitialized()) {
            return String.valueOf(getValue());
        }
        return "Lazy value not initialized yet.";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ o(a aVar, Object obj, int i4, C2103g gVar) {
        this(aVar, (i4 & 2) != 0 ? null : obj);
    }
}
