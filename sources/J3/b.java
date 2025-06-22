package j3;

import S2.E;
import Y2.c;
import kotlin.jvm.internal.C2103g;

public class b implements Iterable, e3.a {

    /* renamed from: d  reason: collision with root package name */
    public static final a f20919d = new a((C2103g) null);

    /* renamed from: a  reason: collision with root package name */
    private final int f20920a;

    /* renamed from: b  reason: collision with root package name */
    private final int f20921b;

    /* renamed from: c  reason: collision with root package name */
    private final int f20922c;

    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        public final b a(int i4, int i5, int i6) {
            return new b(i4, i5, i6);
        }

        private a() {
        }
    }

    public b(int i4, int i5, int i6) {
        if (i6 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        } else if (i6 != Integer.MIN_VALUE) {
            this.f20920a = i4;
            this.f20921b = c.b(i4, i5, i6);
            this.f20922c = i6;
        } else {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
    }

    public final int c() {
        return this.f20920a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        if (isEmpty() && ((b) obj).isEmpty()) {
            return true;
        }
        b bVar = (b) obj;
        if (this.f20920a == bVar.f20920a && this.f20921b == bVar.f20921b && this.f20922c == bVar.f20922c) {
            return true;
        }
        return false;
    }

    public final int h() {
        return this.f20921b;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f20920a * 31) + this.f20921b) * 31) + this.f20922c;
    }

    public boolean isEmpty() {
        if (this.f20922c > 0) {
            if (this.f20920a > this.f20921b) {
                return true;
            }
            return false;
        } else if (this.f20920a < this.f20921b) {
            return true;
        } else {
            return false;
        }
    }

    public final int j() {
        return this.f20922c;
    }

    /* renamed from: k */
    public E iterator() {
        return new c(this.f20920a, this.f20921b, this.f20922c);
    }

    public String toString() {
        StringBuilder sb;
        int i4;
        if (this.f20922c > 0) {
            sb = new StringBuilder();
            sb.append(this.f20920a);
            sb.append("..");
            sb.append(this.f20921b);
            sb.append(" step ");
            i4 = this.f20922c;
        } else {
            sb = new StringBuilder();
            sb.append(this.f20920a);
            sb.append(" downTo ");
            sb.append(this.f20921b);
            sb.append(" step ");
            i4 = -this.f20922c;
        }
        sb.append(i4);
        return sb.toString();
    }
}
