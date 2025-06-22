package j$.util.stream;

import j$.util.i0;
import java.util.concurrent.CountedCompleter;
import java.util.concurrent.ForkJoinPool;

/* renamed from: j$.util.stream.d  reason: case insensitive filesystem */
public abstract class C1159d extends CountedCompleter {

    /* renamed from: g  reason: collision with root package name */
    public static final int f5483g = (ForkJoinPool.getCommonPoolParallelism() << 2);

    /* renamed from: a  reason: collision with root package name */
    public final C1144a f5484a;

    /* renamed from: b  reason: collision with root package name */
    public i0 f5485b;

    /* renamed from: c  reason: collision with root package name */
    public long f5486c;

    /* renamed from: d  reason: collision with root package name */
    public C1159d f5487d;

    /* renamed from: e  reason: collision with root package name */
    public C1159d f5488e;

    /* renamed from: f  reason: collision with root package name */
    public Object f5489f;

    public abstract Object a();

    public abstract C1159d c(i0 i0Var);

    public C1159d(C1144a aVar, i0 i0Var) {
        super((CountedCompleter) null);
        this.f5484a = aVar;
        this.f5485b = i0Var;
        this.f5486c = 0;
    }

    public C1159d(C1159d dVar, i0 i0Var) {
        super(dVar);
        this.f5485b = i0Var;
        this.f5484a = dVar.f5484a;
        this.f5486c = dVar.f5486c;
    }

    public static long e(long j4) {
        long j5 = j4 / ((long) f5483g);
        if (j5 > 0) {
            return j5;
        }
        return 1;
    }

    public Object getRawResult() {
        return this.f5489f;
    }

    public final void setRawResult(Object obj) {
        if (obj != null) {
            throw new IllegalStateException();
        }
    }

    public void d(Object obj) {
        this.f5489f = obj;
    }

    public final boolean b() {
        return ((C1159d) getCompleter()) == null;
    }

    public void compute() {
        i0 trySplit;
        i0 i0Var = this.f5485b;
        long estimateSize = i0Var.estimateSize();
        long j4 = this.f5486c;
        if (j4 == 0) {
            j4 = e(estimateSize);
            this.f5486c = j4;
        }
        boolean z4 = false;
        C1159d dVar = this;
        while (estimateSize > j4 && (trySplit = i0Var.trySplit()) != null) {
            C1159d c5 = dVar.c(trySplit);
            dVar.f5487d = c5;
            C1159d c6 = dVar.c(i0Var);
            dVar.f5488e = c6;
            dVar.setPendingCount(1);
            if (z4) {
                i0Var = trySplit;
                dVar = c5;
                c5 = c6;
            } else {
                dVar = c6;
            }
            z4 = !z4;
            c5.fork();
            estimateSize = i0Var.estimateSize();
        }
        dVar.d(dVar.a());
        dVar.tryComplete();
    }

    public void onCompletion(CountedCompleter countedCompleter) {
        this.f5485b = null;
        this.f5488e = null;
        this.f5487d = null;
    }
}
