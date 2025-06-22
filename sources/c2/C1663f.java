package c2;

import android.view.View;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;
import com.uptodown.views.FullWidthImageView;

/* renamed from: c2.f  reason: case insensitive filesystem */
public final class C1663f implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f10405a;

    /* renamed from: b  reason: collision with root package name */
    public final FullWidthImageView f10406b;

    private C1663f(RelativeLayout relativeLayout, FullWidthImageView fullWidthImageView) {
        this.f10405a = relativeLayout;
        this.f10406b = fullWidthImageView;
    }

    public static C1663f a(View view) {
        FullWidthImageView fullWidthImageView = (FullWidthImageView) ViewBindings.findChildViewById(view, R.id.iv_feature_app_detail);
        if (fullWidthImageView != null) {
            return new C1663f((RelativeLayout) view, fullWidthImageView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.iv_feature_app_detail)));
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f10405a;
    }
}
