package j$.time.format;

public final class d implements f {

    /* renamed from: a  reason: collision with root package name */
    public final char f4934a;

    public d(char c5) {
        this.f4934a = c5;
    }

    public final boolean j(p pVar, StringBuilder sb) {
        sb.append(this.f4934a);
        return true;
    }

    public final String toString() {
        char c5 = this.f4934a;
        if (c5 == '\'') {
            return "''";
        }
        return "'" + c5 + "'";
    }
}
