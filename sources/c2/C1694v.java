package c2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

/* renamed from: c2.v  reason: case insensitive filesystem */
public final class C1694v implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f10795a;

    /* renamed from: b  reason: collision with root package name */
    public final LinearLayout f10796b;

    /* renamed from: c  reason: collision with root package name */
    public final EditText f10797c;

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f10798d;

    /* renamed from: e  reason: collision with root package name */
    public final ImageView f10799e;

    /* renamed from: f  reason: collision with root package name */
    public final ImageView f10800f;

    /* renamed from: g  reason: collision with root package name */
    public final ImageView f10801g;

    /* renamed from: h  reason: collision with root package name */
    public final ImageView f10802h;

    /* renamed from: i  reason: collision with root package name */
    public final ImageView f10803i;

    /* renamed from: j  reason: collision with root package name */
    public final TextView f10804j;

    /* renamed from: k  reason: collision with root package name */
    public final TextView f10805k;

    /* renamed from: l  reason: collision with root package name */
    public final TextView f10806l;

    private C1694v(LinearLayout linearLayout, LinearLayout linearLayout2, EditText editText, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, TextView textView, TextView textView2, TextView textView3) {
        this.f10795a = linearLayout;
        this.f10796b = linearLayout2;
        this.f10797c = editText;
        this.f10798d = imageView;
        this.f10799e = imageView2;
        this.f10800f = imageView3;
        this.f10801g = imageView4;
        this.f10802h = imageView5;
        this.f10803i = imageView6;
        this.f10804j = textView;
        this.f10805k = textView2;
        this.f10806l = textView3;
    }

    public static C1694v a(View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        int i4 = R.id.et_review;
        EditText editText = (EditText) ViewBindings.findChildViewById(view, R.id.et_review);
        if (editText != null) {
            i4 = R.id.iv_avatar_dialog_review;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_avatar_dialog_review);
            if (imageView != null) {
                i4 = R.id.iv_star1_dialog_review;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_star1_dialog_review);
                if (imageView2 != null) {
                    i4 = R.id.iv_star2_dialog_review;
                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_star2_dialog_review);
                    if (imageView3 != null) {
                        i4 = R.id.iv_star3_dialog_review;
                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_star3_dialog_review);
                        if (imageView4 != null) {
                            i4 = R.id.iv_star4_dialog_review;
                            ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_star4_dialog_review);
                            if (imageView5 != null) {
                                i4 = R.id.iv_star5_dialog_review;
                                ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_star5_dialog_review);
                                if (imageView6 != null) {
                                    i4 = R.id.tv_app_name_dialog_review;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_app_name_dialog_review);
                                    if (textView != null) {
                                        i4 = R.id.tv_cancel;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_cancel);
                                        if (textView2 != null) {
                                            i4 = R.id.tv_ok;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_ok);
                                            if (textView3 != null) {
                                                return new C1694v(linearLayout, linearLayout, editText, imageView, imageView2, imageView3, imageView4, imageView5, imageView6, textView, textView2, textView3);
                                            }
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

    public static C1694v c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static C1694v d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.dialog_review_stars, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f10795a;
    }
}
