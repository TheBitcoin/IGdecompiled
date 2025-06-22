package com.uptodown.activities;

import R2.n;
import R2.s;
import V2.d;
import android.content.Context;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import b2.C1637i;
import com.uptodown.UptodownApp;
import d3.p;
import f2.y;
import g2.C2048f;
import g2.C2050h;
import java.io.File;
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

/* renamed from: com.uptodown.activities.u  reason: case insensitive filesystem */
public final class C1845u extends ViewModel {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final t f18877a;

    /* renamed from: b  reason: collision with root package name */
    private final I f18878b;

    /* renamed from: c  reason: collision with root package name */
    private final t f18879c = K.a((Object) null);

    /* renamed from: d  reason: collision with root package name */
    private final t f18880d = K.a((Object) null);

    /* renamed from: e  reason: collision with root package name */
    private boolean f18881e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f18882f;

    /* renamed from: g  reason: collision with root package name */
    private int f18883g;

    /* renamed from: h  reason: collision with root package name */
    private int f18884h;

    /* renamed from: com.uptodown.activities.u$a */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final C2048f f18885a;

        /* renamed from: b  reason: collision with root package name */
        private final C2050h f18886b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f18887c;

        public a(C2048f fVar, C2050h hVar, boolean z4) {
            m.e(hVar, "appInfo");
            this.f18885a = fVar;
            this.f18886b = hVar;
            this.f18887c = z4;
        }

        public final C2048f a() {
            return this.f18885a;
        }

        public final C2050h b() {
            return this.f18886b;
        }

        public final boolean c() {
            return this.f18887c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return m.a(this.f18885a, aVar.f18885a) && m.a(this.f18886b, aVar.f18886b) && this.f18887c == aVar.f18887c;
        }

        public int hashCode() {
            C2048f fVar = this.f18885a;
            return ((((fVar == null ? 0 : fVar.hashCode()) * 31) + this.f18886b.hashCode()) * 31) + androidx.privacysandbox.ads.adservices.adid.a.a(this.f18887c);
        }

        public String toString() {
            return "OldVersionsData(app=" + this.f18885a + ", appInfo=" + this.f18886b + ", isOldVersionsAvailable=" + this.f18887c + ')';
        }
    }

    /* renamed from: com.uptodown.activities.u$b */
    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f18888a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C1845u f18889b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f18890c;

        /* renamed from: com.uptodown.activities.u$b$a */
        public static final class a implements y {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ C1845u f18891a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2048f f18892b;

            a(C1845u uVar, C2048f fVar) {
                this.f18891a = uVar;
                this.f18892b = fVar;
            }

            public void a(ArrayList arrayList) {
                m.e(arrayList, "oldVersions");
                Object value = this.f18891a.d().getValue();
                m.b(value);
                ((C2050h) value).P0(arrayList);
                t a5 = this.f18891a.f18877a;
                C2048f fVar = this.f18892b;
                Object value2 = this.f18891a.d().getValue();
                m.b(value2);
                a5.setValue(new E.c(new a(fVar, (C2050h) value2, true)));
            }

            public void b() {
                t a5 = this.f18891a.f18877a;
                C2048f fVar = this.f18892b;
                Object value = this.f18891a.d().getValue();
                m.b(value);
                a5.setValue(new E.c(new a(fVar, (C2050h) value, false)));
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(C1845u uVar, Context context, d dVar) {
            super(2, dVar);
            this.f18889b = uVar;
            this.f18890c = context;
        }

        public final d create(Object obj, d dVar) {
            return new b(this.f18889b, this.f18890c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            String str;
            W2.b.c();
            if (this.f18888a == 0) {
                n.b(obj);
                if (this.f18889b.g()) {
                    this.f18889b.f18877a.setValue(E.a.f21883a);
                }
                u2.m mVar = new u2.m();
                Context context = this.f18890c;
                C2050h hVar = (C2050h) this.f18889b.d().getValue();
                if (hVar != null) {
                    str = hVar.Q();
                } else {
                    str = null;
                }
                C2048f A4 = mVar.A(context, str);
                J viewModelScope = ViewModelKt.getViewModelScope(this.f18889b);
                Context context2 = this.f18890c;
                Object value = this.f18889b.d().getValue();
                m.b(value);
                new C1637i(viewModelScope, context2, (C2050h) value, new a(this.f18889b, A4), this.f18889b.h());
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, d dVar) {
            return ((b) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    /* renamed from: com.uptodown.activities.u$c */
    static final class c extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f18893a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C1845u f18894b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f18895c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Context f18896d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(C1845u uVar, String str, Context context, d dVar) {
            super(2, dVar);
            this.f18894b = uVar;
            this.f18895c = str;
            this.f18896d = context;
        }

        public final d create(Object obj, d dVar) {
            return new c(this.f18894b, this.f18895c, this.f18896d, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            String d5;
            W2.b.c();
            if (this.f18893a == 0) {
                n.b(obj);
                Object value = this.f18894b.d().getValue();
                m.b(value);
                if (((C2050h) value).Q() != null) {
                    Object value2 = this.f18894b.d().getValue();
                    m.b(value2);
                    if (m3.m.p(((C2050h) value2).Q(), this.f18895c, true) && (d5 = com.uptodown.activities.preferences.a.f18818a.d(this.f18896d)) != null) {
                        File file = new File(d5);
                        UptodownApp.a aVar = UptodownApp.f17422D;
                        Context context = this.f18896d;
                        Object value3 = this.f18894b.d().getValue();
                        m.b(value3);
                        aVar.X(file, context, ((C2050h) value3).M());
                    }
                }
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, d dVar) {
            return ((c) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public C1845u() {
        t a5 = K.a(E.a.f21883a);
        this.f18877a = a5;
        this.f18878b = a5;
    }

    public final void b(Context context) {
        m.e(context, "context");
        C1001s0 unused = C0981i.d(ViewModelKt.getViewModelScope(this), Y.b(), (L) null, new b(this, context, (d) null), 2, (Object) null);
    }

    public final t c() {
        return this.f18879c;
    }

    public final t d() {
        return this.f18880d;
    }

    public final I e() {
        return this.f18878b;
    }

    public final boolean f() {
        return this.f18882f;
    }

    public final boolean g() {
        return this.f18881e;
    }

    public final int h() {
        return this.f18883g;
    }

    public final int i() {
        return this.f18884h;
    }

    public final void j(Context context, String str) {
        m.e(context, "context");
        m.e(str, "packageName");
        C1001s0 unused = C0981i.d(ViewModelKt.getViewModelScope(this), Y.b(), (L) null, new c(this, str, context, (d) null), 2, (Object) null);
    }

    public final void k(boolean z4) {
        this.f18882f = z4;
    }

    public final void l(boolean z4) {
        this.f18881e = z4;
    }

    public final void m(int i4) {
        this.f18883g = i4;
    }

    public final void n(int i4) {
        this.f18884h = i4;
    }
}
