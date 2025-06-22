package p2;

import N1.k;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.leanback.widget.Presenter;
import com.uptodown.R;
import g2.C2053k;
import kotlin.jvm.internal.m;

public final class g extends Presenter {
    public void onBindViewHolder(Presenter.ViewHolder viewHolder, Object obj) {
        m.e(viewHolder, "viewHolder");
        m.e(obj, "item");
        TextView textView = (TextView) viewHolder.view.findViewById(R.id.tv_name);
        textView.setTypeface(k.f7778g.w());
        textView.setText(((C2053k) obj).d());
    }

    public Presenter.ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        m.e(viewGroup, "parent");
        return new Presenter.ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tv_category_tag, viewGroup, false));
    }

    public void onUnbindViewHolder(Presenter.ViewHolder viewHolder) {
        m.e(viewHolder, "viewHolder");
    }
}
