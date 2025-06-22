package j$.util.stream;

import j$.util.i0;

/* renamed from: j$.util.stream.g0  reason: case insensitive filesystem */
public abstract class C1175g0 extends C1180h0 {

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f5505l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C1175g0(C1144a aVar, int i4, int i5) {
        super(aVar, i4);
        this.f5505l = i5;
    }

    public final boolean I() {
        switch (this.f5505l) {
            case 0:
                return true;
            default:
                return false;
        }
    }

    public final C1195k0 sequential() {
        switch (this.f5505l) {
            case 0:
                this.f5458a.f5468k = false;
                return this;
            default:
                this.f5458a.f5468k = false;
                return this;
        }
    }

    public final C1195k0 parallel() {
        switch (this.f5505l) {
            case 0:
                this.f5458a.f5468k = true;
                return this;
            default:
                this.f5458a.f5468k = true;
                return this;
        }
    }

    public final C1174g unordered() {
        switch (this.f5505l) {
            case 0:
                if (!W2.ORDERED.n(this.f5463f)) {
                    return this;
                }
                return new C1234u(this, W2.f5433r, 4);
            default:
                if (!W2.ORDERED.n(this.f5463f)) {
                    return this;
                }
                return new C1234u(this, W2.f5433r, 4);
        }
    }

    public final /* bridge */ /* synthetic */ i0 spliterator() {
        switch (this.f5505l) {
            case 0:
                return spliterator();
            default:
                return spliterator();
        }
    }
}
