package com.uptodown.activities;

import J1.I4;
import J1.J4;
import J1.K4;
import J1.L4;
import J1.M4;
import J1.N4;
import J1.O4;
import J1.P4;
import M1.C;
import N1.k;
import R2.n;
import R2.s;
import android.app.SearchManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.widget.SearchView;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c2.A0;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.views.InstantAutoCompleteTextView;
import d3.p;
import f2.C2013d;
import g2.C2040H;
import g2.C2050h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.D;
import kotlin.jvm.internal.m;
import o3.C1001s0;
import o3.J;
import o3.L;
import o3.U;
import o3.Y;
import r3.C1036f;
import r3.I;
import u2.t;
import u2.x;

public final class SearchActivity extends C1826a {

    /* renamed from: Q  reason: collision with root package name */
    public static final b f18357Q = new b((C2103g) null);

    /* renamed from: J  reason: collision with root package name */
    private final R2.g f18358J = R2.h.a(new I4(this));

    /* renamed from: K  reason: collision with root package name */
    private final R2.g f18359K = new ViewModelLazy(D.b(J.class), new j(this), new i(this), new k((d3.a) null, this));
    /* access modifiers changed from: private */

    /* renamed from: L  reason: collision with root package name */
    public C1001s0 f18360L;
    /* access modifiers changed from: private */

    /* renamed from: M  reason: collision with root package name */
    public C f18361M;
    /* access modifiers changed from: private */

    /* renamed from: N  reason: collision with root package name */
    public a f18362N;
    /* access modifiers changed from: private */

    /* renamed from: O  reason: collision with root package name */
    public boolean f18363O = true;

    /* renamed from: P  reason: collision with root package name */
    private final ActivityResultLauncher f18364P;

    private final class a extends ArrayAdapter implements Filterable {

        /* renamed from: a  reason: collision with root package name */
        private final LayoutInflater f18365a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ SearchActivity f18366b;

        /* renamed from: com.uptodown.activities.SearchActivity$a$a  reason: collision with other inner class name */
        public static final class C0227a extends Filter {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ SearchActivity f18367a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ a f18368b;

            C0227a(SearchActivity searchActivity, a aVar) {
                this.f18367a = searchActivity;
                this.f18368b = aVar;
            }

            public CharSequence convertResultToString(Object obj) {
                m.e(obj, "resultValue");
                String a5 = ((C2040H) obj).a();
                m.b(a5);
                return a5;
            }

            /* access modifiers changed from: protected */
            public Filter.FilterResults performFiltering(CharSequence charSequence) {
                m.e(charSequence, "charSequence");
                t.a aVar = t.f21927u;
                Context applicationContext = this.f18367a.getApplicationContext();
                m.d(applicationContext, "getApplicationContext(...)");
                t a5 = aVar.a(applicationContext);
                a5.a();
                ArrayList z02 = a5.z0();
                a5.i();
                if (charSequence.length() > 0) {
                    ArrayList arrayList = new ArrayList();
                    int size = z02.size();
                    for (int i4 = 0; i4 < size; i4++) {
                        String a6 = ((C2040H) z02.get(i4)).a();
                        if (a6 != null && m3.m.D(a6, charSequence, false, 2, (Object) null)) {
                            arrayList.add(z02.get(i4));
                        }
                    }
                    z02 = arrayList;
                }
                Filter.FilterResults filterResults = new Filter.FilterResults();
                filterResults.values = z02;
                filterResults.count = z02.size();
                return filterResults;
            }

            /* access modifiers changed from: protected */
            public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
                m.e(charSequence, "charSequence");
                m.e(filterResults, "filterResults");
                this.f18368b.clear();
                Object obj = filterResults.values;
                m.c(obj, "null cannot be cast to non-null type kotlin.collections.List<*>");
                for (C2040H add : (List) obj) {
                    this.f18368b.add(add);
                }
                if (filterResults.count > 0) {
                    a j32 = this.f18367a.f18362N;
                    m.b(j32);
                    j32.notifyDataSetChanged();
                    return;
                }
                a j33 = this.f18367a.f18362N;
                m.b(j33);
                j33.notifyDataSetInvalidated();
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(SearchActivity searchActivity, Context context) {
            super(context, -1);
            m.e(context, "context");
            this.f18366b = searchActivity;
            LayoutInflater from = LayoutInflater.from(context);
            m.d(from, "from(...)");
            this.f18365a = from;
        }

