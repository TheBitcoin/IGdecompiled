package com.uptodown.activities;

import R2.n;
import R2.s;
import V2.d;
import W1.C1612h;
import android.content.Context;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.uptodown.UptodownApp;
import com.uptodown.activities.preferences.a;
import d3.p;
import g2.C2038F;
import g2.C2048f;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.m;
import o3.C1001s0;
import o3.J;
import o3.L;
import o3.Y;
import r3.I;
import r3.K;
import r3.t;
import u2.E;
import u2.m;

public final class r extends ViewModel {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final t f18821a;

    /* renamed from: b  reason: collision with root package name */
    private final I f18822b;

    /* renamed from: c  reason: collision with root package name */
    private final t f18823c = K.a(Boolean.FALSE);

    /* renamed from: d  reason: collision with root package name */
    private String f18824d;

    /* renamed from: e  reason: collision with root package name */
    private t f18825e = K.a(0);

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final ArrayList f18826a;

        /* renamed from: b  reason: collision with root package name */
        private final ArrayList f18827b;

        /* renamed from: c  reason: collision with root package name */
        private final ArrayList f18828c;

        /* renamed from: d  reason: collision with root package name */
        private final ArrayList f18829d;

        /* renamed from: e  reason: collision with root package name */
        private final ArrayList f18830e;

        public a(ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4, ArrayList arrayList5) {
            m.e(arrayList, "tmpUserApps");
            m.e(arrayList2, "tmpSystemApps");
            m.e(arrayList3, "tmpDisabledApps");
            m.e(arrayList4, "tmpSystemServices");
            m.e(arrayList5, "tmpPositiveApps");
            this.f18826a = arrayList;
            this.f18827b = arrayList2;
            this.f18828c = arrayList3;
            this.f18829d = arrayList4;
            this.f18830e = arrayList5;
        }

        public final ArrayList a() {
            return this.f18828c;
        }

        public final ArrayList b() {
            return this.f18827b;
        }

        public final ArrayList c() {
            return this.f18829d;
        }

        public final ArrayList d() {
            return this.f18826a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return m.a(this.f18826a, aVar.f18826a) && m.a(this.f18827b, aVar.f18827b) && m.a(this.f18828c, aVar.f18828c) && m.a(this.f18829d, aVar.f18829d) && m.a(this.f18830e, aVar.f18830e);
        }

        public int hashCode() {
            return (((((((this.f18826a.hashCode() * 31) + this.f18827b.hashCode()) * 31) + this.f18828c.hashCode()) * 31) + this.f18829d.hashCode()) * 31) + this.f18830e.hashCode();
        }

