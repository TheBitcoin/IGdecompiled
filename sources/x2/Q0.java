package x2;

import M1.C1532i;
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

public final class Q0 extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    private C2028t f22254a;

    /* renamed from: b  reason: collision with root package name */
    private RelativeLayout f22255b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f22256c;

    /* renamed from: d  reason: collision with root package name */
    private final C1532i f22257d;

    /* renamed from: e  reason: collision with root package name */
    private RecyclerView f22258e;

    /* renamed from: f  reason: collision with root package name */
    private LinearLayoutManager f22259f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Q0(View view, C2028t tVar, C2010a aVar) {
        super(view);
        m.e(view, "itemView");
        m.e(tVar, "listener");
        m.e(aVar, "actionsClickListener");
        this.f22254a = tVar;
        View findViewById = view.findViewById(R.id.rl_title_home_recycler_view_top);
        m.d(findViewById, "findViewById(...)");
        this.f22255b = (RelativeLayout) findViewById;
        View findViewById2 = view.findViewById(R.id.tv_title_home_recycler_view_top);
        m.d(findViewById2, "findViewById(...)");
        this.f22256c = (TextView) findViewById2;
        C1532i iVar = new C1532i(this.f22254a, aVar);
        this.f22257d = iVar;
        View findViewById3 = view.findViewById(R.id.rv_home_recycler_view_top);
        m.d(findViewById3, "findViewById(...)");
        this.f22258e = (RecyclerView) findViewById3;
        this.f22259f = new LinearLayoutManager(view.getContext(), 0, false);
        this.f22256c.setTypeface(k.f7778g.w());
        this.f22258e.setLayoutManager(this.f22259f);
        this.f22258e.setItemAnimator((RecyclerView.ItemAnimator) null);
        this.f22258e.setAdapter(iVar);
    }

    /* access modifiers changed from: private */
    public static final void c(Q0 q02, Q q4, View view) {
        q02.f22254a.c(q4);
    }

    public final void b(Q q4) {
        m.e(q4, "topByCategory");
        this.f22255b.setOnClickListener(new P0(this, q4));
        this.f22256c.setText(q4.b().d());
        if (m.a(q4.b().d(), this.itemView.getContext().getResources().getString(R.string.top_downloads_title))) {
            this.f22257d.b(q4.a(), true);
        } else {
            this.f22257d.b(q4.a(), false);
        }
    }

    public final C1532i d() {
        return this.f22257d;
    }
}
