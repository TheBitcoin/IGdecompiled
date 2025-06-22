package r2;

import S2.C1601o;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import androidx.leanback.app.RowsSupportFragment;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.HeaderItem;
import androidx.leanback.widget.ListRow;
import androidx.leanback.widget.ListRowPresenter;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.Row;
import androidx.leanback.widget.RowPresenter;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import b2.C1634f;
import b2.C1640l;
import com.mbridge.msdk.MBridgeConstans;
import com.uptodown.activities.preferences.PreferencesActivity;
import com.uptodown.tv.ui.activity.TvAppsListActivity;
import com.uptodown.tv.ui.activity.TvMyAppsActivity;
import com.uptodown.tv.ui.activity.TvMyDownloadsActivity;
import f2.C2024o;
import f2.C2027s;
import g2.C2050h;
import g2.C2053k;
import g2.Q;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.m;
import n2.c;
import p2.d;
import p2.f;
import p2.g;
import p2.h;
import p2.i;
import p2.q;
import q2.C2209b;
import u2.x;

/* renamed from: r2.t  reason: case insensitive filesystem */
public final class C2256t extends RowsSupportFragment {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public C2050h f21658a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public C2050h f21659b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public ArrayList f21660c = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public ArrayList f21661d = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public ArrayList f21662e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    private ArrayObjectAdapter f21663f;

    /* renamed from: g  reason: collision with root package name */
    private int f21664g;

    public C2256t() {
        ListRowPresenter listRowPresenter = new ListRowPresenter(0);
        listRowPresenter.setShadowEnabled(false);
        listRowPresenter.setSelectEffectEnabled(false);
        ArrayObjectAdapter arrayObjectAdapter = new ArrayObjectAdapter((Presenter) listRowPresenter);
        this.f21663f = arrayObjectAdapter;
        setAdapter(arrayObjectAdapter);
    }

