package j$.util.stream;

import j$.com.android.tools.r8.a;
import java.util.function.IntConsumer;

/* renamed from: j$.util.stream.a3  reason: case insensitive filesystem */
public final class C1148a3 extends C1158c3 implements IntConsumer {

    /* renamed from: c  reason: collision with root package name */
    public final int[] f5470c;

    public final /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
        return a.e(this, intConsumer);
    }

    public C1148a3(int i4) {
        this.f5470c = new int[i4];
    }

    public final void b(Object obj, long j4) {
        IntConsumer intConsumer = (IntConsumer) obj;
        for (int i4 = 0; ((long) i4) < j4; i4++) {
            intConsumer.accept(this.f5470c[i4]);
        }
    }

    public final void accept(int i4) {
        int i5 = this.f5482b;
        this.f5482b = i5 + 1;
        this.f5470c[i5] = i4;
    }
}
