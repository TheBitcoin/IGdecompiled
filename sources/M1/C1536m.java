package M1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import f2.C2008G;
import f2.C2011b;
import f2.C2029u;
import g2.C2048f;
import java.util.ArrayList;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import x2.C2371h;
import x2.U;
import x2.Z0;

/* renamed from: M1.m  reason: case insensitive filesystem */
public final class C1536m extends RecyclerView.Adapter {

    /* renamed from: f  reason: collision with root package name */
    public static final a f7658f = new a((C2103g) null);

    /* renamed from: a  reason: collision with root package name */
    private final C2011b f7659a;

    /* renamed from: b  reason: collision with root package name */
    private final C2008G f7660b;

    /* renamed from: c  reason: collision with root package name */
    private final C2029u f7661c;

    /* renamed from: d  reason: collision with root package name */
    private ArrayList f7662d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    private int f7663e = -1;

    /* renamed from: M1.m$a */
    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        private a() {
        }
    }

    public C1536m(C2011b bVar, C2008G g4, C2029u uVar) {
        m.e(bVar, "appListener");
        m.e(uVar, "infoClickListener");
        this.f7659a = bVar;
        this.f7660b = g4;
        this.f7661c = uVar;
    }

    private final void a(ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4) {
        ArrayList arrayList5 = new ArrayList();
        this.f7662d = arrayList5;
        arrayList5.addAll(arrayList);
        if (arrayList2 != null && !arrayList2.isEmpty()) {
            this.f7662d.add("title_system_app");
            this.f7662d.addAll(arrayList2);
        }
        if (arrayList3 != null && !arrayList3.isEmpty()) {
            this.f7662d.add("title_disable_app");
            this.f7662d.addAll(arrayList3);
        }
        if (arrayList4 != null && !arrayList4.isEmpty()) {
            this.f7662d.add("title_system_service");
            this.f7662d.addAll(arrayList4);
        }
    }

    public final ArrayList b() {
        return this.f7662d;
    }

    public final void c() {
        notifyDataSetChanged();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x002b, code lost:
        r5 = (g2.C2048f) r5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void d(java.io.File r9, android.content.Context r10) {
        /*
            r8 = this;
            java.lang.String r0 = "file"
            kotlin.jvm.internal.m.e(r9, r0)
            java.lang.String r0 = "context"
            kotlin.jvm.internal.m.e(r10, r0)
            u2.t$a r0 = u2.t.f21927u
            u2.t r0 = r0.a(r10)
            r0.a()
            java.util.ArrayList r1 = r8.f7662d
            java.util.Iterator r1 = r1.iterator()
            r2 = 0
            r3 = 0
        L_0x001b:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x0075
            int r4 = r3 + 1
            java.lang.Object r5 = r1.next()
            boolean r6 = r5 instanceof g2.C2048f
            if (r6 == 0) goto L_0x0073
            g2.f r5 = (g2.C2048f) r5
            java.lang.String r6 = r5.o()
            if (r6 == 0) goto L_0x0073
            int r6 = r6.length()
            if (r6 != 0) goto L_0x003a
            goto L_0x0073
        L_0x003a:
            java.lang.String r5 = r5.o()
            kotlin.jvm.internal.m.b(r5)
            g2.S r5 = r0.D0(r5)
            if (r5 == 0) goto L_0x004c
            g2.s r5 = r5.b(r10)
            goto L_0x004d
        L_0x004c:
            r5 = 0
        L_0x004d:
            if (r5 == 0) goto L_0x0073
            java.util.ArrayList r6 = r5.o()
            int r6 = r6.size()
            r7 = 1
            if (r6 != r7) goto L_0x0073
            java.util.ArrayList r5 = r5.o()
            java.lang.Object r5 = r5.get(r2)
            g2.s$c r5 = (g2.C2060s.c) r5
            java.lang.String r5 = r5.a()
            java.lang.String r6 = r9.getAbsolutePath()
            boolean r5 = m3.m.p(r5, r6, r7)
            if (r5 == 0) goto L_0x0073
            goto L_0x0076
        L_0x0073:
            r3 = r4
            goto L_0x001b
        L_0x0075:
            r3 = -1
        L_0x0076:
            r0.i()
            if (r3 < 0) goto L_0x007e
            r8.notifyItemChanged(r3)
        L_0x007e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: M1.C1536m.d(java.io.File, android.content.Context):void");
    }

    public final void e() {
        this.f7663e = -1;
    }

    public final void f(ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4) {
        m.e(arrayList, "apps");
        a(arrayList, arrayList2, arrayList3, arrayList4);
        notifyDataSetChanged();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x002b, code lost:
        r5 = (g2.C2048f) r5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void g(java.io.File r9, android.content.Context r10) {
        /*
            r8 = this;
            java.lang.String r0 = "file"
            kotlin.jvm.internal.m.e(r9, r0)
            java.lang.String r0 = "context"
            kotlin.jvm.internal.m.e(r10, r0)
            u2.t$a r0 = u2.t.f21927u
            u2.t r0 = r0.a(r10)
            r0.a()
            java.util.ArrayList r1 = r8.f7662d
            java.util.Iterator r1 = r1.iterator()
            r2 = 0
            r3 = 0
        L_0x001b:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x0077
            int r4 = r3 + 1
            java.lang.Object r5 = r1.next()
            boolean r6 = r5 instanceof g2.C2048f
            if (r6 == 0) goto L_0x0075
            g2.f r5 = (g2.C2048f) r5
            java.lang.String r6 = r5.o()
            if (r6 == 0) goto L_0x0075
            int r6 = r6.length()
            if (r6 != 0) goto L_0x003a
            goto L_0x0075
        L_0x003a:
            java.lang.String r5 = r5.o()
            kotlin.jvm.internal.m.b(r5)
            g2.S r5 = r0.D0(r5)
            if (r5 == 0) goto L_0x004c
            g2.s r5 = r5.b(r10)
            goto L_0x004d
        L_0x004c:
            r5 = 0
        L_0x004d:
            if (r5 == 0) goto L_0x0075
            java.util.ArrayList r6 = r5.o()
            int r6 = r6.size()
            r7 = 1
            if (r6 != r7) goto L_0x0075
            java.util.ArrayList r5 = r5.o()
            java.lang.Object r5 = r5.get(r2)
            g2.s$c r5 = (g2.C2060s.c) r5
            java.lang.String r5 = r5.a()
            java.lang.String r6 = r9.getAbsolutePath()
            boolean r5 = m3.m.p(r5, r6, r7)
            if (r5 == 0) goto L_0x0075
            r8.f7663e = r3
            goto L_0x0077
        L_0x0075:
            r3 = r4
            goto L_0x001b
        L_0x0077:
            r0.i()
            int r9 = r8.f7663e
            if (r9 < 0) goto L_0x0081
            r8.notifyItemChanged(r9)
        L_0x0081:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: M1.C1536m.g(java.io.File, android.content.Context):void");
    }

    public int getItemCount() {
        return this.f7662d.size();
    }

    public int getItemViewType(int i4) {
        Object obj = this.f7662d.get(i4);
        m.d(obj, "get(...)");
        if (obj instanceof C2048f) {
            if (((C2048f) obj).w() == C2048f.c.OUTDATED) {
                return 1;
            }
            return 0;
        } else if (obj instanceof String) {
            String str = (String) obj;
            int hashCode = str.hashCode();
            if (hashCode != 1477891299) {
                if (hashCode != 1692569964) {
                    if (hashCode == 2032679000 && str.equals("title_system_app")) {
                        return 2;
                    }
                } else if (str.equals("title_system_service")) {
                    return 3;
                }
            } else if (str.equals("title_disable_app")) {
                return 4;
            }
            throw new IllegalArgumentException();
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i4) {
        m.e(viewHolder, "viewHolder");
        if (viewHolder instanceof C2371h) {
            Object obj = this.f7662d.get(i4);
            m.c(obj, "null cannot be cast to non-null type com.uptodown.models.App");
            ((C2371h) viewHolder).c((C2048f) obj);
            return;
        }
        boolean z4 = true;
        if (viewHolder instanceof Z0) {
            Z0 z02 = (Z0) viewHolder;
            Object obj2 = this.f7662d.get(i4);
            m.c(obj2, "null cannot be cast to non-null type com.uptodown.models.App");
            C2048f fVar = (C2048f) obj2;
            if (this.f7663e != i4) {
                z4 = false;
            }
            z02.q(fVar, z4);
        } else if (viewHolder instanceof U) {
            ((U) viewHolder).c(true);
        } else {
            throw new IllegalArgumentException("ViewHolder unknown!!");
        }
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i4) {
        m.e(viewGroup, "viewGroup");
        if (i4 == 0) {
            return new C2371h(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.installed_app_item, viewGroup, false), this.f7659a);
        }
        if (i4 == 1) {
            return new Z0(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.update_item, viewGroup, false), this.f7660b);
        }
        if (i4 == 2) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tv_myappsupdates_title, viewGroup, false);
            String string = inflate.getContext().getString(R.string.system_apps_title);
            m.d(string, "getString(...)");
            return new U(inflate, string, (C2029u) null);
        } else if (i4 == 3) {
            View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tv_myappsupdates_title, viewGroup, false);
            String string2 = inflate2.getContext().getString(R.string.menu_item_title_system_services);
            m.d(string2, "getString(...)");
            return new U(inflate2, string2, (C2029u) null);
        } else if (i4 == 4) {
            View inflate3 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tv_myappsupdates_title, viewGroup, false);
            String string3 = inflate3.getContext().getString(R.string.disabled_apps);
            m.d(string3, "getString(...)");
            return new U(inflate3, string3, this.f7661c);
        } else {
            throw new IllegalArgumentException("viewType unknown");
        }
    }
}
