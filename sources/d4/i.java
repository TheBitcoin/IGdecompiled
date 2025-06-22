package d4;

import A1.c;
import B2.k;
import H2.j;
import T3.C2574b;
import T3.C2585m;
import V3.C2592c;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import e4.d;
import e4.e;
import e4.f;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.m;
import z3.l;

public final class i extends a {

    /* renamed from: A  reason: collision with root package name */
    public static int f24552A;

    /* renamed from: B  reason: collision with root package name */
    public static e f24553B;

    /* renamed from: y  reason: collision with root package name */
    public static final a f24554y = new a();

    /* renamed from: z  reason: collision with root package name */
    public static final String f24555z;

    /* renamed from: m  reason: collision with root package name */
    public ConstraintLayout f24556m;

    /* renamed from: n  reason: collision with root package name */
    public TextView f24557n;

    /* renamed from: o  reason: collision with root package name */
    public TextView f24558o;

    /* renamed from: p  reason: collision with root package name */
    public TextView f24559p;

    /* renamed from: q  reason: collision with root package name */
    public TextView f24560q;

    /* renamed from: r  reason: collision with root package name */
    public TextView f24561r;

    /* renamed from: s  reason: collision with root package name */
    public NestedScrollView f24562s;

    /* renamed from: t  reason: collision with root package name */
    public RecyclerView f24563t;

    /* renamed from: u  reason: collision with root package name */
    public k f24564u;

    /* renamed from: v  reason: collision with root package name */
    public boolean f24565v;

    /* renamed from: w  reason: collision with root package name */
    public boolean f24566w;

    /* renamed from: x  reason: collision with root package name */
    public String f24567x;

    public static final class a {
        public static /* synthetic */ i a(a aVar, String str, String str2, String str3, String str4, String str5, int i4, e eVar, boolean z4, j jVar, int i5) {
            int i6 = i5;
            return aVar.b((i6 & 1) != 0 ? "" : str, (i6 & 2) != 0 ? "" : str2, (i6 & 4) != 0 ? "" : str3, (i6 & 8) != 0 ? "" : str4, (i6 & 16) != 0 ? "" : str5, i4, eVar, (i6 & 128) != 0 ? false : z4, (i6 & 256) != 0 ? j.ALL_VENDORS : null);
        }

        public final i b(String str, String str2, String str3, String str4, String str5, int i4, e eVar, boolean z4, j jVar) {
            m.e(str, CampaignEx.JSON_KEY_TITLE);
            m.e(str2, "description");
            m.e(str3, "legalDescription");
            m.e(str4, "legalDescriptionLabel");
            m.e(str5, "closeLabel");
            m.e(eVar, "switchItemType");
            m.e(jVar, "vendorTypeSelected");
            i iVar = new i();
            Bundle bundle = new Bundle();
            bundle.putString(CampaignEx.JSON_KEY_TITLE, str);
            bundle.putString("description", str2);
            bundle.putString("legal_description", str3);
            bundle.putString("legal_description_label", str4);
            bundle.putString("close_button_label", str5);
            bundle.putBoolean("legitimate_interest", z4);
            bundle.putString("vendor_type_selected", jVar.name());
            i.f24552A = i4;
            i.f24553B = eVar;
            iVar.setArguments(bundle);
            return iVar;
        }
    }

    public static final class b extends Dialog {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f24568a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(Context context, i iVar, int i4) {
            super(context, i4);
            this.f24568a = iVar;
        }

        public void onBackPressed() {
            i iVar = this.f24568a;
            a aVar = i.f24554y;
            iVar.m();
        }
    }

    static {
        String simpleName = i.class.getSimpleName();
        m.d(simpleName, "LegalDetailFragment::class.java.simpleName");
        f24555z = simpleName;
    }

