package j3;

import kotlin.jvm.internal.C2103g;

public final class d extends b implements a {

    /* renamed from: e  reason: collision with root package name */
    public static final a f20927e = new a((C2103g) null);
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static final d f20928f = new d(1, 0);

    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        public final d a() {
            return d.f20928f;
        }

        private a() {
        }
    }

    public d(int i4, int i5) {
        super(i4, i5, 1);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        if (isEmpty() && ((d) obj).isEmpty()) {
            return true;
        }
        d dVar = (d) obj;
        if (c() == dVar.c() && h() == dVar.h()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (c() * 31) + h();
    }

    public boolean isEmpty() {
        if (c() > h()) {
            return true;
        }
        return false;
    }

    public boolean m(int i4) {
        if (c() > i4 || i4 > h()) {
            return false;
        }
        return true;
    }

    /* renamed from: n */
    public Integer getEndInclusive() {
        return Integer.valueOf(h());
    }

    /* renamed from: o */
    public Integer getStart() {
        return Integer.valueOf(c());
    }

    public String toString() {
        return c() + ".." + h();
    }
}
