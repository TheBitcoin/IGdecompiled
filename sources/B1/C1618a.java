package b1;

import java.util.List;
import kotlin.jvm.internal.m;

/* renamed from: b1.a  reason: case insensitive filesystem */
public final class C1618a {

    /* renamed from: a  reason: collision with root package name */
    private final String f8969a;

    /* renamed from: b  reason: collision with root package name */
    private final String f8970b;

    /* renamed from: c  reason: collision with root package name */
    private final String f8971c;

    /* renamed from: d  reason: collision with root package name */
    private final String f8972d;

    /* renamed from: e  reason: collision with root package name */
    private final v f8973e;

    /* renamed from: f  reason: collision with root package name */
    private final List f8974f;

    public C1618a(String str, String str2, String str3, String str4, v vVar, List list) {
        m.e(str, "packageName");
        m.e(str2, "versionName");
        m.e(str3, "appBuildVersion");
        m.e(str4, "deviceManufacturer");
        m.e(vVar, "currentProcessDetails");
        m.e(list, "appProcessDetails");
        this.f8969a = str;
        this.f8970b = str2;
        this.f8971c = str3;
        this.f8972d = str4;
        this.f8973e = vVar;
        this.f8974f = list;
    }

    public final String a() {
        return this.f8971c;
    }

    public final List b() {
        return this.f8974f;
    }

    public final v c() {
        return this.f8973e;
    }

    public final String d() {
        return this.f8972d;
    }

    public final String e() {
        return this.f8969a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1618a)) {
            return false;
        }
        C1618a aVar = (C1618a) obj;
        if (m.a(this.f8969a, aVar.f8969a) && m.a(this.f8970b, aVar.f8970b) && m.a(this.f8971c, aVar.f8971c) && m.a(this.f8972d, aVar.f8972d) && m.a(this.f8973e, aVar.f8973e) && m.a(this.f8974f, aVar.f8974f)) {
            return true;
        }
        return false;
    }

    public final String f() {
        return this.f8970b;
    }

    public int hashCode() {
        return (((((((((this.f8969a.hashCode() * 31) + this.f8970b.hashCode()) * 31) + this.f8971c.hashCode()) * 31) + this.f8972d.hashCode()) * 31) + this.f8973e.hashCode()) * 31) + this.f8974f.hashCode();
    }

    public String toString() {
        return "AndroidApplicationInfo(packageName=" + this.f8969a + ", versionName=" + this.f8970b + ", appBuildVersion=" + this.f8971c + ", deviceManufacturer=" + this.f8972d + ", currentProcessDetails=" + this.f8973e + ", appProcessDetails=" + this.f8974f + ')';
    }
}
