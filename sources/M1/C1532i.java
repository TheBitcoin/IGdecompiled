package M1;

import S2.C1601o;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.mbridge.msdk.MBridgeConstans;
import com.squareup.picasso.s;
import com.squareup.picasso.w;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import f2.C2010a;
import f2.C2013d;
import g2.C2050h;
import java.util.ArrayList;
import kotlin.jvm.internal.m;
import x2.C2375j;

/* renamed from: M1.i  reason: case insensitive filesystem */
public final class C1532i extends RecyclerView.Adapter {

    /* renamed from: a  reason: collision with root package name */
    private C2013d f7620a;

    /* renamed from: b  reason: collision with root package name */
    private final C2010a f7621b;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList f7622c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private boolean f7623d;

    /* renamed from: M1.i$a */
    public final class a extends C2375j {

        /* renamed from: b  reason: collision with root package name */
        private C2013d f7624b;

        /* renamed from: c  reason: collision with root package name */
        private final C2010a f7625c;

        /* renamed from: d  reason: collision with root package name */
        private final ImageView f7626d;

        /* renamed from: e  reason: collision with root package name */
        private final ImageView f7627e;

        /* renamed from: f  reason: collision with root package name */
        private final ProgressBar f7628f;

        /* renamed from: g  reason: collision with root package name */
        private final TextView f7629g;

        /* renamed from: h  reason: collision with root package name */
        private final TextView f7630h;

        /* renamed from: i  reason: collision with root package name */
        private final TextView f7631i;

        /* renamed from: j  reason: collision with root package name */
        private final TextView f7632j;

        /* renamed from: k  reason: collision with root package name */
        private final TextView f7633k;

        /* renamed from: l  reason: collision with root package name */
        private final LinearLayout f7634l;

