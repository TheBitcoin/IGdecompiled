package H2;

import A1.b;
import A1.e;
import F2.f;
import S2.C1601o;
import T3.C2585m;
import U3.C2589b;
import V3.C2592c;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.mbridge.msdk.MBridgeConstans;
import e4.a;
import e4.d;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.m;
import l.C0942a;
import l.C0943b;
import o3.C1001s0;
import o3.L;
import o3.Y;
import z3.c;
import z3.l;

public final class h extends d4.a implements a.b {

    /* renamed from: q  reason: collision with root package name */
    public static final a f6662q = new a();

    /* renamed from: r  reason: collision with root package name */
    public static final String f6663r = h.class.getName();

    /* renamed from: m  reason: collision with root package name */
    public ConstraintLayout f6664m;

    /* renamed from: n  reason: collision with root package name */
    public RecyclerView f6665n;

    /* renamed from: o  reason: collision with root package name */
    public l f6666o;

    /* renamed from: p  reason: collision with root package name */
    public e4.a f6667p;

    public static final class a {
    }

    public static final void j(h hVar, View view) {
        m.e(hVar, "this$0");
        hVar.dismiss();
    }

    public static final void k(h hVar, PopupWindow popupWindow, ImageView imageView, CardView cardView, TextView textView, TextView textView2, TextView textView3, TextView textView4, View view) {
        Integer num;
        Integer num2;
        m.e(hVar, "this$0");
        m.e(popupWindow, "$mypopupWindow");
        C2592c cVar = hVar.f24526j;
        if (!(cVar == null || (num2 = cVar.f24069g) == null)) {
            cardView.setBackgroundTintList(ColorStateList.valueOf(num2.intValue()));
        }
        C2592c cVar2 = hVar.f24526j;
        if (!(cVar2 == null || (num = cVar2.f24073k) == null)) {
            int intValue = num.intValue();
            if (textView != null) {
                textView.setTextColor(ColorStateList.valueOf(intValue));
            }
            if (textView2 != null) {
                textView2.setTextColor(ColorStateList.valueOf(intValue));
            }
            if (textView3 != null) {
                textView3.setTextColor(ColorStateList.valueOf(intValue));
            }
            if (textView4 != null) {
                textView4.setTextColor(ColorStateList.valueOf(intValue));
            }
        }
        popupWindow.showAsDropDown(imageView);
    }

    public static final void l(PopupWindow popupWindow, h hVar, View view) {
        m.e(popupWindow, "$mypopupWindow");
        m.e(hVar, "this$0");
        popupWindow.dismiss();
        TextView textView = hVar.f24518b;
        if (textView != null) {
            textView.setText(hVar.getString(e.all_partners_toolbar_title));
        }
        l lVar = hVar.f6666o;
        if (lVar == null) {
            m.u("viewModel");
            lVar = null;
        }
        lVar.d(j.ALL_VENDORS);
        hVar.o();
    }

    public static final void m(PopupWindow popupWindow, h hVar, View view) {
        m.e(popupWindow, "$mypopupWindow");
        m.e(hVar, "this$0");
        popupWindow.dismiss();
        TextView textView = hVar.f24518b;
        if (textView != null) {
            textView.setText(hVar.getString(e.iab_partners_toolbar_title));
        }
        l lVar = hVar.f6666o;
        if (lVar == null) {
            m.u("viewModel");
            lVar = null;
        }
        lVar.d(j.IAB_VENDORS);
        hVar.o();
    }

    public static final void n(PopupWindow popupWindow, h hVar, View view) {
        m.e(popupWindow, "$mypopupWindow");
        m.e(hVar, "this$0");
        popupWindow.dismiss();
        TextView textView = hVar.f24518b;
        if (textView != null) {
            textView.setText(hVar.getString(e.non_iab_partners_toolbar_title));
        }
        l lVar = hVar.f6666o;
        if (lVar == null) {
            m.u("viewModel");
            lVar = null;
        }
        lVar.d(j.NON_IAB_VENDORS);
        hVar.o();
    }

    public static final void p(PopupWindow popupWindow, h hVar, View view) {
        m.e(popupWindow, "$mypopupWindow");
        m.e(hVar, "this$0");
        popupWindow.dismiss();
        TextView textView = hVar.f24518b;
        if (textView != null) {
            textView.setText(hVar.getString(e.google_partners_toolbar_title));
        }
        l lVar = hVar.f6666o;
        if (lVar == null) {
            m.u("viewModel");
            lVar = null;
        }
        lVar.d(j.GOOGLE_VENDORS);
        hVar.o();
    }

