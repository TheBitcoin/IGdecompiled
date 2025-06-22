package androidx.datastore.core;

import androidx.annotation.RestrictTo;
import kotlin.jvm.internal.m;

public final class InterProcessCoordinatorKt {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final InterProcessCoordinator createSingleProcessCoordinator(String str) {
        m.e(str, "filePath");
        return new SingleProcessCoordinator(str);
    }
}
