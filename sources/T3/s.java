package t3;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.C2103g;

public final class s {

    /* renamed from: e  reason: collision with root package name */
    public static final a f4517e = new a((C2103g) null);

    /* renamed from: f  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f4518f;

    /* renamed from: g  reason: collision with root package name */
    private static final AtomicLongFieldUpdater f4519g;

    /* renamed from: h  reason: collision with root package name */
    public static final F f4520h = new F("REMOVE_FROZEN");
    private volatile Object _next;
    private volatile long _state;

    /* renamed from: a  reason: collision with root package name */
    private final int f4521a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f4522b;

    /* renamed from: c  reason: collision with root package name */
    private final int f4523c;

    /* renamed from: d  reason: collision with root package name */
    private final AtomicReferenceArray f4524d;

    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        public final int a(long j4) {
            if ((j4 & 2305843009213693952L) != 0) {
                return 2;
            }
            return 1;
        }

        public final long b(long j4, int i4) {
            return d(j4, 1073741823) | ((long) i4);
        }

        public final long c(long j4, int i4) {
            return d(j4, 1152921503533105152L) | (((long) i4) << 30);
        }

        public final long d(long j4, long j5) {
            return j4 & (~j5);
        }

        private a() {
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f4525a;

        public b(int i4) {
            this.f4525a = i4;
        }
    }

