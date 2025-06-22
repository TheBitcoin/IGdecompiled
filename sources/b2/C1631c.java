package b2;

import R2.n;
import R2.s;
import S2.C1601o;
import V2.d;
import V2.g;
import android.content.Context;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import d3.p;
import f2.C2018i;
import g2.C2038F;
import g2.C2048f;
import g2.r;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.A;
import kotlin.jvm.internal.C;
import kotlin.jvm.internal.m;
import o3.C0977g;
import o3.C1001s0;
import o3.E0;
import o3.J;
import o3.Y;
import org.json.JSONArray;
import org.json.JSONObject;
import u2.C2313C;
import u2.L;
import u2.t;

/* renamed from: b2.c  reason: case insensitive filesystem */
public final class C1631c {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public Context f9107a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public C2018i f9108b;

    /* renamed from: c  reason: collision with root package name */
    private final J f9109c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public ArrayList f9110d;

    /* renamed from: b2.c$a */
    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f9111a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C1631c f9112b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(C1631c cVar, d dVar) {
            super(2, dVar);
            this.f9112b = cVar;
        }

        public final d create(Object obj, d dVar) {
            return new a(this.f9112b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f9111a;
            if (i4 == 0) {
                n.b(obj);
                C1631c cVar = this.f9112b;
                this.f9111a = 1;
                if (cVar.f(this) == c5) {
                    return c5;
                }
            } else if (i4 == 1) {
                n.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return s.f8222a;
        }

        public final Object invoke(J j4, d dVar) {
            return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    /* renamed from: b2.c$b */
    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f9113a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C1631c f9114b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ A f9115c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ArrayList f9116d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ C f9117e;

        /* renamed from: b2.c$b$a */
        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f9118a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C1631c f9119b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ ArrayList f9120c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ C f9121d;

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ A f9122e;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(C1631c cVar, ArrayList arrayList, C c5, A a5, d dVar) {
                super(2, dVar);
                this.f9119b = cVar;
                this.f9120c = arrayList;
                this.f9121d = c5;
                this.f9122e = a5;
            }

            public final d create(Object obj, d dVar) {
                return new a(this.f9119b, this.f9120c, this.f9121d, this.f9122e, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f9118a == 0) {
                    n.b(obj);
                    ArrayList d5 = this.f9119b.f9110d;
                    if (d5 == null || d5.isEmpty()) {
                        C2018i c5 = this.f9119b.f9108b;
                        if (c5 == null) {
                            return null;
                        }
                        c5.b();
                        return s.f8222a;
                    }
                    if (this.f9119b.f9108b == null) {
                        if (!this.f9120c.isEmpty()) {
                            C2313C.f21882a.o(this.f9119b.f9107a, this.f9120c.size(), (String) this.f9121d.f20968a);
                        }
                    } else if (this.f9122e.f20966a == 1) {
                        C2018i c6 = this.f9119b.f9108b;
                        m.b(c6);
                        ArrayList d6 = this.f9119b.f9110d;
                        m.b(d6);
                        c6.a(d6);
                    } else {
                        C2018i c7 = this.f9119b.f9108b;
                        m.b(c7);
                        c7.b();
                    }
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, d dVar) {
                return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(C1631c cVar, A a5, ArrayList arrayList, C c5, d dVar) {
            super(2, dVar);
            this.f9114b = cVar;
            this.f9115c = a5;
            this.f9116d = arrayList;
            this.f9117e = c5;
        }

        public final d create(Object obj, d dVar) {
            return new b(this.f9114b, this.f9115c, this.f9116d, this.f9117e, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            String str;
            Object obj2;
            Object c5 = W2.b.c();
            int i4 = this.f9113a;
            if (i4 == 0) {
                n.b(obj);
                r rVar = new r();
                rVar.j(this.f9114b.f9107a);
                L l4 = new L(this.f9114b.f9107a);
                int i5 = 0;
                if (rVar.d() != null) {
                    String d5 = rVar.d();
                    m.b(d5);
                    g2.L Q4 = l4.Q(d5);
                    if (!Q4.b() && Q4.e() != null) {
                        JSONObject e5 = Q4.e();
                        m.b(e5);
                        this.f9115c.f20966a = e5.optInt("success");
                        JSONArray optJSONArray = e5.optJSONArray(DataSchemeDataSource.SCHEME_DATA);
                        if (this.f9115c.f20966a == 1 && optJSONArray != null) {
                            this.f9114b.f9110d = new ArrayList();
                            int length = optJSONArray.length();
                            for (int i6 = 0; i6 < length; i6++) {
                                JSONObject optJSONObject = optJSONArray.optJSONObject(i6);
                                C2038F f4 = new C2038F();
                                m.b(optJSONObject);
                                f4.a(optJSONObject);
                                ArrayList d6 = this.f9114b.f9110d;
                                m.b(d6);
                                d6.add(f4);
                            }
                        }
                    }
                }
                ArrayList d7 = this.f9114b.f9110d;
                if (d7 != null && !d7.isEmpty()) {
                    t a5 = t.f21927u.a(this.f9114b.f9107a);
                    a5.a();
                    ArrayList b02 = a5.b0();
                    ArrayList arrayList = new ArrayList();
                    ArrayList d8 = this.f9114b.f9110d;
                    m.b(d8);
                    int size = d8.size();
                    int i7 = 0;
                    while (true) {
                        str = null;
                        if (i7 >= size) {
                            break;
                        }
                        int size2 = b02.size();
                        int i8 = 0;
                        while (true) {
                            if (i8 >= size2) {
                                break;
                            }
                            String r4 = ((C2048f) b02.get(i8)).r();
                            if (r4 != null) {
                                ArrayList d9 = this.f9114b.f9110d;
                                m.b(d9);
                                if (m3.m.p(r4, ((C2038F) d9.get(i7)).c(), true)) {
                                    ArrayList d10 = this.f9114b.f9110d;
                                    m.b(d10);
                                    arrayList.add(d10.get(i7));
                                    Object obj3 = b02.get(i8);
                                    m.d(obj3, "get(...)");
                                    C2048f fVar = (C2048f) obj3;
                                    if (fVar.q() == 0) {
                                        fVar.Y(1);
                                        a5.r1(fVar);
                                        ArrayList d11 = this.f9114b.f9110d;
                                        m.b(d11);
                                        Iterator it = d11.iterator();
                                        m.d(it, "iterator(...)");
                                        while (true) {
                                            if (!it.hasNext()) {
                                                break;
                                            }
                                            Object next = it.next();
                                            m.d(next, "next(...)");
                                            C2038F f5 = (C2038F) next;
                                            if (m3.m.q(f5.c(), fVar.r(), false, 2, (Object) null)) {
                                                this.f9116d.add(f5);
                                                break;
                                            }
                                        }
                                    }
                                }
                            }
                            i8++;
                        }
                        i7++;
                    }
                    a5.i();
                    this.f9114b.f9110d = arrayList;
                    if (this.f9116d.size() == 1) {
                        ArrayList arrayList2 = this.f9116d;
                        int size3 = b02.size();
                        while (true) {
                            if (i5 >= size3) {
                                obj2 = null;
                                break;
                            }
                            obj2 = b02.get(i5);
                            i5++;
                            if (m.a(((C2048f) obj2).r(), ((C2038F) C1601o.H(arrayList2)).c())) {
                                break;
                            }
                        }
                        C2048f fVar2 = (C2048f) obj2;
                        C c6 = this.f9117e;
                        if (fVar2 != null) {
                            str = fVar2.m();
                        }
                        c6.f20968a = str;
                    }
                }
                com.uptodown.activities.preferences.a.f18818a.N0(this.f9114b.f9107a, System.currentTimeMillis());
                E0 c7 = Y.c();
                a aVar = new a(this.f9114b, this.f9116d, this.f9117e, this.f9115c, (d) null);
                this.f9113a = 1;
                Object g4 = C0977g.g(c7, aVar, this);
                if (g4 == c5) {
                    return c5;
                }
                return g4;
            } else if (i4 == 1) {
                n.b(obj);
                return obj;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public final Object invoke(J j4, d dVar) {
            return ((b) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public C1631c(Context context, C2018i iVar, J j4) {
        m.e(context, "context");
        m.e(j4, "scope");
        this.f9107a = context;
        this.f9108b = iVar;
        this.f9109c = j4;
        C1001s0 unused = C0981i.d(j4, (g) null, (o3.L) null, new a(this, (d) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final Object f(d dVar) {
        return C0977g.g(Y.b(), new b(this, new A(), new ArrayList(), new C(), (d) null), dVar);
    }
}
