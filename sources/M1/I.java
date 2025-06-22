package M1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.mbridge.msdk.MBridgeConstans;
import com.uptodown.R;
import f2.C2010a;
import f2.C2013d;
import g2.C2050h;
import java.util.ArrayList;
import kotlin.jvm.internal.m;
import x2.C2375j;

public final class I extends RecyclerView.Adapter {

    /* renamed from: a  reason: collision with root package name */
    private C2013d f7450a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public C2010a f7451b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public int f7452c;

    /* renamed from: d  reason: collision with root package name */
    private ArrayList f7453d = new ArrayList();

    public final class a extends C2375j {

        /* renamed from: b  reason: collision with root package name */
        private C2013d f7454b;

        /* renamed from: c  reason: collision with root package name */
        private final ImageView f7455c;

        /* renamed from: d  reason: collision with root package name */
        private final ProgressBar f7456d;

        /* renamed from: e  reason: collision with root package name */
        private final TextView f7457e;

        /* renamed from: f  reason: collision with root package name */
        private final TextView f7458f;

        /* renamed from: g  reason: collision with root package name */
        private final TextView f7459g;

        /* renamed from: h  reason: collision with root package name */
        private final TextView f7460h;

        /* renamed from: i  reason: collision with root package name */
        private final LinearLayout f7461i;

        /* renamed from: j  reason: collision with root package name */
        private final TextView f7462j;

        /* renamed from: k  reason: collision with root package name */
        final /* synthetic */ I f7463k;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public a(M1.I r5, android.view.View r6, f2.C2013d r7) {
            /*
                r4 = this;
                java.lang.String r0 = "itemView"
                kotlin.jvm.internal.m.e(r6, r0)
                java.lang.String r0 = "listener"
                kotlin.jvm.internal.m.e(r7, r0)
                r4.f7463k = r5
                android.content.Context r5 = r6.getContext()
                java.lang.String r0 = "getContext(...)"
                kotlin.jvm.internal.m.d(r5, r0)
                r4.<init>(r6, r5)
                r4.f7454b = r7
                r5 = 2131362382(0x7f0a024e, float:1.8344543E38)
                android.view.View r5 = r6.findViewById(r5)
                java.lang.String r7 = "findViewById(...)"
                kotlin.jvm.internal.m.d(r5, r7)
                android.widget.ImageView r5 = (android.widget.ImageView) r5
                r4.f7455c = r5
                r5 = 2131363026(0x7f0a04d2, float:1.834585E38)
                android.view.View r5 = r6.findViewById(r5)
                kotlin.jvm.internal.m.d(r5, r7)
                android.widget.ProgressBar r5 = (android.widget.ProgressBar) r5
                r4.f7456d = r5
                r5 = 2131364290(0x7f0a09c2, float:1.8348413E38)
                android.view.View r5 = r6.findViewById(r5)
                kotlin.jvm.internal.m.d(r5, r7)
                android.widget.TextView r5 = (android.widget.TextView) r5
                r4.f7457e = r5
                r0 = 2131364128(0x7f0a0920, float:1.8348084E38)
                android.view.View r0 = r6.findViewById(r0)
                kotlin.jvm.internal.m.d(r0, r7)
                android.widget.TextView r0 = (android.widget.TextView) r0
                r4.f7458f = r0
                r1 = 2131364086(0x7f0a08f6, float:1.8348E38)
                android.view.View r1 = r6.findViewById(r1)
                kotlin.jvm.internal.m.d(r1, r7)
                android.widget.TextView r1 = (android.widget.TextView) r1
                r4.f7459g = r1
                r2 = 2131364377(0x7f0a0a19, float:1.834859E38)
                android.view.View r2 = r6.findViewById(r2)
                kotlin.jvm.internal.m.d(r2, r7)
                android.widget.TextView r2 = (android.widget.TextView) r2
                r4.f7460h = r2
                r3 = 2131362628(0x7f0a0344, float:1.8345042E38)
                android.view.View r3 = r6.findViewById(r3)
                kotlin.jvm.internal.m.d(r3, r7)
                android.widget.LinearLayout r3 = (android.widget.LinearLayout) r3
                r4.f7461i = r3
                r3 = 2131364213(0x7f0a0975, float:1.8348257E38)
                android.view.View r6 = r6.findViewById(r3)
                kotlin.jvm.internal.m.d(r6, r7)
                android.widget.TextView r6 = (android.widget.TextView) r6
                r4.f7462j = r6
                N1.k$a r7 = N1.k.f7778g
                android.graphics.Typeface r3 = r7.w()
                r5.setTypeface(r3)
                android.graphics.Typeface r5 = r7.x()
                r0.setTypeface(r5)
                android.graphics.Typeface r5 = r7.x()
                r6.setTypeface(r5)
                android.graphics.Typeface r5 = r7.x()
                r1.setTypeface(r5)
                android.graphics.Typeface r5 = r7.x()
                r2.setTypeface(r5)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: M1.I.a.<init>(M1.I, android.view.View, f2.d):void");
        }

        /* access modifiers changed from: private */
        public static final boolean n(I i4, C2050h hVar, int i5, View view) {
            i4.f7451b.a(hVar, i5);
            return true;
        }

        public final void m(C2050h hVar, int i4) {
            m.e(hVar, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) this.itemView.getContext().getResources().getDimension(R.dimen.top_horizontal_card_width), -2);
            View view = this.itemView;
            Context context = view.getContext();
            m.d(context, "getContext(...)");
            view.setLayoutParams(b(layoutParams, context, i4, this.f7463k.f7452c));
            View view2 = this.itemView;
            m.d(view2, "itemView");
            c(view2, this.f7454b, hVar);
            this.itemView.setOnLongClickListener(new H(this.f7463k, hVar, i4));
            i(hVar, this.f7457e, this.f7458f);
            h(this.f7455c, hVar.E());
            e(hVar, this.f7456d, this.f7455c, this.f7458f, this.f7459g, this.f7462j, this.f7461i);
        }
    }

    public I(C2013d dVar, C2010a aVar, int i4) {
        m.e(dVar, "listener");
        m.e(aVar, "actionsClickListener");
        this.f7450a = dVar;
        this.f7451b = aVar;
        this.f7452c = i4;
    }

    public final ArrayList c() {
        return this.f7453d;
    }

    public final void d(ArrayList arrayList) {
        m.e(arrayList, "appList");
        ArrayList arrayList2 = this.f7453d;
        arrayList2.clear();
        arrayList2.addAll(arrayList);
        notifyDataSetChanged();
    }

    public int getItemCount() {
        return this.f7453d.size();
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i4) {
        m.e(viewHolder, "holder");
        Object obj = this.f7453d.get(i4);
        m.d(obj, "get(...)");
        ((a) viewHolder).m((C2050h) obj, i4 + 1);
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i4) {
        m.e(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card, viewGroup, false);
        m.b(inflate);
        return new a(this, inflate, this.f7450a);
    }
}
