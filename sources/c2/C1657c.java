package c2;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

/* renamed from: c2.c  reason: case insensitive filesystem */
public final class C1657c implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f10243a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f10244b;

    /* renamed from: c  reason: collision with root package name */
    public final RelativeLayout f10245c;

    /* renamed from: d  reason: collision with root package name */
    public final RelativeLayout f10246d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f10247e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f10248f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f10249g;

    private C1657c(RelativeLayout relativeLayout, ImageView imageView, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, TextView textView, TextView textView2, TextView textView3) {
        this.f10243a = relativeLayout;
        this.f10244b = imageView;
        this.f10245c = relativeLayout2;
        this.f10246d = relativeLayout3;
        this.f10247e = textView;
        this.f10248f = textView2;
        this.f10249g = textView3;
    }

    public static C1657c a(View view) {
        int i4 = R.id.iv_icon_affiliated;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_icon_affiliated);
        if (imageView != null) {
            i4 = R.id.rl_container_affiliated;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.rl_container_affiliated);
            if (relativeLayout != null) {
                i4 = R.id.rl_container_stroke_affiliated;
                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.rl_container_stroke_affiliated);
                if (relativeLayout2 != null) {
                    i4 = R.id.tv_button_affiliated;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_button_affiliated);
                    if (textView != null) {
                        i4 = R.id.tv_description_affiliated;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_description_affiliated);
                        if (textView2 != null) {
                            i4 = R.id.tv_title_affiliated;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_title_affiliated);
                            if (textView3 != null) {
                                return new C1657c((RelativeLayout) view, imageView, relativeLayout, relativeLayout2, textView, textView2, textView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f10243a;
    }
}
