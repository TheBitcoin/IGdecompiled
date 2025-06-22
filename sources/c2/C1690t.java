package c2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

/* renamed from: c2.t  reason: case insensitive filesystem */
public final class C1690t implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f10762a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f10763b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f10764c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f10765d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f10766e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f10767f;

    private C1690t(RelativeLayout relativeLayout, ImageView imageView, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.f10762a = relativeLayout;
        this.f10763b = imageView;
        this.f10764c = textView;
        this.f10765d = textView2;
        this.f10766e = textView3;
        this.f10767f = textView4;
    }

    public static C1690t a(View view) {
        int i4 = R.id.iv_close_dialog_pre_register;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_close_dialog_pre_register);
        if (imageView != null) {
            i4 = R.id.tv_cancel_dialog_pre_register;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_cancel_dialog_pre_register);
            if (textView != null) {
                i4 = R.id.tv_description_dialog_pre_register;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_description_dialog_pre_register);
                if (textView2 != null) {
                    i4 = R.id.tv_ok_dialog_pre_register;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_ok_dialog_pre_register);
                    if (textView3 != null) {
                        i4 = R.id.tv_title_dialog_pre_register;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_title_dialog_pre_register);
                        if (textView4 != null) {
                            return new C1690t((RelativeLayout) view, imageView, textView, textView2, textView3, textView4);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    public static C1690t c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static C1690t d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.dialog_pre_register, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f10762a;
    }
}
