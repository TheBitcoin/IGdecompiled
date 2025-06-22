package x2;

import M1.C1527d;
import M1.C1530g;
import N1.k;
import S2.C1601o;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import f2.C2010a;
import f2.C2028t;
import g2.C2053k;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.m;
import w2.f;

public final class D extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    private C2028t f22117a;

    /* renamed from: b  reason: collision with root package name */
    private RecyclerView f22118b;

    /* renamed from: c  reason: collision with root package name */
    private C1530g f22119c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public LinearLayoutManager f22120d;

    /* renamed from: e  reason: collision with root package name */
    private LinearLayout f22121e;

    /* renamed from: f  reason: collision with root package name */
    private final f f22122f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public int f22123g = 102;

    public static final class a extends RecyclerView.OnScrollListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ D f22124a;

        a(D d5) {
            this.f22124a = d5;
        }

        public void onScrollStateChanged(RecyclerView recyclerView, int i4) {
            m.e(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, i4);
            D d5 = this.f22124a;
            d5.f22123g = d5.f22120d.findFirstCompletelyVisibleItemPosition();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public D(View view, C2028t tVar, C2010a aVar) {
        super(view);
        m.e(view, "itemView");
        m.e(aVar, "actionsClickListener");
        this.f22117a = tVar;
        View findViewById = view.findViewById(R.id.rv_home_features);
        m.d(findViewById, "findViewById(...)");
        this.f22118b = (RecyclerView) findViewById;
        this.f22119c = new C1530g(this.f22117a, aVar);
        this.f22120d = new LinearLayoutManager(view.getContext(), 0, false);
        View findViewById2 = view.findViewById(R.id.ll_categories);
        m.d(findViewById2, "findViewById(...)");
        this.f22121e = (LinearLayout) findViewById2;
        f fVar = new f();
        this.f22122f = fVar;
        fVar.attachToRecyclerView(this.f22118b);
        this.f22118b.setLayoutManager(this.f22120d);
        this.f22118b.setAdapter(this.f22119c);
        this.f22118b.addOnScrollListener(new a(this));
    }

    private final void e(ArrayList arrayList) {
        Iterator it = arrayList.iterator();
        m.d(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            m.d(next, "next(...)");
            C2053k kVar = (C2053k) next;
            View inflate = LayoutInflater.from(this.itemView.getContext()).inflate(R.layout.home_header_category, this.f22121e, false);
            m.c(inflate, "null cannot be cast to non-null type android.widget.TextView");
            TextView textView = (TextView) inflate;
            textView.setTypeface(k.f7778g.w());
            textView.setText(kVar.d());
            if (m.a(kVar, C1601o.P(arrayList))) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.setMargins((int) this.itemView.getContext().getResources().getDimension(R.dimen.margin_m), 0, (int) this.itemView.getContext().getResources().getDimension(R.dimen.margin_m), 0);
                textView.setLayoutParams(layoutParams);
            }
            textView.setOnClickListener(new C2352C(this, kVar));
            this.f22121e.addView(textView);
        }
    }

    /* access modifiers changed from: private */
    public static final void f(D d5, C2053k kVar, View view) {
        C2028t tVar = d5.f22117a;
        if (tVar != null) {
            tVar.b(kVar);
        }
    }

    public final void d(C1527d.b bVar) {
        m.e(bVar, "homeHeader");
        if (!bVar.b().isEmpty()) {
            this.f22118b.scrollToPosition(this.f22123g);
            this.f22118b.smoothScrollBy(1, 0);
            this.f22119c.c(bVar.b());
        }
        if (this.f22121e.getChildCount() == 0) {
            e(bVar.a());
        }
    }
}
