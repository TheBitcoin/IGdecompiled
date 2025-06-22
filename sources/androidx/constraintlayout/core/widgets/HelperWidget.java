package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.widgets.analyzer.Grouping;
import androidx.constraintlayout.core.widgets.analyzer.WidgetGroup;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class HelperWidget extends ConstraintWidget implements Helper {
    public ConstraintWidget[] mWidgets = new ConstraintWidget[4];
    public int mWidgetsCount = 0;

    public void add(ConstraintWidget constraintWidget) {
        if (constraintWidget != this && constraintWidget != null) {
            int i4 = this.mWidgetsCount + 1;
            ConstraintWidget[] constraintWidgetArr = this.mWidgets;
            if (i4 > constraintWidgetArr.length) {
                this.mWidgets = (ConstraintWidget[]) Arrays.copyOf(constraintWidgetArr, constraintWidgetArr.length * 2);
            }
            ConstraintWidget[] constraintWidgetArr2 = this.mWidgets;
            int i5 = this.mWidgetsCount;
            constraintWidgetArr2[i5] = constraintWidget;
            this.mWidgetsCount = i5 + 1;
        }
    }

    public void addDependents(ArrayList<WidgetGroup> arrayList, int i4, WidgetGroup widgetGroup) {
        for (int i5 = 0; i5 < this.mWidgetsCount; i5++) {
            widgetGroup.add(this.mWidgets[i5]);
        }
        for (int i6 = 0; i6 < this.mWidgetsCount; i6++) {
            Grouping.findDependents(this.mWidgets[i6], i4, arrayList, widgetGroup);
        }
    }

    public void copy(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        super.copy(constraintWidget, hashMap);
        HelperWidget helperWidget = (HelperWidget) constraintWidget;
        this.mWidgetsCount = 0;
        int i4 = helperWidget.mWidgetsCount;
        for (int i5 = 0; i5 < i4; i5++) {
            add(hashMap.get(helperWidget.mWidgets[i5]));
        }
    }

    public int findGroupInDependents(int i4) {
        int i5;
        int i6;
        for (int i7 = 0; i7 < this.mWidgetsCount; i7++) {
            ConstraintWidget constraintWidget = this.mWidgets[i7];
            if (i4 == 0 && (i6 = constraintWidget.horizontalGroup) != -1) {
                return i6;
            }
            if (i4 == 1 && (i5 = constraintWidget.verticalGroup) != -1) {
                return i5;
            }
        }
        return -1;
    }

    public void removeAllIds() {
        this.mWidgetsCount = 0;
        Arrays.fill(this.mWidgets, (Object) null);
    }

    public void updateConstraints(ConstraintWidgetContainer constraintWidgetContainer) {
    }
}
