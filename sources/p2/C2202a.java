package p2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.leanback.widget.Action;
import androidx.leanback.widget.Presenter;
import com.uptodown.R;
import kotlin.jvm.internal.m;

/* renamed from: p2.a  reason: case insensitive filesystem */
public final class C2202a extends Presenter {
    public void onBindViewHolder(Presenter.ViewHolder viewHolder, Object obj) {
        m.e(viewHolder, "viewHolder");
        m.e(obj, "item");
        View view = viewHolder.view;
        m.c(view, "null cannot be cast to non-null type android.widget.Button");
        ((Button) view).setText(((Action) obj).getLabel1());
    }

    public Presenter.ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        m.e(viewGroup, "parent");
        return new Presenter.ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tv_custom_action, viewGroup, false));
    }

    public void onUnbindViewHolder(Presenter.ViewHolder viewHolder) {
        m.e(viewHolder, "viewHolder");
    }
}
