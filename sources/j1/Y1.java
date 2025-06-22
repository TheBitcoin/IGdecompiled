package J1;

import android.view.View;
import g2.C2048f;

public final /* synthetic */ class Y1 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C1446t2 f6923a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C2048f f6924b;

    public /* synthetic */ Y1(C1446t2 t2Var, C2048f fVar) {
        this.f6923a = t2Var;
        this.f6924b = fVar;
    }

    public final void onClick(View view) {
        C1446t2.Y3(this.f6923a, this.f6924b, view);
    }
}
