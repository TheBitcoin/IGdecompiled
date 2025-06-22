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

public final class d1 implements ViewBinding {

    /* renamed from: A  reason: collision with root package name */
    public final TextView f10356A;

    /* renamed from: B  reason: collision with root package name */
    public final TextView f10357B;

    /* renamed from: C  reason: collision with root package name */
    public final TextView f10358C;

    /* renamed from: D  reason: collision with root package name */
    public final TextView f10359D;

    /* renamed from: E  reason: collision with root package name */
    public final TextView f10360E;

    /* renamed from: F  reason: collision with root package name */
    public final TextView f10361F;

    /* renamed from: G  reason: collision with root package name */
    public final TextView f10362G;

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f10363a;

    /* renamed from: b  reason: collision with root package name */
    public final H f10364b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f10365c;

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f10366d;

    /* renamed from: e  reason: collision with root package name */
    public final ImageView f10367e;

    /* renamed from: f  reason: collision with root package name */
    public final ImageView f10368f;

    /* renamed from: g  reason: collision with root package name */
    public final ImageView f10369g;

    /* renamed from: h  reason: collision with root package name */
    public final ImageView f10370h;

    /* renamed from: i  reason: collision with root package name */
    public final LinearLayout f10371i;

    /* renamed from: j  reason: collision with root package name */
    public final LinearLayout f10372j;

    /* renamed from: k  reason: collision with root package name */
    public final View f10373k;

    /* renamed from: l  reason: collision with root package name */
    public final RelativeLayout f10374l;

    /* renamed from: m  reason: collision with root package name */
    public final RelativeLayout f10375m;

    /* renamed from: n  reason: collision with root package name */
    public final RelativeLayout f10376n;

    /* renamed from: o  reason: collision with root package name */
    public final RelativeLayout f10377o;

    /* renamed from: p  reason: collision with root package name */
    public final ScrollView f10378p;

    /* renamed from: q  reason: collision with root package name */
    public final Toolbar f10379q;

    /* renamed from: r  reason: collision with root package name */
    public final TextView f10380r;

    /* renamed from: s  reason: collision with root package name */
    public final TextView f10381s;

    /* renamed from: t  reason: collision with root package name */
    public final TextView f10382t;

    /* renamed from: u  reason: collision with root package name */
    public final TextView f10383u;

    /* renamed from: v  reason: collision with root package name */
    public final TextView f10384v;

    /* renamed from: w  reason: collision with root package name */
    public final TextView f10385w;

    /* renamed from: x  reason: collision with root package name */
    public final TextView f10386x;

    /* renamed from: y  reason: collision with root package name */
    public final TextView f10387y;

    /* renamed from: z  reason: collision with root package name */
    public final TextView f10388z;

    private d1(RelativeLayout relativeLayout, H h4, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, LinearLayout linearLayout, LinearLayout linearLayout2, View view, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, RelativeLayout relativeLayout5, ScrollView scrollView, Toolbar toolbar, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15, TextView textView16) {
        this.f10363a = relativeLayout;
        this.f10364b = h4;
        this.f10365c = imageView;
        this.f10366d = imageView2;
        this.f10367e = imageView3;
        this.f10368f = imageView4;
        this.f10369g = imageView5;
        this.f10370h = imageView6;
        this.f10371i = linearLayout;
        this.f10372j = linearLayout2;
        this.f10373k = view;
        this.f10374l = relativeLayout2;
        this.f10375m = relativeLayout3;
        this.f10376n = relativeLayout4;
        this.f10377o = relativeLayout5;
        this.f10378p = scrollView;
        this.f10379q = toolbar;
        this.f10380r = textView;
        this.f10381s = textView2;
        this.f10382t = textView3;
        this.f10383u = textView4;
        this.f10384v = textView5;
        this.f10385w = textView6;
        this.f10386x = textView7;
        this.f10387y = textView8;
        this.f10388z = textView9;
        this.f10356A = textView10;
        this.f10357B = textView11;
        this.f10358C = textView12;
        this.f10359D = textView13;
        this.f10360E = textView14;
        this.f10361F = textView15;
        this.f10362G = textView16;
    }

