package L;

import K.a;
import M.C0333n;

/* renamed from: L.b  reason: case insensitive filesystem */
public final class C0318b {

    /* renamed from: a  reason: collision with root package name */
    private final int f393a;

    /* renamed from: b  reason: collision with root package name */
    private final a f394b;

    /* renamed from: c  reason: collision with root package name */
    private final a.d f395c;

    /* renamed from: d  reason: collision with root package name */
    private final String f396d;

    private C0318b(a aVar, a.d dVar, String str) {
        this.f394b = aVar;
        this.f395c = dVar;
        this.f396d = str;
        this.f393a = C0333n.b(aVar, dVar, str);
    }

    public static C0318b a(a aVar, a.d dVar, String str) {
        return new C0318b(aVar, dVar, str);
    }

    public final String b() {
        return this.f394b.c();
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0318b)) {
            return false;
        }
        C0318b bVar = (C0318b) obj;
        if (!C0333n.a(this.f394b, bVar.f394b) || !C0333n.a(this.f395c, bVar.f395c) || !C0333n.a(this.f396d, bVar.f396d)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return this.f393a;
    }
}
