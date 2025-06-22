package com.uptodown.tv.ui.fragment;

import N1.j;
import R2.n;
import R2.s;
import W1.C1612h;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import androidx.leanback.app.VerticalGridSupportFragment;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.OnItemViewClickedListener;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.Row;
import androidx.leanback.widget.RowPresenter;
import androidx.leanback.widget.VerticalGridPresenter;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import b2.C1637i;
import com.mbridge.msdk.MBridgeConstans;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.workers.DownloadApkWorker;
import com.uptodown.workers.DownloadWorker;
import d3.p;
import f2.y;
import g2.C2035C;
import g2.C2048f;
import g2.C2050h;
import g2.C2060s;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.F;
import kotlin.jvm.internal.m;
import o3.C1001s0;
import o3.J;
import o3.K;
import o3.L;
import o3.Y;
import p2.o;
import r2.C2232N;
import r2.C2233O;
import r2.C2234P;
import u2.t;
import u2.w;
import u2.x;

public final class TvOldVersionsFragment extends VerticalGridSupportFragment {

    /* renamed from: e  reason: collision with root package name */
    public static final a f19391e = new a((C2103g) null);
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public C2050h f19392a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public C2048f f19393b;

    /* renamed from: c  reason: collision with root package name */
    private AlertDialog f19394c;

