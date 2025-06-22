package L2;

import A1.b;
import A1.c;
import B2.k;
import B2.l;
import H2.j;
import V3.C2592c;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.mbridge.msdk.MBridgeConstans;
import d4.i;
import e4.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.m;
import z3.e;
import z3.f;
import z3.g;

public final class d extends d4.a implements a.b {

    /* renamed from: v  reason: collision with root package name */
    public static final a f7369v = new a();

    /* renamed from: w  reason: collision with root package name */
    public static final String f7370w = d.class.getName();

    /* renamed from: m  reason: collision with root package name */
    public Button f7371m;

    /* renamed from: n  reason: collision with root package name */
    public Button f7372n;

    /* renamed from: o  reason: collision with root package name */
    public RecyclerView f7373o;

    /* renamed from: p  reason: collision with root package name */
    public TextView f7374p;

    /* renamed from: q  reason: collision with root package name */
    public ConstraintLayout f7375q;

    /* renamed from: r  reason: collision with root package name */
    public int f7376r;

    /* renamed from: s  reason: collision with root package name */
    public e4.a f7377s;

    /* renamed from: t  reason: collision with root package name */
    public e f7378t;

    /* renamed from: u  reason: collision with root package name */
    public k f7379u;

    public static final class a {
    }

    public static final void j(d dVar, View view) {
        m.e(dVar, "this$0");
        dVar.dismiss();
    }

    public static final void l(d dVar, View view) {
        m.e(dVar, "this$0");
        e eVar = dVar.f7378t;
        if (eVar == null) {
            m.u("viewModel");
            eVar = null;
        }
        int i4 = dVar.f7376r;
        ArrayList arrayList = (ArrayList) eVar.c(i4);
        int size = arrayList.size();
        int i5 = 0;
        int i6 = 0;
        while (i6 < size) {
            Object obj = arrayList.get(i6);
            i6++;
            eVar.f7380a.f6408r.unset(((e4.d) obj).f24631a.f4812a);
        }
        ArrayList arrayList2 = (ArrayList) eVar.d(i4);
        int size2 = arrayList2.size();
        while (i5 < size2) {
            Object obj2 = arrayList2.get(i5);
            i5++;
            eVar.f7380a.f6407q.unset(((e4.d) obj2).f24631a.f4812a);
        }
        dVar.p();
    }

    public static final void m(d dVar, View view) {
        m.e(dVar, "this$0");
        e eVar = dVar.f7378t;
        if (eVar == null) {
            m.u("viewModel");
            eVar = null;
        }
        int i4 = dVar.f7376r;
        ArrayList arrayList = (ArrayList) eVar.c(i4);
        int size = arrayList.size();
        int i5 = 0;
        int i6 = 0;
        while (i6 < size) {
            Object obj = arrayList.get(i6);
            i6++;
            eVar.f7380a.f6408r.set(((e4.d) obj).f24631a.f4812a);
        }
        ArrayList arrayList2 = (ArrayList) eVar.d(i4);
        int size2 = arrayList2.size();
        while (i5 < size2) {
            Object obj2 = arrayList2.get(i5);
            i5++;
            eVar.f7380a.f6407q.set(((e4.d) obj2).f24631a.f4812a);
        }
        dVar.p();
    }

    public void d(e4.d dVar) {
        m.e(dVar, "item");
        e eVar = this.f7378t;
        e eVar2 = null;
        if (eVar == null) {
            m.u("viewModel");
            eVar = null;
        }
        eVar.getClass();
        m.e(dVar, "switchItem");
        int ordinal = dVar.f24634d.ordinal();
        if (ordinal != 4) {
            if (ordinal == 7) {
                if (m.a(dVar.f24632b, Boolean.TRUE)) {
                    eVar.f7380a.f6407q.set(dVar.f24631a.f4812a);
                } else {
                    eVar.f7380a.f6407q.unset(dVar.f24631a.f4812a);
                }
            }
        } else if (m.a(dVar.f24632b, Boolean.TRUE)) {
            eVar.f7380a.f6408r.set(dVar.f24631a.f4812a);
        } else {
            eVar.f7380a.f6408r.unset(dVar.f24631a.f4812a);
        }
        e eVar3 = this.f7378t;
        if (eVar3 == null) {
            m.u("viewModel");
        } else {
            eVar2 = eVar3;
        }
        k(eVar2.b(this.f7376r));
    }

