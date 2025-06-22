package M1;

import M1.G;
import android.view.View;
import g2.C2050h;

public final /* synthetic */ class F implements View.OnLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ G f7429a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C2050h f7430b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f7431c;

    public /* synthetic */ F(G g4, C2050h hVar, int i4) {
        this.f7429a = g4;
        this.f7430b = hVar;
        this.f7431c = i4;
    }

    public final boolean onLongClick(View view) {
        return G.a.n(this.f7429a, this.f7430b, this.f7431c, view);
    }
}
