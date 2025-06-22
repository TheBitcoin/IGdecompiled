package p2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.leanback.widget.Presenter;
import com.uptodown.R;
import kotlin.jvm.internal.m;
import n2.b;
import t2.C2298f;

public final class l extends Presenter {

    /* renamed from: a  reason: collision with root package name */
    private int f21485a = -1;

    /* renamed from: b  reason: collision with root package name */
    private int f21486b = -1;

    /* access modifiers changed from: private */
    public static final void b(l lVar, View view, boolean z4) {
        m.b(view);
        lVar.c(view, z4);
    }

    private final void c(View view, boolean z4) {
        int i4;
        if (z4) {
            i4 = this.f21485a;
        } else {
            i4 = this.f21486b;
        }
        view.setBackgroundColor(i4);
    }

    public void onBindViewHolder(Presenter.ViewHolder viewHolder, Object obj) {
        m.e(viewHolder, "viewHolder");
        m.e(obj, "object");
        ((C2298f) viewHolder).a((b) obj);
    }

    public Presenter.ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        m.e(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tv_manage_apps_item, viewGroup, false);
        this.f21486b = ContextCompat.getColor(viewGroup.getContext(), R.color.main_blue);
        this.f21485a = ContextCompat.getColor(viewGroup.getContext(), R.color.main_blue_pressed);
        inflate.setFocusable(true);
        inflate.setFocusableInTouchMode(true);
        inflate.setOnFocusChangeListener(new k(this));
        m.b(inflate);
        c(inflate, false);
        return new C2298f(inflate);
    }

    public void onUnbindViewHolder(Presenter.ViewHolder viewHolder) {
        m.e(viewHolder, "viewHolder");
    }
}
