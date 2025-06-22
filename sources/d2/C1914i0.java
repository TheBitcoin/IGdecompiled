package d2;

import android.content.Context;
import com.google.android.material.appbar.AppBarLayout;

/* renamed from: d2.i0  reason: case insensitive filesystem */
public final /* synthetic */ class C1914i0 implements AppBarLayout.OnOffsetChangedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C1941r1 f19925a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f19926b;

    public /* synthetic */ C1914i0(C1941r1 r1Var, Context context) {
        this.f19925a = r1Var;
        this.f19926b = context;
    }

    public final void onOffsetChanged(AppBarLayout appBarLayout, int i4) {
        C1941r1.E4(this.f19925a, this.f19926b, appBarLayout, i4);
    }
}
