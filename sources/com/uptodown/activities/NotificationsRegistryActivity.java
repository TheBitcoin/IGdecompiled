package com.uptodown.activities;

import J1.Q2;
import J1.R2;
import J1.S2;
import J1.T2;
import J1.U2;
import M1.C1537n;
import N1.k;
import R2.k;
import R2.n;
import R2.s;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import b2.C1640l;
import c2.V;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.C1844t;
import d3.p;
import f2.C2027s;
import f2.C2031w;
import g2.C2034B;
import g2.C2050h;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.D;
import kotlin.jvm.internal.m;
import o3.C1001s0;
import o3.J;
import o3.K;
import o3.L;
import o3.Y;
import r3.C1036f;
import r3.I;
import u2.E;

public final class NotificationsRegistryActivity extends C1826a {

    /* renamed from: J  reason: collision with root package name */
    private final R2.g f18012J = R2.h.a(new T2(this));

    /* renamed from: K  reason: collision with root package name */
    private final R2.g f18013K = new ViewModelLazy(D.b(C1844t.class), new f(this), new e(this), new g((d3.a) null, this));
    /* access modifiers changed from: private */

    /* renamed from: L  reason: collision with root package name */
    public boolean f18014L;
    /* access modifiers changed from: private */

    /* renamed from: M  reason: collision with root package name */
    public boolean f18015M = true;
    /* access modifiers changed from: private */

    /* renamed from: N  reason: collision with root package name */
    public C1537n f18016N;

