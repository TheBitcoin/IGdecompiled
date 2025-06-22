package n;

import A1.b;
import A1.c;
import A1.e;
import A3.f;
import A3.i;
import S2.C1594h;
import V3.C2592c;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.recyclerview.widget.RecyclerView;
import c.g;
import com.mbridge.msdk.MBridgeConstans;
import e4.a;
import e4.d;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.m;
import o3.C1001s0;
import o3.L;
import o3.Y;

public final class l extends d4.a implements a.b {

    /* renamed from: A  reason: collision with root package name */
    public static final a f3589A = new a();

    /* renamed from: B  reason: collision with root package name */
    public static final String f3590B = l.class.getName();

    /* renamed from: m  reason: collision with root package name */
    public TextView f3591m;

    /* renamed from: n  reason: collision with root package name */
    public TextView f3592n;

    /* renamed from: o  reason: collision with root package name */
    public TextView f3593o;

    /* renamed from: p  reason: collision with root package name */
    public Button f3594p;

    /* renamed from: q  reason: collision with root package name */
    public Button f3595q;

    /* renamed from: r  reason: collision with root package name */
    public RecyclerView f3596r;

    /* renamed from: s  reason: collision with root package name */
    public RecyclerView f3597s;

    /* renamed from: t  reason: collision with root package name */
    public RecyclerView f3598t;

    /* renamed from: u  reason: collision with root package name */
    public FrameLayout f3599u;

    /* renamed from: v  reason: collision with root package name */
    public ConstraintLayout f3600v;

    /* renamed from: w  reason: collision with root package name */
    public View f3601w;

    /* renamed from: x  reason: collision with root package name */
    public View f3602x;

    /* renamed from: y  reason: collision with root package name */
    public View f3603y;

    /* renamed from: z  reason: collision with root package name */
    public m f3604z;

    public static final class a {
    }

    public static final void k(l lVar, View view) {
        m.e(lVar, "this$0");
        lVar.dismiss();
    }

