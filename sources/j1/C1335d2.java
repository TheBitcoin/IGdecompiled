package J1;

import android.view.View;
import g2.C2048f;
import u2.t;

/* renamed from: J1.d2  reason: case insensitive filesystem */
public final /* synthetic */ class C1335d2 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C1446t2 f6988a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ t f6989b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ C2048f f6990c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f6991d;

    public /* synthetic */ C1335d2(C1446t2 t2Var, t tVar, C2048f fVar, int i4) {
        this.f6988a = t2Var;
        this.f6989b = tVar;
        this.f6990c = fVar;
        this.f6991d = i4;
    }

    public final void onClick(View view) {
        C1446t2.d4(this.f6988a, this.f6989b, this.f6990c, this.f6991d, view);
    }
}