    public void f(e4.d dVar) {
        m.e(dVar, "item");
        FragmentActivity activity = getActivity();
        if (activity != null && (dVar.f24631a instanceof g)) {
            FragmentManager supportFragmentManager = activity.getSupportFragmentManager();
            i.a aVar = i.f24554y;
            String str = i.f24555z;
            if (supportFragmentManager.findFragmentByTag(str) == null) {
                FragmentTransaction beginTransaction = activity.getSupportFragmentManager().beginTransaction();
                f fVar = dVar.f24631a;
                String str2 = fVar.f4813b;
                String a5 = ((g) fVar).a();
                String b5 = ((g) dVar.f24631a).b();
                e eVar = this.f7378t;
                e eVar2 = null;
                if (eVar == null) {
                    m.u("viewModel");
                    eVar = null;
                }
                String str3 = eVar.f7382c.h().f24225b;
                e eVar3 = this.f7378t;
                if (eVar3 == null) {
                    m.u("viewModel");
                } else {
                    eVar2 = eVar3;
                }
                beginTransaction.add((Fragment) i.a.a(aVar, str2, a5, b5, str3, eVar2.f7382c.h().f24228e, dVar.f24631a.f4812a, dVar.f24634d, false, (j) null, 384), str).commit();
            }
        }
    }

