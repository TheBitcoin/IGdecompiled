package y2;

import N1.k;
import R2.s;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c2.C1652C;
import c2.K0;
import com.mbridge.msdk.MBridgeConstans;
import com.uptodown.R;
import d3.p;
import java.util.HashMap;
import java.util.Locale;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;

public final class q {

    /* renamed from: e  reason: collision with root package name */
    public static final a f22827e = new a((C2103g) null);

    /* renamed from: a  reason: collision with root package name */
    private final Context f22828a;

    /* renamed from: b  reason: collision with root package name */
    private final View f22829b;

    /* renamed from: c  reason: collision with root package name */
    private final HashMap f22830c;

    /* renamed from: d  reason: collision with root package name */
    private final p f22831d;

    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        private a() {
        }
    }

    public final class b extends RecyclerView.Adapter {

        /* renamed from: a  reason: collision with root package name */
        private final HashMap f22832a;

        /* renamed from: b  reason: collision with root package name */
        private final p f22833b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ q f22834c;

        public final class a extends RecyclerView.ViewHolder {

            /* renamed from: a  reason: collision with root package name */
            private final C1652C f22835a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ b f22836b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(b bVar, C1652C c5) {
                super(c5.getRoot());
                m.e(c5, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
                this.f22836b = bVar;
                this.f22835a = c5;
            }

            public final C1652C a() {
                return this.f22835a;
            }
        }

        public b(q qVar, HashMap hashMap, p pVar) {
            m.e(hashMap, "options");
            m.e(pVar, "onOptionClick");
            this.f22834c = qVar;
            this.f22832a = hashMap;
            this.f22833b = pVar;
        }

        /* access modifiers changed from: private */
        public static final void c(b bVar, int i4, String str, View view) {
            bVar.f22833b.invoke(Integer.valueOf(i4), str);
        }

        /* renamed from: b */
        public void onBindViewHolder(a aVar, int i4) {
            String str;
            m.e(aVar, "holder");
            String str2 = (String) this.f22832a.get(Integer.valueOf(i4));
            if (str2 != null && str2.length() != 0) {
                TextView textView = aVar.a().f9704b;
                if (str2.length() > 0) {
                    StringBuilder sb = new StringBuilder();
                    String valueOf = String.valueOf(str2.charAt(0));
                    m.c(valueOf, "null cannot be cast to non-null type java.lang.String");
                    String upperCase = valueOf.toUpperCase(Locale.ROOT);
                    m.d(upperCase, "toUpperCase(...)");
                    sb.append(upperCase);
                    String substring = str2.substring(1);
                    m.d(substring, "substring(...)");
                    sb.append(substring);
                    str = sb.toString();
                } else {
                    str = str2;
                }
                textView.setText(str);
                aVar.a().f9704b.setTypeface(k.f7778g.x());
                aVar.itemView.setOnClickListener(new r(this, i4, str2));
            }
        }

        /* renamed from: d */
        public a onCreateViewHolder(ViewGroup viewGroup, int i4) {
            m.e(viewGroup, "parent");
            C1652C c5 = C1652C.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            m.d(c5, "inflate(...)");
            return new a(this, c5);
        }

        public int getItemCount() {
            return this.f22832a.size();
        }
    }

    public q(Context context, View view, HashMap hashMap, p pVar) {
        m.e(context, "context");
        m.e(view, "anchor");
        m.e(hashMap, "options");
        m.e(pVar, "onOptionSelected");
        this.f22828a = context;
        this.f22829b = view;
        this.f22830c = hashMap;
        this.f22831d = pVar;
    }

    /* access modifiers changed from: private */
    public static final s d(q qVar, PopupWindow popupWindow, int i4, String str) {
        m.e(str, "selectedOption");
        qVar.f22831d.invoke(Integer.valueOf(i4), str);
        popupWindow.dismiss();
        return s.f8222a;
    }

    /* access modifiers changed from: private */
    public static final void e(q qVar, LinearLayout linearLayout) {
        new n(qVar.f22828a).i(linearLayout, R.anim.hide_dropdown_menu);
    }

    public final void c() {
        LinearLayout b5 = K0.c(LayoutInflater.from(this.f22828a), (ViewGroup) null, false).getRoot();
        m.d(b5, "getRoot(...)");
        PopupWindow popupWindow = new PopupWindow(b5, this.f22829b.getWidth(), -2, true);
        new n(this.f22828a).h(b5, R.anim.show_dropdown_menu);
        View findViewById = b5.findViewById(R.id.recycler_view);
        m.d(findViewById, "findViewById(...)");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        b bVar = new b(this, this.f22830c, new o(this, popupWindow));
        recyclerView.setLayoutManager(new LinearLayoutManager(this.f22828a));
        recyclerView.setAdapter(bVar);
        popupWindow.setElevation(10.0f);
        popupWindow.showAsDropDown(this.f22829b);
        popupWindow.setOnDismissListener(new p(this, b5));
    }
}
