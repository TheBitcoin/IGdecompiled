package com.uptodown.activities;

import J1.A;
import J1.B;
import J1.C1443t;
import J1.C1450u;
import J1.C1457v;
import J1.C1464w;
import J1.C1471x;
import J1.C1478y;
import J1.C1485z;
import J1.D;
import J1.E;
import J1.G;
import J1.H;
import M1.C1543u;
import N1.k;
import O1.M0;
import R2.s;
import W1.C1610f;
import W1.G;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.inputmethod.InputMethodManager;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import b2.C1640l;
import c2.C1683p;
import c2.C1688s;
import c2.C1698x;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.core.view.WrapContentLinearLayoutManager;
import com.uptodown.workers.DownloadApkWorker;
import d3.a;
import f2.C2002A;
import f2.C2021l;
import f2.C2027s;
import f2.W;
import g2.C2039G;
import g2.C2050h;
import g2.C2054l;
import g2.C2059q;
import g2.C2060s;
import g2.K;
import g2.U;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.C;
import kotlin.jvm.internal.C2103g;
import o3.C0977g;
import o3.C1001s0;
import o3.E0;
import o3.J;
import o3.L;
import o3.Y;
import u2.F;
import u2.t;
import u2.w;
import u2.x;
import u2.y;
import u2.z;
import y2.g;

/* renamed from: com.uptodown.activities.a  reason: case insensitive filesystem */
public abstract class C1826a extends M0 {

    /* renamed from: I  reason: collision with root package name */
    public static final C0232a f18700I = new C0232a((C2103g) null);

    /* renamed from: A  reason: collision with root package name */
    private boolean f18701A;

    /* renamed from: B  reason: collision with root package name */
    private RecyclerView f18702B;
    /* access modifiers changed from: private */

    /* renamed from: C  reason: collision with root package name */
    public C1543u f18703C;

    /* renamed from: D  reason: collision with root package name */
    private C2002A f18704D = new o(this);

    /* renamed from: E  reason: collision with root package name */
    private ArrayList f18705E = new ArrayList();

    /* renamed from: F  reason: collision with root package name */
    private ActivityResultLauncher f18706F;

    /* renamed from: G  reason: collision with root package name */
    private y2.g f18707G;

    /* renamed from: H  reason: collision with root package name */
    private RelativeLayout f18708H;

    /* renamed from: w  reason: collision with root package name */
    private x f18709w;

    /* renamed from: x  reason: collision with root package name */
    private AlertDialog f18710x;

    /* renamed from: y  reason: collision with root package name */
    private C2021l f18711y = new h(this);

    /* renamed from: z  reason: collision with root package name */
    private long f18712z;

    /* renamed from: com.uptodown.activities.a$a  reason: collision with other inner class name */
    public static final class C0232a {
        public /* synthetic */ C0232a(C2103g gVar) {
            this();
        }

        private C0232a() {
        }
    }

    /* renamed from: com.uptodown.activities.a$b */
    public final class b implements Runnable {
        public b() {
        }

        public void run() {
            C1826a aVar = C1826a.this;
            String string = aVar.getString(R.string.error_no_connection);
            kotlin.jvm.internal.m.d(string, "getString(...)");
            aVar.q0(string);
        }
    }

    /* renamed from: com.uptodown.activities.a$c */
    public static final class c extends ItemTouchHelper.SimpleCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C1826a f18714a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(C1826a aVar) {
            super(0, 8);
            this.f18714a = aVar;
        }

