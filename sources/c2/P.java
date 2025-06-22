package c2;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

public final class P implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f9878a;

    /* renamed from: b  reason: collision with root package name */
    public final EditText f9879b;

    /* renamed from: c  reason: collision with root package name */
    public final EditText f9880c;

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f9881d;

    /* renamed from: e  reason: collision with root package name */
    public final LinearLayout f9882e;

    /* renamed from: f  reason: collision with root package name */
    public final RelativeLayout f9883f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f9884g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f9885h;

    /* renamed from: i  reason: collision with root package name */
    public final TextView f9886i;

    /* renamed from: j  reason: collision with root package name */
    public final TextView f9887j;

    /* renamed from: k  reason: collision with root package name */
    public final TextView f9888k;

    private P(LinearLayout linearLayout, EditText editText, EditText editText2, ImageView imageView, LinearLayout linearLayout2, RelativeLayout relativeLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        this.f9878a = linearLayout;
        this.f9879b = editText;
        this.f9880c = editText2;
        this.f9881d = imageView;
        this.f9882e = linearLayout2;
        this.f9883f = relativeLayout;
        this.f9884g = textView;
        this.f9885h = textView2;
        this.f9886i = textView3;
        this.f9887j = textView4;
        this.f9888k = textView5;
    }

    public static P a(View view) {
        int i4 = R.id.et_pass_login;
        EditText editText = (EditText) ViewBindings.findChildViewById(view, R.id.et_pass_login);
        if (editText != null) {
            i4 = R.id.et_user_login;
            EditText editText2 = (EditText) ViewBindings.findChildViewById(view, R.id.et_user_login);
            if (editText2 != null) {
                i4 = R.id.iv_google;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_google);
                if (imageView != null) {
                    LinearLayout linearLayout = (LinearLayout) view;
                    i4 = R.id.rl_google_login;
                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.rl_google_login);
                    if (relativeLayout != null) {
                        i4 = R.id.tv_continue_with_login;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_continue_with_login);
                        if (textView != null) {
                            i4 = R.id.tv_login;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_login);
                            if (textView2 != null) {
                                i4 = R.id.tv_login_google;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_login_google);
                                if (textView3 != null) {
                                    i4 = R.id.tv_msg_sign_up;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_msg_sign_up);
                                    if (textView4 != null) {
                                        i4 = R.id.tv_pass_forget_login;
                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_pass_forget_login);
                                        if (textView5 != null) {
                                            return new P(linearLayout, editText, editText2, imageView, linearLayout, relativeLayout, textView, textView2, textView3, textView4, textView5);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f9878a;
    }
}
