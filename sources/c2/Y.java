package c2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

public final class Y implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f10160a;

    /* renamed from: b  reason: collision with root package name */
    public final RecyclerView f10161b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f10162c;

    private Y(LinearLayout linearLayout, RecyclerView recyclerView, TextView textView) {
        this.f10160a = linearLayout;
        this.f10161b = recyclerView;
        this.f10162c = textView;
    }

    public static Y a(View view) {
        int i4 = R.id.rv_most_popular_apps_organization;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.rv_most_popular_apps_organization);
        if (recyclerView != null) {
            i4 = R.id.tv_most_popular_apps_organization;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_most_popular_apps_organization);
            if (textView != null) {
                return new Y((LinearLayout) view, recyclerView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    public static Y c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.organization_carousel_apps_rv, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f10160a;
    }
}
