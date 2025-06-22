package m3;

import X2.b;

public enum l {
    IGNORE_CASE(2, 0, 2, (int) null),
    MULTILINE(8, 0, 2, (int) null),
    LITERAL(16, 0, 2, (int) null),
    UNIX_LINES(1, 0, 2, (int) null),
    COMMENTS(4, 0, 2, (int) null),
    DOT_MATCHES_ALL(32, 0, 2, (int) null),
    CANON_EQ(128, 0, 2, (int) null);
    

    /* renamed from: a  reason: collision with root package name */
    private final int f21200a;

    /* renamed from: b  reason: collision with root package name */
    private final int f21201b;

    static {
        l[] a5;
        f21199k = b.a(a5);
    }

    private l(int i4, int i5) {
        this.f21200a = i4;
        this.f21201b = i5;
    }

    public int b() {
        return this.f21200a;
    }
}
