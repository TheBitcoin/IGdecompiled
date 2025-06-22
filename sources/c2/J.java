package c2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

public final class J implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final FrameLayout f9789a;

    /* renamed from: b  reason: collision with root package name */
    public final FrameLayout f9790b;

    /* renamed from: c  reason: collision with root package name */
    public final LinearLayout f9791c;

    /* renamed from: d  reason: collision with root package name */
    public final View f9792d;

    /* renamed from: e  reason: collision with root package name */
    public final RecyclerView f9793e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f9794f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f9795g;

    private J(FrameLayout frameLayout, FrameLayout frameLayout2, LinearLayout linearLayout, View view, RecyclerView recyclerView, TextView textView, TextView textView2) {
        this.f9789a = frameLayout;
        this.f9790b = frameLayout2;
        this.f9791c = linearLayout;
        this.f9792d = view;
        this.f9793e = recyclerView;
        this.f9794f = textView;
        this.f9795g = textView2;
    }

    public static J a(View view) {
        FrameLayout frameLayout = (FrameLayout) view;
        int i4 = R.id.ll_no_data_home_fragment;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.ll_no_data_home_fragment);
        if (linearLayout != null) {
            i4 = R.id.loading_view_home_fragment;
            View findChildViewById = ViewBindings.findChildViewById(view, R.id.loading_view_home_fragment);
            if (findChildViewById != null) {
                i4 = R.id.recycler_view_home;
                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.recycler_view_home);
                if (recyclerView != null) {
                    i4 = R.id.tv_no_data_home_fragment;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_no_data_home_fragment);
                    if (textView != null) {
                        i4 = R.id.tv_reload_home_fragment;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_reload_home_fragment);
                        if (textView2 != null) {
                            return new J(frameLayout, frameLayout, linearLayout, findChildViewById, recyclerView, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    public static J c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static J d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.home_fragment, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public FrameLayout getRoot() {
        return this.f9789a;
    }
}
