package com.uptodown.activities;

import R2.n;
import R2.s;
import V2.d;
import android.content.Context;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import d3.p;
import g2.L;
import g2.V;
import g2.r;
import java.util.ArrayList;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.G;
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

public final class U extends ViewModel {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final t f18455a;

    /* renamed from: b  reason: collision with root package name */
    private final I f18456b;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final V f18457a;

        /* renamed from: b  reason: collision with root package name */
        private final ArrayList f18458b;

        public a(V v4, ArrayList arrayList) {
            m.e(v4, "thisDevice");
            m.e(arrayList, "userDevices");
            this.f18457a = v4;
            this.f18458b = arrayList;
        }

        public final V a() {
            return this.f18457a;
        }

        public final ArrayList b() {
            return this.f18458b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return m.a(this.f18457a, aVar.f18457a) && m.a(this.f18458b, aVar.f18458b);
        }

        public int hashCode() {
            return (this.f18457a.hashCode() * 31) + this.f18458b.hashCode();
        }

        public String toString() {
            return "UserDevicesData(thisDevice=" + this.f18457a + ", userDevices=" + this.f18458b + ')';
        }
    }

    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f18459a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f18460b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ U f18461c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(Context context, U u4, d dVar) {
            super(2, dVar);
            this.f18460b = context;
            this.f18461c = u4;
        }

        public final d create(Object obj, d dVar) {
            return new b(this.f18460b, this.f18461c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object obj2;
            W2.b.c();
            if (this.f18459a == 0) {
                n.b(obj);
                ArrayList arrayList = new ArrayList();
                L x02 = new u2.L(this.f18460b).x0();
                if (x02.b() || x02.e() == null) {
                    arrayList = new ArrayList();
                } else {
                    JSONObject e5 = x02.e();
                    m.b(e5);
                    JSONArray optJSONArray = e5.optJSONArray(DataSchemeDataSource.SCHEME_DATA);
                    if (e5.optInt("success") == 1 && optJSONArray != null) {
                        arrayList = V.f20481l.c(optJSONArray);
                    }
                }
                Context context = this.f18460b;
                int size = arrayList.size();
                int i4 = 0;
                while (true) {
                    if (i4 >= size) {
                        obj2 = null;
                        break;
                    }
                    obj2 = arrayList.get(i4);
                    i4++;
                    String c5 = ((V) obj2).c();
                    r rVar = new r();
                    rVar.j(context);
                    if (m.a(c5, rVar.d())) {
                        break;
                    }
                }
                V v4 = (V) obj2;
                G.a(arrayList).remove(v4);
                if (v4 != null) {
                    this.f18461c.f18455a.setValue(new E.c(new a(v4, arrayList)));
                }
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, d dVar) {
            return ((b) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public U() {
        t a5 = K.a(E.a.f21883a);
        this.f18455a = a5;
        this.f18456b = a5;
    }

    public final void b(Context context) {
        m.e(context, "context");
        C1001s0 unused = C0981i.d(ViewModelKt.getViewModelScope(this), Y.b(), (o3.L) null, new b(context, this, (d) null), 2, (Object) null);
    }

    public final I c() {
        return this.f18456b;
    }
}
