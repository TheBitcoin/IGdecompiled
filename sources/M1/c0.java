package M1;

import M1.d0;
import android.view.View;
import g2.C2050h;

public final /* synthetic */ class c0 implements View.OnLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d0.a f7545a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C2050h f7546b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f7547c;

    public /* synthetic */ c0(d0.a aVar, C2050h hVar, int i4) {
        this.f7545a = aVar;
        this.f7546b = hVar;
        this.f7547c = i4;
    }

    public final boolean onLongClick(View view) {
        return d0.a.p(this.f7545a, this.f7546b, this.f7547c, view);
    }
}
