package c2;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;
import com.uptodown.views.InstantAutoCompleteTextView;

public final class B0 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f9697a;

    /* renamed from: b  reason: collision with root package name */
    public final InstantAutoCompleteTextView f9698b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f9699c;

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f9700d;

    /* renamed from: e  reason: collision with root package name */
    public final ImageView f9701e;

    /* renamed from: f  reason: collision with root package name */
    public final RelativeLayout f9702f;

    private B0(RelativeLayout relativeLayout, InstantAutoCompleteTextView instantAutoCompleteTextView, ImageView imageView, ImageView imageView2, ImageView imageView3, RelativeLayout relativeLayout2) {
        this.f9697a = relativeLayout;
        this.f9698b = instantAutoCompleteTextView;
        this.f9699c = imageView;
        this.f9700d = imageView2;
        this.f9701e = imageView3;
        this.f9702f = relativeLayout2;
    }

    public static B0 a(View view) {
        int i4 = R.id.actv_search_bar;
        InstantAutoCompleteTextView instantAutoCompleteTextView = (InstantAutoCompleteTextView) ViewBindings.findChildViewById(view, R.id.actv_search_bar);
        if (instantAutoCompleteTextView != null) {
            i4 = R.id.iv_back_search_bar;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_back_search_bar);
            if (imageView != null) {
                i4 = R.id.iv_delete_search_bar;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_delete_search_bar);
                if (imageView2 != null) {
                    i4 = R.id.iv_voice_search_bar;
                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_voice_search_bar);
                    if (imageView3 != null) {
                        i4 = R.id.rl_options_search_bar;
                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.rl_options_search_bar);
                        if (relativeLayout != null) {
                            return new B0((RelativeLayout) view, instantAutoCompleteTextView, imageView, imageView2, imageView3, relativeLayout);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f9697a;
    }
}
