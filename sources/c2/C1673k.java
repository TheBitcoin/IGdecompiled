package c2;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

/* renamed from: c2.k  reason: case insensitive filesystem */
public final class C1673k implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f10593a;

    /* renamed from: b  reason: collision with root package name */
    public final LinearLayout f10594b;

    /* renamed from: c  reason: collision with root package name */
    public final LinearLayout f10595c;

    /* renamed from: d  reason: collision with root package name */
    public final View f10596d;

    /* renamed from: e  reason: collision with root package name */
    public final View f10597e;

    /* renamed from: f  reason: collision with root package name */
    public final View f10598f;

    /* renamed from: g  reason: collision with root package name */
    public final View f10599g;

    /* renamed from: h  reason: collision with root package name */
    public final View f10600h;

    /* renamed from: i  reason: collision with root package name */
    public final View f10601i;

    /* renamed from: j  reason: collision with root package name */
    public final TextView f10602j;

    /* renamed from: k  reason: collision with root package name */
    public final TextView f10603k;

    /* renamed from: l  reason: collision with root package name */
    public final TextView f10604l;

    /* renamed from: m  reason: collision with root package name */
    public final TextView f10605m;

    /* renamed from: n  reason: collision with root package name */
    public final TextView f10606n;

    /* renamed from: o  reason: collision with root package name */
    public final TextView f10607o;

    /* renamed from: p  reason: collision with root package name */
    public final TextView f10608p;

    /* renamed from: q  reason: collision with root package name */
    public final TextView f10609q;

    private C1673k(LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, View view, View view2, View view3, View view4, View view5, View view6, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8) {
        this.f10593a = linearLayout;
        this.f10594b = linearLayout2;
        this.f10595c = linearLayout3;
        this.f10596d = view;
        this.f10597e = view2;
        this.f10598f = view3;
        this.f10599g = view4;
        this.f10600h = view5;
        this.f10601i = view6;
        this.f10602j = textView;
        this.f10603k = textView2;
        this.f10604l = textView3;
        this.f10605m = textView4;
        this.f10606n = textView5;
        this.f10607o = textView6;
        this.f10608p = textView7;
        this.f10609q = textView8;
    }

    public static C1673k a(View view) {
        View view2 = view;
        LinearLayout linearLayout = (LinearLayout) view2;
        int i4 = R.id.ll_reviews_counter_chart;
        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.ll_reviews_counter_chart);
        if (linearLayout2 != null) {
            i4 = R.id.star1_graphical_value_app_detail;
            View findChildViewById = ViewBindings.findChildViewById(view2, R.id.star1_graphical_value_app_detail);
            if (findChildViewById != null) {
                i4 = R.id.star2_graphical_value_app_detail;
                View findChildViewById2 = ViewBindings.findChildViewById(view2, R.id.star2_graphical_value_app_detail);
                if (findChildViewById2 != null) {
                    i4 = R.id.star3_graphical_value_app_detail;
                    View findChildViewById3 = ViewBindings.findChildViewById(view2, R.id.star3_graphical_value_app_detail);
                    if (findChildViewById3 != null) {
                        i4 = R.id.star4_graphical_value_app_detail;
                        View findChildViewById4 = ViewBindings.findChildViewById(view2, R.id.star4_graphical_value_app_detail);
                        if (findChildViewById4 != null) {
                            i4 = R.id.star5_graphical_value_app_detail;
                            View findChildViewById5 = ViewBindings.findChildViewById(view2, R.id.star5_graphical_value_app_detail);
                            if (findChildViewById5 != null) {
                                i4 = R.id.star5_graphical_value_app_detail_background;
                                View findChildViewById6 = ViewBindings.findChildViewById(view2, R.id.star5_graphical_value_app_detail_background);
                                if (findChildViewById6 != null) {
                                    i4 = R.id.tv_chart_1_value;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_chart_1_value);
                                    if (textView != null) {
                                        i4 = R.id.tv_chart_2_value;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_chart_2_value);
                                        if (textView2 != null) {
                                            i4 = R.id.tv_chart_3_value;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_chart_3_value);
                                            if (textView3 != null) {
                                                i4 = R.id.tv_chart_4_value;
                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_chart_4_value);
                                                if (textView4 != null) {
                                                    i4 = R.id.tv_chart_5_value;
                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_chart_5_value);
                                                    if (textView5 != null) {
                                                        i4 = R.id.tv_review_rating_app_detail;
                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_review_rating_app_detail);
                                                        if (textView6 != null) {
                                                            i4 = R.id.tv_reviews_count_app_detail;
                                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_reviews_count_app_detail);
                                                            if (textView7 != null) {
                                                                i4 = R.id.tv_reviews_title_app_detail;
                                                                TextView textView8 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_reviews_title_app_detail);
                                                                if (textView8 != null) {
                                                                    return new C1673k(linearLayout, linearLayout, linearLayout2, findChildViewById, findChildViewById2, findChildViewById3, findChildViewById4, findChildViewById5, findChildViewById6, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8);
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
    public LinearLayout getRoot() {
        return this.f10593a;
    }
}
