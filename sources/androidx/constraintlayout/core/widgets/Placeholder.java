package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;

public class Placeholder extends VirtualLayout {
    public void addToSolver(LinearSystem linearSystem, boolean z4) {
        super.addToSolver(linearSystem, z4);
        if (this.mWidgetsCount > 0) {
            ConstraintWidget constraintWidget = this.mWidgets[0];
            constraintWidget.resetAllConstraints();
            ConstraintAnchor.Type type = ConstraintAnchor.Type.LEFT;
            constraintWidget.connect(type, (ConstraintWidget) this, type);
            ConstraintAnchor.Type type2 = ConstraintAnchor.Type.RIGHT;
            constraintWidget.connect(type2, (ConstraintWidget) this, type2);
            ConstraintAnchor.Type type3 = ConstraintAnchor.Type.TOP;
            constraintWidget.connect(type3, (ConstraintWidget) this, type3);
            ConstraintAnchor.Type type4 = ConstraintAnchor.Type.BOTTOM;
            constraintWidget.connect(type4, (ConstraintWidget) this, type4);
        }
    }

    public void measure(int i4, int i5, int i6, int i7) {
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        boolean z4 = false;
        if (this.mWidgetsCount > 0) {
            paddingLeft += this.mWidgets[0].getWidth();
            paddingTop += this.mWidgets[0].getHeight();
        }
        int max = Math.max(getMinWidth(), paddingLeft);
        int max2 = Math.max(getMinHeight(), paddingTop);
        if (i4 != 1073741824) {
            if (i4 == Integer.MIN_VALUE) {
                i5 = Math.min(max, i5);
            } else if (i4 == 0) {
                i5 = max;
            } else {
                i5 = 0;
            }
        }
        if (i6 != 1073741824) {
            if (i6 == Integer.MIN_VALUE) {
                i7 = Math.min(max2, i7);
            } else if (i6 == 0) {
                i7 = max2;
            } else {
                i7 = 0;
            }
        }
        setMeasure(i5, i7);
        setWidth(i5);
        setHeight(i7);
        if (this.mWidgetsCount > 0) {
            z4 = true;
        }
        needsCallbackFromSolver(z4);
    }
}
