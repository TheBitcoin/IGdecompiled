package c2;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

public final class L implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f9817a;

    /* renamed from: b  reason: collision with root package name */
    public final LinearLayout f9818b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f9819c;

    private L(LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView) {
        this.f9817a = linearLayout;
        this.f9818b = linearLayout2;
        this.f9819c = textView;
    }

    public static L a(View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_external_download_box);
        if (textView != null) {
            return new L(linearLayout, linearLayout, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.tv_external_download_box)));
    }

    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f9817a;
    }
}
