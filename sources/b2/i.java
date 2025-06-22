package B2;

import A1.b;
import A1.c;
import H2.h;
import H2.j;
import S2.C1601o;
import T3.C2578f;
import T3.C2585m;
import T3.C2586n;
import U3.C2589b;
import V2.d;
import V3.C2592c;
import V3.p;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.C0501d;
import c.e;
import c.g;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.inmobi.cmp.ChoiceCmpCallback;
import com.inmobi.cmp.data.storage.SharedStorage;
import com.mbridge.msdk.MBridgeConstans;
import d4.i;
import d4.m;
import e4.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import l.C0942a;
import l.C0943b;
import l.C0951j;
import o3.C0988l0;
import o3.C1001s0;
import o3.L;
import o3.Y;
import z3.f;
import z3.l;

public final class i extends d4.a implements a.b, m.a {

    /* renamed from: E  reason: collision with root package name */
    public static final a f6183E = new a();

    /* renamed from: F  reason: collision with root package name */
    public static final String f6184F = i.class.getName();

    /* renamed from: A  reason: collision with root package name */
    public TextView f6185A;

    /* renamed from: B  reason: collision with root package name */
    public FrameLayout f6186B;

    /* renamed from: C  reason: collision with root package name */
    public k f6187C;

    /* renamed from: D  reason: collision with root package name */
    public m f6188D;

    /* renamed from: m  reason: collision with root package name */
    public RecyclerView f6189m;

    /* renamed from: n  reason: collision with root package name */
    public RecyclerView f6190n;

    /* renamed from: o  reason: collision with root package name */
    public RecyclerView f6191o;

    /* renamed from: p  reason: collision with root package name */
    public RecyclerView f6192p;

    /* renamed from: q  reason: collision with root package name */
    public ConstraintLayout f6193q;

    /* renamed from: r  reason: collision with root package name */
    public LinearLayout f6194r;

    /* renamed from: s  reason: collision with root package name */
    public LinearLayout f6195s;

    /* renamed from: t  reason: collision with root package name */
    public Button f6196t;

    /* renamed from: u  reason: collision with root package name */
    public Button f6197u;

    /* renamed from: v  reason: collision with root package name */
    public TextView f6198v;

    /* renamed from: w  reason: collision with root package name */
    public TextView f6199w;

    /* renamed from: x  reason: collision with root package name */
    public TextView f6200x;

    /* renamed from: y  reason: collision with root package name */
    public TextView f6201y;

    /* renamed from: z  reason: collision with root package name */
    public TextView f6202z;

    public static final class a {
    }

    public static final void j(i iVar, View view) {
        kotlin.jvm.internal.m.e(iVar, "this$0");
        iVar.dismiss();
    }

    public static final void k(i iVar, Boolean bool) {
        kotlin.jvm.internal.m.e(iVar, "this$0");
        m mVar = iVar.f6188D;
        k kVar = null;
        if (mVar == null) {
            kotlin.jvm.internal.m.u("stacksAdapter");
            mVar = null;
        }
        k kVar2 = iVar.f6187C;
        if (kVar2 == null) {
            kotlin.jvm.internal.m.u("viewModel");
        } else {
            kVar = kVar2;
        }
        List d5 = kVar.d();
        mVar.getClass();
        kotlin.jvm.internal.m.e(d5, "items");
        mVar.f24577a = d5;
        mVar.notifyDataSetChanged();
    }

    public static final void l(i iVar, String str) {
        kotlin.jvm.internal.m.e(iVar, "this$0");
        iVar.p();
    }

    public static final void m(i iVar, View view) {
        FragmentManager supportFragmentManager;
        FragmentTransaction beginTransaction;
        FragmentTransaction add;
        kotlin.jvm.internal.m.e(iVar, "this$0");
        FragmentActivity activity = iVar.getActivity();
        if (activity != null && (supportFragmentManager = activity.getSupportFragmentManager()) != null && (beginTransaction = supportFragmentManager.beginTransaction()) != null && (add = beginTransaction.add((Fragment) new h(), h.f6663r)) != null) {
            add.commit();
        }
    }

    public static final void n(i iVar, String str) {
        kotlin.jvm.internal.m.e(iVar, "this$0");
        iVar.p();
    }

