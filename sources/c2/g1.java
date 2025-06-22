package c2;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

public final class g1 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f10443a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f10444b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f10445c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f10446d;

    /* renamed from: e  reason: collision with root package name */
    public final View f10447e;

    private g1(RelativeLayout relativeLayout, TextView textView, TextView textView2, TextView textView3, View view) {
        this.f10443a = relativeLayout;
        this.f10444b = textView;
        this.f10445c = textView2;
        this.f10446d = textView3;
        this.f10447e = view;
    }

    public static g1 a(View view) {
        int i4 = R.id.tv_read_more_whats_new;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_read_more_whats_new);
        if (textView != null) {
            i4 = R.id.tv_whats_new;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_whats_new);
            if (textView2 != null) {
                i4 = R.id.tv_whats_new_content;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_whats_new_content);
                if (textView3 != null) {
                    i4 = R.id.v_shadow_whats_new;
                    View findChildViewById = ViewBindings.findChildViewById(view, R.id.v_shadow_whats_new);
                    if (findChildViewById != null) {
                        return new g1((RelativeLayout) view, textView, textView2, textView3, findChildViewById);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f10443a;
    }
}
