package x2;

import R2.k;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import c2.X0;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import f2.U;
import g2.C2053k;
import g2.W;
import kotlin.jvm.internal.m;
import w2.v;

public final class v1 extends C2381m {

    /* renamed from: b  reason: collision with root package name */
    private final X0 f22526b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f22527c;

    /* renamed from: d  reason: collision with root package name */
    private final U f22528d;

    /* renamed from: e  reason: collision with root package name */
    private a f22529e = a.DOWNLOAD;

    public enum a {
        DOWNLOAD,
        OPEN,
        INSTALLING,
        DEACTIVATED;

        static {
            a[] a5;
            f22535f = X2.b.a(a5);
        }
    }

    public /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f22536a;

        /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|3|4|5|6|7|8|9|11) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        static {
            /*
                x2.v1$a[] r0 = x2.v1.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                x2.v1$a r1 = x2.v1.a.DOWNLOAD     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                x2.v1$a r1 = x2.v1.a.OPEN     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                x2.v1$a r1 = x2.v1.a.DEACTIVATED     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                x2.v1$a r1 = x2.v1.a.INSTALLING     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                f22536a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: x2.v1.b.<clinit>():void");
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public v1(c2.X0 r3, android.content.Context r4, f2.U r5) {
        /*
            r2 = this;
            java.lang.String r0 = "binding"
            kotlin.jvm.internal.m.e(r3, r0)
            java.lang.String r0 = "context"
            kotlin.jvm.internal.m.e(r4, r0)
            android.widget.RelativeLayout r0 = r3.getRoot()
            java.lang.String r1 = "getRoot(...)"
            kotlin.jvm.internal.m.d(r0, r1)
            r2.<init>(r0)
            r2.f22526b = r3
            r2.f22527c = r4
            r2.f22528d = r5
            x2.v1$a r4 = x2.v1.a.DOWNLOAD
            r2.f22529e = r4
            android.widget.RelativeLayout r4 = r3.f10152k
            x2.q1 r5 = new x2.q1
            r5.<init>(r2)
            r4.setOnClickListener(r5)
            android.widget.RelativeLayout r4 = r3.f10152k
            x2.r1 r5 = new x2.r1
            r5.<init>(r2)
            r4.setOnLongClickListener(r5)
            android.widget.RelativeLayout r4 = r3.f10150i
            x2.s1 r5 = new x2.s1
            r5.<init>(r2)
            r4.setOnClickListener(r5)
            android.widget.TextView r4 = r3.f10154m
            N1.k$a r5 = N1.k.f7778g
            android.graphics.Typeface r0 = r5.w()
            r4.setTypeface(r0)
            android.widget.TextView r4 = r3.f10156o
            android.graphics.Typeface r0 = r5.w()
            r4.setTypeface(r0)
            android.widget.TextView r4 = r3.f10155n
            android.graphics.Typeface r0 = r5.x()
            r4.setTypeface(r0)
            android.widget.TextView r4 = r3.f10157p
            android.graphics.Typeface r5 = r5.x()
            r4.setTypeface(r5)
            android.view.View r3 = r3.f10159r
            x2.t1 r4 = new x2.t1
            r4.<init>()
            r3.setOnClickListener(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: x2.v1.<init>(c2.X0, android.content.Context, f2.U):void");
    }

    private final void A() {
        this.f22529e = a.INSTALLING;
        ProgressBar progressBar = this.f22526b.f10149h;
        m.d(progressBar, "pbProgressUserListItem");
        ImageView imageView = this.f22526b.f10146e;
        m.d(imageView, "ivIconUserListItem");
        e(progressBar, imageView);
        this.f22526b.f10154m.setText(this.f22527c.getString(R.string.installing));
        ProgressBar progressBar2 = this.f22526b.f10149h;
        m.d(progressBar2, "pbProgressUserListItem");
        B(progressBar2);
        this.f22526b.f10154m.setVisibility(0);
        this.f22526b.f10154m.setBackground(ContextCompat.getDrawable(this.f22527c, R.drawable.bg_status_download_installed));
        this.f22526b.f10154m.setTextColor(ContextCompat.getColor(this.f22527c, R.color.download_installed_status));
        this.f22526b.f10151j.setVisibility(8);
    }

    private final void B(ProgressBar progressBar) {
        progressBar.setIndeterminate(true);
        progressBar.setVisibility(0);
    }

    private final void C(ProgressBar progressBar, int i4) {
        progressBar.setIndeterminate(false);
        progressBar.setProgress(i4);
        progressBar.setVisibility(0);
    }

    /* access modifiers changed from: private */
    public static final void l(v1 v1Var, View view) {
        int bindingAdapterPosition;
        if (v1Var.f22528d != null && (bindingAdapterPosition = v1Var.getBindingAdapterPosition()) != -1) {
            v1Var.f22528d.a(bindingAdapterPosition);
        }
    }

    /* access modifiers changed from: private */
    public static final boolean m(v1 v1Var, View view) {
        int bindingAdapterPosition;
        if (v1Var.f22528d == null || (bindingAdapterPosition = v1Var.getBindingAdapterPosition()) == -1) {
            return true;
        }
        U u4 = v1Var.f22528d;
        m.b(view);
        u4.b(view, bindingAdapterPosition);
        return true;
    }

    /* access modifiers changed from: private */
    public static final void n(v1 v1Var, View view) {
        if (UptodownApp.f17422D.a0()) {
            int i4 = b.f22536a[v1Var.f22529e.ordinal()];
            if (i4 == 1) {
                U u4 = v1Var.f22528d;
                if (u4 != null) {
                    u4.c(v1Var.getBindingAdapterPosition());
                }
            } else if (i4 == 2) {
                U u5 = v1Var.f22528d;
                if (u5 != null) {
                    u5.d(v1Var.getBindingAdapterPosition());
                }
            } else if (i4 != 3 && i4 != 4) {
                throw new k();
            }
        }
    }

    private final void q(ProgressBar progressBar) {
        progressBar.setVisibility(8);
    }

    private final void r(W w4) {
        this.f22526b.f10148g.removeAllViews();
        if (!w4.c().isEmpty()) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMarginStart((int) this.f22527c.getResources().getDimension(R.dimen.margin_s));
            int i4 = 0;
            for (C2053k kVar : w4.c()) {
                int i5 = i4 + 1;
                View inflate = LayoutInflater.from(this.f22527c).inflate(R.layout.user_list_item_floating_tag, (ViewGroup) null);
                m.c(inflate, "null cannot be cast to non-null type android.widget.TextView");
                TextView textView = (TextView) inflate;
                textView.setText(kVar.d());
                textView.setTypeface(N1.k.f7778g.x());
                if (i4 > 0) {
                    this.f22526b.f10148g.addView(inflate, layoutParams);
                } else {
                    this.f22526b.f10148g.addView(inflate);
                }
                textView.setOnClickListener(new u1(this, w4, kVar));
                i4 = i5;
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void s(v1 v1Var, W w4, C2053k kVar, View view) {
        U u4 = v1Var.f22528d;
        if (u4 != null) {
            u4.e(w4.a(), kVar);
        }
    }

    private final void t() {
        this.f22526b.f10151j.setVisibility(0);
        this.f22526b.f10144c.setVisibility(0);
        this.f22526b.f10157p.setVisibility(0);
        this.f22526b.f10154m.setVisibility(8);
    }

    private final void u() {
        this.f22529e = a.DOWNLOAD;
        TextView textView = this.f22526b.f10154m;
        m.d(textView, "tvActionUserListItem");
        v.a(textView);
        this.f22526b.f10154m.setText(this.f22527c.getString(R.string.updates_button_download_app));
        this.f22526b.f10151j.setVisibility(8);
    }

    private final void v() {
        this.f22529e = a.DEACTIVATED;
        this.f22526b.f10154m.setVisibility(0);
        this.f22526b.f10154m.setText(this.f22527c.getString(R.string.updates_button_download_app));
        this.f22526b.f10154m.setBackground(ContextCompat.getDrawable(this.f22527c, R.drawable.shape_bg_download_button_desactivated));
        this.f22526b.f10154m.setTextColor(ContextCompat.getColor(this.f22527c, R.color.white));
        this.f22526b.f10151j.setVisibility(8);
    }

    private final void w() {
        ProgressBar progressBar = this.f22526b.f10149h;
        m.d(progressBar, "pbProgressUserListItem");
        ImageView imageView = this.f22526b.f10146e;
        m.d(imageView, "ivIconUserListItem");
        e(progressBar, imageView);
        this.f22526b.f10151j.setVisibility(0);
        this.f22526b.f10144c.setVisibility(0);
        this.f22526b.f10157p.setVisibility(8);
        this.f22526b.f10154m.setVisibility(8);
    }

    private final void x() {
        this.f22526b.f10154m.setText(this.f22527c.getString(R.string.option_button_install));
        TextView textView = this.f22526b.f10154m;
        m.d(textView, "tvActionUserListItem");
        v.d(textView);
        this.f22526b.f10151j.setVisibility(8);
    }

    private final void y() {
        this.f22529e = a.INSTALLING;
        ProgressBar progressBar = this.f22526b.f10149h;
        m.d(progressBar, "pbProgressUserListItem");
        ImageView imageView = this.f22526b.f10146e;
        m.d(imageView, "ivIconUserListItem");
        e(progressBar, imageView);
        this.f22526b.f10154m.setText(this.f22527c.getString(R.string.installing));
        ProgressBar progressBar2 = this.f22526b.f10149h;
        m.d(progressBar2, "pbProgressUserListItem");
        B(progressBar2);
        this.f22526b.f10154m.setVisibility(0);
        this.f22526b.f10154m.setBackground(ContextCompat.getDrawable(this.f22527c, R.drawable.bg_status_download_installed));
        this.f22526b.f10154m.setTextColor(ContextCompat.getColor(this.f22527c, R.color.download_installed_status));
        this.f22526b.f10151j.setVisibility(8);
    }

    private final void z() {
        this.f22529e = a.OPEN;
        ProgressBar progressBar = this.f22526b.f10149h;
        m.d(progressBar, "pbProgressUserListItem");
        ImageView imageView = this.f22526b.f10146e;
        m.d(imageView, "ivIconUserListItem");
        c(progressBar, imageView);
        TextView textView = this.f22526b.f10154m;
        m.d(textView, "tvActionUserListItem");
        v.a(textView);
        ProgressBar progressBar2 = this.f22526b.f10149h;
        m.d(progressBar2, "pbProgressUserListItem");
        q(progressBar2);
        this.f22526b.f10154m.setText(this.f22527c.getString(R.string.open));
        this.f22526b.f10151j.setVisibility(8);
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x011f  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0213  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void p(g2.W r11, boolean r12) {
        /*
            r10 = this;
            r0 = 1
            java.lang.String r1 = "item"
            kotlin.jvm.internal.m.e(r11, r1)
            boolean r1 = r11.h()
            r2 = 8
            r3 = 0
            if (r1 == 0) goto L_0x0017
            c2.X0 r1 = r10.f22526b
            android.view.View r1 = r1.f10159r
            r1.setVisibility(r2)
            goto L_0x001e
        L_0x0017:
            c2.X0 r1 = r10.f22526b
            android.view.View r1 = r1.f10159r
            r1.setVisibility(r3)
        L_0x001e:
            r10.r(r11)
            com.squareup.picasso.s r1 = com.squareup.picasso.s.h()
            java.lang.String r4 = r11.d()
            com.squareup.picasso.w r1 = r1.l(r4)
            r4 = 2131231320(0x7f080258, float:1.8078718E38)
            com.squareup.picasso.w r1 = r1.l(r4)
            com.uptodown.UptodownApp$a r5 = com.uptodown.UptodownApp.f17422D
            android.content.Context r6 = r10.f22527c
            y2.h r5 = r5.i0(r6)
            com.squareup.picasso.w r1 = r1.n(r5)
            c2.X0 r5 = r10.f22526b
            android.widget.ImageView r5 = r5.f10146e
            r1.i(r5)
            boolean r1 = r11.h()
            if (r1 == 0) goto L_0x005e
            c2.X0 r1 = r10.f22526b
            android.widget.ImageView r1 = r1.f10145d
            android.content.Context r4 = r10.f22527c
            r5 = 2131231490(0x7f080302, float:1.8079062E38)
            android.graphics.drawable.Drawable r4 = androidx.core.content.ContextCompat.getDrawable(r4, r5)
            r1.setImageDrawable(r4)
            goto L_0x0099
        L_0x005e:
            boolean r1 = r11.i()
            if (r1 == 0) goto L_0x0075
            c2.X0 r1 = r10.f22526b
            android.widget.ImageView r1 = r1.f10145d
            android.content.Context r4 = r10.f22527c
            r5 = 2131231491(0x7f080303, float:1.8079065E38)
            android.graphics.drawable.Drawable r4 = androidx.core.content.ContextCompat.getDrawable(r4, r5)
            r1.setImageDrawable(r4)
            goto L_0x0099
        L_0x0075:
            boolean r1 = r11.j()
            if (r1 == 0) goto L_0x008c
            c2.X0 r1 = r10.f22526b
            android.widget.ImageView r1 = r1.f10145d
            android.content.Context r4 = r10.f22527c
            r5 = 2131231492(0x7f080304, float:1.8079067E38)
            android.graphics.drawable.Drawable r4 = androidx.core.content.ContextCompat.getDrawable(r4, r5)
            r1.setImageDrawable(r4)
            goto L_0x0099
        L_0x008c:
            c2.X0 r1 = r10.f22526b
            android.widget.ImageView r1 = r1.f10145d
            android.content.Context r5 = r10.f22527c
            android.graphics.drawable.Drawable r4 = androidx.core.content.ContextCompat.getDrawable(r5, r4)
            r1.setImageDrawable(r4)
        L_0x0099:
            c2.X0 r1 = r10.f22526b
            android.widget.TextView r1 = r1.f10156o
            java.lang.String r4 = r11.e()
            r1.setText(r4)
            c2.X0 r1 = r10.f22526b
            android.widget.TextView r1 = r1.f10154m
            r1.setVisibility(r2)
            x2.v1$a r1 = x2.v1.a.DOWNLOAD
            r10.f22529e = r1
            c2.X0 r1 = r10.f22526b
            android.widget.TextView r1 = r1.f10155n
            java.lang.String r4 = r11.g()
            r1.setText(r4)
            u2.t$a r1 = u2.t.f21927u
            android.content.Context r4 = r10.f22527c
            u2.t r1 = r1.a(r4)
            r1.a()
            java.lang.String r4 = r11.f()
            r5 = 0
            if (r4 == 0) goto L_0x00d8
            java.lang.String r4 = r11.f()
            kotlin.jvm.internal.m.b(r4)
            g2.f r4 = r1.Y(r4)
            goto L_0x00d9
        L_0x00d8:
            r4 = r5
        L_0x00d9:
            java.lang.String r6 = r11.f()
            if (r6 == 0) goto L_0x011c
            int r6 = r6.length()
            if (r6 != 0) goto L_0x00e6
            goto L_0x011c
        L_0x00e6:
            java.lang.String r5 = r11.f()
            kotlin.jvm.internal.m.b(r5)
            g2.s r5 = r1.h0(r5)
            if (r5 == 0) goto L_0x011c
            N1.k$a r6 = N1.k.f7778g
            T1.c r7 = r6.j()
            if (r7 == 0) goto L_0x011c
            java.util.ArrayList r7 = r5.o()
            java.lang.Object r7 = r7.get(r3)
            g2.s$c r7 = (g2.C2060s.c) r7
            java.lang.String r7 = r7.a()
            T1.c r6 = r6.j()
            kotlin.jvm.internal.m.b(r6)
            java.lang.String r6 = r6.a()
            boolean r6 = m3.m.p(r7, r6, r0)
            if (r6 == 0) goto L_0x011c
            r6 = 1
            goto L_0x011d
        L_0x011c:
            r6 = 0
        L_0x011d:
            if (r4 != 0) goto L_0x0213
            java.lang.String r4 = "pbProgressUserListItem"
            if (r5 == 0) goto L_0x01e7
            boolean r11 = r5.L()
            if (r11 != 0) goto L_0x01a7
            if (r12 == 0) goto L_0x012d
            goto L_0x01a7
        L_0x012d:
            if (r6 == 0) goto L_0x0134
            r10.A()
            goto L_0x01aa
        L_0x0134:
            boolean r11 = r5.f()
            if (r11 == 0) goto L_0x013e
            r10.x()
            goto L_0x01aa
        L_0x013e:
            com.uptodown.workers.DownloadWorker$a r11 = com.uptodown.workers.DownloadWorker.f19459d
            long r6 = r5.h()
            long r8 = r5.E()
            boolean r11 = r11.k(r6, r8)
            if (r11 == 0) goto L_0x0199
            c2.X0 r11 = r10.f22526b
            android.widget.TextView r11 = r11.f10157p
            r11.setVisibility(r2)
            c2.X0 r11 = r10.f22526b
            android.widget.TextView r11 = r11.f10155n
            android.view.View r12 = r10.itemView
            android.content.Context r12 = r12.getContext()
            int r2 = r5.x()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            W1.i r6 = new W1.i
            r6.<init>()
            long r7 = r5.z()
            android.content.Context r9 = r10.f22527c
            java.lang.String r6 = r6.d(r7, r9)
            r7 = 2
            java.lang.Object[] r7 = new java.lang.Object[r7]
            r7[r3] = r2
            r7[r0] = r6
            r0 = 2131952484(0x7f130364, float:1.9541412E38)
            java.lang.String r12 = r12.getString(r0, r7)
            r11.setText(r12)
            c2.X0 r11 = r10.f22526b
            android.widget.ProgressBar r11 = r11.f10149h
            kotlin.jvm.internal.m.d(r11, r4)
            int r12 = r5.x()
            r10.C(r11, r12)
            r10.w()
            goto L_0x01aa
        L_0x0199:
            c2.X0 r11 = r10.f22526b
            android.widget.ProgressBar r11 = r11.f10149h
            kotlin.jvm.internal.m.d(r11, r4)
            r10.B(r11)
            r10.t()
            goto L_0x01aa
        L_0x01a7:
            r10.y()
        L_0x01aa:
            boolean r11 = r5.K()
            java.lang.String r12 = "ivIconUserListItem"
            if (r11 != 0) goto L_0x01d5
            com.uptodown.workers.DownloadWorker$a r11 = com.uptodown.workers.DownloadWorker.f19459d
            long r2 = r5.h()
            long r5 = r5.E()
            boolean r11 = r11.k(r2, r5)
            if (r11 == 0) goto L_0x01c3
            goto L_0x01d5
        L_0x01c3:
            c2.X0 r11 = r10.f22526b
            android.widget.ProgressBar r11 = r11.f10149h
            kotlin.jvm.internal.m.d(r11, r4)
            c2.X0 r0 = r10.f22526b
            android.widget.ImageView r0 = r0.f10146e
            kotlin.jvm.internal.m.d(r0, r12)
            r10.c(r11, r0)
            goto L_0x0230
        L_0x01d5:
            c2.X0 r11 = r10.f22526b
            android.widget.ProgressBar r11 = r11.f10149h
            kotlin.jvm.internal.m.d(r11, r4)
            c2.X0 r0 = r10.f22526b
            android.widget.ImageView r0 = r0.f10146e
            kotlin.jvm.internal.m.d(r0, r12)
            r10.e(r11, r0)
            goto L_0x0230
        L_0x01e7:
            java.lang.String r12 = r11.f()
            if (r12 == 0) goto L_0x0205
            int r12 = r12.length()
            if (r12 != 0) goto L_0x01f4
            goto L_0x0205
        L_0x01f4:
            g2.h$b r12 = g2.C2050h.f20600F0
            java.lang.String r11 = r11.b()
            boolean r11 = r12.d(r11)
            if (r11 != 0) goto L_0x0201
            goto L_0x0205
        L_0x0201:
            r10.u()
            goto L_0x0230
        L_0x0205:
            r10.v()
            c2.X0 r11 = r10.f22526b
            android.widget.ProgressBar r11 = r11.f10149h
            kotlin.jvm.internal.m.d(r11, r4)
            r10.q(r11)
            goto L_0x0230
        L_0x0213:
            N1.k$a r11 = N1.k.f7778g
            T1.a r11 = r11.i()
            if (r11 == 0) goto L_0x022d
            java.lang.String r11 = r11.b()
            java.lang.String r12 = r4.o()
            boolean r11 = m3.m.p(r11, r12, r0)
            if (r11 == 0) goto L_0x022d
            r10.y()
            goto L_0x0230
        L_0x022d:
            r10.z()
        L_0x0230:
            r1.i()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: x2.v1.p(g2.W, boolean):void");
    }

    /* access modifiers changed from: private */
    public static final void o(View view) {
    }
}
