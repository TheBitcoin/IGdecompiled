package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import java.util.ArrayList;

public class ChainRun extends WidgetRun {
    private int mChainStyle;
    ArrayList<WidgetRun> mWidgets = new ArrayList<>();

    public ChainRun(ConstraintWidget constraintWidget, int i4) {
        super(constraintWidget);
        this.orientation = i4;
        build();
    }

    private void build() {
        ConstraintWidget constraintWidget;
        int i4;
        ConstraintWidget constraintWidget2 = this.mWidget;
        ConstraintWidget previousChainMember = constraintWidget2.getPreviousChainMember(this.orientation);
        while (true) {
            ConstraintWidget constraintWidget3 = previousChainMember;
            constraintWidget = constraintWidget2;
            constraintWidget2 = constraintWidget3;
            if (constraintWidget2 == null) {
                break;
            }
            previousChainMember = constraintWidget2.getPreviousChainMember(this.orientation);
        }
        this.mWidget = constraintWidget;
        this.mWidgets.add(constraintWidget.getRun(this.orientation));
        ConstraintWidget nextChainMember = constraintWidget.getNextChainMember(this.orientation);
        while (nextChainMember != null) {
            this.mWidgets.add(nextChainMember.getRun(this.orientation));
            nextChainMember = nextChainMember.getNextChainMember(this.orientation);
        }
        ArrayList<WidgetRun> arrayList = this.mWidgets;
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            WidgetRun widgetRun = arrayList.get(i5);
            i5++;
            WidgetRun widgetRun2 = widgetRun;
            int i6 = this.orientation;
            if (i6 == 0) {
                widgetRun2.mWidget.horizontalChainRun = this;
            } else if (i6 == 1) {
                widgetRun2.mWidget.verticalChainRun = this;
            }
        }
        if (this.orientation == 0 && ((ConstraintWidgetContainer) this.mWidget.getParent()).isRtl() && this.mWidgets.size() > 1) {
            ArrayList<WidgetRun> arrayList2 = this.mWidgets;
            this.mWidget = arrayList2.get(arrayList2.size() - 1).mWidget;
        }
        if (this.orientation == 0) {
            i4 = this.mWidget.getHorizontalChainStyle();
        } else {
            i4 = this.mWidget.getVerticalChainStyle();
        }
        this.mChainStyle = i4;
    }

    private ConstraintWidget getFirstVisibleWidget() {
        for (int i4 = 0; i4 < this.mWidgets.size(); i4++) {
            WidgetRun widgetRun = this.mWidgets.get(i4);
            if (widgetRun.mWidget.getVisibility() != 8) {
                return widgetRun.mWidget;
            }
        }
        return null;
    }

    private ConstraintWidget getLastVisibleWidget() {
        for (int size = this.mWidgets.size() - 1; size >= 0; size--) {
            WidgetRun widgetRun = this.mWidgets.get(size);
            if (widgetRun.mWidget.getVisibility() != 8) {
                return widgetRun.mWidget;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void apply() {
        ArrayList<WidgetRun> arrayList = this.mWidgets;
        int size = arrayList.size();
        int i4 = 0;
        while (i4 < size) {
            WidgetRun widgetRun = arrayList.get(i4);
            i4++;
            widgetRun.apply();
        }
        int size2 = this.mWidgets.size();
        if (size2 >= 1) {
            ConstraintWidget constraintWidget = this.mWidgets.get(0).mWidget;
            ConstraintWidget constraintWidget2 = this.mWidgets.get(size2 - 1).mWidget;
            if (this.orientation == 0) {
                ConstraintAnchor constraintAnchor = constraintWidget.mLeft;
                ConstraintAnchor constraintAnchor2 = constraintWidget2.mRight;
                DependencyNode target = getTarget(constraintAnchor, 0);
                int margin = constraintAnchor.getMargin();
                ConstraintWidget firstVisibleWidget = getFirstVisibleWidget();
                if (firstVisibleWidget != null) {
                    margin = firstVisibleWidget.mLeft.getMargin();
                }
                if (target != null) {
                    addTarget(this.start, target, margin);
                }
                DependencyNode target2 = getTarget(constraintAnchor2, 0);
                int margin2 = constraintAnchor2.getMargin();
                ConstraintWidget lastVisibleWidget = getLastVisibleWidget();
                if (lastVisibleWidget != null) {
                    margin2 = lastVisibleWidget.mRight.getMargin();
                }
                if (target2 != null) {
                    addTarget(this.end, target2, -margin2);
                }
            } else {
                ConstraintAnchor constraintAnchor3 = constraintWidget.mTop;
                ConstraintAnchor constraintAnchor4 = constraintWidget2.mBottom;
                DependencyNode target3 = getTarget(constraintAnchor3, 1);
                int margin3 = constraintAnchor3.getMargin();
                ConstraintWidget firstVisibleWidget2 = getFirstVisibleWidget();
                if (firstVisibleWidget2 != null) {
                    margin3 = firstVisibleWidget2.mTop.getMargin();
                }
                if (target3 != null) {
                    addTarget(this.start, target3, margin3);
                }
                DependencyNode target4 = getTarget(constraintAnchor4, 1);
                int margin4 = constraintAnchor4.getMargin();
                ConstraintWidget lastVisibleWidget2 = getLastVisibleWidget();
                if (lastVisibleWidget2 != null) {
                    margin4 = lastVisibleWidget2.mBottom.getMargin();
                }
                if (target4 != null) {
                    addTarget(this.end, target4, -margin4);
                }
            }
            this.start.updateDelegate = this;
            this.end.updateDelegate = this;
        }
    }

    public void applyToWidget() {
        for (int i4 = 0; i4 < this.mWidgets.size(); i4++) {
            this.mWidgets.get(i4).applyToWidget();
        }
    }

    /* access modifiers changed from: package-private */
    public void clear() {
        this.mRunGroup = null;
        ArrayList<WidgetRun> arrayList = this.mWidgets;
        int size = arrayList.size();
        int i4 = 0;
        while (i4 < size) {
            WidgetRun widgetRun = arrayList.get(i4);
            i4++;
            widgetRun.clear();
        }
    }

    public long getWrapDimension() {
        int size = this.mWidgets.size();
        long j4 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            WidgetRun widgetRun = this.mWidgets.get(i4);
            j4 = j4 + ((long) widgetRun.start.mMargin) + widgetRun.getWrapDimension() + ((long) widgetRun.end.mMargin);
        }
        return j4;
    }

    /* access modifiers changed from: package-private */
    public void reset() {
        this.start.resolved = false;
        this.end.resolved = false;
    }

    /* access modifiers changed from: package-private */
    public boolean supportsWrapComputation() {
        int size = this.mWidgets.size();
        for (int i4 = 0; i4 < size; i4++) {
            if (!this.mWidgets.get(i4).supportsWrapComputation()) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder("ChainRun ");
        if (this.orientation == 0) {
            str = "horizontal : ";
        } else {
            str = "vertical : ";
        }
        sb.append(str);
        ArrayList<WidgetRun> arrayList = this.mWidgets;
        int size = arrayList.size();
        int i4 = 0;
        while (i4 < size) {
            WidgetRun widgetRun = arrayList.get(i4);
            i4++;
            sb.append("<");
            sb.append(widgetRun);
            sb.append("> ");
        }
        return sb.toString();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00d4, code lost:
        if (r3.resolved != false) goto L_0x00d0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void update(androidx.constraintlayout.core.widgets.analyzer.Dependency r27) {
        /*
            r26 = this;
            r0 = r26
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r0.start
            boolean r1 = r1.resolved
            if (r1 == 0) goto L_0x041f
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r0.end
            boolean r1 = r1.resolved
            if (r1 != 0) goto L_0x0010
            goto L_0x041f
        L_0x0010:
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r0.mWidget
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r1.getParent()
            boolean r2 = r1 instanceof androidx.constraintlayout.core.widgets.ConstraintWidgetContainer
            if (r2 == 0) goto L_0x0021
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r1 = (androidx.constraintlayout.core.widgets.ConstraintWidgetContainer) r1
            boolean r1 = r1.isRtl()
            goto L_0x0022
        L_0x0021:
            r1 = 0
        L_0x0022:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = r0.end
            int r2 = r2.value
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r4 = r0.start
            int r4 = r4.value
            int r2 = r2 - r4
            java.util.ArrayList<androidx.constraintlayout.core.widgets.analyzer.WidgetRun> r4 = r0.mWidgets
            int r4 = r4.size()
            r5 = 0
        L_0x0032:
            r6 = -1
            r7 = 8
            if (r5 >= r4) goto L_0x004a
            java.util.ArrayList<androidx.constraintlayout.core.widgets.analyzer.WidgetRun> r8 = r0.mWidgets
            java.lang.Object r8 = r8.get(r5)
            androidx.constraintlayout.core.widgets.analyzer.WidgetRun r8 = (androidx.constraintlayout.core.widgets.analyzer.WidgetRun) r8
            androidx.constraintlayout.core.widgets.ConstraintWidget r8 = r8.mWidget
            int r8 = r8.getVisibility()
            if (r8 != r7) goto L_0x004b
            int r5 = r5 + 1
            goto L_0x0032
        L_0x004a:
            r5 = -1
        L_0x004b:
            int r8 = r4 + -1
            r9 = r8
        L_0x004e:
            if (r9 < 0) goto L_0x0064
            java.util.ArrayList<androidx.constraintlayout.core.widgets.analyzer.WidgetRun> r10 = r0.mWidgets
            java.lang.Object r10 = r10.get(r9)
            androidx.constraintlayout.core.widgets.analyzer.WidgetRun r10 = (androidx.constraintlayout.core.widgets.analyzer.WidgetRun) r10
            androidx.constraintlayout.core.widgets.ConstraintWidget r10 = r10.mWidget
            int r10 = r10.getVisibility()
            if (r10 != r7) goto L_0x0063
            int r9 = r9 + -1
            goto L_0x004e
        L_0x0063:
            r6 = r9
        L_0x0064:
            r9 = 0
        L_0x0065:
            r11 = 2
            if (r9 >= r11) goto L_0x0112
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
        L_0x006f:
            if (r13 >= r4) goto L_0x00fe
            r27 = 0
            java.util.ArrayList<androidx.constraintlayout.core.widgets.analyzer.WidgetRun> r10 = r0.mWidgets
            java.lang.Object r10 = r10.get(r13)
            androidx.constraintlayout.core.widgets.analyzer.WidgetRun r10 = (androidx.constraintlayout.core.widgets.analyzer.WidgetRun) r10
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r10.mWidget
            int r3 = r3.getVisibility()
            if (r3 != r7) goto L_0x0087
            r20 = r1
            goto L_0x00f5
        L_0x0087:
            int r16 = r16 + 1
            if (r13 <= 0) goto L_0x0092
            if (r13 < r5) goto L_0x0092
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r3 = r10.start
            int r3 = r3.mMargin
            int r14 = r14 + r3
        L_0x0092:
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r3 = r10.mDimension
            int r11 = r3.value
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r7 = r10.mDimensionBehavior
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r12 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r7 == r12) goto L_0x009e
            r7 = 1
            goto L_0x009f
        L_0x009e:
            r7 = 0
        L_0x009f:
            if (r7 == 0) goto L_0x00c3
            int r3 = r0.orientation
            if (r3 != 0) goto L_0x00b1
            androidx.constraintlayout.core.widgets.ConstraintWidget r12 = r10.mWidget
            androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun r12 = r12.mHorizontalRun
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r12 = r12.mDimension
            boolean r12 = r12.resolved
            if (r12 != 0) goto L_0x00b1
            goto L_0x041f
        L_0x00b1:
            r12 = 1
            if (r3 != r12) goto L_0x00c0
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r10.mWidget
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r3 = r3.mVerticalRun
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r3 = r3.mDimension
            boolean r3 = r3.resolved
            if (r3 != 0) goto L_0x00c0
            goto L_0x041f
        L_0x00c0:
            r20 = r1
            goto L_0x00d7
        L_0x00c3:
            r20 = r1
            r12 = 1
            int r1 = r10.matchConstraintsType
            if (r1 != r12) goto L_0x00d2
            if (r9 != 0) goto L_0x00d2
            int r11 = r3.wrapValue
            int r15 = r15 + 1
        L_0x00d0:
            r7 = 1
            goto L_0x00d7
        L_0x00d2:
            boolean r1 = r3.resolved
            if (r1 == 0) goto L_0x00d7
            goto L_0x00d0
        L_0x00d7:
            if (r7 != 0) goto L_0x00ea
            int r15 = r15 + 1
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r10.mWidget
            float[] r1 = r1.mWeight
            int r3 = r0.orientation
            r1 = r1[r3]
            int r3 = (r1 > r27 ? 1 : (r1 == r27 ? 0 : -1))
            if (r3 < 0) goto L_0x00eb
            float r17 = r17 + r1
            goto L_0x00eb
        L_0x00ea:
            int r14 = r14 + r11
        L_0x00eb:
            if (r13 >= r8) goto L_0x00f5
            if (r13 >= r6) goto L_0x00f5
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r10.end
            int r1 = r1.mMargin
            int r1 = -r1
            int r14 = r14 + r1
        L_0x00f5:
            int r13 = r13 + 1
            r1 = r20
            r7 = 8
            r11 = 2
            goto L_0x006f
        L_0x00fe:
            r20 = r1
            r27 = 0
            if (r14 < r2) goto L_0x010f
            if (r15 != 0) goto L_0x0107
            goto L_0x010f
        L_0x0107:
            int r9 = r9 + 1
            r1 = r20
            r7 = 8
            goto L_0x0065
        L_0x010f:
            r1 = r16
            goto L_0x011b
        L_0x0112:
            r20 = r1
            r27 = 0
            r1 = 0
            r14 = 0
            r15 = 0
            r17 = 0
        L_0x011b:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r3 = r0.start
            int r3 = r3.value
            if (r20 == 0) goto L_0x0125
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r3 = r0.end
            int r3 = r3.value
        L_0x0125:
            r7 = 1056964608(0x3f000000, float:0.5)
            if (r14 <= r2) goto L_0x013c
            r9 = 1073741824(0x40000000, float:2.0)
            if (r20 == 0) goto L_0x0135
            int r10 = r14 - r2
            float r10 = (float) r10
            float r10 = r10 / r9
            float r10 = r10 + r7
            int r9 = (int) r10
            int r3 = r3 + r9
            goto L_0x013c
        L_0x0135:
            int r10 = r14 - r2
            float r10 = (float) r10
            float r10 = r10 / r9
            float r10 = r10 + r7
            int r9 = (int) r10
            int r3 = r3 - r9
        L_0x013c:
            if (r15 <= 0) goto L_0x0226
            int r9 = r2 - r14
            float r9 = (float) r9
            float r10 = (float) r15
            float r10 = r9 / r10
            float r10 = r10 + r7
            int r10 = (int) r10
            r11 = 0
            r12 = 0
        L_0x0148:
            if (r11 >= r4) goto L_0x01dd
            java.util.ArrayList<androidx.constraintlayout.core.widgets.analyzer.WidgetRun> r13 = r0.mWidgets
            java.lang.Object r13 = r13.get(r11)
            androidx.constraintlayout.core.widgets.analyzer.WidgetRun r13 = (androidx.constraintlayout.core.widgets.analyzer.WidgetRun) r13
            r16 = 1056964608(0x3f000000, float:0.5)
            androidx.constraintlayout.core.widgets.ConstraintWidget r7 = r13.mWidget
            int r7 = r7.getVisibility()
            r21 = r3
            r3 = 8
            if (r7 != r3) goto L_0x016a
        L_0x0160:
            r22 = r9
            r23 = r10
            r24 = r11
            r25 = r12
            goto L_0x01cf
        L_0x016a:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r3 = r13.mDimensionBehavior
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r7 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r3 != r7) goto L_0x0160
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r3 = r13.mDimension
            boolean r7 = r3.resolved
            if (r7 != 0) goto L_0x0160
            int r7 = (r17 > r27 ? 1 : (r17 == r27 ? 0 : -1))
            if (r7 <= 0) goto L_0x018e
            androidx.constraintlayout.core.widgets.ConstraintWidget r7 = r13.mWidget
            float[] r7 = r7.mWeight
            r22 = r7
            int r7 = r0.orientation
            r7 = r22[r7]
            float r7 = r7 * r9
            float r7 = r7 / r17
            float r7 = r7 + r16
            int r7 = (int) r7
        L_0x018b:
            r22 = r9
            goto L_0x0190
        L_0x018e:
            r7 = r10
            goto L_0x018b
        L_0x0190:
            int r9 = r0.orientation
            if (r9 != 0) goto L_0x019f
            androidx.constraintlayout.core.widgets.ConstraintWidget r9 = r13.mWidget
            r23 = r10
            int r10 = r9.mMatchConstraintMaxWidth
            int r9 = r9.mMatchConstraintMinWidth
        L_0x019c:
            r24 = r11
            goto L_0x01a8
        L_0x019f:
            r23 = r10
            androidx.constraintlayout.core.widgets.ConstraintWidget r9 = r13.mWidget
            int r10 = r9.mMatchConstraintMaxHeight
            int r9 = r9.mMatchConstraintMinHeight
            goto L_0x019c
        L_0x01a8:
            int r11 = r13.matchConstraintsType
            r25 = r12
            r12 = 1
            if (r11 != r12) goto L_0x01b6
            int r3 = r3.wrapValue
            int r3 = java.lang.Math.min(r7, r3)
            goto L_0x01b7
        L_0x01b6:
            r3 = r7
        L_0x01b7:
            int r3 = java.lang.Math.max(r9, r3)
            if (r10 <= 0) goto L_0x01c1
            int r3 = java.lang.Math.min(r10, r3)
        L_0x01c1:
            if (r3 == r7) goto L_0x01c7
            int r12 = r25 + 1
            r7 = r3
            goto L_0x01c9
        L_0x01c7:
            r12 = r25
        L_0x01c9:
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r3 = r13.mDimension
            r3.resolve(r7)
            goto L_0x01d1
        L_0x01cf:
            r12 = r25
        L_0x01d1:
            int r11 = r24 + 1
            r3 = r21
            r9 = r22
            r10 = r23
            r7 = 1056964608(0x3f000000, float:0.5)
            goto L_0x0148
        L_0x01dd:
            r21 = r3
            r25 = r12
            r16 = 1056964608(0x3f000000, float:0.5)
            if (r25 <= 0) goto L_0x0219
            int r15 = r15 - r25
            r3 = 0
            r14 = 0
        L_0x01e9:
            if (r3 >= r4) goto L_0x0219
            java.util.ArrayList<androidx.constraintlayout.core.widgets.analyzer.WidgetRun> r7 = r0.mWidgets
            java.lang.Object r7 = r7.get(r3)
            androidx.constraintlayout.core.widgets.analyzer.WidgetRun r7 = (androidx.constraintlayout.core.widgets.analyzer.WidgetRun) r7
            androidx.constraintlayout.core.widgets.ConstraintWidget r9 = r7.mWidget
            int r9 = r9.getVisibility()
            r10 = 8
            if (r9 != r10) goto L_0x01fe
            goto L_0x0216
        L_0x01fe:
            if (r3 <= 0) goto L_0x0207
            if (r3 < r5) goto L_0x0207
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r9 = r7.start
            int r9 = r9.mMargin
            int r14 = r14 + r9
        L_0x0207:
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r9 = r7.mDimension
            int r9 = r9.value
            int r14 = r14 + r9
            if (r3 >= r8) goto L_0x0216
            if (r3 >= r6) goto L_0x0216
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r7 = r7.end
            int r7 = r7.mMargin
            int r7 = -r7
            int r14 = r14 + r7
        L_0x0216:
            int r3 = r3 + 1
            goto L_0x01e9
        L_0x0219:
            int r3 = r0.mChainStyle
            r7 = 2
            if (r3 != r7) goto L_0x0224
            if (r25 != 0) goto L_0x0224
            r3 = 0
            r0.mChainStyle = r3
            goto L_0x022c
        L_0x0224:
            r3 = 0
            goto L_0x022c
        L_0x0226:
            r21 = r3
            r3 = 0
            r7 = 2
            r16 = 1056964608(0x3f000000, float:0.5)
        L_0x022c:
            if (r14 <= r2) goto L_0x0230
            r0.mChainStyle = r7
        L_0x0230:
            if (r1 <= 0) goto L_0x0238
            if (r15 != 0) goto L_0x0238
            if (r5 != r6) goto L_0x0238
            r0.mChainStyle = r7
        L_0x0238:
            int r7 = r0.mChainStyle
            r12 = 1
            if (r7 != r12) goto L_0x02db
            if (r1 <= r12) goto L_0x0243
            int r2 = r2 - r14
            int r1 = r1 - r12
            int r2 = r2 / r1
            goto L_0x024c
        L_0x0243:
            if (r1 != r12) goto L_0x024b
            int r2 = r2 - r14
            r18 = 2
            int r2 = r2 / 2
            goto L_0x024c
        L_0x024b:
            r2 = 0
        L_0x024c:
            if (r15 <= 0) goto L_0x024f
            r2 = 0
        L_0x024f:
            r1 = r21
        L_0x0251:
            if (r3 >= r4) goto L_0x041f
            if (r20 == 0) goto L_0x025a
            int r7 = r3 + 1
            int r7 = r4 - r7
            goto L_0x025b
        L_0x025a:
            r7 = r3
        L_0x025b:
            java.util.ArrayList<androidx.constraintlayout.core.widgets.analyzer.WidgetRun> r9 = r0.mWidgets
            java.lang.Object r7 = r9.get(r7)
            androidx.constraintlayout.core.widgets.analyzer.WidgetRun r7 = (androidx.constraintlayout.core.widgets.analyzer.WidgetRun) r7
            androidx.constraintlayout.core.widgets.ConstraintWidget r9 = r7.mWidget
            int r9 = r9.getVisibility()
            r10 = 8
            if (r9 != r10) goto L_0x0278
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r9 = r7.start
            r9.resolve(r1)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r7 = r7.end
            r7.resolve(r1)
            goto L_0x02d7
        L_0x0278:
            if (r3 <= 0) goto L_0x027f
            if (r20 == 0) goto L_0x027e
            int r1 = r1 - r2
            goto L_0x027f
        L_0x027e:
            int r1 = r1 + r2
        L_0x027f:
            if (r3 <= 0) goto L_0x0290
            if (r3 < r5) goto L_0x0290
            if (r20 == 0) goto L_0x028b
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r9 = r7.start
            int r9 = r9.mMargin
            int r1 = r1 - r9
            goto L_0x0290
        L_0x028b:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r9 = r7.start
            int r9 = r9.mMargin
            int r1 = r1 + r9
        L_0x0290:
            if (r20 == 0) goto L_0x0298
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r9 = r7.end
            r9.resolve(r1)
            goto L_0x029d
        L_0x0298:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r9 = r7.start
            r9.resolve(r1)
        L_0x029d:
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r9 = r7.mDimension
            int r10 = r9.value
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r11 = r7.mDimensionBehavior
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r12 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r11 != r12) goto L_0x02ae
            int r11 = r7.matchConstraintsType
            r12 = 1
            if (r11 != r12) goto L_0x02ae
            int r10 = r9.wrapValue
        L_0x02ae:
            if (r20 == 0) goto L_0x02b2
            int r1 = r1 - r10
            goto L_0x02b3
        L_0x02b2:
            int r1 = r1 + r10
        L_0x02b3:
            if (r20 == 0) goto L_0x02bc
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r9 = r7.start
            r9.resolve(r1)
        L_0x02ba:
            r12 = 1
            goto L_0x02c2
        L_0x02bc:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r9 = r7.end
            r9.resolve(r1)
            goto L_0x02ba
        L_0x02c2:
            r7.mResolved = r12
            if (r3 >= r8) goto L_0x02d7
            if (r3 >= r6) goto L_0x02d7
            if (r20 == 0) goto L_0x02d1
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r7 = r7.end
            int r7 = r7.mMargin
            int r7 = -r7
            int r1 = r1 - r7
            goto L_0x02d7
        L_0x02d1:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r7 = r7.end
            int r7 = r7.mMargin
            int r7 = -r7
            int r1 = r1 + r7
        L_0x02d7:
            int r3 = r3 + 1
            goto L_0x0251
        L_0x02db:
            if (r7 != 0) goto L_0x0370
            int r2 = r2 - r14
            r19 = 1
            int r1 = r1 + 1
            int r2 = r2 / r1
            if (r15 <= 0) goto L_0x02e6
            r2 = 0
        L_0x02e6:
            r1 = r21
        L_0x02e8:
            if (r3 >= r4) goto L_0x041f
            if (r20 == 0) goto L_0x02f1
            int r7 = r3 + 1
            int r7 = r4 - r7
            goto L_0x02f2
        L_0x02f1:
            r7 = r3
        L_0x02f2:
            java.util.ArrayList<androidx.constraintlayout.core.widgets.analyzer.WidgetRun> r9 = r0.mWidgets
            java.lang.Object r7 = r9.get(r7)
            androidx.constraintlayout.core.widgets.analyzer.WidgetRun r7 = (androidx.constraintlayout.core.widgets.analyzer.WidgetRun) r7
            androidx.constraintlayout.core.widgets.ConstraintWidget r9 = r7.mWidget
            int r9 = r9.getVisibility()
            r10 = 8
            if (r9 != r10) goto L_0x030f
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r9 = r7.start
            r9.resolve(r1)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r7 = r7.end
            r7.resolve(r1)
            goto L_0x036c
        L_0x030f:
            if (r20 == 0) goto L_0x0313
            int r1 = r1 - r2
            goto L_0x0314
        L_0x0313:
            int r1 = r1 + r2
        L_0x0314:
            if (r3 <= 0) goto L_0x0325
            if (r3 < r5) goto L_0x0325
            if (r20 == 0) goto L_0x0320
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r9 = r7.start
            int r9 = r9.mMargin
            int r1 = r1 - r9
            goto L_0x0325
        L_0x0320:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r9 = r7.start
            int r9 = r9.mMargin
            int r1 = r1 + r9
        L_0x0325:
            if (r20 == 0) goto L_0x032d
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r9 = r7.end
            r9.resolve(r1)
            goto L_0x0332
        L_0x032d:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r9 = r7.start
            r9.resolve(r1)
        L_0x0332:
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r9 = r7.mDimension
            int r10 = r9.value
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r11 = r7.mDimensionBehavior
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r12 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r11 != r12) goto L_0x0347
            int r11 = r7.matchConstraintsType
            r12 = 1
            if (r11 != r12) goto L_0x0347
            int r9 = r9.wrapValue
            int r10 = java.lang.Math.min(r10, r9)
        L_0x0347:
            if (r20 == 0) goto L_0x034b
            int r1 = r1 - r10
            goto L_0x034c
        L_0x034b:
            int r1 = r1 + r10
        L_0x034c:
            if (r20 == 0) goto L_0x0354
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r9 = r7.start
            r9.resolve(r1)
            goto L_0x0359
        L_0x0354:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r9 = r7.end
            r9.resolve(r1)
        L_0x0359:
            if (r3 >= r8) goto L_0x036c
            if (r3 >= r6) goto L_0x036c
            if (r20 == 0) goto L_0x0366
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r7 = r7.end
            int r7 = r7.mMargin
            int r7 = -r7
            int r1 = r1 - r7
            goto L_0x036c
        L_0x0366:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r7 = r7.end
            int r7 = r7.mMargin
            int r7 = -r7
            int r1 = r1 + r7
        L_0x036c:
            int r3 = r3 + 1
            goto L_0x02e8
        L_0x0370:
            r1 = 2
            if (r7 != r1) goto L_0x041f
            int r1 = r0.orientation
            if (r1 != 0) goto L_0x037e
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r0.mWidget
            float r1 = r1.getHorizontalBiasPercent()
            goto L_0x0384
        L_0x037e:
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r0.mWidget
            float r1 = r1.getVerticalBiasPercent()
        L_0x0384:
            if (r20 == 0) goto L_0x038a
            r7 = 1065353216(0x3f800000, float:1.0)
            float r1 = r7 - r1
        L_0x038a:
            int r2 = r2 - r14
            float r2 = (float) r2
            float r2 = r2 * r1
            float r2 = r2 + r16
            int r1 = (int) r2
            if (r1 < 0) goto L_0x0395
            if (r15 <= 0) goto L_0x0396
        L_0x0395:
            r1 = 0
        L_0x0396:
            if (r20 == 0) goto L_0x039b
            int r1 = r21 - r1
            goto L_0x039d
        L_0x039b:
            int r1 = r21 + r1
        L_0x039d:
            if (r3 >= r4) goto L_0x041f
            if (r20 == 0) goto L_0x03a6
            int r2 = r3 + 1
            int r2 = r4 - r2
            goto L_0x03a7
        L_0x03a6:
            r2 = r3
        L_0x03a7:
            java.util.ArrayList<androidx.constraintlayout.core.widgets.analyzer.WidgetRun> r7 = r0.mWidgets
            java.lang.Object r2 = r7.get(r2)
            androidx.constraintlayout.core.widgets.analyzer.WidgetRun r2 = (androidx.constraintlayout.core.widgets.analyzer.WidgetRun) r2
            androidx.constraintlayout.core.widgets.ConstraintWidget r7 = r2.mWidget
            int r7 = r7.getVisibility()
            r10 = 8
            if (r7 != r10) goto L_0x03c5
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r7 = r2.start
            r7.resolve(r1)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = r2.end
            r2.resolve(r1)
            r12 = 1
            goto L_0x041b
        L_0x03c5:
            if (r3 <= 0) goto L_0x03d6
            if (r3 < r5) goto L_0x03d6
            if (r20 == 0) goto L_0x03d1
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r7 = r2.start
            int r7 = r7.mMargin
            int r1 = r1 - r7
            goto L_0x03d6
        L_0x03d1:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r7 = r2.start
            int r7 = r7.mMargin
            int r1 = r1 + r7
        L_0x03d6:
            if (r20 == 0) goto L_0x03de
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r7 = r2.end
            r7.resolve(r1)
            goto L_0x03e3
        L_0x03de:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r7 = r2.start
            r7.resolve(r1)
        L_0x03e3:
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r7 = r2.mDimension
            int r9 = r7.value
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r11 = r2.mDimensionBehavior
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r12 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r11 != r12) goto L_0x03f5
            int r11 = r2.matchConstraintsType
            r12 = 1
            if (r11 != r12) goto L_0x03f6
            int r9 = r7.wrapValue
            goto L_0x03f6
        L_0x03f5:
            r12 = 1
        L_0x03f6:
            if (r20 == 0) goto L_0x03fa
            int r1 = r1 - r9
            goto L_0x03fb
        L_0x03fa:
            int r1 = r1 + r9
        L_0x03fb:
            if (r20 == 0) goto L_0x0403
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r7 = r2.start
            r7.resolve(r1)
            goto L_0x0408
        L_0x0403:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r7 = r2.end
            r7.resolve(r1)
        L_0x0408:
            if (r3 >= r8) goto L_0x041b
            if (r3 >= r6) goto L_0x041b
            if (r20 == 0) goto L_0x0415
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = r2.end
            int r2 = r2.mMargin
            int r2 = -r2
            int r1 = r1 - r2
            goto L_0x041b
        L_0x0415:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = r2.end
            int r2 = r2.mMargin
            int r2 = -r2
            int r1 = r1 + r2
        L_0x041b:
            int r3 = r3 + 1
            goto L_0x039d
        L_0x041f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.ChainRun.update(androidx.constraintlayout.core.widgets.analyzer.Dependency):void");
    }
}
