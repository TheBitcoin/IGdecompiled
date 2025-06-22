package y0;

import G0.j;
import java.lang.Thread;
import java.util.concurrent.atomic.AtomicBoolean;
import v0.C2327a;
import v0.g;

/* renamed from: y0.B  reason: case insensitive filesystem */
class C2409B implements Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    private final a f22563a;

    /* renamed from: b  reason: collision with root package name */
    private final j f22564b;

    /* renamed from: c  reason: collision with root package name */
    private final Thread.UncaughtExceptionHandler f22565c;

    /* renamed from: d  reason: collision with root package name */
    private final C2327a f22566d;

    /* renamed from: e  reason: collision with root package name */
    private final AtomicBoolean f22567e = new AtomicBoolean(false);

    /* renamed from: y0.B$a */
    interface a {
        void a(j jVar, Thread thread, Throwable th);
    }

    public C2409B(a aVar, j jVar, Thread.UncaughtExceptionHandler uncaughtExceptionHandler, C2327a aVar2) {
        this.f22563a = aVar;
        this.f22564b = jVar;
        this.f22565c = uncaughtExceptionHandler;
        this.f22566d = aVar2;
    }

    private boolean b(Thread thread, Throwable th) {
        if (thread == null) {
            g.f().d("Crashlytics will not record uncaught exception; null thread");
            return false;
        } else if (th == null) {
            g.f().d("Crashlytics will not record uncaught exception; null throwable");
            return false;
        } else if (!this.f22566d.c()) {
            return true;
        } else {
            g.f().b("Crashlytics will not record uncaught exception; native crash exists for session.");
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean a() {
        return this.f22567e.get();
    }

    public void uncaughtException(Thread thread, Throwable th) {
        this.f22567e.set(true);
        try {
            if (b(thread, th)) {
                this.f22563a.a(this.f22564b, thread, th);
            } else {
                g.f().b("Uncaught exception will not be recorded by Crashlytics.");
            }
            if (this.f22565c != null) {
                g.f().b("Completed exception processing. Invoking default exception handler.");
                this.f22565c.uncaughtException(thread, th);
            } else {
                g.f().b("Completed exception processing, but no default exception handler.");
                System.exit(1);
            }
            this.f22567e.set(false);
        } catch (Exception e5) {
            g.f().e("An error occurred in the uncaught exception handler", e5);
            if (this.f22565c != null) {
                g.f().b("Completed exception processing. Invoking default exception handler.");
                this.f22565c.uncaughtException(thread, th);
            } else {
                g.f().b("Completed exception processing, but no default exception handler.");
                System.exit(1);
            }
            this.f22567e.set(false);
        } catch (Throwable th2) {
            if (this.f22565c != null) {
                g.f().b("Completed exception processing. Invoking default exception handler.");
                this.f22565c.uncaughtException(thread, th);
            } else {
                g.f().b("Completed exception processing, but no default exception handler.");
                System.exit(1);
            }
            this.f22567e.set(false);
            throw th2;
        }
    }
}
