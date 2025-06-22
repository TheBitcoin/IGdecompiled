package androidx.work.impl.constraints.controllers;

import androidx.work.impl.constraints.ConstraintListener;
import androidx.work.impl.constraints.ConstraintsState;
import q3.s;

public final class ConstraintController$track$1$listener$1 implements ConstraintListener<T> {
    final /* synthetic */ s $$this$callbackFlow;
    final /* synthetic */ ConstraintController<T> this$0;

    ConstraintController$track$1$listener$1(ConstraintController<T> constraintController, s sVar) {
        this.this$0 = constraintController;
        this.$$this$callbackFlow = sVar;
    }

    public void onConstraintChanged(T t4) {
        Object obj;
        if (this.this$0.isConstrained(t4)) {
            obj = new ConstraintsState.ConstraintsNotMet(this.this$0.getReason());
        } else {
            obj = ConstraintsState.ConstraintsMet.INSTANCE;
        }
        this.$$this$callbackFlow.n().B(obj);
    }
}
