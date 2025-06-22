package M;

import android.os.Looper;
import android.os.Message;
import b0.e;

final class b0 extends e {

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ C0322c f452b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b0(C0322c cVar, Looper looper) {
        super(looper);
        this.f452b = cVar;
    }

    private static final void a(Message message) {
        c0 c0Var = (c0) message.obj;
        c0Var.b();
        c0Var.e();
    }

    private static final boolean b(Message message) {
        int i4 = message.what;
        if (i4 == 2 || i4 == 1 || i4 == 7) {
            return true;
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v14, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: android.app.PendingIntent} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void handleMessage(android.os.Message r8) {
        /*
            r7 = this;
            M.c r0 = r7.f452b
            java.util.concurrent.atomic.AtomicInteger r0 = r0.f457C
            int r0 = r0.get()
            int r1 = r8.arg1
            if (r0 == r1) goto L_0x0016
            boolean r0 = b(r8)
            if (r0 == 0) goto L_0x0015
            a(r8)
        L_0x0015:
            return
        L_0x0016:
            int r0 = r8.what
            r1 = 4
            r2 = 1
            r3 = 5
            if (r0 == r2) goto L_0x002e
            r4 = 7
            if (r0 == r4) goto L_0x002e
            if (r0 != r1) goto L_0x002a
            M.c r0 = r7.f452b
            boolean r0 = r0.t()
            if (r0 == 0) goto L_0x002e
        L_0x002a:
            int r0 = r8.what
            if (r0 != r3) goto L_0x0036
        L_0x002e:
            M.c r0 = r7.f452b
            boolean r0 = r0.f()
            if (r0 == 0) goto L_0x0120
        L_0x0036:
            int r0 = r8.what
            r4 = 8
            r5 = 3
            r6 = 0
            if (r0 != r1) goto L_0x007e
            M.c r0 = r7.f452b
            J.b r1 = new J.b
            int r8 = r8.arg2
            r1.<init>(r8)
            r0.f483z = r1
            M.c r8 = r7.f452b
            boolean r8 = M.C0322c.h0(r8)
            if (r8 == 0) goto L_0x005f
            M.c r8 = r7.f452b
            boolean r0 = r8.f455A
            if (r0 == 0) goto L_0x005b
            goto L_0x005f
        L_0x005b:
            r8.i0(r5, (android.os.IInterface) null)
            return
        L_0x005f:
            M.c r8 = r7.f452b
            J.b r0 = r8.f483z
            if (r0 == 0) goto L_0x006c
            J.b r8 = r8.f483z
            goto L_0x0071
        L_0x006c:
            J.b r8 = new J.b
            r8.<init>(r4)
        L_0x0071:
            M.c r0 = r7.f452b
            M.c$c r0 = r0.f473p
            r0.a(r8)
            M.c r0 = r7.f452b
            r0.L(r8)
            return
        L_0x007e:
            if (r0 != r3) goto L_0x009f
            M.c r8 = r7.f452b
            J.b r0 = r8.f483z
            if (r0 == 0) goto L_0x008d
            J.b r8 = r8.f483z
            goto L_0x0092
        L_0x008d:
            J.b r8 = new J.b
            r8.<init>(r4)
        L_0x0092:
            M.c r0 = r7.f452b
            M.c$c r0 = r0.f473p
            r0.a(r8)
            M.c r0 = r7.f452b
            r0.L(r8)
            return
        L_0x009f:
            if (r0 != r5) goto L_0x00be
            java.lang.Object r0 = r8.obj
            boolean r1 = r0 instanceof android.app.PendingIntent
            if (r1 == 0) goto L_0x00aa
            r6 = r0
            android.app.PendingIntent r6 = (android.app.PendingIntent) r6
        L_0x00aa:
            J.b r0 = new J.b
            int r8 = r8.arg2
            r0.<init>(r8, r6)
            M.c r8 = r7.f452b
            M.c$c r8 = r8.f473p
            r8.a(r0)
            M.c r8 = r7.f452b
            r8.L(r0)
            return
        L_0x00be:
            r1 = 6
            if (r0 != r1) goto L_0x00e4
            M.c r0 = r7.f452b
            r0.i0(r3, (android.os.IInterface) null)
            M.c r0 = r7.f452b
            M.c$a r1 = r0.f478u
            if (r1 == 0) goto L_0x00d7
            M.c$a r0 = r0.f478u
            int r1 = r8.arg2
            r0.h(r1)
        L_0x00d7:
            M.c r0 = r7.f452b
            int r8 = r8.arg2
            r0.M(r8)
            M.c r8 = r7.f452b
            M.C0322c.g0(r8, r3, r2, r6)
            return
        L_0x00e4:
            r1 = 2
            if (r0 != r1) goto L_0x00f4
            M.c r0 = r7.f452b
            boolean r0 = r0.j()
            if (r0 == 0) goto L_0x00f0
            goto L_0x00f4
        L_0x00f0:
            a(r8)
            return
        L_0x00f4:
            boolean r0 = b(r8)
            if (r0 == 0) goto L_0x0102
            java.lang.Object r8 = r8.obj
            M.c0 r8 = (M.c0) r8
            r8.c()
            return
        L_0x0102:
            int r8 = r8.what
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Don't know how to handle message: "
            r0.append(r1)
            r0.append(r8)
            java.lang.String r8 = r0.toString()
            java.lang.Exception r0 = new java.lang.Exception
            r0.<init>()
            java.lang.String r1 = "GmsClient"
            android.util.Log.wtf(r1, r8, r0)
            return
        L_0x0120:
            a(r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: M.b0.handleMessage(android.os.Message):void");
    }
}
