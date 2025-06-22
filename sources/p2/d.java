package p2;

import N1.k;
import W1.s;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.leanback.widget.Presenter;
import com.uptodown.R;
import com.uptodown.activities.preferences.a;
import com.uptodown.tv.utils.CropImageViewTv;
import g2.C2048f;
import g2.C2050h;
import g2.S;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import u2.F;
import u2.t;
import w2.v;
import y2.h;

public final class d extends Presenter {

    /* renamed from: a  reason: collision with root package name */
    private Context f21470a;

    /* renamed from: b  reason: collision with root package name */
    private CropImageViewTv f21471b;

    /* renamed from: c  reason: collision with root package name */
    private ImageView f21472c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f21473d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f21474e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f21475f;

    public d(Context context) {
        m.e(context, "context");
        this.f21470a = context;
    }

    private final boolean a(C2048f fVar) {
        ApplicationInfo applicationInfo;
        try {
            PackageManager packageManager = this.f21470a.getPackageManager();
            m.d(packageManager, "getPackageManager(...)");
            String o4 = fVar.o();
            m.b(o4);
            applicationInfo = s.a(packageManager, o4, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            applicationInfo = null;
        }
        if (fVar.e() == 0 && applicationInfo != null && applicationInfo.enabled) {
            return true;
        }
        return false;
    }

    private final void b(S s4, TextView textView, TextView textView2) {
        if (s4 == null || s4.m()) {
            textView.setText(this.f21470a.getString(R.string.status_download_installed));
            textView.setTextColor(ContextCompat.getColor(this.f21470a, R.color.download_installed_status));
            textView.setBackground(ContextCompat.getDrawable(this.f21470a, R.drawable.bg_status_download_installed));
        } else {
            textView.setText(this.f21470a.getString(R.string.status_download_update));
            v.d(textView);
        }
        textView.setVisibility(0);
        textView2.setVisibility(8);
    }

    private final void c(String str, TextView textView, TextView textView2) {
        if (new u2.m().s(str, this.f21470a)) {
            t a5 = t.f21927u.a(this.f21470a);
            a5.a();
            m.b(str);
            S D02 = a5.D0(str);
            C2048f Y4 = a5.Y(str);
            a5.i();
            if (Y4 == null) {
                return;
            }
            if (Y4.F() && a.f18818a.f0(this.f21470a) && a(Y4)) {
                b(D02, textView, textView2);
            } else if (!a(Y4) || Y4.F()) {
                textView.setVisibility(8);
                textView2.setVisibility(0);
            } else {
                b(D02, textView, textView2);
            }
        } else {
            textView.setVisibility(8);
            textView2.setVisibility(0);
        }
    }

    private final void d(ImageView imageView, String str, String str2) {
        if (new u2.m().s(str2, this.f21470a)) {
            imageView.setImageDrawable(F.f21886a.k(this.f21470a, str2));
            return;
        }
        com.squareup.picasso.s.h().l(str).l(R.drawable.shape_bg_placeholder).n(new h((int) this.f21470a.getResources().getDimension(R.dimen.border_radius_m), (h.a) null, 2, (C2103g) null)).i(imageView);
    }

    private final void e(String str, String str2, TextView textView, TextView textView2) {
        textView.setText(str);
        textView2.setText(str2);
    }

    public void onBindViewHolder(Presenter.ViewHolder viewHolder, Object obj) {
        m.e(viewHolder, "viewHolder");
        m.e(obj, "item");
        C2050h hVar = (C2050h) obj;
        com.squareup.picasso.s.h().l(hVar.y()).l(R.color.main_blue).i(this.f21471b);
        String L4 = hVar.L();
        String j02 = hVar.j0();
        TextView textView = this.f21473d;
        m.b(textView);
        TextView textView2 = this.f21474e;
        m.b(textView2);
        e(L4, j02, textView, textView2);
        String Q4 = hVar.Q();
        TextView textView3 = this.f21475f;
        m.b(textView3);
        TextView textView4 = this.f21474e;
        m.b(textView4);
        c(Q4, textView3, textView4);
        ImageView imageView = this.f21472c;
        m.b(imageView);
        d(imageView, hVar.E(), hVar.Q());
    }

    public Presenter.ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        m.e(viewGroup, "parent");
        if (viewGroup.getContext() == null) {
            return null;
        }
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tv_card_featured, viewGroup, false);
        this.f21471b = (CropImageViewTv) inflate.findViewById(R.id.iv_featured);
        this.f21472c = (ImageView) inflate.findViewById(R.id.iv_logo_card);
        this.f21473d = (TextView) inflate.findViewById(R.id.tv_titulo_card);
        this.f21474e = (TextView) inflate.findViewById(R.id.tv_resumen_card);
        this.f21475f = (TextView) inflate.findViewById(R.id.tv_status_card);
        TextView textView = this.f21473d;
        if (textView != null) {
            textView.setTypeface(k.f7778g.w());
        }
        TextView textView2 = this.f21474e;
        if (textView2 != null) {
            textView2.setTypeface(k.f7778g.x());
        }
        TextView textView3 = this.f21475f;
        if (textView3 != null) {
            textView3.setTypeface(k.f7778g.x());
        }
        return new Presenter.ViewHolder(inflate);
    }

    public void onUnbindViewHolder(Presenter.ViewHolder viewHolder) {
        m.e(viewHolder, "viewHolder");
    }
}
