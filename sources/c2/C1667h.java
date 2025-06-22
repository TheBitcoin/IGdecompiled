package c2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

/* renamed from: c2.h  reason: case insensitive filesystem */
public final class C1667h implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f10448a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f10449b;

    /* renamed from: c  reason: collision with root package name */
    public final View f10450c;

    /* renamed from: d  reason: collision with root package name */
    public final RelativeLayout f10451d;

    /* renamed from: e  reason: collision with root package name */
    public final RecyclerView f10452e;

    /* renamed from: f  reason: collision with root package name */
    public final Toolbar f10453f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f10454g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f10455h;

    /* renamed from: i  reason: collision with root package name */
    public final TextView f10456i;

    private C1667h(RelativeLayout relativeLayout, ImageView imageView, View view, RelativeLayout relativeLayout2, RecyclerView recyclerView, Toolbar toolbar, TextView textView, TextView textView2, TextView textView3) {
        this.f10448a = relativeLayout;
        this.f10449b = imageView;
        this.f10450c = view;
        this.f10451d = relativeLayout2;
        this.f10452e = recyclerView;
        this.f10453f = toolbar;
        this.f10454g = textView;
        this.f10455h = textView2;
        this.f10456i = textView3;
    }

    public static C1667h a(View view) {
        int i4 = R.id.iv_logo_afa;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_logo_afa);
        if (imageView != null) {
            i4 = R.id.loading_view_app_files;
            View findChildViewById = ViewBindings.findChildViewById(view, R.id.loading_view_app_files);
            if (findChildViewById != null) {
                i4 = R.id.rl_header_afa;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.rl_header_afa);
                if (relativeLayout != null) {
                    i4 = R.id.rv_app_files;
                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.rv_app_files);
                    if (recyclerView != null) {
                        i4 = R.id.toolbar_afa;
                        Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar_afa);
                        if (toolbar != null) {
                            i4 = R.id.tv_app_name_afa;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_app_name_afa);
                            if (textView != null) {
                                i4 = R.id.tv_date_afa;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_date_afa);
                                if (textView2 != null) {
                                    i4 = R.id.tv_no_data_afa;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_no_data_afa);
                                    if (textView3 != null) {
                                        return new C1667h((RelativeLayout) view, imageView, findChildViewById, relativeLayout, recyclerView, toolbar, textView, textView2, textView3);
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

    public static C1667h c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static C1667h d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.app_files_activity, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f10448a;
    }
}
