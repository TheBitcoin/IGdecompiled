package j$.util.stream;

import j$.com.android.tools.r8.a;
import j$.util.function.Consumer$CC;
import java.util.function.Consumer;
import java.util.function.LongConsumer;

/* renamed from: j$.util.stream.k3  reason: case insensitive filesystem */
public final /* synthetic */ class C1198k3 implements C1182h2 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f5532a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LongConsumer f5533b;

    public /* synthetic */ C1198k3(LongConsumer longConsumer, int i4) {
        this.f5532a = i4;
        this.f5533b = longConsumer;
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
        switch (this.f5532a) {
            case 0:
                C1232t1.a();
                throw null;
            default:
                C1232t1.a();
                throw null;
        }
    }

    public final /* synthetic */ void accept(int i4) {
        switch (this.f5532a) {
            case 0:
                C1232t1.k();
                throw null;
            default:
                C1232t1.k();
                throw null;
        }
    }

    public final void accept(long j4) {
        switch (this.f5532a) {
            case 0:
                this.f5533b.accept(j4);
                return;
            default:
                ((P2) this.f5533b).accept(j4);
                return;
        }
    }

    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        switch (this.f5532a) {
            case 0:
                i((Long) obj);
                return;
            default:
                i((Long) obj);
                return;
        }
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        switch (this.f5532a) {
            case 0:
                return Consumer$CC.$default$andThen(this, consumer);
            default:
                return Consumer$CC.$default$andThen(this, consumer);
        }
    }

    public final /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
        switch (this.f5532a) {
            case 0:
                return a.f(this, longConsumer);
            default:
                return a.f(this, longConsumer);
        }
    }

    public final /* synthetic */ void i(Long l4) {
        switch (this.f5532a) {
            case 0:
                C1232t1.i(this, l4);
                return;
            default:
                C1232t1.i(this, l4);
                return;
        }
    }

    public final /* synthetic */ void j() {
        int i4 = this.f5532a;
    }

    public final /* synthetic */ void k(long j4) {
        int i4 = this.f5532a;
    }

    public final /* synthetic */ boolean m() {
        switch (this.f5532a) {
            case 0:
                return false;
            default:
                return false;
        }
    }
}
