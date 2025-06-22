package M1;

import M1.d0;
import android.view.View;
import g2.C2050h;

public final /* synthetic */ class b0 implements View.OnLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d0.a f7539a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C2050h f7540b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f7541c;

    public /* synthetic */ b0(d0.a aVar, C2050h hVar, int i4) {
        this.f7539a = aVar;
        this.f7540b = hVar;
        this.f7541c = i4;
    }

    public final boolean onLongClick(View view) {
        return d0.a.s(this.f7539a, this.f7540b, this.f7541c, view);
    }
}
