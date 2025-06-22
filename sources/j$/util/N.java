package j$.util;

import j$.com.android.tools.r8.a;
import j$.util.stream.C1187i2;
import java.util.function.Consumer;
import java.util.function.LongConsumer;

public final /* synthetic */ class N implements LongConsumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f5104a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Consumer f5105b;

    public /* synthetic */ N(Consumer consumer, int i4) {
        this.f5104a = i4;
        this.f5105b = consumer;
    }

    public final void accept(long j4) {
        switch (this.f5104a) {
            case 0:
                this.f5105b.accept(Long.valueOf(j4));
                return;
            default:
                ((C1187i2) this.f5105b).accept(j4);
                return;
        }
    }

    public final /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
        switch (this.f5104a) {
            case 0:
                return a.f(this, longConsumer);
            default:
                return a.f(this, longConsumer);
        }
    }
}
