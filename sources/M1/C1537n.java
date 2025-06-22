package M1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.uptodown.R;
import f2.C2031w;
import g2.C2034B;
import java.util.ArrayList;
import kotlin.jvm.internal.m;
import x2.Y;

/* renamed from: M1.n  reason: case insensitive filesystem */
public final class C1537n extends RecyclerView.Adapter {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList f7664a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f7665b;

    /* renamed from: c  reason: collision with root package name */
    private final C2031w f7666c;

    public C1537n(ArrayList arrayList, Context context, C2031w wVar) {
        m.e(arrayList, DataSchemeDataSource.SCHEME_DATA);
        m.e(context, "context");
        m.e(wVar, "listener");
        this.f7664a = arrayList;
        this.f7665b = context;
        this.f7666c = wVar;
    }

    public final ArrayList a() {
        return this.f7664a;
    }

    /* renamed from: b */
    public void onBindViewHolder(Y y4, int i4) {
        m.e(y4, "viewHolder");
        Object obj = this.f7664a.get(i4);
        m.d(obj, "get(...)");
        y4.h((C2034B) obj);
    }

    /* renamed from: c */
    public Y onCreateViewHolder(ViewGroup viewGroup, int i4) {
        m.e(viewGroup, "viewGroup");
        View inflate = LayoutInflater.from(this.f7665b).inflate(R.layout.notification_registry_item, viewGroup, false);
        m.b(inflate);
        return new Y(inflate, this.f7666c);
    }

    public final void d(ArrayList arrayList) {
        m.e(arrayList, "<set-?>");
        this.f7664a = arrayList;
    }

    public int getItemCount() {
        return this.f7664a.size();
    }
}
