package c2;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

/* renamed from: c2.A  reason: case insensitive filesystem */
public final class C1650A implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f9673a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f9674b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f9675c;

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f9676d;

    /* renamed from: e  reason: collision with root package name */
    public final ProgressBar f9677e;

    /* renamed from: f  reason: collision with root package name */
    public final RelativeLayout f9678f;

    /* renamed from: g  reason: collision with root package name */
    public final RelativeLayout f9679g;

    /* renamed from: h  reason: collision with root package name */
    public final RelativeLayout f9680h;

    /* renamed from: i  reason: collision with root package name */
    public final TextView f9681i;

    /* renamed from: j  reason: collision with root package name */
    public final TextView f9682j;

    /* renamed from: k  reason: collision with root package name */
    public final TextView f9683k;

    /* renamed from: l  reason: collision with root package name */
    public final TextView f9684l;

    /* renamed from: m  reason: collision with root package name */
    public final TextView f9685m;

    /* renamed from: n  reason: collision with root package name */
    public final TextView f9686n;

    /* renamed from: o  reason: collision with root package name */
    public final TextView f9687o;

    private C1650A(RelativeLayout relativeLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ProgressBar progressBar, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7) {
        this.f9673a = relativeLayout;
        this.f9674b = imageView;
        this.f9675c = imageView2;
        this.f9676d = imageView3;
        this.f9677e = progressBar;
        this.f9678f = relativeLayout2;
        this.f9679g = relativeLayout3;
        this.f9680h = relativeLayout4;
        this.f9681i = textView;
        this.f9682j = textView2;
        this.f9683k = textView3;
        this.f9684l = textView4;
        this.f9685m = textView5;
        this.f9686n = textView6;
        this.f9687o = textView7;
    }

    public static C1650A a(View view) {
        View view2 = view;
        int i4 = R.id.iv_cancel_downloading;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_cancel_downloading);
        if (imageView != null) {
            i4 = R.id.iv_resume_downloading;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_resume_downloading);
            if (imageView2 != null) {
                i4 = R.id.iv_status_pre_register;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_status_pre_register);
                if (imageView3 != null) {
                    i4 = R.id.pb_download_button;
                    ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view2, R.id.pb_download_button);
                    if (progressBar != null) {
                        i4 = R.id.rl_status_downloading;
                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.rl_status_downloading);
                        if (relativeLayout != null) {
                            i4 = R.id.rl_status_loading;
                            RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.rl_status_loading);
                            if (relativeLayout2 != null) {
                                i4 = R.id.rl_status_pre_register;
                                RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.rl_status_pre_register);
                                if (relativeLayout3 != null) {
                                    i4 = R.id.tv_enqueue_download;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_enqueue_download);
                                    if (textView != null) {
                                        i4 = R.id.tv_open_download_button;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_open_download_button);
                                        if (textView2 != null) {
                                            i4 = R.id.tv_percentage_downloaded;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_percentage_downloaded);
                                            if (textView3 != null) {
                                                i4 = R.id.tv_size_downloaded;
                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_size_downloaded);
                                                if (textView4 != null) {
                                                    i4 = R.id.tv_size_total;
                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_size_total);
                                                    if (textView5 != null) {
                                                        i4 = R.id.tv_status_download;
                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_status_download);
                                                        if (textView6 != null) {
                                                            i4 = R.id.tv_status_pre_register;
                                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_status_pre_register);
                                                            if (textView7 != null) {
                                                                return new C1650A((RelativeLayout) view2, imageView, imageView2, imageView3, progressBar, relativeLayout, relativeLayout2, relativeLayout3, textView, textView2, textView3, textView4, textView5, textView6, textView7);
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
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i4)));
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f9673a;
    }
}
