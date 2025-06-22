package com.uptodown.tv.ui.fragment;

import R2.n;
import R2.s;
import V2.g;
import W1.G;
import android.app.AlertDialog;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.leanback.app.BrowseSupportFragment;
import androidx.leanback.app.VerticalGridSupportFragment;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.OnItemViewClickedListener;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.Row;
import androidx.leanback.widget.RowPresenter;
import androidx.leanback.widget.VerticalGridPresenter;
import androidx.lifecycle.LifecycleOwnerKt;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import d3.p;
import g2.C2060s;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import o3.C0977g;
import o3.C1001s0;
import o3.E0;
import o3.J;
import o3.L;
import o3.Y;
import r2.C2230L;
import r2.C2231M;
import u2.C2313C;
import u2.t;
import u2.w;
import u2.x;

public final class TvMyDownloadsFragment extends VerticalGridSupportFragment implements BrowseSupportFragment.MainFragmentAdapterProvider {

    /* renamed from: e  reason: collision with root package name */
    public static final a f19379e = new a((C2103g) null);

    /* renamed from: a  reason: collision with root package name */
    private ArrayObjectAdapter f19380a;

    /* renamed from: b  reason: collision with root package name */
    private AlertDialog f19381b;

    /* renamed from: c  reason: collision with root package name */
    private final BrowseSupportFragment.MainFragmentAdapter f19382c = new d(this);
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public ArrayList f19383d = new ArrayList();

    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        private a() {
        }
    }

    private final class b implements OnItemViewClickedListener {
        public b() {
        }

        /* renamed from: a */
        public void onItemClicked(Presenter.ViewHolder viewHolder, Object obj, RowPresenter.ViewHolder viewHolder2, Row row) {
            if (obj instanceof File) {
                TvMyDownloadsFragment.this.n((File) obj);
            }
        }
    }

    static final class c extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f19385a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ TvMyDownloadsFragment f19386b;

        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f19387a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ TvMyDownloadsFragment f19388b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(TvMyDownloadsFragment tvMyDownloadsFragment, V2.d dVar) {
                super(2, dVar);
                this.f19388b = tvMyDownloadsFragment;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new a(this.f19388b, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f19387a == 0) {
                    n.b(obj);
                    if (this.f19388b.f19383d != null) {
                        this.f19388b.q();
                    }
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(TvMyDownloadsFragment tvMyDownloadsFragment, V2.d dVar) {
            super(2, dVar);
            this.f19386b = tvMyDownloadsFragment;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new c(this.f19386b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f19385a;
            if (i4 == 0) {
                n.b(obj);
                try {
                    ArrayList arrayList = new ArrayList();
                    if (this.f19386b.getContext() != null) {
                        w wVar = new w();
                        Context requireContext = this.f19386b.requireContext();
                        m.d(requireContext, "requireContext(...)");
                        ArrayList d5 = wVar.d(requireContext);
                        d5.addAll(new w().a());
                        PackageManager packageManager = this.f19386b.requireContext().getPackageManager();
                        Iterator it = d5.iterator();
                        m.d(it, "iterator(...)");
                        while (it.hasNext()) {
                            Object next = it.next();
                            m.d(next, "next(...)");
                            File file = (File) next;
                            String name = file.getName();
                            m.d(name, "getName(...)");
                            boolean z4 = false;
                            if (m3.m.o(name, ".apk", false, 2, (Object) null)) {
                                m.b(packageManager);
                                String absolutePath = file.getAbsolutePath();
                                m.d(absolutePath, "getAbsolutePath(...)");
                                PackageInfo c6 = W1.s.c(packageManager, absolutePath, 128);
                                if (c6 != null) {
                                    try {
                                        Bundle bundle = c6.applicationInfo.metaData;
                                        if (bundle != null && bundle.containsKey("com.android.vending.splits.required")) {
                                            Object obj2 = c6.applicationInfo.metaData.get("com.android.vending.splits.required");
                                            m.c(obj2, "null cannot be cast to non-null type kotlin.Boolean");
                                            z4 = ((Boolean) obj2).booleanValue();
                                        }
                                    } catch (Exception e5) {
                                        e5.printStackTrace();
                                    }
                                    if (!z4) {
                                        arrayList.add(file);
                                    }
                                } else {
                                    String name2 = file.getName();
                                    m.d(name2, "getName(...)");
                                    if (!m3.m.y(name2, "split_config", false, 2, (Object) null)) {
                                        arrayList.add(file);
                                    }
                                }
                            } else {
                                G.a aVar = G.f8470b;
                                String name3 = file.getName();
                                m.d(name3, "getName(...)");
                                if (aVar.a(name3)) {
                                    arrayList.add(file);
                                }
                            }
                        }
                        this.f19386b.f19383d = arrayList;
                    }
                } catch (Exception e6) {
                    e6.printStackTrace();
                }
                E0 c7 = Y.c();
                a aVar2 = new a(this.f19386b, (V2.d) null);
                this.f19385a = 1;
                if (C0977g.g(c7, aVar2, this) == c5) {
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
            return ((c) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public static final class d extends BrowseSupportFragment.MainFragmentAdapter {
        d(TvMyDownloadsFragment tvMyDownloadsFragment) {
            super(tvMyDownloadsFragment);
        }

        public void setEntranceTransitionState(boolean z4) {
        }
    }

    static final class e extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f19389a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ TvMyDownloadsFragment f19390b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(TvMyDownloadsFragment tvMyDownloadsFragment, V2.d dVar) {
            super(2, dVar);
            this.f19390b = tvMyDownloadsFragment;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new e(this.f19390b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f19389a;
            if (i4 == 0) {
                n.b(obj);
                TvMyDownloadsFragment tvMyDownloadsFragment = this.f19390b;
                this.f19389a = 1;
                if (tvMyDownloadsFragment.r(this) == c5) {
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
            return ((e) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    /* access modifiers changed from: private */
    public final void n(File file) {
        AlertDialog alertDialog = this.f19381b;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        if (getActivity() != null && !requireActivity().isFinishing() && file != null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            LayoutInflater layoutInflater = getLayoutInflater();
            m.d(layoutInflater, "getLayoutInflater(...)");
            View inflate = layoutInflater.inflate(R.layout.tv_apk_clicked_dialog, (ViewGroup) null, false);
            ((TextView) inflate.findViewById(R.id.tv_install)).setOnClickListener(new C2230L(this, file));
            ((TextView) inflate.findViewById(R.id.tv_delete)).setOnClickListener(new C2231M(file, this));
            builder.setView(inflate);
            AlertDialog create = builder.create();
            this.f19381b = create;
            if (create != null) {
                create.show();
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void o(TvMyDownloadsFragment tvMyDownloadsFragment, File file, View view) {
        t.a aVar = t.f21927u;
        Context requireContext = tvMyDownloadsFragment.requireContext();
        m.d(requireContext, "requireContext(...)");
        t a5 = aVar.a(requireContext);
        a5.a();
        String name = file.getName();
        m.d(name, "getName(...)");
        C2060s d02 = a5.d0(name);
        a5.i();
        if (d02 != null && d02.f()) {
            UptodownApp.a aVar2 = UptodownApp.f17422D;
            FragmentActivity requireActivity = tvMyDownloadsFragment.requireActivity();
            m.d(requireActivity, "requireActivity(...)");
            UptodownApp.a.Y(aVar2, file, requireActivity, (String) null, 4, (Object) null);
        }
        AlertDialog alertDialog = tvMyDownloadsFragment.f19381b;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    /* access modifiers changed from: private */
    public static final void p(File file, TvMyDownloadsFragment tvMyDownloadsFragment, View view) {
        if (file.delete()) {
            t.a aVar = t.f21927u;
            Context requireContext = tvMyDownloadsFragment.requireContext();
            m.d(requireContext, "requireContext(...)");
            t a5 = aVar.a(requireContext);
            a5.a();
            String name = file.getName();
            m.d(name, "getName(...)");
            a5.A(name);
            a5.i();
            ArrayObjectAdapter arrayObjectAdapter = tvMyDownloadsFragment.f19380a;
            m.b(arrayObjectAdapter);
            arrayObjectAdapter.remove(file);
        }
        AlertDialog alertDialog = tvMyDownloadsFragment.f19381b;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    /* access modifiers changed from: private */
    public final void q() {
        ArrayObjectAdapter arrayObjectAdapter = this.f19380a;
        m.b(arrayObjectAdapter);
        arrayObjectAdapter.clear();
        ArrayList arrayList = this.f19383d;
        m.b(arrayList);
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            ArrayObjectAdapter arrayObjectAdapter2 = this.f19380a;
            m.b(arrayObjectAdapter2);
            ArrayList arrayList2 = this.f19383d;
            m.b(arrayList2);
            arrayObjectAdapter2.add(arrayList2.get(i4));
        }
    }

    /* access modifiers changed from: private */
    public final Object r(V2.d dVar) {
        Object g4 = C0977g.g(Y.b(), new c(this, (V2.d) null), dVar);
        if (g4 == W2.b.c()) {
            return g4;
        }
        return s.f8222a;
    }

    private final void s() {
        VerticalGridPresenter verticalGridPresenter = new VerticalGridPresenter();
        verticalGridPresenter.setNumberOfColumns(2);
        setGridPresenter(verticalGridPresenter);
        startEntranceTransition();
        setOnItemViewClickedListener(new b());
    }

    public BrowseSupportFragment.MainFragmentAdapter getMainFragmentAdapter() {
        return this.f19382c;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x xVar = new x(getContext());
        String simpleName = TvMyDownloadsFragment.class.getSimpleName();
        m.d(simpleName, "getSimpleName(...)");
        xVar.e(simpleName);
        ArrayObjectAdapter arrayObjectAdapter = new ArrayObjectAdapter((Presenter) new p2.n());
        this.f19380a = arrayObjectAdapter;
        setAdapter(arrayObjectAdapter);
        setTitle(getString(R.string.downloads_title));
        if (bundle == null) {
            prepareEntranceTransition();
        }
        s();
    }

    public void onPause() {
        try {
            t.a aVar = t.f21927u;
            Context requireContext = requireContext();
            m.d(requireContext, "requireContext(...)");
            t a5 = aVar.a(requireContext);
            a5.a();
            a5.n1();
            a5.i();
        } catch (Exception e5) {
            e5.printStackTrace();
        }
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        Context context = getContext();
        if (context != null) {
            C2313C.f21882a.h(context);
        }
        C1001s0 unused = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), (g) null, (L) null, new e(this, (V2.d) null), 3, (Object) null);
    }

    public final void t(int i4) {
        switch (i4) {
            case 201:
                ArrayObjectAdapter arrayObjectAdapter = this.f19380a;
                m.b(arrayObjectAdapter);
                ArrayObjectAdapter arrayObjectAdapter2 = this.f19380a;
                m.b(arrayObjectAdapter2);
                arrayObjectAdapter.notifyArrayItemRangeChanged(0, arrayObjectAdapter2.size());
                return;
            case 202:
            case 203:
                ArrayObjectAdapter arrayObjectAdapter3 = this.f19380a;
                m.b(arrayObjectAdapter3);
                ArrayObjectAdapter arrayObjectAdapter4 = this.f19380a;
                m.b(arrayObjectAdapter4);
                arrayObjectAdapter3.notifyArrayItemRangeChanged(0, arrayObjectAdapter4.size());
                return;
            default:
                return;
        }
    }
}
