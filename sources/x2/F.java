package x2;

import M1.G;
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

public final class F extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    private C2028t f22150a;

    /* renamed from: b  reason: collision with root package name */
    private RelativeLayout f22151b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f22152c;

    /* renamed from: d  reason: collision with root package name */
    private RecyclerView f22153d;

    /* renamed from: e  reason: collision with root package name */
    private LinearLayoutManager f22154e;

    /* renamed from: f  reason: collision with root package name */
    private final G f22155f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public F(View view, C2028t tVar, C2010a aVar) {
        super(view);
        m.e(view, "itemView");
        m.e(tVar, "listener");
        m.e(aVar, "actionsClickListener");
        this.f22150a = tVar;
        View findViewById = view.findViewById(R.id.rl_title_home_recycler_view_top);
        m.d(findViewById, "findViewById(...)");
        this.f22151b = (RelativeLayout) findViewById;
        View findViewById2 = view.findViewById(R.id.tv_title_home_recycler_view_top);
        m.d(findViewById2, "findViewById(...)");
        this.f22152c = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.rv_home_recycler_view_top);
        m.d(findViewById3, "findViewById(...)");
        this.f22153d = (RecyclerView) findViewById3;
        this.f22154e = new LinearLayoutManager(view.getContext(), 0, false);
        G g4 = new G(this.f22150a, aVar);
        this.f22155f = g4;
        this.f22152c.setTypeface(k.f7778g.w());
        this.f22153d.setLayoutManager(this.f22154e);
        this.f22153d.setItemAnimator((RecyclerView.ItemAnimator) null);
        this.f22153d.setAdapter(g4);
    }

    /* access modifiers changed from: private */
    public static final void c(F f4, Q q4, View view) {
        f4.f22150a.c(q4);
    }

    public final void b(Q q4) {
        m.e(q4, "topByCategory");
        this.f22151b.setOnClickListener(new E(this, q4));
        this.f22152c.setText(q4.b().d());
        this.f22155f.c(q4.a());
    }

    public final G d() {
        return this.f22155f;
    }
}
