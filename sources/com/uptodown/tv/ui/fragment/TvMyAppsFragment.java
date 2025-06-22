package com.uptodown.tv.ui.fragment;

import N1.j;
import N1.k;
import R2.n;
import R2.s;
import S2.C1601o;
import V2.g;
import W1.C1612h;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
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
import b2.C1640l;
import com.mbridge.msdk.MBridgeConstans;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.tv.ui.activity.TvOldVersionsActivity;
import d3.p;
import f2.C2027s;
import g2.C2038F;
import g2.C2048f;
import g2.C2050h;
import g2.S;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C;
import o3.C0977g;
import o3.C1001s0;
import o3.E0;
import o3.J;
import o3.L;
import o3.Y;
import p2.m;
import q2.C2209b;
import r2.C2219A;
import r2.C2220B;
import r2.C2221C;
import r2.C2222D;
import r2.C2223E;
import r2.C2224F;
import r2.C2225G;
import r2.C2226H;
import r2.C2227I;
import r2.C2228J;
import r2.C2229K;
import u2.t;
import u2.w;
import u2.x;

public final class TvMyAppsFragment extends VerticalGridSupportFragment {

    /* renamed from: a  reason: collision with root package name */
    private final LifecycleCoroutineScope f19363a = LifecycleOwnerKt.getLifecycleScope(this);

    /* renamed from: b  reason: collision with root package name */
    private ArrayObjectAdapter f19364b;

    /* renamed from: c  reason: collision with root package name */
    private AlertDialog f19365c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public boolean f19366d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public boolean f19367e;

    /* renamed from: f  reason: collision with root package name */
    private final int f19368f = 5;

    private static final class a extends ArrayObjectAdapter {
        public a(m mVar) {
            super((Presenter) mVar);
        }
    }

    private final class b implements OnItemViewClickedListener {
        public b() {
        }

        /* renamed from: a */
        public void onItemClicked(Presenter.ViewHolder viewHolder, Object obj, RowPresenter.ViewHolder viewHolder2, Row row) {
            Bundle bundle;
            kotlin.jvm.internal.m.e(viewHolder, "itemViewHolder");
            kotlin.jvm.internal.m.e(obj, "item");
            if (!(obj instanceof C2048f)) {
                return;
            }
            if (TvMyAppsFragment.this.f19367e) {
                Intent intent = new Intent(TvMyAppsFragment.this.getContext(), TvOldVersionsActivity.class);
                intent.putExtra(MBridgeConstans.DYNAMIC_VIEW_WX_APP, (Parcelable) obj);
                TvMyAppsFragment tvMyAppsFragment = TvMyAppsFragment.this;
                FragmentActivity activity = tvMyAppsFragment.getActivity();
                if (activity != null) {
                    bundle = UptodownApp.f17422D.a(activity);
                } else {
                    bundle = null;
                }
                tvMyAppsFragment.startActivity(intent, bundle);
            } else if (TvMyAppsFragment.this.f19366d) {
                TvMyAppsFragment.this.J(((C2048f) obj).b(), viewHolder);
            } else {
                TvMyAppsFragment.this.B((C2048f) obj, viewHolder);
            }
        }
    }

    public static final class c implements C2027s {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TvMyAppsFragment f19370a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Presenter.ViewHolder f19371b;

        c(TvMyAppsFragment tvMyAppsFragment, Presenter.ViewHolder viewHolder) {
            this.f19370a = tvMyAppsFragment;
            this.f19371b = viewHolder;
        }

        public void b(int i4) {
        }

        public void c(C2050h hVar) {
            kotlin.jvm.internal.m.e(hVar, "appInfo");
            if (this.f19370a.getActivity() != null) {
                C2209b bVar = (C2209b) this.f19370a.getActivity();
                kotlin.jvm.internal.m.b(bVar);
                bVar.l(hVar, this.f19371b);
            }
        }
    }

