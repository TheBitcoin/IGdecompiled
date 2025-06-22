package c2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

public final class E implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f9720a;

    /* renamed from: b  reason: collision with root package name */
    public final e1 f9721b;

    /* renamed from: c  reason: collision with root package name */
    public final View f9722c;

    /* renamed from: d  reason: collision with root package name */
    public final RecyclerView f9723d;

    /* renamed from: e  reason: collision with root package name */
    public final Toolbar f9724e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f9725f;

    private E(RelativeLayout relativeLayout, e1 e1Var, View view, RecyclerView recyclerView, Toolbar toolbar, TextView textView) {
        this.f9720a = relativeLayout;
        this.f9721b = e1Var;
        this.f9722c = view;
        this.f9723d = recyclerView;
        this.f9724e = toolbar;
        this.f9725f = textView;
    }

    public static E a(View view) {
        int i4 = R.id.header_fus;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.header_fus);
        if (findChildViewById != null) {
            e1 a5 = e1.a(findChildViewById);
            i4 = R.id.loading_view_fus;
            View findChildViewById2 = ViewBindings.findChildViewById(view, R.id.loading_view_fus);
            if (findChildViewById2 != null) {
                i4 = R.id.rv_fus;
                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.rv_fus);
                if (recyclerView != null) {
                    i4 = R.id.toolbar_fus;
                    Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar_fus);
                    if (toolbar != null) {
                        i4 = R.id.tv_toolbar_title_fus;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_toolbar_title_fus);
                        if (textView != null) {
                            return new E((RelativeLayout) view, a5, findChildViewById2, recyclerView, toolbar, textView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    public static E c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static E d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.free_up_space_activity, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f9720a;
    }
}
