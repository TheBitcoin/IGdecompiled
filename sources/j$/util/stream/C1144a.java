package j$.util.stream;

import j$.time.format.a;
import j$.time.format.r;
import j$.util.Objects;
import j$.util.i0;
import java.util.function.IntFunction;
import java.util.function.Supplier;

/* renamed from: j$.util.stream.a  reason: case insensitive filesystem */
public abstract class C1144a implements C1174g, AutoCloseable {

    /* renamed from: a  reason: collision with root package name */
    public final C1144a f5458a;

    /* renamed from: b  reason: collision with root package name */
    public final C1144a f5459b;

    /* renamed from: c  reason: collision with root package name */
    public final int f5460c;

    /* renamed from: d  reason: collision with root package name */
    public final C1144a f5461d;

    /* renamed from: e  reason: collision with root package name */
    public int f5462e;

    /* renamed from: f  reason: collision with root package name */
    public int f5463f;

    /* renamed from: g  reason: collision with root package name */
    public i0 f5464g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f5465h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f5466i;

    /* renamed from: j  reason: collision with root package name */
    public Runnable f5467j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f5468k;

    public abstract E0 B(C1144a aVar, i0 i0Var, boolean z4, IntFunction intFunction);

    public abstract boolean D(i0 i0Var, C1187i2 i2Var);

    public abstract X2 E();

    public abstract C1243w0 F(long j4, IntFunction intFunction);

    public abstract boolean I();

    public abstract C1187i2 J(int i4, C1187i2 i2Var);

    public abstract i0 M(C1144a aVar, Supplier supplier, boolean z4);

    public C1144a(i0 i0Var, int i4, boolean z4) {
        this.f5459b = null;
        this.f5464g = i0Var;
        this.f5458a = this;
        int i5 = W2.f5422g & i4;
        this.f5460c = i5;
        this.f5463f = (~(i5 << 1)) & W2.f5427l;
        this.f5462e = 0;
        this.f5468k = z4;
    }

    public C1144a(C1144a aVar, int i4) {
        if (!aVar.f5465h) {
            aVar.f5465h = true;
            aVar.f5461d = this;
            this.f5459b = aVar;
            this.f5460c = W2.f5423h & i4;
            this.f5463f = W2.j(i4, aVar.f5463f);
            C1144a aVar2 = aVar.f5458a;
            this.f5458a = aVar2;
            if (I()) {
                aVar2.f5466i = true;
            }
            this.f5462e = aVar.f5462e + 1;
            return;
        }
        throw new IllegalStateException("stream has already been operated upon or closed");
    }

    public final Object z(C3 c32) {
        if (!this.f5465h) {
            this.f5465h = true;
            if (this.f5458a.f5468k) {
                return c32.c(this, K(c32.d()));
            }
            return c32.b(this, K(c32.d()));
        }
        throw new IllegalStateException("stream has already been operated upon or closed");
    }

    public final E0 A(IntFunction intFunction) {
        C1144a aVar;
        if (!this.f5465h) {
            this.f5465h = true;
            if (!this.f5458a.f5468k || (aVar = this.f5459b) == null || !I()) {
                return y(K(0), true, intFunction);
            }
            this.f5462e = 0;
            return G(aVar, aVar.K(0), intFunction);
        }
        throw new IllegalStateException("stream has already been operated upon or closed");
    }

    public final i0 L() {
        C1144a aVar = this.f5458a;
        if (this != aVar) {
            throw new IllegalStateException();
        } else if (!this.f5465h) {
            this.f5465h = true;
            i0 i0Var = aVar.f5464g;
            if (i0Var != null) {
                aVar.f5464g = null;
                return i0Var;
            }
            throw new IllegalStateException("source already consumed or closed");
        } else {
            throw new IllegalStateException("stream has already been operated upon or closed");
        }
    }

    public final C1174g sequential() {
        this.f5458a.f5468k = false;
        return this;
    }

    public final C1174g parallel() {
        this.f5458a.f5468k = true;
        return this;
    }

    public final void close() {
        this.f5465h = true;
        this.f5464g = null;
        C1144a aVar = this.f5458a;
        Runnable runnable = aVar.f5467j;
        if (runnable != null) {
            aVar.f5467j = null;
            runnable.run();
        }
    }

    public final C1174g onClose(Runnable runnable) {
        if (!this.f5465h) {
            Objects.requireNonNull(runnable);
            C1144a aVar = this.f5458a;
            Runnable runnable2 = aVar.f5467j;
            if (runnable2 != null) {
                runnable = new B3(runnable2, runnable);
            }
            aVar.f5467j = runnable;
            return this;
        }
        throw new IllegalStateException("stream has already been operated upon or closed");
    }

