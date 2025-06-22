package m0;

import java.util.NoSuchElementException;
import l0.h;

/* renamed from: m0.b  reason: case insensitive filesystem */
public abstract class C2134b extends S {

    /* renamed from: a  reason: collision with root package name */
    private C0262b f21086a = C0262b.NOT_READY;

    /* renamed from: b  reason: collision with root package name */
    private Object f21087b;

    /* renamed from: m0.b$a */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f21088a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                m0.b$b[] r0 = m0.C2134b.C0262b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f21088a = r0
                m0.b$b r1 = m0.C2134b.C0262b.DONE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f21088a     // Catch:{ NoSuchFieldError -> 0x001d }
                m0.b$b r1 = m0.C2134b.C0262b.READY     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: m0.C2134b.a.<clinit>():void");
        }
    }

    /* renamed from: m0.b$b  reason: collision with other inner class name */
    private enum C0262b {
        READY,
        NOT_READY,
        DONE,
        FAILED
    }

    protected C2134b() {
    }

    private boolean c() {
        this.f21086a = C0262b.FAILED;
        this.f21087b = a();
        if (this.f21086a == C0262b.DONE) {
            return false;
        }
        this.f21086a = C0262b.READY;
        return true;
    }

    /* access modifiers changed from: protected */
    public abstract Object a();

    /* access modifiers changed from: protected */
    public final Object b() {
        this.f21086a = C0262b.DONE;
        return null;
    }

    public final boolean hasNext() {
        boolean z4;
        if (this.f21086a != C0262b.FAILED) {
            z4 = true;
        } else {
            z4 = false;
        }
        h.n(z4);
        int i4 = a.f21088a[this.f21086a.ordinal()];
        if (i4 == 1) {
            return false;
        }
        if (i4 != 2) {
            return c();
        }
        return true;
    }

    public final Object next() {
        if (hasNext()) {
            this.f21086a = C0262b.NOT_READY;
            Object a5 = C2131E.a(this.f21087b);
            this.f21087b = null;
            return a5;
        }
        throw new NoSuchElementException();
    }
}
