package x2;

import M1.d0;
import N1.k;
import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import com.uptodown.activities.preferences.a;
import f2.C2010a;
import f2.C2028t;
import g2.C2050h;
import g2.Q;
import java.util.ArrayList;
import kotlin.jvm.internal.m;
import w2.f;

public final class A1 extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    private C2028t f22096a;

    /* renamed from: b  reason: collision with root package name */
    private RelativeLayout f22097b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f22098c;

    /* renamed from: d  reason: collision with root package name */
    private RecyclerView f22099d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public LinearLayoutManager f22100e;

    /* renamed from: f  reason: collision with root package name */
    private final d0 f22101f;

    public static final class a extends RecyclerView.OnScrollListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ A1 f22102a;

        a(A1 a12) {
            this.f22102a = a12;
        }

        public void onScrollStateChanged(RecyclerView recyclerView, int i4) {
            m.e(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, i4);
            if (!this.f22102a.e().o()) {
                this.f22102a.e().x(true);
            }
            if (i4 == 0) {
                int findFirstCompletelyVisibleItemPosition = this.f22102a.f22100e.findFirstCompletelyVisibleItemPosition();
                int findLastCompletelyVisibleItemPosition = this.f22102a.f22100e.findLastCompletelyVisibleItemPosition();
                int n4 = this.f22102a.e().n();
                if (findLastCompletelyVisibleItemPosition == this.f22102a.f22100e.getItemCount() - 1 && findLastCompletelyVisibleItemPosition != this.f22102a.e().n()) {
                    this.f22102a.e().u(findLastCompletelyVisibleItemPosition);
                    ArrayList y02 = ((C2050h) this.f22102a.e().m().get(n4)).y0();
                    if (y02 != null && !y02.isEmpty()) {
                        this.f22102a.e().notifyItemChanged(n4);
                    }
                    ArrayList y03 = ((C2050h) this.f22102a.e().m().get(findLastCompletelyVisibleItemPosition)).y0();
                    if (y03 != null && !y03.isEmpty()) {
                        this.f22102a.e().notifyItemChanged(findLastCompletelyVisibleItemPosition);
                    }
                } else if (findFirstCompletelyVisibleItemPosition != -1 && findFirstCompletelyVisibleItemPosition != this.f22102a.e().n()) {
                    this.f22102a.e().u(findFirstCompletelyVisibleItemPosition);
                    ArrayList y04 = ((C2050h) this.f22102a.e().m().get(n4)).y0();
                    if (y04 != null && !y04.isEmpty()) {
                        this.f22102a.e().notifyItemChanged(n4);
                    }
                    ArrayList y05 = ((C2050h) this.f22102a.e().m().get(findFirstCompletelyVisibleItemPosition)).y0();
                    if (y05 != null && !y05.isEmpty()) {
                        this.f22102a.e().notifyItemChanged(findFirstCompletelyVisibleItemPosition);
                    }
                }
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public A1(View view, C2028t tVar, C2010a aVar, String str) {
        super(view);
        m.e(view, "itemView");
        m.e(tVar, "listener");
        m.e(aVar, "actionsClickListener");
        m.e(str, "fragmentName");
        this.f22096a = tVar;
        View findViewById = view.findViewById(R.id.rl_title_home_recycler_view_top);
        m.d(findViewById, "findViewById(...)");
        this.f22097b = (RelativeLayout) findViewById;
        View findViewById2 = view.findViewById(R.id.tv_title_home_recycler_view_top);
        m.d(findViewById2, "findViewById(...)");
        this.f22098c = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.rv_home_recycler_view_top);
        m.d(findViewById3, "findViewById(...)");
        this.f22099d = (RecyclerView) findViewById3;
        this.f22100e = new LinearLayoutManager(view.getContext(), 0, false);
        C2028t tVar2 = this.f22096a;
        Context context = view.getContext();
        m.d(context, "getContext(...)");
        d0 d0Var = new d0(tVar2, aVar, context, str);
        this.f22101f = d0Var;
        new f().attachToRecyclerView(this.f22099d);
        this.f22098c.setTypeface(k.f7778g.w());
        this.f22099d.setLayoutManager(this.f22100e);
        this.f22099d.setItemAnimator((RecyclerView.ItemAnimator) null);
        this.f22099d.setAdapter(d0Var);
        a.C0236a aVar2 = com.uptodown.activities.preferences.a.f18818a;
        Context context2 = view.getContext();
        m.d(context2, "getContext(...)");
        if (!aVar2.L(context2)) {
            this.f22099d.addOnScrollListener(new a(this));
        }
    }

    /* access modifiers changed from: private */
    public static final void d(A1 a12, Q q4, View view) {
        a12.f22096a.c(q4);
    }

    public final void c(Q q4) {
        m.e(q4, "topByCategory");
        this.f22097b.setOnClickListener(new z1(this, q4));
        this.f22098c.setText(q4.b().d());
        this.f22101f.v(q4.a());
    }

    public final d0 e() {
        return this.f22101f;
    }
}
