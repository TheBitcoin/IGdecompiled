package j$.util.function;

import j$.com.android.tools.r8.a;
import java.util.function.LongConsumer;

public final /* synthetic */ class e implements LongConsumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LongConsumer f5210a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LongConsumer f5211b;

    public /* synthetic */ e(LongConsumer longConsumer, LongConsumer longConsumer2) {
        this.f5210a = longConsumer;
        this.f5211b = longConsumer2;
    }

    public final /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
        return a.f(this, longConsumer);
    }

    public final void accept(long j4) {
        this.f5210a.accept(j4);
        this.f5211b.accept(j4);
    }
}
