package c2;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

/* renamed from: c2.k0  reason: case insensitive filesystem */
public final class C1674k0 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f10610a;

    /* renamed from: b  reason: collision with root package name */
    public final RelativeLayout f10611b;

    /* renamed from: c  reason: collision with root package name */
    public final SwitchCompat f10612c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f10613d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f10614e;

    private C1674k0(RelativeLayout relativeLayout, RelativeLayout relativeLayout2, SwitchCompat switchCompat, TextView textView, TextView textView2) {
        this.f10610a = relativeLayout;
        this.f10611b = relativeLayout2;
        this.f10612c = switchCompat;
        this.f10613d = textView;
        this.f10614e = textView2;
    }

    public static C1674k0 a(View view) {
        RelativeLayout relativeLayout = (RelativeLayout) view;
        int i4 = R.id.sc_preference_switch;
        SwitchCompat switchCompat = (SwitchCompat) ViewBindings.findChildViewById(view, R.id.sc_preference_switch);
        if (switchCompat != null) {
            i4 = R.id.tv_preference_switch_description;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_preference_switch_description);
            if (textView != null) {
                i4 = R.id.tv_preference_switch_title;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_preference_switch_title);
                if (textView2 != null) {
                    return new C1674k0(relativeLayout, relativeLayout, switchCompat, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f10610a;
    }
}
