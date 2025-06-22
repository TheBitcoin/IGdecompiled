package c2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

/* renamed from: c2.g0  reason: case insensitive filesystem */
public final class C1666g0 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f10441a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f10442b;

    private C1666g0(RelativeLayout relativeLayout, TextView textView) {
        this.f10441a = relativeLayout;
        this.f10442b = textView;
    }

    public static C1666g0 a(View view) {
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_preference_category);
        if (textView != null) {
            return new C1666g0((RelativeLayout) view, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.tv_preference_category)));
    }

    public static C1666g0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static C1666g0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.preference_category, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f10441a;
    }
}
