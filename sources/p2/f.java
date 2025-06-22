package p2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.leanback.widget.Presenter;
import com.uptodown.R;
import kotlin.jvm.internal.m;
import t2.C2297e;

public final class f extends Presenter {

    /* renamed from: a  reason: collision with root package name */
    private Context f21481a;

    public f(Context context) {
        m.e(context, "context");
        this.f21481a = context;
    }

    public void onBindViewHolder(Presenter.ViewHolder viewHolder, Object obj) {
        m.e(viewHolder, "viewHolder");
        m.e(obj, "item");
        if (viewHolder instanceof C2297e) {
            ((C2297e) viewHolder).b(obj);
        }
    }

    public Presenter.ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        m.e(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tv_card_small_item, viewGroup, false);
        m.b(inflate);
        return new C2297e(inflate, this.f21481a);
    }

    public void onUnbindViewHolder(Presenter.ViewHolder viewHolder) {
        m.e(viewHolder, "viewHolder");
        if (viewHolder instanceof C2297e) {
            ((C2297e) viewHolder).h();
        }
    }
}
