package J1;

import android.view.View;
import g2.C2048f;

public final /* synthetic */ class Z1 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C1446t2 f6932a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C2048f f6933b;

    public /* synthetic */ Z1(C1446t2 t2Var, C2048f fVar) {
        this.f6932a = t2Var;
        this.f6933b = fVar;
    }

    public final void onClick(View view) {
        C1446t2.Z3(this.f6932a, this.f6933b, view);
    }
}
