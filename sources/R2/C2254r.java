package r2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.leanback.app.RowsSupportFragment;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.HeaderItem;
import androidx.leanback.widget.ListRow;
import androidx.leanback.widget.ListRowPresenter;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.Row;
import androidx.leanback.widget.RowPresenter;
import androidx.lifecycle.LifecycleOwnerKt;
import b2.C1635g;
import b2.C1640l;
import com.mbridge.msdk.MBridgeConstans;
import com.uptodown.R;
import com.uptodown.activities.preferences.PreferencesActivity;
import com.uptodown.tv.ui.activity.TvAppsListActivity;
import com.uptodown.tv.ui.activity.TvMyAppsActivity;
import com.uptodown.tv.ui.activity.TvMyDownloadsActivity;
import f2.C2025p;
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

/* renamed from: r2.r  reason: case insensitive filesystem */
public final class C2254r extends RowsSupportFragment {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public boolean f21652a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayObjectAdapter f21653b;

    /* renamed from: r2.r$a */
    public static final class a implements C2025p {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2254r f21654a;

        a(C2254r rVar) {
            this.f21654a = rVar;
        }

        public void a(ArrayList arrayList) {
            m.e(arrayList, "featuredByCategory");
            if (!arrayList.isEmpty()) {
                C2254r rVar = this.f21654a;
                Object obj = arrayList.get(0);
                m.d(obj, "get(...)");
                rVar.p((C2050h) obj);
                this.f21654a.getMainFragmentAdapter().getFragmentHost().notifyDataReady(this.f21654a.getMainFragmentAdapter());
            }
        }

        public void b(ArrayList arrayList) {
            m.e(arrayList, "categoryChildren");
            this.f21654a.k(arrayList);
            this.f21654a.getMainFragmentAdapter().getFragmentHost().notifyDataReady(this.f21654a.getMainFragmentAdapter());
        }

        public void c(ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, int i4) {
            FragmentManager supportFragmentManager;
            FragmentTransaction beginTransaction;
            FragmentTransaction replace;
            FragmentTransaction addToBackStack;
            m.e(arrayList, "featuredByCategory");
            m.e(arrayList2, "categoryChildren");
            m.e(arrayList3, "miniTops");
            if (i4 <= 1) {
                this.f21654a.s(arrayList, arrayList2, arrayList3);
                this.f21654a.getMainFragmentAdapter().getFragmentHost().notifyDataReady(this.f21654a.getMainFragmentAdapter());
                return;
            }
            this.f21654a.f21652a = false;
            C2252p pVar = new C2252p();
            FragmentActivity activity = this.f21654a.getActivity();
            if (activity != null && (supportFragmentManager = activity.getSupportFragmentManager()) != null && (beginTransaction = supportFragmentManager.beginTransaction()) != null && (replace = beginTransaction.replace(R.id.fragmentContainer, pVar)) != null && (addToBackStack = replace.addToBackStack((String) null)) != null) {
                addToBackStack.commit();
            }
        }
    }

    public C2254r() {
        ListRowPresenter listRowPresenter = new ListRowPresenter(0);
        listRowPresenter.setShadowEnabled(false);
        listRowPresenter.setSelectEffectEnabled(false);
        ArrayObjectAdapter arrayObjectAdapter = new ArrayObjectAdapter((Presenter) listRowPresenter);
        this.f21653b = arrayObjectAdapter;
        setAdapter(arrayObjectAdapter);
    }

    /* access modifiers changed from: private */
    public final void k(ArrayList arrayList) {
        ArrayObjectAdapter arrayObjectAdapter = new ArrayObjectAdapter((Presenter) new g());
        arrayObjectAdapter.addAll(0, arrayList);
        this.f21653b.add(new ListRow(arrayObjectAdapter));
    }

    private final void l(ArrayList arrayList, int i4) {
        Iterator it = arrayList.iterator();
        m.d(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            m.d(next, "next(...)");
            Q q4 = (Q) next;
            if (q4.b().b() == i4) {
                q(q4);
                arrayList.remove(q4);
                return;
            }
        }
    }

