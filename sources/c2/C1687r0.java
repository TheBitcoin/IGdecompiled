package c2;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

/* renamed from: c2.r0  reason: case insensitive filesystem */
public final class C1687r0 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f10736a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f10737b;

    /* renamed from: c  reason: collision with root package name */
    public final RelativeLayout f10738c;

    /* renamed from: d  reason: collision with root package name */
    public final RelativeLayout f10739d;

    /* renamed from: e  reason: collision with root package name */
    public final RecyclerView f10740e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f10741f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f10742g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f10743h;

    private C1687r0(LinearLayout linearLayout, ImageView imageView, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, RecyclerView recyclerView, TextView textView, TextView textView2, TextView textView3) {
        this.f10736a = linearLayout;
        this.f10737b = imageView;
        this.f10738c = relativeLayout;
        this.f10739d = relativeLayout2;
        this.f10740e = recyclerView;
        this.f10741f = textView;
        this.f10742g = textView2;
        this.f10743h = textView3;
    }

    public static C1687r0 a(View view) {
        int i4 = R.id.iv_more_public_profile_top;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_more_public_profile_top);
        if (imageView != null) {
            i4 = R.id.rl_no_items_public_profile_top;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.rl_no_items_public_profile_top);
            if (relativeLayout != null) {
                i4 = R.id.rl_title_public_profile_top;
                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.rl_title_public_profile_top);
                if (relativeLayout2 != null) {
                    i4 = R.id.rv_public_profile_top;
                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.rv_public_profile_top);
                    if (recyclerView != null) {
                        i4 = R.id.tv_explore_public_profile_top;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_explore_public_profile_top);
                        if (textView != null) {
                            i4 = R.id.tv_no_items_public_profile_top;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_no_items_public_profile_top);
                            if (textView2 != null) {
                                i4 = R.id.tv_title_public_profile_top;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_title_public_profile_top);
                                if (textView3 != null) {
                                    return new C1687r0((LinearLayout) view, imageView, relativeLayout, relativeLayout2, recyclerView, textView, textView2, textView3);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f10736a;
    }
}
