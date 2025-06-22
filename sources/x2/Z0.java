package x2;

import M1.J;
import N1.k;
import T1.a;
import T1.c;
import W1.i;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mbridge.msdk.MBridgeConstans;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.workers.DownloadWorker;
import f2.C2008G;
import g2.C2048f;
import g2.C2060s;
import g2.S;
import kotlin.jvm.internal.m;
import u2.F;
import u2.q;
import u2.t;
import w2.v;

public final class Z0 extends C2381m {

    /* renamed from: b  reason: collision with root package name */
    private final C2008G f22297b;

    /* renamed from: c  reason: collision with root package name */
    private final ImageView f22298c;

    /* renamed from: d  reason: collision with root package name */
    private final TextView f22299d;

    /* renamed from: e  reason: collision with root package name */
    private final ProgressBar f22300e;

    /* renamed from: f  reason: collision with root package name */
    private final TextView f22301f;

    /* renamed from: g  reason: collision with root package name */
    private final TextView f22302g;

    /* renamed from: h  reason: collision with root package name */
    private final TextView f22303h;

    /* renamed from: i  reason: collision with root package name */
    private final TextView f22304i;

    /* renamed from: j  reason: collision with root package name */
    private final TextView f22305j;

    /* renamed from: k  reason: collision with root package name */
    private final RelativeLayout f22306k;

    /* renamed from: l  reason: collision with root package name */
    private final TextView f22307l;

    /* renamed from: m  reason: collision with root package name */
    private final ImageView f22308m;

    /* renamed from: n  reason: collision with root package name */
    private final RelativeLayout f22309n;

    /* renamed from: o  reason: collision with root package name */
    private final TextView f22310o;

    /* renamed from: p  reason: collision with root package name */
    private final RelativeLayout f22311p;

    /* renamed from: q  reason: collision with root package name */
    private final RelativeLayout f22312q;

    /* renamed from: r  reason: collision with root package name */
    private final TextView f22313r;

    /* renamed from: s  reason: collision with root package name */
    private final ImageView f22314s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Z0(View view, C2008G g4) {
        super(view);
        m.e(view, "itemView");
        this.f22297b = g4;
        View findViewById = view.findViewById(R.id.iv_icon_update_item);
        m.d(findViewById, "findViewById(...)");
        this.f22298c = (ImageView) findViewById;
        View findViewById2 = view.findViewById(R.id.tv_name_update_item);
        m.d(findViewById2, "findViewById(...)");
        TextView textView = (TextView) findViewById2;
        this.f22299d = textView;
        View findViewById3 = view.findViewById(R.id.pb_progress_update_item);
        m.d(findViewById3, "findViewById(...)");
        this.f22300e = (ProgressBar) findViewById3;
        View findViewById4 = view.findViewById(R.id.tv_version_update_item);
        m.d(findViewById4, "findViewById(...)");
        TextView textView2 = (TextView) findViewById4;
        this.f22301f = textView2;
        View findViewById5 = view.findViewById(R.id.tv_size_update_item);
        m.d(findViewById5, "findViewById(...)");
        TextView textView3 = (TextView) findViewById5;
        this.f22302g = textView3;
        View findViewById6 = view.findViewById(R.id.tv_last_update_item);
        m.d(findViewById6, "findViewById(...)");
        TextView textView4 = (TextView) findViewById6;
        this.f22303h = textView4;
        View findViewById7 = view.findViewById(R.id.tv_verified_by_uptodown_update_item);
        m.d(findViewById7, "findViewById(...)");
        TextView textView5 = (TextView) findViewById7;
        this.f22304i = textView5;
        View findViewById8 = view.findViewById(R.id.tv_action_update_item);
        m.d(findViewById8, "findViewById(...)");
        TextView textView6 = (TextView) findViewById8;
        this.f22305j = textView6;
        View findViewById9 = view.findViewById(R.id.rl_actions_update_item);
        m.d(findViewById9, "findViewById(...)");
        this.f22306k = (RelativeLayout) findViewById9;
        View findViewById10 = view.findViewById(R.id.tv_excluded_update_item);
        m.d(findViewById10, "findViewById(...)");
        TextView textView7 = (TextView) findViewById10;
        this.f22307l = textView7;
        View findViewById11 = view.findViewById(R.id.iv_version_details_update_item);
        m.d(findViewById11, "findViewById(...)");
        this.f22308m = (ImageView) findViewById11;
        View findViewById12 = view.findViewById(R.id.rl_version_details_update_item);
        m.d(findViewById12, "findViewById(...)");
        this.f22309n = (RelativeLayout) findViewById12;
        View findViewById13 = view.findViewById(R.id.tv_version_details_update_item);
        m.d(findViewById13, "findViewById(...)");
        TextView textView8 = (TextView) findViewById13;
        this.f22310o = textView8;
        View findViewById14 = view.findViewById(R.id.rl_container_update_item);
        m.d(findViewById14, "findViewById(...)");
        RelativeLayout relativeLayout = (RelativeLayout) findViewById14;
        this.f22311p = relativeLayout;
        View findViewById15 = view.findViewById(R.id.rl_cancel_update_item);
        m.d(findViewById15, "findViewById(...)");
        this.f22312q = (RelativeLayout) findViewById15;
        View findViewById16 = view.findViewById(R.id.tv_pending_update_item);
        m.d(findViewById16, "findViewById(...)");
        TextView textView9 = (TextView) findViewById16;
        this.f22313r = textView9;
        View findViewById17 = view.findViewById(R.id.iv_cancel_update_item);
        m.d(findViewById17, "findViewById(...)");
        ImageView imageView = (ImageView) findViewById17;
        this.f22314s = imageView;
        relativeLayout.setOnClickListener(new W0(this));
        textView6.setOnClickListener(new X0(this));
        imageView.setOnClickListener(new Y0(this));
        k.a aVar = k.f7778g;
        textView.setTypeface(aVar.w());
        textView2.setTypeface(aVar.w());
        textView3.setTypeface(aVar.x());
        textView5.setTypeface(aVar.x());
        textView9.setTypeface(aVar.w());
        textView8.setTypeface(aVar.x());
        textView7.setTypeface(aVar.w());
        textView6.setTypeface(aVar.w());
        textView4.setTypeface(aVar.x());
    }