    public static d1 a(View view) {
        View view2 = view;
        int i4 = R.id.header_installed_app;
        View findChildViewById = ViewBindings.findChildViewById(view2, R.id.header_installed_app);
        if (findChildViewById != null) {
            H a5 = H.a(findChildViewById);
            i4 = R.id.iv_correct_malware;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_correct_malware);
            if (imageView != null) {
                i4 = R.id.iv_correct_spyware;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_correct_spyware);
                if (imageView2 != null) {
                    i4 = R.id.iv_correct_virus;
                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_correct_virus);
                    if (imageView3 != null) {
                        i4 = R.id.iv_logo_uptodown_vtr;
                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_logo_uptodown_vtr);
                        if (imageView4 != null) {
                            i4 = R.id.iv_sha256_vtr;
                            ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_sha256_vtr);
                            if (imageView5 != null) {
                                i4 = R.id.iv_signature_vtr;
                                ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_signature_vtr);
                                if (imageView6 != null) {
                                    i4 = R.id.ll_container_scans_vtr;
                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.ll_container_scans_vtr);
                                    if (linearLayout != null) {
                                        i4 = R.id.ll_report_vtr;
                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.ll_report_vtr);
                                        if (linearLayout2 != null) {
                                            i4 = R.id.loading_view_virus_total_report;
                                            View findChildViewById2 = ViewBindings.findChildViewById(view2, R.id.loading_view_virus_total_report);
                                            if (findChildViewById2 != null) {
                                                i4 = R.id.rl_container_result_clean;
                                                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.rl_container_result_clean);
                                                if (relativeLayout != null) {
                                                    i4 = R.id.rl_result_scan;
                                                    RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.rl_result_scan);
                                                    if (relativeLayout2 != null) {
                                                        i4 = R.id.rl_sha256_more_info;
                                                        RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.rl_sha256_more_info);
                                                        if (relativeLayout3 != null) {
                                                            i4 = R.id.rl_signature_more_info;
                                                            RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.rl_signature_more_info);
                                                            if (relativeLayout4 != null) {
                                                                i4 = R.id.sv_report_vtr;
                                                                ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(view2, R.id.sv_report_vtr);
                                                                if (scrollView != null) {
                                                                    i4 = R.id.toolbar_vtr;
                                                                    Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view2, R.id.toolbar_vtr);
                                                                    if (toolbar != null) {
                                                                        i4 = R.id.tv_full_report_vtr;
                                                                        TextView textView = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_full_report_vtr);
                                                                        if (textView != null) {
                                                                            i4 = R.id.tv_label_full_report_vtr;
                                                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_label_full_report_vtr);
                                                                            if (textView2 != null) {
                                                                                i4 = R.id.tv_last_scan_results;
                                                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_last_scan_results);
                                                                                if (textView3 != null) {
                                                                                    i4 = R.id.tv_msg_results;
                                                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_msg_results);
                                                                                    if (textView4 != null) {
                                                                                        i4 = R.id.tv_no_data_vtr;
                                                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_no_data_vtr);
                                                                                        if (textView5 != null) {
                                                                                            i4 = R.id.tv_no_malware;
                                                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_no_malware);
                                                                                            if (textView6 != null) {
                                                                                                i4 = R.id.tv_no_spyware;
                                                                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_no_spyware);
                                                                                                if (textView7 != null) {
                                                                                                    i4 = R.id.tv_no_virus;
                                                                                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_no_virus);
                                                                                                    if (textView8 != null) {
                                                                                                        i4 = R.id.tv_not_avaialable_vtr;
                                                                                                        TextView textView9 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_not_avaialable_vtr);
                                                                                                        if (textView9 != null) {
                                                                                                            i4 = R.id.tv_positives_results;
                                                                                                            TextView textView10 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_positives_results);
                                                                                                            if (textView10 != null) {
                                                                                                                i4 = R.id.tv_sha256_label_vtr;
                                                                                                                TextView textView11 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_sha256_label_vtr);
                                                                                                                if (textView11 != null) {
                                                                                                                    i4 = R.id.tv_sha256_value_vtr;
                                                                                                                    TextView textView12 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_sha256_value_vtr);
                                                                                                                    if (textView12 != null) {
                                                                                                                        i4 = R.id.tv_signature_label_vtr;
                                                                                                                        TextView textView13 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_signature_label_vtr);
                                                                                                                        if (textView13 != null) {
                                                                                                                            i4 = R.id.tv_signature_value_vtr;
                                                                                                                            TextView textView14 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_signature_value_vtr);
                                                                                                                            if (textView14 != null) {
                                                                                                                                i4 = R.id.tv_toolbar_vtr;
                                                                                                                                TextView textView15 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_toolbar_vtr);
                                                                                                                                if (textView15 != null) {
                                                                                                                                    i4 = R.id.vt_report_certified_by_uptodown;
                                                                                                                                    TextView textView16 = (TextView) ViewBindings.findChildViewById(view2, R.id.vt_report_certified_by_uptodown);
                                                                                                                                    if (textView16 != null) {
                                                                                                                                        return new d1((RelativeLayout) view2, a5, imageView, imageView2, imageView3, imageView4, imageView5, imageView6, linearLayout, linearLayout2, findChildViewById2, relativeLayout, relativeLayout2, relativeLayout3, relativeLayout4, scrollView, toolbar, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14, textView15, textView16);
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
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i4)));
    }

    public static d1 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static d1 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.virus_total_report, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f10363a;
    }
}
