package x3;

import R2.s;
import d3.l;
import d3.p;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;
import o3.C0989m;
import o3.W0;
import q3.i;
import t3.C;
import t3.C1054d;
import t3.D;

public class d {

    /* renamed from: c  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f4696c;

    /* renamed from: d  reason: collision with root package name */
    private static final AtomicLongFieldUpdater f4697d;

    /* renamed from: e  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f4698e;

    /* renamed from: f  reason: collision with root package name */
    private static final AtomicLongFieldUpdater f4699f;

    /* renamed from: g  reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f4700g;
    private volatile int _availablePermits;

    /* renamed from: a  reason: collision with root package name */
    private final int f4701a;

    /* renamed from: b  reason: collision with root package name */
    private final l f4702b;
    private volatile long deqIdx;
    private volatile long enqIdx;
    private volatile Object head;
    private volatile Object tail;

    /* synthetic */ class a extends k implements p {

        /* renamed from: a  reason: collision with root package name */
        public static final a f4703a = new a();

        a() {
            super(2, e.class, "createSegment", "createSegment(JLkotlinx/coroutines/sync/SemaphoreSegment;)Lkotlinx/coroutines/sync/SemaphoreSegment;", 1);
        }

        public final f d(long j4, f fVar) {
            return e.h(j4, fVar);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return d(((Number) obj).longValue(), (f) obj2);
        }
    }

    static final class b extends n implements l {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f4704a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(d dVar) {
            super(1);
            this.f4704a = dVar;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return s.f8222a;
        }

        public final void invoke(Throwable th) {
            this.f4704a.j();
        }
    }

    /* synthetic */ class c extends k implements p {

        /* renamed from: a  reason: collision with root package name */
        public static final c f4705a = new c();

        c() {
            super(2, e.class, "createSegment", "createSegment(JLkotlinx/coroutines/sync/SemaphoreSegment;)Lkotlinx/coroutines/sync/SemaphoreSegment;", 1);
        }

        public final f d(long j4, f fVar) {
            return e.h(j4, fVar);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return d(((Number) obj).longValue(), (f) obj2);
        }
    }

