package x2;

import N1.k;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import c2.T0;
import com.uptodown.R;
import f2.L;
import g2.V;
import kotlin.jvm.internal.m;
import u2.q;

public final class p1 extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    private final T0 f22473a;

    /* renamed from: b  reason: collision with root package name */
    private final L f22474b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public p1(T0 t02, L l4) {
        super(t02.getRoot());
        m.e(t02, "binding");
        this.f22473a = t02;
        this.f22474b = l4;
        t02.getRoot().setOnClickListener(new n1(this));
        t02.f10033c.setOnClickListener(new o1(this));
        TextView textView = t02.f10036f;
        k.a aVar = k.f7778g;
        textView.setTypeface(aVar.w());
        t02.f10035e.setTypeface(aVar.x());
    }

    /* access modifiers changed from: private */
    public static final void c(p1 p1Var, View view) {
        p1Var.f();
    }

    /* access modifiers changed from: private */
    public static final void d(p1 p1Var, View view) {
        p1Var.f();
    }

    private final void f() {
        int bindingAdapterPosition;
        if (this.f22474b != null && (bindingAdapterPosition = getBindingAdapterPosition()) != -1) {
            this.f22474b.a(bindingAdapterPosition);
        }
    }

    public final void e(V v4) {
        m.e(v4, "userDevice");
        this.f22473a.f10036f.setText(v4.g());
        this.f22473a.f10035e.setText(new q().m(v4.e()));
        int j4 = v4.j();
        if (j4 == 0) {
            this.f22473a.f10032b.setImageDrawable(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.vector_user_device_mobile_item));
        } else if (j4 == 1) {
            this.f22473a.f10032b.setImageDrawable(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.vector_user_device_tablet_item));
        } else if (j4 == 2) {
            this.f22473a.f10032b.setImageDrawable(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.vector_user_device_tv_item));
        }
    }
}
