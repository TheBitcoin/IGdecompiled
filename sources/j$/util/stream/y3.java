package j$.util.stream;

import j$.util.i0;
import java.util.concurrent.atomic.AtomicLong;

public abstract class y3 {

    /* renamed from: a  reason: collision with root package name */
    public final i0 f5641a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f5642b;

    /* renamed from: c  reason: collision with root package name */
    public final int f5643c;

    /* renamed from: d  reason: collision with root package name */
    public final long f5644d;

    /* renamed from: e  reason: collision with root package name */
    public final AtomicLong f5645e;

    public abstract i0 c(i0 i0Var);

    public y3(i0 i0Var, long j4, long j5) {
        this.f5641a = i0Var;
        long j6 = 0;
        int i4 = (j5 > 0 ? 1 : (j5 == 0 ? 0 : -1));
        this.f5642b = i4 < 0;
        this.f5644d = i4 >= 0 ? j5 : j6;
        this.f5643c = 128;
        this.f5645e = new AtomicLong(i4 >= 0 ? j4 + j5 : j4);
    }

    public y3(i0 i0Var, y3 y3Var) {
        this.f5641a = i0Var;
        this.f5642b = y3Var.f5642b;
        this.f5645e = y3Var.f5645e;
        this.f5644d = y3Var.f5644d;
        this.f5643c = y3Var.f5643c;
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long b(long r11) {
        /*
            r10 = this;
        L_0x0000:
            java.util.concurrent.atomic.AtomicLong r0 = r10.f5645e
            long r1 = r0.get()
            boolean r3 = r10.f5642b
            r4 = 0
            int r6 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r6 != 0) goto L_0x0012
            if (r3 == 0) goto L_0x0011
            return r11
        L_0x0011:
            return r4
        L_0x0012:
            long r6 = java.lang.Math.min(r1, r11)
            int r8 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r8 <= 0) goto L_0x0022
            long r8 = r1 - r6
            boolean r0 = r0.compareAndSet(r1, r8)
            if (r0 == 0) goto L_0x0000
        L_0x0022:
            if (r3 == 0) goto L_0x002a
            long r11 = r11 - r6
            long r11 = java.lang.Math.max(r11, r4)
            return r11
        L_0x002a:
            long r11 = r10.f5644d
            int r0 = (r1 > r11 ? 1 : (r1 == r11 ? 0 : -1))
            if (r0 <= 0) goto L_0x0037
            long r1 = r1 - r11
            long r6 = r6 - r1
            long r11 = java.lang.Math.max(r6, r4)
            return r11
        L_0x0037:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.stream.y3.b(long):long");
    }

    public final x3 d() {
        if (this.f5645e.get() > 0) {
            return x3.MAYBE_MORE;
        }
        return this.f5642b ? x3.UNLIMITED : x3.NO_MORE;
    }

    public final i0 trySplit() {
        i0 trySplit;
        if (this.f5645e.get() == 0 || (trySplit = this.f5641a.trySplit()) == null) {
            return null;
        }
        return c(trySplit);
    }

    public final long estimateSize() {
        return this.f5641a.estimateSize();
    }

    public final int characteristics() {
        return this.f5641a.characteristics() & -16465;
    }
}
