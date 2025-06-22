package c2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

public final class A0 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f9688a;

    /* renamed from: b  reason: collision with root package name */
    public final B0 f9689b;

    /* renamed from: c  reason: collision with root package name */
    public final View f9690c;

    /* renamed from: d  reason: collision with root package name */
    public final RecyclerView f9691d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f9692e;

    private A0(RelativeLayout relativeLayout, B0 b02, View view, RecyclerView recyclerView, TextView textView) {
        this.f9688a = relativeLayout;
        this.f9689b = b02;
        this.f9690c = view;
        this.f9691d = recyclerView;
        this.f9692e = textView;
    }

    public static A0 a(View view) {
        int i4 = R.id.include_search_bar;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.include_search_bar);
        if (findChildViewById != null) {
            B0 a5 = B0.a(findChildViewById);
            i4 = R.id.loading_view_search;
            View findChildViewById2 = ViewBindings.findChildViewById(view, R.id.loading_view_search);
            if (findChildViewById2 != null) {
                i4 = R.id.rv_search_activity;
                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.rv_search_activity);
                if (recyclerView != null) {
                    i4 = R.id.tv_msg_search_activity;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_msg_search_activity);
                    if (textView != null) {
                        return new A0((RelativeLayout) view, a5, findChildViewById2, recyclerView, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    public static A0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static A0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.search_activity, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f9688a;
    }
}
