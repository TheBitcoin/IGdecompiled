package x2;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.mbridge.msdk.MBridgeConstans;
import com.squareup.picasso.s;
import com.squareup.picasso.w;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import f2.C2010a;
import f2.C2028t;
import g2.C2050h;
import kotlin.jvm.internal.m;

public final class Q extends C2375j {

    /* renamed from: b  reason: collision with root package name */
    private C2028t f22242b;

    /* renamed from: c  reason: collision with root package name */
    private final C2010a f22243c;

    /* renamed from: d  reason: collision with root package name */
    private final ProgressBar f22244d;

    /* renamed from: e  reason: collision with root package name */
    private ImageView f22245e;

    /* renamed from: f  reason: collision with root package name */
    private ImageView f22246f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f22247g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f22248h;

    /* renamed from: i  reason: collision with root package name */
    private final TextView f22249i;

    /* renamed from: j  reason: collision with root package name */
    private final TextView f22250j;

    /* renamed from: k  reason: collision with root package name */
    private final TextView f22251k;

    /* renamed from: l  reason: collision with root package name */
    private final LinearLayout f22252l;

    /* renamed from: m  reason: collision with root package name */
    private String f22253m;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Q(android.view.View r4, f2.C2028t r5, f2.C2010a r6) {
        /*
            r3 = this;
            java.lang.String r0 = "itemView"
            kotlin.jvm.internal.m.e(r4, r0)
            java.lang.String r0 = "listener"
            kotlin.jvm.internal.m.e(r5, r0)
            java.lang.String r0 = "actionsClickListener"
            kotlin.jvm.internal.m.e(r6, r0)
            android.content.Context r0 = r4.getContext()
            java.lang.String r1 = "getContext(...)"
            kotlin.jvm.internal.m.d(r0, r1)
            r3.<init>(r4, r0)
            r3.f22242b = r5
            r3.f22243c = r6
            r5 = 2131363029(0x7f0a04d5, float:1.8345855E38)
            android.view.View r5 = r4.findViewById(r5)
            java.lang.String r6 = "findViewById(...)"
            kotlin.jvm.internal.m.d(r5, r6)
            android.widget.ProgressBar r5 = (android.widget.ProgressBar) r5
            r3.f22244d = r5
            r5 = 2131362384(0x7f0a0250, float:1.8344547E38)
            android.view.View r5 = r4.findViewById(r5)
            kotlin.jvm.internal.m.d(r5, r6)
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            r3.f22245e = r5
            r5 = 2131362327(0x7f0a0217, float:1.8344431E38)
            android.view.View r5 = r4.findViewById(r5)
            kotlin.jvm.internal.m.d(r5, r6)
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            r3.f22246f = r5
            r5 = 2131363946(0x7f0a086a, float:1.8347715E38)
            android.view.View r5 = r4.findViewById(r5)
            kotlin.jvm.internal.m.d(r5, r6)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r3.f22247g = r5
            r5 = 2131363715(0x7f0a0783, float:1.8347247E38)
            android.view.View r5 = r4.findViewById(r5)
            kotlin.jvm.internal.m.d(r5, r6)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r3.f22248h = r5
            r5 = 2131364216(0x7f0a0978, float:1.8348263E38)
            android.view.View r5 = r4.findViewById(r5)
            kotlin.jvm.internal.m.d(r5, r6)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r3.f22249i = r5
            r0 = 2131364089(0x7f0a08f9, float:1.8348005E38)
            android.view.View r0 = r4.findViewById(r0)
            kotlin.jvm.internal.m.d(r0, r6)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r3.f22250j = r0
            r1 = 2131364379(0x7f0a0a1b, float:1.8348593E38)
            android.view.View r1 = r4.findViewById(r1)
            kotlin.jvm.internal.m.d(r1, r6)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r3.f22251k = r1
            r2 = 2131362630(0x7f0a0346, float:1.8345046E38)
            android.view.View r4 = r4.findViewById(r2)
            kotlin.jvm.internal.m.d(r4, r6)
            android.widget.LinearLayout r4 = (android.widget.LinearLayout) r4
            r3.f22252l = r4
            android.widget.TextView r4 = r3.f22247g
            N1.k$a r6 = N1.k.f7778g
            android.graphics.Typeface r2 = r6.w()
            r4.setTypeface(r2)
            android.widget.TextView r4 = r3.f22248h
            android.graphics.Typeface r2 = r6.x()
            r4.setTypeface(r2)
            android.graphics.Typeface r4 = r6.x()
            r0.setTypeface(r4)
            android.graphics.Typeface r4 = r6.x()
            r1.setTypeface(r4)
            android.graphics.Typeface r4 = r6.x()
            r5.setTypeface(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: x2.Q.<init>(android.view.View, f2.t, f2.a):void");
    }

    /* access modifiers changed from: private */
    public static final boolean o(Q q4, C2050h hVar, View view) {
        q4.f22243c.a(hVar, -1);
        return true;
    }

    private final void q(View view, C2050h hVar) {
        view.setOnClickListener(new P(this, hVar));
    }

    /* access modifiers changed from: private */
    public static final void r(Q q4, C2050h hVar, View view) {
        q4.f22242b.a(hVar);
    }

    public final void n(C2050h hVar) {
        m.e(hVar, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
        this.f22253m = hVar.Q();
        View view = this.itemView;
        m.d(view, "itemView");
        q(view, hVar);
        this.itemView.setOnLongClickListener(new O(this, hVar));
        w l4 = s.h().l(hVar.y()).l(R.color.main_blue);
        UptodownApp.a aVar = UptodownApp.f17422D;
        Context context = this.itemView.getContext();
        m.d(context, "getContext(...)");
        l4.n(aVar.h0(context)).i(this.f22246f);
        i(hVar, this.f22247g, this.f22248h);
        h(this.f22245e, hVar.F());
        e(hVar, this.f22244d, this.f22245e, this.f22248h, this.f22250j, this.f22249i, this.f22252l);
    }

    public final String p() {
        return this.f22253m;
    }
}
