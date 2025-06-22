package androidx.lifecycle;

import R2.m;
import R2.s;
import V2.d;
import V2.g;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.Lifecycle;
import d3.p;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C;
import kotlin.jvm.internal.m;
import o3.C0989m;
import o3.C1001s0;
import o3.J;
import o3.L;
import x3.a;

final class RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1 implements LifecycleEventObserver {
    final /* synthetic */ J $$this$coroutineScope;
    final /* synthetic */ p $block;
    final /* synthetic */ Lifecycle.Event $cancelWorkEvent;
    final /* synthetic */ C0989m $cont;
    final /* synthetic */ C $launchedJob;
    final /* synthetic */ a $mutex;
    final /* synthetic */ Lifecycle.Event $startWorkEvent;

    @f(c = "androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1", f = "RepeatOnLifecycle.kt", l = {171, 110}, m = "invokeSuspend")
    /* renamed from: androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1  reason: invalid class name */
    static final class AnonymousClass1 extends l implements p {
        Object L$0;
        Object L$1;
        int label;

        public final d create(Object obj, d dVar) {
            return new AnonymousClass1(aVar, pVar, dVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x003f, code lost:
            if (r7.c((java.lang.Object) null, r6) == r0) goto L_0x0053;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = W2.b.c()
                int r1 = r6.label
                r2 = 2
                r3 = 1
                r4 = 0
                if (r1 == 0) goto L_0x002e
                if (r1 == r3) goto L_0x0021
                if (r1 != r2) goto L_0x0019
                java.lang.Object r0 = r6.L$0
                x3.a r0 = (x3.a) r0
                R2.n.b(r7)     // Catch:{ all -> 0x0017 }
                goto L_0x0055
            L_0x0017:
                r7 = move-exception
                goto L_0x0061
            L_0x0019:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L_0x0021:
                java.lang.Object r1 = r6.L$1
                d3.p r1 = (d3.p) r1
                java.lang.Object r3 = r6.L$0
                x3.a r3 = (x3.a) r3
                R2.n.b(r7)
                r7 = r3
                goto L_0x0042
            L_0x002e:
                R2.n.b(r7)
                x3.a r7 = r9
                d3.p r1 = r2
                r6.L$0 = r7
                r6.L$1 = r1
                r6.label = r3
                java.lang.Object r3 = r7.c(r4, r6)
                if (r3 != r0) goto L_0x0042
                goto L_0x0053
            L_0x0042:
                androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1 r3 = new androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1     // Catch:{ all -> 0x005d }
                r3.<init>(r1, r4)     // Catch:{ all -> 0x005d }
                r6.L$0 = r7     // Catch:{ all -> 0x005d }
                r6.L$1 = r4     // Catch:{ all -> 0x005d }
                r6.label = r2     // Catch:{ all -> 0x005d }
                java.lang.Object r1 = o3.K.d(r3, r6)     // Catch:{ all -> 0x005d }
                if (r1 != r0) goto L_0x0054
            L_0x0053:
                return r0
            L_0x0054:
                r0 = r7
            L_0x0055:
                R2.s r7 = R2.s.f8222a     // Catch:{ all -> 0x0017 }
                r0.d(r4)
                R2.s r7 = R2.s.f8222a
                return r7
            L_0x005d:
                r0 = move-exception
                r5 = r0
                r0 = r7
                r7 = r5
            L_0x0061:
                r0.d(r4)
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(J j4, d dVar) {
            return ((AnonymousClass1) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1(Lifecycle.Event event, C c5, J j4, Lifecycle.Event event2, C0989m mVar, a aVar, p pVar) {
        this.$startWorkEvent = event;
        this.$launchedJob = c5;
        this.$$this$coroutineScope = j4;
        this.$cancelWorkEvent = event2;
        this.$cont = mVar;
        this.$mutex = aVar;
        this.$block = pVar;
    }

    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        m.e(lifecycleOwner, "<anonymous parameter 0>");
        m.e(event, NotificationCompat.CATEGORY_EVENT);
        if (event == this.$startWorkEvent) {
            C c5 = this.$launchedJob;
            J j4 = this.$$this$coroutineScope;
            final a aVar = this.$mutex;
            final p pVar = this.$block;
            c5.f20968a = C0981i.d(j4, (g) null, (L) null, new AnonymousClass1((d) null), 3, (Object) null);
            return;
        }
        if (event == this.$cancelWorkEvent) {
            C1001s0 s0Var = (C1001s0) this.$launchedJob.f20968a;
            if (s0Var != null) {
                C1001s0.a.a(s0Var, (CancellationException) null, 1, (Object) null);
            }
            this.$launchedJob.f20968a = null;
        }
        if (event == Lifecycle.Event.ON_DESTROY) {
            C0989m mVar = this.$cont;
            m.a aVar2 = R2.m.f8216a;
            mVar.resumeWith(R2.m.a(s.f8222a));
        }
    }
}
