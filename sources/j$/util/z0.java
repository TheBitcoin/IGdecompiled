package j$.util;

import java.security.AccessController;

public abstract class z0 {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f5683a = ((Boolean) AccessController.doPrivileged(new y0(0))).booleanValue();

    public static void a(Class cls, String str) {
        throw new UnsupportedOperationException(cls + " tripwire tripped but logging not supported: " + str);
    }
}
