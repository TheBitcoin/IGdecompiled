package c2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

/* renamed from: c2.z  reason: case insensitive filesystem */
public final class C1702z implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f10906a;

    /* renamed from: b  reason: collision with root package name */
    public final CheckBox f10907b;

    /* renamed from: c  reason: collision with root package name */
    public final RelativeLayout f10908c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f10909d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f10910e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f10911f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f10912g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f10913h;

    /* renamed from: i  reason: collision with root package name */
    public final TextView f10914i;

    /* renamed from: j  reason: collision with root package name */
    public final TextView f10915j;

    /* renamed from: k  reason: collision with root package name */
    public final TextView f10916k;

    /* renamed from: l  reason: collision with root package name */
    public final TextView f10917l;

    /* renamed from: m  reason: collision with root package name */
    public final TextView f10918m;

    /* renamed from: n  reason: collision with root package name */
    public final TextView f10919n;

    /* renamed from: o  reason: collision with root package name */
    public final TextView f10920o;

    /* renamed from: p  reason: collision with root package name */
    public final TextView f10921p;

    /* renamed from: q  reason: collision with root package name */
    public final TextView f10922q;

    /* renamed from: r  reason: collision with root package name */
    public final TextView f10923r;

    private C1702z(LinearLayout linearLayout, CheckBox checkBox, RelativeLayout relativeLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15) {
        this.f10906a = linearLayout;
        this.f10907b = checkBox;
        this.f10908c = relativeLayout;
        this.f10909d = textView;
        this.f10910e = textView2;
        this.f10911f = textView3;
        this.f10912g = textView4;
        this.f10913h = textView5;
        this.f10914i = textView6;
        this.f10915j = textView7;
        this.f10916k = textView8;
        this.f10917l = textView9;
        this.f10918m = textView10;
        this.f10919n = textView11;
        this.f10920o = textView12;
        this.f10921p = textView13;
        this.f10922q = textView14;
        this.f10923r = textView15;
    }

    public static C1702z a(View view) {
        View view2 = view;
        int i4 = R.id.cb_exclude;
        CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view2, R.id.cb_exclude);
        if (checkBox != null) {
            i4 = R.id.rl_exclude;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.rl_exclude);
            if (relativeLayout != null) {
                i4 = R.id.tv_app_installed_details;
                TextView textView = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_app_installed_details);
                if (textView != null) {
                    i4 = R.id.tv_backup;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_backup);
                    if (textView2 != null) {
                        i4 = R.id.tv_check_updates;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_check_updates);
                        if (textView3 != null) {
                            i4 = R.id.tv_exclude;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_exclude);
                            if (textView4 != null) {
                                i4 = R.id.tv_ignore_version;
                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_ignore_version);
                                if (textView5 != null) {
                                    i4 = R.id.tv_nsd_send;
                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_nsd_send);
                                    if (textView6 != null) {
                                        i4 = R.id.tv_old_versions;
                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_old_versions);
                                        if (textView7 != null) {
                                            i4 = R.id.tv_open;
                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_open);
                                            if (textView8 != null) {
                                                i4 = R.id.tv_see_on_uptodown;
                                                TextView textView9 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_see_on_uptodown);
                                                if (textView9 != null) {
                                                    i4 = R.id.tv_share;
                                                    TextView textView10 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_share);
                                                    if (textView10 != null) {
                                                        i4 = R.id.tv_title_das;
                                                        TextView textView11 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_title_das);
                                                        if (textView11 != null) {
                                                            i4 = R.id.tv_uninstall;
                                                            TextView textView12 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_uninstall);
                                                            if (textView12 != null) {
                                                                i4 = R.id.tv_update;
                                                                TextView textView13 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_update);
                                                                if (textView13 != null) {
                                                                    i4 = R.id.tv_version_details;
                                                                    TextView textView14 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_version_details);
                                                                    if (textView14 != null) {
                                                                        i4 = R.id.tv_virustotal_report;
                                                                        TextView textView15 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_virustotal_report);
                                                                        if (textView15 != null) {
                                                                            return new C1702z((LinearLayout) view2, checkBox, relativeLayout, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14, textView15);
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

    public static C1702z c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static C1702z d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.dialogo_app_selected, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f10906a;
    }
}