    public static final void k(i iVar, View view) {
        l lVar;
        z3.e eVar;
        Map map;
        Integer num;
        d a5;
        Map map2;
        d a6;
        Map map3;
        d a7;
        Map map4;
        i iVar2 = iVar;
        m.e(iVar2, "this$0");
        NestedScrollView nestedScrollView = iVar2.f24562s;
        if (nestedScrollView != null) {
            nestedScrollView.setVisibility(8);
        }
        RecyclerView recyclerView = iVar2.f24563t;
        if (recyclerView != null) {
            k kVar = iVar2.f24564u;
            if (kVar == null) {
                m.u("viewModel");
                kVar = null;
            }
            int i4 = f24552A;
            e eVar2 = f24553B;
            if (eVar2 == null) {
                m.u("localSwitchItemType");
                eVar2 = null;
            }
            boolean z4 = iVar2.f24566w;
            String str = iVar2.f24567x;
            if (str == null) {
                str = "";
            }
            kVar.getClass();
            m.e(eVar2, "itemType");
            m.e(str, "vendorTypeSelected");
            ArrayList arrayList = new ArrayList();
            int ordinal = eVar2.ordinal();
            if (ordinal == 4) {
                ArrayList arrayList2 = new ArrayList();
                if (!((!m.a(str, "ALL_VENDORS") && !m.a(str, "IAB_VENDORS")) || (eVar = kVar.f6205a.f6391a) == null || (map = eVar.f4808i) == null)) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    for (Map.Entry entry : map.entrySet()) {
                        if (((l) entry.getValue()).f4826k == null) {
                            linkedHashMap.put(entry.getKey(), entry.getValue());
                        }
                    }
                    for (Map.Entry value : linkedHashMap.entrySet()) {
                        l lVar2 = (l) value.getValue();
                        if (z4) {
                            for (Number intValue : lVar2.f4820e) {
                                if (intValue.intValue() == i4) {
                                    arrayList2.add(new d(lVar2, (Boolean) null, f.NON_SWITCH, e.PURPOSE_PARTNER, false, lVar2.f4813b, (Integer) null, 82));
                                }
                            }
                        } else {
                            for (Number intValue2 : lVar2.f4819d) {
                                if (intValue2.intValue() == i4) {
                                    arrayList2.add(new d(lVar2, (Boolean) null, f.NON_SWITCH, e.PURPOSE_PARTNER, false, lVar2.f4813b, (Integer) null, 82));
                                }
                            }
                        }
                    }
                }
                if (m.a(str, "ALL_VENDORS") || m.a(str, "NON_IAB_VENDORS")) {
                    for (C3.d dVar : kVar.f6206b.f171c.f166a) {
                        if (z4) {
                            for (Number intValue3 : dVar.f165g) {
                                if (intValue3.intValue() == i4) {
                                    arrayList2.add(new d(dVar.a(), (Boolean) null, f.NON_SWITCH, e.PURPOSE_PARTNER, false, dVar.f161c, (Integer) null, 82));
                                }
                            }
                        } else {
                            for (Number intValue4 : dVar.f164f) {
                                if (intValue4.intValue() == i4) {
                                    arrayList2.add(new d(dVar.a(), (Boolean) null, f.NON_SWITCH, e.PURPOSE_PARTNER, false, dVar.f161c, (Integer) null, 82));
                                }
                            }
                        }
                    }
                    if (m.a(str, "ALL_VENDORS") && (lVar = kVar.f6208d) != null) {
                        if (z4) {
                            for (Number intValue5 : lVar.f4820e) {
                                if (intValue5.intValue() == i4) {
                                    arrayList2.add(new d(lVar, (Boolean) null, f.NON_SWITCH, e.PURPOSE_PARTNER, false, lVar.f4813b, (Integer) null, 82));
                                }
                            }
                        } else {
                            for (Number intValue6 : lVar.f4819d) {
                                if (intValue6.intValue() == i4) {
                                    arrayList2.add(new d(lVar, (Boolean) null, f.NON_SWITCH, e.PURPOSE_PARTNER, false, lVar.f4813b, (Integer) null, 82));
                                }
                            }
                        }
                    }
                }
                arrayList.addAll(arrayList2);
            } else if (ordinal != 5) {
                if (ordinal != 6) {
                    if (ordinal == 7 && (m.a(str, "ALL_VENDORS") || m.a(str, "IAB_VENDORS"))) {
                        z3.e eVar3 = kVar.f6205a.f6391a;
                        if (!(eVar3 == null || (map4 = eVar3.f4808i) == null)) {
                            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                            for (Map.Entry entry2 : map4.entrySet()) {
                                if (((l) entry2.getValue()).f4826k == null) {
                                    linkedHashMap2.put(entry2.getKey(), entry2.getValue());
                                }
                            }
                            for (Map.Entry value2 : linkedHashMap2.entrySet()) {
                                l lVar3 = (l) value2.getValue();
                                for (Number intValue7 : lVar3.f4824i) {
                                    if (intValue7.intValue() == i4) {
                                        arrayList.add(new d(lVar3, (Boolean) null, f.NON_SWITCH, e.PURPOSE_PARTNER, false, lVar3.f4813b, (Integer) null, 82));
                                    }
                                }
                            }
                        }
                        l lVar4 = kVar.f6208d;
                        if (!(lVar4 == null || (a7 = kVar.a(str, lVar4.f4824i, i4)) == null)) {
                            arrayList.add(a7);
                        }
                    }
                } else if (m.a(str, "ALL_VENDORS") || m.a(str, "IAB_VENDORS")) {
                    z3.e eVar4 = kVar.f6205a.f6391a;
                    if (!(eVar4 == null || (map3 = eVar4.f4808i) == null)) {
                        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
                        for (Map.Entry entry3 : map3.entrySet()) {
                            if (((l) entry3.getValue()).f4826k == null) {
                                linkedHashMap3.put(entry3.getKey(), entry3.getValue());
                            }
                        }
                        for (Map.Entry value3 : linkedHashMap3.entrySet()) {
                            l lVar5 = (l) value3.getValue();
                            for (Number intValue8 : lVar5.f4823h) {
                                if (intValue8.intValue() == i4) {
                                    arrayList.add(new d(lVar5, (Boolean) null, f.NON_SWITCH, e.PURPOSE_PARTNER, false, lVar5.f4813b, (Integer) null, 82));
                                }
                            }
                        }
                    }
                    l lVar6 = kVar.f6208d;
                    if (!(lVar6 == null || (a6 = kVar.a(str, lVar6.f4823h, i4)) == null)) {
                        arrayList.add(a6);
                    }
                }
            } else if (m.a(str, "ALL_VENDORS") || m.a(str, "IAB_VENDORS")) {
                z3.e eVar5 = kVar.f6205a.f6391a;
                if (!(eVar5 == null || (map2 = eVar5.f4808i) == null)) {
                    LinkedHashMap linkedHashMap4 = new LinkedHashMap();
                    for (Map.Entry entry4 : map2.entrySet()) {
                        if (((l) entry4.getValue()).f4826k == null) {
                            linkedHashMap4.put(entry4.getKey(), entry4.getValue());
                        }
                    }
                    for (Map.Entry value4 : linkedHashMap4.entrySet()) {
                        l lVar7 = (l) value4.getValue();
                        for (Number intValue9 : lVar7.f4822g) {
                            if (intValue9.intValue() == i4) {
                                arrayList.add(new d(lVar7, (Boolean) null, f.NON_SWITCH, e.PURPOSE_PARTNER, false, lVar7.f4813b, (Integer) null, 82));
                            }
                        }
                    }
                }
                l lVar8 = kVar.f6208d;
                if (!(lVar8 == null || (a5 = kVar.a(str, lVar8.f4822g, i4)) == null)) {
                    arrayList.add(a5);
                }
            }
            Integer num2 = null;
            j jVar = new j();
            C2592c cVar = iVar2.f24526j;
            if (cVar == null) {
                num = null;
            } else {
                num = cVar.f24071i;
            }
            if (cVar != null) {
                num2 = cVar.f24063a;
            }
            recyclerView.setAdapter(new e4.a(arrayList, jVar, (String) null, (String) null, num, (Integer) null, (Integer) null, num2, (Typeface) null, iVar2.f24528l, 364));
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
            recyclerView.setVisibility(0);
        }
        iVar2.f24565v = true;
    }

    public static final void l(i iVar, View view) {
        m.e(iVar, "this$0");
        iVar.m();
    }

    public final void j(View view) {
        this.f24556m = (ConstraintLayout) view.findViewById(A1.b.legal_detail_container);
        this.f24557n = (TextView) view.findViewById(A1.b.detail_legal_description_label);
        this.f24558o = (TextView) view.findViewById(A1.b.detail_legal_description);
        this.f24559p = (TextView) view.findViewById(A1.b.detail_description);
        this.f24560q = (TextView) view.findViewById(A1.b.detail_title);
        this.f24561r = (TextView) view.findViewById(A1.b.tv_show_partners);
        this.f24562s = (NestedScrollView) view.findViewById(A1.b.sc_description_container);
        this.f24563t = (RecyclerView) view.findViewById(A1.b.rv_purpose_partners_list);
        k kVar = this.f24564u;
        if (kVar == null) {
            m.u("viewModel");
            kVar = null;
        }
        String str = kVar.f6210f.f().f24184p;
        if (str.length() > 0) {
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(new UnderlineSpan(), 0, str.length(), 0);
            TextView textView = this.f24561r;
            if (textView != null) {
                textView.setText(spannableString);
            }
        }
        TextView textView2 = this.f24561r;
        if (textView2 != null) {
            textView2.setOnClickListener(new h(this));
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            TextView textView3 = this.f24560q;
            if (textView3 != null) {
                textView3.setText(arguments.getString(CampaignEx.JSON_KEY_TITLE, ""));
            }
            TextView textView4 = this.f24559p;
            if (textView4 != null) {
                textView4.setText(arguments.getString("description", ""));
            }
            TextView textView5 = this.f24558o;
            if (textView5 != null) {
                textView5.setText(arguments.getString("legal_description", ""));
            }
            TextView textView6 = this.f24557n;
            if (textView6 != null) {
                textView6.setText(arguments.getString("legal_description_label", ""));
            }
            this.f24566w = arguments.getBoolean("legitimate_interest", false);
            this.f24567x = arguments.getString("vendor_type_selected", "");
        }
    }

    public final void m() {
        if (this.f24565v) {
            NestedScrollView nestedScrollView = this.f24562s;
            if (nestedScrollView != null) {
                nestedScrollView.setVisibility(0);
            }
            RecyclerView recyclerView = this.f24563t;
            if (recyclerView != null) {
                recyclerView.setVisibility(8);
            }
            this.f24565v = false;
            return;
        }
        C2585m mVar = C2585m.f24018a;
        StringBuilder sb = new StringBuilder();
        e eVar = f24553B;
        if (eVar == null) {
            m.u("localSwitchItemType");
            eVar = null;
        }
        int ordinal = eVar.ordinal();
        int i4 = 6;
        if (ordinal != 5) {
            if (ordinal != 6) {
                i4 = 7;
                if (ordinal != 7) {
                    i4 = 3;
                }
            } else {
                i4 = 1;
            }
        }
        sb.append(C2574b.a(i4));
        sb.append("-id:");
        sb.append(f24552A);
        mVar.f("collapseElement", sb.toString());
        dismiss();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            ViewModelStore viewModelStore = activity.getViewModelStore();
            m.d(viewModelStore, "it.viewModelStore");
            this.f24564u = (k) new ViewModelProvider(viewModelStore, (ViewModelProvider.Factory) new B2.l()).get(k.class);
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        b bVar;
        Context context = getContext();
        if (context == null) {
            bVar = null;
        } else {
            bVar = new b(context, this, A1.f.CmpActivityTheme);
        }
        if (bVar != null) {
            return bVar;
        }
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        m.d(onCreateDialog, "super.onCreateDialog(savedInstanceState)");
        return onCreateDialog;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        m.e(layoutInflater, "inflater");
        return layoutInflater.inflate(c.dialog_legal_detail, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        TextView textView;
        String str;
        m.e(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        super.onViewCreated(view, bundle);
        TextView textView2 = this.f24518b;
        k kVar = null;
        if (textView2 != null) {
            e eVar = f24553B;
            if (eVar == null) {
                m.u("localSwitchItemType");
                eVar = null;
            }
            int ordinal = eVar.ordinal();
            if (ordinal == 4) {
                k kVar2 = this.f24564u;
                if (kVar2 == null) {
                    m.u("viewModel");
                    kVar2 = null;
                }
                str = kVar2.f6210f.f().f24172d;
            } else if (ordinal == 5) {
                k kVar3 = this.f24564u;
                if (kVar3 == null) {
                    m.u("viewModel");
                    kVar3 = null;
                }
                str = kVar3.f6210f.f().f24174f;
            } else if (ordinal != 6) {
                k kVar4 = this.f24564u;
                if (kVar4 == null) {
                    m.u("viewModel");
                    kVar4 = null;
                }
                str = kVar4.f6210f.f().f24172d;
            } else {
                k kVar5 = this.f24564u;
                if (kVar5 == null) {
                    m.u("viewModel");
                    kVar5 = null;
                }
                str = kVar5.f6210f.f().f24174f;
            }
            textView2.setText(str);
        }
        ImageView imageView = this.f24519c;
        if (imageView != null) {
            imageView.setOnClickListener(new g(this));
            k kVar6 = this.f24564u;
            if (kVar6 == null) {
                m.u("viewModel");
            } else {
                kVar = kVar6;
            }
            imageView.setContentDescription(kVar.f6210f.f().f24183o);
        }
        j(view);
        C2592c cVar = this.f24526j;
        if (cVar != null) {
            Integer num = cVar.f24071i;
            if (num != null) {
                int intValue = num.intValue();
                TextView textView3 = this.f24560q;
                if (textView3 != null) {
                    textView3.setTextColor(intValue);
                }
                TextView textView4 = this.f24559p;
                if (textView4 != null) {
                    textView4.setTextColor(intValue);
                }
                TextView textView5 = this.f24558o;
                if (textView5 != null) {
                    textView5.setTextColor(intValue);
                }
                TextView textView6 = this.f24557n;
                if (textView6 != null) {
                    textView6.setTextColor(intValue);
                }
            }
            Integer num2 = cVar.f24074l;
            if (num2 != null) {
                int intValue2 = num2.intValue();
                TextView textView7 = this.f24561r;
                if (textView7 != null) {
                    textView7.setTextColor(intValue2);
                }
            }
            Integer num3 = cVar.f24069g;
            if (num3 != null) {
                int intValue3 = num3.intValue();
                ConstraintLayout constraintLayout = this.f24556m;
                if (constraintLayout != null) {
                    constraintLayout.setBackgroundColor(intValue3);
                }
            }
        }
        Typeface typeface = this.f24527k;
        if (!(typeface == null || (textView = this.f24560q) == null)) {
            textView.setTypeface(typeface);
        }
        Typeface typeface2 = this.f24528l;
        if (typeface2 != null) {
            TextView textView8 = this.f24561r;
            if (textView8 != null) {
                textView8.setTypeface(typeface2);
            }
            TextView textView9 = this.f24559p;
            if (textView9 != null) {
                textView9.setTypeface(typeface2);
            }
            TextView textView10 = this.f24558o;
            if (textView10 != null) {
                textView10.setTypeface(typeface2);
            }
            TextView textView11 = this.f24557n;
            if (textView11 != null) {
                textView11.setTypeface(typeface2);
            }
        }
    }
}
