package com.uptodown.activities;

import android.content.Context;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import b2.x;
import f2.T;
import java.util.ArrayList;
import kotlin.jvm.internal.m;
import r3.I;
import r3.K;
import r3.t;
import u2.E;

public final class X extends ViewModel {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final t f18685a;

    /* renamed from: b  reason: collision with root package name */
    private final I f18686b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f18687c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f18688d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public int f18689e;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final ArrayList f18690a;

        public a(ArrayList arrayList) {
            m.e(arrayList, "wishlist");
            this.f18690a = arrayList;
        }

        public final ArrayList a() {
            return this.f18690a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && m.a(this.f18690a, ((a) obj).f18690a);
        }

        public int hashCode() {
            return this.f18690a.hashCode();
        }

        public String toString() {
            return "WishlistData(wishlist=" + this.f18690a + ')';
        }
    }

    public static final class b implements T {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ X f18691a;

        b(X x4) {
            this.f18691a = x4;
        }

        public void a() {
            this.f18691a.f18685a.setValue(new E.c(new a(new ArrayList())));
            this.f18691a.i(false);
        }

        public void c(ArrayList arrayList, boolean z4) {
            m.e(arrayList, "userList");
            if (arrayList.size() > 0) {
                X x4 = this.f18691a;
                x4.f18689e = x4.f18689e + arrayList.size();
                this.f18691a.f18685a.setValue(new E.c(new a(arrayList)));
            } else if (this.f18691a.f18689e == 0) {
                this.f18691a.f18685a.setValue(new E.c(new a(new ArrayList())));
            } else {
                this.f18691a.h(true);
                this.f18691a.f18685a.setValue(E.b.f21884a);
            }
            this.f18691a.i(false);
        }
    }

    public X() {
        t a5 = K.a(E.a.f21883a);
        this.f18685a = a5;
        this.f18686b = a5;
    }

    public final void d(Context context) {
        m.e(context, "context");
        this.f18688d = true;
        this.f18685a.setValue(E.a.f21883a);
        new x(context, ViewModelKt.getViewModelScope(this)).j(30, this.f18689e, new b(this));
    }

    public final boolean e() {
        return this.f18687c;
    }

    public final I f() {
        return this.f18686b;
    }

    public final boolean g() {
        return this.f18688d;
    }

    public final void h(boolean z4) {
        this.f18687c = z4;
    }

    public final void i(boolean z4) {
        this.f18688d = z4;
    }
}
