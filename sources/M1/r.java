package M1;

import R2.s;
import S2.C1601o;
import W1.i;
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
import c2.C1654a0;
import c2.C1656b0;
import c2.I;
import c2.Y;
import c2.Z;
import com.mbridge.msdk.MBridgeConstans;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import f2.C2010a;
import f2.C2013d;
import g2.C2050h;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import x2.C2375j;
import x2.C2407z0;
import x2.M0;
import x2.N;

public final class r extends RecyclerView.Adapter {

    /* renamed from: e  reason: collision with root package name */
    public static final a f7676e = new a((C2103g) null);

    /* renamed from: a  reason: collision with root package name */
    private C2013d f7677a;

    /* renamed from: b  reason: collision with root package name */
    private String f7678b;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList f7679c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private boolean f7680d;

    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        private a() {
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public Object f7681a;

        /* renamed from: b  reason: collision with root package name */
        private int f7682b;

        public final Object a() {
            Object obj = this.f7681a;
            if (obj != null) {
                return obj;
            }
            m.u("item");
            return s.f8222a;
        }

        public final int b() {
            return this.f7682b;
        }

        public final void c(Object obj) {
            m.e(obj, "<set-?>");
            this.f7681a = obj;
        }

        public final void d(int i4) {
            this.f7682b = i4;
        }
    }

    public final class c extends RecyclerView.Adapter {

        /* renamed from: a  reason: collision with root package name */
        private C2013d f7683a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public Context f7684b;

        /* renamed from: c  reason: collision with root package name */
        private ArrayList f7685c = new ArrayList();

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ r f7686d;

        public final class a extends C2375j {

            /* renamed from: b  reason: collision with root package name */
            private final I f7687b;

            /* renamed from: c  reason: collision with root package name */
            private C2013d f7688c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ c f7689d;

