package c4;

import A1.b;
import A1.c;
import A1.e;
import C3.f;
import C3.h;
import V3.C2592c;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import c.g;
import c.i;
import com.inmobi.cmp.data.storage.SharedStorage;
import com.mbridge.msdk.MBridgeConstans;
import kotlin.jvm.internal.m;

public final class d extends d4.a {

    /* renamed from: x  reason: collision with root package name */
    public static final a f24495x = new a();

    /* renamed from: y  reason: collision with root package name */
    public static final String f24496y;

    /* renamed from: m  reason: collision with root package name */
    public LinearLayout f24497m;

    /* renamed from: n  reason: collision with root package name */
    public TextView f24498n;

    /* renamed from: o  reason: collision with root package name */
    public TextView f24499o;

    /* renamed from: p  reason: collision with root package name */
    public CheckBox f24500p;

    /* renamed from: q  reason: collision with root package name */
    public Button f24501q;

    /* renamed from: r  reason: collision with root package name */
    public CardView f24502r;

    /* renamed from: s  reason: collision with root package name */
    public TextView f24503s;

    /* renamed from: t  reason: collision with root package name */
    public TextView f24504t;

    /* renamed from: u  reason: collision with root package name */
    public NestedScrollView f24505u;

    /* renamed from: v  reason: collision with root package name */
    public FrameLayout f24506v;

    /* renamed from: w  reason: collision with root package name */
    public f f24507w;

    public static final class a {
    }

    static {
        String simpleName = d.class.getSimpleName();
        m.d(simpleName, "CCPAPrivacyFragment::class.java.simpleName");
        f24496y = simpleName;
    }

