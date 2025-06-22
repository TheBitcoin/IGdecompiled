package q1;

import w1.C2340g;

public class l {

    /* renamed from: a  reason: collision with root package name */
    private final String f21559a;

    /* renamed from: b  reason: collision with root package name */
    private final String f21560b;

    private l(String str, String str2) {
        this.f21559a = str;
        this.f21560b = str2;
    }

    public static l a(String str, String str2) {
        C2340g.d(str, "Name is null or empty");
        C2340g.d(str2, "Version is null or empty");
        return new l(str, str2);
    }

    public String b() {
        return this.f21559a;
    }

    public String c() {
        return this.f21560b;
    }
}
