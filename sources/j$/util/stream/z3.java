package j$.util.stream;

import j$.util.function.Consumer$CC;
import java.util.function.Consumer;

public final /* synthetic */ class z3 implements C1187i2 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f5651a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Consumer f5652b;

    public /* synthetic */ z3(Consumer consumer, int i4) {
        this.f5651a = i4;
        this.f5652b = consumer;
    }

    private final /* synthetic */ void b(long j4) {
    }

    private final /* synthetic */ void c(long j4) {
    }

    private final /* synthetic */ void d() {
    }

    private final /* synthetic */ void e() {
    }

    public final /* synthetic */ void accept(double d5) {
        switch (this.f5651a) {
            case 0:
                C1232t1.a();
                throw null;
            default:
                C1232t1.a();
                throw null;
        }
    }

    public final /* synthetic */ void accept(int i4) {
        switch (this.f5651a) {
            case 0:
                C1232t1.k();
                throw null;
            default:
                C1232t1.k();
                throw null;
        }
    }

    public final /* synthetic */ void accept(long j4) {
        switch (this.f5651a) {
            case 0:
                C1232t1.l();
                throw null;
            default:
                C1232t1.l();
                throw null;
        }
    }

    public final void accept(Object obj) {
        switch (this.f5651a) {
            case 0:
                ((S2) this.f5652b).accept(obj);
                return;
            default:
                this.f5652b.accept(obj);
                return;
        }
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        switch (this.f5651a) {
            case 0:
                return Consumer$CC.$default$andThen(this, consumer);
            default:
                return Consumer$CC.$default$andThen(this, consumer);
        }
    }

    public final /* synthetic */ void j() {
        int i4 = this.f5651a;
    }

    public final /* synthetic */ void k(long j4) {
        int i4 = this.f5651a;
    }

    public final /* synthetic */ boolean m() {
        switch (this.f5651a) {
            case 0:
                return false;
            default:
                return false;
        }
    }
}
