package com.uptodown.tv.ui.fragment;

import R2.n;
import R2.s;
import V2.g;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.fragment.app.FragmentActivity;
import androidx.leanback.app.VerticalGridSupportFragment;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.OnItemViewClickedListener;
import androidx.leanback.widget.OnItemViewSelectedListener;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.Row;
import androidx.leanback.widget.RowPresenter;
import androidx.leanback.widget.VerticalGridPresenter;
import androidx.lifecycle.LifecycleOwnerKt;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.uptodown.R;
import d3.p;
import g2.C2050h;
import g2.C2053k;
import g2.L;
import java.util.ArrayList;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import o3.C0977g;
import o3.C1001s0;
import o3.E0;
import o3.J;
import o3.Y;
import org.json.JSONArray;
import org.json.JSONObject;
import q2.C2209b;
import r2.C2250n;
import u2.x;

public final class TvAppsListFragment extends VerticalGridSupportFragment {

    /* renamed from: e  reason: collision with root package name */
    public static final a f19349e = new a((C2103g) null);
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public ArrayObjectAdapter f19350a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public C2053k f19351b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public int f19352c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public boolean f19353d;

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
            if ((obj instanceof C2050h) && TvAppsListFragment.this.getActivity() != null && viewHolder != null) {
                C2209b bVar = (C2209b) TvAppsListFragment.this.getActivity();
                m.b(bVar);
                bVar.l((C2050h) obj, viewHolder);
            }
        }
    }

    private final class c implements OnItemViewSelectedListener {
        public c() {
        }

        /* renamed from: a */
        public void onItemSelected(Presenter.ViewHolder viewHolder, Object obj, RowPresenter.ViewHolder viewHolder2, Row row) {
            if (obj != null) {
                ArrayObjectAdapter i4 = TvAppsListFragment.this.f19350a;
                m.b(i4);
                int indexOf = i4.indexOf(obj);
                if (indexOf < TvAppsListFragment.this.f19352c && indexOf >= TvAppsListFragment.this.f19352c - 5 && !TvAppsListFragment.this.f19353d) {
                    TvAppsListFragment.this.t();
                }
            }
        }
    }

    static final class d extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f19356a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ TvAppsListFragment f19357b;

        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f19358a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ TvAppsListFragment f19359b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ C f19360c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(TvAppsListFragment tvAppsListFragment, C c5, V2.d dVar) {
                super(2, dVar);
                this.f19359b = tvAppsListFragment;
                this.f19360c = c5;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new a(this.f19359b, this.f19360c, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f19358a == 0) {
                    n.b(obj);
                    try {
                        this.f19359b.u((ArrayList) this.f19360c.f20968a);
                    } catch (Exception e5) {
                        e5.printStackTrace();
                    }
                    this.f19359b.f19353d = false;
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(TvAppsListFragment tvAppsListFragment, V2.d dVar) {
            super(2, dVar);
            this.f19357b = tvAppsListFragment;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new d(this.f19357b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            L l4;
            Integer num;
            Resources resources;
            Object c5 = W2.b.c();
            int i4 = this.f19356a;
            if (i4 == 0) {
                n.b(obj);
                C c6 = new C();
                this.f19357b.f19353d = true;
                FragmentActivity requireActivity = this.f19357b.requireActivity();
                m.d(requireActivity, "requireActivity(...)");
                u2.L l5 = new u2.L(requireActivity);
                if (this.f19357b.f19351b != null) {
                    C2053k j4 = this.f19357b.f19351b;
                    m.b(j4);
                    int b5 = j4.b();
                    if (b5 == -2) {
                        l4 = l5.K(75, this.f19357b.f19352c);
                    } else if (b5 != -1) {
                        C2053k j5 = this.f19357b.f19351b;
                        m.b(j5);
                        if (j5.h()) {
                            C2053k j6 = this.f19357b.f19351b;
                            m.b(j6);
                            l4 = l5.m0(j6.b(), 75, this.f19357b.f19352c);
                        } else {
                            C2053k j7 = this.f19357b.f19351b;
                            m.b(j7);
                            l4 = l5.i0(j7.b(), 75, this.f19357b.f19352c);
                        }
                    } else {
                        l4 = l5.h0(75, this.f19357b.f19352c);
                    }
                } else {
                    l4 = null;
                }
                if (!(l4 == null || l4.b() || l4.e() == null)) {
                    JSONObject e5 = l4.e();
                    m.b(e5);
                    JSONArray optJSONArray = e5.optJSONArray(DataSchemeDataSource.SCHEME_DATA);
                    if (e5.optInt("success") == 1 && optJSONArray != null) {
                        c6.f20968a = new ArrayList();
                        Context context = this.f19357b.getContext();
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
                            C2050h b6 = C2050h.b.b(bVar, optJSONObject, (Context) null, 2, (Object) null);
                            ((ArrayList) c6.f20968a).add(b6);
                            if (num != null) {
                                com.squareup.picasso.s.h().l(b6.D(num.intValue())).d();
                            }
                            this.f19357b.f19352c = this.f19357b.f19352c + 1;
                        }
                    }
                }
                E0 c7 = Y.c();
                a aVar = new a(this.f19357b, c6, (V2.d) null);
                this.f19356a = 1;
                if (C0977g.g(c7, aVar, this) == c5) {
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
        int f19361a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ TvAppsListFragment f19362b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(TvAppsListFragment tvAppsListFragment, V2.d dVar) {
            super(2, dVar);
            this.f19362b = tvAppsListFragment;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new e(this.f19362b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f19361a;
            if (i4 == 0) {
                n.b(obj);
                TvAppsListFragment tvAppsListFragment = this.f19362b;
                this.f19361a = 1;
                if (tvAppsListFragment.s(this) == c5) {
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

    private final void q(String str) {
        FragmentActivity activity = getActivity();
        if (activity != null && !activity.isFinishing()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(activity);
            builder.setMessage(str);
            builder.setPositiveButton(17039370, new C2250n());
            builder.setCancelable(true);
            builder.create().show();
        }
    }

    /* access modifiers changed from: private */
    public static final void r(DialogInterface dialogInterface, int i4) {
        m.e(dialogInterface, "dialogInterface");
        dialogInterface.dismiss();
    }

    /* access modifiers changed from: private */
    public final Object s(V2.d dVar) {
        Object g4 = C0977g.g(Y.b(), new d(this, (V2.d) null), dVar);
        if (g4 == W2.b.c()) {
            return g4;
        }
        return s.f8222a;
    }

    /* access modifiers changed from: private */
    public final void t() {
        C1001s0 unused = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), (g) null, (o3.L) null, new e(this, (V2.d) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void u(ArrayList arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            String string = getString(R.string.no_data_available);
            m.d(string, "getString(...)");
            q(string);
            return;
        }
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            ArrayObjectAdapter arrayObjectAdapter = this.f19350a;
            m.b(arrayObjectAdapter);
            arrayObjectAdapter.add(arrayList.get(i4));
        }
    }

    private final void v() {
        VerticalGridPresenter verticalGridPresenter = new VerticalGridPresenter();
        verticalGridPresenter.setNumberOfColumns(5);
        setGridPresenter(verticalGridPresenter);
        startEntranceTransition();
        setOnItemViewClickedListener(new b());
        setOnItemViewSelectedListener(new c());
    }

    public void onCreate(Bundle bundle) {
        String str;
        Bundle extras;
        Parcelable parcelable;
        super.onCreate(bundle);
        x xVar = new x(getContext());
        String simpleName = TvAppsListFragment.class.getSimpleName();
        m.d(simpleName, "getSimpleName(...)");
        xVar.e(simpleName);
        ArrayObjectAdapter arrayObjectAdapter = new ArrayObjectAdapter((Presenter) new p2.e());
        this.f19350a = arrayObjectAdapter;
        setAdapter(arrayObjectAdapter);
        FragmentActivity activity = getActivity();
        if (!(activity == null || (extras = activity.getIntent().getExtras()) == null || !extras.containsKey("category"))) {
            if (Build.VERSION.SDK_INT >= 33) {
                parcelable = (Parcelable) extras.getParcelable("category", C2053k.class);
            } else {
                parcelable = extras.getParcelable("category");
            }
            this.f19351b = (C2053k) parcelable;
        }
        C2053k kVar = this.f19351b;
        if (kVar != null) {
            str = kVar.d();
        } else {
            str = null;
        }
        setTitle(str);
        if (bundle == null) {
            prepareEntranceTransition();
        }
        v();
    }

    public void onResume() {
        super.onResume();
        t();
    }
}
