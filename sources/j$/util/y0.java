package j$.util;

import java.security.PrivilegedAction;

public final /* synthetic */ class y0 implements PrivilegedAction {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f5682a;

    public /* synthetic */ y0(int i4) {
        this.f5682a = i4;
    }

    public final Object run() {
        switch (this.f5682a) {
            case 0:
                return Boolean.valueOf(Boolean.getBoolean("org.openjdk.java.util.stream.tripwire"));
            case 1:
                return Boolean.valueOf(Boolean.getBoolean("java.util.secureRandomSeed"));
            default:
                return Boolean.valueOf(Boolean.getBoolean("org.openjdk.java.util.stream.tripwire"));
        }
    }
}
