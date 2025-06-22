package j$.util.stream;

import j$.util.i0;
import java.util.concurrent.CountedCompleter;

public final class S extends CountedCompleter {

    /* renamed from: a  reason: collision with root package name */
    public i0 f5398a;

    /* renamed from: b  reason: collision with root package name */
    public final C1187i2 f5399b;

    /* renamed from: c  reason: collision with root package name */
    public final C1144a f5400c;

    /* renamed from: d  reason: collision with root package name */
    public long f5401d;

    public S(C1144a aVar, i0 i0Var, C1187i2 i2Var) {
        super((CountedCompleter) null);
        this.f5399b = i2Var;
        this.f5400c = aVar;
        this.f5398a = i0Var;
        this.f5401d = 0;
    }

    public S(S s4, i0 i0Var) {
        super(s4);
        this.f5398a = i0Var;
        this.f5399b = s4.f5399b;
        this.f5401d = s4.f5401d;
        this.f5400c = s4.f5400c;
    }

    public final void compute() {
        i0 trySplit;
        i0 i0Var = this.f5398a;
        long estimateSize = i0Var.estimateSize();
        long j4 = this.f5401d;
        if (j4 == 0) {
            j4 = C1159d.e(estimateSize);
            this.f5401d = j4;
        }
        boolean n4 = W2.SHORT_CIRCUIT.n(this.f5400c.f5463f);
        C1187i2 i2Var = this.f5399b;
        boolean z4 = false;
        S s4 = this;
        while (true) {
            if (n4 && i2Var.m()) {
                break;
            } else if (estimateSize <= j4 || (trySplit = i0Var.trySplit()) == null) {
                s4.f5400c.w(i0Var, i2Var);
            } else {
                S s5 = new S(s4, trySplit);
                s4.addToPendingCount(1);
                if (z4) {
                    i0Var = trySplit;
                } else {
                    S s6 = s4;
                    s4 = s5;
                    s5 = s6;
                }
                z4 = !z4;
                s4.fork();
                s4 = s5;
                estimateSize = i0Var.estimateSize();
            }
        }
        s4.f5400c.w(i0Var, i2Var);
        s4.f5398a = null;
        s4.propagateCompletion();
    }
}
