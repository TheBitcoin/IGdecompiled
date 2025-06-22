package b1;

import kotlin.jvm.internal.m;

public final class v {

    /* renamed from: a  reason: collision with root package name */
    private final String f9056a;

    /* renamed from: b  reason: collision with root package name */
    private final int f9057b;

    /* renamed from: c  reason: collision with root package name */
    private final int f9058c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f9059d;

    public v(String str, int i4, int i5, boolean z4) {
        m.e(str, "processName");
        this.f9056a = str;
        this.f9057b = i4;
        this.f9058c = i5;
        this.f9059d = z4;
    }

    public final int a() {
        return this.f9058c;
    }

    public final int b() {
        return this.f9057b;
    }

    public final String c() {
        return this.f9056a;
    }

    public final boolean d() {
        return this.f9059d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof v)) {
            return false;
        }
        v vVar = (v) obj;
        if (m.a(this.f9056a, vVar.f9056a) && this.f9057b == vVar.f9057b && this.f9058c == vVar.f9058c && this.f9059d == vVar.f9059d) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((this.f9056a.hashCode() * 31) + this.f9057b) * 31) + this.f9058c) * 31;
        boolean z4 = this.f9059d;
        if (z4) {
            z4 = true;
        }
        return hashCode + (z4 ? 1 : 0);
    }

    public String toString() {
        return "ProcessDetails(processName=" + this.f9056a + ", pid=" + this.f9057b + ", importance=" + this.f9058c + ", isDefaultProcess=" + this.f9059d + ')';
    }
}
