package p2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.leanback.widget.Presenter;
import com.uptodown.R;
import java.io.File;
import kotlin.jvm.internal.m;
import t2.C2299g;

public final class n extends Presenter {

    /* renamed from: a  reason: collision with root package name */
    private int f21493a = -1;

    /* renamed from: b  reason: collision with root package name */
    private int f21494b = -1;

    private final void a(View view, boolean z4) {
        int i4;
        if (z4) {
            i4 = this.f21493a;
        } else {
            i4 = this.f21494b;
        }
        view.setBackgroundColor(i4);
    }

    public void onBindViewHolder(Presenter.ViewHolder viewHolder, Object obj) {
        m.e(viewHolder, "viewHolder");
        m.e(obj, "item");
        ((C2299g) viewHolder).a((File) obj, viewHolder.view.getContext());
    }

    public Presenter.ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        m.e(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tv_download_item, viewGroup, false);
        this.f21494b = ContextCompat.getColor(viewGroup.getContext(), R.color.tv_default_background);
        this.f21493a = ContextCompat.getColor(viewGroup.getContext(), R.color.tv_selected_background);
        inflate.setFocusable(true);
        inflate.setFocusableInTouchMode(true);
        m.b(inflate);
        a(inflate, false);
        return new C2299g(inflate);
    }

    public void onUnbindViewHolder(Presenter.ViewHolder viewHolder) {
        m.e(viewHolder, "viewHolder");
    }
}