    private final void m(C2050h hVar) {
        if (getContext() != null) {
            Context requireContext = requireContext();
            m.d(requireContext, "requireContext(...)");
            ArrayObjectAdapter arrayObjectAdapter = new ArrayObjectAdapter((Presenter) new d(requireContext));
            arrayObjectAdapter.add(hVar);
            this.f21653b.add(new ListRow(arrayObjectAdapter));
            return;
        }
        this.f21652a = false;
    }

    private final void n(ArrayList arrayList, int i4) {
        Iterator it = arrayList.iterator();
        m.d(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            m.d(next, "next(...)");
            Q q4 = (Q) next;
            if (q4.b().b() == i4) {
                o(q4);
                arrayList.remove(q4);
                return;
            }
        }
    }

    private final void o(Q q4) {
        if (getContext() != null) {
            HeaderItem headerItem = new HeaderItem(q4.b().d());
            Context requireContext = requireContext();
            m.d(requireContext, "requireContext(...)");
            ArrayObjectAdapter arrayObjectAdapter = new ArrayObjectAdapter((Presenter) new h(requireContext));
            arrayObjectAdapter.addAll(0, q4.a());
            c cVar = new c();
            cVar.b(q4.b());
            arrayObjectAdapter.add(cVar);
            this.f21653b.add(new ListRow(headerItem, arrayObjectAdapter));
            return;
        }
        this.f21652a = false;
    }

    /* access modifiers changed from: private */
    public final void p(C2050h hVar) {
        ArrayObjectAdapter arrayObjectAdapter = new ArrayObjectAdapter((Presenter) new q());
        arrayObjectAdapter.add(hVar);
        this.f21653b.add(new ListRow(arrayObjectAdapter));
    }

    private final void q(Q q4) {
        if (getContext() != null) {
            HeaderItem headerItem = new HeaderItem(q4.b().d());
            Context requireContext = requireContext();
            m.d(requireContext, "requireContext(...)");
            ArrayObjectAdapter arrayObjectAdapter = new ArrayObjectAdapter((Presenter) new i(requireContext));
            arrayObjectAdapter.addAll(0, q4.a());
            c cVar = new c();
            cVar.b(q4.b());
            arrayObjectAdapter.add(cVar);
            this.f21653b.add(new ListRow(headerItem, arrayObjectAdapter));
            return;
        }
        this.f21652a = false;
    }

    private final void r(Q q4) {
        if (getContext() != null) {
            HeaderItem headerItem = new HeaderItem(q4.b().d());
            Context requireContext = requireContext();
            m.d(requireContext, "requireContext(...)");
            ArrayObjectAdapter arrayObjectAdapter = new ArrayObjectAdapter((Presenter) new f(requireContext));
            arrayObjectAdapter.addAll(0, q4.a());
            c cVar = new c();
            cVar.b(q4.b());
            arrayObjectAdapter.add(cVar);
            this.f21653b.add(new ListRow(headerItem, arrayObjectAdapter));
            return;
        }
        this.f21652a = false;
    }

