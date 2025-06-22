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
import java.util.Comparator;
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

public final class H extends ViewModel {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final t f17711a;

    /* renamed from: b  reason: collision with root package name */
    private final I f17712b;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final ArrayList f17713a;

        public a(ArrayList arrayList) {
            m.e(arrayList, "rollbackApps");
            this.f17713a = arrayList;
        }

        public final ArrayList a() {
            return this.f17713a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && m.a(this.f17713a, ((a) obj).f17713a);
        }

        public int hashCode() {
            return this.f17713a.hashCode();
        }

        public String toString() {
            return "RollbackData(rollbackApps=" + this.f17713a + ')';
        }
    }

    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f17714a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f17715b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ H f17716c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Context f17717d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(boolean z4, H h4, Context context, d dVar) {
            super(2, dVar);
            this.f17715b = z4;
            this.f17716c = h4;
            this.f17717d = context;
        }

        public final d create(Object obj, d dVar) {
            return new b(this.f17715b, this.f17716c, this.f17717d, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f17714a == 0) {
                n.b(obj);
                if (this.f17715b) {
                    this.f17716c.f17711a.setValue(E.a.f21883a);
                }
                this.f17716c.f17711a.setValue(new E.c(new a(this.f17716c.e(this.f17717d, new u2.m().B(this.f17717d)))));
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, d dVar) {
            return ((b) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public static final class c implements Comparator {
        public final int compare(Object obj, Object obj2) {
            return U2.a.a(((C2048f) obj).m(), ((C2048f) obj2).m());
        }
    }

    public H() {
        t a5 = K.a(E.a.f21883a);
        this.f17711a = a5;
        this.f17712b = a5;
    }

    /* access modifiers changed from: private */
    public final ArrayList e(Context context, ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            if (!m3.m.p(context.getPackageName(), ((C2048f) arrayList.get(i4)).o(), true)) {
                C1612h hVar = new C1612h();
                String o4 = ((C2048f) arrayList.get(i4)).o();
                m.b(o4);
                if (!hVar.p(context, o4) && !((C2048f) arrayList.get(i4)).F() && ((C2048f) arrayList.get(i4)).h() == 1) {
                    arrayList2.add(arrayList.get(i4));
                }
            }
        }
        if (arrayList2.size() > 1) {
            C1601o.t(arrayList2, new c());
        }
        return arrayList2;
    }

    public final void c(Context context, boolean z4) {
        m.e(context, "context");
        C1001s0 unused = C0981i.d(ViewModelKt.getViewModelScope(this), Y.b(), (L) null, new b(z4, this, context, (d) null), 2, (Object) null);
    }

    public final I d() {
        return this.f17712b;
    }
}
