package c2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

/* renamed from: c2.l  reason: case insensitive filesystem */
public final class C1675l implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f10615a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f10616b;

    private C1675l(LinearLayout linearLayout, TextView textView) {
        this.f10615a = linearLayout;
        this.f10616b = textView;
    }

    public static C1675l a(View view) {
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_checking_device);
        if (textView != null) {
            return new C1675l((LinearLayout) view, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.tv_checking_device)));
    }

    public static C1675l c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static C1675l d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.checking_compatibility, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f10615a;
    }
}