            /* JADX WARNING: Illegal instructions before constructor call */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public a(M1.r.c r2, c2.I r3, f2.C2013d r4, android.content.Context r5) {
                /*
                    r1 = this;
                    java.lang.String r0 = "binding"
                    kotlin.jvm.internal.m.e(r3, r0)
                    java.lang.String r0 = "listener"
                    kotlin.jvm.internal.m.e(r4, r0)
                    java.lang.String r0 = "context"
                    kotlin.jvm.internal.m.e(r5, r0)
                    r1.f7689d = r2
                    android.widget.RelativeLayout r2 = r3.getRoot()
                    java.lang.String r0 = "getRoot(...)"
                    kotlin.jvm.internal.m.d(r2, r0)
                    r1.<init>(r2, r5)
                    r1.f7687b = r3
                    r1.f7688c = r4
                    android.widget.TextView r2 = r3.f9781j
                    N1.k$a r4 = N1.k.f7778g
                    android.graphics.Typeface r5 = r4.w()
                    r2.setTypeface(r5)
                    android.widget.TextView r2 = r3.f9779h
                    android.graphics.Typeface r5 = r4.x()
                    r2.setTypeface(r5)
                    android.widget.TextView r2 = r3.f9784m
                    android.graphics.Typeface r3 = r4.x()
                    r2.setTypeface(r3)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: M1.r.c.a.<init>(M1.r$c, c2.I, f2.d, android.content.Context):void");
            }

            public final void l(C2050h hVar, boolean z4) {
                m.e(hVar, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
                int dimension = (int) this.f7689d.f7684b.getResources().getDimension(R.dimen.margin_m);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                if (z4) {
                    layoutParams.setMargins(dimension, 0, dimension, dimension);
                } else {
                    layoutParams.setMargins(dimension, 0, 0, dimension);
                }
                this.itemView.setLayoutParams(layoutParams);
                String y4 = hVar.y();
                if (!(y4 == null || y4.length() == 0)) {
                    com.squareup.picasso.s.h().l(hVar.B()).n(UptodownApp.f17422D.h0(this.f7689d.f7684b)).a().f().l(R.drawable.shape_bg_placeholder).i(this.f7687b.f9773b);
                }
                View view = this.itemView;
                m.d(view, "itemView");
                c(view, this.f7688c, hVar);
                TextView textView = this.f7687b.f9781j;
                m.d(textView, "tvNameHomeCardFeaturedItem");
                TextView textView2 = this.f7687b.f9779h;
                m.d(textView2, "tvDescHomeCardFeaturedItem");
                i(hVar, textView, textView2);
                String Q4 = hVar.Q();
                TextView textView3 = this.f7687b.f9784m;
                m.d(textView3, "tvStatusHomeCardFeaturedItem");
                TextView textView4 = this.f7687b.f9779h;
                m.d(textView4, "tvDescHomeCardFeaturedItem");
                g(Q4, textView3, textView4);
                ImageView imageView = this.f7687b.f9774c;
                m.d(imageView, "ivLogoHomeCardFeaturedItem");
                h(imageView, hVar.F());
            }
        }

        public c(r rVar, C2013d dVar, Context context) {
            m.e(dVar, "listener");
            m.e(context, "context");
            this.f7686d = rVar;
            this.f7683a = dVar;
            this.f7684b = context;
        }

        public final ArrayList b() {
            return this.f7685c;
        }

        /* renamed from: c */
        public void onBindViewHolder(a aVar, int i4) {
            m.e(aVar, "holder");
            if (m.a(this.f7685c.get(i4), C1601o.P(this.f7685c))) {
                Object obj = this.f7685c.get(i4);
                m.d(obj, "get(...)");
                aVar.l((C2050h) obj, true);
                return;
            }
            Object obj2 = this.f7685c.get(i4);
            m.d(obj2, "get(...)");
            aVar.l((C2050h) obj2, false);
        }

        /* renamed from: d */
        public a onCreateViewHolder(ViewGroup viewGroup, int i4) {
            m.e(viewGroup, "parent");
            I d5 = I.d(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            m.d(d5, "inflate(...)");
            return new a(this, d5, this.f7683a, this.f7684b);
        }

        public final void e(ArrayList arrayList) {
            m.e(arrayList, "carouselApps");
            this.f7685c = arrayList;
            notifyDataSetChanged();
        }

        public int getItemCount() {
            return this.f7685c.size();
        }
    }

    public final class d extends C2375j {

        /* renamed from: b  reason: collision with root package name */
        private final c f7690b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ r f7691c;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public d(M1.r r4, c2.Y r5, f2.C2013d r6, android.content.Context r7, java.lang.String r8) {
            /*
                r3 = this;
                java.lang.String r0 = "binding"
                kotlin.jvm.internal.m.e(r5, r0)
                java.lang.String r0 = "listener"
                kotlin.jvm.internal.m.e(r6, r0)
                java.lang.String r0 = "context"
                kotlin.jvm.internal.m.e(r7, r0)
                java.lang.String r0 = "organizationName"
                kotlin.jvm.internal.m.e(r8, r0)
                r3.f7691c = r4
                android.widget.LinearLayout r0 = r5.getRoot()
                java.lang.String r1 = "getRoot(...)"
                kotlin.jvm.internal.m.d(r0, r1)
                r3.<init>(r0, r7)
                M1.r$c r0 = new M1.r$c
                r0.<init>(r4, r6, r7)
                r3.f7690b = r0
                androidx.recyclerview.widget.RecyclerView r4 = r5.f10161b
                androidx.recyclerview.widget.LinearLayoutManager r6 = new androidx.recyclerview.widget.LinearLayoutManager
                android.view.View r1 = r3.itemView
                android.content.Context r1 = r1.getContext()
                r2 = 0
                r6.<init>(r1, r2, r2)
                r4.setLayoutManager(r6)
                androidx.recyclerview.widget.RecyclerView r4 = r5.f10161b
                r4.setAdapter(r0)
                android.widget.TextView r4 = r5.f10162c
                N1.k$a r6 = N1.k.f7778g
                android.graphics.Typeface r6 = r6.w()
                r4.setTypeface(r6)
                android.widget.TextView r4 = r5.f10162c
                r5 = 2131952460(0x7f13034c, float:1.9541363E38)
                r6 = 1
                java.lang.Object[] r6 = new java.lang.Object[r6]
                r6[r2] = r8
                java.lang.String r5 = r7.getString(r5, r6)
                r4.setText(r5)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: M1.r.d.<init>(M1.r, c2.Y, f2.d, android.content.Context, java.lang.String):void");
        }

        public final void l(ArrayList arrayList) {
            m.e(arrayList, "carouselApps");
            this.f7690b.e(arrayList);
        }

        public final c m() {
            return this.f7690b;
        }
    }

    public final class e extends C2375j {

        /* renamed from: b  reason: collision with root package name */
        private final Z f7692b;

        /* renamed from: c  reason: collision with root package name */
        private C2013d f7693c;

        /* renamed from: d  reason: collision with root package name */
        private Context f7694d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ r f7695e;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public e(M1.r r2, c2.Z r3, f2.C2013d r4, android.content.Context r5) {
            /*
                r1 = this;
                java.lang.String r0 = "binding"
                kotlin.jvm.internal.m.e(r3, r0)
                java.lang.String r0 = "listener"
                kotlin.jvm.internal.m.e(r4, r0)
                java.lang.String r0 = "context"
                kotlin.jvm.internal.m.e(r5, r0)
                r1.f7695e = r2
                android.widget.RelativeLayout r2 = r3.getRoot()
                java.lang.String r0 = "getRoot(...)"
                kotlin.jvm.internal.m.d(r2, r0)
                r1.<init>(r2, r5)
                r1.f7692b = r3
                r1.f7693c = r4
                r1.f7694d = r5
                android.widget.TextView r2 = r3.f10177n
                N1.k$a r4 = N1.k.f7778g
                android.graphics.Typeface r5 = r4.w()
                r2.setTypeface(r5)
                android.widget.TextView r2 = r3.f10175l
                android.graphics.Typeface r5 = r4.w()
                r2.setTypeface(r5)
                android.widget.TextView r2 = r3.f10172i
                android.graphics.Typeface r5 = r4.x()
                r2.setTypeface(r5)
                android.widget.TextView r2 = r3.f10176m
                android.graphics.Typeface r5 = r4.x()
                r2.setTypeface(r5)
                android.widget.TextView r2 = r3.f10178o
                android.graphics.Typeface r5 = r4.x()
                r2.setTypeface(r5)
                android.widget.TextView r2 = r3.f10174k
                android.graphics.Typeface r5 = r4.x()
                r2.setTypeface(r5)
                android.widget.TextView r2 = r3.f10173j
                android.graphics.Typeface r5 = r4.w()
                r2.setTypeface(r5)
                android.widget.TextView r2 = r3.f10171h
                android.graphics.Typeface r5 = r4.x()
                r2.setTypeface(r5)
                android.widget.TextView r2 = r3.f10179p
                android.graphics.Typeface r3 = r4.x()
                r2.setTypeface(r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: M1.r.e.<init>(M1.r, c2.Z, f2.d, android.content.Context):void");
        }

        /* access modifiers changed from: private */
        public static final void n(e eVar, C2050h hVar, View view) {
            eVar.f7693c.a(hVar);
        }

        public final void m(C2050h hVar) {
            m.e(hVar, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
            String y4 = hVar.y();
            if (y4 == null || y4.length() == 0) {
                this.f7692b.f10165b.setImageDrawable(ContextCompat.getDrawable(this.f7694d, R.drawable.shape_bg_placeholder));
            } else {
                com.squareup.picasso.s.h().l(hVar.y()).n(UptodownApp.f17422D.h0(this.f7694d)).i(this.f7692b.f10165b);
            }
            View view = this.itemView;
            m.d(view, "itemView");
            c(view, this.f7693c, hVar);
            TextView textView = this.f7692b.f10175l;
            m.d(textView, "tvTopAppNameOrganization");
            TextView textView2 = this.f7692b.f10172i;
            m.d(textView2, "tvTopAppDescOrganization");
            i(hVar, textView, textView2);
            this.f7692b.f10178o.setText(String.valueOf(((double) hVar.V()) / 10.0d));
            this.f7692b.f10174k.setText(this.f7694d.getString(R.string.downloads_counter_multiple, new Object[]{new i().b((long) hVar.p())}));
            ImageView imageView = this.f7692b.f10166c;
            m.d(imageView, "ivTopAppLogoOrganization");
            h(imageView, hVar.F());
            if (!new u2.m().s(hVar.Q(), this.f7694d)) {
                this.f7692b.f10173j.setOnClickListener(new C1541s(this, hVar));
            } else {
                this.f7692b.f10173j.setVisibility(8);
            }
            ProgressBar progressBar = this.f7692b.f10169f;
            m.d(progressBar, "pbProgressLogoOrganization");
            ImageView imageView2 = this.f7692b.f10166c;
            m.d(imageView2, "ivTopAppLogoOrganization");
            TextView textView3 = this.f7692b.f10172i;
            m.d(textView3, "tvTopAppDescOrganization");
            TextView textView4 = this.f7692b.f10171h;
            m.d(textView4, "tvProgressTopOrganization");
            Z z4 = this.f7692b;
            TextView textView5 = z4.f10176m;
            LinearLayout linearLayout = z4.f10167d;
            m.d(linearLayout, "llProgressTopOrganization");
            e(hVar, progressBar, imageView2, textView3, textView4, textView5, linearLayout);
        }
    }

    public final class f extends RecyclerView.Adapter {

        /* renamed from: a  reason: collision with root package name */
        private C2013d f7696a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public Context f7697b;

        /* renamed from: c  reason: collision with root package name */
        private ArrayList f7698c = new ArrayList();

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ r f7699d;

        public final class a extends C2375j {

            /* renamed from: b  reason: collision with root package name */
            private final C1656b0 f7700b;

            /* renamed from: c  reason: collision with root package name */
            private C2013d f7701c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ f f7702d;

            /* JADX WARNING: Illegal instructions before constructor call */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public a(M1.r.f r2, c2.C1656b0 r3, f2.C2013d r4, android.content.Context r5) {
                /*
                    r1 = this;
                    java.lang.String r0 = "binding"
                    kotlin.jvm.internal.m.e(r3, r0)
                    java.lang.String r0 = "listener"
                    kotlin.jvm.internal.m.e(r4, r0)
                    java.lang.String r0 = "context"
                    kotlin.jvm.internal.m.e(r5, r0)
                    r1.f7702d = r2
                    android.widget.RelativeLayout r2 = r3.getRoot()
                    java.lang.String r0 = "getRoot(...)"
                    kotlin.jvm.internal.m.d(r2, r0)
                    r1.<init>(r2, r5)
                    r1.f7700b = r3
                    r1.f7701c = r4
                    android.widget.TextView r2 = r3.f10230f
                    N1.k$a r4 = N1.k.f7778g
                    android.graphics.Typeface r5 = r4.w()
                    r2.setTypeface(r5)
                    android.widget.TextView r2 = r3.f10228d
                    android.graphics.Typeface r5 = r4.x()
                    r2.setTypeface(r5)
                    android.widget.TextView r2 = r3.f10231g
                    android.graphics.Typeface r5 = r4.w()
                    r2.setTypeface(r5)
                    android.widget.TextView r2 = r3.f10232h
                    android.graphics.Typeface r5 = r4.x()
                    r2.setTypeface(r5)
                    android.widget.TextView r2 = r3.f10229e
                    android.graphics.Typeface r3 = r4.x()
                    r2.setTypeface(r3)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: M1.r.f.a.<init>(M1.r$f, c2.b0, f2.d, android.content.Context):void");
            }

            public final void l(C2050h hVar) {
                m.e(hVar, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
                View view = this.itemView;
                m.d(view, "itemView");
                c(view, this.f7701c, hVar);
                TextView textView = this.f7700b.f10230f;
                m.d(textView, "tvTopAppNameOrganization");
                TextView textView2 = this.f7700b.f10228d;
                m.d(textView2, "tvTopAppDescOrganization");
                i(hVar, textView, textView2);
                String Q4 = hVar.Q();
                TextView textView3 = this.f7700b.f10231g;
                m.d(textView3, "tvTopAppStatusOrganization");
                TextView textView4 = this.f7700b.f10228d;
                m.d(textView4, "tvTopAppDescOrganization");
                g(Q4, textView3, textView4);
                ImageView imageView = this.f7700b.f10226b;
                m.d(imageView, "ivTopAppLogoOrganization");
                h(imageView, hVar.E());
                this.f7700b.f10232h.setText(String.valueOf(((double) hVar.V()) / 10.0d));
                this.f7700b.f10229e.setText(this.f7702d.f7697b.getString(R.string.downloads_counter_multiple, new Object[]{new i().b((long) hVar.p())}));
            }
        }

        public f(r rVar, C2013d dVar, Context context) {
            m.e(dVar, "listener");
            m.e(context, "context");
            this.f7699d = rVar;
            this.f7696a = dVar;
            this.f7697b = context;
        }

        public final ArrayList b() {
            return this.f7698c;
        }

        /* renamed from: c */
        public void onBindViewHolder(a aVar, int i4) {
            m.e(aVar, "holder");
            Object obj = this.f7698c.get(i4);
            m.d(obj, "get(...)");
            aVar.l((C2050h) obj);
        }

        /* renamed from: d */
        public a onCreateViewHolder(ViewGroup viewGroup, int i4) {
            m.e(viewGroup, "parent");
            C1656b0 c5 = C1656b0.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            m.d(c5, "inflate(...)");
            return new a(this, c5, this.f7696a, this.f7697b);
        }

        public final void e(ArrayList arrayList) {
            m.e(arrayList, "importantApps");
            this.f7698c = arrayList;
            notifyDataSetChanged();
        }

        public int getItemCount() {
            return this.f7698c.size();
        }
    }

    public final class g extends C2375j {

        /* renamed from: b  reason: collision with root package name */
        private final f f7703b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ r f7704c;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public g(M1.r r4, c2.C1654a0 r5, f2.C2013d r6, android.content.Context r7) {
            /*
                r3 = this;
                java.lang.String r0 = "binding"
                kotlin.jvm.internal.m.e(r5, r0)
                java.lang.String r0 = "listener"
                kotlin.jvm.internal.m.e(r6, r0)
                java.lang.String r0 = "context"
                kotlin.jvm.internal.m.e(r7, r0)
                r3.f7704c = r4
                android.widget.LinearLayout r0 = r5.getRoot()
                java.lang.String r1 = "getRoot(...)"
                kotlin.jvm.internal.m.d(r0, r1)
                r3.<init>(r0, r7)
                M1.r$f r0 = new M1.r$f
                r0.<init>(r4, r6, r7)
                r3.f7703b = r0
                androidx.recyclerview.widget.RecyclerView r4 = r5.f10191b
                androidx.recyclerview.widget.LinearLayoutManager r6 = new androidx.recyclerview.widget.LinearLayoutManager
                android.view.View r7 = r3.itemView
                android.content.Context r7 = r7.getContext()
                r1 = 1
                r2 = 0
                r6.<init>(r7, r1, r2)
                r4.setLayoutManager(r6)
                androidx.recyclerview.widget.RecyclerView r4 = r5.f10191b
                r4.setAdapter(r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: M1.r.g.<init>(M1.r, c2.a0, f2.d, android.content.Context):void");
        }

        public final void l(ArrayList arrayList) {
            m.e(arrayList, "importantApps");
            this.f7703b.e(arrayList);
        }

        public final f m() {
            return this.f7703b;
        }
    }

    public r(C2013d dVar, String str) {
        m.e(dVar, "listener");
        m.e(str, "organizationName");
        this.f7677a = dVar;
        this.f7678b = str;
    }

    public final void a(ArrayList arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            this.f7679c.size();
            Iterator it = arrayList.iterator();
            m.d(it, "iterator(...)");
            while (it.hasNext()) {
                Object next = it.next();
                m.d(next, "next(...)");
                b bVar = new b();
                bVar.c((C2050h) next);
                bVar.d(5);
                this.f7679c.add(bVar);
                notifyItemInserted(C1601o.j(this.f7679c));
            }
        }
    }

    public final void b(C2050h hVar, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3) {
        this.f7679c = new ArrayList();
        if (hVar != null) {
            b bVar = new b();
            bVar.c(hVar);
            bVar.d(1);
            this.f7679c.add(bVar);
        }
        if (arrayList != null && !arrayList.isEmpty()) {
            b bVar2 = new b();
            bVar2.c(arrayList);
            bVar2.d(2);
            this.f7679c.add(bVar2);
        }
        if (arrayList2 != null && !arrayList2.isEmpty()) {
            b bVar3 = new b();
            bVar3.c(arrayList2);
            bVar3.d(3);
            this.f7679c.add(bVar3);
        }
        if (arrayList3 != null && !arrayList3.isEmpty()) {
            b bVar4 = new b();
            bVar4.c(arrayList3);
            bVar4.d(4);
            this.f7679c.add(bVar4);
            Iterator it = arrayList3.iterator();
            m.d(it, "iterator(...)");
            while (it.hasNext()) {
                Object next = it.next();
                m.d(next, "next(...)");
                b bVar5 = new b();
                bVar5.c((C2050h) next);
                bVar5.d(5);
                this.f7679c.add(bVar5);
            }
        }
    }

    public final void c(boolean z4) {
        this.f7680d = z4;
        if (z4) {
            notifyItemInserted(getItemCount());
        } else {
            notifyItemRemoved(getItemCount());
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: g2.h} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: g2.h} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v0, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v0, resolved type: g2.h} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: g2.h} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: g2.h} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v4, resolved type: g2.h} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v6, resolved type: g2.h} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void d(java.lang.String r11, androidx.recyclerview.widget.RecyclerView r12) {
        /*
            r10 = this;
            java.lang.String r0 = "packageName"
            kotlin.jvm.internal.m.e(r11, r0)
            java.lang.String r0 = "recyclerView"
            kotlin.jvm.internal.m.e(r12, r0)
            int r0 = r10.getItemCount()
            r1 = 0
            r2 = 0
        L_0x0010:
            if (r2 >= r0) goto L_0x00c6
            androidx.recyclerview.widget.RecyclerView$ViewHolder r3 = r12.findViewHolderForAdapterPosition(r2)
            boolean r4 = r3 instanceof M1.r.e
            if (r4 == 0) goto L_0x003c
            java.util.ArrayList r3 = r10.f7679c
            java.util.Iterator r3 = r3.iterator()
            r4 = 0
        L_0x0021:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x00c2
            int r5 = r4 + 1
            java.lang.Object r6 = r3.next()
            M1.r$b r6 = (M1.r.b) r6
            java.lang.Object r6 = r6.a()
            boolean r6 = r6 instanceof g2.C2050h
            if (r6 == 0) goto L_0x003a
            r10.notifyItemChanged(r4)
        L_0x003a:
            r4 = r5
            goto L_0x0021
        L_0x003c:
            boolean r4 = r3 instanceof M1.r.g
            r5 = 0
            if (r4 == 0) goto L_0x007c
            M1.r$g r3 = (M1.r.g) r3
            M1.r$f r4 = r3.m()
            java.util.ArrayList r4 = r4.b()
            int r6 = r4.size()
            r7 = 0
        L_0x0050:
            if (r7 >= r6) goto L_0x0066
            java.lang.Object r8 = r4.get(r7)
            int r7 = r7 + 1
            r9 = r8
            g2.h r9 = (g2.C2050h) r9
            java.lang.String r9 = r9.Q()
            boolean r9 = kotlin.jvm.internal.m.a(r9, r11)
            if (r9 == 0) goto L_0x0050
            r5 = r8
        L_0x0066:
            g2.h r5 = (g2.C2050h) r5
            M1.r$f r4 = r3.m()
            java.util.ArrayList r4 = r4.b()
            int r4 = S2.C1601o.K(r4, r5)
            M1.r$f r3 = r3.m()
            r3.notifyItemChanged(r4)
            goto L_0x00c2
        L_0x007c:
            boolean r4 = r3 instanceof M1.r.d
            if (r4 == 0) goto L_0x00bb
            M1.r$d r3 = (M1.r.d) r3
            M1.r$c r4 = r3.m()
            java.util.ArrayList r4 = r4.b()
            int r6 = r4.size()
            r7 = 0
        L_0x008f:
            if (r7 >= r6) goto L_0x00a5
            java.lang.Object r8 = r4.get(r7)
            int r7 = r7 + 1
            r9 = r8
            g2.h r9 = (g2.C2050h) r9
            java.lang.String r9 = r9.Q()
            boolean r9 = kotlin.jvm.internal.m.a(r9, r11)
            if (r9 == 0) goto L_0x008f
            r5 = r8
        L_0x00a5:
            g2.h r5 = (g2.C2050h) r5
            M1.r$c r4 = r3.m()
            java.util.ArrayList r4 = r4.b()
            int r4 = S2.C1601o.K(r4, r5)
            M1.r$c r3 = r3.m()
            r3.notifyItemChanged(r4)
            goto L_0x00c2
        L_0x00bb:
            boolean r3 = r3 instanceof x2.M0
            if (r3 == 0) goto L_0x00c2
            r10.notifyItemChanged(r2)
        L_0x00c2:
            int r2 = r2 + 1
            goto L_0x0010
        L_0x00c6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: M1.r.d(java.lang.String, androidx.recyclerview.widget.RecyclerView):void");
    }

    public int getItemCount() {
        return this.f7679c.size() + (this.f7680d ? 1 : 0);
    }

    public int getItemViewType(int i4) {
        if (i4 == this.f7679c.size()) {
            return 6;
        }
        return ((b) this.f7679c.get(i4)).b();
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i4) {
        m.e(viewHolder, "holder");
        if (viewHolder instanceof e) {
            Object a5 = ((b) this.f7679c.get(i4)).a();
            m.c(a5, "null cannot be cast to non-null type com.uptodown.models.AppInfo");
            ((e) viewHolder).m((C2050h) a5);
        } else if (viewHolder instanceof g) {
            Object a6 = ((b) this.f7679c.get(i4)).a();
            m.c(a6, "null cannot be cast to non-null type java.util.ArrayList<com.uptodown.models.AppInfo>");
            ((g) viewHolder).l((ArrayList) a6);
        } else if (viewHolder instanceof d) {
            Object a7 = ((b) this.f7679c.get(i4)).a();
            m.c(a7, "null cannot be cast to non-null type java.util.ArrayList<com.uptodown.models.AppInfo>");
            ((d) viewHolder).l((ArrayList) a7);
        } else if (viewHolder instanceof M0) {
            Object a8 = ((b) this.f7679c.get(i4)).a();
            m.c(a8, "null cannot be cast to non-null type com.uptodown.models.AppInfo");
            ((M0) viewHolder).m((C2050h) a8, i4);
        } else if (viewHolder instanceof C2407z0) {
            ((C2407z0) viewHolder).a();
        }
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i4) {
        m.e(viewGroup, "parent");
        switch (i4) {
            case 1:
                Z c5 = Z.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
                m.d(c5, "inflate(...)");
                C2013d dVar = this.f7677a;
                Context context = viewGroup.getContext();
                m.d(context, "getContext(...)");
                return new e(this, c5, dVar, context);
            case 2:
                C1654a0 c6 = C1654a0.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
                m.d(c6, "inflate(...)");
                C2013d dVar2 = this.f7677a;
                Context context2 = viewGroup.getContext();
                m.d(context2, "getContext(...)");
                return new g(this, c6, dVar2, context2);
            case 3:
                Y c7 = Y.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
                m.d(c7, "inflate(...)");
                C2013d dVar3 = this.f7677a;
                Context context3 = viewGroup.getContext();
                m.d(context3, "getContext(...)");
                return new d(this, c7, dVar3, context3, this.f7678b);
            case 4:
                View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.title_organization_apps, viewGroup, false);
                m.b(inflate);
                String string = viewGroup.getContext().getString(R.string.organization_more_apps_title, new Object[]{this.f7678b});
                m.d(string, "getString(...)");
                return new C2407z0(inflate, string);
            case 5:
                View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.app_info_vertical_top_item, viewGroup, false);
                m.b(inflate2);
                return new M0(inflate2, this.f7677a, (C2010a) null);
            case 6:
                View inflate3 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pb_loading_more_content, viewGroup, false);
                m.b(inflate3);
                return new N(inflate3);
            default:
                throw new IllegalArgumentException("viewType unknown");
        }
    }
}
