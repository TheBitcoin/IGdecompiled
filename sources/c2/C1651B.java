package c2;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

/* renamed from: c2.B  reason: case insensitive filesystem */
public final class C1651B implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f9693a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f9694b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f9695c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f9696d;

    private C1651B(LinearLayout linearLayout, ImageView imageView, TextView textView, TextView textView2) {
        this.f9693a = linearLayout;
        this.f9694b = imageView;
        this.f9695c = textView;
        this.f9696d = textView2;
    }

    public static C1651B a(View view) {
        int i4 = R.id.iv_version_details_update_item;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_version_details_update_item);
        if (imageView != null) {
            i4 = R.id.tv_order_label_selector;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_order_label_selector);
            if (textView != null) {
                i4 = R.id.tv_order_selector;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_order_selector);
                if (textView2 != null) {
                    return new C1651B((LinearLayout) view, imageView, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f9693a;
    }
}
