package androidx.datastore.core;

import R2.s;
import d3.l;
import kotlin.jvm.internal.n;

final class DataStoreImpl$writeActor$1 extends n implements l {
    final /* synthetic */ DataStoreImpl<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DataStoreImpl$writeActor$1(DataStoreImpl<T> dataStoreImpl) {
        super(1);
        this.this$0 = dataStoreImpl;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return s.f8222a;
    }

    public final void invoke(Throwable th) {
        if (th != null) {
            this.this$0.inMemoryCache.tryUpdate(new Final(th));
        }
        if (this.this$0.storageConnectionDelegate.isInitialized()) {
            this.this$0.getStorageConnection$datastore_core_release().close();
        }
    }
}
