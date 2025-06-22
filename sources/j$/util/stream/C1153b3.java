package j$.util.stream;

import j$.com.android.tools.r8.a;
import java.util.function.LongConsumer;

/* renamed from: j$.util.stream.b3  reason: case insensitive filesystem */
public final class C1153b3 extends C1158c3 implements LongConsumer {

    /* renamed from: c  reason: collision with root package name */
    public final long[] f5476c;

    public final /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
        return a.f(this, longConsumer);
    }

    public C1153b3(int i4) {
        this.f5476c = new long[i4];
    }

    public final void b(Object obj, long j4) {
        LongConsumer longConsumer = (LongConsumer) obj;
        for (int i4 = 0; ((long) i4) < j4; i4++) {
            longConsumer.accept(this.f5476c[i4]);
        }
    }

    public final void accept(long j4) {
        int i4 = this.f5482b;
        this.f5482b = i4 + 1;
        this.f5476c[i4] = j4;
    }
}
