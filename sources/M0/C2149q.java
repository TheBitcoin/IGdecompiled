package m0;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Map;

/* renamed from: m0.q  reason: case insensitive filesystem */
public abstract class C2149q extends C2137e implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    final transient C2148p f21143a;

    /* renamed from: b  reason: collision with root package name */
    final transient int f21144b;

    /* renamed from: m0.q$a */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        final Map f21145a = H.c();

        /* renamed from: b  reason: collision with root package name */
        Comparator f21146b;

        /* renamed from: c  reason: collision with root package name */
        Comparator f21147c;
    }

    C2149q(C2148p pVar, int i4) {
        this.f21143a = pVar;
        this.f21144b = i4;
    }

    public boolean b(Object obj) {
        if (obj == null || !super.b(obj)) {
            return false;
        }
        return true;
    }

    /* renamed from: c */
    public C2148p a() {
        return this.f21143a;
    }

    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }
}