    private final void A(int i4) {
        this.f22301f.setVisibility(0);
        this.f22301f.setText(this.itemView.getContext().getString(R.string.unzipping_status, new Object[]{Integer.valueOf(i4)}));
        this.f22303h.setVisibility(8);
        this.f22302g.setVisibility(8);
        this.f22304i.setVisibility(0);
        if (this.f22300e.isIndeterminate()) {
            this.f22300e.setIndeterminate(false);
        }
        this.f22300e.setProgress(i4);
        this.f22306k.setVisibility(8);
        e(this.f22300e, this.f22298c);
    }

    private final void B() {
        this.f22305j.setText(this.itemView.getContext().getString(R.string.updates_button_update_app));
        v.b(this.f22305j);
        this.f22305j.setVisibility(0);
        this.f22304i.setVisibility(8);
        this.f22303h.setVisibility(0);
    }

    /* access modifiers changed from: private */
    public static final void k(Z0 z02, View view) {
        int bindingAdapterPosition;
        if (z02.f22297b != null && (bindingAdapterPosition = z02.getBindingAdapterPosition()) != -1) {
            z02.f22297b.a(bindingAdapterPosition);
        }
    }

    /* access modifiers changed from: private */
    public static final void l(Z0 z02, View view) {
        C2008G g4 = z02.f22297b;
        if (g4 != null) {
            g4.c(z02.getBindingAdapterPosition());
        }
    }

    /* access modifiers changed from: private */
    public static final void m(Z0 z02, View view) {
        C2008G g4 = z02.f22297b;
        if (g4 != null) {
            g4.d(z02.getBindingAdapterPosition());
        }
    }

    private final void n(C2048f fVar, S s4, boolean z4, boolean z5) {
        C2060s sVar;
        String str;
        v();
        r(fVar);
        F f4 = F.f21886a;
        Context context = this.itemView.getContext();
        m.d(context, "getContext(...)");
        this.f22298c.setImageDrawable(f4.k(context, fVar.o()));
        this.f22299d.setText(fVar.m());
        TextView textView = this.f22302g;
        i iVar = new i();
        long t4 = fVar.t();
        Context context2 = this.itemView.getContext();
        m.d(context2, "getContext(...)");
        textView.setText(iVar.d(t4, context2));
        this.f22303h.setText(new q().k(fVar.j()));
        t.a aVar = t.f21927u;
        Context context3 = this.itemView.getContext();
        m.d(context3, "getContext(...)");
        t a5 = aVar.a(context3);
        a5.a();
        String str2 = null;
        if (s4.a() != null) {
            C2060s a6 = s4.a();
            m.b(a6);
            sVar = a5.g0(a6.q());
        } else {
            sVar = null;
        }
        a5.i();
        if (sVar == null || sVar.o().size() != 1 || !sVar.f()) {
            str = null;
        } else {
            str = ((C2060s.c) sVar.o().get(0)).a();
        }
        this.f22301f.setText(s4.k());
        if (!s4.m()) {
            k.a aVar2 = k.f7778g;
            a i4 = aVar2.i();
            if (i4 != null) {
                str2 = i4.b();
            }
            if (m3.m.p(str2, fVar.o(), true) || z4) {
                z();
            } else {
                if (aVar2.j() != null) {
                    c j4 = aVar2.j();
                    m.b(j4);
                    if (m3.m.p(str, j4.a(), true)) {
                        c j5 = aVar2.j();
                        m.b(j5);
                        A(j5.b());
                    }
                }
                if (s4.c()) {
                    if (sVar != null) {
                        TextView textView2 = this.f22301f;
                        Context context4 = this.itemView.getContext();
                        Integer valueOf = Integer.valueOf(sVar.x());
                        i iVar2 = new i();
                        long z6 = sVar.z();
                        Context context5 = this.itemView.getContext();
                        m.d(context5, "getContext(...)");
                        textView2.setText(context4.getString(R.string.percent_of_total_size, new Object[]{valueOf, iVar2.d(z6, context5)}));
                    }
                    w();
                } else {
                    UptodownApp.a aVar3 = UptodownApp.f17422D;
                    String o4 = fVar.o();
                    m.b(o4);
                    if (aVar3.P(o4) || z5) {
                        u();
                    } else {
                        B();
                    }
                }
                if (sVar != null) {
                    this.f22300e.setProgress(sVar.x());
                }
                if (!s4.c() || DownloadWorker.f19459d.h()) {
                    c(this.f22300e, this.f22298c);
                } else {
                    e(this.f22300e, this.f22298c);
                }
            }
        } else if (s4.e() == 1) {
            String string = this.itemView.getContext().getString(R.string.skipped_update);
            m.d(string, "getString(...)");
            y(string);
        } else {
            x();
        }
        String f5 = s4.f();
        if (f5 == null || f5.length() == 0) {
            this.f22310o.setVisibility(8);
            this.f22309n.setVisibility(8);
            this.f22308m.setVisibility(8);
        } else {
            this.f22309n.setVisibility(0);
            this.f22308m.setVisibility(0);
            if (fVar.s()) {
                this.f22310o.setText(s4.f());
                t();
            } else {
                s();
            }
        }
        this.f22308m.setOnClickListener(new V0(fVar, this));
    }

