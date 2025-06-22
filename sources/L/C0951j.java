package l;

import A1.b;
import A1.c;
import A1.e;
import B2.k;
import C3.d;
import H2.j;
import T3.C2585m;
import T3.C2586n;
import V3.C2592c;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.mbridge.msdk.MBridgeConstans;
import e4.a;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.m;
import o3.C1001s0;
import o3.L;
import o3.Y;
import z3.f;
import z3.l;

/* renamed from: l.j  reason: case insensitive filesystem */
public final class C0951j extends d4.a implements a.b {

    /* renamed from: t  reason: collision with root package name */
    public static final a f3536t = new a();

    /* renamed from: u  reason: collision with root package name */
    public static final String f3537u = C0951j.class.getName();

    /* renamed from: m  reason: collision with root package name */
    public ConstraintLayout f3538m;

    /* renamed from: n  reason: collision with root package name */
    public Button f3539n;

    /* renamed from: o  reason: collision with root package name */
    public Button f3540o;

    /* renamed from: p  reason: collision with root package name */
    public RecyclerView f3541p;

    /* renamed from: q  reason: collision with root package name */
    public C0954m f3542q;

    /* renamed from: r  reason: collision with root package name */
    public k f3543r;

    /* renamed from: s  reason: collision with root package name */
    public e4.a f3544s;

    /* renamed from: l.j$a */
    public static final class a {
    }

    public static final void j(PopupWindow popupWindow, C0951j jVar, View view) {
        m.e(popupWindow, "$mypopupWindow");
        m.e(jVar, "this$0");
        popupWindow.dismiss();
        TextView textView = jVar.f24518b;
        if (textView != null) {
            textView.setText(jVar.getString(e.leg_interest_all_partners_toolbar_title));
        }
        C0954m mVar = jVar.f3542q;
        if (mVar == null) {
            m.u("viewModel");
            mVar = null;
        }
        mVar.e(j.ALL_VENDORS);
        jVar.u();
    }

    public static final void l(C0951j jVar, View view) {
        m.e(jVar, "this$0");
        jVar.dismiss();
    }

