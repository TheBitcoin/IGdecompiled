package M;

import J.C0309h;
import K.a;
import android.content.Context;
import android.util.SparseIntArray;

public final class G {

    /* renamed from: a  reason: collision with root package name */
    private final SparseIntArray f429a = new SparseIntArray();

    /* renamed from: b  reason: collision with root package name */
    private C0309h f430b;

    public G(C0309h hVar) {
        C0335p.l(hVar);
        this.f430b = hVar;
    }

    public final int a(Context context, int i4) {
        return this.f429a.get(i4, -1);
    }

    public final int b(Context context, a.f fVar) {
        C0335p.l(context);
        C0335p.l(fVar);
        int i4 = 0;
        if (!fVar.k()) {
            return 0;
        }
        int l4 = fVar.l();
        int a5 = a(context, l4);
        if (a5 != -1) {
            return a5;
        }
        int i5 = 0;
        while (true) {
            if (i5 >= this.f429a.size()) {
                i4 = -1;
                break;
            }
            int keyAt = this.f429a.keyAt(i5);
            if (keyAt > l4 && this.f429a.get(keyAt) == 0) {
                break;
            }
            i5++;
        }
        if (i4 == -1) {
            i4 = this.f430b.h(context, l4);
        }
        this.f429a.put(l4, i4);
        return i4;
    }

    public final void c() {
        this.f429a.clear();
    }
}
