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

/* renamed from: c2.a  reason: case insensitive filesystem */
public final class C1653a implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f10186a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f10187b;

    /* renamed from: c  reason: collision with root package name */
    public final RelativeLayout f10188c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f10189d;

    private C1653a(RelativeLayout relativeLayout, ImageView imageView, RelativeLayout relativeLayout2, TextView textView) {
        this.f10186a = relativeLayout;
        this.f10187b = imageView;
        this.f10188c = relativeLayout2;
        this.f10189d = textView;
    }

    public static C1653a a(View view) {
        int i4 = R.id.iv_interstitial;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_interstitial);
        if (imageView != null) {
            i4 = R.id.rl_close_interstitial;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.rl_close_interstitial);
            if (relativeLayout != null) {
                i4 = R.id.tv_download_interstitial;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_download_interstitial);
                if (textView != null) {
                    return new C1653a((RelativeLayout) view, imageView, relativeLayout, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    public static C1653a c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static C1653a d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.ad_interstitial, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f10186a;
    }
}
