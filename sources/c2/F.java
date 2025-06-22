package c2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager.widget.ViewPager;
import com.uptodown.R;

public final class F implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f9734a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f9735b;

    /* renamed from: c  reason: collision with root package name */
    public final RelativeLayout f9736c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f9737d;

    /* renamed from: e  reason: collision with root package name */
    public final ViewPager f9738e;

    private F(RelativeLayout relativeLayout, ImageView imageView, RelativeLayout relativeLayout2, TextView textView, ViewPager viewPager) {
        this.f9734a = relativeLayout;
        this.f9735b = imageView;
        this.f9736c = relativeLayout2;
        this.f9737d = textView;
        this.f9738e = viewPager;
    }

    public static F a(View view) {
        int i4 = R.id.iv_back_gallery;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_back_gallery);
        if (imageView != null) {
            i4 = R.id.toolbar_gallery;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.toolbar_gallery);
            if (relativeLayout != null) {
                i4 = R.id.tv_item_count_gallery;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_item_count_gallery);
                if (textView != null) {
                    i4 = R.id.vp_gallery;
                    ViewPager viewPager = (ViewPager) ViewBindings.findChildViewById(view, R.id.vp_gallery);
                    if (viewPager != null) {
                        return new F((RelativeLayout) view, imageView, relativeLayout, textView, viewPager);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    public static F c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static F d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.gallery, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f9734a;
    }
}
