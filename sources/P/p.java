package p;

import android.util.SparseArray;
import p.f;

public abstract class p {

    public static abstract class a {
        public abstract p a();

        public abstract a b(s sVar);

        public abstract a c(b bVar);
    }

    public enum b {
        NOT_SET(0),
        EVENT_OVERRIDE(5);
        

        /* renamed from: d  reason: collision with root package name */
        private static final SparseArray f3871d = null;

        /* renamed from: a  reason: collision with root package name */
        private final int f3873a;

        static {
            b bVar;
            b bVar2;
            SparseArray sparseArray = new SparseArray();
            f3871d = sparseArray;
            sparseArray.put(0, bVar);
            sparseArray.put(5, bVar2);
        }

        private b(int i4) {
            this.f3873a = i4;
        }
    }

    public static a a() {
        return new f.b();
    }

    public abstract s b();

    public abstract b c();
}
