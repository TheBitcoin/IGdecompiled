package x2;

import N1.k;
import S2.C1601o;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import f2.C2028t;
import g2.C2053k;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.m;

/* renamed from: x2.w  reason: case insensitive filesystem */
public final class C2400w extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    private C2028t f22537a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f22538b;

    /* renamed from: c  reason: collision with root package name */
    private LinearLayout f22539c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2400w(View view, C2028t tVar) {
        super(view);
        m.e(view, "itemView");
        m.e(tVar, "listener");
        this.f22537a = tVar;
        View findViewById = view.findViewById(R.id.tv_floating_categories);
        m.d(findViewById, "findViewById(...)");
        this.f22538b = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.ll_floating_categories);
        m.d(findViewById2, "findViewById(...)");
        this.f22539c = (LinearLayout) findViewById2;
        this.f22538b.setTypeface(k.f7778g.w());
    }

    private final void c(ArrayList arrayList) {
        Iterator it = arrayList.iterator();
        m.d(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            m.d(next, "next(...)");
            C2053k kVar = (C2053k) next;
            View inflate = LayoutInflater.from(this.itemView.getContext()).inflate(R.layout.home_header_category, this.f22539c, false);
            m.c(inflate, "null cannot be cast to non-null type android.widget.TextView");
            TextView textView = (TextView) inflate;
            textView.setTypeface(k.f7778g.w());
            textView.setText(kVar.d());
            if (m.a(kVar, C1601o.P(arrayList))) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.setMargins((int) this.itemView.getContext().getResources().getDimension(R.dimen.margin_m), 0, (int) this.itemView.getContext().getResources().getDimension(R.dimen.margin_m), 0);
                textView.setLayoutParams(layoutParams);
            }
            textView.setOnClickListener(new C2398v(this, kVar));
            this.f22539c.addView(textView);
        }
    }

    /* access modifiers changed from: private */
    public static final void d(C2400w wVar, C2053k kVar, View view) {
        wVar.f22537a.b(kVar);
    }

    public final void b(ArrayList arrayList) {
        m.e(arrayList, "floatingCategories");
        this.f22538b.setText(this.itemView.getContext().getString(R.string.it_may_interest_you));
        if (this.f22539c.getChildCount() == 0) {
            c(arrayList);
        }
    }
}
