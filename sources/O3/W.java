package o3;

import R2.a;
import V2.d;
import kotlin.jvm.internal.m;
import v3.h;

public abstract class W extends h {

    /* renamed from: c  reason: collision with root package name */
    public int f3680c;

    public W(int i4) {
        this.f3680c = i4;
    }

    public abstract void a(Object obj, Throwable th);

    public abstract d f();

    public Throwable g(Object obj) {
        A a5;
        if (obj instanceof A) {
            a5 = (A) obj;
        } else {
            a5 = null;
        }
        if (a5 != null) {
            return a5.f3624a;
        }
        return null;
    }

    public final void i(Throwable th, Throwable th2) {
        if (th != null || th2 != null) {
            if (!(th == null || th2 == null)) {
                a.a(th, th2);
            }
            if (th == null) {
                th = th2;
            }
            m.b(th);
            I.a(f().getContext(), new M("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th));
        }
    }

    public abstract Object j();

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x008b, code lost:
        if (r4.P0() != false) goto L_0x008d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00b3, code lost:
        if (r4.P0() != false) goto L_0x00b5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r10 = this;
            v3.i r0 = r10.f4570b
            V2.d r1 = r10.f()     // Catch:{ all -> 0x0023 }
            java.lang.String r2 = "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTask>"
            kotlin.jvm.internal.m.c(r1, r2)     // Catch:{ all -> 0x0023 }
            t3.j r1 = (t3.C1060j) r1     // Catch:{ all -> 0x0023 }
            V2.d r2 = r1.f4497e     // Catch:{ all -> 0x0023 }
            java.lang.Object r1 = r1.f4499g     // Catch:{ all -> 0x0023 }
            V2.g r3 = r2.getContext()     // Catch:{ all -> 0x0023 }
            java.lang.Object r1 = t3.J.c(r3, r1)     // Catch:{ all -> 0x0023 }
            t3.F r4 = t3.J.f4469a     // Catch:{ all -> 0x0023 }
            r5 = 0
            if (r1 == r4) goto L_0x0026
            o3.U0 r4 = o3.F.g(r2, r3, r1)     // Catch:{ all -> 0x0023 }
            goto L_0x0027
        L_0x0023:
            r1 = move-exception
            goto L_0x00b9
        L_0x0026:
            r4 = r5
        L_0x0027:
            V2.g r6 = r2.getContext()     // Catch:{ all -> 0x0046 }
            java.lang.Object r7 = r10.j()     // Catch:{ all -> 0x0046 }
            java.lang.Throwable r8 = r10.g(r7)     // Catch:{ all -> 0x0046 }
            if (r8 != 0) goto L_0x0048
            int r9 = r10.f3680c     // Catch:{ all -> 0x0046 }
            boolean r9 = o3.X.b(r9)     // Catch:{ all -> 0x0046 }
            if (r9 == 0) goto L_0x0048
            o3.s0$b r9 = o3.C1001s0.f3726k0     // Catch:{ all -> 0x0046 }
            V2.g$b r6 = r6.get(r9)     // Catch:{ all -> 0x0046 }
            o3.s0 r6 = (o3.C1001s0) r6     // Catch:{ all -> 0x0046 }
            goto L_0x0049
        L_0x0046:
            r2 = move-exception
            goto L_0x00ad
        L_0x0048:
            r6 = r5
        L_0x0049:
            if (r6 == 0) goto L_0x0066
            boolean r9 = r6.isActive()     // Catch:{ all -> 0x0046 }
            if (r9 != 0) goto L_0x0066
            java.util.concurrent.CancellationException r6 = r6.l()     // Catch:{ all -> 0x0046 }
            r10.a(r7, r6)     // Catch:{ all -> 0x0046 }
            R2.m$a r7 = R2.m.f8216a     // Catch:{ all -> 0x0046 }
            java.lang.Object r6 = R2.n.a(r6)     // Catch:{ all -> 0x0046 }
            java.lang.Object r6 = R2.m.a(r6)     // Catch:{ all -> 0x0046 }
            r2.resumeWith(r6)     // Catch:{ all -> 0x0046 }
            goto L_0x0083
        L_0x0066:
            if (r8 == 0) goto L_0x0076
            R2.m$a r6 = R2.m.f8216a     // Catch:{ all -> 0x0046 }
            java.lang.Object r6 = R2.n.a(r8)     // Catch:{ all -> 0x0046 }
            java.lang.Object r6 = R2.m.a(r6)     // Catch:{ all -> 0x0046 }
            r2.resumeWith(r6)     // Catch:{ all -> 0x0046 }
            goto L_0x0083
        L_0x0076:
            R2.m$a r6 = R2.m.f8216a     // Catch:{ all -> 0x0046 }
            java.lang.Object r6 = r10.h(r7)     // Catch:{ all -> 0x0046 }
            java.lang.Object r6 = R2.m.a(r6)     // Catch:{ all -> 0x0046 }
            r2.resumeWith(r6)     // Catch:{ all -> 0x0046 }
        L_0x0083:
            R2.s r2 = R2.s.f8222a     // Catch:{ all -> 0x0046 }
            if (r4 == 0) goto L_0x008d
            boolean r2 = r4.P0()     // Catch:{ all -> 0x0023 }
            if (r2 == 0) goto L_0x0090
        L_0x008d:
            t3.J.a(r3, r1)     // Catch:{ all -> 0x0023 }
        L_0x0090:
            r0.a()     // Catch:{ all -> 0x009a }
            R2.s r0 = R2.s.f8222a     // Catch:{ all -> 0x009a }
            java.lang.Object r0 = R2.m.a(r0)     // Catch:{ all -> 0x009a }
            goto L_0x00a5
        L_0x009a:
            r0 = move-exception
            R2.m$a r1 = R2.m.f8216a
            java.lang.Object r0 = R2.n.a(r0)
            java.lang.Object r0 = R2.m.a(r0)
        L_0x00a5:
            java.lang.Throwable r0 = R2.m.b(r0)
            r10.i(r5, r0)
            goto L_0x00d7
        L_0x00ad:
            if (r4 == 0) goto L_0x00b5
            boolean r4 = r4.P0()     // Catch:{ all -> 0x0023 }
            if (r4 == 0) goto L_0x00b8
        L_0x00b5:
            t3.J.a(r3, r1)     // Catch:{ all -> 0x0023 }
        L_0x00b8:
            throw r2     // Catch:{ all -> 0x0023 }
        L_0x00b9:
            R2.m$a r2 = R2.m.f8216a     // Catch:{ all -> 0x00c5 }
            r0.a()     // Catch:{ all -> 0x00c5 }
            R2.s r0 = R2.s.f8222a     // Catch:{ all -> 0x00c5 }
            java.lang.Object r0 = R2.m.a(r0)     // Catch:{ all -> 0x00c5 }
            goto L_0x00d0
        L_0x00c5:
            r0 = move-exception
            R2.m$a r2 = R2.m.f8216a
            java.lang.Object r0 = R2.n.a(r0)
            java.lang.Object r0 = R2.m.a(r0)
        L_0x00d0:
            java.lang.Throwable r0 = R2.m.b(r0)
            r10.i(r1, r0)
        L_0x00d7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: o3.W.run():void");
    }

    public Object h(Object obj) {
        return obj;
    }
}
