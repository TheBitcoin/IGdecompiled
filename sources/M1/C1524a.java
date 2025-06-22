package M1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import f2.C2012c;
import g2.C2063v;
import java.util.ArrayList;
import kotlin.jvm.internal.m;
import x2.C2362d;

/* renamed from: M1.a  reason: case insensitive filesystem */
public final class C1524a extends RecyclerView.Adapter {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList f7531a;

    /* renamed from: b  reason: collision with root package name */
    private final C2012c f7532b;

    public C1524a(ArrayList arrayList, C2012c cVar) {
        m.e(cVar, "listener");
        this.f7531a = arrayList;
        this.f7532b = cVar;
    }

    /* renamed from: a */
    public void onBindViewHolder(C2362d dVar, int i4) {
        C2063v vVar;
        m.e(dVar, "viewHolder");
        ArrayList arrayList = this.f7531a;
        if (arrayList != null) {
            vVar = (C2063v) arrayList.get(i4);
        } else {
            vVar = null;
        }
        m.b(vVar);
        dVar.b(vVar);
    }

    /* renamed from: b */
    public C2362d onCreateViewHolder(ViewGroup viewGroup, int i4) {
        m.e(viewGroup, "viewGroup");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.app_file_item, viewGroup, false);
        m.b(inflate);
        return new C2362d(inflate, this.f7532b);
    }

    public int getItemCount() {
        ArrayList arrayList = this.f7531a;
        if (arrayList == null) {
            return 0;
        }
        m.b(arrayList);
        return arrayList.size();
    }
}
