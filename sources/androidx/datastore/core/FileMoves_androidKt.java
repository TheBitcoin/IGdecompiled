package androidx.datastore.core;

import android.os.Build;
import java.io.File;
import kotlin.jvm.internal.m;

public final class FileMoves_androidKt {
    public static final boolean atomicMoveTo(File file, File file2) {
        m.e(file, "<this>");
        m.e(file2, "toFile");
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.INSTANCE.move(file, file2);
        }
        return file.renameTo(file2);
    }
}
