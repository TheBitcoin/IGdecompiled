package c2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import androidx.viewbinding.ViewBinding;
import com.uptodown.R;

public final class D0 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RadioButton f9718a;

    /* renamed from: b  reason: collision with root package name */
    public final RadioButton f9719b;

    private D0(RadioButton radioButton, RadioButton radioButton2) {
        this.f9718a = radioButton;
        this.f9719b = radioButton2;
    }

    public static D0 a(View view) {
        if (view != null) {
            RadioButton radioButton = (RadioButton) view;
            return new D0(radioButton, radioButton);
        }
        throw new NullPointerException("rootView");
    }

    public static D0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static D0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.settings_radio_button, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RadioButton getRoot() {
        return this.f9718a;
    }
}
