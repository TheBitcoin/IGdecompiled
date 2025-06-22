package androidx.datastore.preferences.core;

import N3.Q;
import b3.C1643c;
import d3.a;
import java.io.File;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;

final class PreferenceDataStoreFactory$create$delegate$1 extends n implements a {
    final /* synthetic */ a $produceFile;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PreferenceDataStoreFactory$create$delegate$1(a aVar) {
        super(0);
        this.$produceFile = aVar;
    }

    public final Q invoke() {
        File file = (File) this.$produceFile.invoke();
        if (m.a(C1643c.a(file), PreferencesSerializer.fileExtension)) {
            Q.a aVar = Q.f23639b;
            File absoluteFile = file.getAbsoluteFile();
            m.d(absoluteFile, "file.absoluteFile");
            return Q.a.d(aVar, absoluteFile, false, 1, (Object) null);
        }
        throw new IllegalStateException(("File extension for file: " + file + " does not match required extension for Preferences file: preferences_pb").toString());
    }
}
