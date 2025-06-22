package M1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import c2.I;
import com.mbridge.msdk.MBridgeConstans;
import com.squareup.picasso.s;
import com.squareup.picasso.w;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import f2.C2011b;
import g2.C2050h;
import java.util.ArrayList;
import kotlin.jvm.internal.m;
import x2.C2375j;

/* renamed from: M1.x  reason: case insensitive filesystem */
public final class C1546x extends RecyclerView.Adapter {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList f7721a;

    /* renamed from: b  reason: collision with root package name */
    private C2011b f7722b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public int f7723c;

    /* renamed from: M1.x$a */
    public final class a extends C2375j {

        /* renamed from: b  reason: collision with root package name */
        private final I f7724b;

        /* renamed from: c  reason: collision with root package name */
        private C2011b f7725c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ C1546x f7726d;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public a(M1.C1546x r3, c2.I r4, f2.C2011b r5) {
            /*
                r2 = this;
                java.lang.String r0 = "binding"
                kotlin.jvm.internal.m.e(r4, r0)
                java.lang.String r0 = "listener"
                kotlin.jvm.internal.m.e(r5, r0)
                r2.f7726d = r3
                android.widget.RelativeLayout r3 = r4.getRoot()
                java.lang.String r0 = "getRoot(...)"
                kotlin.jvm.internal.m.d(r3, r0)
                android.widget.RelativeLayout r0 = r4.getRoot()
                android.content.Context r0 = r0.getContext()
                java.lang.String r1 = "getContext(...)"
                kotlin.jvm.internal.m.d(r0, r1)
                r2.<init>(r3, r0)
                r2.f7724b = r4
                r2.f7725c = r5
                android.widget.TextView r3 = r4.f9781j
                N1.k$a r5 = N1.k.f7778g
                android.graphics.Typeface r0 = r5.w()
                r3.setTypeface(r0)
                android.widget.TextView r3 = r4.f9779h
                android.graphics.Typeface r4 = r5.x()
                r3.setTypeface(r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: M1.C1546x.a.<init>(M1.x, c2.I, f2.b):void");
        }

        /* access modifiers changed from: private */
        public static final void n(a aVar, int i4, View view) {
            aVar.f7725c.a(i4);
        }

        public final void m(C2050h hVar, int i4) {
            m.e(hVar, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            RelativeLayout b5 = this.f7724b.getRoot();
            Context context = this.itemView.getContext();
            m.d(context, "getContext(...)");
            b5.setLayoutParams(b(layoutParams, context, i4, this.f7726d.f7723c));
            w l4 = s.h().l(hVar.C()).l(R.drawable.shape_bg_placeholder);
            UptodownApp.a aVar = UptodownApp.f17422D;
            Context context2 = this.itemView.getContext();
            m.d(context2, "getContext(...)");
            l4.n(aVar.i0(context2)).i(this.f7724b.f9774c);
            w f4 = s.h().l(hVar.B()).l(R.drawable.shape_bg_placeholder).a().f();
            Context context3 = this.itemView.getContext();
            m.d(context3, "getContext(...)");
            f4.n(aVar.h0(context3)).i(this.f7724b.f9773b);
            this.f7724b.f9781j.setText(hVar.L());
            this.f7724b.f9779h.setText(hVar.j0());
            this.f7724b.getRoot().setOnClickListener(new C1545w(this, i4));
        }
    }

    public C1546x(ArrayList arrayList, C2011b bVar) {
        m.e(arrayList, "apps");
        m.e(bVar, "listener");
        this.f7721a = arrayList;
        this.f7722b = bVar;
        this.f7723c = arrayList.size() - 1;
    }

    /* renamed from: b */
    public void onBindViewHolder(a aVar, int i4) {
        m.e(aVar, "holder");
        Object obj = this.f7721a.get(i4);
        m.d(obj, "get(...)");
        aVar.m((C2050h) obj, i4);
    }

    /* renamed from: c */
    public a onCreateViewHolder(ViewGroup viewGroup, int i4) {
        m.e(viewGroup, "parent");
        I c5 = I.c(LayoutInflater.from(viewGroup.getContext()));
        m.d(c5, "inflate(...)");
        return new a(this, c5, this.f7722b);
    }

    public int getItemCount() {
        return this.f7721a.size();
    }
}
