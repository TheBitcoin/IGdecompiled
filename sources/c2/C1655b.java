package c2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

/* renamed from: c2.b  reason: case insensitive filesystem */
public final class C1655b implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f10220a;

    /* renamed from: b  reason: collision with root package name */
    public final LinearLayout f10221b;

    /* renamed from: c  reason: collision with root package name */
    public final LinearLayout f10222c;

    /* renamed from: d  reason: collision with root package name */
    public final Toolbar f10223d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f10224e;

    private C1655b(LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, Toolbar toolbar, TextView textView) {
        this.f10220a = linearLayout;
        this.f10221b = linearLayout2;
        this.f10222c = linearLayout3;
        this.f10223d = toolbar;
        this.f10224e = textView;
    }

    public static C1655b a(View view) {
        int i4 = R.id.ll_advanced_preferences_list;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.ll_advanced_preferences_list);
        if (linearLayout != null) {
            LinearLayout linearLayout2 = (LinearLayout) view;
            i4 = R.id.toolbar_advanced_preferences;
            Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar_advanced_preferences);
            if (toolbar != null) {
                i4 = R.id.tv_toolbar_title_advanced_preferences;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_toolbar_title_advanced_preferences);
                if (textView != null) {
                    return new C1655b(linearLayout2, linearLayout, linearLayout2, toolbar, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    public static C1655b c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static C1655b d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.advanced_preferences_activity, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f10220a;
    }
}