    public void d(d dVar) {
        m.e(dVar, "item");
        l lVar = this.f6666o;
        if (lVar == null) {
            m.u("viewModel");
            lVar = null;
        }
        lVar.getClass();
        m.e(dVar, "item");
        e4.e eVar = dVar.f24634d;
        e4.e eVar2 = e4.e.NON_IAB_VENDOR;
        if (eVar == eVar2) {
            Boolean bool = dVar.f24632b;
            Boolean bool2 = Boolean.TRUE;
            if (m.a(bool, bool2)) {
                lVar.f6677b.f6384A.set(dVar.f24631a.f4812a);
                C2585m mVar = C2585m.f24018a;
                StringBuilder a5 = C0942a.a("Non IAB", '_');
                a5.append(dVar.f24631a.f4812a);
                C0943b.a(dVar.f24632b, bool2, mVar, a5.toString());
                return;
            }
        }
        if (dVar.f24634d != eVar2 || !m.a(dVar.f24632b, Boolean.FALSE)) {
            e4.e eVar3 = dVar.f24634d;
            e4.e eVar4 = e4.e.IAB_VENDOR;
            if (eVar3 == eVar4) {
                Boolean bool3 = dVar.f24632b;
                Boolean bool4 = Boolean.TRUE;
                if (m.a(bool3, bool4)) {
                    lVar.f6677b.f6416z.set(dVar.f24631a.f4812a);
                    C2585m mVar2 = C2585m.f24018a;
                    StringBuilder a6 = C0942a.a("Vendors", '_');
                    a6.append(dVar.f24631a.f4812a);
                    C0943b.a(dVar.f24632b, bool4, mVar2, a6.toString());
                    return;
                }
            }
            if (dVar.f24634d != eVar4 || !m.a(dVar.f24632b, Boolean.FALSE)) {
                e4.e eVar5 = dVar.f24634d;
                e4.e eVar6 = e4.e.GOOGLE_VENDOR;
                if (eVar5 == eVar6) {
                    Boolean bool5 = dVar.f24632b;
                    Boolean bool6 = Boolean.TRUE;
                    if (m.a(bool5, bool6)) {
                        lVar.f6677b.f6385B.set(dVar.f24631a.f4812a);
                        C2585m mVar3 = C2585m.f24018a;
                        StringBuilder a7 = C0942a.a("Google", '_');
                        a7.append(dVar.f24631a.f4812a);
                        C0943b.a(dVar.f24632b, bool6, mVar3, a7.toString());
                        return;
                    }
                }
                if (dVar.f24634d != eVar6 || !m.a(dVar.f24632b, Boolean.FALSE)) {
                    e4.e eVar7 = dVar.f24634d;
                    e4.e eVar8 = e4.e.PUBLISHER_VENDOR;
                    if (eVar7 == eVar8) {
                        Boolean bool7 = dVar.f24632b;
                        Boolean bool8 = Boolean.TRUE;
                        if (m.a(bool7, bool8)) {
                            lVar.f6677b.f6410t.set(dVar.f24631a.f4812a);
                            lVar.f6677b.f6412v.setItems(C1601o.d0(((l) dVar.f24631a).f4819d));
                            C2585m mVar4 = C2585m.f24018a;
                            StringBuilder a8 = C0942a.a("Vendors", '_');
                            a8.append(dVar.f24631a.f4812a);
                            C0943b.a(dVar.f24632b, bool8, mVar4, a8.toString());
                            return;
                        }
                    }
                    if (dVar.f24634d == eVar8 && m.a(dVar.f24632b, Boolean.FALSE)) {
                        lVar.f6677b.f6410t.unset(dVar.f24631a.f4812a);
                        lVar.f6677b.f6412v.unset((Set<Integer>) C1601o.d0(((l) dVar.f24631a).f4819d));
                        C2585m mVar5 = C2585m.f24018a;
                        StringBuilder a9 = C0942a.a("Vendors", '_');
                        a9.append(dVar.f24631a.f4812a);
                        C0943b.a(dVar.f24632b, Boolean.TRUE, mVar5, a9.toString());
                        return;
                    }
                    return;
                }
                lVar.f6677b.f6385B.unset(dVar.f24631a.f4812a);
                C2585m mVar6 = C2585m.f24018a;
                StringBuilder a10 = C0942a.a("Google", '_');
                a10.append(dVar.f24631a.f4812a);
                C0943b.a(dVar.f24632b, Boolean.TRUE, mVar6, a10.toString());
                return;
            }
            lVar.f6677b.f6416z.unset(dVar.f24631a.f4812a);
            C2585m mVar7 = C2585m.f24018a;
            StringBuilder a11 = C0942a.a("Vendors", '_');
            a11.append(dVar.f24631a.f4812a);
            C0943b.a(dVar.f24632b, Boolean.TRUE, mVar7, a11.toString());
            return;
        }
        lVar.f6677b.f6384A.unset(dVar.f24631a.f4812a);
        C2585m mVar8 = C2585m.f24018a;
        StringBuilder a12 = C0942a.a("Non IAB", '_');
        a12.append(dVar.f24631a.f4812a);
        C0943b.a(dVar.f24632b, Boolean.TRUE, mVar8, a12.toString());
    }

