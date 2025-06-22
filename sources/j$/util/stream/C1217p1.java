package j$.util.stream;

import j$.util.function.Consumer$CC;
import j$.util.i0;
import java.util.concurrent.CountedCompleter;
import java.util.function.Consumer;

/* renamed from: j$.util.stream.p1  reason: case insensitive filesystem */
public abstract class C1217p1 extends CountedCompleter implements C1187i2 {

    /* renamed from: a  reason: collision with root package name */
    public final i0 f5560a;

    /* renamed from: b  reason: collision with root package name */
    public final C1144a f5561b;

    /* renamed from: c  reason: collision with root package name */
    public final long f5562c;

    /* renamed from: d  reason: collision with root package name */
    public final long f5563d;

    /* renamed from: e  reason: collision with root package name */
    public final long f5564e;

    /* renamed from: f  reason: collision with root package name */
    public int f5565f;

    /* renamed from: g  reason: collision with root package name */
    public int f5566g;

    public /* synthetic */ void accept(double d5) {
        C1232t1.a();
        throw null;
    }

    public /* synthetic */ void accept(int i4) {
        C1232t1.k();
        throw null;
    }

    public /* synthetic */ void accept(long j4) {
        C1232t1.l();
        throw null;
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }

    public abstract C1217p1 b(i0 i0Var, long j4, long j5);

    public final /* synthetic */ void j() {
    }

    public final /* synthetic */ boolean m() {
        return false;
    }

    public C1217p1(i0 i0Var, C1144a aVar, int i4) {
        this.f5560a = i0Var;
        this.f5561b = aVar;
        this.f5562c = C1159d.e(i0Var.estimateSize());
        this.f5563d = 0;
        this.f5564e = (long) i4;
    }

    public C1217p1(C1217p1 p1Var, i0 i0Var, long j4, long j5, int i4) {
        super(p1Var);
        this.f5560a = i0Var;
        this.f5561b = p1Var.f5561b;
        this.f5562c = p1Var.f5562c;
        this.f5563d = j4;
        this.f5564e = j5;
        if (j4 < 0 || j5 < 0 || (j4 + j5) - 1 >= ((long) i4)) {
            throw new IllegalArgumentException(String.format("offset and length interval [%d, %d + %d) is not within array size interval [0, %d)", new Object[]{Long.valueOf(j4), Long.valueOf(j4), Long.valueOf(j5), Integer.valueOf(i4)}));
        }
    }

    public final void compute() {
        i0 trySplit;
        i0 i0Var = this.f5560a;
        C1217p1 p1Var = this;
        while (i0Var.estimateSize() > p1Var.f5562c && (trySplit = i0Var.trySplit()) != null) {
            p1Var.setPendingCount(1);
            long estimateSize = trySplit.estimateSize();
            C1217p1 p1Var2 = p1Var;
            p1Var2.b(trySplit, p1Var.f5563d, estimateSize).fork();
            p1Var = p1Var2.b(i0Var, p1Var2.f5563d + estimateSize, p1Var2.f5564e - estimateSize);
        }
        C1217p1 p1Var3 = p1Var;
        p1Var3.f5561b.N(i0Var, p1Var3);
        p1Var3.propagateCompletion();
    }

    public final void k(long j4) {
        long j5 = this.f5564e;
        if (j4 <= j5) {
            int i4 = (int) this.f5563d;
            this.f5565f = i4;
            this.f5566g = i4 + ((int) j5);
            return;
        }
        throw new IllegalStateException("size passed to Sink.begin exceeds array length");
    }
}
