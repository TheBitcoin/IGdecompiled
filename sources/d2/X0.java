package d2;

import android.graphics.drawable.Drawable;
import android.view.View;
import c2.C1694v;

public final /* synthetic */ class X0 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C1941r1 f19852a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C1694v f19853b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Drawable f19854c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Drawable f19855d;

    public /* synthetic */ X0(C1941r1 r1Var, C1694v vVar, Drawable drawable, Drawable drawable2) {
        this.f19852a = r1Var;
        this.f19853b = vVar;
        this.f19854c = drawable;
        this.f19855d = drawable2;
    }

    public final void onClick(View view) {
        C1941r1.F3(this.f19852a, this.f19853b, this.f19854c, this.f19855d, view);
    }
}
