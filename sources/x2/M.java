package x2;

import N1.k;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import kotlin.jvm.internal.m;

public final class M extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f22211a;

    /* renamed from: b  reason: collision with root package name */
    private final RelativeLayout f22212b;

    /* renamed from: c  reason: collision with root package name */
    private final RelativeLayout f22213c;

    /* renamed from: d  reason: collision with root package name */
    private final TextView f22214d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public M(View view) {
        super(view);
        m.e(view, "itemView");
        View findViewById = view.findViewById(R.id.rl_old_versions_footer);
        m.d(findViewById, "findViewById(...)");
        this.f22211a = (RelativeLayout) findViewById;
        View findViewById2 = view.findViewById(R.id.rl_back_versions);
        m.d(findViewById2, "findViewById(...)");
        this.f22212b = (RelativeLayout) findViewById2;
        View findViewById3 = view.findViewById(R.id.rl_forward_versions);
        m.d(findViewById3, "findViewById(...)");
        this.f22213c = (RelativeLayout) findViewById3;
        View findViewById4 = view.findViewById(R.id.tv_current_page_versions);
        m.d(findViewById4, "findViewById(...)");
        TextView textView = (TextView) findViewById4;
        this.f22214d = textView;
        textView.setTypeface(k.f7778g.w());
    }

    public final RelativeLayout a() {
        return this.f22212b;
    }

    public final RelativeLayout b() {
        return this.f22213c;
    }

    public final RelativeLayout c() {
        return this.f22211a;
    }

    public final TextView d() {
        return this.f22214d;
    }
}
