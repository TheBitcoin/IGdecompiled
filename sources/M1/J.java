package M1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.uptodown.R;
import com.uptodown.activities.preferences.a;
import f2.C2008G;
import f2.C2009H;
import f2.C2011b;
import f2.C2029u;
import g2.C2048f;
import g2.S;
import java.io.File;
import java.util.ArrayList;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import u2.w;
import x2.B1;
import x2.C2356b;
import x2.C2371h;
import x2.D1;
import x2.S0;
import x2.U;
import x2.U0;
import x2.Z0;

public final class J extends RecyclerView.Adapter {

    /* renamed from: j  reason: collision with root package name */
    public static final b f7464j = new b((C2103g) null);

    /* renamed from: a  reason: collision with root package name */
    private final C2008G f7465a;

    /* renamed from: b  reason: collision with root package name */
    private final C2011b f7466b;

    /* renamed from: c  reason: collision with root package name */
    private final C2009H f7467c;

    /* renamed from: d  reason: collision with root package name */
    private final C2029u f7468d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList f7469e;

    /* renamed from: f  reason: collision with root package name */
    private c f7470f = new c();

    /* renamed from: g  reason: collision with root package name */
    private int f7471g = -1;

    /* renamed from: h  reason: collision with root package name */
    private boolean f7472h;

    /* renamed from: i  reason: collision with root package name */
    private int f7473i;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final C2048f f7474a;

        /* renamed from: b  reason: collision with root package name */
        private final S f7475b;

        public a(C2048f fVar, S s4) {
            m.e(fVar, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
            m.e(s4, "update");
            this.f7474a = fVar;
            this.f7475b = s4;
        }

        public final C2048f a() {
            return this.f7474a;
        }

        public final S b() {
            return this.f7475b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (m.a(this.f7474a, aVar.f7474a) && m.a(this.f7475b, aVar.f7475b)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.f7474a.hashCode() * 31) + this.f7475b.hashCode();
        }

        public String toString() {
            return "AppUpdateData(app=" + this.f7474a + ", update=" + this.f7475b + ')';
        }
    }

    public static final class b {
        public /* synthetic */ b(C2103g gVar) {
            this();
        }

        private b() {
        }
    }

    private static final class c {

        /* renamed from: a  reason: collision with root package name */
        private int f7476a;

        public final int a() {
            return this.f7476a;
        }

        public final void b(int i4) {
            this.f7476a = i4;
        }
    }

    public J(C2008G g4, C2011b bVar, C2009H h4, C2029u uVar) {
        m.e(g4, "updateListener");
        m.e(bVar, "appListener");
        m.e(h4, "updatesTrackingListener");
        m.e(uVar, "infoClickListener");
        this.f7465a = g4;
        this.f7466b = bVar;
        this.f7467c = h4;
        this.f7468d = uVar;
    }

    private final void a(ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4, Context context) {
        j(new ArrayList());
        File g4 = new w().g(context);
        if (g4.exists() && new w().k(context, g4) < 262144000) {
            b().add("warning_not_space");
        }
        if (arrayList != null) {
            this.f7470f.b(arrayList.size());
        }
        b().add(this.f7470f);
        this.f7473i = b().size() - 1;
        if (!com.uptodown.activities.preferences.a.f18818a.i0(context)) {
            b().add("tracking_disabled");
            return;
        }
        if (arrayList != null) {
            b().addAll(arrayList);
        }
        if (arrayList4 != null && !arrayList4.isEmpty()) {
            b().add("title_disable_app");
            b().addAll(arrayList4);
        }
        if (arrayList2 != null && arrayList2.size() > 0) {
            b().add("title_recent_updates");
            b().addAll(arrayList2);
        }
        if (arrayList3 != null && arrayList3.size() > 0) {
            b().add("title_ignored");
            b().addAll(arrayList3);
        }
    }

    public final ArrayList b() {
        ArrayList arrayList = this.f7469e;
        if (arrayList != null) {
            return arrayList;
        }
        m.u(DataSchemeDataSource.SCHEME_DATA);
        return null;
    }

