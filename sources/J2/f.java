package J2;

import A1.b;
import A1.c;
import B2.i;
import E2.p;
import E2.q;
import E2.r;
import E2.s;
import S2.C1601o;
import T3.C2578f;
import T3.C2585m;
import T3.C2586n;
import U3.C2589b;
import V3.C2591b;
import V3.C2592c;
import android.app.Dialog;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import b4.d;
import com.inmobi.cmp.core.model.Vector;
import com.mbridge.msdk.MBridgeConstans;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import k.C0925a;
import kotlin.jvm.internal.m;
import o3.C1001s0;
import o3.L;
import o3.Y;
import z3.e;
import z3.l;

public final class f extends C0925a {

    /* renamed from: l  reason: collision with root package name */
    public static final a f7242l = new a();

    /* renamed from: m  reason: collision with root package name */
    public static String f7243m;

    /* renamed from: a  reason: collision with root package name */
    public ConstraintLayout f7244a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f7245b;

    /* renamed from: c  reason: collision with root package name */
    public Button f7246c;

    /* renamed from: d  reason: collision with root package name */
    public Button f7247d;

    /* renamed from: e  reason: collision with root package name */
    public Button f7248e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f7249f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f7250g;

    /* renamed from: h  reason: collision with root package name */
    public l f7251h;

    /* renamed from: i  reason: collision with root package name */
    public Typeface f7252i;

    /* renamed from: j  reason: collision with root package name */
    public Typeface f7253j;

    /* renamed from: k  reason: collision with root package name */
    public C2592c f7254k;

    public static final class a {
    }

    static {
        String simpleName = f.class.getSimpleName();
        m.d(simpleName, "PrivacyBottomSheet::class.java.simpleName");
        f7243m = simpleName;
    }

    public static final void k(f fVar, View view) {
        m.e(fVar, "this$0");
        l lVar = fVar.f7251h;
        if (lVar == null) {
            m.u("viewModel");
            lVar = null;
        }
        s sVar = lVar.f7267a;
        sVar.f6416z.forEach(new r(sVar));
        sVar.f6386C.forEach(new p(sVar));
        Vector vector = sVar.f6385B;
        vector.unset(vector.getKeys());
        sVar.f6384A.unsetAllOwnedItems();
        sVar.f6407q.unsetAllOwnedItems();
        sVar.f6408r.unsetAllOwnedItems();
        sVar.f6409s.setAllOwnedItems();
        sVar.f6386C.forEach(new q(sVar));
        lVar.a();
        lVar.f7276j.b();
        C2585m.f24018a.b(C2586n.REJECT_ALL, C2578f.GDPR).observe(fVar, new e(fVar));
    }

