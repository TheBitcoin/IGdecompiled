package c2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

/* renamed from: c2.a0  reason: case insensitive filesystem */
public final class C1654a0 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f10190a;

    /* renamed from: b  reason: collision with root package name */
    public final RecyclerView f10191b;

    private C1654a0(LinearLayout linearLayout, RecyclerView recyclerView) {
        this.f10190a = linearLayout;
        this.f10191b = recyclerView;
    }

    public static C1654a0 a(View view) {
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.rv_top_downloads_organization);
        if (recyclerView != null) {
            return new C1654a0((LinearLayout) view, recyclerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.rv_top_downloads_organization)));
    }

    public static C1654a0 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.organization_top_download_rv, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f10190a;
    }
}
