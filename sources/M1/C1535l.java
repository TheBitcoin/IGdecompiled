package M1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import f2.C2030v;
import g2.C2066y;
import java.util.ArrayList;
import kotlin.jvm.internal.m;
import x2.L;

/* renamed from: M1.l  reason: case insensitive filesystem */
public final class C1535l extends RecyclerView.Adapter {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList f7655a;

    /* renamed from: b  reason: collision with root package name */
    private final C2030v f7656b;

    /* renamed from: c  reason: collision with root package name */
    private final String f7657c;

    public C1535l(ArrayList arrayList, C2030v vVar, String str) {
        m.e(vVar, "listener");
        m.e(str, "currentLanguageCode");
        this.f7655a = arrayList;
        this.f7656b = vVar;
        this.f7657c = str;
    }

    /* renamed from: a */
    public void onBindViewHolder(L l4, int i4) {
        C2066y yVar;
        m.e(l4, "viewHolder");
        ArrayList arrayList = this.f7655a;
        if (arrayList != null) {
            yVar = (C2066y) arrayList.get(i4);
        } else {
            yVar = null;
        }
        m.b(yVar);
        l4.b(yVar, this.f7657c);
    }

    /* renamed from: b */
    public L onCreateViewHolder(ViewGroup viewGroup, int i4) {
        m.e(viewGroup, "viewGroup");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.language_item, viewGroup, false);
        m.b(inflate);
        return new L(inflate, this.f7656b);
    }

    public int getItemCount() {
        ArrayList arrayList = this.f7655a;
        if (arrayList == null) {
            return 0;
        }
        m.b(arrayList);
        return arrayList.size();
    }
}
