package c2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

public final class J0 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f9796a;

    /* renamed from: b  reason: collision with root package name */
    public final View f9797b;

    /* renamed from: c  reason: collision with root package name */
    public final ProgressBar f9798c;

    /* renamed from: d  reason: collision with root package name */
    public final RelativeLayout f9799d;

    /* renamed from: e  reason: collision with root package name */
    public final RelativeLayout f9800e;

    /* renamed from: f  reason: collision with root package name */
    public final RelativeLayout f9801f;

    /* renamed from: g  reason: collision with root package name */
    public final RecyclerView f9802g;

    /* renamed from: h  reason: collision with root package name */
    public final SwipeRefreshLayout f9803h;

    /* renamed from: i  reason: collision with root package name */
    public final Toolbar f9804i;

    /* renamed from: j  reason: collision with root package name */
    public final TextView f9805j;

    /* renamed from: k  reason: collision with root package name */
    public final TextView f9806k;

    /* renamed from: l  reason: collision with root package name */
    public final TextView f9807l;

    /* renamed from: m  reason: collision with root package name */
    public final TextView f9808m;

    /* renamed from: n  reason: collision with root package name */
    public final TextView f9809n;

    private J0(RelativeLayout relativeLayout, View view, ProgressBar progressBar, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, RecyclerView recyclerView, SwipeRefreshLayout swipeRefreshLayout, Toolbar toolbar, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        this.f9796a = relativeLayout;
        this.f9797b = view;
        this.f9798c = progressBar;
        this.f9799d = relativeLayout2;
        this.f9800e = relativeLayout3;
        this.f9801f = relativeLayout4;
        this.f9802g = recyclerView;
        this.f9803h = swipeRefreshLayout;
        this.f9804i = toolbar;
        this.f9805j = textView;
        this.f9806k = textView2;
        this.f9807l = textView3;
        this.f9808m = textView4;
        this.f9809n = textView5;
    }

    public static J0 a(View view) {
        View view2 = view;
        int i4 = R.id.loading_view_updates;
        View findChildViewById = ViewBindings.findChildViewById(view2, R.id.loading_view_updates);
        if (findChildViewById != null) {
            i4 = R.id.pb_update_all;
            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view2, R.id.pb_update_all);
            if (progressBar != null) {
                i4 = R.id.rl_bottom_box_download_button_updates;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.rl_bottom_box_download_button_updates);
                if (relativeLayout != null) {
                    i4 = R.id.rl_bottom_box_shadow;
                    RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.rl_bottom_box_shadow);
                    if (relativeLayout2 != null) {
                        i4 = R.id.rl_update_all_progress_bottom;
                        RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.rl_update_all_progress_bottom);
                        if (relativeLayout3 != null) {
                            i4 = R.id.rv_updates;
                            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view2, R.id.rv_updates);
                            if (recyclerView != null) {
                                i4 = R.id.srl_updates;
                                SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) ViewBindings.findChildViewById(view2, R.id.srl_updates);
                                if (swipeRefreshLayout != null) {
                                    i4 = R.id.toolbar_updates;
                                    Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view2, R.id.toolbar_updates);
                                    if (toolbar != null) {
                                        i4 = R.id.tv_cancel_update_all;
                                        TextView textView = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_cancel_update_all);
                                        if (textView != null) {
                                            i4 = R.id.tv_description_update_all;
                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_description_update_all);
                                            if (textView2 != null) {
                                                i4 = R.id.tv_install_all_updates;
                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_install_all_updates);
                                                if (textView3 != null) {
                                                    i4 = R.id.tv_title_update_all;
                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_title_update_all);
                                                    if (textView4 != null) {
                                                        i4 = R.id.tv_toolbar_title_updates;
                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_toolbar_title_updates);
                                                        if (textView5 != null) {
                                                            return new J0((RelativeLayout) view2, findChildViewById, progressBar, relativeLayout, relativeLayout2, relativeLayout3, recyclerView, swipeRefreshLayout, toolbar, textView, textView2, textView3, textView4, textView5);
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
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i4)));
    }

    public static J0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static J0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.updates, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f9796a;
    }
}
