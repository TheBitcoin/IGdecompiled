package F2;

import A1.b;
import A1.c;
import S2.C1601o;
import T3.C2574b;
import T3.C2585m;
import V3.C2592c;
import V3.C2593d;
import V3.C2595f;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import com.mbridge.msdk.MBridgeConstans;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.F;
import kotlin.jvm.internal.m;
import z3.e;
import z3.i;

public final class f extends d4.a {

    /* renamed from: H  reason: collision with root package name */
    public static final a f6490H = new a();

    /* renamed from: I  reason: collision with root package name */
    public static final String f6491I;

    /* renamed from: A  reason: collision with root package name */
    public TextView f6492A;

    /* renamed from: B  reason: collision with root package name */
    public TextView f6493B;

    /* renamed from: C  reason: collision with root package name */
    public TextView f6494C;

    /* renamed from: D  reason: collision with root package name */
    public TextView f6495D;

    /* renamed from: E  reason: collision with root package name */
    public ImageView f6496E;

    /* renamed from: F  reason: collision with root package name */
    public a f6497F;

    /* renamed from: G  reason: collision with root package name */
    public g f6498G;

    /* renamed from: m  reason: collision with root package name */
    public TextView f6499m;

    /* renamed from: n  reason: collision with root package name */
    public TextView f6500n;

    /* renamed from: o  reason: collision with root package name */
    public TextView f6501o;

    /* renamed from: p  reason: collision with root package name */
    public TextView f6502p;

    /* renamed from: q  reason: collision with root package name */
    public TextView f6503q;

    /* renamed from: r  reason: collision with root package name */
    public TextView f6504r;

    /* renamed from: s  reason: collision with root package name */
    public TextView f6505s;

    /* renamed from: t  reason: collision with root package name */
    public TextView f6506t;

    /* renamed from: u  reason: collision with root package name */
    public TextView f6507u;

    /* renamed from: v  reason: collision with root package name */
    public TextView f6508v;

    /* renamed from: w  reason: collision with root package name */
    public TextView f6509w;

    /* renamed from: x  reason: collision with root package name */
    public TextView f6510x;

    /* renamed from: y  reason: collision with root package name */
    public TextView f6511y;

    /* renamed from: z  reason: collision with root package name */
    public TextView f6512z;

    public static final class a {
    }

    static {
        String simpleName = f.class.getSimpleName();
        m.d(simpleName, "PartnersDetailFragment::class.java.simpleName");
        f6491I = simpleName;
    }

    public static final void j(f fVar, C2593d dVar) {
        g gVar;
        Iterator it;
        Map map;
        i iVar;
        f fVar2 = fVar;
        C2593d dVar2 = dVar;
        m.e(fVar2, "this$0");
        g gVar2 = fVar2.f6498G;
        if (gVar2 == null) {
            m.u("viewModel");
            gVar2 = null;
        }
        m.d(dVar2, "it");
        gVar2.getClass();
        m.e(dVar2, "cookieDisclosure");
        gVar2.f6516d.clear();
        Iterator it2 = dVar2.f24079a.iterator();
        while (it2.hasNext()) {
            C2595f fVar3 = (C2595f) it2.next();
            List list = gVar2.f6516d;
            String str = fVar3.f24130a;
            String str2 = fVar3.f24131b;
            String valueOf = String.valueOf(fVar3.f24132c);
            String str3 = fVar3.f24133d;
            List list2 = fVar3.f24134e;
            String str4 = "";
            int i4 = 0;
            for (Object next : list2) {
                int i5 = i4 + 1;
                if (i4 < 0) {
                    C1601o.o();
                }
                int intValue = ((Number) next).intValue();
                e eVar = gVar2.f6513a.f6391a;
                if (eVar == null || (map = eVar.f4803d) == null || (iVar = (i) map.get(String.valueOf(intValue))) == null) {
                    it = it2;
                } else {
                    F f4 = F.f20971a;
                    it = it2;
                    String format = String.format("• %s.", Arrays.copyOf(new Object[]{iVar.f4813b}, 1));
                    m.d(format, "format(format, *args)");
                    String m4 = m.m(str4, format);
                    if (i4 != list2.size() - 1) {
                        m4 = m.m(m4, "\n");
                    }
                    str4 = m4;
                }
                it2 = it;
                i4 = i5;
            }
            Iterator it3 = it2;
            list.add(new d4.e(str, str2, valueOf, str3, str4));
        }
        g gVar3 = fVar2.f6498G;
        if (gVar3 == null) {
            m.u("viewModel");
            gVar3 = null;
        }
        if (!gVar3.f6516d.isEmpty()) {
            FragmentActivity activity = fVar2.getActivity();
            if (activity != null) {
                FragmentManager supportFragmentManager = activity.getSupportFragmentManager();
                String str5 = D2.e.f6292p;
                if (supportFragmentManager.findFragmentByTag(str5) == null) {
                    FragmentTransaction beginTransaction = activity.getSupportFragmentManager().beginTransaction();
                    g gVar4 = fVar2.f6498G;
                    if (gVar4 == null) {
                        m.u("viewModel");
                        gVar = null;
                    } else {
                        gVar = gVar4;
                    }
                    D2.a aVar = new D2.a(gVar.f6516d);
                    m.e(aVar, "args");
                    D2.e eVar2 = new D2.e();
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("partner_disclosure_args", aVar);
                    eVar2.setArguments(bundle);
                    beginTransaction.add((Fragment) eVar2, str5).commit();
                    return;
                }
                return;
            }
            return;
        }
        fVar2.q();
    }

