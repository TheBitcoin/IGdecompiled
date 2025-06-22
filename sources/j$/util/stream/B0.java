package j$.util.stream;

import j$.com.android.tools.r8.a;
import java.util.function.LongConsumer;

public final /* synthetic */ class B0 implements LongConsumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f5255a;

    public /* synthetic */ B0(int i4) {
        this.f5255a = i4;
    }

    private final void accept$j$$util$stream$Node$OfLong$$ExternalSyntheticLambda0(long j4) {
    }

    private final void accept$j$$util$stream$StreamSpliterators$SliceSpliterator$OfLong$$ExternalSyntheticLambda0(long j4) {
    }

    public final void accept(long j4) {
        int i4 = this.f5255a;
    }

    public final /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
        switch (this.f5255a) {
            case 0:
                return a.f(this, longConsumer);
            default:
                return a.f(this, longConsumer);
        }
    }
}
