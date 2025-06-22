package M1;

import N1.k;
import android.content.Context;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import c2.C1697w0;
import com.mbridge.msdk.MBridgeConstans;
import com.squareup.picasso.w;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import f2.C2004C;
import g2.N;
import g2.U;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.m;
import u2.F;
import w2.s;
import x2.C2375j;
import y2.n;

public final class Z extends RecyclerView.Adapter {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList f7524a;

    /* renamed from: b  reason: collision with root package name */
    private C2004C f7525b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public int f7526c;

    public final class a extends C2375j {
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final C1697w0 f7527b;

        /* renamed from: c  reason: collision with root package name */
        private C2004C f7528c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Z f7529d;

        /* renamed from: M1.Z$a$a  reason: collision with other inner class name */
        public static final class C0092a implements ViewTreeObserver.OnPreDrawListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ a f7530a;

            C0092a(a aVar) {
                this.f7530a = aVar;
            }

            public boolean onPreDraw() {
                this.f7530a.f7527b.f10844n.getViewTreeObserver().removeOnPreDrawListener(this);
                TextView textView = this.f7530a.f7527b.f10844n;
                m.d(textView, "tvBodyReview");
                if (!s.a(textView)) {
                    return true;
                }
                this.f7530a.f7527b.f10848r.setVisibility(0);
                this.f7530a.f7527b.f10848r.setTypeface(k.f7778g.w());
                return true;
            }
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public a(M1.Z r3, c2.C1697w0 r4, f2.C2004C r5) {
            /*
                r2 = this;
                java.lang.String r0 = "binding"
                kotlin.jvm.internal.m.e(r4, r0)
                java.lang.String r0 = "listener"
                kotlin.jvm.internal.m.e(r5, r0)
                r2.f7529d = r3
                android.widget.RelativeLayout r3 = r4.getRoot()
                java.lang.String r0 = "getRoot(...)"
                kotlin.jvm.internal.m.d(r3, r0)
                android.widget.RelativeLayout r0 = r4.getRoot()
                android.content.Context r0 = r0.getContext()
                java.lang.String r1 = "getContext(...)"
                kotlin.jvm.internal.m.d(r0, r1)
                r2.<init>(r3, r0)
                r2.f7527b = r4
                r2.f7528c = r5
                com.uptodown.util.views.UsernameTextView r3 = r4.f10849s
                N1.k$a r5 = N1.k.f7778g
                android.graphics.Typeface r0 = r5.w()
                r3.setTypeface(r0)
                android.widget.TextView r3 = r4.f10845o
                android.graphics.Typeface r0 = r5.x()
                r3.setTypeface(r0)
                android.widget.TextView r3 = r4.f10844n
                android.graphics.Typeface r0 = r5.x()
                r3.setTypeface(r0)
                android.widget.TextView r3 = r4.f10847q
                android.graphics.Typeface r0 = r5.x()
                r3.setTypeface(r0)
                android.widget.TextView r3 = r4.f10846p
                android.graphics.Typeface r4 = r5.x()
                r3.setTypeface(r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: M1.Z.a.<init>(M1.Z, c2.w0, f2.C):void");
        }

        /* access modifiers changed from: private */
        public static final void t(a aVar, int i4, View view) {
            aVar.f7528c.c(i4);
        }

        /* access modifiers changed from: private */
        public static final void u(a aVar, int i4, View view) {
            aVar.f7528c.c(i4);
        }

        /* access modifiers changed from: private */
        public static final void v(a aVar, int i4, View view) {
            aVar.f7528c.d(i4);
        }

        /* access modifiers changed from: private */
        public static final void w(a aVar, View view) {
            m.e(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
            C2004C c5 = aVar.f7528c;
            Object tag = view.getTag();
            m.c(tag, "null cannot be cast to non-null type kotlin.Int");
            c5.d(((Integer) tag).intValue());
        }

        /* access modifiers changed from: private */
        public static final void x(a aVar, N n4, View view) {
            m.e(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
            Context context = aVar.itemView.getContext();
            m.d(context, "getContext(...)");
            n nVar = new n(context);
            ImageView imageView = aVar.f7527b.f10834d;
            m.d(imageView, "ivLikesCounterReview");
            nVar.n(imageView);
            if (!F.f21886a.i(n4.f())) {
                C2004C c5 = aVar.f7528c;
                Object tag = view.getTag();
                m.c(tag, "null cannot be cast to non-null type kotlin.Int");
                c5.a(((Integer) tag).intValue());
                aVar.f7527b.f10846p.setText(String.valueOf(n4.g() + 1));
            }
        }

        /* access modifiers changed from: private */
        public static final void y(a aVar, View view) {
            aVar.f7528c.b();
        }

        public final void s(N n4, int i4) {
            CharSequence charSequence;
            m.e(n4, "item");
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            RelativeLayout b5 = this.f7527b.getRoot();
            Context context = this.itemView.getContext();
            m.d(context, "getContext(...)");
            b5.setLayoutParams(b(layoutParams, context, i4, this.f7529d.f7526c));
            this.f7527b.f10835e.setImageDrawable(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.vector_star_on));
            this.f7527b.f10836f.setImageDrawable(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.vector_star_off));
            this.f7527b.f10837g.setImageDrawable(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.vector_star_off));
            this.f7527b.f10838h.setImageDrawable(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.vector_star_off));
            this.f7527b.f10839i.setImageDrawable(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.vector_star_off));
            if (n4.h() >= 2) {
                this.f7527b.f10836f.setImageDrawable(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.vector_star_on));
            }
            if (n4.h() >= 3) {
                this.f7527b.f10837g.setImageDrawable(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.vector_star_on));
            }
            if (n4.h() >= 4) {
                this.f7527b.f10838h.setImageDrawable(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.vector_star_on));
            }
            if (n4.h() == 5) {
                this.f7527b.f10839i.setImageDrawable(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.vector_star_on));
            }
            String e5 = n4.e();
            if (e5 == null || e5.length() == 0) {
                w j4 = com.squareup.picasso.s.h().j(R.drawable.vector_user_default);
                UptodownApp.a aVar = UptodownApp.f17422D;
                Context context2 = this.itemView.getContext();
                m.d(context2, "getContext(...)");
                j4.n(aVar.k0(context2)).i(this.f7527b.f10833c);
            } else {
                w l4 = com.squareup.picasso.s.h().l(U.f20468m.c(n4.e()));
                UptodownApp.a aVar2 = UptodownApp.f17422D;
                Context context3 = this.itemView.getContext();
                m.d(context3, "getContext(...)");
                l4.n(aVar2.i0(context3)).i(this.f7527b.f10833c);
            }
            String c5 = n4.c();
            if (!(c5 == null || c5.length() == 0)) {
                this.f7527b.f10849s.setText(n4.c());
            }
            this.f7527b.f10849s.setOnClickListener(new T(this, i4));
            this.f7527b.f10833c.setOnClickListener(new U(this, i4));
            if (F.f21886a.i(n4.f())) {
                this.f7527b.f10834d.setImageDrawable(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.vector_heart_red));
            } else {
                this.f7527b.f10834d.setImageDrawable(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.vector_heart));
            }
            if (n4.m() == null || n4.d() != 1) {
                this.f7527b.f10832b.setVisibility(4);
            } else {
                this.f7527b.f10832b.setVisibility(0);
            }
            if (n4.k() != null) {
                this.f7527b.f10845o.setText(n4.k());
            }
            Spanned j5 = n4.j();
            if (j5 == null || j5.length() == 0) {
                this.f7527b.f10844n.setVisibility(8);
                this.f7527b.f10842l.setVisibility(8);
                this.f7527b.f10841k.setVisibility(8);
                return;
            }
            TextView textView = this.f7527b.f10844n;
            Spanned j6 = n4.j();
            if (j6 != null) {
                charSequence = m3.m.u0(j6);
            } else {
                charSequence = null;
            }
            textView.setText(charSequence);
            this.f7527b.f10844n.setVisibility(0);
            this.f7527b.f10844n.getViewTreeObserver().addOnPreDrawListener(new C0092a(this));
            this.f7527b.f10848r.setOnClickListener(new V(this, i4));
            this.f7527b.f10841k.setVisibility(0);
            this.f7527b.f10841k.setVisibility(0);
            this.f7527b.f10842l.setTag(Integer.valueOf(i4));
            this.f7527b.f10842l.setOnClickListener(new W(this));
            if (n4.a() > 0) {
                this.f7527b.f10847q.setText(String.valueOf(n4.a()));
            }
            this.f7527b.f10846p.setText(String.valueOf(n4.g()));
            this.f7527b.f10841k.setTag(Integer.valueOf(i4));
            this.f7527b.f10841k.setOnClickListener(new X(this, n4));
            this.f7527b.f10840j.setOnClickListener(new Y(this));
        }
    }

    public Z(ArrayList arrayList, C2004C c5) {
        m.e(arrayList, "reviews");
        m.e(c5, "listener");
        this.f7524a = arrayList;
        this.f7525b = c5;
        this.f7526c = arrayList.size() - 1;
    }

    /* renamed from: b */
    public void onBindViewHolder(a aVar, int i4) {
        m.e(aVar, "holder");
        Object obj = this.f7524a.get(i4);
        m.d(obj, "get(...)");
        aVar.s((N) obj, i4);
    }

    /* renamed from: c */
    public a onCreateViewHolder(ViewGroup viewGroup, int i4) {
        m.e(viewGroup, "parent");
        C1697w0 c5 = C1697w0.c(LayoutInflater.from(viewGroup.getContext()));
        m.d(c5, "inflate(...)");
        return new a(this, c5, this.f7525b);
    }

    public final void d(N n4) {
        m.e(n4, "review");
        Iterator it = this.f7524a.iterator();
        int i4 = 0;
        while (true) {
            if (!it.hasNext()) {
                i4 = -1;
                break;
            }
            int i5 = i4 + 1;
            if (((N) it.next()).f() == n4.f()) {
                break;
            }
            i4 = i5;
        }
        this.f7524a.set(i4, n4);
        notifyItemChanged(i4);
    }

    public int getItemCount() {
        return this.f7524a.size();
    }
}
