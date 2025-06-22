package j$.util;

import j$.com.android.tools.r8.a;
import j$.util.stream.C1187i2;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

public final /* synthetic */ class J implements IntConsumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f5100a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Consumer f5101b;

    public /* synthetic */ J(Consumer consumer, int i4) {
        this.f5100a = i4;
        this.f5101b = consumer;
    }

    public final void accept(int i4) {
        switch (this.f5100a) {
            case 0:
                this.f5101b.accept(Integer.valueOf(i4));
                return;
            default:
                ((C1187i2) this.f5101b).accept(i4);
                return;
        }
    }

    public final /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
        switch (this.f5100a) {
            case 0:
                return a.e(this, intConsumer);
            default:
                return a.e(this, intConsumer);
        }
    }
}
