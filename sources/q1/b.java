package Q1;

import S1.g;
import a2.e;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import kotlin.jvm.internal.m;

public final class b extends RecyclerView.Adapter {

    /* renamed from: a  reason: collision with root package name */
    private final g f7994a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList f7995b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f7996c;

    /* renamed from: d  reason: collision with root package name */
    private boolean[] f7997d;

    public b(g gVar) {
        m.e(gVar, "listener");
        this.f7994a = gVar;
    }

    public final int a() {
        boolean[] zArr = this.f7997d;
        if (zArr == null) {
            return 0;
        }
        m.b(zArr);
        int i4 = 0;
        for (boolean z4 : zArr) {
            if (z4) {
                i4++;
            }
        }
        return i4;
    }

    public final ArrayList b() {
        ArrayList arrayList = new ArrayList();
        if (this.f7995b != null) {
            boolean[] zArr = this.f7997d;
            m.b(zArr);
            int length = zArr.length;
            for (int i4 = 0; i4 < length; i4++) {
                if (zArr[i4]) {
                    ArrayList arrayList2 = this.f7995b;
                    m.b(arrayList2);
                    arrayList.add(arrayList2.get(i4));
                }
            }
        }
        return arrayList;
    }

    public final boolean c() {
        return this.f7996c;
    }

    /* renamed from: d */
    public void onBindViewHolder(e eVar, int i4) {
        m.e(eVar, "viewHolder");
        ArrayList arrayList = this.f7995b;
        if (arrayList != null) {
            m.b(arrayList);
            Object obj = arrayList.get(i4);
            m.d(obj, "data!![pos]");
            boolean z4 = this.f7996c;
            boolean[] zArr = this.f7997d;
            m.b(zArr);
            eVar.c(obj, z4, zArr[i4]);
        }
    }

    /* renamed from: e */
    public e onCreateViewHolder(ViewGroup viewGroup, int i4) {
        m.e(viewGroup, "viewGroup");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(N1.g.file_item, viewGroup, false);
        m.d(inflate, "from(viewGroup.context).…e_item, viewGroup, false)");
        return new e(inflate, this.f7994a);
    }

    public final void f(ArrayList arrayList) {
        if (arrayList != null) {
            this.f7995b = arrayList;
            this.f7997d = new boolean[arrayList.size()];
        } else {
            this.f7995b = new ArrayList();
            this.f7997d = new boolean[0];
        }
        notifyDataSetChanged();
    }

    public final void g(int i4) {
        boolean[] zArr = this.f7997d;
        m.b(zArr);
        boolean[] zArr2 = this.f7997d;
        m.b(zArr2);
        zArr[i4] = !zArr2[i4];
        notifyItemChanged(i4);
    }

    public int getItemCount() {
        ArrayList arrayList = this.f7995b;
        if (arrayList == null) {
            return 0;
        }
        m.b(arrayList);
        return arrayList.size();
    }

    public final void h(boolean z4) {
        this.f7996c = z4;
        if (!z4) {
            ArrayList arrayList = this.f7995b;
            if (arrayList != null) {
                m.b(arrayList);
                this.f7997d = new boolean[arrayList.size()];
            } else {
                this.f7997d = new boolean[0];
            }
        }
        notifyDataSetChanged();
    }
}
