package j$.util.stream;

import j$.com.android.tools.r8.a;
import j$.util.Objects;
import j$.util.function.Consumer$CC;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

/* renamed from: j$.util.stream.c2  reason: case insensitive filesystem */
public abstract class C1157c2 implements C1177g2 {

    /* renamed from: a  reason: collision with root package name */
    public final C1187i2 f5481a;

    public final /* synthetic */ void accept(double d5) {
        C1232t1.a();
        throw null;
    }

    public final /* synthetic */ void accept(long j4) {
        C1232t1.l();
        throw null;
    }

    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        l((Integer) obj);
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }

    public final /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
        return a.e(this, intConsumer);
    }

    public final /* synthetic */ void l(Integer num) {
        C1232t1.g(this, num);
    }

    public C1157c2(C1187i2 i2Var) {
        this.f5481a = (C1187i2) Objects.requireNonNull(i2Var);
    }

    public void k(long j4) {
        this.f5481a.k(j4);
    }

    public void j() {
        this.f5481a.j();
    }

    public boolean m() {
        return this.f5481a.m();
    }
}