        public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
            kotlin.jvm.internal.m.e(recyclerView, "recyclerView");
            kotlin.jvm.internal.m.e(viewHolder, "viewHolder");
            kotlin.jvm.internal.m.e(viewHolder2, TypedValues.AttributesType.S_TARGET);
            return false;
        }

        public void onSwiped(RecyclerView.ViewHolder viewHolder, int i4) {
            kotlin.jvm.internal.m.e(viewHolder, "viewHolder");
            int absoluteAdapterPosition = viewHolder.getAbsoluteAdapterPosition();
            C1543u J12 = this.f18714a.f18703C;
            if (J12 != null) {
                J12.e(absoluteAdapterPosition);
            }
        }
    }

    /* renamed from: com.uptodown.activities.a$d */
    static final class d extends kotlin.coroutines.jvm.internal.l implements d3.p {

        /* renamed from: a  reason: collision with root package name */
        int f18715a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C1826a f18716b;

        /* renamed from: com.uptodown.activities.a$d$a  reason: collision with other inner class name */
        static final class C0233a extends kotlin.coroutines.jvm.internal.l implements d3.p {

            /* renamed from: a  reason: collision with root package name */
            int f18717a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C f18718b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ File f18719c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ C1826a f18720d;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0233a(C c5, File file, C1826a aVar, V2.d dVar) {
                super(2, dVar);
                this.f18718b = c5;
                this.f18719c = file;
                this.f18720d = aVar;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new C0233a(this.f18718b, this.f18719c, this.f18720d, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f18717a == 0) {
                    R2.n.b(obj);
                    if (this.f18718b.f20968a != null) {
                        C2054l lVar = new C2054l();
                        File file = this.f18719c;
                        kotlin.jvm.internal.m.b(file);
                        lVar.h(file.getAbsolutePath());
                        lVar.f(String.valueOf(this.f18719c.lastModified()));
                        this.f18720d.D2((String) this.f18718b.f20968a, lVar);
                    } else {
                        this.f18720d.B2();
                    }
                    this.f18720d.M2(true);
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((C0233a) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(C1826a aVar, V2.d dVar) {
            super(2, dVar);
            this.f18716b = aVar;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new d(this.f18716b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f18715a;
            if (i4 == 0) {
                R2.n.b(obj);
                C c6 = new C();
                File h4 = new w().h(this.f18716b);
                if (h4 != null) {
                    t a5 = t.f21927u.a(this.f18716b);
                    a5.a();
                    ArrayList c02 = a5.c0();
                    a5.i();
                    Iterator it = c02.iterator();
                    kotlin.jvm.internal.m.d(it, "iterator(...)");
                    while (true) {
                        if (!it.hasNext()) {
                            w wVar = new w();
                            String name = h4.getName();
                            kotlin.jvm.internal.m.d(name, "getName(...)");
                            c6.f20968a = wVar.i(name);
                            break;
                        }
                        Object next = it.next();
                        kotlin.jvm.internal.m.d(next, "next(...)");
                        C2054l lVar = (C2054l) next;
                        if (m3.m.p(lVar.e(), h4.getAbsolutePath(), true) && Long.parseLong(lVar.a()) == h4.lastModified()) {
                            break;
                        }
                    }
                }
                E0 c7 = Y.c();
                C0233a aVar = new C0233a(c6, h4, this.f18716b, (V2.d) null);
                this.f18715a = 1;
                if (C0977g.g(c7, aVar, this) == c5) {
                    return c5;
                }
            } else if (i4 == 1) {
                R2.n.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return s.f8222a;
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((d) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    /* renamed from: com.uptodown.activities.a$e */
    static final class e extends kotlin.coroutines.jvm.internal.l implements d3.p {

        /* renamed from: a  reason: collision with root package name */
        int f18721a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C1826a f18722b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f18723c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ a f18724d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ a f18725e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(C1826a aVar, String str, a aVar2, a aVar3, V2.d dVar) {
            super(2, dVar);
            this.f18722b = aVar;
            this.f18723c = str;
            this.f18724d = aVar2;
            this.f18725e = aVar3;
        }

        /* access modifiers changed from: private */
        public static final void k(a aVar, C1826a aVar2, View view) {
            aVar.invoke();
            aVar2.i2();
        }

        /* access modifiers changed from: private */
        public static final void l(a aVar, C1826a aVar2, View view) {
            aVar.invoke();
            aVar2.i2();
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new e(this.f18722b, this.f18723c, this.f18724d, this.f18725e, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f18721a == 0) {
                R2.n.b(obj);
                if (!this.f18722b.isFinishing()) {
                    this.f18722b.i2();
                    AlertDialog.Builder builder = new AlertDialog.Builder(this.f18722b);
                    C1683p c5 = C1683p.c(this.f18722b.getLayoutInflater());
                    kotlin.jvm.internal.m.d(c5, "inflate(...)");
                    String str = this.f18723c;
                    a aVar = this.f18724d;
                    C1826a aVar2 = this.f18722b;
                    a aVar3 = this.f18725e;
                    TextView textView = c5.f10696d;
                    k.a aVar4 = N1.k.f7778g;
                    textView.setTypeface(aVar4.x());
                    c5.f10696d.setText(str);
                    c5.f10697e.setTypeface(aVar4.w());
                    c5.f10697e.setOnClickListener(new C1827b(aVar, aVar2));
                    c5.f10695c.setTypeface(aVar4.w());
                    c5.f10695c.setOnClickListener(new C1828c(aVar3, aVar2));
                    builder.setCancelable(false);
                    builder.setView(c5.getRoot());
                    this.f18722b.J2(builder.create());
                    if (!this.f18722b.isFinishing() && this.f18722b.j2() != null) {
                        this.f18722b.W2();
                    }
                }
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((e) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    /* renamed from: com.uptodown.activities.a$f */
    public static final class f implements C2027s {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C1826a f18726a;

        f(C1826a aVar) {
            this.f18726a = aVar;
        }

        public void b(int i4) {
            C1826a aVar = this.f18726a;
            String string = aVar.getString(R.string.app_detail_not_found);
            kotlin.jvm.internal.m.d(string, "getString(...)");
            aVar.q0(string);
        }

        public void c(C2050h hVar) {
            kotlin.jvm.internal.m.e(hVar, "appInfo");
            this.f18726a.Z2(hVar);
        }
    }

    /* renamed from: com.uptodown.activities.a$g */
    static final class g extends kotlin.coroutines.jvm.internal.l implements d3.p {

        /* renamed from: a  reason: collision with root package name */
        int f18727a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C1826a f18728b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ K f18729c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ a f18730d;

        /* renamed from: com.uptodown.activities.a$g$a  reason: collision with other inner class name */
        public static final class C0234a extends ClickableSpan {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ C1826a f18731a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ K f18732b;

            C0234a(C1826a aVar, K k4) {
                this.f18731a = aVar;
                this.f18732b = k4;
            }

            public void onClick(View view) {
                kotlin.jvm.internal.m.e(view, "widget");
                this.f18731a.F2(this.f18732b.f());
            }

            public void updateDrawState(TextPaint textPaint) {
                kotlin.jvm.internal.m.e(textPaint, "ds");
                super.updateDrawState(textPaint);
                textPaint.setColor(ContextCompat.getColor(this.f18731a, R.color.main_blue));
                textPaint.setTypeface(N1.k.f7778g.w());
                textPaint.setUnderlineText(false);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(C1826a aVar, K k4, a aVar2, V2.d dVar) {
            super(2, dVar);
            this.f18728b = aVar;
            this.f18729c = k4;
            this.f18730d = aVar2;
        }

        /* access modifiers changed from: private */
        public static final CharSequence m(m3.h hVar) {
            return (CharSequence) hVar.a().get(1);
        }

        /* access modifiers changed from: private */
        public static final void n(a aVar, C1826a aVar2, View view) {
            aVar.invoke();
            aVar2.i2();
            UptodownApp.f17422D.v0(false);
        }

        /* access modifiers changed from: private */
        public static final void o(C1826a aVar, View view) {
            aVar.i2();
            UptodownApp.f17422D.v0(false);
        }

        /* access modifiers changed from: private */
        public static final void p(C1826a aVar, K k4, View view) {
            aVar.F2(k4.f());
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new g(this.f18728b, this.f18729c, this.f18730d, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f18727a == 0) {
                R2.n.b(obj);
                if (!this.f18728b.isFinishing()) {
                    this.f18728b.i2();
                    AlertDialog.Builder builder = new AlertDialog.Builder(this.f18728b);
                    C1688s c5 = C1688s.c(this.f18728b.getLayoutInflater());
                    kotlin.jvm.internal.m.d(c5, "inflate(...)");
                    C1826a aVar = this.f18728b;
                    K k4 = this.f18729c;
                    a aVar2 = this.f18730d;
                    c5.f10749f.setTypeface(N1.k.f7778g.x());
                    c5.f10749f.setText(aVar.getString(R.string.positives_detected_in_downloaded_file));
                    String obj2 = c5.f10749f.getText().toString();
                    List<C2059q> e5 = C2059q.f20700f.e(obj2, "\\[xx](.*?)\\[/xx]");
                    SpannableString spannableString = new SpannableString(new m3.j("\\[xx](.*?)\\[/xx]").f(obj2, new C1829d()));
                    for (C2059q qVar : e5) {
                        int L4 = m3.m.L(spannableString, qVar.d(), 0, false, 6, (Object) null);
                        int length = qVar.d().length() + L4;
                        if (L4 >= 0) {
                            spannableString.setSpan(new C0234a(aVar, k4), L4, length, 33);
                        }
                    }
                    c5.f10749f.setText(spannableString);
                    c5.f10749f.setMovementMethod(LinkMovementMethod.getInstance());
                    TextView textView = c5.f10751h;
                    k.a aVar3 = N1.k.f7778g;
                    textView.setTypeface(aVar3.w());
                    c5.f10751h.setText(String.valueOf(k4.d()));
                    c5.f10750g.setTypeface(aVar3.x());
                    TextView textView2 = c5.f10750g;
                    F f4 = F.f21886a;
                    kotlin.jvm.internal.F f5 = kotlin.jvm.internal.F.f20971a;
                    String string = aVar.getString(R.string.virustotal_report_msg);
                    kotlin.jvm.internal.m.d(string, "getString(...)");
                    String format = String.format(string, Arrays.copyOf(new Object[]{String.valueOf(k4.e())}, 1));
                    kotlin.jvm.internal.m.d(format, "format(...)");
                    textView2.setText(f4.d(format));
                    c5.f10748e.setTypeface(aVar3.x());
                    c5.f10748e.setText(aVar.getString(R.string.virustotal_report_previous_scan, new Object[]{k4.c()}));
                    c5.f10747d.setTypeface(aVar3.w());
                    c5.f10747d.setOnClickListener(new C1830e(aVar2, aVar));
                    c5.f10746c.setTypeface(aVar3.w());
                    c5.f10746c.setOnClickListener(new C1831f(aVar));
                    c5.f10745b.setOnClickListener(new C1832g(aVar, k4));
                    builder.setCancelable(false);
                    builder.setView(c5.getRoot());
                    this.f18728b.J2(builder.create());
                    if (!this.f18728b.isFinishing() && this.f18728b.j2() != null) {
                        this.f18728b.W2();
                    }
                }
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((g) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    /* renamed from: com.uptodown.activities.a$h */
    public static final class h implements C2021l {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C1826a f18733a;

        h(C1826a aVar) {
            this.f18733a = aVar;
        }
    }

    /* renamed from: com.uptodown.activities.a$i */
    public static final class i implements W {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C1826a f18734a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ File f18735b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f18736c;

        i(C1826a aVar, File file, String str) {
            this.f18734a = aVar;
            this.f18735b = file;
            this.f18736c = str;
        }

        /* access modifiers changed from: private */
        public static final s d(C1826a aVar, File file, String str) {
            aVar.t2(file, str);
            return s.f8222a;
        }

        public void a(K k4) {
            kotlin.jvm.internal.m.e(k4, "reportVT");
            if (k4.d() > 0) {
                C1826a aVar = this.f18734a;
                aVar.h2(k4, new G(aVar, this.f18735b, this.f18736c));
                return;
            }
            this.f18734a.t2(this.f18735b, this.f18736c);
        }

        public void b() {
            this.f18734a.t2(this.f18735b, this.f18736c);
        }
    }

    /* renamed from: com.uptodown.activities.a$j */
    public static final class j implements S1.m {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C1826a f18737a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ File f18738b;

        /* renamed from: com.uptodown.activities.a$j$a  reason: collision with other inner class name */
        public static final class C0235a implements S1.h {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ C1826a f18739a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ File f18740b;

            C0235a(C1826a aVar, File file) {
                this.f18739a = aVar;
                this.f18740b = file;
            }

            public void a() {
                this.f18739a.R2(this.f18740b);
            }

            public void b(String str) {
                if (str != null) {
                    this.f18739a.U1(str);
                    return;
                }
                C1826a aVar = this.f18739a;
                String string = aVar.getString(R.string.error_generico);
                kotlin.jvm.internal.m.d(string, "getString(...)");
                aVar.U1(string);
            }
        }

        j(C1826a aVar, File file) {
            this.f18737a = aVar;
            this.f18738b = file;
        }

        public void a(File file, ArrayList arrayList) {
            kotlin.jvm.internal.m.e(file, "fileZipped");
            kotlin.jvm.internal.m.e(arrayList, "files");
            this.f18737a.P2(file);
            C0235a aVar = new C0235a(this.f18737a, file);
            W1.C c5 = new W1.C(this.f18737a);
            c5.x(arrayList);
            new W1.j(this.f18737a, aVar).w(c5.y(), false);
            this.f18737a.z2(file);
        }

        public void b(int i4) {
            this.f18737a.S2(this.f18738b, i4);
        }

        public void c(File file) {
        }

        public void d(File file) {
        }

        public void e() {
            C1826a aVar = this.f18737a;
            String string = aVar.getString(R.string.msg_install_from_unknown_source, new Object[]{aVar.getString(R.string.app_name)});
            kotlin.jvm.internal.m.d(string, "getString(...)");
            this.f18737a.U1(string);
        }

        public void f() {
            C1826a aVar = this.f18737a;
            String string = aVar.getString(R.string.core_kill_this_app, new Object[]{aVar.getString(R.string.app_name)});
            kotlin.jvm.internal.m.d(string, "getString(...)");
            this.f18737a.U1(string);
        }

        public void g() {
            this.f18737a.S2(this.f18738b, 0);
        }

        public void h() {
            String string = this.f18737a.getString(R.string.error_unzipping);
            kotlin.jvm.internal.m.d(string, "getString(...)");
            this.f18737a.U1(string);
        }

        public void i() {
            this.f18737a.J();
        }
    }

    /* renamed from: com.uptodown.activities.a$k */
    static final class k extends kotlin.coroutines.jvm.internal.l implements d3.p {

        /* renamed from: a  reason: collision with root package name */
        int f18741a;

        /* renamed from: b  reason: collision with root package name */
        int f18742b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ long f18743c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ C1826a f18744d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ int f18745e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(long j4, C1826a aVar, int i4, V2.d dVar) {
            super(2, dVar);
            this.f18743c = j4;
            this.f18744d = aVar;
            this.f18745e = i4;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new k(this.f18743c, this.f18744d, this.f18745e, dVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:0x004d, code lost:
            if (o3.U.b(r4, r7) == r0) goto L_0x004f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x004f, code lost:
            return r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x002d, code lost:
            if (o3.U.b(r5, r7) == r0) goto L_0x004f;
         */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x0041  */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x0059  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = W2.b.c()
                int r1 = r7.f18742b
                r2 = 2
                java.lang.String r3 = "downloadApkWorker"
                r4 = 1
                if (r1 == 0) goto L_0x0022
                if (r1 == r4) goto L_0x001e
                if (r1 != r2) goto L_0x0016
                int r1 = r7.f18741a
                R2.n.b(r8)
                goto L_0x0050
            L_0x0016:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L_0x001e:
                R2.n.b(r8)
                goto L_0x0030
            L_0x0022:
                R2.n.b(r8)
                long r5 = r7.f18743c
                r7.f18742b = r4
                java.lang.Object r8 = o3.U.b(r5, r7)
                if (r8 != r0) goto L_0x0030
                goto L_0x004f
            L_0x0030:
                com.uptodown.UptodownApp$a r8 = com.uptodown.UptodownApp.f17422D
                com.uptodown.activities.a r1 = r7.f18744d
                androidx.work.WorkInfo$State r8 = r8.G(r3, r1)
                r1 = 0
            L_0x0039:
                int r4 = r7.f18745e
                if (r1 >= r4) goto L_0x0059
                androidx.work.WorkInfo$State r4 = androidx.work.WorkInfo.State.ENQUEUED
                if (r8 != r4) goto L_0x0059
                int r1 = r1 + 1
                long r4 = r7.f18743c
                r7.f18741a = r1
                r7.f18742b = r2
                java.lang.Object r8 = o3.U.b(r4, r7)
                if (r8 != r0) goto L_0x0050
            L_0x004f:
                return r0
            L_0x0050:
                com.uptodown.UptodownApp$a r8 = com.uptodown.UptodownApp.f17422D
                com.uptodown.activities.a r4 = r7.f18744d
                androidx.work.WorkInfo$State r8 = r8.G(r3, r4)
                goto L_0x0039
            L_0x0059:
                com.uptodown.UptodownApp$a r8 = com.uptodown.UptodownApp.f17422D
                com.uptodown.activities.a r0 = r7.f18744d
                boolean r8 = r8.U(r3, r0)
                if (r8 != 0) goto L_0x008d
                u2.q r8 = new u2.q
                r8.<init>()
                com.uptodown.activities.a r0 = r7.f18744d
                java.util.ArrayList r8 = r8.i(r0)
                boolean r0 = r8.isEmpty()
                if (r0 != 0) goto L_0x008d
                com.uptodown.activities.a r0 = r7.f18744d
                java.lang.Object r1 = S2.C1601o.H(r8)
                g2.s r1 = (g2.C2060s) r1
                int r1 = r1.q()
                java.lang.Object r8 = S2.C1601o.H(r8)
                g2.s r8 = (g2.C2060s) r8
                java.lang.String r8 = r8.i()
                r0.I2(r1, r8)
            L_0x008d:
                R2.s r8 = R2.s.f8222a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.C1826a.k.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((k) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    /* renamed from: com.uptodown.activities.a$l */
    public static final class l implements W {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C1826a f18746a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ File f18747b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f18748c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ boolean f18749d;

        l(C1826a aVar, File file, String str, boolean z4) {
            this.f18746a = aVar;
            this.f18747b = file;
            this.f18748c = str;
            this.f18749d = z4;
        }

        /* access modifiers changed from: private */
        public static final s d(C1826a aVar, File file, String str, boolean z4) {
            new N1.j(aVar).c(file, str, z4);
            aVar.z2(file);
            return s.f8222a;
        }

        public void a(K k4) {
            kotlin.jvm.internal.m.e(k4, "reportVT");
            if (k4.d() > 0) {
                C1826a aVar = this.f18746a;
                aVar.h2(k4, new H(aVar, this.f18747b, this.f18748c, this.f18749d));
                return;
            }
            new N1.j(this.f18746a).c(this.f18747b, this.f18748c, this.f18749d);
            this.f18746a.z2(this.f18747b);
        }

        public void b() {
            new N1.j(this.f18746a).c(this.f18747b, this.f18748c, this.f18749d);
            this.f18746a.z2(this.f18747b);
        }
    }

    /* renamed from: com.uptodown.activities.a$m */
    public static final class m implements C2027s {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C1826a f18750a;

        m(C1826a aVar) {
            this.f18750a = aVar;
        }

        public void b(int i4) {
        }

        public void c(C2050h hVar) {
            kotlin.jvm.internal.m.e(hVar, "appInfo");
            if (!this.f18750a.isFinishing()) {
                Intent intent = new Intent(this.f18750a, AppDetailActivity.class);
                intent.putExtra("appInfo", hVar);
                C1826a aVar = this.f18750a;
                aVar.startActivity(intent, UptodownApp.f17422D.a(aVar));
            }
        }
    }

    /* renamed from: com.uptodown.activities.a$n */
    public static final class n implements C2027s {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2054l f18751a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C1826a f18752b;

        n(C2054l lVar, C1826a aVar) {
            this.f18751a = lVar;
            this.f18752b = aVar;
        }

        public void b(int i4) {
            this.f18752b.B2();
        }

        public void c(C2050h hVar) {
            kotlin.jvm.internal.m.e(hVar, "appInfo");
            if (hVar.e() > 0) {
                UptodownApp.f17422D.u0(this.f18751a);
                if (this.f18751a != null) {
                    t a5 = t.f21927u.a(this.f18752b);
                    a5.a();
                    a5.L0(this.f18751a);
                    a5.i();
                }
                this.f18752b.A2(hVar);
                return;
            }
            this.f18752b.B2();
        }
    }

    /* renamed from: com.uptodown.activities.a$o */
    public static final class o implements C2002A {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C1826a f18753a;

        o(C1826a aVar) {
            this.f18753a = aVar;
        }

        public void a(C2039G g4) {
            kotlin.jvm.internal.m.e(g4, "preregister");
            this.f18753a.C2(g4.c());
            C1543u J12 = this.f18753a.f18703C;
            if (J12 != null) {
                J12.d(g4);
            }
        }

        public void b() {
            if (this.f18753a.n2().size() > 0) {
                Object remove = this.f18753a.n2().remove(0);
                kotlin.jvm.internal.m.d(remove, "removeAt(...)");
                this.f18753a.G2((C2039G) remove);
            }
        }
    }

    /* renamed from: com.uptodown.activities.a$p */
    public static final class p implements C2027s {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C1826a f18754a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2039G f18755b;

        p(C1826a aVar, C2039G g4) {
            this.f18754a = aVar;
            this.f18755b = g4;
        }

        public void b(int i4) {
            if (i4 == 404) {
                t a5 = t.f21927u.a(this.f18754a);
                a5.a();
                a5.k1(this.f18755b.c());
                a5.i();
            }
        }

        public void c(C2050h hVar) {
            kotlin.jvm.internal.m.e(hVar, "appInfo");
            C2039G g4 = new C2039G();
            g4.k(hVar.e());
            g4.n(hVar.L());
            g4.m(hVar.E());
            this.f18754a.L1(g4);
            t a5 = t.f21927u.a(this.f18754a);
            a5.a();
            a5.k1(g4.c());
            a5.i();
        }
    }

    /* renamed from: com.uptodown.activities.a$q */
    public static final class q implements g.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f18756a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C1826a f18757b;

        q(a aVar, C1826a aVar2) {
            this.f18756a = aVar;
            this.f18757b = aVar2;
        }

        public void a(C2050h hVar) {
            kotlin.jvm.internal.m.e(hVar, "appInfo");
            this.f18757b.Z2(hVar);
        }

        public void b(C2050h hVar) {
            kotlin.jvm.internal.m.e(hVar, "appInfo");
            this.f18756a.invoke();
        }
    }

    private final void M1() {
        new ItemTouchHelper(new c(this)).attachToRecyclerView(this.f18702B);
    }

    /* access modifiers changed from: private */
    public static final void Q1(a aVar, C1826a aVar2, View view) {
        aVar.invoke();
        aVar2.i2();
    }

    /* access modifiers changed from: private */
    public static final void R1(C1826a aVar, View view) {
        aVar.i2();
    }

    /* access modifiers changed from: private */
    public static final s T1(C1826a aVar, File file) {
        aVar.x2(file, (String) null);
        return s.f8222a;
    }

    /* access modifiers changed from: private */
    public static final void V1(C1826a aVar, View view) {
        aVar.i2();
    }

    /* access modifiers changed from: private */
    public static final s X1(C1826a aVar, long j4) {
        Context applicationContext = aVar.getApplicationContext();
        kotlin.jvm.internal.m.d(applicationContext, "getApplicationContext(...)");
        new C1640l(applicationContext, j4, new f(aVar), LifecycleOwnerKt.getLifecycleScope(aVar));
        return s.f8222a;
    }

    /* access modifiers changed from: private */
    public static final s Z1(C1826a aVar) {
        aVar.Y2();
        return s.f8222a;
    }

    /* access modifiers changed from: private */
    public static final void b2(C1826a aVar, View view) {
        aVar.i2();
        aVar.l0();
    }

    /* access modifiers changed from: private */
    public static final void c2(C1826a aVar, View view) {
        aVar.i2();
        aVar.finish();
    }

    /* access modifiers changed from: private */
    public static final void e2(C1826a aVar, a aVar2, View view) {
        aVar.i2();
        aVar2.invoke();
    }

    /* access modifiers changed from: private */
    public static final void f2(a aVar, C1826a aVar2, View view) {
        aVar.invoke();
        aVar2.i2();
    }

    /* access modifiers changed from: private */
    public static final void g2(a aVar, DialogInterface dialogInterface) {
        aVar.invoke();
    }

    /* access modifiers changed from: private */
    public static final void o2(C1826a aVar, View view, View view2, int i4, int i5, int i6, int i7) {
        if (i5 > i7) {
            Object systemService = aVar.getSystemService("input_method");
            kotlin.jvm.internal.m.c(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            ((InputMethodManager) systemService).hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    /* access modifiers changed from: private */
    public static final void p2(View view, C1826a aVar) {
        Integer num;
        int i4;
        int scrollY = view.getScrollY();
        Object tag = view.getTag();
        if (tag instanceof Integer) {
            num = (Integer) tag;
        } else {
            num = null;
        }
        if (num != null) {
            i4 = num.intValue();
        } else {
            i4 = 0;
        }
        if (scrollY > i4) {
            Object systemService = aVar.getSystemService("input_method");
            kotlin.jvm.internal.m.c(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            ((InputMethodManager) systemService).hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
        view.setTag(Integer.valueOf(scrollY));
    }

    private final void s2(File file, String str) {
        U e5 = U.f20468m.e(this);
        t a5 = t.f21927u.a(this);
        a5.a();
        String name = file.getName();
        kotlin.jvm.internal.m.d(name, "getName(...)");
        C2060s d02 = a5.d0(name);
        a5.i();
        if (e5 == null || !e5.n() || (d02 != null && !d02.o().isEmpty())) {
            t2(file, str);
            s sVar = s.f8222a;
            return;
        }
        new b2.p(this, (String) null, C1610f.f8672a.e(file.getAbsolutePath()), new i(this, file, str), LifecycleOwnerKt.getLifecycleScope(this));
    }

    /* access modifiers changed from: private */
    public final void t2(File file, String str) {
        j jVar = new j(this, file);
        k.a aVar = N1.k.f7778g;
        if (aVar.i() == null && aVar.j() == null) {
            G.a aVar2 = W1.G.f8470b;
            String name = file.getName();
            kotlin.jvm.internal.m.d(name, "getName(...)");
            if (aVar2.a(name)) {
                String absolutePath = file.getAbsolutePath();
                kotlin.jvm.internal.m.d(absolutePath, "getAbsolutePath(...)");
                new R1.c(this, absolutePath, jVar, T());
                return;
            }
            UptodownApp.f17422D.V(file, this, str);
            s sVar = s.f8222a;
            return;
        }
        String string = getString(R.string.core_installation_in_progress_msg);
        kotlin.jvm.internal.m.d(string, "getString(...)");
        q0(string);
        s sVar2 = s.f8222a;
    }

    public static /* synthetic */ void w2(C1826a aVar, File file, String str, int i4, Object obj) {
        if (obj == null) {
            if ((i4 & 2) != 0) {
                str = null;
            }
            aVar.v2(file, str);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: launchForegroundInstallation");
    }

    public static /* synthetic */ void y2(C1826a aVar, File file, String str, int i4, Object obj) {
        if (obj == null) {
            if ((i4 & 2) != 0) {
                str = null;
            }
            aVar.x2(file, str);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: launchInstallationFromActivity");
    }

    public void A2(C2050h hVar) {
        kotlin.jvm.internal.m.e(hVar, "appInfo");
        Z2(hVar);
    }

    public void B2() {
    }

    public void C2(long j4) {
        if (j4 > 0) {
            new C1640l(this, j4, new m(this), LifecycleOwnerKt.getLifecycleScope(this));
            return;
        }
        E2();
        s sVar = s.f8222a;
    }

    public final void D2(String str, C2054l lVar) {
        kotlin.jvm.internal.m.e(str, "packageNameToOpen");
        new b2.m(this, str, new n(lVar, this), LifecycleOwnerKt.getLifecycleScope(this));
    }

    public final void E2() {
        if (!isFinishing()) {
            k.a aVar = N1.k.f7778g;
            if (!(aVar.g() instanceof MyDownloads)) {
                Intent intent = new Intent(this, MyDownloads.class);
                if (aVar.g() instanceof MainActivity) {
                    kotlin.jvm.internal.m.c(this, "null cannot be cast to non-null type com.uptodown.activities.MainActivity");
                    intent.putExtra("downloadResultReceiver", ((MainActivity) this).I5());
                }
                startActivity(intent, UptodownApp.f17422D.a(this));
            }
        }
    }

    public final void F2(String str) {
        if (str != null && !isFinishing()) {
            String r4 = new u2.m().r(str);
            String string = getString(R.string.virustotal_safety_report_title);
            kotlin.jvm.internal.m.d(string, "getString(...)");
            new u2.q().q(this, r4, string);
        }
    }

    public final void G2(C2039G g4) {
        kotlin.jvm.internal.m.e(g4, "preregister");
        new C1640l(this, g4.c(), new p(this, g4), LifecycleOwnerKt.getLifecycleScope(this));
    }

    public void H2() {
    }

    public final void I2(int i4, String str) {
        if (!z.f21956a.d()) {
            String string = getString(R.string.error_no_connection);
            kotlin.jvm.internal.m.d(string, "getString(...)");
            q0(string);
        } else if (!DownloadApkWorker.f19447i.c(this, i4) && str != null && str.length() != 0) {
            kotlin.jvm.internal.F f4 = kotlin.jvm.internal.F.f20971a;
            String string2 = getString(R.string.msg_added_to_downlads_queue);
            kotlin.jvm.internal.m.d(string2, "getString(...)");
            String format = String.format(string2, Arrays.copyOf(new Object[]{str}, 1));
            kotlin.jvm.internal.m.d(format, "format(...)");
            q0(format);
        }
    }

    public final void J2(AlertDialog alertDialog) {
        this.f18710x = alertDialog;
    }

    public final void K2() {
        this.f18709w = new x(this);
    }

    public final void L1(C2039G g4) {
        kotlin.jvm.internal.m.e(g4, "preRegister");
        C1543u uVar = this.f18703C;
        if (uVar != null) {
            uVar.b(g4);
        }
    }

    public final void L2(RelativeLayout relativeLayout) {
        this.f18708H = relativeLayout;
    }

    public final void M2(boolean z4) {
        this.f18701A = z4;
    }

    public final void N1() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f18712z > ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS) {
            this.f18712z = currentTimeMillis;
            C1001s0 unused = C0981i.d(o3.K.a(Y.b()), (V2.g) null, (L) null, new d(this, (V2.d) null), 3, (Object) null);
        }
    }

    public final void N2(x xVar) {
        this.f18709w = xVar;
    }

    public final void O1(String str, a aVar) {
        kotlin.jvm.internal.m.e(str, NotificationCompat.CATEGORY_MESSAGE);
        kotlin.jvm.internal.m.e(aVar, "acceptAction");
        if (!isFinishing()) {
            i2();
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            C1683p c5 = C1683p.c(getLayoutInflater());
            kotlin.jvm.internal.m.d(c5, "inflate(...)");
            TextView textView = c5.f10696d;
            k.a aVar2 = N1.k.f7778g;
            textView.setTypeface(aVar2.x());
            c5.f10696d.setText(str);
            c5.f10697e.setTypeface(aVar2.w());
            c5.f10697e.setOnClickListener(new D(aVar, this));
            c5.f10695c.setTypeface(aVar2.w());
            c5.f10695c.setOnClickListener(new E(this));
            builder.setView(c5.getRoot());
            this.f18710x = builder.create();
            if (!isFinishing() && this.f18710x != null) {
                W2();
            }
        }
    }

    public final void O2(Window window) {
        kotlin.jvm.internal.m.e(window, "window");
        if (Build.VERSION.SDK_INT >= 30) {
            WindowInsetsController a5 = window.getInsetsController();
            if (a5 != null) {
                a5.hide(WindowInsets.Type.statusBars() | WindowInsets.Type.navigationBars());
                a5.setSystemBarsBehavior(2);
                return;
            }
            return;
        }
        window.getDecorView().setSystemUiVisibility(4);
        window.getDecorView().setSystemUiVisibility(InputDeviceCompat.SOURCE_TOUCHSCREEN);
    }

    public final void P1(String str, a aVar, a aVar2) {
        kotlin.jvm.internal.m.e(str, NotificationCompat.CATEGORY_MESSAGE);
        kotlin.jvm.internal.m.e(aVar, "acceptAction");
        kotlin.jvm.internal.m.e(aVar2, "cancelAction");
        C1001s0 unused = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), Y.c(), (L) null, new e(this, str, aVar, aVar2, (V2.d) null), 2, (Object) null);
    }

    public void P2(File file) {
        kotlin.jvm.internal.m.e(file, "file");
    }

    public final void Q2(ArrayList arrayList) {
        kotlin.jvm.internal.m.e(arrayList, "<set-?>");
        this.f18705E = arrayList;
    }

    public void R2(File file) {
        kotlin.jvm.internal.m.e(file, "file");
    }

    public final void S1(File file) {
        kotlin.jvm.internal.m.e(file, "updateFile");
        String string = getString(R.string.warning_auto_update);
        kotlin.jvm.internal.m.d(string, "getString(...)");
        O1(string, new J1.C(this, file));
    }

    public void S2(File file, int i4) {
        kotlin.jvm.internal.m.e(file, "file");
    }

    public final void T2(Drawable drawable, int i4) {
        kotlin.jvm.internal.m.e(drawable, "drawable");
        DrawableCompat.setTint(drawable, i4);
    }

    public final void U1(String str) {
        kotlin.jvm.internal.m.e(str, NotificationCompat.CATEGORY_MESSAGE);
        if (!isFinishing()) {
            i2();
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            C1683p c5 = C1683p.c(getLayoutInflater());
            kotlin.jvm.internal.m.d(c5, "inflate(...)");
            TextView textView = c5.f10696d;
            k.a aVar = N1.k.f7778g;
            textView.setTypeface(aVar.x());
            c5.f10696d.setText(str);
            c5.f10695c.setVisibility(8);
            c5.f10697e.setTypeface(aVar.w());
            c5.f10697e.setOnClickListener(new B(this));
            builder.setView(c5.getRoot());
            this.f18710x = builder.create();
            if (!isFinishing() && this.f18710x != null) {
                W2();
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void U2(ActivityResultLauncher activityResultLauncher) {
        this.f18706F = activityResultLauncher;
    }

    public final void V2(C2050h hVar, a aVar) {
        kotlin.jvm.internal.m.e(hVar, "appInfo");
        kotlin.jvm.internal.m.e(aVar, "updateCard");
        q qVar = new q(aVar, this);
        RelativeLayout relativeLayout = this.f18708H;
        if (relativeLayout != null) {
            kotlin.jvm.internal.m.b(relativeLayout);
            y2.g gVar = new y2.g(hVar, relativeLayout, qVar);
            this.f18707G = gVar;
            gVar.B(this, LifecycleOwnerKt.getLifecycleScope(this));
        }
    }

    public final void W1(String str, String str2, long j4) {
        O1(str + 10 + str2, new C1457v(this, j4));
    }

    public final void W2() {
        AlertDialog alertDialog = this.f18710x;
        kotlin.jvm.internal.m.b(alertDialog);
        Window window = alertDialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        AlertDialog alertDialog2 = this.f18710x;
        kotlin.jvm.internal.m.b(alertDialog2);
        alertDialog2.show();
        UptodownApp.f17422D.v0(true);
    }

    public void X2(long j4) {
        String string = getString(R.string.core_kill_this_app, new Object[]{getString(R.string.app_name)});
        kotlin.jvm.internal.m.d(string, "getString(...)");
        U1(string);
    }

    public void Y() {
    }

    public final void Y1(String str, String str2) {
        O1(str + 10 + str2, new C1464w(this));
    }

    public final void Y2() {
        CustomTabsIntent build = new CustomTabsIntent.Builder().build();
        kotlin.jvm.internal.m.d(build, "build(...)");
        build.intent.setData(Uri.parse(new u2.q().c(u2.L.f21898b.c(this))));
        ActivityResultLauncher activityResultLauncher = this.f18706F;
        if (activityResultLauncher != null) {
            kotlin.jvm.internal.m.b(activityResultLauncher);
            activityResultLauncher.launch(build.intent, UptodownApp.f17422D.b(this));
            return;
        }
        startActivity(build.intent, UptodownApp.f17422D.a(this));
    }

    public void Z() {
    }

    public void Z2(C2050h hVar) {
        kotlin.jvm.internal.m.e(hVar, "appInfo");
    }

    public void a0() {
    }

    public void a1() {
    }

    public final void a2() {
        AlertDialog alertDialog;
        if (!isFinishing()) {
            i2();
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            C1683p c5 = C1683p.c(getLayoutInflater());
            kotlin.jvm.internal.m.d(c5, "inflate(...)");
            TextView textView = c5.f10696d;
            k.a aVar = N1.k.f7778g;
            textView.setTypeface(aVar.x());
            c5.f10696d.setText(getString(R.string.msg_storage_permission_required));
            c5.f10697e.setTypeface(aVar.w());
            c5.f10697e.setOnClickListener(new C1485z(this));
            c5.f10695c.setTypeface(aVar.w());
            c5.f10695c.setText(getString(R.string.exit));
            c5.f10695c.setOnClickListener(new A(this));
            builder.setView(c5.getRoot());
            builder.setCancelable(false);
            this.f18710x = builder.create();
            if (!isFinishing() && (alertDialog = this.f18710x) != null) {
                kotlin.jvm.internal.m.b(alertDialog);
                Window window = alertDialog.getWindow();
                if (window != null) {
                    window.setBackgroundDrawable(new ColorDrawable(0));
                }
                AlertDialog alertDialog2 = this.f18710x;
                kotlin.jvm.internal.m.b(alertDialog2);
                alertDialog2.show();
            }
        }
    }

    public void b0() {
    }

    public void d0() {
    }

    public final void d2(C2050h hVar, a aVar, a aVar2) {
        kotlin.jvm.internal.m.e(hVar, "appInfo");
        kotlin.jvm.internal.m.e(aVar, "action");
        kotlin.jvm.internal.m.e(aVar2, "cancelAction");
        i2();
        C1698x c5 = C1698x.c(getLayoutInflater());
        kotlin.jvm.internal.m.d(c5, "inflate(...)");
        TextView textView = c5.f10854e;
        k.a aVar3 = N1.k.f7778g;
        textView.setTypeface(aVar3.w());
        c5.f10853d.setTypeface(aVar3.x());
        c5.f10851b.setOnClickListener(new J1.F(this, aVar2));
        if (hVar.F0()) {
            c5.f10853d.setText(hVar.t());
            c5.f10852c.setText(getString(R.string.leave_anyways));
        } else {
            c5.f10852c.setText(getString(R.string.download_anyways));
        }
        c5.f10852c.setTypeface(aVar3.w());
        c5.f10852c.setOnClickListener(new C1443t(aVar, this));
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(c5.getRoot());
        builder.setCancelable(true);
        builder.setOnCancelListener(new C1450u(aVar2));
        this.f18710x = builder.create();
        W2();
    }

    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        if (motionEvent == null || motionEvent.getSource() != 8194) {
            return super.dispatchGenericMotionEvent(motionEvent);
        }
        return true;
    }

    public final void h2(K k4, a aVar) {
        kotlin.jvm.internal.m.e(k4, "reportVT");
        kotlin.jvm.internal.m.e(aVar, "installAction");
        C1001s0 unused = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), Y.c(), (L) null, new g(this, k4, aVar, (V2.d) null), 2, (Object) null);
    }

    public final void hideKeyboardOnScroll(View view) {
        kotlin.jvm.internal.m.e(view, "scrollView");
        if (Build.VERSION.SDK_INT >= 23) {
            view.setOnScrollChangeListener(new C1471x(this, view));
        } else {
            view.getViewTreeObserver().addOnScrollChangedListener(new C1478y(view, this));
        }
    }

    public final void i2() {
        AlertDialog alertDialog = this.f18710x;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        UptodownApp.f17422D.v0(false);
    }

    public final AlertDialog j2() {
        return this.f18710x;
    }

    public final y2.g k2() {
        return this.f18707G;
    }

    public final boolean l2() {
        return this.f18701A;
    }

    public final x m2() {
        return this.f18709w;
    }

    public final ArrayList n2() {
        return this.f18705E;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x xVar = new x(this);
        this.f18709w = xVar;
        String simpleName = getClass().getSimpleName();
        kotlin.jvm.internal.m.d(simpleName, "getSimpleName(...)");
        xVar.e(simpleName);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        u2();
        H2();
    }

    public final void q2() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_preregister_notifications);
        this.f18702B = recyclerView;
        if (recyclerView != null) {
            kotlin.jvm.internal.m.b(recyclerView);
            recyclerView.setLayoutManager(new WrapContentLinearLayoutManager(this, 1, false));
            RecyclerView recyclerView2 = this.f18702B;
            kotlin.jvm.internal.m.b(recyclerView2);
            recyclerView2.addItemDecoration(new w2.m((int) getResources().getDimension(R.dimen.margin_m)));
            this.f18703C = new C1543u(this, this.f18704D);
            RecyclerView recyclerView3 = this.f18702B;
            kotlin.jvm.internal.m.b(recyclerView3);
            recyclerView3.setAdapter(this.f18703C);
            M1();
        }
    }

    public final boolean r2() {
        AlertDialog alertDialog = this.f18710x;
        if (alertDialog == null || !alertDialog.isShowing()) {
            return false;
        }
        return true;
    }

    public final void showKeyboard(View view) {
        kotlin.jvm.internal.m.e(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        Object systemService = getSystemService("input_method");
        kotlin.jvm.internal.m.c(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).showSoftInput(view.findFocus(), 1);
    }

    public final void u2() {
        C1001s0 unused = C0981i.d(o3.K.a(Y.a()), (V2.g) null, (L) null, new k(5000, this, 5, (V2.d) null), 3, (Object) null);
    }

    public final void v2(File file, String str) {
        kotlin.jvm.internal.m.e(file, "item");
        boolean y4 = new u2.m().y(this);
        U e5 = U.f20468m.e(this);
        t a5 = t.f21927u.a(this);
        a5.a();
        String name = file.getName();
        kotlin.jvm.internal.m.d(name, "getName(...)");
        C2060s d02 = a5.d0(name);
        a5.i();
        if (e5 == null || !e5.n() || (d02 != null && !d02.o().isEmpty())) {
            new N1.j(this).c(file, str, y4);
            z2(file);
            s sVar = s.f8222a;
            return;
        }
        new b2.p(this, (String) null, C1610f.f8672a.e(file.getAbsolutePath()), new l(this, file, str, y4), LifecycleOwnerKt.getLifecycleScope(this));
    }

    public final void x2(File file, String str) {
        kotlin.jvm.internal.m.e(file, "item");
        if (new P1.a(this).r()) {
            v2(file, str);
        } else {
            s2(file, str);
        }
    }

    public final void z2(File file) {
        kotlin.jvm.internal.m.e(file, "file");
        t a5 = t.f21927u.a(this);
        a5.a();
        String name = file.getName();
        kotlin.jvm.internal.m.d(name, "getName(...)");
        C2060s d02 = a5.d0(name);
        a5.i();
        Bundle bundle = new Bundle();
        if (d02 != null) {
            if (d02.w() != null) {
                y yVar = y.f21955a;
                String w4 = d02.w();
                kotlin.jvm.internal.m.b(w4);
                bundle = yVar.b(this, w4, bundle);
                bundle.putString("packagename", d02.w());
            }
            if (((C2060s.c) d02.o().get(0)).d() > 0) {
                bundle.putString("fileId", String.valueOf(((C2060s.c) d02.o().get(0)).d()));
            }
        }
        bundle.putString("type", "start");
        x xVar = this.f18709w;
        if (xVar != null) {
            xVar.d("install", bundle);
        }
    }
}
