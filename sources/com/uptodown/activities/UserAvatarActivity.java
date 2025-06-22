package com.uptodown.activities;

import J1.C1415o5;
import J1.C1422p5;
import J1.C1429q5;
import J1.C1435r5;
import M1.K;
import N1.k;
import R2.k;
import R2.n;
import R2.s;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import c2.N0;
import com.uptodown.R;
import com.uptodown.activities.Q;
import d3.p;
import f2.C2015f;
import g2.C2051i;
import g2.U;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.D;
import kotlin.jvm.internal.m;
import o3.C1001s0;
import o3.J;
import o3.Y;
import r3.C1036f;
import r3.I;
import u2.E;
import u2.L;
import u2.q;
import w2.r;

public final class UserAvatarActivity extends C1826a {

    /* renamed from: J  reason: collision with root package name */
    private final R2.g f18514J = R2.h.a(new C1435r5(this));

    /* renamed from: K  reason: collision with root package name */
    private final R2.g f18515K = new ViewModelLazy(D.b(Q.class), new g(this), new f(this), new h((d3.a) null, this));
    /* access modifiers changed from: private */

    /* renamed from: L  reason: collision with root package name */
    public K f18516L;
    /* access modifiers changed from: private */

    /* renamed from: M  reason: collision with root package name */
    public K f18517M;

    /* renamed from: N  reason: collision with root package name */
    private int f18518N;
    /* access modifiers changed from: private */

    /* renamed from: O  reason: collision with root package name */
    public final AtomicBoolean f18519O = new AtomicBoolean(false);

