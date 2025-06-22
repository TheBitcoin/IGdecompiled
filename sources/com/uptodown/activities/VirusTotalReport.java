package com.uptodown.activities;

import J1.e6;
import J1.f6;
import J1.g6;
import J1.h6;
import J1.i6;
import N1.k;
import R2.g;
import R2.h;
import R2.k;
import R2.n;
import R2.s;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import c2.d1;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.W;
import d3.p;
import g2.C2048f;
import g2.C2050h;
import g2.C2059q;
import g2.C2064w;
import g2.K;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.D;
import kotlin.jvm.internal.F;
import kotlin.jvm.internal.m;
import o3.C1001s0;
import o3.J;
import o3.L;
import o3.Y;
import r3.C1036f;
import r3.I;
import r3.t;
import u2.E;
import u2.q;

public final class VirusTotalReport extends C1826a {

    /* renamed from: L  reason: collision with root package name */
    public static final a f18634L = new a((C2103g) null);

    /* renamed from: J  reason: collision with root package name */
    private final g f18635J = h.a(new e6(this));

    /* renamed from: K  reason: collision with root package name */
    private final g f18636K = new ViewModelLazy(D.b(W.class), new d(this), new c(this), new e((d3.a) null, this));

    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        private a() {
        }
    }

    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f18637a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ VirusTotalReport f18638b;

        static final class a implements C1036f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ VirusTotalReport f18639a;

            a(VirusTotalReport virusTotalReport) {
                this.f18639a = virusTotalReport;
            }

            /* renamed from: b */
            public final Object emit(E e5, V2.d dVar) {
                if (e5 instanceof E.a) {
                    this.f18639a.l3().f10373k.setVisibility(0);
                } else if (e5 instanceof E.c) {
                    if (((W.a) ((E.c) e5).a()).a() != null) {
                        this.f18639a.u3();
                        this.f18639a.v3();
                        this.f18639a.w3();
                    } else {
                        this.f18639a.l3().f10378p.setVisibility(8);
                        this.f18639a.l3().f10384v.setVisibility(0);
                        this.f18639a.l3().f10373k.setVisibility(8);
                    }
                } else if (!(e5 instanceof E.b)) {
                    throw new k();
                }
                return s.f8222a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(VirusTotalReport virusTotalReport, V2.d dVar) {
            super(2, dVar);
            this.f18638b = virusTotalReport;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new b(this.f18638b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f18637a;
            if (i4 == 0) {
                n.b(obj);
                I e5 = this.f18638b.o3().e();
                a aVar = new a(this.f18638b);
                this.f18637a = 1;
                if (e5.collect(aVar, this) == c5) {
                    return c5;
                }
            } else if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                n.b(obj);
            }
            throw new R2.d();
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((b) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public static final class c extends kotlin.jvm.internal.n implements d3.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f18640a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(ComponentActivity componentActivity) {
            super(0);
            this.f18640a = componentActivity;
        }

        public final ViewModelProvider.Factory invoke() {
            return this.f18640a.getDefaultViewModelProviderFactory();
        }
    }

    public static final class d extends kotlin.jvm.internal.n implements d3.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f18641a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(ComponentActivity componentActivity) {
            super(0);
            this.f18641a = componentActivity;
        }

        public final ViewModelStore invoke() {
            return this.f18641a.getViewModelStore();
        }
    }

    public static final class e extends kotlin.jvm.internal.n implements d3.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d3.a f18642a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f18643b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(d3.a aVar, ComponentActivity componentActivity) {
            super(0);
            this.f18642a = aVar;
            this.f18643b = componentActivity;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
            r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0.invoke();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final androidx.lifecycle.viewmodel.CreationExtras invoke() {
            /*
                r1 = this;
                d3.a r0 = r1.f18642a
                if (r0 == 0) goto L_0x000e
                java.lang.Object r0 = r0.invoke()
                androidx.lifecycle.viewmodel.CreationExtras r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0
                if (r0 != 0) goto L_0x000d
                goto L_0x000e
            L_0x000d:
                return r0
            L_0x000e:
                androidx.activity.ComponentActivity r0 = r1.f18643b
                androidx.lifecycle.viewmodel.CreationExtras r0 = r0.getDefaultViewModelCreationExtras()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.VirusTotalReport.e.invoke():androidx.lifecycle.viewmodel.CreationExtras");
        }
    }

    /* access modifiers changed from: private */
    public static final d1 k3(VirusTotalReport virusTotalReport) {
        return d1.c(virusTotalReport.getLayoutInflater());
    }

    /* access modifiers changed from: private */
    public final d1 l3() {
        return (d1) this.f18635J.getValue();
    }

    private final String m3() {
        F f4 = F.f20971a;
        String string = getString(R.string.vt_report_not_avaialable);
        m.d(string, "getString(...)");
        String format = String.format(string, Arrays.copyOf(new Object[]{getString(R.string.privacy_policies), getString(R.string.is_uptodown_safe)}, 2));
        m.d(format, "format(...)");
        String string2 = getString(R.string.app_technical_data_avaialable_at_utd_description);
        m.d(string2, "getString(...)");
        String format2 = String.format(string2, Arrays.copyOf(new Object[]{getString(R.string.app_technical_data_avaialable_at_utd), "packagename"}, 2));
        m.d(format2, "format(...)");
        return format + format2;
    }

    private final void n3() {
        W o32 = o3();
        Object value = o3().c().getValue();
        m.b(value);
        o32.b(this, ((C2050h) value).z(), ((Number) o3().f().getValue()).longValue(), ((Boolean) o3().i().getValue()).booleanValue());
    }

    /* access modifiers changed from: private */
    public final W o3() {
        return (W) this.f18636K.getValue();
    }

    private final void p3() {
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.core_vector_back);
        if (drawable != null) {
            l3().f10379q.setNavigationIcon(drawable);
            l3().f10379q.setNavigationContentDescription((CharSequence) getString(R.string.back));
        }
        l3().f10379q.setNavigationOnClickListener(new g6(this));
        TextView textView = l3().f10361F;
        k.a aVar = N1.k.f7778g;
        textView.setTypeface(aVar.w());
        if (o3().c().getValue() != null) {
            Object value = o3().c().getValue();
            m.b(value);
            String F4 = ((C2050h) value).F();
            if (F4 == null || F4.length() == 0) {
                l3().f10364b.f9762b.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.vector_app_icon_placeholder));
            } else {
                com.squareup.picasso.s h4 = com.squareup.picasso.s.h();
                Object value2 = o3().c().getValue();
                m.b(value2);
                h4.l(((C2050h) value2).F()).n(UptodownApp.f17422D.i0(this)).i(l3().f10364b.f9762b);
            }
        } else if (o3().d().getValue() != null) {
            u2.F f4 = u2.F.f21886a;
            Object value3 = o3().d().getValue();
            m.b(value3);
            l3().f10364b.f9762b.setImageDrawable(f4.k(this, ((C2048f) value3).o()));
        }
        l3().f10364b.f9763c.setTypeface(aVar.w());
        if (o3().c().getValue() != null) {
            TextView textView2 = l3().f10364b.f9763c;
            Object value4 = o3().c().getValue();
            m.b(value4);
            textView2.setText(((C2050h) value4).L());
        } else if (o3().d().getValue() != null) {
            TextView textView3 = l3().f10364b.f9763c;
            Object value5 = o3().d().getValue();
            m.b(value5);
            textView3.setText(((C2048f) value5).m());
        }
        l3().f10364b.f9764d.setTypeface(aVar.x());
        CharSequence charSequence = (CharSequence) o3().g().getValue();
        if (charSequence != null && charSequence.length() != 0) {
            l3().f10364b.f9764d.setText((CharSequence) o3().g().getValue());
        } else if (o3().c().getValue() != null) {
            TextView textView4 = l3().f10364b.f9764d;
            Object value6 = o3().c().getValue();
            m.b(value6);
            textView4.setText(((C2050h) value6).w0());
        } else if (o3().d().getValue() != null) {
            TextView textView5 = l3().f10364b.f9764d;
            Object value7 = o3().d().getValue();
            m.b(value7);
            textView5.setText(((C2048f) value7).B());
        }
        l3().f10381s.setTypeface(aVar.x());
        l3().f10380r.setTypeface(aVar.w());
        l3().f10380r.setOnClickListener(new h6(this));
        l3().f10358C.setTypeface(aVar.x());
        l3().f10357B.setTypeface(aVar.w());
        l3().f10360E.setTypeface(aVar.x());
        l3().f10359D.setTypeface(aVar.w());
        l3().f10387y.setTypeface(aVar.x());
        l3().f10386x.setTypeface(aVar.x());
        l3().f10385w.setTypeface(aVar.x());
        l3().f10362G.setTypeface(aVar.x());
        l3().f10384v.setTypeface(aVar.x());
        l3().f10373k.setOnClickListener(new i6());
    }

    /* access modifiers changed from: private */
    public static final void q3(VirusTotalReport virusTotalReport, View view) {
        virusTotalReport.getOnBackPressedDispatcher().onBackPressed();
    }

    /* access modifiers changed from: private */
    public static final void r3(VirusTotalReport virusTotalReport, View view) {
        if (virusTotalReport.o3().h().getValue() != null) {
            Object value = virusTotalReport.o3().h().getValue();
            m.b(value);
            virusTotalReport.F2(((K) value).f());
        }
    }

    /* access modifiers changed from: private */
    public static final void s3(View view) {
    }

    /* access modifiers changed from: private */
    public static final void t3(VirusTotalReport virusTotalReport, View view) {
        q qVar = new q();
        String string = virusTotalReport.getString(R.string.url_is_utd_safe);
        m.d(string, "getString(...)");
        qVar.q(virusTotalReport, string, (String) null);
    }

    /* access modifiers changed from: private */
    public final void u3() {
        String str;
        String str2;
        String str3;
        K k4 = (K) o3().h().getValue();
        String str4 = null;
        if (k4 != null) {
            str = k4.f();
        } else {
            str = null;
        }
        if (str == null || str.length() == 0) {
            C2050h hVar = (C2050h) o3().c().getValue();
            if (hVar != null) {
                str3 = hVar.i0();
            } else {
                str3 = null;
            }
            if (str3 == null || str3.length() == 0) {
                l3().f10376n.setVisibility(8);
            } else {
                TextView textView = l3().f10358C;
                Object value = o3().c().getValue();
                m.b(value);
                textView.setText(((C2050h) value).i0());
            }
        } else {
            TextView textView2 = l3().f10358C;
            Object value2 = o3().h().getValue();
            m.b(value2);
            textView2.setText(((K) value2).f());
        }
        C2050h hVar2 = (C2050h) o3().c().getValue();
        if (hVar2 != null) {
            str2 = hVar2.J();
        } else {
            str2 = null;
        }
        if (str2 == null || str2.length() == 0) {
            TextView textView3 = l3().f10360E;
            C2048f fVar = (C2048f) o3().d().getValue();
            if (fVar != null) {
                str4 = fVar.k();
            }
            textView3.setText(str4);
        } else {
            TextView textView4 = l3().f10360E;
            C2050h hVar3 = (C2050h) o3().c().getValue();
            if (hVar3 != null) {
                str4 = hVar3.J();
            }
            textView4.setText(str4);
        }
        l3().f10373k.setVisibility(8);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0125, code lost:
        if (r2.size() > 0) goto L_0x013b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void v3() {
        /*
            r8 = this;
            r0 = 0
            com.uptodown.activities.W r1 = r8.o3()
            r3.t r1 = r1.h()
            java.lang.Object r1 = r1.getValue()
            r2 = 2131951893(0x7f130115, float:1.9540213E38)
            java.lang.String r3 = "format(...)"
            r4 = 1
            java.lang.String r5 = "getString(...)"
            r6 = 2131952829(0x7f1304bd, float:1.9542112E38)
            r7 = 2131952831(0x7f1304bf, float:1.9542116E38)
            if (r1 == 0) goto L_0x014e
            kotlin.jvm.internal.F r1 = kotlin.jvm.internal.F.f20971a
            java.lang.String r1 = r8.getString(r6)
            kotlin.jvm.internal.m.d(r1, r5)
            com.uptodown.activities.W r5 = r8.o3()
            r3.t r5 = r5.h()
            java.lang.Object r5 = r5.getValue()
            kotlin.jvm.internal.m.b(r5)
            g2.K r5 = (g2.K) r5
            int r5 = r5.e()
            java.lang.String r5 = java.lang.String.valueOf(r5)
            java.lang.Object[] r6 = new java.lang.Object[r4]
            r6[r0] = r5
            java.lang.Object[] r5 = java.util.Arrays.copyOf(r6, r4)
            java.lang.String r1 = java.lang.String.format(r1, r5)
            kotlin.jvm.internal.m.d(r1, r3)
            c2.d1 r3 = r8.l3()
            android.widget.TextView r3 = r3.f10356A
            N1.k$a r5 = N1.k.f7778g
            android.graphics.Typeface r5 = r5.w()
            r3.setTypeface(r5)
            c2.d1 r3 = r8.l3()
            android.widget.TextView r3 = r3.f10356A
            com.uptodown.activities.W r5 = r8.o3()
            r3.t r5 = r5.h()
            java.lang.Object r5 = r5.getValue()
            kotlin.jvm.internal.m.b(r5)
            g2.K r5 = (g2.K) r5
            int r5 = r5.d()
            java.lang.String r5 = java.lang.String.valueOf(r5)
            r3.setText(r5)
            com.uptodown.activities.W r3 = r8.o3()
            r3.t r3 = r3.h()
            java.lang.Object r3 = r3.getValue()
            kotlin.jvm.internal.m.b(r3)
            g2.K r3 = (g2.K) r3
            java.lang.String r3 = r3.c()
            if (r3 == 0) goto L_0x00c4
            int r3 = r3.length()
            if (r3 != 0) goto L_0x009d
            goto L_0x00c4
        L_0x009d:
            c2.d1 r2 = r8.l3()
            android.widget.TextView r2 = r2.f10382t
            com.uptodown.activities.W r3 = r8.o3()
            r3.t r3 = r3.h()
            java.lang.Object r3 = r3.getValue()
            kotlin.jvm.internal.m.b(r3)
            g2.K r3 = (g2.K) r3
            java.lang.String r3 = r3.c()
            java.lang.Object[] r4 = new java.lang.Object[r4]
            r4[r0] = r3
            java.lang.String r3 = r8.getString(r7, r4)
            r2.setText(r3)
            goto L_0x00d9
        L_0x00c4:
            c2.d1 r3 = r8.l3()
            android.widget.TextView r3 = r3.f10382t
            java.lang.String r2 = r8.getString(r2)
            java.lang.Object[] r4 = new java.lang.Object[r4]
            r4[r0] = r2
            java.lang.String r2 = r8.getString(r7, r4)
            r3.setText(r2)
        L_0x00d9:
            com.uptodown.activities.W r2 = r8.o3()
            r3.t r2 = r2.h()
            java.lang.Object r2 = r2.getValue()
            kotlin.jvm.internal.m.b(r2)
            g2.K r2 = (g2.K) r2
            int r2 = r2.d()
            r3 = 8
            if (r2 > 0) goto L_0x013b
            com.uptodown.activities.W r2 = r8.o3()
            r3.t r2 = r2.h()
            java.lang.Object r2 = r2.getValue()
            kotlin.jvm.internal.m.b(r2)
            g2.K r2 = (g2.K) r2
            java.util.ArrayList r2 = r2.b()
            if (r2 == 0) goto L_0x0128
            com.uptodown.activities.W r2 = r8.o3()
            r3.t r2 = r2.h()
            java.lang.Object r2 = r2.getValue()
            kotlin.jvm.internal.m.b(r2)
            g2.K r2 = (g2.K) r2
            java.util.ArrayList r2 = r2.b()
            kotlin.jvm.internal.m.b(r2)
            int r2 = r2.size()
            if (r2 <= 0) goto L_0x0128
            goto L_0x013b
        L_0x0128:
            c2.d1 r2 = r8.l3()
            android.widget.RelativeLayout r2 = r2.f10375m
            r2.setVisibility(r3)
            c2.d1 r2 = r8.l3()
            android.widget.RelativeLayout r2 = r2.f10374l
            r2.setVisibility(r0)
            goto L_0x0182
        L_0x013b:
            c2.d1 r2 = r8.l3()
            android.widget.RelativeLayout r2 = r2.f10375m
            r2.setVisibility(r0)
            c2.d1 r0 = r8.l3()
            android.widget.RelativeLayout r0 = r0.f10374l
            r0.setVisibility(r3)
            goto L_0x0182
        L_0x014e:
            kotlin.jvm.internal.F r1 = kotlin.jvm.internal.F.f20971a
            java.lang.String r1 = r8.getString(r6)
            kotlin.jvm.internal.m.d(r1, r5)
            r5 = 2131952870(0x7f1304e6, float:1.9542195E38)
            java.lang.String r5 = r8.getString(r5)
            java.lang.Object[] r6 = new java.lang.Object[r4]
            r6[r0] = r5
            java.lang.Object[] r5 = java.util.Arrays.copyOf(r6, r4)
            java.lang.String r1 = java.lang.String.format(r1, r5)
            kotlin.jvm.internal.m.d(r1, r3)
            c2.d1 r3 = r8.l3()
            android.widget.TextView r3 = r3.f10382t
            java.lang.String r2 = r8.getString(r2)
            java.lang.Object[] r4 = new java.lang.Object[r4]
            r4[r0] = r2
            java.lang.String r0 = r8.getString(r7, r4)
            r3.setText(r0)
        L_0x0182:
            u2.F r0 = u2.F.f21886a
            android.text.Spanned r0 = r0.d(r1)
            c2.d1 r1 = r8.l3()
            android.widget.TextView r1 = r1.f10383u
            N1.k$a r2 = N1.k.f7778g
            android.graphics.Typeface r3 = r2.x()
            r1.setTypeface(r3)
            c2.d1 r1 = r8.l3()
            android.widget.TextView r1 = r1.f10383u
            r1.setText(r0)
            c2.d1 r0 = r8.l3()
            android.widget.TextView r0 = r0.f10382t
            android.graphics.Typeface r1 = r2.x()
            r0.setTypeface(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.VirusTotalReport.v3():void");
    }

    /* access modifiers changed from: private */
    public final void w3() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, (int) getResources().getDimension(R.dimen.margin_s), 0, 0);
        if (o3().h().getValue() != null) {
            Object value = o3().h().getValue();
            m.b(value);
            if (((K) value).b() != null) {
                Object value2 = o3().h().getValue();
                m.b(value2);
                ArrayList b5 = ((K) value2).b();
                m.b(b5);
                if (b5.size() > 0) {
                    Object value3 = o3().h().getValue();
                    m.b(value3);
                    ArrayList b6 = ((K) value3).b();
                    m.b(b6);
                    int size = b6.size();
                    for (int i4 = 0; i4 < size; i4++) {
                        View inflate = getLayoutInflater().inflate(R.layout.scan_positive, l3().f10371i, false);
                        m.c(inflate, "null cannot be cast to non-null type android.widget.RelativeLayout");
                        RelativeLayout relativeLayout = (RelativeLayout) inflate;
                        relativeLayout.setLayoutParams(layoutParams);
                        Object value4 = o3().h().getValue();
                        m.b(value4);
                        ArrayList b7 = ((K) value4).b();
                        m.b(b7);
                        ((TextView) relativeLayout.findViewById(R.id.tv_antivirus_name)).setText(((C2064w) b7.get(i4)).b());
                        Object value5 = o3().h().getValue();
                        m.b(value5);
                        ArrayList b8 = ((K) value5).b();
                        m.b(b8);
                        ((TextView) relativeLayout.findViewById(R.id.tv_virus_name)).setText(((C2064w) b8.get(i4)).c());
                        l3().f10371i.addView(relativeLayout);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        Parcelable parcelable;
        Parcelable parcelable2;
        Parcelable parcelable3;
        super.onCreate(bundle);
        setContentView((View) l3().getRoot());
        Intent intent = getIntent();
        if (intent != null) {
            Bundle extras = intent.getExtras();
            if (extras != null && extras.containsKey("appInfo")) {
                t c5 = o3().c();
                if (Build.VERSION.SDK_INT >= 33) {
                    parcelable3 = (Parcelable) extras.getParcelable("appInfo", C2050h.class);
                } else {
                    parcelable3 = extras.getParcelable("appInfo");
                }
                c5.setValue(parcelable3);
            }
            if (extras != null && extras.containsKey("app_selected")) {
                t d5 = o3().d();
                if (Build.VERSION.SDK_INT >= 33) {
                    parcelable2 = (Parcelable) extras.getParcelable("app_selected", C2048f.class);
                } else {
                    parcelable2 = extras.getParcelable("app_selected");
                }
                d5.setValue(parcelable2);
            }
            if (extras != null && extras.containsKey("old_version")) {
                o3().g().setValue(extras.getString("old_version"));
            }
            if (extras != null && extras.containsKey("oldVersionId")) {
                o3().i().setValue(Boolean.TRUE);
                o3().f().setValue(Long.valueOf(extras.getLong("oldVersionId")));
            }
            if (extras != null && extras.containsKey("appReportVT")) {
                t h4 = o3().h();
                if (Build.VERSION.SDK_INT >= 33) {
                    parcelable = (Parcelable) extras.getParcelable("appReportVT", K.class);
                } else {
                    parcelable = extras.getParcelable("appReportVT");
                }
                h4.setValue(parcelable);
            }
            if (extras != null && extras.containsKey("isVirusTotalReportAvaialable")) {
                o3().j().setValue(Boolean.valueOf(extras.getBoolean("isVirusTotalReportAvaialable")));
            }
        }
        p3();
        if (o3().h().getValue() != null) {
            v3();
            w3();
            u3();
        } else if (!((Boolean) o3().j().getValue()).booleanValue()) {
            l3().f10372j.setVisibility(8);
            l3().f10388z.setVisibility(0);
            l3().f10388z.setTypeface(N1.k.f7778g.x());
            l3().f10388z.setText(C2059q.f20700f.h(this, m3()));
            l3().f10388z.setOnClickListener(new f6(this));
            u3();
        } else {
            n3();
        }
        C1001s0 unused = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), Y.c(), (L) null, new b(this, (V2.d) null), 2, (Object) null);
    }
}
