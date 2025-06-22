package androidx.work.impl.constraints;

import androidx.work.impl.constraints.controllers.ConstraintController;
import d3.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;

final class WorkConstraintsTracker$areAllConstraintsMet$1 extends n implements l {
    public static final WorkConstraintsTracker$areAllConstraintsMet$1 INSTANCE = new WorkConstraintsTracker$areAllConstraintsMet$1();

    WorkConstraintsTracker$areAllConstraintsMet$1() {
        super(1);
    }

    public final CharSequence invoke(ConstraintController<?> constraintController) {
        m.e(constraintController, "it");
        String simpleName = constraintController.getClass().getSimpleName();
        m.d(simpleName, "it.javaClass.simpleName");
        return simpleName;
    }
}
