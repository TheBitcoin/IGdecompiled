package com.mbridge.msdk.dycreator.b;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private int f12245a;

    /* renamed from: b  reason: collision with root package name */
    private String f12246b;

    public a(b bVar) {
        if (bVar != null) {
            this.f12245a = bVar.a();
            this.f12246b = bVar.b();
        }
    }

    public final String toString() {
        return "DyError{errorCode=" + this.f12245a + '}';
    }

    public a(int i4, String str) {
        this.f12245a = i4;
        this.f12246b = str;
    }
}
