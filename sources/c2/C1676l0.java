package c2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

/* renamed from: c2.l0  reason: case insensitive filesystem */
public final class C1676l0 implements ViewBinding {

    /* renamed from: A  reason: collision with root package name */
    public final C1672j0 f10617A;

    /* renamed from: B  reason: collision with root package name */
    public final Toolbar f10618B;

    /* renamed from: C  reason: collision with root package name */
    public final C1668h0 f10619C;

    /* renamed from: D  reason: collision with root package name */
    public final TextView f10620D;

    /* renamed from: E  reason: collision with root package name */
    public final C1666g0 f10621E;

    /* renamed from: F  reason: collision with root package name */
    public final C1670i0 f10622F;

    /* renamed from: G  reason: collision with root package name */
    public final C1674k0 f10623G;

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f10624a;

    /* renamed from: b  reason: collision with root package name */
    public final C1668h0 f10625b;

    /* renamed from: c  reason: collision with root package name */
    public final C1668h0 f10626c;

    /* renamed from: d  reason: collision with root package name */
    public final C1668h0 f10627d;

    /* renamed from: e  reason: collision with root package name */
    public final C1668h0 f10628e;

    /* renamed from: f  reason: collision with root package name */
    public final C1672j0 f10629f;

    /* renamed from: g  reason: collision with root package name */
    public final C1670i0 f10630g;

    /* renamed from: h  reason: collision with root package name */
    public final C1672j0 f10631h;

    /* renamed from: i  reason: collision with root package name */
    public final C1670i0 f10632i;

    /* renamed from: j  reason: collision with root package name */
    public final C1672j0 f10633j;

    /* renamed from: k  reason: collision with root package name */
    public final C1672j0 f10634k;

    /* renamed from: l  reason: collision with root package name */
    public final C1668h0 f10635l;

    /* renamed from: m  reason: collision with root package name */
    public final C1666g0 f10636m;

    /* renamed from: n  reason: collision with root package name */
    public final C1672j0 f10637n;

    /* renamed from: o  reason: collision with root package name */
    public final C1672j0 f10638o;

    /* renamed from: p  reason: collision with root package name */
    public final C1668h0 f10639p;

    /* renamed from: q  reason: collision with root package name */
    public final LinearLayout f10640q;

    /* renamed from: r  reason: collision with root package name */
    public final C1666g0 f10641r;

    /* renamed from: s  reason: collision with root package name */
    public final C1666g0 f10642s;

    /* renamed from: t  reason: collision with root package name */
    public final C1672j0 f10643t;

    /* renamed from: u  reason: collision with root package name */
    public final C1666g0 f10644u;

    /* renamed from: v  reason: collision with root package name */
    public final C1666g0 f10645v;

    /* renamed from: w  reason: collision with root package name */
    public final C1668h0 f10646w;

    /* renamed from: x  reason: collision with root package name */
    public final C1672j0 f10647x;

    /* renamed from: y  reason: collision with root package name */
    public final LinearLayout f10648y;

    /* renamed from: z  reason: collision with root package name */
    public final C1666g0 f10649z;

    private C1676l0(LinearLayout linearLayout, C1668h0 h0Var, C1668h0 h0Var2, C1668h0 h0Var3, C1668h0 h0Var4, C1672j0 j0Var, C1670i0 i0Var, C1672j0 j0Var2, C1670i0 i0Var2, C1672j0 j0Var3, C1672j0 j0Var4, C1668h0 h0Var5, C1666g0 g0Var, C1672j0 j0Var5, C1672j0 j0Var6, C1668h0 h0Var6, LinearLayout linearLayout2, C1666g0 g0Var2, C1666g0 g0Var3, C1672j0 j0Var7, C1666g0 g0Var4, C1666g0 g0Var5, C1668h0 h0Var7, C1672j0 j0Var8, LinearLayout linearLayout3, C1666g0 g0Var6, C1672j0 j0Var9, Toolbar toolbar, C1668h0 h0Var8, TextView textView, C1666g0 g0Var7, C1670i0 i0Var3, C1674k0 k0Var) {
        this.f10624a = linearLayout;
        this.f10625b = h0Var;
        this.f10626c = h0Var2;
        this.f10627d = h0Var3;
        this.f10628e = h0Var4;
        this.f10629f = j0Var;
        this.f10630g = i0Var;
        this.f10631h = j0Var2;
        this.f10632i = i0Var2;
        this.f10633j = j0Var3;
        this.f10634k = j0Var4;
        this.f10635l = h0Var5;
        this.f10636m = g0Var;
        this.f10637n = j0Var5;
        this.f10638o = j0Var6;
        this.f10639p = h0Var6;
        this.f10640q = linearLayout2;
        this.f10641r = g0Var2;
        this.f10642s = g0Var3;
        this.f10643t = j0Var7;
        this.f10644u = g0Var4;
        this.f10645v = g0Var5;
        this.f10646w = h0Var7;
        this.f10647x = j0Var8;
        this.f10648y = linearLayout3;
        this.f10649z = g0Var6;
        this.f10617A = j0Var9;
        this.f10618B = toolbar;
        this.f10619C = h0Var8;
        this.f10620D = textView;
        this.f10621E = g0Var7;
        this.f10622F = i0Var3;
        this.f10623G = k0Var;
    }

