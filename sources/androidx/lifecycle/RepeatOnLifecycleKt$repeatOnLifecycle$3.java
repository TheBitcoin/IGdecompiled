package androidx.lifecycle;

import R2.n;
import R2.s;
import V2.d;
import W2.b;
import androidx.lifecycle.Lifecycle;
import d3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import o3.C0977g;
import o3.E0;
import o3.J;
import o3.Y;

@f(c = "androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3", f = "RepeatOnLifecycle.kt", l = {84}, m = "invokeSuspend")
final class RepeatOnLifecycleKt$repeatOnLifecycle$3 extends l implements p {
    final /* synthetic */ p $block;
    final /* synthetic */ Lifecycle.State $state;
    final /* synthetic */ Lifecycle $this_repeatOnLifecycle;
    private /* synthetic */ Object L$0;
    int label;

    @f(c = "androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1", f = "RepeatOnLifecycle.kt", l = {166}, m = "invokeSuspend")
    /* renamed from: androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1  reason: invalid class name */
    static final class AnonymousClass1 extends l implements p {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;

        public final d create(Object obj, d dVar) {
            return new AnonymousClass1(lifecycle, state, j4, pVar, dVar);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v16, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: kotlin.jvm.internal.C} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v17, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v9, resolved type: kotlin.jvm.internal.C} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r14) {
            /*
                r13 = this;
                java.lang.Object r0 = W2.b.c()
                int r1 = r13.label
                r2 = 0
                r3 = 1
                if (r1 == 0) goto L_0x0037
                if (r1 != r3) goto L_0x002f
                java.lang.Object r0 = r13.L$5
                d3.p r0 = (d3.p) r0
                java.lang.Object r0 = r13.L$4
                o3.J r0 = (o3.J) r0
                java.lang.Object r0 = r13.L$3
                androidx.lifecycle.Lifecycle r0 = (androidx.lifecycle.Lifecycle) r0
                java.lang.Object r0 = r13.L$2
                androidx.lifecycle.Lifecycle$State r0 = (androidx.lifecycle.Lifecycle.State) r0
                java.lang.Object r0 = r13.L$1
                r1 = r0
                kotlin.jvm.internal.C r1 = (kotlin.jvm.internal.C) r1
                java.lang.Object r0 = r13.L$0
                r4 = r0
                kotlin.jvm.internal.C r4 = (kotlin.jvm.internal.C) r4
                R2.n.b(r14)     // Catch:{ all -> 0x002b }
                goto L_0x00a9
            L_0x002b:
                r0 = move-exception
                r14 = r0
                goto L_0x00c0
            L_0x002f:
                java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r14.<init>(r0)
                throw r14
            L_0x0037:
                R2.n.b(r14)
                androidx.lifecycle.Lifecycle r14 = r4
                androidx.lifecycle.Lifecycle$State r14 = r14.getCurrentState()
                androidx.lifecycle.Lifecycle$State r1 = androidx.lifecycle.Lifecycle.State.DESTROYED
                if (r14 != r1) goto L_0x0047
                R2.s r14 = R2.s.f8222a
                return r14
            L_0x0047:
                kotlin.jvm.internal.C r6 = new kotlin.jvm.internal.C
                r6.<init>()
                kotlin.jvm.internal.C r1 = new kotlin.jvm.internal.C
                r1.<init>()
                androidx.lifecycle.Lifecycle$State r14 = r5     // Catch:{ all -> 0x00a1 }
                androidx.lifecycle.Lifecycle r12 = r4     // Catch:{ all -> 0x00a1 }
                o3.J r7 = r6     // Catch:{ all -> 0x00a1 }
                d3.p r11 = r7     // Catch:{ all -> 0x00a1 }
                r13.L$0 = r6     // Catch:{ all -> 0x00a1 }
                r13.L$1 = r1     // Catch:{ all -> 0x00a1 }
                r13.L$2 = r14     // Catch:{ all -> 0x00a1 }
                r13.L$3 = r12     // Catch:{ all -> 0x00a1 }
                r13.L$4 = r7     // Catch:{ all -> 0x00a1 }
                r13.L$5 = r11     // Catch:{ all -> 0x00a1 }
                r13.label = r3     // Catch:{ all -> 0x00a1 }
                o3.n r9 = new o3.n     // Catch:{ all -> 0x00a1 }
                V2.d r4 = W2.b.b(r13)     // Catch:{ all -> 0x00a1 }
                r9.<init>(r4, r3)     // Catch:{ all -> 0x00a1 }
                r9.z()     // Catch:{ all -> 0x00a1 }
                androidx.lifecycle.Lifecycle$Event$Companion r4 = androidx.lifecycle.Lifecycle.Event.Companion     // Catch:{ all -> 0x00a1 }
                androidx.lifecycle.Lifecycle$Event r5 = r4.upTo(r14)     // Catch:{ all -> 0x00a1 }
                androidx.lifecycle.Lifecycle$Event r8 = r4.downFrom(r14)     // Catch:{ all -> 0x00a1 }
                r14 = 0
                x3.a r10 = x3.c.b(r14, r3, r2)     // Catch:{ all -> 0x00a1 }
                androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1 r4 = new androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1     // Catch:{ all -> 0x00a1 }
                r4.<init>(r5, r6, r7, r8, r9, r10, r11)     // Catch:{ all -> 0x00a1 }
                r1.f20968a = r4     // Catch:{ all -> 0x00a1 }
                java.lang.String r14 = "null cannot be cast to non-null type androidx.lifecycle.LifecycleEventObserver"
                kotlin.jvm.internal.m.c(r4, r14)     // Catch:{ all -> 0x00a1 }
                androidx.lifecycle.LifecycleEventObserver r4 = (androidx.lifecycle.LifecycleEventObserver) r4     // Catch:{ all -> 0x00a1 }
                r12.addObserver(r4)     // Catch:{ all -> 0x00a1 }
                java.lang.Object r14 = r9.v()     // Catch:{ all -> 0x00a1 }
                java.lang.Object r4 = W2.b.c()     // Catch:{ all -> 0x00a1 }
                if (r14 != r4) goto L_0x00a5
                kotlin.coroutines.jvm.internal.h.c(r13)     // Catch:{ all -> 0x00a1 }
                goto L_0x00a5
            L_0x00a1:
                r0 = move-exception
                r14 = r0
                r4 = r6
                goto L_0x00c0
            L_0x00a5:
                if (r14 != r0) goto L_0x00a8
                return r0
            L_0x00a8:
                r4 = r6
            L_0x00a9:
                java.lang.Object r14 = r4.f20968a
                o3.s0 r14 = (o3.C1001s0) r14
                if (r14 == 0) goto L_0x00b2
                o3.C1001s0.a.a(r14, r2, r3, r2)
            L_0x00b2:
                java.lang.Object r14 = r1.f20968a
                androidx.lifecycle.LifecycleEventObserver r14 = (androidx.lifecycle.LifecycleEventObserver) r14
                if (r14 == 0) goto L_0x00bd
                androidx.lifecycle.Lifecycle r0 = r4
                r0.removeObserver(r14)
            L_0x00bd:
                R2.s r14 = R2.s.f8222a
                return r14
            L_0x00c0:
                java.lang.Object r0 = r4.f20968a
                o3.s0 r0 = (o3.C1001s0) r0
                if (r0 == 0) goto L_0x00c9
                o3.C1001s0.a.a(r0, r2, r3, r2)
            L_0x00c9:
                java.lang.Object r0 = r1.f20968a
                androidx.lifecycle.LifecycleEventObserver r0 = (androidx.lifecycle.LifecycleEventObserver) r0
                if (r0 == 0) goto L_0x00d4
                androidx.lifecycle.Lifecycle r1 = r4
                r1.removeObserver(r0)
            L_0x00d4:
                throw r14
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(J j4, d dVar) {
            return ((AnonymousClass1) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RepeatOnLifecycleKt$repeatOnLifecycle$3(Lifecycle lifecycle, Lifecycle.State state, p pVar, d dVar) {
        super(2, dVar);
        this.$this_repeatOnLifecycle = lifecycle;
        this.$state = state;
        this.$block = pVar;
    }

    public final d create(Object obj, d dVar) {
        RepeatOnLifecycleKt$repeatOnLifecycle$3 repeatOnLifecycleKt$repeatOnLifecycle$3 = new RepeatOnLifecycleKt$repeatOnLifecycle$3(this.$this_repeatOnLifecycle, this.$state, this.$block, dVar);
        repeatOnLifecycleKt$repeatOnLifecycle$3.L$0 = obj;
        return repeatOnLifecycleKt$repeatOnLifecycle$3;
    }

    public final Object invokeSuspend(Object obj) {
        Object c5 = b.c();
        int i4 = this.label;
        if (i4 == 0) {
            n.b(obj);
            final J j4 = (J) this.L$0;
            E0 D4 = Y.c().D();
            final Lifecycle lifecycle = this.$this_repeatOnLifecycle;
            final Lifecycle.State state = this.$state;
            final p pVar = this.$block;
            AnonymousClass1 r32 = new AnonymousClass1((d) null);
            this.label = 1;
            if (C0977g.g(D4, r32, this) == c5) {
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
        return ((RepeatOnLifecycleKt$repeatOnLifecycle$3) create(j4, dVar)).invokeSuspend(s.f8222a);
    }
}
