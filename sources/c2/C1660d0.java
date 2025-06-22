package c2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

/* renamed from: c2.d0  reason: case insensitive filesystem */
public final class C1660d0 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f10344a;

    /* renamed from: b  reason: collision with root package name */
    public final EditText f10345b;

    /* renamed from: c  reason: collision with root package name */
    public final EditText f10346c;

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f10347d;

    /* renamed from: e  reason: collision with root package name */
    public final ImageView f10348e;

    /* renamed from: f  reason: collision with root package name */
    public final View f10349f;

    /* renamed from: g  reason: collision with root package name */
    public final Toolbar f10350g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f10351h;

    /* renamed from: i  reason: collision with root package name */
    public final TextView f10352i;

    /* renamed from: j  reason: collision with root package name */
    public final TextView f10353j;

    /* renamed from: k  reason: collision with root package name */
    public final TextView f10354k;

    /* renamed from: l  reason: collision with root package name */
    public final TextView f10355l;

    private C1660d0(RelativeLayout relativeLayout, EditText editText, EditText editText2, ImageView imageView, ImageView imageView2, View view, Toolbar toolbar, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        this.f10344a = relativeLayout;
        this.f10345b = editText;
        this.f10346c = editText2;
        this.f10347d = imageView;
        this.f10348e = imageView2;
        this.f10349f = view;
        this.f10350g = toolbar;
        this.f10351h = textView;
        this.f10352i = textView2;
        this.f10353j = textView3;
        this.f10354k = textView4;
        this.f10355l = textView5;
    }

    public static C1660d0 a(View view) {
        int i4 = R.id.et_confirm_password_edit;
        EditText editText = (EditText) ViewBindings.findChildViewById(view, R.id.et_confirm_password_edit);
        if (editText != null) {
            i4 = R.id.et_password_edit;
            EditText editText2 = (EditText) ViewBindings.findChildViewById(view, R.id.et_password_edit);
            if (editText2 != null) {
                i4 = R.id.iv_confirm_password_edit;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_confirm_password_edit);
                if (imageView != null) {
                    i4 = R.id.iv_password_edit;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_password_edit);
                    if (imageView2 != null) {
                        i4 = R.id.loading_view_password_edit;
                        View findChildViewById = ViewBindings.findChildViewById(view, R.id.loading_view_password_edit);
                        if (findChildViewById != null) {
                            i4 = R.id.toolbar_password_edit;
                            Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar_password_edit);
                            if (toolbar != null) {
                                i4 = R.id.tv_equals_password_edit;
                                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_equals_password_edit);
                                if (textView != null) {
                                    i4 = R.id.tv_max_chars_password_edit;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_max_chars_password_edit);
                                    if (textView2 != null) {
                                        i4 = R.id.tv_min_chars_password_edit;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_min_chars_password_edit);
                                        if (textView3 != null) {
                                            i4 = R.id.tv_password_edit_change;
                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_password_edit_change);
                                            if (textView4 != null) {
                                                i4 = R.id.tv_title_toolbar_password_edit;
                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_title_toolbar_password_edit);
                                                if (textView5 != null) {
                                                    return new C1660d0((RelativeLayout) view, editText, editText2, imageView, imageView2, findChildViewById, toolbar, textView, textView2, textView3, textView4, textView5);
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    public static C1660d0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static C1660d0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.password_edit, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f10344a;
    }
}
