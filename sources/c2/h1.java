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

public final class h1 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f10462a;

    /* renamed from: b  reason: collision with root package name */
    public final View f10463b;

    /* renamed from: c  reason: collision with root package name */
    public final RecyclerView f10464c;

    /* renamed from: d  reason: collision with root package name */
    public final Toolbar f10465d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f10466e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f10467f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f10468g;

    private h1(RelativeLayout relativeLayout, View view, RecyclerView recyclerView, Toolbar toolbar, TextView textView, TextView textView2, TextView textView3) {
        this.f10462a = relativeLayout;
        this.f10463b = view;
        this.f10464c = recyclerView;
        this.f10465d = toolbar;
        this.f10466e = textView;
        this.f10467f = textView2;
        this.f10468g = textView3;
    }

    public static h1 a(View view) {
        int i4 = R.id.loading_view_wishlist;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.loading_view_wishlist);
        if (findChildViewById != null) {
            i4 = R.id.rv_wishlist;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.rv_wishlist);
            if (recyclerView != null) {
                i4 = R.id.toolbar_wishlist;
                Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar_wishlist);
                if (toolbar != null) {
                    i4 = R.id.tv_explore_wishlist;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_explore_wishlist);
                    if (textView != null) {
                        i4 = R.id.tv_no_items_wishlist;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_no_items_wishlist);
                        if (textView2 != null) {
                            i4 = R.id.tv_title_wishlist;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_title_wishlist);
                            if (textView3 != null) {
                                return new h1((RelativeLayout) view, findChildViewById, recyclerView, toolbar, textView, textView2, textView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    public static h1 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static h1 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.wishlist_activity, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f10462a;
    }
}
