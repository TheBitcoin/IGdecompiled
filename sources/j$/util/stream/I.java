package j$.util.stream;

import j$.util.function.Consumer$CC;
import java.util.function.Consumer;

public abstract class I implements D3 {

    /* renamed from: a  reason: collision with root package name */
    public boolean f5320a;

    /* renamed from: b  reason: collision with root package name */
    public Object f5321b;

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

    /* renamed from: accept */
    public final void o(Object obj) {
        if (!this.f5320a) {
            this.f5320a = true;
            this.f5321b = obj;
        }
    }

    public final boolean m() {
        return this.f5320a;
    }
}
