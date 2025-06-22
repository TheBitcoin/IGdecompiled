package c2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

/* renamed from: c2.s0  reason: case insensitive filesystem */
public final class C1689s0 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f10753a;

    /* renamed from: b  reason: collision with root package name */
    public final View f10754b;

    /* renamed from: c  reason: collision with root package name */
    public final RecyclerView f10755c;

    /* renamed from: d  reason: collision with root package name */
    public final SwitchCompat f10756d;

    /* renamed from: e  reason: collision with root package name */
    public final Toolbar f10757e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f10758f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f10759g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f10760h;

    /* renamed from: i  reason: collision with root package name */
    public final TextView f10761i;

    private C1689s0(RelativeLayout relativeLayout, View view, RecyclerView recyclerView, SwitchCompat switchCompat, Toolbar toolbar, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.f10753a = relativeLayout;
        this.f10754b = view;
        this.f10755c = recyclerView;
        this.f10756d = switchCompat;
        this.f10757e = toolbar;
        this.f10758f = textView;
        this.f10759g = textView2;
        this.f10760h = textView3;
        this.f10761i = textView4;
    }

    public static C1689s0 a(View view) {
        int i4 = R.id.loading_view_recommended;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.loading_view_recommended);
        if (findChildViewById != null) {
            i4 = R.id.rv_recommended;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.rv_recommended);
            if (recyclerView != null) {
                i4 = R.id.s_list_state_recommended;
                SwitchCompat switchCompat = (SwitchCompat) ViewBindings.findChildViewById(view, R.id.s_list_state_recommended);
                if (switchCompat != null) {
                    i4 = R.id.toolbar_recommended;
                    Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar_recommended);
                    if (toolbar != null) {
                        i4 = R.id.tv_explore_recommended;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_explore_recommended);
                        if (textView != null) {
                            i4 = R.id.tv_list_state_recommended;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_list_state_recommended);
                            if (textView2 != null) {
                                i4 = R.id.tv_no_items_recommended;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_no_items_recommended);
                                if (textView3 != null) {
                                    i4 = R.id.tv_title_recommended;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_title_recommended);
                                    if (textView4 != null) {
                                        return new C1689s0((RelativeLayout) view, findChildViewById, recyclerView, switchCompat, toolbar, textView, textView2, textView3, textView4);
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

    public static C1689s0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static C1689s0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.recommended_activity, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f10753a;
    }
}
