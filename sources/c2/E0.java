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

public final class E0 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f9726a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f9727b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f9728c;

    /* renamed from: d  reason: collision with root package name */
    public final LinearLayout f9729d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f9730e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f9731f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f9732g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f9733h;

    private E0(RelativeLayout relativeLayout, ImageView imageView, ImageView imageView2, LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.f9726a = relativeLayout;
        this.f9727b = imageView;
        this.f9728c = imageView2;
        this.f9729d = linearLayout;
        this.f9730e = textView;
        this.f9731f = textView2;
        this.f9732g = textView3;
        this.f9733h = textView4;
    }

    public static E0 a(View view) {
        int i4 = R.id.iv_background_sign_in_popup;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_background_sign_in_popup);
        if (imageView != null) {
            i4 = R.id.iv_close_sign_in_popup;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_close_sign_in_popup);
            if (imageView2 != null) {
                i4 = R.id.ll_content_sign_in_popup;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.ll_content_sign_in_popup);
                if (linearLayout != null) {
                    i4 = R.id.tv_continue_sign_in_popup;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_continue_sign_in_popup);
                    if (textView != null) {
                        i4 = R.id.tv_description_sign_in_popup;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_description_sign_in_popup);
                        if (textView2 != null) {
                            i4 = R.id.tv_footer_sign_in_popup;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_footer_sign_in_popup);
                            if (textView3 != null) {
                                i4 = R.id.tv_title_sign_in_popup;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_title_sign_in_popup);
                                if (textView4 != null) {
                                    return new E0((RelativeLayout) view, imageView, imageView2, linearLayout, textView, textView2, textView3, textView4);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    public static E0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static E0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.sign_in_popup, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f9726a;
    }
}