    public void f(d dVar) {
        FragmentActivity fragmentActivity;
        f fVar;
        String str;
        String str2;
        l lVar;
        String str3;
        String str4;
        String num;
        d dVar2 = dVar;
        m.e(dVar2, "item");
        FragmentActivity activity = getActivity();
        if (activity != null && (dVar2.f24631a instanceof l)) {
            FragmentManager supportFragmentManager = activity.getSupportFragmentManager();
            String str5 = f.f6491I;
            if (supportFragmentManager.findFragmentByTag(str5) == null) {
                z3.f fVar2 = dVar2.f24631a;
                if (fVar2 instanceof l) {
                    String str6 = fVar2.f4813b;
                    String str7 = ((l) fVar2).f4818c;
                    l lVar2 = this.f6666o;
                    if (lVar2 == null) {
                        m.u("viewModel");
                        lVar2 = null;
                    }
                    String a5 = lVar2.a(((l) dVar2.f24631a).f4819d, a.PURPOSE);
                    l lVar3 = this.f6666o;
                    if (lVar3 == null) {
                        m.u("viewModel");
                        lVar3 = null;
                    }
                    String a6 = lVar3.a(((l) dVar2.f24631a).f4822g, a.SPECIAL_PURPOSE);
                    l lVar4 = this.f6666o;
                    if (lVar4 == null) {
                        m.u("viewModel");
                        lVar4 = null;
                    }
                    String a7 = lVar4.a(((l) dVar2.f24631a).f4823h, a.FEATURE);
                    l lVar5 = this.f6666o;
                    if (lVar5 == null) {
                        m.u("viewModel");
                        lVar5 = null;
                    }
                    String a8 = lVar5.a(((l) dVar2.f24631a).f4824i, a.SPECIAL_FEATURE);
                    l lVar6 = this.f6666o;
                    if (lVar6 == null) {
                        m.u("viewModel");
                        lVar6 = null;
                    }
                    String a9 = lVar6.a(((l) dVar2.f24631a).f4829n, a.DATA_DECLARATION);
                    String str8 = ((l) dVar2.f24631a).f4825j;
                    l lVar7 = this.f6666o;
                    if (lVar7 == null) {
                        m.u("viewModel");
                        lVar7 = null;
                    }
                    int i4 = ((l) dVar2.f24631a).f4827l;
                    lVar7.getClass();
                    if (i4 < 0) {
                        fragmentActivity = activity;
                        str = str8;
                        str2 = "";
                    } else {
                        fragmentActivity = activity;
                        float f4 = ((float) i4) / 86400.0f;
                        if (f4 >= 1.0f) {
                            StringBuilder sb = new StringBuilder();
                            str = str8;
                            sb.append(f3.a.a(f4));
                            sb.append(' ');
                            sb.append(lVar7.f6676a.g().f24193i);
                            str2 = sb.toString();
                        } else {
                            str = str8;
                            str2 = i4 + ' ' + lVar7.f6676a.g().f24194j;
                        }
                    }
                    l lVar8 = this.f6666o;
                    if (lVar8 == null) {
                        m.u("viewModel");
                        lVar = null;
                    } else {
                        lVar = lVar8;
                    }
                    Boolean bool = ((l) dVar2.f24631a).f4828m;
                    lVar.getClass();
                    if (m.a(bool, Boolean.TRUE)) {
                        str3 = lVar.f6676a.g().f24197m;
                    } else if (m.a(bool, Boolean.FALSE)) {
                        str3 = lVar.f6676a.g().f24198n;
                    } else {
                        str3 = "";
                    }
                    c cVar = ((l) dVar2.f24631a).f4830o;
                    if (cVar == null || (num = Integer.valueOf(cVar.f4797a).toString()) == null) {
                        str4 = "";
                    } else {
                        str4 = num;
                    }
                    z3.f fVar3 = dVar2.f24631a;
                    String str9 = str;
                    String str10 = str3;
                    F2.a aVar = new F2.a(str6, str7, a5, (String) null, a6, a7, a8, a9, str9, str2, str10, str4, fVar3.f4812a, dVar2.f24634d, ((l) fVar3).f4831p, "Error: cannot load vendor file", 8);
                    m.e(aVar, "args");
                    fVar = new f();
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("partner_detail_args", aVar);
                    fVar.setArguments(bundle);
                } else {
                    fragmentActivity = activity;
                    fVar = null;
                }
                if (fVar != null) {
                    fragmentActivity.getSupportFragmentManager().beginTransaction().add((Fragment) fVar, str5).commit();
                }
            }
        }
    }

