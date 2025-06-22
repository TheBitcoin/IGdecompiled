package Q1;

import N1.g;
import S1.j;
import U1.h;
import a2.b;
import android.net.nsd.NsdServiceInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import kotlin.jvm.internal.m;

public final class a extends RecyclerView.Adapter {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList f7992a;

    /* renamed from: b  reason: collision with root package name */
    private j f7993b;

    public a(ArrayList arrayList, j jVar) {
        m.e(jVar, "listener");
        this.f7992a = arrayList;
        this.f7993b = jVar;
    }

    /* renamed from: a */
    public void onBindViewHolder(b bVar, int i4) {
        m.e(bVar, "holder");
        TextView c5 = bVar.c();
        h.a aVar = h.f8425h;
        ArrayList arrayList = this.f7992a;
        m.b(arrayList);
        String serviceName = ((NsdServiceInfo) arrayList.get(i4)).getServiceName();
        m.d(serviceName, "data!![position].serviceName");
        c5.setText(aVar.c(serviceName));
    }

    /* renamed from: b */
    public b onCreateViewHolder(ViewGroup viewGroup, int i4) {
        m.e(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(g.device_item, viewGroup, false);
        m.d(inflate, "from(parent.context).inf…vice_item, parent, false)");
        return new b(inflate, this.f7993b);
    }

    public int getItemCount() {
        ArrayList arrayList = this.f7992a;
        m.b(arrayList);
        return arrayList.size();
    }
}
