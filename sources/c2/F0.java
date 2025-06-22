package c2;

import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

public final class F0 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f9739a;

    /* renamed from: b  reason: collision with root package name */
    public final CheckBox f9740b;

    /* renamed from: c  reason: collision with root package name */
    public final EditText f9741c;

    /* renamed from: d  reason: collision with root package name */
    public final EditText f9742d;

    /* renamed from: e  reason: collision with root package name */
    public final EditText f9743e;

    /* renamed from: f  reason: collision with root package name */
    public final ImageView f9744f;

    /* renamed from: g  reason: collision with root package name */
    public final LinearLayout f9745g;

    /* renamed from: h  reason: collision with root package name */
    public final RelativeLayout f9746h;

    /* renamed from: i  reason: collision with root package name */
    public final TextView f9747i;

    /* renamed from: j  reason: collision with root package name */
    public final TextView f9748j;

    /* renamed from: k  reason: collision with root package name */
    public final TextView f9749k;

    /* renamed from: l  reason: collision with root package name */
    public final TextView f9750l;

    private F0(LinearLayout linearLayout, CheckBox checkBox, EditText editText, EditText editText2, EditText editText3, ImageView imageView, LinearLayout linearLayout2, RelativeLayout relativeLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.f9739a = linearLayout;
        this.f9740b = checkBox;
        this.f9741c = editText;
        this.f9742d = editText2;
        this.f9743e = editText3;
        this.f9744f = imageView;
        this.f9745g = linearLayout2;
        this.f9746h = relativeLayout;
        this.f9747i = textView;
        this.f9748j = textView2;
        this.f9749k = textView3;
        this.f9750l = textView4;
    }

    public static F0 a(View view) {
        int i4 = R.id.cb_condiciones;
        CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.cb_condiciones);
        if (checkBox != null) {
            i4 = R.id.et_email_sign_up;
            EditText editText = (EditText) ViewBindings.findChildViewById(view, R.id.et_email_sign_up);
            if (editText != null) {
                i4 = R.id.et_pass_sign_up;
                EditText editText2 = (EditText) ViewBindings.findChildViewById(view, R.id.et_pass_sign_up);
                if (editText2 != null) {
                    i4 = R.id.et_user_sign_up;
                    EditText editText3 = (EditText) ViewBindings.findChildViewById(view, R.id.et_user_sign_up);
                    if (editText3 != null) {
                        i4 = R.id.iv_google;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_google);
                        if (imageView != null) {
                            LinearLayout linearLayout = (LinearLayout) view;
                            i4 = R.id.rl_google_login;
                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.rl_google_login);
                            if (relativeLayout != null) {
                                i4 = R.id.tv_already_signed_up;
                                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_already_signed_up);
                                if (textView != null) {
                                    i4 = R.id.tv_continue_with_login;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_continue_with_login);
                                    if (textView2 != null) {
                                        i4 = R.id.tv_login_google;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_login_google);
                                        if (textView3 != null) {
                                            i4 = R.id.tv_sign_up;
                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_sign_up);
                                            if (textView4 != null) {
                                                return new F0(linearLayout, checkBox, editText, editText2, editText3, imageView, linearLayout, relativeLayout, textView, textView2, textView3, textView4);
                                            }
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
        return this.f9739a;
    }
}
