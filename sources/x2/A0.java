package x2;

import android.view.View;
import g2.C2050h;

public final /* synthetic */ class A0 implements View.OnLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ D0 f22093a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C2050h f22094b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f22095c;

    public /* synthetic */ A0(D0 d02, C2050h hVar, int i4) {
        this.f22093a = d02;
        this.f22094b = hVar;
        this.f22095c = i4;
    }

    public final boolean onLongClick(View view) {
        return D0.p(this.f22093a, this.f22094b, this.f22095c, view);
    }
}
