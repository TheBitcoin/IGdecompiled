package c2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

/* renamed from: c2.o0  reason: case insensitive filesystem */
public final class C1682o0 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f10686a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f10687b;

    /* renamed from: c  reason: collision with root package name */
    public final LinearLayout f10688c;

    /* renamed from: d  reason: collision with root package name */
    public final RelativeLayout f10689d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f10690e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f10691f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f10692g;

    private C1682o0(RelativeLayout relativeLayout, ImageView imageView, LinearLayout linearLayout, RelativeLayout relativeLayout2, TextView textView, TextView textView2, TextView textView3) {
        this.f10686a = relativeLayout;
        this.f10687b = imageView;
        this.f10688c = linearLayout;
        this.f10689d = relativeLayout2;
        this.f10690e = textView;
        this.f10691f = textView2;
        this.f10692g = textView3;
    }

    public static C1682o0 a(View view) {
        int i4 = R.id.iv_icon_upcoming_release_item;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_icon_upcoming_release_item);
        if (imageView != null) {
            i4 = R.id.ll_upcoming_release;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.ll_upcoming_release);
            if (linearLayout != null) {
                i4 = R.id.rl_container_upcoming_release_item;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.rl_container_upcoming_release_item);
                if (relativeLayout != null) {
                    i4 = R.id.tv_action_upcoming_release_item;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_action_upcoming_release_item);
                    if (textView != null) {
                        i4 = R.id.tv_added_at_upcoming_release_item;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_added_at_upcoming_release_item);
                        if (textView2 != null) {
                            i4 = R.id.tv_name_upcoming_release_item;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_name_upcoming_release_item);
                            if (textView3 != null) {
                                return new C1682o0((RelativeLayout) view, imageView, linearLayout, relativeLayout, textView, textView2, textView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    public static C1682o0 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.preregistration_item, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f10686a;
    }
}
