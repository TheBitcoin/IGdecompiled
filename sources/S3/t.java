package s3;

import R2.s;
import V2.g;
import V2.h;
import W2.b;
import d3.p;
import d3.q;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.e;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;
import o3.C1009w0;
import r3.C1036f;

public final class t extends d implements C1036f, e {

    /* renamed from: a  reason: collision with root package name */
    public final C1036f f4402a;

    /* renamed from: b  reason: collision with root package name */
    public final g f4403b;

    /* renamed from: c  reason: collision with root package name */
    public final int f4404c;

    /* renamed from: d  reason: collision with root package name */
    private g f4405d;

    /* renamed from: e  reason: collision with root package name */
    private V2.d f4406e;

    static final class a extends n implements p {

        /* renamed from: a  reason: collision with root package name */
        public static final a f4407a = new a();

        a() {
            super(2);
        }

        public final Integer a(int i4, g.b bVar) {
            return Integer.valueOf(i4 + 1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return a(((Number) obj).intValue(), (g.b) obj2);
        }
    }

    public t(C1036f fVar, g gVar) {
        super(q.f4396a, h.f8445a);
        this.f4402a = fVar;
        this.f4403b = gVar;
        this.f4404c = ((Number) gVar.fold(0, a.f4407a)).intValue();
    }

    private final void i(g gVar, g gVar2, Object obj) {
        if (gVar2 instanceof l) {
            k((l) gVar2, obj);
        }
        v.a(this, gVar);
    }

    private final Object j(V2.d dVar, Object obj) {
        g context = dVar.getContext();
        C1009w0.f(context);
        g gVar = this.f4405d;
        if (gVar != context) {
            i(context, gVar, obj);
            this.f4405d = context;
        }
        this.f4406e = dVar;
        q a5 = u.f4408a;
        C1036f fVar = this.f4402a;
        m.c(fVar, "null cannot be cast to non-null type kotlinx.coroutines.flow.FlowCollector<kotlin.Any?>");
        m.c(this, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Unit>");
        Object invoke = a5.invoke(fVar, obj, this);
        if (!m.a(invoke, b.c())) {
            this.f4406e = null;
        }
        return invoke;
    }

    private final void k(l lVar, Object obj) {
        throw new IllegalStateException(m3.m.e("\n            Flow exception transparency is violated:\n                Previous 'emit' call has thrown exception " + lVar.f4394a + ", but then emission attempt of value '" + obj + "' has been detected.\n                Emissions from 'catch' blocks are prohibited in order to avoid unspecified behaviour, 'Flow.catch' operator can be used instead.\n                For a more detailed explanation, please refer to Flow documentation.\n            ").toString());
    }

    public Object emit(Object obj, V2.d dVar) {
        try {
            Object j4 = j(dVar, obj);
            if (j4 == b.c()) {
                kotlin.coroutines.jvm.internal.h.c(dVar);
            }
            if (j4 == b.c()) {
                return j4;
            }
            return s.f8222a;
        } catch (Throwable th) {
            this.f4405d = new l(th, dVar.getContext());
            throw th;
        }
    }

    public e getCallerFrame() {
        V2.d dVar = this.f4406e;
        if (dVar instanceof e) {
            return (e) dVar;
        }
        return null;
    }

    public g getContext() {
        g gVar = this.f4405d;
        if (gVar == null) {
            return h.f8445a;
        }
        return gVar;
    }

    public StackTraceElement getStackTraceElement() {
        return null;
    }

    public Object invokeSuspend(Object obj) {
        Throwable b5 = R2.m.b(obj);
        if (b5 != null) {
            this.f4405d = new l(b5, getContext());
        }
        V2.d dVar = this.f4406e;
        if (dVar != null) {
            dVar.resumeWith(obj);
        }
        return b.c();
    }

    public void releaseIntercepted() {
        super.releaseIntercepted();
    }
}
