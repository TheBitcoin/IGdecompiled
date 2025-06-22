package l1;

import m1.C2152a;
import m1.C2153b;

/* renamed from: l1.d  reason: case insensitive filesystem */
public abstract class C2109d {
    public static boolean a(String str) {
        if (str.equals("1")) {
            return true;
        }
        if (str.equals("0")) {
            return false;
        }
        throw new C2152a("Undecodable Boolean '" + str + "'");
    }

    public static String b(Boolean bool) {
        if (bool.booleanValue()) {
            return "1";
        }
        if (!bool.booleanValue()) {
            return "0";
        }
        throw new C2153b("Unencodable Boolean '" + bool + "'");
    }
}