    /* access modifiers changed from: private */
    public static final void u(C2254r rVar, Presenter.ViewHolder viewHolder, Object obj, RowPresenter.ViewHolder viewHolder2, Row row) {
        if (obj instanceof C2050h) {
            if (viewHolder != null && rVar.getContext() != null) {
                Context requireContext = rVar.requireContext();
                m.d(requireContext, "requireContext(...)");
                new C1640l(requireContext, ((C2050h) obj).e(), new b(rVar, viewHolder), LifecycleOwnerKt.getLifecycleScope(rVar));
            }
        } else if (obj instanceof n2.b) {
            int b5 = ((n2.b) obj).b();
            Class<TvMyAppsActivity> cls = TvMyAppsActivity.class;
            if (b5 == 0) {
                Intent intent = new Intent(rVar.getContext(), cls);
                intent.putExtra("updates", true);
                rVar.startActivity(intent);
            } else if (b5 == 1) {
                rVar.startActivity(new Intent(rVar.getContext(), cls));
            } else if (b5 == 2) {
                Intent intent2 = new Intent(rVar.getContext(), cls);
                intent2.putExtra("rollback", true);
                rVar.startActivity(intent2);
            } else if (b5 == 3) {
                rVar.startActivity(new Intent(rVar.getContext(), TvMyDownloadsActivity.class));
            } else if (b5 == 4) {
                rVar.startActivity(new Intent(rVar.getContext(), PreferencesActivity.class));
            }
        } else {
            Class<TvAppsListActivity> cls2 = TvAppsListActivity.class;
            if (obj instanceof c) {
                Intent intent3 = new Intent(rVar.getContext(), cls2);
                intent3.putExtra("category", ((c) obj).a());
                rVar.startActivity(intent3);
            } else if (obj instanceof C2053k) {
                Intent intent4 = new Intent(rVar.getContext(), cls2);
                intent4.putExtra("category", (Parcelable) obj);
                rVar.startActivity(intent4);
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x xVar = new x(getContext());
        String simpleName = C2254r.class.getSimpleName();
        m.d(simpleName, "getSimpleName(...)");
        xVar.e(simpleName);
    }

    public void onResume() {
        super.onResume();
        if (!this.f21652a) {
            this.f21653b.clear();
            t();
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        m.e(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        super.onViewCreated(view, bundle);
        setOnItemViewClickedListener(new C2253q(this));
    }

    public final void s(ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3) {
        m.e(arrayList, "featuredByCategory");
        m.e(arrayList2, "categories");
        m.e(arrayList3, "miniTops");
        this.f21652a = true;
        if (!arrayList3.isEmpty()) {
            l(arrayList3, -2);
        }
        if (!arrayList3.isEmpty()) {
            n(arrayList3, -1);
        }
        if (!arrayList.isEmpty() && arrayList.size() > 1) {
            Object obj = arrayList.get(1);
            m.d(obj, "get(...)");
            m((C2050h) obj);
        }
        if (!arrayList2.isEmpty() && ((C2053k) arrayList2.get(0)).e() == 523) {
            if (!arrayList3.isEmpty()) {
                n(arrayList3, 558);
            }
            if (!arrayList3.isEmpty()) {
                n(arrayList3, 566);
            }
            if (!arrayList3.isEmpty()) {
                n(arrayList3, 562);
            }
            if (!arrayList3.isEmpty()) {
                n(arrayList3, 564);
            }
            if (!arrayList3.isEmpty()) {
                n(arrayList3, 559);
            }
            if (!arrayList3.isEmpty()) {
                l(arrayList3, 645);
            }
            if (!arrayList3.isEmpty()) {
                n(arrayList3, 560);
            }
            if (!arrayList3.isEmpty()) {
                l(arrayList3, 561);
            }
            if (!arrayList3.isEmpty()) {
                n(arrayList3, 565);
            }
            if (!arrayList3.isEmpty()) {
                l(arrayList3, 593);
            }
            if (!arrayList3.isEmpty()) {
                l(arrayList3, 568);
            }
        }
        if (!arrayList3.isEmpty()) {
            Iterator it = arrayList3.iterator();
            m.d(it, "iterator(...)");
            while (it.hasNext()) {
                Object next = it.next();
                m.d(next, "next(...)");
                r((Q) next);
            }
        }
    }

    public final void t() {
        a aVar = new a(this);
        if (getContext() != null) {
            Context requireContext = requireContext();
            m.d(requireContext, "requireContext(...)");
            new C1635g(requireContext, aVar, LifecycleOwnerKt.getLifecycleScope(this));
        }
    }

    /* renamed from: r2.r$b */
    public static final class b implements C2027s {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2254r f21655a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Presenter.ViewHolder f21656b;

        b(C2254r rVar, Presenter.ViewHolder viewHolder) {
            this.f21655a = rVar;
            this.f21656b = viewHolder;
        }

        public void c(C2050h hVar) {
            m.e(hVar, "appInfo");
            if (this.f21655a.getActivity() != null && (this.f21655a.getActivity() instanceof C2209b)) {
                try {
                    C2209b bVar = (C2209b) this.f21655a.getActivity();
                    m.b(bVar);
                    bVar.l(hVar, this.f21656b);
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
        }

        public void b(int i4) {
        }
    }
}