    private final void A() {
        a aVar = new a(this);
        if (getContext() != null) {
            Context requireContext = requireContext();
            m.d(requireContext, "requireContext(...)");
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            m.d(viewLifecycleOwner, "getViewLifecycleOwner(...)");
            new C1634f(requireContext, aVar, LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner));
        }
    }

    /* access modifiers changed from: private */
    public static final void B(C2256t tVar, Presenter.ViewHolder viewHolder, Object obj, RowPresenter.ViewHolder viewHolder2, Row row) {
        if (obj instanceof C2050h) {
            if (viewHolder != null) {
                Context requireContext = tVar.requireContext();
                m.d(requireContext, "requireContext(...)");
                new C1640l(requireContext, ((C2050h) obj).e(), new b(tVar, viewHolder), LifecycleOwnerKt.getLifecycleScope(tVar));
            }
        } else if (obj instanceof n2.b) {
            int b5 = ((n2.b) obj).b();
            Class<TvMyAppsActivity> cls = TvMyAppsActivity.class;
            if (b5 == 0) {
                Intent intent = new Intent(tVar.getContext(), cls);
                intent.putExtra("updates", true);
                tVar.startActivity(intent);
            } else if (b5 == 1) {
                tVar.startActivity(new Intent(tVar.getContext(), cls));
            } else if (b5 == 2) {
                Intent intent2 = new Intent(tVar.getContext(), cls);
                intent2.putExtra("rollback", true);
                tVar.startActivity(intent2);
            } else if (b5 == 3) {
                tVar.startActivity(new Intent(tVar.getContext(), TvMyDownloadsActivity.class));
            } else if (b5 == 4) {
                tVar.startActivity(new Intent(tVar.getContext(), PreferencesActivity.class));
            }
        } else {
            Class<TvAppsListActivity> cls2 = TvAppsListActivity.class;
            if (obj instanceof c) {
                Intent intent3 = new Intent(tVar.getContext(), cls2);
                intent3.putExtra("category", ((c) obj).a());
                tVar.startActivity(intent3);
            } else if (obj instanceof C2053k) {
                Intent intent4 = new Intent(tVar.getContext(), cls2);
                intent4.putExtra("category", (Parcelable) obj);
                tVar.startActivity(intent4);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void r(ArrayList arrayList) {
        ArrayObjectAdapter arrayObjectAdapter = new ArrayObjectAdapter((Presenter) new g());
        arrayObjectAdapter.addAll(0, arrayList);
        this.f21663f.add(new ListRow(arrayObjectAdapter));
    }

    private final void s(ArrayList arrayList, int i4) {
        Iterator it = arrayList.iterator();
        int i5 = 0;
        while (true) {
            if (!it.hasNext()) {
                i5 = -1;
                break;
            }
            int i6 = i5 + 1;
            Q q4 = (Q) it.next();
            if (q4.b().b() == i4) {
                w(q4);
                break;
            }
            i5 = i6;
        }
        if (i5 >= 0) {
            arrayList.remove(i5);
        }
    }

    private final void t(C2050h hVar) {
        if (getContext() != null) {
            Context requireContext = requireContext();
            m.d(requireContext, "requireContext(...)");
            ArrayObjectAdapter arrayObjectAdapter = new ArrayObjectAdapter((Presenter) new d(requireContext));
            arrayObjectAdapter.add(hVar);
            this.f21663f.add(new ListRow(arrayObjectAdapter));
        }
    }

    private final void u(Q q4) {
        if (getContext() != null) {
            HeaderItem headerItem = new HeaderItem(q4.b().d());
            Context requireContext = requireContext();
            m.d(requireContext, "requireContext(...)");
            ArrayObjectAdapter arrayObjectAdapter = new ArrayObjectAdapter((Presenter) new h(requireContext));
            arrayObjectAdapter.addAll(0, q4.a());
            c cVar = new c();
            cVar.b(q4.b());
            arrayObjectAdapter.add(cVar);
            this.f21663f.add(new ListRow(headerItem, arrayObjectAdapter));
        }
    }

    /* access modifiers changed from: private */
    public final void v(C2050h hVar) {
        ArrayObjectAdapter arrayObjectAdapter = new ArrayObjectAdapter((Presenter) new q());
        arrayObjectAdapter.add(hVar);
        this.f21663f.add(new ListRow(arrayObjectAdapter));
    }

    private final void w(Q q4) {
        if (getContext() != null) {
            HeaderItem headerItem = new HeaderItem(q4.b().d());
            Context requireContext = requireContext();
            m.d(requireContext, "requireContext(...)");
            ArrayObjectAdapter arrayObjectAdapter = new ArrayObjectAdapter((Presenter) new i(requireContext));
            arrayObjectAdapter.addAll(0, q4.a());
            c cVar = new c();
            cVar.b(q4.b());
            arrayObjectAdapter.add(cVar);
            this.f21663f.add(new ListRow(headerItem, arrayObjectAdapter));
        }
    }

    private final void x(Q q4) {
        if (getContext() != null) {
            HeaderItem headerItem = new HeaderItem(q4.b().d());
            Context requireContext = requireContext();
            m.d(requireContext, "requireContext(...)");
            ArrayObjectAdapter arrayObjectAdapter = new ArrayObjectAdapter((Presenter) new f(requireContext));
            arrayObjectAdapter.addAll(0, q4.a());
            c cVar = new c();
            cVar.b(q4.b());
            arrayObjectAdapter.add(cVar);
            this.f21663f.add(new ListRow(headerItem, arrayObjectAdapter));
        }
    }

    private final void y() {
        if (!this.f21662e.isEmpty()) {
            Object obj = this.f21662e.get(0);
            m.d(obj, "get(...)");
            u((Q) obj);
        }
        if (!this.f21661d.isEmpty()) {
            s(this.f21661d, -2);
        }
        C2050h hVar = this.f21659b;
        if (hVar != null) {
            m.b(hVar);
            t(hVar);
        }
        if (!this.f21662e.isEmpty() && this.f21662e.size() > 1) {
            Object obj2 = this.f21662e.get(1);
            m.d(obj2, "get(...)");
            u((Q) obj2);
        }
        if (!this.f21661d.isEmpty()) {
            s(this.f21661d, -1);
        }
        if (!this.f21662e.isEmpty() && this.f21662e.size() > 2) {
            Object obj3 = this.f21662e.get(2);
            m.d(obj3, "get(...)");
            u((Q) obj3);
        }
        if (!this.f21661d.isEmpty()) {
            s(this.f21661d, 521);
        }
        if (!this.f21661d.isEmpty()) {
            s(this.f21661d, 523);
        }
        if (!this.f21661d.isEmpty()) {
            s(this.f21661d, 524);
        }
        if (!this.f21661d.isEmpty()) {
            Iterator it = this.f21661d.iterator();
            m.d(it, "iterator(...)");
            while (it.hasNext()) {
                Object next = it.next();
                m.d(next, "next(...)");
                x((Q) next);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void z() {
        int i4 = this.f21664g;
        if (i4 < 4) {
            this.f21664g = i4 + 1;
        } else {
            y();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x xVar = new x(getContext());
        String simpleName = C2256t.class.getSimpleName();
        m.d(simpleName, "getSimpleName(...)");
        xVar.e(simpleName);
    }

    public void onResume() {
        super.onResume();
        if (this.f21658a == null || this.f21660c.isEmpty()) {
            A();
        } else {
            getMainFragmentAdapter().getFragmentHost().notifyDataReady(getMainFragmentAdapter());
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        m.e(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        super.onViewCreated(view, bundle);
        setOnItemViewClickedListener(new C2255s(this));
    }

    /* renamed from: r2.t$a */
    public static final class a implements C2024o {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2256t f21665a;

        a(C2256t tVar) {
            this.f21665a = tVar;
        }

        public void a(Q q4) {
            m.e(q4, "topHorizontalTopReceived");
            this.f21665a.f21661d.add(q4);
            this.f21665a.z();
        }

        public void b(ArrayList arrayList) {
            m.e(arrayList, "miniTopsReceived");
            this.f21665a.f21661d.addAll(arrayList);
            this.f21665a.z();
        }

        public void c(Q q4) {
            m.e(q4, "topHorizontalNewReleasesReceived");
            this.f21665a.f21661d.add(q4);
        }

        public void d(ArrayList arrayList) {
            m.e(arrayList, "homeFeaturesReceived");
            if (arrayList.size() > 0) {
                this.f21665a.f21658a = (C2050h) C1601o.H(arrayList);
                C2256t tVar = this.f21665a;
                C2050h n4 = tVar.f21658a;
                m.b(n4);
                tVar.v(n4);
            }
            this.f21665a.getMainFragmentAdapter().getFragmentHost().notifyDataReady(this.f21665a.getMainFragmentAdapter());
        }

        public void e(C2050h hVar) {
            m.e(hVar, "appInfoReceived");
        }

        public void f(Q q4) {
            m.e(q4, "topByCategory");
            this.f21665a.f21662e.add(q4);
        }

        public void g(C2050h hVar) {
            m.e(hVar, "appReplacement");
        }

        public void i(Q q4) {
            m.e(q4, "topHorizontalLatestReceived");
            this.f21665a.f21661d.add(q4);
            this.f21665a.z();
        }

        public void j(ArrayList arrayList) {
            m.e(arrayList, "recentFeaturedReceived");
            this.f21665a.f21659b = (C2050h) C1601o.H(arrayList);
            this.f21665a.z();
        }

        public void k(ArrayList arrayList) {
            m.e(arrayList, "floatingMiniTopsReceived");
            this.f21665a.f21662e.addAll(arrayList);
            this.f21665a.z();
        }

        public void l(ArrayList arrayList) {
            m.e(arrayList, "categoriesReceived");
            this.f21665a.f21660c = arrayList;
            C2256t tVar = this.f21665a;
            tVar.r(tVar.f21660c);
        }

        public void h() {
        }
    }

    /* renamed from: r2.t$b */
    public static final class b implements C2027s {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2256t f21666a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Presenter.ViewHolder f21667b;

        b(C2256t tVar, Presenter.ViewHolder viewHolder) {
            this.f21666a = tVar;
            this.f21667b = viewHolder;
        }

        public void c(C2050h hVar) {
            m.e(hVar, "appInfo");
            if (this.f21666a.getActivity() != null && (this.f21666a.getActivity() instanceof C2209b)) {
                try {
                    C2209b bVar = (C2209b) this.f21666a.getActivity();
                    m.b(bVar);
                    bVar.l(hVar, this.f21667b);
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
        }

        public void b(int i4) {
        }
    }
}
