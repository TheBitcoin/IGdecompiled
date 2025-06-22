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

/* renamed from: c2.y  reason: case insensitive filesystem */
public final class C1700y implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f10875a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f10876b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f10877c;

    /* renamed from: d  reason: collision with root package name */
    public final RelativeLayout f10878d;

    /* renamed from: e  reason: collision with root package name */
    public final RelativeLayout f10879e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f10880f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f10881g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f10882h;

    private C1700y(LinearLayout linearLayout, ImageView imageView, ImageView imageView2, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, TextView textView, TextView textView2, TextView textView3) {
        this.f10875a = linearLayout;
        this.f10876b = imageView;
        this.f10877c = imageView2;
        this.f10878d = relativeLayout;
        this.f10879e = relativeLayout2;
        this.f10880f = textView;
        this.f10881g = textView2;
        this.f10882h = textView3;
    }

    public static C1700y a(View view) {
        int i4 = R.id.iv_recommended_option;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_recommended_option);
        if (imageView != null) {
            i4 = R.id.iv_wishlist_option;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_wishlist_option);
            if (imageView2 != null) {
                i4 = R.id.ll_recommended_option;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.ll_recommended_option);
                if (relativeLayout != null) {
                    i4 = R.id.ll_wishlist_option;
                    RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.ll_wishlist_option);
                    if (relativeLayout2 != null) {
                        i4 = R.id.tv_recommended_option;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_recommended_option);
                        if (textView != null) {
                            i4 = R.id.tv_title_dialog_rename;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_title_dialog_rename);
                            if (textView2 != null) {
                                i4 = R.id.tv_wishlist_option;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_wishlist_option);
                                if (textView3 != null) {
                                    return new C1700y((LinearLayout) view, imageView, imageView2, relativeLayout, relativeLayout2, textView, textView2, textView3);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    public static C1700y c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static C1700y d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.dialog_user_list_selector, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f10875a;
    }
}
