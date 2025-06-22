package c;

import A1.b;
import A1.c;
import A1.e;
import V3.C2592c;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import com.mbridge.msdk.MBridgeConstans;
import e4.a;
import e4.d;
import kotlin.jvm.internal.m;

/* renamed from: c.c  reason: case insensitive filesystem */
public final class C0500c extends d4.a implements a.b {

    /* renamed from: q  reason: collision with root package name */
    public static final a f1137q = new a();

    /* renamed from: r  reason: collision with root package name */
    public static final String f1138r;

    /* renamed from: m  reason: collision with root package name */
    public TextView f1139m;

    /* renamed from: n  reason: collision with root package name */
    public Button f1140n;

    /* renamed from: o  reason: collision with root package name */
    public NestedScrollView f1141o;

    /* renamed from: p  reason: collision with root package name */
    public e f1142p;

    /* renamed from: c.c$a */
    public static final class a {
    }

    static {
        String simpleName = C0500c.class.getSimpleName();
        m.d(simpleName, "GBCFragment::class.java.simpleName");
        f1138r = simpleName;
    }

    public static final void j(C0500c cVar, View view) {
        m.e(cVar, "this$0");
        cVar.dismiss();
        FragmentActivity activity = cVar.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    public static final void k(C0500c cVar, View view) {
        g gVar;
        m.e(cVar, "this$0");
        Fragment findFragmentByTag = cVar.getChildFragmentManager().findFragmentByTag(g.f1149h);
        if (findFragmentByTag instanceof g) {
            gVar = (g) findFragmentByTag;
        } else {
            gVar = null;
        }
        if (gVar != null) {
            gVar.g();
        }
        cVar.dismiss();
        FragmentActivity activity = cVar.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    public void d(d dVar) {
        m.e(dVar, "item");
    }

    public void f(d dVar) {
        m.e(dVar, "item");
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
            this.f1142p = (e) new ViewModelProvider(viewModelStore, (ViewModelProvider.Factory) new f()).get(e.class);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        m.e(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(c.gbc_privacy_screen, viewGroup, false);
        m.d(inflate, "inflater.inflate(R.layou…screen, container, false)");
        return inflate;
    }

    public void onViewCreated(View view, Bundle bundle) {
        TextView textView;
        TextView textView2;
        m.e(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        super.onViewCreated(view, bundle);
        this.f1139m = (TextView) view.findViewById(b.tv_gbc_description);
        this.f1140n = (Button) view.findViewById(b.btn_save_and_exit);
        this.f1141o = (NestedScrollView) view.findViewById(b.sv_container);
        e eVar = null;
        getChildFragmentManager().beginTransaction().add(b.gbc_fragment_container, (Fragment) new g(), g.f1149h).addToBackStack((String) null).commit();
        TextView textView3 = this.f24518b;
        if (textView3 != null) {
            e eVar2 = this.f1142p;
            if (eVar2 == null) {
                m.u("viewModel");
                eVar2 = null;
            }
            String str = eVar2.f1146c.f7744b.f7737a;
            if (str.length() == 0) {
                str = getString(e.we_value_your_privacy);
                m.d(str, "getString(R.string.we_value_your_privacy)");
            }
            textView3.setText(str);
        }
        TextView textView4 = this.f1139m;
        if (textView4 != null) {
            e eVar3 = this.f1142p;
            if (eVar3 == null) {
                m.u("viewModel");
                eVar3 = null;
            }
            String str2 = eVar3.f1146c.f7744b.f7739c;
            if (str2.length() == 0) {
                str2 = getString(e.gbc_description);
                m.d(str2, "getString(R.string.gbc_description)");
            }
            textView4.setText(str2);
        }
        TextView textView5 = this.f1139m;
        if (textView5 != null) {
            textView5.setMovementMethod(LinkMovementMethod.getInstance());
        }
        Context context = getContext();
        if (!(context == null || (textView2 = this.f1139m) == null)) {
            textView2.setLinkTextColor(ContextCompat.getColor(context, A1.a.colorBlueAccent));
        }
        Button button = this.f1140n;
        if (button != null) {
            e eVar4 = this.f1142p;
            if (eVar4 == null) {
                m.u("viewModel");
            } else {
                eVar = eVar4;
            }
            String str3 = eVar.f1146c.f7744b.f7740d;
            if (str3.length() == 0) {
                str3 = getString(e.save_and_exit);
                m.d(str3, "getString(R.string.save_and_exit)");
            }
            button.setText(str3);
        }
        ImageView imageView = this.f24519c;
        if (imageView != null) {
            imageView.setOnClickListener(new C0498a(this));
        }
        Button button2 = this.f1140n;
        if (button2 != null) {
            button2.setOnClickListener(new C0499b(this));
        }
        C2592c cVar = this.f24526j;
        if (cVar != null) {
            Integer num = cVar.f24069g;
            if (num != null) {
                view.setBackgroundColor(num.intValue());
            }
            Integer num2 = cVar.f24063a;
            if (num2 != null) {
                int intValue = num2.intValue();
                NestedScrollView nestedScrollView = this.f1141o;
                if (nestedScrollView != null) {
                    GradientDrawable gradientDrawable = new GradientDrawable();
                    gradientDrawable.setCornerRadius(2.0f);
                    gradientDrawable.setStroke(4, intValue);
                    nestedScrollView.setBackground(gradientDrawable);
                }
            }
            Integer num3 = cVar.f24071i;
            if (num3 != null) {
                int intValue2 = num3.intValue();
                TextView textView6 = this.f1139m;
                if (textView6 != null) {
                    textView6.setTextColor(intValue2);
                }
            }
            Integer num4 = cVar.f24077o;
            if (num4 != null) {
                int intValue3 = num4.intValue();
                Button button3 = this.f1140n;
                if (button3 != null) {
                    button3.setBackgroundColor(intValue3);
                }
            }
            Integer num5 = cVar.f24075m;
            if (num5 != null) {
                int intValue4 = num5.intValue();
                Button button4 = this.f1140n;
                if (button4 != null) {
                    button4.setTextColor(intValue4);
                }
            }
        }
        Typeface typeface = this.f24528l;
        if (typeface != null && (textView = this.f1139m) != null) {
            textView.setTypeface(typeface);
        }
    }
}
