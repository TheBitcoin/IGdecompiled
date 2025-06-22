package W2;

import R2.n;
import V2.d;
import V2.g;
import d3.p;
import kotlin.coroutines.jvm.internal.h;
import kotlin.coroutines.jvm.internal.j;
import kotlin.jvm.internal.G;
import kotlin.jvm.internal.m;

abstract class c {

    public static final class a extends j {

        /* renamed from: a  reason: collision with root package name */
        private int f8752a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ p f8753b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Object f8754c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(d dVar, p pVar, Object obj) {
            super(dVar);
            this.f8753b = pVar;
            this.f8754c = obj;
            m.c(dVar, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }

        /* access modifiers changed from: protected */
        public Object invokeSuspend(Object obj) {
            int i4 = this.f8752a;
            if (i4 == 0) {
                this.f8752a = 1;
                n.b(obj);
                m.c(this.f8753b, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1>, kotlin.Any?>");
                return ((p) G.b(this.f8753b, 2)).invoke(this.f8754c, this);
            } else if (i4 == 1) {
                this.f8752a = 2;
                n.b(obj);
                return obj;
            } else {
                throw new IllegalStateException("This coroutine had already completed");
            }
        }
    }

    public static final class b extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a  reason: collision with root package name */
        private int f8755a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ p f8756b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Object f8757c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(d dVar, g gVar, p pVar, Object obj) {
            super(dVar, gVar);
            this.f8756b = pVar;
            this.f8757c = obj;
            m.c(dVar, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }

        /* access modifiers changed from: protected */
        public Object invokeSuspend(Object obj) {
            int i4 = this.f8755a;
            if (i4 == 0) {
                this.f8755a = 1;
                n.b(obj);
                m.c(this.f8756b, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1>, kotlin.Any?>");
                return ((p) G.b(this.f8756b, 2)).invoke(this.f8757c, this);
            } else if (i4 == 1) {
                this.f8755a = 2;
                n.b(obj);
                return obj;
            } else {
                throw new IllegalStateException("This coroutine had already completed");
            }
        }
    }

    public static d a(p pVar, Object obj, d dVar) {
        m.e(pVar, "<this>");
        m.e(dVar, "completion");
        d a5 = h.a(dVar);
        if (pVar instanceof kotlin.coroutines.jvm.internal.a) {
            return ((kotlin.coroutines.jvm.internal.a) pVar).create(obj, a5);
        }
        g context = a5.getContext();
        if (context == V2.h.f8445a) {
            return new a(a5, pVar, obj);
        }
        return new b(a5, context, pVar, obj);
    }

    public static d b(d dVar) {
        kotlin.coroutines.jvm.internal.d dVar2;
        d intercepted;
        m.e(dVar, "<this>");
        if (dVar instanceof kotlin.coroutines.jvm.internal.d) {
            dVar2 = (kotlin.coroutines.jvm.internal.d) dVar;
        } else {
            dVar2 = null;
        }
        if (dVar2 == null || (intercepted = dVar2.intercepted()) == null) {
            return dVar;
        }
        return intercepted;
    }
}
