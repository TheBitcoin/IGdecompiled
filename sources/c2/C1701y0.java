package c2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

/* renamed from: c2.y0  reason: case insensitive filesystem */
public final class C1701y0 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f10883a;

    /* renamed from: b  reason: collision with root package name */
    public final EditText f10884b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f10885c;

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f10886d;

    /* renamed from: e  reason: collision with root package name */
    public final ImageView f10887e;

    /* renamed from: f  reason: collision with root package name */
    public final ImageView f10888f;

    /* renamed from: g  reason: collision with root package name */
    public final ImageView f10889g;

    /* renamed from: h  reason: collision with root package name */
    public final ImageView f10890h;

    /* renamed from: i  reason: collision with root package name */
    public final LinearLayout f10891i;

    /* renamed from: j  reason: collision with root package name */
    public final LinearLayout f10892j;

    /* renamed from: k  reason: collision with root package name */
    public final View f10893k;

    /* renamed from: l  reason: collision with root package name */
    public final NestedScrollView f10894l;

    /* renamed from: m  reason: collision with root package name */
    public final RelativeLayout f10895m;

    /* renamed from: n  reason: collision with root package name */
    public final RecyclerView f10896n;

    /* renamed from: o  reason: collision with root package name */
    public final Toolbar f10897o;

    /* renamed from: p  reason: collision with root package name */
    public final TextView f10898p;

    /* renamed from: q  reason: collision with root package name */
    public final TextView f10899q;

    /* renamed from: r  reason: collision with root package name */
    public final TextView f10900r;

    /* renamed from: s  reason: collision with root package name */
    public final TextView f10901s;

    /* renamed from: t  reason: collision with root package name */
    public final TextView f10902t;

    /* renamed from: u  reason: collision with root package name */
    public final TextView f10903u;

    /* renamed from: v  reason: collision with root package name */
    public final TextView f10904v;

    /* renamed from: w  reason: collision with root package name */
    public final TextView f10905w;

    private C1701y0(RelativeLayout relativeLayout, EditText editText, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, LinearLayout linearLayout, LinearLayout linearLayout2, View view, NestedScrollView nestedScrollView, RelativeLayout relativeLayout2, RecyclerView recyclerView, Toolbar toolbar, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8) {
        this.f10883a = relativeLayout;
        this.f10884b = editText;
        this.f10885c = imageView;
        this.f10886d = imageView2;
        this.f10887e = imageView3;
        this.f10888f = imageView4;
        this.f10889g = imageView5;
        this.f10890h = imageView6;
        this.f10891i = linearLayout;
        this.f10892j = linearLayout2;
        this.f10893k = view;
        this.f10894l = nestedScrollView;
        this.f10895m = relativeLayout2;
        this.f10896n = recyclerView;
        this.f10897o = toolbar;
        this.f10898p = textView;
        this.f10899q = textView2;
        this.f10900r = textView3;
        this.f10901s = textView4;
        this.f10902t = textView5;
        this.f10903u = textView6;
        this.f10904v = textView7;
        this.f10905w = textView8;
    }

    public static C1701y0 a(View view) {
        View view2 = view;
        int i4 = R.id.et_review;
        EditText editText = (EditText) ViewBindings.findChildViewById(view2, R.id.et_review);
        if (editText != null) {
            i4 = R.id.iv_app_icon_reviews;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_app_icon_reviews);
            if (imageView != null) {
                i4 = R.id.iv_star1_reviews;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_star1_reviews);
                if (imageView2 != null) {
                    i4 = R.id.iv_star2_reviews;
                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_star2_reviews);
                    if (imageView3 != null) {
                        i4 = R.id.iv_star3_reviews;
                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_star3_reviews);
                        if (imageView4 != null) {
                            i4 = R.id.iv_star4_reviews;
                            ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_star4_reviews);
                            if (imageView5 != null) {
                                i4 = R.id.iv_star5_reviews;
                                ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_star5_reviews);
                                if (imageView6 != null) {
                                    i4 = R.id.ll_header_log_in_reviews;
                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.ll_header_log_in_reviews);
                                    if (linearLayout != null) {
                                        i4 = R.id.ll_order_reviews;
                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.ll_order_reviews);
                                        if (linearLayout2 != null) {
                                            i4 = R.id.loading_view_reviews;
                                            View findChildViewById = ViewBindings.findChildViewById(view2, R.id.loading_view_reviews);
                                            if (findChildViewById != null) {
                                                i4 = R.id.nsv_reviews;
                                                NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(view2, R.id.nsv_reviews);
                                                if (nestedScrollView != null) {
                                                    i4 = R.id.rl_header_reviews;
                                                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.rl_header_reviews);
                                                    if (relativeLayout != null) {
                                                        i4 = R.id.rv_reviews;
                                                        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view2, R.id.rv_reviews);
                                                        if (recyclerView != null) {
                                                            i4 = R.id.toolbar_reviews;
                                                            Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view2, R.id.toolbar_reviews);
                                                            if (toolbar != null) {
                                                                i4 = R.id.tv_app_author_reviews;
                                                                TextView textView = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_app_author_reviews);
                                                                if (textView != null) {
                                                                    i4 = R.id.tv_app_name_reviews;
                                                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_app_name_reviews);
                                                                    if (textView2 != null) {
                                                                        i4 = R.id.tv_app_version_reviews;
                                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_app_version_reviews);
                                                                        if (textView3 != null) {
                                                                            i4 = R.id.tv_order_by_best_reviews;
                                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_order_by_best_reviews);
                                                                            if (textView4 != null) {
                                                                                i4 = R.id.tv_order_by_date_reviews;
                                                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_order_by_date_reviews);
                                                                                if (textView5 != null) {
                                                                                    i4 = R.id.tv_order_by_most_reviews;
                                                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_order_by_most_reviews);
                                                                                    if (textView6 != null) {
                                                                                        i4 = R.id.tv_send_reviews;
                                                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_send_reviews);
                                                                                        if (textView7 != null) {
                                                                                            i4 = R.id.tv_toolbar_reviews;
                                                                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_toolbar_reviews);
                                                                                            if (textView8 != null) {
                                                                                                return new C1701y0((RelativeLayout) view2, editText, imageView, imageView2, imageView3, imageView4, imageView5, imageView6, linearLayout, linearLayout2, findChildViewById, nestedScrollView, relativeLayout, recyclerView, toolbar, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8);
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
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i4)));
    }

    public static C1701y0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static C1701y0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.reviews_activity, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f10883a;
    }
}
