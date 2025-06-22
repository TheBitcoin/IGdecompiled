package c2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

public final class S implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f9988a;

    /* renamed from: b  reason: collision with root package name */
    public final C1651B f9989b;

    /* renamed from: c  reason: collision with root package name */
    public final View f9990c;

    /* renamed from: d  reason: collision with root package name */
    public final NestedScrollView f9991d;

    /* renamed from: e  reason: collision with root package name */
    public final RecyclerView f9992e;

    /* renamed from: f  reason: collision with root package name */
    public final SearchView f9993f;

    /* renamed from: g  reason: collision with root package name */
    public final Toolbar f9994g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f9995h;

    /* renamed from: i  reason: collision with root package name */
    public final TextView f9996i;

    private S(RelativeLayout relativeLayout, C1651B b5, View view, NestedScrollView nestedScrollView, RecyclerView recyclerView, SearchView searchView, Toolbar toolbar, TextView textView, TextView textView2) {
        this.f9988a = relativeLayout;
        this.f9989b = b5;
        this.f9990c = view;
        this.f9991d = nestedScrollView;
        this.f9992e = recyclerView;
        this.f9993f = searchView;
        this.f9994g = toolbar;
        this.f9995h = textView;
        this.f9996i = textView2;
    }

    public static S a(View view) {
        int i4 = R.id.ll_order_my_apps;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.ll_order_my_apps);
        if (findChildViewById != null) {
            C1651B a5 = C1651B.a(findChildViewById);
            i4 = R.id.loading_view_my_apps;
            View findChildViewById2 = ViewBindings.findChildViewById(view, R.id.loading_view_my_apps);
            if (findChildViewById2 != null) {
                i4 = R.id.nsv_my_apps;
                NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(view, R.id.nsv_my_apps);
                if (nestedScrollView != null) {
                    i4 = R.id.rv_my_apps;
                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.rv_my_apps);
                    if (recyclerView != null) {
                        i4 = R.id.search_view_my_apps;
                        SearchView searchView = (SearchView) ViewBindings.findChildViewById(view, R.id.search_view_my_apps);
                        if (searchView != null) {
                            i4 = R.id.toolbar_my_apps;
                            Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar_my_apps);
                            if (toolbar != null) {
                                i4 = R.id.tv_no_items_filtered_my_apps;
                                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_no_items_filtered_my_apps);
                                if (textView != null) {
                                    i4 = R.id.tv_toolbar_title_my_apps;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_toolbar_title_my_apps);
                                    if (textView2 != null) {
                                        return new S((RelativeLayout) view, a5, findChildViewById2, nestedScrollView, recyclerView, searchView, toolbar, textView, textView2);
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

    public static S c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static S d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.my_apps, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f9988a;
    }
}