    /* access modifiers changed from: private */
    public static final void o(C2048f fVar, Z0 z02, View view) {
        if (!UptodownApp.f17422D.a0()) {
            return;
        }
        if (!fVar.s()) {
            C2008G g4 = z02.f22297b;
            if (g4 != null) {
                g4.b(z02.getBindingAdapterPosition());
                return;
            }
            return;
        }
        C2008G g5 = z02.f22297b;
        if (g5 != null) {
            g5.e(z02.getBindingAdapterPosition());
        }
    }

    private final void r(C2048f fVar) {
        if (fVar.d()) {
            this.itemView.setAlpha(0.3f);
        } else {
            this.itemView.setAlpha(1.0f);
        }
    }

    private final void s() {
        this.f22310o.setVisibility(8);
        this.f22309n.setVisibility(8);
        this.f22308m.setScaleY(1.0f);
        this.f22308m.setContentDescription(this.itemView.getContext().getString(R.string.cd_expand_version_details));
    }

    private final void t() {
        this.f22309n.setVisibility(0);
        this.f22310o.setVisibility(0);
        this.f22308m.setScaleY(-1.0f);
        this.f22308m.setContentDescription(this.itemView.getContext().getString(R.string.cd_collapse_version_details));
    }

    private final void u() {
        this.f22313r.setVisibility(0);
        this.f22312q.setVisibility(0);
    }

    private final void v() {
        this.f22305j.setVisibility(8);
        this.f22306k.setVisibility(0);
        if (!this.f22300e.isIndeterminate()) {
            this.f22300e.setIndeterminate(true);
        }
        this.f22307l.setVisibility(8);
        this.f22312q.setVisibility(8);
        this.f22302g.setVisibility(0);
        this.f22313r.setVisibility(8);
    }

    private final void w() {
        this.f22312q.setVisibility(0);
        this.f22301f.setVisibility(0);
        this.f22307l.setVisibility(8);
        this.f22304i.setVisibility(0);
        this.f22303h.setVisibility(8);
        this.f22302g.setVisibility(8);
        if (this.f22300e.isIndeterminate()) {
            this.f22300e.setIndeterminate(false);
        }
    }

    private final void x() {
        this.f22307l.setVisibility(8);
        this.f22304i.setVisibility(8);
        this.f22302g.setVisibility(8);
        this.f22306k.setVisibility(8);
    }

    private final void y(String str) {
        this.f22307l.setText(str);
        this.f22307l.setVisibility(0);
        this.f22304i.setVisibility(8);
        this.f22303h.setVisibility(0);
        this.f22306k.setVisibility(8);
    }

    private final void z() {
        this.f22301f.setVisibility(0);
        this.f22301f.setText(this.itemView.getContext().getString(R.string.installing));
        this.f22304i.setVisibility(0);
        this.f22303h.setVisibility(8);
        this.f22302g.setVisibility(8);
        this.f22306k.setVisibility(8);
        e(this.f22300e, this.f22298c);
    }

    public final void p(J.a aVar, boolean z4, boolean z5) {
        m.e(aVar, "appUpdateData");
        n(aVar.a(), aVar.b(), z4, z5);
    }

    public final void q(C2048f fVar, boolean z4) {
        m.e(fVar, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
        t.a aVar = t.f21927u;
        Context context = this.itemView.getContext();
        m.d(context, "getContext(...)");
        t a5 = aVar.a(context);
        a5.a();
        String o4 = fVar.o();
        m.b(o4);
        S D02 = a5.D0(o4);
        a5.i();
        m.b(D02);
        n(fVar, D02, z4, false);
    }
}