    public final void o() {
        CharSequence query;
        boolean z4;
        SearchView searchView = this.f24521e;
        if (searchView != null && (query = searchView.getQuery()) != null) {
            e4.a aVar = this.f6667p;
            l lVar = null;
            if (aVar == null) {
                m.u("switchAdapter");
                aVar = null;
            }
            l lVar2 = this.f6666o;
            if (lVar2 == null) {
                m.u("viewModel");
            } else {
                lVar = lVar2;
            }
            List c5 = lVar.c(query.toString());
            if (query.length() > 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            aVar.b(c5, z4);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getActivity() != null) {
            ViewModelStore viewModelStore = getViewModelStore();
            m.d(viewModelStore, "viewModelStore");
            this.f6666o = (l) new ViewModelProvider(viewModelStore, (ViewModelProvider.Factory) new m()).get(l.class);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        m.e(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(A1.c.dialog_partners, viewGroup, false);
        m.d(inflate, "inflater.inflate(R.layou…rtners, container, false)");
        return inflate;
    }

    public void onPause() {
        boolean z4;
        super.onPause();
        l lVar = this.f6666o;
        if (lVar == null) {
            m.u("viewModel");
            lVar = null;
        }
        SearchView searchView = this.f24521e;
        if (searchView == null) {
            z4 = false;
        } else {
            z4 = searchView.hasFocus();
        }
        lVar.f6686k = z4;
    }

    public void onViewCreated(View view, Bundle bundle) {
        Integer num;
        Integer num2;
        Integer num3;
        Integer num4;
        SearchView searchView;
        Integer num5;
        m.e(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        super.onViewCreated(view, bundle);
        this.f6664m = (ConstraintLayout) view.findViewById(b.partners_container);
        this.f6665n = (RecyclerView) view.findViewById(b.rv_partners_list);
        l lVar = this.f6666o;
        l lVar2 = null;
        if (lVar == null) {
            m.u("viewModel");
            lVar = null;
        }
        lVar.getClass();
        C1001s0 unused = C0981i.d(ViewModelKt.getViewModelScope(lVar), Y.b(), (L) null, new k(lVar, (V2.d) null), 2, (Object) null);
        TextView textView = this.f24518b;
        if (textView != null) {
            l lVar3 = this.f6666o;
            if (lVar3 == null) {
                m.u("viewModel");
                lVar3 = null;
            }
            textView.setText(C2589b.a(lVar3.f6676a.a().f24200a));
        }
        ImageView imageView = this.f24519c;
        if (imageView != null) {
            imageView.setOnClickListener(new b(this));
            l lVar4 = this.f6666o;
            if (lVar4 == null) {
                m.u("viewModel");
                lVar4 = null;
            }
            imageView.setContentDescription(lVar4.f6676a.a().f24206g);
        }
        q();
        SearchView searchView2 = this.f24521e;
        if (searchView2 != null) {
            searchView2.setVisibility(0);
        }
        SearchView searchView3 = this.f24521e;
        if (searchView3 != null) {
            l lVar5 = this.f6666o;
            if (lVar5 == null) {
                m.u("viewModel");
                lVar5 = null;
            }
            searchView3.setQueryHint(lVar5.f6676a.a().f24202c);
        }
        SearchView searchView4 = this.f24521e;
        if (searchView4 != null) {
            searchView4.setOnQueryTextListener(new i(this));
        }
        l lVar6 = this.f6666o;
        if (lVar6 == null) {
            m.u("viewModel");
            lVar6 = null;
        }
        List c5 = lVar6.c("");
        l lVar7 = this.f6666o;
        if (lVar7 == null) {
            m.u("viewModel");
            lVar7 = null;
        }
        String str = lVar7.f6676a.a().f24201b;
        C2592c cVar = this.f24526j;
        if (cVar == null) {
            num = null;
        } else {
            num = cVar.f24071i;
        }
        if (cVar == null) {
            num2 = null;
        } else {
            num2 = cVar.f24067e;
        }
        if (cVar == null) {
            num3 = null;
        } else {
            num3 = cVar.f24068f;
        }
        if (cVar == null) {
            num4 = null;
        } else {
            num4 = cVar.f24063a;
        }
        this.f6667p = new e4.a(c5, this, str, (String) null, num, num2, num3, num4, this.f24527k, this.f24528l, 8);
        RecyclerView recyclerView = this.f6665n;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
            e4.a aVar = this.f6667p;
            if (aVar == null) {
                m.u("switchAdapter");
                aVar = null;
            }
            recyclerView.setAdapter(aVar);
        }
        C2592c cVar2 = this.f24526j;
        if (!(cVar2 == null || (num5 = cVar2.f24069g) == null)) {
            int intValue = num5.intValue();
            ConstraintLayout constraintLayout = this.f6664m;
            if (constraintLayout != null) {
                constraintLayout.setBackgroundColor(intValue);
            }
        }
        l lVar8 = this.f6666o;
        if (lVar8 == null) {
            m.u("viewModel");
        } else {
            lVar2 = lVar8;
        }
        if (lVar2.f6686k && (searchView = this.f24521e) != null) {
            searchView.requestFocus();
        }
    }

    public final void q() {
        ImageView imageView;
        l lVar = this.f6666o;
        l lVar2 = null;
        if (lVar == null) {
            m.u("viewModel");
            lVar = null;
        }
        if (!((ArrayList) lVar.f()).isEmpty() || !((ArrayList) lVar.b()).isEmpty()) {
            Toolbar toolbar = this.f24517a;
            if (toolbar == null) {
                imageView = null;
            } else {
                imageView = (ImageView) toolbar.findViewById(b.toolbar_menu);
            }
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            View inflate = LayoutInflater.from(getContext()).inflate(A1.c.list_partner_menu, (ViewGroup) null);
            CardView cardView = (CardView) inflate.findViewById(b.cv_menu_item);
            TextView textView = (TextView) inflate.findViewById(b.tv_menu_all);
            TextView textView2 = (TextView) inflate.findViewById(b.tv_menu_iab);
            TextView textView3 = (TextView) inflate.findViewById(b.tv_menu_non_iab);
            TextView textView4 = (TextView) inflate.findViewById(b.tv_menu_google);
            l lVar3 = this.f6666o;
            if (lVar3 == null) {
                m.u("viewModel");
                lVar3 = null;
            }
            if (((ArrayList) lVar3.f()).isEmpty()) {
                textView3.setVisibility(8);
            }
            l lVar4 = this.f6666o;
            if (lVar4 == null) {
                m.u("viewModel");
            } else {
                lVar2 = lVar4;
            }
            if (((ArrayList) lVar2.b()).isEmpty()) {
                textView4.setVisibility(8);
            }
            PopupWindow popupWindow = new PopupWindow(inflate, 600, -2, true);
            popupWindow.setElevation(10.0f);
            textView.setOnClickListener(new c(popupWindow, this));
            textView2.setOnClickListener(new d(popupWindow, this));
            textView3.setOnClickListener(new e(popupWindow, this));
            textView4.setOnClickListener(new f(popupWindow, this));
            if (imageView != null) {
                imageView.setOnClickListener(new g(this, popupWindow, imageView, cardView, textView, textView2, textView3, textView4));
            }
        }
    }
}
