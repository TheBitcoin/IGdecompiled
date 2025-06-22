package M;

import K.a;
import android.os.Bundle;

/* renamed from: M.w  reason: case insensitive filesystem */
public class C0341w implements a.d {

    /* renamed from: b  reason: collision with root package name */
    public static final C0341w f595b = a().a();

    /* renamed from: a  reason: collision with root package name */
    private final String f596a;

    /* renamed from: M.w$a */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private String f597a;

        /* synthetic */ a(C0343y yVar) {
        }

        public C0341w a() {
            return new C0341w(this.f597a, (C0344z) null);
        }

        public a b(String str) {
            this.f597a = str;
            return this;
        }
    }

    /* synthetic */ C0341w(String str, C0344z zVar) {
        this.f596a = str;
    }

    public static a a() {
        return new a((C0343y) null);
    }

    public final Bundle b() {
        Bundle bundle = new Bundle();
        String str = this.f596a;
        if (str != null) {
            bundle.putString("api", str);
        }
        return bundle;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0341w)) {
            return false;
        }
        return C0333n.a(this.f596a, ((C0341w) obj).f596a);
    }

    public final int hashCode() {
        return C0333n.b(this.f596a);
    }
}
