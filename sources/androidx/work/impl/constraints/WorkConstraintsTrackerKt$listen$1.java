package androidx.work.impl.constraints;

import R2.n;
import R2.s;
import V2.d;
import W2.b;
import androidx.work.impl.model.WorkSpec;
import d3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import o3.J;
import r3.C1035e;
import r3.C1036f;

@f(c = "androidx.work.impl.constraints.WorkConstraintsTrackerKt$listen$1", f = "WorkConstraintsTracker.kt", l = {54}, m = "invokeSuspend")
final class WorkConstraintsTrackerKt$listen$1 extends l implements p {
    final /* synthetic */ OnConstraintsStateChangedListener $listener;
    final /* synthetic */ WorkSpec $spec;
    final /* synthetic */ WorkConstraintsTracker $this_listen;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WorkConstraintsTrackerKt$listen$1(WorkConstraintsTracker workConstraintsTracker, WorkSpec workSpec, OnConstraintsStateChangedListener onConstraintsStateChangedListener, d dVar) {
        super(2, dVar);
        this.$this_listen = workConstraintsTracker;
        this.$spec = workSpec;
        this.$listener = onConstraintsStateChangedListener;
    }

    public final d create(Object obj, d dVar) {
        return new WorkConstraintsTrackerKt$listen$1(this.$this_listen, this.$spec, this.$listener, dVar);
    }

    public final Object invokeSuspend(Object obj) {
        Object c5 = b.c();
        int i4 = this.label;
        if (i4 == 0) {
            n.b(obj);
            C1035e track = this.$this_listen.track(this.$spec);
            final OnConstraintsStateChangedListener onConstraintsStateChangedListener = this.$listener;
            final WorkSpec workSpec = this.$spec;
            AnonymousClass1 r12 = new C1036f() {
                public final Object emit(ConstraintsState constraintsState, d dVar) {
                    onConstraintsStateChangedListener.onConstraintsStateChanged(workSpec, constraintsState);
                    return s.f8222a;
                }
            };
            this.label = 1;
            if (track.collect(r12, this) == c5) {
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
        return ((WorkConstraintsTrackerKt$listen$1) create(j4, dVar)).invokeSuspend(s.f8222a);
    }
}
