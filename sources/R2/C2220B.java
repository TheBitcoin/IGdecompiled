package r2;

import android.view.View;
import com.uptodown.tv.ui.fragment.TvMyAppsFragment;
import g2.C2048f;

/* renamed from: r2.B  reason: case insensitive filesystem */
public final /* synthetic */ class C2220B implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TvMyAppsFragment f21597a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C2048f f21598b;

    public /* synthetic */ C2220B(TvMyAppsFragment tvMyAppsFragment, C2048f fVar) {
        this.f21597a = tvMyAppsFragment;
        this.f21598b = fVar;
    }

    public final void onClick(View view) {
        TvMyAppsFragment.C(this.f21597a, this.f21598b, view);
    }
}
