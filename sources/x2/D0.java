package x2;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mbridge.msdk.MBridgeConstans;
import com.uptodown.R;
import f2.C2010a;
import f2.C2013d;
import f2.C2014e;
import g2.C2050h;
import g2.C2059q;
import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.internal.F;
import kotlin.jvm.internal.m;
import u2.t;
import w2.C2345c;
import w2.v;

public final class D0 extends C2375j {

    /* renamed from: b  reason: collision with root package name */
    private final C2013d f22125b;

    /* renamed from: c  reason: collision with root package name */
    private final C2014e f22126c;

    /* renamed from: d  reason: collision with root package name */
    private final C2010a f22127d;

    /* renamed from: e  reason: collision with root package name */
    private RelativeLayout f22128e;

    /* renamed from: f  reason: collision with root package name */
    private ImageView f22129f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f22130g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f22131h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f22132i;

    /* renamed from: j  reason: collision with root package name */
    private TextView f22133j;

    /* renamed from: k  reason: collision with root package name */
    private TextView f22134k;

    /* renamed from: l  reason: collision with root package name */
    private TextView f22135l;

    /* renamed from: m  reason: collision with root package name */
    private LinearLayout f22136m;

    /* renamed from: n  reason: collision with root package name */
    private LinearLayout f22137n;

    /* renamed from: o  reason: collision with root package name */
    private TextView f22138o;

    /* renamed from: p  reason: collision with root package name */
    private ProgressBar f22139p;

    /* renamed from: q  reason: collision with root package name */
    private TextView f22140q;

