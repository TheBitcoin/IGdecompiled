package com.mbridge.msdk.foundation.same.report.c;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f13387a = "a";

    /* renamed from: b  reason: collision with root package name */
    private static a f13388b;

    private a() {
    }

    public static a a() {
        if (f13388b == null) {
            synchronized (a.class) {
                try {
                    if (f13388b == null) {
                        f13388b = new a();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f13388b;
    }
}