        /* renamed from: m  reason: collision with root package name */
        final /* synthetic */ C1532i f7635m;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public a(M1.C1532i r4, android.view.View r5, f2.C2013d r6, f2.C2010a r7) {
            /*
                r3 = this;
                java.lang.String r0 = "itemView"
                kotlin.jvm.internal.m.e(r5, r0)
                java.lang.String r0 = "listener"
                kotlin.jvm.internal.m.e(r6, r0)
                java.lang.String r0 = "actionsClickListener"
                kotlin.jvm.internal.m.e(r7, r0)
                r3.f7635m = r4
                android.content.Context r4 = r5.getContext()
                java.lang.String r0 = "getContext(...)"
                kotlin.jvm.internal.m.d(r4, r0)
                r3.<init>(r5, r4)
                r3.f7624b = r6
                r3.f7625c = r7
                r4 = 2131362336(0x7f0a0220, float:1.834445E38)
                android.view.View r4 = r5.findViewById(r4)
                android.widget.ImageView r4 = (android.widget.ImageView) r4
                r3.f7626d = r4
                r4 = 2131362386(0x7f0a0252, float:1.8344551E38)
                android.view.View r4 = r5.findViewById(r4)
                android.widget.ImageView r4 = (android.widget.ImageView) r4
                r3.f7627e = r4
                r4 = 2131363030(0x7f0a04d6, float:1.8345857E38)
                android.view.View r4 = r5.findViewById(r4)
                java.lang.String r6 = "findViewById(...)"
                kotlin.jvm.internal.m.d(r4, r6)
                android.widget.ProgressBar r4 = (android.widget.ProgressBar) r4
                r3.f7628f = r4
                r4 = 2131363948(0x7f0a086c, float:1.834772E38)
                android.view.View r4 = r5.findViewById(r4)
                android.widget.TextView r4 = (android.widget.TextView) r4
                r3.f7629g = r4
                r7 = 2131363716(0x7f0a0784, float:1.8347249E38)
                android.view.View r7 = r5.findViewById(r7)
                android.widget.TextView r7 = (android.widget.TextView) r7
                r3.f7630h = r7
                r0 = 2131364217(0x7f0a0979, float:1.8348265E38)
                android.view.View r0 = r5.findViewById(r0)
                android.widget.TextView r0 = (android.widget.TextView) r0
                r3.f7631i = r0
                r0 = 2131364090(0x7f0a08fa, float:1.8348007E38)
                android.view.View r0 = r5.findViewById(r0)
                kotlin.jvm.internal.m.d(r0, r6)
                android.widget.TextView r0 = (android.widget.TextView) r0
                r3.f7632j = r0
                r1 = 2131364380(0x7f0a0a1c, float:1.8348595E38)
                android.view.View r1 = r5.findViewById(r1)
                kotlin.jvm.internal.m.d(r1, r6)
                android.widget.TextView r1 = (android.widget.TextView) r1
                r3.f7633k = r1
                r2 = 2131362631(0x7f0a0347, float:1.8345048E38)
                android.view.View r5 = r5.findViewById(r2)
                kotlin.jvm.internal.m.d(r5, r6)
                android.widget.LinearLayout r5 = (android.widget.LinearLayout) r5
                r3.f7634l = r5
                N1.k$a r5 = N1.k.f7778g
                android.graphics.Typeface r6 = r5.w()
                r4.setTypeface(r6)
                android.graphics.Typeface r4 = r5.x()
                r7.setTypeface(r4)
                android.graphics.Typeface r4 = r5.x()
                r0.setTypeface(r4)
                android.graphics.Typeface r4 = r5.x()
                r1.setTypeface(r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: M1.C1532i.a.<init>(M1.i, android.view.View, f2.d, f2.a):void");
        }

        /* access modifiers changed from: private */
        public static final boolean n(a aVar, C2050h hVar, int i4, View view) {
            aVar.f7625c.a(hVar, i4);
            return true;
        }

        public final void m(C2050h hVar, int i4, int i5) {
            m.e(hVar, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            View view = this.itemView;
            Context context = view.getContext();
            m.d(context, "getContext(...)");
            view.setLayoutParams(b(layoutParams, context, i4, 20));
            String y4 = hVar.y();
            if (y4 == null || y4.length() == 0) {
                this.f7626d.setImageDrawable(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.shape_bg_placeholder));
            } else {
                w l4 = s.h().l(hVar.B());
                UptodownApp.a aVar = UptodownApp.f17422D;
                Context context2 = this.itemView.getContext();
                m.d(context2, "getContext(...)");
                l4.n(aVar.h0(context2)).a().f().l(R.drawable.shape_bg_placeholder).i(this.f7626d);
            }
            View view2 = this.itemView;
            m.d(view2, "itemView");
            c(view2, this.f7624b, hVar);
            this.itemView.setOnLongClickListener(new C1531h(this, hVar, i5));
            TextView textView = this.f7629g;
            m.d(textView, "tvName");
            TextView textView2 = this.f7630h;
            m.d(textView2, "tvDesc");
            i(hVar, textView, textView2);
            ImageView imageView = this.f7627e;
            m.d(imageView, "ivIcon");
            h(imageView, hVar.F());
            ProgressBar progressBar = this.f7628f;
            ImageView imageView2 = this.f7627e;
            m.d(imageView2, "ivIcon");
            TextView textView3 = this.f7630h;
            m.d(textView3, "tvDesc");
            e(hVar, progressBar, imageView2, textView3, this.f7632j, this.f7631i, this.f7634l);
        }
    }

    /* renamed from: M1.i$b */
    public final class b extends C2375j {

        /* renamed from: b  reason: collision with root package name */
        private C2013d f7636b;

        /* renamed from: c  reason: collision with root package name */
        private final C2010a f7637c;

        /* renamed from: d  reason: collision with root package name */
        private final ImageView f7638d;

        /* renamed from: e  reason: collision with root package name */
        private final ProgressBar f7639e;

        /* renamed from: f  reason: collision with root package name */
        private final ImageView f7640f;

        /* renamed from: g  reason: collision with root package name */
        private final TextView f7641g;

        /* renamed from: h  reason: collision with root package name */
        private final TextView f7642h;

        /* renamed from: i  reason: collision with root package name */
        private final TextView f7643i;

        /* renamed from: j  reason: collision with root package name */
        private final TextView f7644j;

        /* renamed from: k  reason: collision with root package name */
        private final TextView f7645k;

        /* renamed from: l  reason: collision with root package name */
        private final LinearLayout f7646l;

