package j$.util.stream;

import j$.com.android.tools.r8.a;
import j$.util.Objects;
import j$.util.function.Consumer$CC;
import java.util.function.Consumer;
import java.util.function.LongConsumer;

/* renamed from: j$.util.stream.d2  reason: case insensitive filesystem */
public abstract class C1162d2 implements C1182h2 {

    /* renamed from: a  reason: collision with root package name */
    public final C1187i2 f5493a;

    public final /* synthetic */ void accept(double d5) {
        C1232t1.a();
        throw null;
    }

    public final /* synthetic */ void accept(int i4) {
        C1232t1.k();
        throw null;
    }

    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        i((Long) obj);
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }

    public final /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
        return a.f(this, longConsumer);
    }

    public final /* synthetic */ void i(Long l4) {
        C1232t1.i(this, l4);
    }

    public C1162d2(C1187i2 i2Var) {
        this.f5493a = (C1187i2) Objects.requireNonNull(i2Var);
    }

    public void k(long j4) {
        this.f5493a.k(j4);
    }

    public void j() {
        this.f5493a.j();
    }

    public boolean m() {
        return this.f5493a.m();
    }
}
