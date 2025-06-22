package x2;

import N1.k;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mbridge.msdk.MBridgeConstans;
import com.uptodown.R;
import f2.C2011b;
import g2.C2048f;
import kotlin.jvm.internal.m;
import u2.F;

/* renamed from: x2.A  reason: case insensitive filesystem */
public final class C2350A extends C2381m {

    /* renamed from: b  reason: collision with root package name */
    private final C2011b f22086b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f22087c;

    /* renamed from: d  reason: collision with root package name */
    private final ImageView f22088d;

    /* renamed from: e  reason: collision with root package name */
    private final TextView f22089e;

    /* renamed from: f  reason: collision with root package name */
    private final TextView f22090f;

    /* renamed from: g  reason: collision with root package name */
    private final TextView f22091g;

    /* renamed from: h  reason: collision with root package name */
    private final RelativeLayout f22092h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2350A(View view, C2011b bVar, Context context) {
        super(view);
        m.e(view, "itemView");
        m.e(context, "context");
        this.f22086b = bVar;
        this.f22087c = context;
        View findViewById = view.findViewById(R.id.iv_icon_free_up_item);
        m.d(findViewById, "findViewById(...)");
        this.f22088d = (ImageView) findViewById;
        View findViewById2 = view.findViewById(R.id.tv_name_free_up_item);
        m.d(findViewById2, "findViewById(...)");
        TextView textView = (TextView) findViewById2;
        this.f22089e = textView;
        View findViewById3 = view.findViewById(R.id.tv_size_free_up_item);
        m.d(findViewById3, "findViewById(...)");
        TextView textView2 = (TextView) findViewById3;
        this.f22090f = textView2;
        View findViewById4 = view.findViewById(R.id.tv_action_free_up_item);
        m.d(findViewById4, "findViewById(...)");
        TextView textView3 = (TextView) findViewById4;
        this.f22091g = textView3;
        View findViewById5 = view.findViewById(R.id.rl_container_free_up_item);
        m.d(findViewById5, "findViewById(...)");
        RelativeLayout relativeLayout = (RelativeLayout) findViewById5;
        this.f22092h = relativeLayout;
        relativeLayout.setOnClickListener(new C2404y(this));
        textView3.setOnClickListener(new C2406z(this));
        k.a aVar = k.f7778g;
        textView.setTypeface(aVar.w());
        textView3.setTypeface(aVar.w());
        textView2.setTypeface(aVar.x());
    }

    /* access modifiers changed from: private */
    public static final void i(C2350A a5, View view) {
        int bindingAdapterPosition;
        if (a5.f22086b != null && (bindingAdapterPosition = a5.getBindingAdapterPosition()) != -1) {
            a5.f22086b.a(bindingAdapterPosition);
        }
    }

    /* access modifiers changed from: private */
    public static final void j(C2350A a5, View view) {
        C2011b bVar = a5.f22086b;
        if (bVar != null) {
            bVar.a(a5.getBindingAdapterPosition());
        }
    }

    public final void k(C2048f fVar) {
        m.e(fVar, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
        this.f22089e.setText(fVar.m());
        this.f22090f.setText(fVar.u(this.f22087c));
        this.f22088d.setImageDrawable(F.f21886a.k(this.f22087c, fVar.o()));
    }
}