    static {
        Class<s> cls = s.class;
        f4518f = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "_next");
        f4519g = AtomicLongFieldUpdater.newUpdater(cls, "_state");
    }

    public s(int i4, boolean z4) {
        this.f4521a = i4;
        this.f4522b = z4;
        int i5 = i4 - 1;
        this.f4523c = i5;
        this.f4524d = new AtomicReferenceArray(i4);
        if (i5 > 1073741823) {
            throw new IllegalStateException("Check failed.");
        } else if ((i4 & i5) != 0) {
            throw new IllegalStateException("Check failed.");
        }
    }

    private final s b(long j4) {
        s sVar = new s(this.f4521a * 2, this.f4522b);
        int i4 = (int) (1073741823 & j4);
        int i5 = (int) ((1152921503533105152L & j4) >> 30);
        while (true) {
            int i6 = this.f4523c;
            if ((i4 & i6) != (i5 & i6)) {
                Object obj = this.f4524d.get(i6 & i4);
                if (obj == null) {
                    obj = new b(i4);
                }
                sVar.f4524d.set(sVar.f4523c & i4, obj);
                i4++;
            } else {
                f4519g.set(sVar, f4517e.d(j4, 1152921504606846976L));
                return sVar;
            }
        }
    }

    private final s c(long j4) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f4518f;
        while (true) {
            s sVar = (s) atomicReferenceFieldUpdater.get(this);
            if (sVar != null) {
                return sVar;
            }
            androidx.concurrent.futures.a.a(f4518f, this, (Object) null, b(j4));
        }
    }

    private final s e(int i4, Object obj) {
        Object obj2 = this.f4524d.get(this.f4523c & i4);
        if (!(obj2 instanceof b) || ((b) obj2).f4525a != i4) {
            return null;
        }
        this.f4524d.set(i4 & this.f4523c, obj);
        return this;
    }

    private final long h() {
        long j4;
        long j5;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f4519g;
        do {
            j4 = atomicLongFieldUpdater.get(this);
            if ((j4 & 1152921504606846976L) != 0) {
                return j4;
            }
            j5 = 1152921504606846976L | j4;
        } while (!atomicLongFieldUpdater.compareAndSet(this, j4, j5));
        return j5;
    }

    private final s k(int i4, int i5) {
        long j4;
        int i6;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f4519g;
        do {
            j4 = atomicLongFieldUpdater.get(this);
            i6 = (int) (1073741823 & j4);
            if ((1152921504606846976L & j4) != 0) {
                return i();
            }
        } while (!f4519g.compareAndSet(this, j4, f4517e.b(j4, i5)));
        this.f4524d.set(this.f4523c & i6, (Object) null);
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x006a A[LOOP:1: B:20:0x006a->B:23:0x007f, LOOP_START, PHI: r0 
      PHI: (r0v3 t3.s) = (r0v2 t3.s), (r0v5 t3.s) binds: [B:19:0x0062, B:23:0x007f] A[DONT_GENERATE, DONT_INLINE]] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(java.lang.Object r13) {
        /*
            r12 = this;
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = f4519g
        L_0x0002:
            long r3 = r0.get(r12)
            r1 = 3458764513820540928(0x3000000000000000, double:1.727233711018889E-77)
            long r1 = r1 & r3
            r7 = 0
            int r5 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r5 == 0) goto L_0x0016
            t3.s$a r13 = f4517e
            int r13 = r13.a(r3)
            return r13
        L_0x0016:
            r1 = 1073741823(0x3fffffff, double:5.304989472E-315)
            long r1 = r1 & r3
            int r2 = (int) r1
            r5 = 1152921503533105152(0xfffffffc0000000, double:1.2882296003504729E-231)
            long r5 = r5 & r3
            r1 = 30
            long r5 = r5 >> r1
            int r9 = (int) r5
            int r10 = r12.f4523c
            int r1 = r9 + 2
            r1 = r1 & r10
            r5 = r2 & r10
            r6 = 1
            if (r1 != r5) goto L_0x0030
            return r6
        L_0x0030:
            boolean r1 = r12.f4522b
            r5 = 1073741823(0x3fffffff, float:1.9999999)
            if (r1 != 0) goto L_0x004f
            java.util.concurrent.atomic.AtomicReferenceArray r1 = r12.f4524d
            r11 = r9 & r10
            java.lang.Object r1 = r1.get(r11)
            if (r1 == 0) goto L_0x004f
            int r1 = r12.f4521a
            r3 = 1024(0x400, float:1.435E-42)
            if (r1 < r3) goto L_0x004e
            int r9 = r9 - r2
            r2 = r9 & r5
            int r1 = r1 >> 1
            if (r2 <= r1) goto L_0x0002
        L_0x004e:
            return r6
        L_0x004f:
            int r1 = r9 + 1
            r1 = r1 & r5
            r2 = r1
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = f4519g
            t3.s$a r5 = f4517e
            long r5 = r5.c(r3, r2)
            r2 = r12
            boolean r1 = r1.compareAndSet(r2, r3, r5)
            if (r1 == 0) goto L_0x0002
            java.util.concurrent.atomic.AtomicReferenceArray r0 = r2.f4524d
            r1 = r9 & r10
            r0.set(r1, r13)
            r0 = r2
        L_0x006a:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = f4519g
            long r3 = r1.get(r0)
            r5 = 1152921504606846976(0x1000000000000000, double:1.2882297539194267E-231)
            long r3 = r3 & r5
            int r1 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r1 == 0) goto L_0x0081
            t3.s r0 = r0.i()
            t3.s r0 = r0.e(r9, r13)
            if (r0 != 0) goto L_0x006a
        L_0x0081:
            r13 = 0
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: t3.s.a(java.lang.Object):int");
    }

    public final boolean d() {
        long j4;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f4519g;
        do {
            j4 = atomicLongFieldUpdater.get(this);
            if ((j4 & 2305843009213693952L) != 0) {
                return true;
            }
            if ((1152921504606846976L & j4) != 0) {
                return false;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j4, 2305843009213693952L | j4));
        return true;
    }

    public final int f() {
        long j4 = f4519g.get(this);
        return 1073741823 & (((int) ((j4 & 1152921503533105152L) >> 30)) - ((int) (1073741823 & j4)));
    }

    public final boolean g() {
        long j4 = f4519g.get(this);
        if (((int) (1073741823 & j4)) == ((int) ((j4 & 1152921503533105152L) >> 30))) {
            return true;
        }
        return false;
    }

    public final s i() {
        return c(h());
    }

    public final Object j() {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f4519g;
        while (true) {
            long j4 = atomicLongFieldUpdater.get(this);
            if ((1152921504606846976L & j4) != 0) {
                return f4520h;
            }
            int i4 = (int) (1073741823 & j4);
            int i5 = (int) ((1152921503533105152L & j4) >> 30);
            int i6 = this.f4523c;
            if ((i5 & i6) == (i4 & i6)) {
                return null;
            }
            Object obj = this.f4524d.get(i6 & i4);
            if (obj == null) {
                if (this.f4522b) {
                    return null;
                }
            } else if (obj instanceof b) {
                return null;
            } else {
                int i7 = (i4 + 1) & 1073741823;
                if (f4519g.compareAndSet(this, j4, f4517e.b(j4, i7))) {
                    this.f4524d.set(this.f4523c & i4, (Object) null);
                    return obj;
                } else if (this.f4522b) {
                    s sVar = this;
                    do {
                        sVar = sVar.k(i4, i7);
                    } while (sVar != null);
                    return obj;
                }
            }
        }
    }
}
