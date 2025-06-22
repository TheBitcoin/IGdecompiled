package com.uptodown.activities;

import R2.n;
import R2.s;
import android.content.Context;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import d3.p;
import g2.C2051i;
import g2.L;
import g2.U;
import java.util.ArrayList;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import o3.C1001s0;
import o3.J;
import o3.Y;
import org.json.JSONArray;
import org.json.JSONObject;
import r3.I;
import r3.K;
import r3.t;
import u2.E;

public final class Q extends ViewModel {

    /* renamed from: f  reason: collision with root package name */
    public static final b f18237f = new b((C2103g) null);
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final t f18238a;

    /* renamed from: b  reason: collision with root package name */
    private final I f18239b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final t f18240c;

    /* renamed from: d  reason: collision with root package name */
    private final I f18241d;

    /* renamed from: e  reason: collision with root package name */
    private final t f18242e = K.a((Object) null);

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final ArrayList f18243a;

        /* renamed from: b  reason: collision with root package name */
        private final ArrayList f18244b;

        public a(ArrayList arrayList, ArrayList arrayList2) {
            m.e(arrayList, "avatars");
            m.e(arrayList2, "turboAvatars");
            this.f18243a = arrayList;
            this.f18244b = arrayList2;
        }

        public final ArrayList a() {
            return this.f18243a;
        }

        public final ArrayList b() {
            return this.f18244b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return m.a(this.f18243a, aVar.f18243a) && m.a(this.f18244b, aVar.f18244b);
        }

        public int hashCode() {
            return (this.f18243a.hashCode() * 31) + this.f18244b.hashCode();
        }

        public String toString() {
            return "AvatarsData(avatars=" + this.f18243a + ", turboAvatars=" + this.f18244b + ')';
        }
    }

    public static final class b {
        public /* synthetic */ b(C2103g gVar) {
            this();
        }

        private b() {
        }
    }

    static final class c extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f18245a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f18246b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ArrayList f18247c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ArrayList f18248d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Q f18249e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(Context context, ArrayList arrayList, ArrayList arrayList2, Q q4, V2.d dVar) {
            super(2, dVar);
            this.f18246b = context;
            this.f18247c = arrayList;
            this.f18248d = arrayList2;
            this.f18249e = q4;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new c(this.f18246b, this.f18247c, this.f18248d, this.f18249e, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f18245a == 0) {
                n.b(obj);
                L s02 = new u2.L(this.f18246b).s0();
                if (!s02.b() && s02.e() != null) {
                    JSONObject e5 = s02.e();
                    m.b(e5);
                    JSONObject optJSONObject = e5.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
                    if (optJSONObject != null) {
                        JSONArray optJSONArray = optJSONObject.optJSONArray("basic");
                        if (optJSONArray != null) {
                            int length = optJSONArray.length();
                            for (int i4 = 0; i4 < length; i4++) {
                                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i4);
                                C2051i.a aVar = C2051i.f20680f;
                                m.b(optJSONObject2);
                                this.f18247c.add(aVar.a(optJSONObject2));
                            }
                        }
                        JSONArray optJSONArray2 = optJSONObject.optJSONArray("turbo");
                        if (optJSONArray2 != null) {
                            int length2 = optJSONArray2.length();
                            for (int i5 = 0; i5 < length2; i5++) {
                                JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i5);
                                C2051i.a aVar2 = C2051i.f20680f;
                                m.b(optJSONObject3);
                                this.f18248d.add(aVar2.a(optJSONObject3));
                            }
                        }
                    }
                }
                this.f18249e.f18238a.setValue(new E.c(new a(this.f18247c, this.f18248d)));
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((c) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class d extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f18250a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Q f18251b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f18252c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ C2051i f18253d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(Q q4, Context context, C2051i iVar, V2.d dVar) {
            super(2, dVar);
            this.f18251b = q4;
            this.f18252c = context;
            this.f18253d = iVar;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new d(this.f18251b, this.f18252c, this.f18253d, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f18250a == 0) {
                n.b(obj);
                this.f18251b.f18240c.setValue(kotlin.coroutines.jvm.internal.b.a(false));
                L e12 = new u2.L(this.f18252c).e1(this.f18253d.d());
                if (!e12.b() && e12.e() != null) {
                    JSONObject e5 = e12.e();
                    m.b(e5);
                    if (e5.optInt("success") == 1) {
                        U u4 = (U) this.f18251b.f().getValue();
                        if (u4 != null) {
                            u4.q(this.f18253d.e());
                        }
                        U u5 = (U) this.f18251b.f().getValue();
                        if (u5 != null) {
                            u5.p(this.f18252c);
                        }
                        this.f18251b.f18240c.setValue(kotlin.coroutines.jvm.internal.b.a(true));
                    } else {
                        this.f18251b.f18240c.setValue(kotlin.coroutines.jvm.internal.b.a(false));
                    }
                }
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((d) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public Q() {
        t a5 = K.a(E.a.f21883a);
        this.f18238a = a5;
        this.f18239b = a5;
        t a6 = K.a(Boolean.FALSE);
        this.f18240c = a6;
        this.f18241d = a6;
    }

    public final void c(Context context) {
        m.e(context, "context");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        J viewModelScope = ViewModelKt.getViewModelScope(this);
        J j4 = viewModelScope;
        C1001s0 unused = C0981i.d(j4, Y.b(), (o3.L) null, new c(context, arrayList, arrayList2, this, (V2.d) null), 2, (Object) null);
    }

    public final I d() {
        return this.f18239b;
    }

    public final I e() {
        return this.f18241d;
    }

    public final t f() {
        return this.f18242e;
    }

    public final void g(Context context, C2051i iVar) {
        m.e(context, "context");
        m.e(iVar, "avatar");
        C1001s0 unused = C0981i.d(ViewModelKt.getViewModelScope(this), Y.b(), (o3.L) null, new d(this, context, iVar, (V2.d) null), 2, (Object) null);
    }
}