    public final int c() {
        return this.f7473i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001a, code lost:
        r4 = (g2.C2048f) r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void d(java.lang.String r8) {
        /*
            r7 = this;
            java.util.ArrayList r0 = r7.b()
            java.util.Iterator r0 = r0.iterator()
            r1 = 0
        L_0x0009:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x004c
            int r2 = r1 + 1
            java.lang.Object r3 = r0.next()
            boolean r4 = r3 instanceof g2.C2048f
            r5 = 1
            if (r4 == 0) goto L_0x0035
            r4 = r3
            g2.f r4 = (g2.C2048f) r4
            java.lang.String r6 = r4.o()
            if (r6 == 0) goto L_0x0035
            int r6 = r6.length()
            if (r6 != 0) goto L_0x002a
            goto L_0x0035
        L_0x002a:
            java.lang.String r4 = r4.o()
            boolean r4 = m3.m.p(r4, r8, r5)
            if (r4 == 0) goto L_0x0035
            goto L_0x004d
        L_0x0035:
            boolean r4 = r3 instanceof M1.J.a
            if (r4 == 0) goto L_0x004a
            M1.J$a r3 = (M1.J.a) r3
            g2.S r3 = r3.b()
            java.lang.String r3 = r3.h()
            boolean r3 = m3.m.p(r3, r8, r5)
            if (r3 == 0) goto L_0x004a
            goto L_0x004d
        L_0x004a:
            r1 = r2
            goto L_0x0009
        L_0x004c:
            r1 = -1
        L_0x004d:
            if (r1 < 0) goto L_0x0052
            r7.notifyItemChanged(r1)
        L_0x0052:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: M1.J.d(java.lang.String):void");
    }

    public final void e() {
        this.f7472h = true;
        int i4 = 0;
        int i5 = 0;
        int i6 = -1;
        for (Object obj : b()) {
            int i7 = i4 + 1;
            if (obj instanceof a) {
                if (i6 == -1) {
                    i6 = i4;
                } else {
                    i5++;
                }
            } else if (i6 != -1) {
                break;
            }
            i4 = i7;
        }
        if (i6 >= 0) {
            notifyItemRangeChanged(i6, i5);
        } else {
            notifyDataSetChanged();
        }
    }

    /* JADX WARNING: type inference failed for: r9v2, types: [java.util.ArrayList] */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0033, code lost:
        r6 = (g2.C2048f) r5;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void f(java.io.File r13, android.content.Context r14) {
        /*
            r12 = this;
            java.lang.String r0 = "file"
            kotlin.jvm.internal.m.e(r13, r0)
            java.lang.String r0 = "context"
            kotlin.jvm.internal.m.e(r14, r0)
            u2.t$a r0 = u2.t.f21927u
            u2.t r0 = r0.a(r14)
            r0.a()
            java.util.ArrayList r1 = r12.b()
            java.util.Iterator r1 = r1.iterator()
            r2 = -1
            r3 = 0
        L_0x001d:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x00eb
            int r4 = r3 + 1
            java.lang.Object r5 = r1.next()
            boolean r6 = r5 instanceof g2.C2048f
            java.lang.String r7 = "next(...)"
            java.lang.String r8 = "iterator(...)"
            r9 = 0
            r10 = 1
            if (r6 == 0) goto L_0x0089
            r6 = r5
            g2.f r6 = (g2.C2048f) r6
            java.lang.String r11 = r6.o()
            if (r11 == 0) goto L_0x0089
            int r11 = r11.length()
            if (r11 != 0) goto L_0x0043
            goto L_0x0089
        L_0x0043:
            java.lang.String r5 = r6.o()
            kotlin.jvm.internal.m.b(r5)
            g2.S r5 = r0.D0(r5)
            if (r5 == 0) goto L_0x0054
            g2.s r9 = r5.b(r14)
        L_0x0054:
            if (r9 == 0) goto L_0x00e8
            java.util.ArrayList r5 = r9.o()
            int r5 = r5.size()
            if (r5 <= 0) goto L_0x00e8
            java.util.ArrayList r5 = r9.o()
            java.util.Iterator r5 = r5.iterator()
            kotlin.jvm.internal.m.d(r5, r8)
        L_0x006b:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x00e8
            java.lang.Object r6 = r5.next()
            kotlin.jvm.internal.m.d(r6, r7)
            g2.s$c r6 = (g2.C2060s.c) r6
            java.lang.String r6 = r6.a()
            java.lang.String r8 = r13.getAbsolutePath()
            boolean r6 = m3.m.p(r6, r8, r10)
            if (r6 == 0) goto L_0x006b
            goto L_0x00e7
        L_0x0089:
            boolean r6 = r5 instanceof M1.J.a
            if (r6 == 0) goto L_0x00e8
            M1.J$a r5 = (M1.J.a) r5
            g2.S r6 = r5.b()
            g2.s r6 = r6.a()
            if (r6 == 0) goto L_0x009d
            java.util.ArrayList r9 = r6.o()
        L_0x009d:
            if (r9 == 0) goto L_0x00e8
            g2.S r6 = r5.b()
            g2.s r6 = r6.a()
            kotlin.jvm.internal.m.b(r6)
            java.util.ArrayList r6 = r6.o()
            int r6 = r6.size()
            if (r6 <= 0) goto L_0x00e8
            g2.S r5 = r5.b()
            g2.s r5 = r5.a()
            kotlin.jvm.internal.m.b(r5)
            java.util.ArrayList r5 = r5.o()
            java.util.Iterator r5 = r5.iterator()
            kotlin.jvm.internal.m.d(r5, r8)
        L_0x00ca:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x00e8
            java.lang.Object r6 = r5.next()
            kotlin.jvm.internal.m.d(r6, r7)
            g2.s$c r6 = (g2.C2060s.c) r6
            java.lang.String r6 = r6.a()
            java.lang.String r8 = r13.getAbsolutePath()
            boolean r6 = m3.m.p(r6, r8, r10)
            if (r6 == 0) goto L_0x00ca
        L_0x00e7:
            r2 = r3
        L_0x00e8:
            r3 = r4
            goto L_0x001d
        L_0x00eb:
            r0.i()
            if (r2 < 0) goto L_0x00f3
            r12.notifyItemChanged(r2)
        L_0x00f3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: M1.J.f(java.io.File, android.content.Context):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0029, code lost:
        r4 = (g2.C2048f) r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void g(android.content.Context r8, java.lang.String r9) {
        /*
            r7 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.m.e(r8, r0)
            if (r9 == 0) goto L_0x0084
            int r0 = r9.length()
            if (r0 != 0) goto L_0x000f
            goto L_0x0084
        L_0x000f:
            java.util.ArrayList r0 = r7.b()
            java.util.Iterator r0 = r0.iterator()
            r1 = 0
        L_0x0018:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x005b
            int r2 = r1 + 1
            java.lang.Object r3 = r0.next()
            boolean r4 = r3 instanceof g2.C2048f
            r5 = 1
            if (r4 == 0) goto L_0x0044
            r4 = r3
            g2.f r4 = (g2.C2048f) r4
            java.lang.String r6 = r4.o()
            if (r6 == 0) goto L_0x0044
            int r6 = r6.length()
            if (r6 != 0) goto L_0x0039
            goto L_0x0044
        L_0x0039:
            java.lang.String r4 = r4.o()
            boolean r4 = m3.m.p(r4, r9, r5)
            if (r4 == 0) goto L_0x0044
            goto L_0x005c
        L_0x0044:
            boolean r4 = r3 instanceof M1.J.a
            if (r4 == 0) goto L_0x0059
            M1.J$a r3 = (M1.J.a) r3
            g2.S r3 = r3.b()
            java.lang.String r3 = r3.h()
            boolean r3 = m3.m.p(r3, r9, r5)
            if (r3 == 0) goto L_0x0059
            goto L_0x005c
        L_0x0059:
            r1 = r2
            goto L_0x0018
        L_0x005b:
            r1 = -1
        L_0x005c:
            if (r1 < 0) goto L_0x0084
            u2.t$a r0 = u2.t.f21927u
            u2.t r8 = r0.a(r8)
            r8.a()
            g2.S r9 = r8.D0(r9)
            r8.i()
            if (r9 == 0) goto L_0x0081
            boolean r8 = r9.m()
            if (r8 == 0) goto L_0x0081
            java.util.ArrayList r8 = r7.b()
            r8.remove(r1)
            r7.notifyItemRemoved(r1)
            return
        L_0x0081:
            r7.notifyItemChanged(r1)
        L_0x0084:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: M1.J.g(android.content.Context, java.lang.String):void");
    }

    public int getItemCount() {
        return b().size();
    }

    public int getItemViewType(int i4) {
        Object obj = b().get(i4);
        m.d(obj, "get(...)");
        if (obj instanceof C2048f) {
            if (((C2048f) obj).e() == 1) {
                return 9;
            }
            return 1;
        } else if (obj instanceof a) {
            a aVar = (a) obj;
            if (aVar.a().e() == 1) {
                return 9;
            }
            if (aVar.b().m()) {
                return 10;
            }
            return 0;
        } else if (obj instanceof String) {
            String str = (String) obj;
            switch (str.hashCode()) {
                case -1764562172:
                    if (str.equals("tracking_disabled")) {
                        return 4;
                    }
                    break;
                case -864119891:
                    if (str.equals("title_recent_updates")) {
                        return 5;
                    }
                    break;
                case 446114743:
                    if (str.equals("warning_not_space")) {
                        return 2;
                    }
                    break;
                case 903589355:
                    if (str.equals("title_ignored")) {
                        return 6;
                    }
                    break;
                case 1477891299:
                    if (str.equals("title_disable_app")) {
                        return 7;
                    }
                    break;
            }
            throw new IllegalArgumentException();
        } else if (obj instanceof c) {
            return 8;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public final void h(int i4) {
        Object remove = b().remove(i4);
        m.c(remove, "null cannot be cast to non-null type com.uptodown.adapters.UpdatesAdapter.AppUpdateData");
        a aVar = (a) remove;
        aVar.a().c0(C2048f.c.UPDATED);
        notifyItemRemoved(i4);
        int indexOf = b().indexOf("title_recent_updates") + 1;
        b().add(indexOf, aVar.a());
        notifyItemInserted(indexOf);
    }

    public final void i() {
        this.f7471g = -1;
    }

    public final void j(ArrayList arrayList) {
        m.e(arrayList, "<set-?>");
        this.f7469e = arrayList;
    }

    public final void k(ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4, Context context) {
        m.e(context, "context");
        a(arrayList, arrayList2, arrayList3, arrayList4, context);
        notifyDataSetChanged();
    }

    /* JADX WARNING: type inference failed for: r8v2, types: [java.util.ArrayList] */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0032, code lost:
        r5 = (g2.C2048f) r4;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void l(java.io.File r12, android.content.Context r13) {
        /*
            r11 = this;
            java.lang.String r0 = "file"
            kotlin.jvm.internal.m.e(r12, r0)
            java.lang.String r0 = "context"
            kotlin.jvm.internal.m.e(r13, r0)
            u2.t$a r0 = u2.t.f21927u
            u2.t r0 = r0.a(r13)
            r0.a()
            java.util.ArrayList r1 = r11.b()
            java.util.Iterator r1 = r1.iterator()
            r2 = 0
        L_0x001c:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x00ed
            int r3 = r2 + 1
            java.lang.Object r4 = r1.next()
            boolean r5 = r4 instanceof g2.C2048f
            java.lang.String r6 = "next(...)"
            java.lang.String r7 = "iterator(...)"
            r8 = 0
            r9 = 1
            if (r5 == 0) goto L_0x008a
            r5 = r4
            g2.f r5 = (g2.C2048f) r5
            java.lang.String r10 = r5.o()
            if (r10 == 0) goto L_0x008a
            int r10 = r10.length()
            if (r10 != 0) goto L_0x0042
            goto L_0x008a
        L_0x0042:
            java.lang.String r4 = r5.o()
            kotlin.jvm.internal.m.b(r4)
            g2.S r4 = r0.D0(r4)
            if (r4 == 0) goto L_0x0053
            g2.s r8 = r4.b(r13)
        L_0x0053:
            if (r8 == 0) goto L_0x00ea
            java.util.ArrayList r4 = r8.o()
            int r4 = r4.size()
            if (r4 <= 0) goto L_0x00ea
            java.util.ArrayList r4 = r8.o()
            java.util.Iterator r4 = r4.iterator()
            kotlin.jvm.internal.m.d(r4, r7)
        L_0x006a:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x00ea
            java.lang.Object r5 = r4.next()
            kotlin.jvm.internal.m.d(r5, r6)
            g2.s$c r5 = (g2.C2060s.c) r5
            java.lang.String r5 = r5.a()
            java.lang.String r7 = r12.getAbsolutePath()
            boolean r5 = m3.m.p(r5, r7, r9)
            if (r5 == 0) goto L_0x006a
            r11.f7471g = r2
            goto L_0x00ea
        L_0x008a:
            boolean r5 = r4 instanceof M1.J.a
            if (r5 == 0) goto L_0x00ea
            M1.J$a r4 = (M1.J.a) r4
            g2.S r5 = r4.b()
            g2.s r5 = r5.a()
            if (r5 == 0) goto L_0x009e
            java.util.ArrayList r8 = r5.o()
        L_0x009e:
            if (r8 == 0) goto L_0x00ea
            g2.S r5 = r4.b()
            g2.s r5 = r5.a()
            kotlin.jvm.internal.m.b(r5)
            java.util.ArrayList r5 = r5.o()
            int r5 = r5.size()
            if (r5 <= 0) goto L_0x00ea
            g2.S r4 = r4.b()
            g2.s r4 = r4.a()
            kotlin.jvm.internal.m.b(r4)
            java.util.ArrayList r4 = r4.o()
            java.util.Iterator r4 = r4.iterator()
            kotlin.jvm.internal.m.d(r4, r7)
        L_0x00cb:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x00ea
            java.lang.Object r5 = r4.next()
            kotlin.jvm.internal.m.d(r5, r6)
            g2.s$c r5 = (g2.C2060s.c) r5
            java.lang.String r5 = r5.a()
            java.lang.String r7 = r12.getAbsolutePath()
            boolean r5 = m3.m.p(r5, r7, r9)
            if (r5 == 0) goto L_0x00cb
            r11.f7471g = r2
        L_0x00ea:
            r2 = r3
            goto L_0x001c
        L_0x00ed:
            r0.i()
            int r12 = r11.f7471g
            if (r12 < 0) goto L_0x00f7
            r11.notifyItemChanged(r12)
        L_0x00f7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: M1.J.l(java.io.File, android.content.Context):void");
    }

    public final void m(boolean z4) {
        this.f7472h = z4;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i4) {
        m.e(viewHolder, "viewHolder");
        if (viewHolder instanceof C2371h) {
            Object obj = b().get(i4);
            m.c(obj, "null cannot be cast to non-null type com.uptodown.models.App");
            ((C2371h) viewHolder).c((C2048f) obj);
            return;
        }
        boolean z4 = true;
        if (viewHolder instanceof Z0) {
            Z0 z02 = (Z0) viewHolder;
            Object obj2 = b().get(i4);
            m.c(obj2, "null cannot be cast to non-null type com.uptodown.adapters.UpdatesAdapter.AppUpdateData");
            a aVar = (a) obj2;
            if (this.f7471g != i4) {
                z4 = false;
            }
            z02.p(aVar, z4, this.f7472h);
        } else if (viewHolder instanceof U) {
            ((U) viewHolder).e(true);
        } else if (viewHolder instanceof B1) {
            ((B1) viewHolder).a(true);
        } else if (viewHolder instanceof U0) {
            ((U0) viewHolder).b(this.f7470f.a());
        } else if (viewHolder instanceof D1) {
            a.C0236a aVar2 = com.uptodown.activities.preferences.a.f18818a;
            Context context = viewHolder.itemView.getContext();
            m.d(context, "getContext(...)");
            ((D1) viewHolder).c(!aVar2.i0(context));
        } else if (viewHolder instanceof C2356b) {
            Object obj3 = b().get(i4);
            m.c(obj3, "null cannot be cast to non-null type com.uptodown.models.App");
            ((C2356b) viewHolder).c((C2048f) obj3);
        } else {
            throw new IllegalArgumentException("ViewHolder unknown!!");
        }
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i4) {
        m.e(viewGroup, "viewGroup");
        switch (i4) {
            case 0:
                return new Z0(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.update_item, viewGroup, false), this.f7465a);
            case 1:
                return new C2371h(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.installed_app_item, viewGroup, false), this.f7466b);
            case 2:
                return new B1(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.warning_not_space_available, viewGroup, false));
            case 4:
                return new D1(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tracking_disabled, viewGroup, false), this.f7467c);
            case 5:
                View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tv_myappsupdates_title, viewGroup, false);
                String string = viewGroup.getContext().getString(R.string.recent_updates);
                m.d(string, "getString(...)");
                return new U(inflate, string, (C2029u) null);
            case 6:
                View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tv_myappsupdates_title, viewGroup, false);
                String string2 = viewGroup.getContext().getString(R.string.update_ignored);
                m.d(string2, "getString(...)");
                return new U(inflate2, string2, (C2029u) null);
            case 7:
                View inflate3 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tv_myappsupdates_title, viewGroup, false);
                String string3 = viewGroup.getContext().getString(R.string.disabled_apps);
                m.d(string3, "getString(...)");
                return new U(inflate3, string3, this.f7468d);
            case 8:
                return new U0(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.updates_header, viewGroup, false), this.f7467c);
            case 9:
                return new C2356b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.installed_app_item, viewGroup, false), this.f7466b);
            case 10:
                return new S0(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.installed_app_item, viewGroup, false), this.f7466b);
            default:
                throw new IllegalArgumentException("viewType unknown");
        }
    }
}
