package c2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

/* renamed from: c2.u  reason: case insensitive filesystem */
public final class C1692u implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f10776a;

    /* renamed from: b  reason: collision with root package name */
    public final EditText f10777b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f10778c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f10779d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f10780e;

    private C1692u(LinearLayout linearLayout, EditText editText, TextView textView, TextView textView2, TextView textView3) {
        this.f10776a = linearLayout;
        this.f10777b = editText;
        this.f10778c = textView;
        this.f10779d = textView2;
        this.f10780e = textView3;
    }

    public static C1692u a(View view) {
        int i4 = R.id.et_dialog_rename;
        EditText editText = (EditText) ViewBindings.findChildViewById(view, R.id.et_dialog_rename);
        if (editText != null) {
            i4 = R.id.tv_cancel;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_cancel);
            if (textView != null) {
                i4 = R.id.tv_ok;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_ok);
                if (textView2 != null) {
                    i4 = R.id.tv_title_dialog_rename;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_title_dialog_rename);
                    if (textView3 != null) {
                        return new C1692u((LinearLayout) view, editText, textView, textView2, textView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    public static C1692u c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static C1692u d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.dialog_rename, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f10776a;
    }
}
