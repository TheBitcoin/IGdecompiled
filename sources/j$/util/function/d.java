package j$.util.function;

import j$.com.android.tools.r8.a;
import java.util.function.IntConsumer;

public final /* synthetic */ class d implements IntConsumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IntConsumer f5208a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ IntConsumer f5209b;

    public /* synthetic */ d(IntConsumer intConsumer, IntConsumer intConsumer2) {
        this.f5208a = intConsumer;
        this.f5209b = intConsumer2;
    }

    public final /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
        return a.e(this, intConsumer);
    }

    public final void accept(int i4) {
        this.f5208a.accept(i4);
        this.f5209b.accept(i4);
    }
}
