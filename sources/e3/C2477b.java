package E3;

/* renamed from: E3.b  reason: case insensitive filesystem */
public abstract class C2477b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    protected final String f23241a;

    public C2477b(String str, Object... objArr) {
        this.f23241a = c.o(str, objArr);
    }

    /* access modifiers changed from: protected */
    public abstract void e();

    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName(this.f23241a);
        try {
            e();
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}
