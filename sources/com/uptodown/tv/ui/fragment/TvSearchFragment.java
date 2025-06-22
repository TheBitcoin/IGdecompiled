package com.uptodown.tv.ui.fragment;

import R2.n;
import R2.s;
import V2.g;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import androidx.leanback.app.SearchSupportFragment;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.HeaderItem;
import androidx.leanback.widget.ListRow;
import androidx.leanback.widget.ListRowPresenter;
import androidx.leanback.widget.ObjectAdapter;
import androidx.leanback.widget.OnItemViewClickedListener;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.Row;
import androidx.leanback.widget.RowPresenter;
import androidx.leanback.widget.SearchBar;
import androidx.lifecycle.LifecycleOwnerKt;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.uptodown.R;
import com.uptodown.tv.ui.activity.TvAppDetailActivity;
import d3.p;
import g2.C2050h;
import g2.L;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.m;
import o3.C0977g;
import o3.C1001s0;
import o3.E0;
import o3.J;
import o3.Y;
import org.json.JSONArray;
import org.json.JSONObject;
import r2.C2235Q;
import r2.C2236S;
import r2.T;
import u2.x;

public final class TvSearchFragment extends SearchSupportFragment implements SearchSupportFragment.SearchResultProvider {

    /* renamed from: a  reason: collision with root package name */
    private ArrayObjectAdapter f19408a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public String f19409b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public ArrayList f19410c;

    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f19411a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ TvSearchFragment f19412b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C2050h f19413c;

