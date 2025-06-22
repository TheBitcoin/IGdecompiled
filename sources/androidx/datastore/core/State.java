package androidx.datastore.core;

import kotlin.jvm.internal.C2103g;

public abstract class State<T> {
    private final int version;

    public /* synthetic */ State(int i4, C2103g gVar) {
        this(i4);
    }

    public final int getVersion() {
        return this.version;
    }

    private State(int i4) {
        this.version = i4;
    }
}
