package J1;

import android.view.View;
import g2.C2048f;
import u2.t;

/* renamed from: J1.c2  reason: case insensitive filesystem */
public final /* synthetic */ class C1328c2 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C1446t2 f6976a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ t f6977b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ C2048f f6978c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f6979d;

    public /* synthetic */ C1328c2(C1446t2 t2Var, t tVar, C2048f fVar, int i4) {
        this.f6976a = t2Var;
        this.f6977b = tVar;
        this.f6978c = fVar;
        this.f6979d = i4;
    }

    public final void onClick(View view) {
        C1446t2.c4(this.f6976a, this.f6977b, this.f6978c, this.f6979d, view);
    }
}
