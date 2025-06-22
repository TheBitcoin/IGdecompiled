package androidx.datastore.preferences.core;

import N3.Q;
import d3.a;
import java.io.File;
import kotlin.jvm.internal.n;

final class PreferenceDataStoreFactory$createWithPath$1 extends n implements a {
    final /* synthetic */ a $produceFile;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PreferenceDataStoreFactory$createWithPath$1(a aVar) {
        super(0);
        this.$produceFile = aVar;
    }

    public final File invoke() {
        return ((Q) this.$produceFile.invoke()).m();
    }
}
