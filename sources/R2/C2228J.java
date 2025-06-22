package r2;

import android.view.View;
import com.uptodown.tv.ui.fragment.TvMyAppsFragment;
import g2.C2048f;

/* renamed from: r2.J  reason: case insensitive filesystem */
public final /* synthetic */ class C2228J implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C2048f f21608a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TvMyAppsFragment f21609b;

    public /* synthetic */ C2228J(C2048f fVar, TvMyAppsFragment tvMyAppsFragment) {
        this.f21608a = fVar;
        this.f21609b = tvMyAppsFragment;
    }

    public final void onClick(View view) {
        TvMyAppsFragment.G(this.f21608a, this.f21609b, view);
    }
}
