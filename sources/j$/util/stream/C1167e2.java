package j$.util.stream;

import j$.util.Objects;
import j$.util.function.Consumer$CC;
import java.util.function.Consumer;

/* renamed from: j$.util.stream.e2  reason: case insensitive filesystem */
public abstract class C1167e2 implements C1187i2 {

    /* renamed from: a  reason: collision with root package name */
    public final C1187i2 f5498a;

    public final /* synthetic */ void accept(double d5) {
        C1232t1.a();
        throw null;
    }

    public final /* synthetic */ void accept(int i4) {
        C1232t1.k();
        throw null;
    }

    public final /* synthetic */ void accept(long j4) {
        C1232t1.l();
        throw null;
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }

    public C1167e2(C1187i2 i2Var) {
        this.f5498a = (C1187i2) Objects.requireNonNull(i2Var);
    }

    public void k(long j4) {
        this.f5498a.k(j4);
    }

    public void j() {
        this.f5498a.j();
    }

    public boolean m() {
        return this.f5498a.m();
    }
}