    /* renamed from: P  reason: collision with root package name */
    private final c f18520P = new c(this);

    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f18521a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ UserAvatarActivity f18522b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(UserAvatarActivity userAvatarActivity, V2.d dVar) {
            super(2, dVar);
            this.f18522b = userAvatarActivity;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new a(this.f18522b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f18521a;
            if (i4 == 0) {
                n.b(obj);
                if (this.f18522b.f18519O.compareAndSet(false, true)) {
                    UserAvatarActivity userAvatarActivity = this.f18522b;
                    this.f18521a = 1;
                    if (userAvatarActivity.w3(this) == c5) {
                        return c5;
                    }
                }
                return s.f8222a;
            } else if (i4 == 1) {
                n.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            this.f18522b.f18519O.set(false);
            return s.f8222a;
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f18523a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ UserAvatarActivity f18524b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(UserAvatarActivity userAvatarActivity, V2.d dVar) {
            super(2, dVar);
            this.f18524b = userAvatarActivity;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new b(this.f18524b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f18523a == 0) {
                n.b(obj);
                this.f18524b.q3();
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((b) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public static final class c implements C2015f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ UserAvatarActivity f18525a;

        c(UserAvatarActivity userAvatarActivity) {
            this.f18525a = userAvatarActivity;
        }

        public void a(C2051i iVar, int i4) {
            m.e(iVar, "avatar");
            if (this.f18525a.f18517M != null) {
                K h32 = this.f18525a.f18517M;
                m.b(h32);
                if (h32.c() != -1) {
                    K h33 = this.f18525a.f18517M;
                    m.b(h33);
                    K h34 = this.f18525a.f18517M;
                    m.b(h34);
                    h33.notifyItemChanged(h34.c());
                    K h35 = this.f18525a.f18517M;
                    m.b(h35);
                    h35.d(-1);
                    K h36 = this.f18525a.f18517M;
                    m.b(h36);
                    h36.notifyItemChanged(i4);
                }
            }
            K f32 = this.f18525a.f18516L;
            m.b(f32);
            f32.d(i4);
            K f33 = this.f18525a.f18516L;
            m.b(f33);
            f33.notifyDataSetChanged();
        }

        public void b(C2051i iVar, int i4) {
            m.e(iVar, "avatar");
            if (this.f18525a.r3().f().getValue() != null) {
                Object value = this.f18525a.r3().f().getValue();
                m.b(value);
                if (((U) value).m(this.f18525a)) {
                    Object value2 = this.f18525a.r3().f().getValue();
                    m.b(value2);
                    if (((U) value2).n()) {
                        K f32 = this.f18525a.f18516L;
                        if (f32 == null || f32.c() != -1) {
                            K f33 = this.f18525a.f18516L;
                            m.b(f33);
                            f33.d(-1);
                            K f34 = this.f18525a.f18516L;
                            m.b(f34);
                            f34.notifyDataSetChanged();
                        }
                        K h32 = this.f18525a.f18517M;
                        if (h32 != null) {
                            K h33 = this.f18525a.f18517M;
                            m.b(h33);
                            h32.notifyItemChanged(h33.c());
                        }
                        K h34 = this.f18525a.f18517M;
                        if (h34 != null) {
                            h34.d(i4);
                        }
                        K h35 = this.f18525a.f18517M;
                        if (h35 != null) {
                            h35.notifyItemChanged(i4);
                            return;
                        }
                        return;
                    }
                }
            }
            q.r(new q(), this.f18525a, L.f21898b.c(this.f18525a), (String) null, 4, (Object) null);
        }
    }

    static final class d extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f18526a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ UserAvatarActivity f18527b;

        static final class a implements C1036f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ UserAvatarActivity f18528a;

            a(UserAvatarActivity userAvatarActivity) {
                this.f18528a = userAvatarActivity;
            }

            /* renamed from: b */
            public final Object emit(E e5, V2.d dVar) {
                if (e5 instanceof E.a) {
                    this.f18528a.o3().f9859d.setVisibility(0);
                } else if (e5 instanceof E.c) {
                    this.f18528a.o3().f9859d.setVisibility(8);
                    this.f18528a.o3().f9865j.setVisibility(0);
                    E.c cVar = (E.c) e5;
                    this.f18528a.n3(((Q.a) cVar.a()).a(), ((Q.a) cVar.a()).b());
                } else if (!(e5 instanceof E.b)) {
                    throw new k();
                }
                return s.f8222a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(UserAvatarActivity userAvatarActivity, V2.d dVar) {
            super(2, dVar);
            this.f18527b = userAvatarActivity;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new d(this.f18527b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f18526a;
            if (i4 == 0) {
                n.b(obj);
                I d5 = this.f18527b.r3().d();
                a aVar = new a(this.f18527b);
                this.f18526a = 1;
                if (d5.collect(aVar, this) == c5) {
                    return c5;
                }
            } else if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                n.b(obj);
            }
            throw new R2.d();
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((d) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class e extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f18529a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ UserAvatarActivity f18530b;

        static final class a implements C1036f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ UserAvatarActivity f18531a;

            a(UserAvatarActivity userAvatarActivity) {
                this.f18531a = userAvatarActivity;
            }

            public final Object b(boolean z4, V2.d dVar) {
                if (z4) {
                    UserAvatarActivity userAvatarActivity = this.f18531a;
                    String string = userAvatarActivity.getString(R.string.avatar_activity_changed_success);
                    m.d(string, "getString(...)");
                    userAvatarActivity.q0(string);
                    this.f18531a.setResult(10);
                    this.f18531a.finish();
                }
                return s.f8222a;
            }

            public /* bridge */ /* synthetic */ Object emit(Object obj, V2.d dVar) {
                return b(((Boolean) obj).booleanValue(), dVar);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(UserAvatarActivity userAvatarActivity, V2.d dVar) {
            super(2, dVar);
            this.f18530b = userAvatarActivity;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new e(this.f18530b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f18529a;
            if (i4 == 0) {
                n.b(obj);
                I e5 = this.f18530b.r3().e();
                a aVar = new a(this.f18530b);
                this.f18529a = 1;
                if (e5.collect(aVar, this) == c5) {
                    return c5;
                }
            } else if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                n.b(obj);
            }
            throw new R2.d();
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((e) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public static final class f extends kotlin.jvm.internal.n implements d3.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f18532a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(ComponentActivity componentActivity) {
            super(0);
            this.f18532a = componentActivity;
        }

        public final ViewModelProvider.Factory invoke() {
            return this.f18532a.getDefaultViewModelProviderFactory();
        }
    }

    public static final class g extends kotlin.jvm.internal.n implements d3.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f18533a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(ComponentActivity componentActivity) {
            super(0);
            this.f18533a = componentActivity;
        }

        public final ViewModelStore invoke() {
            return this.f18533a.getViewModelStore();
        }
    }

    public static final class h extends kotlin.jvm.internal.n implements d3.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d3.a f18534a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f18535b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(d3.a aVar, ComponentActivity componentActivity) {
            super(0);
            this.f18534a = aVar;
            this.f18535b = componentActivity;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
            r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0.invoke();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final androidx.lifecycle.viewmodel.CreationExtras invoke() {
            /*
                r1 = this;
                d3.a r0 = r1.f18534a
                if (r0 == 0) goto L_0x000e
                java.lang.Object r0 = r0.invoke()
                androidx.lifecycle.viewmodel.CreationExtras r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0
                if (r0 != 0) goto L_0x000d
                goto L_0x000e
            L_0x000d:
                return r0
            L_0x000e:
                androidx.activity.ComponentActivity r0 = r1.f18535b
                androidx.lifecycle.viewmodel.CreationExtras r0 = r0.getDefaultViewModelCreationExtras()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.UserAvatarActivity.h.invoke():androidx.lifecycle.viewmodel.CreationExtras");
        }
    }

    /* access modifiers changed from: private */
    public static final N0 m3(UserAvatarActivity userAvatarActivity) {
        return N0.c(userAvatarActivity.getLayoutInflater());
    }

    /* access modifiers changed from: private */
    public final void n3(ArrayList arrayList, ArrayList arrayList2) {
        ArrayList arrayList3;
        ArrayList arrayList4;
        boolean z4;
        int i4 = 0;
        if (this.f18516L == null) {
            arrayList3 = arrayList;
            this.f18516L = new K(arrayList3, this.f18520P, 0, this.f18518N, false, 16, (C2103g) null);
            o3().f9860e.setAdapter(this.f18516L);
            o3().f9863h.setVisibility(0);
        } else {
            arrayList3 = arrayList;
        }
        o3().f9858c.setVisibility(8);
        if (!arrayList2.isEmpty()) {
            o3().f9858c.setVisibility(0);
            U e5 = U.f20468m.e(this);
            if (e5 != null) {
                z4 = e5.n();
            } else {
                z4 = false;
            }
            if (this.f18517M == null) {
                arrayList4 = arrayList2;
                this.f18517M = new K(arrayList4, this.f18520P, 1, 0, z4, 8, (C2103g) null);
                o3().f9861f.setAdapter(this.f18517M);
                o3().f9861f.setVisibility(0);
            } else {
                arrayList4 = arrayList2;
            }
        } else {
            arrayList4 = arrayList2;
            o3().f9858c.setVisibility(8);
            o3().f9861f.setVisibility(8);
        }
        int size = arrayList3.size();
        int i5 = 0;
        int i6 = 0;
        while (true) {
            if (i6 >= size) {
                i5 = -1;
                break;
            }
            Object obj = arrayList3.get(i6);
            i6++;
            if (((C2051i) obj).b() == 1) {
                break;
            }
            i5++;
        }
        int size2 = arrayList4.size();
        int i7 = 0;
        while (true) {
            if (i7 >= size2) {
                i4 = -1;
                break;
            }
            Object obj2 = arrayList4.get(i7);
            i7++;
            if (((C2051i) obj2).b() == 1) {
                break;
            }
            i4++;
        }
        if (i5 > -1) {
            K k4 = this.f18516L;
            if (k4 != null) {
                k4.d(i5);
            }
            K k5 = this.f18516L;
            if (k5 != null) {
                k5.notifyItemChanged(i5);
            }
        } else if (i4 > -1) {
            K k6 = this.f18517M;
            if (k6 != null) {
                k6.d(i4);
            }
            K k7 = this.f18517M;
            if (k7 != null) {
                k7.notifyItemChanged(i4);
            }
        }
    }

    /* access modifiers changed from: private */
    public final N0 o3() {
        return (N0) this.f18514J.getValue();
    }

    private final int p3() {
        int i4 = getResources().getDisplayMetrics().widthPixels;
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.margin_m);
        int i5 = 6;
        while (true) {
            if ((i4 - ((i5 + 1) * dimensionPixelSize)) / i5 > getResources().getDimensionPixelSize(R.dimen.icon_size_l)) {
                break;
            }
            i5--;
            if (i5 <= 0) {
                i5 = 1;
                break;
            }
        }
        this.f18518N = (i4 - (dimensionPixelSize * (i5 + 1))) / i5;
        return i5;
    }

    /* access modifiers changed from: private */
    public final void q3() {
        r3().c(this);
    }

    /* access modifiers changed from: private */
    public final Q r3() {
        return (Q) this.f18515K.getValue();
    }

    private final void s3() {
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.core_vector_back);
        N0 o32 = o3();
        if (drawable != null) {
            o32.f9862g.setNavigationIcon(drawable);
            o32.f9862g.setNavigationContentDescription((CharSequence) getString(R.string.back));
        }
        o32.f9862g.setNavigationOnClickListener(new C1415o5(this));
        TextView textView = o32.f9866k;
        k.a aVar = N1.k.f7778g;
        textView.setTypeface(aVar.w());
        o32.f9865j.setTypeface(aVar.w());
        o32.f9864i.setTypeface(aVar.w());
        o32.f9863h.setTypeface(aVar.w());
        o32.f9867l.setTypeface(aVar.w());
        o32.f9864i.setOnClickListener(new C1422p5(this));
        if (r3().f().getValue() != null) {
            Object value = r3().f().getValue();
            m.b(value);
            if (((U) value).n()) {
                o32.f9857b.setOnClickListener(new C1429q5(this));
            }
        }
        o32.f9860e.setLayoutManager(new GridLayoutManager(this, p3()));
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator();
        defaultItemAnimator.setSupportsChangeAnimations(false);
        o32.f9860e.setItemAnimator(defaultItemAnimator);
        o32.f9861f.setLayoutManager(new LinearLayoutManager(this, 0, false));
        o32.f9861f.addItemDecoration(new r(this));
        o32.f9861f.setItemAnimator(defaultItemAnimator);
        C1001s0 unused = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), (V2.g) null, (o3.L) null, new b(this, (V2.d) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void t3(UserAvatarActivity userAvatarActivity, View view) {
        userAvatarActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void u3(UserAvatarActivity userAvatarActivity, View view) {
        C1001s0 unused = C0981i.d(LifecycleOwnerKt.getLifecycleScope(userAvatarActivity), (V2.g) null, (o3.L) null, new a(userAvatarActivity, (V2.d) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void v3(UserAvatarActivity userAvatarActivity, View view) {
        q.r(new q(), userAvatarActivity, L.f21898b.c(userAvatarActivity), (String) null, 4, (Object) null);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0062  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object w3(V2.d r7) {
        /*
            r6 = this;
            androidx.lifecycle.LifecycleCoroutineScope r0 = androidx.lifecycle.LifecycleOwnerKt.getLifecycleScope(r6)
            o3.E0 r1 = o3.Y.c()
            com.uptodown.activities.UserAvatarActivity$e r3 = new com.uptodown.activities.UserAvatarActivity$e
            r7 = 0
            r3.<init>(r6, r7)
            r4 = 2
            r5 = 0
            r2 = 0
            o3.C1001s0 unused = o3.C0981i.d(r0, r1, r2, r3, r4, r5)
            M1.K r0 = r6.f18516L
            r1 = -1
            if (r0 == 0) goto L_0x003b
            kotlin.jvm.internal.m.b(r0)
            int r0 = r0.c()
            if (r0 == r1) goto L_0x003b
            M1.K r7 = r6.f18516L
            kotlin.jvm.internal.m.b(r7)
            java.util.ArrayList r7 = r7.b()
            M1.K r0 = r6.f18516L
            kotlin.jvm.internal.m.b(r0)
            int r0 = r0.c()
            java.lang.Object r7 = r7.get(r0)
            g2.i r7 = (g2.C2051i) r7
            goto L_0x0060
        L_0x003b:
            M1.K r0 = r6.f18517M
            if (r0 == 0) goto L_0x0060
            kotlin.jvm.internal.m.b(r0)
            int r0 = r0.c()
            if (r0 == r1) goto L_0x0060
            M1.K r7 = r6.f18517M
            kotlin.jvm.internal.m.b(r7)
            java.util.ArrayList r7 = r7.b()
            M1.K r0 = r6.f18517M
            kotlin.jvm.internal.m.b(r0)
            int r0 = r0.c()
            java.lang.Object r7 = r7.get(r0)
            g2.i r7 = (g2.C2051i) r7
        L_0x0060:
            if (r7 == 0) goto L_0x0069
            com.uptodown.activities.Q r0 = r6.r3()
            r0.g(r6, r7)
        L_0x0069:
            R2.s r7 = R2.s.f8222a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.UserAvatarActivity.w3(V2.d):java.lang.Object");
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((View) o3().getRoot());
        r3().f().setValue(U.f20468m.e(this));
        s3();
        C1001s0 unused = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), Y.c(), (o3.L) null, new d(this, (V2.d) null), 2, (Object) null);
    }
}
