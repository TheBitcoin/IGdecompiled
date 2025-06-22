package androidx.room;

import V2.e;
import V2.g;
import androidx.annotation.RestrictTo;
import d3.p;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import o3.C1001s0;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class TransactionElement implements g.b {
    public static final Key Key = new Key((C2103g) null);
    private final AtomicInteger referenceCount = new AtomicInteger(0);
    private final e transactionDispatcher;
    private final C1001s0 transactionThreadControlJob;

    public static final class Key implements g.c {
        public /* synthetic */ Key(C2103g gVar) {
            this();
        }

        private Key() {
        }
    }

    public TransactionElement(C1001s0 s0Var, e eVar) {
        m.e(s0Var, "transactionThreadControlJob");
        m.e(eVar, "transactionDispatcher");
        this.transactionThreadControlJob = s0Var;
        this.transactionDispatcher = eVar;
    }

    public final void acquire() {
        this.referenceCount.incrementAndGet();
    }

    public <R> R fold(R r4, p pVar) {
        return g.b.a.a(this, r4, pVar);
    }

    public <E extends g.b> E get(g.c cVar) {
        return g.b.a.b(this, cVar);
    }

    public g.c getKey() {
        return Key;
    }

    public final e getTransactionDispatcher$room_ktx_release() {
        return this.transactionDispatcher;
    }

    public g minusKey(g.c cVar) {
        return g.b.a.c(this, cVar);
    }

    public g plus(g gVar) {
        return g.b.a.d(this, gVar);
    }

    public final void release() {
        int decrementAndGet = this.referenceCount.decrementAndGet();
        if (decrementAndGet < 0) {
            throw new IllegalStateException("Transaction was never started or was already released.");
        } else if (decrementAndGet == 0) {
            C1001s0.a.a(this.transactionThreadControlJob, (CancellationException) null, 1, (Object) null);
        }
    }
}
