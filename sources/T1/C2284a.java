package t1;

import android.content.Context;
import java.util.Date;
import q1.n;
import t1.C2287d;
import w1.C2339f;

/* renamed from: t1.a  reason: case insensitive filesystem */
public class C2284a implements C2287d.a {

    /* renamed from: f  reason: collision with root package name */
    private static C2284a f21783f = new C2284a(new C2287d());

    /* renamed from: a  reason: collision with root package name */
    protected C2339f f21784a = new C2339f();

    /* renamed from: b  reason: collision with root package name */
    private Date f21785b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f21786c;

    /* renamed from: d  reason: collision with root package name */
    private C2287d f21787d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f21788e;

    private C2284a(C2287d dVar) {
        this.f21787d = dVar;
    }

    public static C2284a a() {
        return f21783f;
    }

    private void d() {
        if (this.f21786c && this.f21785b != null) {
            for (n t4 : C2286c.e().a()) {
                t4.t().g(c());
            }
        }
    }

    public void b(Context context) {
        if (!this.f21786c) {
            this.f21787d.a(context);
            this.f21787d.b(this);
            this.f21787d.i();
            this.f21788e = this.f21787d.g();
            this.f21786c = true;
        }
    }

    public Date c() {
        Date date = this.f21785b;
        if (date != null) {
            return (Date) date.clone();
        }
        return null;
    }

    public void e() {
        Date a5 = this.f21784a.a();
        Date date = this.f21785b;
        if (date == null || a5.after(date)) {
            this.f21785b = a5;
            d();
        }
    }

    public void a(boolean z4) {
        if (!this.f21788e && z4) {
            e();
        }
        this.f21788e = z4;
    }
}
