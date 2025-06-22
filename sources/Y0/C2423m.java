package y0;

import E0.g;
import j$.util.Objects;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* renamed from: y0.m  reason: case insensitive filesystem */
class C2423m {

    /* renamed from: d  reason: collision with root package name */
    private static final FilenameFilter f22658d = new C2421k();

    /* renamed from: e  reason: collision with root package name */
    private static final Comparator f22659e = new C2422l();

    /* renamed from: a  reason: collision with root package name */
    private final g f22660a;

    /* renamed from: b  reason: collision with root package name */
    private String f22661b = null;

    /* renamed from: c  reason: collision with root package name */
    private String f22662c = null;

    C2423m(g gVar) {
        this.f22660a = gVar;
    }

    private static void d(g gVar, String str, String str2) {
        if (str != null && str2 != null) {
            try {
                gVar.q(str, "aqs." + str2).createNewFile();
            } catch (IOException e5) {
                v0.g.f().l("Failed to persist App Quality Sessions session id.", e5);
            }
        }
    }

    static String e(g gVar, String str) {
        List r4 = gVar.r(str, f22658d);
        if (!r4.isEmpty()) {
            return ((File) Collections.min(r4, f22659e)).getName().substring(4);
        }
        v0.g.f().k("Unable to read App Quality Sessions session id.");
        return null;
    }

    public synchronized String c(String str) {
        if (Objects.equals(this.f22661b, str)) {
            return this.f22662c;
        }
        return e(this.f22660a, str);
    }

    public synchronized void f(String str) {
        if (!Objects.equals(this.f22662c, str)) {
            d(this.f22660a, this.f22661b, str);
            this.f22662c = str;
        }
    }

    public synchronized void g(String str) {
        if (!Objects.equals(this.f22661b, str)) {
            d(this.f22660a, str, this.f22662c);
            this.f22661b = str;
        }
    }
}
