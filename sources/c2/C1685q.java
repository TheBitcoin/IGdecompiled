package c2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

/* renamed from: c2.q  reason: case insensitive filesystem */
public final class C1685q implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f10704a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f10705b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f10706c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f10707d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f10708e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f10709f;

    private C1685q(RelativeLayout relativeLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        this.f10704a = relativeLayout;
        this.f10705b = textView;
        this.f10706c = textView2;
        this.f10707d = textView3;
        this.f10708e = textView4;
        this.f10709f = textView5;
    }

    public static C1685q a(View view) {
        int i4 = R.id.tv_cancel_dialog_no_wifi_connection;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_cancel_dialog_no_wifi_connection);
        if (textView != null) {
            i4 = R.id.tv_description_dialog_no_wifi_connection;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_description_dialog_no_wifi_connection);
            if (textView2 != null) {
                i4 = R.id.tv_ok_dialog_no_wifi_connection;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_ok_dialog_no_wifi_connection);
                if (textView3 != null) {
                    i4 = R.id.tv_settings_dialog_no_wifi_connection;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_settings_dialog_no_wifi_connection);
                    if (textView4 != null) {
                        i4 = R.id.tv_title_dialog_no_wifi_connection;
                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_title_dialog_no_wifi_connection);
                        if (textView5 != null) {
                            return new C1685q((RelativeLayout) view, textView, textView2, textView3, textView4, textView5);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    public static C1685q c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static C1685q d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.dialog_no_wifi_connection, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f10704a;
    }
}
