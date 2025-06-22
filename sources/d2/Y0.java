package d2;

import android.graphics.drawable.Drawable;
import android.view.View;
import c2.C1694v;

public final /* synthetic */ class Y0 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C1941r1 f19858a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C1694v f19859b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Drawable f19860c;

    public /* synthetic */ Y0(C1941r1 r1Var, C1694v vVar, Drawable drawable) {
        this.f19858a = r1Var;
        this.f19859b = vVar;
        this.f19860c = drawable;
    }

    public final void onClick(View view) {
        C1941r1.G3(this.f19858a, this.f19859b, this.f19860c, view);
    }
}
