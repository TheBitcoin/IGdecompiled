package r2;

import androidx.leanback.widget.OnItemViewClickedListener;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.Row;
import androidx.leanback.widget.RowPresenter;
import com.uptodown.tv.ui.fragment.TvSearchFragment;

/* renamed from: r2.S  reason: case insensitive filesystem */
public final /* synthetic */ class C2236S implements OnItemViewClickedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TvSearchFragment f21619a;

    public /* synthetic */ C2236S(TvSearchFragment tvSearchFragment) {
        this.f21619a = tvSearchFragment;
    }

    public final void onItemClicked(Presenter.ViewHolder viewHolder, Object obj, RowPresenter.ViewHolder viewHolder2, Object obj2) {
        TvSearchFragment.i(this.f21619a, viewHolder, obj, viewHolder2, (Row) obj2);
    }
}
