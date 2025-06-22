package com.uptodown.activities;

import J1.C1;
import J1.D1;
import J1.E1;
import J1.F1;
import J1.J1;
import J1.K1;
import J1.L1;
import N1.k;
import R2.n;
import R2.s;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import c2.C1664f0;
import c2.Q;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.uptodown.R;
import d2.Q1;
import d3.p;
import g2.C2037E;
import g2.C2050h;
import g2.C2053k;
import g2.C2060s;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import kotlin.jvm.internal.A;
import kotlin.jvm.internal.C;
import kotlin.jvm.internal.F;
import kotlin.jvm.internal.m;
import o3.C0977g;
import o3.C1001s0;
import o3.E0;
import o3.J;
import o3.Y;
import org.json.JSONArray;
import org.json.JSONObject;
import u2.L;
import u2.q;

public final class MoreInfo extends C1826a {

    /* renamed from: J  reason: collision with root package name */
    private final LifecycleCoroutineScope f17889J = LifecycleOwnerKt.getLifecycleScope(this);

    /* renamed from: K  reason: collision with root package name */
    private final R2.g f17890K = R2.h.a(new C1(this));
    /* access modifiers changed from: private */

    /* renamed from: L  reason: collision with root package name */
    public Q1 f17891L;
    /* access modifiers changed from: private */

    /* renamed from: M  reason: collision with root package name */
    public C2050h f17892M;
    /* access modifiers changed from: private */

    /* renamed from: N  reason: collision with root package name */
    public ArrayList f17893N;
    /* access modifiers changed from: private */

    /* renamed from: O  reason: collision with root package name */
    public ArrayList f17894O;
    /* access modifiers changed from: private */

    /* renamed from: P  reason: collision with root package name */
    public ArrayList f17895P;

    /* renamed from: Q  reason: collision with root package name */
    private final int f17896Q = 2;

    public final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final C2060s f17897a;

        public a(C2060s sVar) {
            this.f17897a = sVar;
        }

