package c2;

import android.view.View;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;

public final class Y0 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final TextView f10163a;

    private Y0(TextView textView) {
        this.f10163a = textView;
    }

    public static Y0 a(View view) {
        if (view != null) {
            return new Y0((TextView) view);
        }
        throw new NullPointerException("rootView");
    }

    /* renamed from: b */
    public TextView getRoot() {
        return this.f10163a;
    }
}
