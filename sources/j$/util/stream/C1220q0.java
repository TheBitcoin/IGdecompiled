package j$.util.stream;

import j$.util.function.Consumer$CC;
import java.util.function.Consumer;

/* renamed from: j$.util.stream.q0  reason: case insensitive filesystem */
public abstract class C1220q0 implements C1187i2 {

    /* renamed from: a  reason: collision with root package name */
    public boolean f5572a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f5573b;

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

    public final /* synthetic */ void j() {
    }

    public final /* synthetic */ void k(long j4) {
    }

    public C1220q0(C1223r0 r0Var) {
        this.f5573b = !r0Var.f5580b;
    }

    public final boolean m() {
        return this.f5572a;
    }
}
