package x2;

import N1.k;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import f2.C2009H;
import kotlin.jvm.internal.m;
import u2.F;

public final class D1 extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f22142a;

    /* renamed from: b  reason: collision with root package name */
    private final TextView f22143b;

    /* renamed from: c  reason: collision with root package name */
    private final TextView f22144c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public D1(View view, C2009H h4) {
        super(view);
        m.e(view, "itemView");
        m.e(h4, "listener");
        View findViewById = view.findViewById(R.id.ll_no_tracking_container_updates);
        m.d(findViewById, "findViewById(...)");
        this.f22142a = (LinearLayout) findViewById;
        View findViewById2 = view.findViewById(R.id.tv_no_tracking_msg_updates);
        m.d(findViewById2, "findViewById(...)");
        TextView textView = (TextView) findViewById2;
        this.f22143b = textView;
        View findViewById3 = view.findViewById(R.id.tv_gdpr_set_up_updates);
        m.d(findViewById3, "findViewById(...)");
        TextView textView2 = (TextView) findViewById3;
        this.f22144c = textView2;
        k.a aVar = k.f7778g;
        textView.setTypeface(aVar.x());
        textView.setText(F.f21886a.d(view.getContext().getString(R.string.gdpr_no_tracking_enabled)));
        textView2.setTypeface(aVar.w());
        textView2.setOnClickListener(new C1(h4));
    }

    /* access modifiers changed from: private */
    public static final void b(C2009H h4, View view) {
        h4.a();
    }

    public final void c(boolean z4) {
        if (z4) {
            this.f22142a.setVisibility(0);
        } else {
            this.f22142a.setVisibility(8);
        }
    }
}
