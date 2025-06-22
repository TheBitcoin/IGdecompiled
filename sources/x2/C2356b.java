package x2;

import N1.k;
import W1.i;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.mbridge.msdk.MBridgeConstans;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import f2.C2011b;
import g2.C2048f;
import kotlin.jvm.internal.m;
import u2.F;
import u2.q;

/* renamed from: x2.b  reason: case insensitive filesystem */
public final class C2356b extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    private final C2011b f22319a;

    /* renamed from: b  reason: collision with root package name */
    private final ImageView f22320b;

    /* renamed from: c  reason: collision with root package name */
    private final TextView f22321c;

    /* renamed from: d  reason: collision with root package name */
    private final TextView f22322d;

    /* renamed from: e  reason: collision with root package name */
    private final TextView f22323e;

    /* renamed from: f  reason: collision with root package name */
    private final TextView f22324f;

    /* renamed from: g  reason: collision with root package name */
    private final TextView f22325g;

    /* renamed from: h  reason: collision with root package name */
    private final RelativeLayout f22326h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2356b(View view, C2011b bVar) {
        super(view);
        m.e(view, "itemView");
        this.f22319a = bVar;
        View findViewById = view.findViewById(R.id.iv_icon_installed_app_item);
        m.d(findViewById, "findViewById(...)");
        this.f22320b = (ImageView) findViewById;
        View findViewById2 = view.findViewById(R.id.tv_name_installed_app_item);
        m.d(findViewById2, "findViewById(...)");
        TextView textView = (TextView) findViewById2;
        this.f22321c = textView;
        View findViewById3 = view.findViewById(R.id.tv_version_installed_app_item);
        m.d(findViewById3, "findViewById(...)");
        TextView textView2 = (TextView) findViewById3;
        this.f22322d = textView2;
        View findViewById4 = view.findViewById(R.id.tv_size_installed_app_item);
        m.d(findViewById4, "findViewById(...)");
        TextView textView3 = (TextView) findViewById4;
        this.f22323e = textView3;
        View findViewById5 = view.findViewById(R.id.tv_last_update_installed_app_item);
        m.d(findViewById5, "findViewById(...)");
        TextView textView4 = (TextView) findViewById5;
        this.f22324f = textView4;
        View findViewById6 = view.findViewById(R.id.tv_excluded_installed_app_item);
        m.d(findViewById6, "findViewById(...)");
        TextView textView5 = (TextView) findViewById6;
        this.f22325g = textView5;
        View findViewById7 = view.findViewById(R.id.rl_installed_app_item);
        m.d(findViewById7, "findViewById(...)");
        RelativeLayout relativeLayout = (RelativeLayout) findViewById7;
        this.f22326h = relativeLayout;
        k.a aVar = k.f7778g;
        textView.setTypeface(aVar.w());
        textView2.setTypeface(aVar.w());
        textView3.setTypeface(aVar.x());
        textView4.setTypeface(aVar.x());
        textView5.setTypeface(aVar.w());
        relativeLayout.setOnClickListener(new C2353a(this));
    }

    /* access modifiers changed from: private */
    public static final void b(C2356b bVar, View view) {
        int bindingAdapterPosition;
        if (bVar.f22319a != null && (bindingAdapterPosition = bVar.getBindingAdapterPosition()) != -1) {
            bVar.f22319a.a(bindingAdapterPosition);
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
        m.e(fVar, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
        d(fVar);
        F f4 = F.f21886a;
        Context context = this.itemView.getContext();
        m.d(context, "getContext(...)");
        this.f22320b.setImageDrawable(f4.k(context, fVar.o()));
        this.f22321c.setText(fVar.m());
        this.f22322d.setText(fVar.B());
        TextView textView = this.f22323e;
        i iVar = new i();
        long t4 = fVar.t();
        Context context2 = this.itemView.getContext();
        m.d(context2, "getContext(...)");
        textView.setText(iVar.d(t4, context2));
        this.f22324f.setText(new q().k(fVar.j()));
        if (UptodownApp.f17422D.K()) {
            String k4 = new q().k(fVar.j());
            u2.m mVar = new u2.m();
            Context context3 = this.itemView.getContext();
            m.d(context3, "getContext(...)");
            String o4 = fVar.o();
            m.b(o4);
            String h4 = mVar.h(context3, o4);
            if (h4 != null) {
                k4 = new q().k(fVar.j()) + " (" + h4 + ')';
            }
            this.f22324f.setText(k4);
        }
        this.f22325g.setText(this.itemView.getContext().getString(R.string.disabled_updates));
        this.f22325g.setVisibility(0);
    }
}
