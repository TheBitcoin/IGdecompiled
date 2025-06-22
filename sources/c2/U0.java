package c2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

public final class U0 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f10043a;

    /* renamed from: b  reason: collision with root package name */
    public final View f10044b;

    /* renamed from: c  reason: collision with root package name */
    public final NestedScrollView f10045c;

    /* renamed from: d  reason: collision with root package name */
    public final RecyclerView f10046d;

    /* renamed from: e  reason: collision with root package name */
    public final Toolbar f10047e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f10048f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f10049g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f10050h;

    /* renamed from: i  reason: collision with root package name */
    public final T0 f10051i;

    private U0(RelativeLayout relativeLayout, View view, NestedScrollView nestedScrollView, RecyclerView recyclerView, Toolbar toolbar, TextView textView, TextView textView2, TextView textView3, T0 t02) {
        this.f10043a = relativeLayout;
        this.f10044b = view;
        this.f10045c = nestedScrollView;
        this.f10046d = recyclerView;
        this.f10047e = toolbar;
        this.f10048f = textView;
        this.f10049g = textView2;
        this.f10050h = textView3;
        this.f10051i = t02;
    }

    public static U0 a(View view) {
        int i4 = R.id.loading_view_user_devices;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.loading_view_user_devices);
        if (findChildViewById != null) {
            i4 = R.id.nsv_user_devices;
            NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(view, R.id.nsv_user_devices);
            if (nestedScrollView != null) {
                i4 = R.id.rv_user_devices;
                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.rv_user_devices);
                if (recyclerView != null) {
                    i4 = R.id.toolbar_user_devices;
                    Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar_user_devices);
                    if (toolbar != null) {
                        i4 = R.id.tv_other_devices_user_devices;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_other_devices_user_devices);
                        if (textView != null) {
                            i4 = R.id.tv_this_device_user_devices;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_this_device_user_devices);
                            if (textView2 != null) {
                                i4 = R.id.tv_user_devices;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_user_devices);
                                if (textView3 != null) {
                                    i4 = R.id.user_device;
                                    View findChildViewById2 = ViewBindings.findChildViewById(view, R.id.user_device);
                                    if (findChildViewById2 != null) {
                                        return new U0((RelativeLayout) view, findChildViewById, nestedScrollView, recyclerView, toolbar, textView, textView2, textView3, T0.a(findChildViewById2));
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

    public static U0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static U0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.user_devices_activity, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f10043a;
    }
}
