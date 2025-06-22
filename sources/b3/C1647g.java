package b3;

import java.io.File;
import kotlin.jvm.internal.m;

/* renamed from: b3.g  reason: case insensitive filesystem */
abstract class C1647g extends C1646f {
    public static String a(File file) {
        m.e(file, "<this>");
        String name = file.getName();
        m.d(name, "getName(...)");
        return m3.m.s0(name, '.', "");
    }
}
