package r2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.leanback.app.BackgroundManager;
import androidx.leanback.app.BrowseSupportFragment;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.ListRowPresenter;
import androidx.leanback.widget.PageRow;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.PresenterSelector;
import androidx.leanback.widget.Row;
import com.uptodown.R;
import com.uptodown.tv.ui.activity.TvSearchActivity;
import g2.C2053k;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import n2.C2168a;
import p2.j;
import u2.x;

/* renamed from: r2.v  reason: case insensitive filesystem */
public final class C2258v extends BrowseSupportFragment {

    /* renamed from: c  reason: collision with root package name */
    public static final a f21669c = new a((C2103g) null);

    /* renamed from: d  reason: collision with root package name */
    private static final int f21670d = R.drawable.vector_tv_header_home;

    /* renamed from: e  reason: collision with root package name */
    private static final int f21671e = R.drawable.vector_tv_header_games;

    /* renamed from: f  reason: collision with root package name */
    private static final int f21672f = R.drawable.vector_tv_header_top;

    /* renamed from: g  reason: collision with root package name */
    private static final int f21673g = R.drawable.vector_tv_header_management;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public static C2256t f21674h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public static C2254r f21675i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public static V f21676j;

    /* renamed from: a  reason: collision with root package name */
    private BackgroundManager f21677a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayObjectAdapter f21678b;

    /* renamed from: r2.v$a */
    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        private a() {
        }
    }

    /* renamed from: r2.v$b */
    private static final class b extends BrowseSupportFragment.FragmentFactory {
        public Fragment createFragment(Object obj) {
            m.c(obj, "null cannot be cast to non-null type androidx.leanback.widget.Row");
            long id = ((Row) obj).getHeaderItem().getId();
            if (id == 1) {
                if (C2258v.f21674h == null) {
                    C2258v.f21674h = new C2256t();
                }
                return C2258v.f21674h;
            } else if (id == 2) {
                if (C2258v.f21675i == null) {
                    C2258v.f21675i = new C2254r();
                }
                return C2258v.f21675i;
            } else if (id == 3) {
                if (C2258v.f21676j == null) {
                    C2258v.f21676j = V.f21621f.a(new C2053k(-1, "", (String) null, 4, (C2103g) null));
                }
                return C2258v.f21676j;
            } else if (id == 4) {
                return new z();
            } else {
                return null;
            }
        }
    }

    /* renamed from: r2.v$c */
    public static final class c extends PresenterSelector {
        c() {
        }

        public Presenter getPresenter(Object obj) {
            m.e(obj, "o");
            return new j();
        }
    }

    private final void n() {
        PageRow pageRow = new PageRow(new C2168a(1, "", f21670d));
        ArrayObjectAdapter arrayObjectAdapter = this.f21678b;
        m.b(arrayObjectAdapter);
        arrayObjectAdapter.add(pageRow);
        PageRow pageRow2 = new PageRow(new C2168a(2, "", f21671e));
        ArrayObjectAdapter arrayObjectAdapter2 = this.f21678b;
        m.b(arrayObjectAdapter2);
        arrayObjectAdapter2.add(pageRow2);
        PageRow pageRow3 = new PageRow(new C2168a(3, "", f21672f));
        ArrayObjectAdapter arrayObjectAdapter3 = this.f21678b;
        m.b(arrayObjectAdapter3);
        arrayObjectAdapter3.add(pageRow3);
        PageRow pageRow4 = new PageRow(new C2168a(4, "", f21673g));
        ArrayObjectAdapter arrayObjectAdapter4 = this.f21678b;
        m.b(arrayObjectAdapter4);
        arrayObjectAdapter4.add(pageRow4);
    }

    private final void o() {
        ArrayObjectAdapter arrayObjectAdapter = new ArrayObjectAdapter((Presenter) new ListRowPresenter());
        this.f21678b = arrayObjectAdapter;
        setAdapter(arrayObjectAdapter);
        n();
        startEntranceTransition();
    }

    private final void p() {
        setHeadersState(1);
        setHeaderPresenterSelector(new c());
        setBadgeDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.vector_uptodown_app_store_white));
        setHeadersTransitionOnBackEnabled(true);
        setBrandColor(ContextCompat.getColor(requireContext(), R.color.tv_background_gradient_end));
        setSearchAffordanceColor(ContextCompat.getColor(requireContext(), R.color.transparent));
        setOnSearchClickedListener(new C2257u(this));
        prepareEntranceTransition();
    }

    /* access modifiers changed from: private */
    public static final void q(C2258v vVar, View view) {
        vVar.startActivity(new Intent(vVar.getActivity(), TvSearchActivity.class));
    }

    public void onCreate(Bundle bundle) {
        BackgroundManager backgroundManager;
        super.onCreate(bundle);
        x xVar = new x(getContext());
        String simpleName = C2258v.class.getSimpleName();
        m.d(simpleName, "getSimpleName(...)");
        xVar.e(simpleName);
        p();
        o();
        BackgroundManager instance = BackgroundManager.getInstance(getActivity());
        this.f21677a = instance;
        if (!(instance == null || instance.isAttached() || (backgroundManager = this.f21677a) == null)) {
            backgroundManager.attach(requireActivity().getWindow());
        }
        getMainFragmentRegistry().registerFragment(PageRow.class, new b());
    }
}
