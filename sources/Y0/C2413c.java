package y0;

import B0.F;
import java.io.File;

/* renamed from: y0.c  reason: case insensitive filesystem */
final class C2413c extends C2408A {

    /* renamed from: a  reason: collision with root package name */
    private final F f22627a;

    /* renamed from: b  reason: collision with root package name */
    private final String f22628b;

    /* renamed from: c  reason: collision with root package name */
    private final File f22629c;

    C2413c(F f4, String str, File file) {
        if (f4 != null) {
            this.f22627a = f4;
            if (str != null) {
                this.f22628b = str;
                if (file != null) {
                    this.f22629c = file;
                    return;
                }
                throw new NullPointerException("Null reportFile");
            }
            throw new NullPointerException("Null sessionId");
        }
        throw new NullPointerException("Null report");
    }

    public F b() {
        return this.f22627a;
    }

    public File c() {
        return this.f22629c;
    }

    public String d() {
        return this.f22628b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C2408A) {
            C2408A a5 = (C2408A) obj;
            if (!this.f22627a.equals(a5.b()) || !this.f22628b.equals(a5.d()) || !this.f22629c.equals(a5.c())) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((this.f22627a.hashCode() ^ 1000003) * 1000003) ^ this.f22628b.hashCode()) * 1000003) ^ this.f22629c.hashCode();
    }

    public String toString() {
        return "CrashlyticsReportWithSessionId{report=" + this.f22627a + ", sessionId=" + this.f22628b + ", reportFile=" + this.f22629c + "}";
    }
}
