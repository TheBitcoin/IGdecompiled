package androidx.core.view;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import androidx.core.view.DifferentialMotionFlingController;

public final /* synthetic */ class r implements DifferentialMotionFlingController.DifferentialVelocityProvider {
    public final float getCurrentVelocity(VelocityTracker velocityTracker, MotionEvent motionEvent, int i4) {
        return DifferentialMotionFlingController.getCurrentVelocity(velocityTracker, motionEvent, i4);
    }
}
