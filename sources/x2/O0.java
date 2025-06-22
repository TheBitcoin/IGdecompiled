package x2;

import N1.k;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import kotlin.jvm.internal.m;
import w2.s;

public final class O0 extends RecyclerView.ViewHolder {

    public static final class a implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TextView f22234a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f22235b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f22236c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f22237d;

        a(TextView textView, View view, String str, String str2) {
            this.f22234a = textView;
            this.f22235b = view;
            this.f22236c = str;
            this.f22237d = str2;
        }

        /* access modifiers changed from: private */
        public static final void b(TextView textView, View view, TextView textView2, String str, String str2, View view2) {
            if (textView.getMaxLines() == 3) {
                textView.setMaxLines(Integer.MAX_VALUE);
                view.setVisibility(8);
                textView2.setText(str);
                return;
            }
            textView.setMaxLines(3);
            view.setVisibility(0);
            textView2.setText(str2);
        }

        public boolean onPreDraw() {
            this.f22234a.getViewTreeObserver().removeOnPreDrawListener(this);
            if (!s.a(this.f22234a)) {
                return true;
            }
            View findViewById = this.f22235b.findViewById(R.id.shadow_description_category_description);
            TextView textView = (TextView) this.f22235b.findViewById(R.id.tv_read_more_category_description);
            textView.setTypeface(k.f7778g.w());
            textView.setVisibility(0);
            textView.setOnClickListener(new N0(this.f22234a, findViewById, textView, this.f22236c, this.f22237d));
            findViewById.setVisibility(0);
            return true;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public O0(View view, String str, String str2, String str3, String str4) {
        super(view);
        m.e(view, "itemView");
        m.e(str3, "readMore");
        m.e(str4, "readLess");
        if (str == null || str.length() == 0) {
            view.setVisibility(8);
            return;
        }
        View findViewById = view.findViewById(R.id.tv_top_by_category_description);
        m.d(findViewById, "findViewById(...)");
        TextView textView = (TextView) findViewById;
        k.a aVar = k.f7778g;
        textView.setTypeface(aVar.x());
        textView.setText(str);
        textView.getViewTreeObserver().addOnPreDrawListener(new a(textView, view, str4, str3));
        if (str2 != null && str2.length() != 0) {
            View findViewById2 = view.findViewById(R.id.tv_top_by_category_title);
            m.d(findViewById2, "findViewById(...)");
            TextView textView2 = (TextView) findViewById2;
            textView2.setTypeface(aVar.w());
            textView2.setText(str2);
            textView2.setVisibility(0);
        }
    }
}
