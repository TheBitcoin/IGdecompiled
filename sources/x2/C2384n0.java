package x2;

import N1.k;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import com.uptodown.util.views.UsernameTextView;
import f2.C2003B;
import g2.C2042J;
import kotlin.jvm.internal.m;
import u2.F;
import y2.n;

/* renamed from: x2.n0  reason: case insensitive filesystem */
public final class C2384n0 extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    private final Context f22443a;

    /* renamed from: b  reason: collision with root package name */
    private final C2003B f22444b;

    /* renamed from: c  reason: collision with root package name */
    private final ImageView f22445c;

    /* renamed from: d  reason: collision with root package name */
    private final UsernameTextView f22446d;

    /* renamed from: e  reason: collision with root package name */
    private final ImageView f22447e;

    /* renamed from: f  reason: collision with root package name */
    private final TextView f22448f;

    /* renamed from: g  reason: collision with root package name */
    private final TextView f22449g;

    /* renamed from: h  reason: collision with root package name */
    private final LinearLayout f22450h;

    /* renamed from: i  reason: collision with root package name */
    private final ImageView f22451i;

    /* renamed from: j  reason: collision with root package name */
    private final TextView f22452j;

    /* renamed from: k  reason: collision with root package name */
    private final ImageView f22453k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2384n0(View view, Context context, C2003B b5) {
        super(view);
        m.e(view, "itemView");
        m.e(context, "context");
        m.e(b5, "listener");
        this.f22443a = context;
        this.f22444b = b5;
        View findViewById = view.findViewById(R.id.iv_avatar_review);
        m.d(findViewById, "findViewById(...)");
        this.f22445c = (ImageView) findViewById;
        View findViewById2 = view.findViewById(R.id.tv_username_review);
        m.d(findViewById2, "findViewById(...)");
        UsernameTextView usernameTextView = (UsernameTextView) findViewById2;
        this.f22446d = usernameTextView;
        View findViewById3 = view.findViewById(R.id.iv_author_verified_review);
        m.d(findViewById3, "findViewById(...)");
        this.f22447e = (ImageView) findViewById3;
        View findViewById4 = view.findViewById(R.id.tv_date_review);
        m.d(findViewById4, "findViewById(...)");
        TextView textView = (TextView) findViewById4;
        this.f22448f = textView;
        View findViewById5 = view.findViewById(R.id.tv_body_review);
        m.d(findViewById5, "findViewById(...)");
        TextView textView2 = (TextView) findViewById5;
        this.f22449g = textView2;
        View findViewById6 = view.findViewById(R.id.ll_likes_review);
        m.d(findViewById6, "findViewById(...)");
        this.f22450h = (LinearLayout) findViewById6;
        View findViewById7 = view.findViewById(R.id.iv_likes_counter_review);
        m.d(findViewById7, "findViewById(...)");
        this.f22451i = (ImageView) findViewById7;
        View findViewById8 = view.findViewById(R.id.tv_likes_counter_review);
        m.d(findViewById8, "findViewById(...)");
        TextView textView3 = (TextView) findViewById8;
        this.f22452j = textView3;
        View findViewById9 = view.findViewById(R.id.iv_turbo_mark_review);
        m.d(findViewById9, "findViewById(...)");
        ImageView imageView = (ImageView) findViewById9;
        this.f22453k = imageView;
        k.a aVar = k.f7778g;
        usernameTextView.setTypeface(aVar.w());
        textView.setTypeface(aVar.x());
        textView2.setTypeface(aVar.x());
        textView3.setTypeface(aVar.x());
        imageView.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public static final void f(C2384n0 n0Var, C2042J j4, View view) {
        new n(n0Var.f22443a).n(n0Var.f22451i);
        if (!F.f21886a.h(j4.c())) {
            n0Var.f22444b.c(j4);
            n0Var.f22452j.setText(String.valueOf(j4.d() + 1));
        }
    }

    /* access modifiers changed from: private */
    public static final void g(C2384n0 n0Var, C2042J j4, View view) {
        n0Var.f22444b.d(j4);
    }

    /* access modifiers changed from: private */
    public static final void h(C2384n0 n0Var, C2042J j4, View view) {
        n0Var.f22444b.d(j4);
    }

    /* access modifiers changed from: private */
    public static final void i(C2384n0 n0Var, View view) {
        n0Var.f22444b.b();
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x010e  */
    /* JADX WARNING: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x005b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void e(g2.C2042J r6) {
        /*
            r5 = this;
            java.lang.String r0 = "item"
            kotlin.jvm.internal.m.e(r6, r0)
            java.lang.String r0 = r6.h()
            if (r0 == 0) goto L_0x0039
            g2.U$b r0 = g2.U.f20468m
            java.lang.String r1 = r6.b()
            java.lang.String r1 = r0.d(r1)
            if (r1 == 0) goto L_0x0039
            com.squareup.picasso.s r1 = com.squareup.picasso.s.h()
            java.lang.String r2 = r6.b()
            java.lang.String r0 = r0.d(r2)
            com.squareup.picasso.w r0 = r1.l(r0)
            com.uptodown.UptodownApp$a r1 = com.uptodown.UptodownApp.f17422D
            android.content.Context r2 = r5.f22443a
            y2.h r1 = r1.k0(r2)
            com.squareup.picasso.w r0 = r0.n(r1)
            android.widget.ImageView r1 = r5.f22445c
            r0.i(r1)
            goto L_0x0055
        L_0x0039:
            com.squareup.picasso.s r0 = com.squareup.picasso.s.h()
            r1 = 2131231561(0x7f080349, float:1.8079206E38)
            com.squareup.picasso.w r0 = r0.j(r1)
            com.uptodown.UptodownApp$a r1 = com.uptodown.UptodownApp.f17422D
            android.content.Context r2 = r5.f22443a
            y2.h r1 = r1.i0(r2)
            com.squareup.picasso.w r0 = r0.n(r1)
            android.widget.ImageView r1 = r5.f22445c
            r0.i(r1)
        L_0x0055:
            java.lang.String r0 = r6.h()
            if (r0 == 0) goto L_0x0073
            com.uptodown.util.views.UsernameTextView r0 = r5.f22446d
            java.lang.String r1 = r6.h()
            r0.setText(r1)
            com.uptodown.util.views.UsernameTextView$a r0 = com.uptodown.util.views.UsernameTextView.f19434k
            com.uptodown.util.views.UsernameTextView r1 = r5.f22446d
            boolean r2 = r6.j()
            java.lang.String r3 = r6.i()
            r0.a(r1, r2, r3)
        L_0x0073:
            int r0 = r6.a()
            r1 = 1
            r2 = 0
            if (r0 != r1) goto L_0x0081
            android.widget.ImageView r0 = r5.f22447e
            r0.setVisibility(r2)
            goto L_0x0087
        L_0x0081:
            android.widget.ImageView r0 = r5.f22447e
            r1 = 4
            r0.setVisibility(r1)
        L_0x0087:
            u2.F r0 = u2.F.f21886a
            long r3 = r6.c()
            boolean r0 = r0.h(r3)
            if (r0 == 0) goto L_0x00a2
            android.widget.ImageView r0 = r5.f22451i
            android.content.Context r1 = r5.f22443a
            r3 = 2131231423(0x7f0802bf, float:1.8078927E38)
            android.graphics.drawable.Drawable r1 = androidx.core.content.ContextCompat.getDrawable(r1, r3)
            r0.setImageDrawable(r1)
            goto L_0x00b0
        L_0x00a2:
            android.widget.ImageView r0 = r5.f22451i
            android.content.Context r1 = r5.f22443a
            r3 = 2131231421(0x7f0802bd, float:1.8078923E38)
            android.graphics.drawable.Drawable r1 = androidx.core.content.ContextCompat.getDrawable(r1, r3)
            r0.setImageDrawable(r1)
        L_0x00b0:
            java.lang.String r0 = r6.f()
            if (r0 == 0) goto L_0x00bf
            android.widget.TextView r0 = r5.f22448f
            java.lang.String r1 = r6.f()
            r0.setText(r1)
        L_0x00bf:
            android.widget.TextView r0 = r5.f22449g
            android.text.Spanned r1 = r6.e()
            r0.setText(r1)
            android.widget.TextView r0 = r5.f22449g
            r1 = 2147483647(0x7fffffff, float:NaN)
            r0.setMaxLines(r1)
            android.widget.TextView r0 = r5.f22452j
            int r1 = r6.d()
            java.lang.String r1 = java.lang.String.valueOf(r1)
            r0.setText(r1)
            android.widget.LinearLayout r0 = r5.f22450h
            x2.j0 r1 = new x2.j0
            r1.<init>(r5, r6)
            r0.setOnClickListener(r1)
            java.lang.String r0 = r6.g()
            if (r0 == 0) goto L_0x0108
            int r0 = r0.length()
            if (r0 != 0) goto L_0x00f4
            goto L_0x0108
        L_0x00f4:
            com.uptodown.util.views.UsernameTextView r0 = r5.f22446d
            x2.k0 r1 = new x2.k0
            r1.<init>(r5, r6)
            r0.setOnClickListener(r1)
            android.widget.ImageView r0 = r5.f22445c
            x2.l0 r1 = new x2.l0
            r1.<init>(r5, r6)
            r0.setOnClickListener(r1)
        L_0x0108:
            boolean r6 = r6.j()
            if (r6 == 0) goto L_0x0132
            android.view.View r6 = r5.itemView
            android.content.Context r0 = r5.f22443a
            r1 = 2131231321(0x7f080259, float:1.807872E38)
            android.graphics.drawable.Drawable r0 = androidx.core.content.ContextCompat.getDrawable(r0, r1)
            r6.setBackground(r0)
            android.widget.ImageView r6 = r5.f22453k
            r6.setVisibility(r2)
            android.widget.ImageView r6 = r5.f22453k
            x2.m0 r0 = new x2.m0
            r0.<init>(r5)
            r6.setOnClickListener(r0)
            u2.q$a r6 = u2.q.f21920a
            android.widget.ImageView r0 = r5.f22445c
            r6.b(r0)
        L_0x0132:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: x2.C2384n0.e(g2.J):void");
    }
}
