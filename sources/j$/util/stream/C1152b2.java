package j$.util.stream;

import j$.com.android.tools.r8.a;
import j$.util.Objects;
import j$.util.function.Consumer$CC;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

/* renamed from: j$.util.stream.b2  reason: case insensitive filesystem */
public abstract class C1152b2 implements C1172f2 {

    /* renamed from: a  reason: collision with root package name */
    public final C1187i2 f5475a;

    public final /* synthetic */ void accept(int i4) {
        C1232t1.k();
        throw null;
    }

    public final /* synthetic */ void accept(long j4) {
        C1232t1.l();
        throw null;
    }

    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        o((Double) obj);
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }

    public final /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        return a.d(this, doubleConsumer);
    }

    public final /* synthetic */ void o(Double d5) {
        C1232t1.e(this, d5);
    }

    public C1152b2(C1187i2 i2Var) {
        this.f5475a = (C1187i2) Objects.requireNonNull(i2Var);
    }

    public void k(long j4) {
        this.f5475a.k(j4);
    }

    public void j() {
        this.f5475a.j();
    }

    public boolean m() {
        return this.f5475a.m();
    }
}
