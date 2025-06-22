package b1;

import kotlin.jvm.internal.m;

/* renamed from: b1.b  reason: case insensitive filesystem */
public final class C1619b {

    /* renamed from: a  reason: collision with root package name */
    private final String f8975a;

    /* renamed from: b  reason: collision with root package name */
    private final String f8976b;

    /* renamed from: c  reason: collision with root package name */
    private final String f8977c;

    /* renamed from: d  reason: collision with root package name */
    private final String f8978d;

    /* renamed from: e  reason: collision with root package name */
    private final u f8979e;

    /* renamed from: f  reason: collision with root package name */
    private final C1618a f8980f;

    public C1619b(String str, String str2, String str3, String str4, u uVar, C1618a aVar) {
        m.e(str, "appId");
        m.e(str2, "deviceModel");
        m.e(str3, "sessionSdkVersion");
        m.e(str4, "osVersion");
        m.e(uVar, "logEnvironment");
        m.e(aVar, "androidAppInfo");
        this.f8975a = str;
        this.f8976b = str2;
        this.f8977c = str3;
        this.f8978d = str4;
        this.f8979e = uVar;
        this.f8980f = aVar;
    }

    public final C1618a a() {
        return this.f8980f;
    }

    public final String b() {
        return this.f8975a;
    }

    public final String c() {
        return this.f8976b;
    }

    public final u d() {
        return this.f8979e;
    }

    public final String e() {
        return this.f8978d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1619b)) {
            return false;
        }
        C1619b bVar = (C1619b) obj;
        if (m.a(this.f8975a, bVar.f8975a) && m.a(this.f8976b, bVar.f8976b) && m.a(this.f8977c, bVar.f8977c) && m.a(this.f8978d, bVar.f8978d) && this.f8979e == bVar.f8979e && m.a(this.f8980f, bVar.f8980f)) {
            return true;
        }
        return false;
    }

    public final String f() {
        return this.f8977c;
    }

    public int hashCode() {
        return (((((((((this.f8975a.hashCode() * 31) + this.f8976b.hashCode()) * 31) + this.f8977c.hashCode()) * 31) + this.f8978d.hashCode()) * 31) + this.f8979e.hashCode()) * 31) + this.f8980f.hashCode();
    }

    public String toString() {
        return "ApplicationInfo(appId=" + this.f8975a + ", deviceModel=" + this.f8976b + ", sessionSdkVersion=" + this.f8977c + ", osVersion=" + this.f8978d + ", logEnvironment=" + this.f8979e + ", androidAppInfo=" + this.f8980f + ')';
    }
}
