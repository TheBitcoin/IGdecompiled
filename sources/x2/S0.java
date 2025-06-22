package x2;

import N1.k;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import f2.C2011b;
import kotlin.jvm.internal.m;

public final class S0 extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    private final C2011b f22262a;

    /* renamed from: b  reason: collision with root package name */
    private final ImageView f22263b;

    /* renamed from: c  reason: collision with root package name */
    private final TextView f22264c;

    /* renamed from: d  reason: collision with root package name */
    private final TextView f22265d;

    /* renamed from: e  reason: collision with root package name */
    private final TextView f22266e;

    /* renamed from: f  reason: collision with root package name */
    private final TextView f22267f;

    /* renamed from: g  reason: collision with root package name */
    private final TextView f22268g;

    /* renamed from: h  reason: collision with root package name */
    private final RelativeLayout f22269h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public S0(View view, C2011b bVar) {
        super(view);
        m.e(view, "itemView");
        this.f22262a = bVar;
        View findViewById = view.findViewById(R.id.iv_icon_installed_app_item);
        m.d(findViewById, "findViewById(...)");
        this.f22263b = (ImageView) findViewById;
        View findViewById2 = view.findViewById(R.id.tv_name_installed_app_item);
        m.d(findViewById2, "findViewById(...)");
        TextView textView = (TextView) findViewById2;
        this.f22264c = textView;
        View findViewById3 = view.findViewById(R.id.tv_version_installed_app_item);
        m.d(findViewById3, "findViewById(...)");
        TextView textView2 = (TextView) findViewById3;
        this.f22265d = textView2;
        View findViewById4 = view.findViewById(R.id.tv_size_installed_app_item);
        m.d(findViewById4, "findViewById(...)");
        TextView textView3 = (TextView) findViewById4;
        this.f22266e = textView3;
        View findViewById5 = view.findViewById(R.id.tv_last_update_installed_app_item);
        m.d(findViewById5, "findViewById(...)");
        TextView textView4 = (TextView) findViewById5;
        this.f22267f = textView4;
        View findViewById6 = view.findViewById(R.id.tv_excluded_installed_app_item);
        m.d(findViewById6, "findViewById(...)");
        TextView textView5 = (TextView) findViewById6;
        this.f22268g = textView5;
        View findViewById7 = view.findViewById(R.id.rl_installed_app_item);
        m.d(findViewById7, "findViewById(...)");
        RelativeLayout relativeLayout = (RelativeLayout) findViewById7;
        this.f22269h = relativeLayout;
        k.a aVar = k.f7778g;
        textView.setTypeface(aVar.w());
        textView2.setTypeface(aVar.w());
        textView3.setTypeface(aVar.x());
        textView4.setTypeface(aVar.x());
        textView5.setTypeface(aVar.w());
        relativeLayout.setOnClickListener(new R0(this));
    }

    /* access modifiers changed from: private */
    public static final void b(S0 s02, View view) {
        int bindingAdapterPosition;
        if (s02.f22262a != null && (bindingAdapterPosition = s02.getBindingAdapterPosition()) != -1) {
            s02.f22262a.a(bindingAdapterPosition);
        }
    }
}
