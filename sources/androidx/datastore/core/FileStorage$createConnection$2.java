package androidx.datastore.core;

import R2.s;
import androidx.datastore.core.FileStorage;
import d3.a;
import java.io.File;
import kotlin.jvm.internal.n;

final class FileStorage$createConnection$2 extends n implements a {
    final /* synthetic */ File $file;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FileStorage$createConnection$2(File file) {
        super(0);
        this.$file = file;
    }

    public final void invoke() {
        FileStorage.Companion companion = FileStorage.Companion;
        Object activeFilesLock$datastore_core_release = companion.getActiveFilesLock$datastore_core_release();
        File file = this.$file;
        synchronized (activeFilesLock$datastore_core_release) {
            companion.getActiveFiles$datastore_core_release().remove(file.getAbsolutePath());
            s sVar = s.f8222a;
        }
    }
}
