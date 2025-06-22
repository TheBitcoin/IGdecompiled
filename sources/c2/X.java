package c2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;
import com.uptodown.views.FullWidthImageView;

public final class X implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f10124a;

    /* renamed from: b  reason: collision with root package name */
    public final FullWidthImageView f10125b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f10126c;

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f10127d;

    /* renamed from: e  reason: collision with root package name */
    public final ImageView f10128e;

    /* renamed from: f  reason: collision with root package name */
    public final ImageView f10129f;

    /* renamed from: g  reason: collision with root package name */
    public final View f10130g;

    /* renamed from: h  reason: collision with root package name */
    public final RelativeLayout f10131h;

    /* renamed from: i  reason: collision with root package name */
    public final RelativeLayout f10132i;

    /* renamed from: j  reason: collision with root package name */
    public final RecyclerView f10133j;

    /* renamed from: k  reason: collision with root package name */
    public final ScrollView f10134k;

    /* renamed from: l  reason: collision with root package name */
    public final Toolbar f10135l;

    /* renamed from: m  reason: collision with root package name */
    public final TextView f10136m;

    /* renamed from: n  reason: collision with root package name */
    public final TextView f10137n;

    /* renamed from: o  reason: collision with root package name */
    public final TextView f10138o;

    /* renamed from: p  reason: collision with root package name */
    public final TextView f10139p;

    /* renamed from: q  reason: collision with root package name */
    public final TextView f10140q;

    /* renamed from: r  reason: collision with root package name */
    public final View f10141r;

    private X(RelativeLayout relativeLayout, FullWidthImageView fullWidthImageView, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, View view, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RecyclerView recyclerView, ScrollView scrollView, Toolbar toolbar, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, View view2) {
        this.f10124a = relativeLayout;
        this.f10125b = fullWidthImageView;
        this.f10126c = imageView;
        this.f10127d = imageView2;
        this.f10128e = imageView3;
        this.f10129f = imageView4;
        this.f10130g = view;
        this.f10131h = relativeLayout2;
        this.f10132i = relativeLayout3;
        this.f10133j = recyclerView;
        this.f10134k = scrollView;
        this.f10135l = toolbar;
        this.f10136m = textView;
        this.f10137n = textView2;
        this.f10138o = textView3;
        this.f10139p = textView4;
        this.f10140q = textView5;
        this.f10141r = view2;
    }

    public static X a(View view) {
        View view2 = view;
        int i4 = R.id.iv_feature_organization;
        FullWidthImageView fullWidthImageView = (FullWidthImageView) ViewBindings.findChildViewById(view2, R.id.iv_feature_organization);
        if (fullWidthImageView != null) {
            i4 = R.id.iv_instagram_organization;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_instagram_organization);
            if (imageView != null) {
                i4 = R.id.iv_logo_organization;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_logo_organization);
                if (imageView2 != null) {
                    i4 = R.id.iv_tiktok_organization;
                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_tiktok_organization);
                    if (imageView3 != null) {
                        i4 = R.id.iv_twitter_organization;
                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_twitter_organization);
                        if (imageView4 != null) {
                            i4 = R.id.loading_view_organization;
                            View findChildViewById = ViewBindings.findChildViewById(view2, R.id.loading_view_organization);
                            if (findChildViewById != null) {
                                i4 = R.id.rl_description_organization;
                                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.rl_description_organization);
                                if (relativeLayout != null) {
                                    i4 = R.id.rl_details_organization;
                                    RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.rl_details_organization);
                                    if (relativeLayout2 != null) {
                                        i4 = R.id.rv_organization;
                                        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view2, R.id.rv_organization);
                                        if (recyclerView != null) {
                                            i4 = R.id.sv_organization;
                                            ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(view2, R.id.sv_organization);
                                            if (scrollView != null) {
                                                i4 = R.id.toolbar_organization;
                                                Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view2, R.id.toolbar_organization);
                                                if (toolbar != null) {
                                                    i4 = R.id.tv_description_organization;
                                                    TextView textView = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_description_organization);
                                                    if (textView != null) {
                                                        i4 = R.id.tv_name_organization;
                                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_name_organization);
                                                        if (textView2 != null) {
                                                            i4 = R.id.tv_read_more_organization;
                                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_read_more_organization);
                                                            if (textView3 != null) {
                                                                i4 = R.id.tv_toolbar_title_organization;
                                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_toolbar_title_organization);
                                                                if (textView4 != null) {
                                                                    i4 = R.id.tv_web_organization;
                                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_web_organization);
                                                                    if (textView5 != null) {
                                                                        i4 = R.id.v_description_shadow_organization;
                                                                        View findChildViewById2 = ViewBindings.findChildViewById(view2, R.id.v_description_shadow_organization);
                                                                        if (findChildViewById2 != null) {
                                                                            return new X((RelativeLayout) view2, fullWidthImageView, imageView, imageView2, imageView3, imageView4, findChildViewById, relativeLayout, relativeLayout2, recyclerView, scrollView, toolbar, textView, textView2, textView3, textView4, textView5, findChildViewById2);
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

    public static X c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static X d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.organization_activity, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f10124a;
    }
}
