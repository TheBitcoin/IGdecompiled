package r2;

import android.view.View;
import com.uptodown.tv.ui.fragment.TvMyAppsFragment;
import g2.C2048f;

/* renamed from: r2.I  reason: case insensitive filesystem */
public final /* synthetic */ class C2227I implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C2048f f21606a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TvMyAppsFragment f21607b;

    public /* synthetic */ C2227I(C2048f fVar, TvMyAppsFragment tvMyAppsFragment) {
        this.f21606a = fVar;
        this.f21607b = tvMyAppsFragment;
    }

    public final void onClick(View view) {
        TvMyAppsFragment.F(this.f21606a, this.f21607b, view);
    }
}
