package c2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

public final class Z0 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f10180a;

    /* renamed from: b  reason: collision with root package name */
    public final CheckBox f10181b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f10182c;

    /* renamed from: d  reason: collision with root package name */
    public final LinearLayout f10183d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f10184e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f10185f;

    private Z0(RelativeLayout relativeLayout, CheckBox checkBox, ImageView imageView, LinearLayout linearLayout, TextView textView, TextView textView2) {
        this.f10180a = relativeLayout;
        this.f10181b = checkBox;
        this.f10182c = imageView;
        this.f10183d = linearLayout;
        this.f10184e = textView;
        this.f10185f = textView2;
    }

    public static Z0 a(View view) {
        int i4 = R.id.cb_remote_install_device_item;
        CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.cb_remote_install_device_item);
        if (checkBox != null) {
            i4 = R.id.iv_remote_install_device_item;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_remote_install_device_item);
            if (imageView != null) {
                i4 = R.id.ll_remote_install_device_item;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.ll_remote_install_device_item);
                if (linearLayout != null) {
                    i4 = R.id.tv_remote_install_device_name_item;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_remote_install_device_name_item);
                    if (textView != null) {
                        i4 = R.id.tv_remote_install_status_item;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_remote_install_status_item);
                        if (textView2 != null) {
                            return new Z0((RelativeLayout) view, checkBox, imageView, linearLayout, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    public static Z0 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.user_remote_install_device_item, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f10180a;
    }
}
