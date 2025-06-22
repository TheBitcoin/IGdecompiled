package J1;

import android.view.View;
import g2.C2048f;

/* renamed from: J1.q2  reason: case insensitive filesystem */
public final /* synthetic */ class C1426q2 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C1446t2 f7109a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C2048f f7110b;

    public /* synthetic */ C1426q2(C1446t2 t2Var, C2048f fVar) {
        this.f7109a = t2Var;
        this.f7110b = fVar;
    }

    public final void onClick(View view) {
        C1446t2.j4(this.f7109a, this.f7110b, view);
    }
}
