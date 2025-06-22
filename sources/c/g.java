package c;

import A1.c;
import V3.C2592c;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.recyclerview.widget.RecyclerView;
import com.inmobi.cmp.ChoiceCmpCallback;
import com.inmobi.cmp.core.model.gbc.GoogleBasicConsents;
import com.inmobi.cmp.core.model.portalconfig.GBCConsentValue;
import com.inmobi.cmp.data.storage.SharedStorage;
import e4.a;
import e4.d;
import java.util.List;
import kotlin.jvm.internal.m;
import o3.C0988l0;
import o3.C1001s0;
import o3.L;
import o3.Y;

public final class g extends Fragment implements a.b {

    /* renamed from: g  reason: collision with root package name */
    public static final a f1148g = new a();

    /* renamed from: h  reason: collision with root package name */
    public static final String f1149h;

    /* renamed from: a  reason: collision with root package name */
    public TextView f1150a;

    /* renamed from: b  reason: collision with root package name */
    public RecyclerView f1151b;

    /* renamed from: c  reason: collision with root package name */
    public e f1152c;

    /* renamed from: d  reason: collision with root package name */
    public C2592c f1153d;

    /* renamed from: e  reason: collision with root package name */
    public Typeface f1154e;

    /* renamed from: f  reason: collision with root package name */
    public Typeface f1155f;

    public static final class a {
    }

    static {
        String simpleName = g.class.getSimpleName();
        m.d(simpleName, "GBCPurposesFragment::class.java.simpleName");
        f1149h = simpleName;
    }

    public void d(d dVar) {
        m.e(dVar, "item");
    }

    public void f(d dVar) {
        m.e(dVar, "item");
    }

