package b2;

import R2.s;
import V2.d;
import V2.g;
import android.content.Context;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import d3.p;
import g2.C2048f;
import g2.C2050h;
import g2.S;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.A;
import kotlin.jvm.internal.m;
import o3.C0977g;
import o3.C1001s0;
import o3.J;
import o3.Y;
import org.json.JSONArray;
import org.json.JSONObject;
import u2.L;
import u2.t;

public final class n {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f9443a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Context f9444b;

    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f9445a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ n f9446b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(n nVar, d dVar) {
            super(2, dVar);
            this.f9446b = nVar;
        }

        public final d create(Object obj, d dVar) {
            return new a(this.f9446b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f9445a;
            if (i4 == 0) {
                R2.n.b(obj);
                n nVar = this.f9446b;
                this.f9445a = 1;
                if (nVar.d(this) == c5) {
                    return c5;
                }
            } else if (i4 == 1) {
                R2.n.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return s.f8222a;
        }

        public final Object invoke(J j4, d dVar) {
            return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f9447a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ n f9448b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ A f9449c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(n nVar, A a5, d dVar) {
            super(2, dVar);
            this.f9448b = nVar;
            this.f9449c = a5;
        }

        public final d create(Object obj, d dVar) {
            return new b(this.f9448b, this.f9449c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            boolean z4;
            String str;
            C2048f fVar;
            long j4;
            int i4;
            String d5;
            W2.b.c();
            if (this.f9447a == 0) {
                R2.n.b(obj);
                Iterator it = this.f9448b.f9443a.iterator();
                m.d(it, "iterator(...)");
                while (true) {
                    z4 = true;
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    m.d(next, "next(...)");
                    if (((C2048f) next).y() == 0) {
                        this.f9449c.f20966a++;
                    }
                }
                if (this.f9449c.f20966a > 0) {
                    L l4 = new L(this.f9448b.f9444b);
                    g2.L n02 = l4.n0();
                    if (!n02.b() && n02.e() != null) {
                        JSONObject e5 = n02.e();
                        m.b(e5);
                        String str2 = "success";
                        if (!e5.isNull(str2)) {
                            JSONArray optJSONArray = e5.optJSONArray(DataSchemeDataSource.SCHEME_DATA);
                            if (e5.optInt(str2) == 1 && optJSONArray != null) {
                                t a5 = t.f21927u.a(this.f9448b.f9444b);
                                a5.a();
                                int length = optJSONArray.length();
                                int i5 = 0;
                                while (i5 < length) {
                                    JSONObject optJSONObject = optJSONArray.optJSONObject(i5);
                                    if (!optJSONObject.isNull("packageName")) {
                                        String optString = optJSONObject.optString("packageName");
                                        Iterator it2 = this.f9448b.f9443a.iterator();
                                        m.d(it2, "iterator(...)");
                                        while (true) {
                                            if (!it2.hasNext()) {
                                                fVar = null;
                                                break;
                                            }
                                            Object next2 = it2.next();
                                            m.d(next2, "next(...)");
                                            fVar = (C2048f) next2;
                                            if (m3.m.p(optString, fVar.o(), z4)) {
                                                break;
                                            }
                                        }
                                        if (fVar != null) {
                                            if (!optJSONObject.isNull("appID")) {
                                                j4 = optJSONObject.optLong("appID");
                                            } else {
                                                j4 = 0;
                                            }
                                            str = str2;
                                            long j5 = j4;
                                            if (!optJSONObject.isNull("hasOldVersions")) {
                                                i4 = optJSONObject.optInt("hasOldVersions");
                                            } else {
                                                i4 = 0;
                                            }
                                            if (!(fVar.y() != 0 && fVar.b() == j5 && fVar.h() == i4)) {
                                                m.b(optString);
                                                a5.B1(optString, j5, i4);
                                            }
                                            this.f9448b.f9443a.remove(fVar);
                                            String o4 = fVar.o();
                                            m.b(o4);
                                            S D02 = a5.D0(o4);
                                            if (D02 != null) {
                                                g2.L T4 = l4.T(j5);
                                                if (!(T4.b() || (d5 = T4.d()) == null || d5.length() == 0)) {
                                                    String d6 = T4.d();
                                                    m.b(d6);
                                                    JSONObject jSONObject = new JSONObject(d6);
                                                    JSONObject optJSONObject2 = jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
                                                    if (jSONObject.optInt(str) == 1 && optJSONObject2 != null) {
                                                        C2050h b5 = C2050h.b.b(C2050h.f20600F0, optJSONObject2, (Context) null, 2, (Object) null);
                                                        if (!(b5.M() == null || b5.Q() == null)) {
                                                            D02.q(b5.M());
                                                            a5.v1(D02);
                                                        }
                                                    }
                                                    i5++;
                                                    str2 = str;
                                                    z4 = true;
                                                }
                                            }
                                            i5++;
                                            str2 = str;
                                            z4 = true;
                                        }
                                    }
                                    str = str2;
                                    i5++;
                                    str2 = str;
                                    z4 = true;
                                }
                                Iterator it3 = this.f9448b.f9443a.iterator();
                                m.d(it3, "iterator(...)");
                                while (it3.hasNext()) {
                                    Object next3 = it3.next();
                                    m.d(next3, "next(...)");
                                    C2048f fVar2 = (C2048f) next3;
                                    if (fVar2.o() != null && fVar2.y() == 0) {
                                        String o5 = fVar2.o();
                                        m.b(o5);
                                        a5.B1(o5, fVar2.b(), 0);
                                    }
                                }
                                a5.i();
                            }
                        }
                    }
                }
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, d dVar) {
            return ((b) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public n(ArrayList arrayList, Context context, J j4) {
        m.e(arrayList, "apps");
        m.e(context, "context");
        m.e(j4, "scope");
        this.f9443a = arrayList;
        this.f9444b = context;
        C1001s0 unused = C0981i.d(j4, (g) null, (o3.L) null, new a(this, (d) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final Object d(d dVar) {
        Object g4 = C0977g.g(Y.b(), new b(this, new A(), (d) null), dVar);
        if (g4 == W2.b.c()) {
            return g4;
        }
        return s.f8222a;
    }
}