    public final void k(Set set) {
        boolean z4;
        Button button = this.f7372n;
        boolean z5 = false;
        if (button != null) {
            if (!set.isEmpty()) {
                Iterator it = set.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (((Boolean) it.next()).booleanValue()) {
                            z4 = true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            z4 = false;
            button.setEnabled(z4);
        }
        Button button2 = this.f7371m;
        if (button2 != null) {
            if (!set.isEmpty()) {
                Iterator it2 = set.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (!((Boolean) it2.next()).booleanValue()) {
                            z5 = true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            button2.setEnabled(z5);
        }
    }

    public final ColorStateList n() {
        Integer num;
        C2592c cVar = this.f24526j;
        if (cVar == null || (num = cVar.f24077o) == null || cVar.f24078p == null) {
            return null;
        }
        return new ColorStateList(new int[][]{new int[]{16842910}, new int[]{-16842910}}, new int[]{num.intValue(), cVar.f24078p.intValue()});
    }

    public final ColorStateList o() {
        Integer num;
        C2592c cVar = this.f24526j;
        if (cVar == null || (num = cVar.f24075m) == null || cVar.f24076n == null) {
            return null;
        }
        return new ColorStateList(new int[][]{new int[]{16842910}, new int[]{-16842910}}, new int[]{num.intValue(), cVar.f24076n.intValue()});
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            ViewModelStore viewModelStore = getViewModelStore();
            m.d(viewModelStore, "viewModelStore");
            this.f7378t = (e) new ViewModelProvider(viewModelStore, (ViewModelProvider.Factory) new f()).get(e.class);
            ViewModelStore viewModelStore2 = activity.getViewModelStore();
            m.d(viewModelStore2, "it.viewModelStore");
            this.f7379u = (k) new ViewModelProvider(viewModelStore2, (ViewModelProvider.Factory) new l()).get(k.class);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        m.e(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(c.dialog_stacks, viewGroup, false);
        m.d(inflate, "inflater.inflate(R.layou…stacks, container, false)");
        return inflate;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        m.e(dialogInterface, "dialog");
        super.onDismiss(dialogInterface);
        k kVar = this.f7379u;
        if (kVar == null) {
            m.u("optionsViewModel");
            kVar = null;
        }
        kVar.f6219o.postValue(Boolean.TRUE);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        FragmentActivity activity;
        m.e(menuItem, "item");
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
        String str;
        Map map;
        z3.j jVar;
        m.e(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        super.onViewCreated(view, bundle);
        this.f7371m = (Button) view.findViewById(b.btn_agree_to_all);
        this.f7372n = (Button) view.findViewById(b.btn_disagree_to_all);
        this.f7373o = (RecyclerView) view.findViewById(b.rv_switch_item_list);
        this.f7374p = (TextView) view.findViewById(b.tv_stack_name);
        this.f7375q = (ConstraintLayout) view.findViewById(b.stacks_container);
        Bundle arguments = getArguments();
        if (arguments == null) {
            i4 = 0;
        } else {
            i4 = arguments.getInt("stack_id");
        }
        this.f7376r = i4;
        TextView textView = this.f7374p;
        e4.a aVar = null;
        if (textView != null) {
            e eVar = this.f7378t;
            if (eVar == null) {
                m.u("viewModel");
                eVar = null;
            }
            int i5 = this.f7376r;
            e eVar2 = eVar.f7380a.f6391a;
            if (eVar2 == null || (map = eVar2.f4809j) == null || (jVar = (z3.j) map.get(String.valueOf(i5))) == null) {
                str = null;
            } else {
                str = jVar.f4813b;
            }
            textView.setText(str);
        }
        TextView textView2 = this.f24518b;
        if (textView2 != null) {
            e eVar3 = this.f7378t;
            if (eVar3 == null) {
                m.u("viewModel");
                eVar3 = null;
            }
            textView2.setText(eVar3.f7382c.h().f24224a);
        }
        ImageView imageView = this.f24519c;
        if (imageView != null) {
            imageView.setOnClickListener(new a(this));
            e eVar4 = this.f7378t;
            if (eVar4 == null) {
                m.u("viewModel");
                eVar4 = null;
            }
            imageView.setContentDescription(eVar4.f7382c.h().f24229f);
        }
        C2592c cVar = this.f24526j;
        if (cVar != null) {
            Integer num5 = cVar.f24069g;
            if (num5 != null) {
                int intValue = num5.intValue();
                ConstraintLayout constraintLayout = this.f7375q;
                if (constraintLayout != null) {
                    constraintLayout.setBackgroundColor(intValue);
                }
            }
            Integer num6 = cVar.f24071i;
            if (num6 != null) {
                int intValue2 = num6.intValue();
                TextView textView3 = this.f7374p;
                if (textView3 != null) {
                    textView3.setTextColor(intValue2);
                }
            }
            Typeface typeface = this.f24528l;
            if (typeface != null) {
                TextView textView4 = this.f7374p;
                if (textView4 != null) {
                    textView4.setTypeface(typeface);
                }
                Button button = this.f7371m;
                if (button != null) {
                    button.setTypeface(typeface);
                }
                Button button2 = this.f7372n;
                if (button2 != null) {
                    button2.setTypeface(typeface);
                }
            }
            Button button3 = this.f7371m;
            if (button3 != null) {
                ColorStateList o4 = o();
                if (o4 != null) {
                    button3.setTextColor(o4);
                }
                ColorStateList n4 = n();
                if (n4 != null) {
                    button3.setBackgroundTintList(n4);
                }
            }
            Button button4 = this.f7372n;
            if (button4 != null) {
                ColorStateList o5 = o();
                if (o5 != null) {
                    button4.setTextColor(o5);
                }
                ColorStateList n5 = n();
                if (n5 != null) {
                    button4.setBackgroundTintList(n5);
                }
            }
        }
        e eVar5 = this.f7378t;
        if (eVar5 == null) {
            m.u("viewModel");
            eVar5 = null;
        }
        List a5 = eVar5.a(this.f7376r);
        C2592c cVar2 = this.f24526j;
        if (cVar2 == null) {
            num = null;
        } else {
            num = cVar2.f24071i;
        }
        if (cVar2 == null) {
            num2 = null;
        } else {
            num2 = cVar2.f24067e;
        }
        if (cVar2 == null) {
            num3 = null;
        } else {
            num3 = cVar2.f24068f;
        }
        if (cVar2 == null) {
            num4 = null;
        } else {
            num4 = cVar2.f24063a;
        }
        this.f7377s = new e4.a(a5, this, (String) null, (String) null, num, num2, num3, num4, (Typeface) null, this.f24528l, 268);
        RecyclerView recyclerView = this.f7373o;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
            e4.a aVar2 = this.f7377s;
            if (aVar2 == null) {
                m.u("switchAdapter");
            } else {
                aVar = aVar2;
            }
            recyclerView.setAdapter(aVar);
        }
        q();
    }

    public final void p() {
        e4.a aVar = this.f7377s;
        e eVar = null;
        if (aVar == null) {
            m.u("switchAdapter");
            aVar = null;
        }
        e eVar2 = this.f7378t;
        if (eVar2 == null) {
            m.u("viewModel");
            eVar2 = null;
        }
        aVar.b(eVar2.a(this.f7376r), true);
        e eVar3 = this.f7378t;
        if (eVar3 == null) {
            m.u("viewModel");
        } else {
            eVar = eVar3;
        }
        k(eVar.b(this.f7376r));
    }

    public final void q() {
        Button button = this.f7372n;
        if (button != null) {
            button.setText(getString(A1.e.disagree_to_all));
        }
        e eVar = this.f7378t;
        e eVar2 = null;
        if (eVar == null) {
            m.u("viewModel");
            eVar = null;
        }
        k(eVar.b(this.f7376r));
        Button button2 = this.f7372n;
        if (button2 != null) {
            button2.setOnClickListener(new b(this));
        }
        Button button3 = this.f7371m;
        if (button3 != null) {
            e eVar3 = this.f7378t;
            if (eVar3 == null) {
                m.u("viewModel");
            } else {
                eVar2 = eVar3;
            }
            button3.setText(eVar2.f7382c.h().f24226c);
        }
        Button button4 = this.f7371m;
        if (button4 != null) {
            button4.setOnClickListener(new c(this));
        }
    }
}
