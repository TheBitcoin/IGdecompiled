package J1;

import android.view.View;
import g2.C2048f;

public final /* synthetic */ class X1 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C2048f f6913a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C1446t2 f6914b;

    public /* synthetic */ X1(C2048f fVar, C1446t2 t2Var) {
        this.f6913a = fVar;
        this.f6914b = t2Var;
    }

    public final void onClick(View view) {
        C1446t2.X3(this.f6913a, this.f6914b, view);
    }
}
