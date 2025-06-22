package c2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

public final class K0 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f9815a;

    /* renamed from: b  reason: collision with root package name */
    public final RecyclerView f9816b;

    private K0(LinearLayout linearLayout, RecyclerView recyclerView) {
        this.f9815a = linearLayout;
        this.f9816b = recyclerView;
    }

    public static K0 a(View view) {
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.recycler_view);
        if (recyclerView != null) {
            return new K0((LinearLayout) view, recyclerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.recycler_view)));
    }

    public static K0 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.uptodown_dropdown_menu, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f9815a;
    }
}
