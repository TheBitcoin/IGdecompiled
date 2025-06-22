package com.uptodown.activities;

import R2.k;
import R2.n;
import R2.s;
import S2.C1601o;
import android.content.Context;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.uptodown.workers.DownloadWorker;
import d3.p;
import g2.C2060s;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.m;
import o3.C0977g;
import o3.C1001s0;
import o3.J;
import o3.L;
import o3.Y;
import r3.I;
import r3.K;
import r3.t;
import u2.E;

/* renamed from: com.uptodown.activities.s  reason: case insensitive filesystem */
public final class C1843s extends ViewModel {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final t f18835a;

    /* renamed from: b  reason: collision with root package name */
    private final I f18836b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final t f18837c = K.a(new ArrayList());
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final t f18838d = K.a(new ArrayList());

    /* renamed from: e  reason: collision with root package name */
    private String f18839e;

    /* renamed from: f  reason: collision with root package name */
    private t f18840f = K.a(1);

    /* renamed from: com.uptodown.activities.s$a */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final ArrayList f18841a;

        /* renamed from: b  reason: collision with root package name */
        private final ArrayList f18842b;

        public a(ArrayList arrayList, ArrayList arrayList2) {
            m.e(arrayList, "downloads");
            m.e(arrayList2, "downloadsQueue");
            this.f18841a = arrayList;
            this.f18842b = arrayList2;
        }

        public final ArrayList a() {
            return this.f18841a;
        }

        public final ArrayList b() {
            return this.f18842b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return m.a(this.f18841a, aVar.f18841a) && m.a(this.f18842b, aVar.f18842b);
        }

        public int hashCode() {
            return (this.f18841a.hashCode() * 31) + this.f18842b.hashCode();
        }

