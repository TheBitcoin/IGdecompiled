package androidx.datastore.core.okio;

import N3.C2520k;
import N3.Q;
import R2.g;
import R2.h;
import androidx.datastore.core.InterProcessCoordinator;
import androidx.datastore.core.Storage;
import androidx.datastore.core.StorageConnection;
import d3.a;
import d3.p;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;

public final class OkioStorage<T> implements Storage<T> {
    public static final Companion Companion = new Companion((C2103g) null);
    /* access modifiers changed from: private */
    public static final Set<String> activeFiles = new LinkedHashSet();
    /* access modifiers changed from: private */
    public static final Synchronizer activeFilesLock = new Synchronizer();
    private final g canonicalPath$delegate;
    private final p coordinatorProducer;
    private final C2520k fileSystem;
    /* access modifiers changed from: private */
    public final a producePath;
    private final OkioSerializer<T> serializer;

    public static final class Companion {
        public /* synthetic */ Companion(C2103g gVar) {
            this();
        }

        public final Set<String> getActiveFiles$datastore_core_okio() {
            return OkioStorage.activeFiles;
        }

        public final Synchronizer getActiveFilesLock() {
            return OkioStorage.activeFilesLock;
        }

        private Companion() {
        }
    }

    public OkioStorage(C2520k kVar, OkioSerializer<T> okioSerializer, p pVar, a aVar) {
        m.e(kVar, "fileSystem");
        m.e(okioSerializer, "serializer");
        m.e(pVar, "coordinatorProducer");
        m.e(aVar, "producePath");
        this.fileSystem = kVar;
        this.serializer = okioSerializer;
        this.coordinatorProducer = pVar;
        this.producePath = aVar;
        this.canonicalPath$delegate = h.a(new OkioStorage$canonicalPath$2(this));
    }

    /* access modifiers changed from: private */
    public final Q getCanonicalPath() {
        return (Q) this.canonicalPath$delegate.getValue();
    }

    public StorageConnection<T> createConnection() {
        String q4 = getCanonicalPath().toString();
        synchronized (activeFilesLock) {
            Set<String> set = activeFiles;
            if (!set.contains(q4)) {
                set.add(q4);
            } else {
                throw new IllegalStateException(("There are multiple DataStores active for the same file: " + q4 + ". You should either maintain your DataStore as a singleton or confirm that there is no two DataStore's active on the same file (by confirming that the scope is cancelled).").toString());
            }
        }
        return new OkioStorageConnection(this.fileSystem, getCanonicalPath(), this.serializer, (InterProcessCoordinator) this.coordinatorProducer.invoke(getCanonicalPath(), this.fileSystem), new OkioStorage$createConnection$2(this));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ OkioStorage(C2520k kVar, OkioSerializer okioSerializer, p pVar, a aVar, int i4, C2103g gVar) {
        this(kVar, okioSerializer, (i4 & 4) != 0 ? AnonymousClass1.INSTANCE : pVar, aVar);
    }
}
