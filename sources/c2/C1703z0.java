package c2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

/* renamed from: c2.z0  reason: case insensitive filesystem */
public final class C1703z0 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f10924a;

    /* renamed from: b  reason: collision with root package name */
    public final View f10925b;

    /* renamed from: c  reason: collision with root package name */
    public final RecyclerView f10926c;

    /* renamed from: d  reason: collision with root package name */
    public final Toolbar f10927d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f10928e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f10929f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f10930g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f10931h;

    private C1703z0(RelativeLayout relativeLayout, View view, RecyclerView recyclerView, Toolbar toolbar, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.f10924a = relativeLayout;
        this.f10925b = view;
        this.f10926c = recyclerView;
        this.f10927d = toolbar;
        this.f10928e = textView;
        this.f10929f = textView2;
        this.f10930g = textView3;
        this.f10931h = textView4;
    }

    public static C1703z0 a(View view) {
        int i4 = R.id.loading_view_rollback;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.loading_view_rollback);
        if (findChildViewById != null) {
            i4 = R.id.recyclerview;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.recyclerview);
            if (recyclerView != null) {
                i4 = R.id.toolbar_rollback;
                Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar_rollback);
                if (toolbar != null) {
                    i4 = R.id.tv_gdpr_button_rollback;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_gdpr_button_rollback);
                    if (textView != null) {
                        i4 = R.id.tv_no_items;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_no_items);
                        if (textView2 != null) {
                            i4 = R.id.tv_subtitle_rollback;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_subtitle_rollback);
                            if (textView3 != null) {
                                i4 = R.id.tv_title_rollback;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_title_rollback);
                                if (textView4 != null) {
                                    return new C1703z0((RelativeLayout) view, findChildViewById, recyclerView, toolbar, textView, textView2, textView3, textView4);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    public static C1703z0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static C1703z0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.rollback_activity, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f10924a;
    }
}
