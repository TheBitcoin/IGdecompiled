package c2;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

public final class b1 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f10233a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f10234b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f10235c;

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f10236d;

    /* renamed from: e  reason: collision with root package name */
    public final ImageView f10237e;

    /* renamed from: f  reason: collision with root package name */
    public final ImageView f10238f;

    /* renamed from: g  reason: collision with root package name */
    public final ImageView f10239g;

    /* renamed from: h  reason: collision with root package name */
    public final LinearLayout f10240h;

    /* renamed from: i  reason: collision with root package name */
    public final TextView f10241i;

    /* renamed from: j  reason: collision with root package name */
    public final TextView f10242j;

    private b1(LinearLayout linearLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, LinearLayout linearLayout2, TextView textView, TextView textView2) {
        this.f10233a = linearLayout;
        this.f10234b = imageView;
        this.f10235c = imageView2;
        this.f10236d = imageView3;
        this.f10237e = imageView4;
        this.f10238f = imageView5;
        this.f10239g = imageView6;
        this.f10240h = linearLayout2;
        this.f10241i = textView;
        this.f10242j = textView2;
    }

    public static b1 a(View view) {
        int i4 = R.id.iv_star1_valoration;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_star1_valoration);
        if (imageView != null) {
            i4 = R.id.iv_star2_valoration;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_star2_valoration);
            if (imageView2 != null) {
                i4 = R.id.iv_star3_valoration;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_star3_valoration);
                if (imageView3 != null) {
                    i4 = R.id.iv_star4_valoration;
                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_star4_valoration);
                    if (imageView4 != null) {
                        i4 = R.id.iv_star5_valoration;
                        ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_star5_valoration);
                        if (imageView5 != null) {
                            i4 = R.id.iv_user_valoration;
                            ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_user_valoration);
                            if (imageView6 != null) {
                                i4 = R.id.ll_your_valoration;
                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.ll_your_valoration);
                                if (linearLayout != null) {
                                    i4 = R.id.tv_write_review_app_detail;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_write_review_app_detail);
                                    if (textView != null) {
                                        i4 = R.id.tv_your_valoration;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_your_valoration);
                                        if (textView2 != null) {
                                            return new b1((LinearLayout) view, imageView, imageView2, imageView3, imageView4, imageView5, imageView6, linearLayout, textView, textView2);
                                        }
                                    }
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
        return this.f10233a;
    }
}
