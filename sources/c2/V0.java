package c2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

public final class V0 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f10058a;

    /* renamed from: b  reason: collision with root package name */
    public final LinearLayout f10059b;

    /* renamed from: c  reason: collision with root package name */
    public final LinearLayout f10060c;

    /* renamed from: d  reason: collision with root package name */
    public final LinearLayout f10061d;

    /* renamed from: e  reason: collision with root package name */
    public final LinearLayout f10062e;

    /* renamed from: f  reason: collision with root package name */
    public final Toolbar f10063f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f10064g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f10065h;

    /* renamed from: i  reason: collision with root package name */
    public final TextView f10066i;

    /* renamed from: j  reason: collision with root package name */
    public final TextView f10067j;

    /* renamed from: k  reason: collision with root package name */
    public final TextView f10068k;

    /* renamed from: l  reason: collision with root package name */
    public final View f10069l;

    private V0(RelativeLayout relativeLayout, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, Toolbar toolbar, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, View view) {
        this.f10058a = relativeLayout;
        this.f10059b = linearLayout;
        this.f10060c = linearLayout2;
        this.f10061d = linearLayout3;
        this.f10062e = linearLayout4;
        this.f10063f = toolbar;
        this.f10064g = textView;
        this.f10065h = textView2;
        this.f10066i = textView3;
        this.f10067j = textView4;
        this.f10068k = textView5;
        this.f10069l = view;
    }

    public static V0 a(View view) {
        int i4 = R.id.ll_avatar_uep;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.ll_avatar_uep);
        if (linearLayout != null) {
            i4 = R.id.ll_logout_uep;
            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.ll_logout_uep);
            if (linearLayout2 != null) {
                i4 = R.id.ll_password_uep;
                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.ll_password_uep);
                if (linearLayout3 != null) {
                    i4 = R.id.ll_username_uep;
                    LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.ll_username_uep);
                    if (linearLayout4 != null) {
                        i4 = R.id.toolbar_uep;
                        Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar_uep);
                        if (toolbar != null) {
                            i4 = R.id.tv_avatar_uep;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_avatar_uep);
                            if (textView != null) {
                                i4 = R.id.tv_logout_uep;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_logout_uep);
                                if (textView2 != null) {
                                    i4 = R.id.tv_password_uep;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_password_uep);
                                    if (textView3 != null) {
                                        i4 = R.id.tv_title_uep;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_title_uep);
                                        if (textView4 != null) {
                                            i4 = R.id.tv_username_uep;
                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_username_uep);
                                            if (textView5 != null) {
                                                i4 = R.id.v_divider_uep;
                                                View findChildViewById = ViewBindings.findChildViewById(view, R.id.v_divider_uep);
                                                if (findChildViewById != null) {
                                                    return new V0((RelativeLayout) view, linearLayout, linearLayout2, linearLayout3, linearLayout4, toolbar, textView, textView2, textView3, textView4, textView5, findChildViewById);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    public static V0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static V0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.user_edit_profile, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f10058a;
    }
}
