package x2;

import N1.k;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.mbridge.msdk.MBridgeConstans;
import com.uptodown.R;
import com.uptodown.util.views.UsernameTextView;
import f2.C2004C;
import g2.N;
import kotlin.jvm.internal.m;
import u2.F;
import u2.q;
import y2.n;

/* renamed from: x2.t0  reason: case insensitive filesystem */
public final class C2395t0 extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    private final Context f22497a;

    /* renamed from: b  reason: collision with root package name */
    private final C2004C f22498b;

    /* renamed from: c  reason: collision with root package name */
    private final ImageView f22499c;

    /* renamed from: d  reason: collision with root package name */
    private final UsernameTextView f22500d;

    /* renamed from: e  reason: collision with root package name */
    private final ImageView f22501e;

    /* renamed from: f  reason: collision with root package name */
    private final TextView f22502f;

    /* renamed from: g  reason: collision with root package name */
    private final TextView f22503g;

    /* renamed from: h  reason: collision with root package name */
    private final TextView f22504h;

    /* renamed from: i  reason: collision with root package name */
    private final TextView f22505i;

    /* renamed from: j  reason: collision with root package name */
    private final ImageView f22506j;

    /* renamed from: k  reason: collision with root package name */
    private final LinearLayout f22507k;

    /* renamed from: l  reason: collision with root package name */
    private final LinearLayout f22508l;

    /* renamed from: m  reason: collision with root package name */
    private final ImageView f22509m;

    /* renamed from: n  reason: collision with root package name */
    private final ImageView f22510n;

    /* renamed from: o  reason: collision with root package name */
    private final ImageView f22511o;

    /* renamed from: p  reason: collision with root package name */
    private final ImageView f22512p;

    /* renamed from: q  reason: collision with root package name */
    private final ImageView f22513q;

    /* renamed from: r  reason: collision with root package name */
    private final ImageView f22514r;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2395t0(View view, Context context, C2004C c5) {
        super(view);
        m.e(view, "itemView");
        m.e(context, "context");
        m.e(c5, "listener");
        this.f22497a = context;
        this.f22498b = c5;
        View findViewById = view.findViewById(R.id.iv_avatar_review);
        m.d(findViewById, "findViewById(...)");
        this.f22499c = (ImageView) findViewById;
        View findViewById2 = view.findViewById(R.id.tv_username_review);
        m.d(findViewById2, "findViewById(...)");
        UsernameTextView usernameTextView = (UsernameTextView) findViewById2;
        this.f22500d = usernameTextView;
        View findViewById3 = view.findViewById(R.id.iv_author_verified_review);
        m.d(findViewById3, "findViewById(...)");
        this.f22501e = (ImageView) findViewById3;
        View findViewById4 = view.findViewById(R.id.tv_date_review);
        m.d(findViewById4, "findViewById(...)");
        TextView textView = (TextView) findViewById4;
        this.f22502f = textView;
        View findViewById5 = view.findViewById(R.id.tv_body_review);
        m.d(findViewById5, "findViewById(...)");
        TextView textView2 = (TextView) findViewById5;
        this.f22503g = textView2;
        View findViewById6 = view.findViewById(R.id.tv_reviews_counter_review);
        m.d(findViewById6, "findViewById(...)");
        TextView textView3 = (TextView) findViewById6;
        this.f22504h = textView3;
        View findViewById7 = view.findViewById(R.id.tv_likes_counter_review);
        m.d(findViewById7, "findViewById(...)");
        TextView textView4 = (TextView) findViewById7;
        this.f22505i = textView4;
        View findViewById8 = view.findViewById(R.id.iv_likes_counter_review);
        m.d(findViewById8, "findViewById(...)");
        this.f22506j = (ImageView) findViewById8;
        View findViewById9 = view.findViewById(R.id.ll_reviews_counter_review);
        m.d(findViewById9, "findViewById(...)");
        this.f22507k = (LinearLayout) findViewById9;
        View findViewById10 = view.findViewById(R.id.ll_likes_review);
        m.d(findViewById10, "findViewById(...)");
        this.f22508l = (LinearLayout) findViewById10;
        View findViewById11 = view.findViewById(R.id.iv_star1_review);
        m.d(findViewById11, "findViewById(...)");
        this.f22509m = (ImageView) findViewById11;
        View findViewById12 = view.findViewById(R.id.iv_star2_review);
        m.d(findViewById12, "findViewById(...)");
        this.f22510n = (ImageView) findViewById12;
        View findViewById13 = view.findViewById(R.id.iv_star3_review);
        m.d(findViewById13, "findViewById(...)");
        this.f22511o = (ImageView) findViewById13;
        View findViewById14 = view.findViewById(R.id.iv_star4_review);
        m.d(findViewById14, "findViewById(...)");
        this.f22512p = (ImageView) findViewById14;
        View findViewById15 = view.findViewById(R.id.iv_star5_review);
        m.d(findViewById15, "findViewById(...)");
        this.f22513q = (ImageView) findViewById15;
        View findViewById16 = view.findViewById(R.id.iv_turbo_mark_review);
        m.d(findViewById16, "findViewById(...)");
        ImageView imageView = (ImageView) findViewById16;
        this.f22514r = imageView;
        k.a aVar = k.f7778g;
        usernameTextView.setTypeface(aVar.w());
        textView.setTypeface(aVar.x());
        textView2.setTypeface(aVar.x());
        textView3.setTypeface(aVar.x());
        textView4.setTypeface(aVar.x());
        imageView.setVisibility(8);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x015b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0056  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void h(g2.N r5, int r6) {
        /*
            r4 = this;
            java.lang.String r0 = r5.m()
            if (r0 == 0) goto L_0x0034
            g2.U$b r0 = g2.U.f20468m
            java.lang.String r1 = r5.e()
            java.lang.String r1 = r0.c(r1)
            if (r1 == 0) goto L_0x0034
            com.squareup.picasso.s r1 = com.squareup.picasso.s.h()
            java.lang.String r2 = r5.e()
            java.lang.String r0 = r0.c(r2)
            com.squareup.picasso.w r0 = r1.l(r0)
            com.uptodown.UptodownApp$a r1 = com.uptodown.UptodownApp.f17422D
            android.content.Context r2 = r4.f22497a
            y2.h r1 = r1.i0(r2)
            com.squareup.picasso.w r0 = r0.n(r1)
            android.widget.ImageView r1 = r4.f22499c
            r0.i(r1)
            goto L_0x0050
        L_0x0034:
            com.squareup.picasso.s r0 = com.squareup.picasso.s.h()
            r1 = 2131231561(0x7f080349, float:1.8079206E38)
            com.squareup.picasso.w r0 = r0.j(r1)
            com.uptodown.UptodownApp$a r1 = com.uptodown.UptodownApp.f17422D
            android.content.Context r2 = r4.f22497a
            y2.h r1 = r1.k0(r2)
            com.squareup.picasso.w r0 = r0.n(r1)
            android.widget.ImageView r1 = r4.f22499c
            r0.i(r1)
        L_0x0050:
            java.lang.String r0 = r5.m()
            if (r0 == 0) goto L_0x006e
            com.uptodown.util.views.UsernameTextView r0 = r4.f22500d
            java.lang.String r1 = r5.m()
            r0.setText(r1)
            com.uptodown.util.views.UsernameTextView$a r0 = com.uptodown.util.views.UsernameTextView.f19434k
            com.uptodown.util.views.UsernameTextView r1 = r4.f22500d
            boolean r2 = r5.o()
            java.lang.String r3 = r5.n()
            r0.a(r1, r2, r3)
        L_0x006e:
            com.uptodown.util.views.UsernameTextView r0 = r4.f22500d
            x2.o0 r1 = new x2.o0
            r1.<init>(r4, r6)
            r0.setOnClickListener(r1)
            android.widget.ImageView r0 = r4.f22499c
            x2.p0 r1 = new x2.p0
            r1.<init>(r4, r6)
            r0.setOnClickListener(r1)
            u2.F r0 = u2.F.f21886a
            long r1 = r5.f()
            boolean r0 = r0.i(r1)
            if (r0 == 0) goto L_0x009d
            android.widget.ImageView r0 = r4.f22506j
            android.content.Context r1 = r4.f22497a
            r2 = 2131231423(0x7f0802bf, float:1.8078927E38)
            android.graphics.drawable.Drawable r1 = androidx.core.content.ContextCompat.getDrawable(r1, r2)
            r0.setImageDrawable(r1)
            goto L_0x00ab
        L_0x009d:
            android.widget.ImageView r0 = r4.f22506j
            android.content.Context r1 = r4.f22497a
            r2 = 2131231421(0x7f0802bd, float:1.8078923E38)
            android.graphics.drawable.Drawable r1 = androidx.core.content.ContextCompat.getDrawable(r1, r2)
            r0.setImageDrawable(r1)
        L_0x00ab:
            java.lang.String r0 = r5.m()
            r1 = 0
            if (r0 == 0) goto L_0x00bf
            int r0 = r5.d()
            r2 = 1
            if (r0 != r2) goto L_0x00bf
            android.widget.ImageView r0 = r4.f22501e
            r0.setVisibility(r1)
            goto L_0x00c5
        L_0x00bf:
            android.widget.ImageView r0 = r4.f22501e
            r2 = 4
            r0.setVisibility(r2)
        L_0x00c5:
            java.lang.String r0 = r5.k()
            if (r0 == 0) goto L_0x00d4
            android.widget.TextView r0 = r4.f22502f
            java.lang.String r2 = r5.k()
            r0.setText(r2)
        L_0x00d4:
            android.text.Spanned r0 = r5.j()
            if (r0 == 0) goto L_0x015b
            int r0 = r0.length()
            if (r0 != 0) goto L_0x00e2
            goto L_0x015b
        L_0x00e2:
            android.widget.TextView r0 = r4.f22503g
            r2 = 2147483647(0x7fffffff, float:NaN)
            r0.setMaxLines(r2)
            android.widget.TextView r0 = r4.f22503g
            android.text.Spanned r2 = r5.j()
            if (r2 == 0) goto L_0x00f7
            java.lang.CharSequence r2 = m3.m.u0(r2)
            goto L_0x00f8
        L_0x00f7:
            r2 = 0
        L_0x00f8:
            r0.setText(r2)
            android.widget.TextView r0 = r4.f22503g
            r0.setVisibility(r1)
            android.widget.LinearLayout r0 = r4.f22507k
            r0.setVisibility(r1)
            android.widget.LinearLayout r0 = r4.f22508l
            r0.setVisibility(r1)
            android.widget.LinearLayout r0 = r4.f22507k
            java.lang.Integer r1 = java.lang.Integer.valueOf(r6)
            r0.setTag(r1)
            android.widget.LinearLayout r0 = r4.f22507k
            x2.q0 r1 = new x2.q0
            r1.<init>(r4)
            r0.setOnClickListener(r1)
            int r0 = r5.a()
            if (r0 <= 0) goto L_0x0130
            android.widget.TextView r0 = r4.f22504h
            int r1 = r5.a()
            java.lang.String r1 = java.lang.String.valueOf(r1)
            r0.setText(r1)
        L_0x0130:
            android.widget.TextView r0 = r4.f22505i
            int r1 = r5.g()
            java.lang.String r1 = java.lang.String.valueOf(r1)
            r0.setText(r1)
            android.widget.LinearLayout r0 = r4.f22508l
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r0.setTag(r6)
            android.widget.LinearLayout r6 = r4.f22508l
            x2.r0 r0 = new x2.r0
            r0.<init>(r4, r5)
            r6.setOnClickListener(r0)
            android.widget.ImageView r5 = r4.f22514r
            x2.s0 r6 = new x2.s0
            r6.<init>(r4)
            r5.setOnClickListener(r6)
            return
        L_0x015b:
            android.widget.TextView r5 = r4.f22503g
            r6 = 8
            r5.setVisibility(r6)
            android.widget.LinearLayout r5 = r4.f22507k
            r5.setVisibility(r6)
            android.widget.LinearLayout r5 = r4.f22508l
            r5.setVisibility(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: x2.C2395t0.h(g2.N, int):void");
    }

    /* access modifiers changed from: private */
    public static final void i(C2395t0 t0Var, int i4, View view) {
        t0Var.f22498b.c(i4);
    }

    /* access modifiers changed from: private */
    public static final void j(C2395t0 t0Var, int i4, View view) {
        t0Var.f22498b.c(i4);
    }

    /* access modifiers changed from: private */
    public static final void k(C2395t0 t0Var, View view) {
        m.e(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        C2004C c5 = t0Var.f22498b;
        Object tag = view.getTag();
        m.c(tag, "null cannot be cast to non-null type kotlin.Int");
        c5.d(((Integer) tag).intValue());
    }

    /* access modifiers changed from: private */
    public static final void l(C2395t0 t0Var, N n4, View view) {
        m.e(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        new n(t0Var.f22497a).n(t0Var.f22506j);
        if (!F.f21886a.i(n4.f())) {
            C2004C c5 = t0Var.f22498b;
            Object tag = view.getTag();
            m.c(tag, "null cannot be cast to non-null type kotlin.Int");
            c5.a(((Integer) tag).intValue());
            t0Var.f22505i.setText(String.valueOf(n4.g() + 1));
        }
    }

    /* access modifiers changed from: private */
    public static final void m(C2395t0 t0Var, View view) {
        t0Var.f22498b.b();
    }

    public final void f(N n4, int i4) {
        m.e(n4, "item");
        h(n4, i4);
        this.f22509m.setImageDrawable(ContextCompat.getDrawable(this.f22497a, R.drawable.vector_star_on));
        this.f22510n.setImageDrawable(ContextCompat.getDrawable(this.f22497a, R.drawable.vector_star_off));
        this.f22511o.setImageDrawable(ContextCompat.getDrawable(this.f22497a, R.drawable.vector_star_off));
        this.f22512p.setImageDrawable(ContextCompat.getDrawable(this.f22497a, R.drawable.vector_star_off));
        this.f22513q.setImageDrawable(ContextCompat.getDrawable(this.f22497a, R.drawable.vector_star_off));
        if (n4.h() >= 2) {
            this.f22510n.setImageDrawable(ContextCompat.getDrawable(this.f22497a, R.drawable.vector_star_on));
        }
        if (n4.h() >= 3) {
            this.f22511o.setImageDrawable(ContextCompat.getDrawable(this.f22497a, R.drawable.vector_star_on));
        }
        if (n4.h() >= 4) {
            this.f22512p.setImageDrawable(ContextCompat.getDrawable(this.f22497a, R.drawable.vector_star_on));
        }
        if (n4.h() == 5) {
            this.f22513q.setImageDrawable(ContextCompat.getDrawable(this.f22497a, R.drawable.vector_star_on));
        }
    }

    public final void g(N n4, int i4) {
        m.e(n4, "item");
        h(n4, i4);
        this.f22509m.setImageDrawable(ContextCompat.getDrawable(this.f22497a, R.drawable.vector_star_on_turbo));
        this.f22510n.setImageDrawable(ContextCompat.getDrawable(this.f22497a, R.drawable.vector_star_off_turbo));
        this.f22511o.setImageDrawable(ContextCompat.getDrawable(this.f22497a, R.drawable.vector_star_off_turbo));
        this.f22512p.setImageDrawable(ContextCompat.getDrawable(this.f22497a, R.drawable.vector_star_off_turbo));
        this.f22513q.setImageDrawable(ContextCompat.getDrawable(this.f22497a, R.drawable.vector_star_off_turbo));
        if (n4.h() >= 2) {
            this.f22510n.setImageDrawable(ContextCompat.getDrawable(this.f22497a, R.drawable.vector_star_on_turbo));
        }
        if (n4.h() >= 3) {
            this.f22511o.setImageDrawable(ContextCompat.getDrawable(this.f22497a, R.drawable.vector_star_on_turbo));
        }
        if (n4.h() >= 4) {
            this.f22512p.setImageDrawable(ContextCompat.getDrawable(this.f22497a, R.drawable.vector_star_on_turbo));
        }
        if (n4.h() == 5) {
            this.f22513q.setImageDrawable(ContextCompat.getDrawable(this.f22497a, R.drawable.vector_star_on_turbo));
        }
        this.f22514r.setVisibility(0);
        q.f21920a.a(this.f22499c);
    }
}
