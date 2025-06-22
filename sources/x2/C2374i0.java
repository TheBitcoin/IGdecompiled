package x2;

import N1.k;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import c2.C1682o0;
import com.squareup.picasso.s;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import f2.V;
import g2.C2039G;
import kotlin.jvm.internal.m;
import u2.q;
import w2.v;

/* renamed from: x2.i0  reason: case insensitive filesystem */
public final class C2374i0 extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    private final C1682o0 f22402a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f22403b;

    /* renamed from: c  reason: collision with root package name */
    private final V f22404c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f22405d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2374i0(C1682o0 o0Var, Context context, V v4, boolean z4) {
        super(o0Var.getRoot());
        m.e(o0Var, "binding");
        m.e(context, "context");
        this.f22402a = o0Var;
        this.f22403b = context;
        this.f22404c = v4;
        this.f22405d = z4;
        o0Var.f10689d.setOnClickListener(new C2370g0(this));
        o0Var.f10690e.setOnClickListener(new C2372h0(this));
        TextView textView = o0Var.f10692g;
        k.a aVar = k.f7778g;
        textView.setTypeface(aVar.w());
        o0Var.f10690e.setTypeface(aVar.w());
        o0Var.f10691f.setTypeface(aVar.x());
    }

    /* access modifiers changed from: private */
    public static final void c(C2374i0 i0Var, View view) {
        int bindingAdapterPosition;
        if (i0Var.f22404c != null && (bindingAdapterPosition = i0Var.getBindingAdapterPosition()) != -1) {
            i0Var.f22404c.a(bindingAdapterPosition);
        }
    }

    /* access modifiers changed from: private */
    public static final void d(C2374i0 i0Var, View view) {
        int bindingAdapterPosition;
        if (i0Var.f22404c != null && (bindingAdapterPosition = i0Var.getBindingAdapterPosition()) != -1) {
            i0Var.f22404c.f(bindingAdapterPosition);
        }
    }

    public final void e(C2039G g4) {
        m.e(g4, "item");
        s.h().l(g4.e()).l(R.drawable.shape_bg_placeholder).n(UptodownApp.f17422D.i0(this.f22403b)).i(this.f22402a.f10687b);
        this.f22402a.f10692g.setText(g4.f());
        this.f22402a.f10691f.setText(new q().m(g4.b()));
        if (this.f22405d) {
            this.f22402a.f10690e.setText(this.f22403b.getString(R.string.cancel_registration));
            TextView textView = this.f22402a.f10690e;
            m.d(textView, "tvActionUpcomingReleaseItem");
            v.e(textView);
            return;
        }
        this.f22402a.f10690e.setText(this.f22403b.getString(R.string.pre_registration_title));
        TextView textView2 = this.f22402a.f10690e;
        m.d(textView2, "tvActionUpcomingReleaseItem");
        v.a(textView2);
    }
}
