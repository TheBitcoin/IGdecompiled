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
import com.uptodown.util.views.MaxHeightRecyclerView;

/* renamed from: c2.t0  reason: case insensitive filesystem */
public final class C1691t0 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f10768a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f10769b;

    /* renamed from: c  reason: collision with root package name */
    public final LinearLayout f10770c;

    /* renamed from: d  reason: collision with root package name */
    public final RelativeLayout f10771d;

    /* renamed from: e  reason: collision with root package name */
    public final MaxHeightRecyclerView f10772e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f10773f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f10774g;

    /* renamed from: h  reason: collision with root package name */
    public final View f10775h;

    private C1691t0(RelativeLayout relativeLayout, ImageView imageView, LinearLayout linearLayout, RelativeLayout relativeLayout2, MaxHeightRecyclerView maxHeightRecyclerView, TextView textView, TextView textView2, View view) {
        this.f10768a = relativeLayout;
        this.f10769b = imageView;
        this.f10770c = linearLayout;
        this.f10771d = relativeLayout2;
        this.f10772e = maxHeightRecyclerView;
        this.f10773f = textView;
        this.f10774g = textView2;
        this.f10775h = view;
    }

    public static C1691t0 a(View view) {
        int i4 = R.id.iv_close_remote_install_devices;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_close_remote_install_devices);
        if (imageView != null) {
            i4 = R.id.rl_remote_install_devices;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.rl_remote_install_devices);
            if (linearLayout != null) {
                i4 = R.id.rlp_remote_install_devices;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.rlp_remote_install_devices);
                if (relativeLayout != null) {
                    i4 = R.id.rv_remote_install_devices;
                    MaxHeightRecyclerView maxHeightRecyclerView = (MaxHeightRecyclerView) ViewBindings.findChildViewById(view, R.id.rv_remote_install_devices);
                    if (maxHeightRecyclerView != null) {
                        i4 = R.id.tv_remote_install_devices;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_remote_install_devices);
                        if (textView != null) {
                            i4 = R.id.tv_title_remote_install_devices;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_title_remote_install_devices);
                            if (textView2 != null) {
                                i4 = R.id.v_background_remote_install_devices;
                                View findChildViewById = ViewBindings.findChildViewById(view, R.id.v_background_remote_install_devices);
                                if (findChildViewById != null) {
                                    return new C1691t0((RelativeLayout) view, imageView, linearLayout, relativeLayout, maxHeightRecyclerView, textView, textView2, findChildViewById);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    public static C1691t0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static C1691t0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.remote_install_devices_popup, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f10768a;
    }
}
