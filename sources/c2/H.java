package c2;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

public final class H implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f9761a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f9762b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f9763c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f9764d;

    private H(RelativeLayout relativeLayout, ImageView imageView, TextView textView, TextView textView2) {
        this.f9761a = relativeLayout;
        this.f9762b = imageView;
        this.f9763c = textView;
        this.f9764d = textView2;
    }

    public static H a(View view) {
        int i4 = R.id.iv_logo_app;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_logo_app);
        if (imageView != null) {
            i4 = R.id.tv_app_name;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_app_name);
            if (textView != null) {
                i4 = R.id.tv_app_version;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_app_version);
                if (textView2 != null) {
                    return new H((RelativeLayout) view, imageView, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f9761a;
    }
}
