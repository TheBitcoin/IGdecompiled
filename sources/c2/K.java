package c2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

public final class K implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f9810a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f9811b;

    /* renamed from: c  reason: collision with root package name */
    public final RelativeLayout f9812c;

    /* renamed from: d  reason: collision with root package name */
    public final RecyclerView f9813d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f9814e;

    private K(LinearLayout linearLayout, ImageView imageView, RelativeLayout relativeLayout, RecyclerView recyclerView, TextView textView) {
        this.f9810a = linearLayout;
        this.f9811b = imageView;
        this.f9812c = relativeLayout;
        this.f9813d = recyclerView;
        this.f9814e = textView;
    }

    public static K a(View view) {
        int i4 = R.id.iv_more_home_recycler_view_top;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_more_home_recycler_view_top);
        if (imageView != null) {
            i4 = R.id.rl_title_home_recycler_view_top;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.rl_title_home_recycler_view_top);
            if (relativeLayout != null) {
                i4 = R.id.rv_home_recycler_view_top;
                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.rv_home_recycler_view_top);
                if (recyclerView != null) {
                    i4 = R.id.tv_title_home_recycler_view_top;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_title_home_recycler_view_top);
                    if (textView != null) {
                        return new K((LinearLayout) view, imageView, relativeLayout, recyclerView, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    public static K c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static K d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.home_recycler_view_top, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f9810a;
    }
}