    /* renamed from: r  reason: collision with root package name */
    private TextView f22141r;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public D0(android.view.View r3, f2.C2013d r4, f2.C2014e r5, f2.C2010a r6) {
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
            r2.f22125b = r4
            r2.f22126c = r5
            r2.f22127d = r6
            r4 = 2131363122(0x7f0a0532, float:1.8346044E38)
            android.view.View r4 = r3.findViewById(r4)
            java.lang.String r5 = "findViewById(...)"
            kotlin.jvm.internal.m.d(r4, r5)
            android.widget.RelativeLayout r4 = (android.widget.RelativeLayout) r4
            r2.f22128e = r4
            r4 = 2131362379(0x7f0a024b, float:1.8344537E38)
            android.view.View r4 = r3.findViewById(r4)
            kotlin.jvm.internal.m.d(r4, r5)
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            r2.f22129f = r4
            r4 = 2131363936(0x7f0a0860, float:1.8347695E38)
            android.view.View r4 = r3.findViewById(r4)
            kotlin.jvm.internal.m.d(r4, r5)
            android.widget.TextView r4 = (android.widget.TextView) r4
            r2.f22130g = r4
            r4 = 2131364006(0x7f0a08a6, float:1.8347837E38)
            android.view.View r4 = r3.findViewById(r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            r2.f22131h = r4
            r4 = 2131363710(0x7f0a077e, float:1.8347237E38)
            android.view.View r4 = r3.findViewById(r4)
            kotlin.jvm.internal.m.d(r4, r5)
            android.widget.TextView r4 = (android.widget.TextView) r4
            r2.f22132i = r4
            r4 = 2131363585(0x7f0a0701, float:1.8346983E38)
            android.view.View r4 = r3.findViewById(r4)
            kotlin.jvm.internal.m.d(r4, r5)
            android.widget.TextView r4 = (android.widget.TextView) r4
            r2.f22133j = r4
            r4 = 2131364367(0x7f0a0a0f, float:1.834857E38)
            android.view.View r4 = r3.findViewById(r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            r2.f22134k = r4
            r4 = 2131363780(0x7f0a07c4, float:1.8347378E38)
            android.view.View r4 = r3.findViewById(r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            r2.f22135l = r4
            r4 = 2131362591(0x7f0a031f, float:1.8344967E38)
            android.view.View r4 = r3.findViewById(r4)
            android.widget.LinearLayout r4 = (android.widget.LinearLayout) r4
            r2.f22136m = r4
            r4 = 2131362575(0x7f0a030f, float:1.8344934E38)
            android.view.View r4 = r3.findViewById(r4)
            kotlin.jvm.internal.m.d(r4, r5)
            android.widget.LinearLayout r4 = (android.widget.LinearLayout) r4
            r2.f22137n = r4
            r4 = 2131364084(0x7f0a08f4, float:1.8347995E38)
            android.view.View r4 = r3.findViewById(r4)
            kotlin.jvm.internal.m.d(r4, r5)
            android.widget.TextView r4 = (android.widget.TextView) r4
            r2.f22138o = r4
            r4 = 2131363024(0x7f0a04d0, float:1.8345845E38)
            android.view.View r4 = r3.findViewById(r4)
            kotlin.jvm.internal.m.d(r4, r5)
            android.widget.ProgressBar r4 = (android.widget.ProgressBar) r4
            r2.f22139p = r4
            r4 = 2131364373(0x7f0a0a15, float:1.8348581E38)
            android.view.View r4 = r3.findViewById(r4)
            kotlin.jvm.internal.m.d(r4, r5)
            android.widget.TextView r4 = (android.widget.TextView) r4
            r2.f22140q = r4
            r4 = 2131363636(0x7f0a0734, float:1.8347086E38)
            android.view.View r3 = r3.findViewById(r4)
            android.widget.TextView r3 = (android.widget.TextView) r3
            r2.f22141r = r3
            android.widget.TextView r3 = r2.f22130g
            N1.k$a r4 = N1.k.f7778g
            android.graphics.Typeface r5 = r4.w()
            r3.setTypeface(r5)
            android.widget.TextView r3 = r2.f22131h
            if (r3 == 0) goto L_0x00f3
            android.graphics.Typeface r5 = r4.w()
            r3.setTypeface(r5)
        L_0x00f3:
            android.widget.TextView r3 = r2.f22134k
            if (r3 == 0) goto L_0x00fe
            android.graphics.Typeface r5 = r4.x()
            r3.setTypeface(r5)
        L_0x00fe:
            android.widget.TextView r3 = r2.f22135l
            if (r3 == 0) goto L_0x0109
            android.graphics.Typeface r5 = r4.x()
            r3.setTypeface(r5)
        L_0x0109:
            android.widget.TextView r3 = r2.f22132i
            android.graphics.Typeface r5 = r4.x()
            r3.setTypeface(r5)
            android.widget.TextView r3 = r2.f22133j
            android.graphics.Typeface r5 = r4.w()
            r3.setTypeface(r5)
            android.widget.TextView r3 = r2.f22140q
            android.graphics.Typeface r5 = r4.x()
            r3.setTypeface(r5)
            android.widget.TextView r3 = r2.f22138o
            android.graphics.Typeface r5 = r4.x()
            r3.setTypeface(r5)
            android.widget.TextView r3 = r2.f22141r
            if (r3 == 0) goto L_0x0138
            android.graphics.Typeface r4 = r4.x()
            r3.setTypeface(r4)
        L_0x0138:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: x2.D0.<init>(android.view.View, f2.d, f2.e, f2.a):void");
    }

    /* access modifiers changed from: private */
    public static final boolean p(D0 d02, C2050h hVar, int i4, View view) {
        d02.f22127d.a(hVar, i4);
        return true;
    }

    /* access modifiers changed from: private */
    public static final void q(D0 d02, C2050h hVar, int i4, View view) {
        d02.f22126c.b(hVar, i4);
    }

    private final String r(long j4) {
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

    private final void s(C2050h hVar, int i4) {
        C2345c.f22021a.c(this.f22139p, this.f22129f);
        this.f22133j.setOnClickListener(new C0(this, hVar, i4));
        this.f22137n.setVisibility(8);
        this.f22132i.setVisibility(0);
        this.f22133j.setVisibility(0);
    }

    /* access modifiers changed from: private */
    public static final void t(D0 d02, C2050h hVar, int i4, View view) {
        d02.f22126c.b(hVar, i4);
    }

    public final void o(C2050h hVar, int i4, int i5) {
        m.e(hVar, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
        this.f22128e.setOnLongClickListener(new A0(this, hVar, i5));
        c(this.f22128e, this.f22125b, hVar);
        TextView textView = this.f22131h;
        if (textView != null) {
            textView.setText(this.itemView.getContext().getResources().getString(R.string.top_index_format, new Object[]{String.valueOf(i4)}));
        }
        if (hVar.V() <= 0 || hVar.p() <= 0) {
            LinearLayout linearLayout = this.f22136m;
            if (linearLayout != null) {
                linearLayout.setVisibility(4);
            }
        } else {
            TextView textView2 = this.f22134k;
            if (textView2 != null) {
                textView2.setText(String.valueOf(((double) hVar.V()) / 10.0d));
            }
            TextView textView3 = this.f22135l;
            if (textView3 != null) {
                textView3.setText(this.itemView.getContext().getString(R.string.pre_registration_counter, new Object[]{r((long) hVar.p())}));
            }
            LinearLayout linearLayout2 = this.f22136m;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(0);
            }
        }
        this.f22130g.setText(hVar.L());
        String j4 = hVar.j();
        if (j4 == null || j4.length() == 0) {
            this.f22132i.setText(hVar.g());
        } else {
            TextView textView4 = this.f22132i;
            C2059q.a aVar = C2059q.f20700f;
            String j5 = hVar.j();
            m.b(j5);
            textView4.setText(aVar.j(new SpannableStringBuilder(j5)));
        }
        this.f22133j.setOnClickListener(new B0(this, hVar, i5));
        h(this.f22129f, hVar.E());
        s(hVar, i5);
        if (this.itemView.getContext() != null) {
            t.a aVar2 = t.f21927u;
            Context context = this.itemView.getContext();
            m.d(context, "getContext(...)");
            t a5 = aVar2.a(context);
            a5.a();
            if (a5.v0(hVar.e()) == null) {
                this.f22133j.setText(R.string.pre_registration_title);
                v.a(this.f22133j);
            } else {
                this.f22133j.setText(R.string.cancel_registration);
                v.e(this.f22133j);
            }
            a5.i();
        }
    }
}