    static {
        Class<d> cls = d.class;
        Class<Object> cls2 = Object.class;
        f4696c = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, TtmlNode.TAG_HEAD);
        f4697d = AtomicLongFieldUpdater.newUpdater(cls, "deqIdx");
        f4698e = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "tail");
        f4699f = AtomicLongFieldUpdater.newUpdater(cls, "enqIdx");
        f4700g = AtomicIntegerFieldUpdater.newUpdater(cls, "_availablePermits");
    }

    public d(int i4, int i5) {
        this.f4701a = i4;
        if (i4 <= 0) {
            throw new IllegalArgumentException(("Semaphore should have at least 1 permit, but had " + i4).toString());
        } else if (i5 < 0 || i5 > i4) {
            throw new IllegalArgumentException(("The number of acquired permits should be in 0.." + i4).toString());
        } else {
            f fVar = new f(0, (f) null, 2);
            this.head = fVar;
            this.tail = fVar;
            this._availablePermits = i4 - i5;
            this.f4702b = new b(this);
        }
    }

    private final boolean f(W0 w02) {
        Object c5;
        W0 w03 = w02;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f4698e;
        f fVar = (f) atomicReferenceFieldUpdater.get(this);
        long andIncrement = f4699f.getAndIncrement(this);
        a aVar = a.f4703a;
        long f4 = andIncrement / ((long) e.f4711f);
        loop0:
        while (true) {
            c5 = C1054d.c(fVar, f4, aVar);
            if (D.c(c5)) {
                break;
            }
            C b5 = D.b(c5);
            while (true) {
                C c6 = (C) atomicReferenceFieldUpdater.get(this);
                if (c6.f4463c >= b5.f4463c) {
                    break loop0;
                } else if (b5.q()) {
                    if (androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, c6, b5)) {
                        if (c6.m()) {
                            c6.k();
                        }
                    } else if (b5.m()) {
                        b5.k();
                    }
                }
            }
        }
        f fVar2 = (f) D.b(c5);
        int f5 = (int) (andIncrement % ((long) e.f4711f));
        if (i.a(fVar2.r(), f5, (Object) null, w03)) {
            w03.d(fVar2, f5);
            return true;
        }
        if (!i.a(fVar2.r(), f5, e.f4707b, e.f4708c)) {
            return false;
        }
        if (w03 instanceof C0989m) {
            m.c(w03, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
            ((C0989m) w03).c(s.f8222a, this.f4702b);
            return true;
        }
        throw new IllegalStateException(("unexpected: " + w03).toString());
    }

    /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    private final void g() {
        /*
            r3 = this;
        L_0x0000:
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = f4700g
            int r1 = r0.get(r3)
            int r2 = r3.f4701a
            if (r1 <= r2) goto L_0x0010
            boolean r0 = r0.compareAndSet(r3, r1, r2)
            if (r0 == 0) goto L_0x0000
        L_0x0010:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: x3.d.g():void");
    }

    private final int h() {
        int andDecrement;
        do {
            andDecrement = f4700g.getAndDecrement(this);
        } while (andDecrement > this.f4701a);
        return andDecrement;
    }

    private final boolean l(Object obj) {
        if (obj instanceof C0989m) {
            m.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
            C0989m mVar = (C0989m) obj;
            Object b5 = mVar.b(s.f8222a, (Object) null, this.f4702b);
            if (b5 == null) {
                return false;
            }
            mVar.D(b5);
            return true;
        }
        throw new IllegalStateException(("unexpected: " + obj).toString());
    }

    private final boolean m() {
        Object c5;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f4696c;
        f fVar = (f) atomicReferenceFieldUpdater.get(this);
        long andIncrement = f4697d.getAndIncrement(this);
        long f4 = andIncrement / ((long) e.f4711f);
        c cVar = c.f4705a;
        loop0:
        while (true) {
            c5 = C1054d.c(fVar, f4, cVar);
            if (D.c(c5)) {
                break;
            }
            C b5 = D.b(c5);
            while (true) {
                C c6 = (C) atomicReferenceFieldUpdater.get(this);
                if (c6.f4463c >= b5.f4463c) {
                    break loop0;
                } else if (b5.q()) {
                    if (androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, c6, b5)) {
                        if (c6.m()) {
                            c6.k();
                        }
                    } else if (b5.m()) {
                        b5.k();
                    }
                }
            }
        }
        f fVar2 = (f) D.b(c5);
        fVar2.b();
        if (fVar2.f4463c > f4) {
            return false;
        }
        int f5 = (int) (andIncrement % ((long) e.f4711f));
        Object andSet = fVar2.r().getAndSet(f5, e.f4707b);
        if (andSet == null) {
            int d5 = e.f4706a;
            for (int i4 = 0; i4 < d5; i4++) {
                if (fVar2.r().get(f5) == e.f4708c) {
                    return true;
                }
            }
            return !i.a(fVar2.r(), f5, e.f4707b, e.f4709d);
        } else if (andSet == e.f4710e) {
            return false;
        } else {
            return l(andSet);
        }
    }

    /* access modifiers changed from: protected */
    public final void e(C0989m mVar) {
        while (h() <= 0) {
            m.c(mVar, "null cannot be cast to non-null type kotlinx.coroutines.Waiter");
            if (f((W0) mVar)) {
                return;
            }
        }
        mVar.c(s.f8222a, this.f4702b);
    }

    public int i() {
        return Math.max(f4700g.get(this), 0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void j() {
        /*
            r3 = this;
        L_0x0000:
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = f4700g
            int r0 = r0.getAndIncrement(r3)
            int r1 = r3.f4701a
            if (r0 >= r1) goto L_0x0014
            if (r0 < 0) goto L_0x000d
            goto L_0x0013
        L_0x000d:
            boolean r0 = r3.m()
            if (r0 == 0) goto L_0x0000
        L_0x0013:
            return
        L_0x0014:
            r3.g()
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "The number of released permits cannot be greater than "
            r1.append(r2)
            int r2 = r3.f4701a
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: x3.d.j():void");
    }

    public boolean k() {
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f4700g;
            int i4 = atomicIntegerFieldUpdater.get(this);
            if (i4 > this.f4701a) {
                g();
            } else if (i4 <= 0) {
                return false;
            } else {
                if (atomicIntegerFieldUpdater.compareAndSet(this, i4, i4 - 1)) {
                    return true;
                }
            }
        }
    }
}
