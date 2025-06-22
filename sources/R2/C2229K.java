package r2;

import android.view.View;
import com.uptodown.tv.ui.fragment.TvMyAppsFragment;
import g2.C2048f;

/* renamed from: r2.K  reason: case insensitive filesystem */
public final /* synthetic */ class C2229K implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TvMyAppsFragment f21610a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C2048f f21611b;

    public /* synthetic */ C2229K(TvMyAppsFragment tvMyAppsFragment, C2048f fVar) {
        this.f21610a = tvMyAppsFragment;
        this.f21611b = fVar;
    }

    public final void onClick(View view) {
        TvMyAppsFragment.H(this.f21610a, this.f21611b, view);
    }
}
