package com.google.android.gms.internal.measurement;

public abstract class K2 {

    /* renamed from: a  reason: collision with root package name */
    private static J2 f1514a;

    public static synchronized J2 a() {
        J2 j22;
        synchronized (K2.class) {
            try {
                if (f1514a == null) {
                    b(new M2());
                }
                j22 = f1514a;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        return j22;
    }

    private static synchronized void b(J2 j22) {
        synchronized (K2.class) {
            if (f1514a == null) {
                f1514a = j22;
            } else {
                throw new IllegalStateException("init() already called");
            }
        }
    }
}