    static final class d extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f19372a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ TvMyAppsFragment f19373b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(TvMyAppsFragment tvMyAppsFragment, V2.d dVar) {
            super(2, dVar);
            this.f19373b = tvMyAppsFragment;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new d(this.f19373b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f19372a;
            if (i4 == 0) {
                n.b(obj);
                TvMyAppsFragment tvMyAppsFragment = this.f19373b;
                this.f19372a = 1;
                if (tvMyAppsFragment.L(this) == c5) {
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
            return ((d) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class e extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f19374a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ TvMyAppsFragment f19375b;

        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f19376a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ TvMyAppsFragment f19377b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ C f19378c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(TvMyAppsFragment tvMyAppsFragment, C c5, V2.d dVar) {
                super(2, dVar);
                this.f19377b = tvMyAppsFragment;
                this.f19378c = c5;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new a(this.f19377b, this.f19378c, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f19376a == 0) {
                    n.b(obj);
                    this.f19377b.M((ArrayList) this.f19378c.f20968a);
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(TvMyAppsFragment tvMyAppsFragment, V2.d dVar) {
            super(2, dVar);
            this.f19375b = tvMyAppsFragment;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new e(this.f19375b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f19374a;
            if (i4 == 0) {
                n.b(obj);
                if (this.f19375b.getContext() != null) {
                    C c6 = new C();
                    if (this.f19375b.f19366d) {
                        TvMyAppsFragment tvMyAppsFragment = this.f19375b;
                        Context requireContext = tvMyAppsFragment.requireContext();
                        kotlin.jvm.internal.m.d(requireContext, "requireContext(...)");
                        c6.f20968a = tvMyAppsFragment.N(requireContext);
                    } else {
                        u2.m mVar = new u2.m();
                        Context requireContext2 = this.f19375b.requireContext();
                        kotlin.jvm.internal.m.d(requireContext2, "requireContext(...)");
                        c6.f20968a = mVar.B(requireContext2);
                        ArrayList arrayList = new ArrayList();
                        Iterator it = ((ArrayList) c6.f20968a).iterator();
                        kotlin.jvm.internal.m.d(it, "iterator(...)");
                        while (it.hasNext()) {
                            Object next = it.next();
                            kotlin.jvm.internal.m.d(next, "next(...)");
                            C2048f fVar = (C2048f) next;
                            if (this.f19375b.getContext() != null) {
                                if (m3.m.p(this.f19375b.requireContext().getPackageName(), fVar.o(), true)) {
                                    arrayList.add(fVar);
                                } else {
                                    Context requireContext3 = this.f19375b.requireContext();
                                    kotlin.jvm.internal.m.d(requireContext3, "requireContext(...)");
                                    if (fVar.C(requireContext3)) {
                                        C1612h hVar = new C1612h();
                                        Context requireContext4 = this.f19375b.requireContext();
                                        kotlin.jvm.internal.m.d(requireContext4, "requireContext(...)");
                                        String o4 = fVar.o();
                                        kotlin.jvm.internal.m.b(o4);
                                        if (!hVar.p(requireContext4, o4)) {
                                            arrayList.add(fVar);
                                        }
                                    }
                                }
                            }
                        }
                        c6.f20968a = arrayList;
                    }
                    ArrayList unused = this.f19375b.O((ArrayList) c6.f20968a);
                    E0 c7 = Y.c();
                    a aVar = new a(this.f19375b, c6, (V2.d) null);
                    this.f19374a = 1;
                    if (C0977g.g(c7, aVar, this) == c5) {
                        return c5;
                    }
                }
            } else if (i4 == 1) {
                n.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return s.f8222a;
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((e) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    /* access modifiers changed from: private */
    public static final void A(DialogInterface dialogInterface, int i4) {
        kotlin.jvm.internal.m.e(dialogInterface, "dialogInterface");
        dialogInterface.dismiss();
    }

    /* access modifiers changed from: private */
    public final void B(C2048f fVar, Presenter.ViewHolder viewHolder) {
        boolean z4;
        if (!getParentFragmentManager().isDestroyed() && fVar != null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
            LayoutInflater layoutInflater = getLayoutInflater();
            kotlin.jvm.internal.m.d(layoutInflater, "getLayoutInflater(...)");
            View inflate = layoutInflater.inflate(R.layout.tv_dialog_app_selected, (ViewGroup) null, false);
            TextView textView = (TextView) inflate.findViewById(R.id.tv_title_das);
            k.a aVar = k.f7778g;
            textView.setTypeface(aVar.w());
            textView.setText(fVar.m());
            TextView textView2 = (TextView) inflate.findViewById(R.id.tv_see_on_uptodown);
            if (fVar.b() > 0) {
                textView2.setTypeface(aVar.x());
                textView2.setOnClickListener(new C2225G(this, fVar, viewHolder));
                z4 = true;
            } else {
                textView2.setVisibility(8);
                z4 = false;
            }
            TextView textView3 = (TextView) inflate.findViewById(R.id.tv_open);
            TextView textView4 = (TextView) inflate.findViewById(R.id.tv_uninstall);
            if (getContext() == null || m3.m.p(requireContext().getPackageName(), fVar.o(), true)) {
                textView3.setVisibility(8);
                textView4.setVisibility(8);
            } else {
                textView3.setTypeface(aVar.x());
                textView3.setOnClickListener(new C2226H(fVar, this));
                if (!fVar.F()) {
                    textView4.setTypeface(aVar.x());
                    textView4.setOnClickListener(new C2227I(fVar, this));
                } else {
                    textView4.setVisibility(8);
                }
                z4 = true;
            }
            if (UptodownApp.f17422D.K()) {
                textView3.setText("Debug Info App");
                textView3.setOnClickListener(new C2228J(fVar, this));
                textView3.setVisibility(0);
                z4 = true;
            }
            TextView textView5 = (TextView) inflate.findViewById(R.id.tv_old_versions);
            if (getContext() == null || m3.m.p(requireContext().getPackageName(), fVar.o(), true)) {
                textView5.setVisibility(8);
            } else {
                textView5.setTypeface(aVar.x());
                textView5.setOnClickListener(new C2229K(this, fVar));
            }
            TextView textView6 = (TextView) inflate.findViewById(R.id.tv_exclude);
            if (fVar.e() == 0) {
                textView6.setText(getString(R.string.not_offer_updates));
            } else {
                textView6.setText(getString(R.string.offer_updates_again));
            }
            textView6.setTypeface(aVar.x());
            textView6.setOnClickListener(new C2220B(this, fVar));
            if (z4) {
                builder.setView(inflate);
                AlertDialog create = builder.create();
                this.f19365c = create;
                kotlin.jvm.internal.m.b(create);
                create.show();
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void C(TvMyAppsFragment tvMyAppsFragment, C2048f fVar, View view) {
        AlertDialog alertDialog = tvMyAppsFragment.f19365c;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        t.a aVar = t.f21927u;
        Context requireContext = tvMyAppsFragment.requireContext();
        kotlin.jvm.internal.m.d(requireContext, "requireContext(...)");
        t a5 = aVar.a(requireContext);
        a5.a();
        if (fVar.e() == 0) {
            fVar.N(1);
            fVar.c0(C2048f.c.UPDATED);
            String o4 = fVar.o();
            kotlin.jvm.internal.m.b(o4);
            a5.R(o4);
            w wVar = new w();
            Context requireContext2 = tvMyAppsFragment.requireContext();
            kotlin.jvm.internal.m.d(requireContext2, "requireContext(...)");
            wVar.b(requireContext2);
        } else {
            fVar.N(0);
        }
        a5.o1(fVar);
        a5.i();
    }

    /* access modifiers changed from: private */
    public static final void D(TvMyAppsFragment tvMyAppsFragment, C2048f fVar, Presenter.ViewHolder viewHolder, View view) {
        tvMyAppsFragment.J(fVar.b(), viewHolder);
        AlertDialog alertDialog = tvMyAppsFragment.f19365c;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    /* access modifiers changed from: private */
    public static final void E(C2048f fVar, TvMyAppsFragment tvMyAppsFragment, View view) {
        try {
            if (fVar.o() != null) {
                PackageManager packageManager = tvMyAppsFragment.requireContext().getPackageManager();
                String o4 = fVar.o();
                kotlin.jvm.internal.m.b(o4);
                Intent leanbackLaunchIntentForPackage = packageManager.getLeanbackLaunchIntentForPackage(o4);
                if (leanbackLaunchIntentForPackage == null) {
                    PackageManager packageManager2 = tvMyAppsFragment.requireContext().getPackageManager();
                    String o5 = fVar.o();
                    kotlin.jvm.internal.m.b(o5);
                    leanbackLaunchIntentForPackage = packageManager2.getLaunchIntentForPackage(o5);
                }
                if (leanbackLaunchIntentForPackage != null) {
                    tvMyAppsFragment.startActivity(leanbackLaunchIntentForPackage);
                }
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
        AlertDialog alertDialog = tvMyAppsFragment.f19365c;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    /* access modifiers changed from: private */
    public static final void F(C2048f fVar, TvMyAppsFragment tvMyAppsFragment, View view) {
        if (fVar.o() != null) {
            Context requireContext = tvMyAppsFragment.requireContext();
            kotlin.jvm.internal.m.d(requireContext, "requireContext(...)");
            j jVar = new j(requireContext);
            String o4 = fVar.o();
            kotlin.jvm.internal.m.b(o4);
            jVar.h(o4);
        }
        AlertDialog alertDialog = tvMyAppsFragment.f19365c;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    /* access modifiers changed from: private */
    public static final void G(C2048f fVar, TvMyAppsFragment tvMyAppsFragment, View view) {
        Bundle bundle;
        if (fVar.o() != null) {
            Intent intent = new Intent(tvMyAppsFragment.getContext(), K1.b.class);
            intent.putExtra("AppIndex", fVar.o());
            FragmentActivity activity = tvMyAppsFragment.getActivity();
            if (activity != null) {
                bundle = UptodownApp.f17422D.a(activity);
            } else {
                bundle = null;
            }
            tvMyAppsFragment.startActivity(intent, bundle);
        }
        AlertDialog alertDialog = tvMyAppsFragment.f19365c;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    /* access modifiers changed from: private */
    public static final void H(TvMyAppsFragment tvMyAppsFragment, C2048f fVar, View view) {
        Bundle bundle;
        Intent intent = new Intent(tvMyAppsFragment.getContext(), TvOldVersionsActivity.class);
        intent.putExtra(MBridgeConstans.DYNAMIC_VIEW_WX_APP, fVar);
        FragmentActivity activity = tvMyAppsFragment.getActivity();
        if (activity != null) {
            bundle = UptodownApp.f17422D.a(activity);
        } else {
            bundle = null;
        }
        tvMyAppsFragment.startActivity(intent, bundle);
        AlertDialog alertDialog = tvMyAppsFragment.f19365c;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    /* access modifiers changed from: private */
    public final void J(long j4, Presenter.ViewHolder viewHolder) {
        Context requireContext = requireContext();
        kotlin.jvm.internal.m.d(requireContext, "requireContext(...)");
        new C1640l(requireContext, j4, new c(this, viewHolder), LifecycleOwnerKt.getLifecycleScope(this));
    }

    private final void K() {
        C1001s0 unused = C0981i.d(this.f19363a, (g) null, (L) null, new d(this, (V2.d) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final Object L(V2.d dVar) {
        Object g4 = C0977g.g(Y.b(), new e(this, (V2.d) null), dVar);
        if (g4 == W2.b.c()) {
            return g4;
        }
        return s.f8222a;
    }

    /* access modifiers changed from: private */
    public final void M(ArrayList arrayList) {
        ArrayObjectAdapter arrayObjectAdapter = this.f19364b;
        kotlin.jvm.internal.m.b(arrayObjectAdapter);
        arrayObjectAdapter.clear();
        if (arrayList != null && !arrayList.isEmpty()) {
            int size = arrayList.size();
            for (int i4 = 0; i4 < size; i4++) {
                ArrayObjectAdapter arrayObjectAdapter2 = this.f19364b;
                kotlin.jvm.internal.m.b(arrayObjectAdapter2);
                arrayObjectAdapter2.add(arrayList.get(i4));
            }
        }
        ArrayObjectAdapter arrayObjectAdapter3 = this.f19364b;
        kotlin.jvm.internal.m.b(arrayObjectAdapter3);
        if (arrayObjectAdapter3.size() == 0 && getContext() != null) {
            z(getString(R.string.no_data_available));
        }
    }

    /* access modifiers changed from: private */
    public final ArrayList N(Context context) {
        ArrayList B4 = new u2.m().B(context);
        t a5 = t.f21927u.a(context);
        a5.a();
        ArrayList arrayList = new ArrayList();
        Iterator it = B4.iterator();
        kotlin.jvm.internal.m.d(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            kotlin.jvm.internal.m.d(next, "next(...)");
            C2048f fVar = (C2048f) next;
            if (fVar.C(context)) {
                if (fVar.e() == 1) {
                    fVar.c0(C2048f.c.OUTDATED);
                } else {
                    String o4 = fVar.o();
                    kotlin.jvm.internal.m.b(o4);
                    S D02 = a5.D0(o4);
                    if (D02 == null) {
                        if (fVar.D()) {
                            fVar.c0(C2048f.c.UPDATED);
                        }
                    } else if (D02.e() != 1) {
                        fVar.c0(C2048f.c.OUTDATED);
                        C1612h hVar = new C1612h();
                        String o5 = fVar.o();
                        kotlin.jvm.internal.m.b(o5);
                        if (!hVar.p(context, o5) && D02.e() == 0) {
                            arrayList.add(fVar);
                        }
                    }
                    if (D02 != null && D02.g() == 0) {
                        D02.r(1);
                        a5.v1(D02);
                    }
                }
            }
            UptodownApp.a aVar = UptodownApp.f17422D;
            if (aVar.t() != null) {
                ArrayList t4 = aVar.t();
                kotlin.jvm.internal.m.b(t4);
                Iterator it2 = t4.iterator();
                kotlin.jvm.internal.m.d(it2, "iterator(...)");
                while (it2.hasNext()) {
                    Object next2 = it2.next();
                    kotlin.jvm.internal.m.d(next2, "next(...)");
                    C2038F f4 = (C2038F) next2;
                    if (kotlin.jvm.internal.m.a(f4.c(), fVar.r())) {
                        fVar.X(f4);
                    }
                }
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public final ArrayList O(ArrayList arrayList) {
        C1601o.t(arrayList, new C2219A());
        if (getContext() != null) {
            t.a aVar = t.f21927u;
            Context requireContext = requireContext();
            kotlin.jvm.internal.m.d(requireContext, "requireContext(...)");
            t a5 = aVar.a(requireContext);
            a5.a();
            ArrayList F02 = a5.F0();
            a5.i();
            Iterator it = F02.iterator();
            kotlin.jvm.internal.m.d(it, "iterator(...)");
            while (it.hasNext()) {
                Object next = it.next();
                kotlin.jvm.internal.m.d(next, "next(...)");
                S s4 = (S) next;
                int size = arrayList.size();
                for (int i4 = 0; i4 < size; i4++) {
                    if (m3.m.p(s4.h(), ((C2048f) arrayList.get(i4)).o(), true) && s4.j() > ((C2048f) arrayList.get(i4)).A()) {
                        ((C2048f) arrayList.get(i4)).c0(C2048f.c.OUTDATED);
                    }
                }
            }
        }
        C1601o.t(arrayList, new C2222D(new C2221C()));
        if (getContext() != null) {
            String packageName = requireContext().getPackageName();
            int i5 = 0;
            while (i5 < arrayList.size() && (!m3.m.p(packageName, ((C2048f) arrayList.get(i5)).o(), true) || ((C2048f) arrayList.get(i5)).w() != C2048f.c.OUTDATED)) {
                i5++;
            }
            if (i5 < arrayList.size()) {
                Object remove = arrayList.remove(i5);
                kotlin.jvm.internal.m.d(remove, "removeAt(...)");
                arrayList.add(0, (C2048f) remove);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public static final int P(C2048f fVar, C2048f fVar2) {
        kotlin.jvm.internal.m.e(fVar, "app1");
        kotlin.jvm.internal.m.e(fVar2, "app2");
        if (fVar.m() == null) {
            return 1;
        }
        if (fVar2.m() == null) {
            return -1;
        }
        String m4 = fVar.m();
        kotlin.jvm.internal.m.b(m4);
        String m5 = fVar2.m();
        kotlin.jvm.internal.m.b(m5);
        return m3.m.j(m4, m5, true);
    }

    /* access modifiers changed from: private */
    public static final int Q(C2048f fVar, C2048f fVar2) {
        kotlin.jvm.internal.m.e(fVar, "app1");
        kotlin.jvm.internal.m.e(fVar2, "app2");
        return fVar.w().compareTo(fVar2.w());
    }

    /* access modifiers changed from: private */
    public static final int R(p pVar, Object obj, Object obj2) {
        return ((Number) pVar.invoke(obj, obj2)).intValue();
    }

    private final void S() {
        VerticalGridPresenter verticalGridPresenter = new VerticalGridPresenter();
        verticalGridPresenter.setNumberOfColumns(this.f19368f);
        setGridPresenter(verticalGridPresenter);
        new Handler(Looper.getMainLooper()).postDelayed(new C2224F(this), 500);
        setOnItemViewClickedListener(new b());
    }

    /* access modifiers changed from: private */
    public static final void T(TvMyAppsFragment tvMyAppsFragment) {
        tvMyAppsFragment.startEntranceTransition();
    }

    private final void z(String str) {
        FragmentActivity activity = getActivity();
        if (activity != null && !activity.isFinishing()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(activity);
            builder.setMessage(str);
            builder.setPositiveButton(17039370, new C2223E());
            builder.setCancelable(true);
            builder.create().show();
        }
    }

    public final void I() {
        K();
    }

    public void onCreate(Bundle bundle) {
        Bundle extras;
        super.onCreate(bundle);
        x xVar = new x(getContext());
        String simpleName = TvMyAppsFragment.class.getSimpleName();
        kotlin.jvm.internal.m.d(simpleName, "getSimpleName(...)");
        xVar.e(simpleName);
        a aVar = new a(new m());
        this.f19364b = aVar;
        setAdapter(aVar);
        FragmentActivity activity = getActivity();
        if (!(activity == null || (extras = activity.getIntent().getExtras()) == null)) {
            if (extras.containsKey("updates")) {
                this.f19366d = extras.getBoolean("updates");
            }
            if (extras.containsKey("rollback")) {
                this.f19367e = extras.getBoolean("rollback");
            }
        }
        if (this.f19366d) {
            setTitle(getString(R.string.updates));
        } else if (this.f19367e) {
            setTitle(getString(R.string.rollback_title));
        } else {
            setTitle(getString(R.string.installed));
        }
        if (bundle == null) {
            prepareEntranceTransition();
        }
        S();
    }

    public void onResume() {
        super.onResume();
        K();
    }
}
