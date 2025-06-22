package c2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.uptodown.R;

/* renamed from: c2.C  reason: case insensitive filesystem */
public final class C1652C implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final TextView f9703a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f9704b;

    private C1652C(TextView textView, TextView textView2) {
        this.f9703a = textView;
        this.f9704b = textView2;
    }

    public static C1652C a(View view) {
        if (view != null) {
            TextView textView = (TextView) view;
            return new C1652C(textView, textView);
        }
        throw new NullPointerException("rootView");
    }

    public static C1652C c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.dropdown_option_item, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public TextView getRoot() {
        return this.f9703a;
    }
}
