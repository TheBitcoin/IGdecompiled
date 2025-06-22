package androidx.datastore.core.okio;

import R2.s;
import androidx.datastore.core.okio.OkioStorage;
import d3.a;
import kotlin.jvm.internal.n;

final class OkioStorage$createConnection$2 extends n implements a {
    final /* synthetic */ OkioStorage<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OkioStorage$createConnection$2(OkioStorage<T> okioStorage) {
        super(0);
        this.this$0 = okioStorage;
    }

    public final void invoke() {
        OkioStorage.Companion companion = OkioStorage.Companion;
        Synchronizer activeFilesLock = companion.getActiveFilesLock();
        OkioStorage<T> okioStorage = this.this$0;
        synchronized (activeFilesLock) {
            companion.getActiveFiles$datastore_core_okio().remove(okioStorage.getCanonicalPath().toString());
            s sVar = s.f8222a;
        }
    }
}
