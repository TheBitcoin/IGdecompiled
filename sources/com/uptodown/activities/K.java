package com.uptodown.activities;

import android.content.Context;
import androidx.lifecycle.ViewModel;
import com.uptodown.UptodownApp;
import g2.C2038F;
import g2.C2048f;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.m;
import r3.I;
import r3.t;
import u2.E;

public final class K extends ViewModel {

    /* renamed from: a  reason: collision with root package name */
    private final t f17731a;

    /* renamed from: b  reason: collision with root package name */
    private final I f17732b;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final ArrayList f17733a;

        public a(ArrayList arrayList) {
            m.e(arrayList, "positives");
            this.f17733a = arrayList;
        }

        public final ArrayList a() {
            return this.f17733a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && m.a(this.f17733a, ((a) obj).f17733a);
        }

        public int hashCode() {
            return this.f17733a.hashCode();
        }

        public String toString() {
            return "SecurityData(positives=" + this.f17733a + ')';
        }
    }

    public K() {
        t a5 = r3.K.a(E.a.f21883a);
        this.f17731a = a5;
        this.f17732b = a5;
    }

    public final void a(Context context) {
        m.e(context, "context");
        ArrayList arrayList = new ArrayList();
        ArrayList B4 = new u2.m().B(context);
        UptodownApp.a aVar = UptodownApp.f17422D;
        if (aVar.t() != null) {
            ArrayList t4 = aVar.t();
            m.b(t4);
            Iterator it = t4.iterator();
            m.d(it, "iterator(...)");
            while (it.hasNext()) {
                Object next = it.next();
                m.d(next, "next(...)");
                C2038F f4 = (C2038F) next;
                Iterator it2 = B4.iterator();
                m.d(it2, "iterator(...)");
                while (it2.hasNext()) {
                    Object next2 = it2.next();
                    m.d(next2, "next(...)");
                    C2048f fVar = (C2048f) next2;
                    if (m.a(f4.c(), fVar.r())) {
                        fVar.X(f4);
                        arrayList.add(fVar);
                    }
                }
            }
        }
        u2.m.f21904a.l(arrayList, context);
        this.f17731a.setValue(new E.c(new a(arrayList)));
    }

    public final I b() {
        return this.f17732b;
    }
}