    public static final void l(l lVar, String str) {
        m.e(lVar, "this$0");
        lVar.dismiss();
        FragmentActivity activity = lVar.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* JADX WARNING: Failed to insert additional move for type inference */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m(n.l r6, android.view.View r7) {
        /*
            java.lang.String r7 = "this$0"
            kotlin.jvm.internal.m.e(r6, r7)
            boolean r7 = c.i.f1158b
            r0 = 0
            if (r7 == 0) goto L_0x0022
            androidx.fragment.app.FragmentManager r7 = r6.getChildFragmentManager()
            java.lang.String r1 = c.g.f1149h
            androidx.fragment.app.Fragment r7 = r7.findFragmentByTag(r1)
            boolean r1 = r7 instanceof c.g
            if (r1 == 0) goto L_0x001b
            c.g r7 = (c.g) r7
            goto L_0x001c
        L_0x001b:
            r7 = r0
        L_0x001c:
            if (r7 != 0) goto L_0x001f
            goto L_0x0022
        L_0x001f:
            r7.g()
        L_0x0022:
            n.m r7 = r6.f3604z
            if (r7 != 0) goto L_0x002c
            java.lang.String r7 = "viewModel"
            kotlin.jvm.internal.m.u(r7)
            r7 = r0
        L_0x002c:
            androidx.recyclerview.widget.RecyclerView r1 = r6.f3596r
            if (r1 != 0) goto L_0x0032
            r1 = r0
            goto L_0x0036
        L_0x0032:
            androidx.recyclerview.widget.RecyclerView$Adapter r1 = r1.getAdapter()
        L_0x0036:
            boolean r2 = r1 instanceof e4.a
            if (r2 == 0) goto L_0x003d
            e4.a r1 = (e4.a) r1
            goto L_0x003e
        L_0x003d:
            r1 = r0
        L_0x003e:
            r2 = 10
            if (r1 != 0) goto L_0x0043
            goto L_0x0047
        L_0x0043:
            java.util.List r1 = r1.f24593a
            if (r1 != 0) goto L_0x0049
        L_0x0047:
            r3 = r0
            goto L_0x0068
        L_0x0049:
            java.util.ArrayList r3 = new java.util.ArrayList
            int r4 = S2.C1601o.p(r1, r2)
            r3.<init>(r4)
            java.util.Iterator r1 = r1.iterator()
        L_0x0056:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x0068
            java.lang.Object r4 = r1.next()
            e4.d r4 = (e4.d) r4
            java.lang.Boolean r4 = r4.f24632b
            r3.add(r4)
            goto L_0x0056
        L_0x0068:
            androidx.recyclerview.widget.RecyclerView r1 = r6.f3597s
            if (r1 != 0) goto L_0x006e
            r1 = r0
            goto L_0x0072
        L_0x006e:
            androidx.recyclerview.widget.RecyclerView$Adapter r1 = r1.getAdapter()
        L_0x0072:
            boolean r4 = r1 instanceof e4.a
            if (r4 == 0) goto L_0x0079
            e4.a r1 = (e4.a) r1
            goto L_0x007a
        L_0x0079:
            r1 = r0
        L_0x007a:
            if (r1 != 0) goto L_0x007d
            goto L_0x0081
        L_0x007d:
            java.util.List r1 = r1.f24593a
            if (r1 != 0) goto L_0x0083
        L_0x0081:
            r4 = r0
            goto L_0x00a2
        L_0x0083:
            java.util.ArrayList r4 = new java.util.ArrayList
            int r5 = S2.C1601o.p(r1, r2)
            r4.<init>(r5)
            java.util.Iterator r1 = r1.iterator()
        L_0x0090:
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto L_0x00a2
            java.lang.Object r5 = r1.next()
            e4.d r5 = (e4.d) r5
            java.lang.Boolean r5 = r5.f24632b
            r4.add(r5)
            goto L_0x0090
        L_0x00a2:
            androidx.recyclerview.widget.RecyclerView r1 = r6.f3598t
            if (r1 != 0) goto L_0x00a8
            r1 = r0
            goto L_0x00ac
        L_0x00a8:
            androidx.recyclerview.widget.RecyclerView$Adapter r1 = r1.getAdapter()
        L_0x00ac:
            boolean r5 = r1 instanceof e4.a
            if (r5 == 0) goto L_0x00b3
            e4.a r1 = (e4.a) r1
            goto L_0x00b4
        L_0x00b3:
            r1 = r0
        L_0x00b4:
            if (r1 != 0) goto L_0x00b7
            goto L_0x00db
        L_0x00b7:
            java.util.List r1 = r1.f24593a
            if (r1 != 0) goto L_0x00bc
            goto L_0x00db
        L_0x00bc:
            java.util.ArrayList r0 = new java.util.ArrayList
            int r2 = S2.C1601o.p(r1, r2)
            r0.<init>(r2)
            java.util.Iterator r1 = r1.iterator()
        L_0x00c9:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x00db
            java.lang.Object r2 = r1.next()
            e4.d r2 = (e4.d) r2
            java.lang.Boolean r2 = r2.f24632b
            r0.add(r2)
            goto L_0x00c9
        L_0x00db:
            if (r3 != 0) goto L_0x00e1
            java.util.List r3 = S2.C1601o.h()
        L_0x00e1:
            if (r4 != 0) goto L_0x00e7
            java.util.List r4 = S2.C1601o.h()
        L_0x00e7:
            java.util.List r1 = S2.C1601o.S(r3, r4)
            if (r0 != 0) goto L_0x00f1
            java.util.List r0 = S2.C1601o.h()
        L_0x00f1:
            java.util.List r0 = S2.C1601o.S(r1, r0)
            r7.getClass()
            java.lang.String r1 = "purposeSwitchItemList"
            kotlin.jvm.internal.m.e(r0, r1)
            A3.a r1 = r7.f3605a
            java.util.List r1 = r1.f32d
            if (r1 != 0) goto L_0x0104
            goto L_0x010f
        L_0x0104:
            A3.d r2 = A3.d.f51a
            n.n r3 = new n.n
            r3.<init>(r7)
            r7 = 1
            r2.b(r1, r7, r3)
        L_0x010f:
            boolean r7 = r0 instanceof java.util.Collection
            if (r7 == 0) goto L_0x011a
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L_0x011a
            goto L_0x0159
        L_0x011a:
            java.util.Iterator r1 = r0.iterator()
        L_0x011e:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0159
            java.lang.Object r2 = r1.next()
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            java.lang.Boolean r3 = java.lang.Boolean.FALSE
            boolean r2 = kotlin.jvm.internal.m.a(r2, r3)
            if (r2 != 0) goto L_0x011e
            if (r7 == 0) goto L_0x013b
            boolean r7 = r0.isEmpty()
            if (r7 == 0) goto L_0x013b
            goto L_0x0156
        L_0x013b:
            java.util.Iterator r7 = r0.iterator()
        L_0x013f:
            boolean r0 = r7.hasNext()
            if (r0 == 0) goto L_0x0156
            java.lang.Object r0 = r7.next()
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            boolean r0 = kotlin.jvm.internal.m.a(r0, r1)
            if (r0 != 0) goto L_0x013f
            T3.a r7 = T3.C2573a.ACCEPT_PARTIAL
            goto L_0x015b
        L_0x0156:
            T3.a r7 = T3.C2573a.REJECT
            goto L_0x015b
        L_0x0159:
            T3.a r7 = T3.C2573a.ACCEPT_ALL
        L_0x015b:
            T3.m r0 = T3.C2585m.f24018a
            T3.n r1 = T3.C2586n.SAVE_AND_EXIT
            androidx.lifecycle.LiveData r7 = r0.a(r1, r7)
            n.k r0 = new n.k
            r0.<init>(r6)
            r7.observe(r6, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: n.l.m(n.l, android.view.View):void");
    }

    public static final void n(l lVar, String str) {
        m.e(lVar, "this$0");
        lVar.dismiss();
        FragmentActivity activity = lVar.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    public static final void o(l lVar, View view) {
        m.e(lVar, "this$0");
        m mVar = lVar.f3604z;
        if (mVar == null) {
            m.u("viewModel");
            mVar = null;
        }
        mVar.a().observe(lVar, new j(lVar));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: A3.e} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: A3.f} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: type inference failed for: r1v8 */
    /* JADX WARNING: type inference failed for: r1v9 */
    /* JADX WARNING: type inference failed for: r1v10 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void d(e4.d r6) {
        /*
            r5 = this;
            java.lang.String r0 = "item"
            kotlin.jvm.internal.m.e(r6, r0)
            n.m r0 = r5.f3604z
            r1 = 0
            if (r0 != 0) goto L_0x0010
            java.lang.String r0 = "viewModel"
            kotlin.jvm.internal.m.u(r0)
            r0 = r1
        L_0x0010:
            r0.getClass()
            java.lang.String r2 = "itemData"
            kotlin.jvm.internal.m.e(r6, r2)
            e4.e r2 = r6.f24634d
            int r2 = r2.ordinal()
            r3 = 10
            if (r2 == r3) goto L_0x0088
            r3 = 11
            if (r2 == r3) goto L_0x0028
            goto L_0x00b4
        L_0x0028:
            A3.a r0 = r0.f3605a
            java.util.List r0 = r0.f32d
            if (r0 != 0) goto L_0x002f
            goto L_0x0080
        L_0x002f:
            java.util.Iterator r0 = r0.iterator()
        L_0x0033:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0052
            java.lang.Object r2 = r0.next()
            r3 = r2
            A3.e r3 = (A3.e) r3
            java.lang.Integer r3 = r3.f60a
            int[] r4 = A3.i.f83c
            int r4 = S2.C1594h.s(r4)
            if (r3 != 0) goto L_0x004b
            goto L_0x0033
        L_0x004b:
            int r3 = r3.intValue()
            if (r3 != r4) goto L_0x0033
            goto L_0x0053
        L_0x0052:
            r2 = r1
        L_0x0053:
            A3.e r2 = (A3.e) r2
            if (r2 != 0) goto L_0x0058
            goto L_0x0080
        L_0x0058:
            java.util.List r0 = r2.f66g
            if (r0 != 0) goto L_0x005d
            goto L_0x0080
        L_0x005d:
            java.util.Iterator r0 = r0.iterator()
        L_0x0061:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x007e
            java.lang.Object r2 = r0.next()
            r3 = r2
            A3.f r3 = (A3.f) r3
            java.lang.Integer r3 = r3.f68b
            z3.f r4 = r6.f24631a
            int r4 = r4.f4812a
            if (r3 != 0) goto L_0x0077
            goto L_0x0061
        L_0x0077:
            int r3 = r3.intValue()
            if (r3 != r4) goto L_0x0061
            r1 = r2
        L_0x007e:
            A3.f r1 = (A3.f) r1
        L_0x0080:
            if (r1 != 0) goto L_0x0083
            goto L_0x00b4
        L_0x0083:
            java.lang.Boolean r6 = r6.f24632b
            r1.f70d = r6
            return
        L_0x0088:
            A3.a r0 = r0.f3605a
            java.util.List r0 = r0.f32d
            if (r0 != 0) goto L_0x008f
            goto L_0x00b2
        L_0x008f:
            java.util.Iterator r0 = r0.iterator()
        L_0x0093:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x00b0
            java.lang.Object r2 = r0.next()
            r3 = r2
            A3.e r3 = (A3.e) r3
            java.lang.Integer r3 = r3.f60a
            z3.f r4 = r6.f24631a
            int r4 = r4.f4812a
            if (r3 != 0) goto L_0x00a9
            goto L_0x0093
        L_0x00a9:
            int r3 = r3.intValue()
            if (r3 != r4) goto L_0x0093
            r1 = r2
        L_0x00b0:
            A3.e r1 = (A3.e) r1
        L_0x00b2:
            if (r1 != 0) goto L_0x00b5
        L_0x00b4:
            return
        L_0x00b5:
            java.lang.Boolean r6 = r6.f24632b
            r1.f63d = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: n.l.d(e4.d):void");
    }

    public void f(d dVar) {
        m.e(dVar, "item");
    }

    public final e4.a j(List list) {
        Integer num;
        Integer num2;
        Integer num3;
        C2592c cVar = this.f24526j;
        Integer num4 = null;
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
        if (cVar != null) {
            num4 = cVar.f24063a;
        }
        return new e4.a(list, this, (String) null, (String) null, num, num2, num3, num4, (Typeface) null, this.f24528l, 268);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getActivity() != null) {
            ViewModelStore viewModelStore = getViewModelStore();
            m.d(viewModelStore, "viewModelStore");
            m mVar = (m) new ViewModelProvider(viewModelStore, (ViewModelProvider.Factory) new p()).get(m.class);
            this.f3604z = mVar;
            if (mVar == null) {
                m.u("viewModel");
                mVar = null;
            }
            mVar.b(i.f82b);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        m.e(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(c.dialog_mspa_options, viewGroup, false);
        m.d(inflate, "inflater.inflate(R.layou…ptions, container, false)");
        return inflate;
    }

    public void onViewCreated(View view, Bundle bundle) {
        ArrayList arrayList;
        Button button;
        boolean z4;
        View view2 = view;
        m.e(view2, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        super.onViewCreated(view, bundle);
        TextView textView = this.f24518b;
        if (textView != null) {
            textView.setText(getString(e.ccpa_privacy_title));
        }
        this.f3591m = (TextView) view2.findViewById(b.tv_purposes_label1);
        this.f3596r = (RecyclerView) view2.findViewById(b.rv_purposes_list);
        this.f3592n = (TextView) view2.findViewById(b.tv_sensitive_purposes);
        this.f3593o = (TextView) view2.findViewById(b.tv_child_sensitive_purposes);
        this.f3594p = (Button) view2.findViewById(b.btn_save_and_exit);
        this.f3595q = (Button) view2.findViewById(b.btn_agree_to_all);
        this.f3597s = (RecyclerView) view2.findViewById(b.rv_sensitive_purposes_list);
        this.f3598t = (RecyclerView) view2.findViewById(b.rv_child_sensitive_purposes_list);
        this.f3599u = (FrameLayout) view2.findViewById(b.gbc_fragment_container);
        this.f3600v = (ConstraintLayout) view2.findViewById(b.mspa_options_container);
        this.f3601w = view2.findViewById(b.purposes_divider);
        this.f3602x = view2.findViewById(b.sensitive_purposes_divider);
        this.f3603y = view2.findViewById(b.child_sensitive_purposes_divider);
        ImageView imageView = this.f24519c;
        if (imageView != null) {
            imageView.setOnClickListener(new g(this));
        }
        m mVar = this.f3604z;
        if (mVar == null) {
            m.u("viewModel");
            mVar = null;
        }
        List b5 = mVar.b(i.f82b);
        if (!((ArrayList) b5).isEmpty()) {
            RecyclerView recyclerView = this.f3596r;
            if (recyclerView != null) {
                recyclerView.setAdapter(j(b5));
            }
            TextView textView2 = this.f3591m;
            if (textView2 != null) {
                textView2.setVisibility(0);
            }
            RecyclerView recyclerView2 = this.f3596r;
            if (recyclerView2 != null) {
                recyclerView2.setVisibility(0);
            }
            View view3 = this.f3601w;
            if (view3 != null) {
                view3.setVisibility(0);
            }
        } else {
            TextView textView3 = this.f3591m;
            if (textView3 != null) {
                textView3.setVisibility(8);
            }
            RecyclerView recyclerView3 = this.f3596r;
            if (recyclerView3 != null) {
                recyclerView3.setVisibility(8);
            }
            View view4 = this.f3601w;
            if (view4 != null) {
                view4.setVisibility(8);
            }
        }
        m mVar2 = this.f3604z;
        if (mVar2 == null) {
            m.u("viewModel");
            mVar2 = null;
        }
        mVar2.getClass();
        ArrayList arrayList2 = new ArrayList();
        List list = mVar2.f3605a.f32d;
        if (list == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            for (Object next : list) {
                Integer num = ((A3.e) next).f60a;
                if (num == null) {
                    z4 = false;
                } else {
                    z4 = C1594h.n(i.f83c, num.intValue());
                }
                if (z4) {
                    arrayList.add(next);
                }
            }
        }
        if (arrayList != null) {
            int size = arrayList.size();
            int i4 = 0;
            while (i4 < size) {
                Object obj = arrayList.get(i4);
                i4++;
                List<f> list2 = ((A3.e) obj).f66g;
                if (list2 != null) {
                    for (f fVar : list2) {
                        Integer num2 = fVar.f68b;
                        if (num2 != null) {
                            int intValue = num2.intValue();
                            String str = fVar.f71e;
                            if (str == null) {
                                str = "";
                            }
                            arrayList2.add(new d(new z3.f(intValue, str), fVar.f70d, (e4.f) null, e4.e.MSPA_SENSITIVE_PURPOSE, false, (String) null, (Integer) null, 116));
                        }
                    }
                }
            }
        }
        if (!arrayList2.isEmpty()) {
            RecyclerView recyclerView4 = this.f3597s;
            if (recyclerView4 != null) {
                recyclerView4.setAdapter(j(arrayList2));
            }
            TextView textView4 = this.f3592n;
            if (textView4 != null) {
                textView4.setVisibility(0);
            }
            RecyclerView recyclerView5 = this.f3597s;
            if (recyclerView5 != null) {
                recyclerView5.setVisibility(0);
            }
            View view5 = this.f3602x;
            if (view5 != null) {
                view5.setVisibility(0);
            }
        } else {
            TextView textView5 = this.f3592n;
            if (textView5 != null) {
                textView5.setVisibility(8);
            }
            RecyclerView recyclerView6 = this.f3597s;
            if (recyclerView6 != null) {
                recyclerView6.setVisibility(8);
            }
            View view6 = this.f3602x;
            if (view6 != null) {
                view6.setVisibility(8);
            }
        }
        m mVar3 = this.f3604z;
        if (mVar3 == null) {
            m.u("viewModel");
            mVar3 = null;
        }
        List b6 = mVar3.b(i.f84d);
        if (!((ArrayList) b6).isEmpty()) {
            RecyclerView recyclerView7 = this.f3598t;
            if (recyclerView7 != null) {
                recyclerView7.setAdapter(j(b6));
            }
            TextView textView6 = this.f3593o;
            if (textView6 != null) {
                textView6.setVisibility(0);
            }
            RecyclerView recyclerView8 = this.f3598t;
            if (recyclerView8 != null) {
                recyclerView8.setVisibility(0);
            }
            View view7 = this.f3603y;
            if (view7 != null) {
                view7.setVisibility(0);
            }
        } else {
            TextView textView7 = this.f3593o;
            if (textView7 != null) {
                textView7.setVisibility(8);
            }
            RecyclerView recyclerView9 = this.f3598t;
            if (recyclerView9 != null) {
                recyclerView9.setVisibility(8);
            }
            View view8 = this.f3603y;
            if (view8 != null) {
                view8.setVisibility(8);
            }
        }
        if (c.i.f1158b) {
            getChildFragmentManager().beginTransaction().add(b.gbc_fragment_container, (Fragment) new g(), g.f1149h).addToBackStack((String) null).commit();
            FrameLayout frameLayout = this.f3599u;
            if (frameLayout != null) {
                frameLayout.setVisibility(0);
            }
        } else {
            FrameLayout frameLayout2 = this.f3599u;
            if (frameLayout2 != null) {
                frameLayout2.setVisibility(8);
            }
        }
        p();
        C2592c cVar = this.f24526j;
        if (cVar != null) {
            Integer num3 = cVar.f24069g;
            if (num3 != null) {
                int intValue2 = num3.intValue();
                ConstraintLayout constraintLayout = this.f3600v;
                if (constraintLayout != null) {
                    constraintLayout.setBackgroundColor(intValue2);
                }
            }
            Integer num4 = cVar.f24071i;
            if (num4 != null) {
                int intValue3 = num4.intValue();
                TextView textView8 = this.f3591m;
                if (textView8 != null) {
                    textView8.setTextColor(intValue3);
                }
                TextView textView9 = this.f3592n;
                if (textView9 != null) {
                    textView9.setTextColor(intValue3);
                }
                TextView textView10 = this.f3593o;
                if (textView10 != null) {
                    textView10.setTextColor(intValue3);
                }
            }
            Integer num5 = cVar.f24075m;
            if (num5 != null) {
                int intValue4 = num5.intValue();
                Button button2 = this.f3594p;
                if (button2 != null) {
                    button2.setTextColor(intValue4);
                }
            }
            Integer num6 = cVar.f24077o;
            if (num6 != null) {
                int intValue5 = num6.intValue();
                Button button3 = this.f3594p;
                if (button3 != null) {
                    button3.setBackgroundTintList(ColorStateList.valueOf(intValue5));
                }
            }
        }
        Typeface typeface = this.f24527k;
        if (typeface != null) {
            TextView textView11 = this.f3591m;
            if (textView11 != null) {
                textView11.setTypeface(typeface);
            }
            TextView textView12 = this.f3592n;
            if (textView12 != null) {
                textView12.setTypeface(typeface);
            }
            TextView textView13 = this.f3593o;
            if (textView13 != null) {
                textView13.setTypeface(typeface);
            }
        }
        Typeface typeface2 = this.f24528l;
        if (!(typeface2 == null || (button = this.f3594p) == null)) {
            button.setTypeface(typeface2);
        }
        m mVar4 = this.f3604z;
        if (mVar4 == null) {
            m.u("viewModel");
            mVar4 = null;
        }
        mVar4.getClass();
        C1001s0 unused = C0981i.d(ViewModelKt.getViewModelScope(mVar4), Y.b(), (L) null, new o(mVar4, (V2.d) null), 2, (Object) null);
    }

    public final void p() {
        Button button = this.f3594p;
        if (button != null) {
            button.setOnClickListener(new h(this));
        }
        Button button2 = this.f3595q;
        if (button2 != null) {
            button2.setOnClickListener(new i(this));
        }
    }
}
