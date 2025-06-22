package j$.util.stream;

import j$.util.i0;

public abstract class Y extends Z {

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f5444l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Y(C1144a aVar, int i4, int i5) {
        super(aVar, i4);
        this.f5444l = i5;
    }

    public final boolean I() {
        switch (this.f5444l) {
            case 0:
                return true;
            default:
                return false;
        }
    }

    public final IntStream sequential() {
        switch (this.f5444l) {
            case 0:
                this.f5458a.f5468k = false;
                return this;
            default:
                this.f5458a.f5468k = false;
                return this;
        }
    }

    public final IntStream parallel() {
        switch (this.f5444l) {
            case 0:
                this.f5458a.f5468k = true;
                return this;
            default:
                this.f5458a.f5468k = true;
                return this;
        }
    }

    public final C1174g unordered() {
        switch (this.f5444l) {
            case 0:
                if (!W2.ORDERED.n(this.f5463f)) {
                    return this;
                }
                return new C1230t(this, W2.f5433r, 2);
            default:
                if (!W2.ORDERED.n(this.f5463f)) {
                    return this;
                }
                return new C1230t(this, W2.f5433r, 2);
        }
    }

    public final /* bridge */ /* synthetic */ i0 spliterator() {
        switch (this.f5444l) {
            case 0:
                return spliterator();
            default:
                return spliterator();
        }
    }
}
