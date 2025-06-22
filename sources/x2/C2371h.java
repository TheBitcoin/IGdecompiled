package x2;

import N1.k;
import T1.a;
import W1.i;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import f2.C2011b;
import g2.C2048f;
import g2.S;
import kotlin.jvm.internal.m;
import u2.F;
import u2.q;
import u2.t;

/* renamed from: x2.h  reason: case insensitive filesystem */
public final class C2371h extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    private final C2011b f22389a;

    /* renamed from: b  reason: collision with root package name */
    private final ImageView f22390b;

    /* renamed from: c  reason: collision with root package name */
    private final TextView f22391c;

    /* renamed from: d  reason: collision with root package name */
    private final TextView f22392d;

    /* renamed from: e  reason: collision with root package name */
    private final TextView f22393e;

    /* renamed from: f  reason: collision with root package name */
    private final TextView f22394f;

    /* renamed from: g  reason: collision with root package name */
    private final TextView f22395g;

    /* renamed from: h  reason: collision with root package name */
    private final RelativeLayout f22396h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2371h(View view, C2011b bVar) {
        super(view);
        m.e(view, "itemView");
        this.f22389a = bVar;
        View findViewById = view.findViewById(R.id.iv_icon_installed_app_item);
        m.d(findViewById, "findViewById(...)");
        this.f22390b = (ImageView) findViewById;
        View findViewById2 = view.findViewById(R.id.tv_name_installed_app_item);
        m.d(findViewById2, "findViewById(...)");
        TextView textView = (TextView) findViewById2;
        this.f22391c = textView;
        View findViewById3 = view.findViewById(R.id.tv_version_installed_app_item);
        m.d(findViewById3, "findViewById(...)");
        TextView textView2 = (TextView) findViewById3;
        this.f22392d = textView2;
        View findViewById4 = view.findViewById(R.id.tv_size_installed_app_item);
        m.d(findViewById4, "findViewById(...)");
        TextView textView3 = (TextView) findViewById4;
        this.f22393e = textView3;
        View findViewById5 = view.findViewById(R.id.tv_last_update_installed_app_item);
        m.d(findViewById5, "findViewById(...)");
        TextView textView4 = (TextView) findViewById5;
        this.f22394f = textView4;
        View findViewById6 = view.findViewById(R.id.tv_excluded_installed_app_item);
        m.d(findViewById6, "findViewById(...)");
        TextView textView5 = (TextView) findViewById6;
        this.f22395g = textView5;
        View findViewById7 = view.findViewById(R.id.rl_installed_app_item);
        m.d(findViewById7, "findViewById(...)");
        RelativeLayout relativeLayout = (RelativeLayout) findViewById7;
        this.f22396h = relativeLayout;
        k.a aVar = k.f7778g;
        textView.setTypeface(aVar.w());
        textView2.setTypeface(aVar.w());
        textView3.setTypeface(aVar.x());
        textView4.setTypeface(aVar.x());
        textView5.setTypeface(aVar.w());
        relativeLayout.setOnClickListener(new C2369g(this));
    }

    /* access modifiers changed from: private */
    public static final void b(C2371h hVar, View view) {
        int bindingAdapterPosition;
        if (hVar.f22389a != null && (bindingAdapterPosition = hVar.getBindingAdapterPosition()) != -1) {
            hVar.f22389a.a(bindingAdapterPosition);
        }
    }

    private final void d(C2048f fVar) {
        if (fVar.d()) {
            this.itemView.setAlpha(0.3f);
        } else {
            this.itemView.setAlpha(1.0f);
        }
    }

    public final void c(C2048f fVar) {
        String str;
        if (fVar != null) {
            d(fVar);
            t.a aVar = t.f21927u;
            Context context = this.itemView.getContext();
            m.d(context, "getContext(...)");
            t a5 = aVar.a(context);
            a5.a();
            String o4 = fVar.o();
            m.b(o4);
            S D02 = a5.D0(o4);
            a5.i();
            F f4 = F.f21886a;
            Context context2 = this.itemView.getContext();
            m.d(context2, "getContext(...)");
            this.f22390b.setImageDrawable(f4.k(context2, fVar.o()));
            this.f22391c.setText(fVar.m());
            this.f22392d.setText(fVar.B());
            TextView textView = this.f22393e;
            i iVar = new i();
            long t4 = fVar.t();
            Context context3 = this.itemView.getContext();
            m.d(context3, "getContext(...)");
            textView.setText(iVar.d(t4, context3));
            this.f22394f.setText(new q().k(fVar.j()));
            if (UptodownApp.f17422D.K()) {
                String k4 = new q().k(fVar.j());
                u2.m mVar = new u2.m();
                Context context4 = this.itemView.getContext();
                m.d(context4, "getContext(...)");
                String o5 = fVar.o();
                m.b(o5);
                String h4 = mVar.h(context4, o5);
                if (h4 != null) {
                    k4 = new q().k(fVar.j()) + " (" + h4 + ')';
                }
                this.f22394f.setText(k4);
            }
            a i4 = k.f7778g.i();
            if (i4 != null) {
                str = i4.b();
            } else {
                str = null;
            }
            if (m3.m.p(str, fVar.o(), true)) {
                this.f22392d.setText(R.string.installing);
            }
            if (fVar.e() == 1) {
                this.f22395g.setText(this.itemView.getContext().getString(R.string.disabled_updates));
                this.f22395g.setVisibility(0);
            } else if (D02 == null || D02.e() != 1) {
                this.f22395g.setVisibility(8);
            } else {
                this.f22395g.setText(this.itemView.getContext().getString(R.string.skipped_update));
                this.f22395g.setVisibility(0);
            }
        }
    }
}
