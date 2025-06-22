package c2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

public final class C0 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f9705a;

    /* renamed from: b  reason: collision with root package name */
    public final AppCompatImageView f9706b;

    /* renamed from: c  reason: collision with root package name */
    public final View f9707c;

    /* renamed from: d  reason: collision with root package name */
    public final LinearLayout f9708d;

    /* renamed from: e  reason: collision with root package name */
    public final RecyclerView f9709e;

    /* renamed from: f  reason: collision with root package name */
    public final Toolbar f9710f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f9711g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f9712h;

    /* renamed from: i  reason: collision with root package name */
    public final TextView f9713i;

    /* renamed from: j  reason: collision with root package name */
    public final TextView f9714j;

    private C0(RelativeLayout relativeLayout, AppCompatImageView appCompatImageView, View view, LinearLayout linearLayout, RecyclerView recyclerView, Toolbar toolbar, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.f9705a = relativeLayout;
        this.f9706b = appCompatImageView;
        this.f9707c = view;
        this.f9708d = linearLayout;
        this.f9709e = recyclerView;
        this.f9710f = toolbar;
        this.f9711g = textView;
        this.f9712h = textView2;
        this.f9713i = textView3;
        this.f9714j = textView4;
    }

    public static C0 a(View view) {
        int i4 = R.id.iv_positives;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, R.id.iv_positives);
        if (appCompatImageView != null) {
            i4 = R.id.loading_view_security;
            View findChildViewById = ViewBindings.findChildViewById(view, R.id.loading_view_security);
            if (findChildViewById != null) {
                i4 = R.id.rl_free_positives;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.rl_free_positives);
                if (linearLayout != null) {
                    i4 = R.id.rv_positives;
                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.rv_positives);
                    if (recyclerView != null) {
                        i4 = R.id.toolbar_positives;
                        Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar_positives);
                        if (toolbar != null) {
                            i4 = R.id.tv_button_analysis_free_positives;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_button_analysis_free_positives);
                            if (textView != null) {
                                i4 = R.id.tv_last_analysis_free_positives;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_last_analysis_free_positives);
                                if (textView2 != null) {
                                    i4 = R.id.tv_title_free_positives;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_title_free_positives);
                                    if (textView3 != null) {
                                        i4 = R.id.tv_toolbar_title_positives;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_toolbar_title_positives);
                                        if (textView4 != null) {
                                            return new C0((RelativeLayout) view, appCompatImageView, findChildViewById, linearLayout, recyclerView, toolbar, textView, textView2, textView3, textView4);
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

    public static C0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static C0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.security_activity, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f9705a;
    }
}
