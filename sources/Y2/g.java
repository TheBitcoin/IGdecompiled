package y2;

import N1.k;
import W1.i;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleCoroutineScope;
import b2.C1640l;
import b2.x;
import com.squareup.picasso.s;
import com.squareup.picasso.w;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.C1826a;
import com.uptodown.activities.LoginActivity;
import com.uptodown.workers.DownloadWorker;
import f2.C2027s;
import f2.N;
import f2.O;
import g2.C2048f;
import g2.C2050h;
import g2.C2060s;
import g2.S;
import g2.U;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.m;
import u2.t;
import w2.C2345c;
import w2.v;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    private C2050h f22763a;

    /* renamed from: b  reason: collision with root package name */
    private final RelativeLayout f22764b;

    /* renamed from: c  reason: collision with root package name */
    private final a f22765c;

    /* renamed from: d  reason: collision with root package name */
    public View f22766d;

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f22767e;

    /* renamed from: f  reason: collision with root package name */
    private ImageView f22768f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f22769g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f22770h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f22771i;

    /* renamed from: j  reason: collision with root package name */
    private TextView f22772j;

    /* renamed from: k  reason: collision with root package name */
    private TextView f22773k;

    /* renamed from: l  reason: collision with root package name */
    private ImageView f22774l;

    /* renamed from: m  reason: collision with root package name */
    private LinearLayout f22775m;

    /* renamed from: n  reason: collision with root package name */
    private ProgressBar f22776n;

    /* renamed from: o  reason: collision with root package name */
    private TextView f22777o;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public AtomicBoolean f22778p = new AtomicBoolean(false);
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public boolean f22779q;

    public interface a {
        void a(C2050h hVar);

        void b(C2050h hVar);
    }

    public static final class e implements H1.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f22786a;

        e(g gVar) {
            this.f22786a = gVar;
        }

        public void a(Exception exc) {
            m.e(exc, "e");
        }

        public void b() {
            this.f22786a.f22779q = true;
        }
    }

    public g(C2050h hVar, RelativeLayout relativeLayout, a aVar) {
        m.e(hVar, "appInfoSelected");
        m.e(relativeLayout, "rlContainer");
        this.f22763a = hVar;
        this.f22764b = relativeLayout;
        this.f22765c = aVar;
    }

    /* access modifiers changed from: private */
    public final void A(C1826a aVar, C2050h hVar) {
        C2060s sVar;
        S s4;
        boolean z4;
        boolean z5;
        C2060s sVar2;
        TextView textView = null;
        if (!this.f22779q) {
            w n4 = s.h().l(hVar.E()).l(R.drawable.shape_bg_placeholder).n(UptodownApp.f17422D.i0(aVar));
            ImageView imageView = this.f22768f;
            if (imageView == null) {
                m.u("ivLogoAppInfoSelected");
                imageView = null;
            }
            n4.j(imageView, new e(this));
        }
        TextView textView2 = this.f22769g;
        if (textView2 == null) {
            m.u("tvNameAppInfoSelected");
            textView2 = null;
        }
        textView2.setText(hVar.L());
        TextView textView3 = this.f22771i;
        if (textView3 == null) {
            m.u("tvAuthorAppInfoSelected");
            textView3 = null;
        }
        textView3.setText(hVar.g());
        TextView textView4 = this.f22773k;
        if (textView4 == null) {
            m.u("tvValorationAppInfoSelected");
            textView4 = null;
        }
        textView4.setText(String.valueOf(((double) hVar.V()) / 10.0d));
        t a5 = t.f21927u.a(aVar);
        a5.a();
        if (hVar.z() >= 0) {
            sVar = a5.f0(String.valueOf(hVar.z()));
        } else {
            sVar = null;
        }
        String Q4 = hVar.Q();
        if (Q4 == null || Q4.length() == 0) {
            s4 = null;
        } else {
            String Q5 = hVar.Q();
            m.b(Q5);
            S D02 = a5.D0(Q5);
            if (D02 != null) {
                sVar2 = D02.b(aVar);
            } else {
                sVar2 = null;
            }
            if (sVar2 == null) {
                String Q6 = hVar.Q();
                m.b(Q6);
                sVar2 = a5.i0(Q6, hVar.H());
            }
            C2060s sVar3 = sVar2;
            s4 = D02;
            sVar = sVar3;
        }
        a5.i();
        TextView textView5 = this.f22770h;
        if (textView5 == null) {
            m.u("tvActionAppInfoSelected");
            textView5 = null;
        }
        textView5.setVisibility(8);
        if (hVar.z() >= 0 && C2050h.f20600F0.d(hVar.n())) {
            TextView textView6 = this.f22770h;
            if (textView6 == null) {
                m.u("tvActionAppInfoSelected");
            } else {
                textView = textView6;
            }
            boolean z6 = false;
            textView.setVisibility(0);
            if (!UptodownApp.f17422D.T("downloadApkWorker", aVar) || !DownloadWorker.f19459d.j(hVar.e())) {
                z4 = false;
            } else {
                z4 = true;
            }
            if (sVar == null || !sVar.f()) {
                z5 = false;
            } else {
                z5 = true;
            }
            if (sVar != null && sVar.K()) {
                z6 = true;
            }
            boolean s5 = new u2.m().s(hVar.Q(), aVar);
            if (z5) {
                if (s4 != null) {
                    String string = aVar.getString(R.string.updates_button_update_app);
                    m.d(string, "getString(...)");
                    z(string);
                } else if (!s5) {
                    String string2 = aVar.getString(R.string.option_button_install);
                    m.d(string2, "getString(...)");
                    z(string2);
                } else {
                    String string3 = aVar.getString(R.string.open);
                    m.d(string3, "getString(...)");
                    x(string3);
                }
            } else if (sVar != null && (z4 || z6)) {
                y(sVar, aVar);
            } else if (s5) {
                String string4 = aVar.getString(R.string.open);
                m.d(string4, "getString(...)");
                x(string4);
            } else {
                String string5 = aVar.getString(R.string.updates_button_download_app);
                m.d(string5, "getString(...)");
                x(string5);
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void C(g gVar, C1826a aVar, View view) {
        gVar.m(aVar);
        gVar.l(aVar);
        a aVar2 = gVar.f22765c;
        if (aVar2 != null) {
            aVar2.b(gVar.f22763a);
        }
    }

    /* access modifiers changed from: private */
    public static final void D(g gVar, View view) {
        gVar.f22764b.setVisibility(8);
        a aVar = gVar.f22765c;
        if (aVar != null) {
            aVar.a(gVar.f22763a);
        }
    }

    /* access modifiers changed from: private */
    public static final void E(g gVar, View view) {
        gVar.f22764b.setVisibility(8);
        a aVar = gVar.f22765c;
        if (aVar != null) {
            aVar.a(gVar.f22763a);
        }
    }

    /* access modifiers changed from: private */
    public static final void F(C1826a aVar, g gVar, LifecycleCoroutineScope lifecycleCoroutineScope, O o4, N n4, View view) {
        UptodownApp.a aVar2 = UptodownApp.f17422D;
        if (!aVar2.a0()) {
            return;
        }
        if (U.f20468m.e(aVar) == null) {
            aVar.startActivity(new Intent(aVar, LoginActivity.class), aVar2.a(aVar));
            return;
        }
        if (gVar.f22763a.A0() == 1) {
            new x(aVar, lifecycleCoroutineScope).g(gVar.f22763a.e(), o4);
        } else {
            new x(aVar, lifecycleCoroutineScope).e(gVar.f22763a.e(), n4);
        }
        new Handler(Looper.getMainLooper()).postDelayed(new f(gVar, aVar), 1000);
    }

    /* access modifiers changed from: private */
    public static final void G(g gVar, C1826a aVar) {
        gVar.l(aVar);
    }

    /* access modifiers changed from: private */
    public static final void H(g gVar, C1826a aVar, View view) {
        gVar.l(aVar);
    }

    /* access modifiers changed from: private */
    public final void K(C1826a aVar) {
        ImageView imageView = this.f22774l;
        ImageView imageView2 = null;
        if (imageView == null) {
            m.u("ivLikeAppInfoSelected");
            imageView = null;
        }
        imageView.setBackground(ContextCompat.getDrawable(aVar, R.drawable.ripple_wishlist));
        ImageView imageView3 = this.f22774l;
        if (imageView3 == null) {
            m.u("ivLikeAppInfoSelected");
            imageView3 = null;
        }
        imageView3.setImageResource(R.drawable.vector_heart_blue);
        ImageView imageView4 = this.f22774l;
        if (imageView4 == null) {
            m.u("ivLikeAppInfoSelected");
        } else {
            imageView2 = imageView4;
        }
        imageView2.setVisibility(0);
    }

    /* access modifiers changed from: private */
    public final void L(C1826a aVar) {
        ImageView imageView = this.f22774l;
        ImageView imageView2 = null;
        if (imageView == null) {
            m.u("ivLikeAppInfoSelected");
            imageView = null;
        }
        imageView.setBackground(ContextCompat.getDrawable(aVar, R.drawable.ripple_wishlist_added));
        ImageView imageView3 = this.f22774l;
        if (imageView3 == null) {
            m.u("ivLikeAppInfoSelected");
            imageView3 = null;
        }
        imageView3.setImageResource(R.drawable.vector_heart_white);
        ImageView imageView4 = this.f22774l;
        if (imageView4 == null) {
            m.u("ivLikeAppInfoSelected");
        } else {
            imageView2 = imageView4;
        }
        imageView2.setVisibility(0);
    }

    private final void M(C2060s sVar, C1826a aVar) {
        y(sVar, aVar);
        C2345c cVar = C2345c.f22021a;
        ProgressBar progressBar = this.f22776n;
        TextView textView = null;
        if (progressBar == null) {
            m.u("pbAppInfoSelected");
            progressBar = null;
        }
        ImageView imageView = this.f22768f;
        if (imageView == null) {
            m.u("ivLogoAppInfoSelected");
            imageView = null;
        }
        cVar.e(progressBar, imageView);
        LinearLayout linearLayout = this.f22775m;
        if (linearLayout == null) {
            m.u("llAppInfoSelected");
            linearLayout = null;
        }
        linearLayout.setVisibility(8);
        TextView textView2 = this.f22771i;
        if (textView2 == null) {
            m.u("tvAuthorAppInfoSelected");
        } else {
            textView = textView2;
        }
        textView.setVisibility(0);
    }

    private final void O(C2060s sVar, C1826a aVar) {
        y(sVar, aVar);
        C2345c cVar = C2345c.f22021a;
        ProgressBar progressBar = this.f22776n;
        TextView textView = null;
        if (progressBar == null) {
            m.u("pbAppInfoSelected");
            progressBar = null;
        }
        ImageView imageView = this.f22768f;
        if (imageView == null) {
            m.u("ivLogoAppInfoSelected");
            imageView = null;
        }
        cVar.e(progressBar, imageView);
        ProgressBar progressBar2 = this.f22776n;
        if (progressBar2 == null) {
            m.u("pbAppInfoSelected");
            progressBar2 = null;
        }
        progressBar2.setProgress(sVar.x());
        TextView textView2 = this.f22777o;
        if (textView2 == null) {
            m.u("tvProgressAppInfoSelected");
            textView2 = null;
        }
        textView2.setText(aVar.getString(R.string.percent_of_total_size, new Object[]{Integer.valueOf(sVar.x()), new i().d(sVar.z(), aVar)}));
        LinearLayout linearLayout = this.f22775m;
        if (linearLayout == null) {
            m.u("llAppInfoSelected");
            linearLayout = null;
        }
        linearLayout.setVisibility(0);
        TextView textView3 = this.f22771i;
        if (textView3 == null) {
            m.u("tvAuthorAppInfoSelected");
        } else {
            textView = textView3;
        }
        textView.setVisibility(8);
    }

    private final void m(C1826a aVar) {
        S s4;
        t a5 = t.f21927u.a(aVar);
        a5.a();
        String Q4 = this.f22763a.Q();
        m.b(Q4);
        C2048f Y4 = a5.Y(Q4);
        C2060s sVar = null;
        if (Y4 != null) {
            String Q5 = this.f22763a.Q();
            m.b(Q5);
            s4 = a5.D0(Q5);
            if (s4 != null) {
                sVar = s4.b(aVar);
            }
        } else {
            String Q6 = this.f22763a.Q();
            m.b(Q6);
            C2060s i02 = a5.i0(Q6, this.f22763a.H());
            s4 = null;
            sVar = i02;
        }
        a5.i();
        if (sVar != null) {
            DownloadWorker.a aVar2 = DownloadWorker.f19459d;
            if (aVar2.k(this.f22763a.e(), this.f22763a.H())) {
                aVar2.d(this.f22763a.e());
                sVar.R(aVar);
            } else if (sVar.f()) {
                File n4 = sVar.n();
                if (n4 != null) {
                    UptodownApp.f17422D.V(n4, aVar, this.f22763a.M());
                }
            } else {
                sVar.R(aVar);
            }
        } else if ((Y4 == null || s4 != null) && ((Y4 == null || Y4.e() != 1) && (s4 == null || !s4.m()))) {
            o(this.f22763a, aVar);
        } else {
            v(this.f22763a.Q(), aVar);
        }
    }

    private final void n(C1826a aVar) {
        C2345c cVar = C2345c.f22021a;
        ProgressBar progressBar = this.f22776n;
        TextView textView = null;
        if (progressBar == null) {
            m.u("pbAppInfoSelected");
            progressBar = null;
        }
        ImageView imageView = this.f22768f;
        if (imageView == null) {
            m.u("ivLogoAppInfoSelected");
            imageView = null;
        }
        cVar.c(progressBar, imageView);
        LinearLayout linearLayout = this.f22775m;
        if (linearLayout == null) {
            m.u("llAppInfoSelected");
            linearLayout = null;
        }
        linearLayout.setVisibility(8);
        TextView textView2 = this.f22771i;
        if (textView2 == null) {
            m.u("tvAuthorAppInfoSelected");
        } else {
            textView = textView2;
        }
        textView.setVisibility(0);
        String string = aVar.getString(R.string.updates_button_download_app);
        m.d(string, "getString(...)");
        x(string);
    }

    private final void o(C2050h hVar, C1826a aVar) {
        UptodownApp.f17422D.c0(hVar, aVar);
    }

    private final void p(boolean z4, C1826a aVar) {
        String str;
        if (z4) {
            str = aVar.getString(R.string.updates_button_update_app);
        } else {
            str = aVar.getString(R.string.option_button_install);
        }
        z(str);
        C2345c cVar = C2345c.f22021a;
        ProgressBar progressBar = this.f22776n;
        TextView textView = null;
        if (progressBar == null) {
            m.u("pbAppInfoSelected");
            progressBar = null;
        }
        ImageView imageView = this.f22768f;
        if (imageView == null) {
            m.u("ivLogoAppInfoSelected");
            imageView = null;
        }
        cVar.c(progressBar, imageView);
        LinearLayout linearLayout = this.f22775m;
        if (linearLayout == null) {
            m.u("llAppInfoSelected");
            linearLayout = null;
        }
        linearLayout.setVisibility(8);
        TextView textView2 = this.f22771i;
        if (textView2 == null) {
            m.u("tvAuthorAppInfoSelected");
        } else {
            textView = textView2;
        }
        textView.setVisibility(0);
    }

    private final void u(C1826a aVar, long j4, LifecycleCoroutineScope lifecycleCoroutineScope) {
        new C1640l(aVar, j4, new d(this, aVar), lifecycleCoroutineScope);
    }

    private final void v(String str, C1826a aVar) {
        Intent launchIntentForPackage;
        if (str != null && str.length() != 0 && (launchIntentForPackage = aVar.getPackageManager().getLaunchIntentForPackage(str)) != null) {
            aVar.startActivity(launchIntentForPackage);
        }
    }

    private final void x(String str) {
        C2345c cVar = C2345c.f22021a;
        ProgressBar progressBar = this.f22776n;
        TextView textView = null;
        if (progressBar == null) {
            m.u("pbAppInfoSelected");
            progressBar = null;
        }
        ImageView imageView = this.f22768f;
        if (imageView == null) {
            m.u("ivLogoAppInfoSelected");
            imageView = null;
        }
        cVar.c(progressBar, imageView);
        TextView textView2 = this.f22770h;
        if (textView2 == null) {
            m.u("tvActionAppInfoSelected");
            textView2 = null;
        }
        textView2.setText(str);
        TextView textView3 = this.f22770h;
        if (textView3 == null) {
            m.u("tvActionAppInfoSelected");
            textView3 = null;
        }
        v.a(textView3);
        LinearLayout linearLayout = this.f22775m;
        if (linearLayout == null) {
            m.u("llAppInfoSelected");
            linearLayout = null;
        }
        linearLayout.setVisibility(8);
        TextView textView4 = this.f22771i;
        if (textView4 == null) {
            m.u("tvAuthorAppInfoSelected");
        } else {
            textView = textView4;
        }
        textView.setVisibility(0);
    }

    private final void y(C2060s sVar, C1826a aVar) {
        C2345c cVar = C2345c.f22021a;
        ProgressBar progressBar = this.f22776n;
        ProgressBar progressBar2 = null;
        if (progressBar == null) {
            m.u("pbAppInfoSelected");
            progressBar = null;
        }
        ImageView imageView = this.f22768f;
        if (imageView == null) {
            m.u("ivLogoAppInfoSelected");
            imageView = null;
        }
        cVar.e(progressBar, imageView);
        TextView textView = this.f22771i;
        if (textView == null) {
            m.u("tvAuthorAppInfoSelected");
            textView = null;
        }
        textView.setVisibility(8);
        LinearLayout linearLayout = this.f22775m;
        if (linearLayout == null) {
            m.u("llAppInfoSelected");
            linearLayout = null;
        }
        linearLayout.setVisibility(0);
        TextView textView2 = this.f22770h;
        if (textView2 == null) {
            m.u("tvActionAppInfoSelected");
            textView2 = null;
        }
        textView2.setText(R.string.option_button_cancel);
        TextView textView3 = this.f22770h;
        if (textView3 == null) {
            m.u("tvActionAppInfoSelected");
            textView3 = null;
        }
        v.b(textView3);
        if (sVar.x() == 0) {
            TextView textView4 = this.f22777o;
            if (textView4 == null) {
                m.u("tvProgressAppInfoSelected");
                textView4 = null;
            }
            textView4.setText(aVar.getString(R.string.status_download_update_pending));
            ProgressBar progressBar3 = this.f22776n;
            if (progressBar3 == null) {
                m.u("pbAppInfoSelected");
            } else {
                progressBar2 = progressBar3;
            }
            progressBar2.setIndeterminate(true);
            return;
        }
        ProgressBar progressBar4 = this.f22776n;
        if (progressBar4 == null) {
            m.u("pbAppInfoSelected");
            progressBar4 = null;
        }
        progressBar4.setIndeterminate(false);
        TextView textView5 = this.f22777o;
        if (textView5 == null) {
            m.u("tvProgressAppInfoSelected");
            textView5 = null;
        }
        textView5.setText(aVar.getString(R.string.percent_of_total_size, new Object[]{Integer.valueOf(sVar.x()), new i().d(sVar.z(), aVar)}));
        ProgressBar progressBar5 = this.f22776n;
        if (progressBar5 == null) {
            m.u("pbAppInfoSelected");
        } else {
            progressBar2 = progressBar5;
        }
        progressBar2.setProgress(sVar.x());
    }

    private final void z(String str) {
        C2345c cVar = C2345c.f22021a;
        ProgressBar progressBar = this.f22776n;
        TextView textView = null;
        if (progressBar == null) {
            m.u("pbAppInfoSelected");
            progressBar = null;
        }
        ImageView imageView = this.f22768f;
        if (imageView == null) {
            m.u("ivLogoAppInfoSelected");
            imageView = null;
        }
        cVar.c(progressBar, imageView);
        TextView textView2 = this.f22770h;
        if (textView2 == null) {
            m.u("tvActionAppInfoSelected");
            textView2 = null;
        }
        textView2.setText(str);
        TextView textView3 = this.f22770h;
        if (textView3 == null) {
            m.u("tvActionAppInfoSelected");
            textView3 = null;
        }
        v.d(textView3);
        LinearLayout linearLayout = this.f22775m;
        if (linearLayout == null) {
            m.u("llAppInfoSelected");
            linearLayout = null;
        }
        linearLayout.setVisibility(8);
        TextView textView4 = this.f22771i;
        if (textView4 == null) {
            m.u("tvAuthorAppInfoSelected");
        } else {
            textView = textView4;
        }
        textView.setVisibility(0);
    }

    public final void B(C1826a aVar, LifecycleCoroutineScope lifecycleCoroutineScope) {
        m.e(aVar, "activity");
        m.e(lifecycleCoroutineScope, "scope");
        f fVar = new f(aVar, this);
        C0275g gVar = new C0275g(aVar, this);
        J(this.f22764b.findViewById(R.id.v_background_app_info_selected));
        t().setVisibility(0);
        I((RelativeLayout) this.f22764b.findViewById(R.id.rl_app_info_selected));
        this.f22768f = (ImageView) this.f22764b.findViewById(R.id.iv_logo_app_info_selected);
        this.f22769g = (TextView) this.f22764b.findViewById(R.id.tv_name_app_info_selected);
        this.f22771i = (TextView) this.f22764b.findViewById(R.id.tv_author_app_info_selected);
        this.f22775m = (LinearLayout) this.f22764b.findViewById(R.id.ll_download_app_info_selected);
        this.f22776n = (ProgressBar) this.f22764b.findViewById(R.id.pb_progress_app_info_selected);
        this.f22777o = (TextView) this.f22764b.findViewById(R.id.tv_progress_app_info_selected);
        this.f22772j = (TextView) this.f22764b.findViewById(R.id.tv_verified_app_info_selected);
        this.f22773k = (TextView) this.f22764b.findViewById(R.id.tv_valoration_app_info_selected);
        this.f22770h = (TextView) this.f22764b.findViewById(R.id.tv_action_app_info_selected);
        this.f22774l = (ImageView) this.f22764b.findViewById(R.id.iv_wishlist_action_app_info_selected);
        TextView textView = this.f22769g;
        if (textView == null) {
            m.u("tvNameAppInfoSelected");
            textView = null;
        }
        k.a aVar2 = k.f7778g;
        textView.setTypeface(aVar2.w());
        TextView textView2 = this.f22771i;
        if (textView2 == null) {
            m.u("tvAuthorAppInfoSelected");
            textView2 = null;
        }
        textView2.setTypeface(aVar2.x());
        TextView textView3 = this.f22777o;
        if (textView3 == null) {
            m.u("tvProgressAppInfoSelected");
            textView3 = null;
        }
        textView3.setTypeface(aVar2.x());
        TextView textView4 = this.f22772j;
        if (textView4 == null) {
            m.u("tvVerifiedAppInfoSelected");
            textView4 = null;
        }
        textView4.setTypeface(aVar2.x());
        TextView textView5 = this.f22773k;
        if (textView5 == null) {
            m.u("tvValorationAppInfoSelected");
            textView5 = null;
        }
        textView5.setTypeface(aVar2.x());
        TextView textView6 = this.f22770h;
        if (textView6 == null) {
            m.u("tvActionAppInfoSelected");
            textView6 = null;
        }
        textView6.setTypeface(aVar2.w());
        ImageView imageView = this.f22768f;
        if (imageView == null) {
            m.u("ivLogoAppInfoSelected");
            imageView = null;
        }
        imageView.setScaleX(1.0f);
        ImageView imageView2 = this.f22768f;
        if (imageView2 == null) {
            m.u("ivLogoAppInfoSelected");
            imageView2 = null;
        }
        imageView2.setScaleY(1.0f);
        ProgressBar progressBar = this.f22776n;
        if (progressBar == null) {
            m.u("pbAppInfoSelected");
            progressBar = null;
        }
        progressBar.setVisibility(8);
        A(aVar, this.f22763a);
        if (this.f22763a.A0() == 1) {
            L(aVar);
        } else {
            ImageView imageView3 = this.f22774l;
            if (imageView3 == null) {
                m.u("ivLikeAppInfoSelected");
                imageView3 = null;
            }
            imageView3.setVisibility(8);
            u(aVar, this.f22763a.e(), lifecycleCoroutineScope);
        }
        TextView textView7 = this.f22770h;
        if (textView7 == null) {
            m.u("tvActionAppInfoSelected");
            textView7 = null;
        }
        textView7.setOnClickListener(new C2437a(this, aVar));
        ImageView imageView4 = this.f22768f;
        if (imageView4 == null) {
            m.u("ivLogoAppInfoSelected");
            imageView4 = null;
        }
        imageView4.setOnClickListener(new C2438b(this));
        TextView textView8 = this.f22769g;
        if (textView8 == null) {
            m.u("tvNameAppInfoSelected");
            textView8 = null;
        }
        textView8.setOnClickListener(new C2439c(this));
        ImageView imageView5 = this.f22774l;
        if (imageView5 == null) {
            m.u("ivLikeAppInfoSelected");
            imageView5 = null;
        }
        C1826a aVar3 = aVar;
        imageView5.setOnClickListener(new d(aVar3, this, lifecycleCoroutineScope, gVar, fVar));
        t().setOnClickListener(new e(this, aVar3));
        if (this.f22764b.getVisibility() != 0) {
            this.f22764b.setVisibility(0);
            new n(aVar3).h(r(), R.anim.slide_in_bottom);
        }
        r().setVisibility(0);
    }

    public final void I(RelativeLayout relativeLayout) {
        m.e(relativeLayout, "<set-?>");
        this.f22767e = relativeLayout;
    }

    public final void J(View view) {
        m.e(view, "<set-?>");
        this.f22766d = view;
    }

    public final void N(C2060s sVar, int i4, C1826a aVar) {
        m.e(sVar, "download");
        m.e(aVar, "activity");
        if (sVar.h() == this.f22763a.e()) {
            if (i4 != 205) {
                if (i4 != 207) {
                    switch (i4) {
                        case 200:
                            break;
                        case 201:
                            O(sVar, aVar);
                            return;
                        case 202:
                            p(new u2.m().s(sVar.w(), aVar), aVar);
                            return;
                        default:
                            return;
                    }
                } else {
                    n(aVar);
                    return;
                }
            }
            M(sVar, aVar);
        }
    }

    public final boolean l(C1826a aVar) {
        m.e(aVar, "activity");
        if (this.f22764b.getVisibility() != 0) {
            return false;
        }
        if (!com.uptodown.activities.preferences.a.f18818a.N(aVar) || UptodownApp.f17422D.Q() || !this.f22778p.compareAndSet(false, true)) {
            this.f22764b.setVisibility(8);
        } else {
            new n(aVar).g(r(), R.anim.slide_out_bottom, new b(aVar, this, new c(this)));
        }
        return true;
    }

    public final C2050h q() {
        return this.f22763a;
    }

    public final RelativeLayout r() {
        RelativeLayout relativeLayout = this.f22767e;
        if (relativeLayout != null) {
            return relativeLayout;
        }
        m.u("rlAppInfoSelected");
        return null;
    }

    public final RelativeLayout s() {
        return this.f22764b;
    }

    public final View t() {
        View view = this.f22766d;
        if (view != null) {
            return view;
        }
        m.u("vBackground");
        return null;
    }

    public final void w(C2050h hVar) {
        m.e(hVar, "<set-?>");
        this.f22763a = hVar;
    }

    public static final class f implements N {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C1826a f22787a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ g f22788b;

        f(C1826a aVar, g gVar) {
            this.f22787a = aVar;
            this.f22788b = gVar;
        }

        public void d() {
            if (!this.f22787a.isFinishing() && this.f22788b.s().getVisibility() == 0) {
                this.f22788b.L(this.f22787a);
                C1826a aVar = this.f22787a;
                String string = aVar.getString(R.string.action_added_to_wishlist, new Object[]{this.f22788b.q().L()});
                m.d(string, "getString(...)");
                aVar.q0(string);
            }
        }

        public void a() {
        }
    }

    /* renamed from: y2.g$g  reason: collision with other inner class name */
    public static final class C0275g implements O {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C1826a f22789a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ g f22790b;

        C0275g(C1826a aVar, g gVar) {
            this.f22789a = aVar;
            this.f22790b = gVar;
        }

        public void f() {
            if (!this.f22789a.isFinishing()) {
                if (this.f22790b.s().getVisibility() == 0) {
                    this.f22790b.K(this.f22789a);
                }
                C1826a aVar = this.f22789a;
                String string = aVar.getString(R.string.action_removed_from_wishlist, new Object[]{this.f22790b.q().L()});
                m.d(string, "getString(...)");
                aVar.q0(string);
            }
        }

        public void a() {
        }
    }

    public static final class b implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C1826a f22780a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ g f22781b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ c f22782c;

        b(C1826a aVar, g gVar, c cVar) {
            this.f22780a = aVar;
            this.f22781b = gVar;
            this.f22782c = cVar;
        }

        public void onAnimationEnd(Animation animation) {
            this.f22781b.r().setVisibility(8);
            this.f22781b.s().setVisibility(8);
            this.f22781b.f22778p.set(false);
        }

        public void onAnimationStart(Animation animation) {
            new n(this.f22780a).g(this.f22781b.t(), R.anim.fade_out, this.f22782c);
        }

        public void onAnimationRepeat(Animation animation) {
        }
    }

    public static final class c implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f22783a;

        c(g gVar) {
            this.f22783a = gVar;
        }

        public void onAnimationEnd(Animation animation) {
            this.f22783a.t().setVisibility(8);
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }

    public static final class d implements C2027s {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f22784a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C1826a f22785b;

        d(g gVar, C1826a aVar) {
            this.f22784a = gVar;
            this.f22785b = aVar;
        }

        public void c(C2050h hVar) {
            m.e(hVar, "appInfo");
            this.f22784a.w(hVar);
            if (this.f22784a.s().getVisibility() == 0) {
                g gVar = this.f22784a;
                gVar.A(this.f22785b, gVar.q());
                if (this.f22784a.q().A0() == 1) {
                    this.f22784a.L(this.f22785b);
                } else {
                    this.f22784a.K(this.f22785b);
                }
            }
        }

        public void b(int i4) {
        }
    }
}