        public void run() {
            String str;
            if (MoreInfo.this.f17891L != null) {
                Q1 s32 = MoreInfo.this.f17891L;
                m.b(s32);
                C2060s sVar = this.f17897a;
                if (sVar != null) {
                    str = sVar.w();
                } else {
                    str = null;
                }
                s32.Z(str);
            }
        }
    }

    static final class b extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f17899a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ MoreInfo f17900b;

        static final class a extends kotlin.coroutines.jvm.internal.l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f17901a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ MoreInfo f17902b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(MoreInfo moreInfo, V2.d dVar) {
                super(2, dVar);
                this.f17902b = moreInfo;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new a(this.f17902b, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f17901a == 0) {
                    n.b(obj);
                    ArrayList l32 = this.f17902b.f17893N;
                    if (l32 != null && !l32.isEmpty()) {
                        this.f17902b.C3().f9973z.setVisibility(0);
                        TextView textView = this.f17902b.C3().f9914R;
                        k.a aVar = N1.k.f7778g;
                        textView.setTypeface(aVar.w());
                        this.f17902b.C3().f9915S.setTypeface(aVar.x());
                        ArrayList l33 = this.f17902b.f17893N;
                        m.b(l33);
                        Iterator it = l33.iterator();
                        m.d(it, "iterator(...)");
                        String str = null;
                        while (it.hasNext()) {
                            Object next = it.next();
                            m.d(next, "next(...)");
                            String str2 = (String) next;
                            if (str == null) {
                                str = str2;
                            } else {
                                str = str + ", " + str2;
                            }
                        }
                        this.f17902b.C3().f9915S.setText(str);
                    }
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(MoreInfo moreInfo, V2.d dVar) {
            super(2, dVar);
            this.f17900b = moreInfo;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new b(this.f17900b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            JSONArray optJSONArray;
            Object c5 = W2.b.c();
            int i4 = this.f17899a;
            if (i4 == 0) {
                n.b(obj);
                Context applicationContext = this.f17900b.getApplicationContext();
                m.d(applicationContext, "getApplicationContext(...)");
                L l4 = new L(applicationContext);
                C2050h m32 = this.f17900b.f17892M;
                m.b(m32);
                g2.L l5 = l4.l(m32.e());
                if (!l5.b() && l5.e() != null) {
                    JSONObject e5 = l5.e();
                    m.b(e5);
                    if (e5.optInt("success") == 1 && (optJSONArray = e5.optJSONArray(DataSchemeDataSource.SCHEME_DATA)) != null) {
                        this.f17900b.f17893N = new ArrayList();
                        int length = optJSONArray.length();
                        for (int i5 = 0; i5 < length; i5++) {
                            ArrayList l32 = this.f17900b.f17893N;
                            m.b(l32);
                            l32.add(optJSONArray.get(i5).toString());
                        }
                    }
                    E0 c6 = Y.c();
                    a aVar = new a(this.f17900b, (V2.d) null);
                    this.f17899a = 1;
                    if (C0977g.g(c6, aVar, this) == c5) {
                        return c5;
                    }
                }
            } else if (i4 == 1) {
                n.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return s.f8222a;
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((b) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class c extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a  reason: collision with root package name */
        Object f17903a;

        /* renamed from: b  reason: collision with root package name */
        Object f17904b;

        /* renamed from: c  reason: collision with root package name */
        /* synthetic */ Object f17905c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ MoreInfo f17906d;

        /* renamed from: e  reason: collision with root package name */
        int f17907e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(MoreInfo moreInfo, V2.d dVar) {
            super(dVar);
            this.f17906d = moreInfo;
        }

        public final Object invokeSuspend(Object obj) {
            this.f17905c = obj;
            this.f17907e |= Integer.MIN_VALUE;
            return this.f17906d.D3(this);
        }
    }

    static final class d extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f17908a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ MoreInfo f17909b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C f17910c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(MoreInfo moreInfo, C c5, V2.d dVar) {
            super(2, dVar);
            this.f17909b = moreInfo;
            this.f17910c = c5;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new d(this.f17909b, this.f17910c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            String d5;
            JSONArray optJSONArray;
            W2.b.c();
            if (this.f17908a == 0) {
                n.b(obj);
                Context applicationContext = this.f17909b.getApplicationContext();
                m.d(applicationContext, "getApplicationContext(...)");
                L l4 = new L(applicationContext);
                C2050h m32 = this.f17909b.f17892M;
                m.b(m32);
                g2.L o4 = l4.o(m32.e());
                if (!(o4.b() || (d5 = o4.d()) == null || d5.length() == 0)) {
                    String d6 = o4.d();
                    m.b(d6);
                    JSONObject jSONObject = new JSONObject(d6);
                    if (jSONObject.optInt("success") == 1 && (optJSONArray = jSONObject.optJSONArray(DataSchemeDataSource.SCHEME_DATA)) != null) {
                        this.f17910c.f20968a = new ArrayList();
                        int length = optJSONArray.length();
                        for (int i4 = 0; i4 < length; i4++) {
                            Object obj2 = this.f17910c.f20968a;
                            m.b(obj2);
                            ((ArrayList) obj2).add(optJSONArray.getString(i4));
                        }
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

    static final class e extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f17911a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C f17912b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ MoreInfo f17913c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(C c5, MoreInfo moreInfo, V2.d dVar) {
            super(2, dVar);
            this.f17912b = c5;
            this.f17913c = moreInfo;
        }

        /* access modifiers changed from: private */
        public static final void k(MoreInfo moreInfo, View view) {
            if (moreInfo.C3().f9963u.getVisibility() == 0) {
                moreInfo.C3().f9963u.setVisibility(8);
                moreInfo.C3().f9941j.setImageResource(R.drawable.vector_add);
                return;
            }
            moreInfo.C3().f9963u.setVisibility(0);
            moreInfo.C3().f9941j.setImageResource(R.drawable.vector_remove);
            moreInfo.C3().f9912P.post(new C1839n(moreInfo));
        }

        /* access modifiers changed from: private */
        public static final void l(MoreInfo moreInfo) {
            moreInfo.C3().f9912P.smoothScrollTo(0, moreInfo.C3().f9903G.getTop());
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new e(this.f17912b, this.f17913c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f17911a == 0) {
                n.b(obj);
                Collection collection = (Collection) this.f17912b.f20968a;
                if (collection == null || collection.isEmpty()) {
                    this.f17913c.C3().f9903G.setVisibility(8);
                } else {
                    this.f17913c.C3().f9903G.setVisibility(0);
                    TextView textView = this.f17913c.C3().f9938h0;
                    k.a aVar = N1.k.f7778g;
                    textView.setTypeface(aVar.w());
                    this.f17913c.C3().f9940i0.setTypeface(aVar.x());
                    TextView textView2 = this.f17913c.C3().f9940i0;
                    Object obj2 = this.f17912b.f20968a;
                    m.b(obj2);
                    textView2.setText(String.valueOf(((ArrayList) obj2).size()));
                    this.f17913c.C3().f9903G.setOnClickListener(new C1838m(this.f17913c));
                    MoreInfo moreInfo = this.f17913c;
                    moreInfo.K3((ArrayList) this.f17912b.f20968a, moreInfo.C3().f9963u);
                }
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((e) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class f extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a  reason: collision with root package name */
        Object f17914a;

        /* renamed from: b  reason: collision with root package name */
        Object f17915b;

        /* renamed from: c  reason: collision with root package name */
        /* synthetic */ Object f17916c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ MoreInfo f17917d;

        /* renamed from: e  reason: collision with root package name */
        int f17918e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(MoreInfo moreInfo, V2.d dVar) {
            super(dVar);
            this.f17917d = moreInfo;
        }

        public final Object invokeSuspend(Object obj) {
            this.f17916c = obj;
            this.f17918e |= Integer.MIN_VALUE;
            return this.f17917d.E3(this);
        }
    }

    static final class g extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f17919a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ MoreInfo f17920b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(MoreInfo moreInfo, V2.d dVar) {
            super(2, dVar);
            this.f17920b = moreInfo;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new g(this.f17920b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f17919a == 0) {
                n.b(obj);
                this.f17920b.C3().f9971y.setVisibility(0);
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((g) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class h extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f17921a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ MoreInfo f17922b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ A f17923c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(MoreInfo moreInfo, A a5, V2.d dVar) {
            super(2, dVar);
            this.f17922b = moreInfo;
            this.f17923c = a5;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new h(this.f17922b, this.f17923c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f17921a == 0) {
                n.b(obj);
                try {
                    Context applicationContext = this.f17922b.getApplicationContext();
                    m.d(applicationContext, "getApplicationContext(...)");
                    L l4 = new L(applicationContext);
                    C2050h m32 = this.f17922b.f17892M;
                    m.b(m32);
                    g2.L P4 = l4.P(m32.e());
                    if (!P4.b() && P4.e() != null) {
                        JSONObject e5 = P4.e();
                        m.b(e5);
                        if (!e5.isNull("success")) {
                            this.f17923c.f20966a = e5.optInt("success");
                        }
                        JSONObject optJSONObject = e5.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
                        if (this.f17923c.f20966a == 1 && optJSONObject != null) {
                            this.f17922b.f17894O = new ArrayList();
                            JSONArray optJSONArray = optJSONObject.optJSONArray("permissions_concern");
                            if (optJSONArray != null) {
                                int length = optJSONArray.length();
                                for (int i4 = 0; i4 < length; i4++) {
                                    C2037E e6 = new C2037E();
                                    JSONObject optJSONObject2 = optJSONArray.optJSONObject(i4);
                                    m.d(optJSONObject2, "optJSONObject(...)");
                                    e6.a(optJSONObject2);
                                    ArrayList o32 = this.f17922b.f17894O;
                                    m.b(o32);
                                    o32.add(e6);
                                }
                            }
                            this.f17922b.f17895P = new ArrayList();
                            JSONArray optJSONArray2 = optJSONObject.optJSONArray("permissions");
                            if (optJSONArray2 != null) {
                                int length2 = optJSONArray2.length();
                                for (int i5 = 0; i5 < length2; i5++) {
                                    C2037E e7 = new C2037E();
                                    JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i5);
                                    m.d(optJSONObject3, "optJSONObject(...)");
                                    e7.a(optJSONObject3);
                                    ArrayList q32 = this.f17922b.f17895P;
                                    m.b(q32);
                                    q32.add(e7);
                                }
                            }
                        }
                    }
                } catch (Exception e8) {
                    e8.printStackTrace();
                }
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((h) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class i extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f17924a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ A f17925b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ MoreInfo f17926c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(A a5, MoreInfo moreInfo, V2.d dVar) {
            super(2, dVar);
            this.f17925b = a5;
            this.f17926c = moreInfo;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new i(this.f17925b, this.f17926c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            int i4;
            W2.b.c();
            if (this.f17924a == 0) {
                n.b(obj);
                if (this.f17925b.f20966a == 1) {
                    this.f17926c.C3().f9907K.setVisibility(0);
                    ArrayList o32 = this.f17926c.f17894O;
                    if (o32 == null || o32.isEmpty()) {
                        this.f17926c.C3().f9907K.setVisibility(8);
                        i4 = 0;
                    } else {
                        MoreInfo moreInfo = this.f17926c;
                        moreInfo.Q3(moreInfo.f17894O, this.f17926c.C3().f9961t);
                        ArrayList o33 = this.f17926c.f17894O;
                        m.b(o33);
                        i4 = o33.size();
                    }
                    ArrayList q32 = this.f17926c.f17895P;
                    if (q32 != null && !q32.isEmpty()) {
                        MoreInfo moreInfo2 = this.f17926c;
                        moreInfo2.Q3(moreInfo2.f17895P, this.f17926c.C3().f9967w);
                        ArrayList q33 = this.f17926c.f17895P;
                        m.b(q33);
                        i4 += q33.size();
                    }
                    C2050h m32 = this.f17926c.f17892M;
                    if (m32 != null && m32.S() == 0) {
                        this.f17926c.C3().f9960s0.setText(String.valueOf(i4));
                    }
                } else {
                    this.f17926c.C3().f9907K.setVisibility(8);
                }
                this.f17926c.C3().f9971y.setVisibility(8);
                this.f17926c.C3().f9912P.setVisibility(0);
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((i) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class j extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f17927a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ MoreInfo f17928b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(MoreInfo moreInfo, V2.d dVar) {
            super(2, dVar);
            this.f17928b = moreInfo;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new j(this.f17928b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f17927a;
            if (i4 == 0) {
                n.b(obj);
                MoreInfo moreInfo = this.f17928b;
                this.f17927a = 1;
                if (moreInfo.E3(this) == c5) {
                    return c5;
                }
            } else if (i4 == 1) {
                n.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return s.f8222a;
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((j) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class k extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f17929a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ MoreInfo f17930b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(MoreInfo moreInfo, V2.d dVar) {
            super(2, dVar);
            this.f17930b = moreInfo;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new k(this.f17930b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f17929a;
            if (i4 == 0) {
                n.b(obj);
                MoreInfo moreInfo = this.f17930b;
                this.f17929a = 1;
                if (moreInfo.B3(this) == c5) {
                    return c5;
                }
            } else if (i4 == 1) {
                n.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return s.f8222a;
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((k) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class l extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f17931a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ MoreInfo f17932b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(MoreInfo moreInfo, V2.d dVar) {
            super(2, dVar);
            this.f17932b = moreInfo;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new l(this.f17932b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f17931a;
            if (i4 == 0) {
                n.b(obj);
                MoreInfo moreInfo = this.f17932b;
                this.f17931a = 1;
                if (moreInfo.D3(this) == c5) {
                    return c5;
                }
            } else if (i4 == 1) {
                n.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return s.f8222a;
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((l) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    private final String A3(String str) {
        String str2 = "";
        while (str.length() > 3) {
            F f4 = F.f20971a;
            String substring = str.substring(str.length() - 3);
            m.d(substring, "substring(...)");
            str2 = String.format(",%s%s", Arrays.copyOf(new Object[]{substring, str2}, 2));
            m.d(str2, "format(...)");
            str = str.substring(0, str.length() - 3);
            m.d(str, "substring(...)");
        }
        if (str.length() <= 0) {
            return str2;
        }
        return str + str2;
    }

    /* access modifiers changed from: private */
    public final Object B3(V2.d dVar) {
        Object g4 = C0977g.g(Y.b(), new b(this, (V2.d) null), dVar);
        if (g4 == W2.b.c()) {
            return g4;
        }
        return s.f8222a;
    }

    /* access modifiers changed from: private */
    public final Q C3() {
        return (Q) this.f17890K.getValue();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0073, code lost:
        if (o3.C0977g.g(r8, r6, r0) != r1) goto L_0x0076;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object D3(V2.d r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.uptodown.activities.MoreInfo.c
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.uptodown.activities.MoreInfo$c r0 = (com.uptodown.activities.MoreInfo.c) r0
            int r1 = r0.f17907e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f17907e = r1
            goto L_0x0018
        L_0x0013:
            com.uptodown.activities.MoreInfo$c r0 = new com.uptodown.activities.MoreInfo$c
            r0.<init>(r7, r8)
        L_0x0018:
            java.lang.Object r8 = r0.f17905c
            java.lang.Object r1 = W2.b.c()
            int r2 = r0.f17907e
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x0041
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            R2.n.b(r8)
            goto L_0x0076
        L_0x002d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x0035:
            java.lang.Object r2 = r0.f17904b
            kotlin.jvm.internal.C r2 = (kotlin.jvm.internal.C) r2
            java.lang.Object r4 = r0.f17903a
            com.uptodown.activities.MoreInfo r4 = (com.uptodown.activities.MoreInfo) r4
            R2.n.b(r8)
            goto L_0x0060
        L_0x0041:
            R2.n.b(r8)
            kotlin.jvm.internal.C r2 = new kotlin.jvm.internal.C
            r2.<init>()
            o3.G r8 = o3.Y.b()
            com.uptodown.activities.MoreInfo$d r6 = new com.uptodown.activities.MoreInfo$d
            r6.<init>(r7, r2, r5)
            r0.f17903a = r7
            r0.f17904b = r2
            r0.f17907e = r4
            java.lang.Object r8 = o3.C0977g.g(r8, r6, r0)
            if (r8 != r1) goto L_0x005f
            goto L_0x0075
        L_0x005f:
            r4 = r7
        L_0x0060:
            o3.E0 r8 = o3.Y.c()
            com.uptodown.activities.MoreInfo$e r6 = new com.uptodown.activities.MoreInfo$e
            r6.<init>(r2, r4, r5)
            r0.f17903a = r5
            r0.f17904b = r5
            r0.f17907e = r3
            java.lang.Object r8 = o3.C0977g.g(r8, r6, r0)
            if (r8 != r1) goto L_0x0076
        L_0x0075:
            return r1
        L_0x0076:
            R2.s r8 = R2.s.f8222a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.MoreInfo.D3(V2.d):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x009b, code lost:
        if (o3.C0977g.g(r9, r5, r0) != r1) goto L_0x009e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object E3(V2.d r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof com.uptodown.activities.MoreInfo.f
            if (r0 == 0) goto L_0x0013
            r0 = r9
            com.uptodown.activities.MoreInfo$f r0 = (com.uptodown.activities.MoreInfo.f) r0
            int r1 = r0.f17918e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f17918e = r1
            goto L_0x0018
        L_0x0013:
            com.uptodown.activities.MoreInfo$f r0 = new com.uptodown.activities.MoreInfo$f
            r0.<init>(r8, r9)
        L_0x0018:
            java.lang.Object r9 = r0.f17916c
            java.lang.Object r1 = W2.b.c()
            int r2 = r0.f17918e
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L_0x0051
            if (r2 == r5) goto L_0x0045
            if (r2 == r4) goto L_0x0039
            if (r2 != r3) goto L_0x0031
            R2.n.b(r9)
            goto L_0x009e
        L_0x0031:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x0039:
            java.lang.Object r2 = r0.f17915b
            kotlin.jvm.internal.A r2 = (kotlin.jvm.internal.A) r2
            java.lang.Object r4 = r0.f17914a
            com.uptodown.activities.MoreInfo r4 = (com.uptodown.activities.MoreInfo) r4
            R2.n.b(r9)
            goto L_0x0088
        L_0x0045:
            java.lang.Object r2 = r0.f17915b
            kotlin.jvm.internal.A r2 = (kotlin.jvm.internal.A) r2
            java.lang.Object r5 = r0.f17914a
            com.uptodown.activities.MoreInfo r5 = (com.uptodown.activities.MoreInfo) r5
            R2.n.b(r9)
            goto L_0x0071
        L_0x0051:
            R2.n.b(r9)
            kotlin.jvm.internal.A r9 = new kotlin.jvm.internal.A
            r9.<init>()
            o3.E0 r2 = o3.Y.c()
            com.uptodown.activities.MoreInfo$g r7 = new com.uptodown.activities.MoreInfo$g
            r7.<init>(r8, r6)
            r0.f17914a = r8
            r0.f17915b = r9
            r0.f17918e = r5
            java.lang.Object r2 = o3.C0977g.g(r2, r7, r0)
            if (r2 != r1) goto L_0x006f
            goto L_0x009d
        L_0x006f:
            r5 = r8
            r2 = r9
        L_0x0071:
            o3.G r9 = o3.Y.b()
            com.uptodown.activities.MoreInfo$h r7 = new com.uptodown.activities.MoreInfo$h
            r7.<init>(r5, r2, r6)
            r0.f17914a = r5
            r0.f17915b = r2
            r0.f17918e = r4
            java.lang.Object r9 = o3.C0977g.g(r9, r7, r0)
            if (r9 != r1) goto L_0x0087
            goto L_0x009d
        L_0x0087:
            r4 = r5
        L_0x0088:
            o3.E0 r9 = o3.Y.c()
            com.uptodown.activities.MoreInfo$i r5 = new com.uptodown.activities.MoreInfo$i
            r5.<init>(r2, r4, r6)
            r0.f17914a = r6
            r0.f17915b = r6
            r0.f17918e = r3
            java.lang.Object r9 = o3.C0977g.g(r9, r5, r0)
            if (r9 != r1) goto L_0x009e
        L_0x009d:
            return r1
        L_0x009e:
            R2.s r9 = R2.s.f8222a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.MoreInfo.E3(V2.d):java.lang.Object");
    }

    private final void F3(TextView textView, View view) {
        textView.getViewTreeObserver().addOnGlobalLayoutListener(new K1(textView, this, view));
    }

    /* access modifiers changed from: private */
    public static final void G3(TextView textView, MoreInfo moreInfo, View view) {
        if (w2.s.a(textView)) {
            textView.setOnClickListener(new L1(moreInfo, textView, view));
        }
    }

    /* access modifiers changed from: private */
    public static final void H3(MoreInfo moreInfo, TextView textView, View view, View view2) {
        moreInfo.z3(textView, view);
    }

    /* access modifiers changed from: private */
    public static final void I3(MoreInfo moreInfo, View view) {
        moreInfo.getOnBackPressedDispatcher().onBackPressed();
    }

    /* access modifiers changed from: private */
    public static final void J3(View view) {
    }

    /* access modifiers changed from: private */
    public final void K3(ArrayList arrayList, LinearLayout linearLayout) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        m.b(arrayList);
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            C1664f0 c5 = C1664f0.c(LayoutInflater.from(getApplicationContext()));
            m.d(c5, "inflate(...)");
            c5.getRoot().setLayoutParams(layoutParams);
            c5.f10408b.setTypeface(N1.k.f7778g.x());
            TextView textView = c5.f10408b;
            Object obj = arrayList.get(i4);
            m.d(obj, "get(...)");
            String upperCase = ((String) obj).toUpperCase(Locale.ROOT);
            m.d(upperCase, "toUpperCase(...)");
            textView.setText(upperCase);
            m.b(linearLayout);
            linearLayout.addView(c5.getRoot());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:108:0x04f6 A[Catch:{ Exception -> 0x0052, all -> 0x004f }] */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0507 A[Catch:{ Exception -> 0x0052, all -> 0x004f }] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0069 A[Catch:{ Exception -> 0x0052, all -> 0x004f }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00b4 A[Catch:{ Exception -> 0x0052, all -> 0x004f }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0145 A[Catch:{ Exception -> 0x0052, all -> 0x004f }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x020c A[Catch:{ Exception -> 0x0052, all -> 0x004f }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0220 A[Catch:{ Exception -> 0x0052, all -> 0x004f }] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0268 A[Catch:{ Exception -> 0x0052, all -> 0x004f }] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x02c9 A[Catch:{ Exception -> 0x0052, all -> 0x004f }] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0374 A[Catch:{ Exception -> 0x0052, all -> 0x004f }] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x03cc A[Catch:{ Exception -> 0x0052, all -> 0x004f }] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0477 A[Catch:{ Exception -> 0x0052, all -> 0x004f }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void L3() {
        /*
            r7 = this;
            r0 = 0
            r1 = 8
            c2.Q r2 = r7.C3()     // Catch:{ Exception -> 0x0052 }
            android.widget.TextView r2 = r2.f9950n0     // Catch:{ Exception -> 0x0052 }
            N1.k$a r3 = N1.k.f7778g     // Catch:{ Exception -> 0x0052 }
            android.graphics.Typeface r4 = r3.w()     // Catch:{ Exception -> 0x0052 }
            r2.setTypeface(r4)     // Catch:{ Exception -> 0x0052 }
            g2.h r2 = r7.f17892M     // Catch:{ Exception -> 0x0052 }
            kotlin.jvm.internal.m.b(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = r2.Q()     // Catch:{ Exception -> 0x0052 }
            if (r2 == 0) goto L_0x0055
            int r2 = r2.length()     // Catch:{ Exception -> 0x0052 }
            if (r2 != 0) goto L_0x0024
            goto L_0x0055
        L_0x0024:
            g2.h r2 = r7.f17892M     // Catch:{ Exception -> 0x0052 }
            kotlin.jvm.internal.m.b(r2)     // Catch:{ Exception -> 0x0052 }
            boolean r2 = r2.J0()     // Catch:{ Exception -> 0x0052 }
            if (r2 != 0) goto L_0x0055
            c2.Q r2 = r7.C3()     // Catch:{ Exception -> 0x0052 }
            android.widget.TextView r2 = r2.f9952o0     // Catch:{ Exception -> 0x0052 }
            android.graphics.Typeface r4 = r3.x()     // Catch:{ Exception -> 0x0052 }
            r2.setTypeface(r4)     // Catch:{ Exception -> 0x0052 }
            c2.Q r2 = r7.C3()     // Catch:{ Exception -> 0x0052 }
            android.widget.TextView r2 = r2.f9952o0     // Catch:{ Exception -> 0x0052 }
            g2.h r4 = r7.f17892M     // Catch:{ Exception -> 0x0052 }
            kotlin.jvm.internal.m.b(r4)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r4 = r4.Q()     // Catch:{ Exception -> 0x0052 }
            r2.setText(r4)     // Catch:{ Exception -> 0x0052 }
            goto L_0x005e
        L_0x004f:
            r0 = move-exception
            goto L_0x054d
        L_0x0052:
            r2 = move-exception
            goto L_0x0521
        L_0x0055:
            c2.Q r2 = r7.C3()     // Catch:{ Exception -> 0x0052 }
            android.widget.RelativeLayout r2 = r2.f9905I     // Catch:{ Exception -> 0x0052 }
            r2.setVisibility(r1)     // Catch:{ Exception -> 0x0052 }
        L_0x005e:
            g2.h r2 = r7.f17892M     // Catch:{ Exception -> 0x0052 }
            kotlin.jvm.internal.m.b(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = r2.w0()     // Catch:{ Exception -> 0x0052 }
            if (r2 == 0) goto L_0x009d
            int r2 = r2.length()     // Catch:{ Exception -> 0x0052 }
            if (r2 != 0) goto L_0x0070
            goto L_0x009d
        L_0x0070:
            c2.Q r2 = r7.C3()     // Catch:{ Exception -> 0x0052 }
            android.widget.TextView r2 = r2.f9974z0     // Catch:{ Exception -> 0x0052 }
            android.graphics.Typeface r4 = r3.w()     // Catch:{ Exception -> 0x0052 }
            r2.setTypeface(r4)     // Catch:{ Exception -> 0x0052 }
            c2.Q r2 = r7.C3()     // Catch:{ Exception -> 0x0052 }
            android.widget.TextView r2 = r2.f9895A0     // Catch:{ Exception -> 0x0052 }
            android.graphics.Typeface r4 = r3.x()     // Catch:{ Exception -> 0x0052 }
            r2.setTypeface(r4)     // Catch:{ Exception -> 0x0052 }
            c2.Q r2 = r7.C3()     // Catch:{ Exception -> 0x0052 }
            android.widget.TextView r2 = r2.f9895A0     // Catch:{ Exception -> 0x0052 }
            g2.h r4 = r7.f17892M     // Catch:{ Exception -> 0x0052 }
            kotlin.jvm.internal.m.b(r4)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r4 = r4.w0()     // Catch:{ Exception -> 0x0052 }
            r2.setText(r4)     // Catch:{ Exception -> 0x0052 }
            goto L_0x00a6
        L_0x009d:
            c2.Q r2 = r7.C3()     // Catch:{ Exception -> 0x0052 }
            android.widget.RelativeLayout r2 = r2.f9911O     // Catch:{ Exception -> 0x0052 }
            r2.setVisibility(r1)     // Catch:{ Exception -> 0x0052 }
        L_0x00a6:
            g2.h r2 = r7.f17892M     // Catch:{ Exception -> 0x0052 }
            kotlin.jvm.internal.m.b(r2)     // Catch:{ Exception -> 0x0052 }
            g2.k r2 = r2.h()     // Catch:{ Exception -> 0x0052 }
            r4 = 2131100313(0x7f060299, float:1.7813004E38)
            if (r2 == 0) goto L_0x0131
            g2.h r2 = r7.f17892M     // Catch:{ Exception -> 0x0052 }
            kotlin.jvm.internal.m.b(r2)     // Catch:{ Exception -> 0x0052 }
            g2.k r2 = r2.h()     // Catch:{ Exception -> 0x0052 }
            if (r2 == 0) goto L_0x00c4
            java.lang.String r2 = r2.d()     // Catch:{ Exception -> 0x0052 }
            goto L_0x00c5
        L_0x00c4:
            r2 = 0
        L_0x00c5:
            if (r2 == 0) goto L_0x0131
            int r2 = r2.length()     // Catch:{ Exception -> 0x0052 }
            if (r2 != 0) goto L_0x00ce
            goto L_0x0131
        L_0x00ce:
            c2.Q r2 = r7.C3()     // Catch:{ Exception -> 0x0052 }
            android.widget.TextView r2 = r2.f9921Y     // Catch:{ Exception -> 0x0052 }
            android.graphics.Typeface r5 = r3.w()     // Catch:{ Exception -> 0x0052 }
            r2.setTypeface(r5)     // Catch:{ Exception -> 0x0052 }
            c2.Q r2 = r7.C3()     // Catch:{ Exception -> 0x0052 }
            android.widget.TextView r2 = r2.f9922Z     // Catch:{ Exception -> 0x0052 }
            android.graphics.Typeface r5 = r3.x()     // Catch:{ Exception -> 0x0052 }
            r2.setTypeface(r5)     // Catch:{ Exception -> 0x0052 }
            c2.Q r2 = r7.C3()     // Catch:{ Exception -> 0x0052 }
            android.widget.TextView r2 = r2.f9922Z     // Catch:{ Exception -> 0x0052 }
            g2.h r5 = r7.f17892M     // Catch:{ Exception -> 0x0052 }
            kotlin.jvm.internal.m.b(r5)     // Catch:{ Exception -> 0x0052 }
            g2.k r5 = r5.h()     // Catch:{ Exception -> 0x0052 }
            kotlin.jvm.internal.m.b(r5)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r5 = r5.d()     // Catch:{ Exception -> 0x0052 }
            r2.setText(r5)     // Catch:{ Exception -> 0x0052 }
            c2.Q r2 = r7.C3()     // Catch:{ Exception -> 0x0052 }
            android.widget.TextView r2 = r2.f9922Z     // Catch:{ Exception -> 0x0052 }
            int r5 = androidx.core.content.ContextCompat.getColor(r7, r4)     // Catch:{ Exception -> 0x0052 }
            r2.setTextColor(r5)     // Catch:{ Exception -> 0x0052 }
            c2.Q r2 = r7.C3()     // Catch:{ Exception -> 0x0052 }
            android.widget.TextView r2 = r2.f9922Z     // Catch:{ Exception -> 0x0052 }
            c2.Q r5 = r7.C3()     // Catch:{ Exception -> 0x0052 }
            android.widget.TextView r5 = r5.f9922Z     // Catch:{ Exception -> 0x0052 }
            int r5 = r5.getPaintFlags()     // Catch:{ Exception -> 0x0052 }
            r5 = r5 | r1
            r2.setPaintFlags(r5)     // Catch:{ Exception -> 0x0052 }
            c2.Q r2 = r7.C3()     // Catch:{ Exception -> 0x0052 }
            android.widget.TextView r2 = r2.f9922Z     // Catch:{ Exception -> 0x0052 }
            J1.G1 r5 = new J1.G1     // Catch:{ Exception -> 0x0052 }
            r5.<init>(r7)     // Catch:{ Exception -> 0x0052 }
            r2.setOnClickListener(r5)     // Catch:{ Exception -> 0x0052 }
            goto L_0x013a
        L_0x0131:
            c2.Q r2 = r7.C3()     // Catch:{ Exception -> 0x0052 }
            android.widget.RelativeLayout r2 = r2.f9898C     // Catch:{ Exception -> 0x0052 }
            r2.setVisibility(r1)     // Catch:{ Exception -> 0x0052 }
        L_0x013a:
            g2.h r2 = r7.f17892M     // Catch:{ Exception -> 0x0052 }
            kotlin.jvm.internal.m.b(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = r2.g()     // Catch:{ Exception -> 0x0052 }
            if (r2 == 0) goto L_0x01ba
            int r2 = r2.length()     // Catch:{ Exception -> 0x0052 }
            if (r2 != 0) goto L_0x014c
            goto L_0x01ba
        L_0x014c:
            c2.Q r2 = r7.C3()     // Catch:{ Exception -> 0x0052 }
            android.widget.TextView r2 = r2.f9919W     // Catch:{ Exception -> 0x0052 }
            android.graphics.Typeface r5 = r3.w()     // Catch:{ Exception -> 0x0052 }
            r2.setTypeface(r5)     // Catch:{ Exception -> 0x0052 }
            c2.Q r2 = r7.C3()     // Catch:{ Exception -> 0x0052 }
            android.widget.TextView r2 = r2.f9920X     // Catch:{ Exception -> 0x0052 }
            android.graphics.Typeface r5 = r3.x()     // Catch:{ Exception -> 0x0052 }
            r2.setTypeface(r5)     // Catch:{ Exception -> 0x0052 }
            c2.Q r2 = r7.C3()     // Catch:{ Exception -> 0x0052 }
            android.widget.TextView r2 = r2.f9920X     // Catch:{ Exception -> 0x0052 }
            g2.h r5 = r7.f17892M     // Catch:{ Exception -> 0x0052 }
            kotlin.jvm.internal.m.b(r5)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r5 = r5.g()     // Catch:{ Exception -> 0x0052 }
            r2.setText(r5)     // Catch:{ Exception -> 0x0052 }
            g2.h r2 = r7.f17892M     // Catch:{ Exception -> 0x0052 }
            kotlin.jvm.internal.m.b(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = r2.z0()     // Catch:{ Exception -> 0x0052 }
            if (r2 == 0) goto L_0x01c3
            int r2 = r2.length()     // Catch:{ Exception -> 0x0052 }
            if (r2 != 0) goto L_0x018a
            goto L_0x01c3
        L_0x018a:
            c2.Q r2 = r7.C3()     // Catch:{ Exception -> 0x0052 }
            android.widget.TextView r2 = r2.f9920X     // Catch:{ Exception -> 0x0052 }
            int r4 = androidx.core.content.ContextCompat.getColor(r7, r4)     // Catch:{ Exception -> 0x0052 }
            r2.setTextColor(r4)     // Catch:{ Exception -> 0x0052 }
            c2.Q r2 = r7.C3()     // Catch:{ Exception -> 0x0052 }
            android.widget.TextView r2 = r2.f9920X     // Catch:{ Exception -> 0x0052 }
            c2.Q r4 = r7.C3()     // Catch:{ Exception -> 0x0052 }
            android.widget.TextView r4 = r4.f9920X     // Catch:{ Exception -> 0x0052 }
            int r4 = r4.getPaintFlags()     // Catch:{ Exception -> 0x0052 }
            r4 = r4 | r1
            r2.setPaintFlags(r4)     // Catch:{ Exception -> 0x0052 }
            c2.Q r2 = r7.C3()     // Catch:{ Exception -> 0x0052 }
            android.widget.RelativeLayout r2 = r2.f9896B     // Catch:{ Exception -> 0x0052 }
            J1.H1 r4 = new J1.H1     // Catch:{ Exception -> 0x0052 }
            r4.<init>(r7)     // Catch:{ Exception -> 0x0052 }
            r2.setOnClickListener(r4)     // Catch:{ Exception -> 0x0052 }
            goto L_0x01c3
        L_0x01ba:
            c2.Q r2 = r7.C3()     // Catch:{ Exception -> 0x0052 }
            android.widget.RelativeLayout r2 = r2.f9896B     // Catch:{ Exception -> 0x0052 }
            r2.setVisibility(r1)     // Catch:{ Exception -> 0x0052 }
        L_0x01c3:
            g2.h r2 = r7.f17892M     // Catch:{ Exception -> 0x0052 }
            kotlin.jvm.internal.m.b(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = r2.G()     // Catch:{ Exception -> 0x0052 }
            if (r2 == 0) goto L_0x01d4
            int r2 = r2.length()     // Catch:{ Exception -> 0x0052 }
            if (r2 != 0) goto L_0x01df
        L_0x01d4:
            g2.h r2 = r7.f17892M     // Catch:{ Exception -> 0x0052 }
            kotlin.jvm.internal.m.b(r2)     // Catch:{ Exception -> 0x0052 }
            boolean r2 = r2.H0()     // Catch:{ Exception -> 0x0052 }
            if (r2 != 0) goto L_0x020c
        L_0x01df:
            c2.Q r2 = r7.C3()     // Catch:{ Exception -> 0x0052 }
            android.widget.TextView r2 = r2.f9926b0     // Catch:{ Exception -> 0x0052 }
            android.graphics.Typeface r4 = r3.w()     // Catch:{ Exception -> 0x0052 }
            r2.setTypeface(r4)     // Catch:{ Exception -> 0x0052 }
            c2.Q r2 = r7.C3()     // Catch:{ Exception -> 0x0052 }
            android.widget.TextView r2 = r2.f9928c0     // Catch:{ Exception -> 0x0052 }
            android.graphics.Typeface r4 = r3.x()     // Catch:{ Exception -> 0x0052 }
            r2.setTypeface(r4)     // Catch:{ Exception -> 0x0052 }
            c2.Q r2 = r7.C3()     // Catch:{ Exception -> 0x0052 }
            android.widget.TextView r2 = r2.f9928c0     // Catch:{ Exception -> 0x0052 }
            g2.h r4 = r7.f17892M     // Catch:{ Exception -> 0x0052 }
            kotlin.jvm.internal.m.b(r4)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r4 = r4.G()     // Catch:{ Exception -> 0x0052 }
            r2.setText(r4)     // Catch:{ Exception -> 0x0052 }
            goto L_0x0215
        L_0x020c:
            c2.Q r2 = r7.C3()     // Catch:{ Exception -> 0x0052 }
            android.widget.RelativeLayout r2 = r2.f9900D     // Catch:{ Exception -> 0x0052 }
            r2.setVisibility(r1)     // Catch:{ Exception -> 0x0052 }
        L_0x0215:
            g2.h r2 = r7.f17892M     // Catch:{ Exception -> 0x0052 }
            kotlin.jvm.internal.m.b(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = r2.R()     // Catch:{ Exception -> 0x0052 }
            if (r2 == 0) goto L_0x0254
            int r2 = r2.length()     // Catch:{ Exception -> 0x0052 }
            if (r2 != 0) goto L_0x0227
            goto L_0x0254
        L_0x0227:
            c2.Q r2 = r7.C3()     // Catch:{ Exception -> 0x0052 }
            android.widget.TextView r2 = r2.f9954p0     // Catch:{ Exception -> 0x0052 }
            android.graphics.Typeface r4 = r3.w()     // Catch:{ Exception -> 0x0052 }
            r2.setTypeface(r4)     // Catch:{ Exception -> 0x0052 }
            c2.Q r2 = r7.C3()     // Catch:{ Exception -> 0x0052 }
            android.widget.TextView r2 = r2.f9956q0     // Catch:{ Exception -> 0x0052 }
            android.graphics.Typeface r4 = r3.x()     // Catch:{ Exception -> 0x0052 }
            r2.setTypeface(r4)     // Catch:{ Exception -> 0x0052 }
            c2.Q r2 = r7.C3()     // Catch:{ Exception -> 0x0052 }
            android.widget.TextView r2 = r2.f9956q0     // Catch:{ Exception -> 0x0052 }
            g2.h r4 = r7.f17892M     // Catch:{ Exception -> 0x0052 }
            kotlin.jvm.internal.m.b(r4)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r4 = r4.R()     // Catch:{ Exception -> 0x0052 }
            r2.setText(r4)     // Catch:{ Exception -> 0x0052 }
            goto L_0x025d
        L_0x0254:
            c2.Q r2 = r7.C3()     // Catch:{ Exception -> 0x0052 }
            android.widget.RelativeLayout r2 = r2.f9906J     // Catch:{ Exception -> 0x0052 }
            r2.setVisibility(r1)     // Catch:{ Exception -> 0x0052 }
        L_0x025d:
            g2.h r2 = r7.f17892M     // Catch:{ Exception -> 0x0052 }
            kotlin.jvm.internal.m.b(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = r2.x0()     // Catch:{ Exception -> 0x0052 }
            if (r2 == 0) goto L_0x02b5
            int r2 = r2.length()     // Catch:{ Exception -> 0x0052 }
            if (r2 != 0) goto L_0x026f
            goto L_0x02b5
        L_0x026f:
            c2.Q r2 = r7.C3()     // Catch:{ Exception -> 0x0052 }
            android.widget.TextView r2 = r2.f9962t0     // Catch:{ Exception -> 0x0052 }
            android.graphics.Typeface r4 = r3.w()     // Catch:{ Exception -> 0x0052 }
            r2.setTypeface(r4)     // Catch:{ Exception -> 0x0052 }
            c2.Q r2 = r7.C3()     // Catch:{ Exception -> 0x0052 }
            android.widget.TextView r2 = r2.f9964u0     // Catch:{ Exception -> 0x0052 }
            android.graphics.Typeface r4 = r3.x()     // Catch:{ Exception -> 0x0052 }
            r2.setTypeface(r4)     // Catch:{ Exception -> 0x0052 }
            c2.Q r2 = r7.C3()     // Catch:{ Exception -> 0x0052 }
            android.widget.TextView r2 = r2.f9964u0     // Catch:{ Exception -> 0x0052 }
            g2.h r4 = r7.f17892M     // Catch:{ Exception -> 0x0052 }
            kotlin.jvm.internal.m.b(r4)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r4 = r4.x0()     // Catch:{ Exception -> 0x0052 }
            r2.setText(r4)     // Catch:{ Exception -> 0x0052 }
            c2.Q r2 = r7.C3()     // Catch:{ Exception -> 0x0052 }
            android.widget.TextView r2 = r2.f9964u0     // Catch:{ Exception -> 0x0052 }
            java.lang.String r4 = "tvReqMoreInfo"
            kotlin.jvm.internal.m.d(r2, r4)     // Catch:{ Exception -> 0x0052 }
            c2.Q r4 = r7.C3()     // Catch:{ Exception -> 0x0052 }
            android.view.View r4 = r4.f9897B0     // Catch:{ Exception -> 0x0052 }
            java.lang.String r5 = "vReqMoreInfo"
            kotlin.jvm.internal.m.d(r4, r5)     // Catch:{ Exception -> 0x0052 }
            r7.F3(r2, r4)     // Catch:{ Exception -> 0x0052 }
            goto L_0x02be
        L_0x02b5:
            c2.Q r2 = r7.C3()     // Catch:{ Exception -> 0x0052 }
            android.widget.RelativeLayout r2 = r2.f9908L     // Catch:{ Exception -> 0x0052 }
            r2.setVisibility(r1)     // Catch:{ Exception -> 0x0052 }
        L_0x02be:
            g2.h r2 = r7.f17892M     // Catch:{ Exception -> 0x0052 }
            kotlin.jvm.internal.m.b(r2)     // Catch:{ Exception -> 0x0052 }
            boolean r2 = r2.J0()     // Catch:{ Exception -> 0x0052 }
            if (r2 != 0) goto L_0x040a
            g2.h r2 = r7.f17892M     // Catch:{ Exception -> 0x0052 }
            kotlin.jvm.internal.m.b(r2)     // Catch:{ Exception -> 0x0052 }
            boolean r2 = r2.H0()     // Catch:{ Exception -> 0x0052 }
            if (r2 != 0) goto L_0x040a
            c2.Q r2 = r7.C3()     // Catch:{ Exception -> 0x0052 }
            android.widget.TextView r2 = r2.f9934f0     // Catch:{ Exception -> 0x0052 }
            android.graphics.Typeface r4 = r3.w()     // Catch:{ Exception -> 0x0052 }
            r2.setTypeface(r4)     // Catch:{ Exception -> 0x0052 }
            c2.Q r2 = r7.C3()     // Catch:{ Exception -> 0x0052 }
            android.widget.TextView r2 = r2.f9936g0     // Catch:{ Exception -> 0x0052 }
            android.graphics.Typeface r4 = r3.x()     // Catch:{ Exception -> 0x0052 }
            r2.setTypeface(r4)     // Catch:{ Exception -> 0x0052 }
            c2.Q r2 = r7.C3()     // Catch:{ Exception -> 0x0052 }
            android.widget.TextView r2 = r2.f9936g0     // Catch:{ Exception -> 0x0052 }
            g2.h r4 = r7.f17892M     // Catch:{ Exception -> 0x0052 }
            kotlin.jvm.internal.m.b(r4)     // Catch:{ Exception -> 0x0052 }
            int r4 = r4.p()     // Catch:{ Exception -> 0x0052 }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r4 = r7.A3(r4)     // Catch:{ Exception -> 0x0052 }
            r2.setText(r4)     // Catch:{ Exception -> 0x0052 }
            g2.h r2 = r7.f17892M     // Catch:{ Exception -> 0x0052 }
            kotlin.jvm.internal.m.b(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = r2.i0()     // Catch:{ Exception -> 0x0052 }
            if (r2 == 0) goto L_0x0360
            int r2 = r2.length()     // Catch:{ Exception -> 0x0052 }
            if (r2 != 0) goto L_0x031a
            goto L_0x0360
        L_0x031a:
            c2.Q r2 = r7.C3()     // Catch:{ Exception -> 0x0052 }
            android.widget.TextView r2 = r2.f9966v0     // Catch:{ Exception -> 0x0052 }
            android.graphics.Typeface r4 = r3.w()     // Catch:{ Exception -> 0x0052 }
            r2.setTypeface(r4)     // Catch:{ Exception -> 0x0052 }
            c2.Q r2 = r7.C3()     // Catch:{ Exception -> 0x0052 }
            android.widget.TextView r2 = r2.f9968w0     // Catch:{ Exception -> 0x0052 }
            android.graphics.Typeface r4 = r3.x()     // Catch:{ Exception -> 0x0052 }
            r2.setTypeface(r4)     // Catch:{ Exception -> 0x0052 }
            c2.Q r2 = r7.C3()     // Catch:{ Exception -> 0x0052 }
            android.widget.TextView r2 = r2.f9968w0     // Catch:{ Exception -> 0x0052 }
            g2.h r4 = r7.f17892M     // Catch:{ Exception -> 0x0052 }
            kotlin.jvm.internal.m.b(r4)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r4 = r4.i0()     // Catch:{ Exception -> 0x0052 }
            r2.setText(r4)     // Catch:{ Exception -> 0x0052 }
            c2.Q r2 = r7.C3()     // Catch:{ Exception -> 0x0052 }
            android.widget.TextView r2 = r2.f9968w0     // Catch:{ Exception -> 0x0052 }
            java.lang.String r4 = "tvSha256MoreInfo"
            kotlin.jvm.internal.m.d(r2, r4)     // Catch:{ Exception -> 0x0052 }
            c2.Q r4 = r7.C3()     // Catch:{ Exception -> 0x0052 }
            android.view.View r4 = r4.f9899C0     // Catch:{ Exception -> 0x0052 }
            java.lang.String r5 = "vSha256MoreInfo"
            kotlin.jvm.internal.m.d(r4, r5)     // Catch:{ Exception -> 0x0052 }
            r7.F3(r2, r4)     // Catch:{ Exception -> 0x0052 }
            goto L_0x0369
        L_0x0360:
            c2.Q r2 = r7.C3()     // Catch:{ Exception -> 0x0052 }
            android.widget.RelativeLayout r2 = r2.f9909M     // Catch:{ Exception -> 0x0052 }
            r2.setVisibility(r1)     // Catch:{ Exception -> 0x0052 }
        L_0x0369:
            g2.h r2 = r7.f17892M     // Catch:{ Exception -> 0x0052 }
            kotlin.jvm.internal.m.b(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = r2.l0()     // Catch:{ Exception -> 0x0052 }
            if (r2 == 0) goto L_0x03b8
            int r2 = r2.length()     // Catch:{ Exception -> 0x0052 }
            if (r2 != 0) goto L_0x037b
            goto L_0x03b8
        L_0x037b:
            c2.Q r2 = r7.C3()     // Catch:{ Exception -> 0x0052 }
            android.widget.TextView r2 = r2.f9970x0     // Catch:{ Exception -> 0x0052 }
            android.graphics.Typeface r4 = r3.w()     // Catch:{ Exception -> 0x0052 }
            r2.setTypeface(r4)     // Catch:{ Exception -> 0x0052 }
            c2.Q r2 = r7.C3()     // Catch:{ Exception -> 0x0052 }
            android.widget.TextView r2 = r2.f9972y0     // Catch:{ Exception -> 0x0052 }
            android.graphics.Typeface r4 = r3.x()     // Catch:{ Exception -> 0x0052 }
            r2.setTypeface(r4)     // Catch:{ Exception -> 0x0052 }
            c2.Q r2 = r7.C3()     // Catch:{ Exception -> 0x0052 }
            android.widget.TextView r2 = r2.f9972y0     // Catch:{ Exception -> 0x0052 }
            W1.i r4 = new W1.i     // Catch:{ Exception -> 0x0052 }
            r4.<init>()     // Catch:{ Exception -> 0x0052 }
            g2.h r5 = r7.f17892M     // Catch:{ Exception -> 0x0052 }
            kotlin.jvm.internal.m.b(r5)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r5 = r5.l0()     // Catch:{ Exception -> 0x0052 }
            kotlin.jvm.internal.m.b(r5)     // Catch:{ Exception -> 0x0052 }
            long r5 = java.lang.Long.parseLong(r5)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r4 = r4.d(r5, r7)     // Catch:{ Exception -> 0x0052 }
            r2.setText(r4)     // Catch:{ Exception -> 0x0052 }
            goto L_0x03c1
        L_0x03b8:
            c2.Q r2 = r7.C3()     // Catch:{ Exception -> 0x0052 }
            android.widget.RelativeLayout r2 = r2.f9910N     // Catch:{ Exception -> 0x0052 }
            r2.setVisibility(r1)     // Catch:{ Exception -> 0x0052 }
        L_0x03c1:
            g2.h r2 = r7.f17892M     // Catch:{ Exception -> 0x0052 }
            kotlin.jvm.internal.m.b(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = r2.I()     // Catch:{ Exception -> 0x0052 }
            if (r2 == 0) goto L_0x0400
            int r2 = r2.length()     // Catch:{ Exception -> 0x0052 }
            if (r2 != 0) goto L_0x03d3
            goto L_0x0400
        L_0x03d3:
            c2.Q r2 = r7.C3()     // Catch:{ Exception -> 0x0052 }
            android.widget.TextView r2 = r2.f9942j0     // Catch:{ Exception -> 0x0052 }
            android.graphics.Typeface r4 = r3.w()     // Catch:{ Exception -> 0x0052 }
            r2.setTypeface(r4)     // Catch:{ Exception -> 0x0052 }
            c2.Q r2 = r7.C3()     // Catch:{ Exception -> 0x0052 }
            android.widget.TextView r2 = r2.f9944k0     // Catch:{ Exception -> 0x0052 }
            android.graphics.Typeface r4 = r3.x()     // Catch:{ Exception -> 0x0052 }
            r2.setTypeface(r4)     // Catch:{ Exception -> 0x0052 }
            c2.Q r2 = r7.C3()     // Catch:{ Exception -> 0x0052 }
            android.widget.TextView r2 = r2.f9944k0     // Catch:{ Exception -> 0x0052 }
            g2.h r4 = r7.f17892M     // Catch:{ Exception -> 0x0052 }
            kotlin.jvm.internal.m.b(r4)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r4 = r4.I()     // Catch:{ Exception -> 0x0052 }
            r2.setText(r4)     // Catch:{ Exception -> 0x0052 }
            goto L_0x042e
        L_0x0400:
            c2.Q r2 = r7.C3()     // Catch:{ Exception -> 0x0052 }
            android.widget.RelativeLayout r2 = r2.f9904H     // Catch:{ Exception -> 0x0052 }
            r2.setVisibility(r1)     // Catch:{ Exception -> 0x0052 }
            goto L_0x042e
        L_0x040a:
            c2.Q r2 = r7.C3()     // Catch:{ Exception -> 0x0052 }
            android.widget.RelativeLayout r2 = r2.f9902F     // Catch:{ Exception -> 0x0052 }
            r2.setVisibility(r1)     // Catch:{ Exception -> 0x0052 }
            c2.Q r2 = r7.C3()     // Catch:{ Exception -> 0x0052 }
            android.widget.RelativeLayout r2 = r2.f9909M     // Catch:{ Exception -> 0x0052 }
            r2.setVisibility(r1)     // Catch:{ Exception -> 0x0052 }
            c2.Q r2 = r7.C3()     // Catch:{ Exception -> 0x0052 }
            android.widget.RelativeLayout r2 = r2.f9910N     // Catch:{ Exception -> 0x0052 }
            r2.setVisibility(r1)     // Catch:{ Exception -> 0x0052 }
            c2.Q r2 = r7.C3()     // Catch:{ Exception -> 0x0052 }
            android.widget.RelativeLayout r2 = r2.f9904H     // Catch:{ Exception -> 0x0052 }
            r2.setVisibility(r1)     // Catch:{ Exception -> 0x0052 }
        L_0x042e:
            c2.Q r2 = r7.C3()     // Catch:{ Exception -> 0x0052 }
            android.widget.TextView r2 = r2.f9958r0     // Catch:{ Exception -> 0x0052 }
            android.graphics.Typeface r4 = r3.w()     // Catch:{ Exception -> 0x0052 }
            r2.setTypeface(r4)     // Catch:{ Exception -> 0x0052 }
            c2.Q r2 = r7.C3()     // Catch:{ Exception -> 0x0052 }
            android.widget.TextView r2 = r2.f9960s0     // Catch:{ Exception -> 0x0052 }
            android.graphics.Typeface r4 = r3.x()     // Catch:{ Exception -> 0x0052 }
            r2.setTypeface(r4)     // Catch:{ Exception -> 0x0052 }
            c2.Q r2 = r7.C3()     // Catch:{ Exception -> 0x0052 }
            android.widget.TextView r2 = r2.f9960s0     // Catch:{ Exception -> 0x0052 }
            g2.h r4 = r7.f17892M     // Catch:{ Exception -> 0x0052 }
            kotlin.jvm.internal.m.b(r4)     // Catch:{ Exception -> 0x0052 }
            int r4 = r4.S()     // Catch:{ Exception -> 0x0052 }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ Exception -> 0x0052 }
            r2.setText(r4)     // Catch:{ Exception -> 0x0052 }
            c2.Q r2 = r7.C3()     // Catch:{ Exception -> 0x0052 }
            android.widget.RelativeLayout r2 = r2.f9907K     // Catch:{ Exception -> 0x0052 }
            J1.I1 r4 = new J1.I1     // Catch:{ Exception -> 0x0052 }
            r4.<init>(r7)     // Catch:{ Exception -> 0x0052 }
            r2.setOnClickListener(r4)     // Catch:{ Exception -> 0x0052 }
            g2.h r2 = r7.f17892M     // Catch:{ Exception -> 0x0052 }
            kotlin.jvm.internal.m.b(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = r2.l()     // Catch:{ Exception -> 0x0052 }
            if (r2 == 0) goto L_0x04d0
            int r2 = r2.length()     // Catch:{ Exception -> 0x0052 }
            if (r2 != 0) goto L_0x047e
            goto L_0x04d0
        L_0x047e:
            c2.Q r2 = r7.C3()     // Catch:{ Exception -> 0x0052 }
            android.widget.RelativeLayout r2 = r2.f9901E     // Catch:{ Exception -> 0x0052 }
            r2.setVisibility(r0)     // Catch:{ Exception -> 0x0052 }
            g2.h r2 = r7.f17892M     // Catch:{ Exception -> 0x0052 }
            kotlin.jvm.internal.m.b(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r4 = "supportedDevice"
            java.lang.String r2 = r2.s0(r4)     // Catch:{ Exception -> 0x0052 }
            if (r2 == 0) goto L_0x04b1
            int r4 = r2.length()     // Catch:{ Exception -> 0x0052 }
            if (r4 != 0) goto L_0x049b
            goto L_0x04b1
        L_0x049b:
            c2.Q r4 = r7.C3()     // Catch:{ Exception -> 0x0052 }
            android.widget.TextView r4 = r4.f9930d0     // Catch:{ Exception -> 0x0052 }
            android.graphics.Typeface r5 = r3.w()     // Catch:{ Exception -> 0x0052 }
            r4.setTypeface(r5)     // Catch:{ Exception -> 0x0052 }
            c2.Q r4 = r7.C3()     // Catch:{ Exception -> 0x0052 }
            android.widget.TextView r4 = r4.f9930d0     // Catch:{ Exception -> 0x0052 }
            r4.setText(r2)     // Catch:{ Exception -> 0x0052 }
        L_0x04b1:
            c2.Q r2 = r7.C3()     // Catch:{ Exception -> 0x0052 }
            android.widget.TextView r2 = r2.f9932e0     // Catch:{ Exception -> 0x0052 }
            android.graphics.Typeface r4 = r3.x()     // Catch:{ Exception -> 0x0052 }
            r2.setTypeface(r4)     // Catch:{ Exception -> 0x0052 }
            c2.Q r2 = r7.C3()     // Catch:{ Exception -> 0x0052 }
            android.widget.TextView r2 = r2.f9932e0     // Catch:{ Exception -> 0x0052 }
            g2.h r4 = r7.f17892M     // Catch:{ Exception -> 0x0052 }
            kotlin.jvm.internal.m.b(r4)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r4 = r4.l()     // Catch:{ Exception -> 0x0052 }
            r2.setText(r4)     // Catch:{ Exception -> 0x0052 }
        L_0x04d0:
            c2.Q r2 = r7.C3()     // Catch:{ Exception -> 0x0052 }
            android.widget.TextView r2 = r2.f9916T     // Catch:{ Exception -> 0x0052 }
            android.graphics.Typeface r4 = r3.w()     // Catch:{ Exception -> 0x0052 }
            r2.setTypeface(r4)     // Catch:{ Exception -> 0x0052 }
            c2.Q r2 = r7.C3()     // Catch:{ Exception -> 0x0052 }
            android.widget.TextView r2 = r2.f9917U     // Catch:{ Exception -> 0x0052 }
            android.graphics.Typeface r3 = r3.x()     // Catch:{ Exception -> 0x0052 }
            r2.setTypeface(r3)     // Catch:{ Exception -> 0x0052 }
            g2.h r2 = r7.f17892M     // Catch:{ Exception -> 0x0052 }
            kotlin.jvm.internal.m.b(r2)     // Catch:{ Exception -> 0x0052 }
            int r2 = r2.i()     // Catch:{ Exception -> 0x0052 }
            r3 = 1
            if (r2 != r3) goto L_0x0507
            c2.Q r2 = r7.C3()     // Catch:{ Exception -> 0x0052 }
            android.widget.TextView r2 = r2.f9917U     // Catch:{ Exception -> 0x0052 }
            r3 = 2131951813(0x7f1300c5, float:1.9540051E38)
            java.lang.String r3 = r7.getString(r3)     // Catch:{ Exception -> 0x0052 }
            r2.setText(r3)     // Catch:{ Exception -> 0x0052 }
            goto L_0x0517
        L_0x0507:
            c2.Q r2 = r7.C3()     // Catch:{ Exception -> 0x0052 }
            android.widget.TextView r2 = r2.f9917U     // Catch:{ Exception -> 0x0052 }
            r3 = 2131951814(0x7f1300c6, float:1.9540053E38)
            java.lang.String r3 = r7.getString(r3)     // Catch:{ Exception -> 0x0052 }
            r2.setText(r3)     // Catch:{ Exception -> 0x0052 }
        L_0x0517:
            c2.Q r0 = r7.C3()
            android.view.View r0 = r0.f9971y
            r0.setVisibility(r1)
            return
        L_0x0521:
            r2.printStackTrace()     // Catch:{ all -> 0x004f }
            c2.Q r3 = r7.C3()     // Catch:{ all -> 0x004f }
            android.widget.TextView r3 = r3.f9946l0     // Catch:{ all -> 0x004f }
            r3.setVisibility(r0)     // Catch:{ all -> 0x004f }
            c2.Q r0 = r7.C3()     // Catch:{ all -> 0x004f }
            android.widget.TextView r0 = r0.f9946l0     // Catch:{ all -> 0x004f }
            java.lang.String r2 = r2.getMessage()     // Catch:{ all -> 0x004f }
            r0.setText(r2)     // Catch:{ all -> 0x004f }
            c2.Q r0 = r7.C3()     // Catch:{ all -> 0x004f }
            android.widget.LinearLayout r0 = r0.f9965v     // Catch:{ all -> 0x004f }
            r0.setVisibility(r1)     // Catch:{ all -> 0x004f }
            c2.Q r0 = r7.C3()
            android.view.View r0 = r0.f9971y
            r0.setVisibility(r1)
            return
        L_0x054d:
            c2.Q r2 = r7.C3()
            android.view.View r2 = r2.f9971y
            r2.setVisibility(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.MoreInfo.L3():void");
    }

    /* access modifiers changed from: private */
    public static final void M3(MoreInfo moreInfo, View view) {
        C2050h hVar = moreInfo.f17892M;
        m.b(hVar);
        C2053k h4 = hVar.h();
        m.b(h4);
        moreInfo.S3(h4);
    }

    /* access modifiers changed from: private */
    public static final void N3(MoreInfo moreInfo, View view) {
        if (!moreInfo.isFinishing()) {
            q qVar = new q();
            C2050h hVar = moreInfo.f17892M;
            m.b(hVar);
            String z02 = hVar.z0();
            m.b(z02);
            q.r(qVar, moreInfo, z02, (String) null, 4, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public static final void O3(MoreInfo moreInfo, View view) {
        if (moreInfo.C3().f9969x.getVisibility() == 0) {
            moreInfo.C3().f9969x.setVisibility(8);
            moreInfo.C3().f9951o.setImageResource(R.drawable.vector_add);
            return;
        }
        moreInfo.C3().f9969x.setVisibility(0);
        moreInfo.C3().f9951o.setImageResource(R.drawable.vector_remove);
        moreInfo.C3().f9912P.post(new J1(moreInfo));
    }

    /* access modifiers changed from: private */
    public static final void P3(MoreInfo moreInfo) {
        moreInfo.C3().f9912P.smoothScrollTo(0, moreInfo.C3().f9907K.getTop());
    }

    /* access modifiers changed from: private */
    public final void Q3(ArrayList arrayList, LinearLayout linearLayout) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        m.b(arrayList);
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            String b5 = ((C2037E) arrayList.get(i4)).b();
            if (!(b5 == null || b5.length() == 0)) {
                C1664f0 c5 = C1664f0.c(LayoutInflater.from(getApplicationContext()));
                m.d(c5, "inflate(...)");
                c5.getRoot().setLayoutParams(layoutParams);
                c5.f10408b.setTypeface(N1.k.f7778g.x());
                c5.f10408b.setText(((C2037E) arrayList.get(i4)).b());
                c5.f10408b.setOnClickListener(new F1(c5));
                m.b(linearLayout);
                linearLayout.addView(c5.getRoot());
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void R3(C1664f0 f0Var, View view) {
        if (f0Var.f10408b.getMaxLines() == 1) {
            f0Var.f10408b.setMaxLines(Integer.MAX_VALUE);
        } else {
            f0Var.f10408b.setMaxLines(1);
        }
    }

    private final void S3(C2053k kVar) {
        Q1 a5 = Q1.f19769i.a(kVar);
        getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.slide_next_in, R.anim.slide_back_out).add(16908290, (Fragment) a5, (String) null).addToBackStack(String.valueOf(kVar.b())).commit();
        this.f17891L = a5;
    }

    /* access modifiers changed from: private */
    public static final Q y3(MoreInfo moreInfo) {
        return Q.c(moreInfo.getLayoutInflater());
    }

    private final void z3(TextView textView, View view) {
        view.setVisibility(8);
        int maxLines = textView.getMaxLines();
        int i4 = this.f17896Q;
        if (maxLines == i4) {
            textView.setMaxLines(Integer.MAX_VALUE);
        } else {
            textView.setMaxLines(i4);
        }
        view.setVisibility(0);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        Bundle extras;
        Parcelable parcelable;
        super.onCreate(bundle);
        try {
            setContentView((View) C3().getRoot());
            Intent intent = getIntent();
            if (!(intent == null || (extras = intent.getExtras()) == null || !extras.containsKey("appInfo"))) {
                if (Build.VERSION.SDK_INT >= 33) {
                    parcelable = (Parcelable) extras.getParcelable("appInfo", C2050h.class);
                } else {
                    parcelable = extras.getParcelable("appInfo");
                }
                this.f17892M = (C2050h) parcelable;
            }
            Drawable drawable = ContextCompat.getDrawable(this, R.drawable.core_vector_back);
            if (drawable != null) {
                C3().f9913Q.setNavigationIcon(drawable);
                C3().f9913Q.setNavigationContentDescription((CharSequence) getString(R.string.back));
            }
            C3().f9913Q.setNavigationOnClickListener(new D1(this));
            Q C32 = C3();
            TextView textView = C32.f9946l0;
            k.a aVar = N1.k.f7778g;
            textView.setTypeface(aVar.x());
            C32.f9918V.setTypeface(aVar.w());
            C32.f9924a0.setTypeface(aVar.x());
            C32.f9948m0.setTypeface(aVar.x());
            C32.f9971y.setOnClickListener(new E1());
            if (this.f17892M != null) {
                L3();
                C2050h hVar = this.f17892M;
                m.b(hVar);
                if (!hVar.J0()) {
                    C1001s0 unused = C0981i.d(this.f17889J, (V2.g) null, (o3.L) null, new j(this, (V2.d) null), 3, (Object) null);
                    C1001s0 unused2 = C0981i.d(this.f17889J, (V2.g) null, (o3.L) null, new k(this, (V2.d) null), 3, (Object) null);
                    C1001s0 unused3 = C0981i.d(this.f17889J, (V2.g) null, (o3.L) null, new l(this, (V2.d) null), 3, (Object) null);
                    return;
                }
                C3().f9973z.setVisibility(8);
                C3().f9907K.setVisibility(8);
                C3().f9903G.setVisibility(8);
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }
}
