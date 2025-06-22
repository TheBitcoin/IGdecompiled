package r2;

import androidx.fragment.app.FragmentActivity;
import androidx.leanback.widget.Action;
import androidx.leanback.widget.OnActionClickedListener;
import com.uptodown.tv.ui.fragment.TvAppDetailFragment;

/* renamed from: r2.j  reason: case insensitive filesystem */
public final /* synthetic */ class C2246j implements OnActionClickedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TvAppDetailFragment f21643a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FragmentActivity f21644b;

    public /* synthetic */ C2246j(TvAppDetailFragment tvAppDetailFragment, FragmentActivity fragmentActivity) {
        this.f21643a = tvAppDetailFragment;
        this.f21644b = fragmentActivity;
    }

    public final void onActionClicked(Action action) {
        TvAppDetailFragment.J0(this.f21643a, this.f21644b, action);
    }
}
