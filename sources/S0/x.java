package s0;

import R0.b;

public class x implements b {

    /* renamed from: c  reason: collision with root package name */
    private static final Object f21754c = new Object();

    /* renamed from: a  reason: collision with root package name */
    private volatile Object f21755a = f21754c;

    /* renamed from: b  reason: collision with root package name */
    private volatile b f21756b;

    public x(b bVar) {
        this.f21756b = bVar;
    }

    public Object get() {
        Object obj;
        Object obj2 = this.f21755a;
        Object obj3 = f21754c;
        if (obj2 != obj3) {
            return obj2;
        }
        synchronized (this) {
            try {
                obj = this.f21755a;
                if (obj == obj3) {
                    obj = this.f21756b.get();
                    this.f21755a = obj;
                    this.f21756b = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }
}
