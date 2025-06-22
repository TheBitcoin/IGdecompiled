package j$.util.stream;

import j$.util.i0;
import java.util.concurrent.CountedCompleter;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: j$.util.stream.b  reason: case insensitive filesystem */
public abstract class C1149b extends C1159d {

    /* renamed from: h  reason: collision with root package name */
    public final AtomicReference f5471h;

    /* renamed from: i  reason: collision with root package name */
    public volatile boolean f5472i;

    public abstract Object h();

    public C1149b(C1144a aVar, i0 i0Var) {
        super(aVar, i0Var);
        this.f5471h = new AtomicReference((Object) null);
    }

    public C1149b(C1149b bVar, i0 i0Var) {
        super((C1159d) bVar, i0Var);
        this.f5471h = bVar.f5471h;
    }

    public final void compute() {
        Object obj;
        i0 trySplit;
        i0 i0Var = this.f5485b;
        long estimateSize = i0Var.estimateSize();
        long j4 = this.f5486c;
        if (j4 == 0) {
            j4 = C1159d.e(estimateSize);
            this.f5486c = j4;
        }
        AtomicReference atomicReference = this.f5471h;
        boolean z4 = false;
        C1149b bVar = this;
        while (true) {
            obj = atomicReference.get();
            if (obj != null) {
                break;
            }
            boolean z5 = bVar.f5472i;
            if (!z5) {
                CountedCompleter<?> completer = bVar.getCompleter();
                while (true) {
                    C1149b bVar2 = (C1149b) ((C1159d) completer);
                    if (z5 || bVar2 == null) {
                        break;
                    }
                    z5 = bVar2.f5472i;
                    completer = bVar2.getCompleter();
                }
            }
            if (z5) {
                obj = bVar.h();
                break;
            } else if (estimateSize <= j4 || (trySplit = i0Var.trySplit()) == null) {
                obj = bVar.a();
            } else {
                C1149b bVar3 = (C1149b) bVar.c(trySplit);
                bVar.f5487d = bVar3;
                C1149b bVar4 = (C1149b) bVar.c(i0Var);
                bVar.f5488e = bVar4;
                bVar.setPendingCount(1);
                if (z4) {
                    i0Var = trySplit;
                    bVar = bVar3;
                    bVar3 = bVar4;
                } else {
                    bVar = bVar4;
                }
                z4 = !z4;
                bVar3.fork();
                estimateSize = i0Var.estimateSize();
            }
        }
        obj = bVar.a();
        bVar.d(obj);
        bVar.tryComplete();
    }

    /* JADX WARNING: Removed duplicated region for block: B:4:0x000a A[LOOP:0: B:4:0x000a->B:7:0x0016, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void d(java.lang.Object r3) {
        /*
            r2 = this;
            boolean r0 = r2.b()
            if (r0 == 0) goto L_0x0019
            if (r3 == 0) goto L_0x0018
            java.util.concurrent.atomic.AtomicReference r0 = r2.f5471h
        L_0x000a:
            r1 = 0
            boolean r1 = r0.compareAndSet(r1, r3)
            if (r1 == 0) goto L_0x0012
            goto L_0x0018
        L_0x0012:
            java.lang.Object r1 = r0.get()
            if (r1 == 0) goto L_0x000a
        L_0x0018:
            return
        L_0x0019:
            r2.f5489f = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.stream.C1149b.d(java.lang.Object):void");
    }

    public final Object getRawResult() {
        return i();
    }

    public final Object i() {
        if (!b()) {
            return this.f5489f;
        }
        Object obj = this.f5471h.get();
        if (obj == null) {
            return h();
        }
        return obj;
    }

    public void f() {
        this.f5472i = true;
    }

    public final void g() {
        C1149b bVar = this;
        for (C1149b bVar2 = (C1149b) ((C1159d) getCompleter()); bVar2 != null; bVar2 = (C1149b) ((C1159d) bVar2.getCompleter())) {
            if (bVar2.f5487d == bVar) {
                C1149b bVar3 = (C1149b) bVar2.f5488e;
                if (!bVar3.f5472i) {
                    bVar3.f();
                }
            }
            bVar = bVar2;
        }
    }
}
