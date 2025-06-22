package Q1;

import S1.l;
import a2.g;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import kotlin.jvm.internal.m;

public final class c extends RecyclerView.Adapter {

    /* renamed from: a  reason: collision with root package name */
    private final l f7998a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList f7999b;

    public c(ArrayList arrayList, l lVar) {
        m.e(lVar, "listener");
        this.f7998a = lVar;
        this.f7999b = arrayList;
    }

    /* renamed from: a */
    public void onBindViewHolder(g gVar, int i4) {
        m.e(gVar, "viewHolder");
        CheckBox checkBox = gVar.f8915a;
        ArrayList arrayList = this.f7999b;
        m.b(arrayList);
        checkBox.setText(((T1.g) arrayList.get(i4)).d());
        CheckBox checkBox2 = gVar.f8915a;
        ArrayList arrayList2 = this.f7999b;
        m.b(arrayList2);
        checkBox2.setChecked(((T1.g) arrayList2.get(i4)).a());
        CheckBox checkBox3 = gVar.f8915a;
        ArrayList arrayList3 = this.f7999b;
        m.b(arrayList3);
        checkBox3.setEnabled(((T1.g) arrayList3.get(i4)).b());
    }

    /* renamed from: b */
    public g onCreateViewHolder(ViewGroup viewGroup, int i4) {
        m.e(viewGroup, "viewGroup");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(N1.g.split_item, viewGroup, false);
        m.d(inflate, "itemView");
        return new g(inflate, this.f7998a);
    }

    public int getItemCount() {
        ArrayList arrayList = this.f7999b;
        m.b(arrayList);
        return arrayList.size();
    }
}
