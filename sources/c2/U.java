package c2;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

public final class U implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f10037a;

    /* renamed from: b  reason: collision with root package name */
    public final C1651B f10038b;

    /* renamed from: c  reason: collision with root package name */
    public final RelativeLayout f10039c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f10040d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f10041e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f10042f;

    private U(RelativeLayout relativeLayout, C1651B b5, RelativeLayout relativeLayout2, TextView textView, TextView textView2, TextView textView3) {
        this.f10037a = relativeLayout;
        this.f10038b = b5;
        this.f10039c = relativeLayout2;
        this.f10040d = textView;
        this.f10041e = textView2;
        this.f10042f = textView3;
    }

    public static U a(View view) {
        int i4 = R.id.ll_order_my_downloads;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.ll_order_my_downloads);
        if (findChildViewById != null) {
            C1651B a5 = C1651B.a(findChildViewById);
            i4 = R.id.rl_my_downloads_selector;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.rl_my_downloads_selector);
            if (relativeLayout != null) {
                i4 = R.id.tv_delete_all_downloads;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_delete_all_downloads);
                if (textView != null) {
                    i4 = R.id.tv_delete_selected_downloads;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_delete_selected_downloads);
                    if (textView2 != null) {
                        i4 = R.id.tv_label_selected_items;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_label_selected_items);
                        if (textView3 != null) {
                            return new U((RelativeLayout) view, a5, relativeLayout, textView, textView2, textView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f10037a;
    }
}
