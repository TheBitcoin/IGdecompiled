package M1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.uptodown.R;
import f2.C2011b;
import g2.C2048f;
import java.util.ArrayList;
import kotlin.jvm.internal.m;
import x2.C2350A;

/* renamed from: M1.c  reason: case insensitive filesystem */
public final class C1526c extends RecyclerView.Adapter {

    /* renamed from: a  reason: collision with root package name */
    private final Context f7542a;

    /* renamed from: b  reason: collision with root package name */
    private final C2011b f7543b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList f7544c;

    public C1526c(ArrayList arrayList, Context context, C2011b bVar) {
        m.e(arrayList, "apps");
        m.e(context, "context");
        m.e(bVar, "applistener");
        this.f7542a = context;
        this.f7543b = bVar;
        b(arrayList);
    }

    public final ArrayList a() {
        ArrayList arrayList = this.f7544c;
        if (arrayList != null) {
            return arrayList;
        }
        m.u(DataSchemeDataSource.SCHEME_DATA);
        return null;
    }

    public final void b(ArrayList arrayList) {
        m.e(arrayList, "apps");
        c(arrayList);
        notifyDataSetChanged();
    }

    public final void c(ArrayList arrayList) {
        m.e(arrayList, "<set-?>");
        this.f7544c = arrayList;
    }

    public int getItemCount() {
        return a().size();
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i4) {
        m.e(viewHolder, "viewHolder");
        if (viewHolder instanceof C2350A) {
            Object obj = a().get(i4);
            m.d(obj, "get(...)");
            ((C2350A) viewHolder).k((C2048f) obj);
            return;
        }
        throw new IllegalArgumentException("ViewHolder unknown!!");
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i4) {
        m.e(viewGroup, "viewGroup");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.free_up_item, viewGroup, false);
        m.b(inflate);
        return new C2350A(inflate, this.f7543b, this.f7542a);
    }
}
