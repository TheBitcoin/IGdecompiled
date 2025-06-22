package c2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.uptodown.R;

/* renamed from: c2.e  reason: case insensitive filesystem */
public final class C1661e implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final TextView f10389a;

    private C1661e(TextView textView) {
        this.f10389a = textView;
    }

    public static C1661e a(View view) {
        if (view != null) {
            return new C1661e((TextView) view);
        }
        throw new NullPointerException("rootView");
    }

    public static C1661e c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static C1661e d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.app_detail_floating_category, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public TextView getRoot() {
        return this.f10389a;
    }
}