        public String toString() {
            return "MyAppsData(tmpUserApps=" + this.f18826a + ", tmpSystemApps=" + this.f18827b + ", tmpDisabledApps=" + this.f18828c + ", tmpSystemServices=" + this.f18829d + ", tmpPositiveApps=" + this.f18830e + ')';
        }
    }

    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f18831a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f18832b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ r f18833c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Context f18834d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(boolean z4, r rVar, Context context, d dVar) {
            super(2, dVar);
            this.f18832b = z4;
            this.f18833c = rVar;
            this.f18834d = context;
        }

        public final d create(Object obj, d dVar) {
            return new b(this.f18832b, this.f18833c, this.f18834d, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f18831a == 0) {
                n.b(obj);
                if (this.f18832b) {
                    this.f18833c.f18821a.setValue(E.a.f21883a);
                }
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                ArrayList arrayList4 = new ArrayList();
                ArrayList arrayList5 = new ArrayList();
                ArrayList B4 = new u2.m().B(this.f18834d);
                a.C0236a aVar = com.uptodown.activities.preferences.a.f18818a;
                boolean f02 = aVar.f0(this.f18834d);
                boolean g02 = aVar.g0(this.f18834d);
                Iterator it = B4.iterator();
                m.d(it, "iterator(...)");
                while (it.hasNext()) {
                    Object next = it.next();
                    m.d(next, "next(...)");
                    C2048f fVar = (C2048f) next;
                    C1612h hVar = new C1612h();
                    Context context = this.f18834d;
                    String o4 = fVar.o();
                    m.b(o4);
                    if (hVar.p(context, o4)) {
                        kotlin.coroutines.jvm.internal.b.a(arrayList3.add(fVar));
                    } else if (fVar.H()) {
                        if (g02) {
                            arrayList4.add(fVar);
                        }
                    } else if (!fVar.F()) {
                        kotlin.coroutines.jvm.internal.b.a(arrayList.add(fVar));
                    } else if (f02) {
                        arrayList2.add(fVar);
                    }
                    UptodownApp.a aVar2 = UptodownApp.f17422D;
                    if (aVar2.t() != null) {
                        ArrayList t4 = aVar2.t();
                        m.b(t4);
                        Iterator it2 = t4.iterator();
                        m.d(it2, "iterator(...)");
                        while (it2.hasNext()) {
                            Object next2 = it2.next();
                            m.d(next2, "next(...)");
                            C2038F f4 = (C2038F) next2;
                            if (m.a(f4.c(), fVar.r())) {
                                fVar.X(f4);
                                arrayList5.add(fVar);
                            }
                        }
                    }
                }
                int intValue = ((Number) this.f18833c.f().getValue()).intValue();
                if (intValue == 0) {
                    m.a aVar3 = u2.m.f21904a;
                    aVar3.l(arrayList, this.f18834d);
                    aVar3.l(arrayList2, this.f18834d);
                    aVar3.l(arrayList4, this.f18834d);
                    aVar3.l(arrayList3, this.f18834d);
                } else if (intValue == 1) {
                    m.a aVar4 = u2.m.f21904a;
                    aVar4.i(arrayList, this.f18834d);
                    aVar4.i(arrayList2, this.f18834d);
                    aVar4.i(arrayList4, this.f18834d);
                    aVar4.i(arrayList3, this.f18834d);
                } else if (intValue == 2) {
                    m.a aVar5 = u2.m.f21904a;
                    aVar5.n(arrayList, this.f18834d);
                    aVar5.n(arrayList2, this.f18834d);
                    aVar5.n(arrayList4, this.f18834d);
                    aVar5.n(arrayList3, this.f18834d);
                }
                String g4 = this.f18833c.g();
                if (g4 == null || g4.length() == 0) {
                    this.f18833c.f18821a.setValue(new E.c(new a(arrayList, arrayList2, arrayList3, arrayList4, arrayList5)));
                } else {
                    r rVar = this.f18833c;
                    String g5 = rVar.g();
                    kotlin.jvm.internal.m.b(g5);
                    ArrayList b5 = rVar.h(arrayList, g5);
                    r rVar2 = this.f18833c;
                    String g6 = rVar2.g();
                    kotlin.jvm.internal.m.b(g6);
                    ArrayList b6 = rVar2.h(arrayList2, g6);
                    r rVar3 = this.f18833c;
                    String g7 = rVar3.g();
                    kotlin.jvm.internal.m.b(g7);
                    ArrayList b7 = rVar3.h(arrayList3, g7);
                    r rVar4 = this.f18833c;
                    String g8 = rVar4.g();
                    kotlin.jvm.internal.m.b(g8);
                    this.f18833c.f18821a.setValue(new E.c(new a(b5, b6, b7, rVar4.h(arrayList4, g8), arrayList5)));
                }
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, d dVar) {
            return ((b) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public r() {
        t a5 = K.a(E.a.f21883a);
        this.f18821a = a5;
        this.f18822b = a5;
    }

    /* access modifiers changed from: private */
    public final ArrayList h(ArrayList arrayList, String str) {
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i4 = 0;
        while (i4 < size) {
            Object obj = arrayList.get(i4);
            i4++;
            C2048f fVar = (C2048f) obj;
            String m4 = fVar.m();
            boolean z4 = true;
            if (m4 == null || m4.length() == 0) {
                String o4 = fVar.o();
                if (!(o4 == null || o4.length() == 0)) {
                    String o5 = fVar.o();
                    kotlin.jvm.internal.m.b(o5);
                    z4 = m3.m.B(o5, str, true);
                }
            } else {
                String m5 = fVar.m();
                kotlin.jvm.internal.m.b(m5);
                z4 = m3.m.B(m5, str, true);
            }
            if (z4) {
                arrayList2.add(obj);
            }
        }
        return arrayList2;
    }

    public final void c(Context context, boolean z4) {
        kotlin.jvm.internal.m.e(context, "context");
        C1001s0 unused = C0981i.d(ViewModelKt.getViewModelScope(this), Y.b(), (L) null, new b(z4, this, context, (d) null), 2, (Object) null);
    }

    public final t d() {
        return this.f18823c;
    }

    public final I e() {
        return this.f18822b;
    }

    public final t f() {
        return this.f18825e;
    }

    public final String g() {
        return this.f18824d;
    }

    public final void i(String str) {
        this.f18824d = str;
    }
}
