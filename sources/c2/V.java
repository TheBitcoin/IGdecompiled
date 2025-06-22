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

public final class V implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f10052a;

    /* renamed from: b  reason: collision with root package name */
    public final View f10053b;

    /* renamed from: c  reason: collision with root package name */
    public final RecyclerView f10054c;

    /* renamed from: d  reason: collision with root package name */
    public final Toolbar f10055d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f10056e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f10057f;

    private V(RelativeLayout relativeLayout, View view, RecyclerView recyclerView, Toolbar toolbar, TextView textView, TextView textView2) {
        this.f10052a = relativeLayout;
        this.f10053b = view;
        this.f10054c = recyclerView;
        this.f10055d = toolbar;
        this.f10056e = textView;
        this.f10057f = textView2;
    }

    public static V a(View view) {
        int i4 = R.id.loading_view_notification_registry;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.loading_view_notification_registry);
        if (findChildViewById != null) {
            i4 = R.id.rv_notifications_registry;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.rv_notifications_registry);
            if (recyclerView != null) {
                i4 = R.id.toolbar_notifications_registry;
                Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar_notifications_registry);
                if (toolbar != null) {
                    i4 = R.id.tv_no_data_notifications_registry;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_no_data_notifications_registry);
                    if (textView != null) {
                        i4 = R.id.tv_title_notifications_registry;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_title_notifications_registry);
                        if (textView2 != null) {
                            return new V((RelativeLayout) view, findChildViewById, recyclerView, toolbar, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    public static V c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static V d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.notifications_registry_activity, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f10052a;
    }
}