    public static C1676l0 a(View view) {
        View view2 = view;
        int i4 = R.id.about_app_setting;
        View findChildViewById = ViewBindings.findChildViewById(view2, R.id.about_app_setting);
        if (findChildViewById != null) {
            C1668h0 a5 = C1668h0.a(findChildViewById);
            i4 = R.id.about_uptodown_setting;
            View findChildViewById2 = ViewBindings.findChildViewById(view2, R.id.about_uptodown_setting);
            if (findChildViewById2 != null) {
                C1668h0 a6 = C1668h0.a(findChildViewById2);
                i4 = R.id.ads_setting;
                View findChildViewById3 = ViewBindings.findChildViewById(view2, R.id.ads_setting);
                if (findChildViewById3 != null) {
                    C1668h0 a7 = C1668h0.a(findChildViewById3);
                    i4 = R.id.advanced_setting;
                    View findChildViewById4 = ViewBindings.findChildViewById(view2, R.id.advanced_setting);
                    if (findChildViewById4 != null) {
                        C1668h0 a8 = C1668h0.a(findChildViewById4);
                        i4 = R.id.allow_animations_switch_setting;
                        View findChildViewById5 = ViewBindings.findChildViewById(view2, R.id.allow_animations_switch_setting);
                        if (findChildViewById5 != null) {
                            C1672j0 a9 = C1672j0.a(findChildViewById5);
                            i4 = R.id.auto_play_video_setting;
                            View findChildViewById6 = ViewBindings.findChildViewById(view2, R.id.auto_play_video_setting);
                            if (findChildViewById6 != null) {
                                C1670i0 a10 = C1670i0.a(findChildViewById6);
                                i4 = R.id.auto_update_root_switch_setting;
                                View findChildViewById7 = ViewBindings.findChildViewById(view2, R.id.auto_update_root_switch_setting);
                                if (findChildViewById7 != null) {
                                    C1672j0 a11 = C1672j0.a(findChildViewById7);
                                    i4 = R.id.data_saver_setting;
                                    View findChildViewById8 = ViewBindings.findChildViewById(view2, R.id.data_saver_setting);
                                    if (findChildViewById8 != null) {
                                        C1670i0 a12 = C1670i0.a(findChildViewById8);
                                        i4 = R.id.delete_apk_switch_setting;
                                        View findChildViewById9 = ViewBindings.findChildViewById(view2, R.id.delete_apk_switch_setting);
                                        if (findChildViewById9 != null) {
                                            C1672j0 a13 = C1672j0.a(findChildViewById9);
                                            i4 = R.id.downloads_notification_setting;
                                            View findChildViewById10 = ViewBindings.findChildViewById(view2, R.id.downloads_notification_setting);
                                            if (findChildViewById10 != null) {
                                                C1672j0 a14 = C1672j0.a(findChildViewById10);
                                                i4 = R.id.feedback_setting;
                                                View findChildViewById11 = ViewBindings.findChildViewById(view2, R.id.feedback_setting);
                                                if (findChildViewById11 != null) {
                                                    C1668h0 a15 = C1668h0.a(findChildViewById11);
                                                    i4 = R.id.file_management_category;
                                                    View findChildViewById12 = ViewBindings.findChildViewById(view2, R.id.file_management_category);
                                                    if (findChildViewById12 != null) {
                                                        C1666g0 a16 = C1666g0.a(findChildViewById12);
                                                        i4 = R.id.installable_files_notification_setting;
                                                        View findChildViewById13 = ViewBindings.findChildViewById(view2, R.id.installable_files_notification_setting);
                                                        if (findChildViewById13 != null) {
                                                            C1672j0 a17 = C1672j0.a(findChildViewById13);
                                                            i4 = R.id.installations_notification_setting;
                                                            View findChildViewById14 = ViewBindings.findChildViewById(view2, R.id.installations_notification_setting);
                                                            if (findChildViewById14 != null) {
                                                                C1672j0 a18 = C1672j0.a(findChildViewById14);
                                                                i4 = R.id.language_setting;
                                                                View findChildViewById15 = ViewBindings.findChildViewById(view2, R.id.language_setting);
                                                                if (findChildViewById15 != null) {
                                                                    C1668h0 a19 = C1668h0.a(findChildViewById15);
                                                                    i4 = R.id.ll_preferences_list;
                                                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.ll_preferences_list);
                                                                    if (linearLayout != null) {
                                                                        i4 = R.id.more_info_category;
                                                                        View findChildViewById16 = ViewBindings.findChildViewById(view2, R.id.more_info_category);
                                                                        if (findChildViewById16 != null) {
                                                                            C1666g0 a20 = C1666g0.a(findChildViewById16);
                                                                            i4 = R.id.notifications_category;
                                                                            View findChildViewById17 = ViewBindings.findChildViewById(view2, R.id.notifications_category);
                                                                            if (findChildViewById17 != null) {
                                                                                C1666g0 a21 = C1666g0.a(findChildViewById17);
                                                                                i4 = R.id.only_wifi_switch_setting;
                                                                                View findChildViewById18 = ViewBindings.findChildViewById(view2, R.id.only_wifi_switch_setting);
                                                                                if (findChildViewById18 != null) {
                                                                                    C1672j0 a22 = C1672j0.a(findChildViewById18);
                                                                                    i4 = R.id.performance_category;
                                                                                    View findChildViewById19 = ViewBindings.findChildViewById(view2, R.id.performance_category);
                                                                                    if (findChildViewById19 != null) {
                                                                                        C1666g0 a23 = C1666g0.a(findChildViewById19);
                                                                                        i4 = R.id.privacy_and_policy_category;
                                                                                        View findChildViewById20 = ViewBindings.findChildViewById(view2, R.id.privacy_and_policy_category);
                                                                                        if (findChildViewById20 != null) {
                                                                                            C1666g0 a24 = C1666g0.a(findChildViewById20);
                                                                                            i4 = R.id.privacy_setting;
                                                                                            View findChildViewById21 = ViewBindings.findChildViewById(view2, R.id.privacy_setting);
                                                                                            if (findChildViewById21 != null) {
                                                                                                C1668h0 a25 = C1668h0.a(findChildViewById21);
                                                                                                i4 = R.id.quick_install_root_switch_setting;
                                                                                                View findChildViewById22 = ViewBindings.findChildViewById(view2, R.id.quick_install_root_switch_setting);
                                                                                                if (findChildViewById22 != null) {
                                                                                                    C1672j0 a26 = C1672j0.a(findChildViewById22);
                                                                                                    LinearLayout linearLayout2 = (LinearLayout) view2;
                                                                                                    i4 = R.id.root_category;
                                                                                                    View findChildViewById23 = ViewBindings.findChildViewById(view2, R.id.root_category);
                                                                                                    if (findChildViewById23 != null) {
                                                                                                        C1666g0 a27 = C1666g0.a(findChildViewById23);
                                                                                                        i4 = R.id.show_notifications_setting;
                                                                                                        View findChildViewById24 = ViewBindings.findChildViewById(view2, R.id.show_notifications_setting);
                                                                                                        if (findChildViewById24 != null) {
                                                                                                            C1672j0 a28 = C1672j0.a(findChildViewById24);
                                                                                                            i4 = R.id.toolbar_preferences;
                                                                                                            Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view2, R.id.toolbar_preferences);
                                                                                                            if (toolbar != null) {
                                                                                                                i4 = R.id.tos_setting;
                                                                                                                View findChildViewById25 = ViewBindings.findChildViewById(view2, R.id.tos_setting);
                                                                                                                if (findChildViewById25 != null) {
                                                                                                                    C1668h0 a29 = C1668h0.a(findChildViewById25);
                                                                                                                    i4 = R.id.tv_toolbar_title_preferences;
                                                                                                                    TextView textView = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_toolbar_title_preferences);
                                                                                                                    if (textView != null) {
                                                                                                                        i4 = R.id.updates_category;
                                                                                                                        View findChildViewById26 = ViewBindings.findChildViewById(view2, R.id.updates_category);
                                                                                                                        if (findChildViewById26 != null) {
                                                                                                                            C1666g0 a30 = C1666g0.a(findChildViewById26);
                                                                                                                            i4 = R.id.updates_notification_setting;
                                                                                                                            View findChildViewById27 = ViewBindings.findChildViewById(view2, R.id.updates_notification_setting);
                                                                                                                            if (findChildViewById27 != null) {
                                                                                                                                C1670i0 a31 = C1670i0.a(findChildViewById27);
                                                                                                                                i4 = R.id.updates_setting;
                                                                                                                                View findChildViewById28 = ViewBindings.findChildViewById(view2, R.id.updates_setting);
                                                                                                                                if (findChildViewById28 != null) {
                                                                                                                                    return new C1676l0(linearLayout2, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, linearLayout, a20, a21, a22, a23, a24, a25, a26, linearLayout2, a27, a28, toolbar, a29, textView, a30, a31, C1674k0.a(findChildViewById28));
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

    public static C1676l0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static C1676l0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.preferences_activity, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f10624a;
    }
}