    public static final void o(i iVar, View view) {
        FragmentManager supportFragmentManager;
        FragmentTransaction beginTransaction;
        FragmentTransaction add;
        kotlin.jvm.internal.m.e(iVar, "this$0");
        FragmentActivity activity = iVar.getActivity();
        if (activity != null && (supportFragmentManager = activity.getSupportFragmentManager()) != null && (beginTransaction = supportFragmentManager.beginTransaction()) != null && (add = beginTransaction.add((Fragment) new C0951j(), C0951j.f3537u)) != null) {
            add.commit();
        }
    }

    public static final void q(i iVar, View view) {
        g gVar;
        kotlin.jvm.internal.m.e(iVar, "this$0");
        c.i iVar2 = c.i.f1157a;
        k kVar = null;
        if (c.i.f1158b) {
            Fragment findFragmentByTag = iVar.getChildFragmentManager().findFragmentByTag(g.f1149h);
            if (findFragmentByTag instanceof g) {
                gVar = (g) findFragmentByTag;
            } else {
                gVar = null;
            }
            if (gVar != null) {
                e eVar = gVar.f1152c;
                if (eVar == null) {
                    kotlin.jvm.internal.m.u("viewModel");
                    eVar = null;
                }
                eVar.getClass();
                if (c.i.f1158b) {
                    c.i.f1159c.setAllOwnedItems();
                    SharedStorage sharedStorage = eVar.f1144a;
                    a4.a aVar = a4.a.GBC_CONSENT_STRING;
                    sharedStorage.d(aVar, iVar2.a(sharedStorage.k(aVar), c.i.f1159c));
                    ChoiceCmpCallback choiceCmpCallback = eVar.f1145b;
                    if (choiceCmpCallback != null) {
                        choiceCmpCallback.onGoogleBasicConsentChange(iVar2.b());
                    }
                    C1001s0 unused = C0981i.d(C0988l0.f3711a, Y.b(), (L) null, new C0501d((d) null), 2, (Object) null);
                }
            }
        }
        k kVar2 = iVar.f6187C;
        if (kVar2 == null) {
            kotlin.jvm.internal.m.u("viewModel");
        } else {
            kVar = kVar2;
        }
        kVar.f6205a.x();
        kVar.e();
        C2585m.f24018a.b(C2586n.ACCEPT_ALL, C2578f.GDPR).observe(iVar, new h(iVar));
    }

    public static final void s(i iVar, View view) {
        g gVar;
        kotlin.jvm.internal.m.e(iVar, "this$0");
        k kVar = null;
        if (c.i.f1158b) {
            Fragment findFragmentByTag = iVar.getChildFragmentManager().findFragmentByTag(g.f1149h);
            if (findFragmentByTag instanceof g) {
                gVar = (g) findFragmentByTag;
            } else {
                gVar = null;
            }
            if (gVar != null) {
                gVar.g();
            }
        }
        k kVar2 = iVar.f6187C;
        if (kVar2 == null) {
            kotlin.jvm.internal.m.u("viewModel");
        } else {
            kVar = kVar2;
        }
        kVar.e();
        C2585m.f24018a.b(C2586n.SAVE_AND_EXIT, C2578f.GDPR).observe(iVar, new g(iVar));
    }

    public void d(e4.d dVar) {
        kotlin.jvm.internal.m.e(dVar, "item");
        k kVar = this.f6187C;
        if (kVar == null) {
            kotlin.jvm.internal.m.u("viewModel");
            kVar = null;
        }
        kVar.getClass();
        kotlin.jvm.internal.m.e(dVar, "item");
        f fVar = dVar.f24631a;
        if (fVar instanceof z3.i) {
            Boolean bool = dVar.f24632b;
            Boolean bool2 = Boolean.TRUE;
            if (kotlin.jvm.internal.m.a(bool, bool2)) {
                kVar.f6205a.f6408r.set(dVar.f24631a.f4812a);
            } else {
                kVar.f6205a.f6408r.unset(dVar.f24631a.f4812a);
            }
            C2585m mVar = C2585m.f24018a;
            StringBuilder a5 = C0942a.a("Purposes", '_');
            a5.append(dVar.f24631a.f4812a);
            C0943b.a(dVar.f24632b, bool2, mVar, a5.toString());
        } else if (fVar instanceof z3.d) {
            Boolean bool3 = dVar.f24632b;
            Boolean bool4 = Boolean.TRUE;
            if (kotlin.jvm.internal.m.a(bool3, bool4)) {
                kVar.f6205a.f6407q.set(dVar.f24631a.f4812a);
            } else {
                kVar.f6205a.f6407q.unset(dVar.f24631a.f4812a);
            }
            C2585m mVar2 = C2585m.f24018a;
            StringBuilder a6 = C0942a.a("Special Features", '_');
            a6.append(dVar.f24631a.f4812a);
            C0943b.a(dVar.f24632b, bool4, mVar2, a6.toString());
        }
    }

