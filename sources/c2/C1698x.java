package c2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

/* renamed from: c2.x  reason: case insensitive filesystem */
public final class C1698x implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f10850a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f10851b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f10852c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f10853d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f10854e;

    private C1698x(RelativeLayout relativeLayout, ImageView imageView, TextView textView, TextView textView2, TextView textView3) {
        this.f10850a = relativeLayout;
        this.f10851b = imageView;
        this.f10852c = textView;
        this.f10853d = textView2;
        this.f10854e = textView3;
    }

    public static C1698x a(View view) {
        int i4 = R.id.iv_close_dialog_turbo_positives_detected;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_close_dialog_turbo_positives_detected);
        if (imageView != null) {
            i4 = R.id.tv_action_dialog_turbo_positives_detected;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_action_dialog_turbo_positives_detected);
            if (textView != null) {
                i4 = R.id.tv_description_dialog_turbo_positives_detected;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_description_dialog_turbo_positives_detected);
                if (textView2 != null) {
                    i4 = R.id.tv_title_dialog_turbo_positives_detected;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_title_dialog_turbo_positives_detected);
                    if (textView3 != null) {
                        return new C1698x((RelativeLayout) view, imageView, textView, textView2, textView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    public static C1698x c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static C1698x d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.dialog_turbo_positives_detected, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f10850a;
    }
}
