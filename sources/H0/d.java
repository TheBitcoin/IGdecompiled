package h0;

import K.a;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.api.Scope;

public abstract class d {

    /* renamed from: a  reason: collision with root package name */
    public static final a.g f3408a;

    /* renamed from: b  reason: collision with root package name */
    public static final a.g f3409b;

    /* renamed from: c  reason: collision with root package name */
    public static final a.C0001a f3410c;

    /* renamed from: d  reason: collision with root package name */
    static final a.C0001a f3411d;

    /* renamed from: e  reason: collision with root package name */
    public static final Scope f3412e = new Scope("profile");

    /* renamed from: f  reason: collision with root package name */
    public static final Scope f3413f = new Scope(NotificationCompat.CATEGORY_EMAIL);

    /* renamed from: g  reason: collision with root package name */
    public static final a f3414g;

    /* renamed from: h  reason: collision with root package name */
    public static final a f3415h;

    static {
        a.g gVar = new a.g();
        f3408a = gVar;
        a.g gVar2 = new a.g();
        f3409b = gVar2;
        b bVar = new b();
        f3410c = bVar;
        c cVar = new c();
        f3411d = cVar;
        f3414g = new a("SignIn.API", bVar, gVar);
        f3415h = new a("SignIn.INTERNAL_API", cVar, gVar2);
    }
}
