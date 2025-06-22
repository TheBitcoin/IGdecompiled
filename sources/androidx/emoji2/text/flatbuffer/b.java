package androidx.emoji2.text.flatbuffer;

import java.util.function.Supplier;

public final /* synthetic */ class b extends ThreadLocal {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Supplier f944a;

    public /* synthetic */ b(Supplier supplier) {
        this.f944a = supplier;
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ Object initialValue() {
        return this.f944a.get();
    }
}
