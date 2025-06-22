package androidx.leanback.widget;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.RestrictTo;
import androidx.leanback.R;
import androidx.leanback.widget.Presenter;

public class DividerPresenter extends Presenter {
    private final int mLayoutResourceId;

    public DividerPresenter() {
        this(R.layout.lb_divider);
    }

    public void onBindViewHolder(Presenter.ViewHolder viewHolder, Object obj) {
    }

    public Presenter.ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        return new Presenter.ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(this.mLayoutResourceId, viewGroup, false));
    }

    public void onUnbindViewHolder(Presenter.ViewHolder viewHolder) {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public DividerPresenter(int i4) {
        this.mLayoutResourceId = i4;
    }
}
