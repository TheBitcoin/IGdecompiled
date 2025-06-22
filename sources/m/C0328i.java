package M;

/* renamed from: M.i  reason: case insensitive filesystem */
public final class C0328i {

    /* renamed from: a  reason: collision with root package name */
    private final String f544a;

    /* renamed from: b  reason: collision with root package name */
    private final String f545b;

    public C0328i(String str) {
        this(str, (String) null);
    }

    public C0328i(String str, String str2) {
        C0335p.m(str, "log tag cannot be null");
        C0335p.c(str.length() <= 23, "tag \"%s\" is longer than the %d character maximum", str, 23);
        this.f544a = str;
        this.f545b = (str2 == null || str2.length() <= 0) ? null : str2;
    }
}
