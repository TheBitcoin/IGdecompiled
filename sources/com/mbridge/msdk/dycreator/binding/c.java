package com.mbridge.msdk.dycreator.binding;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static volatile c f12571a;

    private c() {
    }

    public static c a() {
        if (f12571a == null) {
            synchronized (c.class) {
                try {
                    if (f12571a == null) {
                        f12571a = new c();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f12571a;
    }
}