        /* renamed from: com.uptodown.tv.ui.fragment.TvSearchFragment$a$a  reason: collision with other inner class name */
        static final class C0240a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f19414a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ TvSearchFragment f19415b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ C2050h f19416c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0240a(TvSearchFragment tvSearchFragment, C2050h hVar, V2.d dVar) {
                super(2, dVar);
                this.f19415b = tvSearchFragment;
                this.f19416c = hVar;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new C0240a(this.f19415b, this.f19416c, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f19414a == 0) {
                    n.b(obj);
                    Intent intent = new Intent(this.f19415b.getActivity(), TvAppDetailActivity.class);
                    intent.putExtra("appInfo", this.f19416c);
                    this.f19415b.startActivity(intent);
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((C0240a) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(TvSearchFragment tvSearchFragment, C2050h hVar, V2.d dVar) {
            super(2, dVar);
            this.f19412b = tvSearchFragment;
            this.f19413c = hVar;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new a(this.f19412b, this.f19413c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            String d5;
            Object c5 = W2.b.c();
            int i4 = this.f19411a;
            if (i4 == 0) {
                n.b(obj);
                try {
                    Context requireContext = this.f19412b.requireContext();
                    m.d(requireContext, "requireContext(...)");
                    L T4 = new u2.L(requireContext).T(this.f19413c.e());
                    if (!T4.b() && (d5 = T4.d()) != null) {
                        if (d5.length() != 0) {
                            String d6 = T4.d();
                            m.b(d6);
                            JSONObject jSONObject = new JSONObject(d6);
                            JSONObject optJSONObject = jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
                            if (jSONObject.optInt("success") == 1 && optJSONObject != null) {
                                C2050h.b(this.f19413c, optJSONObject, (Context) null, 2, (Object) null);
                            }
                        }
                    }
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
                E0 c6 = Y.c();
                C0240a aVar = new C0240a(this.f19412b, this.f19413c, (V2.d) null);
                this.f19411a = 1;
                if (C0977g.g(c6, aVar, this) == c5) {
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

    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f19417a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ TvSearchFragment f19418b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f19419c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(TvSearchFragment tvSearchFragment, String str, V2.d dVar) {
            super(2, dVar);
            this.f19418b = tvSearchFragment;
            this.f19419c = str;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new b(this.f19418b, this.f19419c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f19417a;
            if (i4 == 0) {
                n.b(obj);
                TvSearchFragment tvSearchFragment = this.f19418b;
                String str = this.f19419c;
                this.f19417a = 1;
                if (tvSearchFragment.x(str, this) == c5) {
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
            return ((b) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class c extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f19420a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ TvSearchFragment f19421b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C2050h f19422c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(TvSearchFragment tvSearchFragment, C2050h hVar, V2.d dVar) {
            super(2, dVar);
            this.f19421b = tvSearchFragment;
            this.f19422c = hVar;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new c(this.f19421b, this.f19422c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f19420a;
            if (i4 == 0) {
                n.b(obj);
                TvSearchFragment tvSearchFragment = this.f19421b;
                C2050h hVar = this.f19422c;
                this.f19420a = 1;
                if (tvSearchFragment.s(hVar, this) == c5) {
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

    public static final class d implements SearchBar.SearchBarListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TvSearchFragment f19423a;

        d(TvSearchFragment tvSearchFragment) {
            this.f19423a = tvSearchFragment;
        }

        /* access modifiers changed from: private */
        public static final void b(TvSearchFragment tvSearchFragment) {
            tvSearchFragment.focusOnResults();
        }

        public void onKeyboardDismiss(String str) {
            m.e(str, MBridgeConstans.DYNAMIC_VIEW_WX_QUERY);
            new Handler(Looper.getMainLooper()).postDelayed(new T(this.f19423a), AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
        }

        public void onSearchQueryChange(String str) {
            if (str != null && str.length() > 2 && !m3.m.p(str, this.f19423a.f19409b, true)) {
                this.f19423a.f19409b = str;
                this.f19423a.w(str);
            }
        }

        public void onSearchQuerySubmit(String str) {
            if (str != null && str.length() > 2 && !m3.m.p(str, this.f19423a.f19409b, true)) {
                this.f19423a.f19409b = str;
                this.f19423a.w(str);
            }
        }
    }

    static final class e extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f19424a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ TvSearchFragment f19425b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f19426c;

        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f19427a;

            a(V2.d dVar) {
                super(2, dVar);
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new a(dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f19427a == 0) {
                    n.b(obj);
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(TvSearchFragment tvSearchFragment, String str, V2.d dVar) {
            super(2, dVar);
            this.f19425b = tvSearchFragment;
            this.f19426c = str;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new e(this.f19425b, this.f19426c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Integer num;
            Resources resources;
            Object c5 = W2.b.c();
            int i4 = this.f19424a;
            if (i4 == 0) {
                n.b(obj);
                try {
                    ArrayList k4 = this.f19425b.f19410c;
                    m.b(k4);
                    k4.clear();
                    Context requireContext = this.f19425b.requireContext();
                    m.d(requireContext, "requireContext(...)");
                    u2.L l4 = new u2.L(requireContext);
                    String str = this.f19426c;
                    ArrayList k5 = this.f19425b.f19410c;
                    m.b(k5);
                    L Z02 = l4.Z0(str, 10, k5.size());
                    if (!Z02.b() && Z02.e() != null) {
                        JSONObject e5 = Z02.e();
                        m.b(e5);
                        if (e5.optJSONObject(DataSchemeDataSource.SCHEME_DATA) != null) {
                            JSONArray optJSONArray = e5.optJSONArray("results");
                            if (e5.optInt("success") == 1 && optJSONArray != null) {
                                Context context = this.f19425b.getContext();
                                if (context == null || (resources = context.getResources()) == null) {
                                    num = null;
                                } else {
                                    num = kotlin.coroutines.jvm.internal.b.b(resources.getDimensionPixelSize(R.dimen.tv_card_height));
                                }
                                int length = optJSONArray.length();
                                for (int i5 = 0; i5 < length; i5++) {
                                    JSONObject optJSONObject = optJSONArray.optJSONObject(i5);
                                    C2050h.b bVar = C2050h.f20600F0;
                                    m.b(optJSONObject);
                                    C2050h b5 = C2050h.b.b(bVar, optJSONObject, (Context) null, 2, (Object) null);
                                    ArrayList k6 = this.f19425b.f19410c;
                                    m.b(k6);
                                    k6.add(b5);
                                    if (num != null) {
                                        com.squareup.picasso.s.h().l(b5.D(num.intValue())).d();
                                    }
                                }
                                TvSearchFragment tvSearchFragment = this.f19425b;
                                tvSearchFragment.y(this.f19426c, tvSearchFragment.f19410c);
                            }
                        }
                    }
                } catch (Exception e6) {
                    e6.printStackTrace();
                }
                E0 c6 = Y.c();
                a aVar = new a((V2.d) null);
                this.f19424a = 1;
                if (C0977g.g(c6, aVar, this) == c5) {
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
    public final void focusOnResults() {
    }

    /* access modifiers changed from: private */
    public static final void i(TvSearchFragment tvSearchFragment, Presenter.ViewHolder viewHolder, Object obj, RowPresenter.ViewHolder viewHolder2, Row row) {
        m.c(obj, "null cannot be cast to non-null type com.uptodown.models.AppInfo");
        tvSearchFragment.u((C2050h) obj);
    }

    private final OnItemViewClickedListener r() {
        return new C2236S(this);
    }

    /* access modifiers changed from: private */
    public final Object s(C2050h hVar, V2.d dVar) {
        Object g4 = C0977g.g(Y.b(), new a(this, hVar, (V2.d) null), dVar);
        if (g4 == W2.b.c()) {
            return g4;
        }
        return s.f8222a;
    }

    private final void t(String str) {
        C1001s0 unused = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), (g) null, (o3.L) null, new b(this, str, (V2.d) null), 3, (Object) null);
    }

    private final void u(C2050h hVar) {
        C1001s0 unused = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), (g) null, (o3.L) null, new c(this, hVar, (V2.d) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void v() {
    }

    /* access modifiers changed from: private */
    public final void w(String str) {
        ArrayObjectAdapter arrayObjectAdapter = this.f19408a;
        m.b(arrayObjectAdapter);
        arrayObjectAdapter.clear();
        if (!TextUtils.isEmpty(str)) {
            t(str);
        }
    }

    /* access modifiers changed from: private */
    public final Object x(String str, V2.d dVar) {
        Object g4 = C0977g.g(Y.b(), new e(this, str, (V2.d) null), dVar);
        if (g4 == W2.b.c()) {
            return g4;
        }
        return s.f8222a;
    }

    /* access modifiers changed from: private */
    public final void y(String str, List list) {
        ArrayObjectAdapter arrayObjectAdapter = new ArrayObjectAdapter((Presenter) new p2.e());
        m.b(list);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayObjectAdapter.add((C2050h) it.next());
        }
        HeaderItem headerItem = new HeaderItem(str);
        ArrayObjectAdapter arrayObjectAdapter2 = this.f19408a;
        m.b(arrayObjectAdapter2);
        arrayObjectAdapter2.add(new ListRow(headerItem, arrayObjectAdapter));
    }

    public ObjectAdapter getResultsAdapter() {
        ArrayObjectAdapter arrayObjectAdapter = this.f19408a;
        m.b(arrayObjectAdapter);
        return arrayObjectAdapter;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x xVar = new x(getContext());
        String simpleName = TvSearchFragment.class.getSimpleName();
        m.d(simpleName, "getSimpleName(...)");
        xVar.e(simpleName);
        this.f19408a = new ArrayObjectAdapter((Presenter) new ListRowPresenter());
        setSearchResultProvider(this);
        setOnItemViewClickedListener(r());
        this.f19410c = new ArrayList();
        setSpeechRecognitionCallback(new C2235Q());
    }

    public boolean onQueryTextChange(String str) {
        if (str != null && str.length() > 2 && !m3.m.p(str, this.f19409b, true)) {
            this.f19409b = str;
            w(str);
        }
        return true;
    }

    public boolean onQueryTextSubmit(String str) {
        if (str != null && str.length() > 2 && !m3.m.p(str, this.f19409b, true)) {
            this.f19409b = str;
            w(str);
        }
        return true;
    }

    public void onViewCreated(View view, Bundle bundle) {
        m.e(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        super.onViewCreated(view, bundle);
        SearchBar searchBar = (SearchBar) view.findViewById(R.id.lb_search_bar);
        if (searchBar != null) {
            searchBar.setSearchBarListener(new d(this));
        }
    }
}
