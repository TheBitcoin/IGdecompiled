package c2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

/* renamed from: c2.n  reason: case insensitive filesystem */
public final class C1679n implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final CoordinatorLayout f10661a;

    /* renamed from: b  reason: collision with root package name */
    public final RadioButton f10662b;

    /* renamed from: c  reason: collision with root package name */
    public final RadioButton f10663c;

    /* renamed from: d  reason: collision with root package name */
    public final RadioButton f10664d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f10665e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f10666f;

    private C1679n(CoordinatorLayout coordinatorLayout, RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, TextView textView, TextView textView2) {
        this.f10661a = coordinatorLayout;
        this.f10662b = radioButton;
        this.f10663c = radioButton2;
        this.f10664d = radioButton3;
        this.f10665e = textView;
        this.f10666f = textView2;
    }

    public static C1679n a(View view) {
        int i4 = R.id.rb_disabled;
        RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, R.id.rb_disabled);
        if (radioButton != null) {
            i4 = R.id.rb_enabled;
            RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(view, R.id.rb_enabled);
            if (radioButton2 != null) {
                i4 = R.id.rb_follow_system;
                RadioButton radioButton3 = (RadioButton) ViewBindings.findChildViewById(view, R.id.rb_follow_system);
                if (radioButton3 != null) {
                    i4 = R.id.tv_cancel;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_cancel);
                    if (textView != null) {
                        i4 = R.id.tv_title_dark_mode_options;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_title_dark_mode_options);
                        if (textView2 != null) {
                            return new C1679n((CoordinatorLayout) view, radioButton, radioButton2, radioButton3, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    public static C1679n c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static C1679n d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.dialog_dark_mode_options, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public CoordinatorLayout getRoot() {
        return this.f10661a;
    }
}
