package x2;

import android.view.View;
import g2.C2048f;

public final /* synthetic */ class V0 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C2048f f22281a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Z0 f22282b;

    public /* synthetic */ V0(C2048f fVar, Z0 z02) {
        this.f22281a = fVar;
        this.f22282b = z02;
    }

    public final void onClick(View view) {
        Z0.o(this.f22281a, this.f22282b, view);
    }
}
