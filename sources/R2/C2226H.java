package r2;

import android.view.View;
import com.uptodown.tv.ui.fragment.TvMyAppsFragment;
import g2.C2048f;

/* renamed from: r2.H  reason: case insensitive filesystem */
public final /* synthetic */ class C2226H implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C2048f f21604a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TvMyAppsFragment f21605b;

    public /* synthetic */ C2226H(C2048f fVar, TvMyAppsFragment tvMyAppsFragment) {
        this.f21604a = fVar;
        this.f21605b = tvMyAppsFragment;
    }

    public final void onClick(View view) {
        TvMyAppsFragment.E(this.f21604a, this.f21605b, view);
    }
}
