package M1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import f2.C2006E;
import g2.O;
import g2.Z;
import java.util.ArrayList;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import x2.C2405y0;

public final class B extends RecyclerView.Adapter {

    /* renamed from: c  reason: collision with root package name */
    public static final a f7403c = new a((C2103g) null);

    /* renamed from: a  reason: collision with root package name */
    private ArrayList f7404a;

    /* renamed from: b  reason: collision with root package name */
    private final C2006E f7405b;

    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        private a() {
        }
    }

    public B(ArrayList arrayList, C2006E e5) {
        m.e(e5, "listener");
        this.f7404a = arrayList;
        this.f7405b = e5;
    }

    /* renamed from: a */
    public void onBindViewHolder(C2405y0 y0Var, int i4) {
        Object obj;
        m.e(y0Var, "viewHolder");
        ArrayList arrayList = this.f7404a;
        Object obj2 = null;
        if (arrayList != null) {
            obj = arrayList.get(i4);
        } else {
            obj = null;
        }
        if (obj instanceof Z) {
            ArrayList arrayList2 = this.f7404a;
            if (arrayList2 != null) {
                obj2 = arrayList2.get(i4);
            }
            m.b(obj2);
            y0Var.g((Z) obj2);
            return;
        }
        ArrayList arrayList3 = this.f7404a;
        if (arrayList3 != null) {
            obj2 = arrayList3.get(i4);
        }
        m.b(obj2);
        y0Var.f((O) obj2);
    }

    /* renamed from: b */
    public C2405y0 onCreateViewHolder(ViewGroup viewGroup, int i4) {
        m.e(viewGroup, "viewGroup");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.screenshot_item, viewGroup, false);
        m.b(inflate);
        return new C2405y0(inflate, this.f7405b);
    }

    public final void c(Object obj) {
        Integer num;
        m.e(obj, "item");
        ArrayList arrayList = this.f7404a;
        if (arrayList != null) {
            num = Integer.valueOf(arrayList.indexOf(obj));
        } else {
            num = null;
        }
        if (num != null && num.intValue() != -1) {
            ArrayList arrayList2 = this.f7404a;
            if (arrayList2 != null) {
                arrayList2.remove(num.intValue());
            }
            notifyItemRemoved(num.intValue());
        }
    }

    public int getItemCount() {
        ArrayList arrayList = this.f7404a;
        if (arrayList == null) {
            return 0;
        }
        m.b(arrayList);
        return arrayList.size();
    }

    public int getItemViewType(int i4) {
        Object obj;
        ArrayList arrayList = this.f7404a;
        if (arrayList != null) {
            obj = arrayList.get(i4);
        } else {
            obj = null;
        }
        if (obj instanceof Z) {
            return 0;
        }
        return 1;
    }
}
