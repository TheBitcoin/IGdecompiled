package androidx.datastore.core;

import java.io.File;
import kotlin.jvm.internal.m;

public final class InterProcessCoordinator_jvmKt {
    public static final InterProcessCoordinator createSingleProcessCoordinator(File file) {
        m.e(file, "file");
        String absolutePath = file.getCanonicalFile().getAbsolutePath();
        m.d(absolutePath, "file.canonicalFile.absolutePath");
        return InterProcessCoordinatorKt.createSingleProcessCoordinator(absolutePath);
    }
}
