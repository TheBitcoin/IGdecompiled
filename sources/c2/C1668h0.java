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

/* renamed from: c2.h0  reason: case insensitive filesystem */
public final class C1668h0 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f10457a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f10458b;

    /* renamed from: c  reason: collision with root package name */
    public final RelativeLayout f10459c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f10460d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f10461e;

    private C1668h0(RelativeLayout relativeLayout, ImageView imageView, RelativeLayout relativeLayout2, TextView textView, TextView textView2) {
        this.f10457a = relativeLayout;
        this.f10458b = imageView;
        this.f10459c = relativeLayout2;
        this.f10460d = textView;
        this.f10461e = textView2;
    }

    public static C1668h0 a(View view) {
        int i4 = R.id.iv_preference_item;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_preference_item);
        if (imageView != null) {
            RelativeLayout relativeLayout = (RelativeLayout) view;
            i4 = R.id.tv_preference_item_description;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_preference_item_description);
            if (textView != null) {
                i4 = R.id.tv_preference_item_title;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_preference_item_title);
                if (textView2 != null) {
                    return new C1668h0(relativeLayout, imageView, relativeLayout, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    public static C1668h0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static C1668h0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.preference_item, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f10457a;
    }
}
