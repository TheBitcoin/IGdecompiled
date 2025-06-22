package N3;

import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.m;
import m3.d;

public abstract class c0 {
    public static final byte[] a(String str) {
        m.e(str, "<this>");
        byte[] bytes = str.getBytes(d.f21160b);
        m.d(bytes, "this as java.lang.String).getBytes(charset)");
        return bytes;
    }

    public static final ReentrantLock b() {
        return new ReentrantLock();
    }

    public static final String c(byte[] bArr) {
        m.e(bArr, "<this>");
        return new String(bArr, d.f21160b);
    }
}
