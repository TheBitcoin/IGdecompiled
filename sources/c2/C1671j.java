package c2;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

/* renamed from: c2.j  reason: case insensitive filesystem */
public final class C1671j implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f10578a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f10579b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f10580c;

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f10581d;

    /* renamed from: e  reason: collision with root package name */
    public final ImageView f10582e;

    /* renamed from: f  reason: collision with root package name */
    public final RelativeLayout f10583f;

    /* renamed from: g  reason: collision with root package name */
    public final RelativeLayout f10584g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f10585h;

    /* renamed from: i  reason: collision with root package name */
    public final TextView f10586i;

    /* renamed from: j  reason: collision with root package name */
    public final TextView f10587j;

    private C1671j(RelativeLayout relativeLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, TextView textView, TextView textView2, TextView textView3) {
        this.f10578a = relativeLayout;
        this.f10579b = imageView;
        this.f10580c = imageView2;
        this.f10581d = imageView3;
        this.f10582e = imageView4;
        this.f10583f = relativeLayout2;
        this.f10584g = relativeLayout3;
        this.f10585h = textView;
        this.f10586i = textView2;
        this.f10587j = textView3;
    }

    public static C1671j a(View view) {
        int i4 = R.id.iv_download_remote;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_download_remote);
        if (imageView != null) {
            i4 = R.id.iv_uninstall_bad;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_uninstall_bad);
            if (imageView2 != null) {
                i4 = R.id.iv_virustotal_bad;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_virustotal_bad);
                if (imageView3 != null) {
                    i4 = R.id.iv_wishlist_bad;
                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_wishlist_bad);
                    if (imageView4 != null) {
                        i4 = R.id.rl_download_cancel;
                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.rl_download_cancel);
                        if (relativeLayout != null) {
                            i4 = R.id.rl_status_loading_bad;
                            RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.rl_status_loading_bad);
                            if (relativeLayout2 != null) {
                                i4 = R.id.tv_download_cancel_bad;
                                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_download_cancel_bad);
                                if (textView != null) {
                                    i4 = R.id.tv_open_bad;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_open_bad);
                                    if (textView2 != null) {
                                        i4 = R.id.tv_pause_bad;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_pause_bad);
                                        if (textView3 != null) {
                                            return new C1671j((RelativeLayout) view, imageView, imageView2, imageView3, imageView4, relativeLayout, relativeLayout2, textView, textView2, textView3);
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
    public RelativeLayout getRoot() {
        return this.f10578a;
    }
}
