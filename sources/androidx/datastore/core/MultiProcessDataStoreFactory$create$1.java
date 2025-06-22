package androidx.datastore.core;

import d3.l;
import java.io.File;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;
import o3.J;

final class MultiProcessDataStoreFactory$create$1 extends n implements l {
    final /* synthetic */ J $scope;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MultiProcessDataStoreFactory$create$1(J j4) {
        super(1);
        this.$scope = j4;
    }

    public final InterProcessCoordinator invoke(File file) {
        m.e(file, "it");
        return new MultiProcessCoordinator(this.$scope.getCoroutineContext(), file);
    }
}
