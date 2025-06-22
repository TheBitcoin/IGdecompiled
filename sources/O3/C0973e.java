package o3;

import V2.g;
import java.util.concurrent.locks.LockSupport;
import kotlin.jvm.internal.m;

/* renamed from: o3.e  reason: case insensitive filesystem */
final class C0973e extends C0965a {

    /* renamed from: d  reason: collision with root package name */
    private final Thread f3702d;

    /* renamed from: e  reason: collision with root package name */
    private final C0970c0 f3703e;

    public C0973e(g gVar, Thread thread, C0970c0 c0Var) {
        super(gVar, true, true);
        this.f3702d = thread;
        this.f3703e = c0Var;
    }

    /* access modifiers changed from: protected */
    public void J(Object obj) {
        if (!m.a(Thread.currentThread(), this.f3702d)) {
            Thread thread = this.f3702d;
            C0969c.a();
            LockSupport.unpark(thread);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: o3.A} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object P0() {
        /*
            r6 = this;
            o3.C0969c.a()
            o3.c0 r0 = r6.f3703e     // Catch:{ all -> 0x000e }
            r1 = 1
            r2 = 0
            r3 = 0
            if (r0 == 0) goto L_0x0010
            o3.C0970c0.K(r0, r2, r1, r3)     // Catch:{ all -> 0x000e }
            goto L_0x0010
        L_0x000e:
            r0 = move-exception
            goto L_0x0063
        L_0x0010:
            boolean r0 = java.lang.Thread.interrupted()     // Catch:{ all -> 0x001f }
            if (r0 != 0) goto L_0x0052
            o3.c0 r0 = r6.f3703e     // Catch:{ all -> 0x001f }
            if (r0 == 0) goto L_0x0021
            long r4 = r0.N()     // Catch:{ all -> 0x001f }
            goto L_0x0026
        L_0x001f:
            r0 = move-exception
            goto L_0x005b
        L_0x0021:
            r4 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
        L_0x0026:
            boolean r0 = r6.A()     // Catch:{ all -> 0x001f }
            if (r0 != 0) goto L_0x0033
            o3.C0969c.a()     // Catch:{ all -> 0x001f }
            java.util.concurrent.locks.LockSupport.parkNanos(r6, r4)     // Catch:{ all -> 0x001f }
            goto L_0x0010
        L_0x0033:
            o3.c0 r0 = r6.f3703e     // Catch:{ all -> 0x000e }
            if (r0 == 0) goto L_0x003a
            o3.C0970c0.F(r0, r2, r1, r3)     // Catch:{ all -> 0x000e }
        L_0x003a:
            o3.C0969c.a()
            java.lang.Object r0 = r6.f0()
            java.lang.Object r0 = o3.B0.h(r0)
            boolean r1 = r0 instanceof o3.A
            if (r1 == 0) goto L_0x004c
            r3 = r0
            o3.A r3 = (o3.A) r3
        L_0x004c:
            if (r3 != 0) goto L_0x004f
            return r0
        L_0x004f:
            java.lang.Throwable r0 = r3.f3624a
            throw r0
        L_0x0052:
            java.lang.InterruptedException r0 = new java.lang.InterruptedException     // Catch:{ all -> 0x001f }
            r0.<init>()     // Catch:{ all -> 0x001f }
            r6.M(r0)     // Catch:{ all -> 0x001f }
            throw r0     // Catch:{ all -> 0x001f }
        L_0x005b:
            o3.c0 r4 = r6.f3703e     // Catch:{ all -> 0x000e }
            if (r4 == 0) goto L_0x0062
            o3.C0970c0.F(r4, r2, r1, r3)     // Catch:{ all -> 0x000e }
        L_0x0062:
            throw r0     // Catch:{ all -> 0x000e }
        L_0x0063:
            o3.C0969c.a()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: o3.C0973e.P0():java.lang.Object");
    }

    /* access modifiers changed from: protected */
    public boolean j0() {
        return true;
    }
}
