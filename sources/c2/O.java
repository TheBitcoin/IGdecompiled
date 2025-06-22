package c2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

public final class O implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f9868a;

    /* renamed from: b  reason: collision with root package name */
    public final View f9869b;

    /* renamed from: c  reason: collision with root package name */
    public final P f9870c;

    /* renamed from: d  reason: collision with root package name */
    public final F0 f9871d;

    /* renamed from: e  reason: collision with root package name */
    public final Toolbar f9872e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f9873f;

    private O(RelativeLayout relativeLayout, View view, P p4, F0 f02, Toolbar toolbar, TextView textView) {
        this.f9868a = relativeLayout;
        this.f9869b = view;
        this.f9870c = p4;
        this.f9871d = f02;
        this.f9872e = toolbar;
        this.f9873f = textView;
    }

    public static O a(View view) {
        int i4 = R.id.loading_view_login;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.loading_view_login);
        if (findChildViewById != null) {
            i4 = R.id.login_form;
            View findChildViewById2 = ViewBindings.findChildViewById(view, R.id.login_form);
            if (findChildViewById2 != null) {
                P a5 = P.a(findChildViewById2);
                i4 = R.id.sign_up_form;
                View findChildViewById3 = ViewBindings.findChildViewById(view, R.id.sign_up_form);
                if (findChildViewById3 != null) {
                    F0 a6 = F0.a(findChildViewById3);
                    i4 = R.id.toolbar_login;
                    Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar_login);
                    if (toolbar != null) {
                        i4 = R.id.tv_title_toolbar_login;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_title_toolbar_login);
                        if (textView != null) {
                            return new O((RelativeLayout) view, findChildViewById, a5, a6, toolbar, textView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    public static O c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static O d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.login_activity, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f9868a;
    }
}
