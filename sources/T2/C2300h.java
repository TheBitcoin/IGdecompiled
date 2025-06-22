package t2;

import N1.k;
import T1.a;
import W1.i;
import W1.s;
import android.content.Context;
import android.content.pm.PackageManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.leanback.widget.Presenter;
import com.uptodown.R;
import g2.C2035C;
import g2.C2048f;
import g2.C2060s;
import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.internal.F;
import kotlin.jvm.internal.m;
import u2.t;

/* renamed from: t2.h  reason: case insensitive filesystem */
public final class C2300h extends Presenter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    private RelativeLayout f21848a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView f21849b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f21850c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f21851d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f21852e;

    /* renamed from: f  reason: collision with root package name */
    private ProgressBar f21853f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f21854g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2300h(View view) {
        super(view);
        m.e(view, "itemView");
        View findViewById = view.findViewById(R.id.rl_tv_old_version_item);
        m.d(findViewById, "findViewById(...)");
        this.f21848a = (RelativeLayout) findViewById;
        View findViewById2 = view.findViewById(R.id.iv_icono_version);
        m.d(findViewById2, "findViewById(...)");
        this.f21849b = (ImageView) findViewById2;
        View findViewById3 = view.findViewById(R.id.tv_name_version);
        m.d(findViewById3, "findViewById(...)");
        this.f21850c = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.tv_size_version);
        m.d(findViewById4, "findViewById(...)");
        this.f21851d = (TextView) findViewById4;
        View findViewById5 = view.findViewById(R.id.tv_version);
        m.d(findViewById5, "findViewById(...)");
        this.f21852e = (TextView) findViewById5;
        View findViewById6 = view.findViewById(R.id.progressbar_downloading_version);
        m.d(findViewById6, "findViewById(...)");
        this.f21853f = (ProgressBar) findViewById6;
        View findViewById7 = view.findViewById(R.id.tv_action_old_version_item);
        m.d(findViewById7, "findViewById(...)");
        this.f21854g = (TextView) findViewById7;
        TextView textView = this.f21850c;
        k.a aVar = k.f7778g;
        textView.setTypeface(aVar.x());
        this.f21851d.setTypeface(aVar.x());
        this.f21852e.setTypeface(aVar.x());
        this.f21854g.setTypeface(aVar.x());
    }

    public final void a(C2035C c5, Context context, String str, C2048f fVar) {
        String str2;
        Long l4;
        boolean z4;
        m.e(c5, "item");
        m.e(context, "context");
        try {
            PackageManager packageManager = context.getPackageManager();
            m.d(packageManager, "getPackageManager(...)");
            m.b(str);
            this.f21849b.setImageDrawable(s.d(packageManager, str, 0).applicationInfo.loadIcon(context.getPackageManager()));
        } catch (Exception unused) {
            this.f21849b.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_uptodown_logo_disabled));
        }
        TextView textView = this.f21850c;
        k.a aVar = k.f7778g;
        textView.setTypeface(aVar.x());
        this.f21851d.setTypeface(aVar.x());
        this.f21852e.setTypeface(aVar.x());
        TextView textView2 = this.f21850c;
        String str3 = null;
        if (fVar != null) {
            str2 = fVar.m();
        } else {
            str2 = null;
        }
        textView2.setText(str2);
        this.f21852e.setText(c5.h());
        this.f21853f.setVisibility(4);
        this.f21854g.setVisibility(0);
        this.f21850c.setTextColor(ContextCompat.getColor(context, R.color.main_dark_grey));
        this.f21851d.setTextColor(ContextCompat.getColor(context, R.color.main_dark_grey));
        this.f21852e.setTextColor(ContextCompat.getColor(context, R.color.main_dark_grey));
        this.f21848a.setBackgroundColor(ContextCompat.getColor(context, R.color.white));
        if (fVar != null) {
            l4 = Long.valueOf(fVar.A());
        } else {
            l4 = null;
        }
        if (l4 == null || fVar.A() != c5.g()) {
            t a5 = t.f21927u.a(context);
            a5.a();
            String a6 = c5.a();
            m.b(a6);
            C2060s f02 = a5.f0(a6);
            a5.i();
            if (f02 == null || f02.x() <= 0 || f02.x() >= 100) {
                z4 = false;
            } else {
                z4 = true;
            }
            if (f02 == null) {
                this.f21854g.setText(R.string.updates_button_download_app);
                this.f21854g.setBackgroundColor(ContextCompat.getColor(context, R.color.accent_green));
            } else if (z4) {
                TextView textView3 = this.f21851d;
                F f4 = F.f20971a;
                String format = String.format(Locale.getDefault(), "%d%%", Arrays.copyOf(new Object[]{Integer.valueOf(f02.x())}, 1));
                m.d(format, "format(...)");
                textView3.setText(format);
                this.f21852e.setVisibility(8);
                this.f21853f.setProgress(f02.x());
                this.f21853f.setVisibility(0);
                this.f21854g.setText(17039360);
                this.f21854g.setBackgroundColor(ContextCompat.getColor(context, R.color.main_light_grey));
            } else {
                this.f21852e.setVisibility(0);
                if (c5.f() > 0) {
                    this.f21851d.setText(new i().d(c5.f(), context));
                }
                a i4 = aVar.i();
                if (i4 != null) {
                    str3 = i4.b();
                }
                if (m3.m.p(str3, f02.w(), true)) {
                    this.f21853f.setIndeterminate(true);
                    this.f21853f.setVisibility(0);
                    this.f21852e.setText(R.string.installing);
                    this.f21851d.setText("");
                    return;
                }
                this.f21854g.setText(R.string.option_button_install);
                this.f21854g.setBackgroundColor(ContextCompat.getColor(context, R.color.main_blue));
            }
        } else {
            this.f21850c.setTextColor(ContextCompat.getColor(context, R.color.white));
            this.f21851d.setTextColor(ContextCompat.getColor(context, R.color.white));
            this.f21852e.setTextColor(ContextCompat.getColor(context, R.color.white));
            this.f21848a.setBackgroundColor(ContextCompat.getColor(context, R.color.main_blue));
            this.f21854g.setVisibility(8);
        }
    }
}
