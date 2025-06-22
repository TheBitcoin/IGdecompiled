package j$.util.stream;

import j$.com.android.tools.r8.a;
import j$.util.function.Consumer$CC;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

/* renamed from: j$.util.stream.g3  reason: case insensitive filesystem */
public final /* synthetic */ class C1178g3 implements C1172f2 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f5506a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DoubleConsumer f5507b;

    public /* synthetic */ C1178g3(DoubleConsumer doubleConsumer, int i4) {
        this.f5506a = i4;
        this.f5507b = doubleConsumer;
    }

    private final /* synthetic */ void b(long j4) {
    }

    private final /* synthetic */ void c(long j4) {
    }

    private final /* synthetic */ void d() {
    }

    private final /* synthetic */ void e() {
    }

    public final void accept(double d5) {
        switch (this.f5506a) {
            case 0:
                this.f5507b.accept(d5);
                return;
            default:
                ((L2) this.f5507b).accept(d5);
                return;
        }
    }

    public final /* synthetic */ void accept(int i4) {
        switch (this.f5506a) {
            case 0:
                C1232t1.k();
                throw null;
            default:
                C1232t1.k();
                throw null;
        }
    }

    public final /* synthetic */ void accept(long j4) {
        switch (this.f5506a) {
            case 0:
                C1232t1.l();
                throw null;
            default:
                C1232t1.l();
                throw null;
        }
    }

    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        switch (this.f5506a) {
            case 0:
                o((Double) obj);
                return;
            default:
                o((Double) obj);
                return;
        }
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        switch (this.f5506a) {
            case 0:
                return Consumer$CC.$default$andThen(this, consumer);
            default:
                return Consumer$CC.$default$andThen(this, consumer);
        }
    }

    public final /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        switch (this.f5506a) {
            case 0:
                return a.d(this, doubleConsumer);
            default:
                return a.d(this, doubleConsumer);
        }
    }

    public final /* synthetic */ void j() {
        int i4 = this.f5506a;
    }

    public final /* synthetic */ void k(long j4) {
        int i4 = this.f5506a;
    }

    public final /* synthetic */ boolean m() {
        switch (this.f5506a) {
            case 0:
                return false;
            default:
                return false;
        }
    }

    public final /* synthetic */ void o(Double d5) {
        switch (this.f5506a) {
            case 0:
                C1232t1.e(this, d5);
                return;
            default:
                C1232t1.e(this, d5);
                return;
        }
    }
}
