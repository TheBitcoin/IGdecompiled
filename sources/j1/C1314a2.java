package J1;

import android.view.View;
import g2.C2048f;

/* renamed from: J1.a2  reason: case insensitive filesystem */
public final /* synthetic */ class C1314a2 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C1446t2 f6942a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C2048f f6943b;

    public /* synthetic */ C1314a2(C1446t2 t2Var, C2048f fVar) {
        this.f6942a = t2Var;
        this.f6943b = fVar;
    }

    public final void onClick(View view) {
        C1446t2.a4(this.f6942a, this.f6943b, view);
    }
}
