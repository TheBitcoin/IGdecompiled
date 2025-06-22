package O3;

import N3.C2514e;
import N3.c0;
import kotlin.jvm.internal.m;

/* renamed from: O3.a  reason: case insensitive filesystem */
public abstract class C2535a {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f23746a = c0.a("0123456789abcdef");

    public static final byte[] a() {
        return f23746a;
    }

    public static final String b(C2514e eVar, long j4) {
        m.e(eVar, "<this>");
        if (j4 > 0) {
            long j5 = j4 - 1;
            if (eVar.n(j5) == 13) {
                String readUtf8 = eVar.readUtf8(j5);
                eVar.skip(2);
                return readUtf8;
            }
        }
        String readUtf82 = eVar.readUtf8(j4);
        eVar.skip(1);
        return readUtf82;
    }
}