    public static final void k(f fVar, View view) {
        m.e(fVar, "this$0");
        C2585m mVar = C2585m.f24018a;
        StringBuilder sb = new StringBuilder();
        g gVar = fVar.f6498G;
        a aVar = null;
        if (gVar == null) {
            m.u("viewModel");
            gVar = null;
        }
        a aVar2 = fVar.f6497F;
        if (aVar2 == null) {
            m.u("args");
            aVar2 = null;
        }
        sb.append(C2574b.a(gVar.a(aVar2.f6482n)));
        sb.append("-id:");
        a aVar3 = fVar.f6497F;
        if (aVar3 == null) {
            m.u("args");
        } else {
            aVar = aVar3;
        }
        sb.append(aVar.f6481m);
        mVar.f("collapseElement", sb.toString());
        fVar.dismiss();
    }

    public static final void l(f fVar, String str, View view) {
        m.e(fVar, "this$0");
        m.e(str, "$link");
        Context context = fVar.getContext();
        if (context != null) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            context.startActivity(intent);
        }
    }

    public static final void p(f fVar, View view) {
        m.e(fVar, "this$0");
        a aVar = fVar.f6497F;
        a aVar2 = null;
        if (aVar == null) {
            m.u("args");
            aVar = null;
        }
        if (aVar.f6483o.length() > 0) {
            g gVar = fVar.f6498G;
            if (gVar == null) {
                m.u("viewModel");
                gVar = null;
            }
            a aVar3 = fVar.f6497F;
            if (aVar3 == null) {
                m.u("args");
            } else {
                aVar2 = aVar3;
            }
            String str = aVar2.f6483o;
            gVar.getClass();
            m.e(str, "url");
            gVar.f6514b.a(str).observe(fVar, new e(fVar));
            return;
        }
        fVar.q();
    }

    public final void m(View view) {
        this.f6496E = (ImageView) view.findViewById(b.toolbar_icon);
        this.f6495D = (TextView) view.findViewById(b.tv_disclosures);
        this.f6494C = (TextView) view.findViewById(b.tv_description);
        this.f6493B = (TextView) view.findViewById(b.tv_purposes);
        this.f6492A = (TextView) view.findViewById(b.tv_legitimate_interests);
        this.f6512z = (TextView) view.findViewById(b.tv_special_purposes);
        this.f6511y = (TextView) view.findViewById(b.tv_features);
        this.f6510x = (TextView) view.findViewById(b.tv_special_features);
        this.f6509w = (TextView) view.findViewById(b.tv_purposes_label);
        this.f6508v = (TextView) view.findViewById(b.tv_legitimate_interests_label);
        this.f6507u = (TextView) view.findViewById(b.tv_special_purposes_label);
        this.f6506t = (TextView) view.findViewById(b.tv_features_label);
        this.f6505s = (TextView) view.findViewById(b.tv_special_features_label);
        this.f6504r = (TextView) view.findViewById(b.tv_cookie_max_age);
        this.f6502p = (TextView) view.findViewById(b.tv_uses_non_cookie_access);
        this.f6503q = (TextView) view.findViewById(b.tv_data_retention);
        this.f6501o = (TextView) view.findViewById(b.tv_data_declarations);
        this.f6500n = (TextView) view.findViewById(b.tv_data_declarations_label);
        this.f6499m = (TextView) view.findViewById(b.tv_privacy_policy_link);
        ImageView imageView = this.f6496E;
        if (imageView != null) {
            imageView.setOnClickListener(new c(this));
            g gVar = this.f6498G;
            if (gVar == null) {
                m.u("viewModel");
                gVar = null;
            }
            imageView.setContentDescription(gVar.f6515c.g().f24199o);
        }
        TextView textView = this.f6495D;
        if (textView != null) {
            textView.setOnClickListener(new d(this));
        }
        C2592c cVar = this.f24526j;
        if (cVar != null) {
            Integer num = cVar.f24069g;
            if (num != null) {
                view.setBackgroundColor(num.intValue());
            }
            Integer num2 = cVar.f24071i;
            if (num2 != null) {
                int intValue = num2.intValue();
                TextView textView2 = this.f6494C;
                if (textView2 != null) {
                    textView2.setTextColor(intValue);
                }
                TextView textView3 = this.f6493B;
                if (textView3 != null) {
                    textView3.setTextColor(intValue);
                }
                TextView textView4 = this.f6492A;
                if (textView4 != null) {
                    textView4.setTextColor(intValue);
                }
                TextView textView5 = this.f6512z;
                if (textView5 != null) {
                    textView5.setTextColor(intValue);
                }
                TextView textView6 = this.f6511y;
                if (textView6 != null) {
                    textView6.setTextColor(intValue);
                }
                TextView textView7 = this.f6510x;
                if (textView7 != null) {
                    textView7.setTextColor(intValue);
                }
                TextView textView8 = this.f6509w;
                if (textView8 != null) {
                    textView8.setTextColor(intValue);
                }
                TextView textView9 = this.f6508v;
                if (textView9 != null) {
                    textView9.setTextColor(intValue);
                }
                TextView textView10 = this.f6507u;
                if (textView10 != null) {
                    textView10.setTextColor(intValue);
                }
                TextView textView11 = this.f6506t;
                if (textView11 != null) {
                    textView11.setTextColor(intValue);
                }
                TextView textView12 = this.f6505s;
                if (textView12 != null) {
                    textView12.setTextColor(intValue);
                }
                TextView textView13 = this.f6504r;
                if (textView13 != null) {
                    textView13.setTextColor(intValue);
                }
                TextView textView14 = this.f6502p;
                if (textView14 != null) {
                    textView14.setTextColor(intValue);
                }
                TextView textView15 = this.f6503q;
                if (textView15 != null) {
                    textView15.setTextColor(intValue);
                }
                TextView textView16 = this.f6501o;
                if (textView16 != null) {
                    textView16.setTextColor(intValue);
                }
                TextView textView17 = this.f6500n;
                if (textView17 != null) {
                    textView17.setTextColor(intValue);
                }
            }
            Integer num3 = cVar.f24074l;
            if (num3 != null) {
                int intValue2 = num3.intValue();
                TextView textView18 = this.f6495D;
                if (textView18 != null) {
                    textView18.setTextColor(intValue2);
                }
                TextView textView19 = this.f6499m;
                if (textView19 != null) {
                    textView19.setTextColor(intValue2);
                }
            }
        }
        Typeface typeface = this.f24527k;
        if (typeface != null) {
            TextView textView20 = this.f6509w;
            if (textView20 != null) {
                textView20.setTypeface(typeface);
            }
            TextView textView21 = this.f6508v;
            if (textView21 != null) {
                textView21.setTypeface(typeface);
            }
            TextView textView22 = this.f6507u;
            if (textView22 != null) {
                textView22.setTypeface(typeface);
            }
            TextView textView23 = this.f6506t;
            if (textView23 != null) {
                textView23.setTypeface(typeface);
            }
            TextView textView24 = this.f6505s;
            if (textView24 != null) {
                textView24.setTypeface(typeface);
            }
            TextView textView25 = this.f6500n;
            if (textView25 != null) {
                textView25.setTypeface(typeface);
            }
        }
        Typeface typeface2 = this.f24528l;
        if (typeface2 != null) {
            TextView textView26 = this.f6494C;
            if (textView26 != null) {
                textView26.setTypeface(typeface2);
            }
            TextView textView27 = this.f6493B;
            if (textView27 != null) {
                textView27.setTypeface(typeface2);
            }
            TextView textView28 = this.f6492A;
            if (textView28 != null) {
                textView28.setTypeface(typeface2);
            }
            TextView textView29 = this.f6512z;
            if (textView29 != null) {
                textView29.setTypeface(typeface2);
            }
            TextView textView30 = this.f6511y;
            if (textView30 != null) {
                textView30.setTypeface(typeface2);
            }
            TextView textView31 = this.f6510x;
            if (textView31 != null) {
                textView31.setTypeface(typeface2);
            }
            TextView textView32 = this.f6495D;
            if (textView32 != null) {
                textView32.setTypeface(typeface2);
            }
            TextView textView33 = this.f6499m;
            if (textView33 != null) {
                textView33.setTypeface(typeface2);
            }
            TextView textView34 = this.f6504r;
            if (textView34 != null) {
                textView34.setTypeface(typeface2);
            }
            TextView textView35 = this.f6502p;
            if (textView35 != null) {
                textView35.setTypeface(typeface2);
            }
            TextView textView36 = this.f6503q;
            if (textView36 != null) {
                textView36.setTypeface(typeface2);
            }
            TextView textView37 = this.f6501o;
            if (textView37 != null) {
                textView37.setTypeface(typeface2);
            }
        }
    }

    public final void n(TextView textView, TextView textView2, String str, String str2) {
        if (str.length() > 0 && textView != null) {
            textView.setText(str);
        }
        if (str2.length() <= 0) {
            if (textView != null) {
                textView.setVisibility(8);
            }
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
        } else if (textView2 != null) {
            textView2.setText(str2);
        }
    }

    public final void o(String str, String str2) {
        TextView textView;
        if (str.length() > 0 && (textView = this.f6499m) != null) {
            textView.setText(str);
        }
        if (URLUtil.isValidUrl(str2)) {
            TextView textView2 = this.f6499m;
            if (textView2 != null) {
                textView2.setOnClickListener(new b(this, str2));
                return;
            }
            return;
        }
        TextView textView3 = this.f6499m;
        if (textView3 != null) {
            textView3.setVisibility(8);
        }
    }

    public void onCreate(Bundle bundle) {
        a aVar;
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments == null) {
            aVar = null;
        } else {
            aVar = (a) arguments.getParcelable("partner_detail_args");
        }
        if (aVar == null) {
            aVar = new a((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 0, (e4.e) null, (String) null, (String) null, 65535);
        }
        this.f6497F = aVar;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            ViewModelStore viewModelStore = activity.getViewModelStore();
            m.d(viewModelStore, "viewModelStore");
            this.f6498G = (g) new ViewModelProvider(viewModelStore, (ViewModelProvider.Factory) new h()).get(g.class);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        m.e(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(c.dialog_partners_detail, viewGroup, false);
        m.d(inflate, "inflater.inflate(R.layou…detail, container, false)");
        return inflate;
    }

    public void onViewCreated(View view, Bundle bundle) {
        String str;
        String str2;
        String str3;
        int i4 = 0;
        m.e(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        super.onViewCreated(view, bundle);
        C2585m mVar = C2585m.f24018a;
        StringBuilder sb = new StringBuilder();
        g gVar = this.f6498G;
        g gVar2 = null;
        if (gVar == null) {
            m.u("viewModel");
            gVar = null;
        }
        a aVar = this.f6497F;
        if (aVar == null) {
            m.u("args");
            aVar = null;
        }
        sb.append(C2574b.a(gVar.a(aVar.f6482n)));
        sb.append("-id:");
        a aVar2 = this.f6497F;
        if (aVar2 == null) {
            m.u("args");
            aVar2 = null;
        }
        sb.append(aVar2.f6481m);
        mVar.f("expandElement", sb.toString());
        m(view);
        a aVar3 = this.f6497F;
        if (aVar3 == null) {
            m.u("args");
            aVar3 = null;
        }
        TextView textView = this.f24518b;
        if (textView != null) {
            textView.setText(aVar3.f6469a);
        }
        String str4 = aVar3.f6470b;
        if (str4 != null && !m.a(str4, "null")) {
            TextView textView2 = this.f6494C;
            if (textView2 != null) {
                textView2.setText(str4);
            }
            TextView textView3 = this.f6494C;
            if (textView3 != null) {
                textView3.setVisibility(0);
            }
        }
        if (aVar3.f6478j.length() == 0) {
            TextView textView4 = this.f6504r;
            if (textView4 != null) {
                textView4.setVisibility(8);
            }
        } else {
            TextView textView5 = this.f6504r;
            if (textView5 != null) {
                textView5.setVisibility(0);
            }
            TextView textView6 = this.f6504r;
            if (textView6 != null) {
                Context context = getContext();
                if (context == null) {
                    str3 = null;
                } else {
                    int i5 = A1.e.subtitle_format;
                    g gVar3 = this.f6498G;
                    if (gVar3 == null) {
                        m.u("viewModel");
                        gVar3 = null;
                    }
                    str3 = context.getString(i5, new Object[]{gVar3.f6515c.g().f24192h, aVar3.f6478j});
                }
                textView6.setText(str3);
            }
        }
        if (aVar3.f6479k.length() == 0) {
            TextView textView7 = this.f6502p;
            if (textView7 != null) {
                textView7.setVisibility(8);
            }
        } else {
            TextView textView8 = this.f6502p;
            if (textView8 != null) {
                textView8.setVisibility(0);
            }
            TextView textView9 = this.f6502p;
            if (textView9 != null) {
                Context context2 = getContext();
                if (context2 == null) {
                    str2 = null;
                } else {
                    int i6 = A1.e.subtitle_format;
                    g gVar4 = this.f6498G;
                    if (gVar4 == null) {
                        m.u("viewModel");
                        gVar4 = null;
                    }
                    str2 = context2.getString(i6, new Object[]{gVar4.f6515c.g().f24196l, aVar3.f6479k});
                }
                textView9.setText(str2);
            }
        }
        if (aVar3.f6480l.length() == 0) {
            TextView textView10 = this.f6503q;
            if (textView10 != null) {
                textView10.setVisibility(8);
            }
        } else {
            TextView textView11 = this.f6503q;
            if (textView11 != null) {
                textView11.setVisibility(0);
            }
            TextView textView12 = this.f6503q;
            if (textView12 != null) {
                Context context3 = getContext();
                if (context3 == null) {
                    str = null;
                } else {
                    str = context3.getString(A1.e.data_retention, new Object[]{aVar3.f6480l});
                }
                textView12.setText(str);
            }
        }
        TextView textView13 = this.f6495D;
        if (textView13 != null) {
            g gVar5 = this.f6498G;
            if (gVar5 == null) {
                m.u("viewModel");
                gVar5 = null;
            }
            textView13.setText(gVar5.f6515c.g().f24195k);
        }
        TextView textView14 = this.f6495D;
        if (textView14 != null) {
            if (aVar3.f6483o.length() <= 0) {
                i4 = 8;
            }
            textView14.setVisibility(i4);
        }
        TextView textView15 = this.f6509w;
        TextView textView16 = this.f6493B;
        g gVar6 = this.f6498G;
        if (gVar6 == null) {
            m.u("viewModel");
            gVar6 = null;
        }
        n(textView15, textView16, gVar6.f6515c.g().f24185a, aVar3.f6471c);
        TextView textView17 = this.f6508v;
        TextView textView18 = this.f6492A;
        g gVar7 = this.f6498G;
        if (gVar7 == null) {
            m.u("viewModel");
            gVar7 = null;
        }
        n(textView17, textView18, gVar7.f6515c.g().f24186b, aVar3.f6472d);
        TextView textView19 = this.f6507u;
        TextView textView20 = this.f6512z;
        g gVar8 = this.f6498G;
        if (gVar8 == null) {
            m.u("viewModel");
            gVar8 = null;
        }
        n(textView19, textView20, gVar8.f6515c.g().f24187c, aVar3.f6473e);
        TextView textView21 = this.f6506t;
        TextView textView22 = this.f6511y;
        g gVar9 = this.f6498G;
        if (gVar9 == null) {
            m.u("viewModel");
            gVar9 = null;
        }
        n(textView21, textView22, gVar9.f6515c.g().f24188d, aVar3.f6474f);
        TextView textView23 = this.f6505s;
        TextView textView24 = this.f6510x;
        g gVar10 = this.f6498G;
        if (gVar10 == null) {
            m.u("viewModel");
            gVar10 = null;
        }
        n(textView23, textView24, gVar10.f6515c.g().f24189e, aVar3.f6475g);
        TextView textView25 = this.f6500n;
        TextView textView26 = this.f6501o;
        g gVar11 = this.f6498G;
        if (gVar11 == null) {
            m.u("viewModel");
            gVar11 = null;
        }
        n(textView25, textView26, gVar11.f6515c.g().f24190f, aVar3.f6476h);
        g gVar12 = this.f6498G;
        if (gVar12 == null) {
            m.u("viewModel");
        } else {
            gVar2 = gVar12;
        }
        o(gVar2.f6515c.g().f24191g, aVar3.f6477i);
    }

    public final void q() {
        TextView textView;
        TextView textView2 = this.f6495D;
        if (textView2 != null) {
            a aVar = this.f6497F;
            if (aVar == null) {
                m.u("args");
                aVar = null;
            }
            textView2.setText(aVar.f6484p);
        }
        Context context = getContext();
        if (context != null && (textView = this.f6495D) != null) {
            textView.setTextColor(ContextCompat.getColor(context, A1.a.colorRed));
        }
    }
}
