package n;

import A1.b;
import A1.c;
import A1.e;
import A3.d;
import A3.i;
import V3.C2592c;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import c4.g;
import com.inmobi.cmp.data.storage.SharedStorage;
import com.mbridge.msdk.MBridgeConstans;
import java.util.List;
import kotlin.jvm.internal.m;

public final class f extends d4.a {

    /* renamed from: x  reason: collision with root package name */
    public static final a f3571x = new a();

    /* renamed from: y  reason: collision with root package name */
    public static final String f3572y;

    /* renamed from: m  reason: collision with root package name */
    public LinearLayout f3573m;

    /* renamed from: n  reason: collision with root package name */
    public TextView f3574n;

    /* renamed from: o  reason: collision with root package name */
    public TextView f3575o;

    /* renamed from: p  reason: collision with root package name */
    public Button f3576p;

    /* renamed from: q  reason: collision with root package name */
    public Button f3577q;

    /* renamed from: r  reason: collision with root package name */
    public CardView f3578r;

    /* renamed from: s  reason: collision with root package name */
    public TextView f3579s;

    /* renamed from: t  reason: collision with root package name */
    public TextView f3580t;

    /* renamed from: u  reason: collision with root package name */
    public NestedScrollView f3581u;

    /* renamed from: v  reason: collision with root package name */
    public c4.f f3582v;

    /* renamed from: w  reason: collision with root package name */
    public m f3583w;

    public static final class a {
    }

    static {
        String simpleName = f.class.getSimpleName();
        m.d(simpleName, "MSPAPrivacyFragment::class.java.simpleName");
        f3572y = simpleName;
    }

    public static final void k(f fVar, View view) {
        m.e(fVar, "this$0");
        fVar.dismiss();
        FragmentActivity activity = fVar.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    public static final void l(f fVar, String str) {
        m.e(fVar, "this$0");
        fVar.dismiss();
        FragmentActivity activity = fVar.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    public static final void m(f fVar, String str, View view) {
        m.e(fVar, "this$0");
        m.e(str, "$link");
        fVar.getClass();
        try {
            if (str.length() > 0) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(str));
                fVar.startActivity(intent);
            }
        } catch (ActivityNotFoundException unused) {
            Log.e(f3572y, "No a valid URL has been passed");
        }
    }

    public static final void n(f fVar, View view) {
        m.e(fVar, "this$0");
        m mVar = fVar.f3583w;
        if (mVar == null) {
            m.u("mspaViewModel");
            mVar = null;
        }
        mVar.a().observe(fVar, new e(fVar));
    }

    public static final void o(f fVar, View view) {
        FragmentManager supportFragmentManager;
        FragmentTransaction beginTransaction;
        FragmentTransaction add;
        m.e(fVar, "this$0");
        FragmentActivity activity = fVar.getActivity();
        if (activity != null && (supportFragmentManager = activity.getSupportFragmentManager()) != null && (beginTransaction = supportFragmentManager.beginTransaction()) != null && (add = beginTransaction.add((Fragment) new l(), l.f3590B)) != null) {
            add.commit();
        }
    }

