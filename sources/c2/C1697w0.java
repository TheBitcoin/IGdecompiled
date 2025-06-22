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
import com.uptodown.util.views.UsernameTextView;

/* renamed from: c2.w0  reason: case insensitive filesystem */
public final class C1697w0 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f10831a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f10832b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f10833c;

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f10834d;

    /* renamed from: e  reason: collision with root package name */
    public final ImageView f10835e;

    /* renamed from: f  reason: collision with root package name */
    public final ImageView f10836f;

    /* renamed from: g  reason: collision with root package name */
    public final ImageView f10837g;

    /* renamed from: h  reason: collision with root package name */
    public final ImageView f10838h;

    /* renamed from: i  reason: collision with root package name */
    public final ImageView f10839i;

    /* renamed from: j  reason: collision with root package name */
    public final ImageView f10840j;

    /* renamed from: k  reason: collision with root package name */
    public final LinearLayout f10841k;

    /* renamed from: l  reason: collision with root package name */
    public final LinearLayout f10842l;

    /* renamed from: m  reason: collision with root package name */
    public final LinearLayout f10843m;

    /* renamed from: n  reason: collision with root package name */
    public final TextView f10844n;

    /* renamed from: o  reason: collision with root package name */
    public final TextView f10845o;

    /* renamed from: p  reason: collision with root package name */
    public final TextView f10846p;

    /* renamed from: q  reason: collision with root package name */
    public final TextView f10847q;

    /* renamed from: r  reason: collision with root package name */
    public final TextView f10848r;

    /* renamed from: s  reason: collision with root package name */
    public final UsernameTextView f10849s;

    private C1697w0(RelativeLayout relativeLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, ImageView imageView8, ImageView imageView9, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, UsernameTextView usernameTextView) {
        this.f10831a = relativeLayout;
        this.f10832b = imageView;
        this.f10833c = imageView2;
        this.f10834d = imageView3;
        this.f10835e = imageView4;
        this.f10836f = imageView5;
        this.f10837g = imageView6;
        this.f10838h = imageView7;
        this.f10839i = imageView8;
        this.f10840j = imageView9;
        this.f10841k = linearLayout;
        this.f10842l = linearLayout2;
        this.f10843m = linearLayout3;
        this.f10844n = textView;
        this.f10845o = textView2;
        this.f10846p = textView3;
        this.f10847q = textView4;
        this.f10848r = textView5;
        this.f10849s = usernameTextView;
    }

    public static C1697w0 a(View view) {
        View view2 = view;
        int i4 = R.id.iv_author_verified_review;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_author_verified_review);
        if (imageView != null) {
            i4 = R.id.iv_avatar_review;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_avatar_review);
            if (imageView2 != null) {
                i4 = R.id.iv_likes_counter_review;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_likes_counter_review);
                if (imageView3 != null) {
                    i4 = R.id.iv_star1_review;
                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_star1_review);
                    if (imageView4 != null) {
                        i4 = R.id.iv_star2_review;
                        ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_star2_review);
                        if (imageView5 != null) {
                            i4 = R.id.iv_star3_review;
                            ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_star3_review);
                            if (imageView6 != null) {
                                i4 = R.id.iv_star4_review;
                                ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_star4_review);
                                if (imageView7 != null) {
                                    i4 = R.id.iv_star5_review;
                                    ImageView imageView8 = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_star5_review);
                                    if (imageView8 != null) {
                                        i4 = R.id.iv_turbo_mark_review;
                                        ImageView imageView9 = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_turbo_mark_review);
                                        if (imageView9 != null) {
                                            i4 = R.id.ll_likes_review;
                                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.ll_likes_review);
                                            if (linearLayout != null) {
                                                i4 = R.id.ll_reviews_counter_review;
                                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.ll_reviews_counter_review);
                                                if (linearLayout2 != null) {
                                                    i4 = R.id.ll_stars_review;
                                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.ll_stars_review);
                                                    if (linearLayout3 != null) {
                                                        i4 = R.id.tv_body_review;
                                                        TextView textView = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_body_review);
                                                        if (textView != null) {
                                                            i4 = R.id.tv_date_review;
                                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_date_review);
                                                            if (textView2 != null) {
                                                                i4 = R.id.tv_likes_counter_review;
                                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_likes_counter_review);
                                                                if (textView3 != null) {
                                                                    i4 = R.id.tv_replies_counter_review;
                                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_replies_counter_review);
                                                                    if (textView4 != null) {
                                                                        i4 = R.id.tv_show_more_review;
                                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_show_more_review);
                                                                        if (textView5 != null) {
                                                                            i4 = R.id.tv_username_review;
                                                                            UsernameTextView usernameTextView = (UsernameTextView) ViewBindings.findChildViewById(view2, R.id.tv_username_review);
                                                                            if (usernameTextView != null) {
                                                                                return new C1697w0((RelativeLayout) view2, imageView, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, imageView9, linearLayout, linearLayout2, linearLayout3, textView, textView2, textView3, textView4, textView5, usernameTextView);
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i4)));
    }

    public static C1697w0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static C1697w0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.review_mini, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f10831a;
    }
}
