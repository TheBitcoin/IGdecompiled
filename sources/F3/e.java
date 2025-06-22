package F3;

import N3.C2514e;
import N3.C2521l;
import N3.X;
import java.io.IOException;

abstract class e extends C2521l {

    /* renamed from: b  reason: collision with root package name */
    private boolean f23323b;

    e(X x4) {
        super(x4);
    }

    /* access modifiers changed from: protected */
    public abstract void a(IOException iOException);

    public void close() {
        if (!this.f23323b) {
            try {
                super.close();
            } catch (IOException e5) {
                this.f23323b = true;
                a(e5);
            }
        }
    }

    public void flush() {
        if (!this.f23323b) {
            try {
                super.flush();
            } catch (IOException e5) {
                this.f23323b = true;
                a(e5);
            }
        }
    }

    public void m(C2514e eVar, long j4) {
        if (this.f23323b) {
            eVar.skip(j4);
            return;
        }
        try {
            super.m(eVar, j4);
        } catch (IOException e5) {
            this.f23323b = true;
            a(e5);
        }
    }
}
