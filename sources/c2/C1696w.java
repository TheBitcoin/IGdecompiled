package c2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

/* renamed from: c2.w  reason: case insensitive filesystem */
public final class C1696w implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f10827a;

    /* renamed from: b  reason: collision with root package name */
    public final RadioGroup f10828b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f10829c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f10830d;

    private C1696w(LinearLayout linearLayout, RadioGroup radioGroup, TextView textView, TextView textView2) {
        this.f10827a = linearLayout;
        this.f10828b = radioGroup;
        this.f10829c = textView;
        this.f10830d = textView2;
    }

    public static C1696w a(View view) {
        int i4 = R.id.rg_dso;
        RadioGroup radioGroup = (RadioGroup) ViewBindings.findChildViewById(view, R.id.rg_dso);
        if (radioGroup != null) {
            i4 = R.id.tv_accept_dso;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_accept_dso);
            if (textView != null) {
                i4 = R.id.tv_title_dso;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_title_dso);
                if (textView2 != null) {
                    return new C1696w((LinearLayout) view, radioGroup, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    public static C1696w c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static C1696w d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.dialog_settings_options, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f10827a;
    }
}
