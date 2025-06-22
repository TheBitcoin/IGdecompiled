package d4;

import A1.c;
import V3.C2591b;
import V3.C2592c;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.mbridge.msdk.MBridgeConstans;
import java.util.List;
import kotlin.jvm.internal.m;

public final class d extends RecyclerView.Adapter {

    /* renamed from: a  reason: collision with root package name */
    public final List f24533a;

    public d(List list) {
        m.e(list, "disclosures");
        this.f24533a = list;
    }

    public int getItemCount() {
        return this.f24533a.size();
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i4) {
        f fVar = (f) viewHolder;
        m.e(fVar, "holder");
        e eVar = (e) this.f24533a.get(i4);
        fVar.getClass();
        m.e(eVar, "disclosure");
        fVar.f24549k.setText(eVar.f24534a);
        fVar.f24548j.setText(eVar.f24535b);
        fVar.f24547i.setText(eVar.f24536c);
        fVar.f24546h.setText(eVar.f24537d);
        fVar.f24545g.setText(eVar.f24538e);
        C2592c cVar = b4.d.f24470f;
        if (cVar != null) {
            Integer num = cVar.f24071i;
            if (num != null) {
                int intValue = num.intValue();
                fVar.f24549k.setTextColor(intValue);
                fVar.f24544f.setTextColor(intValue);
                fVar.f24548j.setTextColor(intValue);
                fVar.f24543e.setTextColor(intValue);
                fVar.f24547i.setTextColor(intValue);
                fVar.f24542d.setTextColor(intValue);
                fVar.f24546h.setTextColor(intValue);
                fVar.f24541c.setTextColor(intValue);
                fVar.f24545g.setTextColor(intValue);
                fVar.f24540b.setTextColor(intValue);
            }
            Integer num2 = cVar.f24063a;
            if (num2 != null) {
                fVar.f24539a.setBackgroundColor(num2.intValue());
            }
        }
        C2591b bVar = b4.d.f24469e;
        if (bVar != null) {
            Typeface typeface = bVar.f24062b;
            if (typeface != null) {
                fVar.f24549k.setTypeface(typeface);
                fVar.f24544f.setTypeface(typeface);
                fVar.f24548j.setTypeface(typeface);
                fVar.f24543e.setTypeface(typeface);
                fVar.f24547i.setTypeface(typeface);
                fVar.f24542d.setTypeface(typeface);
                fVar.f24546h.setTypeface(typeface);
                fVar.f24541c.setTypeface(typeface);
                fVar.f24545g.setTypeface(typeface);
            }
            Typeface typeface2 = bVar.f24061a;
            if (typeface2 != null) {
                fVar.f24540b.setTypeface(typeface2);
            }
        }
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i4) {
        m.e(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(c.list_item_disclosure, viewGroup, false);
        m.d(inflate, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        return new f(inflate);
    }
}
