package j$.util;

import j$.com.android.tools.r8.a;
import j$.util.stream.C1187i2;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

public final /* synthetic */ class F implements DoubleConsumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f5096a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Consumer f5097b;

    public /* synthetic */ F(Consumer consumer, int i4) {
        this.f5096a = i4;
        this.f5097b = consumer;
    }

    public final void accept(double d5) {
        switch (this.f5096a) {
            case 0:
                this.f5097b.accept(Double.valueOf(d5));
                return;
            default:
                ((C1187i2) this.f5097b).accept(d5);
                return;
        }
    }

    public final /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        switch (this.f5096a) {
            case 0:
                return a.d(this, doubleConsumer);
            default:
                return a.d(this, doubleConsumer);
        }
    }
}
