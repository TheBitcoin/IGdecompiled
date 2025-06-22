package x2;

import W1.i;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.mbridge.msdk.MBridgeConstans;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.workers.DownloadWorker;
import f2.C2010a;
import f2.C2013d;
import f2.C2014e;
import g2.C2050h;
import g2.C2059q;
import g2.C2060s;
import g2.S;
import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.internal.F;
import kotlin.jvm.internal.m;
import u2.t;
import w2.C2345c;
import w2.v;

public final class K0 extends C2375j {

    /* renamed from: b  reason: collision with root package name */
    private final C2013d f22189b;

    /* renamed from: c  reason: collision with root package name */
    private final C2014e f22190c;

    /* renamed from: d  reason: collision with root package name */
    private final C2010a f22191d;

    /* renamed from: e  reason: collision with root package name */
    private RelativeLayout f22192e;

    /* renamed from: f  reason: collision with root package name */
    private ImageView f22193f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f22194g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f22195h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f22196i;

    /* renamed from: j  reason: collision with root package name */
    private TextView f22197j;

    /* renamed from: k  reason: collision with root package name */
    private TextView f22198k;

    /* renamed from: l  reason: collision with root package name */
    private TextView f22199l;

    /* renamed from: m  reason: collision with root package name */
    private LinearLayout f22200m;

    /* renamed from: n  reason: collision with root package name */
    private LinearLayout f22201n;

    /* renamed from: o  reason: collision with root package name */
    private TextView f22202o;

    /* renamed from: p  reason: collision with root package name */
    private ProgressBar f22203p;

    /* renamed from: q  reason: collision with root package name */
    private TextView f22204q;

