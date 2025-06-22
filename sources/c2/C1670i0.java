package c2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

/* renamed from: c2.i0  reason: case insensitive filesystem */
public final class C1670i0 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f10545a;

    /* renamed from: b  reason: collision with root package name */
    public final RelativeLayout f10546b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f10547c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f10548d;

    private C1670i0(RelativeLayout relativeLayout, RelativeLayout relativeLayout2, TextView textView, TextView textView2) {
        this.f10545a = relativeLayout;
        this.f10546b = relativeLayout2;
        this.f10547c = textView;
        this.f10548d = textView2;
    }

    public static C1670i0 a(View view) {
        RelativeLayout relativeLayout = (RelativeLayout) view;
        int i4 = R.id.tv_preference_list_description;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_preference_list_description);
        if (textView != null) {
            i4 = R.id.tv_preference_list_title;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_preference_list_title);
            if (textView2 != null) {
                return new C1670i0(relativeLayout, relativeLayout, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    public static C1670i0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static C1670i0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.preference_list, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f10545a;
    }
}
