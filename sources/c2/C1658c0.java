package c2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

/* renamed from: c2.c0  reason: case insensitive filesystem */
public final class C1658c0 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final FrameLayout f10250a;

    /* renamed from: b  reason: collision with root package name */
    public final FrameLayout f10251b;

    /* renamed from: c  reason: collision with root package name */
    public final View f10252c;

    /* renamed from: d  reason: collision with root package name */
    public final RecyclerView f10253d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f10254e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f10255f;

    private C1658c0(FrameLayout frameLayout, FrameLayout frameLayout2, View view, RecyclerView recyclerView, TextView textView, TextView textView2) {
        this.f10250a = frameLayout;
        this.f10251b = frameLayout2;
        this.f10252c = view;
        this.f10253d = recyclerView;
        this.f10254e = textView;
        this.f10255f = textView2;
    }

    public static C1658c0 a(View view) {
        FrameLayout frameLayout = (FrameLayout) view;
        int i4 = R.id.loading_view_parent_category_fragment;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.loading_view_parent_category_fragment);
        if (findChildViewById != null) {
            i4 = R.id.recycler_view;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.recycler_view);
            if (recyclerView != null) {
                i4 = R.id.tv_no_data_parent_category_fragment;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_no_data_parent_category_fragment);
                if (textView != null) {
                    i4 = R.id.tv_reload_parent_category_fragment;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_reload_parent_category_fragment);
                    if (textView2 != null) {
                        return new C1658c0(frameLayout, frameLayout, findChildViewById, recyclerView, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    public static C1658c0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static C1658c0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.parent_category_fragment, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public FrameLayout getRoot() {
        return this.f10250a;
    }
}