    /* renamed from: d  reason: collision with root package name */
    private b f19395d;

    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        private a() {
        }
    }

    private static final class b extends ArrayObjectAdapter {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(o oVar) {
            super((Presenter) oVar);
            m.e(oVar, "presenter");
        }
    }

    private final class c implements OnItemViewClickedListener {
        public c() {
        }

        /* renamed from: a */
        public void onItemClicked(Presenter.ViewHolder viewHolder, Object obj, RowPresenter.ViewHolder viewHolder2, Row row) {
            if (obj instanceof C2035C) {
                if (TvOldVersionsFragment.this.f19393b != null) {
                    long g4 = ((C2035C) obj).g();
                    C2048f k4 = TvOldVersionsFragment.this.f19393b;
                    m.b(k4);
                    if (g4 == k4.A()) {
                        return;
                    }
                }
                t.a aVar = t.f21927u;
                Context requireContext = TvOldVersionsFragment.this.requireContext();
                m.d(requireContext, "requireContext(...)");
                t a5 = aVar.a(requireContext);
                a5.a();
                C2035C c5 = (C2035C) obj;
                C2060s f02 = a5.f0(String.valueOf(c5.a()));
                a5.i();
                if (f02 != null) {
                    DownloadWorker.a aVar2 = DownloadWorker.f19459d;
                    if (!aVar2.l(f02)) {
                        if (!f02.f() || f02.i() == null) {
                            C2050h l4 = TvOldVersionsFragment.this.f19392a;
                            m.b(l4);
                            f02.d(l4);
                            TvOldVersionsFragment.this.s(f02);
                            return;
                        }
                        TvOldVersionsFragment tvOldVersionsFragment = TvOldVersionsFragment.this;
                        C2050h l5 = tvOldVersionsFragment.f19392a;
                        m.b(l5);
                        String Q4 = l5.Q();
                        long E4 = f02.E();
                        String i4 = f02.i();
                        m.b(i4);
                        tvOldVersionsFragment.w(Q4, E4, i4);
                    } else if (f02.w() != null) {
                        String w4 = f02.w();
                        m.b(w4);
                        aVar2.c(w4);
                    } else if (f02.h() > 0) {
                        aVar2.d(f02.h());
                    }
                } else {
                    C2060s sVar = new C2060s();
                    C2050h l6 = TvOldVersionsFragment.this.f19392a;
                    m.b(l6);
                    sVar.d(l6);
                    sVar.c0(c5.g());
                    String a6 = c5.a();
                    m.b(a6);
                    ((C2060s.c) sVar.o().get(0)).m(Long.parseLong(a6));
                    ((C2060s.c) sVar.o().get(0)).q(c5.f());
                    TvOldVersionsFragment.this.s(sVar);
                }
            }
        }
    }

    static final class d extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a  reason: collision with root package name */
        Object f19397a;

        /* renamed from: b  reason: collision with root package name */
        /* synthetic */ Object f19398b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ TvOldVersionsFragment f19399c;

        /* renamed from: d  reason: collision with root package name */
        int f19400d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(TvOldVersionsFragment tvOldVersionsFragment, V2.d dVar) {
            super(dVar);
            this.f19399c = tvOldVersionsFragment;
        }

        public final Object invokeSuspend(Object obj) {
            this.f19398b = obj;
            this.f19400d |= Integer.MIN_VALUE;
            return this.f19399c.t(this);
        }
    }

    static final class e extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f19401a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ TvOldVersionsFragment f19402b;

        public static final class a implements y {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ TvOldVersionsFragment f19403a;

            a(TvOldVersionsFragment tvOldVersionsFragment) {
                this.f19403a = tvOldVersionsFragment;
            }

            public void a(ArrayList arrayList) {
                m.e(arrayList, "oldVersions");
                C2050h l4 = this.f19403a.f19392a;
                m.b(l4);
                l4.P0(arrayList);
                C2050h l5 = this.f19403a.f19392a;
                m.b(l5);
                if (l5.O() != null) {
                    TvOldVersionsFragment tvOldVersionsFragment = this.f19403a;
                    C2050h l6 = tvOldVersionsFragment.f19392a;
                    m.b(l6);
                    tvOldVersionsFragment.v(l6.O());
                }
            }

            public void b() {
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(TvOldVersionsFragment tvOldVersionsFragment, V2.d dVar) {
            super(2, dVar);
            this.f19402b = tvOldVersionsFragment;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new e(this.f19402b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            int i4;
            W2.b.c();
            if (this.f19401a == 0) {
                n.b(obj);
                if (!(this.f19402b.f19392a == null || this.f19402b.getContext() == null)) {
                    C2050h l4 = this.f19402b.f19392a;
                    m.b(l4);
                    if (l4.O() != null) {
                        C2050h l5 = this.f19402b.f19392a;
                        m.b(l5);
                        ArrayList O4 = l5.O();
                        m.b(O4);
                        if (O4.size() != 0) {
                            C2050h l6 = this.f19402b.f19392a;
                            m.b(l6);
                            ArrayList O5 = l6.O();
                            m.b(O5);
                            i4 = O5.size();
                            LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this.f19402b);
                            Context requireContext = this.f19402b.requireContext();
                            m.d(requireContext, "requireContext(...)");
                            C2050h l7 = this.f19402b.f19392a;
                            m.b(l7);
                            new C1637i(lifecycleScope, requireContext, l7, new a(this.f19402b), i4);
                        }
                    }
                    i4 = 0;
                    LifecycleCoroutineScope lifecycleScope2 = LifecycleOwnerKt.getLifecycleScope(this.f19402b);
                    Context requireContext2 = this.f19402b.requireContext();
                    m.d(requireContext2, "requireContext(...)");
                    C2050h l72 = this.f19402b.f19392a;
                    m.b(l72);
                    new C1637i(lifecycleScope2, requireContext2, l72, new a(this.f19402b), i4);
                }
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((e) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class f extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f19404a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ TvOldVersionsFragment f19405b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(TvOldVersionsFragment tvOldVersionsFragment, V2.d dVar) {
            super(2, dVar);
            this.f19405b = tvOldVersionsFragment;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new f(this.f19405b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f19404a == 0) {
                n.b(obj);
                try {
                    if (this.f19405b.f19392a != null) {
                        C2050h l4 = this.f19405b.f19392a;
                        m.b(l4);
                        if (l4.O() != null) {
                            TvOldVersionsFragment tvOldVersionsFragment = this.f19405b;
                            C2050h l5 = tvOldVersionsFragment.f19392a;
                            m.b(l5);
                            tvOldVersionsFragment.v(l5.O());
                        }
                    }
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((f) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class g extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f19406a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ TvOldVersionsFragment f19407b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(TvOldVersionsFragment tvOldVersionsFragment, V2.d dVar) {
            super(2, dVar);
            this.f19407b = tvOldVersionsFragment;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new g(this.f19407b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f19406a;
            if (i4 == 0) {
                n.b(obj);
                TvOldVersionsFragment tvOldVersionsFragment = this.f19407b;
                this.f19406a = 1;
                if (tvOldVersionsFragment.t(this) == c5) {
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
            return ((g) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    private final void p(String str) {
        AlertDialog alertDialog = this.f19394c;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle(getString(R.string.warning_title));
        builder.setMessage(R.string.msg_warning_old_versions);
        builder.setCancelable(false);
        builder.setPositiveButton(17039370, new C2233O(this, str));
        builder.setNegativeButton(17039360, new C2234P());
        AlertDialog create = builder.create();
        this.f19394c = create;
        if (create != null) {
            create.show();
        }
    }

    /* access modifiers changed from: private */
    public static final void q(TvOldVersionsFragment tvOldVersionsFragment, String str, DialogInterface dialogInterface, int i4) {
        m.e(dialogInterface, "dialog");
        dialogInterface.dismiss();
        tvOldVersionsFragment.z(str);
    }

    /* access modifiers changed from: private */
    public static final void r(DialogInterface dialogInterface, int i4) {
        m.e(dialogInterface, "dialog");
        dialogInterface.dismiss();
    }

    /* access modifiers changed from: private */
    public final void s(C2060s sVar) {
        Context requireContext = requireContext();
        m.d(requireContext, "requireContext(...)");
        int Q4 = sVar.Q(requireContext);
        if (Q4 >= 0) {
            DownloadApkWorker.a aVar = DownloadApkWorker.f19447i;
            Context requireContext2 = requireContext();
            m.d(requireContext2, "requireContext(...)");
            if (!aVar.c(requireContext2, Q4)) {
                Context context = getContext();
                F f4 = F.f20971a;
                String string = getString(R.string.msg_added_to_downlads_queue);
                m.d(string, "getString(...)");
                C2050h hVar = this.f19392a;
                m.b(hVar);
                String format = String.format(string, Arrays.copyOf(new Object[]{hVar.L()}, 1));
                m.d(format, "format(...)");
                Toast.makeText(context, format, 1).show();
                return;
            }
            return;
        }
        Context context2 = getContext();
        Toast.makeText(context2, getString(R.string.error_cant_enqueue_download) + " (108)", 1).show();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0066, code lost:
        if (o3.C0977g.g(r7, r4, r0) != r1) goto L_0x0069;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object t(V2.d r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.uptodown.tv.ui.fragment.TvOldVersionsFragment.d
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.uptodown.tv.ui.fragment.TvOldVersionsFragment$d r0 = (com.uptodown.tv.ui.fragment.TvOldVersionsFragment.d) r0
            int r1 = r0.f19400d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f19400d = r1
            goto L_0x0018
        L_0x0013:
            com.uptodown.tv.ui.fragment.TvOldVersionsFragment$d r0 = new com.uptodown.tv.ui.fragment.TvOldVersionsFragment$d
            r0.<init>(r6, r7)
        L_0x0018:
            java.lang.Object r7 = r0.f19398b
            java.lang.Object r1 = W2.b.c()
            int r2 = r0.f19400d
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x003d
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            R2.n.b(r7)
            goto L_0x0069
        L_0x002d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x0035:
            java.lang.Object r2 = r0.f19397a
            com.uptodown.tv.ui.fragment.TvOldVersionsFragment r2 = (com.uptodown.tv.ui.fragment.TvOldVersionsFragment) r2
            R2.n.b(r7)
            goto L_0x0055
        L_0x003d:
            R2.n.b(r7)
            o3.G r7 = o3.Y.b()
            com.uptodown.tv.ui.fragment.TvOldVersionsFragment$e r2 = new com.uptodown.tv.ui.fragment.TvOldVersionsFragment$e
            r2.<init>(r6, r5)
            r0.f19397a = r6
            r0.f19400d = r4
            java.lang.Object r7 = o3.C0977g.g(r7, r2, r0)
            if (r7 != r1) goto L_0x0054
            goto L_0x0068
        L_0x0054:
            r2 = r6
        L_0x0055:
            o3.E0 r7 = o3.Y.c()
            com.uptodown.tv.ui.fragment.TvOldVersionsFragment$f r4 = new com.uptodown.tv.ui.fragment.TvOldVersionsFragment$f
            r4.<init>(r2, r5)
            r0.f19397a = r5
            r0.f19400d = r3
            java.lang.Object r7 = o3.C0977g.g(r7, r4, r0)
            if (r7 != r1) goto L_0x0069
        L_0x0068:
            return r1
        L_0x0069:
            R2.s r7 = R2.s.f8222a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.tv.ui.fragment.TvOldVersionsFragment.t(V2.d):java.lang.Object");
    }

    private final boolean u(String str, long j4) {
        if (getActivity() != null) {
            PackageManager packageManager = requireActivity().getPackageManager();
            try {
                m.b(packageManager);
                m.b(str);
                if (j4 < new C1612h().m(W1.s.d(packageManager, str, 1))) {
                    return true;
                }
                return false;
            } catch (PackageManager.NameNotFoundException e5) {
                e5.printStackTrace();
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public final void v(ArrayList arrayList) {
        b bVar = this.f19395d;
        m.b(bVar);
        bVar.clear();
        m.b(arrayList);
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            b bVar2 = this.f19395d;
            m.b(bVar2);
            bVar2.add(arrayList.get(i4));
        }
    }

    /* access modifiers changed from: private */
    public final void w(String str, long j4, String str2) {
        if (u(str, j4)) {
            p(str);
            return;
        }
        w wVar = new w();
        Context requireContext = requireContext();
        m.d(requireContext, "requireContext(...)");
        File file = new File(wVar.f(requireContext), str2);
        UptodownApp.a aVar = UptodownApp.f17422D;
        FragmentActivity requireActivity = requireActivity();
        m.d(requireActivity, "requireActivity(...)");
        UptodownApp.a.Y(aVar, file, requireActivity, (String) null, 4, (Object) null);
    }

    private final void x() {
        VerticalGridPresenter verticalGridPresenter = new VerticalGridPresenter();
        verticalGridPresenter.setNumberOfColumns(2);
        setGridPresenter(verticalGridPresenter);
        new Handler(Looper.getMainLooper()).postDelayed(new C2232N(this), 500);
        setOnItemViewClickedListener(new c());
    }

    /* access modifiers changed from: private */
    public static final void y(TvOldVersionsFragment tvOldVersionsFragment) {
        tvOldVersionsFragment.startEntranceTransition();
    }

    private final void z(String str) {
        if (getActivity() != null) {
            FragmentActivity requireActivity = requireActivity();
            m.d(requireActivity, "requireActivity(...)");
            j jVar = new j(requireActivity);
            m.b(str);
            jVar.h(str);
        }
    }

    public final void A(int i4) {
        switch (i4) {
            case 201:
                b bVar = this.f19395d;
                m.b(bVar);
                b bVar2 = this.f19395d;
                m.b(bVar2);
                bVar.notifyArrayItemRangeChanged(0, bVar2.size());
                return;
            case 202:
            case 203:
                b bVar3 = this.f19395d;
                m.b(bVar3);
                b bVar4 = this.f19395d;
                m.b(bVar4);
                bVar3.notifyArrayItemRangeChanged(0, bVar4.size());
                return;
            default:
                return;
        }
    }

    public void onCreate(Bundle bundle) {
        Bundle extras;
        Parcelable parcelable;
        Parcelable parcelable2;
        super.onCreate(bundle);
        x xVar = new x(getContext());
        String simpleName = TvOldVersionsFragment.class.getSimpleName();
        m.d(simpleName, "getSimpleName(...)");
        xVar.e(simpleName);
        FragmentActivity activity = getActivity();
        if (!(activity == null || (extras = activity.getIntent().getExtras()) == null)) {
            if (extras.containsKey(MBridgeConstans.DYNAMIC_VIEW_WX_APP)) {
                if (Build.VERSION.SDK_INT >= 33) {
                    parcelable2 = (Parcelable) extras.getParcelable(MBridgeConstans.DYNAMIC_VIEW_WX_APP, C2048f.class);
                } else {
                    parcelable2 = extras.getParcelable(MBridgeConstans.DYNAMIC_VIEW_WX_APP);
                }
                this.f19393b = (C2048f) parcelable2;
            }
            if (extras.containsKey("appInfo")) {
                if (Build.VERSION.SDK_INT >= 33) {
                    parcelable = (Parcelable) extras.getParcelable("appInfo", C2050h.class);
                } else {
                    parcelable = extras.getParcelable("appInfo");
                }
                this.f19392a = (C2050h) parcelable;
                u2.m mVar = new u2.m();
                Context requireContext = requireContext();
                m.d(requireContext, "requireContext(...)");
                C2050h hVar = this.f19392a;
                m.b(hVar);
                this.f19393b = mVar.A(requireContext, hVar.Q());
            }
        }
        if (this.f19393b != null) {
            C2048f fVar = this.f19393b;
            m.b(fVar);
            this.f19395d = new b(new o(fVar));
        } else if (this.f19392a != null) {
            C2050h hVar2 = this.f19392a;
            m.b(hVar2);
            this.f19395d = new b(new o(hVar2.Q()));
        }
        setAdapter(this.f19395d);
        setTitle(getString(R.string.rollback_title));
        if (bundle == null) {
            prepareEntranceTransition();
        }
        x();
    }

    public void onResume() {
        super.onResume();
        C1001s0 unused = C0981i.d(K.a(Y.b()), (V2.g) null, (L) null, new g(this, (V2.d) null), 3, (Object) null);
    }
}
