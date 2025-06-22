package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import java.util.ArrayList;

class RunGroup {
    public static final int BASELINE = 2;
    public static final int END = 1;
    public static final int START = 0;
    public static int index;
    public boolean dual = false;
    int mDirection;
    WidgetRun mFirstRun = null;
    int mGroupIndex;
    WidgetRun mLastRun = null;
    ArrayList<WidgetRun> mRuns = new ArrayList<>();
    public int position = 0;

    RunGroup(WidgetRun widgetRun, int i4) {
        int i5 = index;
        this.mGroupIndex = i5;
        index = i5 + 1;
        this.mFirstRun = widgetRun;
        this.mLastRun = widgetRun;
        this.mDirection = i4;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0071, code lost:
        r2 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0022, code lost:
        r2 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean defineTerminalWidget(androidx.constraintlayout.core.widgets.analyzer.WidgetRun r8, int r9) {
        /*
            r7 = this;
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.mWidget
            boolean[] r0 = r0.isTerminalWidget
            boolean r0 = r0[r9]
            r1 = 0
            if (r0 != 0) goto L_0x000a
            return r1
        L_0x000a:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.start
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.Dependency> r0 = r0.mDependencies
            java.util.Iterator r0 = r0.iterator()
        L_0x0012:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0059
            java.lang.Object r2 = r0.next()
            androidx.constraintlayout.core.widgets.analyzer.Dependency r2 = (androidx.constraintlayout.core.widgets.analyzer.Dependency) r2
            boolean r3 = r2 instanceof androidx.constraintlayout.core.widgets.analyzer.DependencyNode
            if (r3 == 0) goto L_0x0012
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r2
            androidx.constraintlayout.core.widgets.analyzer.WidgetRun r3 = r2.mRun
            if (r3 != r8) goto L_0x0029
            goto L_0x0012
        L_0x0029:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r3 = r3.start
            if (r2 != r3) goto L_0x0012
            boolean r3 = r8 instanceof androidx.constraintlayout.core.widgets.analyzer.ChainRun
            if (r3 == 0) goto L_0x0049
            r3 = r8
            androidx.constraintlayout.core.widgets.analyzer.ChainRun r3 = (androidx.constraintlayout.core.widgets.analyzer.ChainRun) r3
            java.util.ArrayList<androidx.constraintlayout.core.widgets.analyzer.WidgetRun> r3 = r3.mWidgets
            int r4 = r3.size()
            r5 = 0
        L_0x003b:
            if (r5 >= r4) goto L_0x0053
            java.lang.Object r6 = r3.get(r5)
            int r5 = r5 + 1
            androidx.constraintlayout.core.widgets.analyzer.WidgetRun r6 = (androidx.constraintlayout.core.widgets.analyzer.WidgetRun) r6
            r7.defineTerminalWidget(r6, r9)
            goto L_0x003b
        L_0x0049:
            boolean r3 = r8 instanceof androidx.constraintlayout.core.widgets.analyzer.HelperReferences
            if (r3 != 0) goto L_0x0053
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r8.mWidget
            boolean[] r3 = r3.isTerminalWidget
            r3[r9] = r1
        L_0x0053:
            androidx.constraintlayout.core.widgets.analyzer.WidgetRun r2 = r2.mRun
            r7.defineTerminalWidget(r2, r9)
            goto L_0x0012
        L_0x0059:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.end
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.Dependency> r0 = r0.mDependencies
            java.util.Iterator r0 = r0.iterator()
        L_0x0061:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x00a8
            java.lang.Object r2 = r0.next()
            androidx.constraintlayout.core.widgets.analyzer.Dependency r2 = (androidx.constraintlayout.core.widgets.analyzer.Dependency) r2
            boolean r3 = r2 instanceof androidx.constraintlayout.core.widgets.analyzer.DependencyNode
            if (r3 == 0) goto L_0x0061
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r2
            androidx.constraintlayout.core.widgets.analyzer.WidgetRun r3 = r2.mRun
            if (r3 != r8) goto L_0x0078
            goto L_0x0061
        L_0x0078:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r3 = r3.start
            if (r2 != r3) goto L_0x0061
            boolean r3 = r8 instanceof androidx.constraintlayout.core.widgets.analyzer.ChainRun
            if (r3 == 0) goto L_0x0098
            r3 = r8
            androidx.constraintlayout.core.widgets.analyzer.ChainRun r3 = (androidx.constraintlayout.core.widgets.analyzer.ChainRun) r3
            java.util.ArrayList<androidx.constraintlayout.core.widgets.analyzer.WidgetRun> r3 = r3.mWidgets
            int r4 = r3.size()
            r5 = 0
        L_0x008a:
            if (r5 >= r4) goto L_0x00a2
            java.lang.Object r6 = r3.get(r5)
            int r5 = r5 + 1
            androidx.constraintlayout.core.widgets.analyzer.WidgetRun r6 = (androidx.constraintlayout.core.widgets.analyzer.WidgetRun) r6
            r7.defineTerminalWidget(r6, r9)
            goto L_0x008a
        L_0x0098:
            boolean r3 = r8 instanceof androidx.constraintlayout.core.widgets.analyzer.HelperReferences
            if (r3 != 0) goto L_0x00a2
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r8.mWidget
            boolean[] r3 = r3.isTerminalWidget
            r3[r9] = r1
        L_0x00a2:
            androidx.constraintlayout.core.widgets.analyzer.WidgetRun r2 = r2.mRun
            r7.defineTerminalWidget(r2, r9)
            goto L_0x0061
        L_0x00a8:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.RunGroup.defineTerminalWidget(androidx.constraintlayout.core.widgets.analyzer.WidgetRun, int):boolean");
    }

    private long traverseEnd(DependencyNode dependencyNode, long j4) {
        WidgetRun widgetRun = dependencyNode.mRun;
        if (widgetRun instanceof HelperReferences) {
            return j4;
        }
        int size = dependencyNode.mDependencies.size();
        long j5 = j4;
        for (int i4 = 0; i4 < size; i4++) {
            Dependency dependency = dependencyNode.mDependencies.get(i4);
            if (dependency instanceof DependencyNode) {
                DependencyNode dependencyNode2 = (DependencyNode) dependency;
                if (dependencyNode2.mRun != widgetRun) {
                    j5 = Math.min(j5, traverseEnd(dependencyNode2, ((long) dependencyNode2.mMargin) + j4));
                }
            }
        }
        if (dependencyNode != widgetRun.end) {
            return j5;
        }
        long wrapDimension = j4 - widgetRun.getWrapDimension();
        return Math.min(Math.min(j5, traverseEnd(widgetRun.start, wrapDimension)), wrapDimension - ((long) widgetRun.start.mMargin));
    }

    private long traverseStart(DependencyNode dependencyNode, long j4) {
        WidgetRun widgetRun = dependencyNode.mRun;
        if (widgetRun instanceof HelperReferences) {
            return j4;
        }
        int size = dependencyNode.mDependencies.size();
        long j5 = j4;
        for (int i4 = 0; i4 < size; i4++) {
            Dependency dependency = dependencyNode.mDependencies.get(i4);
            if (dependency instanceof DependencyNode) {
                DependencyNode dependencyNode2 = (DependencyNode) dependency;
                if (dependencyNode2.mRun != widgetRun) {
                    j5 = Math.max(j5, traverseStart(dependencyNode2, ((long) dependencyNode2.mMargin) + j4));
                }
            }
        }
        if (dependencyNode != widgetRun.start) {
            return j5;
        }
        long wrapDimension = j4 + widgetRun.getWrapDimension();
        return Math.max(Math.max(j5, traverseStart(widgetRun.end, wrapDimension)), wrapDimension - ((long) widgetRun.end.mMargin));
    }

    public void add(WidgetRun widgetRun) {
        this.mRuns.add(widgetRun);
        this.mLastRun = widgetRun;
    }

    public long computeWrapSize(ConstraintWidgetContainer constraintWidgetContainer, int i4) {
        WidgetRun widgetRun;
        WidgetRun widgetRun2;
        long wrapDimension;
        int i5;
        WidgetRun widgetRun3 = this.mFirstRun;
        long j4 = 0;
        if (widgetRun3 instanceof ChainRun) {
            if (((ChainRun) widgetRun3).orientation != i4) {
                return 0;
            }
        } else if (i4 == 0) {
            if (!(widgetRun3 instanceof HorizontalWidgetRun)) {
                return 0;
            }
        } else if (!(widgetRun3 instanceof VerticalWidgetRun)) {
            return 0;
        }
        if (i4 == 0) {
            widgetRun = constraintWidgetContainer.mHorizontalRun;
        } else {
            widgetRun = constraintWidgetContainer.mVerticalRun;
        }
        DependencyNode dependencyNode = widgetRun.start;
        if (i4 == 0) {
            widgetRun2 = constraintWidgetContainer.mHorizontalRun;
        } else {
            widgetRun2 = constraintWidgetContainer.mVerticalRun;
        }
        DependencyNode dependencyNode2 = widgetRun2.end;
        boolean contains = widgetRun3.start.mTargets.contains(dependencyNode);
        boolean contains2 = this.mFirstRun.end.mTargets.contains(dependencyNode2);
        long wrapDimension2 = this.mFirstRun.getWrapDimension();
        if (contains && contains2) {
            long traverseStart = traverseStart(this.mFirstRun.start, 0);
            long traverseEnd = traverseEnd(this.mFirstRun.end, 0);
            long j5 = traverseStart - wrapDimension2;
            WidgetRun widgetRun4 = this.mFirstRun;
            int i6 = widgetRun4.end.mMargin;
            if (j5 >= ((long) (-i6))) {
                j5 += (long) i6;
            }
            int i7 = widgetRun4.start.mMargin;
            long j6 = ((-traverseEnd) - wrapDimension2) - ((long) i7);
            if (j6 >= ((long) i7)) {
                j6 -= (long) i7;
            }
            float biasPercent = widgetRun4.mWidget.getBiasPercent(i4);
            if (biasPercent > 0.0f) {
                j4 = (long) ((((float) j6) / biasPercent) + (((float) j5) / (1.0f - biasPercent)));
            }
            float f4 = (float) j4;
            long j7 = ((long) ((f4 * biasPercent) + 0.5f)) + wrapDimension2 + ((long) ((f4 * (1.0f - biasPercent)) + 0.5f));
            WidgetRun widgetRun5 = this.mFirstRun;
            wrapDimension = ((long) widgetRun5.start.mMargin) + j7;
            i5 = widgetRun5.end.mMargin;
        } else if (contains) {
            DependencyNode dependencyNode3 = this.mFirstRun.start;
            return Math.max(traverseStart(dependencyNode3, (long) dependencyNode3.mMargin), ((long) this.mFirstRun.start.mMargin) + wrapDimension2);
        } else if (contains2) {
            DependencyNode dependencyNode4 = this.mFirstRun.end;
            return Math.max(-traverseEnd(dependencyNode4, (long) dependencyNode4.mMargin), ((long) (-this.mFirstRun.end.mMargin)) + wrapDimension2);
        } else {
            WidgetRun widgetRun6 = this.mFirstRun;
            wrapDimension = ((long) widgetRun6.start.mMargin) + widgetRun6.getWrapDimension();
            i5 = this.mFirstRun.end.mMargin;
        }
        return wrapDimension - ((long) i5);
    }

    public void defineTerminalWidgets(boolean z4, boolean z5) {
        if (z4) {
            WidgetRun widgetRun = this.mFirstRun;
            if (widgetRun instanceof HorizontalWidgetRun) {
                defineTerminalWidget(widgetRun, 0);
            }
        }
        if (z5) {
            WidgetRun widgetRun2 = this.mFirstRun;
            if (widgetRun2 instanceof VerticalWidgetRun) {
                defineTerminalWidget(widgetRun2, 1);
            }
        }
    }
}
