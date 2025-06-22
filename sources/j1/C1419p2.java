package J1;

import android.view.View;
import g2.C2048f;

/* renamed from: J1.p2  reason: case insensitive filesystem */
public final /* synthetic */ class C1419p2 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C1446t2 f7100a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C2048f f7101b;

    public /* synthetic */ C1419p2(C1446t2 t2Var, C2048f fVar) {
        this.f7100a = t2Var;
        this.f7101b = fVar;
    }

    public final void onClick(View view) {
        C1446t2.i4(this.f7100a, this.f7101b, view);
    }
}
