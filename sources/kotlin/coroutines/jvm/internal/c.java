package kotlin.coroutines.jvm.internal;

import V2.d;
import V2.g;

public final class c implements d {

    /* renamed from: a  reason: collision with root package name */
    public static final c f20959a = new c();

    private c() {
    }

    public g getContext() {
        throw new IllegalStateException("This continuation is already complete");
    }

    public void resumeWith(Object obj) {
        throw new IllegalStateException("This continuation is already complete");
    }

    public String toString() {
        return "This continuation is already complete";
    }
}