    public static final void m(C0951j jVar, PopupWindow popupWindow, ImageView imageView, CardView cardView, TextView textView, TextView textView2, TextView textView3, View view) {
        Integer num;
        Integer num2;
        m.e(jVar, "this$0");
        m.e(popupWindow, "$mypopupWindow");
        C2592c cVar = jVar.f24526j;
        if (!(cVar == null || (num2 = cVar.f24069g) == null)) {
            cardView.setBackgroundTintList(ColorStateList.valueOf(num2.intValue()));
        }
        C2592c cVar2 = jVar.f24526j;
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
        }
        popupWindow.showAsDropDown(imageView);
    }

    public static final void n(PopupWindow popupWindow, C0951j jVar, View view) {
        m.e(popupWindow, "$mypopupWindow");
        m.e(jVar, "this$0");
        popupWindow.dismiss();
        TextView textView = jVar.f24518b;
        if (textView != null) {
            textView.setText(jVar.getString(e.leg_interest_iab_partners_toolbar_title));
        }
        C0954m mVar = jVar.f3542q;
        if (mVar == null) {
            m.u("viewModel");
            mVar = null;
        }
        mVar.e(j.IAB_VENDORS);
        jVar.u();
    }

    public static final void o(C0951j jVar, View view) {
        f fVar;
        Map map;
        m.e(jVar, "this$0");
        C0954m mVar = jVar.f3542q;
        if (mVar == null) {
            m.u("viewModel");
            mVar = null;
        }
        z3.e eVar = mVar.f3548a.f6391a;
        if (!(eVar == null || (map = eVar.f4808i) == null)) {
            for (Map.Entry entry : map.entrySet()) {
                if (!((l) entry.getValue()).f4820e.isEmpty()) {
                    mVar.f3548a.f6386C.unset(((l) entry.getValue()).f4812a);
                }
            }
        }
        for (d dVar : mVar.f3550c.f166a) {
            if (!dVar.f165g.isEmpty()) {
                mVar.f3548a.f6387D.unset(dVar.f159a);
            }
        }
        Map i4 = mVar.i();
        if (i4 != null) {
            for (Map.Entry key : i4.entrySet()) {
                mVar.f3548a.f6409s.unset(Integer.parseInt((String) key.getKey()));
            }
        }
        e4.d h4 = mVar.h();
        if (!(h4 == null || (fVar = h4.f24631a) == null)) {
            mVar.f3548a.f6411u.unset(fVar.f4812a);
        }
        C2585m mVar2 = C2585m.f24018a;
        C2586n nVar = C2586n.OBJECT_ALL_LEGITIMATE;
        m.e(nVar, "navigationTag");
        b4.d.f24465a.n().getClass();
        C2585m.f24020c.e(String.valueOf(nVar), "_legitimatePurposesConsents");
        jVar.t();
    }

    public static final void p(PopupWindow popupWindow, C0951j jVar, View view) {
        m.e(popupWindow, "$mypopupWindow");
        m.e(jVar, "this$0");
        popupWindow.dismiss();
        TextView textView = jVar.f24518b;
        if (textView != null) {
            textView.setText(jVar.getString(e.leg_interest_non_iab_partners_toolbar_title));
        }
        C0954m mVar = jVar.f3542q;
        if (mVar == null) {
            m.u("viewModel");
            mVar = null;
        }
        mVar.e(j.NON_IAB_VENDORS);
        jVar.u();
    }

    public static final void q(C0951j jVar, View view) {
        f fVar;
        Map map;
        m.e(jVar, "this$0");
        C0954m mVar = jVar.f3542q;
        if (mVar == null) {
            m.u("viewModel");
            mVar = null;
        }
        z3.e eVar = mVar.f3548a.f6391a;
        if (!(eVar == null || (map = eVar.f4808i) == null)) {
            for (Map.Entry entry : map.entrySet()) {
                if (!((l) entry.getValue()).f4820e.isEmpty()) {
                    mVar.f3548a.f6386C.set(((l) entry.getValue()).f4812a);
                }
            }
        }
        for (d dVar : mVar.f3550c.f166a) {
            if (!dVar.f165g.isEmpty()) {
                mVar.f3548a.f6387D.set(dVar.f159a);
            }
        }
        Map i4 = mVar.i();
        if (i4 != null) {
            for (Map.Entry key : i4.entrySet()) {
                mVar.f3548a.f6409s.set(Integer.parseInt((String) key.getKey()));
            }
        }
        e4.d h4 = mVar.h();
        if (!(h4 == null || (fVar = h4.f24631a) == null)) {
            mVar.f3548a.f6411u.set(fVar.f4812a);
        }
        C2585m mVar2 = C2585m.f24018a;
        C2586n nVar = C2586n.ACCEPT_ALL_LEGITIMATE;
        m.e(nVar, "navigationTag");
        b4.d.f24465a.n().getClass();
        C2585m.f24020c.e(String.valueOf(nVar), "_legitimatePurposesConsents");
        jVar.t();
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x01da  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x01de  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void d(e4.d r9) {
        /*
            r8 = this;
            java.lang.String r0 = "item"
            kotlin.jvm.internal.m.e(r9, r0)
            l.m r1 = r8.f3542q
            r2 = 0
            java.lang.String r3 = "viewModel"
            if (r1 != 0) goto L_0x0010
            kotlin.jvm.internal.m.u(r3)
            r1 = r2
        L_0x0010:
            r1.getClass()
            kotlin.jvm.internal.m.e(r9, r0)
            e4.e r0 = r9.f24634d
            e4.e r4 = e4.e.NON_IAB_VENDOR
            java.lang.String r5 = "Non IAB"
            r6 = 95
            if (r0 != r4) goto L_0x004d
            java.lang.Boolean r0 = r9.f24632b
            java.lang.Boolean r7 = java.lang.Boolean.TRUE
            boolean r0 = kotlin.jvm.internal.m.a(r0, r7)
            if (r0 == 0) goto L_0x004d
            E2.s r0 = r1.f3548a
            com.inmobi.cmp.core.model.Vector r0 = r0.f6387D
            z3.f r1 = r9.f24631a
            int r1 = r1.f4812a
            r0.set((int) r1)
            T3.m r0 = T3.C2585m.f24018a
            java.lang.StringBuilder r1 = l.C0942a.a(r5, r6)
            z3.f r4 = r9.f24631a
            int r4 = r4.f4812a
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            java.lang.Boolean r9 = r9.f24632b
            l.C0943b.a(r9, r7, r0, r1)
            goto L_0x01d6
        L_0x004d:
            e4.e r0 = r9.f24634d
            if (r0 != r4) goto L_0x0080
            java.lang.Boolean r0 = r9.f24632b
            java.lang.Boolean r4 = java.lang.Boolean.FALSE
            boolean r0 = kotlin.jvm.internal.m.a(r0, r4)
            if (r0 == 0) goto L_0x0080
            E2.s r0 = r1.f3548a
            com.inmobi.cmp.core.model.Vector r0 = r0.f6387D
            z3.f r1 = r9.f24631a
            int r1 = r1.f4812a
            r0.unset((int) r1)
            T3.m r0 = T3.C2585m.f24018a
            java.lang.StringBuilder r1 = l.C0942a.a(r5, r6)
            z3.f r4 = r9.f24631a
            int r4 = r4.f4812a
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            java.lang.Boolean r9 = r9.f24632b
            java.lang.Boolean r4 = java.lang.Boolean.TRUE
            l.C0943b.a(r9, r4, r0, r1)
            goto L_0x01d6
        L_0x0080:
            e4.e r0 = r9.f24634d
            e4.e r4 = e4.e.IAB_VENDOR
            java.lang.String r5 = "Legitimate Vendors"
            if (r0 != r4) goto L_0x00b5
            java.lang.Boolean r0 = r9.f24632b
            java.lang.Boolean r7 = java.lang.Boolean.TRUE
            boolean r0 = kotlin.jvm.internal.m.a(r0, r7)
            if (r0 == 0) goto L_0x00b5
            E2.s r0 = r1.f3548a
            com.inmobi.cmp.core.model.Vector r0 = r0.f6386C
            z3.f r1 = r9.f24631a
            int r1 = r1.f4812a
            r0.set((int) r1)
            T3.m r0 = T3.C2585m.f24018a
            java.lang.StringBuilder r1 = l.C0942a.a(r5, r6)
            z3.f r4 = r9.f24631a
            int r4 = r4.f4812a
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            java.lang.Boolean r9 = r9.f24632b
            l.C0943b.a(r9, r7, r0, r1)
            goto L_0x01d6
        L_0x00b5:
            e4.e r0 = r9.f24634d
            if (r0 != r4) goto L_0x00e8
            java.lang.Boolean r0 = r9.f24632b
            java.lang.Boolean r4 = java.lang.Boolean.FALSE
            boolean r0 = kotlin.jvm.internal.m.a(r0, r4)
            if (r0 == 0) goto L_0x00e8
            E2.s r0 = r1.f3548a
            com.inmobi.cmp.core.model.Vector r0 = r0.f6386C
            z3.f r1 = r9.f24631a
            int r1 = r1.f4812a
            r0.unset((int) r1)
            T3.m r0 = T3.C2585m.f24018a
            java.lang.StringBuilder r1 = l.C0942a.a(r5, r6)
            z3.f r4 = r9.f24631a
            int r4 = r4.f4812a
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            java.lang.Boolean r9 = r9.f24632b
            java.lang.Boolean r4 = java.lang.Boolean.TRUE
            l.C0943b.a(r9, r4, r0, r1)
            goto L_0x01d6
        L_0x00e8:
            e4.e r0 = r9.f24634d
            e4.e r4 = e4.e.PUBLISHER_VENDOR
            java.lang.String r5 = "Vendors"
            if (r0 != r4) goto L_0x012e
            java.lang.Boolean r0 = r9.f24632b
            java.lang.Boolean r7 = java.lang.Boolean.TRUE
            boolean r0 = kotlin.jvm.internal.m.a(r0, r7)
            if (r0 == 0) goto L_0x012e
            E2.s r0 = r1.f3548a
            com.inmobi.cmp.core.model.Vector r0 = r0.f6411u
            z3.f r4 = r9.f24631a
            int r4 = r4.f4812a
            r0.set((int) r4)
            E2.s r0 = r1.f3548a
            com.inmobi.cmp.core.model.Vector r0 = r0.f6412v
            z3.f r1 = r9.f24631a
            z3.l r1 = (z3.l) r1
            java.util.Set r1 = r1.f4820e
            java.util.Set r1 = S2.C1601o.d0(r1)
            r0.setItems(r1)
            T3.m r0 = T3.C2585m.f24018a
            java.lang.StringBuilder r1 = l.C0942a.a(r5, r6)
            z3.f r4 = r9.f24631a
            int r4 = r4.f4812a
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            java.lang.Boolean r9 = r9.f24632b
            l.C0943b.a(r9, r7, r0, r1)
            goto L_0x01d6
        L_0x012e:
            e4.e r0 = r9.f24634d
            if (r0 != r4) goto L_0x0171
            java.lang.Boolean r0 = r9.f24632b
            java.lang.Boolean r4 = java.lang.Boolean.FALSE
            boolean r0 = kotlin.jvm.internal.m.a(r0, r4)
            if (r0 == 0) goto L_0x0171
            E2.s r0 = r1.f3548a
            com.inmobi.cmp.core.model.Vector r0 = r0.f6411u
            z3.f r4 = r9.f24631a
            int r4 = r4.f4812a
            r0.unset((int) r4)
            E2.s r0 = r1.f3548a
            com.inmobi.cmp.core.model.Vector r0 = r0.f6412v
            z3.f r1 = r9.f24631a
            z3.l r1 = (z3.l) r1
            java.util.Set r1 = r1.f4820e
            java.util.Set r1 = S2.C1601o.d0(r1)
            r0.unset((java.util.Set<java.lang.Integer>) r1)
            T3.m r0 = T3.C2585m.f24018a
            java.lang.StringBuilder r1 = l.C0942a.a(r5, r6)
            z3.f r4 = r9.f24631a
            int r4 = r4.f4812a
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            java.lang.Boolean r9 = r9.f24632b
            java.lang.Boolean r4 = java.lang.Boolean.TRUE
            l.C0943b.a(r9, r4, r0, r1)
            goto L_0x01d6
        L_0x0171:
            e4.e r0 = r9.f24634d
            e4.e r4 = e4.e.PURPOSE
            java.lang.String r5 = "Legitimate Purposes"
            if (r0 != r4) goto L_0x01a5
            java.lang.Boolean r0 = r9.f24632b
            java.lang.Boolean r7 = java.lang.Boolean.TRUE
            boolean r0 = kotlin.jvm.internal.m.a(r0, r7)
            if (r0 == 0) goto L_0x01a5
            E2.s r0 = r1.f3548a
            com.inmobi.cmp.core.model.Vector r0 = r0.f6409s
            z3.f r1 = r9.f24631a
            int r1 = r1.f4812a
            r0.set((int) r1)
            T3.m r0 = T3.C2585m.f24018a
            java.lang.StringBuilder r1 = l.C0942a.a(r5, r6)
            z3.f r4 = r9.f24631a
            int r4 = r4.f4812a
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            java.lang.Boolean r9 = r9.f24632b
            l.C0943b.a(r9, r7, r0, r1)
            goto L_0x01d6
        L_0x01a5:
            e4.e r0 = r9.f24634d
            if (r0 != r4) goto L_0x01d6
            java.lang.Boolean r0 = r9.f24632b
            java.lang.Boolean r4 = java.lang.Boolean.FALSE
            boolean r0 = kotlin.jvm.internal.m.a(r0, r4)
            if (r0 == 0) goto L_0x01d6
            E2.s r0 = r1.f3548a
            com.inmobi.cmp.core.model.Vector r0 = r0.f6409s
            z3.f r1 = r9.f24631a
            int r1 = r1.f4812a
            r0.unset((int) r1)
            T3.m r0 = T3.C2585m.f24018a
            java.lang.StringBuilder r1 = l.C0942a.a(r5, r6)
            z3.f r4 = r9.f24631a
            int r4 = r4.f4812a
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            java.lang.Boolean r9 = r9.f24632b
            java.lang.Boolean r4 = java.lang.Boolean.TRUE
            l.C0943b.a(r9, r4, r0, r1)
        L_0x01d6:
            l.m r9 = r8.f3542q
            if (r9 != 0) goto L_0x01de
            kotlin.jvm.internal.m.u(r3)
            goto L_0x01df
        L_0x01de:
            r2 = r9
        L_0x01df:
            java.util.Set r9 = r2.d()
            r8.k(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: l.C0951j.d(e4.d):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:48:0x014c  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x014f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void f(e4.d r28) {
        /*
            r27 = this;
            r0 = r27
            r1 = r28
            java.lang.String r2 = "item"
            kotlin.jvm.internal.m.e(r1, r2)
            androidx.fragment.app.FragmentActivity r2 = r0.getActivity()
            if (r2 != 0) goto L_0x0011
            goto L_0x0209
        L_0x0011:
            z3.f r3 = r1.f24631a
            boolean r4 = r3 instanceof z3.l
            java.lang.String r5 = "viewModel"
            if (r4 == 0) goto L_0x019c
            androidx.fragment.app.FragmentManager r3 = r2.getSupportFragmentManager()
            java.lang.String r4 = F2.f.f6491I
            androidx.fragment.app.Fragment r3 = r3.findFragmentByTag(r4)
            if (r3 != 0) goto L_0x0209
            z3.f r3 = r1.f24631a
            boolean r7 = r3 instanceof z3.l
            if (r7 == 0) goto L_0x0185
            F2.a r8 = new F2.a
            java.lang.String r9 = r3.f4813b
            z3.l r3 = (z3.l) r3
            java.lang.String r10 = r3.f4818c
            l.m r3 = r0.f3542q
            if (r3 != 0) goto L_0x003b
            kotlin.jvm.internal.m.u(r5)
            r3 = 0
        L_0x003b:
            z3.f r7 = r1.f24631a
            z3.l r7 = (z3.l) r7
            java.util.Set r7 = r7.f4820e
            H2.a r11 = H2.a.PURPOSE
            java.lang.String r12 = r3.a(r7, r11)
            l.m r3 = r0.f3542q
            if (r3 != 0) goto L_0x004f
            kotlin.jvm.internal.m.u(r5)
            r3 = 0
        L_0x004f:
            z3.f r7 = r1.f24631a
            z3.l r7 = (z3.l) r7
            java.util.Set r7 = r7.f4822g
            H2.a r11 = H2.a.SPECIAL_PURPOSE
            java.lang.String r13 = r3.a(r7, r11)
            l.m r3 = r0.f3542q
            if (r3 != 0) goto L_0x0063
            kotlin.jvm.internal.m.u(r5)
            r3 = 0
        L_0x0063:
            z3.f r7 = r1.f24631a
            z3.l r7 = (z3.l) r7
            java.util.Set r7 = r7.f4823h
            H2.a r11 = H2.a.FEATURE
            java.lang.String r14 = r3.a(r7, r11)
            l.m r3 = r0.f3542q
            if (r3 != 0) goto L_0x0077
            kotlin.jvm.internal.m.u(r5)
            r3 = 0
        L_0x0077:
            z3.f r7 = r1.f24631a
            z3.l r7 = (z3.l) r7
            java.util.Set r7 = r7.f4824i
            H2.a r11 = H2.a.SPECIAL_FEATURE
            java.lang.String r15 = r3.a(r7, r11)
            l.m r3 = r0.f3542q
            if (r3 != 0) goto L_0x008b
            kotlin.jvm.internal.m.u(r5)
            r3 = 0
        L_0x008b:
            z3.f r7 = r1.f24631a
            z3.l r7 = (z3.l) r7
            java.util.Set r7 = r7.f4829n
            H2.a r11 = H2.a.DATA_DECLARATION
            java.lang.String r16 = r3.a(r7, r11)
            z3.f r3 = r1.f24631a
            z3.l r3 = (z3.l) r3
            java.lang.String r3 = r3.f4825j
            l.m r7 = r0.f3542q
            if (r7 != 0) goto L_0x00a5
            kotlin.jvm.internal.m.u(r5)
            r7 = 0
        L_0x00a5:
            z3.f r11 = r1.f24631a
            z3.l r11 = (z3.l) r11
            int r11 = r11.f4827l
            r7.getClass()
            java.lang.String r17 = ""
            if (r11 >= 0) goto L_0x00b7
            r26 = r2
            r2 = r17
            goto L_0x0100
        L_0x00b7:
            float r6 = (float) r11
            r19 = 1202241536(0x47a8c000, float:86400.0)
            float r6 = r6 / r19
            r19 = 1065353216(0x3f800000, float:1.0)
            r26 = r2
            r2 = 32
            int r19 = (r6 > r19 ? 1 : (r6 == r19 ? 0 : -1))
            if (r19 < 0) goto L_0x00e6
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            int r6 = f3.a.a(r6)
            r11.append(r6)
            r11.append(r2)
            X3.w r2 = r7.f3551d
            V3.k r2 = r2.g()
            java.lang.String r2 = r2.f24193i
            r11.append(r2)
            java.lang.String r2 = r11.toString()
            goto L_0x0100
        L_0x00e6:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r11)
            r6.append(r2)
            X3.w r2 = r7.f3551d
            V3.k r2 = r2.g()
            java.lang.String r2 = r2.f24194j
            r6.append(r2)
            java.lang.String r2 = r6.toString()
        L_0x0100:
            l.m r6 = r0.f3542q
            if (r6 != 0) goto L_0x0108
            kotlin.jvm.internal.m.u(r5)
            r6 = 0
        L_0x0108:
            z3.f r5 = r1.f24631a
            z3.l r5 = (z3.l) r5
            java.lang.Boolean r5 = r5.f4828m
            r6.getClass()
            java.lang.Boolean r7 = java.lang.Boolean.TRUE
            boolean r7 = kotlin.jvm.internal.m.a(r5, r7)
            if (r7 == 0) goto L_0x0124
            X3.w r5 = r6.f3551d
            V3.k r5 = r5.g()
            java.lang.String r5 = r5.f24197m
        L_0x0121:
            r19 = r5
            goto L_0x0137
        L_0x0124:
            java.lang.Boolean r7 = java.lang.Boolean.FALSE
            boolean r5 = kotlin.jvm.internal.m.a(r5, r7)
            if (r5 == 0) goto L_0x0135
            X3.w r5 = r6.f3551d
            V3.k r5 = r5.g()
            java.lang.String r5 = r5.f24198n
            goto L_0x0121
        L_0x0135:
            r19 = r17
        L_0x0137:
            z3.f r5 = r1.f24631a
            z3.l r5 = (z3.l) r5
            z3.c r5 = r5.f4830o
            if (r5 != 0) goto L_0x0140
            goto L_0x014c
        L_0x0140:
            int r5 = r5.f4797a
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.String r5 = r5.toString()
            if (r5 != 0) goto L_0x014f
        L_0x014c:
            r20 = r17
            goto L_0x0151
        L_0x014f:
            r20 = r5
        L_0x0151:
            z3.f r5 = r1.f24631a
            int r6 = r5.f4812a
            e4.e r1 = r1.f24634d
            z3.l r5 = (z3.l) r5
            java.lang.String r5 = r5.f4831p
            java.lang.String r24 = "Error: cannot load vendor file"
            r25 = 4
            r11 = 0
            r22 = r1
            r18 = r2
            r17 = r3
            r23 = r5
            r21 = r6
            r8.<init>(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25)
            java.lang.String r1 = "args"
            kotlin.jvm.internal.m.e(r8, r1)
            F2.f r6 = new F2.f
            r6.<init>()
            android.os.Bundle r1 = new android.os.Bundle
            r1.<init>()
            java.lang.String r2 = "partner_detail_args"
            r1.putParcelable(r2, r8)
            r6.setArguments(r1)
            goto L_0x0188
        L_0x0185:
            r26 = r2
            r6 = 0
        L_0x0188:
            if (r6 != 0) goto L_0x018c
            goto L_0x0209
        L_0x018c:
            androidx.fragment.app.FragmentManager r1 = r26.getSupportFragmentManager()
            androidx.fragment.app.FragmentTransaction r1 = r1.beginTransaction()
            androidx.fragment.app.FragmentTransaction r1 = r1.add((androidx.fragment.app.Fragment) r6, (java.lang.String) r4)
            r1.commit()
            return
        L_0x019c:
            r26 = r2
            boolean r2 = r3 instanceof z3.g
            if (r2 == 0) goto L_0x0209
            androidx.fragment.app.FragmentManager r2 = r26.getSupportFragmentManager()
            d4.i$a r6 = d4.i.f24554y
            java.lang.String r3 = d4.i.f24555z
            androidx.fragment.app.Fragment r2 = r2.findFragmentByTag(r3)
            if (r2 != 0) goto L_0x0209
            androidx.fragment.app.FragmentManager r2 = r26.getSupportFragmentManager()
            androidx.fragment.app.FragmentTransaction r2 = r2.beginTransaction()
            z3.f r4 = r1.f24631a
            java.lang.String r7 = r4.f4813b
            z3.g r4 = (z3.g) r4
            java.lang.String r8 = r4.a()
            z3.f r4 = r1.f24631a
            z3.g r4 = (z3.g) r4
            java.lang.String r9 = r4.b()
            B2.k r4 = r0.f3543r
            java.lang.String r10 = "optionsViewModel"
            if (r4 != 0) goto L_0x01d4
            kotlin.jvm.internal.m.u(r10)
            r4 = 0
        L_0x01d4:
            X3.w r4 = r4.f6210f
            V3.j r4 = r4.f()
            java.lang.String r4 = r4.f24177i
            B2.k r11 = r0.f3543r
            if (r11 != 0) goto L_0x01e4
            kotlin.jvm.internal.m.u(r10)
            r11 = 0
        L_0x01e4:
            X3.w r10 = r11.f6210f
            V3.j r10 = r10.f()
            java.lang.String r11 = r10.f24182n
            z3.f r10 = r1.f24631a
            int r12 = r10.f4812a
            e4.e r13 = r1.f24634d
            l.m r1 = r0.f3542q
            if (r1 != 0) goto L_0x01fa
            kotlin.jvm.internal.m.u(r5)
            r1 = 0
        L_0x01fa:
            H2.j r15 = r1.f3557j
            r14 = 1
            r10 = r4
            d4.i r1 = r6.b(r7, r8, r9, r10, r11, r12, r13, r14, r15)
            androidx.fragment.app.FragmentTransaction r1 = r2.add((androidx.fragment.app.Fragment) r1, (java.lang.String) r3)
            r1.commit()
        L_0x0209:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: l.C0951j.f(e4.d):void");
    }

    public final void k(Set set) {
        boolean z4;
        Button button = this.f3540o;
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
        Button button2 = this.f3539n;
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

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            ViewModelStore viewModelStore = getViewModelStore();
            m.d(viewModelStore, "viewModelStore");
            this.f3542q = (C0954m) new ViewModelProvider(viewModelStore, (ViewModelProvider.Factory) new C0955n()).get(C0954m.class);
            ViewModelStore viewModelStore2 = activity.getViewModelStore();
            m.d(viewModelStore2, "it.viewModelStore");
            this.f3543r = (k) new ViewModelProvider(viewModelStore2, (ViewModelProvider.Factory) new B2.l()).get(k.class);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        m.e(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(c.dialog_leg_interest, viewGroup, false);
        m.d(inflate, "inflater.inflate(R.layou…terest, container, false)");
        return inflate;
    }

    public void onPause() {
        boolean z4;
        super.onPause();
        C0954m mVar = this.f3542q;
        if (mVar == null) {
            m.u("viewModel");
            mVar = null;
        }
        SearchView searchView = this.f24521e;
        if (searchView == null) {
            z4 = false;
        } else {
            z4 = searchView.hasFocus();
        }
        mVar.f3558k = z4;
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
        this.f3538m = (ConstraintLayout) view.findViewById(b.leg_interest_container);
        this.f3539n = (Button) view.findViewById(b.btn_remove_objections);
        this.f3540o = (Button) view.findViewById(b.btn_object_to_all);
        this.f3541p = (RecyclerView) view.findViewById(b.rv_vendors_leg_interest_list);
        C0954m mVar = this.f3542q;
        C0954m mVar2 = null;
        if (mVar == null) {
            m.u("viewModel");
            mVar = null;
        }
        mVar.getClass();
        C1001s0 unused = C0981i.d(ViewModelKt.getViewModelScope(mVar), Y.b(), (L) null, new C0953l(mVar, (V2.d) null), 2, (Object) null);
        TextView textView = this.f24518b;
        if (textView != null) {
            C0954m mVar3 = this.f3542q;
            if (mVar3 == null) {
                m.u("viewModel");
                mVar3 = null;
            }
            textView.setText(mVar3.f3551d.e().f24143a);
        }
        ImageView imageView = this.f24519c;
        if (imageView != null) {
            imageView.setOnClickListener(new C0944c(this));
            C0954m mVar4 = this.f3542q;
            if (mVar4 == null) {
                m.u("viewModel");
                mVar4 = null;
            }
            imageView.setContentDescription(mVar4.f3551d.e().f24153k);
        }
        w();
        SearchView searchView2 = this.f24521e;
        if (searchView2 != null) {
            searchView2.setVisibility(0);
        }
        SearchView searchView3 = this.f24521e;
        if (searchView3 != null) {
            C0954m mVar5 = this.f3542q;
            if (mVar5 == null) {
                m.u("viewModel");
                mVar5 = null;
            }
            searchView3.setQueryHint(mVar5.f3551d.e().f24148f);
        }
        SearchView searchView4 = this.f24521e;
        if (searchView4 != null) {
            searchView4.setOnQueryTextListener(new C0952k(this));
        }
        C0954m mVar6 = this.f3542q;
        if (mVar6 == null) {
            m.u("viewModel");
            mVar6 = null;
        }
        List c5 = C0954m.c(mVar6, (String) null, 1);
        C0954m mVar7 = this.f3542q;
        if (mVar7 == null) {
            m.u("viewModel");
            mVar7 = null;
        }
        String str = mVar7.f3551d.e().f24144b;
        C0954m mVar8 = this.f3542q;
        if (mVar8 == null) {
            m.u("viewModel");
            mVar8 = null;
        }
        String str2 = mVar8.f3551d.e().f24145c;
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
        this.f3544s = new e4.a(c5, this, str, str2, num, num2, num3, num4, this.f24527k, this.f24528l);
        RecyclerView recyclerView = this.f3541p;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
            e4.a aVar = this.f3544s;
            if (aVar == null) {
                m.u("switchAdapter");
                aVar = null;
            }
            recyclerView.setAdapter(aVar);
        }
        v();
        C2592c cVar2 = this.f24526j;
        if (!(cVar2 == null || (num5 = cVar2.f24069g) == null)) {
            int intValue = num5.intValue();
            ConstraintLayout constraintLayout = this.f3538m;
            if (constraintLayout != null) {
                constraintLayout.setBackgroundColor(intValue);
            }
        }
        Button button = this.f3540o;
        if (button != null) {
            ColorStateList s4 = s();
            if (s4 != null) {
                button.setTextColor(s4);
            }
            ColorStateList r4 = r();
            if (r4 != null) {
                button.setBackgroundTintList(r4);
            }
        }
        Button button2 = this.f3539n;
        if (button2 != null) {
            ColorStateList s5 = s();
            if (s5 != null) {
                button2.setTextColor(s5);
            }
            ColorStateList r5 = r();
            if (r5 != null) {
                button2.setBackgroundTintList(r5);
            }
        }
        Typeface typeface = this.f24528l;
        if (typeface != null) {
            Button button3 = this.f3540o;
            if (button3 != null) {
                button3.setTypeface(typeface);
            }
            Button button4 = this.f3539n;
            if (button4 != null) {
                button4.setTypeface(typeface);
            }
        }
        C0954m mVar9 = this.f3542q;
        if (mVar9 == null) {
            m.u("viewModel");
        } else {
            mVar2 = mVar9;
        }
        if (mVar2.f3558k && (searchView = this.f24521e) != null) {
            searchView.requestFocus();
        }
    }

    public final ColorStateList r() {
        Integer num;
        C2592c cVar = this.f24526j;
        if (cVar == null || (num = cVar.f24077o) == null || cVar.f24078p == null) {
            return null;
        }
        return new ColorStateList(new int[][]{new int[]{16842910}, new int[]{-16842910}}, new int[]{num.intValue(), cVar.f24078p.intValue()});
    }

    public final ColorStateList s() {
        Integer num;
        C2592c cVar = this.f24526j;
        if (cVar == null || (num = cVar.f24075m) == null || cVar.f24076n == null) {
            return null;
        }
        return new ColorStateList(new int[][]{new int[]{16842910}, new int[]{-16842910}}, new int[]{num.intValue(), cVar.f24076n.intValue()});
    }

    public final void t() {
        e4.a aVar = this.f3544s;
        C0954m mVar = null;
        if (aVar == null) {
            m.u("switchAdapter");
            aVar = null;
        }
        C0954m mVar2 = this.f3542q;
        if (mVar2 == null) {
            m.u("viewModel");
            mVar2 = null;
        }
        aVar.b(C0954m.c(mVar2, (String) null, 1), false);
        SearchView searchView = this.f24521e;
        if (searchView != null) {
            searchView.setQuery("", false);
        }
        C0954m mVar3 = this.f3542q;
        if (mVar3 == null) {
            m.u("viewModel");
        } else {
            mVar = mVar3;
        }
        k(mVar.d());
    }

    public final void u() {
        CharSequence query;
        boolean z4;
        SearchView searchView = this.f24521e;
        if (searchView != null && (query = searchView.getQuery()) != null) {
            e4.a aVar = this.f3544s;
            C0954m mVar = null;
            if (aVar == null) {
                m.u("switchAdapter");
                aVar = null;
            }
            C0954m mVar2 = this.f3542q;
            if (mVar2 == null) {
                m.u("viewModel");
            } else {
                mVar = mVar2;
            }
            List b5 = mVar.b(query.toString());
            if (query.length() > 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            aVar.b(b5, z4);
        }
    }

    public final void v() {
        Button button = this.f3540o;
        C0954m mVar = null;
        if (button != null) {
            C0954m mVar2 = this.f3542q;
            if (mVar2 == null) {
                m.u("viewModel");
                mVar2 = null;
            }
            button.setText(mVar2.f3551d.e().f24147e);
        }
        C0954m mVar3 = this.f3542q;
        if (mVar3 == null) {
            m.u("viewModel");
            mVar3 = null;
        }
        k(mVar3.d());
        Button button2 = this.f3540o;
        if (button2 != null) {
            button2.setOnClickListener(new C0945d(this));
        }
        Button button3 = this.f3539n;
        if (button3 != null) {
            C0954m mVar4 = this.f3542q;
            if (mVar4 == null) {
                m.u("viewModel");
            } else {
                mVar = mVar4;
            }
            button3.setText(mVar.f3551d.e().f24146d);
        }
        Button button4 = this.f3539n;
        if (button4 != null) {
            button4.setOnClickListener(new C0946e(this));
        }
    }

    public final void w() {
        ImageView imageView;
        C0954m mVar = this.f3542q;
        if (mVar == null) {
            m.u("viewModel");
            mVar = null;
        }
        if (!mVar.f3550c.f166a.isEmpty()) {
            Toolbar toolbar = this.f24517a;
            if (toolbar == null) {
                imageView = null;
            } else {
                imageView = (ImageView) toolbar.findViewById(b.toolbar_menu);
            }
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            View inflate = LayoutInflater.from(getContext()).inflate(c.list_leg_interest_menu, (ViewGroup) null);
            CardView cardView = (CardView) inflate.findViewById(b.cv_menu_item);
            TextView textView = (TextView) inflate.findViewById(b.tv_menu_all);
            TextView textView2 = (TextView) inflate.findViewById(b.tv_menu_iab);
            TextView textView3 = (TextView) inflate.findViewById(b.tv_menu_non_iab);
            PopupWindow popupWindow = new PopupWindow(inflate, 600, -2, true);
            popupWindow.setElevation(10.0f);
            textView.setOnClickListener(new C0947f(popupWindow, this));
            textView2.setOnClickListener(new C0948g(popupWindow, this));
            textView3.setOnClickListener(new C0949h(popupWindow, this));
            if (imageView != null) {
                imageView.setOnClickListener(new C0950i(this, popupWindow, imageView, cardView, textView, textView2, textView3));
            }
        }
    }
}
