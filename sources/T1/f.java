package T1;

import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;

public final class f {

    /* renamed from: c  reason: collision with root package name */
    public static final a f8302c = new a((C2103g) null);

    /* renamed from: a  reason: collision with root package name */
    private final int f8303a;

    /* renamed from: b  reason: collision with root package name */
    private final long f8304b = System.currentTimeMillis();

    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        public final boolean a(f fVar, f fVar2) {
            m.e(fVar2, "newEvent");
            if (fVar != null && fVar.a() == fVar2.a() && fVar2.b() - fVar.b() < 600) {
                return true;
            }
            return false;
        }

        private a() {
        }
    }

    public f(int i4) {
        this.f8303a = i4;
    }

    public final int a() {
        return this.f8303a;
    }

    public final long b() {
        return this.f8304b;
    }
}