    public i0 spliterator() {
        if (!this.f5465h) {
            this.f5465h = true;
            C1144a aVar = this.f5458a;
            if (this != aVar) {
                return M(this, new r(3, this), aVar.f5468k);
            }
            i0 i0Var = aVar.f5464g;
            if (i0Var != null) {
                aVar.f5464g = null;
                return i0Var;
            }
            throw new IllegalStateException("source already consumed or closed");
        }
        throw new IllegalStateException("stream has already been operated upon or closed");
    }

    public final boolean isParallel() {
        return this.f5458a.f5468k;
    }

    public final E0 y(i0 i0Var, boolean z4, IntFunction intFunction) {
        if (this.f5458a.f5468k) {
            return B(this, i0Var, z4, intFunction);
        }
        C1243w0 F4 = F(C(i0Var), intFunction);
        N(i0Var, F4);
        return F4.a();
    }

    public final i0 K(int i4) {
        int i5;
        int i6;
        C1144a aVar = this.f5458a;
        i0 i0Var = aVar.f5464g;
        if (i0Var != null) {
            aVar.f5464g = null;
            if (aVar.f5468k && aVar.f5466i) {
                C1144a aVar2 = aVar.f5461d;
                int i7 = 1;
                while (aVar != this) {
                    int i8 = aVar2.f5460c;
                    if (aVar2.I()) {
                        if (W2.SHORT_CIRCUIT.n(i8)) {
                            i8 &= ~W2.f5436u;
                        }
                        i0Var = aVar2.H(aVar, i0Var);
                        if (i0Var.hasCharacteristics(64)) {
                            i5 = (~W2.f5435t) & i8;
                            i6 = W2.f5434s;
                        } else {
                            i5 = (~W2.f5434s) & i8;
                            i6 = W2.f5435t;
                        }
                        i8 = i5 | i6;
                        i7 = 0;
                    }
                    int i9 = i7 + 1;
                    aVar2.f5462e = i7;
                    aVar2.f5463f = W2.j(i8, aVar.f5463f);
                    C1144a aVar3 = aVar2;
                    aVar2 = aVar2.f5461d;
                    aVar = aVar3;
                    i7 = i9;
                }
            }
            if (i4 != 0) {
                this.f5463f = W2.j(i4, this.f5463f);
            }
            return i0Var;
        }
        throw new IllegalStateException("source already consumed or closed");
    }

    public final long C(i0 i0Var) {
        if (W2.SIZED.n(this.f5463f)) {
            return i0Var.getExactSizeIfKnown();
        }
        return -1;
    }

    public final C1187i2 N(i0 i0Var, C1187i2 i2Var) {
        w(i0Var, O((C1187i2) Objects.requireNonNull(i2Var)));
        return i2Var;
    }

    public final void w(i0 i0Var, C1187i2 i2Var) {
        Objects.requireNonNull(i2Var);
        if (!W2.SHORT_CIRCUIT.n(this.f5463f)) {
            i2Var.k(i0Var.getExactSizeIfKnown());
            i0Var.forEachRemaining(i2Var);
            i2Var.j();
            return;
        }
        x(i0Var, i2Var);
    }

    public final boolean x(i0 i0Var, C1187i2 i2Var) {
        C1144a aVar = this;
        while (aVar.f5462e > 0) {
            aVar = aVar.f5459b;
        }
        i2Var.k(i0Var.getExactSizeIfKnown());
        boolean D4 = aVar.D(i0Var, i2Var);
        i2Var.j();
        return D4;
    }

    public final C1187i2 O(C1187i2 i2Var) {
        Objects.requireNonNull(i2Var);
        C1144a aVar = this;
        while (aVar.f5462e > 0) {
            C1144a aVar2 = aVar.f5459b;
            i2Var = aVar.J(aVar2.f5463f, i2Var);
            aVar = aVar2;
        }
        return i2Var;
    }

    public final i0 P(i0 i0Var) {
        if (this.f5462e == 0) {
            return i0Var;
        }
        return M(this, new r(4, i0Var), this.f5458a.f5468k);
    }

    public E0 G(C1144a aVar, i0 i0Var, IntFunction intFunction) {
        throw new UnsupportedOperationException("Parallel evaluation is not supported");
    }

    public i0 H(C1144a aVar, i0 i0Var) {
        return G(aVar, i0Var, new a(8)).spliterator();
    }
}
