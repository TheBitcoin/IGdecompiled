package c2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

public final class R0 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f9981a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f9982b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f9983c;

    /* renamed from: d  reason: collision with root package name */
    public final LinearLayout f9984d;

    /* renamed from: e  reason: collision with root package name */
    public final RelativeLayout f9985e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f9986f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f9987g;

    private R0(RelativeLayout relativeLayout, ImageView imageView, ImageView imageView2, LinearLayout linearLayout, RelativeLayout relativeLayout2, TextView textView, TextView textView2) {
        this.f9981a = relativeLayout;
        this.f9982b = imageView;
        this.f9983c = imageView2;
        this.f9984d = linearLayout;
        this.f9985e = relativeLayout2;
        this.f9986f = textView;
        this.f9987g = textView2;
    }

    public static R0 a(View view) {
        int i4 = R.id.iv_action_user_device_app_item;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_action_user_device_app_item);
        if (imageView != null) {
            i4 = R.id.iv_icon_user_device_app_item;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_icon_user_device_app_item);
            if (imageView2 != null) {
                i4 = R.id.ll_info_user_device_app_item;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.ll_info_user_device_app_item);
                if (linearLayout != null) {
                    i4 = R.id.rl_container_user_device_app_item;
                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.rl_container_user_device_app_item);
                    if (relativeLayout != null) {
                        i4 = R.id.tv_last_update_user_device_app_item;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_last_update_user_device_app_item);
                        if (textView != null) {
                            i4 = R.id.tv_name_user_device_app_item;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_name_user_device_app_item);
                            if (textView2 != null) {
                                return new R0((RelativeLayout) view, imageView, imageView2, linearLayout, relativeLayout, textView, textView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    public static R0 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.user_device_app_item, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f9981a;
    }
}
