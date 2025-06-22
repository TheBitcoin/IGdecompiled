package m3;

import j3.d;
import java.util.Locale;
import kotlin.jvm.internal.m;

abstract class b {
    public static int a(int i4) {
        if (2 <= i4 && i4 < 37) {
            return i4;
        }
        throw new IllegalArgumentException("radix " + i4 + " was not in valid range " + new d(2, 36));
    }

    public static final int b(char c5, int i4) {
        return Character.digit(c5, i4);
    }

    public static final boolean c(char c5) {
        if (Character.isWhitespace(c5) || Character.isSpaceChar(c5)) {
            return true;
        }
        return false;
    }

    public static String d(char c5, Locale locale) {
        m.e(locale, "locale");
        String e5 = e(c5, locale);
        if (e5.length() <= 1) {
            String valueOf = String.valueOf(c5);
            m.c(valueOf, "null cannot be cast to non-null type java.lang.String");
            String upperCase = valueOf.toUpperCase(Locale.ROOT);
            m.d(upperCase, "toUpperCase(...)");
            if (m.a(e5, upperCase)) {
                return String.valueOf(Character.toTitleCase(c5));
            }
        } else if (c5 != 329) {
            char charAt = e5.charAt(0);
            m.c(e5, "null cannot be cast to non-null type java.lang.String");
            String substring = e5.substring(1);
            m.d(substring, "substring(...)");
            m.c(substring, "null cannot be cast to non-null type java.lang.String");
            String lowerCase = substring.toLowerCase(Locale.ROOT);
            m.d(lowerCase, "toLowerCase(...)");
            return charAt + lowerCase;
        }
        return e5;
    }

    public static final String e(char c5, Locale locale) {
        m.e(locale, "locale");
        String valueOf = String.valueOf(c5);
        m.c(valueOf, "null cannot be cast to non-null type java.lang.String");
        String upperCase = valueOf.toUpperCase(locale);
        m.d(upperCase, "toUpperCase(...)");
        return upperCase;
    }
}
