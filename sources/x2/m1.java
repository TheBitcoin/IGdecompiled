package x2;

import N1.k;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import c2.R0;
import com.squareup.picasso.s;
import com.squareup.picasso.w;
import com.uptodown.UptodownApp;
import f2.C2011b;
import g2.V;
import kotlin.jvm.internal.m;
import u2.q;

public final class m1 extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    private final R0 f22439a;

    /* renamed from: b  reason: collision with root package name */
    private final C2011b f22440b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public m1(R0 r02, C2011b bVar) {
        super(r02.getRoot());
        m.e(r02, "binding");
        m.e(bVar, "listener");
        this.f22439a = r02;
        this.f22440b = bVar;
        r02.getRoot().setOnClickListener(new k1(this));
        r02.f9982b.setOnClickListener(new l1(this));
        TextView textView = r02.f9987g;
        k.a aVar = k.f7778g;
        textView.setTypeface(aVar.w());
        r02.f9986f.setTypeface(aVar.x());
    }

    /* access modifiers changed from: private */
    public static final void c(m1 m1Var, View view) {
        m1Var.e();
    }

    /* access modifiers changed from: private */
    public static final void d(m1 m1Var, View view) {
        m1Var.e();
    }

    private final void e() {
        int bindingAdapterPosition = getBindingAdapterPosition();
        if (bindingAdapterPosition != -1) {
            this.f22440b.a(bindingAdapterPosition);
        }
    }

    public final void f(V.c cVar) {
        m.e(cVar, "userDeviceApp");
        this.f22439a.f9987g.setText(cVar.c());
        this.f22439a.f9986f.setText(new q().m(cVar.b()));
        w l4 = s.h().l(cVar.a());
        UptodownApp.a aVar = UptodownApp.f17422D;
        Context context = this.itemView.getContext();
        m.d(context, "getContext(...)");
        l4.n(aVar.i0(context)).i(this.f22439a.f9983c);
    }
}
