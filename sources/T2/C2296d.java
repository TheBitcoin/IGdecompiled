package t2;

import N1.k;
import W1.s;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.leanback.widget.Presenter;
import com.mbridge.msdk.MBridgeConstans;
import com.uptodown.R;
import com.uptodown.activities.preferences.a;
import g2.C2048f;
import g2.C2050h;
import g2.C2053k;
import g2.S;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import n2.c;
import u2.t;
import w2.v;
import y2.h;

/* renamed from: t2.d  reason: case insensitive filesystem */
public final class C2296d extends Presenter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    private Context f21831a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView f21832b;

    /* renamed from: c  reason: collision with root package name */
    private ImageView f21833c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f21834d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f21835e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f21836f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2296d(View view, Context context) {
        super(view);
        m.e(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        m.e(context, "context");
        this.f21831a = context;
        View findViewById = view.findViewById(R.id.iv_home_card_featured_item);
        m.d(findViewById, "findViewById(...)");
        this.f21832b = (ImageView) findViewById;
        View findViewById2 = view.findViewById(R.id.iv_logo_home_card_featured_item);
        m.d(findViewById2, "findViewById(...)");
        this.f21833c = (ImageView) findViewById2;
        View findViewById3 = view.findViewById(R.id.tv_name_home_card_featured_item);
        m.d(findViewById3, "findViewById(...)");
        this.f21834d = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.tv_desc_home_card_featured_item);
        m.d(findViewById4, "findViewById(...)");
        this.f21835e = (TextView) findViewById4;
        View findViewById5 = view.findViewById(R.id.tv_status_home_card_featured_item);
        m.d(findViewById5, "findViewById(...)");
        this.f21836f = (TextView) findViewById5;
        TextView textView = this.f21834d;
        k.a aVar = k.f7778g;
        textView.setTypeface(aVar.w());
        this.f21835e.setTypeface(aVar.x());
        this.f21836f.setTypeface(aVar.x());
    }

    private final boolean a(C2048f fVar) {
        ApplicationInfo applicationInfo;
        try {
            PackageManager packageManager = this.f21831a.getPackageManager();
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

    private final void c(S s4, TextView textView, TextView textView2, boolean z4) {
        if (s4 == null || s4.m()) {
            textView.setText(this.f21831a.getString(R.string.status_download_installed));
            textView.setTextColor(ContextCompat.getColor(this.f21831a, R.color.download_installed_status));
            textView.setBackground(ContextCompat.getDrawable(this.f21831a, R.drawable.bg_status_download_installed));
        } else {
            textView.setText(this.f21831a.getString(R.string.status_download_update));
            v.d(textView);
        }
        textView.setVisibility(0);
        if (z4) {
            textView2.setVisibility(8);
        }
    }

    private final void d(String str, TextView textView, TextView textView2, boolean z4) {
        if (new u2.m().s(str, this.f21831a)) {
            t a5 = t.f21927u.a(this.f21831a);
            a5.a();
            m.b(str);
            S D02 = a5.D0(str);
            C2048f Y4 = a5.Y(str);
            a5.i();
            if (Y4 == null) {
                return;
            }
            if (Y4.F() && a.f18818a.f0(this.f21831a) && a(Y4)) {
                c(D02, textView, textView2, z4);
            } else if (!a(Y4) || Y4.F()) {
                textView.setVisibility(8);
                if (z4) {
                    textView2.setVisibility(0);
                }
            } else {
                c(D02, textView, textView2, z4);
            }
        } else {
            if (z4) {
                textView.setVisibility(8);
            } else {
                textView.setVisibility(4);
            }
            textView2.setVisibility(0);
        }
    }

    static /* synthetic */ void e(C2296d dVar, String str, TextView textView, TextView textView2, boolean z4, int i4, Object obj) {
        if ((i4 & 8) != 0) {
            z4 = true;
        }
        dVar.d(str, textView, textView2, z4);
    }

    private final void f(ImageView imageView, String str) {
        if (str != null) {
            com.squareup.picasso.s.h().l(str).l(R.drawable.shape_bg_placeholder).n(new h((int) this.f21831a.getResources().getDimension(R.dimen.border_radius_m), (h.a) null, 2, (C2103g) null)).i(imageView);
            return;
        }
        imageView.setImageDrawable(ContextCompat.getDrawable(this.f21831a, R.drawable.vector_app_icon_placeholder));
    }

    private final void g(String str, String str2, TextView textView, TextView textView2) {
        textView.setText(str);
        textView2.setText(str2);
    }

    public final void b(Object obj) {
        m.e(obj, "item");
        if (obj instanceof C2050h) {
            C2050h hVar = (C2050h) obj;
            String y4 = hVar.y();
            if (y4 == null || y4.length() == 0) {
                this.f21832b.setImageDrawable(ContextCompat.getDrawable(this.f21831a, R.drawable.shape_bg_placeholder));
            } else {
                com.squareup.picasso.s.h().l(hVar.B()).n(new h((int) this.f21831a.getResources().getDimension(R.dimen.border_radius_m), (h.a) null, 2, (C2103g) null)).a().f().l(R.drawable.shape_bg_placeholder).i(this.f21832b);
            }
            g(hVar.L(), hVar.j0(), this.f21834d, this.f21835e);
            e(this, hVar.Q(), this.f21836f, this.f21835e, false, 8, (Object) null);
            f(this.f21833c, hVar.F());
            return;
        }
        if (obj instanceof c) {
            C2053k a5 = ((c) obj).a();
            m.b(a5);
            g(a5.d(), (String) null, this.f21834d, this.f21835e);
            this.f21836f.setVisibility(8);
            int color = ContextCompat.getColor(this.f21831a, R.color.main_blue);
            Drawable drawable = ContextCompat.getDrawable(this.f21831a, R.drawable.vector_plus);
            if (drawable != null) {
                drawable.setTint(color);
            }
            this.f21832b.setImageDrawable(drawable);
            this.f21833c.setImageDrawable((Drawable) null);
            return;
        }
        throw new Exception("item unknown!");
    }

    public final void h() {
        this.f21832b.setImageDrawable((Drawable) null);
        this.f21833c.setImageDrawable((Drawable) null);
        this.f21834d.setText((CharSequence) null);
        this.f21835e.setText((CharSequence) null);
        this.f21836f.setText((CharSequence) null);
    }
}
