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

public final class W implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f10070a;

    /* renamed from: b  reason: collision with root package name */
    public final View f10071b;

    /* renamed from: c  reason: collision with root package name */
    public final RecyclerView f10072c;

    /* renamed from: d  reason: collision with root package name */
    public final Toolbar f10073d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f10074e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f10075f;

    private W(RelativeLayout relativeLayout, View view, RecyclerView recyclerView, Toolbar toolbar, TextView textView, TextView textView2) {
        this.f10070a = relativeLayout;
        this.f10071b = view;
        this.f10072c = recyclerView;
        this.f10073d = toolbar;
        this.f10074e = textView;
        this.f10075f = textView2;
    }

    public static W a(View view) {
        int i4 = R.id.loading_view_old_versions;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.loading_view_old_versions);
        if (findChildViewById != null) {
            i4 = R.id.rv_old_versions;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.rv_old_versions);
            if (recyclerView != null) {
                i4 = R.id.toolbar_old_versions;
                Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar_old_versions);
                if (toolbar != null) {
                    i4 = R.id.tv_no_data_old_version;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_no_data_old_version);
                    if (textView != null) {
                        i4 = R.id.tv_toolbar_old_versions;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_toolbar_old_versions);
                        if (textView2 != null) {
                            return new W((RelativeLayout) view, findChildViewById, recyclerView, toolbar, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    public static W c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static W d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.old_versions_activity, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f10070a;
    }
}
