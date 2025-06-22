package j$.util.stream;

import j$.util.C1127b;
import j$.util.i0;
import java.util.Comparator;
import java.util.function.BooleanSupplier;
import java.util.function.Supplier;

public abstract class Y2 implements i0 {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f5445a;

    /* renamed from: b  reason: collision with root package name */
    public final C1144a f5446b;

    /* renamed from: c  reason: collision with root package name */
    public Supplier f5447c;

    /* renamed from: d  reason: collision with root package name */
    public i0 f5448d;

    /* renamed from: e  reason: collision with root package name */
    public C1187i2 f5449e;

    /* renamed from: f  reason: collision with root package name */
    public BooleanSupplier f5450f;

    /* renamed from: g  reason: collision with root package name */
    public long f5451g;

    /* renamed from: h  reason: collision with root package name */
    public C1154c f5452h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f5453i;

    public abstract void d();

    public abstract Y2 e(i0 i0Var);

    public final /* synthetic */ boolean hasCharacteristics(int i4) {
        return C1127b.e(this, i4);
    }

    public Y2(C1144a aVar, Supplier supplier, boolean z4) {
        this.f5446b = aVar;
        this.f5447c = supplier;
        this.f5448d = null;
        this.f5445a = z4;
    }

    public Y2(C1144a aVar, i0 i0Var, boolean z4) {
        this.f5446b = aVar;
        this.f5447c = null;
        this.f5448d = i0Var;
        this.f5445a = z4;
    }

    public final void c() {
        if (this.f5448d == null) {
            this.f5448d = (i0) this.f5447c.get();
            this.f5447c = null;
        }
    }

    public final boolean a() {
        C1154c cVar = this.f5452h;
        boolean z4 = false;
        if (cVar != null) {
            long j4 = this.f5451g + 1;
            this.f5451g = j4;
            if (j4 < cVar.count()) {
                z4 = true;
            }
            if (z4) {
                return z4;
            }
            this.f5451g = 0;
            this.f5452h.clear();
            return b();
        } else if (this.f5453i) {
            return false;
        } else {
            c();
            d();
            this.f5451g = 0;
            this.f5449e.k(this.f5448d.getExactSizeIfKnown());
            return b();
        }
    }

    public i0 trySplit() {
        if (!this.f5445a || this.f5452h != null || this.f5453i) {
            return null;
        }
        c();
        i0 trySplit = this.f5448d.trySplit();
        if (trySplit == null) {
            return null;
        }
        return e(trySplit);
    }

    public final boolean b() {
        while (this.f5452h.count() == 0) {
            if (this.f5449e.m() || !this.f5450f.getAsBoolean()) {
                if (this.f5453i) {
                    return false;
                }
                this.f5449e.j();
                this.f5453i = true;
            }
        }
        return true;
    }

    public final long estimateSize() {
        c();
        return this.f5448d.estimateSize();
    }

    public final long getExactSizeIfKnown() {
        c();
        if (W2.SIZED.n(this.f5446b.f5463f)) {
            return this.f5448d.getExactSizeIfKnown();
        }
        return -1;
    }

    public final int characteristics() {
        c();
        int i4 = this.f5446b.f5463f;
        int i5 = i4 & ((~i4) >> 1) & W2.f5425j & W2.f5421f;
        return (i5 & 64) != 0 ? (i5 & -16449) | (this.f5448d.characteristics() & 16448) : i5;
    }

    public final Comparator getComparator() {
        if (C1127b.e(this, 4)) {
            return null;
        }
        throw new IllegalStateException();
    }

    public final String toString() {
        return String.format("%s[%s]", new Object[]{getClass().getName(), this.f5448d});
    }
}
