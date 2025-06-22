package com.google.android.gms.internal.measurement;

final class N4 implements V4 {

    /* renamed from: a  reason: collision with root package name */
    private V4[] f1581a;

    N4(V4... v4Arr) {
        this.f1581a = v4Arr;
    }

    public final X4 a(Class cls) {
        for (V4 v4 : this.f1581a) {
            if (v4.b(cls)) {
                return v4.a(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: " + cls.getName());
    }

    public final boolean b(Class cls) {
        for (V4 b5 : this.f1581a) {
            if (b5.b(cls)) {
                return true;
            }
        }
        return false;
    }
}
