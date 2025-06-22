package x2;

import M1.I;
import N1.k;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import f2.C2010a;
import f2.C2028t;
import g2.Q;
import kotlin.jvm.internal.m;

public final class H extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    private C2028t f22164a;

    /* renamed from: b  reason: collision with root package name */
    private RelativeLayout f22165b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f22166c;

    /* renamed from: d  reason: collision with root package name */
    private RecyclerView f22167d;

    /* renamed from: e  reason: collision with root package name */
    private LinearLayoutManager f22168e;

    /* renamed from: f  reason: collision with root package name */
    private final I f22169f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public H(View view, C2028t tVar, C2010a aVar) {
        super(view);
        m.e(view, "itemView");
        m.e(tVar, "listener");
        m.e(aVar, "actionsClickListener");
        this.f22164a = tVar;
        View findViewById = view.findViewById(R.id.rl_title_home_recycler_view_top);
        m.d(findViewById, "findViewById(...)");
        this.f22165b = (RelativeLayout) findViewById;
        View findViewById2 = view.findViewById(R.id.tv_title_home_recycler_view_top);
        m.d(findViewById2, "findViewById(...)");
        this.f22166c = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.rv_home_recycler_view_top);
        m.d(findViewById3, "findViewById(...)");
        this.f22167d = (RecyclerView) findViewById3;
        this.f22168e = new LinearLayoutManager(view.getContext(), 0, false);
        I i4 = new I(this.f22164a, aVar, 20);
        this.f22169f = i4;
        this.f22166c.setTypeface(k.f7778g.w());
        this.f22167d.setItemAnimator((RecyclerView.ItemAnimator) null);
        this.f22167d.setLayoutManager(this.f22168e);
        this.f22167d.setAdapter(i4);
    }

    /* access modifiers changed from: private */
    public static final void c(H h4, Q q4, View view) {
        h4.f22164a.c(q4);
    }

    public final void b(Q q4) {
        m.e(q4, "topByCategory");
        if (!q4.a().isEmpty()) {
            this.f22165b.setOnClickListener(new G(this, q4));
            this.f22166c.setText(q4.b().d());
            this.f22169f.d(q4.a());
            return;
        }
        this.itemView.setVisibility(8);
    }

    public final I d() {
        return this.f22169f;
    }
}
