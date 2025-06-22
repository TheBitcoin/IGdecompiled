package j$.util.stream;

import j$.util.concurrent.ConcurrentHashMap;
import j$.util.i0;
import java.util.concurrent.CountedCompleter;

public final class Q extends CountedCompleter {

    /* renamed from: a  reason: collision with root package name */
    public final C1144a f5381a;

    /* renamed from: b  reason: collision with root package name */
    public i0 f5382b;

    /* renamed from: c  reason: collision with root package name */
    public final long f5383c;

    /* renamed from: d  reason: collision with root package name */
    public final ConcurrentHashMap f5384d;

    /* renamed from: e  reason: collision with root package name */
    public final P f5385e;

    /* renamed from: f  reason: collision with root package name */
    public final Q f5386f;

    /* renamed from: g  reason: collision with root package name */
    public E0 f5387g;

    public Q(C1144a aVar, i0 i0Var, P p4) {
        super((CountedCompleter) null);
        this.f5381a = aVar;
        this.f5382b = i0Var;
        this.f5383c = C1159d.e(i0Var.estimateSize());
        this.f5384d = new ConcurrentHashMap(Math.max(16, C1159d.f5483g << 1), 0.75f, 1);
        this.f5385e = p4;
        this.f5386f = null;
    }

    public Q(Q q4, i0 i0Var, Q q5) {
        super(q4);
        this.f5381a = q4.f5381a;
        this.f5382b = i0Var;
        this.f5383c = q4.f5383c;
        this.f5384d = q4.f5384d;
        this.f5385e = q4.f5385e;
        this.f5386f = q5;
    }

    public final void compute() {
        i0 trySplit;
        i0 i0Var = this.f5382b;
        long j4 = this.f5383c;
        boolean z4 = false;
        Q q4 = this;
        while (i0Var.estimateSize() > j4 && (trySplit = i0Var.trySplit()) != null) {
            Q q5 = new Q(q4, trySplit, q4.f5386f);
            Q q6 = new Q(q4, i0Var, q5);
            q4.addToPendingCount(1);
            q6.addToPendingCount(1);
            q4.f5384d.put(q5, q6);
            if (q4.f5386f != null) {
                q5.addToPendingCount(1);
                if (q4.f5384d.replace(q4.f5386f, q4, q5)) {
                    q4.addToPendingCount(-1);
                } else {
                    q5.addToPendingCount(-1);
                }
            }
            if (z4) {
                i0Var = trySplit;
                q4 = q5;
                q5 = q6;
            } else {
                q4 = q6;
            }
            z4 = !z4;
            q5.fork();
        }
        if (q4.getPendingCount() > 0) {
            C1211o oVar = new C1211o(15);
            C1144a aVar = q4.f5381a;
            C1243w0 F4 = aVar.F(aVar.C(i0Var), oVar);
            q4.f5381a.N(i0Var, F4);
            q4.f5387g = F4.a();
            q4.f5382b = null;
        }
        q4.tryComplete();
    }

    public final void onCompletion(CountedCompleter countedCompleter) {
        E0 e02 = this.f5387g;
        if (e02 != null) {
            e02.forEach(this.f5385e);
            this.f5387g = null;
        } else {
            i0 i0Var = this.f5382b;
            if (i0Var != null) {
                this.f5381a.N(i0Var, this.f5385e);
                this.f5382b = null;
            }
        }
        Q q4 = (Q) this.f5384d.remove(this);
        if (q4 != null) {
            q4.tryComplete();
        }
    }
}
