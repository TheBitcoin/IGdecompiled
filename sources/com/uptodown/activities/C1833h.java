package com.uptodown.activities;

import R2.n;
import R2.s;
import S2.C1601o;
import V2.d;
import W1.C1612h;
import android.content.Context;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import d3.p;
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

/* renamed from: com.uptodown.activities.h  reason: case insensitive filesystem */
public final class C1833h extends ViewModel {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final t f18767a;

    /* renamed from: b  reason: collision with root package name */
    private final I f18768b;

    /* renamed from: c  reason: collision with root package name */
    private final t f18769c = K.a(Boolean.FALSE);

    /* renamed from: com.uptodown.activities.h$a */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final ArrayList f18770a;

        public a(ArrayList arrayList) {
            m.e(arrayList, "tmpUserApps");
            this.f18770a = arrayList;
        }

        public final ArrayList a() {
            return this.f18770a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && m.a(this.f18770a, ((a) obj).f18770a);
        }

        public int hashCode() {
            return this.f18770a.hashCode();
        }

        public String toString() {
            return "FreeUpSpaceData(tmpUserApps=" + this.f18770a + ')';
        }
    }

    /* renamed from: com.uptodown.activities.h$b */
    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f18771a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f18772b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C1833h f18773c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Context f18774d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(boolean z4, C1833h hVar, Context context, d dVar) {
            super(2, dVar);
            this.f18772b = z4;
            this.f18773c = hVar;
            this.f18774d = context;
        }

        /* access modifiers changed from: private */
        public static final int k(C2048f fVar, C2048f fVar2) {
            return m.h(fVar2.t(), fVar.t());
        }

        /* access modifiers changed from: private */
        public static final int l(p pVar, Object obj, Object obj2) {
            return ((Number) pVar.invoke(obj, obj2)).intValue();
        }

        public final d create(Object obj, d dVar) {
            return new b(this.f18772b, this.f18773c, this.f18774d, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f18771a == 0) {
                n.b(obj);
                if (this.f18772b) {
                    this.f18773c.f18767a.setValue(E.a.f21883a);
                }
                ArrayList arrayList = new ArrayList();
                Iterator it = new u2.m().B(this.f18774d).iterator();
                m.d(it, "iterator(...)");
                while (it.hasNext()) {
                    Object next = it.next();
                    m.d(next, "next(...)");
                    C2048f fVar = (C2048f) next;
                    C1612h hVar = new C1612h();
                    Context context = this.f18774d;
                    String o4 = fVar.o();
                    m.b(o4);
                    if (!hVar.p(context, o4) && !fVar.H() && !fVar.F()) {
                        arrayList.add(fVar);
                    }
                }
                C1601o.t(arrayList, new C1835j(new C1834i()));
                this.f18773c.f18767a.setValue(new E.c(new a(arrayList)));
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, d dVar) {
            return ((b) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public C1833h() {
        t a5 = K.a(E.a.f21883a);
        this.f18767a = a5;
        this.f18768b = a5;
    }

    public final void b(Context context, boolean z4) {
        m.e(context, "context");
        C1001s0 unused = C0981i.d(ViewModelKt.getViewModelScope(this), Y.b(), (L) null, new b(z4, this, context, (d) null), 2, (Object) null);
    }

    public final t c() {
        return this.f18769c;
    }

    public final I d() {
        return this.f18768b;
    }
}
