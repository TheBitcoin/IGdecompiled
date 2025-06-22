package androidx.datastore.core;

import d3.a;
import kotlin.jvm.internal.n;

final class DataStoreImpl$storageConnectionDelegate$1 extends n implements a {
    final /* synthetic */ DataStoreImpl<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DataStoreImpl$storageConnectionDelegate$1(DataStoreImpl<T> dataStoreImpl) {
        super(0);
        this.this$0 = dataStoreImpl;
    }

    public final StorageConnection<T> invoke() {
        return this.this$0.storage.createConnection();
    }
}
