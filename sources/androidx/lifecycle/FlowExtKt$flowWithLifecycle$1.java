package androidx.lifecycle;

import R2.n;
import V2.d;
import W2.b;
import androidx.lifecycle.Lifecycle;
import d3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import o3.J;
import q3.s;
import q3.v;
import r3.C1035e;
import r3.C1036f;

@f(c = "androidx.lifecycle.FlowExtKt$flowWithLifecycle$1", f = "FlowExt.kt", l = {91}, m = "invokeSuspend")
final class FlowExtKt$flowWithLifecycle$1 extends l implements p {
    final /* synthetic */ Lifecycle $lifecycle;
    final /* synthetic */ Lifecycle.State $minActiveState;
    final /* synthetic */ C1035e $this_flowWithLifecycle;
    private /* synthetic */ Object L$0;
    int label;

    @f(c = "androidx.lifecycle.FlowExtKt$flowWithLifecycle$1$1", f = "FlowExt.kt", l = {92}, m = "invokeSuspend")
    /* renamed from: androidx.lifecycle.FlowExtKt$flowWithLifecycle$1$1  reason: invalid class name */
    static final class AnonymousClass1 extends l implements p {
        int label;

        public final d create(Object obj, d dVar) {
            return new AnonymousClass1(eVar, sVar2, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = b.c();
            int i4 = this.label;
            if (i4 == 0) {
                n.b(obj);
                C1035e eVar = eVar;
                final s sVar = sVar2;
                AnonymousClass1 r12 = new C1036f() {
                    public final Object emit(T t4, d dVar) {
                        Object t5 = sVar.t(t4, dVar);
                        if (t5 == b.c()) {
                            return t5;
                        }
                        return R2.s.f8222a;
                    }
                };
                this.label = 1;
                if (eVar.collect(r12, this) == c5) {
                    return c5;
                }
            } else if (i4 == 1) {
                n.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return R2.s.f8222a;
        }

        public final Object invoke(J j4, d dVar) {
            return ((AnonymousClass1) create(j4, dVar)).invokeSuspend(R2.s.f8222a);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FlowExtKt$flowWithLifecycle$1(Lifecycle lifecycle, Lifecycle.State state, C1035e eVar, d dVar) {
        super(2, dVar);
        this.$lifecycle = lifecycle;
        this.$minActiveState = state;
        this.$this_flowWithLifecycle = eVar;
    }

    public final d create(Object obj, d dVar) {
        FlowExtKt$flowWithLifecycle$1 flowExtKt$flowWithLifecycle$1 = new FlowExtKt$flowWithLifecycle$1(this.$lifecycle, this.$minActiveState, this.$this_flowWithLifecycle, dVar);
        flowExtKt$flowWithLifecycle$1.L$0 = obj;
        return flowExtKt$flowWithLifecycle$1;
    }

    public final Object invokeSuspend(Object obj) {
        s sVar;
        Object c5 = b.c();
        int i4 = this.label;
        if (i4 == 0) {
            n.b(obj);
            final s sVar2 = (s) this.L$0;
            Lifecycle lifecycle = this.$lifecycle;
            Lifecycle.State state = this.$minActiveState;
            final C1035e eVar = this.$this_flowWithLifecycle;
            AnonymousClass1 r5 = new AnonymousClass1((d) null);
            this.L$0 = sVar2;
            this.label = 1;
            if (RepeatOnLifecycleKt.repeatOnLifecycle(lifecycle, state, (p) r5, (d) this) == c5) {
                return c5;
            }
            sVar = sVar2;
        } else if (i4 == 1) {
            sVar = (s) this.L$0;
            n.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        v.a.a(sVar, (Throwable) null, 1, (Object) null);
        return R2.s.f8222a;
    }

    public final Object invoke(s sVar, d dVar) {
        return ((FlowExtKt$flowWithLifecycle$1) create(sVar, dVar)).invokeSuspend(R2.s.f8222a);
    }
}
