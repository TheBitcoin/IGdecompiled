package M1;

import N1.k;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.s;
import com.squareup.picasso.w;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import f2.C2010a;
import f2.C2028t;
import g2.C2050h;
import java.util.ArrayList;
import kotlin.jvm.internal.m;

/* renamed from: M1.g  reason: case insensitive filesystem */
public final class C1530g extends RecyclerView.Adapter {

    /* renamed from: a  reason: collision with root package name */
    private final C2028t f7607a;

    /* renamed from: b  reason: collision with root package name */
    private final C2010a f7608b;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList f7609c = new ArrayList();

    /* renamed from: M1.g$a */
    public final class a extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        private C2028t f7610a;

        /* renamed from: b  reason: collision with root package name */
        private C2010a f7611b;

        /* renamed from: c  reason: collision with root package name */
        private final ImageView f7612c;

        /* renamed from: d  reason: collision with root package name */
        private final TextView f7613d;

        /* renamed from: e  reason: collision with root package name */
        private final TextView f7614e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ C1530g f7615f;

        /* renamed from: M1.g$a$a  reason: collision with other inner class name */
        public /* synthetic */ class C0093a {

            /* renamed from: a  reason: collision with root package name */
            public static final /* synthetic */ int[] f7616a;

            /* JADX WARNING: Can't wrap try/catch for region: R(13:0|1|2|3|4|5|6|7|8|9|10|11|13) */
            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
            static {
                /*
                    g2.h$c[] r0 = g2.C2050h.c.values()
                    int r0 = r0.length
                    int[] r0 = new int[r0]
                    g2.h$c r1 = g2.C2050h.c.TRENDING     // Catch:{ NoSuchFieldError -> 0x0010 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                    r2 = 1
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
                L_0x0010:
                    g2.h$c r1 = g2.C2050h.c.LATEST     // Catch:{ NoSuchFieldError -> 0x0019 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                    r2 = 2
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
                L_0x0019:
                    g2.h$c r1 = g2.C2050h.c.UPDATE     // Catch:{ NoSuchFieldError -> 0x0022 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                    r2 = 3
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
                L_0x0022:
                    g2.h$c r1 = g2.C2050h.c.PROMOTED     // Catch:{ NoSuchFieldError -> 0x002b }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                    r2 = 4
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
                L_0x002b:
                    g2.h$c r1 = g2.C2050h.c.EDITOR_CHOICE     // Catch:{ NoSuchFieldError -> 0x0034 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                    r2 = 5
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
                L_0x0034:
                    f7616a = r0
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: M1.C1530g.a.C0093a.<clinit>():void");
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(C1530g gVar, View view, C2028t tVar, C2010a aVar) {
            super(view);
            m.e(view, "itemView");
            m.e(aVar, "actionsClickListener");
            this.f7615f = gVar;
            this.f7610a = tVar;
            this.f7611b = aVar;
            this.f7612c = (ImageView) view.findViewById(R.id.iv_feature_home);
            TextView textView = (TextView) view.findViewById(R.id.tv_tag_feature_home);
            this.f7613d = textView;
            TextView textView2 = (TextView) view.findViewById(R.id.tv_name_feature_home);
            this.f7614e = textView2;
            k.a aVar2 = k.f7778g;
            textView.setTypeface(aVar2.w());
            textView2.setTypeface(aVar2.w());
        }

        /* access modifiers changed from: private */
        public static final void d(a aVar, C2050h hVar, View view) {
            if (aVar.f7610a != null && aVar.getBindingAdapterPosition() != -1) {
                C2028t tVar = aVar.f7610a;
                m.b(tVar);
                tVar.a(hVar);
            }
        }

        /* access modifiers changed from: private */
        public static final boolean e(a aVar, C2050h hVar, int i4, View view) {
            aVar.f7611b.a(hVar, i4);
            return true;
        }

        private final void f() {
            this.f7613d.setBackground(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.bg_dev_on_board));
            this.f7613d.setTextColor(ContextCompat.getColor(this.itemView.getContext(), R.color.main_dark_grey));
        }

        private final void g() {
            this.f7613d.setBackground(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.shape_bg_tag_latest));
        }

        private final void h() {
            this.f7613d.setBackground(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.shape_bg_tag_promoted));
        }

        private final void i() {
            this.f7613d.setBackground(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.shape_bg_tag_trending));
        }

        private final void j() {
            this.f7613d.setBackground(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.shape_bg_accent_green));
        }

        public final void c(C2050h hVar, int i4) {
            m.e(hVar, "appInfo");
            UptodownApp.a aVar = UptodownApp.f17422D;
            int F4 = aVar.F();
            int dimension = (int) this.itemView.getContext().getResources().getDimension(R.dimen.margin_s);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(F4, -2);
            layoutParams.setMargins(dimension, 0, dimension, 0);
            this.itemView.setLayoutParams(layoutParams);
            if (hVar.p0() != C2050h.c.NONE) {
                this.f7613d.setText(hVar.o0());
                this.f7613d.setVisibility(0);
                this.f7613d.setTextColor(ContextCompat.getColor(this.itemView.getContext(), R.color.white));
                int i5 = C0093a.f7616a[hVar.p0().ordinal()];
                if (i5 == 1) {
                    i();
                } else if (i5 == 2) {
                    g();
                } else if (i5 == 3) {
                    j();
                } else if (i5 == 4) {
                    h();
                } else if (i5 == 5) {
                    f();
                }
            }
            this.f7614e.setText(hVar.L());
            this.f7612c.setLayoutParams(new RelativeLayout.LayoutParams(-1, aVar.w()));
            w f4 = s.h().l(hVar.x()).f();
            Context context = this.itemView.getContext();
            m.d(context, "getContext(...)");
            f4.n(aVar.h0(context)).i(this.f7612c);
            this.f7612c.setOnClickListener(new C1528e(this, hVar));
            this.f7612c.setOnLongClickListener(new C1529f(this, hVar, i4));
        }
    }

    public C1530g(C2028t tVar, C2010a aVar) {
        m.e(aVar, "actionsClickListener");
        this.f7607a = tVar;
        this.f7608b = aVar;
    }

    /* renamed from: a */
    public void onBindViewHolder(a aVar, int i4) {
        m.e(aVar, "holder");
        int size = i4 % this.f7609c.size();
        Object obj = this.f7609c.get(size);
        m.d(obj, "get(...)");
        aVar.c((C2050h) obj, size);
    }

    /* renamed from: b */
    public a onCreateViewHolder(ViewGroup viewGroup, int i4) {
        m.e(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.home_fragment_header_image, viewGroup, false);
        m.b(inflate);
        return new a(this, inflate, this.f7607a, this.f7608b);
    }

    public final void c(ArrayList arrayList) {
        m.e(arrayList, "headerPrograms");
        ArrayList arrayList2 = this.f7609c;
        arrayList2.clear();
        arrayList2.addAll(arrayList);
        notifyDataSetChanged();
    }

    public int getItemCount() {
        return this.f7609c.size() * 100;
    }
}
