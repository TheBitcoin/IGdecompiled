package M1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import f2.C2020k;
import g2.C2060s;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.m;
import x2.C2394t;

/* renamed from: M1.b  reason: case insensitive filesystem */
public final class C1525b extends RecyclerView.Adapter {

    /* renamed from: a  reason: collision with root package name */
    private final C2020k f7534a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList f7535b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private boolean f7536c;

    /* renamed from: d  reason: collision with root package name */
    private boolean[] f7537d;

    /* renamed from: e  reason: collision with root package name */
    private int f7538e = -1;

    public C1525b(C2020k kVar) {
        m.e(kVar, "listener");
        this.f7534a = kVar;
    }

    private final void a(C2394t tVar, C2060s sVar, boolean z4, boolean z5, int i4) {
        if (!sVar.o().isEmpty()) {
            boolean z6 = false;
            if (((C2060s.c) sVar.o().get(0)).a() != null) {
                if (this.f7538e == i4) {
                    z6 = true;
                }
                tVar.o(sVar, z4, z5, z6);
                return;
            }
        }
        tVar.p(sVar, z4, z5);
    }

    private final void b(ArrayList arrayList, ArrayList arrayList2) {
        this.f7535b = new ArrayList();
        if (arrayList2 != null && !arrayList2.isEmpty()) {
            this.f7535b.addAll(arrayList2);
        }
        if (!arrayList.isEmpty()) {
            this.f7535b.addAll(arrayList);
        }
        this.f7537d = new boolean[this.f7535b.size()];
    }

    public final int c() {
        boolean[] zArr = this.f7537d;
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

    public final ArrayList d() {
        return this.f7535b;
    }

    public final int e() {
        return this.f7538e;
    }

    public final ArrayList f() {
        ArrayList arrayList = new ArrayList();
        boolean[] zArr = this.f7537d;
        m.b(zArr);
        int length = zArr.length;
        for (int i4 = 0; i4 < length; i4++) {
            if (zArr[i4]) {
                boolean[] zArr2 = this.f7537d;
                m.b(zArr2);
                if (i4 < zArr2.length) {
                    arrayList.add(this.f7535b.get(i4));
                }
            }
        }
        return arrayList;
    }

    public final boolean g() {
        return this.f7536c;
    }

    public int getItemCount() {
        return this.f7535b.size();
    }

    public final void h(File file, Context context) {
        m.e(file, "file");
        m.e(context, "context");
        Iterator it = this.f7535b.iterator();
        int i4 = 0;
        while (true) {
            if (!it.hasNext()) {
                i4 = -1;
                break;
            }
            int i5 = i4 + 1;
            if (m.a(((C2060s) it.next()).m(context), file)) {
                break;
            }
            i4 = i5;
        }
        if (i4 >= 0) {
            notifyItemChanged(i4);
        }
    }

    public final void i() {
        this.f7538e = -1;
    }

    public final void j(ArrayList arrayList, ArrayList arrayList2) {
        m.e(arrayList, "downloads");
        b(arrayList, arrayList2);
        notifyDataSetChanged();
    }

    public final void k(File file, Context context) {
        m.e(file, "file");
        m.e(context, "context");
        Iterator it = this.f7535b.iterator();
        int i4 = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            int i5 = i4 + 1;
            if (m.a(((C2060s) it.next()).m(context), file)) {
                this.f7538e = i4;
                break;
            }
            i4 = i5;
        }
        int i6 = this.f7538e;
        if (i6 >= 0) {
            notifyItemChanged(i6);
        }
    }

    public final void l(int i4) {
        boolean[] zArr = this.f7537d;
        m.b(zArr);
        boolean[] zArr2 = this.f7537d;
        m.b(zArr2);
        zArr[i4] = !zArr2[i4];
        notifyItemChanged(i4);
    }

    public final void m(boolean z4) {
        this.f7536c = z4;
        if (!z4) {
            if (!this.f7535b.isEmpty()) {
                this.f7537d = new boolean[this.f7535b.size()];
            } else {
                this.f7537d = new boolean[0];
            }
        }
        notifyDataSetChanged();
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i4) {
        m.e(viewHolder, "viewHolder");
        Object obj = this.f7535b.get(i4);
        m.d(obj, "get(...)");
        boolean z4 = this.f7536c;
        boolean[] zArr = this.f7537d;
        m.b(zArr);
        a((C2394t) viewHolder, (C2060s) obj, z4, zArr[i4], i4);
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i4) {
        m.e(viewGroup, "viewGroup");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.download_item, viewGroup, false);
        m.b(inflate);
        return new C2394t(inflate, this.f7534a);
    }
}
