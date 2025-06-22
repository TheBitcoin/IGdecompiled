package com.google.android.gms.internal.measurement;

import java.util.List;

public final class U extends A {
    public final C0663s b(String str, Z2 z22, List list) {
        if (str == null || str.isEmpty() || !z22.g(str)) {
            throw new IllegalArgumentException(String.format("Command not found: %s", new Object[]{str}));
        }
        C0663s c5 = z22.c(str);
        if (c5 instanceof C0623n) {
            return ((C0623n) c5).a(z22, list);
        }
        throw new IllegalArgumentException(String.format("Function %s is not defined", new Object[]{str}));
    }
}
