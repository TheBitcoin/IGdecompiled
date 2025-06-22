package M1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import f2.C2010a;
import f2.C2028t;
import g2.C2050h;
import java.util.ArrayList;
import kotlin.jvm.internal.m;
import x2.C2367f;

/* renamed from: M1.k  reason: case insensitive filesystem */
public final class C1534k extends RecyclerView.Adapter {

    /* renamed from: a  reason: collision with root package name */
    private C2028t f7652a;

    /* renamed from: b  reason: collision with root package name */
    private C2010a f7653b;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList f7654c = new ArrayList();

    public C1534k(C2028t tVar, C2010a aVar) {
        m.e(tVar, "listener");
        m.e(aVar, "actionsClickListener");
        this.f7652a = tVar;
        this.f7653b = aVar;
    }

    public final ArrayList a() {
        return this.f7654c;
    }

    /* renamed from: b */
    public void onBindViewHolder(C2367f fVar, int i4) {
        m.e(fVar, "holder");
        Object obj = this.f7654c.get(i4);
        m.d(obj, "get(...)");
        fVar.m((C2050h) obj, i4);
    }

    /* renamed from: c */
    public C2367f onCreateViewHolder(ViewGroup viewGroup, int i4) {
        m.e(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.app_info_item_small, viewGroup, false);
        m.b(inflate);
        return new C2367f(inflate, this.f7652a, this.f7653b);
    }

    public final void d(ArrayList arrayList) {
        m.e(arrayList, "appList");
        ArrayList arrayList2 = this.f7654c;
        arrayList2.clear();
        arrayList2.addAll(arrayList);
    }

    public int getItemCount() {
        return this.f7654c.size();
    }
}
