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
import u2.F;
import u2.t;
import w2.v;
import y2.h;

/* renamed from: t2.e  reason: case insensitive filesystem */
public final class C2297e extends Presenter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    private Context f21837a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView f21838b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f21839c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f21840d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f21841e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2297e(View view, Context context) {
        super(view);
        m.e(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        m.e(context, "context");
        this.f21837a = context;
        this.f21838b = (ImageView) view.findViewById(R.id.iv_logo_home_card_item);
        this.f21839c = (TextView) view.findViewById(R.id.tv_name_home_card_item);
        this.f21840d = (TextView) view.findViewById(R.id.tv_desc_home_card_item);
        this.f21841e = (TextView) view.findViewById(R.id.tv_status_home_card_item);
        TextView textView = this.f21839c;
        if (textView != null) {
            textView.setTypeface(k.f7778g.w());
        }
        TextView textView2 = this.f21840d;
        if (textView2 != null) {
            textView2.setTypeface(k.f7778g.x());
        }
        TextView textView3 = this.f21841e;
        if (textView3 != null) {
            textView3.setTypeface(k.f7778g.x());
        }
    }

    private final boolean a(C2048f fVar) {
        ApplicationInfo applicationInfo;
        try {
            PackageManager packageManager = this.f21837a.getPackageManager();
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
            textView.setText(this.f21837a.getString(R.string.status_download_installed));
            textView.setTextColor(ContextCompat.getColor(this.f21837a, R.color.download_installed_status));
            textView.setBackground(ContextCompat.getDrawable(this.f21837a, R.drawable.bg_status_download_installed));
        } else {
            textView.setText(this.f21837a.getString(R.string.status_download_update));
            v.d(textView);
        }
        textView.setVisibility(0);
        if (z4) {
            textView2.setVisibility(8);
        }
    }

    private final void d(String str, TextView textView, TextView textView2, boolean z4) {
        if (new u2.m().s(str, this.f21837a)) {
            t a5 = t.f21927u.a(this.f21837a);
            a5.a();
            m.b(str);
            S D02 = a5.D0(str);
            C2048f Y4 = a5.Y(str);
            a5.i();
            if (Y4 == null) {
                return;
            }
            if (Y4.F() && a.f18818a.f0(this.f21837a) && a(Y4)) {
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

    static /* synthetic */ void e(C2297e eVar, String str, TextView textView, TextView textView2, boolean z4, int i4, Object obj) {
        if ((i4 & 8) != 0) {
            z4 = true;
        }
        eVar.d(str, textView, textView2, z4);
    }

    private final void f(ImageView imageView, String str, String str2) {
        if (new u2.m().s(str2, this.f21837a)) {
            imageView.setImageDrawable(F.f21886a.k(this.f21837a, str2));
            return;
        }
        com.squareup.picasso.s.h().l(str).l(R.drawable.shape_bg_placeholder).n(new h((int) this.f21837a.getResources().getDimension(R.dimen.border_radius_s), (h.a) null, 2, (C2103g) null)).i(imageView);
    }

    private final void g(String str, String str2, TextView textView, TextView textView2) {
        textView.setText(str);
        textView2.setText(str2);
    }

    public final void b(Object obj) {
        m.e(obj, "item");
        if (obj instanceof C2050h) {
            C2050h hVar = (C2050h) obj;
            String L4 = hVar.L();
            String j02 = hVar.j0();
            TextView textView = this.f21839c;
            m.b(textView);
            TextView textView2 = this.f21840d;
            m.b(textView2);
            g(L4, j02, textView, textView2);
            String Q4 = hVar.Q();
            TextView textView3 = this.f21841e;
            m.b(textView3);
            TextView textView4 = this.f21840d;
            m.b(textView4);
            e(this, Q4, textView3, textView4, false, 8, (Object) null);
            ImageView imageView = this.f21838b;
            m.b(imageView);
            f(imageView, hVar.E(), hVar.Q());
            return;
        }
        if (obj instanceof c) {
            C2053k a5 = ((c) obj).a();
            m.b(a5);
            String d5 = a5.d();
            TextView textView5 = this.f21839c;
            m.b(textView5);
            TextView textView6 = this.f21840d;
            m.b(textView6);
            g(d5, (String) null, textView5, textView6);
            TextView textView7 = this.f21841e;
            if (textView7 != null) {
                textView7.setVisibility(8);
            }
            int color = ContextCompat.getColor(this.f21837a, R.color.main_blue);
            Drawable drawable = ContextCompat.getDrawable(this.f21837a, R.drawable.vector_plus);
            if (drawable != null) {
                drawable.setTint(color);
            }
            ImageView imageView2 = this.f21838b;
            if (imageView2 != null) {
                imageView2.setImageDrawable(drawable);
                return;
            }
            return;
        }
        throw new Exception("item unknown!");
    }

    public final void h() {
        ImageView imageView = this.f21838b;
        if (imageView != null) {
            imageView.setImageDrawable((Drawable) null);
        }
        TextView textView = this.f21839c;
        if (textView != null) {
            textView.setText((CharSequence) null);
        }
        TextView textView2 = this.f21840d;
        if (textView2 != null) {
            textView2.setText((CharSequence) null);
        }
        TextView textView3 = this.f21841e;
        if (textView3 != null) {
            textView3.setText((CharSequence) null);
        }
    }
}