    public void e(p pVar) {
        kotlin.jvm.internal.m.e(pVar, "item");
        FragmentActivity activity = getActivity();
        if (activity != null) {
            FragmentManager supportFragmentManager = activity.getSupportFragmentManager();
            String str = L2.d.f7370w;
            if (supportFragmentManager.findFragmentByTag(str) == null) {
                int i4 = pVar.f24221a;
                L2.d dVar = new L2.d();
                Bundle bundle = new Bundle();
                bundle.putInt("stack_id", i4);
                dVar.setArguments(bundle);
                activity.getSupportFragmentManager().beginTransaction().add((Fragment) dVar, str).commit();
            }
        }
    }

    public void f(e4.d dVar) {
        kotlin.jvm.internal.m.e(dVar, "item");
        FragmentActivity activity = getActivity();
        if (activity != null && (dVar.f24631a instanceof z3.g)) {
            FragmentManager supportFragmentManager = activity.getSupportFragmentManager();
            i.a aVar = d4.i.f24554y;
            String str = d4.i.f24555z;
            if (supportFragmentManager.findFragmentByTag(str) == null) {
                FragmentTransaction beginTransaction = activity.getSupportFragmentManager().beginTransaction();
                f fVar = dVar.f24631a;
                String str2 = fVar.f4813b;
                String a5 = ((z3.g) fVar).a();
                String b5 = ((z3.g) dVar.f24631a).b();
                k kVar = this.f6187C;
                k kVar2 = null;
                if (kVar == null) {
                    kotlin.jvm.internal.m.u("viewModel");
                    kVar = null;
                }
                String str3 = kVar.f6210f.f().f24177i;
                k kVar3 = this.f6187C;
                if (kVar3 == null) {
                    kotlin.jvm.internal.m.u("viewModel");
                } else {
                    kVar2 = kVar3;
                }
                beginTransaction.add((Fragment) i.a.a(aVar, str2, a5, b5, str3, kVar2.f6210f.f().f24182n, dVar.f24631a.f4812a, dVar.f24634d, false, (j) null, 384), str).commit();
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            ViewModelStore viewModelStore = activity.getViewModelStore();
            kotlin.jvm.internal.m.d(viewModelStore, "it.viewModelStore");
            k kVar = (k) new ViewModelProvider(viewModelStore, (ViewModelProvider.Factory) new l()).get(k.class);
            this.f6187C = kVar;
            if (kVar == null) {
                kotlin.jvm.internal.m.u("viewModel");
                kVar = null;
            }
            kVar.f6219o.observe(this, new a(this));
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.m.e(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(c.dialog_options, viewGroup, false);
        kotlin.jvm.internal.m.d(inflate, "inflater.inflate(R.layou…ptions, container, false)");
        return inflate;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        FragmentActivity activity;
        kotlin.jvm.internal.m.e(menuItem, "item");
        if (menuItem.getItemId() == 16908332 && (activity = getActivity()) != null) {
            activity.onBackPressed();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public void onViewCreated(View view, Bundle bundle) {
        int i4;
        Integer num;
        Integer num2;
        Integer num3;
        Integer num4;
        Integer num5;
        Integer num6;
        Integer num7;
        Integer num8;
        Integer num9;
        Integer num10;
        Integer num11;
        Integer num12;
        String str;
        Map map;
        View view2 = view;
        kotlin.jvm.internal.m.e(view2, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        super.onViewCreated(view, bundle);
        this.f6189m = (RecyclerView) view2.findViewById(b.rv_privacy_policy);
        this.f6190n = (RecyclerView) view2.findViewById(b.rv_special_features_list);
        this.f6191o = (RecyclerView) view2.findViewById(b.rv_purposes_list);
        this.f6192p = (RecyclerView) view2.findViewById(b.rv_stacks_list);
        this.f6193q = (ConstraintLayout) view2.findViewById(b.options_container);
        this.f6194r = (LinearLayout) view2.findViewById(b.section_legitimate_int);
        this.f6195s = (LinearLayout) view2.findViewById(b.section_partners);
        this.f6197u = (Button) view2.findViewById(b.btn_agree_to_all);
        this.f6196t = (Button) view2.findViewById(b.btn_save_and_exit);
        this.f6198v = (TextView) view2.findViewById(b.tv_partners_options);
        this.f6199w = (TextView) view2.findViewById(b.tv_special_purposes_and_features_label);
        this.f6200x = (TextView) view2.findViewById(b.tv_purposes_label);
        this.f6201y = (TextView) view2.findViewById(b.tv_leg_interests_label);
        this.f6202z = (TextView) view2.findViewById(b.tv_partners_label);
        this.f6185A = (TextView) view2.findViewById(b.tv_options_description);
        int i5 = b.gbc_fragment_container;
        FrameLayout frameLayout = (FrameLayout) view2.findViewById(i5);
        this.f6186B = frameLayout;
        k kVar = null;
        if (c.i.f1158b) {
            getChildFragmentManager().beginTransaction().add(i5, (Fragment) new g(), g.f1149h).addToBackStack((String) null).commit();
        } else if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
        k kVar2 = this.f6187C;
        if (kVar2 == null) {
            kotlin.jvm.internal.m.u("viewModel");
            kVar2 = null;
        }
        kVar2.getClass();
        C1001s0 unused = C0981i.d(ViewModelKt.getViewModelScope(kVar2), Y.b(), (L) null, new j(kVar2, (d) null), 2, (Object) null);
        k kVar3 = this.f6187C;
        if (kVar3 == null) {
            kotlin.jvm.internal.m.u("viewModel");
            kVar3 = null;
        }
        z3.e eVar = kVar3.f6205a.f6391a;
        if (eVar == null || (map = eVar.f4808i) == null) {
            i4 = 0;
        } else {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry : map.entrySet()) {
                if (((l) entry.getValue()).f4826k == null) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            i4 = linkedHashMap.size();
        }
        List list = kVar3.f6206b.f171c.f166a;
        ArrayList arrayList = new ArrayList();
        for (Object next : list) {
            Set d02 = C1601o.d0(((C3.d) next).f164f);
            List list2 = kVar3.f6206b.f170b.f135h;
            if (!b.l.a(d02) || !d02.isEmpty()) {
                Iterator it = d02.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (b.c.a((Number) it.next(), list2)) {
                            arrayList.add(next);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        String valueOf = String.valueOf(kVar3.f6207c.f6348a.size() + arrayList.size() + i4 + (kVar3.f6208d == null ? 0 : 1));
        k kVar4 = this.f6187C;
        if (kVar4 == null) {
            kotlin.jvm.internal.m.u("viewModel");
            kVar4 = null;
        }
        String str2 = kVar4.f6210f.f().f24170b;
        TextView textView = this.f6185A;
        if (textView != null) {
            textView.setText(m3.m.u(str2, "${partners}", valueOf, true));
        }
        TextView textView2 = this.f6185A;
        if (textView2 != null) {
            k kVar5 = this.f6187C;
            if (kVar5 == null) {
                kotlin.jvm.internal.m.u("viewModel");
                kVar5 = null;
            }
            kVar5.getClass();
            if (c.i.f1158b) {
                str = kVar5.f6215k.f7744b.f7739c;
            } else {
                str = "";
            }
            textView2.append(str);
        }
        TextView textView3 = this.f6202z;
        if (textView3 != null) {
            k kVar6 = this.f6187C;
            if (kVar6 == null) {
                kotlin.jvm.internal.m.u("viewModel");
                kVar6 = null;
            }
            textView3.setText(C2589b.a(kVar6.f6210f.f().f24173e));
        }
        TextView textView4 = this.f6201y;
        if (textView4 != null) {
            k kVar7 = this.f6187C;
            if (kVar7 == null) {
                kotlin.jvm.internal.m.u("viewModel");
                kVar7 = null;
            }
            textView4.setText(C2589b.a(kVar7.f6210f.f().f24171c));
        }
        TextView textView5 = this.f6200x;
        if (textView5 != null) {
            k kVar8 = this.f6187C;
            if (kVar8 == null) {
                kotlin.jvm.internal.m.u("viewModel");
                kVar8 = null;
            }
            textView5.setText(kVar8.f6210f.f().f24172d);
        }
        TextView textView6 = this.f6199w;
        if (textView6 != null) {
            k kVar9 = this.f6187C;
            if (kVar9 == null) {
                kotlin.jvm.internal.m.u("viewModel");
                kVar9 = null;
            }
            textView6.setText(kVar9.f6210f.f().f24174f);
        }
        TextView textView7 = this.f6198v;
        if (textView7 != null) {
            k kVar10 = this.f6187C;
            if (kVar10 == null) {
                kotlin.jvm.internal.m.u("viewModel");
                kVar10 = null;
            }
            textView7.setText(kVar10.f6210f.f().f24178j);
        }
        TextView textView8 = this.f24518b;
        if (textView8 != null) {
            k kVar11 = this.f6187C;
            if (kVar11 == null) {
                kotlin.jvm.internal.m.u("viewModel");
                kVar11 = null;
            }
            textView8.setText(kVar11.f6210f.f().f24169a);
        }
        ImageView imageView = this.f24519c;
        if (imageView != null) {
            imageView.setOnClickListener(new b(this));
            k kVar12 = this.f6187C;
            if (kVar12 == null) {
                kotlin.jvm.internal.m.u("viewModel");
                kVar12 = null;
            }
            imageView.setContentDescription(kVar12.f6210f.f().f24183o);
        }
        k kVar13 = this.f6187C;
        if (kVar13 == null) {
            kotlin.jvm.internal.m.u("viewModel");
            kVar13 = null;
        }
        List d5 = kVar13.d();
        C2592c cVar = this.f24526j;
        if (cVar == null) {
            num = null;
        } else {
            num = cVar.f24071i;
        }
        if (cVar == null) {
            num2 = null;
        } else {
            num2 = cVar.f24063a;
        }
        this.f6188D = new m(d5, this, num, num2, this.f24528l);
        RecyclerView recyclerView = this.f6192p;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
            m mVar = this.f6188D;
            if (mVar == null) {
                kotlin.jvm.internal.m.u("stacksAdapter");
                mVar = null;
            }
            recyclerView.setAdapter(mVar);
        }
        RecyclerView recyclerView2 = this.f6191o;
        if (recyclerView2 != null) {
            recyclerView2.setLayoutManager(new LinearLayoutManager(recyclerView2.getContext()));
            RecyclerView recyclerView3 = recyclerView2;
            k kVar14 = this.f6187C;
            if (kVar14 == null) {
                kotlin.jvm.internal.m.u("viewModel");
                kVar14 = null;
            }
            List b5 = kVar14.b();
            C2592c cVar2 = this.f24526j;
            if (cVar2 == null) {
                num9 = null;
            } else {
                num9 = cVar2.f24071i;
            }
            if (cVar2 == null) {
                num10 = null;
            } else {
                num10 = cVar2.f24067e;
            }
            if (cVar2 == null) {
                num11 = null;
            } else {
                num11 = cVar2.f24068f;
            }
            if (cVar2 == null) {
                num12 = null;
            } else {
                num12 = cVar2.f24063a;
            }
            recyclerView3.setAdapter(new e4.a(b5, this, (String) null, (String) null, num9, num10, num11, num12, (Typeface) null, this.f24528l, 268));
        }
        RecyclerView recyclerView4 = this.f6190n;
        if (recyclerView4 != null) {
            recyclerView4.setLayoutManager(new LinearLayoutManager(recyclerView4.getContext()));
            k kVar15 = this.f6187C;
            if (kVar15 == null) {
                kotlin.jvm.internal.m.u("viewModel");
                kVar15 = null;
            }
            List c5 = kVar15.c();
            C2592c cVar3 = this.f24526j;
            if (cVar3 == null) {
                num5 = null;
            } else {
                num5 = cVar3.f24071i;
            }
            if (cVar3 == null) {
                num6 = null;
            } else {
                num6 = cVar3.f24067e;
            }
            if (cVar3 == null) {
                num7 = null;
            } else {
                num7 = cVar3.f24068f;
            }
            if (cVar3 == null) {
                num8 = null;
            } else {
                num8 = cVar3.f24063a;
            }
            recyclerView4.setAdapter(new e4.a(c5, this, (String) null, (String) null, num5, num6, num7, num8, (Typeface) null, this.f24528l, 268));
        }
        RecyclerView recyclerView5 = this.f6189m;
        if (recyclerView5 != null) {
            recyclerView5.setLayoutManager(new LinearLayoutManager(recyclerView5.getContext()));
            k kVar16 = this.f6187C;
            if (kVar16 == null) {
                kotlin.jvm.internal.m.u("viewModel");
                kVar16 = null;
            }
            List list3 = kVar16.f6211g;
            Context context = recyclerView5.getContext();
            kotlin.jvm.internal.m.d(context, "context");
            C2592c cVar4 = this.f24526j;
            if (cVar4 == null) {
                num4 = null;
            } else {
                num4 = cVar4.f24074l;
            }
            recyclerView5.setAdapter(new d4.l(list3, context, num4, this.f24528l));
        }
        r();
        TextView textView9 = this.f6200x;
        if (textView9 != null) {
            k kVar17 = this.f6187C;
            if (kVar17 == null) {
                kotlin.jvm.internal.m.u("viewModel");
                kVar17 = null;
            }
            k kVar18 = this.f6187C;
            if (kVar18 == null) {
                kotlin.jvm.internal.m.u("viewModel");
                kVar18 = null;
            }
            List b6 = kVar18.b();
            kVar17.getClass();
            kotlin.jvm.internal.m.e(b6, "itemsList");
            textView9.setVisibility(!((ArrayList) b6).isEmpty() ? 0 : 8);
        }
        TextView textView10 = this.f6199w;
        if (textView10 != null) {
            k kVar19 = this.f6187C;
            if (kVar19 == null) {
                kotlin.jvm.internal.m.u("viewModel");
                kVar19 = null;
            }
            k kVar20 = this.f6187C;
            if (kVar20 == null) {
                kotlin.jvm.internal.m.u("viewModel");
            } else {
                kVar = kVar20;
            }
            List c6 = kVar.c();
            kVar19.getClass();
            kotlin.jvm.internal.m.e(c6, "itemsList");
            textView10.setVisibility(!((ArrayList) c6).isEmpty() ? 0 : 8);
        }
        C2592c cVar5 = this.f24526j;
        if (cVar5 != null) {
            Integer num13 = cVar5.f24069g;
            if (num13 != null) {
                int intValue = num13.intValue();
                ConstraintLayout constraintLayout = this.f6193q;
                if (constraintLayout != null) {
                    constraintLayout.setBackgroundColor(intValue);
                }
            }
            Integer num14 = cVar5.f24071i;
            if (num14 != null) {
                int intValue2 = num14.intValue();
                TextView textView11 = this.f6200x;
                if (textView11 != null) {
                    textView11.setTextColor(intValue2);
                }
                TextView textView12 = this.f6199w;
                if (textView12 != null) {
                    textView12.setTextColor(intValue2);
                }
                TextView textView13 = this.f6198v;
                if (textView13 != null) {
                    textView13.setTextColor(intValue2);
                }
                TextView textView14 = this.f6202z;
                if (textView14 != null) {
                    textView14.setTextColor(intValue2);
                }
                TextView textView15 = this.f6201y;
                if (textView15 != null) {
                    textView15.setTextColor(intValue2);
                }
                TextView textView16 = this.f6185A;
                if (textView16 != null) {
                    textView16.setTextColor(intValue2);
                }
            }
            Integer num15 = cVar5.f24063a;
            if (num15 != null) {
                int intValue3 = num15.intValue();
                TextView textView17 = this.f6185A;
                if (textView17 != null) {
                    GradientDrawable gradientDrawable = new GradientDrawable();
                    gradientDrawable.setCornerRadius(2.0f);
                    gradientDrawable.setStroke(4, intValue3);
                    textView17.setBackground(gradientDrawable);
                }
            }
            Integer num16 = cVar5.f24075m;
            if (num16 != null) {
                int intValue4 = num16.intValue();
                Button button = this.f6197u;
                if (button != null) {
                    button.setTextColor(intValue4);
                }
                Button button2 = this.f6196t;
                if (button2 != null) {
                    button2.setTextColor(intValue4);
                }
            }
            Integer num17 = cVar5.f24077o;
            if (num17 != null) {
                int intValue5 = num17.intValue();
                Button button3 = this.f6197u;
                if (button3 != null) {
                    button3.setBackgroundTintList(ColorStateList.valueOf(intValue5));
                }
                Button button4 = this.f6196t;
                if (button4 != null) {
                    button4.setBackgroundTintList(ColorStateList.valueOf(intValue5));
                }
            }
        }
        C2592c cVar6 = this.f24526j;
        if (!(cVar6 == null || (num3 = cVar6.f24063a) == null)) {
            int intValue6 = num3.intValue();
            View findViewById = view2.findViewById(b.purposes_divider);
            if (findViewById != null) {
                findViewById.setBackgroundTintList(ColorStateList.valueOf(intValue6));
            }
            View findViewById2 = view2.findViewById(b.special_features_divider);
            if (findViewById2 != null) {
                findViewById2.setBackgroundTintList(ColorStateList.valueOf(intValue6));
            }
            View findViewById3 = view2.findViewById(b.partners_divider);
            if (findViewById3 != null) {
                findViewById3.setBackgroundTintList(ColorStateList.valueOf(intValue6));
            }
            View findViewById4 = view2.findViewById(b.consent_divider);
            if (findViewById4 != null) {
                findViewById4.setBackgroundTintList(ColorStateList.valueOf(intValue6));
            }
            View findViewById5 = view2.findViewById(b.leg_interests_divider);
            if (findViewById5 != null) {
                findViewById5.setBackgroundTintList(ColorStateList.valueOf(intValue6));
            }
        }
        Typeface typeface = this.f24527k;
        if (typeface != null) {
            TextView textView18 = this.f6200x;
            if (textView18 != null) {
                textView18.setTypeface(typeface);
            }
            TextView textView19 = this.f6199w;
            if (textView19 != null) {
                textView19.setTypeface(typeface);
            }
            TextView textView20 = this.f6198v;
            if (textView20 != null) {
                textView20.setTypeface(typeface);
            }
        }
        Typeface typeface2 = this.f24528l;
        if (typeface2 != null) {
            TextView textView21 = this.f6185A;
            if (textView21 != null) {
                textView21.setTypeface(typeface2);
            }
            TextView textView22 = this.f6202z;
            if (textView22 != null) {
                textView22.setTypeface(typeface2);
            }
            TextView textView23 = this.f6201y;
            if (textView23 != null) {
                textView23.setTypeface(typeface2);
            }
            Button button5 = this.f6197u;
            if (button5 != null) {
                button5.setTypeface(typeface2);
            }
            Button button6 = this.f6196t;
            if (button6 != null) {
                button6.setTypeface(typeface2);
            }
        }
    }

    public final void p() {
        Fragment fragment;
        FragmentManager supportFragmentManager;
        FragmentActivity activity = getActivity();
        if (activity == null || (supportFragmentManager = activity.getSupportFragmentManager()) == null) {
            fragment = null;
        } else {
            fragment = supportFragmentManager.findFragmentByTag(J2.f.f7243m);
        }
        BottomSheetDialogFragment bottomSheetDialogFragment = (BottomSheetDialogFragment) fragment;
        if (bottomSheetDialogFragment != null) {
            bottomSheetDialogFragment.dismiss();
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 != null) {
            activity2.finish();
        }
    }

    public final void r() {
        Button button = this.f6197u;
        k kVar = null;
        if (button != null) {
            k kVar2 = this.f6187C;
            if (kVar2 == null) {
                kotlin.jvm.internal.m.u("viewModel");
                kVar2 = null;
            }
            button.setText(kVar2.f6210f.f().f24175g);
            button.setOnClickListener(new c(this));
        }
        Button button2 = this.f6196t;
        if (button2 != null) {
            k kVar3 = this.f6187C;
            if (kVar3 == null) {
                kotlin.jvm.internal.m.u("viewModel");
            } else {
                kVar = kVar3;
            }
            button2.setText(kVar.f6210f.f().f24176h);
            button2.setOnClickListener(new d(this));
        }
        LinearLayout linearLayout = this.f6195s;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(new e(this));
        }
        LinearLayout linearLayout2 = this.f6194r;
        if (linearLayout2 != null) {
            linearLayout2.setOnClickListener(new f(this));
        }
    }
}
