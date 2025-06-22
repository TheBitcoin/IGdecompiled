package j$.util.stream;

import j$.util.function.Consumer$CC;
import java.util.function.Consumer;

/* renamed from: j$.util.stream.d3  reason: case insensitive filesystem */
public final class C1163d3 extends C1168e3 implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final Object[] f5494b;

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }

    public C1163d3(int i4) {
        this.f5494b = new Object[i4];
    }

    public final void accept(Object obj) {
        int i4 = this.f5499a;
        this.f5499a = i4 + 1;
        this.f5494b[i4] = obj;
    }
}
