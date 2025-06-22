package J;

import android.util.Log;

class N {

    /* renamed from: e  reason: collision with root package name */
    private static final N f315e = new N(true, 3, 1, (String) null, (Throwable) null);

    /* renamed from: a  reason: collision with root package name */
    final boolean f316a;

    /* renamed from: b  reason: collision with root package name */
    final String f317b;

    /* renamed from: c  reason: collision with root package name */
    final Throwable f318c;

    /* renamed from: d  reason: collision with root package name */
    final int f319d;

    private N(boolean z4, int i4, int i5, String str, Throwable th) {
        this.f316a = z4;
        this.f319d = i4;
        this.f317b = str;
        this.f318c = th;
    }

    static N b() {
        return f315e;
    }

    static N c(String str) {
        return new N(false, 1, 5, str, (Throwable) null);
    }

    static N d(String str, Throwable th) {
        return new N(false, 1, 5, str, th);
    }

    static N f(int i4) {
        return new N(true, i4, 1, (String) null, (Throwable) null);
    }

    static N g(int i4, int i5, String str, Throwable th) {
        return new N(false, i4, i5, str, th);
    }

    /* access modifiers changed from: package-private */
    public String a() {
        return this.f317b;
    }

    /* access modifiers changed from: package-private */
    public final void e() {
        if (!this.f316a && Log.isLoggable("GoogleCertificatesRslt", 3)) {
            if (this.f318c != null) {
                Log.d("GoogleCertificatesRslt", a(), this.f318c);
            } else {
                Log.d("GoogleCertificatesRslt", a());
            }
        }
    }

    /* synthetic */ N(boolean z4, int i4, int i5, String str, Throwable th, M m4) {
        this(false, 1, 5, (String) null, (Throwable) null);
    }
}
