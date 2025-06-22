package c2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

public final class f1 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f10409a;

    /* renamed from: b  reason: collision with root package name */
    public final ProgressBar f10410b;

    /* renamed from: c  reason: collision with root package name */
    public final LinearLayout f10411c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f10412d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f10413e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f10414f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f10415g;

    private f1(LinearLayout linearLayout, ProgressBar progressBar, LinearLayout linearLayout2, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.f10409a = linearLayout;
        this.f10410b = progressBar;
        this.f10411c = linearLayout2;
        this.f10412d = textView;
        this.f10413e = textView2;
        this.f10414f = textView3;
        this.f10415g = textView4;
    }

    public static f1 a(View view) {
        int i4 = R.id.pb_not_storage;
        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, R.id.pb_not_storage);
        if (progressBar != null) {
            LinearLayout linearLayout = (LinearLayout) view;
            i4 = R.id.tv_no_storage_action;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_no_storage_action);
            if (textView != null) {
                i4 = R.id.tv_not_storage;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_not_storage);
                if (textView2 != null) {
                    i4 = R.id.tv_not_storage_text;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_not_storage_text);
                    if (textView3 != null) {
                        i4 = R.id.tv_not_storage_title;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_not_storage_title);
                        if (textView4 != null) {
                            return new f1(linearLayout, progressBar, linearLayout, textView, textView2, textView3, textView4);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    public static f1 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static f1 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.warning_not_space_available_dialog, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f10409a;
    }
}
