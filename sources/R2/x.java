package r2;

import androidx.leanback.widget.OnItemViewClickedListener;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.Row;
import androidx.leanback.widget.RowPresenter;

public final /* synthetic */ class x implements OnItemViewClickedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ z f21680a;

    public /* synthetic */ x(z zVar) {
        this.f21680a = zVar;
    }

    public final void onItemClicked(Presenter.ViewHolder viewHolder, Object obj, RowPresenter.ViewHolder viewHolder2, Object obj2) {
        z.l(this.f21680a, viewHolder, obj, viewHolder2, (Row) obj2);
    }
}
