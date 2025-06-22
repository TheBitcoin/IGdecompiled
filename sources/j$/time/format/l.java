package j$.time.format;

public final class l implements f {

    /* renamed from: a  reason: collision with root package name */
    public final String f4951a;

    public l(String str) {
        this.f4951a = str;
    }

    public final boolean j(p pVar, StringBuilder sb) {
        sb.append(this.f4951a);
        return true;
    }

    public final String toString() {
        String replace = this.f4951a.replace("'", "''");
        return "'" + replace + "'";
    }
}
