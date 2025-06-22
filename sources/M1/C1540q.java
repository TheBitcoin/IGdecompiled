package M1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import f2.x;
import g2.C2048f;
import g2.C2050h;
import java.util.ArrayList;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import x2.C2351B;
import x2.C2363d0;
import x2.M;

/* renamed from: M1.q  reason: case insensitive filesystem */
public final class C1540q extends RecyclerView.Adapter {

    /* renamed from: g  reason: collision with root package name */
    public static final a f7669g = new a((C2103g) null);

    /* renamed from: a  reason: collision with root package name */
    private C2050h f7670a;

    /* renamed from: b  reason: collision with root package name */
    private C2048f f7671b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f7672c;

    /* renamed from: d  reason: collision with root package name */
    private final x f7673d;

    /* renamed from: e  reason: collision with root package name */
    private final int f7674e;

    /* renamed from: f  reason: collision with root package name */
    private int f7675f;

    /* renamed from: M1.q$a */
    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        private a() {
        }
    }

    public C1540q(C2050h hVar, C2048f fVar, Context context, x xVar, int i4) {
        m.e(hVar, "appInfo");
        m.e(context, "context");
        m.e(xVar, "listener");
        this.f7670a = hVar;
        this.f7671b = fVar;
        this.f7672c = context;
        this.f7673d = xVar;
        this.f7674e = i4;
    }

    /* access modifiers changed from: private */
    public static final void c(C1540q qVar, View view) {
        qVar.f7673d.a();
    }

    /* access modifiers changed from: private */
    public static final void d(C1540q qVar, View view) {
        qVar.f7673d.d();
    }

    public final void e(C2048f fVar) {
        this.f7671b = fVar;
    }

    public final void f(ArrayList arrayList) {
        this.f7670a.P0(arrayList);
    }

    public final void g(int i4) {
        this.f7675f = i4;
    }

    public int getItemCount() {
        ArrayList O4 = this.f7670a.O();
        m.b(O4);
        return O4.size() + 1;
    }

    public int getItemViewType(int i4) {
        if (i4 == 0) {
            return 0;
        }
        ArrayList O4 = this.f7670a.O();
        m.b(O4);
        if (i4 < O4.size()) {
            return 1;
        }
        return 2;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i4) {
        m.e(viewHolder, "viewHolder");
        if (viewHolder instanceof C2351B) {
            C2048f fVar = this.f7671b;
            if (fVar != null) {
                ((C2351B) viewHolder).a(fVar);
            } else {
                ((C2351B) viewHolder).b(this.f7670a);
            }
        } else if (viewHolder instanceof C2363d0) {
            ((C2363d0) viewHolder).h(this.f7670a, this.f7671b, i4);
        } else if (!(viewHolder instanceof M)) {
        } else {
            if (this.f7674e > 20) {
                M m4 = (M) viewHolder;
                m4.a().setOnClickListener(new C1538o(this));
                m4.b().setOnClickListener(new C1539p(this));
                if (this.f7675f <= 0) {
                    m4.a().setVisibility(4);
                } else {
                    m4.a().setVisibility(0);
                }
                int i5 = this.f7675f + 1;
                ArrayList O4 = this.f7670a.O();
                m.b(O4);
                if (O4.size() < 20 || i5 * 20 == this.f7674e - 1) {
                    m4.b().setVisibility(4);
                } else {
                    m4.b().setVisibility(0);
                }
                m4.d().setText(String.valueOf(i5));
                return;
            }
            ((M) viewHolder).c().setVisibility(8);
        }
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i4) {
        m.e(viewGroup, "viewGroup");
        if (i4 == 0) {
            View inflate = LayoutInflater.from(this.f7672c).inflate(R.layout.header_installed_app, viewGroup, false);
            m.b(inflate);
            return new C2351B(inflate, this.f7672c);
        } else if (i4 != 1) {
            View inflate2 = LayoutInflater.from(this.f7672c).inflate(R.layout.load_more_versions, viewGroup, false);
            m.b(inflate2);
            return new M(inflate2);
        } else {
            View inflate3 = LayoutInflater.from(this.f7672c).inflate(R.layout.old_version_item, viewGroup, false);
            m.b(inflate3);
            return new C2363d0(inflate3, this.f7673d);
        }
    }
}
