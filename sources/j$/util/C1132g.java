package j$.util;

import java.io.Serializable;

/* renamed from: j$.util.g  reason: case insensitive filesystem */
public final class C1132g extends RuntimeException {
    public static void a(String str, Serializable serializable) {
        throw new RuntimeException("Unsupported " + str + " :" + serializable);
    }
}
