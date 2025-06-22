package x2;

import android.view.View;
import g2.C2050h;

/* renamed from: x2.e  reason: case insensitive filesystem */
public final /* synthetic */ class C2365e implements View.OnLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C2367f f22359a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C2050h f22360b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f22361c;

    public /* synthetic */ C2365e(C2367f fVar, C2050h hVar, int i4) {
        this.f22359a = fVar;
        this.f22360b = hVar;
        this.f22361c = i4;
    }

    public final boolean onLongClick(View view) {
        return C2367f.n(this.f22359a, this.f22360b, this.f22361c, view);
    }
}
