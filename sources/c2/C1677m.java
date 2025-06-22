package c2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

/* renamed from: c2.m  reason: case insensitive filesystem */
public final class C1677m implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f10650a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f10651b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f10652c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f10653d;

    private C1677m(LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3) {
        this.f10650a = linearLayout;
        this.f10651b = textView;
        this.f10652c = textView2;
        this.f10653d = textView3;
    }

    public static C1677m a(View view) {
        int i4 = R.id.tv_close_dialog_pre_register;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_close_dialog_pre_register);
        if (textView != null) {
            i4 = R.id.tv_description_dialog_pre_register;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_description_dialog_pre_register);
            if (textView2 != null) {
                i4 = R.id.tv_title_dialog_pre_register;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_title_dialog_pre_register);
                if (textView3 != null) {
                    return new C1677m((LinearLayout) view, textView, textView2, textView3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    public static C1677m c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static C1677m d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.dialog_coming_soon, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f10650a;
    }
}
