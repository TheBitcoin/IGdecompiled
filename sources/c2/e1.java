package c2;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

public final class e1 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f10397a;

    /* renamed from: b  reason: collision with root package name */
    public final LinearLayout f10398b;

    /* renamed from: c  reason: collision with root package name */
    public final ProgressBar f10399c;

    /* renamed from: d  reason: collision with root package name */
    public final ProgressBar f10400d;

    /* renamed from: e  reason: collision with root package name */
    public final RelativeLayout f10401e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f10402f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f10403g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f10404h;

    private e1(RelativeLayout relativeLayout, LinearLayout linearLayout, ProgressBar progressBar, ProgressBar progressBar2, RelativeLayout relativeLayout2, TextView textView, TextView textView2, TextView textView3) {
        this.f10397a = relativeLayout;
        this.f10398b = linearLayout;
        this.f10399c = progressBar;
        this.f10400d = progressBar2;
        this.f10401e = relativeLayout2;
        this.f10402f = textView;
        this.f10403g = textView2;
        this.f10404h = textView3;
    }

    public static e1 a(View view) {
        int i4 = R.id.ll_pb_fus;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.ll_pb_fus);
        if (linearLayout != null) {
            i4 = R.id.pb_enough_storage;
            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, R.id.pb_enough_storage);
            if (progressBar != null) {
                i4 = R.id.pb_not_storage;
                ProgressBar progressBar2 = (ProgressBar) ViewBindings.findChildViewById(view, R.id.pb_not_storage);
                if (progressBar2 != null) {
                    RelativeLayout relativeLayout = (RelativeLayout) view;
                    i4 = R.id.tv_no_storage_action;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_no_storage_action);
                    if (textView != null) {
                        i4 = R.id.tv_not_storage;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_not_storage);
                        if (textView2 != null) {
                            i4 = R.id.tv_not_storage_text;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_not_storage_text);
                            if (textView3 != null) {
                                return new e1(relativeLayout, linearLayout, progressBar, progressBar2, relativeLayout, textView, textView2, textView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f10397a;
    }
}
