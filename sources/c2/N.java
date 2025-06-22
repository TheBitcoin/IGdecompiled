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

public final class N implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f9851a;

    /* renamed from: b  reason: collision with root package name */
    public final View f9852b;

    /* renamed from: c  reason: collision with root package name */
    public final RecyclerView f9853c;

    /* renamed from: d  reason: collision with root package name */
    public final Toolbar f9854d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f9855e;

    private N(RelativeLayout relativeLayout, View view, RecyclerView recyclerView, Toolbar toolbar, TextView textView) {
        this.f9851a = relativeLayout;
        this.f9852b = view;
        this.f9853c = recyclerView;
        this.f9854d = toolbar;
        this.f9855e = textView;
    }

    public static N a(View view) {
        int i4 = R.id.loading_view_language_settings;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.loading_view_language_settings);
        if (findChildViewById != null) {
            i4 = R.id.rv_languages;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.rv_languages);
            if (recyclerView != null) {
                i4 = R.id.toolbar_lang_settings;
                Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar_lang_settings);
                if (toolbar != null) {
                    i4 = R.id.tv_title_lang_settings;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_title_lang_settings);
                    if (textView != null) {
                        return new N((RelativeLayout) view, findChildViewById, recyclerView, toolbar, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    public static N c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static N d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.language_settings, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f9851a;
    }
}
