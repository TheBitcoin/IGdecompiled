package c2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

/* renamed from: c2.n0  reason: case insensitive filesystem */
public final class C1680n0 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f10667a;

    /* renamed from: b  reason: collision with root package name */
    public final C1651B f10668b;

    /* renamed from: c  reason: collision with root package name */
    public final LinearLayout f10669c;

    /* renamed from: d  reason: collision with root package name */
    public final View f10670d;

    /* renamed from: e  reason: collision with root package name */
    public final NestedScrollView f10671e;

    /* renamed from: f  reason: collision with root package name */
    public final RecyclerView f10672f;

    /* renamed from: g  reason: collision with root package name */
    public final Toolbar f10673g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f10674h;

    /* renamed from: i  reason: collision with root package name */
    public final TextView f10675i;

    /* renamed from: j  reason: collision with root package name */
    public final TextView f10676j;

    private C1680n0(RelativeLayout relativeLayout, C1651B b5, LinearLayout linearLayout, View view, NestedScrollView nestedScrollView, RecyclerView recyclerView, Toolbar toolbar, TextView textView, TextView textView2, TextView textView3) {
        this.f10667a = relativeLayout;
        this.f10668b = b5;
        this.f10669c = linearLayout;
        this.f10670d = view;
        this.f10671e = nestedScrollView;
        this.f10672f = recyclerView;
        this.f10673g = toolbar;
        this.f10674h = textView;
        this.f10675i = textView2;
        this.f10676j = textView3;
    }

    public static C1680n0 a(View view) {
        int i4 = R.id.ll_order_upcoming_releases;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.ll_order_upcoming_releases);
        if (findChildViewById != null) {
            C1651B a5 = C1651B.a(findChildViewById);
            i4 = R.id.ll_upcoming_releases;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.ll_upcoming_releases);
            if (linearLayout != null) {
                i4 = R.id.loading_view_upcoming_releases;
                View findChildViewById2 = ViewBindings.findChildViewById(view, R.id.loading_view_upcoming_releases);
                if (findChildViewById2 != null) {
                    i4 = R.id.nsv_upcoming_releases;
                    NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(view, R.id.nsv_upcoming_releases);
                    if (nestedScrollView != null) {
                        i4 = R.id.rv_upcoming_releases;
                        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.rv_upcoming_releases);
                        if (recyclerView != null) {
                            i4 = R.id.toolbar_upcoming_releases;
                            Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar_upcoming_releases);
                            if (toolbar != null) {
                                i4 = R.id.tv_discover_upcoming_releases;
                                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_discover_upcoming_releases);
                                if (textView != null) {
                                    i4 = R.id.tv_no_items_upcoming_releases;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_no_items_upcoming_releases);
                                    if (textView2 != null) {
                                        i4 = R.id.tv_title_upcoming_releases;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_title_upcoming_releases);
                                        if (textView3 != null) {
                                            return new C1680n0((RelativeLayout) view, a5, linearLayout, findChildViewById2, nestedScrollView, recyclerView, toolbar, textView, textView2, textView3);
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

    public static C1680n0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static C1680n0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.preregistration_activity, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f10667a;
    }
}
