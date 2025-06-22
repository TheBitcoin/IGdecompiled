package c2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

public final class I implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f9772a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f9773b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f9774c;

    /* renamed from: d  reason: collision with root package name */
    public final LinearLayout f9775d;

    /* renamed from: e  reason: collision with root package name */
    public final ProgressBar f9776e;

    /* renamed from: f  reason: collision with root package name */
    public final RelativeLayout f9777f;

    /* renamed from: g  reason: collision with root package name */
    public final RelativeLayout f9778g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f9779h;

    /* renamed from: i  reason: collision with root package name */
    public final TextView f9780i;

    /* renamed from: j  reason: collision with root package name */
    public final TextView f9781j;

    /* renamed from: k  reason: collision with root package name */
    public final TextView f9782k;

    /* renamed from: l  reason: collision with root package name */
    public final TextView f9783l;

    /* renamed from: m  reason: collision with root package name */
    public final TextView f9784m;

    /* renamed from: n  reason: collision with root package name */
    public final TextView f9785n;

    private I(RelativeLayout relativeLayout, ImageView imageView, ImageView imageView2, LinearLayout linearLayout, ProgressBar progressBar, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7) {
        this.f9772a = relativeLayout;
        this.f9773b = imageView;
        this.f9774c = imageView2;
        this.f9775d = linearLayout;
        this.f9776e = progressBar;
        this.f9777f = relativeLayout2;
        this.f9778g = relativeLayout3;
        this.f9779h = textView;
        this.f9780i = textView2;
        this.f9781j = textView3;
        this.f9782k = textView4;
        this.f9783l = textView5;
        this.f9784m = textView6;
        this.f9785n = textView7;
    }

    public static I a(View view) {
        View view2 = view;
        int i4 = R.id.iv_home_card_featured_item;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_home_card_featured_item);
        if (imageView != null) {
            i4 = R.id.iv_logo_home_card_featured_item;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_logo_home_card_featured_item);
            if (imageView2 != null) {
                i4 = R.id.ll_progress_home_card_featured_item;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.ll_progress_home_card_featured_item);
                if (linearLayout != null) {
                    i4 = R.id.pb_progress_home_card_featured_item;
                    ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view2, R.id.pb_progress_home_card_featured_item);
                    if (progressBar != null) {
                        RelativeLayout relativeLayout = (RelativeLayout) view2;
                        i4 = R.id.rl_logo_home_card_featured_item;
                        RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.rl_logo_home_card_featured_item);
                        if (relativeLayout2 != null) {
                            i4 = R.id.tv_desc_home_card_featured_item;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_desc_home_card_featured_item);
                            if (textView != null) {
                                i4 = R.id.tv_desc_home_card_featured_item_holder;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_desc_home_card_featured_item_holder);
                                if (textView2 != null) {
                                    i4 = R.id.tv_name_home_card_featured_item;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_name_home_card_featured_item);
                                    if (textView3 != null) {
                                        i4 = R.id.tv_name_home_card_featured_item_holder;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_name_home_card_featured_item_holder);
                                        if (textView4 != null) {
                                            i4 = R.id.tv_progress_home_card_featured_item;
                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_progress_home_card_featured_item);
                                            if (textView5 != null) {
                                                i4 = R.id.tv_status_home_card_featured_item;
                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_status_home_card_featured_item);
                                                if (textView6 != null) {
                                                    i4 = R.id.tv_verified_home_card_featured_item;
                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_verified_home_card_featured_item);
                                                    if (textView7 != null) {
                                                        return new I(relativeLayout, imageView, imageView2, linearLayout, progressBar, relativeLayout, relativeLayout2, textView, textView2, textView3, textView4, textView5, textView6, textView7);
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

    public static I c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static I d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.home_card_featured_item, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f9772a;
    }
}
