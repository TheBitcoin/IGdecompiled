package androidx.window.core;

import kotlin.jvm.internal.m;

public final class WindowStrictModeException extends Exception {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WindowStrictModeException(String str) {
        super(str);
        m.e(str, "message");
    }
}
