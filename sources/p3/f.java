package P3;

import java.net.MalformedURLException;
import java.net.URL;

public class f {

    /* renamed from: a  reason: collision with root package name */
    private final String f23860a;

    /* renamed from: b  reason: collision with root package name */
    private final int f23861b;

    /* renamed from: c  reason: collision with root package name */
    private String f23862c;

    /* renamed from: d  reason: collision with root package name */
    private String f23863d;

    public f(String str, int i4, String str2) {
        try {
            new URL(str);
            this.f23860a = str;
            this.f23861b = i4;
            this.f23862c = str2;
        } catch (MalformedURLException e5) {
            throw new RuntimeException(e5);
        }
    }

    public static f b(String str, int i4) {
        return new f(str, i4, "Default Tracker");
    }

    public C2549e a(C2546b bVar) {
        if (this.f23863d == null) {
            this.f23863d = String.format("https://%s/", new Object[]{bVar.c().getPackageName()});
        }
        return new C2549e(bVar, this);
    }

    public String c() {
        return this.f23860a;
    }

    public String d() {
        return this.f23863d;
    }

    public int e() {
        return this.f23861b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            f fVar = (f) obj;
            if (this.f23861b != fVar.f23861b || !this.f23860a.equals(fVar.f23860a) || !this.f23862c.equals(fVar.f23862c)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public String f() {
        return this.f23862c;
    }

    public int hashCode() {
        return (((this.f23860a.hashCode() * 31) + this.f23861b) * 31) + this.f23862c.hashCode();
    }
}
