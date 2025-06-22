package p2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.leanback.widget.Presenter;
import com.uptodown.R;
import g2.C2035C;
import g2.C2048f;
import kotlin.jvm.internal.m;
import t2.C2300h;

public final class o extends Presenter {

    /* renamed from: a  reason: collision with root package name */
    private String f21495a;

    /* renamed from: b  reason: collision with root package name */
    private C2048f f21496b;

    public o(String str) {
        this.f21495a = str;
    }

    public void onBindViewHolder(Presenter.ViewHolder viewHolder, Object obj) {
        m.e(viewHolder, "viewHolder");
        m.e(obj, "object");
        C2300h hVar = (C2300h) viewHolder;
        Context context = viewHolder.view.getContext();
        m.d(context, "getContext(...)");
        hVar.a((C2035C) obj, context, this.f21495a, this.f21496b);
    }

    public Presenter.ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        m.e(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tv_old_version_item, viewGroup, false);
        inflate.setFocusable(true);
        inflate.setFocusableInTouchMode(true);
        inflate.setBackgroundColor(ContextCompat.getColor(viewGroup.getContext(), R.color.white));
        m.b(inflate);
        return new C2300h(inflate);
    }

    public void onUnbindViewHolder(Presenter.ViewHolder viewHolder) {
        m.e(viewHolder, "viewHolder");
    }

    public o(C2048f fVar) {
        m.e(fVar, "appInstalled");
        this.f21495a = fVar.o();
        this.f21496b = fVar;
    }
}
