package x2;

import N1.k;
import W1.i;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.mbridge.msdk.MBridgeConstans;
import com.squareup.picasso.s;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.preferences.a;
import com.uptodown.workers.DownloadWorker;
import f2.C2013d;
import g2.C2048f;
import g2.C2050h;
import g2.C2060s;
import g2.S;
import kotlin.jvm.internal.m;
import u2.t;
import w2.C2345c;
import w2.v;

/* renamed from: x2.j  reason: case insensitive filesystem */
public abstract class C2375j extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    private Context f22407a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2375j(View view, Context context) {
        super(view);
        m.e(view, "itemView");
        m.e(context, "context");
        this.f22407a = context;
    }

    /* access modifiers changed from: private */
    public static final void d(C2013d dVar, C2050h hVar, View view) {
        dVar.a(hVar);
    }

    private final void f(C2048f fVar, S s4, TextView textView) {
        if (s4 != null && !s4.m()) {
            textView.setText(this.f22407a.getString(R.string.status_download_update));
            v.d(textView);
        } else if (fVar.d()) {
            textView.setText(this.f22407a.getString(R.string.dark_mode_disabled));
            textView.setTextColor(ContextCompat.getColor(this.f22407a, R.color.main_light_grey));
            textView.setBackground(ContextCompat.getDrawable(this.f22407a, R.drawable.bg_status_download_installed));
        } else {
            textView.setText(this.f22407a.getString(R.string.status_download_installed));
            textView.setTextColor(ContextCompat.getColor(this.f22407a, R.color.main_blue));
            textView.setBackground(ContextCompat.getDrawable(this.f22407a, R.drawable.shape_stroke_blue_primary));
        }
        textView.setTypeface(k.f7778g.w());
    }

    private final void j(String str, ProgressBar progressBar, ImageView imageView, TextView textView, TextView textView2, LinearLayout linearLayout) {
        C2345c.f22021a.c(progressBar, imageView);
        linearLayout.setVisibility(8);
        if (textView2 != null) {
            g(str, textView2, textView);
        }
    }

    private final void k(int i4, long j4, ProgressBar progressBar, ImageView imageView, TextView textView, TextView textView2, TextView textView3, LinearLayout linearLayout) {
        C2345c.f22021a.e(progressBar, imageView);
        textView.setVisibility(8);
        if (textView3 != null) {
            textView3.setVisibility(8);
        }
        linearLayout.setVisibility(0);
        if (i4 == 0) {
            progressBar.setIndeterminate(true);
            textView2.setText(this.f22407a.getString(R.string.status_download_update_pending));
            return;
        }
        progressBar.setIndeterminate(false);
        progressBar.setProgress(i4);
        textView2.setText(this.f22407a.getString(R.string.percent_of_total_size, new Object[]{Integer.valueOf(i4), new i().d(j4, this.f22407a)}));
    }

    public final RelativeLayout.LayoutParams b(RelativeLayout.LayoutParams layoutParams, Context context, int i4, int i5) {
        m.e(layoutParams, "<this>");
        m.e(context, "context");
        int dimension = (int) context.getResources().getDimension(R.dimen.margin_m);
        if (m.a(a.f18818a.p(context), "ar")) {
            if (i4 == i5) {
                layoutParams.setMargins(dimension, 0, 0, 0);
                return layoutParams;
            } else if (i4 == 1) {
                layoutParams.setMargins(dimension, 0, dimension, 0);
                return layoutParams;
            } else {
                layoutParams.setMargins(dimension, 0, 0, 0);
                return layoutParams;
            }
        } else if (i4 == i5) {
            layoutParams.setMargins(dimension, 0, dimension, 0);
            return layoutParams;
        } else {
            layoutParams.setMargins(dimension, 0, 0, 0);
            return layoutParams;
        }
    }

    public final void c(View view, C2013d dVar, C2050h hVar) {
        m.e(view, "<this>");
        m.e(dVar, "listener");
        m.e(hVar, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
        view.setOnClickListener(new C2373i(dVar, hVar));
    }

    public final void e(C2050h hVar, ProgressBar progressBar, ImageView imageView, TextView textView, TextView textView2, TextView textView3, LinearLayout linearLayout) {
        C2060s sVar;
        boolean z4;
        m.e(hVar, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
        m.e(progressBar, "pb");
        m.e(imageView, "ivIcon");
        m.e(textView, "tvDesc");
        TextView textView4 = textView2;
        m.e(textView4, "tvProgress");
        LinearLayout linearLayout2 = linearLayout;
        m.e(linearLayout2, "llProgress");
        t a5 = t.f21927u.a(this.f22407a);
        a5.a();
        if (hVar.Q() != null) {
            String Q4 = hVar.Q();
            m.b(Q4);
            sVar = a5.i0(Q4, hVar.v0());
        } else {
            sVar = null;
        }
        boolean z5 = false;
        if (!UptodownApp.f17422D.T("downloadApkWorker", this.f22407a) || !DownloadWorker.f19459d.j(hVar.e())) {
            z4 = false;
        } else {
            z4 = true;
        }
        if (sVar != null && sVar.K()) {
            z5 = true;
        }
        if (sVar == null || (!z4 && !z5)) {
            j(hVar.Q(), progressBar, imageView, textView, textView3, linearLayout);
            return;
        }
        k(sVar.x(), sVar.z(), progressBar, imageView, textView, textView4, textView3, linearLayout2);
    }

    public final void g(String str, TextView textView, TextView textView2) {
        m.e(textView, "tvStatus");
        m.e(textView2, "tvDesc");
        if (new u2.m().s(str, this.f22407a)) {
            t a5 = t.f21927u.a(this.f22407a);
            a5.a();
            m.b(str);
            S D02 = a5.D0(str);
            C2048f Y4 = a5.Y(str);
            a5.i();
            if (Y4 == null) {
                textView.setVisibility(0);
                textView2.setVisibility(8);
            } else if (Y4.e() != 0 || Y4.H()) {
                textView.setVisibility(8);
                textView2.setVisibility(0);
            } else {
                f(Y4, D02, textView);
                textView.setVisibility(0);
                textView2.setVisibility(8);
            }
        } else {
            textView.setText(this.f22407a.getString(R.string.status_download_installed));
            textView.setTextColor(ContextCompat.getColor(this.f22407a, R.color.main_blue));
            textView.setBackground(ContextCompat.getDrawable(this.f22407a, R.drawable.shape_stroke_blue_primary));
            textView.setTypeface(k.f7778g.w());
            textView.setVisibility(8);
            textView2.setVisibility(0);
        }
    }

    public final void h(ImageView imageView, String str) {
        m.e(imageView, "iv");
        if (str != null) {
            s.h().l(str).l(R.drawable.shape_bg_placeholder).n(UptodownApp.f17422D.i0(this.f22407a)).i(imageView);
        } else {
            imageView.setImageDrawable(ContextCompat.getDrawable(this.f22407a, R.drawable.vector_app_icon_placeholder));
        }
    }

    public final void i(C2050h hVar, TextView textView, TextView textView2) {
        m.e(hVar, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
        m.e(textView, "tvName");
        m.e(textView2, "tvDesc");
        textView.setText(hVar.L());
        String j02 = hVar.j0();
        if (j02 == null || j02.length() == 0) {
            j02 = hVar.g();
        }
        textView2.setText(j02);
    }
}
