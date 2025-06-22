package j$.util.stream;

import j$.util.y0;
import java.security.AccessController;

public abstract class E3 {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f5280a = ((Boolean) AccessController.doPrivileged(new y0(2))).booleanValue();

    public static void a(Class cls, String str) {
        throw new UnsupportedOperationException(cls + " tripwire tripped but logging not supported: " + str);
    }
}
