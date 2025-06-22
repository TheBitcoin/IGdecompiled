package androidx.datastore;

import android.content.Context;
import java.io.File;
import kotlin.jvm.internal.m;

public final class DataStoreFile {
    public static final File dataStoreFile(Context context, String str) {
        m.e(context, "<this>");
        m.e(str, "fileName");
        File filesDir = context.getApplicationContext().getFilesDir();
        return new File(filesDir, "datastore/" + str);
    }
}
