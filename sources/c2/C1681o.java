package c2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

/* renamed from: c2.o  reason: case insensitive filesystem */
public final class C1681o implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f10677a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f10678b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f10679c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f10680d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f10681e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f10682f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f10683g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f10684h;

    /* renamed from: i  reason: collision with root package name */
    public final TextView f10685i;

    private C1681o(LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8) {
        this.f10677a = linearLayout;
        this.f10678b = textView;
        this.f10679c = textView2;
        this.f10680d = textView3;
        this.f10681e = textView4;
        this.f10682f = textView5;
        this.f10683g = textView6;
        this.f10684h = textView7;
        this.f10685i = textView8;
    }

    public static C1681o a(View view) {
        int i4 = R.id.tv_app_details_ddo;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_app_details_ddo);
        if (textView != null) {
            i4 = R.id.tv_delete_ddo;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_delete_ddo);
            if (textView2 != null) {
                i4 = R.id.tv_open_containing_folder_ddo;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_open_containing_folder_ddo);
                if (textView3 != null) {
                    i4 = R.id.tv_open_ddo;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_open_ddo);
                    if (textView4 != null) {
                        i4 = R.id.tv_pause_ddo;
                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_pause_ddo);
                        if (textView5 != null) {
                            i4 = R.id.tv_select_ddo;
                            TextView textView6 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_select_ddo);
                            if (textView6 != null) {
                                i4 = R.id.tv_share_ddo;
                                TextView textView7 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_share_ddo);
                                if (textView7 != null) {
                                    i4 = R.id.tv_title_ddo;
                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_title_ddo);
                                    if (textView8 != null) {
                                        return new C1681o((LinearLayout) view, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8);
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

    public static C1681o c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static C1681o d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.dialog_download_options, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f10677a;
    }
}
