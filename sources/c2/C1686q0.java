package c2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;
import com.uptodown.util.views.UsernameTextView;

/* renamed from: c2.q0  reason: case insensitive filesystem */
public final class C1686q0 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f10710a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f10711b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f10712c;

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f10713d;

    /* renamed from: e  reason: collision with root package name */
    public final LinearLayout f10714e;

    /* renamed from: f  reason: collision with root package name */
    public final View f10715f;

    /* renamed from: g  reason: collision with root package name */
    public final C1687r0 f10716g;

    /* renamed from: h  reason: collision with root package name */
    public final C1687r0 f10717h;

    /* renamed from: i  reason: collision with root package name */
    public final ScrollView f10718i;

    /* renamed from: j  reason: collision with root package name */
    public final Toolbar f10719j;

    /* renamed from: k  reason: collision with root package name */
    public final TextView f10720k;

    /* renamed from: l  reason: collision with root package name */
    public final TextView f10721l;

    /* renamed from: m  reason: collision with root package name */
    public final TextView f10722m;

    /* renamed from: n  reason: collision with root package name */
    public final TextView f10723n;

    /* renamed from: o  reason: collision with root package name */
    public final TextView f10724o;

    /* renamed from: p  reason: collision with root package name */
    public final UsernameTextView f10725p;

    /* renamed from: q  reason: collision with root package name */
    public final TextView f10726q;

    /* renamed from: r  reason: collision with root package name */
    public final TextView f10727r;

    /* renamed from: s  reason: collision with root package name */
    public final TextView f10728s;

    /* renamed from: t  reason: collision with root package name */
    public final C1687r0 f10729t;

    private C1686q0(RelativeLayout relativeLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, LinearLayout linearLayout, View view, C1687r0 r0Var, C1687r0 r0Var2, ScrollView scrollView, Toolbar toolbar, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, UsernameTextView usernameTextView, TextView textView6, TextView textView7, TextView textView8, C1687r0 r0Var3) {
        this.f10710a = relativeLayout;
        this.f10711b = imageView;
        this.f10712c = imageView2;
        this.f10713d = imageView3;
        this.f10714e = linearLayout;
        this.f10715f = view;
        this.f10716g = r0Var;
        this.f10717h = r0Var2;
        this.f10718i = scrollView;
        this.f10719j = toolbar;
        this.f10720k = textView;
        this.f10721l = textView2;
        this.f10722m = textView3;
        this.f10723n = textView4;
        this.f10724o = textView5;
        this.f10725p = usernameTextView;
        this.f10726q = textView6;
        this.f10727r = textView7;
        this.f10728s = textView8;
        this.f10729t = r0Var3;
    }

    public static C1686q0 a(View view) {
        View view2 = view;
        int i4 = R.id.iv_bg_public_profile;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_bg_public_profile);
        if (imageView != null) {
            i4 = R.id.iv_icon_public_profile;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_icon_public_profile);
            if (imageView2 != null) {
                i4 = R.id.iv_turbo_mark_public_profile;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_turbo_mark_public_profile);
                if (imageView3 != null) {
                    i4 = R.id.ll_user_stats_public_profile;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.ll_user_stats_public_profile);
                    if (linearLayout != null) {
                        i4 = R.id.loading_view_public_profile;
                        View findChildViewById = ViewBindings.findChildViewById(view2, R.id.loading_view_public_profile);
                        if (findChildViewById != null) {
                            i4 = R.id.recommended_apps_public_profile;
                            View findChildViewById2 = ViewBindings.findChildViewById(view2, R.id.recommended_apps_public_profile);
                            if (findChildViewById2 != null) {
                                C1687r0 a5 = C1687r0.a(findChildViewById2);
                                i4 = R.id.reviews_public_profile;
                                View findChildViewById3 = ViewBindings.findChildViewById(view2, R.id.reviews_public_profile);
                                if (findChildViewById3 != null) {
                                    C1687r0 a6 = C1687r0.a(findChildViewById3);
                                    i4 = R.id.s_public_profile;
                                    ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(view2, R.id.s_public_profile);
                                    if (scrollView != null) {
                                        i4 = R.id.toolbar_public_profile;
                                        Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view2, R.id.toolbar_public_profile);
                                        if (toolbar != null) {
                                            i4 = R.id.tv_downloads_label_public_profile;
                                            TextView textView = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_downloads_label_public_profile);
                                            if (textView != null) {
                                                i4 = R.id.tv_downloads_value_public_profile;
                                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_downloads_value_public_profile);
                                                if (textView2 != null) {
                                                    i4 = R.id.tv_edit_public_profile;
                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_edit_public_profile);
                                                    if (textView3 != null) {
                                                        i4 = R.id.tv_followers_label_public_profile;
                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_followers_label_public_profile);
                                                        if (textView4 != null) {
                                                            i4 = R.id.tv_followers_value_public_profile;
                                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_followers_value_public_profile);
                                                            if (textView5 != null) {
                                                                i4 = R.id.tv_name_public_profile;
                                                                UsernameTextView usernameTextView = (UsernameTextView) ViewBindings.findChildViewById(view2, R.id.tv_name_public_profile);
                                                                if (usernameTextView != null) {
                                                                    i4 = R.id.tv_registered_public_profile;
                                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_registered_public_profile);
                                                                    if (textView6 != null) {
                                                                        i4 = R.id.tv_reviews_label_public_profile;
                                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_reviews_label_public_profile);
                                                                        if (textView7 != null) {
                                                                            i4 = R.id.tv_reviews_value_public_profile;
                                                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_reviews_value_public_profile);
                                                                            if (textView8 != null) {
                                                                                i4 = R.id.wishlist_public_profile;
                                                                                View findChildViewById4 = ViewBindings.findChildViewById(view2, R.id.wishlist_public_profile);
                                                                                if (findChildViewById4 != null) {
                                                                                    return new C1686q0((RelativeLayout) view2, imageView, imageView2, imageView3, linearLayout, findChildViewById, a5, a6, scrollView, toolbar, textView, textView2, textView3, textView4, textView5, usernameTextView, textView6, textView7, textView8, C1687r0.a(findChildViewById4));
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

    public static C1686q0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static C1686q0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.public_profile_activity, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f10710a;
    }
}
