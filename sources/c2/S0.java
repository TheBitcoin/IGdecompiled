package c2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

public final class S0 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f9997a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f9998b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f9999c;

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f10000d;

    /* renamed from: e  reason: collision with root package name */
    public final LinearLayout f10001e;

    /* renamed from: f  reason: collision with root package name */
    public final View f10002f;

    /* renamed from: g  reason: collision with root package name */
    public final RadioButton f10003g;

    /* renamed from: h  reason: collision with root package name */
    public final RadioButton f10004h;

    /* renamed from: i  reason: collision with root package name */
    public final RadioGroup f10005i;

    /* renamed from: j  reason: collision with root package name */
    public final RecyclerView f10006j;

    /* renamed from: k  reason: collision with root package name */
    public final Toolbar f10007k;

    /* renamed from: l  reason: collision with root package name */
    public final TextView f10008l;

    /* renamed from: m  reason: collision with root package name */
    public final TextView f10009m;

    /* renamed from: n  reason: collision with root package name */
    public final TextView f10010n;

    /* renamed from: o  reason: collision with root package name */
    public final TextView f10011o;

    /* renamed from: p  reason: collision with root package name */
    public final TextView f10012p;

    /* renamed from: q  reason: collision with root package name */
    public final TextView f10013q;

    /* renamed from: r  reason: collision with root package name */
    public final TextView f10014r;

    /* renamed from: s  reason: collision with root package name */
    public final TextView f10015s;

    /* renamed from: t  reason: collision with root package name */
    public final TextView f10016t;

    /* renamed from: u  reason: collision with root package name */
    public final TextView f10017u;

    /* renamed from: v  reason: collision with root package name */
    public final TextView f10018v;

    /* renamed from: w  reason: collision with root package name */
    public final TextView f10019w;

    /* renamed from: x  reason: collision with root package name */
    public final TextView f10020x;

    /* renamed from: y  reason: collision with root package name */
    public final TextView f10021y;

    private S0(RelativeLayout relativeLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, LinearLayout linearLayout, View view, RadioButton radioButton, RadioButton radioButton2, RadioGroup radioGroup, RecyclerView recyclerView, Toolbar toolbar, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14) {
        this.f9997a = relativeLayout;
        this.f9998b = imageView;
        this.f9999c = imageView2;
        this.f10000d = imageView3;
        this.f10001e = linearLayout;
        this.f10002f = view;
        this.f10003g = radioButton;
        this.f10004h = radioButton2;
        this.f10005i = radioGroup;
        this.f10006j = recyclerView;
        this.f10007k = toolbar;
        this.f10008l = textView;
        this.f10009m = textView2;
        this.f10010n = textView3;
        this.f10011o = textView4;
        this.f10012p = textView5;
        this.f10013q = textView6;
        this.f10014r = textView7;
        this.f10015s = textView8;
        this.f10016t = textView9;
        this.f10017u = textView10;
        this.f10018v = textView11;
        this.f10019w = textView12;
        this.f10020x = textView13;
        this.f10021y = textView14;
    }

    public static S0 a(View view) {
        View view2 = view;
        int i4 = R.id.iv_edit_device_name_user_device_details;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_edit_device_name_user_device_details);
        if (imageView != null) {
            i4 = R.id.iv_filters_user_apps_details;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_filters_user_apps_details);
            if (imageView2 != null) {
                i4 = R.id.iv_uptodown_protect_value_user_device_details;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_uptodown_protect_value_user_device_details);
                if (imageView3 != null) {
                    i4 = R.id.ll_device_details;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.ll_device_details);
                    if (linearLayout != null) {
                        i4 = R.id.loading_view_user_device_details;
                        View findChildViewById = ViewBindings.findChildViewById(view2, R.id.loading_view_user_device_details);
                        if (findChildViewById != null) {
                            i4 = R.id.rb_installed_apps_user_device_details;
                            RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view2, R.id.rb_installed_apps_user_device_details);
                            if (radioButton != null) {
                                i4 = R.id.rb_not_installed_apps_user_device_details;
                                RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(view2, R.id.rb_not_installed_apps_user_device_details);
                                if (radioButton2 != null) {
                                    i4 = R.id.rg_filter_apps_user_device_details;
                                    RadioGroup radioGroup = (RadioGroup) ViewBindings.findChildViewById(view2, R.id.rg_filter_apps_user_device_details);
                                    if (radioGroup != null) {
                                        i4 = R.id.rv_user_apps_device_details;
                                        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view2, R.id.rv_user_apps_device_details);
                                        if (recyclerView != null) {
                                            i4 = R.id.toolbar_user_device_details;
                                            Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view2, R.id.toolbar_user_device_details);
                                            if (toolbar != null) {
                                                i4 = R.id.tv_brand_label_user_device_details;
                                                TextView textView = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_brand_label_user_device_details);
                                                if (textView != null) {
                                                    i4 = R.id.tv_brand_value_user_device_details;
                                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_brand_value_user_device_details);
                                                    if (textView2 != null) {
                                                        i4 = R.id.tv_device_apps_user_device_details;
                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_device_apps_user_device_details);
                                                        if (textView3 != null) {
                                                            i4 = R.id.tv_device_name_user_device_details;
                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_device_name_user_device_details);
                                                            if (textView4 != null) {
                                                                i4 = R.id.tv_last_time_used_label_user_device_details;
                                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_last_time_used_label_user_device_details);
                                                                if (textView5 != null) {
                                                                    i4 = R.id.tv_last_time_used_value_user_device_details;
                                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_last_time_used_value_user_device_details);
                                                                    if (textView6 != null) {
                                                                        i4 = R.id.tv_model_label_user_device_details;
                                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_model_label_user_device_details);
                                                                        if (textView7 != null) {
                                                                            i4 = R.id.tv_model_value_user_device_details;
                                                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_model_value_user_device_details);
                                                                            if (textView8 != null) {
                                                                                i4 = R.id.tv_no_items_device_details;
                                                                                TextView textView9 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_no_items_device_details);
                                                                                if (textView9 != null) {
                                                                                    i4 = R.id.tv_platform_label_user_device_details;
                                                                                    TextView textView10 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_platform_label_user_device_details);
                                                                                    if (textView10 != null) {
                                                                                        i4 = R.id.tv_platform_value_user_device_details;
                                                                                        TextView textView11 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_platform_value_user_device_details);
                                                                                        if (textView11 != null) {
                                                                                            i4 = R.id.tv_unlink_device_user_device_details;
                                                                                            TextView textView12 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_unlink_device_user_device_details);
                                                                                            if (textView12 != null) {
                                                                                                i4 = R.id.tv_uptodown_protect_label_user_device_details;
                                                                                                TextView textView13 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_uptodown_protect_label_user_device_details);
                                                                                                if (textView13 != null) {
                                                                                                    i4 = R.id.tv_user_device_details;
                                                                                                    TextView textView14 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_user_device_details);
                                                                                                    if (textView14 != null) {
                                                                                                        return new S0((RelativeLayout) view2, imageView, imageView2, imageView3, linearLayout, findChildViewById, radioButton, radioButton2, radioGroup, recyclerView, toolbar, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14);
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

    public static S0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static S0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.user_device_details_activity, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f9997a;
    }
}