        /* renamed from: m  reason: collision with root package name */
        private final TextView f7647m;

        /* renamed from: n  reason: collision with root package name */
        final /* synthetic */ C1532i f7648n;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public b(M1.C1532i r5, android.view.View r6, f2.C2013d r7, f2.C2010a r8) {
            /*
                r4 = this;
                java.lang.String r0 = "itemView"
                kotlin.jvm.internal.m.e(r6, r0)
                java.lang.String r0 = "listener"
                kotlin.jvm.internal.m.e(r7, r0)
                java.lang.String r0 = "actionsClickListener"
                kotlin.jvm.internal.m.e(r8, r0)
                r4.f7648n = r5
                android.content.Context r5 = r6.getContext()
                java.lang.String r0 = "getContext(...)"
                kotlin.jvm.internal.m.d(r5, r0)
                r4.<init>(r6, r5)
                r4.f7636b = r7
                r4.f7637c = r8
                r5 = 2131362337(0x7f0a0221, float:1.8344452E38)
                android.view.View r5 = r6.findViewById(r5)
                android.widget.ImageView r5 = (android.widget.ImageView) r5
                r4.f7638d = r5
                r5 = 2131363031(0x7f0a04d7, float:1.834586E38)
                android.view.View r5 = r6.findViewById(r5)
                java.lang.String r7 = "findViewById(...)"
                kotlin.jvm.internal.m.d(r5, r7)
                android.widget.ProgressBar r5 = (android.widget.ProgressBar) r5
                r4.f7639e = r5
                r5 = 2131362388(0x7f0a0254, float:1.8344555E38)
                android.view.View r5 = r6.findViewById(r5)
                android.widget.ImageView r5 = (android.widget.ImageView) r5
                r4.f7640f = r5
                r5 = 2131363951(0x7f0a086f, float:1.8347725E38)
                android.view.View r5 = r6.findViewById(r5)
                android.widget.TextView r5 = (android.widget.TextView) r5
                r4.f7641g = r5
                r8 = 2131364009(0x7f0a08a9, float:1.8347843E38)
                android.view.View r8 = r6.findViewById(r8)
                android.widget.TextView r8 = (android.widget.TextView) r8
                r4.f7642h = r8
                r0 = 2131363719(0x7f0a0787, float:1.8347255E38)
                android.view.View r0 = r6.findViewById(r0)
                android.widget.TextView r0 = (android.widget.TextView) r0
                r4.f7643i = r0
                r1 = 2131364091(0x7f0a08fb, float:1.834801E38)
                android.view.View r1 = r6.findViewById(r1)
                kotlin.jvm.internal.m.d(r1, r7)
                android.widget.TextView r1 = (android.widget.TextView) r1
                r4.f7644j = r1
                r2 = 2131364381(0x7f0a0a1d, float:1.8348597E38)
                android.view.View r2 = r6.findViewById(r2)
                kotlin.jvm.internal.m.d(r2, r7)
                android.widget.TextView r2 = (android.widget.TextView) r2
                r4.f7645k = r2
                r3 = 2131362632(0x7f0a0348, float:1.834505E38)
                android.view.View r3 = r6.findViewById(r3)
                kotlin.jvm.internal.m.d(r3, r7)
                android.widget.LinearLayout r3 = (android.widget.LinearLayout) r3
                r4.f7646l = r3
                r7 = 2131364219(0x7f0a097b, float:1.8348269E38)
                android.view.View r6 = r6.findViewById(r7)
                android.widget.TextView r6 = (android.widget.TextView) r6
                r4.f7647m = r6
                N1.k$a r6 = N1.k.f7778g
                android.graphics.Typeface r7 = r6.w()
                r5.setTypeface(r7)
                android.graphics.Typeface r5 = r6.w()
                r8.setTypeface(r5)
                android.graphics.Typeface r5 = r6.x()
                r0.setTypeface(r5)
                android.graphics.Typeface r5 = r6.x()
                r1.setTypeface(r5)
                android.graphics.Typeface r5 = r6.x()
                r2.setTypeface(r5)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: M1.C1532i.b.<init>(M1.i, android.view.View, f2.d, f2.a):void");
        }

        /* access modifiers changed from: private */
        public static final boolean n(b bVar, C2050h hVar, int i4, View view) {
            bVar.f7637c.a(hVar, i4);
            return true;
        }

        public final void m(C2050h hVar, int i4, int i5, boolean z4) {
            m.e(hVar, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
            int dimension = (int) this.itemView.getContext().getResources().getDimension(R.dimen.margin_m);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            if (z4) {
                layoutParams.setMargins(dimension, 0, dimension, dimension);
            } else {
                layoutParams.setMargins(dimension, 0, 0, dimension);
            }
            ViewGroup.LayoutParams layoutParams2 = this.f7638d.getLayoutParams();
            m.c(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams2;
            if (i4 >= 10) {
                marginLayoutParams.setMarginStart((int) this.itemView.getContext().getResources().getDimension(R.dimen.margin_xl));
            } else {
                marginLayoutParams.setMarginStart(0);
            }
            this.f7638d.setLayoutParams(marginLayoutParams);
            this.itemView.setLayoutParams(layoutParams);
            this.f7642h.setText(String.valueOf(i4));
            String y4 = hVar.y();
            if (y4 == null || y4.length() == 0) {
                this.f7638d.setImageDrawable(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.shape_bg_placeholder));
            } else {
                w l4 = s.h().l(hVar.B());
                UptodownApp.a aVar = UptodownApp.f17422D;
                Context context = this.itemView.getContext();
                m.d(context, "getContext(...)");
                l4.n(aVar.h0(context)).a().f().l(R.drawable.shape_bg_placeholder).i(this.f7638d);
            }
            View view = this.itemView;
            m.d(view, "itemView");
            c(view, this.f7636b, hVar);
            this.itemView.setOnLongClickListener(new C1533j(this, hVar, i5));
            TextView textView = this.f7641g;
            m.d(textView, "tvName");
            TextView textView2 = this.f7643i;
            m.d(textView2, "tvDesc");
            i(hVar, textView, textView2);
            ImageView imageView = this.f7640f;
            m.d(imageView, "ivIcon");
            h(imageView, hVar.F());
            ProgressBar progressBar = this.f7639e;
            ImageView imageView2 = this.f7640f;
            m.d(imageView2, "ivIcon");
            TextView textView3 = this.f7643i;
            m.d(textView3, "tvDesc");
            e(hVar, progressBar, imageView2, textView3, this.f7644j, this.f7647m, this.f7646l);
        }
    }

    public C1532i(C2013d dVar, C2010a aVar) {
        m.e(dVar, "listener");
        m.e(aVar, "actionsClickListener");
        this.f7620a = dVar;
        this.f7621b = aVar;
    }

    public final ArrayList a() {
        return this.f7622c;
    }

    public final void b(ArrayList arrayList, boolean z4) {
        m.e(arrayList, "appList");
        this.f7623d = z4;
        this.f7622c = arrayList;
        notifyDataSetChanged();
    }

    public int getItemCount() {
        return this.f7622c.size();
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i4) {
        m.e(viewHolder, "holder");
        if (viewHolder instanceof a) {
            Object obj = this.f7622c.get(i4);
            m.d(obj, "get(...)");
            ((a) viewHolder).m((C2050h) obj, i4 + 1, i4);
        } else if (viewHolder instanceof b) {
            int i5 = i4 + 1;
            if (m.a(this.f7622c.get(i4), C1601o.P(this.f7622c))) {
                Object obj2 = this.f7622c.get(i4);
                m.d(obj2, "get(...)");
                ((b) viewHolder).m((C2050h) obj2, i5, i4, true);
                return;
            }
            Object obj3 = this.f7622c.get(i4);
            m.d(obj3, "get(...)");
            ((b) viewHolder).m((C2050h) obj3, i5, i4, false);
        }
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i4) {
        m.e(viewGroup, "parent");
        if (this.f7623d) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.home_card_top_featured_item, viewGroup, false);
            m.b(inflate);
            return new b(this, inflate, this.f7620a, this.f7621b);
        }
        View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.home_card_featured_item, viewGroup, false);
        m.b(inflate2);
        return new a(this, inflate2, this.f7620a, this.f7621b);
    }
}
