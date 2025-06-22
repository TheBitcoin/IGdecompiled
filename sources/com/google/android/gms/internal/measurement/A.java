package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.List;

public abstract class A {

    /* renamed from: a  reason: collision with root package name */
    final List f1393a = new ArrayList();

    protected A() {
    }

    /* access modifiers changed from: package-private */
    public final C0663s a(String str) {
        if (this.f1393a.contains(C0690v2.c(str))) {
            throw new UnsupportedOperationException("Command not implemented: " + str);
        }
        throw new IllegalArgumentException("Command not supported");
    }

    public abstract C0663s b(String str, Z2 z22, List list);
}
