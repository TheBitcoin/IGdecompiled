package c2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

public final class O0 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f9874a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f9875b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f9876c;

    /* renamed from: d  reason: collision with root package name */
    public final RelativeLayout f9877d;

    private O0(RelativeLayout relativeLayout, ImageView imageView, ImageView imageView2, RelativeLayout relativeLayout2) {
        this.f9874a = relativeLayout;
        this.f9875b = imageView;
        this.f9876c = imageView2;
        this.f9877d = relativeLayout2;
    }

    public static O0 a(View view) {
        int i4 = R.id.iv_avatar_item;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_avatar_item);
        if (imageView != null) {
            i4 = R.id.iv_checked_user_avatar;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_checked_user_avatar);
            if (imageView2 != null) {
                i4 = R.id.rl_shadow_avatar_item;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.rl_shadow_avatar_item);
                if (relativeLayout != null) {
                    return new O0((RelativeLayout) view, imageView, imageView2, relativeLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    public static O0 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.user_avatar, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f9874a;
    }
}
