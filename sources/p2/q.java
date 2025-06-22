package p2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.leanback.widget.Presenter;
import com.uptodown.R;
import g2.C2050h;
import kotlin.jvm.internal.m;
import t2.i;

public final class q extends Presenter {

    /* renamed from: a  reason: collision with root package name */
    private int f21498a = -1;

    /* renamed from: b  reason: collision with root package name */
    private int f21499b = -1;

    /* access modifiers changed from: private */
    public static final void b(q qVar, View view, boolean z4) {
        m.b(view);
        qVar.c(view, z4);
    }

    private final void c(View view, boolean z4) {
        int i4;
        if (z4) {
            i4 = this.f21498a;
        } else {
            i4 = this.f21499b;
        }
        view.setBackgroundColor(i4);
    }

    public void onBindViewHolder(Presenter.ViewHolder viewHolder, Object obj) {
        m.e(viewHolder, "viewHolder");
        m.e(obj, "object");
        ((i) viewHolder).a((C2050h) obj);
    }

    public Presenter.ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        m.e(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tv_program_day, viewGroup, false);
        this.f21499b = ContextCompat.getColor(viewGroup.getContext(), R.color.main_blue);
        this.f21498a = ContextCompat.getColor(viewGroup.getContext(), R.color.main_blue_pressed);
        inflate.setFocusable(true);
        inflate.setFocusableInTouchMode(true);
        inflate.setOnFocusChangeListener(new p(this));
        m.b(inflate);
        c(inflate, false);
        return new i(inflate);
    }

    public void onUnbindViewHolder(Presenter.ViewHolder viewHolder) {
        m.e(viewHolder, "viewHolder");
    }
}