    public final void j(TextView textView, String str, String str2, boolean z4) {
        if (textView != null) {
            textView.setText(str2);
            N2.a.a(textView, z4);
            textView.setOnClickListener(new d(this, str));
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
            this.f3582v = (c4.f) new ViewModelProvider(viewModelStore, (ViewModelProvider.Factory) new g()).get(c4.f.class);
            ViewModelStore viewModelStore2 = getViewModelStore();
            m.d(viewModelStore2, "viewModelStore");
            this.f3583w = (m) new ViewModelProvider(viewModelStore2, (ViewModelProvider.Factory) new p()).get(m.class);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        m.e(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(c.dialog_mspa_privacy, viewGroup, false);
        m.d(inflate, "inflater.inflate(R.layou…rivacy, container, false)");
        return inflate;
    }

    public void onViewCreated(View view, Bundle bundle) {
        List list;
        TextView textView;
        String str;
        m.e(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        super.onViewCreated(view, bundle);
        this.f3573m = (LinearLayout) view.findViewById(b.container_ccpa_links);
        this.f3574n = (TextView) view.findViewById(b.tv_privacy_policy_link);
        this.f3575o = (TextView) view.findViewById(b.tv_delete_data_link);
        this.f3580t = (TextView) view.findViewById(b.tv_access_data_link);
        this.f3578r = (CardView) view.findViewById(b.bottom_container);
        this.f3579s = (TextView) view.findViewById(b.tv_ccpa_content);
        this.f3581u = (NestedScrollView) view.findViewById(b.sv_container);
        this.f3576p = (Button) view.findViewById(b.btn_preferences);
        this.f3577q = (Button) view.findViewById(b.btn_confirm);
        m mVar = this.f3583w;
        m mVar2 = null;
        if (mVar == null) {
            m.u("mspaViewModel");
            mVar = null;
        }
        i.f81a.c(mVar.f3605a);
        TextView textView2 = this.f24518b;
        if (textView2 != null) {
            c4.f fVar = this.f3582v;
            if (fVar == null) {
                m.u("ccpaViewModel");
                fVar = null;
            }
            String str2 = fVar.f24513c.f24055a;
            if (str2.length() == 0) {
                str2 = getString(e.ccpa_privacy_title);
                m.d(str2, "getString(R.string.ccpa_privacy_title)");
            }
            textView2.setText(str2);
        }
        c4.f fVar2 = this.f3582v;
        if (fVar2 == null) {
            m.u("ccpaViewModel");
            fVar2 = null;
        }
        if (fVar2.d().length() > 0) {
            TextView textView3 = this.f3579s;
            if (textView3 != null) {
                c4.f fVar3 = this.f3582v;
                if (fVar3 == null) {
                    m.u("ccpaViewModel");
                    fVar3 = null;
                }
                textView3.setText(Q2.a.a(fVar3.d()));
            }
        } else {
            TextView textView4 = this.f3579s;
            if (textView4 != null) {
                textView4.setText(e.ccpa_content_message);
            }
        }
        TextView textView5 = this.f3579s;
        if (textView5 != null) {
            c4.f fVar4 = this.f3582v;
            if (fVar4 == null) {
                m.u("ccpaViewModel");
                fVar4 = null;
            }
            fVar4.getClass();
            if (c.i.f1158b) {
                str = fVar4.f24516f.f7744b.f7739c;
            } else {
                str = "";
            }
            textView5.append(str);
        }
        TextView textView6 = this.f3579s;
        if (textView6 != null) {
            textView6.setMovementMethod(LinkMovementMethod.getInstance());
        }
        Context context = getContext();
        if (!(context == null || (textView = this.f3579s) == null)) {
            textView.setLinkTextColor(ContextCompat.getColor(context, A1.a.colorBlueAccent));
        }
        LinearLayout linearLayout = this.f3573m;
        if (linearLayout != null) {
            c4.f fVar5 = this.f3582v;
            if (fVar5 == null) {
                m.u("ccpaViewModel");
                fVar5 = null;
            }
            N2.a.a(linearLayout, fVar5.e());
        }
        TextView textView7 = this.f3575o;
        c4.f fVar6 = this.f3582v;
        if (fVar6 == null) {
            m.u("ccpaViewModel");
            fVar6 = null;
        }
        String f4 = fVar6.f();
        c4.f fVar7 = this.f3582v;
        if (fVar7 == null) {
            m.u("ccpaViewModel");
            fVar7 = null;
        }
        String g4 = fVar7.g();
        c4.f fVar8 = this.f3582v;
        if (fVar8 == null) {
            m.u("ccpaViewModel");
            fVar8 = null;
        }
        j(textView7, f4, g4, fVar8.h());
        TextView textView8 = this.f3580t;
        c4.f fVar9 = this.f3582v;
        if (fVar9 == null) {
            m.u("ccpaViewModel");
            fVar9 = null;
        }
        String a5 = fVar9.a();
        c4.f fVar10 = this.f3582v;
        if (fVar10 == null) {
            m.u("ccpaViewModel");
            fVar10 = null;
        }
        String b5 = fVar10.b();
        c4.f fVar11 = this.f3582v;
        if (fVar11 == null) {
            m.u("ccpaViewModel");
            fVar11 = null;
        }
        j(textView8, a5, b5, fVar11.c());
        TextView textView9 = this.f3574n;
        c4.f fVar12 = this.f3582v;
        if (fVar12 == null) {
            m.u("ccpaViewModel");
            fVar12 = null;
        }
        String i4 = fVar12.i();
        c4.f fVar13 = this.f3582v;
        if (fVar13 == null) {
            m.u("ccpaViewModel");
            fVar13 = null;
        }
        String j4 = fVar13.j();
        c4.f fVar14 = this.f3582v;
        if (fVar14 == null) {
            m.u("ccpaViewModel");
            fVar14 = null;
        }
        j(textView9, i4, j4, fVar14.k());
        ImageView imageView = this.f24519c;
        if (imageView != null) {
            imageView.setOnClickListener(new C0957a(this));
            c4.f fVar15 = this.f3582v;
            if (fVar15 == null) {
                m.u("ccpaViewModel");
                fVar15 = null;
            }
            imageView.setContentDescription(fVar15.f24513c.f24060f);
        }
        Button button = this.f3577q;
        if (button != null) {
            button.setOnClickListener(new C0958b(this));
        }
        Button button2 = this.f3576p;
        if (button2 != null) {
            button2.setOnClickListener(new C0959c(this));
        }
        C2592c cVar = this.f24526j;
        if (cVar != null) {
            Integer num = cVar.f24069g;
            if (num != null) {
                int intValue = num.intValue();
                view.setBackgroundColor(intValue);
                CardView cardView = this.f3578r;
                if (cardView != null) {
                    cardView.setCardBackgroundColor(intValue);
                }
            }
            Integer num2 = cVar.f24063a;
            if (num2 != null) {
                int intValue2 = num2.intValue();
                NestedScrollView nestedScrollView = this.f3581u;
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
                TextView textView10 = this.f3579s;
                if (textView10 != null) {
                    textView10.setTextColor(intValue3);
                }
            }
            Integer num4 = cVar.f24074l;
            if (num4 != null) {
                int intValue4 = num4.intValue();
                TextView textView11 = this.f3579s;
                if (textView11 != null) {
                    textView11.setLinkTextColor(intValue4);
                }
                TextView textView12 = this.f3580t;
                if (textView12 != null) {
                    textView12.setTextColor(intValue4);
                }
                TextView textView13 = this.f3575o;
                if (textView13 != null) {
                    textView13.setTextColor(intValue4);
                }
                TextView textView14 = this.f3574n;
                if (textView14 != null) {
                    textView14.setTextColor(intValue4);
                }
            }
            Integer num5 = cVar.f24077o;
            if (num5 != null) {
                int intValue5 = num5.intValue();
                Button button3 = this.f3576p;
                if (button3 != null) {
                    button3.setBackgroundColor(intValue5);
                }
                Button button4 = this.f3577q;
                if (button4 != null) {
                    button4.setBackgroundColor(intValue5);
                }
            }
            Integer num6 = cVar.f24075m;
            if (num6 != null) {
                int intValue6 = num6.intValue();
                Button button5 = this.f3576p;
                if (button5 != null) {
                    button5.setTextColor(intValue6);
                }
                Button button6 = this.f3577q;
                if (button6 != null) {
                    button6.setTextColor(intValue6);
                }
            }
        }
        Typeface typeface = this.f24528l;
        if (typeface != null) {
            TextView textView15 = this.f3579s;
            if (textView15 != null) {
                textView15.setTypeface(typeface);
            }
            TextView textView16 = this.f3580t;
            if (textView16 != null) {
                textView16.setTypeface(typeface);
            }
            TextView textView17 = this.f3575o;
            if (textView17 != null) {
                textView17.setTypeface(typeface);
            }
            TextView textView18 = this.f3574n;
            if (textView18 != null) {
                textView18.setTypeface(typeface);
            }
            Button button7 = this.f3577q;
            if (button7 != null) {
                button7.setTypeface(typeface);
            }
            Button button8 = this.f3576p;
            if (button8 != null) {
                button8.setTypeface(typeface);
            }
        }
        m mVar3 = this.f3583w;
        if (mVar3 == null) {
            m.u("mspaViewModel");
        } else {
            mVar2 = mVar3;
        }
        mVar2.getClass();
        if (!i.f85e && (list = mVar2.f3605a.f32d) != null) {
            d.f51a.b(list, true, new n(mVar2));
        }
        i.f85e = true;
        SharedStorage m4 = b4.d.f24465a.m();
        a4.a aVar = a4.a.MSPA_SHOWN;
        m4.getClass();
        m.e(aVar, "preferenceKey");
        SharedPreferences.Editor edit = m4.f11786a.edit();
        m.d(edit, "editor");
        edit.putBoolean("MSPAShown", true);
        edit.apply();
    }
}
