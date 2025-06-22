package J1;

import android.view.View;
import g2.C2048f;

/* renamed from: J1.g2  reason: case insensitive filesystem */
public final /* synthetic */ class C1356g2 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C1446t2 f7017a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C2048f f7018b;

    public /* synthetic */ C1356g2(C1446t2 t2Var, C2048f fVar) {
        this.f7017a = t2Var;
        this.f7018b = fVar;
    }

    public final void onClick(View view) {
        C1446t2.U3(this.f7017a, this.f7018b, view);
    }
}
