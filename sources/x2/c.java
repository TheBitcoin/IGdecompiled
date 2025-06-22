package X2;

import S2.C1588b;
import S2.C1594h;
import java.io.Serializable;
import kotlin.jvm.internal.m;

final class c extends C1588b implements a, Serializable {

    /* renamed from: b  reason: collision with root package name */
    private final Enum[] f8817b;

    public c(Enum[] enumArr) {
        m.e(enumArr, "entries");
        this.f8817b = enumArr;
    }

    public int c() {
        return this.f8817b.length;
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof Enum)) {
            return false;
        }
        return h((Enum) obj);
    }

    public boolean h(Enum enumR) {
        m.e(enumR, "element");
        if (((Enum) C1594h.u(this.f8817b, enumR.ordinal())) == enumR) {
            return true;
        }
        return false;
    }

    public final /* bridge */ int indexOf(Object obj) {
        if (!(obj instanceof Enum)) {
            return -1;
        }
        return k((Enum) obj);
    }

    /* renamed from: j */
    public Enum get(int i4) {
        C1588b.f8237a.b(i4, this.f8817b.length);
        return this.f8817b[i4];
    }

    public int k(Enum enumR) {
        m.e(enumR, "element");
        int ordinal = enumR.ordinal();
        if (((Enum) C1594h.u(this.f8817b, ordinal)) == enumR) {
            return ordinal;
        }
        return -1;
    }

    public int l(Enum enumR) {
        m.e(enumR, "element");
        return indexOf(enumR);
    }

    public final /* bridge */ int lastIndexOf(Object obj) {
        if (!(obj instanceof Enum)) {
            return -1;
        }
        return l((Enum) obj);
    }
}
