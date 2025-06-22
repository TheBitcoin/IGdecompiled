package c2;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

/* renamed from: c2.g  reason: case insensitive filesystem */
public final class C1665g implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f10416a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f10417b;

    /* renamed from: c  reason: collision with root package name */
    public final LinearLayout f10418c;

    /* renamed from: d  reason: collision with root package name */
    public final LinearLayout f10419d;

    /* renamed from: e  reason: collision with root package name */
    public final LinearLayout f10420e;

    /* renamed from: f  reason: collision with root package name */
    public final LinearLayout f10421f;

    /* renamed from: g  reason: collision with root package name */
    public final LinearLayout f10422g;

    /* renamed from: h  reason: collision with root package name */
    public final ProgressBar f10423h;

    /* renamed from: i  reason: collision with root package name */
    public final RelativeLayout f10424i;

    /* renamed from: j  reason: collision with root package name */
    public final RelativeLayout f10425j;

    /* renamed from: k  reason: collision with root package name */
    public final RelativeLayout f10426k;

    /* renamed from: l  reason: collision with root package name */
    public final TextView f10427l;

    /* renamed from: m  reason: collision with root package name */
    public final TextView f10428m;

    /* renamed from: n  reason: collision with root package name */
    public final TextView f10429n;

    /* renamed from: o  reason: collision with root package name */
    public final TextView f10430o;

    /* renamed from: p  reason: collision with root package name */
    public final TextView f10431p;

    /* renamed from: q  reason: collision with root package name */
    public final TextView f10432q;

    /* renamed from: r  reason: collision with root package name */
    public final TextView f10433r;

    /* renamed from: s  reason: collision with root package name */
    public final TextView f10434s;

    /* renamed from: t  reason: collision with root package name */
    public final TextView f10435t;

    /* renamed from: u  reason: collision with root package name */
    public final TextView f10436u;

    /* renamed from: v  reason: collision with root package name */
    public final TextView f10437v;

    /* renamed from: w  reason: collision with root package name */
    public final TextView f10438w;

    /* renamed from: x  reason: collision with root package name */
    public final TextView f10439x;

    /* renamed from: y  reason: collision with root package name */
    public final View f10440y;

    private C1665g(RelativeLayout relativeLayout, ImageView imageView, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, ProgressBar progressBar, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, View view) {
        this.f10416a = relativeLayout;
        this.f10417b = imageView;
        this.f10418c = linearLayout;
        this.f10419d = linearLayout2;
        this.f10420e = linearLayout3;
        this.f10421f = linearLayout4;
        this.f10422g = linearLayout5;
        this.f10423h = progressBar;
        this.f10424i = relativeLayout2;
        this.f10425j = relativeLayout3;
        this.f10426k = relativeLayout4;
        this.f10427l = textView;
        this.f10428m = textView2;
        this.f10429n = textView3;
        this.f10430o = textView4;
        this.f10431p = textView5;
        this.f10432q = textView6;
        this.f10433r = textView7;
        this.f10434s = textView8;
        this.f10435t = textView9;
        this.f10436u = textView10;
        this.f10437v = textView11;
        this.f10438w = textView12;
        this.f10439x = textView13;
        this.f10440y = view;
    }

    public static C1665g a(View view) {
        View view2 = view;
        int i4 = R.id.iv_logo_app_detail;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_logo_app_detail);
        if (imageView != null) {
            i4 = R.id.ll_download_info_app_detail;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.ll_download_info_app_detail);
            if (linearLayout != null) {
                i4 = R.id.ll_downloads_counter_app_detail;
                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.ll_downloads_counter_app_detail);
                if (linearLayout2 != null) {
                    i4 = R.id.ll_info_app_detail;
                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.ll_info_app_detail);
                    if (linearLayout3 != null) {
                        i4 = R.id.ll_last_update_app_detail;
                        LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.ll_last_update_app_detail);
                        if (linearLayout4 != null) {
                            i4 = R.id.ll_valoration_app_detail;
                            LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.ll_valoration_app_detail);
                            if (linearLayout5 != null) {
                                i4 = R.id.pb_progress_app_detail;
                                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view2, R.id.pb_progress_app_detail);
                                if (progressBar != null) {
                                    i4 = R.id.rl_head_main_info;
                                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.rl_head_main_info);
                                    if (relativeLayout != null) {
                                        i4 = R.id.rl_logo_app_detail;
                                        RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.rl_logo_app_detail);
                                        if (relativeLayout2 != null) {
                                            i4 = R.id.rl_valoration_app_detail;
                                            RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.rl_valoration_app_detail);
                                            if (relativeLayout3 != null) {
                                                i4 = R.id.tv_author_app_detail;
                                                TextView textView = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_author_app_detail);
                                                if (textView != null) {
                                                    i4 = R.id.tv_author_onboard_badge;
                                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_author_onboard_badge);
                                                    if (textView2 != null) {
                                                        i4 = R.id.tv_downloads_counter_app_detail;
                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_downloads_counter_app_detail);
                                                        if (textView3 != null) {
                                                            i4 = R.id.tv_downloads_label_app_detail;
                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_downloads_label_app_detail);
                                                            if (textView4 != null) {
                                                                i4 = R.id.tv_last_update_app_detail;
                                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_last_update_app_detail);
                                                                if (textView5 != null) {
                                                                    i4 = R.id.tv_last_update_label_app_detail;
                                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_last_update_label_app_detail);
                                                                    if (textView6 != null) {
                                                                        i4 = R.id.tv_name_app_detail;
                                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_name_app_detail);
                                                                        if (textView7 != null) {
                                                                            i4 = R.id.tv_phase_app_detail;
                                                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_phase_app_detail);
                                                                            if (textView8 != null) {
                                                                                i4 = R.id.tv_progress_app_detail;
                                                                                TextView textView9 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_progress_app_detail);
                                                                                if (textView9 != null) {
                                                                                    i4 = R.id.tv_reviews_counter_app_detail;
                                                                                    TextView textView10 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_reviews_counter_app_detail);
                                                                                    if (textView10 != null) {
                                                                                        i4 = R.id.tv_valoration_app_detail;
                                                                                        TextView textView11 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_valoration_app_detail);
                                                                                        if (textView11 != null) {
                                                                                            i4 = R.id.tv_verified_app_detail;
                                                                                            TextView textView12 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_verified_app_detail);
                                                                                            if (textView12 != null) {
                                                                                                i4 = R.id.tv_version_app_detail;
                                                                                                TextView textView13 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_version_app_detail);
                                                                                                if (textView13 != null) {
                                                                                                    i4 = R.id.v_separator_downloads_app_detail;
                                                                                                    View findChildViewById = ViewBindings.findChildViewById(view2, R.id.v_separator_downloads_app_detail);
                                                                                                    if (findChildViewById != null) {
                                                                                                        return new C1665g((RelativeLayout) view2, imageView, linearLayout, linearLayout2, linearLayout3, linearLayout4, linearLayout5, progressBar, relativeLayout, relativeLayout2, relativeLayout3, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, findChildViewById);
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

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f10416a;
    }
}
