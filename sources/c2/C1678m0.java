package c2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

/* renamed from: c2.m0  reason: case insensitive filesystem */
public final class C1678m0 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f10654a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f10655b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f10656c;

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f10657d;

    /* renamed from: e  reason: collision with root package name */
    public final ImageView f10658e;

    /* renamed from: f  reason: collision with root package name */
    public final ImageView f10659f;

    /* renamed from: g  reason: collision with root package name */
    public final ImageView f10660g;

    private C1678m0(LinearLayout linearLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6) {
        this.f10654a = linearLayout;
        this.f10655b = imageView;
        this.f10656c = imageView2;
        this.f10657d = imageView3;
        this.f10658e = imageView4;
        this.f10659f = imageView5;
        this.f10660g = imageView6;
    }

    public static C1678m0 a(View view) {
        int i4 = R.id.iv_facebook_preferences;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_facebook_preferences);
        if (imageView != null) {
            i4 = R.id.iv_instagram_preferences;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_instagram_preferences);
            if (imageView2 != null) {
                i4 = R.id.iv_linkedin_preferences;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_linkedin_preferences);
                if (imageView3 != null) {
                    i4 = R.id.iv_tiktok_preferences;
                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_tiktok_preferences);
                    if (imageView4 != null) {
                        i4 = R.id.iv_x_preferences;
                        ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_x_preferences);
                        if (imageView5 != null) {
                            i4 = R.id.iv_youtube_preferences;
                            ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_youtube_preferences);
                            if (imageView6 != null) {
                                return new C1678m0((LinearLayout) view, imageView, imageView2, imageView3, imageView4, imageView5, imageView6);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    public static C1678m0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static C1678m0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.preferences_socials, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f10654a;
    }
}
