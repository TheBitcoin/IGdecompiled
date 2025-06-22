package M1;

import M1.I;
import android.view.View;
import g2.C2050h;

public final /* synthetic */ class H implements View.OnLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ I f7447a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C2050h f7448b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f7449c;

    public /* synthetic */ H(I i4, C2050h hVar, int i5) {
        this.f7447a = i4;
        this.f7448b = hVar;
        this.f7449c = i5;
    }

    public final boolean onLongClick(View view) {
        return I.a.n(this.f7447a, this.f7448b, this.f7449c, view);
    }
}
