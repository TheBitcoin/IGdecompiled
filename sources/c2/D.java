package c2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

public final class D implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f9715a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f9716b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f9717c;

    private D(LinearLayout linearLayout, TextView textView, TextView textView2) {
        this.f9715a = linearLayout;
        this.f9716b = textView;
        this.f9717c = textView2;
    }

    public static D a(View view) {
        int i4 = R.id.tv_answer_faq;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_answer_faq);
        if (textView != null) {
            i4 = R.id.tv_question_faq;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_question_faq);
            if (textView2 != null) {
                return new D((LinearLayout) view, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    public static D c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static D d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.faq, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f9715a;
    }
}
