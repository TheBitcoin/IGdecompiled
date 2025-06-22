package p2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.leanback.widget.Presenter;
import com.uptodown.R;
import g2.C2050h;
import kotlin.jvm.internal.m;
import t2.C2295c;

/* renamed from: p2.b  reason: case insensitive filesystem */
public final class C2203b extends Presenter {

    /* renamed from: a  reason: collision with root package name */
    private C2295c f21469a;

    public final void a(Context context, C2050h hVar) {
        m.e(context, "context");
        C2295c cVar = this.f21469a;
        if (cVar != null) {
            m.b(cVar);
            cVar.d(context, hVar);
        }
    }

    public final void b(int i4) {
        C2295c cVar = this.f21469a;
        if (cVar != null) {
            m.b(cVar);
            cVar.h(i4);
        }
    }

    public final void c(boolean z4) {
        C2295c cVar = this.f21469a;
        if (cVar != null) {
            m.b(cVar);
            cVar.i(z4);
        }
    }

    public void onBindViewHolder(Presenter.ViewHolder viewHolder, Object obj) {
        m.e(viewHolder, "viewHolder");
        m.e(obj, "item");
        C2295c cVar = (C2295c) viewHolder;
        this.f21469a = cVar;
        m.b(cVar);
        Context context = viewHolder.view.getContext();
        m.d(context, "getContext(...)");
        cVar.c(context, (C2050h) obj, 0);
    }

    public Presenter.ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        m.e(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tv_app_detail, viewGroup, false);
        m.b(inflate);
        return new C2295c(inflate);
    }

    public void onUnbindViewHolder(Presenter.ViewHolder viewHolder) {
        m.e(viewHolder, "viewHolder");
    }
}