    public static final void k(d dVar, View view) {
        m.e(dVar, "this$0");
        dVar.dismiss();
        FragmentActivity activity = dVar.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    public static final void l(d dVar, String str, View view) {
        m.e(dVar, "this$0");
        m.e(str, "$link");
        dVar.getClass();
        try {
            if (str.length() > 0) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(str));
                dVar.startActivity(intent);
            }
        } catch (ActivityNotFoundException unused) {
            Log.e(f24496y, "No a valid URL has been passed");
        }
    }

    /* JADX WARNING: type inference failed for: r11v6, types: [androidx.fragment.app.Fragment] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m(c4.d r10, android.view.View r11) {
        /*
            java.lang.String r11 = "this$0"
            kotlin.jvm.internal.m.e(r10, r11)
            c4.f r11 = r10.f24507w
            r0 = 0
            if (r11 != 0) goto L_0x0010
            java.lang.String r11 = "viewModel"
            kotlin.jvm.internal.m.u(r11)
            r11 = r0
        L_0x0010:
            android.widget.CheckBox r1 = r10.f24500p
            if (r1 != 0) goto L_0x0016
            r1 = 0
            goto L_0x001a
        L_0x0016:
            boolean r1 = r1.isChecked()
        L_0x001a:
            com.inmobi.cmp.data.storage.SharedStorage r2 = r11.f24511a
            r3 = 1
            if (r1 != r3) goto L_0x0023
            C3.h r3 = C3.h.YES
        L_0x0021:
            r5 = r3
            goto L_0x0026
        L_0x0023:
            C3.h r3 = C3.h.NO
            goto L_0x0021
        L_0x0026:
            C3.f r3 = r11.f24514d
            if (r3 != 0) goto L_0x002b
            goto L_0x002f
        L_0x002b:
            C3.a r3 = r3.f170b
            if (r3 != 0) goto L_0x0031
        L_0x002f:
            r3 = r0
            goto L_0x0033
        L_0x0031:
            java.lang.String r3 = r3.f131d
        L_0x0033:
            java.lang.String r4 = "Y"
            boolean r3 = kotlin.jvm.internal.m.a(r3, r4)
            if (r3 == 0) goto L_0x003f
            C3.h r3 = C3.h.YES
        L_0x003d:
            r6 = r3
            goto L_0x0042
        L_0x003f:
            C3.h r3 = C3.h.NO
            goto L_0x003d
        L_0x0042:
            C3.h r4 = C3.h.YES
            r7 = 1
            r8 = 0
            r3 = 0
            com.inmobi.cmp.data.storage.SharedStorage.f(r2, r3, r4, r5, r6, r7, r8)
            com.inmobi.cmp.ChoiceCmpCallback r2 = r11.f24512b
            if (r2 != 0) goto L_0x004f
            goto L_0x005a
        L_0x004f:
            com.inmobi.cmp.data.storage.SharedStorage r3 = r11.f24511a
            a4.a r4 = a4.a.PRIVACY_STRING
            java.lang.String r3 = r3.j(r4)
            r2.onCCPAConsentGiven(r3)
        L_0x005a:
            o3.l0 r4 = o3.C0988l0.f3711a
            o3.G r5 = o3.Y.b()
            c4.e r7 = new c4.e
            r7.<init>(r11, r1, r0)
            r8 = 2
            r9 = 0
            r6 = 0
            o3.C1001s0 unused = o3.C0981i.d(r4, r5, r6, r7, r8, r9)
            boolean r11 = c.i.f1158b
            if (r11 == 0) goto L_0x0086
            androidx.fragment.app.FragmentManager r11 = r10.getChildFragmentManager()
            java.lang.String r1 = c.g.f1149h
            androidx.fragment.app.Fragment r11 = r11.findFragmentByTag(r1)
            boolean r1 = r11 instanceof c.g
            if (r1 == 0) goto L_0x0080
            r0 = r11
            c.g r0 = (c.g) r0
        L_0x0080:
            if (r0 != 0) goto L_0x0083
            goto L_0x0086
        L_0x0083:
            r0.g()
        L_0x0086:
            r10.dismiss()
            androidx.fragment.app.FragmentActivity r10 = r10.getActivity()
            if (r10 != 0) goto L_0x0090
            return
        L_0x0090:
            r10.finish()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: c4.d.m(c4.d, android.view.View):void");
    }

    public final void j(TextView textView, String str, String str2, boolean z4) {
        if (textView != null) {
            textView.setText(str2);
            N2.a.a(textView, z4);
            textView.setOnClickListener(new c(this, str));
        }
    }

    public void onCancel(DialogInterface dialogInterface) {
        m.e(dialogInterface, "dialog");
        super.onCancel(dialogInterface);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getActivity() != null) {
            ViewModelStore viewModelStore = getViewModelStore();
            m.d(viewModelStore, "viewModelStore");
            this.f24507w = (f) new ViewModelProvider(viewModelStore, (ViewModelProvider.Factory) new g()).get(f.class);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        m.e(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(c.dialog_ccpa_privacy, viewGroup, false);
        m.d(inflate, "inflater.inflate(R.layou…rivacy, container, false)");
        return inflate;
    }

    public void onViewCreated(View view, Bundle bundle) {
        h hVar;
        h hVar2;
        C3.a aVar;
        TextView textView;
        String str;
        m.e(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        super.onViewCreated(view, bundle);
        this.f24497m = (LinearLayout) view.findViewById(b.container_ccpa_links);
        this.f24498n = (TextView) view.findViewById(b.tv_privacy_policy_link);
        this.f24499o = (TextView) view.findViewById(b.tv_delete_data_link);
        this.f24500p = (CheckBox) view.findViewById(b.chx_ccpa_consent);
        this.f24501q = (Button) view.findViewById(b.btn_ccpa_consent);
        this.f24502r = (CardView) view.findViewById(b.bottom_container);
        this.f24503s = (TextView) view.findViewById(b.tv_ccpa_content);
        this.f24504t = (TextView) view.findViewById(b.tv_access_data_link);
        this.f24505u = (NestedScrollView) view.findViewById(b.sv_container);
        int i4 = b.gbc_fragment_container;
        FrameLayout frameLayout = (FrameLayout) view.findViewById(i4);
        this.f24506v = frameLayout;
        String str2 = null;
        if (i.f1158b) {
            getChildFragmentManager().beginTransaction().add(i4, (Fragment) new g(), g.f1149h).addToBackStack((String) null).commit();
        } else if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
        TextView textView2 = this.f24518b;
        if (textView2 != null) {
            f fVar = this.f24507w;
            if (fVar == null) {
                m.u("viewModel");
                fVar = null;
            }
            String str3 = fVar.f24513c.f24055a;
            if (str3.length() == 0) {
                str3 = getString(e.ccpa_privacy_title);
                m.d(str3, "getString(R.string.ccpa_privacy_title)");
            }
            textView2.setText(str3);
        }
        f fVar2 = this.f24507w;
        if (fVar2 == null) {
            m.u("viewModel");
            fVar2 = null;
        }
        if (fVar2.d().length() > 0) {
            TextView textView3 = this.f24503s;
            if (textView3 != null) {
                f fVar3 = this.f24507w;
                if (fVar3 == null) {
                    m.u("viewModel");
                    fVar3 = null;
                }
                textView3.setText(Q2.a.a(fVar3.d()));
            }
        } else {
            TextView textView4 = this.f24503s;
            if (textView4 != null) {
                textView4.setText(e.ccpa_content_message);
            }
        }
        TextView textView5 = this.f24503s;
        if (textView5 != null) {
            f fVar4 = this.f24507w;
            if (fVar4 == null) {
                m.u("viewModel");
                fVar4 = null;
            }
            fVar4.getClass();
            if (i.f1158b) {
                str = fVar4.f24516f.f7744b.f7739c;
            } else {
                str = "";
            }
            textView5.append(str);
        }
        TextView textView6 = this.f24503s;
        if (textView6 != null) {
            textView6.setMovementMethod(LinkMovementMethod.getInstance());
        }
        Context context = getContext();
        if (!(context == null || (textView = this.f24503s) == null)) {
            textView.setLinkTextColor(ContextCompat.getColor(context, A1.a.colorBlueAccent));
        }
        LinearLayout linearLayout = this.f24497m;
        if (linearLayout != null) {
            f fVar5 = this.f24507w;
            if (fVar5 == null) {
                m.u("viewModel");
                fVar5 = null;
            }
            N2.a.a(linearLayout, fVar5.e());
        }
        TextView textView7 = this.f24499o;
        f fVar6 = this.f24507w;
        if (fVar6 == null) {
            m.u("viewModel");
            fVar6 = null;
        }
        String f4 = fVar6.f();
        f fVar7 = this.f24507w;
        if (fVar7 == null) {
            m.u("viewModel");
            fVar7 = null;
        }
        String g4 = fVar7.g();
        f fVar8 = this.f24507w;
        if (fVar8 == null) {
            m.u("viewModel");
            fVar8 = null;
        }
        j(textView7, f4, g4, fVar8.h());
        TextView textView8 = this.f24504t;
        f fVar9 = this.f24507w;
        if (fVar9 == null) {
            m.u("viewModel");
            fVar9 = null;
        }
        String a5 = fVar9.a();
        f fVar10 = this.f24507w;
        if (fVar10 == null) {
            m.u("viewModel");
            fVar10 = null;
        }
        String b5 = fVar10.b();
        f fVar11 = this.f24507w;
        if (fVar11 == null) {
            m.u("viewModel");
            fVar11 = null;
        }
        j(textView8, a5, b5, fVar11.c());
        TextView textView9 = this.f24498n;
        f fVar12 = this.f24507w;
        if (fVar12 == null) {
            m.u("viewModel");
            fVar12 = null;
        }
        String i5 = fVar12.i();
        f fVar13 = this.f24507w;
        if (fVar13 == null) {
            m.u("viewModel");
            fVar13 = null;
        }
        String j4 = fVar13.j();
        f fVar14 = this.f24507w;
        if (fVar14 == null) {
            m.u("viewModel");
            fVar14 = null;
        }
        j(textView9, i5, j4, fVar14.k());
        ImageView imageView = this.f24519c;
        if (imageView != null) {
            imageView.setOnClickListener(new a(this));
            f fVar15 = this.f24507w;
            if (fVar15 == null) {
                m.u("viewModel");
                fVar15 = null;
            }
            imageView.setContentDescription(fVar15.f24513c.f24060f);
        }
        CheckBox checkBox = this.f24500p;
        if (checkBox != null) {
            f fVar16 = this.f24507w;
            if (fVar16 == null) {
                m.u("viewModel");
                fVar16 = null;
            }
            checkBox.setChecked(m.a(fVar16.f24511a.a(2, 3), "Y"));
        }
        Button button = this.f24501q;
        if (button != null) {
            button.setOnClickListener(new b(this));
        }
        C2592c cVar = this.f24526j;
        if (cVar != null) {
            Integer num = cVar.f24069g;
            if (num != null) {
                int intValue = num.intValue();
                view.setBackgroundColor(intValue);
                CardView cardView = this.f24502r;
                if (cardView != null) {
                    cardView.setCardBackgroundColor(intValue);
                }
            }
            Integer num2 = cVar.f24063a;
            if (num2 != null) {
                int intValue2 = num2.intValue();
                NestedScrollView nestedScrollView = this.f24505u;
                if (nestedScrollView != null) {
                    GradientDrawable gradientDrawable = new GradientDrawable();
                    gradientDrawable.setCornerRadius(2.0f);
                    gradientDrawable.setStroke(4, intValue2);
                    nestedScrollView.setBackground(gradientDrawable);
                }
            }
            Integer num3 = cVar.f24071i;
            if (num3 != null) {
                int intValue3 = num3.intValue();
                TextView textView10 = this.f24503s;
                if (textView10 != null) {
                    textView10.setTextColor(intValue3);
                }
                CheckBox checkBox2 = this.f24500p;
                if (checkBox2 != null) {
                    checkBox2.setTextColor(intValue3);
                }
                CheckBox checkBox3 = this.f24500p;
                if (checkBox3 != null) {
                    checkBox3.setButtonTintList(ColorStateList.valueOf(intValue3));
                }
            }
            Integer num4 = cVar.f24074l;
            if (num4 != null) {
                int intValue4 = num4.intValue();
                TextView textView11 = this.f24503s;
                if (textView11 != null) {
                    textView11.setLinkTextColor(intValue4);
                }
                TextView textView12 = this.f24504t;
                if (textView12 != null) {
                    textView12.setTextColor(intValue4);
                }
                TextView textView13 = this.f24499o;
                if (textView13 != null) {
                    textView13.setTextColor(intValue4);
                }
                TextView textView14 = this.f24498n;
                if (textView14 != null) {
                    textView14.setTextColor(intValue4);
                }
            }
            Integer num5 = cVar.f24077o;
            if (num5 != null) {
                int intValue5 = num5.intValue();
                Button button2 = this.f24501q;
                if (button2 != null) {
                    button2.setBackgroundColor(intValue5);
                }
            }
            Integer num6 = cVar.f24075m;
            if (num6 != null) {
                int intValue6 = num6.intValue();
                Button button3 = this.f24501q;
                if (button3 != null) {
                    button3.setTextColor(intValue6);
                }
            }
        }
        Typeface typeface = this.f24528l;
        if (typeface != null) {
            TextView textView15 = this.f24503s;
            if (textView15 != null) {
                textView15.setTypeface(typeface);
            }
            TextView textView16 = this.f24504t;
            if (textView16 != null) {
                textView16.setTypeface(typeface);
            }
            TextView textView17 = this.f24499o;
            if (textView17 != null) {
                textView17.setTypeface(typeface);
            }
            TextView textView18 = this.f24498n;
            if (textView18 != null) {
                textView18.setTypeface(typeface);
            }
            CheckBox checkBox4 = this.f24500p;
            if (checkBox4 != null) {
                checkBox4.setTypeface(typeface);
            }
            Button button4 = this.f24501q;
            if (button4 != null) {
                button4.setTypeface(typeface);
            }
        }
        f fVar17 = this.f24507w;
        if (fVar17 == null) {
            m.u("viewModel");
            fVar17 = null;
        }
        SharedStorage sharedStorage = fVar17.f24511a;
        if (m.a(sharedStorage.a(2, 3), "Y")) {
            hVar = h.YES;
        } else {
            hVar = h.NO;
        }
        h hVar3 = hVar;
        f fVar18 = fVar17.f24514d;
        if (!(fVar18 == null || (aVar = fVar18.f170b) == null)) {
            str2 = aVar.f131d;
        }
        if (m.a(str2, "Y")) {
            hVar2 = h.YES;
        } else {
            hVar2 = h.NO;
        }
        SharedStorage.f(sharedStorage, 0, h.YES, hVar3, hVar2, 1, (Object) null);
    }
}
