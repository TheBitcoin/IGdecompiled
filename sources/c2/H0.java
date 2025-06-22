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

public final class H0 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f9765a;

    /* renamed from: b  reason: collision with root package name */
    public final View f9766b;

    /* renamed from: c  reason: collision with root package name */
    public final RecyclerView f9767c;

    /* renamed from: d  reason: collision with root package name */
    public final Toolbar f9768d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f9769e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f9770f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f9771g;

    private H0(RelativeLayout relativeLayout, View view, RecyclerView recyclerView, Toolbar toolbar, TextView textView, TextView textView2, TextView textView3) {
        this.f9765a = relativeLayout;
        this.f9766b = view;
        this.f9767c = recyclerView;
        this.f9768d = toolbar;
        this.f9769e = textView;
        this.f9770f = textView2;
        this.f9771g = textView3;
    }

    public static H0 a(View view) {
        int i4 = R.id.loading_view_top_by_cat_fragment;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.loading_view_top_by_cat_fragment);
        if (findChildViewById != null) {
            i4 = R.id.recyclerview_top_cat;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.recyclerview_top_cat);
            if (recyclerView != null) {
                i4 = R.id.toolbar_top_by_cat;
                Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar_top_by_cat);
                if (toolbar != null) {
                    i4 = R.id.tv_no_data_top_cat;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_no_data_top_cat);
                    if (textView != null) {
                        i4 = R.id.tv_reload_top_by_category_fragment;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_reload_top_by_category_fragment);
                        if (textView2 != null) {
                            i4 = R.id.tv_toolbar_title_top_by_cat;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_toolbar_title_top_by_cat);
                            if (textView3 != null) {
                                return new H0((RelativeLayout) view, findChildViewById, recyclerView, toolbar, textView, textView2, textView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    public static H0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static H0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.top_by_category_fragment, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f9765a;
    }
}
