package com.google.gson;

import java.lang.reflect.Field;
import java.util.Locale;

public enum b implements c {
    IDENTITY {
        public String a(Field field) {
            return field.getName();
        }
    },
    UPPER_CAMEL_CASE {
        public String a(Field field) {
            return b.c(field.getName());
        }
    },
    UPPER_CAMEL_CASE_WITH_SPACES {
        public String a(Field field) {
            return b.c(b.b(field.getName(), ' '));
        }
    },
    UPPER_CASE_WITH_UNDERSCORES {
        public String a(Field field) {
            return b.b(field.getName(), '_').toUpperCase(Locale.ENGLISH);
        }
    },
    LOWER_CASE_WITH_UNDERSCORES {
        public String a(Field field) {
            return b.b(field.getName(), '_').toLowerCase(Locale.ENGLISH);
        }
    },
    LOWER_CASE_WITH_DASHES {
        public String a(Field field) {
            return b.b(field.getName(), '-').toLowerCase(Locale.ENGLISH);
        }
    },
    LOWER_CASE_WITH_DOTS {
        public String a(Field field) {
            return b.b(field.getName(), '.').toLowerCase(Locale.ENGLISH);
        }
    };

    static String b(String str, char c5) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i4 = 0; i4 < length; i4++) {
            char charAt = str.charAt(i4);
            if (Character.isUpperCase(charAt) && sb.length() != 0) {
                sb.append(c5);
            }
            sb.append(charAt);
        }
        return sb.toString();
    }

    static String c(String str) {
        int length = str.length();
        int i4 = 0;
        while (true) {
            if (i4 >= length) {
                break;
            }
            char charAt = str.charAt(i4);
            if (!Character.isLetter(charAt)) {
                i4++;
            } else if (!Character.isUpperCase(charAt)) {
                char upperCase = Character.toUpperCase(charAt);
                if (i4 == 0) {
                    return upperCase + str.substring(1);
                }
                return str.substring(0, i4) + upperCase + str.substring(i4 + 1);
            }
        }
        return str;
    }
}
