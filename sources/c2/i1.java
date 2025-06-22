package c2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

public final class i1 implements ViewBinding {

    /* renamed from: A  reason: collision with root package name */
    public final TextView f10549A;

    /* renamed from: B  reason: collision with root package name */
    public final TextView f10550B;

    /* renamed from: C  reason: collision with root package name */
    public final TextView f10551C;

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f10552a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f10553b;

    /* renamed from: c  reason: collision with root package name */
    public final LinearLayout f10554c;

    /* renamed from: d  reason: collision with root package name */
    public final RelativeLayout f10555d;

    /* renamed from: e  reason: collision with root package name */
    public final RelativeLayout f10556e;

    /* renamed from: f  reason: collision with root package name */
    public final LinearLayout f10557f;

    /* renamed from: g  reason: collision with root package name */
    public final RelativeLayout f10558g;

    /* renamed from: h  reason: collision with root package name */
    public final RelativeLayout f10559h;

    /* renamed from: i  reason: collision with root package name */
    public final RelativeLayout f10560i;

    /* renamed from: j  reason: collision with root package name */
    public final RelativeLayout f10561j;

    /* renamed from: k  reason: collision with root package name */
    public final SwitchCompat f10562k;

    /* renamed from: l  reason: collision with root package name */
    public final SwitchCompat f10563l;

    /* renamed from: m  reason: collision with root package name */
    public final SwitchCompat f10564m;

    /* renamed from: n  reason: collision with root package name */
    public final TextView f10565n;

    /* renamed from: o  reason: collision with root package name */
    public final TextView f10566o;

    /* renamed from: p  reason: collision with root package name */
    public final TextView f10567p;

    /* renamed from: q  reason: collision with root package name */
    public final TextView f10568q;

    /* renamed from: r  reason: collision with root package name */
    public final TextView f10569r;

    /* renamed from: s  reason: collision with root package name */
    public final TextView f10570s;

    /* renamed from: t  reason: collision with root package name */
    public final TextView f10571t;

    /* renamed from: u  reason: collision with root package name */
    public final TextView f10572u;

    /* renamed from: v  reason: collision with root package name */
    public final TextView f10573v;

    /* renamed from: w  reason: collision with root package name */
    public final TextView f10574w;

    /* renamed from: x  reason: collision with root package name */
    public final TextView f10575x;

    /* renamed from: y  reason: collision with root package name */
    public final TextView f10576y;

    /* renamed from: z  reason: collision with root package name */
    public final TextView f10577z;

    private i1(RelativeLayout relativeLayout, ImageView imageView, LinearLayout linearLayout, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, LinearLayout linearLayout2, RelativeLayout relativeLayout4, RelativeLayout relativeLayout5, RelativeLayout relativeLayout6, RelativeLayout relativeLayout7, SwitchCompat switchCompat, SwitchCompat switchCompat2, SwitchCompat switchCompat3, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15, TextView textView16) {
        this.f10552a = relativeLayout;
        this.f10553b = imageView;
        this.f10554c = linearLayout;
        this.f10555d = relativeLayout2;
        this.f10556e = relativeLayout3;
        this.f10557f = linearLayout2;
        this.f10558g = relativeLayout4;
        this.f10559h = relativeLayout5;
        this.f10560i = relativeLayout6;
        this.f10561j = relativeLayout7;
        this.f10562k = switchCompat;
        this.f10563l = switchCompat2;
        this.f10564m = switchCompat3;
        this.f10565n = textView;
        this.f10566o = textView2;
        this.f10567p = textView3;
        this.f10568q = textView4;
        this.f10569r = textView5;
        this.f10570s = textView6;
        this.f10571t = textView7;
        this.f10572u = textView8;
        this.f10573v = textView9;
        this.f10574w = textView10;
        this.f10575x = textView11;
        this.f10576y = textView12;
        this.f10577z = textView13;
        this.f10549A = textView14;
        this.f10550B = textView15;
        this.f10551C = textView16;
    }

