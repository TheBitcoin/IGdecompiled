package r2;

import android.view.View;
import androidx.leanback.widget.Presenter;
import com.uptodown.tv.ui.fragment.TvMyAppsFragment;
import g2.C2048f;

/* renamed from: r2.G  reason: case insensitive filesystem */
public final /* synthetic */ class C2225G implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TvMyAppsFragment f21601a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C2048f f21602b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Presenter.ViewHolder f21603c;

    public /* synthetic */ C2225G(TvMyAppsFragment tvMyAppsFragment, C2048f fVar, Presenter.ViewHolder viewHolder) {
        this.f21601a = tvMyAppsFragment;
        this.f21602b = fVar;
        this.f21603c = viewHolder;
    }

    public final void onClick(View view) {
        TvMyAppsFragment.D(this.f21601a, this.f21602b, this.f21603c, view);
    }
}
