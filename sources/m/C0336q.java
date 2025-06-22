package M;

/* renamed from: M.q  reason: case insensitive filesystem */
public final class C0336q {

    /* renamed from: b  reason: collision with root package name */
    private static C0336q f572b;

    /* renamed from: c  reason: collision with root package name */
    private static final r f573c = new r(0, false, false, 0, 0);

    /* renamed from: a  reason: collision with root package name */
    private r f574a;

    private C0336q() {
    }

    public static synchronized C0336q b() {
        C0336q qVar;
        synchronized (C0336q.class) {
            try {
                if (f572b == null) {
                    f572b = new C0336q();
                }
                qVar = f572b;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        return qVar;
    }

    public r a() {
        return this.f574a;
    }

    public final synchronized void c(r rVar) {
        if (rVar == null) {
            this.f574a = f573c;
            return;
        }
        r rVar2 = this.f574a;
        if (rVar2 == null || rVar2.k() < rVar.k()) {
            this.f574a = rVar;
        }
    }
}
