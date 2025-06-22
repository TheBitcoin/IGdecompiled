package T1;

import com.mbridge.msdk.foundation.entity.RewardPlus;
import kotlin.jvm.internal.m;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final String f8286a;

    /* renamed from: b  reason: collision with root package name */
    private final String f8287b;

    /* renamed from: c  reason: collision with root package name */
    private String f8288c;

    public b(String str, String str2) {
        m.e(str, "packageName");
        m.e(str2, RewardPlus.NAME);
        this.f8286a = str;
        this.f8287b = str2;
    }

    public final String a() {
        return this.f8288c;
    }

    public final String b() {
        return this.f8287b;
    }

    public final String c() {
        return this.f8286a;
    }

    public final void d(String str) {
        this.f8288c = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (m.a(this.f8286a, bVar.f8286a) && m.a(this.f8287b, bVar.f8287b)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.f8286a.hashCode() * 31) + this.f8287b.hashCode();
    }

    public String toString() {
        return "AppToBackup(packageName=" + this.f8286a + ", name=" + this.f8287b + ')';
    }
}