        /* access modifiers changed from: private */
        public static final void b(SearchActivity searchActivity, View view) {
            m.e(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
            if (UptodownApp.f17422D.a0()) {
                Object tag = view.getTag();
                m.c(tag, "null cannot be cast to non-null type kotlin.String");
                t.a aVar = t.f21927u;
                Context applicationContext = searchActivity.getApplicationContext();
                m.d(applicationContext, "getApplicationContext(...)");
                t a5 = aVar.a(applicationContext);
                a5.a();
                int L4 = a5.L((String) tag);
                a5.i();
                if (L4 > 0) {
                    a j32 = searchActivity.f18362N;
                    m.b(j32);
                    j32.getFilter().filter(searchActivity.t3().f9689b.f9698b.getText().toString());
                }
            }
        }

        public Filter getFilter() {
            return new C0227a(this.f18366b, this);
        }

        public View getView(int i4, View view, ViewGroup viewGroup) {
            LinearLayout linearLayout;
            m.e(viewGroup, "parent");
            C2040H h4 = (C2040H) getItem(i4);
            if (h4 != null) {
                if (view != null) {
                    linearLayout = (LinearLayout) view;
                } else {
                    View inflate = this.f18365a.inflate(R.layout.recent_search_item, viewGroup, false);
                    m.c(inflate, "null cannot be cast to non-null type android.widget.LinearLayout");
                    linearLayout = (LinearLayout) inflate;
                }
                TextView textView = (TextView) linearLayout.findViewById(R.id.tv_query_recent_search_item);
                ImageView imageView = (ImageView) linearLayout.findViewById(R.id.iv_delete_recent_search_item);
                imageView.setTag(h4.a());
                imageView.setOnClickListener(new I(this.f18366b));
                textView.setTypeface(N1.k.f7778g.x());
                textView.setText(h4.a());
                return linearLayout;
            }
            View inflate2 = this.f18365a.inflate(R.layout.recent_search_item, viewGroup, false);
            m.c(inflate2, "null cannot be cast to non-null type android.widget.LinearLayout");
            return (LinearLayout) inflate2;
        }
    }

    public static final class b {
        public /* synthetic */ b(C2103g gVar) {
            this();
        }

        private b() {
        }
    }

    public static final class c implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SearchActivity f18369a;

        public c(SearchActivity searchActivity) {
            this.f18369a = searchActivity;
        }

        public void afterTextChanged(Editable editable) {
            String o32 = this.f18369a.H3(String.valueOf(editable));
            int length = o32.length();
            if (2 > length || length >= 40) {
                if (this.f18369a.f18360L != null) {
                    C1001s0 l32 = this.f18369a.f18360L;
                    m.b(l32);
                    C1001s0.a.a(l32, (CancellationException) null, 1, (Object) null);
                }
                if (this.f18369a.f18361M != null) {
                    C i32 = this.f18369a.f18361M;
                    m.b(i32);
                    i32.c(new ArrayList());
                }
            } else {
                this.f18369a.I3(o32, 2);
            }
            if (String.valueOf(editable).length() > 0) {
                this.f18369a.t3().f9689b.f9700d.setVisibility(0);
                this.f18369a.t3().f9689b.f9701e.setVisibility(8);
                return;
            }
            C i33 = this.f18369a.f18361M;
            if (i33 != null) {
                i33.c(new ArrayList());
            }
            this.f18369a.t3().f9689b.f9700d.setVisibility(8);
            this.f18369a.t3().f9689b.f9701e.setVisibility(0);
        }

        public void beforeTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        }