    public final void g() {
        RecyclerView.Adapter adapter;
        e eVar = this.f1152c;
        if (eVar == null) {
            m.u("viewModel");
            eVar = null;
        }
        RecyclerView recyclerView = this.f1151b;
        if (recyclerView == null) {
            adapter = null;
        } else {
            adapter = recyclerView.getAdapter();
        }
        if (adapter != null) {
            List<d> list = ((e4.a) adapter).f24593a;
            eVar.getClass();
            m.e(list, "gbcList");
            for (d dVar : list) {
                if (m.a(dVar.f24632b, Boolean.TRUE)) {
                    i.f1157a.d(dVar.f24631a.f4812a, GBCConsentValue.GRANTED);
                } else {
                    i.f1157a.d(dVar.f24631a.f4812a, GBCConsentValue.DENIED);
                }
            }
            SharedStorage sharedStorage = eVar.f1144a;
            a4.a aVar = a4.a.GBC_CONSENT_STRING;
            sharedStorage.d(aVar, i.f1157a.a(sharedStorage.k(aVar), i.f1159c));
            ChoiceCmpCallback choiceCmpCallback = eVar.f1145b;
            if (choiceCmpCallback != null) {
                choiceCmpCallback.onGoogleBasicConsentChange(new GoogleBasicConsents(eVar.a(list, "adStorage"), eVar.a(list, "adUserData"), eVar.a(list, "adPersonalization"), eVar.a(list, "analyticsStorage")));
            }
            C1001s0 unused = C0981i.d(C0988l0.f3711a, Y.b(), (L) null, new C0501d((V2.d) null), 2, (Object) null);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.inmobi.cmp.presentation.components.switchlist.SwitchAdapter");
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getActivity() != null) {
            ViewModelStore viewModelStore = getViewModelStore();
            m.d(viewModelStore, "viewModelStore");
            this.f1152c = (e) new ViewModelProvider(viewModelStore, (ViewModelProvider.Factory) new f()).get(e.class);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        m.e(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(c.gbc_purpose_container, viewGroup, false);
        m.d(inflate, "inflater.inflate(R.layou…tainer, container, false)");
        return inflate;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00f3, code lost:
        if (r10.f155b == com.inmobi.cmp.core.model.portalconfig.GBCConsentValue.GRANTED) goto L_0x00f7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onViewCreated(android.view.View r24, android.os.Bundle r25) {
        /*
            r23 = this;
            r2 = r23
            r12 = r24
            java.lang.String r0 = "view"
            kotlin.jvm.internal.m.e(r12, r0)
            super.onViewCreated(r24, r25)
            int r0 = A1.b.tv_google_consents
            android.view.View r0 = r12.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r2.f1150a = r0
            int r0 = A1.b.rv_google_purposes_list
            android.view.View r0 = r12.findViewById(r0)
            androidx.recyclerview.widget.RecyclerView r0 = (androidx.recyclerview.widget.RecyclerView) r0
            r2.f1151b = r0
            V3.b r0 = b4.d.f24469e
            r1 = 0
            if (r0 != 0) goto L_0x0027
            r3 = r1
            goto L_0x0029
        L_0x0027:
            android.graphics.Typeface r3 = r0.f24061a
        L_0x0029:
            r2.f1154e = r3
            if (r0 != 0) goto L_0x002f
            r0 = r1
            goto L_0x0031
        L_0x002f:
            android.graphics.Typeface r0 = r0.f24062b
        L_0x0031:
            r2.f1155f = r0
            V3.c r0 = b4.d.f24470f
            r2.f1153d = r0
            android.widget.TextView r0 = r2.f1150a
            java.lang.String r3 = "viewModel"
            if (r0 != 0) goto L_0x003e
            goto L_0x0060
        L_0x003e:
            c.e r4 = r2.f1152c
            if (r4 != 0) goto L_0x0046
            kotlin.jvm.internal.m.u(r3)
            r4 = r1
        L_0x0046:
            M2.c r4 = r4.f1146c
            M2.a r4 = r4.f7744b
            java.lang.String r4 = r4.f7738b
            int r5 = r4.length()
            if (r5 != 0) goto L_0x005d
            int r4 = A1.e.google_consents
            java.lang.String r4 = r2.getString(r4)
            java.lang.String r5 = "getString(R.string.google_consents)"
            kotlin.jvm.internal.m.d(r4, r5)
        L_0x005d:
            r0.setText(r4)
        L_0x0060:
            androidx.recyclerview.widget.RecyclerView r13 = r2.f1151b
            if (r13 != 0) goto L_0x0066
            goto L_0x0137
        L_0x0066:
            e4.a r0 = new e4.a
            c.e r4 = r2.f1152c
            if (r4 != 0) goto L_0x0070
            kotlin.jvm.internal.m.u(r3)
            r4 = r1
        L_0x0070:
            r4.getClass()
            r3 = r1
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            com.inmobi.cmp.data.storage.SharedStorage r5 = r4.f1144a
            a4.a r6 = a4.a.GBC_CONSENT_STRING
            com.inmobi.cmp.core.model.Vector r5 = r5.k(r6)
            M2.c r6 = r4.f1146c
            java.util.List r6 = r6.f7745c
            java.util.Iterator r6 = r6.iterator()
        L_0x0089:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x010f
            java.lang.Object r7 = r6.next()
            M2.b r7 = (M2.b) r7
            java.lang.Integer r8 = r7.f7741a
            if (r8 != 0) goto L_0x009a
            goto L_0x0089
        L_0x009a:
            int r8 = r8.intValue()
            C3.f r9 = r4.f1147d
            C3.a r9 = r9.f170b
            C3.c r9 = r9.f127S
            java.util.List r9 = r9.f158c
            java.util.Iterator r9 = r9.iterator()
        L_0x00aa:
            boolean r10 = r9.hasNext()
            if (r10 == 0) goto L_0x00bc
            java.lang.Object r10 = r9.next()
            r11 = r10
            C3.b r11 = (C3.b) r11
            int r11 = r11.f154a
            if (r11 != r8) goto L_0x00aa
            goto L_0x00bd
        L_0x00bc:
            r10 = r3
        L_0x00bd:
            C3.b r10 = (C3.b) r10
            if (r10 != 0) goto L_0x00c2
            goto L_0x0089
        L_0x00c2:
            e4.d r14 = new e4.d
            z3.f r15 = new z3.f
            M2.a r7 = r7.f7742b
            if (r7 != 0) goto L_0x00cc
            r7 = r3
            goto L_0x00ce
        L_0x00cc:
            java.lang.String r7 = r7.f7737a
        L_0x00ce:
            if (r7 != 0) goto L_0x00d2
            java.lang.String r7 = ""
        L_0x00d2:
            r15.<init>(r8, r7)
            r7 = 1
            if (r5 != 0) goto L_0x00d9
            goto L_0x00ef
        L_0x00d9:
            int r8 = r10.f154a
            boolean r8 = r5.contains(r8)
            if (r8 != r7) goto L_0x00ef
            int r7 = r10.f154a
            java.lang.Boolean r7 = r5.get(r7)
            if (r7 != 0) goto L_0x00ea
            goto L_0x00f6
        L_0x00ea:
            boolean r7 = r7.booleanValue()
            goto L_0x00f7
        L_0x00ef:
            com.inmobi.cmp.core.model.portalconfig.GBCConsentValue r8 = r10.f155b
            com.inmobi.cmp.core.model.portalconfig.GBCConsentValue r9 = com.inmobi.cmp.core.model.portalconfig.GBCConsentValue.GRANTED
            if (r8 != r9) goto L_0x00f6
            goto L_0x00f7
        L_0x00f6:
            r7 = 0
        L_0x00f7:
            java.lang.Boolean r16 = java.lang.Boolean.valueOf(r7)
            e4.e r18 = e4.e.GOOGLE_BASIC_CONSENT_PURPOSE
            r21 = 0
            r22 = 116(0x74, float:1.63E-43)
            r17 = 0
            r19 = 0
            r20 = 0
            r14.<init>(r15, r16, r17, r18, r19, r20, r21, r22)
            r1.add(r14)
            goto L_0x0089
        L_0x010f:
            V3.c r4 = r2.f1153d
            if (r4 != 0) goto L_0x0115
            r5 = r3
            goto L_0x0117
        L_0x0115:
            java.lang.Integer r5 = r4.f24071i
        L_0x0117:
            if (r4 != 0) goto L_0x011b
            r6 = r3
            goto L_0x011d
        L_0x011b:
            java.lang.Integer r6 = r4.f24067e
        L_0x011d:
            if (r4 != 0) goto L_0x0121
            r7 = r3
            goto L_0x0123
        L_0x0121:
            java.lang.Integer r7 = r4.f24068f
        L_0x0123:
            if (r4 != 0) goto L_0x0127
        L_0x0125:
            r8 = r3
            goto L_0x012a
        L_0x0127:
            java.lang.Integer r3 = r4.f24063a
            goto L_0x0125
        L_0x012a:
            android.graphics.Typeface r10 = r2.f1155f
            r9 = 0
            r11 = 268(0x10c, float:3.76E-43)
            r3 = 0
            r4 = 0
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r13.setAdapter(r0)
        L_0x0137:
            V3.c r0 = r2.f1153d
            if (r0 != 0) goto L_0x013c
            goto L_0x0159
        L_0x013c:
            java.lang.Integer r1 = r0.f24069g
            if (r1 != 0) goto L_0x0141
            goto L_0x0148
        L_0x0141:
            int r1 = r1.intValue()
            r12.setBackgroundColor(r1)
        L_0x0148:
            java.lang.Integer r0 = r0.f24071i
            if (r0 != 0) goto L_0x014d
            goto L_0x0159
        L_0x014d:
            int r0 = r0.intValue()
            android.widget.TextView r1 = r2.f1150a
            if (r1 != 0) goto L_0x0156
            goto L_0x0159
        L_0x0156:
            r1.setTextColor(r0)
        L_0x0159:
            V3.c r0 = r2.f1153d
            if (r0 != 0) goto L_0x015e
            goto L_0x0177
        L_0x015e:
            java.lang.Integer r0 = r0.f24063a
            if (r0 != 0) goto L_0x0163
            goto L_0x0177
        L_0x0163:
            int r0 = r0.intValue()
            int r1 = A1.b.gbc_purpose_divider
            android.view.View r1 = r12.findViewById(r1)
            if (r1 != 0) goto L_0x0170
            goto L_0x0177
        L_0x0170:
            android.content.res.ColorStateList r0 = android.content.res.ColorStateList.valueOf(r0)
            r1.setBackgroundTintList(r0)
        L_0x0177:
            android.graphics.Typeface r0 = r2.f1154e
            if (r0 != 0) goto L_0x017c
            goto L_0x0180
        L_0x017c:
            android.widget.TextView r1 = r2.f1150a
            if (r1 != 0) goto L_0x0181
        L_0x0180:
            return
        L_0x0181:
            r1.setTypeface(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: c.g.onViewCreated(android.view.View, android.os.Bundle):void");
    }
}