        public String toString() {
            return "MyDownloadsData(downloads=" + this.f18841a + ", downloadsQueue=" + this.f18842b + ')';
        }
    }

    /* renamed from: com.uptodown.activities.s$b */
    public enum b {
        NAME,
        DATE,
        SIZE;

        static {
            b[] a5;
            f18847e = X2.b.a(a5);
        }
    }

    /* renamed from: com.uptodown.activities.s$c */
    public /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f18848a;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                com.uptodown.activities.s$b[] r0 = com.uptodown.activities.C1843s.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.uptodown.activities.s$b r1 = com.uptodown.activities.C1843s.b.DATE     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.uptodown.activities.s$b r1 = com.uptodown.activities.C1843s.b.SIZE     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.uptodown.activities.s$b r1 = com.uptodown.activities.C1843s.b.NAME     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                f18848a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.C1843s.c.<clinit>():void");
        }
    }

    /* renamed from: com.uptodown.activities.s$d */
    static final class d extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f18849a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2060s f18850b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f18851c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(C2060s sVar, Context context, V2.d dVar) {
            super(2, dVar);
            this.f18850b = sVar;
            this.f18851c = context;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new d(this.f18850b, this.f18851c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f18849a == 0) {
                n.b(obj);
                DownloadWorker.a aVar = DownloadWorker.f19459d;
                if (aVar.k(this.f18850b.h(), this.f18850b.E())) {
                    aVar.d(this.f18850b.h());
                }
                u2.t a5 = u2.t.f21927u.a(this.f18851c);
                a5.a();
                boolean z4 = true;
                if (a5.z(this.f18850b) != 1) {
                    z4 = false;
                }
                a5.i();
                this.f18850b.g();
                return kotlin.coroutines.jvm.internal.b.a(z4);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((d) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    /* renamed from: com.uptodown.activities.s$e */
    static final class e extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f18852a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f18853b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C1843s f18854c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Context f18855d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ b f18856e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(boolean z4, C1843s sVar, Context context, b bVar, V2.d dVar) {
            super(2, dVar);
            this.f18853b = z4;
            this.f18854c = sVar;
            this.f18855d = context;
            this.f18856e = bVar;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new e(this.f18853b, this.f18854c, this.f18855d, this.f18856e, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f18852a == 0) {
                n.b(obj);
                if (this.f18853b) {
                    this.f18854c.f18835a.setValue(E.a.f21883a);
                }
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                u2.t a5 = u2.t.f21927u.a(this.f18855d);
                a5.a();
                Iterator it = a5.m0().iterator();
                m.d(it, "iterator(...)");
                while (it.hasNext()) {
                    Object next = it.next();
                    m.d(next, "next(...)");
                    C2060s sVar = (C2060s) next;
                    if (sVar.N()) {
                        if (sVar.K()) {
                            kotlin.coroutines.jvm.internal.b.a(arrayList.add(sVar));
                        } else if (sVar.o().size() == 0) {
                            a5.z(sVar);
                        } else if (sVar.o().size() == 1 && ((C2060s.c) sVar.o().get(0)).a() != null) {
                            String a6 = ((C2060s.c) sVar.o().get(0)).a();
                            m.b(a6);
                            File file = new File(a6);
                            if (!file.exists()) {
                                kotlin.coroutines.jvm.internal.b.b(a5.z(sVar));
                            } else {
                                sVar.s(this.f18855d, file);
                                kotlin.coroutines.jvm.internal.b.a(arrayList2.add(sVar));
                            }
                        } else if (sVar.o().size() > 1) {
                            arrayList2.add(sVar);
                        }
                    }
                }
                a5.i();
                this.f18854c.f18838d.setValue(arrayList);
                this.f18854c.f18837c.setValue(arrayList2);
                if (this.f18854c.l() != null) {
                    String l4 = this.f18854c.l();
                    m.b(l4);
                    if (l4.length() > 0) {
                        C1843s sVar2 = this.f18854c;
                        sVar2.i(sVar2.l(), this.f18856e);
                        return s.f8222a;
                    }
                }
                this.f18854c.o(arrayList2, this.f18856e);
                this.f18854c.f18835a.setValue(new E.c(new a(arrayList2, arrayList)));
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((e) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    /* renamed from: com.uptodown.activities.s$f */
    static final class f extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f18857a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C1843s f18858b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f18859c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ b f18860d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(C1843s sVar, String str, b bVar, V2.d dVar) {
            super(2, dVar);
            this.f18858b = sVar;
            this.f18859c = str;
            this.f18860d = bVar;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new f(this.f18858b, this.f18859c, this.f18860d, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f18857a == 0) {
                n.b(obj);
                C1843s sVar = this.f18858b;
                ArrayList e5 = sVar.m((ArrayList) sVar.f18837c.getValue(), this.f18859c);
                this.f18858b.o(e5, this.f18860d);
                C1843s sVar2 = this.f18858b;
                this.f18858b.f18835a.setValue(new E.c(new a(e5, sVar2.m((ArrayList) sVar2.f18838d.getValue(), this.f18859c))));
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((f) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    /* renamed from: com.uptodown.activities.s$g */
    public static final class g implements Comparator {
        public final int compare(Object obj, Object obj2) {
            C2060s sVar = (C2060s) obj2;
            if (!sVar.o().isEmpty() && ((C2060s.c) sVar.o().get(0)).a() != null) {
                String a5 = ((C2060s.c) sVar.o().get(0)).a();
                m.b(a5);
                File file = new File(a5);
                if (file.exists()) {
                    file.lastModified();
                }
            }
            C2060s sVar2 = (C2060s) obj;
            if (!sVar2.o().isEmpty() && ((C2060s.c) sVar2.o().get(0)).a() != null) {
                String a6 = ((C2060s.c) sVar2.o().get(0)).a();
                m.b(a6);
                File file2 = new File(a6);
                if (file2.exists()) {
                    file2.lastModified();
                }
            }
            return U2.a.a(0L, 0L);
        }
    }

    /* renamed from: com.uptodown.activities.s$h */
    public static final class h implements Comparator {
        public final int compare(Object obj, Object obj2) {
            return U2.a.a(((C2060s) obj).i(), ((C2060s) obj2).i());
        }
    }

    /* renamed from: com.uptodown.activities.s$i */
    public static final class i implements Comparator {
        public final int compare(Object obj, Object obj2) {
            return U2.a.a(Long.valueOf(((C2060s) obj).z()), Long.valueOf(((C2060s) obj2).z()));
        }
    }

    public C1843s() {
        t a5 = K.a(E.a.f21883a);
        this.f18835a = a5;
        this.f18836b = a5;
    }

    /* access modifiers changed from: private */
    public final void i(String str, b bVar) {
        C1001s0 unused = C0981i.d(ViewModelKt.getViewModelScope(this), Y.b(), (L) null, new f(this, str, bVar, (V2.d) null), 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public final ArrayList m(ArrayList arrayList, String str) {
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i4 = 0;
        while (i4 < size) {
            Object obj = arrayList.get(i4);
            i4++;
            C2060s sVar = (C2060s) obj;
            String i5 = sVar.i();
            String str2 = "";
            boolean z4 = true;
            if (i5 == null || i5.length() == 0) {
                String w4 = sVar.w();
                if (!(w4 == null || w4.length() == 0)) {
                    String w5 = sVar.w();
                    m.b(w5);
                    if (str != null) {
                        str2 = str;
                    }
                    z4 = m3.m.B(w5, str2, true);
                }
            } else {
                String i6 = sVar.i();
                m.b(i6);
                if (str != null) {
                    str2 = str;
                }
                z4 = m3.m.B(i6, str2, true);
            }
            if (z4) {
                arrayList2.add(obj);
            }
        }
        return arrayList2;
    }

    /* access modifiers changed from: private */
    public final void o(ArrayList arrayList, b bVar) {
        int i4 = c.f18848a[bVar.ordinal()];
        if (i4 == 1) {
            p(arrayList);
        } else if (i4 == 2) {
            r(arrayList);
        } else if (i4 == 3) {
            q(arrayList);
        } else {
            throw new k();
        }
    }

    private final void p(ArrayList arrayList) {
        if (arrayList.size() > 1) {
            C1601o.t(arrayList, new g());
        }
    }

    private final void q(ArrayList arrayList) {
        if (arrayList.size() > 1) {
            C1601o.t(arrayList, new h());
        }
    }

    private final void r(ArrayList arrayList) {
        if (arrayList.size() > 1) {
            C1601o.t(arrayList, new i());
        }
    }

    public final Object g(Context context, C2060s sVar, V2.d dVar) {
        return C0977g.g(Y.b(), new d(sVar, context, (V2.d) null), dVar);
    }

    public final void h(Context context, b bVar, boolean z4) {
        m.e(context, "context");
        m.e(bVar, "sortType");
        C1001s0 unused = C0981i.d(ViewModelKt.getViewModelScope(this), Y.b(), (L) null, new e(z4, this, context, bVar, (V2.d) null), 2, (Object) null);
    }

    public final I j() {
        return this.f18836b;
    }

    public final t k() {
        return this.f18840f;
    }

    public final String l() {
        return this.f18839e;
    }

    public final void n(String str) {
        this.f18839e = str;
    }
}
