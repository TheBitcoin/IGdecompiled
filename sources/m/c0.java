package M;

import android.util.Log;

public abstract class c0 {

    /* renamed from: a  reason: collision with root package name */
    private Object f485a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f486b = false;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ C0322c f487c;

    public c0(C0322c cVar, Object obj) {
        this.f487c = cVar;
        this.f485a = obj;
    }

    /* access modifiers changed from: protected */
    public abstract void a(Object obj);

    /* access modifiers changed from: protected */
    public abstract void b();

    public final void c() {
        Object obj;
        synchronized (this) {
            try {
                obj = this.f485a;
                if (this.f486b) {
                    String obj2 = toString();
                    Log.w("GmsClient", "Callback proxy " + obj2 + " being reused. This is not safe.");
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        if (obj != null) {
            a(obj);
        }
        synchronized (this) {
            this.f486b = true;
        }
        e();
    }

    public final void d() {
        synchronized (this) {
            this.f485a = null;
        }
    }

    public final void e() {
        d();
        synchronized (this.f487c.f475r) {
            this.f487c.f475r.remove(this);
        }
    }
}
