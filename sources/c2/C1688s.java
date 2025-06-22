package c2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

/* renamed from: c2.s  reason: case insensitive filesystem */
public final class C1688s implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f10744a;

    /* renamed from: b  reason: collision with root package name */
    public final RelativeLayout f10745b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f10746c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f10747d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f10748e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f10749f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f10750g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f10751h;

    /* renamed from: i  reason: collision with root package name */
    public final TextView f10752i;

    private C1688s(LinearLayout linearLayout, RelativeLayout relativeLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7) {
        this.f10744a = linearLayout;
        this.f10745b = relativeLayout;
        this.f10746c = textView;
        this.f10747d = textView2;
        this.f10748e = textView3;
        this.f10749f = textView4;
        this.f10750g = textView5;
        this.f10751h = textView6;
        this.f10752i = textView7;
    }

    public static C1688s a(View view) {
        int i4 = R.id.rl_result_scan;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.rl_result_scan);
        if (relativeLayout != null) {
            i4 = R.id.tv_cancel;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_cancel);
            if (textView != null) {
                i4 = R.id.tv_install;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_install);
                if (textView2 != null) {
                    i4 = R.id.tv_last_scan_results;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_last_scan_results);
                    if (textView3 != null) {
                        i4 = R.id.tv_msg;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_msg);
                        if (textView4 != null) {
                            i4 = R.id.tv_msg_results;
                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_msg_results);
                            if (textView5 != null) {
                                i4 = R.id.tv_positives_results;
                                TextView textView6 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_positives_results);
                                if (textView6 != null) {
                                    i4 = R.id.tv_title_dialog_turbo_positives_detected;
                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_title_dialog_turbo_positives_detected);
                                    if (textView7 != null) {
                                        return new C1688s((LinearLayout) view, relativeLayout, textView, textView2, textView3, textView4, textView5, textView6, textView7);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    public static C1688s c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static C1688s d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.dialog_positives_detected, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f10744a;
    }
}
