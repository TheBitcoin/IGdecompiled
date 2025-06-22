package androidx.datastore.core;

import V2.g;
import java.io.File;
import kotlin.jvm.internal.m;

public final class MultiProcessCoordinatorKt {
    public static final InterProcessCoordinator createMultiProcessCoordinator(g gVar, File file) {
        m.e(gVar, "context");
        m.e(file, "file");
        return new MultiProcessCoordinator(gVar, file);
    }
}
