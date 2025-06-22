package j$.util.stream;

import j$.com.android.tools.r8.a;
import j$.util.function.Consumer$CC;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

/* renamed from: j$.util.stream.i3  reason: case insensitive filesystem */
public final /* synthetic */ class C1188i3 implements C1177g2 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f5518a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ IntConsumer f5519b;

    public /* synthetic */ C1188i3(IntConsumer intConsumer, int i4) {
        this.f5518a = i4;
        this.f5519b = intConsumer;
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
        switch (this.f5518a) {
            case 0:
                C1232t1.a();
                throw null;
            default:
                C1232t1.a();
                throw null;
        }
    }

    public final void accept(int i4) {
        switch (this.f5518a) {
            case 0:
                this.f5519b.accept(i4);
                return;
            default:
                ((N2) this.f5519b).accept(i4);
                return;
        }
    }

    public final /* synthetic */ void accept(long j4) {
        switch (this.f5518a) {
            case 0:
                C1232t1.l();
                throw null;
            default:
                C1232t1.l();
                throw null;
        }
    }

    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        switch (this.f5518a) {
            case 0:
                l((Integer) obj);
                return;
            default:
                l((Integer) obj);
                return;
        }
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        switch (this.f5518a) {
            case 0:
                return Consumer$CC.$default$andThen(this, consumer);
            default:
                return Consumer$CC.$default$andThen(this, consumer);
        }
    }

    public final /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
        switch (this.f5518a) {
            case 0:
                return a.e(this, intConsumer);
            default:
                return a.e(this, intConsumer);
        }
    }

    public final /* synthetic */ void j() {
        int i4 = this.f5518a;
    }

    public final /* synthetic */ void k(long j4) {
        int i4 = this.f5518a;
    }

    public final /* synthetic */ void l(Integer num) {
        switch (this.f5518a) {
            case 0:
                C1232t1.g(this, num);
                return;
            default:
                C1232t1.g(this, num);
                return;
        }
    }

    public final /* synthetic */ boolean m() {
        switch (this.f5518a) {
            case 0:
                return false;
            default:
                return false;
        }
    }
}
