package T1;

import kotlin.jvm.internal.m;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private long f8289a;

    /* renamed from: b  reason: collision with root package name */
    private int f8290b;

    /* renamed from: c  reason: collision with root package name */
    private String f8291c;

    public final String a() {
        return this.f8291c;
    }

    public final int b() {
        return this.f8290b;
    }

    public final void c(String str, int i4) {
        m.e(str, "filePath");
        this.f8291c = str;
        this.f8290b = i4;
        this.f8289a = System.currentTimeMillis();
    }

    public final void d(int i4) {
        this.f8290b = i4;
    }
}
