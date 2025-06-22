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

public final class T0 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f10031a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f10032b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f10033c;

    /* renamed from: d  reason: collision with root package name */
    public final LinearLayout f10034d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f10035e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f10036f;

    private T0(RelativeLayout relativeLayout, ImageView imageView, ImageView imageView2, LinearLayout linearLayout, TextView textView, TextView textView2) {
        this.f10031a = relativeLayout;
        this.f10032b = imageView;
        this.f10033c = imageView2;
        this.f10034d = linearLayout;
        this.f10035e = textView;
        this.f10036f = textView2;
    }

    public static T0 a(View view) {
        int i4 = R.id.iv_device_user_device_item;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_device_user_device_item);
        if (imageView != null) {
            i4 = R.id.iv_enter_user_device_item;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_enter_user_device_item);
            if (imageView2 != null) {
                i4 = R.id.ll_info_user_device_item;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.ll_info_user_device_item);
                if (linearLayout != null) {
                    i4 = R.id.tv_last_update_user_device_item;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_last_update_user_device_item);
                    if (textView != null) {
                        i4 = R.id.tv_name_user_device_item;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_name_user_device_item);
                        if (textView2 != null) {
                            return new T0((RelativeLayout) view, imageView, imageView2, linearLayout, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    public static T0 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.user_device_item, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f10031a;
    }
}
