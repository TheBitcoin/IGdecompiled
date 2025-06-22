package p2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.leanback.widget.Presenter;
import com.uptodown.R;
import kotlin.jvm.internal.m;
import t2.C2296d;

public final class h extends Presenter {

    /* renamed from: a  reason: collision with root package name */
    private Context f21482a;

    public h(Context context) {
        m.e(context, "context");
        this.f21482a = context;
    }

    public void onBindViewHolder(Presenter.ViewHolder viewHolder, Object obj) {
        m.e(viewHolder, "viewHolder");
        m.e(obj, "item");
        if (viewHolder instanceof C2296d) {
            ((C2296d) viewHolder).b(obj);
        }
    }

    public Presenter.ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        m.e(viewGroup, "parent");
        if (viewGroup.getContext() == null) {
            return null;
        }
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tv_home_card_featured_item, viewGroup, false);
        m.b(inflate);
        return new C2296d(inflate, this.f21482a);
    }

    public void onUnbindViewHolder(Presenter.ViewHolder viewHolder) {
        m.e(viewHolder, "viewHolder");
        if (viewHolder instanceof C2296d) {
            ((C2296d) viewHolder).h();
        }
    }
}
