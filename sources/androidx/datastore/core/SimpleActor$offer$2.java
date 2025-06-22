package androidx.datastore.core;

import R2.s;
import V2.d;
import d3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import o3.J;

@f(c = "androidx.datastore.core.SimpleActor$offer$2", f = "SimpleActor.kt", l = {121, 121}, m = "invokeSuspend")
final class SimpleActor$offer$2 extends l implements p {
    Object L$0;
    int label;
    final /* synthetic */ SimpleActor<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SimpleActor$offer$2(SimpleActor<T> simpleActor, d dVar) {
        super(2, dVar);
        this.this$0 = simpleActor;
    }

    public final d create(Object obj, d dVar) {
        return new SimpleActor$offer$2(this.this$0, dVar);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x004e, code lost:
        if (r6 == r0) goto L_0x005c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x005a, code lost:
        if (r1.invoke(r6, r5) == r0) goto L_0x005c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x005c, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            java.lang.Object r0 = W2.b.c()
            int r1 = r5.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0022
            if (r1 == r3) goto L_0x001a
            if (r1 != r2) goto L_0x0012
            R2.n.b(r6)
            goto L_0x005d
        L_0x0012:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x001a:
            java.lang.Object r1 = r5.L$0
            d3.p r1 = (d3.p) r1
            R2.n.b(r6)
            goto L_0x0051
        L_0x0022:
            R2.n.b(r6)
            androidx.datastore.core.SimpleActor<T> r6 = r5.this$0
            androidx.datastore.core.AtomicInt r6 = r6.remainingMessages
            int r6 = r6.get()
            if (r6 <= 0) goto L_0x006c
        L_0x0031:
            androidx.datastore.core.SimpleActor<T> r6 = r5.this$0
            o3.J r6 = r6.scope
            o3.K.e(r6)
            androidx.datastore.core.SimpleActor<T> r6 = r5.this$0
            d3.p r1 = r6.consumeMessage
            androidx.datastore.core.SimpleActor<T> r6 = r5.this$0
            q3.d r6 = r6.messageQueue
            r5.L$0 = r1
            r5.label = r3
            java.lang.Object r6 = r6.m(r5)
            if (r6 != r0) goto L_0x0051
            goto L_0x005c
        L_0x0051:
            r4 = 0
            r5.L$0 = r4
            r5.label = r2
            java.lang.Object r6 = r1.invoke(r6, r5)
            if (r6 != r0) goto L_0x005d
        L_0x005c:
            return r0
        L_0x005d:
            androidx.datastore.core.SimpleActor<T> r6 = r5.this$0
            androidx.datastore.core.AtomicInt r6 = r6.remainingMessages
            int r6 = r6.decrementAndGet()
            if (r6 != 0) goto L_0x0031
            R2.s r6 = R2.s.f8222a
            return r6
        L_0x006c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "Check failed."
            r6.<init>(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SimpleActor$offer$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    public final Object invoke(J j4, d dVar) {
        return ((SimpleActor$offer$2) create(j4, dVar)).invokeSuspend(s.f8222a);
    }
}
