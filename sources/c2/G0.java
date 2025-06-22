package c2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

public final class G0 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f9754a;

    /* renamed from: b  reason: collision with root package name */
    public final EditText f9755b;

    /* renamed from: c  reason: collision with root package name */
    public final EditText f9756c;

    /* renamed from: d  reason: collision with root package name */
    public final View f9757d;

    /* renamed from: e  reason: collision with root package name */
    public final Toolbar f9758e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f9759f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f9760g;

    private G0(RelativeLayout relativeLayout, EditText editText, EditText editText2, View view, Toolbar toolbar, TextView textView, TextView textView2) {
        this.f9754a = relativeLayout;
        this.f9755b = editText;
        this.f9756c = editText2;
        this.f9757d = view;
        this.f9758e = toolbar;
        this.f9759f = textView;
        this.f9760g = textView2;
    }

    public static G0 a(View view) {
        int i4 = R.id.et_email_suggestions;
        EditText editText = (EditText) ViewBindings.findChildViewById(view, R.id.et_email_suggestions);
        if (editText != null) {
            i4 = R.id.et_msg_suggestions;
            EditText editText2 = (EditText) ViewBindings.findChildViewById(view, R.id.et_msg_suggestions);
            if (editText2 != null) {
                i4 = R.id.loading_view_suggestions;
                View findChildViewById = ViewBindings.findChildViewById(view, R.id.loading_view_suggestions);
                if (findChildViewById != null) {
                    i4 = R.id.toolbar_suggestions;
                    Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar_suggestions);
                    if (toolbar != null) {
                        i4 = R.id.tv_send_suggestions;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_send_suggestions);
                        if (textView != null) {
                            i4 = R.id.tv_title_suggestions;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_title_suggestions);
                            if (textView2 != null) {
                                return new G0((RelativeLayout) view, editText, editText2, findChildViewById, toolbar, textView, textView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    public static G0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static G0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.suggestions, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f9754a;
    }
}
