package c2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

/* renamed from: c2.j0  reason: case insensitive filesystem */
public final class C1672j0 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f10588a;

    /* renamed from: b  reason: collision with root package name */
    public final RelativeLayout f10589b;

    /* renamed from: c  reason: collision with root package name */
    public final SwitchCompat f10590c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f10591d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f10592e;

    private C1672j0(RelativeLayout relativeLayout, RelativeLayout relativeLayout2, SwitchCompat switchCompat, TextView textView, TextView textView2) {
        this.f10588a = relativeLayout;
        this.f10589b = relativeLayout2;
        this.f10590c = switchCompat;
        this.f10591d = textView;
        this.f10592e = textView2;
    }

    public static C1672j0 a(View view) {
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
                    return new C1672j0(relativeLayout, relativeLayout, switchCompat, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    public static C1672j0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static C1672j0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.preference_switch, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f10588a;
    }
}
