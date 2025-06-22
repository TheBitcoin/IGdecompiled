package x2;

import N1.k;
import android.content.Context;
import android.text.Spanned;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import f2.J;
import g2.N;
import g2.U;
import kotlin.jvm.internal.m;
import u2.F;
import w2.s;
import y2.n;

public final class j1 extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    private final J f22410a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f22411b;

    /* renamed from: c  reason: collision with root package name */
    private final TextView f22412c;

    /* renamed from: d  reason: collision with root package name */
    private final ImageView f22413d;

    /* renamed from: e  reason: collision with root package name */
    private final TextView f22414e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final TextView f22415f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final TextView f22416g;

    /* renamed from: h  reason: collision with root package name */
    private final TextView f22417h;

    /* renamed from: i  reason: collision with root package name */
    private final LinearLayout f22418i;

    /* renamed from: j  reason: collision with root package name */
    private final LinearLayout f22419j;

    /* renamed from: k  reason: collision with root package name */
    private final TextView f22420k;

    /* renamed from: l  reason: collision with root package name */
    private final ImageView f22421l;

    /* renamed from: m  reason: collision with root package name */
    private final ImageView f22422m;

    /* renamed from: n  reason: collision with root package name */
    private final ImageView f22423n;

    /* renamed from: o  reason: collision with root package name */
    private final ImageView f22424o;

    /* renamed from: p  reason: collision with root package name */
    private final ImageView f22425p;

    /* renamed from: q  reason: collision with root package name */
    private final ImageView f22426q;

    public static final class a implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ j1 f22427a;

        a(j1 j1Var) {
            this.f22427a = j1Var;
        }

        public boolean onPreDraw() {
            this.f22427a.f22415f.getViewTreeObserver().removeOnPreDrawListener(this);
            if (!s.a(this.f22427a.f22415f)) {
                return true;
            }
            this.f22427a.f22416g.setVisibility(0);
            this.f22427a.f22416g.setTypeface(k.f7778g.w());
            return true;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public j1(View view, J j4, Context context) {
        super(view);
        m.e(view, "itemView");
        m.e(j4, "listener");
        m.e(context, "context");
        this.f22410a = j4;
        this.f22411b = context;
        View findViewById = view.findViewById(R.id.tv_username_review);
        m.d(findViewById, "findViewById(...)");
        TextView textView = (TextView) findViewById;
        this.f22412c = textView;
        View findViewById2 = view.findViewById(R.id.iv_avatar_review);
        m.d(findViewById2, "findViewById(...)");
        this.f22413d = (ImageView) findViewById2;
        View findViewById3 = view.findViewById(R.id.tv_date_review);
        m.d(findViewById3, "findViewById(...)");
        TextView textView2 = (TextView) findViewById3;
        this.f22414e = textView2;
        View findViewById4 = view.findViewById(R.id.tv_body_review);
        m.d(findViewById4, "findViewById(...)");
        TextView textView3 = (TextView) findViewById4;
        this.f22415f = textView3;
        View findViewById5 = view.findViewById(R.id.tv_show_more_review);
        m.d(findViewById5, "findViewById(...)");
        this.f22416g = (TextView) findViewById5;
        View findViewById6 = view.findViewById(R.id.tv_likes_counter_review);
        m.d(findViewById6, "findViewById(...)");
        TextView textView4 = (TextView) findViewById6;
        this.f22417h = textView4;
        View findViewById7 = view.findViewById(R.id.ll_likes_review);
        m.d(findViewById7, "findViewById(...)");
        this.f22418i = (LinearLayout) findViewById7;
        View findViewById8 = view.findViewById(R.id.ll_reviews_counter_review);
        m.d(findViewById8, "findViewById(...)");
        this.f22419j = (LinearLayout) findViewById8;
        View findViewById9 = view.findViewById(R.id.tv_reviews_counter_review);
        m.d(findViewById9, "findViewById(...)");
        TextView textView5 = (TextView) findViewById9;
        this.f22420k = textView5;
        View findViewById10 = view.findViewById(R.id.iv_likes_counter_review);
        m.d(findViewById10, "findViewById(...)");
        this.f22421l = (ImageView) findViewById10;
        View findViewById11 = view.findViewById(R.id.iv_star1_review);
        m.d(findViewById11, "findViewById(...)");
        this.f22422m = (ImageView) findViewById11;
        View findViewById12 = view.findViewById(R.id.iv_star2_review);
        m.d(findViewById12, "findViewById(...)");
        this.f22423n = (ImageView) findViewById12;
        View findViewById13 = view.findViewById(R.id.iv_star3_review);
        m.d(findViewById13, "findViewById(...)");
        this.f22424o = (ImageView) findViewById13;
        View findViewById14 = view.findViewById(R.id.iv_star4_review);
        m.d(findViewById14, "findViewById(...)");
        this.f22425p = (ImageView) findViewById14;
        View findViewById15 = view.findViewById(R.id.iv_star5_review);
        m.d(findViewById15, "findViewById(...)");
        this.f22426q = (ImageView) findViewById15;
        k.a aVar = k.f7778g;
        textView.setTypeface(aVar.w());
        textView2.setTypeface(aVar.x());
        textView3.setTypeface(aVar.x());
        textView4.setTypeface(aVar.x());
        textView5.setTypeface(aVar.x());
    }

    /* access modifiers changed from: private */
    public static final void i(j1 j1Var, int i4, View view) {
        j1Var.f22410a.c(i4);
    }

    /* access modifiers changed from: private */
    public static final void j(j1 j1Var, int i4, View view) {
        j1Var.f22410a.c(i4);
    }

    /* access modifiers changed from: private */
    public static final void k(j1 j1Var, N n4, int i4, View view) {
        new n(j1Var.f22411b).n(j1Var.f22421l);
        if (!F.f21886a.i(n4.f())) {
            j1Var.f22410a.a(i4);
            j1Var.f22417h.setText(String.valueOf(n4.g() + 1));
        }
    }

    /* access modifiers changed from: private */
    public static final void l(j1 j1Var, int i4, View view) {
        j1Var.f22410a.b(i4);
    }

    /* access modifiers changed from: private */
    public static final void m(j1 j1Var, View view) {
        if (j1Var.f22415f.getMaxLines() == Integer.MAX_VALUE) {
            j1Var.f22415f.setMaxLines(4);
            j1Var.f22416g.setText(j1Var.f22411b.getString(R.string.read_more_desc_app_detail));
            return;
        }
        j1Var.f22415f.setMaxLines(Integer.MAX_VALUE);
        j1Var.f22416g.setText(j1Var.f22411b.getString(R.string.read_less_desc_app_detail));
    }

    public final void h(N n4, int i4) {
        CharSequence charSequence;
        m.e(n4, "item");
        String c5 = n4.c();
        if (!(c5 == null || c5.length() == 0)) {
            this.f22412c.setText(n4.c());
        }
        U.b bVar = U.f20468m;
        if (bVar.c(n4.e()) != null) {
            com.squareup.picasso.s.h().l(bVar.c(n4.e())).n(UptodownApp.f17422D.i0(this.f22411b)).i(this.f22413d);
        } else {
            com.squareup.picasso.s.h().j(R.drawable.vector_user_default).n(UptodownApp.f17422D.i0(this.f22411b)).i(this.f22413d);
        }
        if (n4.k() != null) {
            this.f22414e.setText(n4.k());
        }
        Spanned j4 = n4.j();
        if (j4 == null || j4.length() == 0) {
            this.f22415f.setVisibility(8);
            this.f22418i.setVisibility(8);
            this.f22419j.setVisibility(8);
        } else {
            this.f22415f.setText(n4.j());
            this.f22415f.setVisibility(0);
            this.f22418i.setVisibility(0);
            this.f22419j.setVisibility(0);
        }
        this.f22417h.setText(String.valueOf(n4.g()));
        if (F.f21886a.i(n4.f())) {
            this.f22421l.setImageDrawable(ContextCompat.getDrawable(this.f22411b, R.drawable.vector_heart_red));
        } else {
            this.f22421l.setImageDrawable(ContextCompat.getDrawable(this.f22411b, R.drawable.vector_heart));
        }
        if (n4.a() == 0) {
            this.f22420k.setText(this.f22411b.getString(R.string.reply));
        } else {
            this.f22420k.setText(String.valueOf(n4.a()));
        }
        this.f22412c.setOnClickListener(new e1(this, i4));
        this.f22413d.setOnClickListener(new f1(this, i4));
        this.f22418i.setOnClickListener(new g1(this, n4, i4));
        this.f22419j.setOnClickListener(new h1(this, i4));
        TextView textView = this.f22415f;
        Spanned j5 = n4.j();
        if (j5 != null) {
            charSequence = m3.m.u0(j5);
        } else {
            charSequence = null;
        }
        textView.setText(charSequence);
        this.f22415f.getViewTreeObserver().addOnPreDrawListener(new a(this));
        this.f22416g.setOnClickListener(new i1(this));
        this.f22422m.setImageDrawable(ContextCompat.getDrawable(this.f22411b, R.drawable.vector_star_on));
        this.f22423n.setImageDrawable(ContextCompat.getDrawable(this.f22411b, R.drawable.vector_star_off));
        this.f22424o.setImageDrawable(ContextCompat.getDrawable(this.f22411b, R.drawable.vector_star_off));
        this.f22425p.setImageDrawable(ContextCompat.getDrawable(this.f22411b, R.drawable.vector_star_off));
        this.f22426q.setImageDrawable(ContextCompat.getDrawable(this.f22411b, R.drawable.vector_star_off));
        if (n4.h() >= 2) {
            this.f22423n.setImageDrawable(ContextCompat.getDrawable(this.f22411b, R.drawable.vector_star_on));
        }
        if (n4.h() >= 3) {
            this.f22424o.setImageDrawable(ContextCompat.getDrawable(this.f22411b, R.drawable.vector_star_on));
        }
        if (n4.h() >= 4) {
            this.f22425p.setImageDrawable(ContextCompat.getDrawable(this.f22411b, R.drawable.vector_star_on));
        }
        if (n4.h() == 5) {
            this.f22426q.setImageDrawable(ContextCompat.getDrawable(this.f22411b, R.drawable.vector_star_on));
        }
    }
}
