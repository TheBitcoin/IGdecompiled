package androidx.work.impl.constraints;

import R2.n;
import R2.s;
import V2.d;
import W2.b;
import androidx.work.impl.constraints.ConstraintsState;
import d3.a;
import d3.q;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.m;
import r3.C1035e;
import r3.C1036f;
import s3.k;

public final class WorkConstraintsTracker$track$$inlined$combine$1 implements C1035e {
    final /* synthetic */ C1035e[] $flowArray$inlined;

    @f(c = "androidx.work.impl.constraints.WorkConstraintsTracker$track$$inlined$combine$1$3", f = "WorkConstraintsTracker.kt", l = {292}, m = "invokeSuspend")
    /* renamed from: androidx.work.impl.constraints.WorkConstraintsTracker$track$$inlined$combine$1$3  reason: invalid class name */
    public static final class AnonymousClass3 extends l implements q {
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        public final Object invokeSuspend(Object obj) {
            ConstraintsState constraintsState;
            Object c5 = b.c();
            int i4 = this.label;
            if (i4 == 0) {
                n.b(obj);
                C1036f fVar = (C1036f) this.L$0;
                ConstraintsState[] constraintsStateArr = (ConstraintsState[]) ((Object[]) this.L$1);
                int length = constraintsStateArr.length;
                int i5 = 0;
                while (true) {
                    if (i5 >= length) {
                        constraintsState = null;
                        break;
                    }
                    constraintsState = constraintsStateArr[i5];
                    if (!m.a(constraintsState, ConstraintsState.ConstraintsMet.INSTANCE)) {
                        break;
                    }
                    i5++;
                }
                if (constraintsState == null) {
                    constraintsState = ConstraintsState.ConstraintsMet.INSTANCE;
                }
                this.label = 1;
                if (fVar.emit(constraintsState, this) == c5) {
                    return c5;
                }
            } else if (i4 == 1) {
                n.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return s.f8222a;
        }

        public final Object invoke(C1036f fVar, ConstraintsState[] constraintsStateArr, d dVar) {
            AnonymousClass3 r02 = new AnonymousClass3(dVar);
            r02.L$0 = fVar;
            r02.L$1 = constraintsStateArr;
            return r02.invokeSuspend(s.f8222a);
        }
    }

    public WorkConstraintsTracker$track$$inlined$combine$1(C1035e[] eVarArr) {
        this.$flowArray$inlined = eVarArr;
    }

    public Object collect(C1036f fVar, d dVar) {
        final C1035e[] eVarArr = this.$flowArray$inlined;
        Object a5 = k.a(fVar, eVarArr, new a() {
            public final ConstraintsState[] invoke() {
                return new ConstraintsState[eVarArr.length];
            }
        }, new AnonymousClass3((d) null), dVar);
        if (a5 == b.c()) {
            return a5;
        }
        return s.f8222a;
    }
}
