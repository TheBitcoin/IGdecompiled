package androidx.datastore.core;

import kotlin.jvm.internal.C2103g;

public final class UnInitialized extends State<Object> {
    public static final UnInitialized INSTANCE = new UnInitialized();

    private UnInitialized() {
        super(-1, (C2103g) null);
    }
}