    public static i1 a(View view) {
        View view2 = view;
        int i4 = R.id.iv_logo_wizard_privacy;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_logo_wizard_privacy);
        if (imageView != null) {
            i4 = R.id.ll_buttons_bottom_gdpr;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.ll_buttons_bottom_gdpr);
            if (linearLayout != null) {
                i4 = R.id.rl_ads_wizard_privacy;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.rl_ads_wizard_privacy);
                if (relativeLayout != null) {
                    i4 = R.id.rl_analytics_wizard_privacy;
                    RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.rl_analytics_wizard_privacy);
                    if (relativeLayout2 != null) {
                        i4 = R.id.rl_content_wizard_privacy;
                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.rl_content_wizard_privacy);
                        if (linearLayout2 != null) {
                            i4 = R.id.rl_device_analysis_wizard_privacy;
                            RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.rl_device_analysis_wizard_privacy);
                            if (relativeLayout3 != null) {
                                i4 = R.id.rl_error_log_wizard_privacy;
                                RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.rl_error_log_wizard_privacy);
                                if (relativeLayout4 != null) {
                                    i4 = R.id.rl_forgotten_right_wizard_privacy;
                                    RelativeLayout relativeLayout5 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.rl_forgotten_right_wizard_privacy);
                                    if (relativeLayout5 != null) {
                                        i4 = R.id.rl_header_wizard_privacy;
                                        RelativeLayout relativeLayout6 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.rl_header_wizard_privacy);
                                        if (relativeLayout6 != null) {
                                            i4 = R.id.s_analytics_wizard_privacy;
                                            SwitchCompat switchCompat = (SwitchCompat) ViewBindings.findChildViewById(view2, R.id.s_analytics_wizard_privacy);
                                            if (switchCompat != null) {
                                                i4 = R.id.s_device_analysis_wizard_privacy;
                                                SwitchCompat switchCompat2 = (SwitchCompat) ViewBindings.findChildViewById(view2, R.id.s_device_analysis_wizard_privacy);
                                                if (switchCompat2 != null) {
                                                    i4 = R.id.s_error_log_wizard_privacy;
                                                    SwitchCompat switchCompat3 = (SwitchCompat) ViewBindings.findChildViewById(view2, R.id.s_error_log_wizard_privacy);
                                                    if (switchCompat3 != null) {
                                                        i4 = R.id.tv_accept_all_gdpr;
                                                        TextView textView = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_accept_all_gdpr);
                                                        if (textView != null) {
                                                            i4 = R.id.tv_content_wizard_privacy;
                                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_content_wizard_privacy);
                                                            if (textView2 != null) {
                                                                i4 = R.id.tv_decline_all_gdpr;
                                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_decline_all_gdpr);
                                                                if (textView3 != null) {
                                                                    i4 = R.id.tv_description_ads_wizard_privacy;
                                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_description_ads_wizard_privacy);
                                                                    if (textView4 != null) {
                                                                        i4 = R.id.tv_description_analytics_wizard_privacy;
                                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_description_analytics_wizard_privacy);
                                                                        if (textView5 != null) {
                                                                            i4 = R.id.tv_description_device_analysis_wizard_privacy;
                                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_description_device_analysis_wizard_privacy);
                                                                            if (textView6 != null) {
                                                                                i4 = R.id.tv_description_error_log_wizard_privacy;
                                                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_description_error_log_wizard_privacy);
                                                                                if (textView7 != null) {
                                                                                    i4 = R.id.tv_description_forgotten_right_wizard_privacy;
                                                                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_description_forgotten_right_wizard_privacy);
                                                                                    if (textView8 != null) {
                                                                                        i4 = R.id.tv_header_title_wizard_privacy;
                                                                                        TextView textView9 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_header_title_wizard_privacy);
                                                                                        if (textView9 != null) {
                                                                                            i4 = R.id.tv_title_ads_wizard_privacy;
                                                                                            TextView textView10 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_title_ads_wizard_privacy);
                                                                                            if (textView10 != null) {
                                                                                                i4 = R.id.tv_title_analytics_wizard_privacy;
                                                                                                TextView textView11 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_title_analytics_wizard_privacy);
                                                                                                if (textView11 != null) {
                                                                                                    i4 = R.id.tv_title_device_analysis_wizard_privacy;
                                                                                                    TextView textView12 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_title_device_analysis_wizard_privacy);
                                                                                                    if (textView12 != null) {
                                                                                                        i4 = R.id.tv_title_error_log_wizard_privacy;
                                                                                                        TextView textView13 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_title_error_log_wizard_privacy);
                                                                                                        if (textView13 != null) {
                                                                                                            i4 = R.id.tv_title_forgotten_right_wizard_privacy;
                                                                                                            TextView textView14 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_title_forgotten_right_wizard_privacy);
                                                                                                            if (textView14 != null) {
                                                                                                                i4 = R.id.tv_title_wizard_privacy;
                                                                                                                TextView textView15 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_title_wizard_privacy);
                                                                                                                if (textView15 != null) {
                                                                                                                    i4 = R.id.tv_warning_device_analysis_wizard_privacy;
                                                                                                                    TextView textView16 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_warning_device_analysis_wizard_privacy);
                                                                                                                    if (textView16 != null) {
                                                                                                                        return new i1((RelativeLayout) view2, imageView, linearLayout, relativeLayout, relativeLayout2, linearLayout2, relativeLayout3, relativeLayout4, relativeLayout5, relativeLayout6, switchCompat, switchCompat2, switchCompat3, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14, textView15, textView16);
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
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i4)));
    }

    public static i1 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static i1 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.wizard_privacy, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f10552a;
    }
}
