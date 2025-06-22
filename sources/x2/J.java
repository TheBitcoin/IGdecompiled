package x2;

import M1.C1534k;
import N1.k;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import f2.C2010a;
import f2.C2028t;
import g2.Q;
import kotlin.jvm.internal.m;

public final class J extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    private C2028t f22178a;

    /* renamed from: b  reason: collision with root package name */
    private RelativeLayout f22179b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f22180c;

    /* renamed from: d  reason: collision with root package name */
    private RecyclerView f22181d;

    /* renamed from: e  reason: collision with root package name */
    private GridLayoutManager f22182e;

    /* renamed from: f  reason: collision with root package name */
    private C1534k f22183f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public J(View view, C2028t tVar, C2010a aVar) {
        super(view);
        m.e(view, "itemView");
        m.e(tVar, "listener");
        m.e(aVar, "actionsClickListener");
        this.f22178a = tVar;
        View findViewById = view.findViewById(R.id.rl_title_home_recycler_view_top);
        m.d(findViewById, "findViewById(...)");
        this.f22179b = (RelativeLayout) findViewById;
        View findViewById2 = view.findViewById(R.id.tv_title_home_recycler_view_top);
        m.d(findViewById2, "findViewById(...)");
        this.f22180c = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.rv_home_recycler_view_top);
        m.d(findViewById3, "findViewById(...)");
        this.f22181d = (RecyclerView) findViewById3;
        this.f22182e = new GridLayoutManager(view.getContext(), 3, 0, false);
        this.f22183f = new C1534k(this.f22178a, aVar);
        this.f22180c.setTypeface(k.f7778g.w());
        this.f22181d.setLayoutManager(this.f22182e);
        this.f22181d.setAdapter(this.f22183f);
        this.f22181d.setItemAnimator((RecyclerView.ItemAnimator) null);
    }

    /* access modifiers changed from: private */
    public static final void c(J j4, Q q4, View view) {
        j4.f22178a.c(q4);
    }

    public final void b(Q q4) {
        m.e(q4, "topByCategory");
        this.f22179b.setOnClickListener(new I(this, q4));
        this.f22180c.setText(q4.b().d());
        this.f22183f.d(q4.a());
    }

    public final C1534k d() {
        return this.f22183f;
    }
}