    public static final void l(f fVar, String str) {
        m.e(fVar, "this$0");
        fVar.g();
        FragmentActivity activity = fVar.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    public static final void n(f fVar, View view) {
        FragmentManager supportFragmentManager;
        FragmentTransaction beginTransaction;
        FragmentTransaction add;
        m.e(fVar, "this$0");
        FragmentActivity activity = fVar.getActivity();
        if (activity != null && (supportFragmentManager = activity.getSupportFragmentManager()) != null && (beginTransaction = supportFragmentManager.beginTransaction()) != null && (add = beginTransaction.add((Fragment) new i(), i.f6184F)) != null) {
            add.commit();
        }
    }

    public static final void o(f fVar, String str) {
        m.e(fVar, "this$0");
        fVar.g();
        FragmentActivity activity = fVar.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    public static final void p(f fVar, View view) {
        m.e(fVar, "this$0");
        l lVar = fVar.f7251h;
        if (lVar == null) {
            m.u("viewModel");
            lVar = null;
        }
        lVar.f7267a.x();
        lVar.a();
        lVar.f7276j.a();
        C2585m.f24018a.b(C2586n.ACCEPT_ALL, C2578f.GDPR).observe(fVar, new d(fVar));
    }

    public void h(ViewStub viewStub) {
        m.e(viewStub, "viewStub");
        viewStub.setLayoutResource(c.gdpr_privacy_bottom_sheet);
        View inflate = viewStub.inflate();
        m.d(inflate, "inflatedView");
        this.f7244a = (ConstraintLayout) inflate.findViewById(b.privacy_container);
        this.f7245b = (ImageView) inflate.findViewById(b.iv_cmp_logo);
        this.f7246c = (Button) inflate.findViewById(b.btn_more_options);
        this.f7247d = (Button) inflate.findViewById(b.btn_disagree);
        this.f7248e = (Button) inflate.findViewById(b.btn_agree);
        this.f7249f = (TextView) inflate.findViewById(b.tv_message);
        this.f7250g = (TextView) inflate.findViewById(b.tv_title);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0064  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.text.SpannableString j(java.lang.String r6, android.text.SpannableString r7, java.lang.String r8, android.text.style.ClickableSpan r9, boolean r10) {
        /*
            r5 = this;
            r0 = 2
            r1 = 0
            java.lang.String r2 = "subString"
            kotlin.jvm.internal.m.e(r8, r2)
            r2 = 0
            if (r6 != 0) goto L_0x000b
            goto L_0x0024
        L_0x000b:
            m3.j r3 = new m3.j
            m3.l r4 = m3.l.IGNORE_CASE
            r3.<init>(r8, r4)
            l3.e r6 = m3.j.d(r3, r6, r1, r0, r2)
            java.util.Iterator r3 = r6.iterator()
            boolean r3 = r3.hasNext()
            if (r3 == 0) goto L_0x0021
            goto L_0x0022
        L_0x0021:
            r6 = r2
        L_0x0022:
            if (r6 != 0) goto L_0x0026
        L_0x0024:
            r6 = r2
            goto L_0x0058
        L_0x0026:
            if (r10 == 0) goto L_0x002f
            java.lang.Object r6 = l3.h.l(r6)
        L_0x002c:
            m3.h r6 = (m3.h) r6
            goto L_0x0034
        L_0x002f:
            java.lang.Object r6 = l3.h.j(r6)
            goto L_0x002c
        L_0x0034:
            j3.d r6 = r6.b()
            int r10 = r6.c()
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            int r6 = r6.c()
            int r8 = r8.length()
            int r8 = r8 + r6
            java.lang.Integer r6 = java.lang.Integer.valueOf(r8)
            java.lang.Integer[] r8 = new java.lang.Integer[r0]
            r8[r1] = r10
            r10 = 1
            r8[r10] = r6
            java.util.List r6 = S2.C1601o.k(r8)
        L_0x0058:
            if (r6 != 0) goto L_0x005e
            java.util.List r6 = S2.C1601o.h()
        L_0x005e:
            boolean r8 = r6.isEmpty()
            if (r8 != 0) goto L_0x00b4
            java.lang.Object r8 = S2.C1601o.H(r6)
            java.lang.Number r8 = (java.lang.Number) r8
            int r8 = r8.intValue()
            java.lang.Object r10 = S2.C1601o.P(r6)
            java.lang.Number r10 = (java.lang.Number) r10
            int r10 = r10.intValue()
            r0 = 33
            r7.setSpan(r9, r8, r10, r0)
            android.content.Context r8 = r5.getContext()
            if (r8 != 0) goto L_0x0084
            goto L_0x00b4
        L_0x0084:
            android.text.style.ForegroundColorSpan r9 = new android.text.style.ForegroundColorSpan
            V3.c r10 = r5.f7254k
            if (r10 != 0) goto L_0x008b
            goto L_0x008d
        L_0x008b:
            java.lang.Integer r2 = r10.f24074l
        L_0x008d:
            if (r2 != 0) goto L_0x0096
            int r10 = A1.a.colorBlueAccent
            int r8 = androidx.core.content.ContextCompat.getColor(r8, r10)
            goto L_0x009a
        L_0x0096:
            int r8 = r2.intValue()
        L_0x009a:
            r9.<init>(r8)
            java.lang.Object r8 = S2.C1601o.H(r6)
            java.lang.Number r8 = (java.lang.Number) r8
            int r8 = r8.intValue()
            java.lang.Object r6 = S2.C1601o.P(r6)
            java.lang.Number r6 = (java.lang.Number) r6
            int r6 = r6.intValue()
            r7.setSpan(r9, r8, r6, r0)
        L_0x00b4:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: J2.f.j(java.lang.String, android.text.SpannableString, java.lang.String, android.text.style.ClickableSpan, boolean):android.text.SpannableString");
    }

    public final void m() {
        int i4;
        Button button = this.f7248e;
        l lVar = null;
        if (button != null) {
            l lVar2 = this.f7251h;
            if (lVar2 == null) {
                m.u("viewModel");
                lVar2 = null;
            }
            button.setText(lVar2.f7274h.f24138d);
            button.setOnClickListener(new a(this));
        }
        Button button2 = this.f7247d;
        if (button2 != null) {
            l lVar3 = this.f7251h;
            if (lVar3 == null) {
                m.u("viewModel");
                lVar3 = null;
            }
            button2.setText(lVar3.f7274h.f24139e);
            l lVar4 = this.f7251h;
            if (lVar4 == null) {
                m.u("viewModel");
                lVar4 = null;
            }
            if (lVar4.f7273g) {
                i4 = 0;
            } else {
                i4 = 8;
            }
            button2.setVisibility(i4);
            button2.setOnClickListener(new b(this));
        }
        Button button3 = this.f7246c;
        if (button3 != null) {
            l lVar5 = this.f7251h;
            if (lVar5 == null) {
                m.u("viewModel");
            } else {
                lVar = lVar5;
            }
            button3.setText(C2589b.a(lVar.f7274h.f24137c));
            button3.setOnClickListener(new c(this));
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            ViewModelStore viewModelStore = activity.getViewModelStore();
            m.d(viewModelStore, "it.viewModelStore");
            this.f7251h = (l) new ViewModelProvider(viewModelStore, (ViewModelProvider.Factory) new m()).get(l.class);
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        int i4;
        TextView textView;
        Map map;
        m.e(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        super.onViewCreated(view, bundle);
        Dialog dialog = getDialog();
        int i5 = 0;
        if (dialog != null) {
            dialog.setCanceledOnTouchOutside(false);
        }
        i(false);
        Dialog dialog2 = getDialog();
        if (dialog2 != null) {
            dialog2.setCancelable(false);
        }
        C2591b bVar = d.f24469e;
        if (bVar != null) {
            this.f7252i = bVar.f24061a;
            this.f7253j = bVar.f24062b;
        }
        this.f7254k = d.f24470f;
        TextView textView2 = this.f7250g;
        if (textView2 != null) {
            l lVar = this.f7251h;
            if (lVar == null) {
                m.u("viewModel");
                lVar = null;
            }
            textView2.setText(lVar.f7274h.f24135a);
        }
        l lVar2 = this.f7251h;
        if (lVar2 == null) {
            m.u("viewModel");
            lVar2 = null;
        }
        e eVar = lVar2.f7267a.f6391a;
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
        List list = lVar2.f7268b.f171c.f166a;
        ArrayList arrayList = new ArrayList();
        for (Object next : list) {
            Set d02 = C1601o.d0(((C3.d) next).f164f);
            List list2 = lVar2.f7268b.f170b.f135h;
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
        int size = lVar2.f7269c.f6348a.size() + arrayList.size() + i4;
        if (lVar2.f7270d != null) {
            i5 = 1;
        }
        String valueOf = String.valueOf(size + i5);
        l lVar3 = this.f7251h;
        if (lVar3 == null) {
            m.u("viewModel");
            lVar3 = null;
        }
        String str = lVar3.f7274h.f24136b;
        if (c.i.f1158b) {
            str = m.m(str, lVar3.f7275i.f7744b.f7739c);
        }
        String u4 = m3.m.u(str, "${partners}", valueOf, true);
        SpannableString spannableString = new SpannableString(u4);
        l lVar4 = this.f7251h;
        if (lVar4 == null) {
            m.u("viewModel");
            lVar4 = null;
        }
        j(u4, spannableString, lVar4.f7274h.f24140f, new i(this), false);
        l lVar5 = this.f7251h;
        if (lVar5 == null) {
            m.u("viewModel");
            lVar5 = null;
        }
        j(u4, spannableString, lVar5.f7274h.f24142h, new j(this), true);
        TextView textView3 = this.f7249f;
        if (textView3 != null) {
            textView3.setText(spannableString);
        }
        TextView textView4 = this.f7249f;
        if (textView4 != null) {
            textView4.setMovementMethod(LinkMovementMethod.getInstance());
        }
        m();
        C2592c cVar = this.f7254k;
        if (cVar != null) {
            Integer num = cVar.f24069g;
            if (num != null) {
                int intValue = num.intValue();
                ConstraintLayout constraintLayout = this.f7244a;
                if (constraintLayout != null) {
                    constraintLayout.setBackgroundColor(intValue);
                }
            }
            Integer num2 = cVar.f24070h;
            if (num2 != null) {
                int intValue2 = num2.intValue();
                TextView textView5 = this.f7250g;
                if (textView5 != null) {
                    textView5.setTextColor(intValue2);
                }
            }
            Integer num3 = cVar.f24071i;
            if (num3 != null) {
                int intValue3 = num3.intValue();
                TextView textView6 = this.f7249f;
                if (textView6 != null) {
                    textView6.setTextColor(intValue3);
                }
            }
            Integer num4 = cVar.f24075m;
            if (num4 != null) {
                int intValue4 = num4.intValue();
                Button button = this.f7248e;
                if (button != null) {
                    button.setTextColor(intValue4);
                }
                Button button2 = this.f7247d;
                if (button2 != null) {
                    button2.setTextColor(intValue4);
                }
            }
            Integer num5 = cVar.f24077o;
            if (num5 != null) {
                int intValue5 = num5.intValue();
                Button button3 = this.f7248e;
                if (button3 != null) {
                    button3.setBackgroundColor(intValue5);
                }
                Button button4 = this.f7247d;
                if (button4 != null) {
                    button4.setBackgroundColor(intValue5);
                }
            }
            Integer num6 = cVar.f24074l;
            if (num6 != null) {
                int intValue6 = num6.intValue();
                Button button5 = this.f7246c;
                if (button5 != null) {
                    button5.setTextColor(intValue6);
                }
            }
        }
        Typeface typeface = this.f7252i;
        if (typeface != null) {
            TextView textView7 = this.f7250g;
            if (textView7 != null) {
                textView7.setTypeface(typeface);
            }
            Button button6 = this.f7248e;
            if (button6 != null) {
                button6.setTypeface(typeface);
            }
            Button button7 = this.f7247d;
            if (button7 != null) {
                button7.setTypeface(typeface);
            }
            Button button8 = this.f7246c;
            if (button8 != null) {
                button8.setTypeface(typeface);
            }
        }
        Typeface typeface2 = this.f7253j;
        if (!(typeface2 == null || (textView = this.f7249f) == null)) {
            textView.setTypeface(typeface2);
        }
        l lVar6 = this.f7251h;
        if (lVar6 == null) {
            m.u("viewModel");
            lVar6 = null;
        }
        h hVar = new h(this);
        lVar6.getClass();
        m.e(hVar, "result");
        C1001s0 unused = C0981i.d(ViewModelKt.getViewModelScope(lVar6), Y.b(), (L) null, new k(hVar, lVar6, (V2.d) null), 2, (Object) null);
    }
}
