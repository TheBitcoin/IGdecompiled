package androidx.datastore.core.okio;

import N3.Q;
import d3.a;
import kotlin.jvm.internal.n;

final class OkioStorage$canonicalPath$2 extends n implements a {
    final /* synthetic */ OkioStorage<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OkioStorage$canonicalPath$2(OkioStorage<T> okioStorage) {
        super(0);
        this.this$0 = okioStorage;
    }

    public final Q invoke() {
        Q q4 = (Q) this.this$0.producePath.invoke();
        boolean e5 = q4.e();
        OkioStorage<T> okioStorage = this.this$0;
        if (e5) {
            return q4.h();
        }
        throw new IllegalStateException(("OkioStorage requires absolute paths, but did not get an absolute path from producePath = " + okioStorage.producePath + ", instead got " + q4).toString());
    }
}
