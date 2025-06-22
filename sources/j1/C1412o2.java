package J1;

import android.view.View;
import g2.C2048f;

/* renamed from: J1.o2  reason: case insensitive filesystem */
public final /* synthetic */ class C1412o2 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C1446t2 f7092a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C2048f f7093b;

    public /* synthetic */ C1412o2(C1446t2 t2Var, C2048f fVar) {
        this.f7092a = t2Var;
        this.f7093b = fVar;
    }

    public final void onClick(View view) {
        C1446t2.h4(this.f7092a, this.f7093b, view);
    }
}
