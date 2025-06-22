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

public final class Q0 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f9975a;

    /* renamed from: b  reason: collision with root package name */
    public final View f9976b;

    /* renamed from: c  reason: collision with root package name */
    public final RecyclerView f9977c;

    /* renamed from: d  reason: collision with root package name */
    public final Toolbar f9978d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f9979e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f9980f;

    private Q0(RelativeLayout relativeLayout, View view, RecyclerView recyclerView, Toolbar toolbar, TextView textView, TextView textView2) {
        this.f9975a = relativeLayout;
        this.f9976b = view;
        this.f9977c = recyclerView;
        this.f9978d = toolbar;
        this.f9979e = textView;
        this.f9980f = textView2;
    }

    public static Q0 a(View view) {
        int i4 = R.id.loading_view_user_comments;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.loading_view_user_comments);
        if (findChildViewById != null) {
            i4 = R.id.rv_user_comments;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.rv_user_comments);
            if (recyclerView != null) {
                i4 = R.id.toolbar_user_comments;
                Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar_user_comments);
                if (toolbar != null) {
                    i4 = R.id.tv_error_user_comments;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_error_user_comments);
                    if (textView != null) {
                        i4 = R.id.tv_toolbar_title_user_comments;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_toolbar_title_user_comments);
                        if (textView2 != null) {
                            return new Q0((RelativeLayout) view, findChildViewById, recyclerView, toolbar, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    public static Q0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static Q0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.user_comments_activity, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f9975a;
    }
}
