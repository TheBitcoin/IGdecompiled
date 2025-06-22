package p;

import java.util.List;

final class d extends n {

    /* renamed from: a  reason: collision with root package name */
    private final List f3811a;

    d(List list) {
        if (list != null) {
            this.f3811a = list;
            return;
        }
        throw new NullPointerException("Null logRequests");
    }

    public List c() {
        return this.f3811a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof n) {
            return this.f3811a.equals(((n) obj).c());
        }
        return false;
    }

    public int hashCode() {
        return this.f3811a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "BatchedLogRequest{logRequests=" + this.f3811a + "}";
    }
}
