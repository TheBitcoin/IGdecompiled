package com.uptodown.activities;

import R2.n;
import R2.s;
import android.content.Context;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.uptodown.R;
import d3.p;
import g2.C2034B;
import java.util.ArrayList;
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

/* renamed from: com.uptodown.activities.t  reason: case insensitive filesystem */
public final class C1844t extends ViewModel {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final t f18861a;

    /* renamed from: b  reason: collision with root package name */
    private final I f18862b;

    /* renamed from: com.uptodown.activities.t$a */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final ArrayList f18863a;

        public a(ArrayList arrayList) {
            m.e(arrayList, "notificationsRegistry");
            this.f18863a = arrayList;
        }

        public final ArrayList a() {
            return this.f18863a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && m.a(this.f18863a, ((a) obj).f18863a);
        }

        public int hashCode() {
            return this.f18863a.hashCode();
        }

        public String toString() {
            return "NotificationRegistryData(notificationsRegistry=" + this.f18863a + ')';
        }
    }

    /* renamed from: com.uptodown.activities.t$b */
    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f18864a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f18865b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C1844t f18866c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(Context context, C1844t tVar, V2.d dVar) {
            super(2, dVar);
            this.f18865b = context;
            this.f18866c = tVar;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new b(this.f18865b, this.f18866c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f18864a == 0) {
                n.b(obj);
                u2.t a5 = u2.t.f21927u.a(this.f18865b);
                a5.a();
                a5.o();
                a5.i();
                this.f18866c.d(this.f18865b);
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((b) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    /* renamed from: com.uptodown.activities.t$c */
    static final class c extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f18867a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f18868b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f18869c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(Context context, int i4, V2.d dVar) {
            super(2, dVar);
            this.f18868b = context;
            this.f18869c = i4;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new c(this.f18868b, this.f18869c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f18867a == 0) {
                n.b(obj);
                u2.t a5 = u2.t.f21927u.a(this.f18868b);
                a5.a();
                a5.H(this.f18869c);
                a5.i();
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((c) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    /* renamed from: com.uptodown.activities.t$d */
    static final class d extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f18870a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f18871b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C1844t f18872c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(Context context, C1844t tVar, V2.d dVar) {
            super(2, dVar);
            this.f18871b = context;
            this.f18872c = tVar;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new d(this.f18871b, this.f18872c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f18870a == 0) {
                n.b(obj);
                u2.t a5 = u2.t.f21927u.a(this.f18871b);
                a5.a();
                ArrayList u02 = a5.u0();
                a5.i();
                this.f18872c.f18861a.setValue(new E.c(new a(u02)));
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((d) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    /* renamed from: com.uptodown.activities.t$e */
    static final class e extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f18873a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f18874b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C2034B f18875c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f18876d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(Context context, C2034B b5, String str, V2.d dVar) {
            super(2, dVar);
            this.f18874b = context;
            this.f18875c = b5;
            this.f18876d = str;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new e(this.f18874b, this.f18875c, this.f18876d, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f18873a == 0) {
                n.b(obj);
                u2.t a5 = u2.t.f21927u.a(this.f18874b);
                a5.a();
                C2034B b5 = this.f18875c;
                String string = this.f18874b.getString(R.string.file_deleted_notification, new Object[]{this.f18876d});
                m.d(string, "getString(...)");
                a5.y1(b5, "no_action", string);
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((e) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public C1844t() {
        t a5 = K.a(E.a.f21883a);
        this.f18861a = a5;
        this.f18862b = a5;
    }

    public final void b(Context context) {
        m.e(context, "context");
        C1001s0 unused = C0981i.d(ViewModelKt.getViewModelScope(this), Y.b(), (L) null, new b(context, this, (V2.d) null), 2, (Object) null);
    }

    public final void c(Context context, int i4) {
        m.e(context, "context");
        C1001s0 unused = C0981i.d(ViewModelKt.getViewModelScope(this), Y.b(), (L) null, new c(context, i4, (V2.d) null), 2, (Object) null);
    }

    public final void d(Context context) {
        m.e(context, "context");
        C1001s0 unused = C0981i.d(ViewModelKt.getViewModelScope(this), Y.b(), (L) null, new d(context, this, (V2.d) null), 2, (Object) null);
    }

    public final I e() {
        return this.f18862b;
    }

    public final void f(Context context, C2034B b5, String str) {
        m.e(context, "context");
        m.e(b5, "notification");
        m.e(str, "dateString");
        C1001s0 unused = C0981i.d(ViewModelKt.getViewModelScope(this), Y.b(), (L) null, new e(context, b5, str, (V2.d) null), 2, (Object) null);
    }
}
