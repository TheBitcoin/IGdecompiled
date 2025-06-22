package t1;

import android.view.View;
import q1.h;
import z1.C2447a;

/* renamed from: t1.e  reason: case insensitive filesystem */
public class C2288e {

    /* renamed from: a  reason: collision with root package name */
    private final C2447a f21796a;

    /* renamed from: b  reason: collision with root package name */
    private final String f21797b;

    /* renamed from: c  reason: collision with root package name */
    private final h f21798c;

    /* renamed from: d  reason: collision with root package name */
    private final String f21799d;

    public C2288e(View view, h hVar, String str) {
        this.f21796a = new C2447a(view);
        this.f21797b = view.getClass().getCanonicalName();
        this.f21798c = hVar;
        this.f21799d = str;
    }

    public String a() {
        return this.f21799d;
    }

    public h b() {
        return this.f21798c;
    }

    public C2447a c() {
        return this.f21796a;
    }

    public String d() {
        return this.f21797b;
    }
}