    /* renamed from: O  reason: collision with root package name */
    private c f18017O = new c(this);

    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f18018a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ NotificationsRegistryActivity f18019b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f18020c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(NotificationsRegistryActivity notificationsRegistryActivity, int i4, V2.d dVar) {
            super(2, dVar);
            this.f18019b = notificationsRegistryActivity;
            this.f18020c = i4;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new a(this.f18019b, this.f18020c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f18018a;
            if (i4 == 0) {
                n.b(obj);
                NotificationsRegistryActivity notificationsRegistryActivity = this.f18019b;
                int i5 = this.f18020c;
                this.f18018a = 1;
                if (notificationsRegistryActivity.C3(i5, this) == c5) {
                    return c5;
                }
            } else if (i4 == 1) {
                n.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return s.f8222a;
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public static final class b implements C2027s {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ NotificationsRegistryActivity f18021a;

        b(NotificationsRegistryActivity notificationsRegistryActivity) {
            this.f18021a = notificationsRegistryActivity;
        }

        public void b(int i4) {
            NotificationsRegistryActivity notificationsRegistryActivity = this.f18021a;
            String string = notificationsRegistryActivity.getString(R.string.app_detail_not_found);
            m.d(string, "getString(...)");
            notificationsRegistryActivity.q0(string);
        }

        public void c(C2050h hVar) {
            m.e(hVar, "appInfo");
            Intent intent = new Intent(this.f18021a, AppDetailActivity.class);
            intent.putExtra("appInfo", hVar);
            NotificationsRegistryActivity notificationsRegistryActivity = this.f18021a;
            notificationsRegistryActivity.startActivity(intent, UptodownApp.f17422D.a(notificationsRegistryActivity));
        }
    }

    public static final class c implements C2031w {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ NotificationsRegistryActivity f18022a;

        c(NotificationsRegistryActivity notificationsRegistryActivity) {
            this.f18022a = notificationsRegistryActivity;
        }

        public void a(int i4) {
            this.f18022a.A3(i4, 1);
        }

        public void b(int i4) {
            this.f18022a.p3(i4);
        }

        public void c(int i4) {
            this.f18022a.A3(i4, 0);
        }
    }

    static final class d extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f18023a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ NotificationsRegistryActivity f18024b;

        static final class a implements C1036f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ NotificationsRegistryActivity f18025a;

            a(NotificationsRegistryActivity notificationsRegistryActivity) {
                this.f18025a = notificationsRegistryActivity;
            }

            /* renamed from: b */
            public final Object emit(E e5, V2.d dVar) {
                if (e5 instanceof E.a) {
                    this.f18025a.t3().f10053b.setVisibility(0);
                } else if (e5 instanceof E.c) {
                    this.f18025a.B3(((C1844t.a) ((E.c) e5).a()).a());
                    this.f18025a.f18015M = false;
                    this.f18025a.f18014L = false;
                    this.f18025a.t3().f10053b.setVisibility(8);
                } else if (!(e5 instanceof E.b)) {
                    throw new k();
                }
                return s.f8222a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(NotificationsRegistryActivity notificationsRegistryActivity, V2.d dVar) {
            super(2, dVar);
            this.f18024b = notificationsRegistryActivity;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new d(this.f18024b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f18023a;
            if (i4 == 0) {
                n.b(obj);
                I e5 = this.f18024b.v3().e();
                a aVar = new a(this.f18024b);
                this.f18023a = 1;
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
            return ((d) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public static final class e extends kotlin.jvm.internal.n implements d3.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f18026a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(ComponentActivity componentActivity) {
            super(0);
            this.f18026a = componentActivity;
        }

        public final ViewModelProvider.Factory invoke() {
            return this.f18026a.getDefaultViewModelProviderFactory();
        }
    }

    public static final class f extends kotlin.jvm.internal.n implements d3.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f18027a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(ComponentActivity componentActivity) {
            super(0);
            this.f18027a = componentActivity;
        }

        public final ViewModelStore invoke() {
            return this.f18027a.getViewModelStore();
        }
    }

    public static final class g extends kotlin.jvm.internal.n implements d3.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d3.a f18028a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f18029b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(d3.a aVar, ComponentActivity componentActivity) {
            super(0);
            this.f18028a = aVar;
            this.f18029b = componentActivity;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
            r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0.invoke();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final androidx.lifecycle.viewmodel.CreationExtras invoke() {
            /*
                r1 = this;
                d3.a r0 = r1.f18028a
                if (r0 == 0) goto L_0x000e
                java.lang.Object r0 = r0.invoke()
                androidx.lifecycle.viewmodel.CreationExtras r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0
                if (r0 != 0) goto L_0x000d
                goto L_0x000e
            L_0x000d:
                return r0
            L_0x000e:
                androidx.activity.ComponentActivity r0 = r1.f18029b
                androidx.lifecycle.viewmodel.CreationExtras r0 = r0.getDefaultViewModelCreationExtras()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.NotificationsRegistryActivity.g.invoke():androidx.lifecycle.viewmodel.CreationExtras");
        }
    }

    static final class h extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a  reason: collision with root package name */
        Object f18030a;

        /* renamed from: b  reason: collision with root package name */
        int f18031b;

        /* renamed from: c  reason: collision with root package name */
        /* synthetic */ Object f18032c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ NotificationsRegistryActivity f18033d;

        /* renamed from: e  reason: collision with root package name */
        int f18034e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(NotificationsRegistryActivity notificationsRegistryActivity, V2.d dVar) {
            super(dVar);
            this.f18033d = notificationsRegistryActivity;
        }

        public final Object invokeSuspend(Object obj) {
            this.f18032c = obj;
            this.f18034e |= Integer.MIN_VALUE;
            return this.f18033d.C3(0, this);
        }
    }

    static final class i extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f18035a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ NotificationsRegistryActivity f18036b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f18037c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(NotificationsRegistryActivity notificationsRegistryActivity, int i4, V2.d dVar) {
            super(2, dVar);
            this.f18036b = notificationsRegistryActivity;
            this.f18037c = i4;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new i(this.f18036b, this.f18037c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f18035a == 0) {
                n.b(obj);
                String format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.getDefault()).format(kotlin.coroutines.jvm.internal.b.c(System.currentTimeMillis()));
                m.d(format, "format(...)");
                C1844t i32 = this.f18036b.v3();
                NotificationsRegistryActivity notificationsRegistryActivity = this.f18036b;
                C1537n g32 = notificationsRegistryActivity.f18016N;
                m.b(g32);
                Object obj2 = g32.a().get(this.f18037c);
                m.d(obj2, "get(...)");
                i32.f(notificationsRegistryActivity, (C2034B) obj2, format);
                C1537n g33 = this.f18036b.f18016N;
                m.b(g33);
                ((C2034B) g33.a().get(this.f18037c)).k(this.f18036b.getString(R.string.file_deleted_notification, new Object[]{format}));
                C1537n g34 = this.f18036b.f18016N;
                m.b(g34);
                ((C2034B) g34.a().get(this.f18037c)).i("no_action");
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((i) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class j extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f18038a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ NotificationsRegistryActivity f18039b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f18040c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(NotificationsRegistryActivity notificationsRegistryActivity, int i4, V2.d dVar) {
            super(2, dVar);
            this.f18039b = notificationsRegistryActivity;
            this.f18040c = i4;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new j(this.f18039b, this.f18040c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f18038a == 0) {
                n.b(obj);
                C1537n g32 = this.f18039b.f18016N;
                m.b(g32);
                g32.notifyItemChanged(this.f18040c);
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((j) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    /* access modifiers changed from: private */
    public final void A3(int i4, int i5) {
        C1537n nVar = this.f18016N;
        if (nVar != null) {
            m.b(nVar);
            if (nVar.getItemCount() > i4) {
                C1537n nVar2 = this.f18016N;
                m.b(nVar2);
                Object obj = nVar2.a().get(i4);
                m.d(obj, "get(...)");
                C2034B b5 = (C2034B) obj;
                if (b5.a() != null) {
                    String a5 = b5.a();
                    m.b(a5);
                    List j02 = m3.m.j0(a5, new String[]{";"}, false, 0, 6, (Object) null);
                    if (j02.size() > i5) {
                        s3((String) j02.get(i5), b5.b(), i4);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final void B3(ArrayList arrayList) {
        if (!arrayList.isEmpty()) {
            C1537n nVar = this.f18016N;
            if (nVar == null) {
                this.f18016N = new C1537n(arrayList, this, this.f18017O);
                t3().f10054c.setAdapter(this.f18016N);
            } else {
                if (nVar != null) {
                    nVar.d(arrayList);
                }
                C1537n nVar2 = this.f18016N;
                if (nVar2 != null) {
                    nVar2.notifyDataSetChanged();
                }
            }
            t3().f10056e.setVisibility(8);
            return;
        }
        C1537n nVar3 = this.f18016N;
        if (nVar3 != null) {
            nVar3.d(new ArrayList());
        }
        C1537n nVar4 = this.f18016N;
        if (nVar4 != null) {
            nVar4.notifyDataSetChanged();
        }
        t3().f10056e.setVisibility(0);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x006a, code lost:
        if (o3.C0977g.g(r8, r4, r0) != r1) goto L_0x006d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object C3(int r7, V2.d r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.uptodown.activities.NotificationsRegistryActivity.h
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.uptodown.activities.NotificationsRegistryActivity$h r0 = (com.uptodown.activities.NotificationsRegistryActivity.h) r0
            int r1 = r0.f18034e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f18034e = r1
            goto L_0x0018
        L_0x0013:
            com.uptodown.activities.NotificationsRegistryActivity$h r0 = new com.uptodown.activities.NotificationsRegistryActivity$h
            r0.<init>(r6, r8)
        L_0x0018:
            java.lang.Object r8 = r0.f18032c
            java.lang.Object r1 = W2.b.c()
            int r2 = r0.f18034e
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x003f
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            R2.n.b(r8)
            goto L_0x006d
        L_0x002d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0035:
            int r7 = r0.f18031b
            java.lang.Object r2 = r0.f18030a
            com.uptodown.activities.NotificationsRegistryActivity r2 = (com.uptodown.activities.NotificationsRegistryActivity) r2
            R2.n.b(r8)
            goto L_0x0059
        L_0x003f:
            R2.n.b(r8)
            o3.G r8 = o3.Y.b()
            com.uptodown.activities.NotificationsRegistryActivity$i r2 = new com.uptodown.activities.NotificationsRegistryActivity$i
            r2.<init>(r6, r7, r5)
            r0.f18030a = r6
            r0.f18031b = r7
            r0.f18034e = r4
            java.lang.Object r8 = o3.C0977g.g(r8, r2, r0)
            if (r8 != r1) goto L_0x0058
            goto L_0x006c
        L_0x0058:
            r2 = r6
        L_0x0059:
            o3.E0 r8 = o3.Y.c()
            com.uptodown.activities.NotificationsRegistryActivity$j r4 = new com.uptodown.activities.NotificationsRegistryActivity$j
            r4.<init>(r2, r7, r5)
            r0.f18030a = r5
            r0.f18034e = r3
            java.lang.Object r7 = o3.C0977g.g(r8, r4, r0)
            if (r7 != r1) goto L_0x006d
        L_0x006c:
            return r1
        L_0x006d:
            R2.s r7 = R2.s.f8222a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.NotificationsRegistryActivity.C3(int, V2.d):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public static final V o3(NotificationsRegistryActivity notificationsRegistryActivity) {
        return V.c(notificationsRegistryActivity.getLayoutInflater());
    }

    /* access modifiers changed from: private */
    public final void p3(int i4) {
        C1537n nVar = this.f18016N;
        if (nVar != null) {
            m.b(nVar);
            if (nVar.getItemCount() > i4) {
                C1844t v32 = v3();
                C1537n nVar2 = this.f18016N;
                m.b(nVar2);
                v32.c(this, ((C2034B) nVar2.a().get(i4)).c());
                C1537n nVar3 = this.f18016N;
                m.b(nVar3);
                nVar3.a().remove(i4);
                C1537n nVar4 = this.f18016N;
                m.b(nVar4);
                nVar4.notifyItemRemoved(i4);
            }
        }
    }

    private final void q3(File file, int i4) {
        String string = getString(R.string.dialog_delete_download_msg, new Object[]{file.getName()});
        m.d(string, "getString(...)");
        O1(string, new U2(file, this, i4));
    }

    /* access modifiers changed from: private */
    public static final s r3(File file, NotificationsRegistryActivity notificationsRegistryActivity, int i4) {
        if (file.delete()) {
            String string = notificationsRegistryActivity.getString(R.string.snackbar_message_apk_deleted, new Object[]{file.getName()});
            m.d(string, "getString(...)");
            notificationsRegistryActivity.q0(string);
            C1001s0 unused = C0981i.d(K.a(Y.b()), (V2.g) null, (L) null, new a(notificationsRegistryActivity, i4, (V2.d) null), 3, (Object) null);
        }
        return s.f8222a;
    }

    private final void s3(String str, String str2, int i4) {
        switch (str.hashCode()) {
            case -1569440520:
                if (str.equals("positive_apps")) {
                    startActivity(new Intent(this, SecurityActivity.class), UptodownApp.f17422D.a(this));
                    s sVar = s.f8222a;
                    return;
                }
                break;
            case -1335458389:
                if (str.equals("delete")) {
                    if (str2 != null) {
                        q3(new File(str2), i4);
                    } else {
                        String string = getString(R.string.msg_no_action_available);
                        m.d(string, "getString(...)");
                        q0(string);
                    }
                    s sVar2 = s.f8222a;
                    return;
                }
                break;
            case -504325460:
                if (str.equals("open_app")) {
                    if (str2 != null) {
                        try {
                            Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(str2);
                            if (launchIntentForPackage != null) {
                                startActivity(launchIntentForPackage);
                            } else {
                                String string2 = getString(R.string.app_detail_not_found);
                                m.d(string2, "getString(...)");
                                q0(string2);
                            }
                        } catch (Exception e5) {
                            e5.printStackTrace();
                            String string3 = getString(R.string.app_detail_not_found);
                            m.d(string3, "getString(...)");
                            q0(string3);
                        }
                    } else {
                        String string4 = getString(R.string.msg_no_action_available);
                        m.d(string4, "getString(...)");
                        q0(string4);
                    }
                    s sVar3 = s.f8222a;
                    return;
                }
                break;
            case -234430262:
                if (str.equals("updates")) {
                    startActivity(new Intent(this, Updates.class), UptodownApp.f17422D.a(this));
                    s sVar4 = s.f8222a;
                    return;
                }
                break;
            case 1085191854:
                if (str.equals("update_uptodown")) {
                    if (str2 != null) {
                        File file = new File(str2);
                        if (file.exists()) {
                            UptodownApp.a.Y(UptodownApp.f17422D, file, this, (String) null, 4, (Object) null);
                        } else {
                            String string5 = getString(R.string.installable_files_not_found);
                            m.d(string5, "getString(...)");
                            q0(string5);
                        }
                    } else {
                        String string6 = getString(R.string.msg_no_action_available);
                        m.d(string6, "getString(...)");
                        q0(string6);
                    }
                    s sVar5 = s.f8222a;
                    return;
                }
                break;
            case 1117687366:
                if (str.equals("preregister")) {
                    if (str2 != null) {
                        new C1640l(this, Long.parseLong(str2), new b(this), LifecycleOwnerKt.getLifecycleScope(this));
                        return;
                    }
                    String string7 = getString(R.string.msg_no_action_available);
                    m.d(string7, "getString(...)");
                    q0(string7);
                    s sVar6 = s.f8222a;
                    return;
                }
                break;
            case 1312704747:
                if (str.equals("downloads")) {
                    startActivity(new Intent(this, MyDownloads.class), UptodownApp.f17422D.a(this));
                    s sVar7 = s.f8222a;
                    return;
                }
                break;
            case 1957569947:
                if (str.equals("install")) {
                    if (str2 != null) {
                        File file2 = new File(str2);
                        if (file2.exists()) {
                            UptodownApp.a.Y(UptodownApp.f17422D, file2, this, (String) null, 4, (Object) null);
                        } else {
                            String string8 = getString(R.string.installable_files_not_found);
                            m.d(string8, "getString(...)");
                            q0(string8);
                        }
                    } else {
                        String string9 = getString(R.string.msg_no_action_available);
                        m.d(string9, "getString(...)");
                        q0(string9);
                    }
                    s sVar8 = s.f8222a;
                    return;
                }
                break;
        }
        String string10 = getString(R.string.msg_no_action_available);
        m.d(string10, "getString(...)");
        q0(string10);
        s sVar9 = s.f8222a;
    }

    /* access modifiers changed from: private */
    public final V t3() {
        return (V) this.f18012J.getValue();
    }

    private final void u3() {
        v3().d(this);
    }

    /* access modifiers changed from: private */
    public final C1844t v3() {
        return (C1844t) this.f18013K.getValue();
    }

    private final void w3() {
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.core_vector_back);
        if (drawable != null) {
            t3().f10055d.setNavigationIcon(drawable);
            t3().f10055d.setNavigationContentDescription((CharSequence) getString(R.string.back));
        }
        t3().f10055d.setNavigationOnClickListener(new Q2(this));
        t3().f10055d.inflateMenu(R.menu.menu_notifications_registry);
        t3().f10055d.setOverflowIcon(ContextCompat.getDrawable(this, R.drawable.vector_menu_dots_color_adaptable));
        t3().f10055d.setOnMenuItemClickListener(new R2(this));
        TextView textView = t3().f10057f;
        k.a aVar = N1.k.f7778g;
        textView.setTypeface(aVar.w());
        t3().f10056e.setTypeface(aVar.x());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, 1, false);
        int dimension = (int) getResources().getDimension(R.dimen.margin_m);
        t3().f10054c.addItemDecoration(new w2.l(dimension, dimension));
        t3().f10054c.setLayoutManager(linearLayoutManager);
        t3().f10054c.setItemAnimator(new DefaultItemAnimator());
        t3().f10053b.setOnClickListener(new S2());
    }

    /* access modifiers changed from: private */
    public static final void x3(NotificationsRegistryActivity notificationsRegistryActivity, View view) {
        notificationsRegistryActivity.getOnBackPressedDispatcher().onBackPressed();
    }

    /* access modifiers changed from: private */
    public static final boolean y3(NotificationsRegistryActivity notificationsRegistryActivity, MenuItem menuItem) {
        m.e(menuItem, "item");
        if (menuItem.getItemId() != R.id.action_delete_all) {
            return true;
        }
        notificationsRegistryActivity.v3().b(notificationsRegistryActivity);
        return true;
    }

    /* access modifiers changed from: private */
    public static final void z3(View view) {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((View) t3().getRoot());
        w3();
        C1001s0 unused = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), Y.c(), (L) null, new d(this, (V2.d) null), 2, (Object) null);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (this.f18015M) {
            u3();
        }
    }
}
