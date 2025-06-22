package r;

import A.a;
import android.content.Context;

/* renamed from: r.c  reason: case insensitive filesystem */
final class C1020c extends C1025h {

    /* renamed from: a  reason: collision with root package name */
    private final Context f4116a;

    /* renamed from: b  reason: collision with root package name */
    private final a f4117b;

    /* renamed from: c  reason: collision with root package name */
    private final a f4118c;

    /* renamed from: d  reason: collision with root package name */
    private final String f4119d;

    C1020c(Context context, a aVar, a aVar2, String str) {
        if (context != null) {
            this.f4116a = context;
            if (aVar != null) {
                this.f4117b = aVar;
                if (aVar2 != null) {
                    this.f4118c = aVar2;
                    if (str != null) {
                        this.f4119d = str;
                        return;
                    }
                    throw new NullPointerException("Null backendName");
                }
                throw new NullPointerException("Null monotonicClock");
            }
            throw new NullPointerException("Null wallClock");
        }
        throw new NullPointerException("Null applicationContext");
    }

    public Context b() {
        return this.f4116a;
    }

    public String c() {
        return this.f4119d;
    }

    public a d() {
        return this.f4118c;
    }

    public a e() {
        return this.f4117b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C1025h) {
            C1025h hVar = (C1025h) obj;
            if (!this.f4116a.equals(hVar.b()) || !this.f4117b.equals(hVar.e()) || !this.f4118c.equals(hVar.d()) || !this.f4119d.equals(hVar.c())) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((((this.f4116a.hashCode() ^ 1000003) * 1000003) ^ this.f4117b.hashCode()) * 1000003) ^ this.f4118c.hashCode()) * 1000003) ^ this.f4119d.hashCode();
    }

    public String toString() {
        return "CreationContext{applicationContext=" + this.f4116a + ", wallClock=" + this.f4117b + ", monotonicClock=" + this.f4118c + ", backendName=" + this.f4119d + "}";
    }
}
