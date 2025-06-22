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

public final class T implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f10022a;

    /* renamed from: b  reason: collision with root package name */
    public final View f10023b;

    /* renamed from: c  reason: collision with root package name */
    public final U f10024c;

    /* renamed from: d  reason: collision with root package name */
    public final NestedScrollView f10025d;

    /* renamed from: e  reason: collision with root package name */
    public final RecyclerView f10026e;

    /* renamed from: f  reason: collision with root package name */
    public final SearchView f10027f;

    /* renamed from: g  reason: collision with root package name */
    public final Toolbar f10028g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f10029h;

    /* renamed from: i  reason: collision with root package name */
    public final TextView f10030i;

    private T(RelativeLayout relativeLayout, View view, U u4, NestedScrollView nestedScrollView, RecyclerView recyclerView, SearchView searchView, Toolbar toolbar, TextView textView, TextView textView2) {
        this.f10022a = relativeLayout;
        this.f10023b = view;
        this.f10024c = u4;
        this.f10025d = nestedScrollView;
        this.f10026e = recyclerView;
        this.f10027f = searchView;
        this.f10028g = toolbar;
        this.f10029h = textView;
        this.f10030i = textView2;
    }

    public static T a(View view) {
        int i4 = R.id.loading_view_my_downloads;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.loading_view_my_downloads);
        if (findChildViewById != null) {
            i4 = R.id.my_downloads_filters;
            View findChildViewById2 = ViewBindings.findChildViewById(view, R.id.my_downloads_filters);
            if (findChildViewById2 != null) {
                U a5 = U.a(findChildViewById2);
                i4 = R.id.nsv_my_downloads;
                NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(view, R.id.nsv_my_downloads);
                if (nestedScrollView != null) {
                    i4 = R.id.recyclerview;
                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.recyclerview);
                    if (recyclerView != null) {
                        i4 = R.id.search_view_my_downloads;
                        SearchView searchView = (SearchView) ViewBindings.findChildViewById(view, R.id.search_view_my_downloads);
                        if (searchView != null) {
                            i4 = R.id.toolbar_downloads;
                            Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar_downloads);
                            if (toolbar != null) {
                                i4 = R.id.tv_no_items;
                                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_no_items);
                                if (textView != null) {
                                    i4 = R.id.tv_toolbar_title_downloads;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_toolbar_title_downloads);
                                    if (textView2 != null) {
                                        return new T((RelativeLayout) view, findChildViewById, a5, nestedScrollView, recyclerView, searchView, toolbar, textView, textView2);
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

    public static T c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static T d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.my_downloads, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f10022a;
    }
}
