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
import com.uptodown.views.FullWidthImageView;

public final class Z implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f10164a;

    /* renamed from: b  reason: collision with root package name */
    public final FullWidthImageView f10165b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f10166c;

    /* renamed from: d  reason: collision with root package name */
    public final LinearLayout f10167d;

    /* renamed from: e  reason: collision with root package name */
    public final LinearLayout f10168e;

    /* renamed from: f  reason: collision with root package name */
    public final ProgressBar f10169f;

    /* renamed from: g  reason: collision with root package name */
    public final RelativeLayout f10170g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f10171h;

    /* renamed from: i  reason: collision with root package name */
    public final TextView f10172i;

    /* renamed from: j  reason: collision with root package name */
    public final TextView f10173j;

    /* renamed from: k  reason: collision with root package name */
    public final TextView f10174k;

    /* renamed from: l  reason: collision with root package name */
    public final TextView f10175l;

    /* renamed from: m  reason: collision with root package name */
    public final TextView f10176m;

    /* renamed from: n  reason: collision with root package name */
    public final TextView f10177n;

    /* renamed from: o  reason: collision with root package name */
    public final TextView f10178o;

    /* renamed from: p  reason: collision with root package name */
    public final TextView f10179p;

    private Z(RelativeLayout relativeLayout, FullWidthImageView fullWidthImageView, ImageView imageView, LinearLayout linearLayout, LinearLayout linearLayout2, ProgressBar progressBar, RelativeLayout relativeLayout2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9) {
        this.f10164a = relativeLayout;
        this.f10165b = fullWidthImageView;
        this.f10166c = imageView;
        this.f10167d = linearLayout;
        this.f10168e = linearLayout2;
        this.f10169f = progressBar;
        this.f10170g = relativeLayout2;
        this.f10171h = textView;
        this.f10172i = textView2;
        this.f10173j = textView3;
        this.f10174k = textView4;
        this.f10175l = textView5;
        this.f10176m = textView6;
        this.f10177n = textView7;
        this.f10178o = textView8;
        this.f10179p = textView9;
    }

    public static Z a(View view) {
        View view2 = view;
        int i4 = R.id.iv_top_app_feature_organization;
        FullWidthImageView fullWidthImageView = (FullWidthImageView) ViewBindings.findChildViewById(view2, R.id.iv_top_app_feature_organization);
        if (fullWidthImageView != null) {
            i4 = R.id.iv_top_app_logo_organization;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_top_app_logo_organization);
            if (imageView != null) {
                i4 = R.id.ll_progress_top_organization;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.ll_progress_top_organization);
                if (linearLayout != null) {
                    i4 = R.id.ll_top_app_desc_organization;
                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.ll_top_app_desc_organization);
                    if (linearLayout2 != null) {
                        i4 = R.id.pb_progress_logo_organization;
                        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view2, R.id.pb_progress_logo_organization);
                        if (progressBar != null) {
                            i4 = R.id.rl_logo_organization;
                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.rl_logo_organization);
                            if (relativeLayout != null) {
                                i4 = R.id.tv_progress_top_organization;
                                TextView textView = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_progress_top_organization);
                                if (textView != null) {
                                    i4 = R.id.tv_top_app_desc_organization;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_top_app_desc_organization);
                                    if (textView2 != null) {
                                        i4 = R.id.tv_top_app_download_organization;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_top_app_download_organization);
                                        if (textView3 != null) {
                                            i4 = R.id.tv_top_app_downloads_counter_organization;
                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_top_app_downloads_counter_organization);
                                            if (textView4 != null) {
                                                i4 = R.id.tv_top_app_name_organization;
                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_top_app_name_organization);
                                                if (textView5 != null) {
                                                    i4 = R.id.tv_top_app_status_organization;
                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_top_app_status_organization);
                                                    if (textView6 != null) {
                                                        i4 = R.id.tv_top_app_title_organization;
                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_top_app_title_organization);
                                                        if (textView7 != null) {
                                                            i4 = R.id.tv_top_app_valoration_organization;
                                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_top_app_valoration_organization);
                                                            if (textView8 != null) {
                                                                i4 = R.id.tv_verified_top_organization;
                                                                TextView textView9 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_verified_top_organization);
                                                                if (textView9 != null) {
                                                                    return new Z((RelativeLayout) view2, fullWidthImageView, imageView, linearLayout, linearLayout2, progressBar, relativeLayout, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9);
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

    public static Z c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.organization_main_app_card, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f10164a;
    }
}
