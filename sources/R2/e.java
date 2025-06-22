package R2;

import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;

public final class e implements Comparable {

    /* renamed from: e  reason: collision with root package name */
    public static final a f8207e = new a((C2103g) null);

    /* renamed from: f  reason: collision with root package name */
    public static final e f8208f = f.a();

    /* renamed from: a  reason: collision with root package name */
    private final int f8209a;

    /* renamed from: b  reason: collision with root package name */
    private final int f8210b;

    /* renamed from: c  reason: collision with root package name */
    private final int f8211c;

    /* renamed from: d  reason: collision with root package name */
    private final int f8212d;

    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        private a() {
        }
    }

    public e(int i4, int i5, int i6) {
        this.f8209a = i4;
        this.f8210b = i5;
        this.f8211c = i6;
        this.f8212d = b(i4, i5, i6);
    }

    private final int b(int i4, int i5, int i6) {
        if (i4 >= 0 && i4 < 256 && i5 >= 0 && i5 < 256 && i6 >= 0 && i6 < 256) {
            return (i4 << 16) + (i5 << 8) + i6;
        }
        throw new IllegalArgumentException(("Version components are out of range: " + i4 + '.' + i5 + '.' + i6).toString());
    }

    /* renamed from: a */
    public int compareTo(e eVar) {
        m.e(eVar, "other");
        return this.f8212d - eVar.f8212d;
    }

    public boolean equals(Object obj) {
        e eVar;
        if (this == obj) {
            return true;
        }
        if (obj instanceof e) {
            eVar = (e) obj;
        } else {
            eVar = null;
        }
        if (eVar != null && this.f8212d == eVar.f8212d) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f8212d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f8209a);
        sb.append('.');
        sb.append(this.f8210b);
        sb.append('.');
        sb.append(this.f8211c);
        return sb.toString();
    }
}
