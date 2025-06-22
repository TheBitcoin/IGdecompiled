package B0;

import B0.F;
import java.util.List;

final class y extends F.e.d.f {

    /* renamed from: a  reason: collision with root package name */
    private final List f6159a;

    static final class b extends F.e.d.f.a {

        /* renamed from: a  reason: collision with root package name */
        private List f6160a;

        b() {
        }

        public F.e.d.f a() {
            List list = this.f6160a;
            if (list != null) {
                return new y(list);
            }
            throw new IllegalStateException("Missing required properties:" + " rolloutAssignments");
        }

        public F.e.d.f.a b(List list) {
            if (list != null) {
                this.f6160a = list;
                return this;
            }
            throw new NullPointerException("Null rolloutAssignments");
        }
    }

    public List b() {
        return this.f6159a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof F.e.d.f) {
            return this.f6159a.equals(((F.e.d.f) obj).b());
        }
        return false;
    }

    public int hashCode() {
        return this.f6159a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "RolloutsState{rolloutAssignments=" + this.f6159a + "}";
    }

    private y(List list) {
        this.f6159a = list;
    }
}
