package androidx.datastore.core;

import d3.a;
import java.io.File;
import kotlin.jvm.internal.n;

final class MultiProcessCoordinator$lockFile$2 extends n implements a {
    final /* synthetic */ MultiProcessCoordinator this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MultiProcessCoordinator$lockFile$2(MultiProcessCoordinator multiProcessCoordinator) {
        super(0);
        this.this$0 = multiProcessCoordinator;
    }

    public final File invoke() {
        MultiProcessCoordinator multiProcessCoordinator = this.this$0;
        File access$fileWithSuffix = multiProcessCoordinator.fileWithSuffix(multiProcessCoordinator.LOCK_SUFFIX);
        this.this$0.createIfNotExists(access$fileWithSuffix);
        return access$fileWithSuffix;
    }
}
