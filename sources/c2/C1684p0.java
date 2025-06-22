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

/* renamed from: c2.p0  reason: case insensitive filesystem */
public final class C1684p0 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f10698a;

    /* renamed from: b  reason: collision with root package name */
    public final View f10699b;

    /* renamed from: c  reason: collision with root package name */
    public final RecyclerView f10700c;

    /* renamed from: d  reason: collision with root package name */
    public final Toolbar f10701d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f10702e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f10703f;

    private C1684p0(RelativeLayout relativeLayout, View view, RecyclerView recyclerView, Toolbar toolbar, TextView textView, TextView textView2) {
        this.f10698a = relativeLayout;
        this.f10699b = view;
        this.f10700c = recyclerView;
        this.f10701d = toolbar;
        this.f10702e = textView;
        this.f10703f = textView2;
    }

    public static C1684p0 a(View view) {
        int i4 = R.id.loading_view_public_list;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.loading_view_public_list);
        if (findChildViewById != null) {
            i4 = R.id.rv_public_list;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.rv_public_list);
            if (recyclerView != null) {
                i4 = R.id.toolbar_public_list;
                Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar_public_list);
                if (toolbar != null) {
                    i4 = R.id.tv_no_items_public_list;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_no_items_public_list);
                    if (textView != null) {
                        i4 = R.id.tv_title_public_list;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_title_public_list);
                        if (textView2 != null) {
                            return new C1684p0((RelativeLayout) view, findChildViewById, recyclerView, toolbar, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    public static C1684p0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static C1684p0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.public_list_activity, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f10698a;
    }
}
