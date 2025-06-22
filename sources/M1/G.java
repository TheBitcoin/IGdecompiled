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

public final class G extends RecyclerView.Adapter {

    /* renamed from: a  reason: collision with root package name */
    private C2013d f7432a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final C2010a f7433b;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList f7434c = new ArrayList();

    public final class a extends C2375j {

        /* renamed from: b  reason: collision with root package name */
        private C2013d f7435b;

        /* renamed from: c  reason: collision with root package name */
        private final ImageView f7436c;

        /* renamed from: d  reason: collision with root package name */
        private final ProgressBar f7437d;

        /* renamed from: e  reason: collision with root package name */
        private final TextView f7438e;

        /* renamed from: f  reason: collision with root package name */
        private final TextView f7439f;

        /* renamed from: g  reason: collision with root package name */
        private final TextView f7440g;

        /* renamed from: h  reason: collision with root package name */
        private final TextView f7441h;

        /* renamed from: i  reason: collision with root package name */
        private final TextView f7442i;

        /* renamed from: j  reason: collision with root package name */
        private final TextView f7443j;

        /* renamed from: k  reason: collision with root package name */
        private final LinearLayout f7444k;

        /* renamed from: l  reason: collision with root package name */
        private final RelativeLayout f7445l;

        /* renamed from: m  reason: collision with root package name */
        final /* synthetic */ G f7446m;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public a(M1.G r7, android.view.View r8, f2.C2013d r9) {
            /*
                r6 = this;
                java.lang.String r0 = "itemView"
                kotlin.jvm.internal.m.e(r8, r0)
                java.lang.String r0 = "listener"
                kotlin.jvm.internal.m.e(r9, r0)
                r6.f7446m = r7
                android.content.Context r7 = r8.getContext()
                java.lang.String r0 = "getContext(...)"
                kotlin.jvm.internal.m.d(r7, r0)
                r6.<init>(r8, r7)
                r6.f7435b = r9
                r7 = 2131362383(0x7f0a024f, float:1.8344545E38)
                android.view.View r7 = r8.findViewById(r7)
                java.lang.String r9 = "findViewById(...)"
                kotlin.jvm.internal.m.d(r7, r9)
                android.widget.ImageView r7 = (android.widget.ImageView) r7
                r6.f7436c = r7
                r7 = 2131363027(0x7f0a04d3, float:1.8345851E38)
                android.view.View r7 = r8.findViewById(r7)
                kotlin.jvm.internal.m.d(r7, r9)
                android.widget.ProgressBar r7 = (android.widget.ProgressBar) r7
                r6.f7437d = r7
                r7 = 2131364293(0x7f0a09c5, float:1.8348419E38)
                android.view.View r7 = r8.findViewById(r7)
                kotlin.jvm.internal.m.d(r7, r9)
                android.widget.TextView r7 = (android.widget.TextView) r7
                r6.f7438e = r7
                r0 = 2131364008(0x7f0a08a8, float:1.834784E38)
                android.view.View r0 = r8.findViewById(r0)
                kotlin.jvm.internal.m.d(r0, r9)
                android.widget.TextView r0 = (android.widget.TextView) r0
                r6.f7439f = r0
                r1 = 2131364131(0x7f0a0923, float:1.834809E38)
                android.view.View r1 = r8.findViewById(r1)
                kotlin.jvm.internal.m.d(r1, r9)
                android.widget.TextView r1 = (android.widget.TextView) r1
                r6.f7440g = r1
                r2 = 2131364214(0x7f0a0976, float:1.8348259E38)
                android.view.View r2 = r8.findViewById(r2)
                kotlin.jvm.internal.m.d(r2, r9)
                android.widget.TextView r2 = (android.widget.TextView) r2
                r6.f7441h = r2
                r3 = 2131364087(0x7f0a08f7, float:1.8348001E38)
                android.view.View r3 = r8.findViewById(r3)
                kotlin.jvm.internal.m.d(r3, r9)
                android.widget.TextView r3 = (android.widget.TextView) r3
                r6.f7442i = r3
                r4 = 2131364378(0x7f0a0a1a, float:1.8348591E38)
                android.view.View r4 = r8.findViewById(r4)
                kotlin.jvm.internal.m.d(r4, r9)
                android.widget.TextView r4 = (android.widget.TextView) r4
                r6.f7443j = r4
                r5 = 2131362629(0x7f0a0345, float:1.8345044E38)
                android.view.View r5 = r8.findViewById(r5)
                kotlin.jvm.internal.m.d(r5, r9)
                android.widget.LinearLayout r5 = (android.widget.LinearLayout) r5
                r6.f7444k = r5
                r5 = 2131363137(0x7f0a0541, float:1.8346074E38)
                android.view.View r8 = r8.findViewById(r5)
                kotlin.jvm.internal.m.d(r8, r9)
                android.widget.RelativeLayout r8 = (android.widget.RelativeLayout) r8
                r6.f7445l = r8
                N1.k$a r8 = N1.k.f7778g
                android.graphics.Typeface r9 = r8.w()
                r0.setTypeface(r9)
                android.graphics.Typeface r9 = r8.w()
                r7.setTypeface(r9)
                android.graphics.Typeface r7 = r8.x()
                r1.setTypeface(r7)
                android.graphics.Typeface r7 = r8.x()
                r2.setTypeface(r7)
                android.graphics.Typeface r7 = r8.x()
                r3.setTypeface(r7)
                android.graphics.Typeface r7 = r8.x()
                r4.setTypeface(r7)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: M1.G.a.<init>(M1.G, android.view.View, f2.d):void");
        }

        /* access modifiers changed from: private */
        public static final boolean n(G g4, C2050h hVar, int i4, View view) {
            g4.f7433b.a(hVar, i4);
            return true;
        }

        public final void m(C2050h hVar, int i4, int i5) {
            m.e(hVar, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            if (i4 >= 10) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams2.setMarginStart((int) this.itemView.getContext().getResources().getDimension(R.dimen.top_card_margin_index_ten));
                this.f7445l.setLayoutParams(layoutParams2);
            } else {
                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams3.setMarginStart((int) this.itemView.getContext().getResources().getDimension(R.dimen.top_download_horizontal_card_margin));
                this.f7445l.setLayoutParams(layoutParams3);
            }
            View view = this.itemView;
            Context context = view.getContext();
            m.d(context, "getContext(...)");
            view.setLayoutParams(b(layoutParams, context, i4, 20));
            this.f7439f.setText(String.valueOf(i4));
            View view2 = this.itemView;
            m.d(view2, "itemView");
            c(view2, this.f7435b, hVar);
            this.itemView.setOnLongClickListener(new F(this.f7446m, hVar, i5));
            i(hVar, this.f7438e, this.f7440g);
            h(this.f7436c, hVar.E());
            e(hVar, this.f7437d, this.f7436c, this.f7440g, this.f7442i, this.f7441h, this.f7444k);
        }
    }

    public G(C2013d dVar, C2010a aVar) {
        m.e(dVar, "listener");
        m.e(aVar, "actionsClickListener");
        this.f7432a = dVar;
        this.f7433b = aVar;
    }

    public final ArrayList b() {
        return this.f7434c;
    }

    public final void c(ArrayList arrayList) {
        m.e(arrayList, "appList");
        ArrayList arrayList2 = this.f7434c;
        arrayList2.clear();
        arrayList2.addAll(arrayList);
        notifyDataSetChanged();
    }

    public int getItemCount() {
        return this.f7434c.size();
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i4) {
        m.e(viewHolder, "holder");
        Object obj = this.f7434c.get(i4);
        m.d(obj, "get(...)");
        ((a) viewHolder).m((C2050h) obj, i4 + 1, i4);
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i4) {
        m.e(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_top_download, viewGroup, false);
        m.b(inflate);
        return new a(this, inflate, this.f7432a);
    }
}
