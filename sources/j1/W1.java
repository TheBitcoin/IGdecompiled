package J1;

import android.view.View;
import g2.C2048f;

public final /* synthetic */ class W1 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C2048f f6902a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C1446t2 f6903b;

    public /* synthetic */ W1(C2048f fVar, C1446t2 t2Var) {
        this.f6902a = fVar;
        this.f6903b = t2Var;
    }

    public final void onClick(View view) {
        C1446t2.W3(this.f6902a, this.f6903b, view);
    }
}