    /* renamed from: r  reason: collision with root package name */
    private TextView f22205r;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public K0(android.view.View r3, f2.C2013d r4, f2.C2014e r5, f2.C2010a r6) {
        /*
            r2 = this;
            java.lang.String r0 = "itemView"
            kotlin.jvm.internal.m.e(r3, r0)
            java.lang.String r0 = "listener"
            kotlin.jvm.internal.m.e(r4, r0)
            java.lang.String r0 = "topItemsListener"
            kotlin.jvm.internal.m.e(r5, r0)
            java.lang.String r0 = "actionsClickListener"
            kotlin.jvm.internal.m.e(r6, r0)
            android.content.Context r0 = r3.getContext()
            java.lang.String r1 = "getContext(...)"
            kotlin.jvm.internal.m.d(r0, r1)
            r2.<init>(r3, r0)
            r2.f22189b = r4
            r2.f22190c = r5
            r2.f22191d = r6
            r4 = 2131363122(0x7f0a0532, float:1.8346044E38)
            android.view.View r4 = r3.findViewById(r4)
            java.lang.String r5 = "findViewById(...)"
            kotlin.jvm.internal.m.d(r4, r5)
            android.widget.RelativeLayout r4 = (android.widget.RelativeLayout) r4
            r2.f22192e = r4
            r4 = 2131362379(0x7f0a024b, float:1.8344537E38)
            android.view.View r4 = r3.findViewById(r4)
            kotlin.jvm.internal.m.d(r4, r5)
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            r2.f22193f = r4
            r4 = 2131363936(0x7f0a0860, float:1.8347695E38)
            android.view.View r4 = r3.findViewById(r4)
            kotlin.jvm.internal.m.d(r4, r5)
            android.widget.TextView r4 = (android.widget.TextView) r4
            r2.f22194g = r4
            r4 = 2131364006(0x7f0a08a6, float:1.8347837E38)
            android.view.View r4 = r3.findViewById(r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            r2.f22195h = r4
            r4 = 2131363710(0x7f0a077e, float:1.8347237E38)
            android.view.View r4 = r3.findViewById(r4)
            kotlin.jvm.internal.m.d(r4, r5)
            android.widget.TextView r4 = (android.widget.TextView) r4
            r2.f22196i = r4
            r4 = 2131363585(0x7f0a0701, float:1.8346983E38)
            android.view.View r4 = r3.findViewById(r4)
            kotlin.jvm.internal.m.d(r4, r5)
            android.widget.TextView r4 = (android.widget.TextView) r4
            r2.f22197j = r4
            r4 = 2131364367(0x7f0a0a0f, float:1.834857E38)
            android.view.View r4 = r3.findViewById(r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            r2.f22198k = r4
            r4 = 2131363780(0x7f0a07c4, float:1.8347378E38)
            android.view.View r4 = r3.findViewById(r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            r2.f22199l = r4
            r4 = 2131362591(0x7f0a031f, float:1.8344967E38)
            android.view.View r4 = r3.findViewById(r4)
            android.widget.LinearLayout r4 = (android.widget.LinearLayout) r4
            r2.f22200m = r4
            r4 = 2131362575(0x7f0a030f, float:1.8344934E38)
            android.view.View r4 = r3.findViewById(r4)
            kotlin.jvm.internal.m.d(r4, r5)
            android.widget.LinearLayout r4 = (android.widget.LinearLayout) r4
            r2.f22201n = r4
            r4 = 2131364084(0x7f0a08f4, float:1.8347995E38)
            android.view.View r4 = r3.findViewById(r4)
            kotlin.jvm.internal.m.d(r4, r5)
            android.widget.TextView r4 = (android.widget.TextView) r4
            r2.f22202o = r4
            r4 = 2131363024(0x7f0a04d0, float:1.8345845E38)
            android.view.View r4 = r3.findViewById(r4)
            kotlin.jvm.internal.m.d(r4, r5)
            android.widget.ProgressBar r4 = (android.widget.ProgressBar) r4
            r2.f22203p = r4
            r4 = 2131364373(0x7f0a0a15, float:1.8348581E38)
            android.view.View r4 = r3.findViewById(r4)
            kotlin.jvm.internal.m.d(r4, r5)
            android.widget.TextView r4 = (android.widget.TextView) r4
            r2.f22204q = r4
            r4 = 2131363636(0x7f0a0734, float:1.8347086E38)
            android.view.View r3 = r3.findViewById(r4)
            android.widget.TextView r3 = (android.widget.TextView) r3
            r2.f22205r = r3
            android.widget.TextView r3 = r2.f22194g
            N1.k$a r4 = N1.k.f7778g
            android.graphics.Typeface r5 = r4.w()
            r3.setTypeface(r5)
            android.widget.TextView r3 = r2.f22195h
            if (r3 == 0) goto L_0x00f3
            android.graphics.Typeface r5 = r4.w()
            r3.setTypeface(r5)
        L_0x00f3:
            android.widget.TextView r3 = r2.f22198k
            if (r3 == 0) goto L_0x00fe
            android.graphics.Typeface r5 = r4.x()
            r3.setTypeface(r5)
        L_0x00fe:
            android.widget.TextView r3 = r2.f22199l
            if (r3 == 0) goto L_0x0109
            android.graphics.Typeface r5 = r4.x()
            r3.setTypeface(r5)
        L_0x0109:
            android.widget.TextView r3 = r2.f22196i
            android.graphics.Typeface r5 = r4.x()
            r3.setTypeface(r5)
            android.widget.TextView r3 = r2.f22197j
            android.graphics.Typeface r5 = r4.w()
            r3.setTypeface(r5)
            android.widget.TextView r3 = r2.f22204q
            android.graphics.Typeface r5 = r4.x()
            r3.setTypeface(r5)
            android.widget.TextView r3 = r2.f22202o
            android.graphics.Typeface r5 = r4.x()
            r3.setTypeface(r5)
            android.widget.TextView r3 = r2.f22205r
            if (r3 == 0) goto L_0x0138
            android.graphics.Typeface r4 = r4.x()
            r3.setTypeface(r4)
        L_0x0138:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: x2.K0.<init>(android.view.View, f2.d, f2.e, f2.a):void");
    }

    /* access modifiers changed from: private */
    public static final void A(K0 k02, C2050h hVar, int i4, View view) {
        k02.f22190c.a(hVar, i4);
    }

    private final void B(C2050h hVar, int i4) {
        v(hVar, i4);
        this.f22197j.setText(R.string.option_button_install);
        this.f22197j.setOnClickListener(new G0(this, hVar, i4));
        v.a(this.f22197j);
    }

    /* access modifiers changed from: private */
    public static final void C(K0 k02, C2050h hVar, int i4, View view) {
        k02.f22190c.b(hVar, i4);
        k02.D();
    }

    private final void D() {
        C2345c.f22021a.e(this.f22203p, this.f22193f);
        LinearLayout linearLayout = this.f22200m;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        this.f22197j.setVisibility(8);
        this.f22196i.setVisibility(8);
        this.f22201n.setVisibility(0);
        this.f22202o.setText(this.itemView.getContext().getString(R.string.installing));
        this.f22203p.setIndeterminate(true);
    }

    private final void E(C2050h hVar, int i4) {
        v(hVar, i4);
        this.f22197j.setText(R.string.open);
        v.a(this.f22197j);
    }

    private final void F(C2050h hVar, int i4) {
        v(hVar, i4);
        this.f22197j.setText(this.itemView.getContext().getString(R.string.status_download_update));
        this.f22197j.setOnClickListener(new J0(this, hVar, i4));
        v.a(this.f22197j);
    }

    /* access modifiers changed from: private */
    public static final void G(K0 k02, C2050h hVar, int i4, View view) {
        k02.f22190c.b(hVar, i4);
        k02.D();
    }

    /* access modifiers changed from: private */
    public static final boolean s(K0 k02, C2050h hVar, int i4, View view) {
        k02.f22191d.a(hVar, i4);
        return true;
    }

    /* access modifiers changed from: private */
    public static final void t(K0 k02, C2050h hVar, int i4, View view) {
        k02.f22190c.b(hVar, i4);
    }

    private final String u(long j4) {
        if (j4 < 1000) {
            return String.valueOf(j4);
        }
        if (j4 < 1000000) {
            F f4 = F.f20971a;
            String format = String.format(Locale.getDefault(), "%dK", Arrays.copyOf(new Object[]{Integer.valueOf(((int) j4) / 1000)}, 1));
            m.d(format, "format(...)");
            return format;
        }
        F f5 = F.f20971a;
        String format2 = String.format(Locale.getDefault(), "%dM", Arrays.copyOf(new Object[]{Integer.valueOf(((int) j4) / 1000000)}, 1));
        m.d(format2, "format(...)");
        return format2;
    }

    private final void v(C2050h hVar, int i4) {
        C2345c.f22021a.c(this.f22203p, this.f22193f);
        this.f22197j.setOnClickListener(new H0(this, hVar, i4));
        this.f22201n.setVisibility(8);
        this.f22196i.setVisibility(0);
        this.f22197j.setVisibility(0);
    }

    /* access modifiers changed from: private */
    public static final void w(K0 k02, C2050h hVar, int i4, View view) {
        k02.f22190c.b(hVar, i4);
    }

    private final void x(C2050h hVar, int i4) {
        C2060s sVar;
        boolean z4;
        boolean z5;
        String Q4;
        t.a aVar = t.f21927u;
        Context context = this.itemView.getContext();
        m.d(context, "getContext(...)");
        t a5 = aVar.a(context);
        a5.a();
        S s4 = null;
        if (hVar.z() > 0) {
            sVar = a5.f0(String.valueOf(hVar.z()));
            if (!(sVar != null || (Q4 = hVar.Q()) == null || Q4.length() == 0)) {
                String Q5 = hVar.Q();
                m.b(Q5);
                sVar = a5.h0(Q5);
            }
        } else {
            String Q6 = hVar.Q();
            if (Q6 == null || Q6.length() == 0) {
                sVar = null;
            } else {
                String Q7 = hVar.Q();
                m.b(Q7);
                sVar = a5.i0(Q7, hVar.H());
            }
        }
        String Q8 = hVar.Q();
        if (!(Q8 == null || Q8.length() == 0)) {
            String Q9 = hVar.Q();
            m.b(Q9);
            s4 = a5.D0(Q9);
        }
        a5.i();
        boolean s5 = new u2.m().s(hVar.Q(), this.itemView.getContext());
        UptodownApp.a aVar2 = UptodownApp.f17422D;
        Context context2 = this.itemView.getContext();
        m.d(context2, "getContext(...)");
        boolean T4 = aVar2.T("downloadApkWorker", context2);
        boolean z6 = false;
        if (!T4 || !DownloadWorker.f19459d.j(hVar.e())) {
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
        if (sVar == null || (!z4 && !z6)) {
            C2050h hVar2 = hVar;
            int i5 = i4;
            if (s5) {
                if (s4 == null || s4.m()) {
                    E(hVar2, i5);
                } else if (sVar == null || !sVar.f()) {
                    y(hVar2, i5);
                } else {
                    F(hVar2, i5);
                }
            } else if (z5) {
                B(hVar2, i5);
            } else {
                y(hVar2, i5);
            }
        } else {
            z(sVar.x(), sVar.z(), hVar, i4);
        }
    }

    private final void y(C2050h hVar, int i4) {
        v(hVar, i4);
        this.f22197j.setText(R.string.option_button_install);
        v.a(this.f22197j);
    }

    private final void z(int i4, long j4, C2050h hVar, int i5) {
        C2345c.f22021a.e(this.f22203p, this.f22193f);
        LinearLayout linearLayout = this.f22200m;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        this.f22197j.setText(R.string.option_button_cancel);
        this.f22197j.setBackground(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.shape_stroke_blue_primary));
        this.f22197j.setTextColor(ContextCompat.getColor(this.itemView.getContext(), R.color.blue_primary));
        this.f22197j.setOnClickListener(new I0(this, hVar, i5));
        this.f22196i.setVisibility(8);
        this.f22201n.setVisibility(0);
        if (i4 == 0) {
            this.f22202o.setText(this.itemView.getContext().getString(R.string.status_download_update_pending));
            this.f22203p.setIndeterminate(true);
            return;
        }
        this.f22203p.setIndeterminate(false);
        TextView textView = this.f22202o;
        Context context = this.itemView.getContext();
        Integer valueOf = Integer.valueOf(i4);
        i iVar = new i();
        Context context2 = this.itemView.getContext();
        m.d(context2, "getContext(...)");
        textView.setText(context.getString(R.string.percent_of_total_size, new Object[]{valueOf, iVar.d(j4, context2)}));
        this.f22203p.setProgress(i4);
    }

    public final void r(C2050h hVar, int i4, int i5) {
        m.e(hVar, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
        this.f22192e.setOnLongClickListener(new E0(this, hVar, i5));
        c(this.f22192e, this.f22189b, hVar);
        TextView textView = this.f22195h;
        if (textView != null) {
            textView.setText(this.itemView.getContext().getResources().getString(R.string.top_index_format, new Object[]{String.valueOf(i4)}));
        }
        if (hVar.V() <= 0 || hVar.p() <= 0) {
            LinearLayout linearLayout = this.f22200m;
            if (linearLayout != null) {
                linearLayout.setVisibility(4);
            }
        } else {
            TextView textView2 = this.f22198k;
            if (textView2 != null) {
                textView2.setText(String.valueOf(((double) hVar.V()) / 10.0d));
            }
            TextView textView3 = this.f22199l;
            if (textView3 != null) {
                textView3.setText(this.itemView.getContext().getString(R.string.downloads_counter_multiple, new Object[]{u((long) hVar.p())}));
            }
            LinearLayout linearLayout2 = this.f22200m;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(0);
            }
        }
        this.f22194g.setText(hVar.L());
        String j4 = hVar.j();
        if (j4 == null || j4.length() == 0) {
            this.f22196i.setText(hVar.g());
        } else {
            TextView textView4 = this.f22196i;
            C2059q.a aVar = C2059q.f20700f;
            String j5 = hVar.j();
            m.b(j5);
            textView4.setText(aVar.j(new SpannableStringBuilder(j5)));
        }
        this.f22197j.setOnClickListener(new F0(this, hVar, i5));
        h(this.f22193f, hVar.E());
        x(hVar, i5);
    }
}
