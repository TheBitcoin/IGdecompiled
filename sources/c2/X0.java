package c2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

public final class X0 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f10142a;

    /* renamed from: b  reason: collision with root package name */
    public final HorizontalScrollView f10143b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f10144c;

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f10145d;

    /* renamed from: e  reason: collision with root package name */
    public final ImageView f10146e;

    /* renamed from: f  reason: collision with root package name */
    public final LinearLayout f10147f;

    /* renamed from: g  reason: collision with root package name */
    public final LinearLayout f10148g;

    /* renamed from: h  reason: collision with root package name */
    public final ProgressBar f10149h;

    /* renamed from: i  reason: collision with root package name */
    public final RelativeLayout f10150i;

    /* renamed from: j  reason: collision with root package name */
    public final RelativeLayout f10151j;

    /* renamed from: k  reason: collision with root package name */
    public final RelativeLayout f10152k;

    /* renamed from: l  reason: collision with root package name */
    public final RelativeLayout f10153l;

    /* renamed from: m  reason: collision with root package name */
    public final TextView f10154m;

    /* renamed from: n  reason: collision with root package name */
    public final TextView f10155n;

    /* renamed from: o  reason: collision with root package name */
    public final TextView f10156o;

    /* renamed from: p  reason: collision with root package name */
    public final TextView f10157p;

    /* renamed from: q  reason: collision with root package name */
    public final Y0 f10158q;

    /* renamed from: r  reason: collision with root package name */
    public final View f10159r;

    private X0(RelativeLayout relativeLayout, HorizontalScrollView horizontalScrollView, ImageView imageView, ImageView imageView2, ImageView imageView3, LinearLayout linearLayout, LinearLayout linearLayout2, ProgressBar progressBar, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, RelativeLayout relativeLayout5, TextView textView, TextView textView2, TextView textView3, TextView textView4, Y0 y02, View view) {
        this.f10142a = relativeLayout;
        this.f10143b = horizontalScrollView;
        this.f10144c = imageView;
        this.f10145d = imageView2;
        this.f10146e = imageView3;
        this.f10147f = linearLayout;
        this.f10148g = linearLayout2;
        this.f10149h = progressBar;
        this.f10150i = relativeLayout2;
        this.f10151j = relativeLayout3;
        this.f10152k = relativeLayout4;
        this.f10153l = relativeLayout5;
        this.f10154m = textView;
        this.f10155n = textView2;
        this.f10156o = textView3;
        this.f10157p = textView4;
        this.f10158q = y02;
        this.f10159r = view;
    }

    public static X0 a(View view) {
        View view2 = view;
        int i4 = R.id.hsv_floating_tags_user_list_item;
        HorizontalScrollView horizontalScrollView = (HorizontalScrollView) ViewBindings.findChildViewById(view2, R.id.hsv_floating_tags_user_list_item);
        if (horizontalScrollView != null) {
            i4 = R.id.iv_cancel_user_list_item;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_cancel_user_list_item);
            if (imageView != null) {
                i4 = R.id.iv_icon_platform_user_list_item;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_icon_platform_user_list_item);
                if (imageView2 != null) {
                    i4 = R.id.iv_icon_user_list_item;
                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_icon_user_list_item);
                    if (imageView3 != null) {
                        i4 = R.id.ll_info_user_list_item;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.ll_info_user_list_item);
                        if (linearLayout != null) {
                            i4 = R.id.ll_user_list_item_floating_categories;
                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.ll_user_list_item_floating_categories);
                            if (linearLayout2 != null) {
                                i4 = R.id.pb_progress_user_list_item;
                                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view2, R.id.pb_progress_user_list_item);
                                if (progressBar != null) {
                                    i4 = R.id.rl_actions_user_list_item;
                                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.rl_actions_user_list_item);
                                    if (relativeLayout != null) {
                                        i4 = R.id.rl_cancel_user_list_item;
                                        RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.rl_cancel_user_list_item);
                                        if (relativeLayout2 != null) {
                                            i4 = R.id.rl_container_user_list_item;
                                            RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.rl_container_user_list_item);
                                            if (relativeLayout3 != null) {
                                                i4 = R.id.rl_icon_progress_user_list_item;
                                                RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.rl_icon_progress_user_list_item);
                                                if (relativeLayout4 != null) {
                                                    i4 = R.id.tv_action_user_list_item;
                                                    TextView textView = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_action_user_list_item);
                                                    if (textView != null) {
                                                        i4 = R.id.tv_date_user_list_item;
                                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_date_user_list_item);
                                                        if (textView2 != null) {
                                                            i4 = R.id.tv_name_user_list_item;
                                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_name_user_list_item);
                                                            if (textView3 != null) {
                                                                i4 = R.id.tv_pending_user_list_item;
                                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_pending_user_list_item);
                                                                if (textView4 != null) {
                                                                    i4 = R.id.user_list_item_floating_tag;
                                                                    View findChildViewById = ViewBindings.findChildViewById(view2, R.id.user_list_item_floating_tag);
                                                                    if (findChildViewById != null) {
                                                                        Y0 a5 = Y0.a(findChildViewById);
                                                                        i4 = R.id.view_disabled_wishlist_item;
                                                                        View findChildViewById2 = ViewBindings.findChildViewById(view2, R.id.view_disabled_wishlist_item);
                                                                        if (findChildViewById2 != null) {
                                                                            return new X0((RelativeLayout) view2, horizontalScrollView, imageView, imageView2, imageView3, linearLayout, linearLayout2, progressBar, relativeLayout, relativeLayout2, relativeLayout3, relativeLayout4, textView, textView2, textView3, textView4, a5, findChildViewById2);
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
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i4)));
    }

    public static X0 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.user_list_item, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f10142a;
    }
}