        public void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        }
    }

    public static final class d extends RecyclerView.OnScrollListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ LinearLayoutManager f18370a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ SearchActivity f18371b;

        d(LinearLayoutManager linearLayoutManager, SearchActivity searchActivity) {
            this.f18370a = linearLayoutManager;
            this.f18371b = searchActivity;
        }

        public void onScrolled(RecyclerView recyclerView, int i4, int i5) {
            m.e(recyclerView, "recyclerView");
            if (i5 > 0) {
                int childCount = this.f18370a.getChildCount();
                int itemCount = this.f18370a.getItemCount();
                int findFirstVisibleItemPosition = this.f18370a.findFirstVisibleItemPosition();
                SearchActivity searchActivity = this.f18371b;
                String o32 = searchActivity.H3(searchActivity.t3().f9689b.f9698b.getText().toString());
                if (o32.length() > 2 && childCount + findFirstVisibleItemPosition >= itemCount && !this.f18371b.u3().d()) {
                    this.f18371b.K3(o32);
                }
            }
        }
    }

    public static final class e implements C2013d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SearchActivity f18372a;

        e(SearchActivity searchActivity) {
            this.f18372a = searchActivity;
        }

        public void a(C2050h hVar) {
            m.e(hVar, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
            if (UptodownApp.f17422D.a0()) {
                this.f18372a.C2(hVar.e());
            }
        }
    }

    static final class f extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f18373a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ SearchActivity f18374b;

        static final class a implements C1036f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ SearchActivity f18375a;

            a(SearchActivity searchActivity) {
                this.f18375a = searchActivity;
            }

            /* JADX WARNING: Code restructure failed: missing block: B:5:0x0022, code lost:
                if (r4.b().size() == 0) goto L_0x0024;
             */
            /* renamed from: b */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object emit(u2.E r4, V2.d r5) {
                /*
                    r3 = this;
                    u2.E$a r5 = u2.E.a.f21883a
                    boolean r5 = kotlin.jvm.internal.m.a(r4, r5)
                    r0 = 0
                    if (r5 == 0) goto L_0x0031
                    com.uptodown.activities.SearchActivity r4 = r3.f18375a
                    M1.C r4 = r4.f18361M
                    if (r4 == 0) goto L_0x0024
                    com.uptodown.activities.SearchActivity r4 = r3.f18375a
                    M1.C r4 = r4.f18361M
                    kotlin.jvm.internal.m.b(r4)
                    java.util.ArrayList r4 = r4.b()
                    int r4 = r4.size()
                    if (r4 != 0) goto L_0x0177
                L_0x0024:
                    com.uptodown.activities.SearchActivity r4 = r3.f18375a
                    c2.A0 r4 = r4.t3()
                    android.view.View r4 = r4.f9690c
                    r4.setVisibility(r0)
                    goto L_0x0177
                L_0x0031:
                    boolean r5 = r4 instanceof u2.E.c
                    if (r5 == 0) goto L_0x016f
                    com.uptodown.activities.SearchActivity r5 = r3.f18375a
                    u2.E$c r4 = (u2.E.c) r4
                    java.lang.Object r1 = r4.a()
                    com.uptodown.activities.J$a r1 = (com.uptodown.activities.J.a) r1
                    boolean r1 = r1.b()
                    r5.f18363O = r1
                    com.uptodown.activities.SearchActivity r5 = r3.f18375a
                    M1.C r5 = r5.f18361M
                    r1 = 8
                    if (r5 != 0) goto L_0x0072
                    com.uptodown.activities.SearchActivity r5 = r3.f18375a
                    java.lang.Object r4 = r4.a()
                    com.uptodown.activities.J$a r4 = (com.uptodown.activities.J.a) r4
                    java.util.ArrayList r4 = r4.c()
                    r5.F3(r4)
                    com.uptodown.activities.SearchActivity r4 = r3.f18375a
                    c2.A0 r4 = r4.t3()
                    androidx.recyclerview.widget.RecyclerView r4 = r4.f9691d
                    com.uptodown.activities.SearchActivity r5 = r3.f18375a
                    M1.C r5 = r5.f18361M
                    r4.setAdapter(r5)
                    goto L_0x014f
                L_0x0072:
                    com.uptodown.activities.SearchActivity r5 = r3.f18375a
                    c2.A0 r5 = r5.t3()
                    c2.B0 r5 = r5.f9689b
                    com.uptodown.views.InstantAutoCompleteTextView r5 = r5.f9698b
                    android.text.Editable r5 = r5.getText()
                    java.lang.String r5 = r5.toString()
                    int r5 = r5.length()
                    if (r5 <= 0) goto L_0x013e
                    com.uptodown.activities.SearchActivity r5 = r3.f18375a
                    c2.A0 r5 = r5.t3()
                    androidx.recyclerview.widget.RecyclerView r5 = r5.f9691d
                    androidx.recyclerview.widget.RecyclerView$Adapter r5 = r5.getAdapter()
                    if (r5 != 0) goto L_0x00a9
                    com.uptodown.activities.SearchActivity r5 = r3.f18375a
                    c2.A0 r5 = r5.t3()
                    androidx.recyclerview.widget.RecyclerView r5 = r5.f9691d
                    com.uptodown.activities.SearchActivity r2 = r3.f18375a
                    M1.C r2 = r2.f18361M
                    r5.setAdapter(r2)
                L_0x00a9:
                    java.lang.Object r5 = r4.a()
                    com.uptodown.activities.J$a r5 = (com.uptodown.activities.J.a) r5
                    boolean r5 = r5.a()
                    if (r5 == 0) goto L_0x00d7
                    com.uptodown.activities.SearchActivity r5 = r3.f18375a
                    M1.C r5 = r5.f18361M
                    kotlin.jvm.internal.m.b(r5)
                    java.lang.Object r4 = r4.a()
                    com.uptodown.activities.J$a r4 = (com.uptodown.activities.J.a) r4
                    java.util.ArrayList r4 = r4.c()
                    r5.c(r4)
                    com.uptodown.activities.SearchActivity r4 = r3.f18375a
                    c2.A0 r4 = r4.t3()
                    androidx.recyclerview.widget.RecyclerView r4 = r4.f9691d
                    r4.scrollToPosition(r0)
                    goto L_0x00fd
                L_0x00d7:
                    java.lang.Object r5 = r4.a()
                    com.uptodown.activities.J$a r5 = (com.uptodown.activities.J.a) r5
                    java.util.ArrayList r5 = r5.c()
                    int r5 = r5.size()
                    if (r5 <= 0) goto L_0x00fd
                    com.uptodown.activities.SearchActivity r5 = r3.f18375a
                    M1.C r5 = r5.f18361M
                    kotlin.jvm.internal.m.b(r5)
                    java.lang.Object r4 = r4.a()
                    com.uptodown.activities.J$a r4 = (com.uptodown.activities.J.a) r4
                    java.util.ArrayList r4 = r4.c()
                    r5.a(r4)
                L_0x00fd:
                    com.uptodown.activities.SearchActivity r4 = r3.f18375a
                    M1.C r4 = r4.f18361M
                    kotlin.jvm.internal.m.b(r4)
                    java.util.ArrayList r4 = r4.b()
                    int r4 = r4.size()
                    if (r4 != 0) goto L_0x0127
                    com.uptodown.activities.SearchActivity r4 = r3.f18375a
                    c2.A0 r4 = r4.t3()
                    android.widget.TextView r4 = r4.f9692e
                    r4.setVisibility(r0)
                    com.uptodown.activities.SearchActivity r4 = r3.f18375a
                    c2.A0 r4 = r4.t3()
                    androidx.recyclerview.widget.RecyclerView r4 = r4.f9691d
                    r4.setVisibility(r1)
                    goto L_0x014f
                L_0x0127:
                    com.uptodown.activities.SearchActivity r4 = r3.f18375a
                    c2.A0 r4 = r4.t3()
                    android.widget.TextView r4 = r4.f9692e
                    r4.setVisibility(r1)
                    com.uptodown.activities.SearchActivity r4 = r3.f18375a
                    c2.A0 r4 = r4.t3()
                    androidx.recyclerview.widget.RecyclerView r4 = r4.f9691d
                    r4.setVisibility(r0)
                    goto L_0x014f
                L_0x013e:
                    com.uptodown.activities.SearchActivity r4 = r3.f18375a
                    M1.C r4 = r4.f18361M
                    kotlin.jvm.internal.m.b(r4)
                    java.util.ArrayList r5 = new java.util.ArrayList
                    r5.<init>()
                    r4.c(r5)
                L_0x014f:
                    com.uptodown.activities.SearchActivity r4 = r3.f18375a
                    com.uptodown.activities.J r4 = r4.u3()
                    r4.e(r0)
                    com.uptodown.activities.SearchActivity r4 = r3.f18375a
                    M1.C r4 = r4.f18361M
                    if (r4 == 0) goto L_0x0163
                    r4.d(r0)
                L_0x0163:
                    com.uptodown.activities.SearchActivity r4 = r3.f18375a
                    c2.A0 r4 = r4.t3()
                    android.view.View r4 = r4.f9690c
                    r4.setVisibility(r1)
                    goto L_0x0177
                L_0x016f:
                    u2.E$b r5 = u2.E.b.f21884a
                    boolean r4 = kotlin.jvm.internal.m.a(r4, r5)
                    if (r4 == 0) goto L_0x017a
                L_0x0177:
                    R2.s r4 = R2.s.f8222a
                    return r4
                L_0x017a:
                    R2.k r4 = new R2.k
                    r4.<init>()
                    throw r4
                */
                throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.SearchActivity.f.a.emit(u2.E, V2.d):java.lang.Object");
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(SearchActivity searchActivity, V2.d dVar) {
            super(2, dVar);
            this.f18374b = searchActivity;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new f(this.f18374b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f18373a;
            if (i4 == 0) {
                n.b(obj);
                I c6 = this.f18374b.u3().c();
                a aVar = new a(this.f18374b);
                this.f18373a = 1;
                if (c6.collect(aVar, this) == c5) {
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
            return ((f) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class g extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f18376a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f18377b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ SearchActivity f18378c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f18379d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(int i4, SearchActivity searchActivity, String str, V2.d dVar) {
            super(2, dVar);
            this.f18377b = i4;
            this.f18378c = searchActivity;
            this.f18379d = str;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new g(this.f18377b, this.f18378c, this.f18379d, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f18376a;
            if (i4 == 0) {
                n.b(obj);
                this.f18376a = 1;
                if (U.b(((long) this.f18377b) * 1000, this) == c5) {
                    return c5;
                }
            } else if (i4 == 1) {
                n.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            J m32 = this.f18378c.u3();
            SearchActivity searchActivity = this.f18378c;
            m32.b(searchActivity, searchActivity.H3(this.f18379d), 0);
            return s.f8222a;
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((g) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class h extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f18380a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ SearchActivity f18381b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f18382c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(SearchActivity searchActivity, String str, V2.d dVar) {
            super(2, dVar);
            this.f18381b = searchActivity;
            this.f18382c = str;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new h(this.f18381b, this.f18382c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f18380a == 0) {
                n.b(obj);
                J m32 = this.f18381b.u3();
                SearchActivity searchActivity = this.f18381b;
                String o32 = searchActivity.H3(this.f18382c);
                C i32 = this.f18381b.f18361M;
                m.b(i32);
                m32.b(searchActivity, o32, i32.getItemCount());
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((h) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public static final class i extends kotlin.jvm.internal.n implements d3.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f18383a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(ComponentActivity componentActivity) {
            super(0);
            this.f18383a = componentActivity;
        }

        public final ViewModelProvider.Factory invoke() {
            return this.f18383a.getDefaultViewModelProviderFactory();
        }
    }

    public static final class j extends kotlin.jvm.internal.n implements d3.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f18384a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(ComponentActivity componentActivity) {
            super(0);
            this.f18384a = componentActivity;
        }

        public final ViewModelStore invoke() {
            return this.f18384a.getViewModelStore();
        }
    }

    public static final class k extends kotlin.jvm.internal.n implements d3.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d3.a f18385a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f18386b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public k(d3.a aVar, ComponentActivity componentActivity) {
            super(0);
            this.f18385a = aVar;
            this.f18386b = componentActivity;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
            r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0.invoke();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final androidx.lifecycle.viewmodel.CreationExtras invoke() {
            /*
                r1 = this;
                d3.a r0 = r1.f18385a
                if (r0 == 0) goto L_0x000e
                java.lang.Object r0 = r0.invoke()
                androidx.lifecycle.viewmodel.CreationExtras r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0
                if (r0 != 0) goto L_0x000d
                goto L_0x000e
            L_0x000d:
                return r0
            L_0x000e:
                androidx.activity.ComponentActivity r0 = r1.f18386b
                androidx.lifecycle.viewmodel.CreationExtras r0 = r0.getDefaultViewModelCreationExtras()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.SearchActivity.k.invoke():androidx.lifecycle.viewmodel.CreationExtras");
        }
    }

    public SearchActivity() {
        ActivityResultLauncher registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new J4(this));
        m.d(registerForActivityResult, "registerForActivityResult(...)");
        this.f18364P = registerForActivityResult;
    }

    /* access modifiers changed from: private */
    public static final void A3(SearchActivity searchActivity, View view) {
        if (UptodownApp.f17422D.a0()) {
            searchActivity.E3();
        }
    }

    /* access modifiers changed from: private */
    public static final boolean B3(SearchActivity searchActivity, TextView textView, int i4, KeyEvent keyEvent) {
        m.e(textView, "v");
        if (i4 != 3) {
            return false;
        }
        String obj = textView.getText().toString();
        if (obj.length() <= 0) {
            return true;
        }
        searchActivity.w3();
        J3(searchActivity, obj, 0, 2, (Object) null);
        Bundle bundle = new Bundle();
        bundle.putString(MimeTypes.BASE_TYPE_TEXT, obj);
        x m22 = searchActivity.m2();
        if (m22 != null) {
            m22.d("search", bundle);
        }
        searchActivity.L3(obj);
        searchActivity.t3().f9689b.f9698b.dismissDropDown();
        return true;
    }

    /* access modifiers changed from: private */
    public static final void C3(SearchActivity searchActivity, AdapterView adapterView, View view, int i4, long j4) {
        m.e(adapterView, "adapterView");
        if (UptodownApp.f17422D.a0()) {
            Object itemAtPosition = adapterView.getItemAtPosition(i4);
            m.c(itemAtPosition, "null cannot be cast to non-null type com.uptodown.models.RecentSearch");
            C2040H h4 = (C2040H) itemAtPosition;
            if (h4.a() != null) {
                String a5 = h4.a();
                m.b(a5);
                J3(searchActivity, a5, 0, 2, (Object) null);
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void D3(View view) {
    }

    private final void E3() {
        try {
            this.f18364P.launch(new Intent("android.speech.action.RECOGNIZE_SPEECH"));
        } catch (ActivityNotFoundException e5) {
            e5.printStackTrace();
            String string = getString(R.string.feature_not_supported);
            m.d(string, "getString(...)");
            q0(string);
        }
    }

    /* access modifiers changed from: private */
    public final void F3(ArrayList arrayList) {
        this.f18361M = new C(arrayList, new e(this));
    }

    private final String G3(String str) {
        return new m3.j("[^a-zA-Z0-9 ]+").g(str, "");
    }

    /* access modifiers changed from: private */
    public final String H3(String str) {
        m.b(str);
        return m3.m.w(str, "/", "", false, 4, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void I3(String str, int i4) {
        C1001s0 s0Var = this.f18360L;
        if (s0Var != null) {
            m.b(s0Var);
            C1001s0.a.a(s0Var, (CancellationException) null, 1, (Object) null);
        }
        this.f18360L = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), (V2.g) null, (L) null, new g(i4, this, str, (V2.d) null), 3, (Object) null);
    }

    static /* synthetic */ void J3(SearchActivity searchActivity, String str, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i4 = 0;
        }
        searchActivity.I3(str, i4);
    }

    /* access modifiers changed from: private */
    public final void K3(String str) {
        if (this.f18363O) {
            C1001s0 s0Var = this.f18360L;
            if (s0Var != null) {
                m.b(s0Var);
                if (!s0Var.A()) {
                    return;
                }
            }
            if (this.f18361M != null) {
                u3().e(true);
                C c5 = this.f18361M;
                if (c5 != null) {
                    c5.d(true);
                }
                this.f18360L = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), (V2.g) null, (L) null, new h(this, str, (V2.d) null), 3, (Object) null);
            }
        }
    }

    private final void L3(String str) {
        C2040H h4 = new C2040H();
        h4.c(G3(str));
        h4.d(String.valueOf(System.currentTimeMillis()));
        t a5 = t.f21927u.a(this);
        a5.a();
        Iterator it = a5.z0().iterator();
        m.d(it, "iterator(...)");
        while (true) {
            if (!it.hasNext()) {
                a5.U0(h4);
                break;
            }
            Object next = it.next();
            m.d(next, "next(...)");
            if (m3.m.p(((C2040H) next).a(), str, true)) {
                break;
            }
        }
        a5.i();
    }

    /* access modifiers changed from: private */
    public static final void M3(SearchActivity searchActivity, ActivityResult activityResult) {
        String str;
        if (activityResult.getResultCode() == -1 && activityResult.getData() != null) {
            Intent data = activityResult.getData();
            m.b(data);
            ArrayList<String> stringArrayListExtra = data.getStringArrayListExtra("android.speech.extra.RESULTS");
            if (stringArrayListExtra != null) {
                str = stringArrayListExtra.get(0);
            } else {
                str = null;
            }
            searchActivity.t3().f9689b.f9698b.setText(str);
        }
    }

    /* access modifiers changed from: private */
    public static final A0 s3(SearchActivity searchActivity) {
        return A0.c(searchActivity.getLayoutInflater());
    }

    /* access modifiers changed from: private */
    public final A0 t3() {
        return (A0) this.f18358J.getValue();
    }

    /* access modifiers changed from: private */
    public final J u3() {
        return (J) this.f18359K.getValue();
    }

    private final void v3(Intent intent) {
        String stringExtra;
        if (m.a("android.intent.action.SEARCH", intent.getAction()) && (stringExtra = intent.getStringExtra(MBridgeConstans.DYNAMIC_VIEW_WX_QUERY)) != null) {
            J3(this, stringExtra, 0, 2, (Object) null);
        }
    }

    private final void w3() {
        Object systemService = getSystemService("input_method");
        m.c(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).hideSoftInputFromWindow(t3().f9689b.f9698b.getWindowToken(), 0);
    }

    private final void x3() {
        setContentView((View) t3().getRoot());
        ImageView imageView = (ImageView) findViewById(R.id.iv_back_search_bar);
        if (imageView != null) {
            imageView.setOnClickListener(new K4(this));
        }
        t3().f9689b.f9700d.setOnClickListener(new L4(this));
        t3().f9689b.f9701e.setOnClickListener(new M4(this));
        t3().f9689b.f9698b.requestFocus();
        InstantAutoCompleteTextView instantAutoCompleteTextView = t3().f9689b.f9698b;
        k.a aVar = N1.k.f7778g;
        instantAutoCompleteTextView.setTypeface(aVar.x());
        t3().f9689b.f9698b.setOnEditorActionListener(new N4(this));
        this.f18362N = new a(this, this);
        t3().f9689b.f9698b.setAdapter(this.f18362N);
        t3().f9689b.f9698b.setOnItemClickListener(new O4(this));
        InstantAutoCompleteTextView instantAutoCompleteTextView2 = t3().f9689b.f9698b;
        m.d(instantAutoCompleteTextView2, "actvSearchBar");
        instantAutoCompleteTextView2.addTextChangedListener(new c(this));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, 1, false);
        t3().f9691d.setLayoutManager(linearLayoutManager);
        t3().f9691d.setItemAnimator(new DefaultItemAnimator());
        t3().f9691d.addOnScrollListener(new d(linearLayoutManager, this));
        RecyclerView recyclerView = t3().f9691d;
        m.d(recyclerView, "rvSearchActivity");
        hideKeyboardOnScroll(recyclerView);
        t3().f9690c.setOnClickListener(new P4());
        t3().f9692e.setTypeface(aVar.x());
    }

    /* access modifiers changed from: private */
    public static final void y3(SearchActivity searchActivity, View view) {
        if (UptodownApp.f17422D.a0()) {
            searchActivity.finish();
        }
    }

    /* access modifiers changed from: private */
    public static final void z3(SearchActivity searchActivity, View view) {
        if (UptodownApp.f17422D.a0()) {
            searchActivity.t3().f9689b.f9698b.setText("");
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x3();
        a aVar = this.f18362N;
        m.b(aVar);
        aVar.getFilter().filter(t3().f9689b.f9698b.getText().toString());
        Intent intent = getIntent();
        if (intent != null) {
            v3(intent);
        }
        t3().f9690c.setVisibility(8);
        C1001s0 unused = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), Y.c(), (L) null, new f(this, (V2.d) null), 2, (Object) null);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        m.e(menu, "menu");
        MenuInflater menuInflater = getMenuInflater();
        m.d(menuInflater, "getMenuInflater(...)");
        menuInflater.inflate(R.menu.menu_search, menu);
        Object systemService = getSystemService("search");
        m.c(systemService, "null cannot be cast to non-null type android.app.SearchManager");
        SearchManager searchManager = (SearchManager) systemService;
        SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        if (searchView == null) {
            return true;
        }
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setIconifiedByDefault(false);
        return true;
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        m.e(intent, "intent");
        super.onNewIntent(intent);
        v3(intent);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        w3();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        InstantAutoCompleteTextView instantAutoCompleteTextView = t3().f9689b.f9698b;
        m.d(instantAutoCompleteTextView, "actvSearchBar");
        showKeyboard(instantAutoCompleteTextView);
    }

    public boolean onSearchRequested() {
        startSearch((String) null, false, new Bundle(), false);
        return true;
    }
}
