package c2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

public final class r implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f10730a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f10731b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f10732c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f10733d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f10734e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f10735f;

    private r(LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        this.f10730a = linearLayout;
        this.f10731b = textView;
        this.f10732c = textView2;
        this.f10733d = textView3;
        this.f10734e = textView4;
        this.f10735f = textView5;
    }

    public static r a(View view) {
        int i4 = R.id.tv_open_app_details_positive;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_open_app_details_positive);
        if (textView != null) {
            i4 = R.id.tv_positive_title;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_positive_title);
            if (textView2 != null) {
                i4 = R.id.tv_rollback_positive;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_rollback_positive);
                if (textView3 != null) {
                    i4 = R.id.tv_uninstall_positive;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_uninstall_positive);
                    if (textView4 != null) {
                        i4 = R.id.tv_virus_report_positive;
                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_virus_report_positive);
                        if (textView5 != null) {
                            return new r((LinearLayout) view, textView, textView2, textView3, textView4, textView5);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    public static r c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static r d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.dialog_positive_selected, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f10730a;
    }
}
