package androidx.datastore.core;

import V2.g;
import d3.p;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;

public final class UpdatingDataContextElement implements g.b {
    public static final Companion Companion = new Companion((C2103g) null);
    /* access modifiers changed from: private */
    public static final String NESTED_UPDATE_ERROR_MESSAGE = "Calling updateData inside updateData on the same DataStore instance is not supported\nsince updates made in the parent updateData call will not be visible to the nested\nupdateData call. See https://issuetracker.google.com/issues/241760537 for details.";
    private final DataStoreImpl<?> instance;
    private final UpdatingDataContextElement parent;

    public static final class Companion {

        public static final class Key implements g.c {
            public static final Key INSTANCE = new Key();

            private Key() {
            }
        }

        public /* synthetic */ Companion(C2103g gVar) {
            this();
        }

        public final String getNESTED_UPDATE_ERROR_MESSAGE$datastore_core_release() {
            return UpdatingDataContextElement.NESTED_UPDATE_ERROR_MESSAGE;
        }

        private Companion() {
        }
    }

    public UpdatingDataContextElement(UpdatingDataContextElement updatingDataContextElement, DataStoreImpl<?> dataStoreImpl) {
        m.e(dataStoreImpl, "instance");
        this.parent = updatingDataContextElement;
        this.instance = dataStoreImpl;
    }

    public final void checkNotUpdating(DataStore<?> dataStore) {
        m.e(dataStore, "candidate");
        if (this.instance != dataStore) {
            UpdatingDataContextElement updatingDataContextElement = this.parent;
            if (updatingDataContextElement != null) {
                updatingDataContextElement.checkNotUpdating(dataStore);
                return;
            }
            return;
        }
        throw new IllegalStateException(NESTED_UPDATE_ERROR_MESSAGE.toString());
    }

    public <R> R fold(R r4, p pVar) {
        return g.b.a.a(this, r4, pVar);
    }

    public <E extends g.b> E get(g.c cVar) {
        return g.b.a.b(this, cVar);
    }

    public g.c getKey() {
        return Companion.Key.INSTANCE;
    }

    public g minusKey(g.c cVar) {
        return g.b.a.c(this, cVar);
    }

    public g plus(g gVar) {
        return g.b.a.d(this, gVar);
    }
}
