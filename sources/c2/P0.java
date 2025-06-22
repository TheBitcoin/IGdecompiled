package c2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

public final class P0 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f9889a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f9890b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f9891c;

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f9892d;

    /* renamed from: e  reason: collision with root package name */
    public final RelativeLayout f9893e;

    private P0(RelativeLayout relativeLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, RelativeLayout relativeLayout2) {
        this.f9889a = relativeLayout;
        this.f9890b = imageView;
        this.f9891c = imageView2;
        this.f9892d = imageView3;
        this.f9893e = relativeLayout2;
    }

    public static P0 a(View view) {
        int i4 = R.id.iv_avatar_item;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_avatar_item);
        if (imageView != null) {
            i4 = R.id.iv_checked_user_avatar;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_checked_user_avatar);
            if (imageView2 != null) {
                i4 = R.id.iv_locked_item;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_locked_item);
                if (imageView3 != null) {
                    i4 = R.id.rl_shadow_avatar_item;
                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.rl_shadow_avatar_item);
                    if (relativeLayout != null) {
                        return new P0((RelativeLayout) view, imageView, imageView2, imageView3, relativeLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    public static P0 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.user_avatar_turbo, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f9889a;
    }
}
