package androidx.datastore.core;

import R2.s;
import d3.l;
import d3.p;
import kotlin.jvm.internal.m;
import o3.C1001s0;
import o3.J;
import o3.L;
import q3.a;
import q3.d;
import q3.g;
import q3.h;
import q3.o;

public final class SimpleActor<T> {
    /* access modifiers changed from: private */
    public final p consumeMessage;
    /* access modifiers changed from: private */
    public final d messageQueue = g.b(Integer.MAX_VALUE, (a) null, (l) null, 6, (Object) null);
    /* access modifiers changed from: private */
    public final AtomicInt remainingMessages = new AtomicInt(0);
    /* access modifiers changed from: private */
    public final J scope;

    public SimpleActor(J j4, final l lVar, final p pVar, p pVar2) {
        m.e(j4, "scope");
        m.e(lVar, "onComplete");
        m.e(pVar, "onUndeliveredElement");
        m.e(pVar2, "consumeMessage");
        this.scope = j4;
        this.consumeMessage = pVar2;
        C1001s0 s0Var = (C1001s0) j4.getCoroutineContext().get(C1001s0.f3726k0);
        if (s0Var != null) {
            s0Var.i(new l() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Throwable) obj);
                    return s.f8222a;
                }

                public final void invoke(Throwable th) {
                    s sVar;
                    lVar.invoke(th);
                    this.messageQueue.s(th);
                    do {
                        Object f4 = h.f(this.messageQueue.h());
                        if (f4 != null) {
                            pVar.invoke(f4, th);
                            sVar = s.f8222a;
                            continue;
                        } else {
                            sVar = null;
                            continue;
                        }
                    } while (sVar != null);
                }
            });
        }
    }

    public final void offer(T t4) {
        Object B4 = this.messageQueue.B(t4);
        if (B4 instanceof h.a) {
            Throwable e5 = h.e(B4);
            if (e5 == null) {
                e5 = new o("Channel was closed normally");
            }
            throw e5;
        } else if (!h.i(B4)) {
            throw new IllegalStateException("Check failed.");
        } else if (this.remainingMessages.getAndIncrement() == 0) {
            C1001s0 unused = C0981i.d(this.scope, (V2.g) null, (L) null, new SimpleActor$offer$2(this, (V2.d) null), 3, (Object) null);
        }
    }
}
