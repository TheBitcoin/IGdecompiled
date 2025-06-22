package androidx.datastore.core;

import androidx.datastore.core.SharedCounter;
import d3.a;
import java.io.File;
import kotlin.jvm.internal.n;

final class MultiProcessCoordinator$lazySharedCounter$1 extends n implements a {
    final /* synthetic */ MultiProcessCoordinator this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MultiProcessCoordinator$lazySharedCounter$1(MultiProcessCoordinator multiProcessCoordinator) {
        super(0);
        this.this$0 = multiProcessCoordinator;
    }

    public final SharedCounter invoke() {
        SharedCounter.Factory factory = SharedCounter.Factory;
        factory.loadLib();
        final MultiProcessCoordinator multiProcessCoordinator = this.this$0;
        return factory.create$datastore_core_release(new a() {
            public final File invoke() {
                MultiProcessCoordinator multiProcessCoordinator = multiProcessCoordinator;
                File access$fileWithSuffix = multiProcessCoordinator.fileWithSuffix(multiProcessCoordinator.VERSION_SUFFIX);
                multiProcessCoordinator.createIfNotExists(access$fileWithSuffix);
                return access$fileWithSuffix;
            }
        });
    }
}
