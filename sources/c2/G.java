package c2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.uptodown.R;

public final class G implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f9751a;

    /* renamed from: b  reason: collision with root package name */
    public final SubsamplingScaleImageView f9752b;

    /* renamed from: c  reason: collision with root package name */
    public final ProgressBar f9753c;

    private G(RelativeLayout relativeLayout, SubsamplingScaleImageView subsamplingScaleImageView, ProgressBar progressBar) {
        this.f9751a = relativeLayout;
        this.f9752b = subsamplingScaleImageView;
        this.f9753c = progressBar;
    }

    public static G a(View view) {
        int i4 = R.id.iv_imagen;
        SubsamplingScaleImageView subsamplingScaleImageView = (SubsamplingScaleImageView) ViewBindings.findChildViewById(view, R.id.iv_imagen);
        if (subsamplingScaleImageView != null) {
            i4 = R.id.pb_gallery_item;
            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, R.id.pb_gallery_item);
            if (progressBar != null) {
                return new G((RelativeLayout) view, subsamplingScaleImageView, progressBar);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    public static G c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.gallery_item, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f9751a;
    }
}
